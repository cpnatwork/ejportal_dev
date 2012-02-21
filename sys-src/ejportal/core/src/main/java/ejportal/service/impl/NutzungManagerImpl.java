package ejportal.service.impl;

import ejportal.dao.JournalDao;
import ejportal.dao.NutzungDao;
import ejportal.model.Journal;
import ejportal.model.Nutzung;
import ejportal.service.NutzungManager;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 09.08.2010
 * Time: 16:12:49
 * To change this template use File | Settings | File Templates.
 */
public class NutzungManagerImpl extends GenericManagerImpl<Nutzung, Long> implements NutzungManager {
    private NutzungDao nutzungDao;
    private JournalDao journalDao;

    public NutzungManagerImpl(NutzungDao nutzungDao, JournalDao journalDao){
        super(nutzungDao);
        this.nutzungDao = nutzungDao;
        this.journalDao = journalDao;
    }

    public List<Nutzung> findByJournalId(Long journalId) {
        return nutzungDao.findByJournal(journalId);
    }

    public Nutzung saveWithJournal(Nutzung nutzung, Long journalId) {
        nutzung.setJournal(journalDao.get(journalId));

        return super.save(nutzung);
    }

}
