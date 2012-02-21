package ejportal.service.impl;

import ejportal.dao.BestellerDao;
import ejportal.dao.InteresseDao;
import ejportal.dao.SigelDao;
import ejportal.model.Besteller;
import ejportal.service.BestellerManager;
import ejportal.service.dto.BestellerBaseTO;
import ejportal.service.dto.BestellerSearchTO;
import ejportal.util.BeanUtil;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mkoerner
 * Date: 09.08.2010
 * Time: 16:14:50
 * To change this template use File | Settings | File Templates.
 */
public class BestellerManagerImpl extends GenericManagerImpl<Besteller, Long> implements BestellerManager {
    private BestellerDao bestellerDao;
    private InteresseDao interesseDao;
    private SigelDao sigelDao;
    private BeanUtil beanUtil;

    public BestellerManagerImpl(BestellerDao bestellerDao, InteresseDao interesseDao, SigelDao sigelDao){
        super(bestellerDao);
        this.bestellerDao = bestellerDao;
        this.interesseDao = interesseDao;
        this.sigelDao = sigelDao;
        this.beanUtil = new BeanUtil();
    }

    public List<Besteller> search(BestellerSearchTO bestellerSearchTO, Integer maxResults) {
        return bestellerDao.findBySearchTO(bestellerSearchTO, maxResults);
    }
    
    public void connectBestellerSigel(long bestellerId, long sigelId) {
        Besteller besteller = bestellerDao.get(bestellerId);
        besteller.setSigel(sigelDao.get(sigelId));
    }
    
    public BestellerBaseTO getBestellerBaseTO(long bestellerId) {
        //TODO Fehlerbehandlung
        Besteller besteller = bestellerDao.get(bestellerId);
        BestellerBaseTO bestellerBaseTO = new BestellerBaseTO();

        try {
            //here comes the reflection voodoo ;-)
            beanUtil.copyEntityToBaseTO(besteller,bestellerBaseTO);
            //jetzt sind im bestellerBaseTO alle Attribute von besteller OHNE die Beziehungen!
        } catch (Exception e) {
            //TODO Fehlerbehandlung
            e.printStackTrace();
        }
        return   bestellerBaseTO;    }

    public Besteller saveBaseTO(BestellerBaseTO bestellerBaseTO) {
        //erst mal den Besteller holen
        Besteller besteller = bestellerDao.get(bestellerBaseTO.getBestellerId());
        try {
            //mit reflection voodoo die Daten vom bestellerBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(bestellerBaseTO, besteller);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();
        }

        besteller = save(besteller);
        return besteller;    }

    public Besteller create(BestellerBaseTO bestellerBaseTO) {

        //Neuen Besteller erstellen
        Besteller besteller = new Besteller();

        //Attribute aus dem BaseTO füllen
        try {
            //mit reflection voodoo die Daten vom bestellerBaseTO uebertragen
            beanUtil.copyBaseTOtoEntity(bestellerBaseTO, besteller);
        } catch (Exception e) {
            //TODO Exceptionhandling
            e.printStackTrace();
        }

        //Speichern und gut is!
        besteller = save(besteller);
        return besteller;    }
}
