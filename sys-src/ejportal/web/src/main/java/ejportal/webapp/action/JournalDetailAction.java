package ejportal.webapp.action;

import ejportal.service.JournalManager;
import ejportal.service.dto.JournalBaseTO;
import ejportal.model.Journal;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 14.06.2010
 * Time: 14:19:28
 * To change this template use File | Settings | File Templates.
 */

public class JournalDetailAction extends JournalBaseAction {
    private JournalManager journalManager;
    private Journal journal;
    private JournalBaseTO journalBaseTO;
    private SelectData selectData = new SelectData();

       /*
//Zugriff auf die journalId (fuer das Menue)
    public long getJournalId(){
        //bei Journal bearbeiten gibt es kein journal sondern nur eine journalBaseTO
        if (journalBaseTO !=null && journalBaseTO.getId() !=null){
               return journalBaseTO.getId();
        }
        return journal.getId();
    }

    public void setId(Long journalId) {
        this.journalId = journalId;
    }

    public Long getId() {
        return journalId;
    }
*/

    
    //Dropdown lists

    public Map<String, String> getListZugangUeber() {
        return selectData.getJournalZugangUeber();
    }

    public Map<String, String> getListNutzungsbestimmungen() {
        return selectData.getJournalNutzungsbestimmungen();
    }

    public Map<String, String> getListStatus() {
        return selectData.getJournalStatus();
    }      



    //Verlag aendern
    private long verlagId;

    public void setJournalManager(JournalManager journalManager) {
        this.journalManager = journalManager;
    }

    //Provider aendern
    private long providerId;

    //Konsortium aendern
    private long konsortiumId;

    //Paket aendern
    private long paketId;

    //Fach aendern
    private long fachId;

    //Bibliotheksmitarbeiter ändern
    private long bibId;


    public List getFaecher() {
        List retVal = new ArrayList();
        // FIXME org.hibernate.LazyInitializationException
//        Hibernate.initialize(getJournal().getFaecher());
//        retVal = getJournal().getFaecher();
        return retVal;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public JournalBaseTO getJournalBaseTO() {
        return journalBaseTO;
    }

    public void setJournalBaseTO(JournalBaseTO journalBaseTO) {
        this.journalBaseTO = journalBaseTO;
    }

    //TODO Die naechsten beiden Methoden sind Pfusch...da sollten wir uns was schoeneres ueberlegen.

    /**public String changeVerlag(){
        getSession().setAttribute("journalid",journalId);
        return "selectVerlag";
    }

    public void setVerlagById(long verlagId){
        this.journalId = (Long) getSession().getAttribute("journalid");
        getSession().removeAttribute("journalid");
        journalManager.connectJournalVerlag(this.journalId, verlagId);
    }
    **/

    public String delete() {
        try {
            journalManager.remove(journalId);
            saveMessage(getText("journal.deleted"));
        }
        catch (DataIntegrityViolationException dive){
            saveMessage("Dieses Journal wird noch verwendet und kann deshalb nicht entfernt werden.");
            return ERROR;
        }
        
        return SUCCESS;
    }

    public String load(){
        log.debug(">>> JournalDetailAction.load: journalId="+journalId);
        if (journalId != null) {
            journal = journalManager.get(journalId);
        } else {
            return ERROR;
        }

        return SUCCESS;

    }

    //TODO edit + save evtl in eigene Action? JournalEditAction?
    public String edit() {
        log.debug(">>> JournalDetailAction.edit: journalId"+journalId);
        if (journalId != null) {
            journalBaseTO = journalManager.getJournalBaseTO(journalId);

        } else {
            journalBaseTO = new JournalBaseTO();
        }

        return "edit";
    }

    public String save() throws Exception {
        log.debug(">>> JournalDetailAction.save: journalId"+journalId);
        if (cancel != null) {
            return CANCEL;
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (journalBaseTO.getId() == null);

        //Prüfen, ob Titel angegeben worden ist.
        if (journalBaseTO.getTitel().compareTo("") == 0) {
            saveMessage(getText("Geben Sie einen Titel ein!"));
            return "back";
        }
        if(journalBaseTO.getTitel().length() > 254){
            saveMessage(getText("Geben Sie bitte einen kürzeren Titel ein!"));
            return "back";
        }
        

        if (isNew){ // Create
            journal = journalManager.create(journalBaseTO);              
        }
        else{ // Update
            journal = journalManager.saveBaseTO(journalBaseTO);           
        }
        String key = (isNew) ? "journal.added" : "journal.updated";
        saveMessage(getText(key));

        //journalId setzen
        this.journalId=journal.getId();

        /**
        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
         **/

    return SUCCESS;
    }

    
    //Verlag aendern

    public void setVerlagId(long verlagId) {
        this.verlagId = verlagId;
    }

    public String changeVerlag(){
        journalManager.connectJournalVerlag(this.journalId, this.verlagId);
        load();
        saveMessage("Verlag wurde neu zugewiesen.");
        return SUCCESS;
    }
    //Provider aendern

    public void setProviderId(long providerId) {
        this.providerId = providerId;
    }

    public String changeProvider(){
        journalManager.connectJournalProvider(this.journalId, this.providerId);
        load();
        saveMessage("Provider wurde neu zugewiesen.");
        return SUCCESS;
    }

    //Konsortium aendern

    public void setKonsortiumId(long konsortiumId) {
        this.konsortiumId = konsortiumId;
    }

    public String changeKonsortium(){
        journalManager.connectJournalKonsortium(this.journalId, this.konsortiumId);
        load();
        saveMessage("Konsortium wurde neu zugewiesen.");
        return SUCCESS;
    }
        //Paket aendern

    public void setPaketId(long paketId) {
        this.paketId = paketId;
    }

    public String changePaket(){
        journalManager.connectJournalPaket(this.journalId, this.paketId);
        load();
        saveMessage("Paket wurde neu zugewiesen.");
        return SUCCESS;
    }

    //Bibliotheksmitarbeiter aendern

    public void setBibId(long bibId) {
        this.bibId = bibId;
    }

    public String changeBibliotheksmitarbeiter(){
        journalManager.connectJournalBibliotheksmitarbeiter(this.journalId, this.bibId);
        load();
        saveMessage("Bibliothek wurde neu zugewiesen.");
        return SUCCESS;
    }

      //Fach aendern

    public void setFachId(long fachId) {
        this.fachId = fachId;
    }

    public long getFachId() {
        return fachId;
    }

    public String changeFach(){
        if(!journalManager.connectJournalFach(this.journalId, this.fachId)){
            saveMessage("Das Fach ist bereits vorhanden.");
        }
        else{
            saveMessage("Das Fach wurde erfolgreich hinzugefügt.");       
        }
        load();
        return SUCCESS;
    }

    //ein Fach vom Journal abhängen
    public String dropFach(){
        if(!journalManager.disconnectJournalFach(this.journalId, this.fachId)){
            saveMessage("Die Zuordnung des Fachs wurde erfolgreich aufgehoben.");
        }
        load();
        return SUCCESS;
    }
}
