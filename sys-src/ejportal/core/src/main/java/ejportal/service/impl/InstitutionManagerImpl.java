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

import ejportal.dao.InstitutionDao;
import ejportal.model.Institution;
import ejportal.service.InstitutionManager;
import ejportal.service.dto.InstitutionBaseTO;
import ejportal.service.dto.InstitutionSearchTO;
import ejportal.util.BeanUtil;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 21.06.2010 Time: 12:36:53 To
 * change this template use File | Settings | File Templates.
 */
public class InstitutionManagerImpl extends
		GenericManagerImpl<Institution, Long> implements InstitutionManager {

	/** The institution dao. */
	private final InstitutionDao institutionDao;

	/** The bean util. */
	BeanUtil beanUtil;

	/**
	 * Instantiates a new institution manager impl.
	 * 
	 * @param institutionDao
	 *            the institution dao
	 */
	public InstitutionManagerImpl(final InstitutionDao institutionDao) {
		super(institutionDao);
		this.institutionDao = institutionDao;

		this.beanUtil = new BeanUtil();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.InstitutionManager#search(ejportal.service.dto.
	 * InstitutionSearchTO, java.lang.Integer)
	 */
	public List<Institution> search(
			final InstitutionSearchTO institutionSearchTO,
			final Integer maxResults) {
		return this.institutionDao.findBySearchTO(institutionSearchTO,
				maxResults);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.InstitutionManager#search(ejportal.service.dto.
	 * InstitutionSearchTO)
	 */
	public List<Institution> search(
			final InstitutionSearchTO institutionSearchTO) {
		return this.institutionDao.findBySearchTO(institutionSearchTO); // To
																		// change
																		// body
																		// of
																		// implemented
																		// methods
																		// use
																		// File
																		// |
																		// Settings
																		// |
																		// File
																		// Templates.
	}

	/*
	 * public void connectInstitutionJournal(long institutionId, long journalId)
	 * {
	 * 
	 * }
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.InstitutionManager#getInstitutionBaseTO(long)
	 */
	public InstitutionBaseTO getInstitutionBaseTO(final long id) {
		// TODO Fehlerbehandlung
		final Institution institution = this.institutionDao.get(id);
		final InstitutionBaseTO institutionBaseTO = new InstitutionBaseTO();

		try {
			// here comes the reflection voodoo ;-)
			this.beanUtil.copyEntityToBaseTO(institution, institutionBaseTO);
			// jetzt sind im journalBaseTO alle Attribute von journal OHNE die
			// Beziehungen!
		} catch (final Exception e) {
			// TODO Fehlerbehandlung
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		return institutionBaseTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.InstitutionManager#saveBaseTO(ejportal.service.dto.
	 * InstitutionBaseTO)
	 */
	public Institution saveBaseTO(final InstitutionBaseTO institutionBaseTO) {

		Institution institution = this.institutionDao.get(institutionBaseTO
				.getId());
		try {
			// mit reflection voodoo die Daten vom journalBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(institutionBaseTO, institution);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		institution = this.save(institution);
		return institution;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.InstitutionManager#create(ejportal.service.dto.
	 * InstitutionBaseTO)
	 */
	public Institution create(final InstitutionBaseTO institutionBaseTO) {
		Institution institution = new Institution();
		try {
			// mit reflection voodoo die Daten vom institutionBaseTO uebertragen
			this.beanUtil.copyBaseTOtoEntity(institutionBaseTO, institution);
		} catch (final Exception e) {
			// TODO Exceptionhandling
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		institution = this.save(institution);
		return institution; // To change body of implemented methods use File |
							// Settings | File Templates.
	}

}
