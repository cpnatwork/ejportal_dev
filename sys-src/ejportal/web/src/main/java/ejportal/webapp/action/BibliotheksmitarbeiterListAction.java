package ejportal.webapp.action;

import ejportal.service.BibliotheksmitarbeiterManager;
import ejportal.service.dto.BibliotheksmitarbeiterSearchTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 05.08.2010
 * Time: 13:05:05
 * To change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterListAction extends JournalBaseAction{
    private BibliotheksmitarbeiterManager bibliotheksmitarbeiterManager;
    private BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO;
    private List bibliotheksmitarbeiters;

    //fuer die Suche
    String name;


     public void setBibliotheksmitarbeiterManager(BibliotheksmitarbeiterManager bibliotheksmitarbeiterManager) {
        this.bibliotheksmitarbeiterManager = bibliotheksmitarbeiterManager;
    }

    public List getBibliotheksmitarbeiters() {
        return bibliotheksmitarbeiters;
    }

    public String listAll() {
        bibliotheksmitarbeiters = bibliotheksmitarbeiterManager.getAll();
        return SUCCESS;
    }


    //Suche
    public void setBibliotheksmitarbeiterName(String name) {
        this.name = name;
    }

    public BibliotheksmitarbeiterSearchTO getBibliotheksmitarbeiterSearchTO() {
        return bibliotheksmitarbeiterSearchTO;
    }

    public void setBibliotheksmitarbeiterSearchTO(BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO) {
        this.bibliotheksmitarbeiterSearchTO = bibliotheksmitarbeiterSearchTO;
    }

    public String search() {
        int maxResults = 100;
        bibliotheksmitarbeiters = bibliotheksmitarbeiterManager.findBySearchTO(bibliotheksmitarbeiterSearchTO, maxResults);

        if(bibliotheksmitarbeiters.size() == maxResults){
            saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als " + bibliotheksmitarbeiters.size() + " Bibliothek gefunden wurden.");
            saveMessage("Die ersten " + maxResults + " Ergebnisse werden angezeigt.");
        }
        //TODO Fehlerbehandlung Suche
        return SUCCESS;
    }



}
