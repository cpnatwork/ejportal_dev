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

import java.text.DecimalFormat;

import org.appfuse.service.impl.GenericManagerImpl;

import ejportal.dao.JournalDao;
import ejportal.dao.JournalkostenDao;
import ejportal.dao.WechselkursDao;
import ejportal.model.Journalkosten;
import ejportal.service.JournalkostenManager;

/**
 * Created by IntelliJ IDEA. User: ag35ogub Date: 09.08.2010 Time: 15:30:10 To
 * change this template use File | Settings | File Templates.
 */
public class JournalkostenManagerImpl extends
		GenericManagerImpl<Journalkosten, Long> implements JournalkostenManager {

	/** The journalkosten dao. */
	private final JournalkostenDao journalkostenDao;

	/** The wechselkurs dao. */
	private final WechselkursDao wechselkursDao;

	/** The journal dao. */
	private final JournalDao journalDao;

	/**
	 * Instantiates a new journalkosten manager impl.
	 * 
	 * @param journalkostenDao
	 *            the journalkosten dao
	 * @param wechselkursDao
	 *            the wechselkurs dao
	 * @param journalDao
	 *            the journal dao
	 */
	public JournalkostenManagerImpl(final JournalkostenDao journalkostenDao,
			final WechselkursDao wechselkursDao, final JournalDao journalDao) {
		super(journalkostenDao);
		this.journalkostenDao = journalkostenDao;
		this.wechselkursDao = wechselkursDao;
		this.journalDao = journalDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalkostenManager#findByJournalId(long)
	 */
	public Journalkosten findByJournalId(final long journalId) {
		return this.journalkostenDao.findByJournalId(journalId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalkostenManager#getEndpreisPO(long)
	 */
	public String getEndpreisPO(final long journalId) {
		final Journalkosten jk = this.findByJournalId(journalId);
		final float faktor = this.wechselkursDao.findByWaehrung(
				jk.getWaehrungPO()).getUmrechnungsfaktor();
		final float endpreis = jk.getOPreisPO()
				* ((Float.valueOf(jk.getMwStPO()) / 100) + 1) * faktor;
		final DecimalFormat df = new DecimalFormat("###,##0.00");
		return df.format(endpreis) + " EUR";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalkostenManager#getEndpreisP(long)
	 */
	public String getEndpreisP(final long journalId) {
		final Journalkosten jk = this.findByJournalId(journalId);
		final float faktor = this.wechselkursDao.findByWaehrung(
				jk.getWaehrungP()).getUmrechnungsfaktor();
		final float endpreis = jk.getOPreisP()
				* ((Float.valueOf(jk.getMwStP()) / 100) + 1) * faktor;
		final DecimalFormat df = new DecimalFormat("###,##0.00");
		return df.format(endpreis) + " EUR";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalkostenManager#getEndpreisO(long)
	 */
	public String getEndpreisO(final long journalId) {
		final Journalkosten jk = this.findByJournalId(journalId);
		final float faktor = this.wechselkursDao.findByWaehrung(
				jk.getWaehrungO()).getUmrechnungsfaktor();
		final float endpreis = jk.getOPreisO()
				* ((Float.valueOf(jk.getMwStO()) / 100) + 1) * faktor;
		final DecimalFormat df = new DecimalFormat("###,##0.00");
		return df.format(endpreis) + " EUR";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalkostenManager#getEndpreisIPO(long)
	 */
	public String getEndpreisIPO(final long journalId) {
		final Journalkosten jk = this.findByJournalId(journalId);
		final float faktor = this.wechselkursDao.findByWaehrung(
				jk.getIWaehrungPO()).getUmrechnungsfaktor();
		final float endpreis = jk.getIPreisPO()
				* ((Float.valueOf(jk.getIMwStPO()) / 100) + 1) * faktor;
		final DecimalFormat df = new DecimalFormat("###,##0.00");
		return df.format(endpreis) + " EUR";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalkostenManager#getEndpreisIP(long)
	 */
	public String getEndpreisIP(final long journalId) {
		final Journalkosten jk = this.findByJournalId(journalId);
		final float faktor = this.wechselkursDao.findByWaehrung(
				jk.getIWaehrungP()).getUmrechnungsfaktor();
		final float endpreis = jk.getIPreisP()
				* ((Float.valueOf(jk.getIMwStP()) / 100) + 1) * faktor;
		final DecimalFormat df = new DecimalFormat("###,##0.00");
		return df.format(endpreis) + " EUR";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.JournalkostenManager#getEndpreisIO(long)
	 */
	public String getEndpreisIO(final long journalId) {
		final Journalkosten jk = this.findByJournalId(journalId);
		final float faktor = this.wechselkursDao.findByWaehrung(
				jk.getIWaehrungO()).getUmrechnungsfaktor();
		final float endpreis = jk.getIPreisO()
				* ((Float.valueOf(jk.getIMwStO()) / 100) + 1) * faktor;
		final DecimalFormat df = new DecimalFormat("###,##0.00");
		return df.format(endpreis) + " EUR";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.JournalkostenManager#saveWithJournal(ejportal.model.
	 * Journalkosten, java.lang.Long)
	 */
	public Journalkosten saveWithJournal(final Journalkosten journalkosten,
			final Long journalId) {
		journalkosten.setJournal(this.journalDao.get(journalId));
		return super.save(journalkosten);
	}
}
