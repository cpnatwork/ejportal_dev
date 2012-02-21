package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 09.08.2010
 * Time: 14:43:18
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Journalkosten extends BaseObject {

    private Long journalkostenId;

    private float oPreisPO;
    private String waehrungPO;
    private String mwStPO;

    private float oPreisO;
    private String waehrungO;
    private String mwStO;

    private float oPreisP;
    private String waehrungP;
    private String mwStP;

    private float iPreisPO;
    private String iWaehrungPO;
    private String iMwStPO;

    private float iPreisO;
    private String iWaehrungO;
    private String iMwStO;

    private float iPreisP;
    private String iWaehrungP;
    private String iMwStP;

    private float impact;
    private Date impactDatum;

    // relation

    private Journal journal;


    /* GETTER UND SETTER */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getJournalkostenId() {
        return journalkostenId;
    }

    public void setJournalkostenId(Long journalkostenId) {
        this.journalkostenId = journalkostenId;
    }

    public float getOPreisPO() {
        return oPreisPO;
    }

    public void setOPreisPO(float oPreisPO) {
        this.oPreisPO = oPreisPO;
    }

    public String getWaehrungPO() {
        return waehrungPO;
    }

    public void setWaehrungPO(String waehrungPO) {
        this.waehrungPO = waehrungPO;
    }

    public String getMwStPO() {
        return mwStPO;
    }

    public void setMwStPO(String mwStPO) {
        this.mwStPO = mwStPO;
    }

    public float getOPreisO() {
        return oPreisO;
    }

    public void setOPreisO(float oPreisO) {
        this.oPreisO = oPreisO;
    }

    public String getWaehrungO() {
        return waehrungO;
    }

    public void setWaehrungO(String waehrungO) {
        this.waehrungO = waehrungO;
    }

    public String getMwStO() {
        return mwStO;
    }

    public void setMwStO(String mwStO) {
        this.mwStO = mwStO;
    }

    public float getOPreisP() {
        return oPreisP;
    }

    public void setOPreisP(float oPreisP) {
        this.oPreisP = oPreisP;
    }

    public String getWaehrungP() {
        return waehrungP;
    }

    public void setWaehrungP(String waehrungP) {
        this.waehrungP = waehrungP;
    }

    public String getMwStP() {
        return mwStP;
    }

    public void setMwStP(String mwStP) {
        this.mwStP = mwStP;
    }

    public float getIPreisPO() {
        return iPreisPO;
    }

    public void setIPreisPO(float iPreisPO) {
        this.iPreisPO = iPreisPO;
    }

    public String getIWaehrungPO() {
        return iWaehrungPO;
    }

    public void setIWaehrungPO(String iWaehrungPO) {
        this.iWaehrungPO = iWaehrungPO;
    }

    public String getIMwStPO() {
        return iMwStPO;
    }

    public void setIMwStPO(String iMwStPO) {
        this.iMwStPO = iMwStPO;
    }

    public float getIPreisO() {
        return iPreisO;
    }

    public void setIPreisO(float iPreisO) {
        this.iPreisO = iPreisO;
    }

    public String getIWaehrungO() {
        return iWaehrungO;
    }

    public void setIWaehrungO(String iWaehrungO) {
        this.iWaehrungO = iWaehrungO;
    }

    public String getIMwStO() {
        return iMwStO;
    }

    public void setIMwStO(String iMwStO) {
        this.iMwStO = iMwStO;
    }

    public float getIPreisP() {
        return iPreisP;
    }

    public void setIPreisP(float iPreisP) {
        this.iPreisP = iPreisP;
    }

    public String getIWaehrungP() {
        return iWaehrungP;
    }

    public void setIWaehrungP(String iWaehrungP) {
        this.iWaehrungP = iWaehrungP;
    }

    public String getIMwStP() {
        return iMwStP;
    }

    public void setIMwStP(String iMwStP) {
        this.iMwStP = iMwStP;
    }

    public float getImpact() {
        return impact;
    }

    public void setImpact(float impact) {
        this.impact = impact;
    }

    public Date getImpactDatum() {
        return impactDatum;
    }

    public void setImpactDatum(Date impactDatum) {
        this.impactDatum = impactDatum;
    }
    
    @OneToOne( fetch=FetchType.EAGER )
    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Journalkosten that = (Journalkosten) o;

        if (Float.compare(that.iPreisO, iPreisO) != 0) return false;
        if (Float.compare(that.iPreisP, iPreisP) != 0) return false;
        if (Float.compare(that.iPreisPO, iPreisPO) != 0) return false;
        if (Float.compare(that.impact, impact) != 0) return false;
        if (Float.compare(that.oPreisO, oPreisO) != 0) return false;
        if (Float.compare(that.oPreisP, oPreisP) != 0) return false;
        if (Float.compare(that.oPreisPO, oPreisPO) != 0) return false;
        if (iMwStO != null ? !iMwStO.equals(that.iMwStO) : that.iMwStO != null) return false;
        if (iMwStP != null ? !iMwStP.equals(that.iMwStP) : that.iMwStP != null) return false;
        if (iMwStPO != null ? !iMwStPO.equals(that.iMwStPO) : that.iMwStPO != null) return false;
        if (iWaehrungO != null ? !iWaehrungO.equals(that.iWaehrungO) : that.iWaehrungO != null) return false;
        if (iWaehrungP != null ? !iWaehrungP.equals(that.iWaehrungP) : that.iWaehrungP != null) return false;
        if (iWaehrungPO != null ? !iWaehrungPO.equals(that.iWaehrungPO) : that.iWaehrungPO != null) return false;
        if (impactDatum != null ? !impactDatum.equals(that.impactDatum) : that.impactDatum != null) return false;
        if (journal != null ? !journal.equals(that.journal) : that.journal != null) return false;
        if (journalkostenId != null ? !journalkostenId.equals(that.journalkostenId) : that.journalkostenId != null)
            return false;
        if (mwStO != null ? !mwStO.equals(that.mwStO) : that.mwStO != null) return false;
        if (mwStP != null ? !mwStP.equals(that.mwStP) : that.mwStP != null) return false;
        if (mwStPO != null ? !mwStPO.equals(that.mwStPO) : that.mwStPO != null) return false;
        if (waehrungO != null ? !waehrungO.equals(that.waehrungO) : that.waehrungO != null) return false;
        if (waehrungP != null ? !waehrungP.equals(that.waehrungP) : that.waehrungP != null) return false;
        if (waehrungPO != null ? !waehrungPO.equals(that.waehrungPO) : that.waehrungPO != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = journalkostenId != null ? journalkostenId.hashCode() : 0;
        result = 31 * result + (oPreisPO != +0.0f ? Float.floatToIntBits(oPreisPO) : 0);
        result = 31 * result + (waehrungPO != null ? waehrungPO.hashCode() : 0);
        result = 31 * result + (mwStPO != null ? mwStPO.hashCode() : 0);
        result = 31 * result + (oPreisO != +0.0f ? Float.floatToIntBits(oPreisO) : 0);
        result = 31 * result + (waehrungO != null ? waehrungO.hashCode() : 0);
        result = 31 * result + (mwStO != null ? mwStO.hashCode() : 0);
        result = 31 * result + (oPreisP != +0.0f ? Float.floatToIntBits(oPreisP) : 0);
        result = 31 * result + (waehrungP != null ? waehrungP.hashCode() : 0);
        result = 31 * result + (mwStP != null ? mwStP.hashCode() : 0);
        result = 31 * result + (iPreisPO != +0.0f ? Float.floatToIntBits(iPreisPO) : 0);
        result = 31 * result + (iWaehrungPO != null ? iWaehrungPO.hashCode() : 0);
        result = 31 * result + (iMwStPO != null ? iMwStPO.hashCode() : 0);
        result = 31 * result + (iPreisO != +0.0f ? Float.floatToIntBits(iPreisO) : 0);
        result = 31 * result + (iWaehrungO != null ? iWaehrungO.hashCode() : 0);
        result = 31 * result + (iMwStO != null ? iMwStO.hashCode() : 0);
        result = 31 * result + (iPreisP != +0.0f ? Float.floatToIntBits(iPreisP) : 0);
        result = 31 * result + (iWaehrungP != null ? iWaehrungP.hashCode() : 0);
        result = 31 * result + (iMwStP != null ? iMwStP.hashCode() : 0);
        result = 31 * result + (impact != +0.0f ? Float.floatToIntBits(impact) : 0);
        result = 31 * result + (impactDatum != null ? impactDatum.hashCode() : 0);
        result = 31 * result + (journal != null ? journal.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Journalkosten{" +
                "journalkostenId=" + journalkostenId +
                '}';
    }
}
