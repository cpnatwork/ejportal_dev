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

import ejportal.model.Institution;
import ejportal.service.InstitutionManager;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 06.07.2010 Time: 21:50:21 To
 * change this template use File | Settings | File Templates.
 */
public class InstitutionActionTest extends BaseActionTestCase {

	/** The action. */
	private InstitutionDetailAction action;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.webapp.action.BaseActionTestCase#onSetUpBeforeTransaction()
	 */
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		super.onSetUpBeforeTransaction();
		this.action = new InstitutionDetailAction();
		final InstitutionManager institutionManager = (InstitutionManager) this.applicationContext
				.getBean("institutionManager");

		this.action.setInstitutionManager(institutionManager);

		// add a test institution to the database
		final Institution institution = new Institution();
		institution.setName("TestInstitution");
		institution.setAbteilung("TI");
		institutionManager.save(institution);
	}

	/**
	 * Test edit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testEdit() throws Exception {
		this.log.debug("testing edit...");
		this.action.setId(1L);
		Assert.assertNull(this.action.getInstitution());
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getInstitutionBaseTO());
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
		this.action.setId(1L);
		Assert.assertEquals("edit", this.action.edit());
		Assert.assertNotNull(this.action.getInstitutionBaseTO());

		// update Name and save
		this.action.getInstitutionBaseTO().setName("Updated Name");
		Assert.assertEquals("success", this.action.save());
		Assert.assertEquals("Updated Name", this.action.getInstitutionBaseTO()
				.getName());
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
		final Institution institution = new Institution();
		institution.setId(2L);
		// action.setInstitution(institution);
		this.action.setId(2L);
		Assert.assertEquals("success", this.action.delete());
		Assert.assertNotNull(request.getSession().getAttribute("messages"));
	}
}
