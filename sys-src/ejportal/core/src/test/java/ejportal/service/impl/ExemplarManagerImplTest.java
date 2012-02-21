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
import ejportal.dao.InstitutionDao;
import ejportal.dao.JournalDao;
import ejportal.dao.SigelDao;
import ejportal.model.Exemplar;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 04.08.2010 Time: 13:55:47 To
 * change this template use File | Settings | File Templates.
 */
public class ExemplarManagerImplTest extends BaseManagerMockTestCase {

	/** The manager. */
	private ExemplarManagerImpl manager = null;

	/** The exemplar dao. */
	private ExemplarDao exemplarDao = null;

	/** The institution dao. */
	private InstitutionDao institutionDao = null;

	/** The sigel dao. */
	private SigelDao sigelDao = null;

	/** The journal dao. */
	private JournalDao journalDao = null;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		this.exemplarDao = this.context.mock(ExemplarDao.class);
		this.institutionDao = this.context.mock(InstitutionDao.class);
		this.sigelDao = this.context.mock(SigelDao.class);
		this.journalDao = this.context.mock(JournalDao.class);
		this.manager = new ExemplarManagerImpl(this.exemplarDao,
				this.institutionDao, this.sigelDao, this.journalDao);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.manager = null;
	}

	/**
	 * Test get exemplar.
	 */
	@Test
	public void testGetExemplar() {
		this.log.debug("testing get...");

		final Long id = 7L;
		final Exemplar exemplar = new Exemplar();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(ExemplarManagerImplTest.this.exemplarDao).get(
						this.with(Expectations.equal(id)));
				this.will(Expectations.returnValue(exemplar));
			}
		});

		final Exemplar result = this.manager.get(id);
		Assert.assertSame(exemplar, result);
	}

	/**
	 * Test get exemplars.
	 */
	@Test
	public void testGetExemplars() {
		this.log.debug("testing getAll...");

		final List exemplars = new ArrayList();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(ExemplarManagerImplTest.this.exemplarDao).getAll();
				this.will(Expectations.returnValue(exemplars));
			}
		});

		final List result = this.manager.getAll();

		Assert.assertSame(exemplars, result);
	}

	/**
	 * Test save exemplar.
	 */
	@Test
	public void testSaveExemplar() {
		this.log.debug("testing save...");

		final Exemplar exemplar = new Exemplar();
		// enter all required fields

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(ExemplarManagerImplTest.this.exemplarDao).save(
						this.with(Expectations.same(exemplar)));
			}
		});

		this.manager.save(exemplar);
	}

	/**
	 * Test remove exemplar.
	 */
	@Test
	public void testRemoveExemplar() {
		this.log.debug("testing remove...");

		final Long id = 1L;

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(ExemplarManagerImplTest.this.exemplarDao).remove(
						this.with(Expectations.equal(id)));
			}
		});

		this.manager.remove(id);
	}
}
