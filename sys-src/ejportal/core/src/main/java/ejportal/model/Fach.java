package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 15:42:45
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Fach extends BaseObject {
    private Long fachId;
    private String fachName;
    private Set<Journal> journals =  new HashSet<Journal>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getFachId() {
        return fachId;
    }

    public void setFachId(Long fachId) {
        this.fachId = fachId;
    }

    public String getFachName() {
        return fachName;
    }

    public void setFachName(String fachName) {
        this.fachName = fachName;
    }

    @ManyToMany
    @JoinTable(name="Journal_Fach",
                joinColumns={@JoinColumn(name="fachId")},
                inverseJoinColumns={@JoinColumn(name="journalId")})
    public Set<Journal> getJournals() {
        return journals;
    }

    public void setJournals(Set<Journal> journals) {
        this.journals = journals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fach fach = (Fach) o;

        if (fachId != null ? !fachId.equals(fach.fachId) : fach.fachId != null) return false;
        if (fachName != null ? !fachName.equals(fach.fachName) : fach.fachName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fachId != null ? fachId.hashCode() : 0;
        result = 31 * result + (fachName != null ? fachName.hashCode() : 0);
        return result;
    }

    public String toString(){
        return "" + fachId + " " + fachName;
    }
}
