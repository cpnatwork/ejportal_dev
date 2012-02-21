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

import ejportal.model.Lizenzdetail;
import ejportal.service.LizenzdetailManager;

/**
 * Created by IntelliJ IDEA. User: ag35ogub Date: 05.08.2010 Time: 13:49:53 To
 * change this template use File | Settings | File Templates.
 */
public class LizenzdetailDetailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2866825497560962861L;

	/** The lizenzdetail manager. */
	private LizenzdetailManager lizenzdetailManager;

	/** The lizenzdetail. */
	private Lizenzdetail lizenzdetail;

	/** The lizenz id. */
	private Long lizenzId;

	/** The institution id. */
	private Long institutionId;

	// CRUD
	/**
	 * Delete.
	 * 
	 * @return the string
	 */
	public String delete() {
		this.lizenzdetailManager.remove(this.lizenzId);
		this.saveMessage(this
				.getText("Lizenzdetail wurde erfolgreich entfernt."));

		return Action.SUCCESS;
	}

	/**
	 * Edits the.
	 * 
	 * @return the string
	 */
	public String edit() {
		if (this.lizenzId != null) {
			this.lizenzdetail = this.lizenzdetailManager.get(this.lizenzId);
		} else {
			this.lizenzdetail = new Lizenzdetail();
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

		final boolean isNew = (this.lizenzdetail.getLizenzId() == null);

		// Prüfen, ob Beginndatum angegeben worden ist.
		if (this.lizenzdetail.getBeginn().compareTo("") == 0) {
			this.saveMessage(this.getText("Geben Sie einen Beginndatum ein!"));
			return "back";
		}

		this.lizenzdetail = this.lizenzdetailManager.saveWithInstitution(
				this.lizenzdetail, this.institutionId);

		final String key = (isNew) ? "Lizenzdetail wurde erfolgreich erstellt."
				: "Lizenzdetail wurde erfolgreich aktualisiert.";
		this.saveMessage(key);

		return Action.SUCCESS;
	}

	// Getter und Setter
	/**
	 * Gets the lizenzdetail manager.
	 * 
	 * @return the lizenzdetail manager
	 */
	public LizenzdetailManager getLizenzdetailManager() {
		return this.lizenzdetailManager;
	}

	/**
	 * Sets the lizenzdetail manager.
	 * 
	 * @param lizenzdetailManager
	 *            the new lizenzdetail manager
	 */
	public void setLizenzdetailManager(
			final LizenzdetailManager lizenzdetailManager) {
		this.lizenzdetailManager = lizenzdetailManager;
	}

	/**
	 * Gets the lizenzdetail.
	 * 
	 * @return the lizenzdetail
	 */
	public Lizenzdetail getLizenzdetail() {
		return this.lizenzdetail;
	}

	/**
	 * Sets the lizenzdetail.
	 * 
	 * @param lizenzdetail
	 *            the new lizenzdetail
	 */
	public void setLizenzdetail(final Lizenzdetail lizenzdetail) {
		this.lizenzdetail = lizenzdetail;
	}

	/**
	 * Gets the lizenz id.
	 * 
	 * @return the lizenz id
	 */
	public Long getLizenzId() {
		return this.lizenzId;
	}

	/**
	 * Sets the lizenz id.
	 * 
	 * @param lizenzId
	 *            the new lizenz id
	 */
	public void setLizenzId(final Long lizenzId) {
		this.lizenzId = lizenzId;
	}

	/**
	 * Gets the institution id.
	 * 
	 * @return the institution id
	 */
	public Long getInstitutionId() {
		return this.institutionId;
	}

	/**
	 * Sets the institution id.
	 * 
	 * @param institutionId
	 *            the new institution id
	 */
	public void setInstitutionId(final Long institutionId) {
		this.institutionId = institutionId;
	}

}
