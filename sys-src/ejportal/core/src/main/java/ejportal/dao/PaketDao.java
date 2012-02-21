package ejportal.dao;

import ejportal.model.Paket;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:00:40
 * To change this template use File | Settings | File Templates.
 */
public interface PaketDao extends GenericDao<Paket, Long> {
    public List<Paket> findByPaketName(String paketName);
    public List<Paket> findByPaketName(String paketName, Integer maxResults);
}
