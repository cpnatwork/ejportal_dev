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

import ejportal.model.Paket;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 04.08.2010 Time: 09:58:24 To
 * change this template use File | Settings | File Templates.
 */
public class PaketDaoTest extends BaseDaoTestCase {

	/** The paket dao. */
	@Autowired
	private PaketDao paketDao;

	/**
	 * Test find paket by name.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindPaketByName() throws Exception {
		final List<Paket> pakete = this.paketDao
				.findByPaketName("Kombi: Journal of allergy and clinical immunology");

		// test, ob pakete drin haengen
		Assert.assertNotNull(pakete.get(0).getPaketName());

		Assert.assertTrue(pakete.size() > 0);
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
		Paket paket = new Paket();
		paket.setPaketName("Paket Test");

		paket = this.paketDao.save(paket);
		this.flush();

		paket = this.paketDao.get(paket.getPaketId());

		Assert.assertEquals("Paket Test", paket.getPaketName());
		Assert.assertNotNull(paket.getPaketId());

		this.log.debug("removing paket...");

		this.paketDao.remove(paket.getPaketId());
		this.flush();

		// should throw DataAccessException
		this.paketDao.get(paket.getPaketId());
	}

}
