package ejportal.service;

import ejportal.model.Rechnung;
import ejportal.service.dto.RechnungBaseTO;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Tselmeg
 * Date: 09.08.2010
 * Time: 15:02:46
 * To change this template use File | Settings | File Templates.
 */
public interface RechnungManager extends GenericManager<Rechnung, Long> {
    
    public List<Rechnung> getListForExemplar(long exemplarId);
    public List<Rechnung> getListForJournal(long journalId);

    public void connectRechnungExemplar(long rechnungId, long exemplarId);


    public RechnungBaseTO getRechnungBaseTO(Long rechnungId);
    public Rechnung saveBaseTO(RechnungBaseTO rechnungBaseTO);
    public Rechnung create(RechnungBaseTO rechnungBaseTO, Long exemplarId);
}
