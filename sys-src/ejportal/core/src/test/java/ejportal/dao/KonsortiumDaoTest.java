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

import ejportal.model.Konsortium;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 03.08.2010 Time: 16:42:22 To
 * change this template use File | Settings | File Templates.
 */
public class KonsortiumDaoTest extends BaseDaoTestCase {

	/** The konsortium dao. */
	@Autowired
	private KonsortiumDao konsortiumDao;

	/**
	 * Test find konsortium by name.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindKonsortiumByName() throws Exception {
		final List<Konsortium> konsortien = this.konsortiumDao
				.findByKonsortiumName("Elsevier-K");

		// test, ob institutionen drin haengen
		Assert.assertNotNull(konsortien.get(0).getKonsortiumName());

		Assert.assertTrue(konsortien.size() > 0);
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
		Konsortium konsortium = new Konsortium();
		konsortium.setKonsortiumName("Konsortium Test");

		konsortium = this.konsortiumDao.save(konsortium);
		this.flush();

		konsortium = this.konsortiumDao.get(konsortium.getKonsortiumId());

		Assert.assertEquals("Konsortium Test", konsortium.getKonsortiumName());
		Assert.assertNotNull(konsortium.getKonsortiumId());

		this.log.debug("removing konsortium...");

		this.konsortiumDao.remove(konsortium.getKonsortiumId());
		this.flush();

		// should throw DataAccessException
		this.konsortiumDao.get(konsortium.getKonsortiumId());
	}

}