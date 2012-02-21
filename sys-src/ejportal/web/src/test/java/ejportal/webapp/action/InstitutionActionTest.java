package ejportal.webapp.action;

import ejportal.model.Institution;
import ejportal.service.InstitutionManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 06.07.2010
 * Time: 21:50:21
 * To change this template use File | Settings | File Templates.
 */
public class InstitutionActionTest extends BaseActionTestCase {
    private InstitutionDetailAction action;

    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new InstitutionDetailAction();
        InstitutionManager institutionManager = (InstitutionManager) applicationContext.getBean("institutionManager");

        action.setInstitutionManager(institutionManager);

        // add a test institution to the database
        Institution institution = new Institution();
        institution.setName("TestInstitution");
        institution.setAbteilung("TI");
        institutionManager.save(institution);
    }



    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setId(1L);
        assertNull(action.getInstitution());
        assertEquals("edit", action.edit());
        assertNotNull(action.getInstitutionBaseTO());
        assertFalse(action.hasActionErrors());
    }
    
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setId(1L);
        assertEquals("edit", action.edit());
        assertNotNull(action.getInstitutionBaseTO());

        // update Name and save
        action.getInstitutionBaseTO().setName("Updated Name");
        assertEquals("success", action.save());
        assertEquals("Updated Name", action.getInstitutionBaseTO().getName());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Institution institution = new Institution();
        institution.setId(2L);
        //action.setInstitution(institution);
        action.setId(2L);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
