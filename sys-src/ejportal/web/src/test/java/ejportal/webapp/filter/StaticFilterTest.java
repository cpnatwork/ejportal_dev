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

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

/**
 * The Class StaticFilterTest.
 */
public class StaticFilterTest extends TestCase {

	/** The filter. */
	private StaticFilter filter = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		this.filter = new StaticFilter();
		final MockFilterConfig config = new MockFilterConfig();
		config.addInitParameter("includes", "/scripts/*");
		this.filter.init(config);
	}

	/**
	 * Test filter doesnt forward when path matches.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testFilterDoesntForwardWhenPathMatches() throws Exception {
		final MockHttpServletRequest request = new MockHttpServletRequest(
				"GET", "/scripts/dojo/test.html");
		final MockHttpServletResponse response = new MockHttpServletResponse();
		final MockFilterChain chain = new MockFilterChain();

		this.filter.doFilter(request, response, chain);

		Assert.assertNull(chain.getForwardURL());
	}

	/**
	 * Test filter forwards when path doesnt match.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void testFilterForwardsWhenPathDoesntMatch() throws Exception {
		final MockHttpServletRequest request = new MockHttpServletRequest(
				"GET", "/editProfile.html");
		final MockHttpServletResponse response = new MockHttpServletResponse();
		final MockFilterChain chain = new MockFilterChain();

		this.filter.doFilter(request, response, chain);

		Assert.assertNotNull(chain.getForwardURL());
	}
}
