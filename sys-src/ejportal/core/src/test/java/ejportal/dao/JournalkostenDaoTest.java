package ejportal.dao;

import ejportal.model.Journalkosten;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;
import org.appfuse.dao.BaseDaoTestCase;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 12.08.2010
 * Time: 11:30:02
 * To change this template use File | Settings | File Templates.
 */
public class JournalkostenDaoTest extends BaseDaoTestCase {
    @Autowired
    private JournalkostenDao journalkostenDao;

    @Test
    public void testFindByJournalId() throws Exception{
        Journalkosten journalkosten = journalkostenDao.findByJournalId(1L);
        assertTrue(journalkosten != null);
    }

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemove() throws Exception {
        Journalkosten journalkosten = new Journalkosten();
        journalkosten.setOPreisPO((long)123.12);

        journalkosten = journalkostenDao.save(journalkosten);
        flush();

        journalkosten = journalkostenDao.get(journalkosten.getJournalkostenId());

        assertEquals((long)123.12, (long)journalkosten.getOPreisPO());
        assertNotNull(journalkosten.getJournalkostenId());

        log.debug("removing Journalkosten...");

        journalkostenDao.remove(journalkosten.getJournalkostenId());
        flush();

        // should throw DataAccessException
        journalkostenDao.get(journalkosten.getJournalkostenId());

    }
}
