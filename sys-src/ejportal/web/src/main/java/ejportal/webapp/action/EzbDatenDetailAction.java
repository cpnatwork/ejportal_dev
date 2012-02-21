package ejportal.webapp.action;

import ejportal.model.EzbDaten;
import ejportal.service.EzbDatenManager;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 09.08.2010
 * Time: 17:54:57
 * To change this template use File | Settings | File Templates.
 */
public class EzbDatenDetailAction extends JournalBaseAction{
    private EzbDatenManager ezbDatenManager;
    private EzbDaten ezbDaten;
    private Long ezbId;



    public void setEzbDatenManager(EzbDatenManager ezbDatenManager) {
        this.ezbDatenManager = ezbDatenManager;
    }

    public EzbDaten getEzbDaten() {
        return ezbDaten;
    }

    public void setEzbDaten(EzbDaten ezbDaten) {
        this.ezbDaten = ezbDaten;
    }

    public Long getEzbId() {
        return ezbId;
    }

    public void setEzbId(Long ezbId) {
        this.ezbId = ezbId;
    }



    public String loadWithJournalId(){
        if (journalId != null) {
            ezbDaten = ezbDatenManager.loadWithJournalId(journalId);
        } else {
            return ERROR;
        }

        return SUCCESS;
    }

    public String changeEzbDaten(){
        ezbDatenManager.connectEzbDaten(this.ezbId, this.journalId);
        loadWithJournalId();
        saveMessage("EZB Daten wurden neu zugewiesen.");
        return SUCCESS;
    }

    public String importEzbDaten(){
        journalId = ezbDatenManager.createJournal(this.ezbId).getId();
        return SUCCESS;
    }

}

