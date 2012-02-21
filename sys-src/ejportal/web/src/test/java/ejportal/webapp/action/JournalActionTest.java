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

import ejportal.model.Journal;
import ejportal.service.JournalManager;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 14.06.2010 Time: 14:19:28 To
 * change this template use File | Settings | File Templates.
 */

public class JournalActionTest extends BaseActionTestCase {

	/** The action. */
	private JournalDetailAction action;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.webapp.action.BaseActionTestCase#onSetUpBeforeTransaction()
	 */
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		super.onSetUpBeforeTransaction();
		this.action = new JournalDetailAction();
		final JournalManager journalManager = (JournalManager) this.applicationContext
				.getBean("journalManager");

		this.action.setJournalManager(journalManager);

		// add a test journal to the database
		final Journal journal = new Journal();
		journal.setTitel("TestJournal");
		journal.setKurztitel("TJ");
		journalManager.save(journal);
	}

	/**
	 * Test edit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testEdit() throws Exception {
		this.log.debug("testing edit...");
		this.action.setJournalId(1L);
		Assert.assertNull(this.action.getJournal());
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getJournalBaseTO());
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
		this.action.setJournalId(1L);
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getJournalBaseTO());

		// update Kurztitel and save
		this.action.getJournalBaseTO().setTitel("Updated Kurztitel");
		Assert.assertEquals("success", this.action.save());
		Assert.assertEquals("Updated Kurztitel", this.action.getJournalBaseTO()
				.getTitel());
		Assert.assertFalse(this.action.hasActionErrors());
		Assert.assertFalse(this.action.hasFieldErrors());
		Assert.assertNotNull(request.getSession().getAttribute("messages"));
	}

	/**
	 * Test remove.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testRemove() throws Exception {
		final MockHttpServletRequest request = new MockHttpServletRequest();
		ServletActionContext.setRequest(request);
		this.action.setDelete("");
		final Journal journal = new Journal();
		journal.setId(2L);
		// action.setJournal(journal);
		this.action.setJournalId(2L);
		Assert.assertEquals("success", this.action.delete());
		Assert.assertNotNull(request.getSession().getAttribute("messages"));
	}
}
