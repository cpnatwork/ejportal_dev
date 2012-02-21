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

import ejportal.model.Interesse;
import ejportal.service.InteresseManager;
import ejportal.service.dto.InteresseBaseTO;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 10.08.2010 Time: 11:09:43 To
 * change this template use File | Settings | File Templates.
 */
public class InteresseAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8959433480487130490L;

	/** The interesse manager. */
	private InteresseManager interesseManager;

	/** The interesse. */
	private Interesse interesse;

	/** The interesse base to. */
	private InteresseBaseTO interesseBaseTO;

	// IDs für URL
	/** The interesse id. */
	private Long interesseId;

	/** The besteller id. */
	private Long bestellerId;

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

	// CRUD
	/**
	 * Delete.
	 * 
	 * @return the string
	 */
	public String delete() {
		this.interesseManager.remove(this.interesseId);
		this.saveMessage("Das Interesse wurde erfolgreich entfernt.");

		return Action.SUCCESS;
	}

	/**
	 * Load.
	 * 
	 * @return the string
	 */
	public String load() {
		if (this.interesseId != null) {
			this.interesse = this.interesseManager.get(this.interesseId);
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
		if (this.interesseId != null) {
			this.interesse = this.interesseManager.get(this.interesseId);
			this.interesseBaseTO = this.interesseManager
					.getInteresseBaseTO(this.interesseId);
			if (this.interesse.getBesteller() != null) {
				this.bestellerId = this.interesse.getBesteller()
						.getBestellerId();
			}
		} else {
			this.interesseBaseTO = new InteresseBaseTO();
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

		final boolean isNew = (this.interesseBaseTO.getInteresseId() == null);

		// Validierung Name
		if (this.interesseBaseTO.getInteresse().equals("")) {
			this.saveMessage(this
					.getText("Bitte geben Sie eine Bezeichnung ein."));
			return "back";
		}

		if (isNew) {
			this.interesse = this.interesseManager.create(this.interesseBaseTO,
					this.journalId);
			this.interesseId = this.interesse.getInteresseId();
		} else {
			this.interesse = this.interesseManager
					.saveBaseTO(this.interesseBaseTO);
			this.interesseId = this.interesse.getInteresseId();
		}

		final String key = (isNew) ? "Interesse wurde erfolgreich erstellt."
				: "Interesse wurde erfolgreich aktualisiert.";
		this.saveMessage(key);

		return Action.SUCCESS;
	}

	// Ralations
	/**
	 * Change besteller.
	 * 
	 * @return the string
	 */
	public String changeBesteller() {
		this.interesseManager.connectInteresseBesteller(this.interesseId,
				this.bestellerId);
		this.load();
		return Action.SUCCESS;
	}

	// Getter und Setter
	/**
	 * Sets the interesse manager.
	 * 
	 * @param interesseManager
	 *            the new interesse manager
	 */
	public void setInteresseManager(final InteresseManager interesseManager) {
		this.interesseManager = interesseManager;
	}

	/**
	 * Gets the interesse.
	 * 
	 * @return the interesse
	 */
	public Interesse getInteresse() {
		return this.interesse;
	}

	/**
	 * Sets the interesse.
	 * 
	 * @param interesse
	 *            the new interesse
	 */
	public void setInteresse(final Interesse interesse) {
		this.interesse = interesse;
	}

	/**
	 * Gets the interesse base to.
	 * 
	 * @return the interesse base to
	 */
	public InteresseBaseTO getInteresseBaseTO() {
		return this.interesseBaseTO;
	}

	/**
	 * Sets the interesse base to.
	 * 
	 * @param interesseBaseTO
	 *            the new interesse base to
	 */
	public void setInteresseBaseTO(final InteresseBaseTO interesseBaseTO) {
		this.interesseBaseTO = interesseBaseTO;
	}
}
