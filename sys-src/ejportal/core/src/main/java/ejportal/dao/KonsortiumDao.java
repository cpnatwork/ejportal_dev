package ejportal.dao;

import ejportal.model.Konsortium;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:00:54
 * To change this template use File | Settings | File Templates.
 */
public interface KonsortiumDao extends GenericDao<Konsortium, Long> {
    public List<Konsortium> findByKonsortiumName(String konsortiumName);
    public List<Konsortium> findByKonsortiumName(String konsortiumName, Integer maxResults);
}
