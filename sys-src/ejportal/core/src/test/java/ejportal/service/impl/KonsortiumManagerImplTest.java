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

import ejportal.dao.KonsortiumDao;
import ejportal.model.Konsortium;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 03.08.2010 Time: 16:49:18 To
 * change this template use File | Settings | File Templates.
 */
public class KonsortiumManagerImplTest extends BaseManagerMockTestCase {

	/** The manager. */
	private KonsortiumManagerImpl manager = null;

	/** The konsortium dao. */
	private KonsortiumDao konsortiumDao = null;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		this.konsortiumDao = this.context.mock(KonsortiumDao.class);
		this.manager = new KonsortiumManagerImpl(this.konsortiumDao);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.manager = null;
	}

	/**
	 * Test get konsortium.
	 */
	@Test
	public void testGetKonsortium() {
		this.log.debug("testing get...");

		final Long id = 7L;
		final Konsortium konsortium = new Konsortium();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(KonsortiumManagerImplTest.this.konsortiumDao).get(
						this.with(Expectations.equal(id)));
				this.will(Expectations.returnValue(konsortium));
			}
		});

		final Konsortium result = this.manager.get(id);
		Assert.assertSame(konsortium, result);
	}

	/**
	 * Test get konsortiums.
	 */
	@Test
	public void testGetKonsortiums() {
		this.log.debug("testing getAll...");

		final List konsortiums = new ArrayList();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(KonsortiumManagerImplTest.this.konsortiumDao).getAll();
				this.will(Expectations.returnValue(konsortiums));
			}
		});

		final List result = this.manager.getAll();

		Assert.assertSame(konsortiums, result);
	}

	/**
	 * Test save konsortium.
	 */
	@Test
	public void testSaveKonsortium() {
		this.log.debug("testing save...");

		final Konsortium konsortium = new Konsortium();
		// enter all required fields

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(KonsortiumManagerImplTest.this.konsortiumDao).save(
						this.with(Expectations.same(konsortium)));
			}
		});

		this.manager.save(konsortium);
	}

	/**
	 * Test remove konsortium.
	 */
	@Test
	public void testRemoveKonsortium() {
		this.log.debug("testing remove...");

		final Long id = -11L;

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(KonsortiumManagerImplTest.this.konsortiumDao).remove(
						this.with(Expectations.equal(id)));
			}
		});

		this.manager.remove(id);
	}

}
