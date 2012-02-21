package ejportal.dao;

import ejportal.model.Exemplar;
import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 04.08.2010
 * Time: 12:22:22
 * To change this template use File | Settings | File Templates.
 */
public class ExemplarDaoTest extends BaseDaoTestCase {
    @Autowired
    private ExemplarDao exemplarDao;

    @Test
    @ExpectedException(DataAccessException.class)
    public void testAddAndRemoveJournal() throws Exception {
        Exemplar exemplar = new Exemplar();
        exemplar.setForm("Print");

        exemplar = exemplarDao.save(exemplar);
        flush();

        exemplar = exemplarDao.get(exemplar.getExemplarId());

        assertEquals("Print", exemplar.getForm());
        assertNotNull(exemplar.getExemplarId());

        log.debug("removing Exemplar...");

        exemplarDao.remove(exemplar.getExemplarId());
        flush();

        // should throw DataAccessException
        exemplarDao.get(exemplar.getExemplarId());
    }

    @Test
    public void testFindExemplarForJournal(){
        List<Exemplar> exemplare = exemplarDao.getListForJournal(2);
        log.debug("getting exemplare for journals");
        assertNotNull(exemplare);
    }
}