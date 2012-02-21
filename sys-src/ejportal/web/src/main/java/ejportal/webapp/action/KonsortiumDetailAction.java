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

import ejportal.model.Konsortium;
import ejportal.service.KonsortiumManager;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 03.08.2010 Time: 14:14:45 To
 * change this template use File | Settings | File Templates.
 */
public class KonsortiumDetailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7523489767970930185L;

	/** The konsortium manager. */
	private KonsortiumManager konsortiumManager;

	/** The konsortium. */
	private Konsortium konsortium;

	/** The konsortium id. */
	private Long konsortiumId;

	/**
	 * Sets the konsortium manager.
	 * 
	 * @param konsortiumManager
	 *            the new konsortium manager
	 */
	public void setKonsortiumManager(final KonsortiumManager konsortiumManager) {
		this.konsortiumManager = konsortiumManager;
	}

	/**
	 * Gets the konsortium.
	 * 
	 * @return the konsortium
	 */
	public Konsortium getKonsortium() {
		return this.konsortium;
	}

	/**
	 * Sets the konsortium.
	 * 
	 * @param konsortium
	 *            the new konsortium
	 */
	public void setKonsortium(final Konsortium konsortium) {
		this.konsortium = konsortium;
	}

	/**
	 * Gets the konsortium id.
	 * 
	 * @return the konsortium id
	 */
	public Long getKonsortiumId() {
		return this.konsortiumId;
	}

	/**
	 * Sets the konsortium id.
	 * 
	 * @param konsortiumId
	 *            the new konsortium id
	 */
	public void setKonsortiumId(final Long konsortiumId) {
		this.konsortiumId = konsortiumId;
	}

	/**
	 * Delete.
	 * 
	 * @return the string
	 */
	public String delete() {
		try {
			this.konsortiumManager.remove(this.konsortiumId);
			this.saveMessage(this
					.getText("Konsortium wurde erfolgreich entfernt."));

		}

		catch (final DataIntegrityViolationException dive) {

			this.saveMessage("Dieses Konsortium wird noch verwendet und kann deshalb nicht entfernt werden.");
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
		if (this.konsortiumId != null) {
			this.konsortium = this.konsortiumManager.get(this.konsortiumId);
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
		if (this.konsortiumId != null) {
			this.konsortium = this.konsortiumManager.get(this.konsortiumId);
		} else {
			this.konsortium = new Konsortium();
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

		final boolean isNew = (this.konsortium.getKonsortiumId() == null);

		// Pr�fen, ob Konsortiumname angegeben worden ist.
		if (this.konsortium.getKonsortiumName().compareTo("") == 0) {
			this.saveMessage(this
					.getText("Geben Sie einen Konsortiumnamen ein!"));
			return "back";
		}
		if (this.konsortium.getKonsortiumName().length() > 254) {
			this.saveMessage(this
					.getText("Geben Sie bitte einen k�rzeren Namen ein!"));
			return "back";
		}

		/*
		 * if (isNew){ //create konsortium = konsortiumManager.save(konsortium);
		 * } else{ //update konsortium = konsortiumManager.save(konsortium); }
		 */

		this.konsortium = this.konsortiumManager.save(this.konsortium);

		final String key = (isNew) ? "Konsortium wurde erfolgreich erstellt."
				: "Konsortium wurde erfolgreich aktualisiert.";
		this.saveMessage(key);

		return Action.SUCCESS;
	}
}
