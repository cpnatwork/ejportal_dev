package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 09.08.2010
 * Time: 11:50:47
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="ezb1")
@SecondaryTables({
        @SecondaryTable(name="ezb2"),
        @SecondaryTable(name="ezb3")
})
public class EzbDaten extends BaseObject {

    private long ezbId;
    private String titel;
    private String zdbNummer;
    private int ampelfarbe;
    private String verlag;
    private String typ;
    private String preistyp;
    private String zugangsbedingung;
    private String issne;
    private String issnp;
    private String biburl;
    private String volltexturl;
    private String frontdoorurl;
    private String link;

    @Id
    public long getEzbId() {
        return ezbId;
    }

    public void setEzbId(long ezbId) {
        this.ezbId = ezbId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }


    public int getAmpelfarbe() {
        return ampelfarbe;
    }

    public void setAmpelfarbe(int ampelfarbe) {
        this.ampelfarbe = ampelfarbe;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getPreistyp() {
        return preistyp;
    }

    public void setPreistyp(String preistyp) {
        this.preistyp = preistyp;
    }

    public String getZugangsbedingung() {
        return zugangsbedingung;
    }

    public void setZugangsbedingung(String zugangsbedingung) {
        this.zugangsbedingung = zugangsbedingung;
    }

    @Column(table="ezb2")
    public String getIssne() {
        return issne;
    }

    public void setIssne(String issne) {
        this.issne = issne;
    }

    @Column(table="ezb2")
    public String getIssnp() {
        return issnp;
    }

    public void setIssnp(String issnp) {
        this.issnp = issnp;
    }

    @Column(table="ezb2")
    public String getZdbNummer() {
        return zdbNummer;
    }

    public void setZdbNummer(String zdbNummer) {
        this.zdbNummer = zdbNummer;
    }

    @Column(table="ezb2")
    public String getBiburl() {
        return biburl;
    }

    public void setBiburl(String biburl) {
        this.biburl = biburl;
    }

    @Column(table="ezb3")
    public String getVolltexturl() {
        return volltexturl;
    }

    public void setVolltexturl(String volltexturl) {
        this.volltexturl = volltexturl;
    }

    @Column(table="ezb3")
    public String getFrontdoorurl() {
        return frontdoorurl;
    }

    public void setFrontdoorurl(String frontdoorurl) {
        this.frontdoorurl = frontdoorurl;
    }

    @Column(table="ezb3")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EzbDaten ezbDaten = (EzbDaten) o;

        if (ampelfarbe != ezbDaten.ampelfarbe) return false;
        if (ezbId != ezbDaten.ezbId) return false;
        if (biburl != null ? !biburl.equals(ezbDaten.biburl) : ezbDaten.biburl != null) return false;
        if (frontdoorurl != null ? !frontdoorurl.equals(ezbDaten.frontdoorurl) : ezbDaten.frontdoorurl != null)
            return false;
        if (issne != null ? !issne.equals(ezbDaten.issne) : ezbDaten.issne != null) return false;
        if (issnp != null ? !issnp.equals(ezbDaten.issnp) : ezbDaten.issnp != null) return false;
        if (link != null ? !link.equals(ezbDaten.link) : ezbDaten.link != null) return false;
        if (preistyp != null ? !preistyp.equals(ezbDaten.preistyp) : ezbDaten.preistyp != null) return false;
        if (titel != null ? !titel.equals(ezbDaten.titel) : ezbDaten.titel != null) return false;
        if (typ != null ? !typ.equals(ezbDaten.typ) : ezbDaten.typ != null) return false;
        if (verlag != null ? !verlag.equals(ezbDaten.verlag) : ezbDaten.verlag != null) return false;
        if (volltexturl != null ? !volltexturl.equals(ezbDaten.volltexturl) : ezbDaten.volltexturl != null)
            return false;
        if (zdbNummer != null ? !zdbNummer.equals(ezbDaten.zdbNummer) : ezbDaten.zdbNummer != null) return false;
        if (zugangsbedingung != null ? !zugangsbedingung.equals(ezbDaten.zugangsbedingung) : ezbDaten.zugangsbedingung != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (ezbId ^ (ezbId >>> 32));
        result = 31 * result + (titel != null ? titel.hashCode() : 0);
        result = 31 * result + (zdbNummer != null ? zdbNummer.hashCode() : 0);
        result = 31 * result + ampelfarbe;
        result = 31 * result + (verlag != null ? verlag.hashCode() : 0);
        result = 31 * result + (typ != null ? typ.hashCode() : 0);
        result = 31 * result + (preistyp != null ? preistyp.hashCode() : 0);
        result = 31 * result + (zugangsbedingung != null ? zugangsbedingung.hashCode() : 0);
        result = 31 * result + (issne != null ? issne.hashCode() : 0);
        result = 31 * result + (issnp != null ? issnp.hashCode() : 0);
        result = 31 * result + (biburl != null ? biburl.hashCode() : 0);
        result = 31 * result + (volltexturl != null ? volltexturl.hashCode() : 0);
        result = 31 * result + (frontdoorurl != null ? frontdoorurl.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EzbDaten{" +
                "ezbId=" + ezbId +
                ", titel='" + titel + '\'' +
                ", zdbNummer='" + zdbNummer + '\'' +
                ", ampelfarbe=" + ampelfarbe +
                ", verlag='" + verlag + '\'' +
                ", typ='" + typ + '\'' +
                ", preistyp='" + preistyp + '\'' +
                ", zugangsbedingung='" + zugangsbedingung + '\'' +
                ", issne='" + issne + '\'' +
                ", issnp='" + issnp + '\'' +
                ", biburl='" + biburl + '\'' +
                ", volltexturl='" + volltexturl + '\'' +
                ", frontdoorurl='" + frontdoorurl + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
