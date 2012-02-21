package ejportal.service.dto;

import ejportal.model.Journal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 07.07.2010
 * Time: 12:51:40
 * To change this template use File | Settings | File Templates.
 */
public class InstitutionBaseTO {
    private Long id;
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

    public List<Journal> getVerlagJournals() {
        return verlagJournals;
    }

    public void setVerlagJournals(List<Journal> verlagJournals) {
        this.verlagJournals = verlagJournals;
    }

    public List<Journal> getProviderJournals() {
        return providerJournals;
    }

    public void setProviderJournals(List<Journal> providerJournals) {
        this.providerJournals = providerJournals;
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

    public String getLizenzBes() {
        return lizenzBes;
    }

    public void setLizenzBes(String lizenzBes) {
        this.lizenzBes = lizenzBes;
    }

}
