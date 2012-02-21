package ejportal.dao;

import ejportal.model.Institution;
import ejportal.service.dto.InstitutionSearchTO;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 21.06.2010
 * Time: 12:29:46
 * To change this template use File | Settings | File Templates.
 */
public interface InstitutionDao extends GenericDao<Institution, Long> {

    public List<Institution> findBySearchTO(InstitutionSearchTO institutionSearchTO);
    public List<Institution> findBySearchTO(InstitutionSearchTO institutionSearchTO, Integer maxResults);
}
