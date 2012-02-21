package ejportal.service.dto;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 01.07.2010
 * Time: 13:15:54
 * To change this template use File | Settings | File Templates.
 */
public class JournalBaseTO {
    private Long id;
    private String herausgeber;       

    private String titel;
    private String kurztitel;
    private String issn;
    private String issnPrint;
    private String kommentar;
    private String kommentarAdmin;
    private String kommentarIntranet;

    private String zugangUeber;

    private Date anmeldedatum;
    private Date freischaltdatum;
    private String zugangsId;
    private String zugangsPasswort;
    private String nutzungsbestimmungen;
    private Date rotschaltungsdatum;
    private String rotschaltungsbemerkungen;
    private String status;
    private Date aenderungsdatum;
    private String zdbNummer;
    private String anker;
    private boolean readMeTitelbezogen;
    private String importId;
    private Date bearbeitungsdatum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHerausgeber() {
        return herausgeber;
    }

    public void setHerausgeber(String herausgeber) {
        this.herausgeber = herausgeber;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getKurztitel() {
        return kurztitel;
    }

    public void setKurztitel(String kurztitel) {
        this.kurztitel = kurztitel;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getIssnPrint() {
        return issnPrint;
    }

    public void setIssnPrint(String issnPrint) {
        this.issnPrint = issnPrint;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getKommentarAdmin() {
        return kommentarAdmin;
    }

    public void setKommentarAdmin(String kommentarAdmin) {
        this.kommentarAdmin = kommentarAdmin;
    }

    public String getKommentarIntranet() {
        return kommentarIntranet;
    }

    public void setKommentarIntranet(String kommentarIntranet) {
        this.kommentarIntranet = kommentarIntranet;
    }

    public String getZugangUeber() {
        return zugangUeber;
    }

    public void setZugangUeber(String zugangUeber) {
        this.zugangUeber = zugangUeber;
    }

    public Date getAnmeldedatum() {
        return anmeldedatum;
    }

    public void setAnmeldedatum(Date anmeldedatum) {
        this.anmeldedatum = anmeldedatum;
    }

    public Date getFreischaltdatum() {
        return freischaltdatum;
    }

    public void setFreischaltdatum(Date freischaltdatum) {
        this.freischaltdatum = freischaltdatum;
    }

    public String getZugangsId() {
        return zugangsId;
    }

    public void setZugangsId(String zugangsId) {
        this.zugangsId = zugangsId;
    }

    public String getZugangsPasswort() {
        return zugangsPasswort;
    }

    public void setZugangsPasswort(String zugangsPasswort) {
        this.zugangsPasswort = zugangsPasswort;
    }

    public String getNutzungsbestimmungen() {
        return nutzungsbestimmungen;
    }

    public void setNutzungsbestimmungen(String nutzungsbestimmungen) {
        this.nutzungsbestimmungen = nutzungsbestimmungen;
    }

    public Date getRotschaltungsdatum() {
        return rotschaltungsdatum;
    }

    public void setRotschaltungsdatum(Date rotschaltungsdatum) {
        this.rotschaltungsdatum = rotschaltungsdatum;
    }

    public String getRotschaltungsbemerkungen() {
        return rotschaltungsbemerkungen;
    }

    public void setRotschaltungsbemerkungen(String rotschaltungsbemerkungen) {
        this.rotschaltungsbemerkungen = rotschaltungsbemerkungen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAenderungsdatum() {
        return aenderungsdatum;
    }

    public void setAenderungsdatum(Date aenderungsdatum) {
        this.aenderungsdatum = aenderungsdatum;
    }

    public String getZdbNummer() {
        return zdbNummer;
    }

    public void setZdbNummer(String zdbNummer) {
        this.zdbNummer = zdbNummer;
    }

    public String getAnker() {
        return anker;
    }

    public void setAnker(String anker) {
        this.anker = anker;
    }

    public boolean getReadMeTitelbezogen() {
        return readMeTitelbezogen;
    }

    public void setReadMeTitelbezogen(boolean readMeTitelbezogen) {
        this.readMeTitelbezogen = readMeTitelbezogen;
    }

    public String getImportId() {
        return importId;
    }

    public void setImportId(String importId) {
        this.importId = importId;
    }

    public Date getBearbeitungsdatum() {
        return bearbeitungsdatum;
    }

    public void setBearbeitungsdatum(Date bearbeitungsdatum) {
        this.bearbeitungsdatum = bearbeitungsdatum;
    }
}
