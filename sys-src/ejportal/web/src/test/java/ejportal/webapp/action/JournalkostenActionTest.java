package ejportal.webapp.action;

import ejportal.model.Journalkosten;
import ejportal.service.JournalkostenManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 12.08.2010
 * Time: 12:28:05
 * To change this template use File | Settings | File Templates.
 */
public class JournalkostenActionTest  extends BaseActionTestCase {

    private JournalkostenAction action;

    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new JournalkostenAction();
        JournalkostenManager journalkostenManager = (JournalkostenManager) applicationContext.getBean("journalkostenManager");

        action.setJournalkostenManager(journalkostenManager);

        // add a test Journalkosten to the database
        Journalkosten journalkosten= new Journalkosten();
        journalkosten.setOPreisPO((long)123.23);
        journalkostenManager.save(journalkosten);
    }

    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setJournalkostenId(1L);
        action.setJournalId(1L);
        assertNull(action.getJournalkosten());
        assertEquals("edit", action.edit());
        assertNotNull(action.getJournalkosten());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setJournalkostenId(1L);
        action.setJournalId(1L);
        assertEquals("edit", action.edit());
        assertNotNull(action.getJournalkosten());

        // update Journalkosten and save
        action.getJournalkosten().setOPreisPO((long)123.23);
        assertEquals("success", action.save());
        assertEquals((long)123.23, (long)action.getJournalkosten().getOPreisPO());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

}
