package ejportal.webapp.action;

import ejportal.model.Sigel;
import ejportal.service.SigelManager;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 04.08.2010
 * Time: 14:48:20
 * To change this template use File | Settings | File Templates.
 */
public class SigelDetailAction extends BaseAction {
    private SigelManager sigelManager;
    private Sigel sigel;
    private Long sigelId;

    public void setSigelManager(SigelManager sigelManager) {
        this.sigelManager = sigelManager;
    }

    public Sigel getSigel() {
        return sigel;
    }

    public void setSigel(Sigel sigel) {
        this.sigel = sigel;
    }

    public long getSigelId() {
        return sigelId;
    }

    public void setSigelId(Long sigelId) {
        this.sigelId = sigelId;
    }

    public String delete() {
        try {
            sigelManager.remove(sigelId);
            saveMessage(getText("Sigel wurde erfolgreich entfernt."));
        }
        catch (DataIntegrityViolationException dive) {
            saveMessage("Dieses Sigel wird noch verwendet und kann deshalb nicht entfernt werden.");
            return ERROR;
        }

        return SUCCESS;
    }

    public String load(){
        if (sigelId != null) {
            sigel = sigelManager.get(sigelId);
        } else {
            return ERROR;
        }

        return SUCCESS;

    }

    public String edit() {
        if (sigelId != null) {
            sigel = sigelManager.get(sigelId);
        } else {
            sigel = new Sigel();
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

        boolean isNew = (sigel.getSigelId() == null);

        //Prüfen, ob Sigelname angegeben worden ist.
        if (sigel.getName().compareTo("") == 0) {
            saveMessage(getText("Geben Sie einen Sigelnamen ein!"));
            return "back";
        }
        if(sigel.getName().length() > 254){
            saveMessage(getText("Geben Sie bitte einen kürzeren Namen ein!"));
            return "back";
        }

/*        if (isNew){ //create
            paket = paketManager.save(paket);
        }
        else{ //update
            paket = paketManager.save(paket);
        }*/

        sigel = sigelManager.save(sigel);

        String key = (isNew) ? "Sigel wurde erfolgreich erstellt." : "Sigel wurde erfolgreich aktualisiert.";
        saveMessage(getText(key));

        return SUCCESS;
    }
}
