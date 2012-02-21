package ejportal.webapp.action;

import ejportal.model.Paket;
import ejportal.service.PaketManager;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 03.08.2010
 * Time: 12:07:36
 * To change this template use File | Settings | File Templates.
 */
public class PaketDetailAction extends BaseAction {
    private PaketManager paketManager;
    private Paket paket;
    private Long paketId;

    public void setPaketManager(PaketManager paketManager) {
        this.paketManager = paketManager;
    }

    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        this.paket = paket;
    }

    public long getPaketId() {
        return paketId;
    }

    public void setPaketId(Long paketId) {
        this.paketId = paketId;
    }

    public String delete() {
        try {
            paketManager.remove(paketId);
            saveMessage(getText("Paket wurde erfolgreich entfernt."));
        }
        catch (DataIntegrityViolationException dive) {
            saveMessage("Dieses Paket wird noch verwendet und kann deshalb nicht entfernt werden.");
            return ERROR;
        }

        return SUCCESS;
    }

    public String load(){
        if (paketId != null) {
            paket = paketManager.get(paketId);
        } else {
            return ERROR;
        }

        return SUCCESS;

    }

    public String edit() {
        if (paketId != null) {
            paket = paketManager.get(paketId);
        } else {
            paket = new Paket();
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

        boolean isNew = (paket.getPaketId() == null);

        //Prüfen, ob Paketname angegeben worden ist.
        if (paket.getPaketName().compareTo("") == 0) {
            saveMessage(getText("Geben Sie einen Paketnamen ein!"));
            return "back";
        }
        if(paket.getPaketName().length() > 254){
            saveMessage(getText("Geben Sie bitte einen kürzeren Namen ein!"));
            return "back";
        }

/*        if (isNew){ //create
            paket = paketManager.save(paket);
        }
        else{ //update
            paket = paketManager.save(paket);
        }*/

        paket = paketManager.save(paket);

        String key = (isNew) ? "Paket wurde erfolgreich erstellt." : "Paket wurde erfolgreich aktualisiert.";
        saveMessage(getText(key));

        return SUCCESS;
    }
}
