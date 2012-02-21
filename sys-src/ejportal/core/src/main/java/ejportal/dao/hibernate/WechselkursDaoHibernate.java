package ejportal.dao.hibernate;

import ejportal.dao.WechselkursDao;
import ejportal.model.Wechselkurs;
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 11.08.2010
 * Time: 12:39:36
 * To change this template use File | Settings | File Templates.
 */
@Repository("wechselkursDao")
public class WechselkursDaoHibernate  extends GenericDaoHibernate<Wechselkurs, Long> implements WechselkursDao {

    public WechselkursDaoHibernate() {
        super(Wechselkurs.class);
    }

    public Wechselkurs findByWaehrung(String waehrung) {
        List<Wechselkurs> li = getHibernateTemplate().find("from Wechselkurs where waehrung=?", waehrung);
        return li.get(0);
    }

    
}
