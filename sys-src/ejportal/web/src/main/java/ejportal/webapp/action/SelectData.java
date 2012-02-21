package ejportal.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 02.08.2010
 * Time: 13:42:45
 * To change this template use File | Settings | File Templates.
 */

public class SelectData {

    private Map<String, String> journalZugangUeber = new HashMap<String, String>();
    private Map<String, String> journalNutzungsbestimmungen = new HashMap<String, String>();
    private Map<String, String> journalStatus = new HashMap<String, String>();

    private Map<String, String> exemplarStatus = new HashMap<String, String>();
    private Map<String, String> exemplarBeteiligung = new HashMap<String, String>();
    private Map<String, String> exemplarForm = new HashMap<String, String>();
    private Map<String, String> exemplarZugangsart = new HashMap<String, String>();
    private Map<String, String> exemplarAbbestellung = new HashMap<String, String>();
    private Map<String, String> exemplarUmbestellung = new HashMap<String, String>();

    private Map<String, String> institutionLizenzArt = new HashMap<String, String>();
    private Map<String, String> institutionZugang = new HashMap<String, String>();
    private Map<String, String> institutionPersonengruppe = new HashMap<String, String>();
    private Map<String, String> institutionFernleihe = new HashMap<String, String>();
    private Map<String, String> institutionBestellsprache = new HashMap<String, String>();
    private Map<String, String> institutionBestellart = new HashMap<String, String>();

    private Map<String, String> projektWaehrung = new HashMap<String, String>();
    private Map<String, String> projektMwSt = new HashMap<String, String>();

    
    public SelectData()  {

        // Journal
        setJournalZugangUeber("Konsortium ohne Abo.");
        setJournalZugangUeber("Konsortium mit Abo.");
        setJournalZugangUeber("Eigenes Abo.");

        setJournalNutzungsbestimmungen("frei zugänglich");
        setJournalNutzungsbestimmungen("Kennung erhalten die Universitäts-Angehörigen an den Info-Stellen der Bibliothek");
        setJournalNutzungsbestimmungen("Zugriff von der Domain Universität Erlangen-Nürnberg");

        setJournalStatus("bearbeitet");
        setJournalStatus("Projektimport");

        // Exemplar
        setExemplarStatus("laufend");
        setExemplarStatus("zentral bestellt");
        setExemplarStatus("zentral vorgemerkt");
        setExemplarStatus("bearbeiten");
        setExemplarStatus("beendet");
        setExemplarStatus("kein Abo.");

        setExemplarBeteiligung("Mitglied");
        setExemplarBeteiligung("Herausgeber");
        setExemplarBeteiligung("Autor");

        setExemplarForm("Online");
        setExemplarForm("Print");
        setExemplarForm("Print + Online");
        setExemplarForm("Online Kons-Anteil");

        setExemplarZugangsart("Kauf");
        setExemplarZugangsart("Konsortium");
        setExemplarZugangsart("Geschenk / Spende");
        setExemplarZugangsart("Mitgliedschaft");
        setExemplarZugangsart("kein Abo.");

        setExemplarAbbestellung("abbestellt");
        setExemplarAbbestellung("Abbestellwunsch");

        setExemplarUmbestellung("umbestellt");

        // Institution
        setInstitutionLizenzArt("Konsortium");
        setInstitutionLizenzArt("Nationallizenz (Archiv)");
        setInstitutionLizenzArt("Nationallizenz (laufende ZS)");
        setInstitutionLizenzArt("Vertrag");

        setInstitutionZugang("IP");
        setInstitutionZugang("PW");
        setInstitutionZugang("Han-IP");
        setInstitutionZugang("Han-PW");

        setInstitutionPersonengruppe("uniweit");
        setInstitutionPersonengruppe("Professoren");
        setInstitutionPersonengruppe("Mitarbeiter");

        setInstitutionFernleihe("Fernleihkopien nur für den Deutschen Leihverkehr möglich");
        setInstitutionFernleihe("Keine Fernleihkopien möglich");
        setInstitutionFernleihe("Fernleihkopien für den Deutschen und Internationalen Leihverkehr möglich");

        setInstitutionBestellsprache("dt.");
        setInstitutionBestellsprache("engl.");

        setInstitutionBestellart("Email");
        setInstitutionBestellart("Brief");


        // Projektplanung
        setProjektWaehrung("EUR");
        setProjektWaehrung("CHF");
        setProjektWaehrung("GBP");
        setProjektWaehrung("USD");

        setProjektMwSt("7.00", "7,00%");
        setProjektMwSt("16.00", "16,00%");
        setProjektMwSt("19.00", "19,00%");
        setProjektMwSt("0.00", "0");
        
    }

