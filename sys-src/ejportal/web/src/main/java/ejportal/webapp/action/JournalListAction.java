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

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;

import ejportal.service.JournalManager;
import ejportal.service.dto.JournalSearchTO;

/**
 * Created by IntelliJ IDEA. User: Florian Date: 24.06.2010 Time: 14:29:00 To
 * change this template use File | Settings | File Templates.
 */
public class JournalListAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1847023681270520333L;

	/** The journal manager. */
	private JournalManager journalManager;

	/** The journal search to. */
	private JournalSearchTO journalSearchTO;

	/** The journals. */
	private List journals;

	/** The verlag id. */
	private int verlagId;

	/** The max date. */
	private Date maxDate = new Date();

	/** The max date param. */
	private int maxDateParam;

	/** The select data. */
	private final SelectData selectData = new SelectData();

	/**
	 * Sets the journal manager.
	 * 
	 * @param journalManager
	 *            the new journal manager
	 */
	public void setJournalManager(final JournalManager journalManager) {
		this.journalManager = journalManager;
	}

	/**
	 * List all.
	 * 
	 * @return the string
	 */
	public String listAll() {
		this.journals = this.journalManager.getAll();
		return Action.SUCCESS;
	}

	/**
	 * List bearbeitungsdatum.
	 * 
	 * @return the string
	 */
	public String listBearbeitungsdatum() {
		switch (this.maxDateParam) {
		case 7:
			this.journals = this.journalManager.findByBearbeitungsdatum(this
					.addDates(7));
			break;
		case 14:
			this.journals = this.journalManager.findByBearbeitungsdatum(this
					.addDates(14));
			break;
		default:
			this.journals = this.journalManager.findByBearbeitungsdatum(this
					.addDates(14));
		}
		return Action.SUCCESS;
	}

	/**
	 * List bearbeitungsdatum all.
	 * 
	 * @return the string
	 */
	public String listBearbeitungsdatumAll() {
		this.journals = this.journalManager.findByBearbeitungsdatumAll();
		return Action.SUCCESS;
	}

	/**
	 * Adds the dates.
	 * 
	 * @param i
	 *            the i
	 * @return the date
	 */
	private Date addDates(final int i) {
		// Get a Calendar for current locale and time zone
		final Calendar cal = Calendar.getInstance();
		// Get a Date object that represents 30 days from now
		final Date today = new Date(); // Current date
		cal.setTime(today); // Set it in the Calendar object
		cal.add(Calendar.DATE, i); // Add 30 days
		return cal.getTime(); // Retrieve the resulting date
	}

	/**
	 * Gets the journals.
	 * 
	 * @return the journals
	 */
	public List getJournals() {
		return this.journals;
	}

	// Journal Suche
	/**
	 * Gets the journal search to.
	 * 
	 * @return the journal search to
	 */
	public JournalSearchTO getJournalSearchTO() {
		return this.journalSearchTO;
	}

	/**
	 * Sets the journal search to.
	 * 
	 * @param journalSearchTO
	 *            the new journal search to
	 */
	public void setJournalSearchTO(final JournalSearchTO journalSearchTO) {
		this.journalSearchTO = journalSearchTO;
	}

	/**
	 * Search.
	 * 
	 * @return the string
	 */
	public String search() {
		this.log.debug(">>> JournalListAction.search: journalSearchTO="
				+ this.journalSearchTO.toString());
		final int maxResults = 100;
		this.journals = this.journalManager.search(this.journalSearchTO,
				maxResults);
		if (this.journals.size() == maxResults) {
			this.saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als "
					+ this.journals.size() + " Journale gefunden wurden.");
			this.saveMessage("Die ersten " + maxResults
					+ " Ergebnisse werden angezeigt.");
		}

		// TODO Fehlerbehandlung
		return Action.SUCCESS;
	}

	// Journals nach Institution
	/**
	 * Sets the verlag id.
	 * 
	 * @param verlagId
	 *            the new verlag id
	 */
	public void setVerlagId(final int verlagId) {
		this.verlagId = verlagId;
	}

	/**
	 * List by verlag.
	 * 
	 * @return the string
	 */
	public String listByVerlag() {
		this.journals = this.journalManager.findByVerlagId(this.verlagId);
		return Action.SUCCESS;
	}

	// Bearbeitungsdatum

	/**
	 * Gets the max date.
	 * 
	 * @return the max date
	 */
	public Date getMaxDate() {
		return this.maxDate;
	}

	/**
	 * Sets the max date.
	 * 
	 * @param maxDate
	 *            the new max date
	 */
	public void setMaxDate(final Date maxDate) {
		this.maxDate = maxDate;
	}

	/**
	 * Gets the max date param.
	 * 
	 * @return the max date param
	 */
	public int getMaxDateParam() {
		return this.maxDateParam;
	}

	/**
	 * Sets the max date param.
	 * 
	 * @param maxDateParam
	 *            the new max date param
	 */
	public void setMaxDateParam(final int maxDateParam) {
		this.maxDateParam = maxDateParam;
	}

	// Dropdown Zugang �ber

	/**
	 * Gets the list zugang ueber.
	 * 
	 * @return the list zugang ueber
	 */
	public Map<String, String> getListZugangUeber() {
		return this.selectData.getJournalZugangUeber();
	}
}
