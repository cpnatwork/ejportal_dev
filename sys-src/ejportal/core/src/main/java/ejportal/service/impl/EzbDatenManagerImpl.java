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
package ejportal.service.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;

import ejportal.dao.EzbDatenDao;
import ejportal.dao.JournalDao;
import ejportal.model.EzbDaten;
import ejportal.model.Journal;
import ejportal.service.EzbDatenManager;
import ejportal.service.dto.EzbDatenSearchTO;

/**
 * Created by IntelliJ IDEA. User: Florian Date: 09.08.2010 Time: 18:01:20 To
 * change this template use File | Settings | File Templates.
 */
public class EzbDatenManagerImpl extends GenericManagerImpl<EzbDaten, Long>
		implements EzbDatenManager {

	/** The ezb daten dao. */
	private final EzbDatenDao ezbDatenDao;

	/** The journal dao. */
	private final JournalDao journalDao;

	/**
	 * Instantiates a new ezb daten manager impl.
	 * 
	 * @param ezbDatenDao
	 *            the ezb daten dao
	 * @param journalDao
	 *            the journal dao
	 */
	public EzbDatenManagerImpl(final EzbDatenDao ezbDatenDao,
			final JournalDao journalDao) {
		super(ezbDatenDao);
		this.ezbDatenDao = ezbDatenDao;
		this.journalDao = journalDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.EzbDatenManager#loadWithJournalId(java.lang.Long)
	 */
	public EzbDaten loadWithJournalId(final Long journalId) {
		final Journal journal = this.journalDao.get(journalId);
		if (journal.getEzbId() != null) {
			try {
				return this.ezbDatenDao.get(journal.getEzbId());
			} catch (final Exception e) {
				return new EzbDaten();
			}
		}
		return new EzbDaten();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.EzbDatenManager#findBySearchTO(ejportal.service.dto.
	 * EzbDatenSearchTO, int)
	 */
	public List<EzbDaten> findBySearchTO(
			final EzbDatenSearchTO ezbDatenSearchTO, final int maxResults) {
		return this.ezbDatenDao.findBySearchTO(ezbDatenSearchTO, maxResults);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.EzbDatenManager#connectEzbDaten(java.lang.Long,
	 * java.lang.Long)
	 */
	public void connectEzbDaten(final Long ezbId, final Long journalId) {
		final Journal journal = this.journalDao.get(journalId);
		journal.setEzbId(ezbId);
		this.journalDao.save(journal);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.EzbDatenManager#createJournal(java.lang.Long)
	 */
	public Journal createJournal(final Long ezbId) {
		final EzbDaten ezbDaten = this.ezbDatenDao.get(ezbId);
		Journal journal = new Journal();

		journal.setEzbId(ezbId);
		journal.setTitel(ezbDaten.getTitel());
		journal.setZdbNummer(ezbDaten.getZdbNummer());
		journal.setIssn(ezbDaten.getIssne());
		journal.setIssnPrint(ezbDaten.getIssnp());

		journal = this.journalDao.save(journal);
		return journal;
	}
}
