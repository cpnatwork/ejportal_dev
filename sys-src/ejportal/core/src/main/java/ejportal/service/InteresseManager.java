package ejportal.service;

import ejportal.model.Interesse;
import ejportal.service.dto.InteresseBaseTO;
import org.appfuse.service.GenericManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 09.08.2010
 * Time: 16:14:14
 * To change this template use File | Settings | File Templates.
 */
public interface InteresseManager extends GenericManager<Interesse, Long> {

    public List<Interesse> getListForJournal(Long journalId);

    public void connectInteresseJournal(Long interesseId, Long journalId);
    public void connectInteresseBesteller(Long interesseID, Long bestellerId);

    public InteresseBaseTO getInteresseBaseTO(Long interesseId);
    public Interesse saveBaseTO(InteresseBaseTO interesseBaseTO);
    public Interesse create(InteresseBaseTO interesseBaseTO, Long journalId);
}
