package ejportal.dao.hibernate;

import ejportal.dao.InteresseDao;
import ejportal.model.Interesse;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 09.08.2010
 * Time: 16:11:07
 * To change this template use File | Settings | File Templates.
 */
@Repository("interesseDao")
public class InteresseDaoHibernate extends GenericDaoHibernate<Interesse, Long> implements InteresseDao {

    public InteresseDaoHibernate () {
        super(Interesse.class);
    }

    public List<Interesse> findByJournalId(Long journalId) {
        return getHibernateTemplate().find("from Interesse where Journal_id=?", journalId);
    }    
}