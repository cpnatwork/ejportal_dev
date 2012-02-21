package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 15:55:15
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Lizenzdetail extends BaseObject{
    private Long lizenzId;
    private Institution verlag;
    private String beginn;
    private String laufzeit;
    private String verlaengerung;
    private float kosten;
    private String readmeAktualisiert;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getLizenzId() {
        return lizenzId;
    }

    public void setLizenzId(Long lizenzId) {
        this.lizenzId = lizenzId;
    }

    @ManyToOne
    public Institution getVerlag() {
        return verlag;
    }

    public void setVerlag(Institution verlag) {
        this.verlag = verlag;
    }

    public String getBeginn() {
        return beginn;
    }

    public void setBeginn(String beginn) {
        this.beginn = beginn;
    }

    public String getLaufzeit() {
        return laufzeit;
    }

    public void setLaufzeit(String laufzeit) {
        this.laufzeit = laufzeit;
    }

    public String getVerlaengerung() {
        return verlaengerung;
    }

    public void setVerlaengerung(String verlaengerung) {
        this.verlaengerung = verlaengerung;
    }

    public float getKosten() {
        return kosten;
    }

    public void setKosten(float kosten) {
        this.kosten = kosten;
    }

    public String getReadmeAktualisiert() {
        return readmeAktualisiert;
    }

    public void setReadmeAktualisiert(String readmeAktualisiert) {
        this.readmeAktualisiert = readmeAktualisiert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lizenzdetail that = (Lizenzdetail) o;

        if (Float.compare(that.kosten, kosten) != 0) return false;
        if (beginn != null ? !beginn.equals(that.beginn) : that.beginn != null) return false;
        if (laufzeit != null ? !laufzeit.equals(that.laufzeit) : that.laufzeit != null) return false;
        if (lizenzId != null ? !lizenzId.equals(that.lizenzId) : that.lizenzId != null) return false;
        if (readmeAktualisiert != null ? !readmeAktualisiert.equals(that.readmeAktualisiert) : that.readmeAktualisiert != null)
            return false;
        if (verlaengerung != null ? !verlaengerung.equals(that.verlaengerung) : that.verlaengerung != null)
            return false;
        if (verlag != null ? !verlag.equals(that.verlag) : that.verlag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lizenzId != null ? lizenzId.hashCode() : 0;
        result = 31 * result + (verlag != null ? verlag.hashCode() : 0);
        result = 31 * result + (beginn != null ? beginn.hashCode() : 0);
        result = 31 * result + (laufzeit != null ? laufzeit.hashCode() : 0);
        result = 31 * result + (verlaengerung != null ? verlaengerung.hashCode() : 0);
        result = 31 * result + (kosten != +0.0f ? Float.floatToIntBits(kosten) : 0);
        result = 31 * result + (readmeAktualisiert != null ? readmeAktualisiert.hashCode() : 0);
        return result;
    }

    public String toString(){
        return "" + lizenzId + " " + laufzeit;
    }
}
