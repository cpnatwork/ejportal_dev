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
package ejportal.webapp.action;

import junit.framework.Assert;

import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockHttpServletRequest;

import ejportal.model.Journalkosten;
import ejportal.service.JournalkostenManager;

/**
 * Created by IntelliJ IDEA. User: ag35ogub Date: 12.08.2010 Time: 12:28:05 To
 * change this template use File | Settings | File Templates.
 */
public class JournalkostenActionTest extends BaseActionTestCase {

	/** The action. */
	private JournalkostenAction action;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.webapp.action.BaseActionTestCase#onSetUpBeforeTransaction()
	 */
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		super.onSetUpBeforeTransaction();
		this.action = new JournalkostenAction();
		final JournalkostenManager journalkostenManager = (JournalkostenManager) this.applicationContext
				.getBean("journalkostenManager");

		this.action.setJournalkostenManager(journalkostenManager);

		// add a test Journalkosten to the database
		final Journalkosten journalkosten = new Journalkosten();
		journalkosten.setOPreisPO((long) 123.23);
		journalkostenManager.save(journalkosten);
	}

	/**
	 * Test edit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testEdit() throws Exception {
		this.log.debug("testing edit...");
		this.action.setJournalkostenId(1L);
		this.action.setJournalId(1L);
		Assert.assertNull(this.action.getJournalkosten());
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getJournalkosten());
		Assert.assertFalse(this.action.hasActionErrors());
	}

	/**
	 * Test save.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testSave() throws Exception {
		final MockHttpServletRequest request = new MockHttpServletRequest();
		ServletActionContext.setRequest(request);
		this.action.setJournalkostenId(1L);
		this.action.setJournalId(1L);
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getJournalkosten());

		// update Journalkosten and save
		this.action.getJournalkosten().setOPreisPO((long) 123.23);
		Assert.assertEquals("success", this.action.save());
		Assert.assertEquals((long) 123.23, (long) this.action
				.getJournalkosten().getOPreisPO());
		Assert.assertFalse(this.action.hasActionErrors());
		Assert.assertFalse(this.action.hasFieldErrors());
		Assert.assertNotNull(request.getSession().getAttribute("messages"));
	}

}
