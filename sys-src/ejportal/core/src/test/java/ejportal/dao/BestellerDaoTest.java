package ejportal.dao;

import ejportal.model.Besteller;
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
 * Time: 16:23:36
 * To change this template use File | Settings | File Templates.
 */
public class BestellerDaoTest extends BaseDaoTestCase {
    @Autowired
    private BestellerDao bestellerDao;

    @Test
    public void testFindById() throws Exception{
        List<Besteller> besteller = bestellerDao.findByBestellerId(1L);
        assertTrue(besteller.size() > 0);
    }
    
    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemove() throws Exception {
        Besteller besteller = new Besteller();
        besteller.setBestellerName("BestellerName");
        
        besteller = bestellerDao.save(besteller);
        flush();
        
        besteller = bestellerDao.get(besteller.getBestellerId());

        assertEquals("BestellerName", besteller.getBestellerName());
        assertNotNull(besteller.getBestellerId());

        log.debug("removing Besteller...");

        bestellerDao.remove(besteller.getBestellerId());
        flush();

        // should throw DataAccessException
        bestellerDao.get(besteller.getBestellerId());
        
    }
}
