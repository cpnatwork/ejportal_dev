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
package ejportal.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

import ejportal.dao.InteresseDao;
import ejportal.model.Interesse;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 16:11:07 To
 * change this template use File | Settings | File Templates.
 */
@Repository("interesseDao")
public class InteresseDaoHibernate extends GenericDaoHibernate<Interesse, Long>
		implements InteresseDao {

	/**
	 * Instantiates a new interesse dao hibernate.
	 */
	public InteresseDaoHibernate() {
		super(Interesse.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.InteresseDao#findByJournalId(java.lang.Long)
	 */
	public List<Interesse> findByJournalId(final Long journalId) {
		return this.getHibernateTemplate().find(
				"from Interesse where Journal_id=?", journalId);
	}
}