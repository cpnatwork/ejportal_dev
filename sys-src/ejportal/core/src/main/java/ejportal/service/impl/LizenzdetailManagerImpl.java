package ejportal.service.impl;

import ejportal.dao.InstitutionDao;
import ejportal.dao.LizenzdetailDao;
import ejportal.model.Lizenzdetail;
import ejportal.service.LizenzdetailManager;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:19:48
 * To change this template use File | Settings | File Templates.
 */
public class LizenzdetailManagerImpl extends GenericManagerImpl<Lizenzdetail, Long> implements LizenzdetailManager {
    private LizenzdetailDao lizenzdetailDao;
    private InstitutionDao institutionDao;

    public LizenzdetailManagerImpl(LizenzdetailDao lizenzdetailDao, InstitutionDao institutionDao){
        super(lizenzdetailDao);
        this.lizenzdetailDao = lizenzdetailDao;
        this.institutionDao = institutionDao;
    }

    public List<Lizenzdetail> findByVerlagId(long verlagId) {
        return lizenzdetailDao.findByVerlag(verlagId);

    }

    public Lizenzdetail saveWithInstitution(Lizenzdetail lizenzdetail, Long institutionId){
        lizenzdetail.setVerlag(institutionDao.get(institutionId));
        return super.save(lizenzdetail);
    }
}
