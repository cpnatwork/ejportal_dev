package ejportal.service;

import ejportal.model.Konsortium;
import org.appfuse.service.GenericManager;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:14:27
 * To change this template use File | Settings | File Templates.
 */
public interface KonsortiumManager extends GenericManager<Konsortium, Long> {

    public List<Konsortium> findByKonsortiumName(String konsortiumName);
    public List<Konsortium> findByKonsortiumName(String konsortiumName, Integer maxResults);
}
