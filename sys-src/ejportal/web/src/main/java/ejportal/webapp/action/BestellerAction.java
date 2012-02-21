package ejportal.webapp.action;

import ejportal.model.Besteller;
import ejportal.service.BestellerManager;
import ejportal.service.dto.BestellerBaseTO;
import ejportal.service.dto.BestellerSearchTO;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 10.08.2010
 * Time: 11:01:25
 * To change this template use File | Settings | File Templates.
 */
public class BestellerAction extends JournalBaseAction{
    private BestellerManager bestellerManager;
    private Besteller besteller;
    private BestellerBaseTO bestellerBaseTO;

    // IDs fürs Menü
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
        try {
            bestellerManager.remove(bestellerId);
            saveMessage("Besteller wurde erfolgreich entfernt.");
        }
        catch (DataIntegrityViolationException dive){
            saveMessage("Dieser Besteller hat noch Interessen und kann deshalb nicht entfernt werden.");
            return ERROR;
        }
        return SUCCESS;
    }

    public String load() {
        if (bestellerId != null) {
            besteller = bestellerManager.get(bestellerId);
        } else {
            return ERROR;
        }

        return SUCCESS;
    }

    public String edit() {
        if (bestellerId != null) {
            besteller = bestellerManager.get(bestellerId);
            bestellerBaseTO = bestellerManager.getBestellerBaseTO(bestellerId);
        } else {
            bestellerBaseTO = new BestellerBaseTO();
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

        boolean isNew = (bestellerBaseTO.getBestellerId() == null);

        //Validierung Name
        if (bestellerBaseTO.getBestellerName().equals("")) {
            saveMessage(getText("Bitte geben Sie einen Namen ein."));
            return "back";
        }

        //Validierung Projekt
        if (bestellerBaseTO.getProjekt().equals("")) {
            saveMessage(getText("Bitte geben Sie ein Projekt ein."));
            return "back";
        }

        //Validierung Einzahlung erwünscht
        if (bestellerBaseTO.getEinzahlungErwuenscht() < 0) {
            saveMessage(getText("Bitte geben Sie einen Betrag ein."));
            return "back";
        }
        if (!(new Float(bestellerBaseTO.getEinzahlungErwuenscht()) instanceof Float)) {
            saveMessage(getText("Bitte geben Sie eine Zahl ein."));
            return "back";
        }

        //Validierung Einzahlung festgelegt
        if (bestellerBaseTO.getEinzahlungFestgelegt() < 0) {
            saveMessage(getText("Bitte geben Sie einen Betrag ein."));
            return "back";
        }
        if (!(new Float(bestellerBaseTO.getEinzahlungFestgelegt()) instanceof Float)) {
            saveMessage(getText("Bitte geben Sie eine Zahl ein."));
            return "back";
        }

        if (isNew){
            besteller = bestellerManager.create(bestellerBaseTO);
            bestellerId = besteller.getBestellerId();            
        }
        else{
            besteller = bestellerManager.saveBaseTO(bestellerBaseTO);
            bestellerId = besteller.getBestellerId();
        }

        String key = (isNew) ? "Besteller wurde erfolgreich erstellt." : "Besteller wurde erfolgreich aktualisiert.";
        saveMessage(key);

        return SUCCESS;
    }

    //Search
    private BestellerSearchTO bestellerSearchTO;
    private List bestellerList;

    public BestellerSearchTO getBestellerSearchTO() {
        return bestellerSearchTO;
    }

    public void setBestellerSearchTO(BestellerSearchTO bestellerSearchTO) {
        this.bestellerSearchTO = bestellerSearchTO;
    }

    public List getBestellerList() {
        return bestellerList;
    }

    public String search(){
        int maxResults = 25;
        bestellerList = bestellerManager.search(bestellerSearchTO, maxResults);
        if(bestellerList.size() == maxResults){
            saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als " + bestellerList.size() + " Besteller gefunden wurden.");
            saveMessage("Die ersten " + maxResults + " Ergebnisse werden angezeigt.");
        }

        //TODO Fehlerbehandlung
        return SUCCESS;
    }

    //Relations
    private Long sigelId;

    public void setSigelId(Long sigelId) {
        this.sigelId = sigelId;
    }

    public String changeSigel(){
        bestellerManager.connectBestellerSigel(this.bestellerId, this.sigelId);
        load();
        return SUCCESS;
    }

    // Getter und Setter
    public void setBestellerManager(BestellerManager bestellerManager) {
        this.bestellerManager = bestellerManager;
    }

    public Besteller getBesteller() {
        return besteller;
    }

    public void setBesteller(Besteller besteller) {
        this.besteller = besteller;
    }

    public BestellerBaseTO getBestellerBaseTO() {
        return bestellerBaseTO;
    }

    public void setBestellerBaseTO(BestellerBaseTO bestellerBaseTO) {
        this.bestellerBaseTO = bestellerBaseTO;
    }
}
