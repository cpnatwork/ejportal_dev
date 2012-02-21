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

import ejportal.model.Journal;
import ejportal.model.Rechnung;
import ejportal.service.JournalManager;
import ejportal.service.RechnungManager;
import ejportal.service.dto.RechnungBaseTO;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 09.08.2010 Time: 15:55:42 To
 * change this template use File | Settings | File Templates.
 */
public class RechnungAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5522924092728345436L;

	/** The rechnung manager. */
	private RechnungManager rechnungManager;

	/** The journal manager. */
	private JournalManager journalManager;

	/** The rechnung. */
	private Rechnung rechnung;

	/** The journal. */
	private Journal journal;

	/** The rechnung base to. */
	private RechnungBaseTO rechnungBaseTO;

	/** The rechnung id. */
	private Long rechnungId;

	// ExemplarId fürs Menü
	/** The exemplar id. */
	private Long exemplarId;

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

	// List
	/**
	 * Gets the list for exemplar.
	 * 
	 * @return the list for exemplar
	 */
	public List<Rechnung> getListForExemplar() {
		return this.rechnungManager.getListForExemplar(this.exemplarId);
	}

	// CRUD
	/**
	 * Delete.
	 * 
	 * @return the string
	 */
	public String delete() {
		this.rechnungManager.remove(this.rechnungId);
		this.saveMessage("Rechnung wurde erfolgreich entfernt.");

		return Action.SUCCESS;
	}

	/**
	 * Load.
	 * 
	 * @return the string
	 */
	public String load() {
		if (this.rechnungId != null) {
			this.rechnung = this.rechnungManager.get(this.rechnungId);
		} else
			return Action.ERROR;

		return Action.SUCCESS;
	}

	/**
	 * Edits the.
	 * 
	 * @return the string
	 */
	public String edit() {
		if (this.rechnungId != null) {
			this.rechnung = this.rechnungManager.get(this.rechnungId);
			this.rechnungBaseTO = this.rechnungManager
					.getRechnungBaseTO(this.rechnungId);
		} else {
			this.rechnungBaseTO = new RechnungBaseTO();
		}
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

		if (this.delete != null)
			return this.delete();

		final boolean isNew = (this.rechnungBaseTO.getRechnungId() == null);

		// Prüfen, ob Rechnung leer ist.
		if (this.rechnungBaseTO.getBetrag() <= 0) {
			this.saveMessage(this.getText("Bitte geben Sie einen Betrag ein!"));
			return "back";
		}
		if (this.rechnungBaseTO.getBezugsform().compareTo("") == 0) {
			this.saveMessage(this
					.getText("Bitte geben Sie eine Bezugsform ein!"));
			return "back";
		}
		if (this.rechnungBaseTO.getBezugsjahr().compareTo("") == 0) {
			this.saveMessage(this
					.getText("Bitte geben Sie ein Bezugsjahr ein!"));
			return "back";
		}

		if (isNew) {
			this.rechnung = this.rechnungManager.create(this.rechnungBaseTO,
					this.exemplarId);
		} else {
			this.rechnung = this.rechnungManager
					.saveBaseTO(this.rechnungBaseTO);
		}

		final String key = (isNew) ? "Rechnung wurde erfolgreich erstellt."
				: "Rechnung wurde erfolgreich aktualisiert.";
		this.saveMessage(key);

		return Action.SUCCESS;
	}

	/**
	 * Load exemplare.
	 * 
	 * @return the string
	 */
	public String loadExemplare() {
		if (this.journalId != null) {
			this.journal = this.journalManager.get(this.journalId);
		} else
			return Action.ERROR;

		return Action.SUCCESS;
	}

	// Getter und Setter

	/**
	 * Gets the rechnung id.
	 * 
	 * @return the rechnung id
	 */
	public Long getRechnungId() {
		return this.rechnungId;
	}

	/**
	 * Sets the rechnung id.
	 * 
	 * @param rechnungId
	 *            the new rechnung id
	 */
	public void setRechnungId(final Long rechnungId) {
		this.rechnungId = rechnungId;
	}

	/**
	 * Sets the rechnung manager.
	 * 
	 * @param rechnungManager
	 *            the new rechnung manager
	 */
	public void setRechnungManager(final RechnungManager rechnungManager) {
		this.rechnungManager = rechnungManager;
	}

	/**
	 * Gets the rechnung.
	 * 
	 * @return the rechnung
	 */
	public Rechnung getRechnung() {
		return this.rechnung;
	}

	/**
	 * Sets the rechnung.
	 * 
	 * @param rechnung
	 *            the new rechnung
	 */
	public void setRechnung(final Rechnung rechnung) {
		this.rechnung = rechnung;
	}

	/**
	 * Gets the rechnung base to.
	 * 
	 * @return the rechnung base to
	 */
	public RechnungBaseTO getRechnungBaseTO() {
		return this.rechnungBaseTO;
	}

	/**
	 * Sets the rechnung base to.
	 * 
	 * @param rechnungBaseTO
	 *            the new rechnung base to
	 */
	public void setRechnungBaseTO(final RechnungBaseTO rechnungBaseTO) {
		this.rechnungBaseTO = rechnungBaseTO;
	}

	/**
	 * Sets the journal manager.
	 * 
	 * @param journalManager
	 *            the new journal manager
	 */
	public void setJournalManager(final JournalManager journalManager) {
		this.journalManager = journalManager;
	}

	/**
	 * Gets the journal.
	 * 
	 * @return the journal
	 */
	public Journal getJournal() {
		return this.journal;
	}

}
