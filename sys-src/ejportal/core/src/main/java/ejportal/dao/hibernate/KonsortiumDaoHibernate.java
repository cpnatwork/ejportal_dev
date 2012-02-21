package ejportal.dao.hibernate;

import ejportal.dao.KonsortiumDao;
import ejportal.model.Konsortium;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:07:56
 * To change this template use File | Settings | File Templates.
 */
@Repository("konsortiumDao")
public class KonsortiumDaoHibernate extends GenericDaoHibernate<Konsortium, Long> implements KonsortiumDao{

    public KonsortiumDaoHibernate(){
        super(Konsortium.class);
    }

    public List<Konsortium> findByKonsortiumName(String konsortiumName) {
        return findByKonsortiumName(konsortiumName, null);
    }

    public List<Konsortium> findByKonsortiumName(String konsortiumName, Integer maxResults) {
        Session session = getSessionFactory().openSession();
        List searchResult = null;
        try{
            Criteria criteria = session.createCriteria(Konsortium.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            criteria.setFirstResult(0);
            if(maxResults != null){
                criteria.setMaxResults(maxResults);
            }

            if(!konsortiumName.equals("")){
                criteria.add(Restrictions.like("konsortiumName", "%" + konsortiumName + "%").ignoreCase());
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

        //return getHibernateTemplate().find("from Konsortium where konsortiumName=?", konsortiumName);
    }
}