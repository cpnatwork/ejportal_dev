package ejportal.service.dto;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 04.08.2010
 * Time: 15:50:30
 * To change this template use File | Settings | File Templates.
 */
public class SigelSearchTO {
    private String name;
    private String bibliothek;
    private String fakultaet;


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
}
