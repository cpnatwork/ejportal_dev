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

import ejportal.dao.ExemplarDao;
import ejportal.model.Exemplar;

/**
 * Created by IntelliJ IDEA. User: Christoph Date: 14.07.2010 Time: 16:08:03 To
 * change this template use File | Settings | File Templates.
 */
@Repository("exemplarDao")
public class ExemplarDaoHibernate extends GenericDaoHibernate<Exemplar, Long>
		implements ExemplarDao {

	/**
	 * Instantiates a new exemplar dao hibernate.
	 */
	public ExemplarDaoHibernate() {
		super(Exemplar.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.ExemplarDao#getListForJournal(long)
	 */
	public List<Exemplar> getListForJournal(final long journalId) {
		return this.getHibernateTemplate().find(
				"from Exemplar where journal_Id=?", journalId);
	}
}
