package ejportal.service.impl;

import ejportal.dao.InstitutionDao;
import ejportal.dao.JournalDao;
import ejportal.dao.KonsortiumDao;
import ejportal.dao.PaketDao;
import ejportal.model.Konsortium;
import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 03.08.2010
 * Time: 16:49:18
 * To change this template use File | Settings | File Templates.
 */
public class KonsortiumManagerImplTest extends BaseManagerMockTestCase {
    private KonsortiumManagerImpl manager = null;
    private KonsortiumDao konsortiumDao = null;
    @Before
    public void setUp() {
        konsortiumDao = context.mock(KonsortiumDao.class);
        manager = new KonsortiumManagerImpl(konsortiumDao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetKonsortium() {
        log.debug("testing get...");

        final Long id = 7L;
        final Konsortium konsortium = new Konsortium();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(konsortiumDao).get(with(equal(id)));
            will(returnValue(konsortium));
        }});

        Konsortium result = manager.get(id);
        assertSame(konsortium, result);
    }

    @Test
    public void testGetKonsortiums() {
        log.debug("testing getAll...");

        final List konsortiums = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(konsortiumDao).getAll();
            will(returnValue(konsortiums));
        }});

        List result = manager.getAll();

        assertSame(konsortiums, result);
    }

    @Test
    public void testSaveKonsortium() {
        log.debug("testing save...");

        final Konsortium konsortium = new Konsortium();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(konsortiumDao).save(with(same(konsortium)));
        }});

        manager.save(konsortium);
    }

    @Test
    public void testRemoveKonsortium() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(konsortiumDao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }

}
