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

import ejportal.dao.PaketDao;
import ejportal.model.Paket;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 16:06:57 To
 * change this template use File | Settings | File Templates.
 */
@Repository("paketDao")
public class PaketDaoHibernate extends GenericDaoHibernate<Paket, Long>
		implements PaketDao {

	/**
	 * Instantiates a new paket dao hibernate.
	 */
	public PaketDaoHibernate() {
		super(Paket.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.PaketDao#findByPaketName(java.lang.String)
	 */
	public List<Paket> findByPaketName(final String paketName) {
		return this.findByPaketName(paketName, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.PaketDao#findByPaketName(java.lang.String,
	 * java.lang.Integer)
	 */
	public List<Paket> findByPaketName(final String paketName,
			final Integer maxResults) {
		final Session session = this.getSessionFactory().openSession();
		List searchResult = null;
		try {
			final Criteria criteria = session.createCriteria(Paket.class);
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

			criteria.setFirstResult(0);
			if (maxResults != null) {
				criteria.setMaxResults(maxResults);
			}

			if (!paketName.equals("")) {
				criteria.add(Restrictions.like("paketName",
						"%" + paketName + "%").ignoreCase());
			}

			searchResult = criteria.list();
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return searchResult;

		// return getHibernateTemplate().find("from Paket where paketName=?",
		// paketName);
	}
}
