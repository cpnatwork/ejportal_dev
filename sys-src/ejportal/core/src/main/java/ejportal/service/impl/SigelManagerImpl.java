package ejportal.service.impl;

import ejportal.dao.SigelDao;
import ejportal.model.Sigel;
import ejportal.service.SigelManager;
import ejportal.service.dto.SigelSearchTO;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Chris
 * Date: 28.06.2010
 * Time: 15:54:42
 * To change this template use File | Settings | File Templates.
 */
public class SigelManagerImpl extends GenericManagerImpl<Sigel, Long> implements SigelManager {
    private SigelDao sigelDao;

    public SigelManagerImpl(SigelDao sigelDao) {
        super(sigelDao);
        this.sigelDao = sigelDao;

    }

    public List<Sigel> findBySearchTO(SigelSearchTO sigelSearchTO) {
        return sigelDao.findBySearchTO(sigelSearchTO);
    }
    public List<Sigel> findBySearchTO(SigelSearchTO sigelSearchTO, Integer maxResults) {
        return sigelDao.findBySearchTO(sigelSearchTO, maxResults);
    }
    

    public List<Sigel> findByName(String name) {
        return sigelDao.findByName(name);
    }

    public List<Sigel> findByBibliothek(String bibliothek) {
        return sigelDao.findByBibliothek(bibliothek);
    }

    public List<Sigel> findByFakultaet(String fakultaet) {
        return sigelDao.findByFakultaet(fakultaet);
    }
}
