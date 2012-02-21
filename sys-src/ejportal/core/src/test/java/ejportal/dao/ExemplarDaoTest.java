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

import ejportal.model.Exemplar;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 04.08.2010 Time: 12:22:22 To
 * change this template use File | Settings | File Templates.
 */
public class ExemplarDaoTest extends BaseDaoTestCase {

	/** The exemplar dao. */
	@Autowired
	private ExemplarDao exemplarDao;

	/**
	 * Test add and remove journal.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@ExpectedException(DataAccessException.class)
	public void testAddAndRemoveJournal() throws Exception {
		Exemplar exemplar = new Exemplar();
		exemplar.setForm("Print");

		exemplar = this.exemplarDao.save(exemplar);
		this.flush();

		exemplar = this.exemplarDao.get(exemplar.getExemplarId());

		Assert.assertEquals("Print", exemplar.getForm());
		Assert.assertNotNull(exemplar.getExemplarId());

		this.log.debug("removing Exemplar...");

		this.exemplarDao.remove(exemplar.getExemplarId());
		this.flush();

		// should throw DataAccessException
		this.exemplarDao.get(exemplar.getExemplarId());
	}

	/**
	 * Test find exemplar for journal.
	 */
	@Test
	public void testFindExemplarForJournal() {
		final List<Exemplar> exemplare = this.exemplarDao.getListForJournal(2);
		this.log.debug("getting exemplare for journals");
		Assert.assertNotNull(exemplare);
	}
}