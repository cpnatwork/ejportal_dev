package ejportal.webapp.action;

import ejportal.model.Lizenzdetail;
import ejportal.service.LizenzdetailManager;
import org.springframework.dao.DataIntegrityViolationException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 05.08.2010
 * Time: 13:49:53
 * To change this template use File | Settings | File Templates.
 */
public class LizenzdetailDetailAction extends BaseAction {
    private LizenzdetailManager lizenzdetailManager;
    private Lizenzdetail lizenzdetail;
    private Long lizenzId;
    private Long institutionId;


    // CRUD
    public String delete() {
        lizenzdetailManager.remove(lizenzId);
        saveMessage(getText("Lizenzdetail wurde erfolgreich entfernt."));

        return SUCCESS;
    }

    public String edit() {
        if (lizenzId != null) {
            lizenzdetail = lizenzdetailManager.get(lizenzId);
        } else {
            lizenzdetail = new Lizenzdetail();
        }
        return "edit";
    }

    public String save() throws Exception {
        if (cancel != null) {
            return CANCEL;
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (lizenzdetail.getLizenzId() == null);

        //Prüfen, ob Beginndatum angegeben worden ist.
        if (lizenzdetail.getBeginn().compareTo("") == 0) {
            saveMessage(getText("Geben Sie einen Beginndatum ein!"));
            return "back";
        }

        
        lizenzdetail = lizenzdetailManager.saveWithInstitution(lizenzdetail, institutionId);

        String key = (isNew) ? "Lizenzdetail wurde erfolgreich erstellt." : "Lizenzdetail wurde erfolgreich aktualisiert.";
        saveMessage(key);

        return SUCCESS;
    }


    // Getter und Setter
    public LizenzdetailManager getLizenzdetailManager() {
        return lizenzdetailManager;
    }

    public void setLizenzdetailManager(LizenzdetailManager lizenzdetailManager) {
        this.lizenzdetailManager = lizenzdetailManager;
    }

    public Lizenzdetail getLizenzdetail() {
        return lizenzdetail;
    }

    public void setLizenzdetail(Lizenzdetail lizenzdetail) {
        this.lizenzdetail = lizenzdetail;
    }

    public Long getLizenzId() {
        return lizenzId;
    }

    public void setLizenzId(Long lizenzId) {
        this.lizenzId = lizenzId;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId; 
    }


}
