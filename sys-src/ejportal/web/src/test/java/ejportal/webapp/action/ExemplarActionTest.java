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

import ejportal.model.Exemplar;
import ejportal.model.Journal;
import ejportal.service.ExemplarManager;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 05.08.2010 Time: 13:55:01 To
 * change this template use File | Settings | File Templates.
 */
public class ExemplarActionTest extends BaseActionTestCase {

	/** The action. */
	private ExemplarDetailAction action;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.webapp.action.BaseActionTestCase#onSetUpBeforeTransaction()
	 */
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		super.onSetUpBeforeTransaction();
		this.action = new ExemplarDetailAction();
		final ExemplarManager exemplarManager = (ExemplarManager) this.applicationContext
				.getBean("exemplarManager");

		this.action.setExemplarManager(exemplarManager);

		final Journal journal = new Journal();
		journal.setId(1L);

		// add a test exemplar to the database
		final Exemplar exemplar = new Exemplar();
		exemplar.setForm("TestForm");
		exemplar.setBestellnummer("BestNr");
		exemplar.setJournal(journal);
		exemplarManager.save(exemplar);
	}

	/**
	 * Test edit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testEdit() throws Exception {
		this.log.debug("testing edit...");
		this.action.setExemplarId(1L);
		Assert.assertNull(this.action.getExemplar());
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getExemplarBaseTO());
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
		this.action.setExemplarId(1L);
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getExemplarBaseTO());

		// update Name and save
		this.action.getExemplarBaseTO().setForm("Updated Form");
		Assert.assertEquals("success", this.action.save());
		Assert.assertEquals("Updated Form", this.action.getExemplarBaseTO()
				.getForm());
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
		final Exemplar exemplar = new Exemplar();
		exemplar.setExemplarId(2L);
		// action.setExemplar(exemplar);
		this.action.setExemplarId(2L);
		Assert.assertEquals("success", this.action.delete());
		Assert.assertNotNull(request.getSession().getAttribute("messages"));
	}
}
