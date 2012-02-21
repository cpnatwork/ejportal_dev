package ejportal.service.impl;

import ejportal.dao.FachDao;
import ejportal.model.Fach;
import ejportal.service.FachManager;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:30:38
 * To change this template use File | Settings | File Templates.
 */
public class FachManagerImpl extends GenericManagerImpl<Fach, Long> implements FachManager {
    private FachDao fachDao;

    public FachManagerImpl(FachDao fachDao){
        super(fachDao);
        this.fachDao = fachDao;
    }
     public List<Fach> findByFachName(String fachName) {
        return fachDao.findByFachName(fachName);
    }
    public List<Fach> findByFachName(String fachName, Integer maxResults) {
        return fachDao.findByFachName(fachName, maxResults);
    }
}
