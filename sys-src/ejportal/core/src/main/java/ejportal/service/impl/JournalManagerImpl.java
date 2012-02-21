package ejportal.service.impl;

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 14:29:19
 * To change this template use File | Settings | File Templates.
 */


import ejportal.dao.*;
import ejportal.model.Exemplar;
import ejportal.model.Fach;
import ejportal.model.Journal;
import ejportal.service.JournalManager;
import ejportal.service.dto.JournalBaseTO;
import ejportal.service.dto.JournalSearchTO;
import ejportal.util.BeanUtil;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.Date;
import java.util.List;

public class JournalManagerImpl extends GenericManagerImpl<Journal, Long> implements JournalManager {
    private JournalDao journalDao;
    private InstitutionDao institutionDao;
    private KonsortiumDao konsortiumDao;
    private PaketDao paketDao;
    private FachDao fachDao;
    private ExemplarDao exemplarDao;
    private BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao;
    BeanUtil beanUtil;


    public JournalManagerImpl(JournalDao journalDao, InstitutionDao institutionDao, KonsortiumDao konsortiumDao, PaketDao paketDao, FachDao fachDao, ExemplarDao exemplarDao, BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao) {
        super(journalDao);
        this.journalDao = journalDao;
        this.institutionDao = institutionDao;
        this.konsortiumDao = konsortiumDao;
        this.paketDao = paketDao;
        this.fachDao = fachDao;
        this.exemplarDao = exemplarDao;
        this.bibliotheksmitarbeiterDao = bibliotheksmitarbeiterDao;
        beanUtil = new BeanUtil();
    }




    public List<Journal> search(JournalSearchTO journalSearchTO, Integer maxResults) {
        return journalDao.findBySearchTO(journalSearchTO, maxResults);
    }

    public List<Journal> search(JournalSearchTO journalSearchTO) {
        return journalDao.findBySearchTO(journalSearchTO); 
    }


    public JournalBaseTO getJournalBaseTO(long journalId){
        //TODO Fehlerbehandlung
       Journal journal = journalDao.get(journalId);
       JournalBaseTO journalBaseTO = new JournalBaseTO();

        try {
            //here comes the reflection voodoo ;-)
            beanUtil.copyEntityToBaseTO(journal,journalBaseTO);
            //jetzt sind im journalBaseTO alle Attribute von journal OHNE die Beziehungen!
        } catch (Exception e) {
            //TODO Fehlerbehandlung
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return   journalBaseTO;
    }

    public Journal saveBaseTO(JournalBaseTO journalBaseTO) {
        //erst mal das Journal holen
        Journal journal = journalDao.get(journalBaseTO.getId());
        try {
            //mit reflection voodoo die Daten vom journalBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(journalBaseTO, journal);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        //Änderungsdatum auf aktuelles Datum setzen
        journal.setAenderungsdatum(new java.util.Date());
        journal = save(journal);
        return journal;
    }

    public Journal create(JournalBaseTO journalBaseTO) {
        Journal journal = new Journal();
        try {
            //mit reflection voodoo die Daten vom journalBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(journalBaseTO, journal);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        //Änderungsdatum auf aktuelles Datum setzen
        journal.setAenderungsdatum(new java.util.Date());
        journal = save(journal);
        return journal;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void connectJournalVerlag(long journalId, long verlagId) {          
        Journal journal = journalDao.get(journalId);
        //Änderungsdatum auf aktuelles Datum setzen
        journal.setAenderungsdatum(new java.util.Date());
        journal.setVerlag(institutionDao.get(verlagId));
    }

    public void connectJournalProvider(long journalId, long providerId) {
        Journal journal = journalDao.get(journalId);
        //Änderungsdatum auf aktuelles Datum setzen
        journal.setAenderungsdatum(new java.util.Date());
        journal.setProvider(institutionDao.get(providerId));
    }

    public void connectJournalKonsortium(long journalId, long konsortiumId) {
        Journal journal = journalDao.get(journalId);
        //Änderungsdatum auf aktuelles Datum setzen
        journal.setAenderungsdatum(new java.util.Date());
        journal.setKonsortium(konsortiumDao.get(konsortiumId));
    }

    public void connectJournalPaket(long journalId, long paketId) {
        Journal journal = journalDao.get(journalId);
        //Änderungsdatum auf aktuelles Datum setzen
        journal.setAenderungsdatum(new java.util.Date());
        journal.setPaket(paketDao.get(paketId));
    }

    public boolean connectJournalFach(long journalId, long fachId) {
        Journal journal = journalDao.get(journalId);
        Fach fach = fachDao.get(fachId);
        //Änderungsdatum auf aktuelles Datum setzen
        journal.setAenderungsdatum(new java.util.Date());
        fach.getJournals().add(journal);
        return journal.getFaecher().add(fach);
    }

    public boolean disconnectJournalFach(long journalId, long fachId){
        Journal journal = journalDao.get(journalId);
        Fach fach = fachDao.get(fachId);
        //Änderungsdatum auf aktuelles Datum setzen
        journal.setAenderungsdatum(new java.util.Date());
        fach.getJournals().remove(journal);
        return journal.getFaecher().remove(fach);
    }

    public void connectJournalBibliotheksmitarbeiter(long journalId, long bibId) {
       Journal journal = journalDao.get(journalId);
        //Änderungsdatum auf aktuelles Datum setzen
        journal.setAenderungsdatum(new java.util.Date());
        journal.setBibliotheksmitarbeiter(bibliotheksmitarbeiterDao.get(bibId));
    }

    public void connectJournalExemplar(long journalId, long exemplarId) {
        Journal journal = journalDao.get(journalId);
        Exemplar exemplar = exemplarDao.get(exemplarId);

        //Änderungsdatum auf aktuelles Datum setzen
        journal.setAenderungsdatum(new java.util.Date());

        exemplar.setJournal(journal);
        journal.getExemplare().add(exemplar);
    }

    public List<Journal> findByTitel(String titel) {
        return journalDao.findByTitel(titel);
    }

    public List<Journal> findByKurztitel(String kurztitel) {
        return journalDao.findByKurztitel(kurztitel);
    }

    public List<Journal> findByVerlagId(int verlagId) {
        return journalDao.findByVerlag(verlagId);
    }

    public List<Journal> findByBearbeitungsdatum(Date maxDate) {
        return journalDao.findByBearbeitungsdatum(maxDate);
    }

    public List<Journal> findByBearbeitungsdatumAll() {
        return journalDao.findByBearbeitungsdatumAll();
    }

    public List<Journal> findByZugangUeber(String zugangUeber) {
        return journalDao.findByZugangUeber(zugangUeber);
    }
}
