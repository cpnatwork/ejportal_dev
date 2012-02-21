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

import ejportal.model.Institution;
import ejportal.service.dto.InstitutionSearchTO;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 21.06.2010 Time: 12:39:44 To
 * change this template use File | Settings | File Templates.
 */
public class InstitutionDaoTest extends BaseDaoTestCase {

	/** The institution dao. */
	@Autowired
	private InstitutionDao institutionDao;

	/**
	 * Test find by name.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testFindByName() throws Exception {
		final InstitutionSearchTO institutionSearchTO = new InstitutionSearchTO();
		institutionSearchTO.setName("Springer");

		final List<Institution> institutionen = this.institutionDao
				.findBySearchTO(institutionSearchTO);
		Assert.assertTrue(institutionen.size() > 0);
	}

	/**
	 * Test add and remove institution.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@ExpectedException(DataAccessException.class)
	public void testAddAndRemoveInstitution() throws Exception {
		Institution institution = new Institution();
		institution.setName("BayernDirekt");

		institution = this.institutionDao.save(institution);
		this.flush();

		institution = this.institutionDao.get(institution.getId());

		Assert.assertEquals("BayernDirekt", institution.getName());

		System.out.println(institution.getId());
		Assert.assertNotNull(institution.getId());

		this.log.debug("removing institution...");

		this.institutionDao.remove(institution.getId());
		this.flush();

		// should throw DataAccessException
		this.institutionDao.get(institution.getId());

	}
}
