package ejportal.webapp.action;

import ejportal.service.FachManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ev55esul
 * Date: 02.08.2010
 * Time: 17:29:53
 * To change this template use File | Settings | File Templates.
 */
public class FachListAction extends JournalBaseAction{
    private FachManager fachManager;
    private List faecher;

    //fuer die Suche
    String fachName;


     public void setFachManager(FachManager fachManager) {
        this.fachManager = fachManager;
    }


    public List getFaecher() {
        return faecher;
    }

    public String listAll() {
        faecher = fachManager.getAll();
        return SUCCESS;
    }

   //Suche
    public void setFachName(String fachName) {
        this.fachName = fachName;
    }

    public String search() {
         int maxResults = 100;
/*        if(!fachName.equals("")){
            faecher = fachManager.findByFachName(fachName);
        }
        else{
            //TODO Ist das so gewuenscht? Ohne Suchparameter --> alle laden?!?!?!
            faecher = fachManager.getAll();
        }*/
        faecher = fachManager.findByFachName(fachName, maxResults);
        if (faecher.size() == maxResults) {
            saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als " + faecher.size() + " F&auml;cher gefunden wurden.");
            saveMessage("Die ersten " + maxResults + " Ergebnisse werden angezeigt.");
        }
        return SUCCESS;
    }


}