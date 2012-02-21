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

import ejportal.model.Sigel;
import ejportal.service.SigelManager;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 04.08.2010 Time: 14:48:20 To
 * change this template use File | Settings | File Templates.
 */
public class SigelDetailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4106064806151141421L;

	/** The sigel manager. */
	private SigelManager sigelManager;

	/** The sigel. */
	private Sigel sigel;

	/** The sigel id. */
	private Long sigelId;

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
	 * Gets the sigel.
	 * 
	 * @return the sigel
	 */
	public Sigel getSigel() {
		return this.sigel;
	}

	/**
	 * Sets the sigel.
	 * 
	 * @param sigel
	 *            the new sigel
	 */
	public void setSigel(final Sigel sigel) {
		this.sigel = sigel;
	}

	/**
	 * Gets the sigel id.
	 * 
	 * @return the sigel id
	 */
	public long getSigelId() {
		return this.sigelId;
	}

	/**
	 * Sets the sigel id.
	 * 
	 * @param sigelId
	 *            the new sigel id
	 */
	public void setSigelId(final Long sigelId) {
		this.sigelId = sigelId;
	}

	/**
	 * Delete.
	 * 
	 * @return the string
	 */
	public String delete() {
		try {
			this.sigelManager.remove(this.sigelId);
			this.saveMessage(this.getText("Sigel wurde erfolgreich entfernt."));
		} catch (final DataIntegrityViolationException dive) {
			this.saveMessage("Dieses Sigel wird noch verwendet und kann deshalb nicht entfernt werden.");
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
		if (this.sigelId != null) {
			this.sigel = this.sigelManager.get(this.sigelId);
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
		if (this.sigelId != null) {
			this.sigel = this.sigelManager.get(this.sigelId);
		} else {
			this.sigel = new Sigel();
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

		final boolean isNew = (this.sigel.getSigelId() == null);

		// Pr�fen, ob Sigelname angegeben worden ist.
		if (this.sigel.getName().compareTo("") == 0) {
			this.saveMessage(this.getText("Geben Sie einen Sigelnamen ein!"));
			return "back";
		}
		if (this.sigel.getName().length() > 254) {
			this.saveMessage(this
					.getText("Geben Sie bitte einen k�rzeren Namen ein!"));
			return "back";
		}

		/*
		 * if (isNew){ //create paket = paketManager.save(paket); } else{
		 * //update paket = paketManager.save(paket); }
		 */

		this.sigel = this.sigelManager.save(this.sigel);

		final String key = (isNew) ? "Sigel wurde erfolgreich erstellt."
				: "Sigel wurde erfolgreich aktualisiert.";
		this.saveMessage(this.getText(key));

		return Action.SUCCESS;
	}
}
