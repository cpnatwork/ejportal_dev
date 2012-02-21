package ejportal.service.impl;

import ejportal.dao.PaketDao;
import ejportal.model.Paket;
import ejportal.service.PaketManager;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:18:27
 * To change this template use File | Settings | File Templates.
 */
public class PaketManagerImpl extends GenericManagerImpl<Paket, Long> implements PaketManager{
    private PaketDao paketDao;

    public PaketManagerImpl(PaketDao paketDao){
        super(paketDao);
        this.paketDao = paketDao;
    }
    
    public List<Paket> findByPaketName(String paketName) {
        return paketDao.findByPaketName(paketName);
    }

    public List<Paket> findByPaketName(String paketName, Integer maxResults) {
        return paketDao.findByPaketName(paketName, maxResults);
    }

}
