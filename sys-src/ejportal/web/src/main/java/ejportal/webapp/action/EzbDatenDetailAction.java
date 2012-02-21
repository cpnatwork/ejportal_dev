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

import ejportal.model.EzbDaten;
import ejportal.service.EzbDatenManager;

/**
 * Created by IntelliJ IDEA. User: Florian Date: 09.08.2010 Time: 17:54:57 To
 * change this template use File | Settings | File Templates.
 */
public class EzbDatenDetailAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3314683016077568442L;

	/** The ezb daten manager. */
	private EzbDatenManager ezbDatenManager;

	/** The ezb daten. */
	private EzbDaten ezbDaten;

	/** The ezb id. */
	private Long ezbId;

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
	public EzbDaten getEzbDaten() {
		return this.ezbDaten;
	}

	/**
	 * Sets the ezb daten.
	 * 
	 * @param ezbDaten
	 *            the new ezb daten
	 */
	public void setEzbDaten(final EzbDaten ezbDaten) {
		this.ezbDaten = ezbDaten;
	}

	/**
	 * Gets the ezb id.
	 * 
	 * @return the ezb id
	 */
	public Long getEzbId() {
		return this.ezbId;
	}

	/**
	 * Sets the ezb id.
	 * 
	 * @param ezbId
	 *            the new ezb id
	 */
	public void setEzbId(final Long ezbId) {
		this.ezbId = ezbId;
	}

	/**
	 * Load with journal id.
	 * 
	 * @return the string
	 */
	public String loadWithJournalId() {
		if (this.journalId != null) {
			this.ezbDaten = this.ezbDatenManager
					.loadWithJournalId(this.journalId);
		} else
			return Action.ERROR;

		return Action.SUCCESS;
	}

	/**
	 * Change ezb daten.
	 * 
	 * @return the string
	 */
	public String changeEzbDaten() {
		this.ezbDatenManager.connectEzbDaten(this.ezbId, this.journalId);
		this.loadWithJournalId();
		this.saveMessage("EZB Daten wurden neu zugewiesen.");
		return Action.SUCCESS;
	}

	/**
	 * Import ezb daten.
	 * 
	 * @return the string
	 */
	public String importEzbDaten() {
		this.journalId = this.ezbDatenManager.createJournal(this.ezbId).getId();
		return Action.SUCCESS;
	}

}
