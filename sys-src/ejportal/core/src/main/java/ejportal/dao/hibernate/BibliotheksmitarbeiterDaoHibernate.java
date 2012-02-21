package ejportal.dao.hibernate;

import ejportal.dao.BibliotheksmitarbeiterDao;
import ejportal.model.Bibliotheksmitarbeiter;
import ejportal.service.dto.BibliotheksmitarbeiterSearchTO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 14:58:16
 * To change this template use File | Settings | File Templates.
 */
@Repository("bibliotheksmitarbeiterDao")
public class BibliotheksmitarbeiterDaoHibernate extends GenericDaoHibernate<Bibliotheksmitarbeiter, Long> implements BibliotheksmitarbeiterDao {

    public BibliotheksmitarbeiterDaoHibernate(){
        super(Bibliotheksmitarbeiter.class);
    }


    public List<Bibliotheksmitarbeiter> findByName(String name) {
        return getHibernateTemplate().find("from Bibliotheksmitarbeiter where name=?", name);
    }

    public List<Bibliotheksmitarbeiter> findByAbteilungsHauptstelle(String abteilungsHauptstelle) {
        return getHibernateTemplate().find("from Bibliotheksmitarbeiter where abteilungsHauptstelle=?", abteilungsHauptstelle);
    }

    public List<Bibliotheksmitarbeiter> findByEmailanschrift(String emailanschrift) {
         return getHibernateTemplate().find("from Bibliotheksmitarbeiter where emailanschrift=?", emailanschrift);
    }

    public List<Bibliotheksmitarbeiter> findBySearchTO(BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO) {
        return findBySearchTO(bibliotheksmitarbeiterSearchTO, null);
    }

    public List<Bibliotheksmitarbeiter> findBySearchTO(BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO, Integer maxResults) {
        Session session = getSessionFactory().openSession();
        List searchResult = null;
        try{
            Criteria criteria = session.createCriteria(Bibliotheksmitarbeiter.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            criteria.setFirstResult(0);
            if(maxResults != null){
                criteria.setMaxResults(maxResults);
            }

            if(!bibliotheksmitarbeiterSearchTO.getName().equals("")){
                criteria.add(Restrictions.like("name", "%" + bibliotheksmitarbeiterSearchTO.getName() + "%").ignoreCase());
            }
            if(!bibliotheksmitarbeiterSearchTO.getAbteilungsHauptstelle().equals("")){
                criteria.add(Restrictions.like("abteilungsHauptstelle", "%" + bibliotheksmitarbeiterSearchTO.getAbteilungsHauptstelle() + "%").ignoreCase());
            }
            if(!bibliotheksmitarbeiterSearchTO.getEmailanschrift().equals("")){
                criteria.add(Restrictions.like("emailanschrift", "%" + bibliotheksmitarbeiterSearchTO.getEmailanschrift() + "%").ignoreCase());
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
