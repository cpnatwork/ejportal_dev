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
import ejportal.dao.LizenzdetailDao;
import ejportal.model.Lizenzdetail;
import ejportal.service.LizenzdetailManager;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 16:19:48 To
 * change this template use File | Settings | File Templates.
 */
public class LizenzdetailManagerImpl extends
		GenericManagerImpl<Lizenzdetail, Long> implements LizenzdetailManager {

	/** The lizenzdetail dao. */
	private final LizenzdetailDao lizenzdetailDao;

	/** The institution dao. */
	private final InstitutionDao institutionDao;

	/**
	 * Instantiates a new lizenzdetail manager impl.
	 * 
	 * @param lizenzdetailDao
	 *            the lizenzdetail dao
	 * @param institutionDao
	 *            the institution dao
	 */
	public LizenzdetailManagerImpl(final LizenzdetailDao lizenzdetailDao,
			final InstitutionDao institutionDao) {
		super(lizenzdetailDao);
		this.lizenzdetailDao = lizenzdetailDao;
		this.institutionDao = institutionDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.LizenzdetailManager#findByVerlagId(long)
	 */
	public List<Lizenzdetail> findByVerlagId(final long verlagId) {
		return this.lizenzdetailDao.findByVerlag(verlagId);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.service.LizenzdetailManager#saveWithInstitution(ejportal.model
	 * .Lizenzdetail, java.lang.Long)
	 */
	public Lizenzdetail saveWithInstitution(final Lizenzdetail lizenzdetail,
			final Long institutionId) {
		lizenzdetail.setVerlag(this.institutionDao.get(institutionId));
		return super.save(lizenzdetail);
	}
}
