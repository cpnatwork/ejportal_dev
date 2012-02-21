package ejportal.webapp.action;

import ejportal.model.Institution;
import ejportal.service.InstitutionManager;
import ejportal.service.dto.InstitutionBaseTO;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 06.07.2010
 * Time: 22:32:43
 * To change this template use File | Settings | File Templates.
 */
public class InstitutionDetailAction extends BaseAction {
    private InstitutionManager institutionManager;
    private Institution institution;
    private InstitutionBaseTO institutionBaseTO;
    private Long id;
    private SelectData selectData = new SelectData();

    //Dropdown lists
    public Map<String, String> getListLizenzArt() {
        return selectData.getInstitutionLizenzArt();
    }

    public Map<String, String> getListZugang() {
        return selectData.getInstitutionZugang();
    }

    public Map<String, String> getListPersonengruppe() {
        return selectData.getInstitutionPersonengruppe();
    }

    public Map<String, String> getListFernleihe() {
        return selectData.getInstitutionFernleihe();
    }

    public Map<String, String> getListBestellsprache() {
        return selectData.getInstitutionBestellsprache();
    }

    public Map<String, String> getListBestellart() {
        return selectData.getInstitutionBestellart();
    }


    

    
    public void setInstitutionManager(InstitutionManager institutionManager) {
        this.institutionManager = institutionManager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public InstitutionBaseTO getInstitutionBaseTO() {
        return institutionBaseTO;
    }

    public void setInstitutionBaseTO(InstitutionBaseTO institutionBaseTO) {
        this.institutionBaseTO = institutionBaseTO;
    }

    public String delete() {
        try{
            institutionManager.remove(id);
            saveMessage(getText("institution.deleted"));

        }

        catch (DataIntegrityViolationException dive){

            saveMessage("Diese Institution ist noch bei Journalen eingetragen und kann deshalb nicht entfernt werden.");
            return ERROR;
        }

        return SUCCESS;
    }

    public String load(){
        if (id != null) {
            institution = institutionManager.get(id);
        } else {
            return ERROR;
        }

        return SUCCESS;

    }

    public String edit() {
        if (id != null) {
            institutionBaseTO = institutionManager.getInstitutionBaseTO(id);
        } else {
            institutionBaseTO = new InstitutionBaseTO();
        }

        return "edit";
    }

    public String save() throws Exception {
        if (cancel != null) {
            return CANCEL;
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (institutionBaseTO.getId() == null);

        //Prüfen, ob Name der Institution angegeben worden ist.
        if (institutionBaseTO.getName().compareTo("") == 0) {
            saveMessage(getText("Geben Sie einen Namen der Institution ein!"));
            return "back";
        }
        if(institutionBaseTO.getName().length() > 254){
            saveMessage(getText("Geben Sie bitte einen kürzeren Namen ein!"));
            return "back";
        }


        if (isNew){ //create
            institution = institutionManager.create(institutionBaseTO);
        }
        else{ //update
            institution = institutionManager.saveBaseTO(institutionBaseTO);
        }

       // institution =institutionManager.save(institution);
        String key = (isNew) ? "institution.added" : "institution.updated";
        saveMessage(getText(key));
        
        /**
        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
        **/
    return SUCCESS;
    }

}

