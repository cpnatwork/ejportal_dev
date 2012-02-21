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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;

import com.opensymphony.xwork2.Action;

import ejportal.model.Journal;
import ejportal.service.JournalManager;
import ejportal.service.dto.JournalBaseTO;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 14.06.2010 Time: 14:19:28 To
 * change this template use File | Settings | File Templates.
 */

public class JournalDetailAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5960420736816836701L;

	/** The journal manager. */
	private JournalManager journalManager;

	/** The journal. */
	private Journal journal;

	/** The journal base to. */
	private JournalBaseTO journalBaseTO;

	/** The select data. */
	private final SelectData selectData = new SelectData();

	/*
	 * //Zugriff auf die journalId (fuer das Menue) public long getJournalId(){
	 * //bei Journal bearbeiten gibt es kein journal sondern nur eine
	 * journalBaseTO if (journalBaseTO !=null && journalBaseTO.getId() !=null){
	 * return journalBaseTO.getId(); } return journal.getId(); }
	 * 
	 * public void setId(Long journalId) { this.journalId = journalId; }
	 * 
	 * public Long getId() { return journalId; }
	 */

	// Dropdown lists

	/**
	 * Gets the list zugang ueber.
	 * 
	 * @return the list zugang ueber
	 */
	public Map<String, String> getListZugangUeber() {
		return this.selectData.getJournalZugangUeber();
	}

	/**
	 * Gets the list nutzungsbestimmungen.
	 * 
	 * @return the list nutzungsbestimmungen
	 */
	public Map<String, String> getListNutzungsbestimmungen() {
		return this.selectData.getJournalNutzungsbestimmungen();
	}

	/**
	 * Gets the list status.
	 * 
	 * @return the list status
	 */
	public Map<String, String> getListStatus() {
		return this.selectData.getJournalStatus();
	}

	// Verlag aendern
	/** The verlag id. */
	private long verlagId;

	/**
	 * Sets the journal manager.
	 * 
	 * @param journalManager
	 *            the new journal manager
	 */
	public void setJournalManager(final JournalManager journalManager) {
		this.journalManager = journalManager;
	}

	// Provider aendern
	/** The provider id. */
	private long providerId;

	// Konsortium aendern
	/** The konsortium id. */
	private long konsortiumId;

	// Paket aendern
	/** The paket id. */
	private long paketId;

	// Fach aendern
	/** The fach id. */
	private long fachId;

	// Bibliotheksmitarbeiter �ndern
	/** The bib id. */
	private long bibId;

	/**
	 * Gets the faecher.
	 * 
	 * @return the faecher
	 */
	public List getFaecher() {
		final List retVal = new ArrayList();
		// FIXME org.hibernate.LazyInitializationException
		// Hibernate.initialize(getJournal().getFaecher());
		// retVal = getJournal().getFaecher();
		return retVal;
	}

	/**
	 * Gets the journal.
	 * 
	 * @return the journal
	 */
	public Journal getJournal() {
		return this.journal;
	}

	/**
	 * Sets the journal.
	 * 
	 * @param journal
	 *            the new journal
	 */
	public void setJournal(final Journal journal) {
		this.journal = journal;
	}

	/**
	 * Gets the journal base to.
	 * 
	 * @return the journal base to
	 */
	public JournalBaseTO getJournalBaseTO() {
		return this.journalBaseTO;
	}

	/**
	 * Sets the journal base to.
	 * 
	 * @param journalBaseTO
	 *            the new journal base to
	 */
	public void setJournalBaseTO(final JournalBaseTO journalBaseTO) {
		this.journalBaseTO = journalBaseTO;
	}

	// TODO Die naechsten beiden Methoden sind Pfusch...da sollten wir uns was
	// schoeneres ueberlegen.

	/**
	 * public String changeVerlag(){
	 * getSession().setAttribute("journalid",journalId); return "selectVerlag";
	 * }
	 * 
	 * public void setVerlagById(long verlagId){ this.journalId = (Long)
	 * getSession().getAttribute("journalid");
	 * getSession().removeAttribute("journalid");
	 * journalManager.connectJournalVerlag(this.journalId, verlagId); }
	 * 
	 * @return the string
	 */

	public String delete() {
		try {
			this.journalManager.remove(this.journalId);
			this.saveMessage(this.getText("journal.deleted"));
		} catch (final DataIntegrityViolationException dive) {
			this.saveMessage("Dieses Journal wird noch verwendet und kann deshalb nicht entfernt werden.");
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
		this.log.debug(">>> JournalDetailAction.load: journalId="
				+ this.journalId);
		if (this.journalId != null) {
			this.journal = this.journalManager.get(this.journalId);
		} else
			return Action.ERROR;

		return Action.SUCCESS;

	}

	// TODO edit + save evtl in eigene Action? JournalEditAction?
	/**
	 * Edits the.
	 * 
	 * @return the string
	 */
	public String edit() {
		this.log.debug(">>> JournalDetailAction.edit: journalId"
				+ this.journalId);
		if (this.journalId != null) {
			this.journalBaseTO = this.journalManager
					.getJournalBaseTO(this.journalId);

		} else {
			this.journalBaseTO = new JournalBaseTO();
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
		this.log.debug(">>> JournalDetailAction.save: journalId"
				+ this.journalId);
		if (this.cancel != null)
			return BaseAction.CANCEL;

		if (this.delete != null)
			return this.delete();

		final boolean isNew = (this.journalBaseTO.getId() == null);

		// Pr�fen, ob Titel angegeben worden ist.
		if (this.journalBaseTO.getTitel().compareTo("") == 0) {
			this.saveMessage(this.getText("Geben Sie einen Titel ein!"));
			return "back";
		}
		if (this.journalBaseTO.getTitel().length() > 254) {
			this.saveMessage(this
					.getText("Geben Sie bitte einen k�rzeren Titel ein!"));
			return "back";
		}

		if (isNew) { // Create
			this.journal = this.journalManager.create(this.journalBaseTO);
		} else { // Update
			this.journal = this.journalManager.saveBaseTO(this.journalBaseTO);
		}
		final String key = (isNew) ? "journal.added" : "journal.updated";
		this.saveMessage(this.getText(key));

		// journalId setzen
		this.journalId = this.journal.getId();

		/**
		 * if (!isNew) { return INPUT; } else { return SUCCESS; }
		 **/

		return Action.SUCCESS;
	}

	// Verlag aendern

	/**
	 * Sets the verlag id.
	 * 
	 * @param verlagId
	 *            the new verlag id
	 */
	public void setVerlagId(final long verlagId) {
		this.verlagId = verlagId;
	}

	/**
	 * Change verlag.
	 * 
	 * @return the string
	 */
	public String changeVerlag() {
		this.journalManager.connectJournalVerlag(this.journalId, this.verlagId);
		this.load();
		this.saveMessage("Verlag wurde neu zugewiesen.");
		return Action.SUCCESS;
	}

	// Provider aendern

	/**
	 * Sets the provider id.
	 * 
	 * @param providerId
	 *            the new provider id
	 */
	public void setProviderId(final long providerId) {
		this.providerId = providerId;
	}

	/**
	 * Change provider.
	 * 
	 * @return the string
	 */
	public String changeProvider() {
		this.journalManager.connectJournalProvider(this.journalId,
				this.providerId);
		this.load();
		this.saveMessage("Provider wurde neu zugewiesen.");
		return Action.SUCCESS;
	}

	// Konsortium aendern

	/**
	 * Sets the konsortium id.
	 * 
	 * @param konsortiumId
	 *            the new konsortium id
	 */
	public void setKonsortiumId(final long konsortiumId) {
		this.konsortiumId = konsortiumId;
	}

	/**
	 * Change konsortium.
	 * 
	 * @return the string
	 */
	public String changeKonsortium() {
		this.journalManager.connectJournalKonsortium(this.journalId,
				this.konsortiumId);
		this.load();
		this.saveMessage("Konsortium wurde neu zugewiesen.");
		return Action.SUCCESS;
	}

	// Paket aendern

	/**
	 * Sets the paket id.
	 * 
	 * @param paketId
	 *            the new paket id
	 */
	public void setPaketId(final long paketId) {
		this.paketId = paketId;
	}

	/**
	 * Change paket.
	 * 
	 * @return the string
	 */
	public String changePaket() {
		this.journalManager.connectJournalPaket(this.journalId, this.paketId);
		this.load();
		this.saveMessage("Paket wurde neu zugewiesen.");
		return Action.SUCCESS;
	}

	// Bibliotheksmitarbeiter aendern

	/**
	 * Sets the bib id.
	 * 
	 * @param bibId
	 *            the new bib id
	 */
	public void setBibId(final long bibId) {
		this.bibId = bibId;
	}

	/**
	 * Change bibliotheksmitarbeiter.
	 * 
	 * @return the string
	 */
	public String changeBibliotheksmitarbeiter() {
		this.journalManager.connectJournalBibliotheksmitarbeiter(
				this.journalId, this.bibId);
		this.load();
		this.saveMessage("Bibliothek wurde neu zugewiesen.");
		return Action.SUCCESS;
	}

	// Fach aendern

	/**
	 * Sets the fach id.
	 * 
	 * @param fachId
	 *            the new fach id
	 */
	public void setFachId(final long fachId) {
		this.fachId = fachId;
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
	 * Change fach.
	 * 
	 * @return the string
	 */
	public String changeFach() {
		if (!this.journalManager
				.connectJournalFach(this.journalId, this.fachId)) {
			this.saveMessage("Das Fach ist bereits vorhanden.");
		} else {
			this.saveMessage("Das Fach wurde erfolgreich hinzugef�gt.");
		}
		this.load();
		return Action.SUCCESS;
	}

	// ein Fach vom Journal abh�ngen
	/**
	 * Drop fach.
	 * 
	 * @return the string
	 */
	public String dropFach() {
		if (!this.journalManager.disconnectJournalFach(this.journalId,
				this.fachId)) {
			this.saveMessage("Die Zuordnung des Fachs wurde erfolgreich aufgehoben.");
		}
		this.load();
		return Action.SUCCESS;
	}
}
