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
import ejportal.model.Nutzung;
import ejportal.service.NutzungManager;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 10.08.2010 Time: 11:59:42 To
 * change this template use File | Settings | File Templates.
 */
public class NutzungActionTest extends BaseActionTestCase {

	/** The action. */
	private NutzungAction action;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.webapp.action.BaseActionTestCase#onSetUpBeforeTransaction()
	 */
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		super.onSetUpBeforeTransaction();
		this.action = new NutzungAction();
		final NutzungManager nutzungManager = (NutzungManager) this.applicationContext
				.getBean("nutzungManager");

		this.action.setNutzungManager(nutzungManager);

		final Journal journal = new Journal();
		journal.setId(1L);

		// add a test exemplar to the database
		final Nutzung nutzung = new Nutzung();
		nutzung.setZugriffe(4);
		nutzung.setZeitraum(5);
		nutzung.setJournal(journal);
		nutzungManager.save(nutzung);
	}

	/**
	 * Test edit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testEdit() throws Exception {
		this.log.debug("testing edit...");
		this.action.setNutzungId(1L);
		Assert.assertEquals("edit", this.action.edit());
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
		this.action.setNutzungId(1L);
		Assert.assertEquals("edit", this.action.edit());
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
		final Nutzung nutzung = new Nutzung();
		nutzung.setNutzungId(2L);
		this.action.setNutzungId(2L);
		Assert.assertEquals("success", this.action.delete());
		Assert.assertNotNull(request.getSession().getAttribute("messages"));
	}
}
