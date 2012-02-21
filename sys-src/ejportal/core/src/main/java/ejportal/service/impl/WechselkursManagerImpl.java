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

import org.appfuse.service.impl.GenericManagerImpl;

import ejportal.dao.WechselkursDao;
import ejportal.model.Wechselkurs;
import ejportal.service.WechselkursManager;

/**
 * Created by IntelliJ IDEA. User: ag35ogub Date: 11.08.2010 Time: 12:43:59 To
 * change this template use File | Settings | File Templates.
 */
public class WechselkursManagerImpl extends
		GenericManagerImpl<Wechselkurs, Long> implements WechselkursManager {

	/** The wechselkurs dao. */
	private final WechselkursDao wechselkursDao;

	/**
	 * Instantiates a new wechselkurs manager impl.
	 * 
	 * @param wechselkursDao
	 *            the wechselkurs dao
	 */
	public WechselkursManagerImpl(final WechselkursDao wechselkursDao) {
		super(wechselkursDao);
		this.wechselkursDao = wechselkursDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.service.WechselkursManager#findByWaehrung(java.lang.String)
	 */
	public Wechselkurs findByWaehrung(final String waehrung) {
		return this.wechselkursDao.findByWaehrung(waehrung);
	}
}
