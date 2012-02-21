package ejportal.service;

import ejportal.model.Institution;
import ejportal.service.dto.InstitutionBaseTO;
import ejportal.service.dto.InstitutionSearchTO;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 21.06.2010
 * Time: 12:35:24
 * To change this template use File | Settings | File Templates.
 */
public interface InstitutionManager extends GenericManager<Institution, Long>{

    public List<Institution> search(InstitutionSearchTO institutionSearchTO);
    public List<Institution> search(InstitutionSearchTO institutionSearchTO, Integer maxResults);
    //public void connectInstitutionJournal(long institutionId, long journalId);
    public InstitutionBaseTO getInstitutionBaseTO(long id);

    public Institution saveBaseTO(InstitutionBaseTO institutionBaseTO);

    public Institution create(InstitutionBaseTO institutionBaseTO);

}
