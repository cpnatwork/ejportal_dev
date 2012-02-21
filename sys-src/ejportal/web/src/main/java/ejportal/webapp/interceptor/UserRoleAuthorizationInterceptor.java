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
package ejportal.webapp.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * Security interceptor checks to see if users are in the specified roles before
 * proceeding. Similar to Spring's UserRoleAuthorizationInterceptor.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * @see org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor
 */
public class UserRoleAuthorizationInterceptor implements Interceptor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5067790608840427509L;

	/** The authorized roles. */
	private String[] authorizedRoles;

	/**
	 * Intercept the action invocation and check to see if the user has the
	 * proper role.
	 * 
	 * @param invocation
	 *            the current action invocation
	 * @return the method's return value, or null after setting
	 *         HttpServletResponse.SC_FORBIDDEN
	 * @throws Exception
	 *             when setting the error on the response fails
	 */
	public String intercept(final ActionInvocation invocation) throws Exception {
		final HttpServletRequest request = ServletActionContext.getRequest();

		if (this.authorizedRoles != null) {
			for (final String authorizedRole : this.authorizedRoles) {
				if (request.isUserInRole(authorizedRole))
					return invocation.invoke();
			}
		}

		final HttpServletResponse response = ServletActionContext.getResponse();
		this.handleNotAuthorized(request, response);
		return null;
	}

	/**
	 * Set the roles that this interceptor should treat as authorized.
	 * 
	 * @param authorizedRoles
	 *            array of role names
	 */
	public final void setAuthorizedRoles(final String[] authorizedRoles) {
		this.authorizedRoles = authorizedRoles;
	}

	/**
	 * Handle a request that is not authorized according to this interceptor.
	 * Default implementation sends HTTP status code 403 ("forbidden").
	 * 
	 * <p>
	 * This method can be overridden to write a custom message, forward or
	 * redirect to some error page or login page, or throw a ServletException.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param response
	 *            current HTTP response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected void handleNotAuthorized(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	/**
	 * This method currently does nothing.
	 */
	public void destroy() {
	}

	/**
	 * This method currently does nothing.
	 */
	public void init() {
	}
}
