package ejportal.dao;


import ejportal.service.dto.JournalSearchTO;
import org.appfuse.dao.GenericDao;
import ejportal.model.Journal;

import java.util.Date;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 13:47:15
 * To change this template use File | Settings | File Templates.
 */

public interface JournalDao extends GenericDao<Journal, Long> {
    public List<Journal> findByTitel(String titel);
    public List<Journal> findByKurztitel(String kurztitel);
    public List<Journal> findByVerlag(int verlagId);
    public List<Journal> findByBearbeitungsdatum(Date maxDate);
    public List<Journal> findByBearbeitungsdatumAll();
    public List<Journal> findByZugangUeber(String zugangUeber);

    List<Journal> findBySearchTO(JournalSearchTO journalSearchTO);
    List<Journal> findBySearchTO(JournalSearchTO journalSearchTO, Integer maxResults);
}

