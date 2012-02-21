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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.appfuse.model.Role;
import org.appfuse.model.User;
import org.appfuse.service.UserExistsException;
import org.springframework.mail.MailException;
import org.springframework.security.AccessDeniedException;
import org.springframework.security.Authentication;
import org.springframework.security.AuthenticationTrustResolver;
import org.springframework.security.AuthenticationTrustResolverImpl;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

import ejportal.webapp.util.RequestUtil;

/**
 * Action for facilitating User Management feature.
 */
public class UserAction extends BaseAction implements Preparable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6776558938712115191L;

	/** The users. */
	private List users;

	/** The user. */
	private User user;

	/** The id. */
	private String id;

	/**
	 * Grab the entity from the database before populating with request
	 * parameters.
	 */
	public void prepare() {
		// prevent failures on new
		if (this.getRequest().getMethod().equalsIgnoreCase("post")
				&& (!"".equals(this.getRequest().getParameter("user.id")))) {
			this.user = this.userManager.getUser(this.getRequest()
					.getParameter("user.id"));
		}
	}

	/**
	 * Holder for users to display on list screen.
	 * 
	 * @return list of users
	 */
	public List getUsers() {
		return this.users;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final String id) {
		this.id = id;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return this.user;
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
	 * Delete the user passed in.
	 * 
	 * @return success
	 */
	public String delete() {
		this.userManager.removeUser(this.user.getId().toString());
		final List<Object> args = new ArrayList<Object>();
		args.add(this.user.getFullName());
		this.saveMessage(this.getText("user.deleted", args));

		return Action.SUCCESS;
	}

	/**
	 * Grab the user from the database based on the "id" passed in.
	 * 
	 * @return success if user found
	 * @throws IOException
	 *             can happen when sending a "forbidden" from
	 *             response.sendError()
	 */
	public String edit() throws IOException {
		final HttpServletRequest request = this.getRequest();
		final boolean editProfile = (request.getRequestURI().indexOf(
				"editProfile") > -1);

		// if URL is "editProfile" - make sure it's the current user
		if (editProfile
				&& ((request.getParameter("id") != null) || (request
						.getParameter("from") != null))) {
			ServletActionContext.getResponse().sendError(
					HttpServletResponse.SC_FORBIDDEN);
			this.log.warn("User '" + request.getRemoteUser()
					+ "' is trying to edit user '" + request.getParameter("id")
					+ "'");
			return null;
		}

		// if a user's id is passed in
		if (this.id != null) {
			// lookup the user using that id
			this.user = this.userManager.getUser(this.id);
		} else if (editProfile) {
			this.user = this.userManager.getUserByUsername(request
					.getRemoteUser());
		} else {
			this.user = new User();
			// TODO hier hart kondiert - evtl aendern
			this.user.addRole(new Role("ROLE_EXTERN"));
			// user.addRole(new Role(Constants.USER_ROLE));
		}

		if (this.user.getUsername() != null) {
			this.user.setConfirmPassword(this.user.getPassword());

			// if user logged in with remember me, display a warning that they
			// can't change passwords
			this.log.debug("checking for remember me login...");

			final AuthenticationTrustResolver resolver = new AuthenticationTrustResolverImpl();
			final SecurityContext ctx = SecurityContextHolder.getContext();

			if (ctx != null) {
				final Authentication auth = ctx.getAuthentication();

				if (resolver.isRememberMe(auth)) {
					this.getSession().setAttribute("cookieLogin", "true");
					this.saveMessage(this.getText("userProfile.cookieLogin"));
				}
			}
		}

		return Action.SUCCESS;
	}

	/**
	 * Default: just returns "success".
	 * 
	 * @return "success"
	 */
	@Override
	public String execute() {
		return Action.SUCCESS;
	}

	/**
	 * Sends users to "mainMenu" when !from.equals("list"). Sends everyone else
	 * to "cancel"
	 * 
	 * @return "mainMenu" or "cancel"
	 */
	@Override
	public String cancel() {
		if (!"list".equals(this.from))
			return "mainMenu";
		return "cancel";
	}

	/**
	 * Save user.
	 * 
	 * @return success if everything worked, otherwise input
	 * @throws Exception
	 *             when setting "access denied" fails on response
	 */
	public String save() throws Exception {

		final Integer originalVersion = this.user.getVersion();

		final boolean isNew = ("".equals(this.getRequest().getParameter(
				"user.version")));
		// only attempt to change roles if user is admin
		// for other users, prepare() method will handle populating
		// TODO hartkodiert
		if (this.getRequest().isUserInRole("ROLE_ADMIN")) {
			// if (getRequest().isUserInRole(Constants.ADMIN_ROLE)) {
			this.user.getRoles().clear(); // APF-788: Removing roles from user
											// doesn't work
			final String[] userRoles = this.getRequest().getParameterValues(
					"userRoles");

			for (int i = 0; (userRoles != null) && (i < userRoles.length); i++) {
				final String roleName = userRoles[i];
				this.user.addRole(this.roleManager.getRole(roleName));
			}
		}

		try {
			this.userManager.saveUser(this.user);
		} catch (final AccessDeniedException ade) {
			// thrown by UserSecurityAdvice configured in aop:advisor
			// userManagerSecurity
			this.log.warn(ade.getMessage());
			this.getResponse().sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		} catch (final UserExistsException e) {
			final List<Object> args = new ArrayList<Object>();
			args.add(this.user.getUsername());
			args.add(this.user.getEmail());
			this.addActionError(this.getText("errors.existing.user", args));

			// reset the version # to what was passed in
			this.user.setVersion(originalVersion);
			// redisplay the unencrypted passwords
			this.user.setPassword(this.user.getConfirmPassword());
			return Action.INPUT;
		}

		if (!"list".equals(this.from)) {
			// add success messages
			this.saveMessage(this.getText("user.saved"));
			return "mainMenu";
		} else {
			// add success messages
			final List<Object> args = new ArrayList<Object>();
			args.add(this.user.getFullName());
			if (isNew) {
				this.saveMessage(this.getText("user.added", args));
				// Send an account information e-mail
				this.mailMessage.setSubject(this
						.getText("signup.email.subject"));
				try {
					this.sendUserMessage(this.user,
							this.getText("newuser.email.message", args),
							RequestUtil.getAppURL(this.getRequest()));
				} catch (final MailException me) {
					this.addActionError(me.getCause().getLocalizedMessage());
				}
				return Action.SUCCESS;
			} else {
				this.saveMessage(this.getText("user.updated.byAdmin", args));
				return Action.INPUT;
			}
		}
	}

	/**
	 * Fetch all users from database and put into local "users" variable for
	 * retrieval in the UI.
	 * 
	 * @return "success" if no exceptions thrown
	 */
	public String list() {
		this.users = this.userManager.getUsers();
		return Action.SUCCESS;
	}
}
