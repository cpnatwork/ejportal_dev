package ejportal.dao;

import ejportal.model.Institution;
import ejportal.service.dto.InstitutionSearchTO;
import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 21.06.2010
 * Time: 12:39:44
 * To change this template use File | Settings | File Templates.
 */
public class InstitutionDaoTest extends BaseDaoTestCase{
    @Autowired
    private InstitutionDao institutionDao;

    @Test
    public void testFindByName() throws Exception{
        InstitutionSearchTO institutionSearchTO = new InstitutionSearchTO();
        institutionSearchTO.setName("Springer");

        List<Institution> institutionen = institutionDao.findBySearchTO(institutionSearchTO );
        assertTrue(institutionen.size() > 0);
    }

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveInstitution() throws Exception{
        Institution institution = new Institution();
        institution.setName("BayernDirekt");

        institution = institutionDao.save(institution);
        flush();

        institution = institutionDao.get(institution.getId());

        assertEquals("BayernDirekt", institution.getName());

        System.out.println(institution.getId());
        assertNotNull(institution.getId());

        log.debug("removing institution...");

        institutionDao.remove(institution.getId());
        flush();

        // should throw DataAccessException
        institutionDao.get(institution.getId());

    }
}
