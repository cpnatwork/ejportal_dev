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

import java.util.ArrayList;
import java.util.List;

import org.appfuse.model.User;
import org.springframework.mail.MailException;
import org.springframework.security.userdetails.UsernameNotFoundException;

import com.opensymphony.xwork2.Action;

import ejportal.webapp.util.RequestUtil;

/**
 * Action class to send password hints to registered users.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class PasswordHintAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4037514607101222025L;

	/** The username. */
	private String username;

	/**
	 * Sets the username.
	 * 
	 * @param username
	 *            The username to set.
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * Execute sending the password hint via e-mail.
	 * 
	 * @return success if username works, input if not
	 */
	@Override
	public String execute() {
		final List<Object> args = new ArrayList<Object>();

		// ensure that the username has been sent
		if (this.username == null) {
			this.log.warn("Username not specified, notifying user that it's a required field.");

			args.add(this.getText("user.username"));
			this.addActionError(this.getText("errors.requiredField", args));
			return Action.INPUT;
		}

		if (this.log.isDebugEnabled()) {
			this.log.debug("Processing Password Hint...");
		}

		// look up the user's information
		try {
			final User user = this.userManager.getUserByUsername(this.username);
			final String hint = user.getPasswordHint();

			if ((hint == null) || hint.trim().equals("")) {
				this.log.warn("User '" + this.username
						+ "' found, but no password hint exists.");
				this.addActionError(this.getText("login.passwordHint.missing"));
				return Action.INPUT;
			}

			final StringBuffer msg = new StringBuffer();
			msg.append("Your password hint is: ").append(hint);
			msg.append("\n\nLogin at: ").append(
					RequestUtil.getAppURL(this.getRequest()));

			this.mailMessage.setTo(user.getEmail());
			final String subject = '[' + this.getText("webapp.name") + "] "
					+ this.getText("user.passwordHint");
			this.mailMessage.setSubject(subject);
			this.mailMessage.setText(msg.toString());
			this.mailEngine.send(this.mailMessage);

			args.add(this.username);
			args.add(user.getEmail());

			this.saveMessage(this.getText("login.passwordHint.sent", args));
		} catch (final UsernameNotFoundException e) {
			this.log.warn(e.getMessage());
			args.add(this.username);
			this.addActionError(this.getText("login.passwordHint.error", args));
			this.getSession().setAttribute("errors", this.getActionErrors());
			return Action.INPUT;
		} catch (final MailException me) {
			this.addActionError(me.getCause().getLocalizedMessage());
			this.getSession().setAttribute("errors", this.getActionErrors());
			return Action.INPUT;
		}

		return Action.SUCCESS;
	}
}
