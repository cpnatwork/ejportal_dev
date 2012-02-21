package ejportal.service.dto;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 10.08.2010
 * Time: 10:29:16
 * To change this template use File | Settings | File Templates.
 */
public class EzbDatenSearchTO {
    private String ezbId;
    private String titel;
    private String zdbNummer;

    public String getEzbId() {
        return ezbId;
    }

    public void setEzbId(String ezbId) {
        this.ezbId = ezbId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getZdbNummer() {
        return zdbNummer;
    }

    public void setZdbNummer(String zdbNummer) {
        this.zdbNummer = zdbNummer;
    }
}
