package ejportal.webapp.action;

import ejportal.model.Bibliotheksmitarbeiter;
import ejportal.service.BibliotheksmitarbeiterManager;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 05.08.2010
 * Time: 13:03:44
 * To change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterDetailAction extends BaseAction{
    private BibliotheksmitarbeiterManager bibliotheksmitarbeiterManager;
    private Bibliotheksmitarbeiter bibliotheksmitarbeiter;
    private Long bibId;

    public void setBibliotheksmitarbeiterManager(BibliotheksmitarbeiterManager bibliotheksmitarbeiterManager) {
        this.bibliotheksmitarbeiterManager = bibliotheksmitarbeiterManager;
    }

    public Bibliotheksmitarbeiter getBibliotheksmitarbeiter() {
        return bibliotheksmitarbeiter;
    }

    public void setBibliotheksmitarbeiter(Bibliotheksmitarbeiter bibliotheksmitarbeiter) {
        this.bibliotheksmitarbeiter = bibliotheksmitarbeiter;
    }

    public long getBibId() {
        return bibId;
    }

    public void setBibId(Long bibId) {
        this.bibId = bibId;
    }

    public String delete() {
        try {
            bibliotheksmitarbeiterManager.remove(bibId);
            saveMessage(getText("Bibliothek wurde erfolgreich entfernt."));
        }
        catch (DataIntegrityViolationException dive) {
            saveMessage("Diese Bibliothek wird noch verwendet und kann deshalb nicht enfernt werden.");
            return ERROR;
        }

        return SUCCESS;
    }

    public String load(){
        if (bibId != null) {
            bibliotheksmitarbeiter = bibliotheksmitarbeiterManager.get(bibId);
        } else {
            return ERROR;
        }

        return SUCCESS;

    }

    public String edit() {
        if (bibId != null) {
            bibliotheksmitarbeiter = bibliotheksmitarbeiterManager.get(bibId);
        } else {
            bibliotheksmitarbeiter = new Bibliotheksmitarbeiter();
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

        boolean isNew = (bibliotheksmitarbeiter.getBibId() == null);

        //Prüfen, ob Name angegeben worden ist.
        if (bibliotheksmitarbeiter.getName().compareTo("") == 0) {
            saveMessage(getText("Geben Sie einen Namen ein!"));
            return "back";
        }
        if(bibliotheksmitarbeiter.getName().length() > 254){
            saveMessage(getText("Geben Sie bitte einen kürzeren Namen ein!"));
            return "back";
        }

        bibliotheksmitarbeiter = bibliotheksmitarbeiterManager.save(bibliotheksmitarbeiter);

        String key = (isNew) ? "Bibliothek wurde erfolgreich erstellt." : "Bibliothek wurde erfolgreich aktualisiert.";
        saveMessage(getText(key));

        return SUCCESS;
    }

  /*  public void validate(){
        if(bibliotheksmitarbeiter.getName().length() == 0){
            addFieldError("Bibliotheksmitarbeiter", "Geben sie einen Namen für den Bibliotheksmitarbeiter ein.");
        }
       *//* if(bibliotheksmitarbeiter.getAbteilungsHauptstelle().length() == 0){
            addFieldError("Bibliotheksmitarbeiter", "Geben sie eine Abteilungshauptstelle für den Bibliotheksmitarbeiter ein.");
        }
        if(bibliotheksmitarbeiter.getEmailanschrift().length() == 0){
            addFieldError("Bibliotheksmitarbeiter", "Geben sie eine E-Mail Adresse für den Bibliotheksmitarbeiter ein.");
        }*//*
    }*/
}
