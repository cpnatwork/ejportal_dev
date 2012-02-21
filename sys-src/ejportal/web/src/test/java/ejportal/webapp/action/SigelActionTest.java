package ejportal.webapp.action;

import ejportal.model.Sigel;
import ejportal.service.SigelManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 04.08.2010
 * Time: 14:48:55
 * To change this template use File | Settings | File Templates.
 */
public class SigelActionTest extends BaseActionTestCase {
    private SigelDetailAction action;

    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new SigelDetailAction();
        SigelManager sigelManager = (SigelManager) applicationContext.getBean("sigelManager");

        action.setSigelManager(sigelManager);

        // add a test sigel to the database
        Sigel sigel = new Sigel();
        sigel.setName("TestSigel");
        sigelManager.save(sigel);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setSigelId(1L);
        assertNull(action.getSigel());
        assertEquals("edit", action.edit());
        assertNotNull(action.getSigel());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setSigelId(1L);
        assertEquals("edit", action.edit());
        assertNotNull(action.getSigel());

        // update Sigelname and save
        action.getSigel().setName("Updated Name");
        assertEquals("success", action.save());
        assertEquals("Updated Name", action.getSigel().getName());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }


    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Sigel sigel = new Sigel();
        sigel.setSigelId(2L);
        //action.setSigel(sigel);
        action.setSigelId(2L);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
