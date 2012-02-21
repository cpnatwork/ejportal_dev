package ejportal.service.impl;

import ejportal.dao.JournalDao;
import ejportal.dao.JournalkostenDao;
import ejportal.dao.WechselkursDao;
import ejportal.model.Journalkosten;
import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertSame;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 12.08.2010
 * Time: 12:04:00
 * To change this template use File | Settings | File Templates.
 */
public class JournalkostenManagerImplTest extends BaseManagerMockTestCase {

    private JournalkostenManagerImpl manager = null;
    private JournalkostenDao journalkostenDao = null;
    private JournalDao journalDao = null;
    private WechselkursDao wechselkursDao = null;

    @Before
    public void setUp(){
        journalkostenDao = context.mock(JournalkostenDao.class);
        journalDao = context.mock(JournalDao.class);
        wechselkursDao = context.mock(WechselkursDao.class);
        manager = new JournalkostenManagerImpl(journalkostenDao, wechselkursDao, journalDao);
    }

    @After
    public void tearDown(){
        manager = null;
    }

    @Test
    public void testGetProjektkosten() {
        log.debug("testing get...");

        final Long id = 7L;
        final Journalkosten journalkosten = new Journalkosten();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(journalkostenDao).get(with(equal(id)));
            will(returnValue(journalkosten));
        }});

        Journalkosten result = manager.get(id);
        assertSame(journalkosten, result);
    }

    @Test
    public void testRemoveProjektkosten() {
        log.debug("testing remove...");

        final Long id= 1L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(journalkostenDao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }

}
