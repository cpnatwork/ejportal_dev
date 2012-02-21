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

import ejportal.dao.BestellerDao;
import ejportal.model.Besteller;
import ejportal.service.dto.BestellerSearchTO;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 16:08:32 To
 * change this template use File | Settings | File Templates.
 */
@Repository("bestellerDao")
public class BestellerDaoHibernate extends GenericDaoHibernate<Besteller, Long>
		implements BestellerDao {

	/**
	 * Instantiates a new besteller dao hibernate.
	 */
	public BestellerDaoHibernate() {
		super(Besteller.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.BestellerDao#findByBestellerId(java.lang.Long)
	 */
	public List<Besteller> findByBestellerId(final Long bestellerId) {
		return this.getHibernateTemplate().find(
				"from Besteller where bestellerId=?", bestellerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.BestellerDao#findBySearchTO(ejportal.service.dto.
	 * BestellerSearchTO, java.lang.Integer)
	 */
	public List<Besteller> findBySearchTO(
			final BestellerSearchTO bestellerSearchTO, final Integer maxResults) {
		final Session session = this.getSessionFactory().openSession();
		List searchResult = null;
		try {
			final Criteria criteria = session.createCriteria(Besteller.class);
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

			criteria.setFirstResult(0);
			if (maxResults != null) {
				criteria.setMaxResults(maxResults);
			}

			if (!bestellerSearchTO.getBestellerName().equals("")) {
				criteria.add(Restrictions.like("bestellerName",
						"%" + bestellerSearchTO.getBestellerName() + "%")
						.ignoreCase());
			}

			if (!bestellerSearchTO.getProjekt().equals("")) {
				criteria.add(Restrictions.like("projekt",
						"%" + bestellerSearchTO.getProjekt() + "%")
						.ignoreCase());
			}

			searchResult = criteria.list();
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return searchResult;
	}
}