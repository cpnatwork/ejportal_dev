package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 09.08.2010
 * Time: 15:54:50
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Interesse extends BaseObject {

    Long interesseId;
    String interesse;
    Journal journal;
    Besteller besteller;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getInteresseId() {
        return interesseId;
    }

    public void setInteresseId(Long interesseId) {
        this.interesseId = interesseId;
    }

    public String getInteresse() {
        return interesse;
    }

    public void setInteresse(String interesse) {
        this.interesse = interesse;
    }

    @ManyToOne
    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    @ManyToOne
    public Besteller getBesteller() {
        return besteller;
    }

    public void setBesteller(Besteller besteller) {
        this.besteller = besteller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interesse interesse1 = (Interesse) o;

        if (besteller != null ? !besteller.equals(interesse1.besteller) : interesse1.besteller != null) return false;
        if (interesse != null ? !interesse.equals(interesse1.interesse) : interesse1.interesse != null) return false;
        if (interesseId != null ? !interesseId.equals(interesse1.interesseId) : interesse1.interesseId != null)
            return false;
        if (journal != null ? !journal.equals(interesse1.journal) : interesse1.journal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = interesseId != null ? interesseId.hashCode() : 0;
        result = 31 * result + (interesse != null ? interesse.hashCode() : 0);
        result = 31 * result + (journal != null ? journal.hashCode() : 0);
        result = 31 * result + (besteller != null ? besteller.hashCode() : 0);
        return result;
    }

    public String toString() {
        return interesse;
    }
}
