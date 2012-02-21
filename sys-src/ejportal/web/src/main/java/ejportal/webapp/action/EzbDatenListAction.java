package ejportal.webapp.action;

import ejportal.service.EzbDatenManager;
import ejportal.service.dto.EzbDatenSearchTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 10.08.2010
 * Time: 10:30:29
 * To change this template use File | Settings | File Templates.
 */
public class EzbDatenListAction extends JournalBaseAction{
    private EzbDatenManager ezbDatenManager;
    private EzbDatenSearchTO ezbDatenSearchTO;
    private List ezbDaten;


     public void setEzbDatenManager(EzbDatenManager ezbDatenManager) {
        this.ezbDatenManager = ezbDatenManager;
    }

    public List getEzbDaten() {
        return ezbDaten;
    }

    public String initSearch(){
        //ezbDatenSearchTO=new EzbDatenSearchTO();
        return SUCCESS;
    }

    //Suche
    public EzbDatenSearchTO getEzbDatenSearchTO() {
        return ezbDatenSearchTO;
    }

    public void setEzbDatenSearchTO(EzbDatenSearchTO ezbDatenSearchTO) {
        this.ezbDatenSearchTO = ezbDatenSearchTO;
    }

    public String search() {
        int maxResults = 100;

        //Prüfen, ob ezbid eine Zahl ist.
        if (!ezbDatenSearchTO.getEzbId().equals("")){
            try {
                Long.parseLong(ezbDatenSearchTO.getEzbId());
            } catch (NumberFormatException e) {
                saveMessage(getText("Im Feld EZB-Id darf nur eine Zahl angegeben werden"));
                return "back";
            }
        }


        ezbDaten = ezbDatenManager.findBySearchTO(ezbDatenSearchTO, maxResults);

        if(ezbDaten.size() == maxResults){
            saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als " + ezbDaten.size() + " EZB Daten gefunden wurden.");
            saveMessage("Die ersten " + maxResults + " Ergebnisse werden angezeigt.");
        }
        //TODO Fehlerbehandlung Suche
        return SUCCESS;
    }




}
