package ejportal.model;


/**
 * Created by IntelliJ IDEA.
 * User: Martin
 * Date: 07.07.2010
 * Time: 13:09:42
 * To change this template use File | Settings | File Templates.
 */

import org.appfuse.model.BaseObject;
import javax.persistence.*;
import java.lang.Long;
import java.util.Date;

@Entity
public class Exemplar extends BaseObject  {

    private Long exemplarId;

    private Sigel besteller;
    private Sigel eigentuemer;
    private Sigel zustaendigeBib;
    private Journal journal;
    private Institution lieferant;

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
    private String abbestellung;    /*abbestellt, Abbestellungswunsch*/
    private Date umbestZum;
    private String umbestellung;


    public String toString(){
        return "";
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getExemplarId() {
        return exemplarId;
    }

    public void setExemplarId(Long exemplarId) {
        this.exemplarId = exemplarId;
    }

    @ManyToOne
    public Sigel getBesteller() {
        return besteller;
    }

    public void setBesteller(Sigel besteller) {
        this.besteller = besteller;
    }

    @ManyToOne
    public Sigel getEigentuemer() {
        return eigentuemer;
    }

    public void setEigentuemer(Sigel eigentuemer) {
        this.eigentuemer = eigentuemer;
    }

    @ManyToOne
    public Sigel getZustaendigeBib() {
        return zustaendigeBib;
    }

    public void setZustaendigeBib(Sigel zustaendigeBib) {
        this.zustaendigeBib = zustaendigeBib;
    }

    @ManyToOne
    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    @ManyToOne
    public Institution getLieferant() {
        return lieferant;
    }

    
    public void setLieferant(Institution lieferant) {
        this.lieferant = lieferant;
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

    @Column(length = 2000)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exemplar)) return false;

        Exemplar exemplar = (Exemplar) o;

        if (exemplarId != exemplar.exemplarId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = exemplarId != null ? exemplarId.hashCode() : 0;
        result = 31 * result + (besteller != null ? besteller.hashCode() : 0);
        result = 31 * result + (eigentuemer != null ? eigentuemer.hashCode() : 0);
        result = 31 * result + (zustaendigeBib != null ? zustaendigeBib.hashCode() : 0);
        result = 31 * result + (journal != null ? journal.hashCode() : 0);
        result = 31 * result + (lieferant != null ? lieferant.hashCode() : 0);
        result = 31 * result + (beteiligung != null ? beteiligung.hashCode() : 0);
        result = 31 * result + (form != null ? form.hashCode() : 0);
        result = 31 * result + (zugangsart != null ? zugangsart.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (bestellnummer != null ? bestellnummer.hashCode() : 0);
        result = 31 * result + (kundennummer != null ? kundennummer.hashCode() : 0);
        result = 31 * result + (abonummer != null ? abonummer.hashCode() : 0);
        result = 31 * result + (privatabo ? 1 : 0);
        result = 31 * result + (exKommentar != null ? exKommentar.hashCode() : 0);
        result = 31 * result + (printexBayern != null ? printexBayern.hashCode() : 0);
        result = 31 * result + (abbestZum != null ? abbestZum.hashCode() : 0);
        result = 31 * result + (abbestellung != null ? abbestellung.hashCode() : 0);
        result = 31 * result + (umbestZum != null ? umbestZum.hashCode() : 0);
        result = 31 * result + (umbestellung != null ? umbestellung.hashCode() : 0);
        return result;
    }
}
