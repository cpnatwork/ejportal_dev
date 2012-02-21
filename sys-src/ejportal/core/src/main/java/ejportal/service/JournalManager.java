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
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 14:21:38
 * To change this template use File | Settings | File Templates.
 */

import java.util.Date;
import java.util.List;

import org.appfuse.service.GenericManager;

import ejportal.model.Journal;
import ejportal.service.dto.JournalBaseTO;
import ejportal.service.dto.JournalSearchTO;

/**
 * The Interface JournalManager.
 */
public interface JournalManager extends GenericManager<Journal, Long> {

	/**
	 * Search.
	 * 
	 * @param journalSearchTO
	 *            the journal search to
	 * @return the list
	 */
	public List<Journal> search(JournalSearchTO journalSearchTO);

	/**
	 * Search.
	 * 
	 * @param journalSearchTO
	 *            the journal search to
	 * @param maxResults
	 *            the max results
	 * @return the list
	 */
	public List<Journal> search(JournalSearchTO journalSearchTO,
			Integer maxResults);

	/**
	 * Connect journal verlag.
	 * 
	 * @param journalId
	 *            the journal id
	 * @param verlagId
	 *            the verlag id
	 */
	public void connectJournalVerlag(long journalId, long verlagId);

	/**
	 * Connect journal provider.
	 * 
	 * @param journalId
	 *            the journal id
	 * @param providerId
	 *            the provider id
	 */
	public void connectJournalProvider(long journalId, long providerId);

	/**
	 * Connect journal konsortium.
	 * 
	 * @param journalId
	 *            the journal id
	 * @param konsortiumId
	 *            the konsortium id
	 */
	public void connectJournalKonsortium(long journalId, long konsortiumId);

	/**
	 * Connect journal paket.
	 * 
	 * @param journalId
	 *            the journal id
	 * @param paketId
	 *            the paket id
	 */
	public void connectJournalPaket(long journalId, long paketId);

	/**
	 * Connect journal fach.
	 * 
	 * @param journalId
	 *            the journal id
	 * @param fachId
	 *            the fach id
	 * @return true, if successful
	 */
	public boolean connectJournalFach(long journalId, long fachId);

	/**
	 * Disconnect journal fach.
	 * 
	 * @param journalId
	 *            the journal id
	 * @param fachId
	 *            the fach id
	 * @return true, if successful
	 */
	public boolean disconnectJournalFach(long journalId, long fachId);

	/**
	 * Connect journal bibliotheksmitarbeiter.
	 * 
	 * @param journalId
	 *            the journal id
	 * @param bibId
	 *            the bib id
	 */
	public void connectJournalBibliotheksmitarbeiter(long journalId, long bibId);

	/**
	 * Connect journal exemplar.
	 * 
	 * @param journalId
	 *            the journal id
	 * @param exemplarId
	 *            the exemplar id
	 */
	public void connectJournalExemplar(long journalId, long exemplarId);

	/**
	 * Gets the journal base to.
	 * 
	 * @param id
	 *            the id
	 * @return the journal base to
	 */
	public JournalBaseTO getJournalBaseTO(long id);

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
	 * Find by verlag id.
	 * 
	 * @param verlagId
	 *            the verlag id
	 * @return the list
	 */
	public List<Journal> findByVerlagId(int verlagId);

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
	 * Save base to.
	 * 
	 * @param journalBaseTO
	 *            the journal base to
	 * @return the journal
	 */
	public Journal saveBaseTO(JournalBaseTO journalBaseTO);

	/**
	 * Creates the.
	 * 
	 * @param journalBaseTO
	 *            the journal base to
	 * @return the journal
	 */
	public Journal create(JournalBaseTO journalBaseTO);

}
