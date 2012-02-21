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

import ejportal.service.SigelManager;
import ejportal.service.dto.SigelSearchTO;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 04.08.2010 Time: 14:47:50 To
 * change this template use File | Settings | File Templates.
 */
public class SigelListAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3054579480511265799L;

	/** The sigel manager. */
	private SigelManager sigelManager;

	/** The sigel search to. */
	private SigelSearchTO sigelSearchTO;

	/** The sigels. */
	private List sigels;

	/** The exemplar id. */
	Long exemplarId; // bei der Zuweisung von Sigel zu Exemplar "merken" und in
						// Ergebnisseite uebernehmen

	/** The interesse id. */
	Long interesseId;

	/** The besteller id. */
	Long bestellerId;

	/** The journal id. */
	Long journalId;

	/**
	 * Gets the exemplar id.
	 * 
	 * @return the exemplar id
	 */
	public long getExemplarId() {
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
	 * Gets the journal id.
	 * 
	 * @return the journal id
	 */
	public Long getJournalId() {
		return this.journalId;
	}

	/**
	 * Sets the journal id.
	 * 
	 * @param journalId
	 *            the new journal id
	 */
	public void setJournalId(final Long journalId) {
		this.journalId = journalId;
	}

	/**
	 * Gets the interesse id.
	 * 
	 * @return the interesse id
	 */
	public Long getInteresseId() {
		return this.interesseId;
	}

	/**
	 * Sets the interesse id.
	 * 
	 * @param interesseId
	 *            the new interesse id
	 */
	public void setInteresseId(final Long interesseId) {
		this.interesseId = interesseId;
	}

	/**
	 * Gets the besteller id.
	 * 
	 * @return the besteller id
	 */
	public Long getBestellerId() {
		return this.bestellerId;
	}

	/**
	 * Sets the besteller id.
	 * 
	 * @param bestellerId
	 *            the new besteller id
	 */
	public void setBestellerId(final Long bestellerId) {
		this.bestellerId = bestellerId;
	}

	/**
	 * Sets the sigel manager.
	 * 
	 * @param sigelManager
	 *            the new sigel manager
	 */
	public void setSigelManager(final SigelManager sigelManager) {
		this.sigelManager = sigelManager;
	}

	/**
	 * Gets the sigels.
	 * 
	 * @return the sigels
	 */
	public List getSigels() {
		return this.sigels;
	}

	/**
	 * List all.
	 * 
	 * @return the string
	 */
	public String listAll() {
		this.sigels = this.sigelManager.getAll();
		return Action.SUCCESS;
	}

	// Suche

	/**
	 * Gets the sigel search to.
	 * 
	 * @return the sigel search to
	 */
	public SigelSearchTO getSigelSearchTO() {
		return this.sigelSearchTO;
	}

	/**
	 * Sets the sigel search to.
	 * 
	 * @param sigelSearchTO
	 *            the new sigel search to
	 */
	public void setSigelSearchTO(final SigelSearchTO sigelSearchTO) {
		this.sigelSearchTO = sigelSearchTO;
	}

	/**
	 * Search.
	 * 
	 * @return the string
	 */
	public String search() {
		final int maxResults = 100;
		this.sigels = this.sigelManager.findBySearchTO(this.sigelSearchTO,
				maxResults);

		if (this.sigels.size() == maxResults) {
			// TODO Konsortien???
			this.saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als "
					+ this.sigels.size() + " Konsortien gefunden wurden.");
			this.saveMessage("Die ersten " + maxResults
					+ " Ergebnisse werden angezeigt.");
		}
		// TODO Fehlerbehandlung Suche
		return Action.SUCCESS;
	}

	// fuer neue Zuweisung zu Exemplar
	/**
	 * Sets the exemplar id.
	 * 
	 * @param exemplarId
	 *            the new exemplar id
	 */
	public void setExemplarId(final long exemplarId) {
		this.exemplarId = exemplarId;
	}

}
