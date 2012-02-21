package ejportal.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import ejportal.service.JournalManager;
import org.apache.struts2.ServletActionContext;
import ejportal.model.Journal;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 14.06.2010
 * Time: 14:19:28
 * To change this template use File | Settings | File Templates.
 */

public class JournalActionTest extends BaseActionTestCase {
    private JournalDetailAction action;

    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new JournalDetailAction();
        JournalManager journalManager = (JournalManager) applicationContext.getBean("journalManager");
        
        action.setJournalManager(journalManager);

        // add a test journal to the database
        Journal journal = new Journal();
        journal.setTitel("TestJournal");
        journal.setKurztitel("TJ");
        journalManager.save(journal);
    }

   

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setJournalId(1L);
        assertNull(action.getJournal());
        assertEquals("edit", action.edit());
        assertNotNull(action.getJournalBaseTO());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setJournalId(1L);
        assertEquals("edit", action.edit());
        assertNotNull(action.getJournalBaseTO());

        // update Kurztitel and save
        action.getJournalBaseTO().setTitel("Updated Kurztitel");
        assertEquals("success", action.save());
        assertEquals("Updated Kurztitel", action.getJournalBaseTO().getTitel());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Journal journal = new Journal();
        journal.setId(2L);
        //action.setJournal(journal);
        action.setJournalId(2L);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
