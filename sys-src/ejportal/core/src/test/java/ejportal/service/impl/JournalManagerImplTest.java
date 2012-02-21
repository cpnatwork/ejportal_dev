package ejportal.service.impl;

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 14:22:58
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.List;

import ejportal.dao.*;
import ejportal.model.Journal;
import org.appfuse.service.impl.BaseManagerMockTestCase;

import org.jmock.Expectations;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class JournalManagerImplTest extends BaseManagerMockTestCase {
    private JournalManagerImpl manager = null;
    private JournalDao journalDao = null;
    private InstitutionDao institutionDao;
    private KonsortiumDao konsortiumDao;
    private PaketDao paketDao;
    private FachDao fachDao;
    private BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao;
    private ExemplarDao exemplarDao;

    @Before
    public void setUp() {
        journalDao = context.mock(JournalDao.class);
        institutionDao = context.mock(InstitutionDao.class);
        konsortiumDao = context.mock(KonsortiumDao.class);
        paketDao = context.mock(PaketDao.class);
        fachDao = context.mock(FachDao.class);
        bibliotheksmitarbeiterDao = context.mock(BibliotheksmitarbeiterDao.class);
        exemplarDao = context.mock(ExemplarDao.class);
        manager = new JournalManagerImpl(journalDao, institutionDao, konsortiumDao, paketDao, fachDao, exemplarDao, bibliotheksmitarbeiterDao);
    }

    @After
    public void tearDown() {
        manager = null;
    }

    @Test
    public void testGetJournal() {
        log.debug("testing get...");

        final Long id = 7L;
        final Journal journal = new Journal();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(journalDao).get(with(equal(id)));
            will(returnValue(journal));
        }});

        Journal result = manager.get(id);
        assertSame(journal, result);
    }

    @Test
    public void testGetJournals() {
        log.debug("testing getAll...");

        final List journals = new ArrayList();

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(journalDao).getAll();
            will(returnValue(journals));
        }});

        List result = manager.getAll();

        assertSame(journals, result);
    }

    @Test
    public void testSaveJournal() {
        log.debug("testing save...");

        final Journal journal = new Journal();
        // enter all required fields

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(journalDao).save(with(same(journal)));
        }});

        manager.save(journal);
    }

    @Test
    public void testRemoveJournal() {
        log.debug("testing remove...");

        final Long id = -11L;

        // set expected behavior on dao
        context.checking(new Expectations() {{
            one(journalDao).remove(with(equal(id)));
        }});

        manager.remove(id);
    }
    
}

