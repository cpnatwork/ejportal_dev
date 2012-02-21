package ejportal.service.impl;

import ejportal.dao.JournalDao;
import ejportal.dao.JournalkostenDao;
import ejportal.dao.WechselkursDao;
import ejportal.model.Journalkosten;
import ejportal.service.JournalkostenManager;
import org.appfuse.service.GenericManager;
import org.appfuse.service.impl.GenericManagerImpl;

import java.text.DecimalFormat;

/**
 * Created by IntelliJ IDEA.
 * User: ag35ogub
 * Date: 09.08.2010
 * Time: 15:30:10
 * To change this template use File | Settings | File Templates.
 */
public class JournalkostenManagerImpl extends GenericManagerImpl<Journalkosten, Long> implements JournalkostenManager {

    private JournalkostenDao journalkostenDao;
    private WechselkursDao wechselkursDao;
    private JournalDao journalDao;

    public JournalkostenManagerImpl(JournalkostenDao journalkostenDao, WechselkursDao wechselkursDao, JournalDao journalDao){
        super(journalkostenDao);
        this.journalkostenDao = journalkostenDao;
        this.wechselkursDao = wechselkursDao;
        this.journalDao = journalDao;
    }

    public Journalkosten findByJournalId(long journalId) {
        return journalkostenDao.findByJournalId(journalId);
    }

    public String getEndpreisPO(long journalId){
        Journalkosten jk = findByJournalId(journalId);
        float faktor = wechselkursDao.findByWaehrung(jk.getWaehrungPO()).getUmrechnungsfaktor();
        float endpreis = jk.getOPreisPO() * ((Float.valueOf(jk.getMwStPO()) / 100) + 1) * faktor;
        DecimalFormat df = new DecimalFormat( "###,##0.00" );
        return df.format(endpreis)+ " EUR";
    }

    public String getEndpreisP(long journalId){
        Journalkosten jk = findByJournalId(journalId);
        float faktor = wechselkursDao.findByWaehrung(jk.getWaehrungP()).getUmrechnungsfaktor();
        float endpreis = jk.getOPreisP() * ((Float.valueOf(jk.getMwStP()) / 100) + 1) * faktor;
        DecimalFormat df = new DecimalFormat( "###,##0.00" );
        return df.format(endpreis)+ " EUR";
    }

    public String getEndpreisO(long journalId){
        Journalkosten jk = findByJournalId(journalId);
        float faktor = wechselkursDao.findByWaehrung(jk.getWaehrungO()).getUmrechnungsfaktor();
        float endpreis = jk.getOPreisO() * ((Float.valueOf(jk.getMwStO()) / 100) + 1) * faktor;
        DecimalFormat df = new DecimalFormat( "###,##0.00" );
        return df.format(endpreis)+ " EUR";
    }

    public String getEndpreisIPO(long journalId){
        Journalkosten jk = findByJournalId(journalId);
        float faktor = wechselkursDao.findByWaehrung(jk.getIWaehrungPO()).getUmrechnungsfaktor();
        float endpreis = jk.getIPreisPO() * ((Float.valueOf(jk.getIMwStPO()) / 100) + 1) * faktor;
        DecimalFormat df = new DecimalFormat( "###,##0.00" );
        return df.format(endpreis)+ " EUR";
    }

    public String getEndpreisIP(long journalId){
        Journalkosten jk = findByJournalId(journalId);
        float faktor = wechselkursDao.findByWaehrung(jk.getIWaehrungP()).getUmrechnungsfaktor();
        float endpreis = jk.getIPreisP() * ((Float.valueOf(jk.getIMwStP()) / 100) + 1) * faktor;
        DecimalFormat df = new DecimalFormat( "###,##0.00" );
        return df.format(endpreis)+ " EUR";
    }

    public String getEndpreisIO(long journalId){
        Journalkosten jk = findByJournalId(journalId);
        float faktor = wechselkursDao.findByWaehrung(jk.getIWaehrungO()).getUmrechnungsfaktor();
        float endpreis = jk.getIPreisO() * ((Float.valueOf(jk.getIMwStO()) / 100) + 1) * faktor;
        DecimalFormat df = new DecimalFormat( "###,##0.00" );
        return df.format(endpreis) + " EUR";
    }

    public Journalkosten saveWithJournal(Journalkosten journalkosten, Long journalId){
        journalkosten.setJournal(journalDao.get(journalId));
        return super.save(journalkosten);
    }
}
