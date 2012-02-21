package ejportal.service.impl;

import ejportal.dao.BestellerDao;
import ejportal.dao.InstitutionDao;
import ejportal.dao.InteresseDao;
import ejportal.dao.SigelDao;
import ejportal.model.Besteller;
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
 * Date: 09.08.2010
 * Time: 16:33:14
 * To change this template use File | Settings | File Templates.
 */
public class BestellerManagerImplTest extends BaseManagerMockTestCase {
    private BestellerManagerImpl manager = null;
    private BestellerDao bestellerDao = null;
    private InteresseDao interesseDao = null;
    private SigelDao sigelDao = null;

    @Before
    public void setUp(){
        bestellerDao = context.mock(BestellerDao.class);
        interesseDao = context.mock(InteresseDao.class);
        sigelDao = context.mock(SigelDao.class);
        manager = new BestellerManagerImpl(bestellerDao, interesseDao, sigelDao);
    }
    
    @After
    public void tearDown() {
        manager = null;
    }
    
    @Test
    public void testGetBesteller() {
        log.debug("testing get...");

        final Long id = 7L;
        final Besteller besteller = new Besteller();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(bestellerDao).get(with(equal(id)));
            will(returnValue(besteller));
        }});

        Besteller result = manager.get(id);
        assertSame(besteller, result);
    }

    @Test
    public void testGetBestellers() {
        log.debug("testing getAll...");

        final List bestellers = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(bestellerDao).getAll();
            will(returnValue(bestellers));
        }});

        List result = manager.getAll();

        assertSame(bestellers, result);
    }

    @Test
    public void testSaveBesteller() {
        log.debug("testing save...");

        final Besteller besteller = new Besteller();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(bestellerDao).save(with(same(besteller)));
        }});

        manager.save(besteller);
    }

    @Test
    public void testRemoveBesteller() {
        log.debug("testing remove...");

        final Long id = 1L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(bestellerDao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
}
