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

import ejportal.dao.ExemplarDao;
import ejportal.dao.JournalDao;
import ejportal.dao.RechnungDao;
import ejportal.model.Rechnung;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 09.08.2010 Time: 15:38:49 To
 * change this template use File | Settings | File Templates.
 */
public class RechnungManagerImplTest extends BaseManagerMockTestCase {

	/** The manager. */
	private RechnungManagerImpl manager = null;

	/** The rechnung dao. */
	private RechnungDao rechnungDao = null;

	/** The exemplar dao. */
	private ExemplarDao exemplarDao;

	/** The journal dao. */
	private JournalDao journalDao;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		this.rechnungDao = this.context.mock(RechnungDao.class);
		this.exemplarDao = this.context.mock(ExemplarDao.class);
		this.journalDao = this.context.mock(JournalDao.class);
		this.manager = new RechnungManagerImpl(this.rechnungDao,
				this.exemplarDao, this.journalDao);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.manager = null;
	}

	/**
	 * Test get rechnung.
	 */
	@Test
	public void testGetRechnung() {
		this.log.debug("testing get...");

		final Long id = 7L;
		final Rechnung rechnung = new Rechnung();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(RechnungManagerImplTest.this.rechnungDao).get(
						this.with(Expectations.equal(id)));
				this.will(Expectations.returnValue(rechnung));
			}
		});

		final Rechnung result = this.manager.get(id);
		Assert.assertSame(rechnung, result);
	}

	/**
	 * Test get rechnungen.
	 */
	public void testGetRechnungen() {
		this.log.debug("testing getAll...");

		final List rechnungen = new ArrayList();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(RechnungManagerImplTest.this.rechnungDao).getAll();
				this.will(Expectations.returnValue(rechnungen));
			}
		});

		final List result = this.manager.getAll();

		Assert.assertSame(rechnungen, result);
	}

	/**
	 * Test save rechnung.
	 */
	@Test
	public void testSaveRechnung() {
		this.log.debug("testing save...");

		final Rechnung rechnung = new Rechnung();
		// enter all required fields

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(RechnungManagerImplTest.this.rechnungDao).save(
						this.with(Expectations.same(rechnung)));
			}
		});

		this.manager.save(rechnung);

	}

	/**
	 * Test remove rechnung.
	 */
	@Test
	public void testRemoveRechnung() {
		this.log.debug("testing remove...");

		final Long id = -11L;

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(RechnungManagerImplTest.this.rechnungDao).remove(
						this.with(Expectations.equal(id)));
			}
		});

		this.manager.remove(id);
	}

}
