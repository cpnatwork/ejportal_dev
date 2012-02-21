package ejportal.webapp.action;

import ejportal.model.Interesse;
import ejportal.service.InteresseManager;
import ejportal.service.dto.InteresseBaseTO;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 10.08.2010
 * Time: 11:09:43
 * To change this template use File | Settings | File Templates.
 */
public class InteresseAction extends JournalBaseAction{
    private InteresseManager interesseManager;
    private Interesse interesse;
    private InteresseBaseTO interesseBaseTO;

    // IDs für URL
    private Long interesseId;
    private Long bestellerId;

    public Long getInteresseId() {
        return interesseId;
    }

    public void setInteresseId(Long interesseId) {
        this.interesseId = interesseId;
    }

    public Long getBestellerId() {
        return bestellerId;
    }

    public void setBestellerId(Long bestellerId) {
        this.bestellerId = bestellerId;
    }

    // CRUD
    public String delete() {
        interesseManager.remove(interesseId);
        saveMessage("Das Interesse wurde erfolgreich entfernt.");

        return SUCCESS;
    }

    public String load() {
        if (interesseId != null) {
            interesse = interesseManager.get(interesseId);
        } else {
            return ERROR;
        }

        return SUCCESS;
    }

    public String edit() {
        if (interesseId != null) {
            interesse = interesseManager.get(interesseId);
            interesseBaseTO = interesseManager.getInteresseBaseTO(interesseId);
            if (interesse.getBesteller() != null) {
                bestellerId = interesse.getBesteller().getBestellerId();
            }
        } else {
            interesseBaseTO = new InteresseBaseTO();
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

        boolean isNew = (interesseBaseTO.getInteresseId() == null);

        //Validierung Name
        if (interesseBaseTO.getInteresse().equals("")) {
            saveMessage(getText("Bitte geben Sie eine Bezeichnung ein."));
            return "back";
        }

        if (isNew){
            interesse = interesseManager.create(interesseBaseTO, journalId);
            interesseId = interesse.getInteresseId();
        }
        else{
            interesse = interesseManager.saveBaseTO(interesseBaseTO);
            interesseId = interesse.getInteresseId();
        }

        String key = (isNew) ? "Interesse wurde erfolgreich erstellt." : "Interesse wurde erfolgreich aktualisiert.";
        saveMessage(key);

        return SUCCESS;
    }

    // Ralations
    public String changeBesteller(){
        interesseManager.connectInteresseBesteller(this.interesseId, this.bestellerId);
        load();
        return SUCCESS;
    }

    // Getter und Setter
    public void setInteresseManager(InteresseManager interesseManager) {
        this.interesseManager = interesseManager;
    }

    public Interesse getInteresse() {
        return interesse;
    }

    public void setInteresse(Interesse interesse) {
        this.interesse = interesse;
    }

    public InteresseBaseTO getInteresseBaseTO() {
        return interesseBaseTO;
    }

    public void setInteresseBaseTO(InteresseBaseTO interesseBaseTO) {
        this.interesseBaseTO = interesseBaseTO;
    }
}
