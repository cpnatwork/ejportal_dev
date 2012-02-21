package ejportal.service.dto;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 10.08.2010
 * Time: 13:38:56
 * To change this template use File | Settings | File Templates.
 */
public class RechnungBaseTO {

    private Long rechnungId;

    private float betrag;
    private String bezugsform;
    private String bezugsjahr;

    public Long getRechnungId() {
        return rechnungId;
    }

    public void setRechnungId(Long rechnungId) {
        this.rechnungId = rechnungId;
    }

    public float getBetrag() {
        return betrag;
    }

    public void setBetrag(float betrag) {
        this.betrag = betrag;
    }

    public String getBezugsform() {
        return bezugsform;
    }

    public void setBezugsform(String bezugsform) {
        this.bezugsform = bezugsform;
    }

    public String getBezugsjahr() {
        return bezugsjahr;
    }

    public void setBezugsjahr(String bezugsjahr) {
        this.bezugsjahr = bezugsjahr;
    }
}
