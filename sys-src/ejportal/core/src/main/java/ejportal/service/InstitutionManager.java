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

import ejportal.model.Institution;
import ejportal.service.dto.InstitutionBaseTO;
import ejportal.service.dto.InstitutionSearchTO;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 21.06.2010 Time: 12:35:24 To
 * change this template use File | Settings | File Templates.
 */
public interface InstitutionManager extends GenericManager<Institution, Long> {

	/**
	 * Search.
	 * 
	 * @param institutionSearchTO
	 *            the institution search to
	 * @return the list
	 */
	public List<Institution> search(InstitutionSearchTO institutionSearchTO);

	/**
	 * Search.
	 * 
	 * @param institutionSearchTO
	 *            the institution search to
	 * @param maxResults
	 *            the max results
	 * @return the list
	 */
	public List<Institution> search(InstitutionSearchTO institutionSearchTO,
			Integer maxResults);

	// public void connectInstitutionJournal(long institutionId, long
	// journalId);
	/**
	 * Gets the institution base to.
	 * 
	 * @param id
	 *            the id
	 * @return the institution base to
	 */
	public InstitutionBaseTO getInstitutionBaseTO(long id);

	/**
	 * Save base to.
	 * 
	 * @param institutionBaseTO
	 *            the institution base to
	 * @return the institution
	 */
	public Institution saveBaseTO(InstitutionBaseTO institutionBaseTO);

	/**
	 * Creates the.
	 * 
	 * @param institutionBaseTO
	 *            the institution base to
	 * @return the institution
	 */
	public Institution create(InstitutionBaseTO institutionBaseTO);

}
