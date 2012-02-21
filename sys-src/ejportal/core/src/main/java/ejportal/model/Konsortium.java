package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 15:54:00
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Konsortium extends BaseObject{
    private Long konsortiumId;
    private String konsortiumName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getKonsortiumId() {
        return konsortiumId;
    }

    public void setKonsortiumId(Long konsortiumId) {
        this.konsortiumId = konsortiumId;
    }

    public String getKonsortiumName() {
        return konsortiumName;
    }

    public void setKonsortiumName(String konsortiumName) {
        this.konsortiumName = konsortiumName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Konsortium that = (Konsortium) o;

        if (konsortiumId != null ? !konsortiumId.equals(that.konsortiumId) : that.konsortiumId != null) return false;
        if (konsortiumName != null ? !konsortiumName.equals(that.konsortiumName) : that.konsortiumName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = konsortiumId != null ? konsortiumId.hashCode() : 0;
        result = 31 * result + (konsortiumName != null ? konsortiumName.hashCode() : 0);
        return result;
    }

    public String toString(){
        return "" + konsortiumId + " " + konsortiumName;
    }
}
