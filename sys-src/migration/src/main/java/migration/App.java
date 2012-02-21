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
package migration;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!.
 */
public class App {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	@Autowired
	public static void main(final String[] args) {

		// PREPARE
		final ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		// of course, an ApplicationContext is just a BeanFactory
		final BeanFactory factory = appContext;

		// Initialize
		final Helper helper = new Helper();
		final JournalMigration jmigration = new JournalMigration(factory,
				helper);

		// /run
		jmigration.run();

	}

}
