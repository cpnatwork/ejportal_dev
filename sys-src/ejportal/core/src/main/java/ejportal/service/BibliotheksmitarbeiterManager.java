package ejportal.service;

import ejportal.model.Bibliotheksmitarbeiter;
import ejportal.service.dto.BibliotheksmitarbeiterSearchTO;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 15:02:43
 * To change this template use File | Settings | File Templates.
 */
public interface BibliotheksmitarbeiterManager extends GenericManager<Bibliotheksmitarbeiter, Long> {
    public List<Bibliotheksmitarbeiter> findBySearchTO(BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO);
   public List<Bibliotheksmitarbeiter> findBySearchTO(BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO, Integer maxResults);

   public List<Bibliotheksmitarbeiter> findByName(String name);
   public List<Bibliotheksmitarbeiter> findByAbteilungsHauptstelle(String abteilungshauptstelle);
   public List<Bibliotheksmitarbeiter> findByEmailanschrift(String emailanschrift);
}
