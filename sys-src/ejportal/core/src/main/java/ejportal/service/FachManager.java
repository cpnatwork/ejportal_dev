package ejportal.service;

import ejportal.model.Fach;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:30:06
 * To change this template use File | Settings | File Templates.
 */
public interface FachManager extends GenericManager<Fach, Long> {
     public List<Fach> findByFachName(String fachName);
     public List<Fach> findByFachName(String fachName, Integer maxResults);
}
