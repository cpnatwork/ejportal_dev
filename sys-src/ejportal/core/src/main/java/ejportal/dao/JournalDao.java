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

import java.util.Date;
import java.util.List;

import org.appfuse.dao.GenericDao;

import ejportal.model.Journal;
import ejportal.service.dto.JournalSearchTO;

/**
 * Created by IntelliJ IDEA. User: Christian Date: 10.06.2010 Time: 13:47:15 To
 * change this template use File | Settings | File Templates.
 */

public interface JournalDao extends GenericDao<Journal, Long> {

	/**
	 * Find by titel.
	 * 
	 * @param titel
	 *            the titel
	 * @return the list
	 */
	public List<Journal> findByTitel(String titel);

	/**
	 * Find by kurztitel.
	 * 
	 * @param kurztitel
	 *            the kurztitel
	 * @return the list
	 */
	public List<Journal> findByKurztitel(String kurztitel);

	/**
	 * Find by verlag.
	 * 
	 * @param verlagId
	 *            the verlag id
	 * @return the list
	 */
	public List<Journal> findByVerlag(int verlagId);

	/**
	 * Find by bearbeitungsdatum.
	 * 
	 * @param maxDate
	 *            the max date
	 * @return the list
	 */
	public List<Journal> findByBearbeitungsdatum(Date maxDate);

	/**
	 * Find by bearbeitungsdatum all.
	 * 
	 * @return the list
	 */
	public List<Journal> findByBearbeitungsdatumAll();

	/**
	 * Find by zugang ueber.
	 * 
	 * @param zugangUeber
	 *            the zugang ueber
	 * @return the list
	 */
	public List<Journal> findByZugangUeber(String zugangUeber);

	/**
	 * Find by search to.
	 * 
	 * @param journalSearchTO
	 *            the journal search to
	 * @return the list
	 */
	List<Journal> findBySearchTO(JournalSearchTO journalSearchTO);

	/**
	 * Find by search to.
	 * 
	 * @param journalSearchTO
	 *            the journal search to
	 * @param maxResults
	 *            the max results
	 * @return the list
	 */
	List<Journal> findBySearchTO(JournalSearchTO journalSearchTO,
			Integer maxResults);
}
