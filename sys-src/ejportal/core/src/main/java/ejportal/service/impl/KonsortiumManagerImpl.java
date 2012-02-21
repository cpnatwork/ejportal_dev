package ejportal.service.impl;

import ejportal.dao.KonsortiumDao;
import ejportal.model.Konsortium;
import ejportal.service.KonsortiumManager;
import ejportal.util.BeanUtil;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:19:05
 * To change this template use File | Settings | File Templates.
 */
public class KonsortiumManagerImpl extends GenericManagerImpl<Konsortium, Long> implements KonsortiumManager{
    private KonsortiumDao konsortiumDao;

    public KonsortiumManagerImpl(KonsortiumDao konsortiumDao){
        super(konsortiumDao);
        this.konsortiumDao = konsortiumDao;
    }

    public List<Konsortium> findByKonsortiumName(String konsortiumName) {
        return konsortiumDao.findByKonsortiumName(konsortiumName);
    }

    public List<Konsortium> findByKonsortiumName(String konsortiumName, Integer maxResults) {
        return konsortiumDao.findByKonsortiumName(konsortiumName, maxResults);
    }

}
