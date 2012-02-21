package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 09.08.2010
 * Time: 15:35:49
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Besteller extends BaseObject {

    private Long bestellerId;
    private Sigel sigel;
    private String anrede;
    private String bestellerName;
    private String funktion;
    private String projekt;
    private float einzahlungErwuenscht;
    private float einzahlungFestgelegt;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getBestellerId() {
        return bestellerId;
    }

    public void setBestellerId(Long bestellerId) {
        this.bestellerId = bestellerId;
    }

    @ManyToOne
    public Sigel getSigel() {
        return sigel;
    }

    public void setSigel(Sigel sigel) {
        this.sigel = sigel;
    }

    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public String getBestellerName() {
        return bestellerName;
    }

    public void setBestellerName(String bestellerName) {
        this.bestellerName = bestellerName;
    }

    public String getFunktion() {
        return funktion;
    }

    public void setFunktion(String funktion) {
        this.funktion = funktion;
    }

    public String getProjekt() {
        return projekt;
    }

    public void setProjekt(String projekt) {
        this.projekt = projekt;
    }

    public float getEinzahlungErwuenscht() {
        return einzahlungErwuenscht;
    }

    public void setEinzahlungErwuenscht(float einzahlungErwuenscht) {
        this.einzahlungErwuenscht = einzahlungErwuenscht;
    }

    public float getEinzahlungFestgelegt() {
        return einzahlungFestgelegt;
    }

    public void setEinzahlungFestgelegt(float einzahlungFestgelegt) {
        this.einzahlungFestgelegt = einzahlungFestgelegt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Besteller besteller = (Besteller) o;

        if (Float.compare(besteller.einzahlungErwuenscht, einzahlungErwuenscht) != 0) return false;
        if (Float.compare(besteller.einzahlungFestgelegt, einzahlungFestgelegt) != 0) return false;
        if (anrede != null ? !anrede.equals(besteller.anrede) : besteller.anrede != null) return false;
        if (bestellerId != null ? !bestellerId.equals(besteller.bestellerId) : besteller.bestellerId != null)
            return false;
        if (bestellerName != null ? !bestellerName.equals(besteller.bestellerName) : besteller.bestellerName != null)
            return false;
        if (funktion != null ? !funktion.equals(besteller.funktion) : besteller.funktion != null) return false;
        if (projekt != null ? !projekt.equals(besteller.projekt) : besteller.projekt != null) return false;
        if (sigel != null ? !sigel.equals(besteller.sigel) : besteller.sigel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bestellerId != null ? bestellerId.hashCode() : 0;
        result = 31 * result + (sigel != null ? sigel.hashCode() : 0);
        result = 31 * result + (anrede != null ? anrede.hashCode() : 0);
        result = 31 * result + (bestellerName != null ? bestellerName.hashCode() : 0);
        result = 31 * result + (funktion != null ? funktion.hashCode() : 0);
        result = 31 * result + (projekt != null ? projekt.hashCode() : 0);
        result = 31 * result + (einzahlungErwuenscht != +0.0f ? Float.floatToIntBits(einzahlungErwuenscht) : 0);
        result = 31 * result + (einzahlungFestgelegt != +0.0f ? Float.floatToIntBits(einzahlungFestgelegt) : 0);
        return result;
    }

    public String toString() {
        return anrede +" "+ bestellerName;
    }
}
