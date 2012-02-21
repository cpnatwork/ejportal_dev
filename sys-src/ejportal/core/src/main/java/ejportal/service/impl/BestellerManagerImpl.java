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
import ejportal.dao.SigelDao;
import ejportal.model.Besteller;
import ejportal.service.BestellerManager;
import ejportal.service.dto.BestellerBaseTO;
import ejportal.service.dto.BestellerSearchTO;
import ejportal.util.BeanUtil;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 16:14:50 To
 * change this template use File | Settings | File Templates.
 */
public class BestellerManagerImpl extends GenericManagerImpl<Besteller, Long>
		implements BestellerManager {

	/** The besteller dao. */
	private final BestellerDao bestellerDao;

	/** The interesse dao. */
	private final InteresseDao interesseDao;

	/** The sigel dao. */
	private final SigelDao sigelDao;

	/** The bean util. */
	private final BeanUtil beanUtil;

	/**
	 * Instantiates a new besteller manager impl.
	 * 
	 * @param bestellerDao
	 *            the besteller dao
	 * @param interesseDao
	 *            the interesse dao
	 * @param sigelDao
	 *            the sigel dao
	 */
	public BestellerManagerImpl(final BestellerDao bestellerDao,
			final InteresseDao interesseDao, final SigelDao sigelDao) {
		super(bestellerDao);
		this.bestellerDao = bestellerDao;
		this.interesseDao = interesseDao;
		this.sigelDao = sigelDao;
		this.beanUtil = new BeanUtil();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.BestellerManager#search(ejportal.service.dto.
	 * BestellerSearchTO, java.lang.Integer)
	 */
	public List<Besteller> search(final BestellerSearchTO bestellerSearchTO,
			final Integer maxResults) {
		return this.bestellerDao.findBySearchTO(bestellerSearchTO, maxResults);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.BestellerManager#connectBestellerSigel(long, long)
	 */
	public void connectBestellerSigel(final long bestellerId, final long sigelId) {
		final Besteller besteller = this.bestellerDao.get(bestellerId);
		besteller.setSigel(this.sigelDao.get(sigelId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.BestellerManager#getBestellerBaseTO(long)
	 */
	public BestellerBaseTO getBestellerBaseTO(final long bestellerId) {
		// TODO Fehlerbehandlung
		final Besteller besteller = this.bestellerDao.get(bestellerId);
		final BestellerBaseTO bestellerBaseTO = new BestellerBaseTO();

		try {
			// here comes the reflection voodoo ;-)
			this.beanUtil.copyEntityToBaseTO(besteller, bestellerBaseTO);
			// jetzt sind im bestellerBaseTO alle Attribute von besteller OHNE
			// die Beziehungen!
		} catch (final Exception e) {
			// TODO Fehlerbehandlung
			e.printStackTrace();
		}
		return bestellerBaseTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.BestellerManager#saveBaseTO(ejportal.service.dto.
	 * BestellerBaseTO)
	 */
	public Besteller saveBaseTO(final BestellerBaseTO bestellerBaseTO) {
		// erst mal den Besteller holen
		Besteller besteller = this.bestellerDao.get(bestellerBaseTO
				.getBestellerId());
		try {
			// mit reflection voodoo die Daten vom bestellerBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(bestellerBaseTO, besteller);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace();
		}

		besteller = this.save(besteller);
		return besteller;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.BestellerManager#create(ejportal.service.dto.BestellerBaseTO
	 * )
	 */
	public Besteller create(final BestellerBaseTO bestellerBaseTO) {

		// Neuen Besteller erstellen
		Besteller besteller = new Besteller();

		// Attribute aus dem BaseTO füllen
		try {
			// mit reflection voodoo die Daten vom bestellerBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(bestellerBaseTO, besteller);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace();
		}

		// Speichern und gut is!
		besteller = this.save(besteller);
		return besteller;
	}
}
