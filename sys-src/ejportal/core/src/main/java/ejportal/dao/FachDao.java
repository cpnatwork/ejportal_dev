package ejportal.dao;

import ejportal.model.Fach;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:00:17
 * To change this template use File | Settings | File Templates.
 */
public interface FachDao extends GenericDao<Fach, Long> {
    public List<Fach> findByFachName(String fachName);
    public List<Fach> findByFachName(String fachName, Integer maxResults);

    
}
