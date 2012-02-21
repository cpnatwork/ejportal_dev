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
import ejportal.model.Rechnung;
import ejportal.service.RechnungManager;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 09.08.2010 Time: 17:02:25 To
 * change this template use File | Settings | File Templates.
 */
public class RechnungActionTest extends BaseActionTestCase {

	/** The action. */
	private RechnungAction action;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.webapp.action.BaseActionTestCase#onSetUpBeforeTransaction()
	 */
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		super.onSetUpBeforeTransaction();
		this.action = new RechnungAction();
		final RechnungManager rechnungManager = (RechnungManager) this.applicationContext
				.getBean("rechnungManager");

		this.action.setRechnungManager(rechnungManager);

		final Exemplar exemplar = new Exemplar();
		exemplar.setExemplarId(1L);

		// add a test rechnung to the database
		final Rechnung rechnung = new Rechnung();
		rechnung.setBetrag(55.55F);
		rechnung.setBezugsjahr("2009");
		rechnung.setExemplar(exemplar);
		rechnungManager.save(rechnung);
	}

	/**
	 * Test edit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testEdit() throws Exception {
		this.log.debug("testing edit...");
		this.action.setRechnungId(1L);
		Assert.assertNull(this.action.getRechnung());
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getRechnungBaseTO());
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
		this.action.setRechnungId(1L);
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getRechnungBaseTO());

		// update bezugsform and save
		this.action.getRechnungBaseTO().setBezugsform("Updated Bezugsform");
		Assert.assertEquals("success", this.action.save());
		Assert.assertEquals("Updated Bezugsform", this.action
				.getRechnungBaseTO().getBezugsform());
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
		final Rechnung rechnung = new Rechnung();
		rechnung.setRechnungId(2L);
		// action.setRechnung(rechnung);
		this.action.setRechnungId(2L);
		Assert.assertEquals("success", this.action.delete());
		Assert.assertNotNull(request.getSession().getAttribute("messages"));
	}
}
