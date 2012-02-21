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

import ejportal.model.Sigel;
import ejportal.service.SigelManager;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 04.08.2010 Time: 14:48:55 To
 * change this template use File | Settings | File Templates.
 */
public class SigelActionTest extends BaseActionTestCase {

	/** The action. */
	private SigelDetailAction action;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.webapp.action.BaseActionTestCase#onSetUpBeforeTransaction()
	 */
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		super.onSetUpBeforeTransaction();
		this.action = new SigelDetailAction();
		final SigelManager sigelManager = (SigelManager) this.applicationContext
				.getBean("sigelManager");

		this.action.setSigelManager(sigelManager);

		// add a test sigel to the database
		final Sigel sigel = new Sigel();
		sigel.setName("TestSigel");
		sigelManager.save(sigel);
	}

	/**
	 * Test edit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testEdit() throws Exception {
		this.log.debug("testing edit...");
		this.action.setSigelId(1L);
		Assert.assertNull(this.action.getSigel());
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getSigel());
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
		this.action.setSigelId(1L);
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getSigel());

		// update Sigelname and save
		this.action.getSigel().setName("Updated Name");
		Assert.assertEquals("success", this.action.save());
		Assert.assertEquals("Updated Name", this.action.getSigel().getName());
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
		final Sigel sigel = new Sigel();
		sigel.setSigelId(2L);
		// action.setSigel(sigel);
		this.action.setSigelId(2L);
		Assert.assertEquals("success", this.action.delete());
		Assert.assertNotNull(request.getSession().getAttribute("messages"));
	}
}
