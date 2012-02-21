package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 09.08.2010
 * Time: 13:59:04
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Rechnung extends BaseObject {

    private Long rechnungId;
    private Exemplar exemplar;
    private float betrag;
    private String bezugsform;
    private String bezugsjahr;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getRechnungId() {
        return rechnungId;
    }

    public void setRechnungId(Long rechnungId) {
        this.rechnungId = rechnungId;
    }

    @ManyToOne
    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public float getBetrag() {
        return betrag;
    }

    public void setBetrag(float betrag) {
        this.betrag = betrag;
    }

    public String getBezugsform() {
        return bezugsform;
    }

    public void setBezugsform(String bezugsform) {
        this.bezugsform = bezugsform;
    }

    public String getBezugsjahr() {
        return bezugsjahr;
    }

    public void setBezugsjahr(String bezugsjahr) {
        this.bezugsjahr = bezugsjahr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rechnung rechnung = (Rechnung) o;
        Float betragF = new Float(betrag);
        if (betragF != null ? !betragF.equals(rechnung.betrag) : new Float(rechnung.betrag) != null) return false;
        if (rechnungId != null ? !rechnungId.equals(rechnung.rechnungId) : rechnung.rechnungId != null)
            return false;
        if (bezugsform != null ? !bezugsform.equals(rechnung.bezugsform) : rechnung.bezugsform != null) return false;
        if (bezugsjahr != null ? !bezugsjahr.equals(rechnung.bezugsjahr) : rechnung.bezugsjahr != null) return false;
        if (exemplar != null ? !exemplar.equals(rechnung.exemplar) : rechnung.exemplar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rechnungId != null ? rechnungId.hashCode() : 0;
        result = 31 * result + (betrag != +0.0f ? Float.floatToIntBits(betrag) : 0);
        result = 31 * result + (bezugsform != null ? bezugsform.hashCode() : 0);
        result = 31 * result + (bezugsjahr != null ? bezugsjahr.hashCode() : 0);
        result = 31 * result + (exemplar != null ? exemplar.hashCode() : 0);
        return result;
    }

    public String toString(){
        return ("" + rechnungId + " " + betrag);
    }

    
}
