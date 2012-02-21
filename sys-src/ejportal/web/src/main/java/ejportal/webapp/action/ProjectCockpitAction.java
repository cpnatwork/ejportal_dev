package ejportal.webapp.action;

import ejportal.model.Interesse;
import ejportal.model.Journalkosten;
import ejportal.model.Nutzung;
import ejportal.model.Rechnung;
import ejportal.service.InteresseManager;
import ejportal.service.JournalkostenManager;
import ejportal.service.NutzungManager;
import ejportal.service.RechnungManager;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 10.08.2010
 * Time: 15:03:33
 * To change this template use File | Settings | File Templates.
 */
public class ProjectCockpitAction extends JournalBaseAction{

    // JournalId
    private Long nutzungId;





    // ListAll füŸr alle Listen
    public String listAll() {
        journalkosten = getJournalkostenForJournal();
        interessen = getInteressenForJournal();
        rechnungen = getRechnungenForJournal();
        nutzungen = getNutzungenForJournal();

        return SUCCESS;
    }

    // Journalkosten
    private JournalkostenManager journalkostenManager;
    private Journalkosten journalkosten;
    DecimalFormat df = new DecimalFormat( "###,##0.00" );

    public JournalkostenManager getJournalkostenManager() {
        return journalkostenManager;
    }

    public void setJournalkostenManager(JournalkostenManager journalkostenManager) {
        this.journalkostenManager = journalkostenManager;
    }

    public Journalkosten getJournalkosten() {
        return journalkosten;
    }

    public void setJournalkosten(Journalkosten journalkosten) {
        this.journalkosten = journalkosten;
    }

    public Journalkosten getJournalkostenForJournal(){
        return journalkostenManager.findByJournalId(getJournalId());
    }
    public String getEndpreisPO(){        
        return journalkostenManager.getEndpreisPO(journalId);
    }

    public String getEndpreisO(){
        return journalkostenManager.getEndpreisO(journalId);
    }

    public String getEndpreisP(){
        return journalkostenManager.getEndpreisP(journalId);
    }

    public String getEndpreisIPO(){
        return journalkostenManager.getEndpreisIPO(journalId);
    }

    public String getEndpreisIP(){
        return journalkostenManager.getEndpreisIP(journalId);
    }

    public String getEndpreisIO(){
        return journalkostenManager.getEndpreisIO(journalId);
    }

    // formalierte Journalkosten
    public String getPreisPO(){
        float value = journalkosten.getOPreisPO();      
        if (value == 0) return "";
        return df.format(value) + " " + journalkosten.getWaehrungPO();
    }

    public String getPreisO(){
        float value = journalkosten.getOPreisO();
        if (value == 0) return "";
        return df.format(value) + " " + journalkosten.getWaehrungO();
    }

    public String getPreisP(){
        float value = journalkosten.getOPreisP();
        if (value == 0) return "";
        return df.format(value) + " " + journalkosten.getWaehrungP();
    }

    public String getIPreisPO(){
        float value = journalkosten.getIPreisPO();
        if (value == 0) return "";
        return df.format(value) + " " + journalkosten.getIWaehrungPO();
    }

    public String getIPreisO(){
        float value = journalkosten.getIPreisO();
        if (value == 0) return "";
        return df.format(value) + " " + journalkosten.getIWaehrungO();
    }

    public String getIPreisP(){
        float value = journalkosten.getIPreisP();
        if (value == 0) return "";
        return df.format(value) + " " + journalkosten.getIWaehrungP();
    }

    
    // Interesse
    private InteresseManager interesseManager;
    private List interessen;

    public void setInteresseManager(InteresseManager interesseManager) {
        this.interesseManager = interesseManager;
    }

    public List getInteressen() {
        return interessen;
    }

    public List<Interesse> getInteressenForJournal() {
        return interesseManager.getListForJournal(journalId);
    }
    
    // Rechnungen
    private RechnungManager rechnungManager;
    private List rechnungen;

    public void setRechnungManager(RechnungManager rechnungManager) {
        this.rechnungManager = rechnungManager;
    }

    public List getRechnungen() {
        return rechnungen;
    }

    public List<Rechnung> getRechnungenForJournal() {
        return rechnungManager.getListForJournal(journalId);
    }

    // TODO: Nutzung
    private NutzungManager nutzungManager;
    private List nutzungen;

    public Long getNutzungId() {
        return nutzungId;
    }

    public void setNutzungId(Long nutzungId) {
        this.nutzungId = nutzungId;
    }

    public void setNutzungManager(NutzungManager nutzungManager) {
        this.nutzungManager = nutzungManager;
    }

    public List getNutzungen() {
        return nutzungen;
    }

    public List<Nutzung> getNutzungenForJournal() {
        return nutzungManager.findByJournalId(journalId);
    }

    public String deleteNutzung() {
        nutzungManager.remove(nutzungId);
        saveMessage("Nutzung wurde erfolgreich entfernt.");

        return SUCCESS;
    }
}
