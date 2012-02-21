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
 * Created by IntelliJ IDEA. User: Florian Date: 10.08.2010 Time: 10:29:16 To
 * change this template use File | Settings | File Templates.
 */
public class EzbDatenSearchTO {

	/** The ezb id. */
	private String ezbId;

	/** The titel. */
	private String titel;

	/** The zdb nummer. */
	private String zdbNummer;

	/**
	 * Gets the ezb id.
	 * 
	 * @return the ezb id
	 */
	public String getEzbId() {
		return this.ezbId;
	}

	/**
	 * Sets the ezb id.
	 * 
	 * @param ezbId
	 *            the new ezb id
	 */
	public void setEzbId(final String ezbId) {
		this.ezbId = ezbId;
	}

	/**
	 * Gets the titel.
	 * 
	 * @return the titel
	 */
	public String getTitel() {
		return this.titel;
	}

	/**
	 * Sets the titel.
	 * 
	 * @param titel
	 *            the new titel
	 */
	public void setTitel(final String titel) {
		this.titel = titel;
	}

	/**
	 * Gets the zdb nummer.
	 * 
	 * @return the zdb nummer
	 */
	public String getZdbNummer() {
		return this.zdbNummer;
	}

	/**
	 * Sets the zdb nummer.
	 * 
	 * @param zdbNummer
	 *            the new zdb nummer
	 */
	public void setZdbNummer(final String zdbNummer) {
		this.zdbNummer = zdbNummer;
	}
}
