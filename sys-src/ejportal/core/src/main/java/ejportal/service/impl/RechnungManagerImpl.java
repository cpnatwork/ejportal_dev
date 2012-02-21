package ejportal.service.impl;

import ejportal.dao.ExemplarDao;
import ejportal.dao.JournalDao;
import ejportal.dao.RechnungDao;
import ejportal.dao.SigelDao;
import ejportal.model.Exemplar;
import ejportal.model.Rechnung;
import ejportal.service.RechnungManager;
import ejportal.service.dto.RechnungBaseTO;
import ejportal.util.BeanUtil;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 09.08.2010
 * Time: 15:09:08
 * To change this template use File | Settings | File Templates.
 */
public class RechnungManagerImpl extends GenericManagerImpl<Rechnung, Long> implements RechnungManager {
    private RechnungDao rechnungDao;
    private ExemplarDao exemplarDao;
    private JournalDao journalDao;
    private BeanUtil beanUtil;

    public RechnungManagerImpl(RechnungDao rechnungDao, ExemplarDao exemplarDao, JournalDao journalDao) {
        super(rechnungDao);
        this.rechnungDao = rechnungDao;
        this.exemplarDao = exemplarDao;
        this.journalDao = journalDao;
        this.beanUtil = new BeanUtil();
    }

    public List<Rechnung> getListForExemplar(long exemplarId) {
        return rechnungDao.findByExemplarId(exemplarId);
    }

    public List<Rechnung> getListForJournal(long journalId) {
        //alle zu einem Journal gehörigen Exemplare abrufen
        List<Exemplar> exemplare = exemplarDao.getListForJournal(journalId);
        List<Rechnung> rechnungen = new ArrayList();

        //Für jedes Exemplar die Rechnungen holen
        for(Exemplar exemplar: exemplare){
            //Rechnungen eines Exemplars
            List<Rechnung> rechnungenForExemplar = rechnungDao.findByExemplarId(exemplar.getExemplarId());
            //falls es Rechnungen gibt, diese an die Ergebnismenge anhängen
            if(!rechnungenForExemplar.isEmpty()){
                for(Rechnung rechnung: rechnungenForExemplar){
                    rechnungen.add(rechnung);
                }
            }
        }

        return rechnungen;
    }

    public void connectRechnungExemplar(long rechnungId, long exemplarId) {
        Rechnung rechnung = rechnungDao.get(rechnungId);
        rechnung.setExemplar(exemplarDao.get(exemplarId));
    }

    public RechnungBaseTO getRechnungBaseTO(Long rechnungId) {
        Rechnung rechnung = rechnungDao.get(rechnungId);
        RechnungBaseTO rechnungBaseTO = new RechnungBaseTO();

        try {
            //here comes the reflection voodoo ;-)
            beanUtil.copyEntityToBaseTO(rechnung,rechnungBaseTO);
            //jetzt sind im rechnungBaseTO alle Attribute von rechnung OHNE die Beziehungen!
        } catch (Exception e) {
            //TODO Fehlerbehandlung
            e.printStackTrace();
        }
        return  rechnungBaseTO;    }

    public Rechnung saveBaseTO(RechnungBaseTO rechnungBaseTO) {
        //erst mal die Rechnung holen
        Rechnung rechnung = rechnungDao.get(rechnungBaseTO.getRechnungId());
        try {
            //mit reflection voodoo die Daten vom rechnungBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(rechnungBaseTO, rechnung);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();
        }

        rechnung = save(rechnung);
        return rechnung;    }

    public Rechnung create(RechnungBaseTO rechnungBaseTO, Long exemplarId) {
        //Neue Rechnung erstellen
        Rechnung rechnung = new Rechnung();

        //Attribute aus dem BaseTO füllen
        try {
            //mit reflection voodoo die Daten vom rechnungBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(rechnungBaseTO, rechnung);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();
        }

        //Das Exemplar der Rechnung zuordnen
        rechnung.setExemplar(exemplarDao.get(exemplarId));

        //Speichern und gut is!
        rechnung = save(rechnung);
        return rechnung;
    }
}
