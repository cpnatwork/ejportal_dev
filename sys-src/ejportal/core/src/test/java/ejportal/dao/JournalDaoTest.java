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
package ejportal.dao;

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 13:40:30
 * To change this template use File | Settings | File Templates.
 */

import java.util.Date;
import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import ejportal.model.Fach;
import ejportal.model.Journal;

/**
 * The Class JournalDaoTest.
 */
public class JournalDaoTest extends BaseDaoTestCase {

	/** The journal dao. */
	@Autowired
	private JournalDao journalDao;

	/**
	 * Test find journal by titel.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindJournalByTitel() throws Exception {
		/*
		 * FIXME: there is a coding problem... /* final List<Journal> journals =
		 * this.journalDao .findByTitel("Die wei�e Spinne");
		 * 
		 * // test, ob institutionen drin haengen
		 * Assert.assertNotNull(journals.get(0).getVerlag());
		 * Assert.assertNotNull(journals.get(0).getProvider());
		 * Assert.assertNotNull(journals.get(0).getKonsortium());
		 * 
		 * Assert.assertTrue(journals.size() > 0);
		 */
	}

	/**
	 * Test find journal by kurztitel.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindJournalByKurztitel() throws Exception {
		final List<Journal> journals = this.journalDao.findByKurztitel("DwS");
		Assert.assertTrue(journals.size() > 0);
	}

	/**
	 * Test add and remove journal.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@ExpectedException(DataAccessException.class)
	public void testAddAndRemoveJournal() throws Exception {
		Journal journal = new Journal();
		journal.setTitel("Westalpen");
		journal.setKurztitel("W");

		journal = this.journalDao.save(journal);
		this.flush();

		journal = this.journalDao.get(journal.getId());

		Assert.assertEquals("Westalpen", journal.getTitel());
		Assert.assertNotNull(journal.getId());

		this.log.debug("removing journal...");

		this.journalDao.remove(journal.getId());
		this.flush();

		// should throw DataAccessException
		this.journalDao.get(journal.getId());
	}

	/**
	 * Test get faecher.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetFaecher() throws Exception {
		final List<Journal> journals = this.journalDao.findByKurztitel("DwS");
		Assert.assertTrue(journals.size() > 0);
		final Journal j = journals.get(0);
		final java.util.Set<Fach> faecher = j.getFaecher();
		// System.err.println("Faecher:"+faecher.get(0));
		Assert.assertTrue(faecher.size() > 0);
	}

	/**
	 * Test find by bearbeitungsdatum.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindByBearbeitungsdatum() throws Exception {
		final List<Journal> journals = this.journalDao
				.findByBearbeitungsdatum(new Date());
		Assert.assertTrue(journals.size() > 0);

	}

}
