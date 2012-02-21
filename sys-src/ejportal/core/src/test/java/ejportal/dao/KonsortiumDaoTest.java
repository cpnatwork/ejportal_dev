package ejportal.dao;

import ejportal.model.Konsortium;
import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 03.08.2010
 * Time: 16:42:22
 * To change this template use File | Settings | File Templates.
 */
public class KonsortiumDaoTest extends BaseDaoTestCase {
    @Autowired
    private KonsortiumDao konsortiumDao;

    @Test
    public void testFindKonsortiumByName() throws Exception {
        List<Konsortium> konsortien = konsortiumDao.findByKonsortiumName("Elsevier-K");

        //test, ob institutionen drin haengen
        assertNotNull(konsortien.get(0).getKonsortiumName());

        assertTrue(konsortien.size() > 0);
    }

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveJournal() throws Exception {
        Konsortium konsortium = new Konsortium ();
        konsortium.setKonsortiumName("Konsortium Test");

        konsortium = konsortiumDao.save(konsortium);
        flush();

        konsortium = konsortiumDao.get(konsortium.getKonsortiumId());

        assertEquals("Konsortium Test", konsortium.getKonsortiumName());
        assertNotNull(konsortium.getKonsortiumId());

        log.debug("removing konsortium...");

        konsortiumDao.remove(konsortium.getKonsortiumId());
        flush();

        // should throw DataAccessException
        konsortiumDao.get(konsortium.getKonsortiumId());
    }


}