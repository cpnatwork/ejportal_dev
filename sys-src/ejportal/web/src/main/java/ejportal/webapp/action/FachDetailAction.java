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

import ejportal.model.Fach;
import ejportal.service.FachManager;

/**
 * Created by IntelliJ IDEA. User: ev55esul Date: 05.08.2010 Time: 17:55:06 To
 * change this template use File | Settings | File Templates.
 */
public class FachDetailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2205103709325280619L;

	/** The fach manager. */
	private FachManager fachManager;

	/** The fach. */
	private Fach fach;

	/** The fach id. */
	private Long fachId;

	/**
	 * Sets the fach manager.
	 * 
	 * @param fachManager
	 *            the new fach manager
	 */
	public void setFachManager(final FachManager fachManager) {
		this.fachManager = fachManager;
	}

	/**
	 * Gets the fach.
	 * 
	 * @return the fach
	 */
	public Fach getFach() {
		return this.fach;
	}

	/**
	 * Sets the fach.
	 * 
	 * @param fach
	 *            the new fach
	 */
	public void setFach(final Fach fach) {
		this.fach = fach;
	}

	/**
	 * Gets the fach id.
	 * 
	 * @return the fach id
	 */
	public long getFachId() {
		return this.fachId;
	}

	/**
	 * Sets the fach id.
	 * 
	 * @param fachId
	 *            the new fach id
	 */
	public void setFachId(final Long fachId) {
		this.fachId = fachId;
	}

	/**
	 * Delete.
	 * 
	 * @return the string
	 */
	public String delete() {
		try {
			this.fachManager.remove(this.fachId);
			this.saveMessage(this.getText("Fach wurde erfolgreich entfernt."));
		} catch (final DataIntegrityViolationException dive) {
			this.saveMessage("Dieses Fach wird noch verwendet und kann deshalb nicht entfernt werden.");
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
		if (this.fachId != null) {
			this.fach = this.fachManager.get(this.fachId);
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
		if (this.fachId != null) {
			this.fach = this.fachManager.get(this.fachId);
		} else {
			this.fach = new Fach();
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

		final boolean isNew = (this.fach.getFachId() == null);

		// Pr�fen, ob Fachname angegeben worden ist.
		if (this.fach.getFachName().compareTo("") == 0) {
			this.saveMessage(this.getText("Geben Sie einen Fachnamen ein!"));
			return "back";
		}
		if (this.fach.getFachName().length() > 254) {
			this.saveMessage(this
					.getText("Geben Sie bitte einen k�rzeren Fachnamen ein!"));
			return "back";
		}
		/*
		 * if (isNew){ //create fach = fachManager.save(fach); } else{ //update
		 * fach = fachManager.save(fach); }
		 */

		this.fach = this.fachManager.save(this.fach);

		final String key = (isNew) ? "Fach wurde erfolgreich erstellt."
				: "Fach wurde erfolgreich aktualisiert.";
		this.saveMessage(this.getText(key));

		return Action.SUCCESS;
	}
}
