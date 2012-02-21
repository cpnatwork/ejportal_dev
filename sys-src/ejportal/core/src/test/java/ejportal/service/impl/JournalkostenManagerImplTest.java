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

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.jmock.Expectations;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ejportal.dao.JournalDao;
import ejportal.dao.JournalkostenDao;
import ejportal.dao.WechselkursDao;
import ejportal.model.Journalkosten;

/**
 * Created by IntelliJ IDEA. User: ag35ogub Date: 12.08.2010 Time: 12:04:00 To
 * change this template use File | Settings | File Templates.
 */
public class JournalkostenManagerImplTest extends BaseManagerMockTestCase {

	/** The manager. */
	private JournalkostenManagerImpl manager = null;

	/** The journalkosten dao. */
	private JournalkostenDao journalkostenDao = null;

	/** The journal dao. */
	private JournalDao journalDao = null;

	/** The wechselkurs dao. */
	private WechselkursDao wechselkursDao = null;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		this.journalkostenDao = this.context.mock(JournalkostenDao.class);
		this.journalDao = this.context.mock(JournalDao.class);
		this.wechselkursDao = this.context.mock(WechselkursDao.class);
		this.manager = new JournalkostenManagerImpl(this.journalkostenDao,
				this.wechselkursDao, this.journalDao);
	}

	/**
	 * Tear down.
	 */
	@After
	public void tearDown() {
		this.manager = null;
	}

	/**
	 * Test get projektkosten.
	 */
	@Test
	public void testGetProjektkosten() {
		this.log.debug("testing get...");

		final Long id = 7L;
		final Journalkosten journalkosten = new Journalkosten();

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(JournalkostenManagerImplTest.this.journalkostenDao)
						.get(this.with(Expectations.equal(id)));
				this.will(Expectations.returnValue(journalkosten));
			}
		});

		final Journalkosten result = this.manager.get(id);
		Assert.assertSame(journalkosten, result);
	}

	/**
	 * Test remove projektkosten.
	 */
	@Test
	public void testRemoveProjektkosten() {
		this.log.debug("testing remove...");

		final Long id = 1L;

		// set expected behavior on dao
		this.context.checking(new Expectations() {
			{
				this.one(JournalkostenManagerImplTest.this.journalkostenDao)
						.remove(this.with(Expectations.equal(id)));
			}
		});

		this.manager.remove(id);
	}

}
