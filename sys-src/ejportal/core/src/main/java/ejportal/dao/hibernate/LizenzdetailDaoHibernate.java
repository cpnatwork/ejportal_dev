package ejportal.dao.hibernate;

import ejportal.dao.LizenzdetailDao;
import ejportal.model.Lizenzdetail;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:08:48
 * To change this template use File | Settings | File Templates.
 */
@Repository("lizenzdetailDao")
public class LizenzdetailDaoHibernate extends GenericDaoHibernate<Lizenzdetail, Long> implements LizenzdetailDao{

    public LizenzdetailDaoHibernate(){
        super(Lizenzdetail.class);
    }

    public List<Lizenzdetail> findByVerlag(long verlagId) {
         return getHibernateTemplate().find("from Lizenzdetail where verlag_id=?", verlagId);

    }
    
}
