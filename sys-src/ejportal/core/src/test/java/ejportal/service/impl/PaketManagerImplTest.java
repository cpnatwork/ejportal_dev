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

import ejportal.dao.PaketDao;
import ejportal.model.Paket;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 04.08.2010 Time: 10:06:04 To
 * change this template use File | Settings | File Templates.
 */
public class PaketManagerImplTest extends BaseManagerMockTestCase {

	/** The manager. */
	private PaketManagerImpl manager = null;

	/** The paket dao. */
	private PaketDao paketDao = null;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		this.paketDao = this.context.mock(PaketDao.class);
		this.manager = new PaketManagerImpl(this.paketDao);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.manager = null;
	}

	/**
	 * Test get paket.
	 */
	@Test
	public void testGetPaket() {
		this.log.debug("testing get...");

		final Long id = 7L;
		final Paket paket = new Paket();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(PaketManagerImplTest.this.paketDao).get(
						this.with(Expectations.equal(id)));
				this.will(Expectations.returnValue(paket));
			}
		});

		final Paket result = this.manager.get(id);
		Assert.assertSame(paket, result);
	}

	/**
	 * Test get pakete.
	 */
	@Test
	public void testGetPakete() {
		this.log.debug("testing getAll...");

		final List pakete = new ArrayList();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(PaketManagerImplTest.this.paketDao).getAll();
				this.will(Expectations.returnValue(pakete));
			}
		});

		final List result = this.manager.getAll();

		Assert.assertSame(pakete, result);
	}

	/**
	 * Test save paket.
	 */
	@Test
	public void testSavePaket() {
		this.log.debug("testing save...");

		final Paket paket = new Paket();
		// enter all required fields

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(PaketManagerImplTest.this.paketDao).save(
						this.with(Expectations.same(paket)));
			}
		});

		this.manager.save(paket);
	}

	/**
	 * Test remove paket.
	 */
	@Test
	public void testRemovePaket() {
		this.log.debug("testing remove...");

		final Long id = -11L;

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(PaketManagerImplTest.this.paketDao).remove(
						this.with(Expectations.equal(id)));
			}
		});

		this.manager.remove(id);
	}

}
