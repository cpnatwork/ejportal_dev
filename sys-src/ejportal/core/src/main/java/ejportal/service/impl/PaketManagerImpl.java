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

import ejportal.dao.PaketDao;
import ejportal.model.Paket;
import ejportal.service.PaketManager;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 16:18:27 To
 * change this template use File | Settings | File Templates.
 */
public class PaketManagerImpl extends GenericManagerImpl<Paket, Long> implements
		PaketManager {

	/** The paket dao. */
	private final PaketDao paketDao;

	/**
	 * Instantiates a new paket manager impl.
	 * 
	 * @param paketDao
	 *            the paket dao
	 */
	public PaketManagerImpl(final PaketDao paketDao) {
		super(paketDao);
		this.paketDao = paketDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.PaketManager#findByPaketName(java.lang.String)
	 */
	public List<Paket> findByPaketName(final String paketName) {
		return this.paketDao.findByPaketName(paketName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.PaketManager#findByPaketName(java.lang.String,
	 * java.lang.Integer)
	 */
	public List<Paket> findByPaketName(final String paketName,
			final Integer maxResults) {
		return this.paketDao.findByPaketName(paketName, maxResults);
	}

}
