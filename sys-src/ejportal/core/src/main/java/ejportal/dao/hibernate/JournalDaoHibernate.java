package ejportal.dao.hibernate;

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 13:53:05
 * To change this template use File | Settings | File Templates.
 */


import java.util.Date;
import java.util.List;

import ejportal.service.dto.JournalSearchTO;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import ejportal.model.Journal;
import ejportal.dao.JournalDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("journalDao")
public class JournalDaoHibernate extends GenericDaoHibernate<Journal, Long> implements JournalDao {

    public JournalDaoHibernate() {
        super(Journal.class);
    }

    public List<Journal> findByTitel(String titel) {
        return getHibernateTemplate().find("from Journal where titel=?", titel);
    }

    public List<Journal> findByKurztitel(String kurztitel) {
        return getHibernateTemplate().find("from Journal where kurztitel=?", kurztitel);
    }

    public List<Journal> findByVerlag(int verlagId) {
         return getHibernateTemplate().find("from Journal where verlag_id=?", verlagId);
    }

    public List<Journal> findByBearbeitungsdatum(Date maxDate) {
        return getHibernateTemplate().find("from Journal where bearbeitungsdatum<?", maxDate);
    }

    public List<Journal> findByBearbeitungsdatumAll() {
        return getHibernateTemplate().find("from Journal where bearbeitungsdatum != null");
    }

    public List<Journal> findByZugangUeber(String zugangUeber) {
        return getHibernateTemplate().find("from Journal where zugangUeber=? ", zugangUeber);
    }

    public List<Journal> findBySearchTO(JournalSearchTO journalSearchTO){
          return  findBySearchTO(journalSearchTO, null);
    }

    public List<Journal> findBySearchTO(JournalSearchTO journalSearchTO, Integer maxResults) {
        Session session = getSessionFactory().openSession();
        List searchResult = null;
        try{
            Criteria criteria = session.createCriteria(Journal.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            criteria.setFirstResult(0);
            if(maxResults != null){
                criteria.setMaxResults(maxResults);
            }

            if(!journalSearchTO.getTitel().equals("")){
                criteria.add(Restrictions.like("titel", "%" + journalSearchTO.getTitel() + "%").ignoreCase());
            }
            if(!journalSearchTO.getKurztitel().equals("")){
                criteria.add(Restrictions.like("kurztitel", "%" + journalSearchTO.getKurztitel() + "%").ignoreCase());
            }
            if(!journalSearchTO.getVerlag().equals("")){
                criteria.createAlias("verlag","vl")
                    .add(Restrictions.like("vl.name", "%" + journalSearchTO.getVerlag() + "%").ignoreCase());
            }
            if(!journalSearchTO.getProvider().equals("")){
                criteria.createAlias("provider","pr")
                    .add(Restrictions.like("pr.name", "%" + journalSearchTO.getProvider() + "%").ignoreCase());
            }
            if(!journalSearchTO.getKonsortium().equals("")){
                criteria.createAlias("konsortium","ko")
                    .add(Restrictions.like("ko.konsortiumName", "%" + journalSearchTO.getKonsortium() + "%").ignoreCase());
            }
            if(!journalSearchTO.getPaket().equals("")){
                criteria.createAlias("paket","pk")
                    .add(Restrictions.like("pk.paketName", "%" + journalSearchTO.getPaket() + "%").ignoreCase());
            }
            if(!journalSearchTO.getZugangUeber().equals("")){
                criteria.add(Restrictions.like("zugangUeber", "%" + journalSearchTO.getZugangUeber() + "%").ignoreCase());
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
        //return getHibernateTemplate().find("from Journal where kurztitel=?", journalSearchTO.getKurztitel());
        //return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
/*
    public List<Journal> findByIssn(String issn) {
        return getHibernateTemplate().find("from Journal where issn=?", issn);
    }

    public List<Journal> findByIssnPrint(String issnPrint) {
        return getHibernateTemplate().find("from Journal where issnPrint=?", issnPrint);
    }*/
}
