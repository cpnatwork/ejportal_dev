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

import ejportal.dao.BestellerDao;
import ejportal.dao.InteresseDao;
import ejportal.dao.JournalDao;
import ejportal.model.Interesse;
import ejportal.service.InteresseManager;
import ejportal.service.dto.InteresseBaseTO;
import ejportal.util.BeanUtil;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 16:15:50 To
 * change this template use File | Settings | File Templates.
 */
public class InteresseManagerImpl extends GenericManagerImpl<Interesse, Long>
		implements InteresseManager {

	/** The interesse dao. */
	private final InteresseDao interesseDao;

	/** The besteller dao. */
	private final BestellerDao bestellerDao;

	/** The journal dao. */
	private final JournalDao journalDao;

	/** The bean util. */
	private final BeanUtil beanUtil;

	/**
	 * Instantiates a new interesse manager impl.
	 * 
	 * @param interesseDao
	 *            the interesse dao
	 * @param bestellerDao
	 *            the besteller dao
	 * @param journalDao
	 *            the journal dao
	 */
	public InteresseManagerImpl(final InteresseDao interesseDao,
			final BestellerDao bestellerDao, final JournalDao journalDao) {
		super(interesseDao);
		this.interesseDao = interesseDao;
		this.bestellerDao = bestellerDao;
		this.journalDao = journalDao;
		this.beanUtil = new BeanUtil();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.InteresseManager#getListForJournal(java.lang.Long)
	 */
	public List<Interesse> getListForJournal(final Long journalId) {
		return this.interesseDao.findByJournalId(journalId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.InteresseManager#connectInteresseJournal(java.lang.Long,
	 * java.lang.Long)
	 */
	public void connectInteresseJournal(final Long interesseId,
			final Long journalId) {
		final Interesse interesse = this.interesseDao.get(interesseId);
		interesse.setJournal(this.journalDao.get(journalId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.InteresseManager#connectInteresseBesteller(java.lang
	 * .Long, java.lang.Long)
	 */
	public void connectInteresseBesteller(final Long interesseId,
			final Long bestellerId) {
		final Interesse interesse = this.interesseDao.get(interesseId);
		interesse.setBesteller(this.bestellerDao.get(bestellerId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.InteresseManager#getInteresseBaseTO(java.lang.Long)
	 */
	public InteresseBaseTO getInteresseBaseTO(final Long interesseId) {
		final Interesse interesse = this.interesseDao.get(interesseId);
		final InteresseBaseTO interesseBaseTO = new InteresseBaseTO();

		try {
			// here comes the reflection voodoo ;-)
			this.beanUtil.copyEntityToBaseTO(interesse, interesseBaseTO);
			// jetzt sind im interesseBaseTO alle Attribute von interesse OHNE
			// die Beziehungen!
		} catch (final Exception e) {
			// TODO Fehlerbehandlung
			e.printStackTrace();
		}
		return interesseBaseTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.InteresseManager#saveBaseTO(ejportal.service.dto.
	 * InteresseBaseTO)
	 */
	public Interesse saveBaseTO(final InteresseBaseTO interesseBaseTO) {
		// erst mal das Interesse holen
		Interesse interesse = this.interesseDao.get(interesseBaseTO
				.getInteresseId());
		try {
			// mit reflection voodoo die Daten vom interesseBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(interesseBaseTO, interesse);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace();
		}

		interesse = this.save(interesse);
		return interesse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.InteresseManager#create(ejportal.service.dto.InteresseBaseTO
	 * , java.lang.Long)
	 */
	public Interesse create(final InteresseBaseTO interesseBaseTO,
			final Long journalId) {
		// Neues Interesse erstellen
		Interesse interesse = new Interesse();

		// Attribute aus dem BaseTO füllen
		try {
			// mit reflection voodoo die Daten vom interesseBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(interesseBaseTO, interesse);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace();
		}

		// Das Journal dem Interesse zuordnen
		interesse.setJournal(this.journalDao.get(journalId));

		// Speichern und gut is!
		interesse = this.save(interesse);
		return interesse;
	}
}
