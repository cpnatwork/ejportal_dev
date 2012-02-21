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
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

import ejportal.webapp.listener.StartupListener;

/**
 * This class is used to reload the drop-downs initialized in the
 * StartupListener.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class ReloadAction extends BaseAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 295460450224891051L;

	/**
	 * Method that calls StartupListener.setContext() and returns user to
	 * referrer location (or does a popup if none found).
	 * 
	 * @return sucess when everything goes right
	 * @throws IOException
	 *             when response.sendRedirect fails
	 */
	@Override
	public String execute() throws IOException {
		StartupListener.setupContext(this.getSession().getServletContext());

		final String referer = this.getRequest().getHeader("Referer");
		final HttpServletResponse response = ServletActionContext.getResponse();

		if (referer != null) {
			this.log.info("reload complete, reloading user back to: " + referer);
			this.saveMessage(this.getText("reload.succeeded"));
			response.sendRedirect(response.encodeRedirectURL(referer));
			return Action.SUCCESS;
		} else {
			response.setContentType("text/html");

			final PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Context Reloaded</title>");
			out.println("</head>");
			out.println("<body bgcolor=\"white\">");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Reloading options succeeded! Click OK to continue.');");
			out.println("history.back();");
			out.println("</script>");
			out.println("</body>");
			out.println("</html>");
		}

		return Action.SUCCESS;
	}
}
