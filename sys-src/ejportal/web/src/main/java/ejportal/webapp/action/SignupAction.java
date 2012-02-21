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

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.appfuse.Constants;
import org.appfuse.model.User;
import org.appfuse.service.UserExistsException;
import org.springframework.mail.MailException;
import org.springframework.security.AccessDeniedException;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;

import com.opensymphony.xwork2.Action;

import ejportal.webapp.util.RequestUtil;

/**
 * Action to allow new users to sign up.
 */
public class SignupAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6558317334878272308L;

	/** The user. */
	private User user;

	/** The cancel. */
	private String cancel;

	/**
	 * Sets the cancel.
	 * 
	 * @param cancel
	 *            the new cancel
	 */
	public void setCancel(final String cancel) {
		this.cancel = cancel;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(final User user) {
		this.user = user;
	}

	/**
	 * Return an instance of the user - to display when validation errors occur.
	 * 
	 * @return a populated user
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 * When method=GET, "input" is returned. Otherwise, "success" is returned.
	 * 
	 * @return cancel, input or success
	 */
	@Override
	public String execute() {
		if (this.cancel != null)
			return BaseAction.CANCEL;
		if (ServletActionContext.getRequest().getMethod().equals("GET"))
			return Action.INPUT;
		return Action.SUCCESS;
	}

	/**
	 * Returns "input".
	 * 
	 * @return "input" by default
	 */
	@Override
	public String doDefault() {
		return Action.INPUT;
	}

	/**
	 * Save the user, encrypting their passwords if necessary.
	 * 
	 * @return success when good things happen
	 * @throws Exception
	 *             when bad things happen
	 */
	public String save() throws Exception {
		this.user.setEnabled(true);

		// Set the default user role on this new user
		// user.addRole(roleManager.getRole(Constants.USER_ROLE));

		// TODO hier geaendert -- evtl nicht so schoen
		this.user.addRole(this.roleManager.getRole("ROLE_EXTERN"));

		try {
			this.userManager.saveUser(this.user);
		} catch (final AccessDeniedException ade) {
			// thrown by UserSecurityAdvice configured in aop:advisor
			// userManagerSecurity
			this.log.warn(ade.getMessage());
			this.getResponse().sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		} catch (final UserExistsException e) {
			this.log.warn(e.getMessage());
			final List<Object> args = new ArrayList<Object>();
			args.add(this.user.getUsername());
			args.add(this.user.getEmail());
			this.addActionError(this.getText("errors.existing.user", args));

			// redisplay the unencrypted passwords
			this.user.setPassword(this.user.getConfirmPassword());
			return Action.INPUT;
		}

		this.saveMessage(this.getText("user.registered"));
		this.getSession().setAttribute(Constants.REGISTERED, Boolean.TRUE);

		// log user in automatically
		final UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
				this.user.getUsername(), this.user.getConfirmPassword(),
				this.user.getAuthorities());
		auth.setDetails(this.user);
		SecurityContextHolder.getContext().setAuthentication(auth);

		// Send an account information e-mail
		this.mailMessage.setSubject(this.getText("signup.email.subject"));

		try {
			this.sendUserMessage(this.user,
					this.getText("signup.email.message"),
					RequestUtil.getAppURL(this.getRequest()));
		} catch (final MailException me) {
			this.addActionError(me.getMostSpecificCause().getMessage());
		}

		return Action.SUCCESS;
	}
}
