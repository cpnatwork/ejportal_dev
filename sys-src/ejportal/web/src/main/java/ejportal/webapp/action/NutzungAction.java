package ejportal.webapp.action;

import ejportal.model.Nutzung;
import ejportal.service.NutzungManager;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 10.08.2010
 * Time: 09:48:43
 * To change this template use File | Settings | File Templates.
 */
public class NutzungAction extends JournalBaseAction{
    private NutzungManager nutzungManager;
    private Nutzung nutzung;
    private Long nutzungId;


    public Nutzung getNutzung() {
        return nutzung;
    }

    public void setNutzung(Nutzung nutzung) {
        this.nutzung = nutzung;
    }

    public void setNutzungManager(NutzungManager nutzungManager) {
        this.nutzungManager = nutzungManager;
    }

    public Long getNutzungId() {
        return nutzungId;
    }

    public void setNutzungId(Long nutzungId) {
        this.nutzungId = nutzungId;
    }

    public String edit(){
        if (nutzungId != null) {
            nutzung = nutzungManager.get(nutzungId);
        } else {
            nutzung = new Nutzung();
        }
        return "edit";
    }

    public String load() {
        if (nutzungId != null) {
            nutzung = nutzungManager.get(nutzungId);
        } else {
            return ERROR;
        }

        return SUCCESS;
    }

    public String save(){
        if (cancel != null) {
            return CANCEL;
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (nutzung.getNutzungId() == null);

        //Prüfen, ob Nutzung leer ist.
        if (nutzung.getZugriffe() == null) {
            saveMessage(getText("Bitte geben Sie die Anzahl der Zugriffe ein!"));
            return "back";
        }
        if (nutzung.getZeitraum() == null) {
            saveMessage(getText("Bitte geben Sie einen Zeitraum ein!"));
            return "back";
        }
        if (nutzung.getNutzungsjahr() == null) {
            saveMessage(getText("Bitte geben Sie ein Jahr ein!")); 
            return "back";
        }
        if (nutzung.getRechnungsbetrag() == null) {
            saveMessage(getText("Bitte geben Sie einen Betrag ein!")); 
            return "back";
        }

        //Prüfen, ob Datentypen stimmen.
        /*if ((nutzung.getZugriffe() instanceof Integer) == false) {
            saveMessage(getText("Bitte geben Sie für Zugriffe eine Zahl ein!"));
            return "back";
        }*/

        nutzung = nutzungManager.saveWithJournal(nutzung, journalId);

        load();
        String key = (isNew) ? "Nutzung wurde erfolgreich erstellt." : "Nutzung wurde erfolgreich aktualisiert.";
        saveMessage(key);

        return SUCCESS;
    }

    public String delete(){
        nutzungManager.remove(nutzungId);
        saveMessage(getText("Nutzung wurde erfolgreich entfernt."));

        return SUCCESS;
    }


}
