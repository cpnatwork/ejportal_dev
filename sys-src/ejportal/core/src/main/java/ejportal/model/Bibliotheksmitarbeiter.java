package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 14:45:18
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Bibliotheksmitarbeiter extends BaseObject {
    private Long bibId;
    private String name;
    private String abteilungsHauptstelle;
    private String fensterumschlagAdresse;
    private String hausanschrift;
    private String postanschrift;
    private String telefon;
    private String telefax;
    private String emailanschrift;
    private String url;
    private String umstId;
    private String mitarbeiter;
    private String dienstort;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getBibId() {
        return bibId;
    }

    public void setBibId(Long bibId) {
        this.bibId = bibId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbteilungsHauptstelle() {
        return abteilungsHauptstelle;
    }

    public void setAbteilungsHauptstelle(String abteilungsHauptstelle) {
        this.abteilungsHauptstelle = abteilungsHauptstelle;
    }

    public String getFensterumschlagAdresse() {
        return fensterumschlagAdresse;
    }

    public void setFensterumschlagAdresse(String fensterumschlagAdresse) {
        this.fensterumschlagAdresse = fensterumschlagAdresse;
    }

    public String getHausanschrift() {
        return hausanschrift;
    }

    public void setHausanschrift(String hausanschrift) {
        this.hausanschrift = hausanschrift;
    }

    public String getPostanschrift() {
        return postanschrift;
    }

    public void setPostanschrift(String postanschrift) {
        this.postanschrift = postanschrift;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTelefax() {
        return telefax;
    }

    public void setTelefax(String telefax) {
        this.telefax = telefax;
    }

    public String getEmailanschrift() {
        return emailanschrift;
    }

    public void setEmailanschrift(String emailanschrift) {
        this.emailanschrift = emailanschrift;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUmstId() {
        return umstId;
    }

    public void setUmstId(String umstId) {
        this.umstId = umstId;
    }

    public String getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(String mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public String getDienstort() {
        return dienstort;
    }

    public void setDienstort(String dienstort) {
        this.dienstort = dienstort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bibliotheksmitarbeiter that = (Bibliotheksmitarbeiter) o;

        if (abteilungsHauptstelle != null ? !abteilungsHauptstelle.equals(that.abteilungsHauptstelle) : that.abteilungsHauptstelle != null)
            return false;
        if (dienstort != null ? !dienstort.equals(that.dienstort) : that.dienstort != null) return false;
        if (emailanschrift != null ? !emailanschrift.equals(that.emailanschrift) : that.emailanschrift != null)
            return false;
        if (fensterumschlagAdresse != null ? !fensterumschlagAdresse.equals(that.fensterumschlagAdresse) : that.fensterumschlagAdresse != null)
            return false;
        if (hausanschrift != null ? !hausanschrift.equals(that.hausanschrift) : that.hausanschrift != null)
            return false;
        if (bibId != null ? !bibId.equals(that.bibId) : that.bibId != null) return false;
        if (mitarbeiter != null ? !mitarbeiter.equals(that.mitarbeiter) : that.mitarbeiter != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (postanschrift != null ? !postanschrift.equals(that.postanschrift) : that.postanschrift != null)
            return false;
        if (telefax != null ? !telefax.equals(that.telefax) : that.telefax != null) return false;
        if (telefon != null ? !telefon.equals(that.telefon) : that.telefon != null) return false;
        if (umstId != null ? !umstId.equals(that.umstId) : that.umstId != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bibId != null ? bibId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (abteilungsHauptstelle != null ? abteilungsHauptstelle.hashCode() : 0);
        result = 31 * result + (fensterumschlagAdresse != null ? fensterumschlagAdresse.hashCode() : 0);
        result = 31 * result + (hausanschrift != null ? hausanschrift.hashCode() : 0);
        result = 31 * result + (postanschrift != null ? postanschrift.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        result = 31 * result + (telefax != null ? telefax.hashCode() : 0);
        result = 31 * result + (emailanschrift != null ? emailanschrift.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (umstId != null ? umstId.hashCode() : 0);
        result = 31 * result + (mitarbeiter != null ? mitarbeiter.hashCode() : 0);
        result = 31 * result + (dienstort != null ? dienstort.hashCode() : 0);
        return result;
    }

    public String toString(){
        return ("" + bibId + " " + name);
    }
}
