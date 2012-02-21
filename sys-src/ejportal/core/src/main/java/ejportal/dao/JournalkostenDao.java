package ejportal.dao;

import ejportal.model.Journalkosten;
import ejportal.model.Konsortium;
import org.appfuse.dao.GenericDao;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 09.08.2010
 * Time: 15:21:39
 * To change this template use File | Settings | File Templates.
 */
public interface JournalkostenDao extends GenericDao<Journalkosten, Long> {
    public Journalkosten findByJournalId(long journalId);
}
