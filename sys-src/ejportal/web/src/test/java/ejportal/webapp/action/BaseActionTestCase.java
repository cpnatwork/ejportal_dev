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

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.struts2.ServletActionContext;
import org.appfuse.Constants;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.config.providers.XWorkConfigurationProvider;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.util.LocalizedTextUtil;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.ValueStackFactory;

/**
 * Base class for running Struts 2 Action tests.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public abstract class BaseActionTestCase extends
		AbstractTransactionalDataSourceSpringContextTests {
	/**
	 * Transient log to prevent session synchronization issues - children can
	 * use instance for logging.
	 */
	protected transient final Log log = this.logger;

	/** The smtp port. */
	private int smtpPort = 25250;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String[] getConfigLocations() {
		super.setAutowireMode(AbstractDependencyInjectionSpringContextTests.AUTOWIRE_BY_NAME);
		return new String[] { "classpath:/applicationContext-resources.xml",
				"classpath:/applicationContext-dao.xml",
				"classpath:/applicationContext-service.xml",
				"classpath*:/applicationContext.xml", // for modular archetypes
				"/WEB-INF/applicationContext*.xml" };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		this.smtpPort = this.smtpPort + (int) (Math.random() * 100);

		LocalizedTextUtil.addDefaultResourceBundle(Constants.BUNDLE_KEY);

		// Initialize ActionContext
		final ConfigurationManager configurationManager = new ConfigurationManager();
		configurationManager
				.addContainerProvider(new XWorkConfigurationProvider());
		final Configuration config = configurationManager.getConfiguration();
		final Container container = config.getContainer();

		final ValueStack stack = container.getInstance(ValueStackFactory.class)
				.createValueStack();
		stack.getContext().put(ActionContext.CONTAINER, container);
		ActionContext.setContext(new ActionContext(stack.getContext()));

		ActionContext.getContext().setSession(new HashMap<String, Object>());

		// change the port on the mailSender so it doesn't conflict with an
		// existing SMTP server on localhost
		final JavaMailSenderImpl mailSender = (JavaMailSenderImpl) this.applicationContext
				.getBean("mailSender");
		mailSender.setPort(this.getSmtpPort());
		mailSender.setHost("localhost");

		// populate the request so getRequest().getSession() doesn't fail in
		// BaseAction.java
		ServletActionContext.setRequest(new MockHttpServletRequest());
	}

	/**
	 * Gets the smtp port.
	 * 
	 * @return the smtp port
	 */
	protected int getSmtpPort() {
		return this.smtpPort;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onTearDownAfterTransaction() throws Exception {
		ActionContext.getContext().setSession(null);
	}
}
