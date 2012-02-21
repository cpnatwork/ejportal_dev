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

import org.springframework.dao.DataIntegrityViolationException;

import com.opensymphony.xwork2.Action;

import ejportal.model.Besteller;
import ejportal.service.BestellerManager;
import ejportal.service.dto.BestellerBaseTO;
import ejportal.service.dto.BestellerSearchTO;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 10.08.2010 Time: 11:01:25 To
 * change this template use File | Settings | File Templates.
 */
public class BestellerAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4374473357754966995L;

	/** The besteller manager. */
	private BestellerManager bestellerManager;

	/** The besteller. */
	private Besteller besteller;

	/** The besteller base to. */
	private BestellerBaseTO bestellerBaseTO;

	// IDs fürs Menü
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
		try {
			this.bestellerManager.remove(this.bestellerId);
			this.saveMessage("Besteller wurde erfolgreich entfernt.");
		} catch (final DataIntegrityViolationException dive) {
			this.saveMessage("Dieser Besteller hat noch Interessen und kann deshalb nicht entfernt werden.");
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
		if (this.bestellerId != null) {
			this.besteller = this.bestellerManager.get(this.bestellerId);
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
		if (this.bestellerId != null) {
			this.besteller = this.bestellerManager.get(this.bestellerId);
			this.bestellerBaseTO = this.bestellerManager
					.getBestellerBaseTO(this.bestellerId);
		} else {
			this.bestellerBaseTO = new BestellerBaseTO();
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

		final boolean isNew = (this.bestellerBaseTO.getBestellerId() == null);

		// Validierung Name
		if (this.bestellerBaseTO.getBestellerName().equals("")) {
			this.saveMessage(this.getText("Bitte geben Sie einen Namen ein."));
			return "back";
		}

		// Validierung Projekt
		if (this.bestellerBaseTO.getProjekt().equals("")) {
			this.saveMessage(this.getText("Bitte geben Sie ein Projekt ein."));
			return "back";
		}

		// Validierung Einzahlung erwünscht
		if (this.bestellerBaseTO.getEinzahlungErwuenscht() < 0) {
			this.saveMessage(this.getText("Bitte geben Sie einen Betrag ein."));
			return "back";
		}
		if (!(new Float(this.bestellerBaseTO.getEinzahlungErwuenscht()) instanceof Float)) {
			this.saveMessage(this.getText("Bitte geben Sie eine Zahl ein."));
			return "back";
		}

		// Validierung Einzahlung festgelegt
		if (this.bestellerBaseTO.getEinzahlungFestgelegt() < 0) {
			this.saveMessage(this.getText("Bitte geben Sie einen Betrag ein."));
			return "back";
		}
		if (!(new Float(this.bestellerBaseTO.getEinzahlungFestgelegt()) instanceof Float)) {
			this.saveMessage(this.getText("Bitte geben Sie eine Zahl ein."));
			return "back";
		}

		if (isNew) {
			this.besteller = this.bestellerManager.create(this.bestellerBaseTO);
			this.bestellerId = this.besteller.getBestellerId();
		} else {
			this.besteller = this.bestellerManager
					.saveBaseTO(this.bestellerBaseTO);
			this.bestellerId = this.besteller.getBestellerId();
		}

		final String key = (isNew) ? "Besteller wurde erfolgreich erstellt."
				: "Besteller wurde erfolgreich aktualisiert.";
		this.saveMessage(key);

		return Action.SUCCESS;
	}

	// Search
	/** The besteller search to. */
	private BestellerSearchTO bestellerSearchTO;

	/** The besteller list. */
	private List bestellerList;

	/**
	 * Gets the besteller search to.
	 * 
	 * @return the besteller search to
	 */
	public BestellerSearchTO getBestellerSearchTO() {
		return this.bestellerSearchTO;
	}

	/**
	 * Sets the besteller search to.
	 * 
	 * @param bestellerSearchTO
	 *            the new besteller search to
	 */
	public void setBestellerSearchTO(final BestellerSearchTO bestellerSearchTO) {
		this.bestellerSearchTO = bestellerSearchTO;
	}

	/**
	 * Gets the besteller list.
	 * 
	 * @return the besteller list
	 */
	public List getBestellerList() {
		return this.bestellerList;
	}

	/**
	 * Search.
	 * 
	 * @return the string
	 */
	public String search() {
		final int maxResults = 25;
		this.bestellerList = this.bestellerManager.search(
				this.bestellerSearchTO, maxResults);
		if (this.bestellerList.size() == maxResults) {
			this.saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als "
					+ this.bestellerList.size() + " Besteller gefunden wurden.");
			this.saveMessage("Die ersten " + maxResults
					+ " Ergebnisse werden angezeigt.");
		}

		// TODO Fehlerbehandlung
		return Action.SUCCESS;
	}

	// Relations
	/** The sigel id. */
	private Long sigelId;

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
	 * Change sigel.
	 * 
	 * @return the string
	 */
	public String changeSigel() {
		this.bestellerManager.connectBestellerSigel(this.bestellerId,
				this.sigelId);
		this.load();
		return Action.SUCCESS;
	}

	// Getter und Setter
	/**
	 * Sets the besteller manager.
	 * 
	 * @param bestellerManager
	 *            the new besteller manager
	 */
	public void setBestellerManager(final BestellerManager bestellerManager) {
		this.bestellerManager = bestellerManager;
	}

	/**
	 * Gets the besteller.
	 * 
	 * @return the besteller
	 */
	public Besteller getBesteller() {
		return this.besteller;
	}

	/**
	 * Sets the besteller.
	 * 
	 * @param besteller
	 *            the new besteller
	 */
	public void setBesteller(final Besteller besteller) {
		this.besteller = besteller;
	}

	/**
	 * Gets the besteller base to.
	 * 
	 * @return the besteller base to
	 */
	public BestellerBaseTO getBestellerBaseTO() {
		return this.bestellerBaseTO;
	}

	/**
	 * Sets the besteller base to.
	 * 
	 * @param bestellerBaseTO
	 *            the new besteller base to
	 */
	public void setBestellerBaseTO(final BestellerBaseTO bestellerBaseTO) {
		this.bestellerBaseTO = bestellerBaseTO;
	}
}
