package ejportal.dao;

import ejportal.model.Rechnung;
import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 09.08.2010
 * Time: 15:16:11
 * To change this template use File | Settings | File Templates.
 */
public class RechnungDaoTest extends BaseDaoTestCase {
    @Autowired
    private RechnungDao rechnungDao;

    @Test
    public void testFindByExemplar() throws Exception {
        List<Rechnung> rechnungen = rechnungDao.findByExemplarId(1L);
        assertTrue(rechnungen.size() > 0);
    }

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveRechnung() throws Exception {
        Rechnung rechnung = new Rechnung();
        rechnung.setBetrag(999.99F);
        rechnung.setBezugsform("Irgendwas");
        rechnung.setBezugsjahr("2000");

        rechnung = rechnungDao.save(rechnung);
        flush();

        rechnung = rechnungDao.get(rechnung.getRechnungId());

        assertEquals("Irgendwas", rechnung.getBezugsform());
        assertNotNull(rechnung.getRechnungId());

        log.debug("removing rechnung...");

        rechnungDao.remove(rechnung.getRechnungId());
        flush();

        // should throw DataAccessException
        rechnungDao.get(rechnung.getRechnungId());
    }


}
