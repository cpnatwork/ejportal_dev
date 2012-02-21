package ejportal.dao;

import ejportal.model.Wechselkurs;
import org.appfuse.dao.GenericDao;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 11.08.2010
 * Time: 12:38:52
 * To change this template use File | Settings | File Templates.
 */
public interface WechselkursDao extends GenericDao<Wechselkurs, Long> {
    public Wechselkurs findByWaehrung(String waehrung);
}
