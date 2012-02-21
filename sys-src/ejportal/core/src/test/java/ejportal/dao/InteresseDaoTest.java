package ejportal.dao;

import ejportal.model.Interesse;
import org.appfuse.dao.BaseDaoTestCase;
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
 * User: mkoerner
 * Date: 09.08.2010
 * Time: 16:29:47
 * To change this template use File | Settings | File Templates.
 */
public class InteresseDaoTest extends BaseDaoTestCase {
    @Autowired
    private InteresseDao interesseDao;

    @Test
    public void testFindByJournal() throws Exception{
        List<Interesse> interessen = interesseDao.findByJournalId(1L);
        assertTrue(interessen.size() > 0);
    }

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemove() throws Exception {
        Interesse interesse = new Interesse();
        interesse.setInteresse("Interesse");
        
        interesse = interesseDao.save(interesse);
        flush();
        
        interesse = interesseDao.get(interesse.getInteresseId());

        assertEquals("Interesse", interesse.getInteresse());
        assertNotNull(interesse.getInteresseId());

        log.debug("removing Interesse...");

        interesseDao.remove(interesse.getInteresseId());
        flush();

        // should throw DataAccessException
        interesseDao.get(interesse.getInteresseId());
        
    }
}