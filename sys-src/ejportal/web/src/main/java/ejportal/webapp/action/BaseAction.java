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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.appfuse.Constants;
import org.appfuse.model.User;
import org.appfuse.service.MailEngine;
import org.appfuse.service.RoleManager;
import org.appfuse.service.UserManager;
import org.springframework.mail.SimpleMailMessage;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Implementation of <strong>ActionSupport</strong> that contains convenience
 * methods for subclasses. For example, getting the current user and saving
 * messages/errors. This class is intended to be a base class for all Action
 * classes.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class BaseAction extends ActionSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3525445612504421307L;

	/** Constant for cancel result String. */
	public static final String CANCEL = "cancel";

	/**
	 * Transient log to prevent session synchronization issues - children can
	 * use instance for logging.
	 */
	protected final transient Log log = LogFactory.getLog(this.getClass());

	/** The UserManager. */
	protected UserManager userManager;

	/** The RoleManager. */
	protected RoleManager roleManager;

	/** Indicator if the user clicked cancel. */
	protected String cancel;

	/**
	 * Indicator for the page the user came from.
	 */
	protected String from;

	/** Set to "delete" when a "delete" request parameter is passed in. */
	protected String delete;

	/** Set to "save" when a "save" request parameter is passed in. */
	protected String save;

	/** MailEngine for sending e-mail. */
	protected MailEngine mailEngine;

	/** A message pre-populated with default data. */
	protected SimpleMailMessage mailMessage;

	/** Velocity template to use for e-mailing. */
	protected String templateName;

	/**
	 * Simple method that returns "cancel" result.
	 * 
	 * @return "cancel"
	 */
	public String cancel() {
		return BaseAction.CANCEL;
	}

	/**
	 * A method that returns the journal title.
	 * 
	 * @return "journalTitle"
	 */
	public String getJournalTitel() {
		return "Ein Beispiel Journal Title";
	}

	/**
	 * Save the message in the session, appending if messages already exist.
	 * 
	 * @param msg
	 *            the message to put in the session
	 */
	@SuppressWarnings("unchecked")
	protected void saveMessage(final String msg) {
		List messages = (List) this.getRequest().getSession()
				.getAttribute("messages");
		if (messages == null) {
			messages = new ArrayList();
		}
		messages.add(msg);
		this.getRequest().getSession().setAttribute("messages", messages);
	}

	/**
	 * Convenience method to get the Configuration HashMap from the servlet
	 * context.
	 * 
	 * @return the user's populated form from the session
	 */
	protected Map getConfiguration() {
		final Map config = (HashMap) this.getSession().getServletContext()
				.getAttribute(Constants.CONFIG);
		// so unit tests don't puke when nothing's been set
		if (config == null)
			return new HashMap();
		return config;
	}

	/**
	 * Convenience method to get the request.
	 * 
	 * @return current request
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * Convenience method to get the response.
	 * 
	 * @return current response
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * Convenience method to get the session. This will create a session if one
	 * doesn't exist.
	 * 
	 * @return the session from the request (request.getSession()).
	 */
	protected HttpSession getSession() {
		return this.getRequest().getSession();
	}

	/**
	 * Convenience method to send e-mail to users.
	 * 
	 * @param user
	 *            the user to send to
	 * @param msg
	 *            the message to send
	 * @param url
	 *            the URL to the application (or where ever you'd like to send
	 *            them)
	 */
	protected void sendUserMessage(final User user, final String msg,
			final String url) {
		if (this.log.isDebugEnabled()) {
			this.log.debug("sending e-mail to user [" + user.getEmail()
					+ "]...");
		}

		this.mailMessage
				.setTo(user.getFullName() + "<" + user.getEmail() + ">");

		final Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", user);
		// TODO: figure out how to get bundle specified in struts.xml
		// model.put("bundle", getTexts());
		model.put("message", msg);
		model.put("applicationURL", url);
		this.mailEngine.sendMessage(this.mailMessage, this.templateName, model);
	}

	/**
	 * Sets the UserManager.
	 * 
	 * @param userManager
	 *            the new UserManager
	 */
	public void setUserManager(final UserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * Sets the RoleManager.
	 * 
	 * @param roleManager
	 *            the new RoleManager
	 */
	public void setRoleManager(final RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	/**
	 * Sets the mailEngine for sending e-mail.
	 * 
	 * @param mailEngine
	 *            the new mailEngine for sending e-mail
	 */
	public void setMailEngine(final MailEngine mailEngine) {
		this.mailEngine = mailEngine;
	}

	/**
	 * Sets the a message pre-populated with default data.
	 * 
	 * @param mailMessage
	 *            the new a message pre-populated with default data
	 */
	public void setMailMessage(final SimpleMailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}

	/**
	 * Sets the velocity template to use for e-mailing.
	 * 
	 * @param templateName
	 *            the new velocity template to use for e-mailing
	 */
	public void setTemplateName(final String templateName) {
		this.templateName = templateName;
	}

	/**
	 * Convenience method for setting a "from" parameter to indicate the
	 * previous page.
	 * 
	 * @param from
	 *            indicator for the originating page
	 */
	public void setFrom(final String from) {
		this.from = from;
	}

	/**
	 * Sets the set to "delete" when a "delete" request parameter is passed in.
	 * 
	 * @param delete
	 *            the new set to "delete" when a "delete" request parameter is
	 *            passed in
	 */
	public void setDelete(final String delete) {
		this.delete = delete;
	}

	/**
	 * Sets the set to "save" when a "save" request parameter is passed in.
	 * 
	 * @param save
	 *            the new set to "save" when a "save" request parameter is
	 *            passed in
	 */
	public void setSave(final String save) {
		this.save = save;
	}
}
