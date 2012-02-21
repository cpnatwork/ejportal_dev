package ejportal.dao;

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 13:40:30
 * To change this template use File | Settings | File Templates.
 */

import java.util.Date;
import java.util.List;

import ejportal.model.Fach;
import org.appfuse.dao.BaseDaoTestCase;
import ejportal.model.Journal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;
import static org.junit.Assert.*;

public class JournalDaoTest extends BaseDaoTestCase {
    @Autowired
    private JournalDao journalDao;

    @Test
    public void testFindJournalByTitel() throws Exception {
        List<Journal> journals = journalDao.findByTitel("Die weiße Spinne");

        //test, ob institutionen drin haengen
        assertNotNull(journals.get(0).getVerlag());
        assertNotNull(journals.get(0).getProvider());
        assertNotNull(journals.get(0).getKonsortium());

        assertTrue(journals.size() > 0);
    }

    @Test
    public void testFindJournalByKurztitel() throws Exception {
        List<Journal> journals = journalDao.findByKurztitel("DwS");
        assertTrue(journals.size() > 0);
    }

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveJournal() throws Exception {
        Journal journal = new Journal();
        journal.setTitel("Westalpen");
        journal.setKurztitel("W");

        journal = journalDao.save(journal);
        flush();

        journal = journalDao.get(journal.getId());

        assertEquals("Westalpen", journal.getTitel());
        assertNotNull(journal.getId());

        log.debug("removing journal...");

        journalDao.remove(journal.getId());
        flush();

        // should throw DataAccessException
        journalDao.get(journal.getId());
    }

    @Test
    public void testGetFaecher() throws Exception {
        List<Journal> journals = journalDao.findByKurztitel("DwS");
        assertTrue(journals.size() > 0);
        Journal j = journals.get(0);
        java.util.Set<Fach> faecher = j.getFaecher();
        //System.err.println("Faecher:"+faecher.get(0));
       assertTrue(faecher.size() > 0);
    }

    @Test
    public void testFindByBearbeitungsdatum() throws Exception {
        List<Journal> journals = journalDao.findByBearbeitungsdatum(new Date());
        assertTrue(journals.size() > 0);
  
    }

}
