package ejportal.dao.hibernate;

import ejportal.dao.PaketDao;
import ejportal.model.Paket;
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
 * Time: 16:06:57
 * To change this template use File | Settings | File Templates.
 */
@Repository("paketDao")
public class PaketDaoHibernate extends GenericDaoHibernate<Paket, Long> implements PaketDao {

    public PaketDaoHibernate() {
        super(Paket.class);
    }

    public List<Paket> findByPaketName(String paketName) {
        return findByPaketName(paketName, null);
    }

    public List<Paket> findByPaketName(String paketName, Integer maxResults) {
        Session session = getSessionFactory().openSession();
        List searchResult = null;
        try{
            Criteria criteria = session.createCriteria(Paket.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            criteria.setFirstResult(0);
            if(maxResults != null){
                criteria.setMaxResults(maxResults);
            }

            if(!paketName.equals("")){
                criteria.add(Restrictions.like("paketName", "%" + paketName + "%").ignoreCase());
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

    //return getHibernateTemplate().find("from Paket where paketName=?", paketName);
    }
}
