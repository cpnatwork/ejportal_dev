package ejportal.service;

import ejportal.model.Journalkosten;
import org.appfuse.service.GenericManager;


/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 09.08.2010
 * Time: 15:28:15
 * To change this template use File | Settings | File Templates.
 */
public interface JournalkostenManager  extends GenericManager<Journalkosten, Long> {

    public Journalkosten findByJournalId(long journalId);

    public String getEndpreisPO(long journalId);
    public String getEndpreisP(long journalId);
    public String getEndpreisO(long journalId);
    public String getEndpreisIPO(long journalId);
    public String getEndpreisIP(long journalId);
    public String getEndpreisIO(long journalId);

    public Journalkosten saveWithJournal(Journalkosten journalkosten, Long journalId);
    
}
