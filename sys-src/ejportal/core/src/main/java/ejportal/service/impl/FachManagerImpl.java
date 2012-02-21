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

import ejportal.dao.FachDao;
import ejportal.model.Fach;
import ejportal.service.FachManager;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 16:30:38 To
 * change this template use File | Settings | File Templates.
 */
public class FachManagerImpl extends GenericManagerImpl<Fach, Long> implements
		FachManager {

	/** The fach dao. */
	private final FachDao fachDao;

	/**
	 * Instantiates a new fach manager impl.
	 * 
	 * @param fachDao
	 *            the fach dao
	 */
	public FachManagerImpl(final FachDao fachDao) {
		super(fachDao);
		this.fachDao = fachDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.FachManager#findByFachName(java.lang.String)
	 */
	public List<Fach> findByFachName(final String fachName) {
		return this.fachDao.findByFachName(fachName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.FachManager#findByFachName(java.lang.String,
	 * java.lang.Integer)
	 */
	public List<Fach> findByFachName(final String fachName,
			final Integer maxResults) {
		return this.fachDao.findByFachName(fachName, maxResults);
	}
}
