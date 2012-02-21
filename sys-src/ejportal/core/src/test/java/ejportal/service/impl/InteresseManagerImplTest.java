package ejportal.service.impl;

import ejportal.dao.BestellerDao;
import ejportal.dao.InteresseDao;
import ejportal.dao.JournalDao;
import ejportal.model.Interesse;
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
 * Date: 09.08.2010
 * Time: 16:42:11
 * To change this template use File | Settings | File Templates.
 */
public class InteresseManagerImplTest extends BaseManagerMockTestCase {
    private InteresseManagerImpl manager = null;
    private InteresseDao interesseDao = null;
    private BestellerDao bestellerDao = null;
    private JournalDao journalDao = null;

    @Before
    public void setUp(){
        bestellerDao = context.mock(BestellerDao.class);
        interesseDao = context.mock(InteresseDao.class);
        journalDao = context.mock(JournalDao.class);
        manager = new InteresseManagerImpl(interesseDao, bestellerDao, journalDao);
    }
    
    @After
    public void tearDown() {
        manager = null;
    }
    
    @Test
    public void testGetInteresse() {
        log.debug("testing get...");

        final Long id = 7L;
        final Interesse interesse = new Interesse();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(interesseDao).get(with(equal(id)));
            will(returnValue(interesse));
        }});

        Interesse result = manager.get(id);
        assertSame(interesse, result);
    }

    @Test
    public void testGetInteresses() {
        log.debug("testing getAll...");

        final List interesses = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(interesseDao).getAll();
            will(returnValue(interesses));
        }});

        List result = manager.getAll();

        assertSame(interesses, result);
    }

    @Test
    public void testSaveInteresse() {
        log.debug("testing save...");

        final Interesse interesse = new Interesse();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(interesseDao).save(with(same(interesse)));
        }});

        manager.save(interesse);
    }

    @Test
    public void testRemoveInteresse() {
        log.debug("testing remove...");

        final Long id = 1L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(interesseDao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}
