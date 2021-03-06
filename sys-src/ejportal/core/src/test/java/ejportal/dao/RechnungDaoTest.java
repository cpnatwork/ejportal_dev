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

import ejportal.model.Rechnung;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 09.08.2010 Time: 15:16:11 To
 * change this template use File | Settings | File Templates.
 */
public class RechnungDaoTest extends BaseDaoTestCase {

	/** The rechnung dao. */
	@Autowired
	private RechnungDao rechnungDao;

	/**
	 * Test find by exemplar.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindByExemplar() throws Exception {
		final List<Rechnung> rechnungen = this.rechnungDao.findByExemplarId(1L);
		Assert.assertTrue(rechnungen.size() > 0);
	}

	/**
	 * Test add and remove rechnung.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@ExpectedException(DataAccessException.class)
	public void testAddAndRemoveRechnung() throws Exception {
		Rechnung rechnung = new Rechnung();
		rechnung.setBetrag(999.99F);
		rechnung.setBezugsform("Irgendwas");
		rechnung.setBezugsjahr("2000");

		rechnung = this.rechnungDao.save(rechnung);
		this.flush();

		rechnung = this.rechnungDao.get(rechnung.getRechnungId());

		Assert.assertEquals("Irgendwas", rechnung.getBezugsform());
		Assert.assertNotNull(rechnung.getRechnungId());

		this.log.debug("removing rechnung...");

		this.rechnungDao.remove(rechnung.getRechnungId());
		this.flush();

		// should throw DataAccessException
		this.rechnungDao.get(rechnung.getRechnungId());
	}

}
