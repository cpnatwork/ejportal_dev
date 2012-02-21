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

import ejportal.model.Besteller;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 16:23:36 To
 * change this template use File | Settings | File Templates.
 */
public class BestellerDaoTest extends BaseDaoTestCase {

	/** The besteller dao. */
	@Autowired
	private BestellerDao bestellerDao;

	/**
	 * Test find by id.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindById() throws Exception {
		final List<Besteller> besteller = this.bestellerDao
				.findByBestellerId(1L);
		Assert.assertTrue(besteller.size() > 0);
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
		Besteller besteller = new Besteller();
		besteller.setBestellerName("BestellerName");

		besteller = this.bestellerDao.save(besteller);
		this.flush();

		besteller = this.bestellerDao.get(besteller.getBestellerId());

		Assert.assertEquals("BestellerName", besteller.getBestellerName());
		Assert.assertNotNull(besteller.getBestellerId());

		this.log.debug("removing Besteller...");

		this.bestellerDao.remove(besteller.getBestellerId());
		this.flush();

		// should throw DataAccessException
		this.bestellerDao.get(besteller.getBestellerId());

	}
}
