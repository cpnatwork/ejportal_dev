package ejportal.dao.hibernate;

import ejportal.dao.NutzungDao;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import ejportal.model.Nutzung;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 09.08.2010
 * Time: 16:01:40
 * To change this template use File | Settings | File Templates.
 */
@Repository("nutzungDao")
public class NutzungDaoHibernate extends GenericDaoHibernate<Nutzung, Long> implements NutzungDao {
    public NutzungDaoHibernate(){
        super(Nutzung.class);
    }

    public List<Nutzung> findByJournal(long journalId) {
         return getHibernateTemplate().find("from Nutzung where journal_id=?", journalId);
    }
}
