package ejportal.service.impl;

import ejportal.dao.PaketDao;
import ejportal.model.Paket;
import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 04.08.2010
 * Time: 10:06:04
 * To change this template use File | Settings | File Templates.
 */
public class PaketManagerImplTest extends BaseManagerMockTestCase {
    private PaketManagerImpl manager = null;
    private PaketDao paketDao = null;
    @Before
    public void setUp() {
        paketDao = context.mock(PaketDao.class);
        manager = new PaketManagerImpl(paketDao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetPaket() {
        log.debug("testing get...");

        final Long id = 7L;
        final Paket paket = new Paket();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(paketDao).get(with(equal(id)));
            will(returnValue(paket));
        }});

        Paket result = manager.get(id);
        assertSame(paket, result);
    }

    @Test
    public void testGetPakete() {
        log.debug("testing getAll...");

        final List pakete = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(paketDao).getAll();
            will(returnValue(pakete));
        }});

        List result = manager.getAll();

        assertSame(pakete, result);
    }

    @Test
    public void testSavePaket() {
        log.debug("testing save...");

        final Paket paket = new Paket();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(paketDao).save(with(same(paket)));
        }});

        manager.save(paket);
    }

    @Test
    public void testRemovePaket() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(paketDao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }

}
