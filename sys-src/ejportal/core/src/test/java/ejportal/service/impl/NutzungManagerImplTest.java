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

import ejportal.dao.JournalDao;
import ejportal.dao.NutzungDao;
import ejportal.model.Nutzung;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 09.08.2010 Time: 16:23:13 To
 * change this template use File | Settings | File Templates.
 */
public class NutzungManagerImplTest extends BaseManagerMockTestCase {

	/** The manager. */
	private NutzungManagerImpl manager = null;

	/** The nutzung dao. */
	private NutzungDao nutzungDao = null;

	/** The journal dao. */
	private JournalDao journalDao = null;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		this.nutzungDao = this.context.mock(NutzungDao.class);
		this.journalDao = this.context.mock(JournalDao.class);
		this.manager = new NutzungManagerImpl(this.nutzungDao, this.journalDao);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.manager = null;
	}

	/**
	 * Test get nutzung.
	 */
	@Test
	public void testGetNutzung() {
		this.log.debug("testing get...");

		final Long id = 7L;
		final Nutzung nutzung = new Nutzung();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(NutzungManagerImplTest.this.nutzungDao).get(
						this.with(Expectations.equal(id)));
				this.will(Expectations.returnValue(nutzung));
			}
		});

		final Nutzung result = this.manager.get(id);
		Assert.assertSame(nutzung, result);
	}

	/**
	 * Test get nutzungen.
	 */
	@Test
	public void testGetNutzungen() {
		this.log.debug("testing getAll...");

		final List nutzungen = new ArrayList();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(NutzungManagerImplTest.this.nutzungDao).getAll();
				this.will(Expectations.returnValue(nutzungen));
			}
		});

		final List result = this.manager.getAll();

		Assert.assertSame(nutzungen, result);
	}

	/**
	 * Test save nutzung.
	 */
	@Test
	public void testSaveNutzung() {
		this.log.debug("testing save...");

		final Nutzung nutzung = new Nutzung();
		// enter all required fields

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(NutzungManagerImplTest.this.nutzungDao).save(
						this.with(Expectations.same(nutzung)));
			}
		});

		this.manager.save(nutzung);
	}

	/**
	 * Test remove nutzung.
	 */
	@Test
	public void testRemoveNutzung() {
		this.log.debug("testing remove...");

		final Long id = 1L;

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(NutzungManagerImplTest.this.nutzungDao).remove(
						this.with(Expectations.equal(id)));
			}
		});

		this.manager.remove(id);
	}
}
