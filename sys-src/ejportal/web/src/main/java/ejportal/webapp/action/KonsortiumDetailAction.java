package ejportal.webapp.action;

import ejportal.model.Konsortium;
import ejportal.service.KonsortiumManager;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 03.08.2010
 * Time: 14:14:45
 * To change this template use File | Settings | File Templates.
 */
public class KonsortiumDetailAction extends BaseAction{
    private KonsortiumManager konsortiumManager;
    private Konsortium konsortium;
    private Long konsortiumId;


    public void setKonsortiumManager(KonsortiumManager konsortiumManager) {
        this.konsortiumManager = konsortiumManager;
    }

    public Konsortium getKonsortium() {
        return konsortium;
    }

    public void setKonsortium(Konsortium konsortium) {
        this.konsortium = konsortium;
    }

    public Long getKonsortiumId() {
        return konsortiumId;
    }

    public void setKonsortiumId(Long konsortiumId) {
        this.konsortiumId = konsortiumId;
    }

    public String delete() {
        try{
            konsortiumManager.remove(konsortiumId);
            saveMessage(getText("Konsortium wurde erfolgreich entfernt."));

        }

        catch (DataIntegrityViolationException dive){

            saveMessage("Dieses Konsortium wird noch verwendet und kann deshalb nicht entfernt werden.");
            return ERROR;
        }

        return SUCCESS;
    }

    public String load(){
        if (konsortiumId != null) {
            konsortium = konsortiumManager.get(konsortiumId);
        } else {
            return ERROR;
        }

        return SUCCESS;

    }

    public String edit() {
        if (konsortiumId != null) {
            konsortium = konsortiumManager.get(konsortiumId);
        } else {
            konsortium = new Konsortium();
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

        boolean isNew = (konsortium.getKonsortiumId() == null);

        //Prüfen, ob Konsortiumname angegeben worden ist.
        if (konsortium.getKonsortiumName().compareTo("") == 0) {
            saveMessage(getText("Geben Sie einen Konsortiumnamen ein!"));
            return "back";
        }
        if(konsortium.getKonsortiumName().length() > 254){
            saveMessage(getText("Geben Sie bitte einen kürzeren Namen ein!"));
            return "back";
        }


        /*if (isNew){ //create
            konsortium = konsortiumManager.save(konsortium);
        }
        else{ //update
            konsortium = konsortiumManager.save(konsortium);
        }*/

        konsortium = konsortiumManager.save(konsortium);

        String key = (isNew) ? "Konsortium wurde erfolgreich erstellt." : "Konsortium wurde erfolgreich aktualisiert.";
        saveMessage(key);

    return SUCCESS;
    }
}
