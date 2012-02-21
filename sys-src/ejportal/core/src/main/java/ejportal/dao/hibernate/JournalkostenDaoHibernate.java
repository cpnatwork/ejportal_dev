package ejportal.dao.hibernate;

import ejportal.dao.JournalkostenDao;
import ejportal.model.Journalkosten;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 09.08.2010
 * Time: 15:22:26
 * To change this template use File | Settings | File Templates.
 */

@Repository("journalkostenDao")
public class JournalkostenDaoHibernate  extends GenericDaoHibernate<Journalkosten, Long> implements JournalkostenDao {

    public JournalkostenDaoHibernate(){
        super(Journalkosten.class);
    }

    public Journalkosten findByJournalId(long journalId){
        List<Journalkosten> li = getHibernateTemplate().find("from Journalkosten where journal_id=?", journalId);
        if (li.size() == 0){
            return new Journalkosten();
        }
        return li.get(0);

    }

}