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

import org.springframework.dao.DataIntegrityViolationException;

import com.opensymphony.xwork2.Action;

import ejportal.model.Institution;
import ejportal.service.InstitutionManager;
import ejportal.service.dto.InstitutionBaseTO;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 06.07.2010 Time: 22:32:43 To
 * change this template use File | Settings | File Templates.
 */
public class InstitutionDetailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8332137436813525033L;

	/** The institution manager. */
	private InstitutionManager institutionManager;

	/** The institution. */
	private Institution institution;

	/** The institution base to. */
	private InstitutionBaseTO institutionBaseTO;

	/** The id. */
	private Long id;

	/** The select data. */
	private final SelectData selectData = new SelectData();

	// Dropdown lists
	/**
	 * Gets the list lizenz art.
	 * 
	 * @return the list lizenz art
	 */
	public Map<String, String> getListLizenzArt() {
		return this.selectData.getInstitutionLizenzArt();
	}

	/**
	 * Gets the list zugang.
	 * 
	 * @return the list zugang
	 */
	public Map<String, String> getListZugang() {
		return this.selectData.getInstitutionZugang();
	}

	/**
	 * Gets the list personengruppe.
	 * 
	 * @return the list personengruppe
	 */
	public Map<String, String> getListPersonengruppe() {
		return this.selectData.getInstitutionPersonengruppe();
	}

	/**
	 * Gets the list fernleihe.
	 * 
	 * @return the list fernleihe
	 */
	public Map<String, String> getListFernleihe() {
		return this.selectData.getInstitutionFernleihe();
	}

	/**
	 * Gets the list bestellsprache.
	 * 
	 * @return the list bestellsprache
	 */
	public Map<String, String> getListBestellsprache() {
		return this.selectData.getInstitutionBestellsprache();
	}

	/**
	 * Gets the list bestellart.
	 * 
	 * @return the list bestellart
	 */
	public Map<String, String> getListBestellart() {
		return this.selectData.getInstitutionBestellart();
	}

	/**
	 * Sets the institution manager.
	 * 
	 * @param institutionManager
	 *            the new institution manager
	 */
	public void setInstitutionManager(
			final InstitutionManager institutionManager) {
		this.institutionManager = institutionManager;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets the institution.
	 * 
	 * @return the institution
	 */
	public Institution getInstitution() {
		return this.institution;
	}

	/**
	 * Sets the institution.
	 * 
	 * @param institution
	 *            the new institution
	 */
	public void setInstitution(final Institution institution) {
		this.institution = institution;
	}

	/**
	 * Gets the institution base to.
	 * 
	 * @return the institution base to
	 */
	public InstitutionBaseTO getInstitutionBaseTO() {
		return this.institutionBaseTO;
	}

	/**
	 * Sets the institution base to.
	 * 
	 * @param institutionBaseTO
	 *            the new institution base to
	 */
	public void setInstitutionBaseTO(final InstitutionBaseTO institutionBaseTO) {
		this.institutionBaseTO = institutionBaseTO;
	}

	/**
	 * Delete.
	 * 
	 * @return the string
	 */
	public String delete() {
		try {
			this.institutionManager.remove(this.id);
			this.saveMessage(this.getText("institution.deleted"));

		}

		catch (final DataIntegrityViolationException dive) {

			this.saveMessage("Diese Institution ist noch bei Journalen eingetragen und kann deshalb nicht entfernt werden.");
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
		if (this.id != null) {
			this.institution = this.institutionManager.get(this.id);
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
		if (this.id != null) {
			this.institutionBaseTO = this.institutionManager
					.getInstitutionBaseTO(this.id);
		} else {
			this.institutionBaseTO = new InstitutionBaseTO();
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

		final boolean isNew = (this.institutionBaseTO.getId() == null);

		// Pr�fen, ob Name der Institution angegeben worden ist.
		if (this.institutionBaseTO.getName().compareTo("") == 0) {
			this.saveMessage(this
					.getText("Geben Sie einen Namen der Institution ein!"));
			return "back";
		}
		if (this.institutionBaseTO.getName().length() > 254) {
			this.saveMessage(this
					.getText("Geben Sie bitte einen k�rzeren Namen ein!"));
			return "back";
		}

		if (isNew) { // create
			this.institution = this.institutionManager
					.create(this.institutionBaseTO);
		} else { // update
			this.institution = this.institutionManager
					.saveBaseTO(this.institutionBaseTO);
		}

		// institution =institutionManager.save(institution);
		final String key = (isNew) ? "institution.added"
				: "institution.updated";
		this.saveMessage(this.getText(key));

		/**
		 * if (!isNew) { return INPUT; } else { return SUCCESS; }
		 **/
		return Action.SUCCESS;
	}

}
