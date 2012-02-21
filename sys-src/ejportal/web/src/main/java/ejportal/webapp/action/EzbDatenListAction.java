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

import ejportal.service.EzbDatenManager;
import ejportal.service.dto.EzbDatenSearchTO;

/**
 * Created by IntelliJ IDEA. User: Florian Date: 10.08.2010 Time: 10:30:29 To
 * change this template use File | Settings | File Templates.
 */
public class EzbDatenListAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4557019142853507612L;

	/** The ezb daten manager. */
	private EzbDatenManager ezbDatenManager;

	/** The ezb daten search to. */
	private EzbDatenSearchTO ezbDatenSearchTO;

	/** The ezb daten. */
	private List ezbDaten;

	/**
	 * Sets the ezb daten manager.
	 * 
	 * @param ezbDatenManager
	 *            the new ezb daten manager
	 */
	public void setEzbDatenManager(final EzbDatenManager ezbDatenManager) {
		this.ezbDatenManager = ezbDatenManager;
	}

	/**
	 * Gets the ezb daten.
	 * 
	 * @return the ezb daten
	 */
	public List getEzbDaten() {
		return this.ezbDaten;
	}

	/**
	 * Inits the search.
	 * 
	 * @return the string
	 */
	public String initSearch() {
		// ezbDatenSearchTO=new EzbDatenSearchTO();
		return Action.SUCCESS;
	}

	// Suche
	/**
	 * Gets the ezb daten search to.
	 * 
	 * @return the ezb daten search to
	 */
	public EzbDatenSearchTO getEzbDatenSearchTO() {
		return this.ezbDatenSearchTO;
	}

	/**
	 * Sets the ezb daten search to.
	 * 
	 * @param ezbDatenSearchTO
	 *            the new ezb daten search to
	 */
	public void setEzbDatenSearchTO(final EzbDatenSearchTO ezbDatenSearchTO) {
		this.ezbDatenSearchTO = ezbDatenSearchTO;
	}

	/**
	 * Search.
	 * 
	 * @return the string
	 */
	public String search() {
		final int maxResults = 100;

		// Prüfen, ob ezbid eine Zahl ist.
		if (!this.ezbDatenSearchTO.getEzbId().equals("")) {
			try {
				Long.parseLong(this.ezbDatenSearchTO.getEzbId());
			} catch (final NumberFormatException e) {
				this.saveMessage(this
						.getText("Im Feld EZB-Id darf nur eine Zahl angegeben werden"));
				return "back";
			}
		}

		this.ezbDaten = this.ezbDatenManager.findBySearchTO(
				this.ezbDatenSearchTO, maxResults);

		if (this.ezbDaten.size() == maxResults) {
			this.saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als "
					+ this.ezbDaten.size() + " EZB Daten gefunden wurden.");
			this.saveMessage("Die ersten " + maxResults
					+ " Ergebnisse werden angezeigt.");
		}
		// TODO Fehlerbehandlung Suche
		return Action.SUCCESS;
	}

}
