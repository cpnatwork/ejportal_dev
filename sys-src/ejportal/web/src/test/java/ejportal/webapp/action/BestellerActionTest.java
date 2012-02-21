package ejportal.webapp.action;

import ejportal.model.Besteller;
import ejportal.model.Sigel;
import ejportal.service.BestellerManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 10.08.2010
 * Time: 11:14:10
 * To change this template use File | Settings | File Templates.
 */
public class BestellerActionTest extends BaseActionTestCase {
    private BestellerAction action;

    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new BestellerAction();
        BestellerManager bestellerManager = (BestellerManager) applicationContext.getBean("bestellerManager");

        action.setBestellerManager(bestellerManager);

        Sigel sigel= new Sigel();
        sigel.setSigelId(1L);

        // add a test besteller to the database
        Besteller besteller = new Besteller();
        besteller.setBestellerName("BestActionTestName");
        besteller.setAnrede("Herr Prof. Dr.");
        besteller.setSigel(sigel);
        bestellerManager.save(besteller);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setBestellerId(1L);
        assertNull(action.getBesteller());
        assertEquals("edit", action.edit());
        assertNotNull(action.getBestellerBaseTO());
        assertFalse(action.hasActionErrors());
    }
    
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setBestellerId(1L);
        assertEquals("edit", action.edit());
        assertNotNull(action.getBestellerBaseTO());

        // update Name and save
        action.getBestellerBaseTO().setBestellerName("Updated Name");
        assertEquals("success", action.save());
        assertEquals("Updated Name", action.getBestellerBaseTO().getBestellerName());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Besteller besteller = new Besteller();
        besteller.setBestellerId(2L);
        //action.setBesteller(besteller);
        action.setBestellerId(2L);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
