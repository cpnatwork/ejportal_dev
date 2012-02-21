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

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 14:29:19
 * To change this template use File | Settings | File Templates.
 */

import java.util.Date;
import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;

import ejportal.dao.BibliotheksmitarbeiterDao;
import ejportal.dao.ExemplarDao;
import ejportal.dao.FachDao;
import ejportal.dao.InstitutionDao;
import ejportal.dao.JournalDao;
import ejportal.dao.KonsortiumDao;
import ejportal.dao.PaketDao;
import ejportal.model.Exemplar;
import ejportal.model.Fach;
import ejportal.model.Journal;
import ejportal.service.JournalManager;
import ejportal.service.dto.JournalBaseTO;
import ejportal.service.dto.JournalSearchTO;
import ejportal.util.BeanUtil;

/**
 * The Class JournalManagerImpl.
 */
public class JournalManagerImpl extends GenericManagerImpl<Journal, Long>
		implements JournalManager {

	/** The journal dao. */
	private final JournalDao journalDao;

	/** The institution dao. */
	private final InstitutionDao institutionDao;

	/** The konsortium dao. */
	private final KonsortiumDao konsortiumDao;

	/** The paket dao. */
	private final PaketDao paketDao;

	/** The fach dao. */
	private final FachDao fachDao;

	/** The exemplar dao. */
	private final ExemplarDao exemplarDao;

	/** The bibliotheksmitarbeiter dao. */
	private final BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao;

	/** The bean util. */
	BeanUtil beanUtil;

	/**
	 * Instantiates a new journal manager impl.
	 * 
	 * @param journalDao
	 *            the journal dao
	 * @param institutionDao
	 *            the institution dao
	 * @param konsortiumDao
	 *            the konsortium dao
	 * @param paketDao
	 *            the paket dao
	 * @param fachDao
	 *            the fach dao
	 * @param exemplarDao
	 *            the exemplar dao
	 * @param bibliotheksmitarbeiterDao
	 *            the bibliotheksmitarbeiter dao
	 */
	public JournalManagerImpl(final JournalDao journalDao,
			final InstitutionDao institutionDao,
			final KonsortiumDao konsortiumDao, final PaketDao paketDao,
			final FachDao fachDao, final ExemplarDao exemplarDao,
			final BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao) {
		super(journalDao);
		this.journalDao = journalDao;
		this.institutionDao = institutionDao;
		this.konsortiumDao = konsortiumDao;
		this.paketDao = paketDao;
		this.fachDao = fachDao;
		this.exemplarDao = exemplarDao;
		this.bibliotheksmitarbeiterDao = bibliotheksmitarbeiterDao;
		this.beanUtil = new BeanUtil();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.JournalManager#search(ejportal.service.dto.JournalSearchTO
	 * , java.lang.Integer)
	 */
	public List<Journal> search(final JournalSearchTO journalSearchTO,
			final Integer maxResults) {
		return this.journalDao.findBySearchTO(journalSearchTO, maxResults);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.JournalManager#search(ejportal.service.dto.JournalSearchTO
	 * )
	 */
	public List<Journal> search(final JournalSearchTO journalSearchTO) {
		return this.journalDao.findBySearchTO(journalSearchTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#getJournalBaseTO(long)
	 */
	public JournalBaseTO getJournalBaseTO(final long journalId) {
		// TODO Fehlerbehandlung
		final Journal journal = this.journalDao.get(journalId);
		final JournalBaseTO journalBaseTO = new JournalBaseTO();

		try {
			// here comes the reflection voodoo ;-)
			this.beanUtil.copyEntityToBaseTO(journal, journalBaseTO);
			// jetzt sind im journalBaseTO alle Attribute von journal OHNE die
			// Beziehungen!
		} catch (final Exception e) {
			// TODO Fehlerbehandlung
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		return journalBaseTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.JournalManager#saveBaseTO(ejportal.service.dto.JournalBaseTO
	 * )
	 */
	public Journal saveBaseTO(final JournalBaseTO journalBaseTO) {
		// erst mal das Journal holen
		Journal journal = this.journalDao.get(journalBaseTO.getId());
		try {
			// mit reflection voodoo die Daten vom journalBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(journalBaseTO, journal);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		// Änderungsdatum auf aktuelles Datum setzen
		journal.setAenderungsdatum(new java.util.Date());
		journal = this.save(journal);
		return journal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.JournalManager#create(ejportal.service.dto.JournalBaseTO
	 * )
	 */
	public Journal create(final JournalBaseTO journalBaseTO) {
		Journal journal = new Journal();
		try {
			// mit reflection voodoo die Daten vom journalBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(journalBaseTO, journal);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		// Änderungsdatum auf aktuelles Datum setzen
		journal.setAenderungsdatum(new java.util.Date());
		journal = this.save(journal);
		return journal; // To change body of implemented methods use File |
						// Settings | File Templates.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#connectJournalVerlag(long, long)
	 */
	public void connectJournalVerlag(final long journalId, final long verlagId) {
		final Journal journal = this.journalDao.get(journalId);
		// Änderungsdatum auf aktuelles Datum setzen
		journal.setAenderungsdatum(new java.util.Date());
		journal.setVerlag(this.institutionDao.get(verlagId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#connectJournalProvider(long, long)
	 */
	public void connectJournalProvider(final long journalId,
			final long providerId) {
		final Journal journal = this.journalDao.get(journalId);
		// Änderungsdatum auf aktuelles Datum setzen
		journal.setAenderungsdatum(new java.util.Date());
		journal.setProvider(this.institutionDao.get(providerId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#connectJournalKonsortium(long, long)
	 */
	public void connectJournalKonsortium(final long journalId,
			final long konsortiumId) {
		final Journal journal = this.journalDao.get(journalId);
		// Änderungsdatum auf aktuelles Datum setzen
		journal.setAenderungsdatum(new java.util.Date());
		journal.setKonsortium(this.konsortiumDao.get(konsortiumId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#connectJournalPaket(long, long)
	 */
	public void connectJournalPaket(final long journalId, final long paketId) {
		final Journal journal = this.journalDao.get(journalId);
		// Änderungsdatum auf aktuelles Datum setzen
		journal.setAenderungsdatum(new java.util.Date());
		journal.setPaket(this.paketDao.get(paketId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#connectJournalFach(long, long)
	 */
	public boolean connectJournalFach(final long journalId, final long fachId) {
		final Journal journal = this.journalDao.get(journalId);
		final Fach fach = this.fachDao.get(fachId);
		// Änderungsdatum auf aktuelles Datum setzen
		journal.setAenderungsdatum(new java.util.Date());
		fach.getJournals().add(journal);
		return journal.getFaecher().add(fach);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#disconnectJournalFach(long, long)
	 */
	public boolean disconnectJournalFach(final long journalId, final long fachId) {
		final Journal journal = this.journalDao.get(journalId);
		final Fach fach = this.fachDao.get(fachId);
		// Änderungsdatum auf aktuelles Datum setzen
		journal.setAenderungsdatum(new java.util.Date());
		fach.getJournals().remove(journal);
		return journal.getFaecher().remove(fach);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.JournalManager#connectJournalBibliotheksmitarbeiter(
	 * long, long)
	 */
	public void connectJournalBibliotheksmitarbeiter(final long journalId,
			final long bibId) {
		final Journal journal = this.journalDao.get(journalId);
		// Änderungsdatum auf aktuelles Datum setzen
		journal.setAenderungsdatum(new java.util.Date());
		journal.setBibliotheksmitarbeiter(this.bibliotheksmitarbeiterDao
				.get(bibId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#connectJournalExemplar(long, long)
	 */
	public void connectJournalExemplar(final long journalId,
			final long exemplarId) {
		final Journal journal = this.journalDao.get(journalId);
		final Exemplar exemplar = this.exemplarDao.get(exemplarId);

		// Änderungsdatum auf aktuelles Datum setzen
		journal.setAenderungsdatum(new java.util.Date());

		exemplar.setJournal(journal);
		journal.getExemplare().add(exemplar);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#findByTitel(java.lang.String)
	 */
	public List<Journal> findByTitel(final String titel) {
		return this.journalDao.findByTitel(titel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#findByKurztitel(java.lang.String)
	 */
	public List<Journal> findByKurztitel(final String kurztitel) {
		return this.journalDao.findByKurztitel(kurztitel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#findByVerlagId(int)
	 */
	public List<Journal> findByVerlagId(final int verlagId) {
		return this.journalDao.findByVerlag(verlagId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.JournalManager#findByBearbeitungsdatum(java.util.Date)
	 */
	public List<Journal> findByBearbeitungsdatum(final Date maxDate) {
		return this.journalDao.findByBearbeitungsdatum(maxDate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#findByBearbeitungsdatumAll()
	 */
	public List<Journal> findByBearbeitungsdatumAll() {
		return this.journalDao.findByBearbeitungsdatumAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalManager#findByZugangUeber(java.lang.String)
	 */
	public List<Journal> findByZugangUeber(final String zugangUeber) {
		return this.journalDao.findByZugangUeber(zugangUeber);
	}
}
