package ejportal.service.impl;

import ejportal.dao.ExemplarDao;
import ejportal.dao.InstitutionDao;
import ejportal.dao.JournalDao;
import ejportal.dao.SigelDao;
import ejportal.model.Exemplar;
import ejportal.model.Journal;
import ejportal.service.ExemplarManager;
import ejportal.service.dto.ExemplarBaseTO;
import ejportal.util.BeanUtil;
import org.appfuse.service.impl.GenericManagerImpl;

/**
 * Created by IntelliJ IDEA.
 * User: Christoph
 * Date: 14.07.2010
 * Time: 16:15:45
 * To change this template use File | Settings | File Templates.
 */
public class ExemplarManagerImpl extends GenericManagerImpl<Exemplar, Long> implements ExemplarManager {
    private ExemplarDao exemplarDao;
    private InstitutionDao institutionDao;
    private SigelDao sigelDao;
    private JournalDao journalDao;
    BeanUtil beanUtil;

    public ExemplarManagerImpl(ExemplarDao exemplarDao, InstitutionDao institutionDao, SigelDao sigelDao, JournalDao journalDao) {
        super(exemplarDao);
        this.exemplarDao = exemplarDao;
        this.institutionDao = institutionDao;
        this.sigelDao = sigelDao;
        this.journalDao = journalDao;
        beanUtil = new BeanUtil();
    }

    public void connectExemplarLieferant(long exemplarId, long lieferantId) {
        Exemplar exemplar = exemplarDao.get(exemplarId);
        exemplar.setLieferant(institutionDao.get(lieferantId));
    }

    public void connectExemplarEigentuemer(long exemplarId, long eigentuemerId) {
        Exemplar exemplar = exemplarDao.get(exemplarId);
        exemplar.setEigentuemer(sigelDao.get(eigentuemerId));
    }

    public void connectExemplarBesteller(long exemplarId, long bestellerId) {
        Exemplar exemplar = exemplarDao.get(exemplarId);
        exemplar.setBesteller(sigelDao.get(bestellerId));
    }

    public void connectExemplarZustaendigeBib(long exemplarId, long zustaendigeBibId){
        Exemplar exemplar = exemplarDao.get(exemplarId);
        exemplar.setZustaendigeBib(sigelDao.get(zustaendigeBibId));
    }

    public ExemplarBaseTO getExemplarBaseTO(long exemplarId) {
        //TODO Fehlerbehandlung
        Exemplar exemplar = exemplarDao.get(exemplarId);
        ExemplarBaseTO exemplarBaseTO = new ExemplarBaseTO();

        try {
            //here comes the reflection voodoo ;-)
            beanUtil.copyEntityToBaseTO(exemplar,exemplarBaseTO);
            //jetzt sind im exemplarBaseTO alle Attribute von exemplar OHNE die Beziehungen!
        } catch (Exception e) {
            //TODO Fehlerbehandlung
            e.printStackTrace();
        }
        return   exemplarBaseTO;    }

    public Exemplar saveBaseTO(ExemplarBaseTO exemplarBaseTO) {
        //erst mal das Exemplar holen
        Exemplar exemplar = exemplarDao.get(exemplarBaseTO.getExemplarId());
        try {
            //mit reflection voodoo die Daten vom exemplarBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(exemplarBaseTO, exemplar);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();
        }

        exemplar = save(exemplar);
        return exemplar;    }

    public Exemplar create(ExemplarBaseTO exemplarBaseTO, Long journalId) {

        //Neues Exemplar erstellen
        Exemplar exemplar = new Exemplar();

        //Attribute aus dem BaseTO füllen
        try {
            //mit reflection voodoo die Daten vom exemplarBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(exemplarBaseTO, exemplar);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();
        }

        //Neues Exemplar dem Journal zuweisen
        Journal journal = journalDao.get(journalId);
        exemplar.setJournal(journal);
        //Die folgende Zeile macht Hibernate von selbst!
        //journal.getExemplare().add(exemplar);

        //Speichern und gut is!
        exemplar = save(exemplar);
        return exemplar;    }

    public void removeSafe(Long exemplarId){

        //Erst das Exemplar aus der Exemplar-Liste des Journals entfernen
        Exemplar exemplar = exemplarDao.get(exemplarId);
        exemplar.getJournal().getExemplare().remove(exemplar);

        //Löschen und gut is!
        super.remove(exemplarId);
    }
}
