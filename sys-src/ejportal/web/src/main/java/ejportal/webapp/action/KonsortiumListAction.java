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

import ejportal.service.KonsortiumManager;

/**
 * Created by IntelliJ IDEA. User: Janine Date: 14.07.2010 Time: 16:05:53 To
 * change this template use File | Settings | File Templates.
 */
public class KonsortiumListAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1799123744984012592L;

	/** The konsortium manager. */
	private KonsortiumManager konsortiumManager;

	/** The konsortien. */
	private List konsortien;

	// fuer die Suche
	/** The konsortium name. */
	String konsortiumName;

	/**
	 * Sets the konsortium manager.
	 * 
	 * @param konsortiumManager
	 *            the new konsortium manager
	 */
	public void setKonsortiumManager(final KonsortiumManager konsortiumManager) {
		this.konsortiumManager = konsortiumManager;
	}

	/**
	 * Gets the konsortien.
	 * 
	 * @return the konsortien
	 */
	public List getKonsortien() {
		return this.konsortien;
	}

	/**
	 * List all.
	 * 
	 * @return the string
	 */
	public String listAll() {
		this.konsortien = this.konsortiumManager.getAll();
		return Action.SUCCESS;
	}

	// Suche
	/**
	 * Sets the konsortium name.
	 * 
	 * @param konsortiumName
	 *            the new konsortium name
	 */
	public void setKonsortiumName(final String konsortiumName) {
		this.konsortiumName = konsortiumName;
	}

	/**
	 * Search.
	 * 
	 * @return the string
	 */
	public String search() {
		final int maxResults = 100;
		this.konsortien = this.konsortiumManager.findByKonsortiumName(
				this.konsortiumName, maxResults);

		if (this.konsortien.size() == maxResults) {
			this.saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als "
					+ this.konsortien.size() + " Konsortien gefunden wurden.");
			this.saveMessage("Die ersten " + maxResults
					+ " Ergebnisse werden angezeigt.");
		}
		// TODO Fehlerbehandlung Suche
		return Action.SUCCESS;
	}

}