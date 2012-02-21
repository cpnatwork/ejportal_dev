package ejportal.service.impl;

import ejportal.dao.JournalDao;
import ejportal.service.JournalTitelService;

/**
 * Created by IntelliJ IDEA.
 * User: florian
 * Date: 11.08.2010
 * Time: 13:40:37
 * To change this template use File | Settings | File Templates.
 */
public class JournalTitelServiceImpl implements JournalTitelService {
    private  JournalDao journalDao;

    public JournalTitelServiceImpl(JournalDao journalDao) {
        this.journalDao=journalDao;
    }


    public String getTitel(long journalId) {
        return journalDao.get(journalId).getTitel();
    }
}
