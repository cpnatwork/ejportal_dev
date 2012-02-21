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
package ejportal.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;

import ejportal.model.Besteller;
import ejportal.service.dto.BestellerSearchTO;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 16:06:16 To
 * change this template use File | Settings | File Templates.
 */
public interface BestellerDao extends GenericDao<Besteller, Long> {

	/**
	 * Find by search to.
	 * 
	 * @param bestellerSearchTO
	 *            the besteller search to
	 * @param maxResults
	 *            the max results
	 * @return the list
	 */
	public List<Besteller> findBySearchTO(BestellerSearchTO bestellerSearchTO,
			Integer maxResults);

	/**
	 * Find by besteller id.
	 * 
	 * @param bestellerId
	 *            the besteller id
	 * @return the list
	 */
	public List<Besteller> findByBestellerId(Long bestellerId);

}
