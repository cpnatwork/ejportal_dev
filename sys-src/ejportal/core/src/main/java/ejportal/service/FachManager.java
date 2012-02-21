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

import java.util.List;

import org.appfuse.service.GenericManager;

import ejportal.model.Fach;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 16:30:06 To
 * change this template use File | Settings | File Templates.
 */
public interface FachManager extends GenericManager<Fach, Long> {

	/**
	 * Find by fach name.
	 * 
	 * @param fachName
	 *            the fach name
	 * @return the list
	 */
	public List<Fach> findByFachName(String fachName);

	/**
	 * Find by fach name.
	 * 
	 * @param fachName
	 *            the fach name
	 * @param maxResults
	 *            the max results
	 * @return the list
	 */
	public List<Fach> findByFachName(String fachName, Integer maxResults);
}
