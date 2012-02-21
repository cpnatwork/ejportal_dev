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
import org.appfuse.model.User;
import org.appfuse.service.UserManager;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * The Class UserActionTest.
 */
public class UserActionTest extends BaseActionTestCase {

	/** The action. */
	private UserAction action;

	/**
	 * Sets the user action.
	 * 
	 * @param action
	 *            the new user action
	 */
	public void setUserAction(final UserAction action) {
		this.action = action;
	}

	/**
	 * Test cancel.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testCancel() throws Exception {
		Assert.assertEquals(this.action.cancel(), "mainMenu");
		Assert.assertFalse(this.action.hasActionErrors());

		this.action.setFrom("list");
		Assert.assertEquals("cancel", this.action.cancel());
	}

	/**
	 * Test edit.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testEdit() throws Exception {
		// so request.getRequestURL() doesn't fail
		final MockHttpServletRequest request = new MockHttpServletRequest(
				"GET", "/editUser.html");
		ServletActionContext.setRequest(request);

		this.action.setId("-1"); // regular user
		Assert.assertNull(this.action.getUser());
		Assert.assertEquals("success", this.action.edit());
		Assert.assertNotNull(this.action.getUser());
		Assert.assertFalse(this.action.hasActionErrors());
	}

	/**
	 * Test save.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testSave() throws Exception {
		final UserManager userManager = (UserManager) this.applicationContext
				.getBean("userManager");
		final User user = userManager.getUserByUsername("user");
		user.setPassword("user");
		user.setConfirmPassword("user");
		this.action.setUser(user);
		this.action.setFrom("list");

		final MockHttpServletRequest request = new MockHttpServletRequest();
		request.addParameter("encryptPass", "true");
		ServletActionContext.setRequest(request);

		Assert.assertEquals("input", this.action.save());
		Assert.assertNotNull(this.action.getUser());
		Assert.assertFalse(this.action.hasActionErrors());
	}

	/**
	 * Test save conflicting user.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testSaveConflictingUser() throws Exception {
		final UserManager userManager = (UserManager) this.applicationContext
				.getBean("userManager");
		final User user = userManager.getUserByUsername("user");
		user.setPassword("user");
		user.setConfirmPassword("user");
		// e-mail address from existing user
		// User existingUser = (User) userManager.getUsers().get(0);
		final User existingUser = userManager.getUserByUsername("admin");
		user.setEmail(existingUser.getEmail());
		this.action.setUser(user);
		this.action.setFrom("list");

		final Integer originalVersionNumber = user.getVersion();
		this.log.debug("original version #: " + originalVersionNumber);

		final MockHttpServletRequest request = new MockHttpServletRequest();
		request.addParameter("encryptPass", "true");
		ServletActionContext.setRequest(request);

		Assert.assertEquals("input", this.action.save());
		Assert.assertNotNull(this.action.getUser());
		Assert.assertEquals(originalVersionNumber, user.getVersion());
		Assert.assertTrue(this.action.hasActionErrors());
	}

	/**
	 * Test search.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testSearch() throws Exception {
		Assert.assertNull(this.action.getUsers());
		Assert.assertEquals("success", this.action.list());
		Assert.assertNotNull(this.action.getUsers());
		Assert.assertFalse(this.action.hasActionErrors());
	}

	/**
	 * Test remove.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testRemove() throws Exception {
		final User user = new User("admin");
		user.setId(-2L);
		this.action.setUser(user);
		Assert.assertEquals("success", this.action.delete());
		Assert.assertFalse(this.action.hasActionErrors());
	}
}
