package ejportal.webapp.action;

import ejportal.service.InstitutionManager;
import ejportal.service.dto.InstitutionSearchTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 29.06.2010
 * Time: 13:09:46
 * To change this template use File | Settings | File Templates.
 */
public class InstitutionListAction extends JournalBaseAction{
    private InstitutionManager institutionManager;
    private InstitutionSearchTO institutionSearchTO;
    private List institutions;

    //fuer die Suche
    String institutionName;
    Long exemplarId;

    public Long getExemplarId() {
        return exemplarId;
    }

    public void setExemplarId(Long exemplarId) {
        this.exemplarId = exemplarId;
    }

    public void setInstitutionManager(InstitutionManager institutionManager) {
        this.institutionManager = institutionManager;
    }

    public String listAll() {
        institutions = institutionManager.getAll();
        return SUCCESS;
    }

    public List getInstitutions() {
        return institutions;
    }


    //Suche
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public InstitutionSearchTO getInstitutionSearchTO() {
        return institutionSearchTO;
    }

    public void setInstitutionSearchTO(InstitutionSearchTO institutionSearchTO) {
        this.institutionSearchTO = institutionSearchTO;
    }
    
    public String search(){
        int maxResults = 100;
        institutions = institutionManager.search(institutionSearchTO, maxResults);
        if(institutions.size() == maxResults){
            saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als " + institutions.size() + " Institutionen gefunden wurden.");
            saveMessage("Die ersten " + maxResults + " Ergebnisse werden angezeigt.");
        }
        //TODO Fehlerbehandlung
        return SUCCESS;
    }    

    //fuer neue Zuweisung zu Journal
    public void setJournalId(long journalId) {
        this.journalId = journalId;
    }





}
