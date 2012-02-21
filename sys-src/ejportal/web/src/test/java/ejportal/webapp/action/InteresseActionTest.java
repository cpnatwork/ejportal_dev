package ejportal.webapp.action;

import ejportal.model.Interesse;
import ejportal.model.Journal;
import ejportal.service.InteresseManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 10.08.2010
 * Time: 11:46:42
 * To change this template use File | Settings | File Templates.
 */
public class InteresseActionTest extends BaseActionTestCase {
    private InteresseAction action;

    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new InteresseAction();
        InteresseManager interesseManager = (InteresseManager) applicationContext.getBean("interesseManager");

        action.setInteresseManager(interesseManager);

        Journal journal= new Journal();
        journal.setId(1L);

        // add a test interesse to the database
        Interesse interesse = new Interesse();
        interesse.setInteresse("BestActionTestInteresse");
        interesse.setJournal(journal);
        interesseManager.save(interesse);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setInteresseId(1L);
        assertNull(action.getInteresse());
        assertEquals("edit", action.edit());
        assertNotNull(action.getInteresseBaseTO());
        assertFalse(action.hasActionErrors());
    }
    
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setInteresseId(1L);
        assertEquals("edit", action.edit());
        assertNotNull(action.getInteresseBaseTO());

        // update Name and save
        action.getInteresseBaseTO().setInteresse("Updated Interesse");
        assertEquals("success", action.save());
        assertEquals("Updated Interesse", action.getInteresseBaseTO().getInteresse());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Interesse interesse = new Interesse();
        interesse.setInteresseId(2L);
        //action.setInteresse(interesse);
        action.setInteresseId(2L);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
