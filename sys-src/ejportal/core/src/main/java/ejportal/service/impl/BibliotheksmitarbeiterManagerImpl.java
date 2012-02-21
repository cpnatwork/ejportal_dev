package ejportal.service.impl;

import ejportal.dao.BibliotheksmitarbeiterDao;
import ejportal.model.Bibliotheksmitarbeiter;
import ejportal.service.BibliotheksmitarbeiterManager;
import ejportal.service.dto.BibliotheksmitarbeiterSearchTO;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 15:04:21
 * To change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterManagerImpl extends GenericManagerImpl<Bibliotheksmitarbeiter, Long> implements BibliotheksmitarbeiterManager{
    private BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao;

    public BibliotheksmitarbeiterManagerImpl(BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao) {
        super(bibliotheksmitarbeiterDao);
        this.bibliotheksmitarbeiterDao = bibliotheksmitarbeiterDao;
    }

    public List<Bibliotheksmitarbeiter> findBySearchTO(BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO) {
        return bibliotheksmitarbeiterDao.findBySearchTO(bibliotheksmitarbeiterSearchTO);
    }
    public List<Bibliotheksmitarbeiter> findBySearchTO(BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO, Integer maxResults) {
        return bibliotheksmitarbeiterDao.findBySearchTO(bibliotheksmitarbeiterSearchTO, maxResults);
    }

    public List<Bibliotheksmitarbeiter> findByName(String name) {
        return bibliotheksmitarbeiterDao.findByName(name);
    }

    public List<Bibliotheksmitarbeiter> findByAbteilungsHauptstelle(String abteilungsHauptstelle) {
        return bibliotheksmitarbeiterDao.findByAbteilungsHauptstelle(abteilungsHauptstelle);
    }

    public List<Bibliotheksmitarbeiter> findByEmailanschrift(String emailanschrift) {
        return bibliotheksmitarbeiterDao.findByEmailanschrift(emailanschrift);
    }
}
