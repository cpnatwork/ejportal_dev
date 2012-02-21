package ejportal.webapp.action;

import ejportal.model.Fach;
import ejportal.service.FachManager;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by IntelliJ IDEA.
 * User: ev55esul
 * Date: 05.08.2010
 * Time: 17:55:06
 * To change this template use File | Settings | File Templates.
 */
public class FachDetailAction extends BaseAction {
    private FachManager fachManager;
    private Fach fach;
    private Long fachId;

    public void setFachManager(FachManager fachManager) {
        this.fachManager = fachManager;
    }

    public Fach getFach() {
        return fach;
    }

    public void setFach(Fach fach) {
        this.fach = fach;
    }

    public long getFachId() {
        return fachId;
    }

    public void setFachId(Long fachId) {
        this.fachId = fachId;
    }

    public String delete() {
        try {
            fachManager.remove(fachId);
            saveMessage(getText("Fach wurde erfolgreich entfernt."));
        }
        catch (DataIntegrityViolationException dive) {
            saveMessage("Dieses Fach wird noch verwendet und kann deshalb nicht entfernt werden.");
            return ERROR;
        }

        return SUCCESS;
    }

    public String load(){
        if (fachId != null) {
            fach = fachManager.get(fachId);
        } else {
            return ERROR;
        }

        return SUCCESS;

    }

    public String edit() {
        if (fachId != null) {
            fach = fachManager.get(fachId);
        } else {
            fach = new Fach();
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

        boolean isNew = (fach.getFachId() == null);

        //Prüfen, ob Fachname angegeben worden ist.
        if (fach.getFachName().compareTo("") == 0) {
            saveMessage(getText("Geben Sie einen Fachnamen ein!"));
            return "back";
        }
        if(fach.getFachName().length() > 254){
            saveMessage(getText("Geben Sie bitte einen kürzeren Fachnamen ein!"));
            return "back";
        }
/*        if (isNew){ //create
            fach = fachManager.save(fach);
        }
        else{ //update
            fach = fachManager.save(fach);
        }*/

        fach = fachManager.save(fach);

        String key = (isNew) ? "Fach wurde erfolgreich erstellt." : "Fach wurde erfolgreich aktualisiert.";
        saveMessage(getText(key));

        return SUCCESS;
    }
}
