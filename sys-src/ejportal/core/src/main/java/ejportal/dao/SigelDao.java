package ejportal.dao;

import ejportal.model.Sigel;
import ejportal.service.dto.SigelSearchTO;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 28.06.2010
 * Time: 15:27:25
 * To change this template use File | Settings | File Templates.
 */
public interface SigelDao extends GenericDao<Sigel, Long> {
   public List<Sigel> findBySearchTO(SigelSearchTO sigelSearchTO);
   public List<Sigel> findBySearchTO(SigelSearchTO sigelSearchTO, Integer maxResults);

   public List<Sigel> findByName(String name);
   public List<Sigel> findByBibliothek(String bibliothek);
   public List<Sigel> findByFakultaet(String fakultaet);
}
