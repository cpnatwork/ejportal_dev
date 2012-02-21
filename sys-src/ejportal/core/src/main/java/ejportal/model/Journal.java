package ejportal.model;

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 10:49:00
 * To change this template use File | Settings | File Templates.
 */

import org.appfuse.model.BaseObject;

import javax.persistence.*;
import java.util.*;
import java.lang.Long;

@Entity
public class Journal extends BaseObject {
    
    private Long id;
    private String herausgeber;
    private Bibliotheksmitarbeiter bibliotheksmitarbeiter;
    private Institution verlag;
    private Institution provider;
    private Sigel eigentuemer;
    private Bibliotheksmitarbeiter freischalter;
    private Konsortium konsortium;
    private Paket paket;
    private Set<Fach> faecher = new HashSet<Fach>();
    private Set<Exemplar> exemplare = new HashSet<Exemplar>();
    //private EzbDaten ezbImport;

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
    private Long ezbId;   //-->ezbImport
    private String anker;
    private boolean readMeTitelbezogen;
    private String importId;
    private Date bearbeitungsdatum;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne
    public Institution getVerlag() {
        return verlag;
    }

    public void setVerlag(Institution institution) {
        this.verlag = institution;
    }

    @ManyToOne
    public Institution getProvider() {
        return provider;
    }

    public void setProvider(Institution provider) {
        this.provider = provider;
    }

    @ManyToOne
    public Sigel getEigentuemer() {
        return eigentuemer;
    }

    public void setEigentuemer(Sigel eigentuemer) {
        this.eigentuemer = eigentuemer;
    }

    @ManyToOne
    public Bibliotheksmitarbeiter getFreischalter() {
        return freischalter;
    }

    public void setFreischalter(Bibliotheksmitarbeiter freischalter) {
        this.freischalter = freischalter;
    }

    @ManyToOne
    public Konsortium getKonsortium() {
        return konsortium;
    }

    public void setKonsortium(Konsortium konsortium) {
        this.konsortium = konsortium;
    }

    @ManyToOne
    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        this.paket = paket;
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

    @Column(length = 2000)
    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    @Column(length = 2000)
    public String getKommentarAdmin() {
        return kommentarAdmin;
    }

    public void setKommentarAdmin(String kommentarAdmin) {
        this.kommentarAdmin = kommentarAdmin;
    }

    @Column(length = 2000)
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

    @ManyToOne
    public Bibliotheksmitarbeiter getBibliotheksmitarbeiter() {
        return bibliotheksmitarbeiter;
    }

    public void setBibliotheksmitarbeiter(Bibliotheksmitarbeiter bibliotheksmitarbeiter) {
        this.bibliotheksmitarbeiter = bibliotheksmitarbeiter;
    }

    @ManyToMany(mappedBy="journals", fetch=FetchType.EAGER)
    @OrderBy(value="fachId")
    public Set<Fach> getFaecher() {
        return faecher;
    }

    public void setFaecher(Set<Fach> faecher) {
        this.faecher = faecher;
    }

    public Date getBearbeitungsdatum() {
        return bearbeitungsdatum;
    }

    public void setBearbeitungsdatum(Date bearbeitungsdatum) {
        this.bearbeitungsdatum = bearbeitungsdatum;
    }

    @OneToMany(mappedBy = "journal", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @OrderBy(value="exemplarId")
    public Set<Exemplar> getExemplare() {
        return exemplare;
    }

    public void setExemplare(Set<Exemplar> exemplare) {
        this.exemplare = exemplare;
    }

    public Long getEzbId() {
        return ezbId;
    }

    public void setEzbId(Long ezbId) {
        this.ezbId = ezbId;
    }

//von Hand, da sonst bei einem neuen Import die Fremdschluessel auf null gesetzt werden :-(

    /**
    @OneToOne
        public EzbDaten getEzbImport() {
        return ezbImport;
    }

    public void setEzbImport(EzbDaten ezbImport) {
        this.ezbImport = ezbImport;
    }
     **/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Journal)) return false;

        Journal journal = (Journal) o;

        if (id != journal.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (herausgeber != null ? herausgeber.hashCode() : 0);
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (kurztitel != null ? kurztitel.hashCode() : 0);
        result = 31 * result + (issn != null ? issn.hashCode() : 0);
        result = 31 * result + (issnPrint != null ? issnPrint.hashCode() : 0);
        result = 31 * result + (kommentar != null ? kommentar.hashCode() : 0);
        result = 31 * result + (kommentarAdmin != null ? kommentarAdmin.hashCode() : 0);
        result = 31 * result + (kommentarIntranet != null ? kommentarIntranet.hashCode() : 0);
        result = 31 * result + (zugangUeber != null ? zugangUeber.hashCode() : 0);
        result = 31 * result + (anmeldedatum != null ? anmeldedatum.hashCode() : 0);
        result = 31 * result + (freischaltdatum != null ? freischaltdatum.hashCode() : 0);
        result = 31 * result + (zugangsId != null ? zugangsId.hashCode() : 0);
        result = 31 * result + (zugangsPasswort != null ? zugangsPasswort.hashCode() : 0);
        result = 31 * result + (nutzungsbestimmungen != null ? nutzungsbestimmungen.hashCode() : 0);
        result = 31 * result + (rotschaltungsdatum != null ? rotschaltungsdatum.hashCode() : 0);
        result = 31 * result + (rotschaltungsbemerkungen != null ? rotschaltungsbemerkungen.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (aenderungsdatum != null ? aenderungsdatum.hashCode() : 0);
        result = 31 * result + (zdbNummer != null ? zdbNummer.hashCode() : 0);
        result = 31 * result + (anker != null ? anker.hashCode() : 0);
        result = 31 * result + (readMeTitelbezogen ? 1 : 0);
        result = 31 * result + (importId != null ? importId.hashCode() : 0);
        result = 31 * result + (bearbeitungsdatum != null ? bearbeitungsdatum.hashCode() : 0);
        return result;
    }

    public String toString(){
        return (this.getId() + this.getTitel());
    }


}