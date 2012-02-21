package ejportal.webapp.action;

import ejportal.service.SigelManager;
import ejportal.service.dto.SigelSearchTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 04.08.2010
 * Time: 14:47:50
 * To change this template use File | Settings | File Templates.
 */
public class SigelListAction extends BaseAction {
    private SigelManager sigelManager;
    private SigelSearchTO sigelSearchTO;
    private List sigels;

    Long exemplarId; //bei der Zuweisung von Sigel zu Exemplar  "merken" und in Ergebnisseite uebernehmen
    Long interesseId;
    Long bestellerId;
    Long journalId;

    public long getExemplarId() {
        return exemplarId;
    }

    public void setExemplarId(Long exemplarId) {
        this.exemplarId = exemplarId;
    }

    public Long getJournalId() {
        return journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public Long getInteresseId() {
        return interesseId;
    }

    public void setInteresseId(Long interesseId) {
        this.interesseId = interesseId;
    }

    public Long getBestellerId() {
        return bestellerId;
    }

    public void setBestellerId(Long bestellerId) {
        this.bestellerId = bestellerId;
    }

    public void setSigelManager(SigelManager sigelManager) {
        this.sigelManager = sigelManager;
    }

    public List getSigels() {
        return sigels;
    }

    public String listAll() {
        sigels = sigelManager.getAll();
        return SUCCESS;
    }


    //Suche

    public SigelSearchTO getSigelSearchTO() {
        return sigelSearchTO;
    }

    public void setSigelSearchTO(SigelSearchTO sigelSearchTO) {
        this.sigelSearchTO = sigelSearchTO;
    }

    public String search() {
        int maxResults = 100;
        sigels = sigelManager.findBySearchTO(sigelSearchTO, maxResults);

        if(sigels.size() == maxResults){
            //TODO Konsortien???
            saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als " + sigels.size() + " Konsortien gefunden wurden.");
            saveMessage("Die ersten " + maxResults + " Ergebnisse werden angezeigt.");
        }
        //TODO Fehlerbehandlung Suche
        return SUCCESS;
    }

    //fuer neue Zuweisung zu Exemplar
    public void setExemplarId(long exemplarId) {
        this.exemplarId = exemplarId;
    }



}
