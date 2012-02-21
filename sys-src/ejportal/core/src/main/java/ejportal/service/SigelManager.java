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

import ejportal.model.Sigel;
import ejportal.service.dto.SigelSearchTO;

/**
 * Created by IntelliJ IDEA. User: Chris Date: 28.06.2010 Time: 15:50:30 To
 * change this template use File | Settings | File Templates.
 */
public interface SigelManager extends GenericManager<Sigel, Long> {

	/**
	 * Find by search to.
	 * 
	 * @param sigelSearchTO
	 *            the sigel search to
	 * @return the list
	 */
	public List<Sigel> findBySearchTO(SigelSearchTO sigelSearchTO);

	/**
	 * Find by search to.
	 * 
	 * @param sigelSearchTO
	 *            the sigel search to
	 * @param maxResults
	 *            the max results
	 * @return the list
	 */
	public List<Sigel> findBySearchTO(SigelSearchTO sigelSearchTO,
			Integer maxResults);

	/**
	 * Find by name.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */
	public List<Sigel> findByName(String name);

	/**
	 * Find by bibliothek.
	 * 
	 * @param bibliothek
	 *            the bibliothek
	 * @return the list
	 */
	public List<Sigel> findByBibliothek(String bibliothek);

	/**
	 * Find by fakultaet.
	 * 
	 * @param fakultaet
	 *            the fakultaet
	 * @return the list
	 */
	public List<Sigel> findByFakultaet(String fakultaet);
}
