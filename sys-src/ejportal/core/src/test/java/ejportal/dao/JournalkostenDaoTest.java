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

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.ExpectedException;

import ejportal.model.Journalkosten;

/**
 * Created by IntelliJ IDEA. User: ag35ogub Date: 12.08.2010 Time: 11:30:02 To
 * change this template use File | Settings | File Templates.
 */
public class JournalkostenDaoTest extends BaseDaoTestCase {

	/** The journalkosten dao. */
	@Autowired
	private JournalkostenDao journalkostenDao;

	/**
	 * Test find by journal id.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindByJournalId() throws Exception {
		final Journalkosten journalkosten = this.journalkostenDao
				.findByJournalId(1L);
		Assert.assertTrue(journalkosten != null);
	}

	/**
	 * Test add and remove.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@ExpectedException(DataAccessException.class)
	public void testAddAndRemove() throws Exception {
		Journalkosten journalkosten = new Journalkosten();
		journalkosten.setOPreisPO((long) 123.12);

		journalkosten = this.journalkostenDao.save(journalkosten);
		this.flush();

		journalkosten = this.journalkostenDao.get(journalkosten
				.getJournalkostenId());

		Assert.assertEquals((long) 123.12, (long) journalkosten.getOPreisPO());
		Assert.assertNotNull(journalkosten.getJournalkostenId());

		this.log.debug("removing Journalkosten...");

		this.journalkostenDao.remove(journalkosten.getJournalkostenId());
		this.flush();

		// should throw DataAccessException
		this.journalkostenDao.get(journalkosten.getJournalkostenId());

	}
}
