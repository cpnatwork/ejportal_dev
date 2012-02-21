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

import ejportal.dao.JournalDao;
import ejportal.dao.NutzungDao;
import ejportal.model.Nutzung;
import ejportal.service.NutzungManager;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 09.08.2010 Time: 16:12:49 To
 * change this template use File | Settings | File Templates.
 */
public class NutzungManagerImpl extends GenericManagerImpl<Nutzung, Long>
		implements NutzungManager {

	/** The nutzung dao. */
	private final NutzungDao nutzungDao;

	/** The journal dao. */
	private final JournalDao journalDao;

	/**
	 * Instantiates a new nutzung manager impl.
	 * 
	 * @param nutzungDao
	 *            the nutzung dao
	 * @param journalDao
	 *            the journal dao
	 */
	public NutzungManagerImpl(final NutzungDao nutzungDao,
			final JournalDao journalDao) {
		super(nutzungDao);
		this.nutzungDao = nutzungDao;
		this.journalDao = journalDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.NutzungManager#findByJournalId(java.lang.Long)
	 */
	public List<Nutzung> findByJournalId(final Long journalId) {
		return this.nutzungDao.findByJournal(journalId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.NutzungManager#saveWithJournal(ejportal.model.Nutzung,
	 * java.lang.Long)
	 */
	public Nutzung saveWithJournal(final Nutzung nutzung, final Long journalId) {
		nutzung.setJournal(this.journalDao.get(journalId));

		return super.save(nutzung);
	}

}
