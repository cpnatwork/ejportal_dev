package ejportal.webapp.action;

import ejportal.model.Exemplar;
import ejportal.model.Rechnung;
import ejportal.service.RechnungManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 09.08.2010
 * Time: 17:02:25
 * To change this template use File | Settings | File Templates.
 */
public class RechnungActionTest extends BaseActionTestCase {
    private RechnungAction action;

    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new RechnungAction();
        RechnungManager rechnungManager = (RechnungManager) applicationContext.getBean("rechnungManager");

        action.setRechnungManager(rechnungManager);

        Exemplar exemplar = new Exemplar();
        exemplar.setExemplarId(1L);

        // add a test rechnung to the database
        Rechnung rechnung = new Rechnung();
        rechnung.setBetrag(55.55F);
        rechnung.setBezugsjahr("2009");
        rechnung.setExemplar(exemplar);
        rechnungManager.save(rechnung);
    }


    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setRechnungId(1L);
        assertNull(action.getRechnung());
        assertEquals("edit", action.edit());
        assertNotNull(action.getRechnungBaseTO());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setRechnungId(1L);
        assertEquals("edit", action.edit());
        assertNotNull(action.getRechnungBaseTO());

        // update bezugsform and save
        action.getRechnungBaseTO().setBezugsform("Updated Bezugsform");
        assertEquals("success", action.save());
        assertEquals("Updated Bezugsform", action.getRechnungBaseTO().getBezugsform());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Rechnung rechnung = new Rechnung();
        rechnung.setRechnungId(2L);
        //action.setRechnung(rechnung);
        action.setRechnungId(2L);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
