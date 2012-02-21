package ejportal.webapp.action;

import ejportal.service.PaketManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Janine
 * Date: 19.07.2010
 * Time: 14:03:47
 * To change this template use File | Settings | File Templates.
 */
public class PaketListAction extends JournalBaseAction {
    private PaketManager paketManager;
    private List pakete;

    private String paketName;    //fuer die Suche

    public void setPaketManager(PaketManager paketManager) {
        this.paketManager = paketManager;
    }

    public List getPakete() {
        return pakete;
    }

    public String listAll() {
        pakete = paketManager.getAll();
        return SUCCESS;
    }


    //Suche

    public void setPaketName(String paketName) {
        this.paketName = paketName;
    }

    public String search() {
        int maxResults = 100;

        /*if(!paketName.equals("")){
            pakete = paketManager.findByPaketName(paketName);
        }
        else{
            //TODO Ist das so gewuenscht? Ohne Suchparameter --> alle laden?!?!?!
            pakete = paketManager.getAll();
        }*/
        pakete = paketManager.findByPaketName(paketName, maxResults);

        if (pakete.size() == maxResults) {
            saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als " + pakete.size() + " Pakete gefunden wurden.");
            saveMessage("Die ersten " + maxResults + " Ergebnisse werden angezeigt.");
        }
        //TODO Fehlerbehandlung Suche        
        return SUCCESS;
    }
}