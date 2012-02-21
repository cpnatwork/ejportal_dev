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
import org.appfuse.Constants;
import org.appfuse.model.Address;
import org.appfuse.model.User;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.context.SecurityContextHolder;
import org.subethamail.wiser.Wiser;

/**
 * The Class SignupActionTest.
 */
public class SignupActionTest extends BaseActionTestCase {

	/** The action. */
	private SignupAction action;

	/**
	 * Sets the signup action.
	 * 
	 * @param action
	 *            the new signup action
	 */
	public void setSignupAction(final SignupAction action) {
		this.action = action;
	}

	/**
	 * Test display form.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testDisplayForm() throws Exception {
		final MockHttpServletRequest request = new MockHttpServletRequest(null,
				"GET", "/signup.html");
		ServletActionContext.setRequest(request);
		Assert.assertEquals("input", this.action.execute());
	}

	/**
	 * Test execute.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testExecute() throws Exception {
		final User user = new User();
		user.setUsername("self-registered");
		user.setPassword("Password1");
		user.setConfirmPassword("Password1");
		user.setFirstName("First");
		user.setLastName("Last");

		final Address address = new Address();
		address.setCity("Denver");
		address.setProvince("CO");
		address.setCountry("USA");
		address.setPostalCode("80210");
		user.setAddress(address);

		user.setEmail("self-registered@raibledesigns.com");
		user.setWebsite("http://raibledesigns.com");
		user.setPasswordHint("Password is one with you.");
		this.action.setUser(user);

		// set mock response so setting cookies doesn't fail
		ServletActionContext.setResponse(new MockHttpServletResponse());

		// start SMTP Server
		final Wiser wiser = new Wiser();
		wiser.setPort(this.getSmtpPort());
		wiser.start();

		Assert.assertEquals("success", this.action.save());
		Assert.assertFalse(this.action.hasActionErrors());

		// verify an account information e-mail was sent
		wiser.stop();
		Assert.assertTrue(wiser.getMessages().size() == 1);

		// verify that success messages are in the session
		Assert.assertNotNull(this.action.getSession().getAttribute(
				Constants.REGISTERED));

		SecurityContextHolder.getContext().setAuthentication(null);
	}
}
