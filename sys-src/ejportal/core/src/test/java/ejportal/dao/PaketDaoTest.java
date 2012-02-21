package ejportal.dao;

import ejportal.model.Paket;
import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 04.08.2010
 * Time: 09:58:24
 * To change this template use File | Settings | File Templates.
 */
public class PaketDaoTest extends BaseDaoTestCase {
    @Autowired
    private PaketDao paketDao;

    @Test
    public void testFindPaketByName() throws Exception {
        List<Paket> pakete = paketDao.findByPaketName("Kombi: Journal of allergy and clinical immunology");

        //test, ob pakete drin haengen
        assertNotNull(pakete.get(0).getPaketName());

        assertTrue(pakete.size() > 0);
    }

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveJournal() throws Exception {
        Paket paket = new Paket ();
        paket.setPaketName("Paket Test");

        paket = paketDao.save(paket);
        flush();

        paket = paketDao.get(paket.getPaketId());

        assertEquals("Paket Test", paket.getPaketName());
        assertNotNull(paket.getPaketId());

        log.debug("removing paket...");

        paketDao.remove(paket.getPaketId());
        flush();

        // should throw DataAccessException
        paketDao.get(paket.getPaketId());
    }


}
