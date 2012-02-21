package ejportal.dao;

import ejportal.model.Lizenzdetail;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:01:08
 * To change this template use File | Settings | File Templates.
 */
public interface LizenzdetailDao extends GenericDao<Lizenzdetail, Long> {
    public List<Lizenzdetail> findByVerlag(long verlagId);
}
