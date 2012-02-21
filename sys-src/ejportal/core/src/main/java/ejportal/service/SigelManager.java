package ejportal.service;

import ejportal.model.Sigel;
import ejportal.service.dto.SigelSearchTO;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 28.06.2010
 * Time: 15:50:30
 * To change this template use File | Settings | File Templates.
 */
public interface SigelManager extends GenericManager<Sigel, Long> {
   public List<Sigel> findBySearchTO(SigelSearchTO sigelSearchTO);
   public List<Sigel> findBySearchTO(SigelSearchTO sigelSearchTO, Integer maxResults);

   public List<Sigel> findByName(String name);
   public List<Sigel> findByBibliothek(String bibliothek);
   public List<Sigel> findByFakultaet(String fakultaet);
}