    public Map<String, String> getJournalZugangUeber() {
        return journalZugangUeber;
    }

    public void setJournalZugangUeber( String value ) {
        this.journalZugangUeber.put(value, value);
    }

    public Map<String, String> getJournalNutzungsbestimmungen() {
        return journalNutzungsbestimmungen;
    }

    public void setJournalNutzungsbestimmungen( String value ) {
        this.journalNutzungsbestimmungen.put(value, value);
    }

    public Map<String, String> getJournalStatus() {
        return journalStatus;
    }

    public void setJournalStatus( String value ) {
        this.journalStatus.put(value, value);
    }

    public Map<String, String> getExemplarStatus() {
        return exemplarStatus;
    }

    public void setExemplarStatus( String value ) {
        this.exemplarStatus.put(value, value);
    }

    public Map<String, String> getExemplarBeteiligung() {
        return exemplarBeteiligung;
    }

    public void setExemplarBeteiligung( String value ) {
        this.exemplarBeteiligung.put(value, value);
    }

    public Map<String, String> getExemplarForm() {
        return exemplarForm;
    }

    public void setExemplarForm( String value ) {
        this.exemplarForm.put(value, value);
    }

    public Map<String, String> getExemplarZugangsart() {
        return exemplarZugangsart;
    }

    public void setExemplarZugangsart( String value ) {
        this.exemplarZugangsart.put(value, value);
    }

    public Map<String, String> getExemplarAbbestellung() {
        return exemplarAbbestellung;
    }

    public void setExemplarAbbestellung( String value ) {
        this.exemplarAbbestellung.put(value, value);
    }

    public Map<String, String> getExemplarUmbestellung() {
        return exemplarUmbestellung;
    }

    public void setExemplarUmbestellung(String exemplarUmbestellung) {
        this.exemplarUmbestellung.put(exemplarUmbestellung, exemplarUmbestellung);
    }

    public Map<String, String> getInstitutionLizenzArt() {
        return institutionLizenzArt;
    }

    public void setInstitutionLizenzArt( String value ) {
        this.institutionLizenzArt.put(value, value);
    }

    public Map<String, String> getInstitutionZugang() {
        return institutionZugang;
    }

    public void setInstitutionZugang( String value ) {
        this.institutionZugang.put(value, value);
    }

    public Map<String, String> getInstitutionPersonengruppe() {
        return institutionPersonengruppe;
    }

    public void setInstitutionPersonengruppe( String value ) {
        this.institutionPersonengruppe.put(value, value);
    }

    public Map<String, String> getInstitutionFernleihe() {
        return institutionFernleihe;
    }

    public void setInstitutionFernleihe( String value ) {
        this.institutionFernleihe.put(value, value);
    }

    public Map<String, String> getInstitutionBestellsprache() {
        return institutionBestellsprache;
    }

    public void setInstitutionBestellsprache( String value ) {
        this.institutionBestellsprache.put(value, value);
    }

    public Map<String, String> getInstitutionBestellart() {
        return institutionBestellart;
    }

    public void setInstitutionBestellart( String value ) {
        this.institutionBestellart.put(value, value);
    }

    public Map<String, String> getProjektWaehrung() {
        return projektWaehrung;
    }

    public void setProjektWaehrung( String value ) {
        this.projektWaehrung.put( value, value);
    }

    public Map<String, String> getProjektMwSt() {
        return projektMwSt;
    }

    public void setProjektMwSt(String key, String value) {
        this.projektMwSt.put(key, value);
    }
}

