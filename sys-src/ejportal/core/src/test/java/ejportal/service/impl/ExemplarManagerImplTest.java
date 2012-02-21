package ejportal.service.impl;

import ejportal.dao.ExemplarDao;
import ejportal.dao.InstitutionDao;
import ejportal.dao.JournalDao;
import ejportal.dao.SigelDao;
import ejportal.model.Exemplar;
import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 04.08.2010
 * Time: 13:55:47
 * To change this template use File | Settings | File Templates.
 */
public class ExemplarManagerImplTest extends BaseManagerMockTestCase {
    private ExemplarManagerImpl manager = null;
    private ExemplarDao exemplarDao = null;
    private InstitutionDao institutionDao = null;
    private SigelDao sigelDao = null;
    private JournalDao journalDao = null;

    @Before
    public void setUp(){
        exemplarDao = context.mock(ExemplarDao.class);
        institutionDao = context.mock(InstitutionDao.class);
        sigelDao = context.mock(SigelDao.class);
        journalDao = context.mock(JournalDao.class);
        manager = new ExemplarManagerImpl(exemplarDao, institutionDao, sigelDao, journalDao);
    }
    
    @After
    public void tearDown() {
        manager = null;
    }
    
    @Test
    public void testGetExemplar() {
        log.debug("testing get...");

        final Long id = 7L;
        final Exemplar exemplar = new Exemplar();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(exemplarDao).get(with(equal(id)));
            will(returnValue(exemplar));
        }});

        Exemplar result = manager.get(id);
        assertSame(exemplar, result);
    }

    @Test
    public void testGetExemplars() {
        log.debug("testing getAll...");

        final List exemplars = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(exemplarDao).getAll();
            will(returnValue(exemplars));
        }});

        List result = manager.getAll();

        assertSame(exemplars, result);
    }

    @Test
    public void testSaveExemplar() {
        log.debug("testing save...");

        final Exemplar exemplar = new Exemplar();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(exemplarDao).save(with(same(exemplar)));
        }});

        manager.save(exemplar);
    }

    @Test
    public void testRemoveExemplar() {
        log.debug("testing remove...");

        final Long id = 1L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(exemplarDao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}
