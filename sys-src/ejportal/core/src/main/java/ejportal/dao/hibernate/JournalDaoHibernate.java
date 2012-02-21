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

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 13:53:05
 * To change this template use File | Settings | File Templates.
 */

import java.util.Date;
import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ejportal.dao.JournalDao;
import ejportal.model.Journal;
import ejportal.service.dto.JournalSearchTO;

/**
 * The Class JournalDaoHibernate.
 */
@Repository("journalDao")
public class JournalDaoHibernate extends GenericDaoHibernate<Journal, Long>
		implements JournalDao {

	/**
	 * Instantiates a new journal dao hibernate.
	 */
	public JournalDaoHibernate() {
		super(Journal.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.JournalDao#findByTitel(java.lang.String)
	 */
	public List<Journal> findByTitel(final String titel) {
		return this.getHibernateTemplate().find("from Journal where titel=?",
				titel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.JournalDao#findByKurztitel(java.lang.String)
	 */
	public List<Journal> findByKurztitel(final String kurztitel) {
		return this.getHibernateTemplate().find(
				"from Journal where kurztitel=?", kurztitel);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.JournalDao#findByVerlag(int)
	 */
	public List<Journal> findByVerlag(final int verlagId) {
		return this.getHibernateTemplate().find(
				"from Journal where verlag_id=?", verlagId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.JournalDao#findByBearbeitungsdatum(java.util.Date)
	 */
	public List<Journal> findByBearbeitungsdatum(final Date maxDate) {
		return this.getHibernateTemplate().find(
				"from Journal where bearbeitungsdatum<?", maxDate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.JournalDao#findByBearbeitungsdatumAll()
	 */
	public List<Journal> findByBearbeitungsdatumAll() {
		return this.getHibernateTemplate().find(
				"from Journal where bearbeitungsdatum != null");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.dao.JournalDao#findByZugangUeber(java.lang.String)
	 */
	public List<Journal> findByZugangUeber(final String zugangUeber) {
		return this.getHibernateTemplate().find(
				"from Journal where zugangUeber=? ", zugangUeber);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.dao.JournalDao#findBySearchTO(ejportal.service.dto.JournalSearchTO
	 * )
	 */
	public List<Journal> findBySearchTO(final JournalSearchTO journalSearchTO) {
		return this.findBySearchTO(journalSearchTO, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ejportal.dao.JournalDao#findBySearchTO(ejportal.service.dto.JournalSearchTO
	 * , java.lang.Integer)
	 */
	public List<Journal> findBySearchTO(final JournalSearchTO journalSearchTO,
			final Integer maxResults) {
		final Session session = this.getSessionFactory().openSession();
		List searchResult = null;
		try {
			final Criteria criteria = session.createCriteria(Journal.class);
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

			criteria.setFirstResult(0);
			if (maxResults != null) {
				criteria.setMaxResults(maxResults);
			}

			if (!journalSearchTO.getTitel().equals("")) {
				criteria.add(Restrictions.like("titel",
						"%" + journalSearchTO.getTitel() + "%").ignoreCase());
			}
			if (!journalSearchTO.getKurztitel().equals("")) {
				criteria.add(Restrictions.like("kurztitel",
						"%" + journalSearchTO.getKurztitel() + "%")
						.ignoreCase());
			}
			if (!journalSearchTO.getVerlag().equals("")) {
				criteria.createAlias("verlag", "vl").add(
						Restrictions.like("vl.name",
								"%" + journalSearchTO.getVerlag() + "%")
								.ignoreCase());
			}
			if (!journalSearchTO.getProvider().equals("")) {
				criteria.createAlias("provider", "pr").add(
						Restrictions.like("pr.name",
								"%" + journalSearchTO.getProvider() + "%")
								.ignoreCase());
			}
			if (!journalSearchTO.getKonsortium().equals("")) {
				criteria.createAlias("konsortium", "ko").add(
						Restrictions.like("ko.konsortiumName",
								"%" + journalSearchTO.getKonsortium() + "%")
								.ignoreCase());
			}
			if (!journalSearchTO.getPaket().equals("")) {
				criteria.createAlias("paket", "pk").add(
						Restrictions.like("pk.paketName",
								"%" + journalSearchTO.getPaket() + "%")
								.ignoreCase());
			}
			if (!journalSearchTO.getZugangUeber().equals("")) {
				criteria.add(Restrictions.like("zugangUeber",
						"%" + journalSearchTO.getZugangUeber() + "%")
						.ignoreCase());
			}
			searchResult = criteria.list();
		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return searchResult;
		// return getHibernateTemplate().find("from Journal where kurztitel=?",
		// journalSearchTO.getKurztitel());
		// return null; //To change body of implemented methods use File |
		// Settings | File Templates.
	}
	/*
	 * public List<Journal> findByIssn(String issn) { return
	 * getHibernateTemplate().find("from Journal where issn=?", issn); }
	 * 
	 * public List<Journal> findByIssnPrint(String issnPrint) { return
	 * getHibernateTemplate().find("from Journal where issnPrint=?", issnPrint);
	 * }
	 */
}
