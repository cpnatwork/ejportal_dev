package ejportal.dao;

import ejportal.model.Sigel;
import ejportal.service.dto.SigelSearchTO;
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
 * User: Chris
 * Date: 28.06.2010
 * Time: 15:20:51
 * To change this template use File | Settings | File Templates.
 */
public class SigelDaoTest extends BaseDaoTestCase {
    @Autowired
    private SigelDao sigelDao;

    @Test
    public void testFindByName() throws Exception{
         List<Sigel> sigel = sigelDao.findByName("EB");

        //test, ob institutionen drin haengen
        assertNotNull(sigel.get(0).getName());
        assertNotNull(sigel.get(0).getBibliothek());
        assertNotNull(sigel.get(0).getFakultaet());

        assertTrue(sigel.size() > 0);
    }

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveSigel() throws Exception {
        Sigel sigel = new Sigel();
        sigel.setName("Test-Sigel 2");

        sigel = sigelDao.save(sigel);
        flush();

        sigel = sigelDao.get(sigel.getSigelId());

        assertEquals("Test-Sigel 2", sigel.getName());
        assertNotNull(sigel.getSigelId());

        log.debug("removing sigel...");

        sigelDao.remove(sigel.getSigelId());
        flush();

        // should throw DataAccessException
        sigelDao.get(sigel.getSigelId());
    }
}
