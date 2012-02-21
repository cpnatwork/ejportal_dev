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

import ejportal.dao.BibliotheksmitarbeiterDao;
import ejportal.model.Bibliotheksmitarbeiter;
import ejportal.service.dto.BibliotheksmitarbeiterSearchTO;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 14:58:16 To
 * change this template use File | Settings | File Templates.
 */
@Repository("bibliotheksmitarbeiterDao")
public class BibliotheksmitarbeiterDaoHibernate extends
		GenericDaoHibernate<Bibliotheksmitarbeiter, Long> implements
		BibliotheksmitarbeiterDao {

	/**
	 * Instantiates a new bibliotheksmitarbeiter dao hibernate.
	 */
	public BibliotheksmitarbeiterDaoHibernate() {
		super(Bibliotheksmitarbeiter.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.BibliotheksmitarbeiterDao#findByName(java.lang.String)
	 */
	public List<Bibliotheksmitarbeiter> findByName(final String name) {
		return this.getHibernateTemplate().find(
				"from Bibliotheksmitarbeiter where name=?", name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.dao.BibliotheksmitarbeiterDao#findByAbteilungsHauptstelle(java
	 * .lang.String)
	 */
	public List<Bibliotheksmitarbeiter> findByAbteilungsHauptstelle(
			final String abteilungsHauptstelle) {
		return this.getHibernateTemplate().find(
				"from Bibliotheksmitarbeiter where abteilungsHauptstelle=?",
				abteilungsHauptstelle);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.dao.BibliotheksmitarbeiterDao#findByEmailanschrift(java.lang
	 * .String)
	 */
	public List<Bibliotheksmitarbeiter> findByEmailanschrift(
			final String emailanschrift) {
		return this.getHibernateTemplate().find(
				"from Bibliotheksmitarbeiter where emailanschrift=?",
				emailanschrift);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.dao.BibliotheksmitarbeiterDao#findBySearchTO(ejportal.service
	 * .dto.BibliotheksmitarbeiterSearchTO)
	 */
	public List<Bibliotheksmitarbeiter> findBySearchTO(
			final BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO) {
		return this.findBySearchTO(bibliotheksmitarbeiterSearchTO, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.dao.BibliotheksmitarbeiterDao#findBySearchTO(ejportal.service
	 * .dto.BibliotheksmitarbeiterSearchTO, java.lang.Integer)
	 */
	public List<Bibliotheksmitarbeiter> findBySearchTO(
			final BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO,
			final Integer maxResults) {
		final Session session = this.getSessionFactory().openSession();
		List searchResult = null;
		try {
			final Criteria criteria = session
					.createCriteria(Bibliotheksmitarbeiter.class);
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

			criteria.setFirstResult(0);
			if (maxResults != null) {
				criteria.setMaxResults(maxResults);
			}

			if (!bibliotheksmitarbeiterSearchTO.getName().equals("")) {
				criteria.add(Restrictions.like("name",
						"%" + bibliotheksmitarbeiterSearchTO.getName() + "%")
						.ignoreCase());
			}
			if (!bibliotheksmitarbeiterSearchTO.getAbteilungsHauptstelle()
					.equals("")) {
				criteria.add(Restrictions.like(
						"abteilungsHauptstelle",
						"%"
								+ bibliotheksmitarbeiterSearchTO
										.getAbteilungsHauptstelle() + "%")
						.ignoreCase());
			}
			if (!bibliotheksmitarbeiterSearchTO.getEmailanschrift().equals("")) {
				criteria.add(Restrictions.like(
						"emailanschrift",
						"%"
								+ bibliotheksmitarbeiterSearchTO
										.getEmailanschrift() + "%")
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
