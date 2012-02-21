package ejportal.dao;

import org.appfuse.dao.BaseDaoTestCase;
import ejportal.model.Bibliotheksmitarbeiter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 05.08.2010
 * Time: 14:58:15
 * To change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterDaoTest extends BaseDaoTestCase{
    @Autowired
    private BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao;

    @Test
    public void testFindByName() throws Exception{
         List<Bibliotheksmitarbeiter> bibliotheksmitarbeiter = bibliotheksmitarbeiterDao.findByName("Bio Bib");

        assertNotNull(bibliotheksmitarbeiter.get(0).getName());
        assertNotNull(bibliotheksmitarbeiter.get(0).getAbteilungsHauptstelle());
        assertNotNull(bibliotheksmitarbeiter.get(0).getEmailanschrift());

        assertTrue(bibliotheksmitarbeiter.size() > 0);
    }

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveBibliotheksmitarbeiter() throws Exception {
        Bibliotheksmitarbeiter bibliotheksmitarbeiter = new Bibliotheksmitarbeiter();
        bibliotheksmitarbeiter.setName("Test-Bibliotheksmitarbeiter 2");

        bibliotheksmitarbeiter = bibliotheksmitarbeiterDao.save(bibliotheksmitarbeiter);
        flush();

        bibliotheksmitarbeiter = bibliotheksmitarbeiterDao.get(bibliotheksmitarbeiter.getBibId());

        assertEquals("Test-Bibliotheksmitarbeiter 2", bibliotheksmitarbeiter.getName());
        assertNotNull(bibliotheksmitarbeiter.getBibId());

        log.debug("removing bibliotheksmitarbeiter...");

        bibliotheksmitarbeiterDao.remove(bibliotheksmitarbeiter.getBibId());
        flush();

        // should throw DataAccessException
        bibliotheksmitarbeiterDao.get(bibliotheksmitarbeiter.getBibId());
    }
}
