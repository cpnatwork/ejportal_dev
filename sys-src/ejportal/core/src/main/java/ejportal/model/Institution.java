package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 15.06.2010
 * Time: 22:19:09
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Institution extends BaseObject {

    private Long id;
    private Bibliotheksmitarbeiter bibliotheksmitarbeiter;
    private String name;
    private String abteilung;
    private String strasse;
    private String postfach;
    private String plz_ort;
    private String bundesland;
    private String land;
    private String ansprechpartner;
    private String email;
    private String fax;
    private String telefon;
    private String bestellsprache;
    private String status;
    private String kommentar;
    private String kennwort;
    private boolean fernzugriff;

    private String bestellart;
    private String fernzugriffErlaeuterung;
    private String zugang;
    private String personengruppe;
    private String zugangsdaten;
    private String kommentarIntern;
    private String internetadresse;
    private String nutzungsURL;
    private String copyrightURL;
    private String accountURL;
    private String statstikURL;
    private String sfxURL;
    private String ublogoURL;
    private String statstikZugang;
    private String fernleihe;
    private String lizenzArt;
    private String lizenzAbbest;
    private String lizenzPaket;
    private String lizenzVorgang;
    private String lizenzZust;
    private String lizenzBes;

    private List<Journal> verlagJournals =  new ArrayList<Journal>();
    private List<Journal> providerJournals = new ArrayList<Journal>();
    private List<Lizenzdetail> verlagLizenzdetails = new ArrayList<Lizenzdetail>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPostfach() {
        return postfach;
    }

    public void setPostfach(String postfach) {
        this.postfach = postfach;
    }

    public String getPlz_ort() {
        return plz_ort;
    }

    public void setPlz_ort(String plz_ort) {
        this.plz_ort = plz_ort;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public void setAnsprechpartner(String ansprechpartner) {
        this.ansprechpartner = ansprechpartner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getBestellsprache() {
        return bestellsprache;
    }

    public void setBestellsprache(String bestellsprache) {
        this.bestellsprache = bestellsprache;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(length = 1000)
    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getKennwort() {
        return kennwort;
    }

    public void setKennwort(String kennwort) {
        this.kennwort = kennwort;
    }

    public boolean getFernzugriff() {
        return fernzugriff;
    }

    public void setFernzugriff(boolean fernzugriff) {
        this.fernzugriff = fernzugriff;
    }

        public String getBestellart() {
        return bestellart;
    }

    public void setBestellart(String bestellart) {
        this.bestellart = bestellart;
    }

    public String getFernzugriffErlaeuterung() {
        return fernzugriffErlaeuterung;
    }

    public void setFernzugriffErlaeuterung(String fernzugriffErlaeuterung) {
        this.fernzugriffErlaeuterung = fernzugriffErlaeuterung;
    }

    public String getZugang() {
        return zugang;
    }

    public void setZugang(String zugang) {
        this.zugang = zugang;
    }

    public String getPersonengruppe() {
        return personengruppe;
    }

    public void setPersonengruppe(String personengruppe) {
        this.personengruppe = personengruppe;
    }

    public String getZugangsdaten() {
        return zugangsdaten;
    }

    public void setZugangsdaten(String zugangsdaten) {
        this.zugangsdaten = zugangsdaten;
    }

    @Column(length = 1000)
    public String getKommentarIntern() {
        return kommentarIntern;
    }

    public void setKommentarIntern(String kommentarIntern) {
        this.kommentarIntern = kommentarIntern;
    }

    public String getInternetadresse() {
        return internetadresse;
    }

    public void setInternetadresse(String internetadresse) {
        this.internetadresse = internetadresse;
    }

    public String getNutzungsURL() {
        return nutzungsURL;
    }

    public void setNutzungsURL(String nutzungsURL) {
        this.nutzungsURL = nutzungsURL;
    }

    public String getCopyrightURL() {
        return copyrightURL;
    }

    public void setCopyrightURL(String copyrightURL) {
        this.copyrightURL = copyrightURL;
    }

    public String getAccountURL() {
        return accountURL;
    }

    public void setAccountURL(String accountURL) {
        this.accountURL = accountURL;
    }

    public String getStatstikURL() {
        return statstikURL;
    }

    public void setStatstikURL(String statstikURL) {
        this.statstikURL = statstikURL;
    }

    public String getSfxURL() {
        return sfxURL;
    }

    public void setSfxURL(String sfxURL) {
        this.sfxURL = sfxURL;
    }

    public String getUblogoURL() {
        return ublogoURL;
    }

    public void setUblogoURL(String ublogoURL) {
        this.ublogoURL = ublogoURL;
    }

    public String getStatstikZugang() {
        return statstikZugang;
    }

    public void setStatstikZugang(String statstikZugang) {
        this.statstikZugang = statstikZugang;
    }

    public String getFernleihe() {
        return fernleihe;
    }

    public void setFernleihe(String fernleihe) {
        this.fernleihe = fernleihe;
    }

    public String getLizenzArt() {
        return lizenzArt;
    }

    public void setLizenzArt(String lizenzArt) {
        this.lizenzArt = lizenzArt;
    }

    public String getLizenzAbbest() {
        return lizenzAbbest;
    }

    public void setLizenzAbbest(String lizenzAbbest) {
        this.lizenzAbbest = lizenzAbbest;
    }

    @Column(length = 500)
    public String getLizenzPaket() {
        return lizenzPaket;
    }

    public void setLizenzPaket(String lizenzPaket) {
        this.lizenzPaket = lizenzPaket;
    }

    public String getLizenzVorgang() {
        return lizenzVorgang;
    }

    public void setLizenzVorgang(String lizenzVorgang) {
        this.lizenzVorgang = lizenzVorgang;
    }

    public String getLizenzZust() {
        return lizenzZust;
    }

    public void setLizenzZust(String lizenzZust) {
        this.lizenzZust = lizenzZust;
    }

    @Column(length = 500)
    public String getLizenzBes() {
        return lizenzBes;
    }

    public void setLizenzBes(String lizenzBes) {
        this.lizenzBes = lizenzBes;
    }



    @OneToMany(mappedBy = "verlag")
    public List<Journal> getVerlagJournals() {
        return verlagJournals;
    }

    public void setVerlagJournals(List<Journal> verlagJournals) {
        this.verlagJournals = verlagJournals;
    }

    @OneToMany(mappedBy = "verlag", fetch=FetchType.EAGER)
    public List<Lizenzdetail> getVerlagLizenzdetails() {
        return verlagLizenzdetails;
    }

    public void setVerlagLizenzdetails(List<Lizenzdetail> verlagLizenzdetails) {
        this.verlagLizenzdetails = verlagLizenzdetails;
    }

    @OneToMany(mappedBy = "provider")
    public List<Journal> getProviderJournals() {
        return providerJournals;
    }

    public void setProviderJournals(List<Journal> providerJournals) {
        this.providerJournals = providerJournals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Institution)) return false;

        Institution institution = (Institution) o;

        if (fernzugriff != institution.fernzugriff) return false;
        if (abteilung != null ? !abteilung.equals(institution.abteilung) : institution.abteilung != null) return false;
        if (ansprechpartner != null ? !ansprechpartner.equals(institution.ansprechpartner) : institution.ansprechpartner != null)
            return false;
        if (bestellsprache != null ? !bestellsprache.equals(institution.bestellsprache) : institution.bestellsprache != null)
            return false;
        if (bundesland != null ? !bundesland.equals(institution.bundesland) : institution.bundesland != null) return false;
        if (email != null ? !email.equals(institution.email) : institution.email != null) return false;
        if (fax != null ? !fax.equals(institution.fax) : institution.fax != null) return false;
        if (id != null ? !id.equals(institution.id) : institution.id != null) return false;
        if (kennwort != null ? !kennwort.equals(institution.kennwort) : institution.kennwort != null) return false;
        if (kommentar != null ? !kommentar.equals(institution.kommentar) : institution.kommentar != null) return false;
        if (land != null ? !land.equals(institution.land) : institution.land != null) return false;
        if (plz_ort != null ? !plz_ort.equals(institution.plz_ort) : institution.plz_ort != null) return false;
        if (postfach != null ? !postfach.equals(institution.postfach) : institution.postfach != null) return false;
        if (status != null ? !status.equals(institution.status) : institution.status != null) return false;
        if (strasse != null ? !strasse.equals(institution.strasse) : institution.strasse != null) return false;
        if (telefon != null ? !telefon.equals(institution.telefon) : institution.telefon != null) return false;
        if (bestellart != null ? !bestellart.equals(institution.bestellart) : institution.bestellart != null) return false;
        if (fernzugriffErlaeuterung != null ? !fernzugriffErlaeuterung.equals(institution.fernzugriffErlaeuterung) : institution.fernzugriffErlaeuterung != null) return false;
        if (zugang != null ? !zugang.equals(institution.zugang) : institution.zugang != null) return false;
        if (personengruppe != null ? !personengruppe.equals(institution.personengruppe) : institution.personengruppe != null) return false;
        if (zugangsdaten != null ? !zugangsdaten.equals(institution.zugangsdaten) : institution.zugangsdaten != null) return false;
        if (kommentarIntern != null ? !kommentarIntern.equals(institution.kommentarIntern) : institution.kommentarIntern != null) return false;
        if (internetadresse != null ? !internetadresse.equals(institution.internetadresse) : institution.internetadresse != null) return false;
        if (nutzungsURL != null ? !nutzungsURL.equals(institution.nutzungsURL) : institution.nutzungsURL != null) return false;
        if (copyrightURL != null ? !copyrightURL.equals(institution.copyrightURL) : institution.copyrightURL != null) return false;
        if (accountURL != null ? !accountURL.equals(institution.accountURL) : institution.accountURL != null) return false;
        if (statstikURL != null ? !statstikURL.equals(institution.statstikURL) : institution.statstikURL != null) return false;
        if (sfxURL != null ? !sfxURL.equals(institution.sfxURL) : institution.sfxURL != null) return false;
        if (ublogoURL != null ? !ublogoURL.equals(institution.ublogoURL) : institution.ublogoURL != null) return false;
        if (statstikZugang != null ? !statstikZugang.equals(institution.statstikZugang) : institution.statstikZugang != null) return false;
        if (fernleihe != null ? !fernleihe.equals(institution.fernleihe) : institution.fernleihe != null) return false;
        if (lizenzArt != null ? !lizenzArt.equals(institution.lizenzArt) : institution.lizenzArt != null) return false;
        if (lizenzAbbest != null ? !lizenzAbbest.equals(institution.lizenzAbbest) : institution.lizenzAbbest != null) return false;
        if (lizenzPaket != null ? !lizenzPaket.equals(institution.lizenzPaket) : institution.lizenzPaket != null) return false;
        if (lizenzVorgang != null ? !lizenzVorgang.equals(institution.lizenzVorgang) : institution.lizenzVorgang != null) return false;
        if (lizenzZust != null ? !lizenzZust.equals(institution.lizenzZust) : institution.lizenzZust != null) return false;
        if (lizenzBes != null ? !lizenzBes.equals(institution.lizenzBes) : institution.lizenzBes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;

        result = 31 * result + (bestellart != null ? bestellart.hashCode() : 0);
        result = 31 * result + (fernzugriffErlaeuterung != null ? fernzugriffErlaeuterung.hashCode() : 0);
        result = 31 * result + (zugang != null ? zugang.hashCode() : 0);
        result = 31 * result + (personengruppe != null ? personengruppe.hashCode() : 0);
        result = 31 * result + (zugangsdaten != null ? zugangsdaten.hashCode() : 0);
        result = 31 * result + (kommentarIntern != null ? kommentarIntern.hashCode() : 0);
        result = 31 * result + (nutzungsURL != null ? nutzungsURL.hashCode() : 0);
        result = 31 * result + (copyrightURL != null ? copyrightURL.hashCode() : 0);
        result = 31 * result + (accountURL != null ? accountURL.hashCode() : 0);
        result = 31 * result + (statstikURL != null ? statstikURL.hashCode() : 0);
        result = 31 * result + (sfxURL != null ? sfxURL.hashCode() : 0);
        result = 31 * result + (ublogoURL != null ? ublogoURL.hashCode() : 0);
        result = 31 * result + (statstikZugang != null ? statstikZugang.hashCode() : 0);
        result = 31 * result + (fernleihe != null ? fernleihe.hashCode() : 0);
        result = 31 * result + (lizenzArt != null ? lizenzArt.hashCode() : 0);
        result = 31 * result + (lizenzAbbest != null ? lizenzAbbest.hashCode() : 0);
        result = 31 * result + (lizenzPaket != null ? lizenzPaket.hashCode() : 0);
        result = 31 * result + (lizenzVorgang != null ? lizenzVorgang.hashCode() : 0);
        result = 31 * result + (lizenzZust != null ? lizenzZust.hashCode() : 0);
        result = 31 * result + (lizenzBes != null ? lizenzBes.hashCode() : 0);
        result = 31 * result + (internetadresse != null ? internetadresse.hashCode() : 0);
        result = 31 * result + (abteilung != null ? abteilung.hashCode() : 0);
        result = 31 * result + (strasse != null ? strasse.hashCode() : 0);
        result = 31 * result + (postfach != null ? postfach.hashCode() : 0);
        result = 31 * result + (plz_ort != null ? plz_ort.hashCode() : 0);
        result = 31 * result + (bundesland != null ? bundesland.hashCode() : 0);
        result = 31 * result + (land != null ? land.hashCode() : 0);
        result = 31 * result + (ansprechpartner != null ? ansprechpartner.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        result = 31 * result + (bestellsprache != null ? bestellsprache.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (kommentar != null ? kommentar.hashCode() : 0);
        result = 31 * result + (kennwort != null ? kennwort.hashCode() : 0);
        return result;
    }

    public String toString(){
        return ("" + id + " " + abteilung);
    }

    @ManyToOne
    public Bibliotheksmitarbeiter getBibliotheksmitarbeiter() {
        return bibliotheksmitarbeiter;
    }

    public void setBibliotheksmitarbeiter(Bibliotheksmitarbeiter bibliotheksmitarbeiter) {
        this.bibliotheksmitarbeiter = bibliotheksmitarbeiter;
    }
}
