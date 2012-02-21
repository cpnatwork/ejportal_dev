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

import ejportal.model.Paket;
import ejportal.service.PaketManager;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 03.08.2010 Time: 12:07:36 To
 * change this template use File | Settings | File Templates.
 */
public class PaketDetailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -868809777968504016L;

	/** The paket manager. */
	private PaketManager paketManager;

	/** The paket. */
	private Paket paket;

	/** The paket id. */
	private Long paketId;

	/**
	 * Sets the paket manager.
	 * 
	 * @param paketManager
	 *            the new paket manager
	 */
	public void setPaketManager(final PaketManager paketManager) {
		this.paketManager = paketManager;
	}

	/**
	 * Gets the paket.
	 * 
	 * @return the paket
	 */
	public Paket getPaket() {
		return this.paket;
	}

	/**
	 * Sets the paket.
	 * 
	 * @param paket
	 *            the new paket
	 */
	public void setPaket(final Paket paket) {
		this.paket = paket;
	}

	/**
	 * Gets the paket id.
	 * 
	 * @return the paket id
	 */
	public long getPaketId() {
		return this.paketId;
	}

	/**
	 * Sets the paket id.
	 * 
	 * @param paketId
	 *            the new paket id
	 */
	public void setPaketId(final Long paketId) {
		this.paketId = paketId;
	}

	/**
	 * Delete.
	 * 
	 * @return the string
	 */
	public String delete() {
		try {
			this.paketManager.remove(this.paketId);
			this.saveMessage(this.getText("Paket wurde erfolgreich entfernt."));
		} catch (final DataIntegrityViolationException dive) {
			this.saveMessage("Dieses Paket wird noch verwendet und kann deshalb nicht entfernt werden.");
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
		if (this.paketId != null) {
			this.paket = this.paketManager.get(this.paketId);
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
		if (this.paketId != null) {
			this.paket = this.paketManager.get(this.paketId);
		} else {
			this.paket = new Paket();
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

		final boolean isNew = (this.paket.getPaketId() == null);

		// Pr�fen, ob Paketname angegeben worden ist.
		if (this.paket.getPaketName().compareTo("") == 0) {
			this.saveMessage(this.getText("Geben Sie einen Paketnamen ein!"));
			return "back";
		}
		if (this.paket.getPaketName().length() > 254) {
			this.saveMessage(this
					.getText("Geben Sie bitte einen k�rzeren Namen ein!"));
			return "back";
		}

		/*
		 * if (isNew){ //create paket = paketManager.save(paket); } else{
		 * //update paket = paketManager.save(paket); }
		 */

		this.paket = this.paketManager.save(this.paket);

		final String key = (isNew) ? "Paket wurde erfolgreich erstellt."
				: "Paket wurde erfolgreich aktualisiert.";
		this.saveMessage(this.getText(key));

		return Action.SUCCESS;
	}
}
