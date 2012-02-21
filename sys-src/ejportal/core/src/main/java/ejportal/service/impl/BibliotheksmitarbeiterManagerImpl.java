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

import ejportal.dao.BibliotheksmitarbeiterDao;
import ejportal.model.Bibliotheksmitarbeiter;
import ejportal.service.BibliotheksmitarbeiterManager;
import ejportal.service.dto.BibliotheksmitarbeiterSearchTO;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 15:04:21 To
 * change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterManagerImpl extends
		GenericManagerImpl<Bibliotheksmitarbeiter, Long> implements
		BibliotheksmitarbeiterManager {

	/** The bibliotheksmitarbeiter dao. */
	private final BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao;

	/**
	 * Instantiates a new bibliotheksmitarbeiter manager impl.
	 * 
	 * @param bibliotheksmitarbeiterDao
	 *            the bibliotheksmitarbeiter dao
	 */
	public BibliotheksmitarbeiterManagerImpl(
			final BibliotheksmitarbeiterDao bibliotheksmitarbeiterDao) {
		super(bibliotheksmitarbeiterDao);
		this.bibliotheksmitarbeiterDao = bibliotheksmitarbeiterDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.BibliotheksmitarbeiterManager#findBySearchTO(ejportal
	 * .service.dto.BibliotheksmitarbeiterSearchTO)
	 */
	public List<Bibliotheksmitarbeiter> findBySearchTO(
			final BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO) {
		return this.bibliotheksmitarbeiterDao
				.findBySearchTO(bibliotheksmitarbeiterSearchTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.BibliotheksmitarbeiterManager#findBySearchTO(ejportal
	 * .service.dto.BibliotheksmitarbeiterSearchTO, java.lang.Integer)
	 */
	public List<Bibliotheksmitarbeiter> findBySearchTO(
			final BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO,
			final Integer maxResults) {
		return this.bibliotheksmitarbeiterDao.findBySearchTO(
				bibliotheksmitarbeiterSearchTO, maxResults);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.BibliotheksmitarbeiterManager#findByName(java.lang.String
	 * )
	 */
	public List<Bibliotheksmitarbeiter> findByName(final String name) {
		return this.bibliotheksmitarbeiterDao.findByName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.BibliotheksmitarbeiterManager#findByAbteilungsHauptstelle
	 * (java.lang.String)
	 */
	public List<Bibliotheksmitarbeiter> findByAbteilungsHauptstelle(
			final String abteilungsHauptstelle) {
		return this.bibliotheksmitarbeiterDao
				.findByAbteilungsHauptstelle(abteilungsHauptstelle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.BibliotheksmitarbeiterManager#findByEmailanschrift(java
	 * .lang.String)
	 */
	public List<Bibliotheksmitarbeiter> findByEmailanschrift(
			final String emailanschrift) {
		return this.bibliotheksmitarbeiterDao
				.findByEmailanschrift(emailanschrift);
	}
}
