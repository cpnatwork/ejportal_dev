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

import ejportal.model.Bibliotheksmitarbeiter;
import ejportal.service.dto.BibliotheksmitarbeiterSearchTO;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 14:57:04 To
 * change this template use File | Settings | File Templates.
 */
public interface BibliotheksmitarbeiterDao extends
		GenericDao<Bibliotheksmitarbeiter, Long> {

	/**
	 * Find by search to.
	 * 
	 * @param bibliotheksmitarbeiterSearchTO
	 *            the bibliotheksmitarbeiter search to
	 * @return the list
	 */
	public List<Bibliotheksmitarbeiter> findBySearchTO(
			BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO);

	/**
	 * Find by search to.
	 * 
	 * @param bibliotheksmitarbeiterSearchTO
	 *            the bibliotheksmitarbeiter search to
	 * @param maxResults
	 *            the max results
	 * @return the list
	 */
	public List<Bibliotheksmitarbeiter> findBySearchTO(
			BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO,
			Integer maxResults);

	/**
	 * Find by name.
	 * 
	 * @param name
	 *            the name
	 * @return the list
	 */
	public List<Bibliotheksmitarbeiter> findByName(String name);

	/**
	 * Find by abteilungs hauptstelle.
	 * 
	 * @param abteilungsHauptstelle
	 *            the abteilungs hauptstelle
	 * @return the list
	 */
	public List<Bibliotheksmitarbeiter> findByAbteilungsHauptstelle(
			String abteilungsHauptstelle);

	/**
	 * Find by emailanschrift.
	 * 
	 * @param emailanschrift
	 *            the emailanschrift
	 * @return the list
	 */
	public List<Bibliotheksmitarbeiter> findByEmailanschrift(
			String emailanschrift);
}
