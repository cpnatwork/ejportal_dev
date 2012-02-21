package ejportal.service.impl;

import ejportal.dao.SigelDao;
import ejportal.model.Sigel;
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
 * User: Tselmeg
 * Date: 05.08.2010
 * Time: 15:05:10
 * To change this template use File | Settings | File Templates.
 */
public class SigelManagerImplTest  extends BaseManagerMockTestCase {
    private SigelManagerImpl manager = null;
    private SigelDao sigelDao = null;

    @Before
    public void setUp() {
        sigelDao = context.mock(SigelDao.class);
        manager = new SigelManagerImpl(sigelDao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetSigel() {
        log.debug("testing get...");

        final Long id = 7L;
        final Sigel sigel = new Sigel();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(sigelDao).get(with(equal(id)));
            will(returnValue(sigel));
        }});

        Sigel result = manager.get(id);
        assertSame(sigel, result);
    }

    @Test
    public void testGetSigels() {
        log.debug("testing getAll...");

        final List sigels = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(sigelDao).getAll();
            will(returnValue(sigels));
        }});

        List result = manager.getAll();

        assertSame(sigels, result);
    }

    @Test
    public void testSaveSigel() {
        log.debug("testing save...");

        final Sigel sigel = new Sigel();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(sigelDao).save(with(same(sigel)));
        }});

        manager.save(sigel);
    }

    @Test
    public void testRemoveSigel() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(sigelDao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}
