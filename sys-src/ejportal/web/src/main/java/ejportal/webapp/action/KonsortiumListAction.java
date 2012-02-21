package ejportal.webapp.action;

import ejportal.service.KonsortiumManager;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * User: Janine
 * Date: 14.07.2010
 * Time: 16:05:53
 * To change this template use File | Settings | File Templates.
 */
public class KonsortiumListAction extends JournalBaseAction{
    private KonsortiumManager konsortiumManager;
    private List konsortien;

    //fuer die Suche
    String konsortiumName;


     public void setKonsortiumManager(KonsortiumManager konsortiumManager) {
        this.konsortiumManager = konsortiumManager;
    }

    public List getKonsortien() {
        return konsortien;
    }

    public String listAll() {
        konsortien = konsortiumManager.getAll();
        return SUCCESS;
    }


    //Suche
    public void setKonsortiumName(String konsortiumName) {
        this.konsortiumName = konsortiumName;
    }

    public String search() {
        int maxResults = 100;
        konsortien = konsortiumManager.findByKonsortiumName(konsortiumName, maxResults);

        if(konsortien.size() == maxResults){
            saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als " + konsortien.size() + " Konsortien gefunden wurden.");
            saveMessage("Die ersten " + maxResults + " Ergebnisse werden angezeigt.");
        }
        //TODO Fehlerbehandlung Suche
        return SUCCESS;
    }


}