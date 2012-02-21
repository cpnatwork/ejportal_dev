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

import java.util.ArrayList;
import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;

import ejportal.dao.ExemplarDao;
import ejportal.dao.JournalDao;
import ejportal.dao.RechnungDao;
import ejportal.model.Exemplar;
import ejportal.model.Rechnung;
import ejportal.service.RechnungManager;
import ejportal.service.dto.RechnungBaseTO;
import ejportal.util.BeanUtil;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 09.08.2010 Time: 15:09:08 To
 * change this template use File | Settings | File Templates.
 */
public class RechnungManagerImpl extends GenericManagerImpl<Rechnung, Long>
		implements RechnungManager {

	/** The rechnung dao. */
	private final RechnungDao rechnungDao;

	/** The exemplar dao. */
	private final ExemplarDao exemplarDao;

	/** The journal dao. */
	private final JournalDao journalDao;

	/** The bean util. */
	private final BeanUtil beanUtil;

	/**
	 * Instantiates a new rechnung manager impl.
	 * 
	 * @param rechnungDao
	 *            the rechnung dao
	 * @param exemplarDao
	 *            the exemplar dao
	 * @param journalDao
	 *            the journal dao
	 */
	public RechnungManagerImpl(final RechnungDao rechnungDao,
			final ExemplarDao exemplarDao, final JournalDao journalDao) {
		super(rechnungDao);
		this.rechnungDao = rechnungDao;
		this.exemplarDao = exemplarDao;
		this.journalDao = journalDao;
		this.beanUtil = new BeanUtil();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.RechnungManager#getListForExemplar(long)
	 */
	public List<Rechnung> getListForExemplar(final long exemplarId) {
		return this.rechnungDao.findByExemplarId(exemplarId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.RechnungManager#getListForJournal(long)
	 */
	public List<Rechnung> getListForJournal(final long journalId) {
		// alle zu einem Journal gehörigen Exemplare abrufen
		final List<Exemplar> exemplare = this.exemplarDao
				.getListForJournal(journalId);
		final List<Rechnung> rechnungen = new ArrayList();

		// Für jedes Exemplar die Rechnungen holen
		for (final Exemplar exemplar : exemplare) {
			// Rechnungen eines Exemplars
			final List<Rechnung> rechnungenForExemplar = this.rechnungDao
					.findByExemplarId(exemplar.getExemplarId());
			// falls es Rechnungen gibt, diese an die Ergebnismenge anhängen
			if (!rechnungenForExemplar.isEmpty()) {
				for (final Rechnung rechnung : rechnungenForExemplar) {
					rechnungen.add(rechnung);
				}
			}
		}

		return rechnungen;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.RechnungManager#connectRechnungExemplar(long, long)
	 */
	public void connectRechnungExemplar(final long rechnungId,
			final long exemplarId) {
		final Rechnung rechnung = this.rechnungDao.get(rechnungId);
		rechnung.setExemplar(this.exemplarDao.get(exemplarId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.RechnungManager#getRechnungBaseTO(java.lang.Long)
	 */
	public RechnungBaseTO getRechnungBaseTO(final Long rechnungId) {
		final Rechnung rechnung = this.rechnungDao.get(rechnungId);
		final RechnungBaseTO rechnungBaseTO = new RechnungBaseTO();

		try {
			// here comes the reflection voodoo ;-)
			this.beanUtil.copyEntityToBaseTO(rechnung, rechnungBaseTO);
			// jetzt sind im rechnungBaseTO alle Attribute von rechnung OHNE die
			// Beziehungen!
		} catch (final Exception e) {
			// TODO Fehlerbehandlung
			e.printStackTrace();
		}
		return rechnungBaseTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.RechnungManager#saveBaseTO(ejportal.service.dto.
	 * RechnungBaseTO)
	 */
	public Rechnung saveBaseTO(final RechnungBaseTO rechnungBaseTO) {
		// erst mal die Rechnung holen
		Rechnung rechnung = this.rechnungDao
				.get(rechnungBaseTO.getRechnungId());
		try {
			// mit reflection voodoo die Daten vom rechnungBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(rechnungBaseTO, rechnung);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace();
		}

		rechnung = this.save(rechnung);
		return rechnung;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.RechnungManager#create(ejportal.service.dto.RechnungBaseTO
	 * , java.lang.Long)
	 */
	public Rechnung create(final RechnungBaseTO rechnungBaseTO,
			final Long exemplarId) {
		// Neue Rechnung erstellen
		Rechnung rechnung = new Rechnung();

		// Attribute aus dem BaseTO füllen
		try {
			// mit reflection voodoo die Daten vom rechnungBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(rechnungBaseTO, rechnung);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace();
		}

		// Das Exemplar der Rechnung zuordnen
		rechnung.setExemplar(this.exemplarDao.get(exemplarId));

		// Speichern und gut is!
		rechnung = this.save(rechnung);
		return rechnung;
	}
}
