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

import org.appfuse.service.impl.GenericManagerImpl;

import ejportal.dao.ExemplarDao;
import ejportal.dao.InstitutionDao;
import ejportal.dao.JournalDao;
import ejportal.dao.SigelDao;
import ejportal.model.Exemplar;
import ejportal.model.Journal;
import ejportal.service.ExemplarManager;
import ejportal.service.dto.ExemplarBaseTO;
import ejportal.util.BeanUtil;

/**
 * Created by IntelliJ IDEA. User: Christoph Date: 14.07.2010 Time: 16:15:45 To
 * change this template use File | Settings | File Templates.
 */
public class ExemplarManagerImpl extends GenericManagerImpl<Exemplar, Long>
		implements ExemplarManager {

	/** The exemplar dao. */
	private final ExemplarDao exemplarDao;

	/** The institution dao. */
	private final InstitutionDao institutionDao;

	/** The sigel dao. */
	private final SigelDao sigelDao;

	/** The journal dao. */
	private final JournalDao journalDao;

	/** The bean util. */
	BeanUtil beanUtil;

	/**
	 * Instantiates a new exemplar manager impl.
	 * 
	 * @param exemplarDao
	 *            the exemplar dao
	 * @param institutionDao
	 *            the institution dao
	 * @param sigelDao
	 *            the sigel dao
	 * @param journalDao
	 *            the journal dao
	 */
	public ExemplarManagerImpl(final ExemplarDao exemplarDao,
			final InstitutionDao institutionDao, final SigelDao sigelDao,
			final JournalDao journalDao) {
		super(exemplarDao);
		this.exemplarDao = exemplarDao;
		this.institutionDao = institutionDao;
		this.sigelDao = sigelDao;
		this.journalDao = journalDao;
		this.beanUtil = new BeanUtil();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.ExemplarManager#connectExemplarLieferant(long,
	 * long)
	 */
	public void connectExemplarLieferant(final long exemplarId,
			final long lieferantId) {
		final Exemplar exemplar = this.exemplarDao.get(exemplarId);
		exemplar.setLieferant(this.institutionDao.get(lieferantId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.ExemplarManager#connectExemplarEigentuemer(long,
	 * long)
	 */
	public void connectExemplarEigentuemer(final long exemplarId,
			final long eigentuemerId) {
		final Exemplar exemplar = this.exemplarDao.get(exemplarId);
		exemplar.setEigentuemer(this.sigelDao.get(eigentuemerId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.ExemplarManager#connectExemplarBesteller(long,
	 * long)
	 */
	public void connectExemplarBesteller(final long exemplarId,
			final long bestellerId) {
		final Exemplar exemplar = this.exemplarDao.get(exemplarId);
		exemplar.setBesteller(this.sigelDao.get(bestellerId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.ExemplarManager#connectExemplarZustaendigeBib(long,
	 * long)
	 */
	public void connectExemplarZustaendigeBib(final long exemplarId,
			final long zustaendigeBibId) {
		final Exemplar exemplar = this.exemplarDao.get(exemplarId);
		exemplar.setZustaendigeBib(this.sigelDao.get(zustaendigeBibId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.ExemplarManager#getExemplarBaseTO(long)
	 */
	public ExemplarBaseTO getExemplarBaseTO(final long exemplarId) {
		// TODO Fehlerbehandlung
		final Exemplar exemplar = this.exemplarDao.get(exemplarId);
		final ExemplarBaseTO exemplarBaseTO = new ExemplarBaseTO();

		try {
			// here comes the reflection voodoo ;-)
			this.beanUtil.copyEntityToBaseTO(exemplar, exemplarBaseTO);
			// jetzt sind im exemplarBaseTO alle Attribute von exemplar OHNE die
			// Beziehungen!
		} catch (final Exception e) {
			// TODO Fehlerbehandlung
			e.printStackTrace();
		}
		return exemplarBaseTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.ExemplarManager#saveBaseTO(ejportal.service.dto.
	 * ExemplarBaseTO)
	 */
	public Exemplar saveBaseTO(final ExemplarBaseTO exemplarBaseTO) {
		// erst mal das Exemplar holen
		Exemplar exemplar = this.exemplarDao
				.get(exemplarBaseTO.getExemplarId());
		try {
			// mit reflection voodoo die Daten vom exemplarBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(exemplarBaseTO, exemplar);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace();
		}

		exemplar = this.save(exemplar);
		return exemplar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.ExemplarManager#create(ejportal.service.dto.ExemplarBaseTO
	 * , java.lang.Long)
	 */
	public Exemplar create(final ExemplarBaseTO exemplarBaseTO,
			final Long journalId) {

		// Neues Exemplar erstellen
		Exemplar exemplar = new Exemplar();

		// Attribute aus dem BaseTO füllen
		try {
			// mit reflection voodoo die Daten vom exemplarBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(exemplarBaseTO, exemplar);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace();
		}

		// Neues Exemplar dem Journal zuweisen
		final Journal journal = this.journalDao.get(journalId);
		exemplar.setJournal(journal);
		// Die folgende Zeile macht Hibernate von selbst!
		// journal.getExemplare().add(exemplar);

		// Speichern und gut is!
		exemplar = this.save(exemplar);
		return exemplar;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.ExemplarManager#removeSafe(java.lang.Long)
	 */
	public void removeSafe(final Long exemplarId) {

		// Erst das Exemplar aus der Exemplar-Liste des Journals entfernen
		final Exemplar exemplar = this.exemplarDao.get(exemplarId);
		exemplar.getJournal().getExemplare().remove(exemplar);

		// Löschen und gut is!
		super.remove(exemplarId);
	}
}
