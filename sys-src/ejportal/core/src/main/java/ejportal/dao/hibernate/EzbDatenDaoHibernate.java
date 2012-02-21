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

import ejportal.dao.EzbDatenDao;
import ejportal.model.EzbDaten;
import ejportal.service.dto.EzbDatenSearchTO;

/**
 * Created by IntelliJ IDEA. User: Florian Date: 09.08.2010 Time: 18:14:09 To
 * change this template use File | Settings | File Templates.
 */
@Repository("ezbDatenDao")
public class EzbDatenDaoHibernate extends GenericDaoHibernate<EzbDaten, Long>
		implements EzbDatenDao {

	/**
	 * Instantiates a new ezb daten dao hibernate.
	 */
	public EzbDatenDaoHibernate() {
		super(EzbDaten.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.dao.EzbDatenDao#findBySearchTO(ejportal.service.dto.EzbDatenSearchTO
	 * , java.lang.Integer)
	 */
	public List<EzbDaten> findBySearchTO(
			final EzbDatenSearchTO ezbDatenSearchTO, final Integer maxResults) {
		final Session session = this.getSessionFactory().openSession();
		List searchResult = null;
		try {
			final Criteria criteria = session.createCriteria(EzbDaten.class);
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

			criteria.setFirstResult(0);
			if (maxResults != null) {
				criteria.setMaxResults(maxResults);
			}

			if (!ezbDatenSearchTO.getEzbId().equals("")) {
				try {
					final long ezbId = Long.parseLong(ezbDatenSearchTO
							.getEzbId());
					criteria.add(Restrictions.eq("ezbId", ezbId));
				} catch (final NumberFormatException e) {
					// das war wohl nix
					e.printStackTrace();
				}
			}

			if (!ezbDatenSearchTO.getTitel().equals("")) {
				criteria.add(Restrictions.like("titel",
						"%" + ezbDatenSearchTO.getTitel() + "%").ignoreCase());
			}
			if (!ezbDatenSearchTO.getZdbNummer().equals("")) {
				criteria.add(Restrictions.like("zdbNummer",
						"%" + ezbDatenSearchTO.getZdbNummer() + "%")
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
