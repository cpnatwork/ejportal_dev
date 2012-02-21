package ejportal.service;

import ejportal.model.Wechselkurs;
import org.appfuse.service.GenericManager;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 11.08.2010
 * Time: 12:42:06
 * To change this template use File | Settings | File Templates.
 */
public interface WechselkursManager extends GenericManager<Wechselkurs, Long> {
    public Wechselkurs findByWaehrung(String waehrung);
}
