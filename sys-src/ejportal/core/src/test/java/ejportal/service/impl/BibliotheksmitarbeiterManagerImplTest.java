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

import ejportal.dao.BibliotheksmitarbeiterDao;
import ejportal.model.Bibliotheksmitarbeiter;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 05.08.2010 Time: 14:58:46 To
 * change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterManagerImplTest extends
		BaseManagerMockTestCase {

	/** The manager. */
	private BibliotheksmitarbeiterManagerImpl manager = null;

	/** The bibliotheksmitarbeiter dao. */
	private BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao = null;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		this.bibliotheksmitarbeiterDao = this.context
				.mock(BibliotheksmitarbeiterDao.class);
		this.manager = new BibliotheksmitarbeiterManagerImpl(
				this.bibliotheksmitarbeiterDao);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.manager = null;
	}

	/**
	 * Test get bibliotheksmitarbeiter.
	 */
	@Test
	public void testGetBibliotheksmitarbeiter() {
		this.log.debug("testing get...");

		final Long id = 7L;
		final Bibliotheksmitarbeiter bibliotheksmitarbeiter = new Bibliotheksmitarbeiter();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(
						BibliotheksmitarbeiterManagerImplTest.this.bibliotheksmitarbeiterDao)
						.get(this.with(Expectations.equal(id)));
				this.will(Expectations.returnValue(bibliotheksmitarbeiter));
			}
		});

		final Bibliotheksmitarbeiter result = this.manager.get(id);
		Assert.assertSame(bibliotheksmitarbeiter, result);
	}

	/**
	 * Test get bibliotheksmitarbeiters.
	 */
	@Test
	public void testGetBibliotheksmitarbeiters() {
		this.log.debug("testing getAll...");

		final List bibliotheksmitarbeiters = new ArrayList();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(
						BibliotheksmitarbeiterManagerImplTest.this.bibliotheksmitarbeiterDao)
						.getAll();
				this.will(Expectations.returnValue(bibliotheksmitarbeiters));
			}
		});

		final List result = this.manager.getAll();

		Assert.assertSame(bibliotheksmitarbeiters, result);
	}

	/**
	 * Test save bibliotheksmitarbeiter.
	 */
	@Test
	public void testSaveBibliotheksmitarbeiter() {
		this.log.debug("testing save...");

		final Bibliotheksmitarbeiter bibliotheksmitarbeiter = new Bibliotheksmitarbeiter();
		// enter all required fields

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(
						BibliotheksmitarbeiterManagerImplTest.this.bibliotheksmitarbeiterDao)
						.save(this.with(Expectations
								.same(bibliotheksmitarbeiter)));
			}
		});

		this.manager.save(bibliotheksmitarbeiter);
	}

	/**
	 * Test remove bibliotheksmitarbeiter.
	 */
	@Test
	public void testRemoveBibliotheksmitarbeiter() {
		this.log.debug("testing remove...");

		final Long id = -11L;

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(
						BibliotheksmitarbeiterManagerImplTest.this.bibliotheksmitarbeiterDao)
						.remove(this.with(Expectations.equal(id)));
			}
		});

		this.manager.remove(id);
	}
}
