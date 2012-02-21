/**************************************************************************
 * ejPortal
 * ==============================================
 * Copyright (C) 2010-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Irmert
 *   - and the SWAT 2010 team
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
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

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejportal.dao.BibliotheksmitarbeiterDao;
import ejportal.dao.ExemplarDao;
import ejportal.dao.FachDao;
import ejportal.dao.InstitutionDao;
import ejportal.dao.JournalDao;
import ejportal.dao.KonsortiumDao;
import ejportal.dao.PaketDao;
import ejportal.model.Journal;

/**
 * The Class JournalManagerImplTest.
 */
public class JournalManagerImplTest extends BaseManagerMockTestCase {

	/** The manager. */
	private JournalManagerImpl manager = null;

	/** The journal dao. */
	private JournalDao journalDao = null;

	/** The institution dao. */
	private InstitutionDao institutionDao;

	/** The konsortium dao. */
	private KonsortiumDao konsortiumDao;

	/** The paket dao. */
	private PaketDao paketDao;

	/** The fach dao. */
	private FachDao fachDao;

	/** The bibliotheksmitarbeiter dao. */
	private BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao;

	/** The exemplar dao. */
	private ExemplarDao exemplarDao;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		this.journalDao = this.context.mock(JournalDao.class);
		this.institutionDao = this.context.mock(InstitutionDao.class);
		this.konsortiumDao = this.context.mock(KonsortiumDao.class);
		this.paketDao = this.context.mock(PaketDao.class);
		this.fachDao = this.context.mock(FachDao.class);
		this.bibliotheksmitarbeiterDao = this.context
				.mock(BibliotheksmitarbeiterDao.class);
		this.exemplarDao = this.context.mock(ExemplarDao.class);
		this.manager = new JournalManagerImpl(this.journalDao,
				this.institutionDao, this.konsortiumDao, this.paketDao,
				this.fachDao, this.exemplarDao, this.bibliotheksmitarbeiterDao);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.manager = null;
	}

	/**
	 * Test get journal.
	 */
	@Test
	public void testGetJournal() {
		this.log.debug("testing get...");

		final Long id = 7L;
		final Journal journal = new Journal();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(JournalManagerImplTest.this.journalDao).get(
						this.with(Expectations.equal(id)));
				this.will(Expectations.returnValue(journal));
			}
		});

		final Journal result = this.manager.get(id);
		Assert.assertSame(journal, result);
	}

	/**
	 * Test get journals.
	 */
	@Test
	public void testGetJournals() {
		this.log.debug("testing getAll...");

		final List journals = new ArrayList();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(JournalManagerImplTest.this.journalDao).getAll();
				this.will(Expectations.returnValue(journals));
			}
		});

		final List result = this.manager.getAll();

		Assert.assertSame(journals, result);
	}

	/**
	 * Test save journal.
	 */
	@Test
	public void testSaveJournal() {
		this.log.debug("testing save...");

		final Journal journal = new Journal();
		// enter all required fields

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(JournalManagerImplTest.this.journalDao).save(
						this.with(Expectations.same(journal)));
			}
		});

		this.manager.save(journal);
	}

	/**
	 * Test remove journal.
	 */
	@Test
	public void testRemoveJournal() {
		this.log.debug("testing remove...");

		final Long id = -11L;

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(JournalManagerImplTest.this.journalDao).remove(
						this.with(Expectations.equal(id)));
			}
		});

		this.manager.remove(id);
	}

}
