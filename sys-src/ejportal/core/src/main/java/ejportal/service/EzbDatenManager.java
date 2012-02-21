package ejportal.service;

import ejportal.model.EzbDaten;
import ejportal.model.Journal;
import ejportal.service.dto.EzbDatenSearchTO;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 09.08.2010
 * Time: 17:56:30
 * To change this template use File | Settings | File Templates.
 */
public interface EzbDatenManager extends GenericManager<EzbDaten, Long> {

    public EzbDaten loadWithJournalId(Long journalId) ;

    List<EzbDaten> findBySearchTO(EzbDatenSearchTO ezbDatenSearchTO, int maxResults);

    void connectEzbDaten(Long ezbId, Long journalId);

    Journal createJournal(Long  ezbId);
}