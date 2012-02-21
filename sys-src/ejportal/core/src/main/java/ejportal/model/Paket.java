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
 * Time: 15:51:23
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Paket extends BaseObject {
    private Long paketId;
    private String paketName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getPaketId() {
        return paketId;
    }

    public void setPaketId(Long paketId) {
        this.paketId = paketId;
    }

    public String getPaketName() {
        return paketName;
    }

    public void setPaketName(String paketName) {
        this.paketName = paketName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Paket paket = (Paket) o;

        if (paketId != null ? !paketId.equals(paket.paketId) : paket.paketId != null) return false;
        if (paketName != null ? !paketName.equals(paket.paketName) : paket.paketName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paketId != null ? paketId.hashCode() : 0;
        result = 31 * result + (paketName != null ? paketName.hashCode() : 0);
        return result;
    }

    public String toString(){
        return "" + paketId + " " + paketName;
    }
}
