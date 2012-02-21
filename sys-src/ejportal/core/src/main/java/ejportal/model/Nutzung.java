package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.*;


/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 09.08.2010
 * Time: 15:33:54
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Nutzung extends BaseObject {
    private Journal journal;

    private Long nutzungId;
    private Integer zugriffe;
    private Integer zeitraum;
    private Integer nutzungsjahr;
    private Float rechnungsbetrag;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getNutzungId() {
        return nutzungId;
    }

    public void setNutzungId(Long nutzungId) {
        this.nutzungId = nutzungId;
    }

    @ManyToOne
    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public Integer getZugriffe() {
        return zugriffe;
    }

    public void setZugriffe(Integer zugriffe) {
        this.zugriffe = zugriffe;
    }

    public Integer getZeitraum() {
        return zeitraum;
    }

    public void setZeitraum(Integer zeitraum) {
        this.zeitraum = zeitraum;
    }

    public Integer getNutzungsjahr() {
        return nutzungsjahr;
    }

    public void setNutzungsjahr(Integer nutzungsjahr) {
        this.nutzungsjahr = nutzungsjahr;
    }

    public Float getRechnungsbetrag() {
        return rechnungsbetrag;
    }

    public void setRechnungsbetrag(Float rechnungsbetrag) {
        this.rechnungsbetrag = rechnungsbetrag;
    }

    @Override
    public String toString() {
        return "Nutzung{" +
                "nutzungId=" + nutzungId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nutzung nutzung = (Nutzung) o;

        if (nutzungId != null ? !nutzungId.equals(nutzung.nutzungId) : nutzung.nutzungId != null) return false;
        if (nutzungsjahr != null ? !nutzungsjahr.equals(nutzung.nutzungsjahr) : nutzung.nutzungsjahr != null)
            return false;
        if (rechnungsbetrag != null ? !rechnungsbetrag.equals(nutzung.rechnungsbetrag) : nutzung.rechnungsbetrag != null)
            return false;
        if (zeitraum != null ? !zeitraum.equals(nutzung.zeitraum) : nutzung.zeitraum != null) return false;
        if (zugriffe != null ? !zugriffe.equals(nutzung.zugriffe) : nutzung.zugriffe != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nutzungId != null ? nutzungId.hashCode() : 0;
        result = 31 * result + (zugriffe != null ? zugriffe.hashCode() : 0);
        result = 31 * result + (zeitraum != null ? zeitraum.hashCode() : 0);
        result = 31 * result + (nutzungsjahr != null ? nutzungsjahr.hashCode() : 0);
        result = 31 * result + (rechnungsbetrag != null ? rechnungsbetrag.hashCode() : 0);
        return result;
    }
}
