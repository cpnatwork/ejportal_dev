package ejportal.webapp.action;

import ejportal.model.Exemplar;
import ejportal.model.Journal;
import ejportal.service.ExemplarManager;
import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 05.08.2010
 * Time: 13:55:01
 * To change this template use File | Settings | File Templates.
 */
public class ExemplarActionTest extends BaseActionTestCase {
    private ExemplarDetailAction action;

    @Override
    protected void onSetUpBeforeTransaction() throws Exception {
        super.onSetUpBeforeTransaction();
        action = new ExemplarDetailAction();
        ExemplarManager exemplarManager = (ExemplarManager) applicationContext.getBean("exemplarManager");

        action.setExemplarManager(exemplarManager);

        Journal journal = new Journal();
        journal.setId(1L);

        // add a test exemplar to the database
        Exemplar exemplar = new Exemplar();
        exemplar.setForm("TestForm");
        exemplar.setBestellnummer("BestNr");
        exemplar.setJournal(journal);
        exemplarManager.save(exemplar);
    }



    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setExemplarId(1L);
        assertNull(action.getExemplar());
        assertEquals("edit", action.edit());
        assertNotNull(action.getExemplarBaseTO());
        assertFalse(action.hasActionErrors());
    }
    
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setExemplarId(1L);
        assertEquals("edit", action.edit());
        assertNotNull(action.getExemplarBaseTO());

        // update Name and save
        action.getExemplarBaseTO().setForm("Updated Form");
        assertEquals("success", action.save());
        assertEquals("Updated Form", action.getExemplarBaseTO().getForm());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Exemplar exemplar = new Exemplar();
        exemplar.setExemplarId(2L);
        //action.setExemplar(exemplar);
        action.setExemplarId(2L);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}
