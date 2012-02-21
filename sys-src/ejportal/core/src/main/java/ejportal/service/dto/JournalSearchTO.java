package ejportal.service.dto;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 24.06.2010
 * Time: 16:17:26
 * To change this template use File | Settings | File Templates.
 */
public class JournalSearchTO {
    private String titel="";
    private String kurztitel="";
    private String verlag="";
    private String provider="";
    private String konsortium="";
    private String paket="";
    private String zugangUeber="";

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getKurztitel() {
        return kurztitel;
    }

    public void setKurztitel(String kurztitel) {
        this.kurztitel = kurztitel;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getKonsortium() {
        return konsortium;
    }

    public void setKonsortium(String konsortium) {
        this.konsortium = konsortium;
    }

    public String getPaket() {
        return paket;
    }

    public void setPaket(String paket) {
        this.paket = paket;
    }

    public String getZugangUeber() {
        return zugangUeber;
    }

    public void setZugangUeber(String zugangUeber) {
        this.zugangUeber = zugangUeber;
    }

    @Override
    public String toString() {
        return "JournalSearchTO{" +
                "titel='" + titel + '\'' +
                ", kurztitel='" + kurztitel + '\'' +
                ", verlag='" + verlag + '\'' +
                ", provider='" + provider + '\'' +
                ", konsortium='" + konsortium + '\'' +
                ", paket='" + paket + '\'' +
                ", zugangUeber='" + zugangUeber + '\'' +
                '}';
    }
}
