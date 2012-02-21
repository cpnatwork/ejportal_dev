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

import ejportal.model.Institution;
import ejportal.service.dto.InstitutionSearchTO;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 21.06.2010 Time: 12:29:46 To
 * change this template use File | Settings | File Templates.
 */
public interface InstitutionDao extends GenericDao<Institution, Long> {

	/**
	 * Find by search to.
	 * 
	 * @param institutionSearchTO
	 *            the institution search to
	 * @return the list
	 */
	public List<Institution> findBySearchTO(
			InstitutionSearchTO institutionSearchTO);

	/**
	 * Find by search to.
	 * 
	 * @param institutionSearchTO
	 *            the institution search to
	 * @param maxResults
	 *            the max results
	 * @return the list
	 */
	public List<Institution> findBySearchTO(
			InstitutionSearchTO institutionSearchTO, Integer maxResults);
}
