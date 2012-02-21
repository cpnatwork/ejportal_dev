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
package ejportal.webapp.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import ejportal.service.InstitutionManager;
import ejportal.service.dto.InstitutionSearchTO;

/**
 * Created by IntelliJ IDEA. User: Florian Date: 29.06.2010 Time: 13:09:46 To
 * change this template use File | Settings | File Templates.
 */
public class InstitutionListAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3641198922886602319L;

	/** The institution manager. */
	private InstitutionManager institutionManager;

	/** The institution search to. */
	private InstitutionSearchTO institutionSearchTO;

	/** The institutions. */
	private List institutions;

	// fuer die Suche
	/** The institution name. */
	String institutionName;

	/** The exemplar id. */
	Long exemplarId;

	/**
	 * Gets the exemplar id.
	 * 
	 * @return the exemplar id
	 */
	public Long getExemplarId() {
		return this.exemplarId;
	}

	/**
	 * Sets the exemplar id.
	 * 
	 * @param exemplarId
	 *            the new exemplar id
	 */
	public void setExemplarId(final Long exemplarId) {
		this.exemplarId = exemplarId;
	}

	/**
	 * Sets the institution manager.
	 * 
	 * @param institutionManager
	 *            the new institution manager
	 */
	public void setInstitutionManager(
			final InstitutionManager institutionManager) {
		this.institutionManager = institutionManager;
	}

	/**
	 * List all.
	 * 
	 * @return the string
	 */
	public String listAll() {
		this.institutions = this.institutionManager.getAll();
		return Action.SUCCESS;
	}

	/**
	 * Gets the institutions.
	 * 
	 * @return the institutions
	 */
	public List getInstitutions() {
		return this.institutions;
	}

	// Suche
	/**
	 * Sets the institution name.
	 * 
	 * @param institutionName
	 *            the new institution name
	 */
	public void setInstitutionName(final String institutionName) {
		this.institutionName = institutionName;
	}

	/**
	 * Gets the institution search to.
	 * 
	 * @return the institution search to
	 */
	public InstitutionSearchTO getInstitutionSearchTO() {
		return this.institutionSearchTO;
	}

	/**
	 * Sets the institution search to.
	 * 
	 * @param institutionSearchTO
	 *            the new institution search to
	 */
	public void setInstitutionSearchTO(
			final InstitutionSearchTO institutionSearchTO) {
		this.institutionSearchTO = institutionSearchTO;
	}

	/**
	 * Search.
	 * 
	 * @return the string
	 */
	public String search() {
		final int maxResults = 100;
		this.institutions = this.institutionManager.search(
				this.institutionSearchTO, maxResults);
		if (this.institutions.size() == maxResults) {
			this.saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als "
					+ this.institutions.size()
					+ " Institutionen gefunden wurden.");
			this.saveMessage("Die ersten " + maxResults
					+ " Ergebnisse werden angezeigt.");
		}
		// TODO Fehlerbehandlung
		return Action.SUCCESS;
	}

	// fuer neue Zuweisung zu Journal
	/*
	 * (non-Javadoc)
	 * 
	 * @see ejportal.webapp.action.JournalBaseAction#setJournalId(long)
	 */
	@Override
	public void setJournalId(final long journalId) {
		this.journalId = journalId;
	}

}
