package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 11.08.2010
 * Time: 12:28:22
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Wechselkurs extends BaseObject {

    private Long wechselkursId;
    private String waehrung;
    private float umrechnungsfaktor;

    // getter and setter

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getWechselkursId() {
        return wechselkursId;
    }

    public void setWechselkursId(Long id) {
        this.wechselkursId = id;
    }

    public String getWaehrung() {
        return waehrung;
    }

    public void setWaehrung(String waehrung) {
        this.waehrung = waehrung;
    }

    public float getUmrechnungsfaktor() {
        return umrechnungsfaktor;
    }

    public void setUmrechnungsfaktor(float umrechnungsfaktor) {
        this.umrechnungsfaktor = umrechnungsfaktor;
    }


    // hashcode, toString, equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wechselkurs that = (Wechselkurs) o;

        if (Float.compare(that.umrechnungsfaktor, umrechnungsfaktor) != 0) return false;
        if (wechselkursId != null ? !wechselkursId.equals(that.wechselkursId) : that.wechselkursId != null) return false;
        if (waehrung != null ? !waehrung.equals(that.waehrung) : that.waehrung != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = wechselkursId != null ? wechselkursId.hashCode() : 0;
        result = 31 * result + (waehrung != null ? waehrung.hashCode() : 0);
        result = 31 * result + (umrechnungsfaktor != +0.0f ? Float.floatToIntBits(umrechnungsfaktor) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Wechselkurs{" +
                "wechselkursId=" + wechselkursId +
                ", waehrung='" + waehrung + '\'' +
                '}';
    }
}
