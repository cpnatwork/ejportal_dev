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

import ejportal.dao.SigelDao;
import ejportal.model.Sigel;
import ejportal.service.dto.SigelSearchTO;

/**
 * Created by IntelliJ IDEA. User: Chris Date: 28.06.2010 Time: 15:44:35 To
 * change this template use File | Settings | File Templates.
 */

@Repository("sigelDao")
public class SigelDaoHibernate extends GenericDaoHibernate<Sigel, Long>
		implements SigelDao {

	/**
	 * Instantiates a new sigel dao hibernate.
	 */
	public SigelDaoHibernate() {
		super(Sigel.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.SigelDao#findByName(java.lang.String)
	 */
	public List<Sigel> findByName(final String name) {
		return this.getHibernateTemplate()
				.find("from Sigel where name=?", name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.SigelDao#findByBibliothek(java.lang.String)
	 */
	public List<Sigel> findByBibliothek(final String bibliothek) {
		return this.getHibernateTemplate().find(
				"from Sigel where bibliothek=?", bibliothek);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.SigelDao#findByFakultaet(java.lang.String)
	 */
	public List<Sigel> findByFakultaet(final String fakultaet) {
		return this.getHibernateTemplate().find("from Sigel where fakultaet=?",
				fakultaet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.dao.SigelDao#findBySearchTO(ejportal.service.dto.SigelSearchTO)
	 */
	public List<Sigel> findBySearchTO(final SigelSearchTO sigelSearchTO) {
		return this.findBySearchTO(sigelSearchTO, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.dao.SigelDao#findBySearchTO(ejportal.service.dto.SigelSearchTO,
	 * java.lang.Integer)
	 */
	public List<Sigel> findBySearchTO(final SigelSearchTO sigelSearchTO,
			final Integer maxResults) {
		final Session session = this.getSessionFactory().openSession();
		List searchResult = null;
		try {
			final Criteria criteria = session.createCriteria(Sigel.class);
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

			criteria.setFirstResult(0);
			if (maxResults != null) {
				criteria.setMaxResults(maxResults);
			}

			if (!sigelSearchTO.getName().equals("")) {
				criteria.add(Restrictions.like("name",
						"%" + sigelSearchTO.getName() + "%").ignoreCase());
			}
			if (!sigelSearchTO.getBibliothek().equals("")) {
				criteria.add(Restrictions.like("bibliothek",
						"%" + sigelSearchTO.getBibliothek() + "%").ignoreCase());
			}
			if (!sigelSearchTO.getFakultaet().equals("")) {
				criteria.add(Restrictions.like("fakultaet",
						"%" + sigelSearchTO.getFakultaet() + "%").ignoreCase());
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
