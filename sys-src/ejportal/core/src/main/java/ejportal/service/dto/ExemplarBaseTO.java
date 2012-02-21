package ejportal.service.dto;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 04.08.2010
 * Time: 15:00:05
 * To change this template use File | Settings | File Templates.
 */
public class ExemplarBaseTO {

    private Long exemplarId;

    private String beteiligung;     /* Werte: Autor, Herausgeber, Mitglied */
    private String form;            /* Werte: Online, Print, Print + Online, Online Kons-Anteil */
    private String zugangsart;      /* Werte: Geschenk / Spende, Kauf, kein Abo., Konsortium, Mitgliedschaft */
    private String status;          /* Werte: bearbeiten, beendet, kein Abo., laufend, zentral bestellt,   */
    private String bestellnummer;
    private String kundennummer;
    private String abonummer;
    private boolean privatabo;
    private String exKommentar;
    private String printexBayern;
    private Date abbestZum;
    private String abbestellung;
    private Date umbestZum;
    private String umbestellung;

    public Long getExemplarId() {
        return exemplarId;
    }

    public void setExemplarId(Long exemplarId) {
        this.exemplarId = exemplarId;
    }

    public String getBeteiligung() {
        return beteiligung;
    }

    public void setBeteiligung(String beteiligung) {
        this.beteiligung = beteiligung;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getZugangsart() {
        return zugangsart;
    }

    public void setZugangsart(String zugangsart) {
        this.zugangsart = zugangsart;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(String bestellnummer) {
        this.bestellnummer = bestellnummer;
    }

    public String getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(String kundennummer) {
        this.kundennummer = kundennummer;
    }

    public String getAbonummer() {
        return abonummer;
    }

    public void setAbonummer(String abonummer) {
        this.abonummer = abonummer;
    }

    public boolean getPrivatabo() {
        return privatabo;
    }

    public void setPrivatabo(boolean privatabo) {
        this.privatabo = privatabo;
    }

    public String getExKommentar() {
        return exKommentar;
    }

    public void setExKommentar(String exKommentar) {
        this.exKommentar = exKommentar;
    }

    public String getPrintexBayern() {
        return printexBayern;
    }

    public void setPrintexBayern(String printexBayern) {
        this.printexBayern = printexBayern;
    }

    public Date getAbbestZum() {
        return abbestZum;
    }

    public void setAbbestZum(Date abbestZum) {
        this.abbestZum = abbestZum;
    }

    public String getAbbestellung() {
        return abbestellung;
    }

    public void setAbbestellung(String abbestellung) {
        this.abbestellung = abbestellung;
    }

    public Date getUmbestZum() {
        return umbestZum;
    }

    public void setUmbestZum(Date umbestZum) {
        this.umbestZum = umbestZum;
    }

    public String getUmbestellung() {
        return umbestellung;
    }

    public void setUmbestellung(String umbestellung) {
        this.umbestellung = umbestellung;
    }
}
