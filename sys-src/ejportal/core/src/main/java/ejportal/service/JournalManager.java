package ejportal.service;

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 14:21:38
 * To change this template use File | Settings | File Templates.
 */

import ejportal.service.dto.JournalBaseTO;
import ejportal.service.dto.JournalSearchTO;
import org.appfuse.service.GenericManager;
import ejportal.model.Journal;

import java.util.Date;
import java.util.List;

public interface JournalManager extends GenericManager<Journal, Long> {

    

    public List<Journal> search(JournalSearchTO journalSearchTO) ;
    public List<Journal> search(JournalSearchTO journalSearchTO, Integer maxResults) ;

    public void connectJournalVerlag(long journalId, long verlagId);
    public void connectJournalProvider(long journalId, long providerId);
    public void connectJournalKonsortium(long journalId, long konsortiumId);
    public void connectJournalPaket(long journalId, long paketId);
    public boolean connectJournalFach(long journalId, long fachId);
    public boolean disconnectJournalFach(long journalId, long fachId);
    public void connectJournalBibliotheksmitarbeiter(long journalId, long bibId);
    public void connectJournalExemplar(long journalId, long exemplarId);
    
    public JournalBaseTO getJournalBaseTO(long id);

    public List<Journal> findByTitel(String titel);
    public List<Journal> findByKurztitel(String kurztitel);
    public List<Journal> findByVerlagId(int verlagId);
    public List<Journal> findByBearbeitungsdatum(Date maxDate);
    public List<Journal> findByBearbeitungsdatumAll();
    public List<Journal> findByZugangUeber(String zugangUeber);

    public Journal saveBaseTO(JournalBaseTO journalBaseTO);

    public Journal create(JournalBaseTO journalBaseTO);

   
}

