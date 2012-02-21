package ejportal.webapp.action;

import ejportal.model.Journal;
import ejportal.model.Nutzung;
import ejportal.service.NutzungManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 10.08.2010
 * Time: 11:59:42
 * To change this template use File | Settings | File Templates.
 */
public class NutzungActionTest extends BaseActionTestCase{
    private NutzungAction action;

    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new NutzungAction();
        NutzungManager nutzungManager = (NutzungManager) applicationContext.getBean("nutzungManager");

        action.setNutzungManager(nutzungManager);

        Journal journal = new Journal();
        journal.setId(1L);

        // add a test exemplar to the database
        Nutzung nutzung = new Nutzung();
        nutzung.setZugriffe(4);
        nutzung.setZeitraum(5);
        nutzung.setJournal(journal);
        nutzungManager.save(nutzung);
    }



    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setNutzungId(1L);
        assertEquals("edit", action.edit());
        assertFalse(action.hasActionErrors());
    }

    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setNutzungId(1L);
        assertEquals("edit", action.edit());
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Nutzung nutzung = new Nutzung();
        nutzung.setNutzungId(2L);
        action.setNutzungId(2L);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
