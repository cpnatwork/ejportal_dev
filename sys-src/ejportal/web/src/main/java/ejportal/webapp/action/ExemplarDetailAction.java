package ejportal.webapp.action;

import ejportal.model.Exemplar;
import ejportal.service.ExemplarManager;
import ejportal.service.dto.ExemplarBaseTO;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 04.08.2010
 * Time: 14:56:26
 * To change this template use File | Settings | File Templates.
 */
public class ExemplarDetailAction extends JournalBaseAction{
    private ExemplarManager exemplarManager;
    private Exemplar exemplar;
    private ExemplarBaseTO exemplarBaseTO;
    private Long exemplarId;



    private SelectData selectData = new SelectData();

    //Dropdown Lists

    public Map<String, String> getListBeteiligung() {
        return selectData.getExemplarBeteiligung();
    }
    public Map<String, String> getListForm() {
        return selectData.getExemplarForm();
    }
    public Map<String, String> getListZugangsart() {
        return selectData.getExemplarZugangsart();
    }
    public Map<String, String> getListStatus() {
        return selectData.getExemplarStatus();
    }

    public Map<String, String> getListAbbestellung(){
        return selectData.getExemplarAbbestellung();
    }

    public Map<String, String> getListUmbestellung(){
        return selectData.getExemplarUmbestellung();
    }

    public void setExemplarManager(ExemplarManager exemplarManager) {
        this.exemplarManager = exemplarManager;
    }

    public ExemplarBaseTO getExemplarBaseTO() {
        return exemplarBaseTO;
    }

    public void setExemplarBaseTO(ExemplarBaseTO exemplarBaseTO) {
        this.exemplarBaseTO = exemplarBaseTO;
    }

    public void setExemplarId(Long exemplarId) {
        this.exemplarId = exemplarId;
    }

    public Long getExemplarId() {
        return exemplarId;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }



    public String delete() {
       try {
            exemplarManager.removeSafe(exemplarId);
            saveMessage("Das Exemplar wurde entfernt.");
       }
       catch (DataIntegrityViolationException dive){
            saveMessage("Dieses Exemplar wird noch verwendet und kann deshalb nicht entfernt werden.");
            return ERROR;
        }
        return SUCCESS;
    }

    public String load(){
        if (exemplarId != null) {
            exemplar = exemplarManager.get(exemplarId);
        } else {
            return ERROR;
        }

        return SUCCESS;
    }

    public String edit() {
        if (exemplarId != null) {
            exemplarBaseTO = exemplarManager.getExemplarBaseTO(exemplarId);
        } else {
            exemplarBaseTO = new ExemplarBaseTO();
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

        boolean isNew = (exemplarBaseTO.getExemplarId() == null);

        // Pruefen, ob Bestellnummer angegeben worden ist.
        if (exemplarBaseTO.getBestellnummer().compareTo("") == 0) {
            saveMessage(getText("Bitte geben Sie eine Bestellnummer ein!"));
            return "back";
        }
        if(exemplarBaseTO.getBestellnummer().length() > 254){
            saveMessage(getText("Geben Sie bitte eine kürzere Bestellnummer ein!"));
            return "back";
        }

        if (isNew){ // Create
            exemplar = exemplarManager.create(exemplarBaseTO, journalId);
        }
        else{ // Update
            exemplar = exemplarManager.saveBaseTO(exemplarBaseTO);
        }
        String key = (isNew) ? "Das Exemplar wurde erstellt." : "Das Exemplar wurde aktualisiert.";
        saveMessage(key);

        //ExemplarID setzen
        this.exemplarId=exemplar.getExemplarId();

    return SUCCESS;
    }

    //Besteller ändern
    private Long bestellerId;

    public void setBestellerId(Long bestellerId) {
        this.bestellerId = bestellerId;
    }

    public String changeBesteller(){
        exemplarManager.connectExemplarBesteller(this.exemplarId, this.bestellerId);
        load();
        return SUCCESS;
    }

    //Eigentümer ändern
    private Long eigentuemerId;

    public void setEigentuemerId(Long eigentuemerId) {
        this.eigentuemerId = eigentuemerId;
    }

    public String changeEigentuemer(){
        exemplarManager.connectExemplarEigentuemer(this.exemplarId, this.eigentuemerId);
        load();
        return SUCCESS;
    }
    
    //Lieferanten ändern
    private Long lieferantId;

    public void setLieferantId(Long lieferantId) {
        this.lieferantId = lieferantId;
    }

    public String changeLieferant(){
        exemplarManager.connectExemplarLieferant(this.exemplarId, this.lieferantId);
        load();
        return SUCCESS;
    }

    //Lieferanten ändern
    private Long zustaendigeBibId;

    public Long getZustaendigeBibId() {
        return zustaendigeBibId;
    }

    public void setZustaendigeBibId(Long zustaendigeBibId) {
        this.zustaendigeBibId = zustaendigeBibId;
    }

    public String changeZustaendigeBib(){
        exemplarManager.connectExemplarZustaendigeBib(this.exemplarId, this.zustaendigeBibId);
        load();
        return SUCCESS;
    }
}