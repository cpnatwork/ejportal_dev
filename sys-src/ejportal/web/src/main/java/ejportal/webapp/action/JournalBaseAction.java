package ejportal.webapp.action;

import ejportal.service.JournalManager;
import ejportal.service.JournalTitelService;

/**
 * Created by IntelliJ IDEA.
 * User: florian
 * Date: 11.08.2010
 * Time: 13:20:53
 * To change this template use File | Settings | File Templates.
 */
public class JournalBaseAction extends BaseAction{
    private JournalTitelService journalTitelService;
    protected Long journalId;

    public long getJournalId() {
        return journalId;
    }

    public void setJournalId(long journalId) {
        this.journalId = journalId;
    }

    public void setJournalTitelService(JournalTitelService journalTitelService) {
        this.journalTitelService = journalTitelService;
    }

    public String getTitel(){
         return journalTitelService.getTitel(journalId);
    }

}
