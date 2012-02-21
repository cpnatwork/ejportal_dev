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

import ejportal.dao.SigelDao;
import ejportal.model.Sigel;
import ejportal.service.SigelManager;
import ejportal.service.dto.SigelSearchTO;

/**
 * Created by IntelliJ IDEA. User: Chris Date: 28.06.2010 Time: 15:54:42 To
 * change this template use File | Settings | File Templates.
 */
public class SigelManagerImpl extends GenericManagerImpl<Sigel, Long> implements
		SigelManager {

	/** The sigel dao. */
	private final SigelDao sigelDao;

	/**
	 * Instantiates a new sigel manager impl.
	 * 
	 * @param sigelDao
	 *            the sigel dao
	 */
	public SigelManagerImpl(final SigelDao sigelDao) {
		super(sigelDao);
		this.sigelDao = sigelDao;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.SigelManager#findBySearchTO(ejportal.service.dto.
	 * SigelSearchTO)
	 */
	public List<Sigel> findBySearchTO(final SigelSearchTO sigelSearchTO) {
		return this.sigelDao.findBySearchTO(sigelSearchTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.SigelManager#findBySearchTO(ejportal.service.dto.
	 * SigelSearchTO, java.lang.Integer)
	 */
	public List<Sigel> findBySearchTO(final SigelSearchTO sigelSearchTO,
			final Integer maxResults) {
		return this.sigelDao.findBySearchTO(sigelSearchTO, maxResults);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.SigelManager#findByName(java.lang.String)
	 */
	public List<Sigel> findByName(final String name) {
		return this.sigelDao.findByName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.SigelManager#findByBibliothek(java.lang.String)
	 */
	public List<Sigel> findByBibliothek(final String bibliothek) {
		return this.sigelDao.findByBibliothek(bibliothek);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.SigelManager#findByFakultaet(java.lang.String)
	 */
	public List<Sigel> findByFakultaet(final String fakultaet) {
		return this.sigelDao.findByFakultaet(fakultaet);
	}
}
