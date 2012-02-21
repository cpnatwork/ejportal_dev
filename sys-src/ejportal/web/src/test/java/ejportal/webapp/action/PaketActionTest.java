package ejportal.webapp.action;

import ejportal.model.Paket;
import ejportal.service.PaketManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 03.08.2010
 * Time: 11:34:17
 * To change this template use File | Settings | File Templates.
 */
public class PaketActionTest extends BaseActionTestCase {
    private PaketDetailAction action;

    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new PaketDetailAction();
        PaketManager paketManager = (PaketManager) applicationContext.getBean("paketManager");

        action.setPaketManager(paketManager);

        // add a test paket to the database
        Paket paket = new Paket();
        paket.setPaketName("TestPaket");
        paketManager.save(paket);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setPaketId(1L);
        assertNull(action.getPaket());
        assertEquals("edit", action.edit());
        assertNotNull(action.getPaket());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setPaketId(1L);
        assertEquals("edit", action.edit());
        assertNotNull(action.getPaket());

        // update Paketname and save
        action.getPaket().setPaketName("Updated Name");
        assertEquals("success", action.save());
        assertEquals("Updated Name", action.getPaket().getPaketName());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }


    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Paket paket = new Paket();
        paket.setPaketId(2L);
        //action.setPaket(paket);
        action.setPaketId(2L);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
