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

import ejportal.model.Konsortium;
import ejportal.service.KonsortiumManager;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 03.08.2010 Time: 16:04:03 To
 * change this template use File | Settings | File Templates.
 */

public class KonsortiumActionTest extends BaseActionTestCase {

	/** The action. */
	private KonsortiumDetailAction action;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.webapp.action.BaseActionTestCase#onSetUpBeforeTransaction()
	 */
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		super.onSetUpBeforeTransaction();
		this.action = new KonsortiumDetailAction();
		final KonsortiumManager konsortiumManager = (KonsortiumManager) this.applicationContext
				.getBean("konsortiumManager");

		this.action.setKonsortiumManager(konsortiumManager);

		// add a test Konsortium to the database
		final Konsortium konsortium = new Konsortium();
		konsortium.setKonsortiumName("TestKonsortium");
		konsortiumManager.save(konsortium);
	}

	/**
	 * Test edit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testEdit() throws Exception {
		this.log.debug("testing edit...");
		this.action.setKonsortiumId(1L);
		Assert.assertNull(this.action.getKonsortium());
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getKonsortium());
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
		this.action.setKonsortiumId(1L);
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getKonsortium());

		// update Name and save
		this.action.getKonsortium().setKonsortiumName("Updated Name");
		Assert.assertEquals("success", this.action.save());
		Assert.assertEquals("Updated Name", this.action.getKonsortium()
				.getKonsortiumName());
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
		final Konsortium Konsortium = new Konsortium();
		Konsortium.setKonsortiumId(2L);
		// action.setKonsortium(Konsortium);
		this.action.setKonsortiumId(2L);
		Assert.assertEquals("success", this.action.delete());
		Assert.assertNotNull(request.getSession().getAttribute("messages"));
	}
}
