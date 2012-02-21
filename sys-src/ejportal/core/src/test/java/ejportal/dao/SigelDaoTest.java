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

import ejportal.model.Sigel;

/**
 * Created by IntelliJ IDEA. User: Chris Date: 28.06.2010 Time: 15:20:51 To
 * change this template use File | Settings | File Templates.
 */
public class SigelDaoTest extends BaseDaoTestCase {

	/** The sigel dao. */
	@Autowired
	private SigelDao sigelDao;

	/**
	 * Test find by name.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindByName() throws Exception {
		final List<Sigel> sigel = this.sigelDao.findByName("EB");

		// test, ob institutionen drin haengen
		Assert.assertNotNull(sigel.get(0).getName());
		Assert.assertNotNull(sigel.get(0).getBibliothek());
		Assert.assertNotNull(sigel.get(0).getFakultaet());

		Assert.assertTrue(sigel.size() > 0);
	}

	/**
	 * Test add and remove sigel.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@ExpectedException(DataAccessException.class)
	public void testAddAndRemoveSigel() throws Exception {
		Sigel sigel = new Sigel();
		sigel.setName("Test-Sigel 2");

		sigel = this.sigelDao.save(sigel);
		this.flush();

		sigel = this.sigelDao.get(sigel.getSigelId());

		Assert.assertEquals("Test-Sigel 2", sigel.getName());
		Assert.assertNotNull(sigel.getSigelId());

		this.log.debug("removing sigel...");

		this.sigelDao.remove(sigel.getSigelId());
		this.flush();

		// should throw DataAccessException
		this.sigelDao.get(sigel.getSigelId());
	}
}
