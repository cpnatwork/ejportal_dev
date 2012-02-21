package ejportal.webapp.action;

import ejportal.service.JournalManager;
import ejportal.service.dto.JournalSearchTO;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 24.06.2010
 * Time: 14:29:00
 * To change this template use File | Settings | File Templates.
 */
public class JournalListAction extends BaseAction {
    private JournalManager journalManager;
    private JournalSearchTO journalSearchTO;
    private List journals;
    private int verlagId;

    private Date maxDate = new Date();
    private int maxDateParam;
    private SelectData selectData=new SelectData();

    public void setJournalManager(JournalManager journalManager) {
        this.journalManager = journalManager;
    }

    public String listAll() {
        journals = journalManager.getAll();
        return SUCCESS;
    }

     public String listBearbeitungsdatum() {
         switch (maxDateParam){
             case 7:   journals = journalManager.findByBearbeitungsdatum(addDates(7));break;
             case 14:  journals = journalManager.findByBearbeitungsdatum(addDates(14));break;
             default:  journals = journalManager.findByBearbeitungsdatum(addDates(14));
         }
        return SUCCESS;
    }

    public String listBearbeitungsdatumAll(){
        journals = journalManager.findByBearbeitungsdatumAll();
        return SUCCESS;
    }

    private Date addDates(int i){
        // Get a Calendar for current locale and time zone
        Calendar cal = Calendar.getInstance();
        // Get a Date object that represents 30 days from now
        Date today = new Date();                   // Current date
        cal.setTime(today);                        // Set it in the Calendar object
        cal.add(Calendar.DATE, i);                // Add 30 days
        return cal.getTime();           // Retrieve the resulting date
    }

    public List getJournals() {
        return journals;
    }


    //Journal Suche
    public JournalSearchTO getJournalSearchTO() {
        return journalSearchTO;
    }

    public void setJournalSearchTO(JournalSearchTO journalSearchTO) {
        this.journalSearchTO = journalSearchTO;
    }

    public String search(){
        log.debug(">>> JournalListAction.search: journalSearchTO="+journalSearchTO.toString());
        int maxResults = 100;
        journals = journalManager.search(journalSearchTO, maxResults);
        if(journals.size() == maxResults){
            saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als " + journals.size() + " Journale gefunden wurden.");
            saveMessage("Die ersten " + maxResults + " Ergebnisse werden angezeigt.");
        }

        //TODO Fehlerbehandlung
        return SUCCESS;
    }


    //Journals nach Institution
    public void setVerlagId(int verlagId) {
        this.verlagId = verlagId;
    }

    public String listByVerlag() {
        journals = journalManager.findByVerlagId(verlagId);
        return SUCCESS;
    }


    //Bearbeitungsdatum

    public Date getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public int getMaxDateParam() {
        return maxDateParam;
    }

    public void setMaxDateParam(int maxDateParam) {
        this.maxDateParam = maxDateParam;
    }
    
    //Dropdown Zugang über

    public Map<String, String> getListZugangUeber() {
        return selectData.getJournalZugangUeber();
    }
}
