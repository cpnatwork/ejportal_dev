package ejportal.service.impl;

import ejportal.dao.BibliotheksmitarbeiterDao;
import ejportal.model.Bibliotheksmitarbeiter;
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
 * Date: 05.08.2010
 * Time: 14:58:46
 * To change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterManagerImplTest extends BaseManagerMockTestCase{
        private BibliotheksmitarbeiterManagerImpl manager = null;
    private BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao = null;

    @Before
    public void setUp() {
        bibliotheksmitarbeiterDao = context.mock(BibliotheksmitarbeiterDao.class);
        manager = new BibliotheksmitarbeiterManagerImpl(bibliotheksmitarbeiterDao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetBibliotheksmitarbeiter() {
        log.debug("testing get...");

        final Long id = 7L;
        final Bibliotheksmitarbeiter bibliotheksmitarbeiter = new Bibliotheksmitarbeiter();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(bibliotheksmitarbeiterDao).get(with(equal(id)));
            will(returnValue(bibliotheksmitarbeiter));
        }});

        Bibliotheksmitarbeiter result = manager.get(id);
        assertSame(bibliotheksmitarbeiter, result);
    }

    @Test
    public void testGetBibliotheksmitarbeiters() {
        log.debug("testing getAll...");

        final List bibliotheksmitarbeiters = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(bibliotheksmitarbeiterDao).getAll();
            will(returnValue(bibliotheksmitarbeiters));
        }});

        List result = manager.getAll();

        assertSame(bibliotheksmitarbeiters, result);
    }

    @Test
    public void testSaveBibliotheksmitarbeiter() {
        log.debug("testing save...");

        final Bibliotheksmitarbeiter bibliotheksmitarbeiter = new Bibliotheksmitarbeiter();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(bibliotheksmitarbeiterDao).save(with(same(bibliotheksmitarbeiter)));
        }});

        manager.save(bibliotheksmitarbeiter);
    }

    @Test
    public void testRemoveBibliotheksmitarbeiter() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(bibliotheksmitarbeiterDao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}
