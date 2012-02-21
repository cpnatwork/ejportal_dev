package ejportal.service.dto;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 10.08.2010
 * Time: 11:22:54
 * To change this template use File | Settings | File Templates.
 */
public class BestellerBaseTO {
    private Long bestellerId;
    private String anrede;
    private String bestellerName;
    private String funktion;
    private String projekt;
    private float einzahlungErwuenscht;
    private float einzahlungFestgelegt;

    public Long getBestellerId() {
        return bestellerId;
    }

    public void setBestellerId(Long bestellerId) {
        this.bestellerId = bestellerId;
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
}
