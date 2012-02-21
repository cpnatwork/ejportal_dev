package ejportal.dao.hibernate;

import ejportal.dao.FachDao;
import ejportal.model.Fach;
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
 * Time: 16:31:01
 * To change this template use File | Settings | File Templates.
 */
@Repository("fachDao")
public class FachDaoHibernate extends GenericDaoHibernate<Fach, Long> implements FachDao {

    public FachDaoHibernate(){
        super(Fach.class);
    }

        public List<Fach> findByFachName(String fachName) {
        return getHibernateTemplate().find("from Fach where fachName=?", fachName);
    }

    public List<Fach> findByFachName(String fachName, Integer maxResults) {
        Session session = getSessionFactory().openSession();
        List searchResult = null;
        try{
            Criteria criteria = session.createCriteria(Fach.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            criteria.setFirstResult(0);
            if(maxResults != null){
                criteria.setMaxResults(maxResults);
            }

            if(!fachName.equals("")){
                criteria.add(Restrictions.like("fachName", "%" + fachName + "%").ignoreCase());
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

    //return getHibernateTemplate().find("from Fach where fachName=?", fachName);
    }
    
}

