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

import ejportal.service.PaketManager;

/**
 * Created by IntelliJ IDEA. User: Janine Date: 19.07.2010 Time: 14:03:47 To
 * change this template use File | Settings | File Templates.
 */
public class PaketListAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3200127502202307502L;

	/** The paket manager. */
	private PaketManager paketManager;

	/** The pakete. */
	private List pakete;

	/** The paket name. */
	private String paketName; // fuer die Suche

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
	 * Gets the pakete.
	 * 
	 * @return the pakete
	 */
	public List getPakete() {
		return this.pakete;
	}

	/**
	 * List all.
	 * 
	 * @return the string
	 */
	public String listAll() {
		this.pakete = this.paketManager.getAll();
		return Action.SUCCESS;
	}

	// Suche

	/**
	 * Sets the paket name.
	 * 
	 * @param paketName
	 *            the new paket name
	 */
	public void setPaketName(final String paketName) {
		this.paketName = paketName;
	}

	/**
	 * Search.
	 * 
	 * @return the string
	 */
	public String search() {
		final int maxResults = 100;

		/*
		 * if(!paketName.equals("")){ pakete =
		 * paketManager.findByPaketName(paketName); } else{ //TODO Ist das so
		 * gewuenscht? Ohne Suchparameter --> alle laden?!?!?! pakete =
		 * paketManager.getAll(); }
		 */
		this.pakete = this.paketManager.findByPaketName(this.paketName,
				maxResults);

		if (this.pakete.size() == maxResults) {
			this.saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als "
					+ this.pakete.size() + " Pakete gefunden wurden.");
			this.saveMessage("Die ersten " + maxResults
					+ " Ergebnisse werden angezeigt.");
		}
		// TODO Fehlerbehandlung Suche
		return Action.SUCCESS;
	}
}