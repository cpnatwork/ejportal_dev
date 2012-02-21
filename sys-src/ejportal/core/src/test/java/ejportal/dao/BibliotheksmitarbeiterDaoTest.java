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

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import ejportal.model.Bibliotheksmitarbeiter;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 05.08.2010 Time: 14:58:15 To
 * change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterDaoTest extends BaseDaoTestCase {

	/** The bibliotheksmitarbeiter dao. */
	@Autowired
	private BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao;

	/**
	 * Test find by name.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindByName() throws Exception {
		final List<Bibliotheksmitarbeiter> bibliotheksmitarbeiter = this.bibliotheksmitarbeiterDao
				.findByName("Bio Bib");

		Assert.assertNotNull(bibliotheksmitarbeiter.get(0).getName());
		Assert.assertNotNull(bibliotheksmitarbeiter.get(0)
				.getAbteilungsHauptstelle());
		Assert.assertNotNull(bibliotheksmitarbeiter.get(0).getEmailanschrift());

		Assert.assertTrue(bibliotheksmitarbeiter.size() > 0);
	}

	/**
	 * Test add and remove bibliotheksmitarbeiter.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@ExpectedException(DataAccessException.class)
	public void testAddAndRemoveBibliotheksmitarbeiter() throws Exception {
		Bibliotheksmitarbeiter bibliotheksmitarbeiter = new Bibliotheksmitarbeiter();
		bibliotheksmitarbeiter.setName("Test-Bibliotheksmitarbeiter 2");

		bibliotheksmitarbeiter = this.bibliotheksmitarbeiterDao
				.save(bibliotheksmitarbeiter);
		this.flush();

		bibliotheksmitarbeiter = this.bibliotheksmitarbeiterDao
				.get(bibliotheksmitarbeiter.getBibId());

		Assert.assertEquals("Test-Bibliotheksmitarbeiter 2",
				bibliotheksmitarbeiter.getName());
		Assert.assertNotNull(bibliotheksmitarbeiter.getBibId());

		this.log.debug("removing bibliotheksmitarbeiter...");

		this.bibliotheksmitarbeiterDao
				.remove(bibliotheksmitarbeiter.getBibId());
		this.flush();

		// should throw DataAccessException
		this.bibliotheksmitarbeiterDao.get(bibliotheksmitarbeiter.getBibId());
	}
}
