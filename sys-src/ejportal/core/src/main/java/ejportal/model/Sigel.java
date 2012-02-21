package ejportal.model;

import org.appfuse.model.BaseObject;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Christoph
 * Date: 28.06.2010
 * Time: 15:02:30
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Sigel extends BaseObject {
    private Long sigelId;
    private String name;
    private String bibliothek;
    private String fakultaet;
    private String persEmail;
    private String bibAnsprechpartner1;
    private String bibAnsprechpartner2;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getSigelId() {
        return sigelId;
    }

    public void setSigelId(Long sigelId) {
        this.sigelId = sigelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBibliothek() {
        return bibliothek;
    }

    public void setBibliothek(String bibliothek) {
        this.bibliothek = bibliothek;
    }

    public String getFakultaet() {
        return fakultaet;
    }

    public void setFakultaet(String fakultaet) {
        this.fakultaet = fakultaet;
    }

    public String getPersEmail() {
        return persEmail;
    }

    public void setPersEmail(String persEmail) {
        this.persEmail = persEmail;
    }

    public String getBibAnsprechpartner1() {
        return bibAnsprechpartner1;
    }

    public void setBibAnsprechpartner1(String bibAnsprechpartner1) {
        this.bibAnsprechpartner1 = bibAnsprechpartner1;
    }

    public String getBibAnsprechpartner2() {
        return bibAnsprechpartner2;
    }

    public void setBibAnsprechpartner2(String bibAnsprechpartner2) {
        this.bibAnsprechpartner2 = bibAnsprechpartner2;
    }

    @Override
    public String toString() {
        return sigelId + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sigel sigel1 = (Sigel) o;

        if (bibAnsprechpartner1 != null ? !bibAnsprechpartner1.equals(sigel1.bibAnsprechpartner1) : sigel1.bibAnsprechpartner1 != null)
            return false;
        if (bibAnsprechpartner2 != null ? !bibAnsprechpartner2.equals(sigel1.bibAnsprechpartner2) : sigel1.bibAnsprechpartner2 != null)
            return false;
        if (bibliothek != null ? !bibliothek.equals(sigel1.bibliothek) : sigel1.bibliothek != null) return false;
        if (fakultaet != null ? !fakultaet.equals(sigel1.fakultaet) : sigel1.fakultaet != null) return false;
        if (sigelId != null ? !sigelId.equals(sigel1.sigelId) : sigel1.sigelId != null) return false;
        if (persEmail != null ? !persEmail.equals(sigel1.persEmail) : sigel1.persEmail != null) return false;
        if (name != null ? !name.equals(sigel1.name) : sigel1.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sigelId != null ? sigelId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (bibliothek != null ? bibliothek.hashCode() : 0);
        result = 31 * result + (fakultaet != null ? fakultaet.hashCode() : 0);
        result = 31 * result + (persEmail != null ? persEmail.hashCode() : 0);
        result = 31 * result + (bibAnsprechpartner1 != null ? bibAnsprechpartner1.hashCode() : 0);
        result = 31 * result + (bibAnsprechpartner2 != null ? bibAnsprechpartner2.hashCode() : 0);
        return result;
    }
}
