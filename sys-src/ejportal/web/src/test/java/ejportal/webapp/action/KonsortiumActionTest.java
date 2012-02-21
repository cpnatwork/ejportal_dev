package ejportal.webapp.action;

import ejportal.model.Konsortium;
import ejportal.service.KonsortiumManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 03.08.2010
 * Time: 16:04:03
 * To change this template use File | Settings | File Templates.
 */

public class KonsortiumActionTest extends BaseActionTestCase {
    private KonsortiumDetailAction action;

    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new KonsortiumDetailAction();
        KonsortiumManager konsortiumManager = (KonsortiumManager) applicationContext.getBean("konsortiumManager");

        action.setKonsortiumManager(konsortiumManager);

        // add a test Konsortium to the database
        Konsortium konsortium = new Konsortium();
        konsortium.setKonsortiumName("TestKonsortium");
        konsortiumManager.save(konsortium);
    }



    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setKonsortiumId(1L);
        assertNull(action.getKonsortium());
        assertEquals("edit", action.edit());
        assertNotNull(action.getKonsortium());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setKonsortiumId(1L);
        assertEquals("edit", action.edit());
        assertNotNull(action.getKonsortium());

        // update Name and save
        action.getKonsortium().setKonsortiumName("Updated Name");
        assertEquals("success", action.save());
        assertEquals("Updated Name", action.getKonsortium().getKonsortiumName());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Konsortium Konsortium = new Konsortium();
        Konsortium.setKonsortiumId(2L);
        //action.setKonsortium(Konsortium);
        action.setKonsortiumId(2L);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
