package ejportal.service;

import ejportal.model.Lizenzdetail;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:14:51
 * To change this template use File | Settings | File Templates.
 */
public interface LizenzdetailManager extends GenericManager<Lizenzdetail, Long> {
    public List<Lizenzdetail> findByVerlagId(long verlagId);

    public Lizenzdetail saveWithInstitution(Lizenzdetail lizenzdetail, Long institutionId);
}
