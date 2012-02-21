package ejportal.service.impl;

import ejportal.dao.JournalDao;
import ejportal.dao.NutzungDao;
import ejportal.model.Nutzung;
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
 * User: Nina
 * Date: 09.08.2010
 * Time: 16:23:13
 * To change this template use File | Settings | File Templates.
 */
public class NutzungManagerImplTest extends BaseManagerMockTestCase{
    private NutzungManagerImpl manager = null;
    private NutzungDao nutzungDao = null;
    private JournalDao journalDao = null;

    @Before
    public void setUp(){
        nutzungDao = context.mock(NutzungDao.class);
        journalDao = context.mock(JournalDao.class);
        manager = new NutzungManagerImpl(nutzungDao, journalDao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetNutzung() {
        log.debug("testing get...");

        final Long id = 7L;
        final Nutzung nutzung = new Nutzung();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(nutzungDao).get(with(equal(id)));
            will(returnValue(nutzung));
        }});

        Nutzung result = manager.get(id);
        assertSame(nutzung, result);
    }

    @Test
    public void testGetNutzungen() {
        log.debug("testing getAll...");

        final List nutzungen = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(nutzungDao).getAll();
            will(returnValue(nutzungen));
        }});

        List result = manager.getAll();

        assertSame(nutzungen, result);
    }

    @Test
    public void testSaveNutzung() {
        log.debug("testing save...");

        final Nutzung nutzung = new Nutzung();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(nutzungDao).save(with(same(nutzung)));
        }});

        manager.save(nutzung);
    }

    @Test
    public void testRemoveNutzung() {
        log.debug("testing remove...");

        final Long id = 1L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(nutzungDao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}
