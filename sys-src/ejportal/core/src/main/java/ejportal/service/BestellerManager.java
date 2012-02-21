package ejportal.service;

import ejportal.model.Besteller;
import ejportal.service.dto.BestellerBaseTO;
import ejportal.service.dto.BestellerSearchTO;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 09.08.2010
 * Time: 16:13:01
 * To change this template use File | Settings | File Templates.
 */
public interface BestellerManager extends GenericManager<Besteller, Long> {

    public List<Besteller> search(BestellerSearchTO bestellerSearchTO, Integer maxResults);

    public void connectBestellerSigel(long bestellerId, long sigelId);

    public BestellerBaseTO getBestellerBaseTO(long bestellerId);
    public Besteller saveBaseTO(BestellerBaseTO bestellerBaseTO);
    public Besteller create(BestellerBaseTO bestellerBaseTO);

}
