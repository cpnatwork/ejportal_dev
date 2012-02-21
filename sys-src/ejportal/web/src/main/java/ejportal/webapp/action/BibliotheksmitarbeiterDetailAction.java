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

import org.springframework.dao.DataIntegrityViolationException;

import com.opensymphony.xwork2.Action;

import ejportal.model.Bibliotheksmitarbeiter;
import ejportal.service.BibliotheksmitarbeiterManager;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 05.08.2010 Time: 13:03:44 To
 * change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterDetailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8620844377727054551L;

	/** The bibliotheksmitarbeiter manager. */
	private BibliotheksmitarbeiterManager bibliotheksmitarbeiterManager;

	/** The bibliotheksmitarbeiter. */
	private Bibliotheksmitarbeiter bibliotheksmitarbeiter;

	/** The bib id. */
	private Long bibId;

	/**
	 * Sets the bibliotheksmitarbeiter manager.
	 * 
	 * @param bibliotheksmitarbeiterManager
	 *            the new bibliotheksmitarbeiter manager
	 */
	public void setBibliotheksmitarbeiterManager(
			final BibliotheksmitarbeiterManager bibliotheksmitarbeiterManager) {
		this.bibliotheksmitarbeiterManager = bibliotheksmitarbeiterManager;
	}

	/**
	 * Gets the bibliotheksmitarbeiter.
	 * 
	 * @return the bibliotheksmitarbeiter
	 */
	public Bibliotheksmitarbeiter getBibliotheksmitarbeiter() {
		return this.bibliotheksmitarbeiter;
	}

	/**
	 * Sets the bibliotheksmitarbeiter.
	 * 
	 * @param bibliotheksmitarbeiter
	 *            the new bibliotheksmitarbeiter
	 */
	public void setBibliotheksmitarbeiter(
			final Bibliotheksmitarbeiter bibliotheksmitarbeiter) {
		this.bibliotheksmitarbeiter = bibliotheksmitarbeiter;
	}

	/**
	 * Gets the bib id.
	 * 
	 * @return the bib id
	 */
	public long getBibId() {
		return this.bibId;
	}

	/**
	 * Sets the bib id.
	 * 
	 * @param bibId
	 *            the new bib id
	 */
	public void setBibId(final Long bibId) {
		this.bibId = bibId;
	}

	/**
	 * Delete.
	 * 
	 * @return the string
	 */
	public String delete() {
		try {
			this.bibliotheksmitarbeiterManager.remove(this.bibId);
			this.saveMessage(this
					.getText("Bibliothek wurde erfolgreich entfernt."));
		} catch (final DataIntegrityViolationException dive) {
			this.saveMessage("Diese Bibliothek wird noch verwendet und kann deshalb nicht enfernt werden.");
			return Action.ERROR;
		}

		return Action.SUCCESS;
	}

	/**
	 * Load.
	 * 
	 * @return the string
	 */
	public String load() {
		if (this.bibId != null) {
			this.bibliotheksmitarbeiter = this.bibliotheksmitarbeiterManager
					.get(this.bibId);
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
		if (this.bibId != null) {
			this.bibliotheksmitarbeiter = this.bibliotheksmitarbeiterManager
					.get(this.bibId);
		} else {
			this.bibliotheksmitarbeiter = new Bibliotheksmitarbeiter();
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

		final boolean isNew = (this.bibliotheksmitarbeiter.getBibId() == null);

		// Pr�fen, ob Name angegeben worden ist.
		if (this.bibliotheksmitarbeiter.getName().compareTo("") == 0) {
			this.saveMessage(this.getText("Geben Sie einen Namen ein!"));
			return "back";
		}
		if (this.bibliotheksmitarbeiter.getName().length() > 254) {
			this.saveMessage(this
					.getText("Geben Sie bitte einen k�rzeren Namen ein!"));
			return "back";
		}

		this.bibliotheksmitarbeiter = this.bibliotheksmitarbeiterManager
				.save(this.bibliotheksmitarbeiter);

		final String key = (isNew) ? "Bibliothek wurde erfolgreich erstellt."
				: "Bibliothek wurde erfolgreich aktualisiert.";
		this.saveMessage(this.getText(key));

		return Action.SUCCESS;
	}

	/*
	 * public void validate(){ if(bibliotheksmitarbeiter.getName().length() ==
	 * 0){ addFieldError("Bibliotheksmitarbeiter",
	 * "Geben sie einen Namen f�r den Bibliotheksmitarbeiter ein."); }
	 *//*
		 * if(bibliotheksmitarbeiter.getAbteilungsHauptstelle().length() == 0){
		 * addFieldError("Bibliotheksmitarbeiter",
		 * "Geben sie eine Abteilungshauptstelle f�r den Bibliotheksmitarbeiter ein."
		 * ); } if(bibliotheksmitarbeiter.getEmailanschrift().length() == 0){
		 * addFieldError("Bibliotheksmitarbeiter",
		 * "Geben sie eine E-Mail Adresse f�r den Bibliotheksmitarbeiter ein.");
		 * }
		 *//*
			 * }
			 */
}
