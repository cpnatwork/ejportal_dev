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
package ejportal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejportal.dao.BestellerDao;
import ejportal.dao.InteresseDao;
import ejportal.dao.SigelDao;
import ejportal.model.Besteller;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 16:33:14 To
 * change this template use File | Settings | File Templates.
 */
public class BestellerManagerImplTest extends BaseManagerMockTestCase {

	/** The manager. */
	private BestellerManagerImpl manager = null;

	/** The besteller dao. */
	private BestellerDao bestellerDao = null;

	/** The interesse dao. */
	private InteresseDao interesseDao = null;

	/** The sigel dao. */
	private SigelDao sigelDao = null;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		this.bestellerDao = this.context.mock(BestellerDao.class);
		this.interesseDao = this.context.mock(InteresseDao.class);
		this.sigelDao = this.context.mock(SigelDao.class);
		this.manager = new BestellerManagerImpl(this.bestellerDao,
				this.interesseDao, this.sigelDao);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.manager = null;
	}

	/**
	 * Test get besteller.
	 */
	@Test
	public void testGetBesteller() {
		this.log.debug("testing get...");

		final Long id = 7L;
		final Besteller besteller = new Besteller();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(BestellerManagerImplTest.this.bestellerDao).get(
						this.with(Expectations.equal(id)));
				this.will(Expectations.returnValue(besteller));
			}
		});

		final Besteller result = this.manager.get(id);
		Assert.assertSame(besteller, result);
	}

	/**
	 * Test get bestellers.
	 */
	@Test
	public void testGetBestellers() {
		this.log.debug("testing getAll...");

		final List bestellers = new ArrayList();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(BestellerManagerImplTest.this.bestellerDao).getAll();
				this.will(Expectations.returnValue(bestellers));
			}
		});

		final List result = this.manager.getAll();

		Assert.assertSame(bestellers, result);
	}

	/**
	 * Test save besteller.
	 */
	@Test
	public void testSaveBesteller() {
		this.log.debug("testing save...");

		final Besteller besteller = new Besteller();
		// enter all required fields

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(BestellerManagerImplTest.this.bestellerDao).save(
						this.with(Expectations.same(besteller)));
			}
		});

		this.manager.save(besteller);
	}

	/**
	 * Test remove besteller.
	 */
	@Test
	public void testRemoveBesteller() {
		this.log.debug("testing remove...");

		final Long id = 1L;

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(BestellerManagerImplTest.this.bestellerDao).remove(
						this.with(Expectations.equal(id)));
			}
		});

		this.manager.remove(id);
	}
}
