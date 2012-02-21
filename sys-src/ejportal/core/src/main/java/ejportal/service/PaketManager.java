package ejportal.service;

import ejportal.model.Paket;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uj32uvac
 * Date: 07.07.2010
 * Time: 16:13:52
 * To change this template use File | Settings | File Templates.
 */
public interface PaketManager extends GenericManager<Paket, Long> {
    public List<Paket> findByPaketName(String paketName);
    public List<Paket> findByPaketName(String paketName, Integer maxResults);
}
