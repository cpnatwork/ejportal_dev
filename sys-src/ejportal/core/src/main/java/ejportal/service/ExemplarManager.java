package ejportal.service;

import ejportal.model.Exemplar;
import ejportal.model.Journal;
import ejportal.service.dto.ExemplarBaseTO;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Christoph
 * Date: 14.07.2010
 * Time: 16:14:10
 * To change this template use File | Settings | File Templates.
 */
public interface ExemplarManager extends GenericManager<Exemplar, Long> {
    public void connectExemplarLieferant(long exemplarId, long lieferantId);
    public void connectExemplarEigentuemer(long exemplarId, long eigentuemerId);
    public void connectExemplarBesteller(long exemplarId, long bestellerId);
    public void connectExemplarZustaendigeBib(long exemplarId, long zustaendigeBibId);

    public ExemplarBaseTO getExemplarBaseTO(long id);

    public Exemplar saveBaseTO(ExemplarBaseTO exemplarBaseTO);
    public Exemplar create(ExemplarBaseTO exemplarBaseTO, Long journalId);

    public void removeSafe(Long exemplarId);
}
