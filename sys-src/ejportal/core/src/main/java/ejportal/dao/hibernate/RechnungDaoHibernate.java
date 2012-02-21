package ejportal.dao.hibernate;

import ejportal.dao.RechnungDao;
import ejportal.model.Rechnung;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 09.08.2010
 * Time: 14:53:53
 * To change this template use File | Settings | File Templates.
 */
@Repository("rechnungDao")
public class RechnungDaoHibernate extends GenericDaoHibernate<Rechnung, Long> implements RechnungDao {

    public RechnungDaoHibernate() {
        super(Rechnung.class);
    }

    public List<Rechnung> findByExemplarId(long exemplarId) {
        return getHibernateTemplate().find("from Rechnung where Exemplar_exemplarId=?", exemplarId);
    }
}
