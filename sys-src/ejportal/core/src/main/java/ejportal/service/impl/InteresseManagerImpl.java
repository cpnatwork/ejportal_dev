package ejportal.service.impl;

import ejportal.dao.BestellerDao;
import ejportal.dao.InteresseDao;
import ejportal.dao.JournalDao;
import ejportal.model.Interesse;
import ejportal.service.InteresseManager;
import ejportal.service.dto.InteresseBaseTO;
import ejportal.util.BeanUtil;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 09.08.2010
 * Time: 16:15:50
 * To change this template use File | Settings | File Templates.
 */
public class InteresseManagerImpl extends GenericManagerImpl<Interesse, Long> implements InteresseManager {
    private InteresseDao interesseDao;
    private BestellerDao bestellerDao;
    private JournalDao journalDao;
    private BeanUtil beanUtil;

    public InteresseManagerImpl(InteresseDao interesseDao, BestellerDao bestellerDao, JournalDao journalDao) {
        super(interesseDao);
        this.interesseDao = interesseDao;
        this.bestellerDao = bestellerDao;
        this.journalDao = journalDao;
        this.beanUtil = new BeanUtil();
    }

    public List<Interesse> getListForJournal(Long journalId) {
        return interesseDao.findByJournalId(journalId);
    }

    public void connectInteresseJournal(Long interesseId, Long journalId) {
        Interesse interesse = interesseDao.get(interesseId);
        interesse.setJournal(journalDao.get(journalId));
    }

    public void connectInteresseBesteller(Long interesseId, Long bestellerId) {
        Interesse interesse = interesseDao.get(interesseId);
        interesse.setBesteller(bestellerDao.get(bestellerId));
    }

    public InteresseBaseTO getInteresseBaseTO(Long interesseId) {
        Interesse interesse = interesseDao.get(interesseId);
        InteresseBaseTO interesseBaseTO = new InteresseBaseTO();

        try {
            //here comes the reflection voodoo ;-)
            beanUtil.copyEntityToBaseTO(interesse,interesseBaseTO);
            //jetzt sind im interesseBaseTO alle Attribute von interesse OHNE die Beziehungen!
        } catch (Exception e) {
            //TODO Fehlerbehandlung
            e.printStackTrace();
        }
        return   interesseBaseTO;    }

    public Interesse saveBaseTO(InteresseBaseTO interesseBaseTO) {
        //erst mal das Interesse holen
        Interesse interesse = interesseDao.get(interesseBaseTO.getInteresseId());
        try {
            //mit reflection voodoo die Daten vom interesseBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(interesseBaseTO, interesse);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();
        }

        interesse = save(interesse);
        return interesse;    }

    public Interesse create(InteresseBaseTO interesseBaseTO, Long journalId) {
        //Neues Interesse erstellen
        Interesse interesse = new Interesse();

        //Attribute aus dem BaseTO füllen
        try {
            //mit reflection voodoo die Daten vom interesseBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(interesseBaseTO, interesse);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();
        }

        //Das Journal dem Interesse zuordnen
        interesse.setJournal(journalDao.get(journalId));

        //Speichern und gut is!
        interesse = save(interesse);
        return interesse;
    }
}
