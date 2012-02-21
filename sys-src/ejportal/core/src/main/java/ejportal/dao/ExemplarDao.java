package ejportal.dao;

import ejportal.model.Exemplar;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Christoph
 * Date: 14.07.2010
 * Time: 16:06:59
 * To change this template use File | Settings | File Templates.
 */
public interface ExemplarDao extends GenericDao<Exemplar, Long> {
    //keine Suchen notwendig
    //Exemplare werden über das Journal per Getter gefunden

    public List<Exemplar> getListForJournal(long journalId);
}
