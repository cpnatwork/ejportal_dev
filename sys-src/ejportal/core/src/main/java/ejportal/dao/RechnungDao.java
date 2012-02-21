package ejportal.dao;

import ejportal.model.Rechnung;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 09.08.2010
 * Time: 14:41:15
 * To change this template use File | Settings | File Templates.
 */
public interface RechnungDao extends GenericDao<Rechnung, Long> {
    public List<Rechnung> findByExemplarId(long exemplarId);
}
