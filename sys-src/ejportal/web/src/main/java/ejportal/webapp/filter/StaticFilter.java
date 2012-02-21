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
package ejportal.webapp.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.UrlPathHelper;

/**
 * A simple filter that allows the application to continue using the .html
 * prefix for actions but also allows static files to be served up with the same
 * extension. Dojo to serve up its HTML template code. The filter works on an
 * include/exclude basis where all requests for active pages are redirected by
 * the filter to the dispatch servlet. All Dojo related .html requests are
 * allowed to pass straight through to be processed by the servlet container as
 * per normal.
 */
public class StaticFilter extends OncePerRequestFilter {

	/** The Constant DEFAULT_INCLUDES. */
	private static final String DEFAULT_INCLUDES = "*.html";

	/** The Constant DEFAULT_EXCLUDES. */
	private static final String DEFAULT_EXCLUDES = "";

	/** The Constant INCLUDES_PARAMETER. */
	private static final String INCLUDES_PARAMETER = "includes";

	/** The Constant EXCLUDES_PARAMETER. */
	private static final String EXCLUDES_PARAMETER = "excludes";

	/** The Constant SERVLETNAME_PARAMETER. */
	private static final String SERVLETNAME_PARAMETER = "servletName";

	/** The excludes. */
	private String[] excludes;

	/** The includes. */
	private String[] includes;

	/** The servlet name. */
	private String servletName;

	/**
	 * Read the includes/excludes parameters and set the filter accordingly.
	 */
	@Override
	public void initFilterBean() {
		final String includesParam = this.getFilterConfig().getInitParameter(
				StaticFilter.INCLUDES_PARAMETER);
		if (StringUtils.isEmpty(includesParam)) {
			this.includes = this.parsePatterns(StaticFilter.DEFAULT_INCLUDES);
		} else {
			this.includes = this.parsePatterns(includesParam);
		}

		final String excludesParam = this.getFilterConfig().getInitParameter(
				StaticFilter.EXCLUDES_PARAMETER);
		if (StringUtils.isEmpty(excludesParam)) {
			this.excludes = this.parsePatterns(StaticFilter.DEFAULT_EXCLUDES);
		} else {
			this.excludes = this.parsePatterns(excludesParam);
		}
		// if servletName is specified, set it
		this.servletName = this.getFilterConfig().getInitParameter(
				StaticFilter.SERVLETNAME_PARAMETER);
	}

	/**
	 * Parses the patterns.
	 * 
	 * @param delimitedPatterns
	 *            the delimited patterns
	 * @return the string[]
	 */
	private String[] parsePatterns(final String delimitedPatterns) {
		// make sure no patterns are repeated.
		final Set patternSet = org.springframework.util.StringUtils
				.commaDelimitedListToSet(delimitedPatterns);
		final String[] patterns = new String[patternSet.size()];
		int i = 0;
		for (final Iterator iterator = patternSet.iterator(); iterator
				.hasNext(); i++) {
			// no trailing/leading white space.
			final String pattern = (String) iterator.next();
			patterns[i] = pattern.trim();
		}
		return patterns;
	}

	/**
	 * This method checks to see if the current path matches includes or
	 * excludes. If it matches includes and not excludes, it forwards to the
	 * static resource and ends the filter chain. Otherwise, it forwards to the
	 * next filter in the chain.
	 * 
	 * @param request
	 *            the current request
	 * @param response
	 *            the current response
	 * @param chain
	 *            the filter chain
	 * @throws IOException
	 *             when something goes terribly wrong
	 * @throws ServletException
	 *             when something goes wrong
	 */
	@Override
	public void doFilterInternal(final HttpServletRequest request,
			final HttpServletResponse response, final FilterChain chain)
			throws IOException, ServletException {

		final UrlPathHelper urlPathHelper = new UrlPathHelper();
		final String path = urlPathHelper.getPathWithinApplication(request);
		final boolean pathExcluded = PatternMatchUtils.simpleMatch(
				this.excludes, path);
		final boolean pathIncluded = PatternMatchUtils.simpleMatch(
				this.includes, path);

		if (pathIncluded && !pathExcluded) {
			if (this.logger.isDebugEnabled()) {
				this.logger.debug("Forwarding to static resource: " + path);
			}

			if (path.contains(".html")) {
				response.setContentType("text/html");
			}

			final RequestDispatcher rd = this.getServletContext()
					.getRequestDispatcher(path);
			rd.include(request, response);
			return;
		}

		if (this.servletName != null) {
			final RequestDispatcher rd = this.getServletContext()
					.getNamedDispatcher(this.servletName);
			rd.forward(request, response);
			return;
		}

		chain.doFilter(request, response);
	}
}
