package ejportal.dao.hibernate;

import ejportal.dao.ExemplarDao;
import ejportal.model.Exemplar;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Christoph
 * Date: 14.07.2010
 * Time: 16:08:03
 * To change this template use File | Settings | File Templates.
 */
@Repository("exemplarDao")
public class ExemplarDaoHibernate extends GenericDaoHibernate<Exemplar, Long> implements ExemplarDao {

    public ExemplarDaoHibernate(){
        super(Exemplar.class);
    }

    public List<Exemplar> getListForJournal(long journalId) {
        return getHibernateTemplate().find("from Exemplar where journal_Id=?", journalId);
    }
}
