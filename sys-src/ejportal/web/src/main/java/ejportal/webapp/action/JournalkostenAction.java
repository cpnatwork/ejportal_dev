package ejportal.webapp.action;

import ejportal.model.Journalkosten;
import ejportal.service.JournalkostenManager;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 09.08.2010
 * Time: 16:01:26
 * To change this template use File | Settings | File Templates.
 */
public class JournalkostenAction extends JournalBaseAction  {

    private JournalkostenManager journalkostenManager;
    private Journalkosten journalkosten;
    private Long journalkostenId;
    private SelectData selectData = new SelectData();


    /* GETTER UND SETTER */
    public JournalkostenManager getJournalkostenManager() {
        return journalkostenManager;
    }

    public void setJournalkostenManager(JournalkostenManager journalkostenManager) {
        this.journalkostenManager = journalkostenManager;
    }

    public Journalkosten getJournalkosten() {
        return journalkosten;
    }

    public void setJournalkosten(Journalkosten journalkosten) {
        this.journalkosten = journalkosten;
    }

    public Long getJournalkostenId() {
        return journalkostenId;
    }

    public void setJournalkostenId(Long journalkostenId) {
        this.journalkostenId = journalkostenId;
    }

    // Lists
    public Map<String, String> getListWaehrung() {
        return selectData.getProjektWaehrung();
    }

    public Map<String, String> getListMwSt() {
        return selectData.getProjektMwSt();
    }


    // CRUD
   public String edit() {

       journalkosten = journalkostenManager.findByJournalId(journalId);

       return "edit";
   }

   public String save() throws Exception {
       if (cancel != null) {
           return CANCEL;
       }

       journalkosten = journalkostenManager.saveWithJournal(journalkosten, journalId);

       saveMessage("Journalkosten wurden erfolgreich aktualisiert.");

       return SUCCESS;
   }


}
