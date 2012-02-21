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

import com.opensymphony.xwork2.Action;

import ejportal.service.BibliotheksmitarbeiterManager;
import ejportal.service.dto.BibliotheksmitarbeiterSearchTO;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 05.08.2010 Time: 13:05:05 To
 * change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterListAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5749207743545171935L;

	/** The bibliotheksmitarbeiter manager. */
	private BibliotheksmitarbeiterManager bibliotheksmitarbeiterManager;

	/** The bibliotheksmitarbeiter search to. */
	private BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO;

	/** The bibliotheksmitarbeiters. */
	private List bibliotheksmitarbeiters;

	// fuer die Suche
	/** The name. */
	String name;

	/**
	 * Sets the bibliotheksmitarbeiter manager.
	 * 
	 * @param bibliotheksmitarbeiterManager
	 *            the new bibliotheksmitarbeiter manager
	 */
	public void setBibliotheksmitarbeiterManager(
			final BibliotheksmitarbeiterManager bibliotheksmitarbeiterManager) {
		this.bibliotheksmitarbeiterManager = bibliotheksmitarbeiterManager;
	}

	/**
	 * Gets the bibliotheksmitarbeiters.
	 * 
	 * @return the bibliotheksmitarbeiters
	 */
	public List getBibliotheksmitarbeiters() {
		return this.bibliotheksmitarbeiters;
	}

	/**
	 * List all.
	 * 
	 * @return the string
	 */
	public String listAll() {
		this.bibliotheksmitarbeiters = this.bibliotheksmitarbeiterManager
				.getAll();
		return Action.SUCCESS;
	}

	// Suche
	/**
	 * Sets the bibliotheksmitarbeiter name.
	 * 
	 * @param name
	 *            the new bibliotheksmitarbeiter name
	 */
	public void setBibliotheksmitarbeiterName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the bibliotheksmitarbeiter search to.
	 * 
	 * @return the bibliotheksmitarbeiter search to
	 */
	public BibliotheksmitarbeiterSearchTO getBibliotheksmitarbeiterSearchTO() {
		return this.bibliotheksmitarbeiterSearchTO;
	}

	/**
	 * Sets the bibliotheksmitarbeiter search to.
	 * 
	 * @param bibliotheksmitarbeiterSearchTO
	 *            the new bibliotheksmitarbeiter search to
	 */
	public void setBibliotheksmitarbeiterSearchTO(
			final BibliotheksmitarbeiterSearchTO bibliotheksmitarbeiterSearchTO) {
		this.bibliotheksmitarbeiterSearchTO = bibliotheksmitarbeiterSearchTO;
	}

	/**
	 * Search.
	 * 
	 * @return the string
	 */
	public String search() {
		final int maxResults = 100;
		this.bibliotheksmitarbeiters = this.bibliotheksmitarbeiterManager
				.findBySearchTO(this.bibliotheksmitarbeiterSearchTO, maxResults);

		if (this.bibliotheksmitarbeiters.size() == maxResults) {
			this.saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als "
					+ this.bibliotheksmitarbeiters.size()
					+ " Bibliothek gefunden wurden.");
			this.saveMessage("Die ersten " + maxResults
					+ " Ergebnisse werden angezeigt.");
		}
		// TODO Fehlerbehandlung Suche
		return Action.SUCCESS;
	}

}
