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

import java.util.Map;

import com.opensymphony.xwork2.Action;

import ejportal.model.Journalkosten;
import ejportal.service.JournalkostenManager;

/**
 * Created by IntelliJ IDEA. User: ag35ogub Date: 09.08.2010 Time: 16:01:26 To
 * change this template use File | Settings | File Templates.
 */
public class JournalkostenAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6930679054320941050L;

	/** The journalkosten manager. */
	private JournalkostenManager journalkostenManager;

	/** The journalkosten. */
	private Journalkosten journalkosten;

	/** The journalkosten id. */
	private Long journalkostenId;

	/** The select data. */
	private final SelectData selectData = new SelectData();

	/* GETTER UND SETTER */
	/**
	 * Gets the journalkosten manager.
	 * 
	 * @return the journalkosten manager
	 */
	public JournalkostenManager getJournalkostenManager() {
		return this.journalkostenManager;
	}

	/**
	 * Sets the journalkosten manager.
	 * 
	 * @param journalkostenManager
	 *            the new journalkosten manager
	 */
	public void setJournalkostenManager(
			final JournalkostenManager journalkostenManager) {
		this.journalkostenManager = journalkostenManager;
	}

	/**
	 * Gets the journalkosten.
	 * 
	 * @return the journalkosten
	 */
	public Journalkosten getJournalkosten() {
		return this.journalkosten;
	}

	/**
	 * Sets the journalkosten.
	 * 
	 * @param journalkosten
	 *            the new journalkosten
	 */
	public void setJournalkosten(final Journalkosten journalkosten) {
		this.journalkosten = journalkosten;
	}

	/**
	 * Gets the journalkosten id.
	 * 
	 * @return the journalkosten id
	 */
	public Long getJournalkostenId() {
		return this.journalkostenId;
	}

	/**
	 * Sets the journalkosten id.
	 * 
	 * @param journalkostenId
	 *            the new journalkosten id
	 */
	public void setJournalkostenId(final Long journalkostenId) {
		this.journalkostenId = journalkostenId;
	}

	// Lists
	/**
	 * Gets the list waehrung.
	 * 
	 * @return the list waehrung
	 */
	public Map<String, String> getListWaehrung() {
		return this.selectData.getProjektWaehrung();
	}

	/**
	 * Gets the list mw st.
	 * 
	 * @return the list mw st
	 */
	public Map<String, String> getListMwSt() {
		return this.selectData.getProjektMwSt();
	}

	// CRUD
	/**
	 * Edits the.
	 * 
	 * @return the string
	 */
	public String edit() {

		this.journalkosten = this.journalkostenManager
				.findByJournalId(this.journalId);

		return "edit";
	}

	/**
	 * Save.
	 * 
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public String save() throws Exception {
		if (this.cancel != null)
			return BaseAction.CANCEL;

		this.journalkosten = this.journalkostenManager.saveWithJournal(
				this.journalkosten, this.journalId);

		this.saveMessage("Journalkosten wurden erfolgreich aktualisiert.");

		return Action.SUCCESS;
	}

}
