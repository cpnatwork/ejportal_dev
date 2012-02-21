package ejportal.service.impl;

import ejportal.dao.InstitutionDao;
import ejportal.dao.LizenzdetailDao;
import ejportal.model.Institution;
import ejportal.service.InstitutionManager;
import ejportal.service.dto.InstitutionBaseTO;
import ejportal.service.dto.InstitutionSearchTO;
import ejportal.util.BeanUtil;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 21.06.2010
 * Time: 12:36:53
 * To change this template use File | Settings | File Templates.
 */
public class InstitutionManagerImpl extends GenericManagerImpl<Institution, Long> implements InstitutionManager {
    private InstitutionDao institutionDao;

    BeanUtil beanUtil;

    public InstitutionManagerImpl(InstitutionDao institutionDao) {
        super(institutionDao);
        this.institutionDao = institutionDao;

        beanUtil = new BeanUtil();
    }

    public List<Institution> search(InstitutionSearchTO institutionSearchTO, Integer maxResults) {
        return institutionDao.findBySearchTO(institutionSearchTO, maxResults);
    }

    public List<Institution> search(InstitutionSearchTO institutionSearchTO) {
        return institutionDao.findBySearchTO(institutionSearchTO);  //To change body of implemented methods use File | Settings | File Templates.
    }

    /*public void connectInstitutionJournal(long institutionId, long journalId) {
        
    }*/

    public InstitutionBaseTO getInstitutionBaseTO(long id) {
         //TODO Fehlerbehandlung
       Institution institution = institutionDao.get(id);
       InstitutionBaseTO institutionBaseTO = new InstitutionBaseTO();

        try {
            //here comes the reflection voodoo ;-)
            beanUtil.copyEntityToBaseTO(institution, institutionBaseTO);
            //jetzt sind im journalBaseTO alle Attribute von journal OHNE die Beziehungen!
        } catch (Exception e) {
            //TODO Fehlerbehandlung
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return institutionBaseTO;
    }

    public Institution saveBaseTO(InstitutionBaseTO institutionBaseTO) {

        Institution institution = institutionDao.get(institutionBaseTO.getId());
        try {
            //mit reflection voodoo die Daten vom journalBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(institutionBaseTO, institution);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        institution = save(institution);
        return institution;
    }

    public Institution create(InstitutionBaseTO institutionBaseTO) {
        Institution institution = new Institution();
        try {
            //mit reflection voodoo die Daten vom institutionBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(institutionBaseTO, institution);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        institution = save(institution);
        return institution;  //To change body of implemented methods use File | Settings | File Templates.
    }

}
