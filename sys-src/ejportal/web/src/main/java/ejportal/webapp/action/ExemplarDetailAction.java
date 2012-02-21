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

import ejportal.model.Exemplar;
import ejportal.service.ExemplarManager;
import ejportal.service.dto.ExemplarBaseTO;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 04.08.2010 Time: 14:56:26 To
 * change this template use File | Settings | File Templates.
 */
public class ExemplarDetailAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1694151608896535163L;

	/** The exemplar manager. */
	private ExemplarManager exemplarManager;

	/** The exemplar. */
	private Exemplar exemplar;

	/** The exemplar base to. */
	private ExemplarBaseTO exemplarBaseTO;

	/** The exemplar id. */
	private Long exemplarId;

	/** The select data. */
	private final SelectData selectData = new SelectData();

	// Dropdown Lists

	/**
	 * Gets the list beteiligung.
	 * 
	 * @return the list beteiligung
	 */
	public Map<String, String> getListBeteiligung() {
		return this.selectData.getExemplarBeteiligung();
	}

	/**
	 * Gets the list form.
	 * 
	 * @return the list form
	 */
	public Map<String, String> getListForm() {
		return this.selectData.getExemplarForm();
	}

	/**
	 * Gets the list zugangsart.
	 * 
	 * @return the list zugangsart
	 */
	public Map<String, String> getListZugangsart() {
		return this.selectData.getExemplarZugangsart();
	}

	/**
	 * Gets the list status.
	 * 
	 * @return the list status
	 */
	public Map<String, String> getListStatus() {
		return this.selectData.getExemplarStatus();
	}

	/**
	 * Gets the list abbestellung.
	 * 
	 * @return the list abbestellung
	 */
	public Map<String, String> getListAbbestellung() {
		return this.selectData.getExemplarAbbestellung();
	}

	/**
	 * Gets the list umbestellung.
	 * 
	 * @return the list umbestellung
	 */
	public Map<String, String> getListUmbestellung() {
		return this.selectData.getExemplarUmbestellung();
	}

	/**
	 * Sets the exemplar manager.
	 * 
	 * @param exemplarManager
	 *            the new exemplar manager
	 */
	public void setExemplarManager(final ExemplarManager exemplarManager) {
		this.exemplarManager = exemplarManager;
	}

	/**
	 * Gets the exemplar base to.
	 * 
	 * @return the exemplar base to
	 */
	public ExemplarBaseTO getExemplarBaseTO() {
		return this.exemplarBaseTO;
	}

	/**
	 * Sets the exemplar base to.
	 * 
	 * @param exemplarBaseTO
	 *            the new exemplar base to
	 */
	public void setExemplarBaseTO(final ExemplarBaseTO exemplarBaseTO) {
		this.exemplarBaseTO = exemplarBaseTO;
	}

	/**
	 * Sets the exemplar id.
	 * 
	 * @param exemplarId
	 *            the new exemplar id
	 */
	public void setExemplarId(final Long exemplarId) {
		this.exemplarId = exemplarId;
	}

	/**
	 * Gets the exemplar id.
	 * 
	 * @return the exemplar id
	 */
	public Long getExemplarId() {
		return this.exemplarId;
	}

	/**
	 * Gets the exemplar.
	 * 
	 * @return the exemplar
	 */
	public Exemplar getExemplar() {
		return this.exemplar;
	}

	/**
	 * Delete.
	 * 
	 * @return the string
	 */
	public String delete() {
		try {
			this.exemplarManager.removeSafe(this.exemplarId);
			this.saveMessage("Das Exemplar wurde entfernt.");
		} catch (final DataIntegrityViolationException dive) {
			this.saveMessage("Dieses Exemplar wird noch verwendet und kann deshalb nicht entfernt werden.");
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
		if (this.exemplarId != null) {
			this.exemplar = this.exemplarManager.get(this.exemplarId);
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
		if (this.exemplarId != null) {
			this.exemplarBaseTO = this.exemplarManager
					.getExemplarBaseTO(this.exemplarId);
		} else {
			this.exemplarBaseTO = new ExemplarBaseTO();
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

		final boolean isNew = (this.exemplarBaseTO.getExemplarId() == null);

		// Pruefen, ob Bestellnummer angegeben worden ist.
		if (this.exemplarBaseTO.getBestellnummer().compareTo("") == 0) {
			this.saveMessage(this
					.getText("Bitte geben Sie eine Bestellnummer ein!"));
			return "back";
		}
		if (this.exemplarBaseTO.getBestellnummer().length() > 254) {
			this.saveMessage(this
					.getText("Geben Sie bitte eine k�rzere Bestellnummer ein!"));
			return "back";
		}

		if (isNew) { // Create
			this.exemplar = this.exemplarManager.create(this.exemplarBaseTO,
					this.journalId);
		} else { // Update
			this.exemplar = this.exemplarManager
					.saveBaseTO(this.exemplarBaseTO);
		}
		final String key = (isNew) ? "Das Exemplar wurde erstellt."
				: "Das Exemplar wurde aktualisiert.";
		this.saveMessage(key);

		// ExemplarID setzen
		this.exemplarId = this.exemplar.getExemplarId();

		return Action.SUCCESS;
	}

	// Besteller �ndern
	/** The besteller id. */
	private Long bestellerId;

	/**
	 * Sets the besteller id.
	 * 
	 * @param bestellerId
	 *            the new besteller id
	 */
	public void setBestellerId(final Long bestellerId) {
		this.bestellerId = bestellerId;
	}

	/**
	 * Change besteller.
	 * 
	 * @return the string
	 */
	public String changeBesteller() {
		this.exemplarManager.connectExemplarBesteller(this.exemplarId,
				this.bestellerId);
		this.load();
		return Action.SUCCESS;
	}

	// Eigent�mer �ndern
	/** The eigentuemer id. */
	private Long eigentuemerId;

	/**
	 * Sets the eigentuemer id.
	 * 
	 * @param eigentuemerId
	 *            the new eigentuemer id
	 */
	public void setEigentuemerId(final Long eigentuemerId) {
		this.eigentuemerId = eigentuemerId;
	}

	/**
	 * Change eigentuemer.
	 * 
	 * @return the string
	 */
	public String changeEigentuemer() {
		this.exemplarManager.connectExemplarEigentuemer(this.exemplarId,
				this.eigentuemerId);
		this.load();
		return Action.SUCCESS;
	}

	// Lieferanten �ndern
	/** The lieferant id. */
	private Long lieferantId;

	/**
	 * Sets the lieferant id.
	 * 
	 * @param lieferantId
	 *            the new lieferant id
	 */
	public void setLieferantId(final Long lieferantId) {
		this.lieferantId = lieferantId;
	}

	/**
	 * Change lieferant.
	 * 
	 * @return the string
	 */
	public String changeLieferant() {
		this.exemplarManager.connectExemplarLieferant(this.exemplarId,
				this.lieferantId);
		this.load();
		return Action.SUCCESS;
	}

	// Lieferanten �ndern
	/** The zustaendige bib id. */
	private Long zustaendigeBibId;

	/**
	 * Gets the zustaendige bib id.
	 * 
	 * @return the zustaendige bib id
	 */
	public Long getZustaendigeBibId() {
		return this.zustaendigeBibId;
	}

	/**
	 * Sets the zustaendige bib id.
	 * 
	 * @param zustaendigeBibId
	 *            the new zustaendige bib id
	 */
	public void setZustaendigeBibId(final Long zustaendigeBibId) {
		this.zustaendigeBibId = zustaendigeBibId;
	}

	/**
	 * Change zustaendige bib.
	 * 
	 * @return the string
	 */
	public String changeZustaendigeBib() {
		this.exemplarManager.connectExemplarZustaendigeBib(this.exemplarId,
				this.zustaendigeBibId);
		this.load();
		return Action.SUCCESS;
	}
}