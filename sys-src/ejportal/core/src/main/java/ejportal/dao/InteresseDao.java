package ejportal.dao;

import ejportal.model.Interesse;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 09.08.2010
 * Time: 16:07:48
 * To change this template use File | Settings | File Templates.
 */
public interface InteresseDao extends GenericDao<Interesse, Long> {

    public List<Interesse> findByJournalId(Long journalId);

}
