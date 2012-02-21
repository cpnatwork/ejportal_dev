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

import ejportal.dao.RechnungDao;
import ejportal.model.Rechnung;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 09.08.2010 Time: 14:53:53 To
 * change this template use File | Settings | File Templates.
 */
@Repository("rechnungDao")
public class RechnungDaoHibernate extends GenericDaoHibernate<Rechnung, Long>
		implements RechnungDao {

	/**
	 * Instantiates a new rechnung dao hibernate.
	 */
	public RechnungDaoHibernate() {
		super(Rechnung.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.RechnungDao#findByExemplarId(long)
	 */
	public List<Rechnung> findByExemplarId(final long exemplarId) {
		return this.getHibernateTemplate().find(
				"from Rechnung where Exemplar_exemplarId=?", exemplarId);
	}
}
