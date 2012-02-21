package ejportal.dao;

import ejportal.model.Nutzung;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.appfuse.dao.BaseDaoTestCase;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;
import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 09.08.2010
 * Time: 16:22:05
 * To change this template use File | Settings | File Templates.
 */
public class NutzungDaoTest extends BaseDaoTestCase {
    @Autowired
    private NutzungDao nutzungDao;

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveJournal() throws Exception {
        Nutzung nutzung = new Nutzung();
        nutzung.setRechnungsbetrag(2.09F);

        nutzung = nutzungDao.save(nutzung);
        flush();

        nutzung = nutzungDao.get(nutzung.getNutzungId());

        assertEquals(new Float(2.09F), nutzung.getRechnungsbetrag());
        assertNotNull(nutzung.getNutzungId());

        log.debug("removing Nutzung...");

        nutzungDao.remove(nutzung.getNutzungId());
        flush();

        // should throw DataAccessException
        nutzungDao.get(nutzung.getNutzungId());
    }
}
