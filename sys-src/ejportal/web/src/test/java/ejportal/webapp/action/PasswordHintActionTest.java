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

import org.subethamail.wiser.Wiser;

/**
 * The Class PasswordHintActionTest.
 */
public class PasswordHintActionTest extends BaseActionTestCase {

	/** The action. */
	private PasswordHintAction action;

	/**
	 * Sets the password hint action.
	 * 
	 * @param action
	 *            the new password hint action
	 */
	public void setPasswordHintAction(final PasswordHintAction action) {
		this.action = action;
	}

	/**
	 * Test execute.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testExecute() throws Exception {
		// start SMTP Server
		final Wiser wiser = new Wiser();
		wiser.setPort(this.getSmtpPort());
		wiser.start();

		this.action.setUsername("user");
		Assert.assertEquals("success", this.action.execute());
		Assert.assertFalse(this.action.hasActionErrors());

		// verify an account information e-mail was sent
		wiser.stop();
		Assert.assertTrue(wiser.getMessages().size() == 1);

		// verify that success messages are in the request
		Assert.assertNotNull(this.action.getSession().getAttribute("messages"));
	}
}
