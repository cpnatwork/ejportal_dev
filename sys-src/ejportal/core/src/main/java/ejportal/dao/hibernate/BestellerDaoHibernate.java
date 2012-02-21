package ejportal.dao.hibernate;

import ejportal.dao.BestellerDao;
import ejportal.model.Besteller;
import ejportal.service.dto.BestellerSearchTO;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 09.08.2010
 * Time: 16:08:32
 * To change this template use File | Settings | File Templates.
 */
@Repository("bestellerDao")
public class BestellerDaoHibernate extends GenericDaoHibernate<Besteller, Long> implements BestellerDao {

    public BestellerDaoHibernate () {
        super(Besteller.class);
    }

    public List<Besteller> findByBestellerId(Long bestellerId) {
        return getHibernateTemplate().find("from Besteller where bestellerId=?", bestellerId);
    }

    public List<Besteller> findBySearchTO(BestellerSearchTO bestellerSearchTO, Integer maxResults) {
        Session session = getSessionFactory().openSession();
        List searchResult = null;
        try{
            Criteria criteria = session.createCriteria(Besteller.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            criteria.setFirstResult(0);
            if(maxResults != null){
                criteria.setMaxResults(maxResults);
            }

            if(!bestellerSearchTO.getBestellerName().equals("")){
                criteria.add(Restrictions.like("bestellerName", "%" + bestellerSearchTO.getBestellerName() + "%").ignoreCase());
            }

            if(!bestellerSearchTO.getProjekt().equals("")){
                criteria.add(Restrictions.like("projekt", "%" + bestellerSearchTO.getProjekt() + "%").ignoreCase());
            }

            searchResult = criteria.list();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return searchResult;
    }
}