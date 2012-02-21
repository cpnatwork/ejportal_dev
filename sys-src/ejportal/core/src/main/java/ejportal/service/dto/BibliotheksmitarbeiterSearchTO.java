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
package ejportal.service.dto;

/**
 * Created by IntelliJ IDEA. User: Nina Date: 05.08.2010 Time: 13:30:08 To
 * change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterSearchTO {

	/** The journal id. */
	private Long journalId;

	/** The name. */
	private String name;

	/** The abteilungs hauptstelle. */
	private String abteilungsHauptstelle;

	/** The emailanschrift. */
	private String emailanschrift;

	/**
	 * Gets the journal id.
	 * 
	 * @return the journal id
	 */
	public Long getJournalId() {
		return this.journalId;
	}

	/**
	 * Sets the journal id.
	 * 
	 * @param journalId
	 *            the new journal id
	 */
	public void setJournalId(final Long journalId) {
		this.journalId = journalId;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the abteilungs hauptstelle.
	 * 
	 * @return the abteilungs hauptstelle
	 */
	public String getAbteilungsHauptstelle() {
		return this.abteilungsHauptstelle;
	}

	/**
	 * Sets the abteilungs hauptstelle.
	 * 
	 * @param abteilungsHauptstelle
	 *            the new abteilungs hauptstelle
	 */
	public void setAbteilungsHauptstelle(final String abteilungsHauptstelle) {
		this.abteilungsHauptstelle = abteilungsHauptstelle;
	}

	/**
	 * Gets the emailanschrift.
	 * 
	 * @return the emailanschrift
	 */
	public String getEmailanschrift() {
		return this.emailanschrift;
	}

	/**
	 * Sets the emailanschrift.
	 * 
	 * @param emailanschrift
	 *            the new emailanschrift
	 */
	public void setEmailanschrift(final String emailanschrift) {
		this.emailanschrift = emailanschrift;
	}
}
