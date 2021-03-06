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
package ejportal.service;

/**
 * Created by IntelliJ IDEA. User: florian Date: 11.08.2010 Time: 13:40:11 To
 * change this template use File | Settings | File Templates.
 */
public interface JournalTitelService {

	/**
	 * Gets the titel.
	 * 
	 * @param journalId
	 *            the journal id
	 * @return the titel
	 */
	public String getTitel(long journalId);
}
