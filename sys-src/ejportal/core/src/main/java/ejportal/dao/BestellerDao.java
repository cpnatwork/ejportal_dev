package ejportal.dao;

import ejportal.model.Besteller;
import ejportal.service.dto.BestellerSearchTO;
import org.appfuse.dao.GenericDao;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 09.08.2010
 * Time: 16:06:16
 * To change this template use File | Settings | File Templates.
 */
public interface BestellerDao extends GenericDao<Besteller, Long> {

    public List<Besteller> findBySearchTO(BestellerSearchTO bestellerSearchTO, Integer maxResults);
    public List<Besteller> findByBestellerId(Long bestellerId);

}
