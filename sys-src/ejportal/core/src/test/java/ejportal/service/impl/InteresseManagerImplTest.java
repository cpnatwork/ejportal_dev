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
import ejportal.dao.JournalDao;
import ejportal.model.Interesse;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 16:42:11 To
 * change this template use File | Settings | File Templates.
 */
public class InteresseManagerImplTest extends BaseManagerMockTestCase {

	/** The manager. */
	private InteresseManagerImpl manager = null;

	/** The interesse dao. */
	private InteresseDao interesseDao = null;

	/** The besteller dao. */
	private BestellerDao bestellerDao = null;

	/** The journal dao. */
	private JournalDao journalDao = null;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		this.bestellerDao = this.context.mock(BestellerDao.class);
		this.interesseDao = this.context.mock(InteresseDao.class);
		this.journalDao = this.context.mock(JournalDao.class);
		this.manager = new InteresseManagerImpl(this.interesseDao,
				this.bestellerDao, this.journalDao);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.manager = null;
	}

	/**
	 * Test get interesse.
	 */
	@Test
	public void testGetInteresse() {
		this.log.debug("testing get...");

		final Long id = 7L;
		final Interesse interesse = new Interesse();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(InteresseManagerImplTest.this.interesseDao).get(
						this.with(Expectations.equal(id)));
				this.will(Expectations.returnValue(interesse));
			}
		});

		final Interesse result = this.manager.get(id);
		Assert.assertSame(interesse, result);
	}

	/**
	 * Test get interesses.
	 */
	@Test
	public void testGetInteresses() {
		this.log.debug("testing getAll...");

		final List interesses = new ArrayList();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(InteresseManagerImplTest.this.interesseDao).getAll();
				this.will(Expectations.returnValue(interesses));
			}
		});

		final List result = this.manager.getAll();

		Assert.assertSame(interesses, result);
	}

	/**
	 * Test save interesse.
	 */
	@Test
	public void testSaveInteresse() {
		this.log.debug("testing save...");

		final Interesse interesse = new Interesse();
		// enter all required fields

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(InteresseManagerImplTest.this.interesseDao).save(
						this.with(Expectations.same(interesse)));
			}
		});

		this.manager.save(interesse);
	}

	/**
	 * Test remove interesse.
	 */
	@Test
	public void testRemoveInteresse() {
		this.log.debug("testing remove...");

		final Long id = 1L;

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(InteresseManagerImplTest.this.interesseDao).remove(
						this.with(Expectations.equal(id)));
			}
		});

		this.manager.remove(id);
	}
}
