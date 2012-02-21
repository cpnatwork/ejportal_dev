package ejportal.service;

import ejportal.model.Nutzung;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 09.08.2010
 * Time: 16:12:28
 * To change this template use File | Settings | File Templates.
 */
public interface NutzungManager extends GenericManager<Nutzung, Long> {
    public List<Nutzung> findByJournalId(Long journalId);
    public Nutzung saveWithJournal(Nutzung nutzung, Long journalId);
}
