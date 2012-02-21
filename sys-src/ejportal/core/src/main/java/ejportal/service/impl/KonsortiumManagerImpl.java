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

import ejportal.dao.KonsortiumDao;
import ejportal.model.Konsortium;
import ejportal.service.KonsortiumManager;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 16:19:05 To
 * change this template use File | Settings | File Templates.
 */
public class KonsortiumManagerImpl extends GenericManagerImpl<Konsortium, Long>
		implements KonsortiumManager {

	/** The konsortium dao. */
	private final KonsortiumDao konsortiumDao;

	/**
	 * Instantiates a new konsortium manager impl.
	 * 
	 * @param konsortiumDao
	 *            the konsortium dao
	 */
	public KonsortiumManagerImpl(final KonsortiumDao konsortiumDao) {
		super(konsortiumDao);
		this.konsortiumDao = konsortiumDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.KonsortiumManager#findByKonsortiumName(java.lang.String)
	 */
	public List<Konsortium> findByKonsortiumName(final String konsortiumName) {
		return this.konsortiumDao.findByKonsortiumName(konsortiumName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.KonsortiumManager#findByKonsortiumName(java.lang.String,
	 * java.lang.Integer)
	 */
	public List<Konsortium> findByKonsortiumName(final String konsortiumName,
			final Integer maxResults) {
		return this.konsortiumDao.findByKonsortiumName(konsortiumName,
				maxResults);
	}

}
