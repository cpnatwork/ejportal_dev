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

import ejportal.model.Paket;
import ejportal.service.PaketManager;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 03.08.2010 Time: 11:34:17 To
 * change this template use File | Settings | File Templates.
 */
public class PaketActionTest extends BaseActionTestCase {

	/** The action. */
	private PaketDetailAction action;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.webapp.action.BaseActionTestCase#onSetUpBeforeTransaction()
	 */
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		super.onSetUpBeforeTransaction();
		this.action = new PaketDetailAction();
		final PaketManager paketManager = (PaketManager) this.applicationContext
				.getBean("paketManager");

		this.action.setPaketManager(paketManager);

		// add a test paket to the database
		final Paket paket = new Paket();
		paket.setPaketName("TestPaket");
		paketManager.save(paket);
	}

	/**
	 * Test edit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testEdit() throws Exception {
		this.log.debug("testing edit...");
		this.action.setPaketId(1L);
		Assert.assertNull(this.action.getPaket());
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getPaket());
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
		this.action.setPaketId(1L);
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getPaket());

		// update Paketname and save
		this.action.getPaket().setPaketName("Updated Name");
		Assert.assertEquals("success", this.action.save());
		Assert.assertEquals("Updated Name", this.action.getPaket()
				.getPaketName());
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
		final Paket paket = new Paket();
		paket.setPaketId(2L);
		// action.setPaket(paket);
		this.action.setPaketId(2L);
		Assert.assertEquals("success", this.action.delete());
		Assert.assertNotNull(request.getSession().getAttribute("messages"));
	}
}
