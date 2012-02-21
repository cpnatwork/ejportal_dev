package ejportal.service.impl;

import ejportal.dao.EzbDatenDao;
import ejportal.dao.JournalDao;
import ejportal.model.EzbDaten;
import ejportal.model.Journal;
import ejportal.service.EzbDatenManager;
import ejportal.service.dto.EzbDatenSearchTO;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 09.08.2010
 * Time: 18:01:20
 * To change this template use File | Settings | File Templates.
 */
public class EzbDatenManagerImpl extends GenericManagerImpl<EzbDaten, Long> implements EzbDatenManager {
    private EzbDatenDao ezbDatenDao;
    private JournalDao journalDao;

    public EzbDatenManagerImpl(EzbDatenDao ezbDatenDao, JournalDao journalDao){
        super(ezbDatenDao);
        this.ezbDatenDao = ezbDatenDao;
        this.journalDao = journalDao;
    }

    public EzbDaten loadWithJournalId(Long journalId) {
        Journal journal = journalDao.get(journalId);
        if(journal.getEzbId() != null){
            try {
                return ezbDatenDao.get(journal.getEzbId());
            } catch (Exception e) {
                return new EzbDaten();
            }
        }
        return new EzbDaten();
    }

    public List<EzbDaten> findBySearchTO(EzbDatenSearchTO ezbDatenSearchTO, int maxResults) {
        return ezbDatenDao.findBySearchTO(ezbDatenSearchTO, maxResults);
    }

    public void connectEzbDaten(Long ezbId, Long journalId) {
        Journal journal = journalDao.get(journalId);
        journal.setEzbId(ezbId);
        journalDao.save(journal);
    }

    public Journal createJournal(Long ezbId) {
        EzbDaten ezbDaten = ezbDatenDao.get(ezbId);
        Journal journal = new Journal();

        journal.setEzbId(ezbId);
        journal.setTitel(ezbDaten.getTitel());
        journal.setZdbNummer(ezbDaten.getZdbNummer());
        journal.setIssn(ezbDaten.getIssne());
        journal.setIssnPrint(ezbDaten.getIssnp());
        

        journal = journalDao.save(journal);
        return journal;
    }
}
