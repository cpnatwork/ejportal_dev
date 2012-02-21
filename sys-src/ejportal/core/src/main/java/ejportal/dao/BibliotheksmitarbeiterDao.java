package ejportal.dao;

import ejportal.model.Bibliotheksmitarbeiter;
import ejportal.service.dto.BibliotheksmitarbeiterSearchTO;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 14:57:04
 * To change this template use File | Settings | File Templates.
 */
public interface BibliotheksmitarbeiterDao extends GenericDao<Bibliotheksmitarbeiter, Long> {
   public List<Bibliotheksmitarbeiter> findBySearchTO(BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO);
   public List<Bibliotheksmitarbeiter> findBySearchTO(BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO, Integer maxResults);

   public List<Bibliotheksmitarbeiter> findByName(String name);
   public List<Bibliotheksmitarbeiter> findByAbteilungsHauptstelle(String abteilungsHauptstelle);
   public List<Bibliotheksmitarbeiter> findByEmailanschrift(String emailanschrift);
}
