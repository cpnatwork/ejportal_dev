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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ejportal.dao.KonsortiumDao;
import ejportal.model.Konsortium;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 16:07:56 To
 * change this template use File | Settings | File Templates.
 */
@Repository("konsortiumDao")
public class KonsortiumDaoHibernate extends
		GenericDaoHibernate<Konsortium, Long> implements KonsortiumDao {

	/**
	 * Instantiates a new konsortium dao hibernate.
	 */
	public KonsortiumDaoHibernate() {
		super(Konsortium.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.KonsortiumDao#findByKonsortiumName(java.lang.String)
	 */
	public List<Konsortium> findByKonsortiumName(final String konsortiumName) {
		return this.findByKonsortiumName(konsortiumName, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.KonsortiumDao#findByKonsortiumName(java.lang.String,
	 * java.lang.Integer)
	 */
	public List<Konsortium> findByKonsortiumName(final String konsortiumName,
			final Integer maxResults) {
		final Session session = this.getSessionFactory().openSession();
		List searchResult = null;
		try {
			final Criteria criteria = session.createCriteria(Konsortium.class);
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

			criteria.setFirstResult(0);
			if (maxResults != null) {
				criteria.setMaxResults(maxResults);
			}

			if (!konsortiumName.equals("")) {
				criteria.add(Restrictions.like("konsortiumName",
						"%" + konsortiumName + "%").ignoreCase());
			}

			searchResult = criteria.list();
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return searchResult;

		// return
		// getHibernateTemplate().find("from Konsortium where konsortiumName=?",
		// konsortiumName);
	}
}