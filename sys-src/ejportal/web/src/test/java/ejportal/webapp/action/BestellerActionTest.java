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

import ejportal.model.Besteller;
import ejportal.model.Sigel;
import ejportal.service.BestellerManager;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 10.08.2010 Time: 11:14:10 To
 * change this template use File | Settings | File Templates.
 */
public class BestellerActionTest extends BaseActionTestCase {

	/** The action. */
	private BestellerAction action;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.webapp.action.BaseActionTestCase#onSetUpBeforeTransaction()
	 */
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		super.onSetUpBeforeTransaction();
		this.action = new BestellerAction();
		final BestellerManager bestellerManager = (BestellerManager) this.applicationContext
				.getBean("bestellerManager");

		this.action.setBestellerManager(bestellerManager);

		final Sigel sigel = new Sigel();
		sigel.setSigelId(1L);

		// add a test besteller to the database
		final Besteller besteller = new Besteller();
		besteller.setBestellerName("BestActionTestName");
		besteller.setAnrede("Herr Prof. Dr.");
		besteller.setSigel(sigel);
		bestellerManager.save(besteller);
	}

	/**
	 * Test edit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testEdit() throws Exception {
		this.log.debug("testing edit...");
		this.action.setBestellerId(1L);
		Assert.assertNull(this.action.getBesteller());
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getBestellerBaseTO());
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
		this.action.setBestellerId(1L);
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getBestellerBaseTO());

		// update Name and save
		this.action.getBestellerBaseTO().setBestellerName("Updated Name");
		Assert.assertEquals("success", this.action.save());
		Assert.assertEquals("Updated Name", this.action.getBestellerBaseTO()
				.getBestellerName());
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
		final Besteller besteller = new Besteller();
		besteller.setBestellerId(2L);
		// action.setBesteller(besteller);
		this.action.setBestellerId(2L);
		Assert.assertEquals("success", this.action.delete());
		Assert.assertNotNull(request.getSession().getAttribute("messages"));
	}
}
