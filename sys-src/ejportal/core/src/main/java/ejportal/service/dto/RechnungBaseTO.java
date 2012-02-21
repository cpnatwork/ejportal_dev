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
 * Created by IntelliJ IDEA. User: Tselmeg Date: 10.08.2010 Time: 13:38:56 To
 * change this template use File | Settings | File Templates.
 */
public class RechnungBaseTO {

	/** The rechnung id. */
	private Long rechnungId;

	/** The betrag. */
	private float betrag;

	/** The bezugsform. */
	private String bezugsform;

	/** The bezugsjahr. */
	private String bezugsjahr;

	/**
	 * Gets the rechnung id.
	 * 
	 * @return the rechnung id
	 */
	public Long getRechnungId() {
		return this.rechnungId;
	}

	/**
	 * Sets the rechnung id.
	 * 
	 * @param rechnungId
	 *            the new rechnung id
	 */
	public void setRechnungId(final Long rechnungId) {
		this.rechnungId = rechnungId;
	}

	/**
	 * Gets the betrag.
	 * 
	 * @return the betrag
	 */
	public float getBetrag() {
		return this.betrag;
	}

	/**
	 * Sets the betrag.
	 * 
	 * @param betrag
	 *            the new betrag
	 */
	public void setBetrag(final float betrag) {
		this.betrag = betrag;
	}

	/**
	 * Gets the bezugsform.
	 * 
	 * @return the bezugsform
	 */
	public String getBezugsform() {
		return this.bezugsform;
	}

	/**
	 * Sets the bezugsform.
	 * 
	 * @param bezugsform
	 *            the new bezugsform
	 */
	public void setBezugsform(final String bezugsform) {
		this.bezugsform = bezugsform;
	}

	/**
	 * Gets the bezugsjahr.
	 * 
	 * @return the bezugsjahr
	 */
	public String getBezugsjahr() {
		return this.bezugsjahr;
	}

	/**
	 * Sets the bezugsjahr.
	 * 
	 * @param bezugsjahr
	 *            the new bezugsjahr
	 */
	public void setBezugsjahr(final String bezugsjahr) {
		this.bezugsjahr = bezugsjahr;
	}
}
