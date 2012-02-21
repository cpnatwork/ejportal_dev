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

import ejportal.service.FachManager;

/**
 * Created by IntelliJ IDEA. User: ev55esul Date: 02.08.2010 Time: 17:29:53 To
 * change this template use File | Settings | File Templates.
 */
public class FachListAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5740352639021129044L;

	/** The fach manager. */
	private FachManager fachManager;

	/** The faecher. */
	private List faecher;

	// fuer die Suche
	/** The fach name. */
	String fachName;

	/**
	 * Sets the fach manager.
	 * 
	 * @param fachManager
	 *            the new fach manager
	 */
	public void setFachManager(final FachManager fachManager) {
		this.fachManager = fachManager;
	}

	/**
	 * Gets the faecher.
	 * 
	 * @return the faecher
	 */
	public List getFaecher() {
		return this.faecher;
	}

	/**
	 * List all.
	 * 
	 * @return the string
	 */
	public String listAll() {
		this.faecher = this.fachManager.getAll();
		return Action.SUCCESS;
	}

	// Suche
	/**
	 * Sets the fach name.
	 * 
	 * @param fachName
	 *            the new fach name
	 */
	public void setFachName(final String fachName) {
		this.fachName = fachName;
	}

	/**
	 * Search.
	 * 
	 * @return the string
	 */
	public String search() {
		final int maxResults = 100;
		/*
		 * if(!fachName.equals("")){ faecher =
		 * fachManager.findByFachName(fachName); } else{ //TODO Ist das so
		 * gewuenscht? Ohne Suchparameter --> alle laden?!?!?! faecher =
		 * fachManager.getAll(); }
		 */
		this.faecher = this.fachManager.findByFachName(this.fachName,
				maxResults);
		if (this.faecher.size() == maxResults) {
			this.saveMessage("Bitte verfeinern Sie Ihre Anfrage, da momentan mehr als "
					+ this.faecher.size() + " F&auml;cher gefunden wurden.");
			this.saveMessage("Die ersten " + maxResults
					+ " Ergebnisse werden angezeigt.");
		}
		return Action.SUCCESS;
	}

}