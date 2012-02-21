package ejportal.webapp.action;

import ejportal.model.Exemplar;
import ejportal.model.Journal;
import ejportal.model.Rechnung;
import ejportal.service.JournalManager;
import ejportal.service.RechnungManager;
import ejportal.service.dto.RechnungBaseTO;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 09.08.2010
 * Time: 15:55:42
 * To change this template use File | Settings | File Templates.
 */
public class RechnungAction extends JournalBaseAction {
    private RechnungManager rechnungManager;
    private JournalManager journalManager;
    private Rechnung rechnung;
    private Journal journal;
    private RechnungBaseTO rechnungBaseTO;
    private Long rechnungId;

    // ExemplarId fürs Menü
    private Long exemplarId;

    public Long getExemplarId() {
        return exemplarId;
    }

    public void setExemplarId(Long exemplarId) {
        this.exemplarId = exemplarId;
    }


    // List
    public List<Rechnung> getListForExemplar() {
        return rechnungManager.getListForExemplar(exemplarId);
    }

    // CRUD
    public String delete() {
        rechnungManager.remove(rechnungId);
        saveMessage("Rechnung wurde erfolgreich entfernt.");

        return SUCCESS;
    }

    public String load() {
        if (rechnungId != null) {
            rechnung = rechnungManager.get(rechnungId);
        } else {
            return ERROR;
        }

        return SUCCESS;
    }

    public String edit() {
        if (rechnungId != null) {
            rechnung = rechnungManager.get(rechnungId);
            rechnungBaseTO = rechnungManager.getRechnungBaseTO(rechnungId);
        } else {
            rechnungBaseTO = new RechnungBaseTO();
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

        boolean isNew = (rechnungBaseTO.getRechnungId() == null);

        //Prüfen, ob Rechnung leer ist.
        if (rechnungBaseTO.getBetrag() <= 0) {
            saveMessage(getText("Bitte geben Sie einen Betrag ein!"));
            return "back";
        }
        if (rechnungBaseTO.getBezugsform().compareTo("") == 0) {
            saveMessage(getText("Bitte geben Sie eine Bezugsform ein!"));
            return "back";
        }
        if (rechnungBaseTO.getBezugsjahr().compareTo("") == 0) {
            saveMessage(getText("Bitte geben Sie ein Bezugsjahr ein!"));
            return "back";
        }

        if (isNew){
            rechnung = rechnungManager.create(rechnungBaseTO, exemplarId);
        }
        else{
            rechnung = rechnungManager.saveBaseTO(rechnungBaseTO);
        }

        String key = (isNew) ? "Rechnung wurde erfolgreich erstellt." : "Rechnung wurde erfolgreich aktualisiert.";
        saveMessage(key);

        return SUCCESS;
    }

    public String loadExemplare() {
        if (journalId != null) {
            journal = journalManager.get(journalId);
        } else {
            return ERROR;
        }

        return SUCCESS;
    }

    // Getter und Setter

    public Long getRechnungId() {
        return rechnungId;
    }

    public void setRechnungId(Long rechnungId) {
        this.rechnungId = rechnungId;
    }

    public void setRechnungManager(RechnungManager rechnungManager) {
        this.rechnungManager = rechnungManager;
    }

    public Rechnung getRechnung() {
        return rechnung;
    }

    public void setRechnung(Rechnung rechnung) {
        this.rechnung = rechnung;
    }

    public RechnungBaseTO getRechnungBaseTO() {
        return rechnungBaseTO;
    }

    public void setRechnungBaseTO(RechnungBaseTO rechnungBaseTO) {
        this.rechnungBaseTO = rechnungBaseTO;
    }

    public void setJournalManager(JournalManager journalManager) {
        this.journalManager = journalManager;
    }

    public Journal getJournal() {
        return journal;
    }

}
