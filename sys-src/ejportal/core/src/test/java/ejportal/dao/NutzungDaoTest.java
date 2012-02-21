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

import ejportal.model.Nutzung;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 09.08.2010 Time: 16:22:05 To
 * change this template use File | Settings | File Templates.
 */
public class NutzungDaoTest extends BaseDaoTestCase {

	/** The nutzung dao. */
	@Autowired
	private NutzungDao nutzungDao;

	/**
	 * Test add and remove journal.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@ExpectedException(DataAccessException.class)
	public void testAddAndRemoveJournal() throws Exception {
		Nutzung nutzung = new Nutzung();
		nutzung.setRechnungsbetrag(2.09F);

		nutzung = this.nutzungDao.save(nutzung);
		this.flush();

		nutzung = this.nutzungDao.get(nutzung.getNutzungId());

		Assert.assertEquals(new Float(2.09F), nutzung.getRechnungsbetrag());
		Assert.assertNotNull(nutzung.getNutzungId());

		this.log.debug("removing Nutzung...");

		this.nutzungDao.remove(nutzung.getNutzungId());
		this.flush();

		// should throw DataAccessException
		this.nutzungDao.get(nutzung.getNutzungId());
	}
}
