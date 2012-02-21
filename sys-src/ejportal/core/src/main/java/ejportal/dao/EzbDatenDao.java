package ejportal.dao;

import ejportal.model.EzbDaten;
import ejportal.service.dto.EzbDatenSearchTO;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 09.08.2010
 * Time: 18:12:39
 * To change this template use File | Settings | File Templates.
 */
public interface EzbDatenDao extends GenericDao<EzbDaten, Long> {
    List<EzbDaten> findBySearchTO(EzbDatenSearchTO ezbDatenSearchTO, Integer maxResults);
}
