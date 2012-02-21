package ejportal.dao.hibernate;

import ejportal.dao.EzbDatenDao;
import ejportal.model.EzbDaten;
import ejportal.service.dto.EzbDatenSearchTO;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 09.08.2010
 * Time: 18:14:09
 * To change this template use File | Settings | File Templates.
 */
@Repository("ezbDatenDao")
public class EzbDatenDaoHibernate extends GenericDaoHibernate<EzbDaten, Long> implements EzbDatenDao {

    public EzbDatenDaoHibernate(){
        super(EzbDaten.class);
    }

    public List<EzbDaten> findBySearchTO(EzbDatenSearchTO ezbDatenSearchTO, Integer maxResults) {
        Session session = getSessionFactory().openSession();
        List searchResult = null;
        try{
            Criteria criteria = session.createCriteria(EzbDaten.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            criteria.setFirstResult(0);
            if(maxResults != null){
                criteria.setMaxResults(maxResults);
            }


            if(!ezbDatenSearchTO.getEzbId().equals("")){
                try {
                    long ezbId= Long.parseLong(ezbDatenSearchTO.getEzbId());
                    criteria.add(Restrictions.eq("ezbId", ezbId));
                } catch (NumberFormatException e) {
                    // das war wohl nix
                    e.printStackTrace();
                }
            }

            if(!ezbDatenSearchTO.getTitel().equals("")){
                criteria.add(Restrictions.like("titel", "%" + ezbDatenSearchTO.getTitel() + "%").ignoreCase());
            }
            if(!ezbDatenSearchTO.getZdbNummer().equals("")){
                criteria.add(Restrictions.like("zdbNummer", "%" + ezbDatenSearchTO.getZdbNummer() + "%").ignoreCase());
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
