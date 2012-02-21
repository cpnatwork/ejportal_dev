package ejportal.service.impl;

import ejportal.dao.ExemplarDao;
import ejportal.dao.JournalDao;
import ejportal.dao.RechnungDao;
import ejportal.dao.SigelDao;
import ejportal.model.Rechnung;
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
 * Date: 09.08.2010
 * Time: 15:38:49
 * To change this template use File | Settings | File Templates.
 */
public class RechnungManagerImplTest extends BaseManagerMockTestCase {
    private RechnungManagerImpl manager = null;
    private RechnungDao rechnungDao = null;
    private ExemplarDao exemplarDao;
    private JournalDao journalDao;

    @Before
    public void setUp() {
        rechnungDao = context.mock(RechnungDao.class);
        exemplarDao = context.mock(ExemplarDao.class);
        journalDao = context.mock(JournalDao.class);
        manager = new RechnungManagerImpl(rechnungDao, exemplarDao, journalDao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetRechnung() {
        log.debug("testing get...");

        final Long id = 7L;
        final Rechnung rechnung = new Rechnung();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(rechnungDao).get(with(equal(id)));
            will(returnValue(rechnung));
        }});

        Rechnung result = manager.get(id);
        assertSame(rechnung, result);
    }

    public void testGetRechnungen() {
        log.debug("testing getAll...");

        final List rechnungen = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(rechnungDao).getAll();
            will(returnValue(rechnungen));
        }});

        List result = manager.getAll();

        assertSame(rechnungen, result);
    }

    @Test
    public void testSaveRechnung() {
        log.debug("testing save...");

        final Rechnung rechnung = new Rechnung();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(rechnungDao).save(with(same(rechnung)));
        }});

        manager.save(rechnung);

    }

    @Test
    public void testRemoveRechnung() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(rechnungDao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }

}
