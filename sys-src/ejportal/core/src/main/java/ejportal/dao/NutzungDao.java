package ejportal.dao;

import ejportal.model.Nutzung;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 09.08.2010
 * Time: 16:00:53
 * To change this template use File | Settings | File Templates.
 */
public interface NutzungDao extends GenericDao<Nutzung, Long> {
    public List<Nutzung> findByJournal(long journalId);
}
