package ejportal.service.impl;

import ejportal.dao.WechselkursDao;
import ejportal.model.Wechselkurs;
import ejportal.service.WechselkursManager;
import org.appfuse.service.impl.GenericManagerImpl;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 11.08.2010
 * Time: 12:43:59
 * To change this template use File | Settings | File Templates.
 */
public class WechselkursManagerImpl extends GenericManagerImpl<Wechselkurs, Long> implements WechselkursManager{
    private WechselkursDao wechselkursDao;

    public WechselkursManagerImpl(WechselkursDao wechselkursDao){
        super(wechselkursDao);
        this.wechselkursDao = wechselkursDao;
    }

    public Wechselkurs findByWaehrung(String waehrung) {
        return wechselkursDao.findByWaehrung(waehrung);
    }
}
