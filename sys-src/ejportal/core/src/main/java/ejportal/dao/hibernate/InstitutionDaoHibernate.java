package ejportal.dao.hibernate;

import ejportal.dao.InstitutionDao;
import ejportal.model.Institution;
import ejportal.service.dto.InstitutionSearchTO;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 21.06.2010
 * Time: 12:31:46
 * To change this template use File | Settings | File Templates.
 */

@Repository("institutionDao")
public class InstitutionDaoHibernate extends GenericDaoHibernate<Institution, Long> implements InstitutionDao {

    public InstitutionDaoHibernate(){
        super(Institution.class);
    }

    public List<Institution> findBySearchTO(InstitutionSearchTO institutionSearchTO) {
        return findBySearchTO(institutionSearchTO, null);
    }

    public List<Institution> findBySearchTO(InstitutionSearchTO institutionSearchTO, Integer maxResults) {
        Session session = getSessionFactory().openSession();
        List searchResult = null;
        try{
            Criteria criteria = session.createCriteria(Institution.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            criteria.setFirstResult(0);
            if(maxResults != null){
                criteria.setMaxResults(maxResults);
            }

            if(!institutionSearchTO.getName().equals("")){
                criteria.add(Restrictions.like("name", "%" + institutionSearchTO.getName() + "%").ignoreCase());
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
