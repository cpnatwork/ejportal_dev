package ejportal.dao.hibernate;

import ejportal.dao.SigelDao;
import ejportal.model.Sigel;
import ejportal.service.dto.SigelSearchTO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 28.06.2010
 * Time: 15:44:35
 * To change this template use File | Settings | File Templates.
 */

@Repository("sigelDao")
public class SigelDaoHibernate  extends GenericDaoHibernate<Sigel, Long> implements SigelDao {

    public SigelDaoHibernate() {
        super(Sigel.class);
    }
    public List<Sigel> findByName(String name) {
        return getHibernateTemplate().find("from Sigel where name=?", name);
    }

    public List<Sigel> findByBibliothek(String bibliothek) {
        return getHibernateTemplate().find("from Sigel where bibliothek=?", bibliothek);
    }

    public List<Sigel> findByFakultaet(String fakultaet) {
         return getHibernateTemplate().find("from Sigel where fakultaet=?", fakultaet);
    }

    public List<Sigel> findBySearchTO(SigelSearchTO sigelSearchTO) {
        return findBySearchTO(sigelSearchTO, null);
    }

    public List<Sigel> findBySearchTO(SigelSearchTO sigelSearchTO, Integer maxResults) {
        Session session = getSessionFactory().openSession();
        List searchResult = null;
        try{
            Criteria criteria = session.createCriteria(Sigel.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            criteria.setFirstResult(0);
            if(maxResults != null){
                criteria.setMaxResults(maxResults);
            }

            if(!sigelSearchTO.getName().equals("")){
                criteria.add(Restrictions.like("name", "%" + sigelSearchTO.getName() + "%").ignoreCase());
            }
            if(!sigelSearchTO.getBibliothek().equals("")){
                criteria.add(Restrictions.like("bibliothek", "%" + sigelSearchTO.getBibliothek() + "%").ignoreCase());
            }
            if(!sigelSearchTO.getFakultaet().equals("")){
                criteria.add(Restrictions.like("fakultaet", "%" + sigelSearchTO.getFakultaet() + "%").ignoreCase());
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
