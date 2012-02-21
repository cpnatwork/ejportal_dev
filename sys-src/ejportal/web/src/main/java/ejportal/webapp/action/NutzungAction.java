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

import com.opensymphony.xwork2.Action;

import ejportal.model.Nutzung;
import ejportal.service.NutzungManager;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 10.08.2010 Time: 09:48:43 To
 * change this template use File | Settings | File Templates.
 */
public class NutzungAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1315590153681274624L;

	/** The nutzung manager. */
	private NutzungManager nutzungManager;

	/** The nutzung. */
	private Nutzung nutzung;

	/** The nutzung id. */
	private Long nutzungId;

	/**
	 * Gets the nutzung.
	 * 
	 * @return the nutzung
	 */
	public Nutzung getNutzung() {
		return this.nutzung;
	}

	/**
	 * Sets the nutzung.
	 * 
	 * @param nutzung
	 *            the new nutzung
	 */
	public void setNutzung(final Nutzung nutzung) {
		this.nutzung = nutzung;
	}

	/**
	 * Sets the nutzung manager.
	 * 
	 * @param nutzungManager
	 *            the new nutzung manager
	 */
	public void setNutzungManager(final NutzungManager nutzungManager) {
		this.nutzungManager = nutzungManager;
	}

	/**
	 * Gets the nutzung id.
	 * 
	 * @return the nutzung id
	 */
	public Long getNutzungId() {
		return this.nutzungId;
	}

	/**
	 * Sets the nutzung id.
	 * 
	 * @param nutzungId
	 *            the new nutzung id
	 */
	public void setNutzungId(final Long nutzungId) {
		this.nutzungId = nutzungId;
	}

	/**
	 * Edits the.
	 * 
	 * @return the string
	 */
	public String edit() {
		if (this.nutzungId != null) {
			this.nutzung = this.nutzungManager.get(this.nutzungId);
		} else {
			this.nutzung = new Nutzung();
		}
		return "edit";
	}

	/**
	 * Load.
	 * 
	 * @return the string
	 */
	public String load() {
		if (this.nutzungId != null) {
			this.nutzung = this.nutzungManager.get(this.nutzungId);
		} else
			return Action.ERROR;

		return Action.SUCCESS;
	}

	/**
	 * Save.
	 * 
	 * @return the string
	 */
	public String save() {
		if (this.cancel != null)
			return BaseAction.CANCEL;

		if (this.delete != null)
			return this.delete();

		final boolean isNew = (this.nutzung.getNutzungId() == null);

		// Pr�fen, ob Nutzung leer ist.
		if (this.nutzung.getZugriffe() == null) {
			this.saveMessage(this
					.getText("Bitte geben Sie die Anzahl der Zugriffe ein!"));
			return "back";
		}
		if (this.nutzung.getZeitraum() == null) {
			this.saveMessage(this
					.getText("Bitte geben Sie einen Zeitraum ein!"));
			return "back";
		}
		if (this.nutzung.getNutzungsjahr() == null) {
			this.saveMessage(this.getText("Bitte geben Sie ein Jahr ein!"));
			return "back";
		}
		if (this.nutzung.getRechnungsbetrag() == null) {
			this.saveMessage(this.getText("Bitte geben Sie einen Betrag ein!"));
			return "back";
		}

		// Pr�fen, ob Datentypen stimmen.
		/*
		 * if ((nutzung.getZugriffe() instanceof Integer) == false) {
		 * saveMessage(getText("Bitte geben Sie f�r Zugriffe eine Zahl ein!"));
		 * return "back"; }
		 */

		this.nutzung = this.nutzungManager.saveWithJournal(this.nutzung,
				this.journalId);

		this.load();
		final String key = (isNew) ? "Nutzung wurde erfolgreich erstellt."
				: "Nutzung wurde erfolgreich aktualisiert.";
		this.saveMessage(key);

		return Action.SUCCESS;
	}

	/**
	 * Delete.
	 * 
	 * @return the string
	 */
	public String delete() {
		this.nutzungManager.remove(this.nutzungId);
		this.saveMessage(this.getText("Nutzung wurde erfolgreich entfernt."));

		return Action.SUCCESS;
	}

}
