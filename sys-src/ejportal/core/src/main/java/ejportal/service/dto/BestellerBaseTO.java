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
 * Created by IntelliJ IDEA. User: mkoerner Date: 10.08.2010 Time: 11:22:54 To
 * change this template use File | Settings | File Templates.
 */
public class BestellerBaseTO {

	/** The besteller id. */
	private Long bestellerId;

	/** The anrede. */
	private String anrede;

	/** The besteller name. */
	private String bestellerName;

	/** The funktion. */
	private String funktion;

	/** The projekt. */
	private String projekt;

	/** The einzahlung erwuenscht. */
	private float einzahlungErwuenscht;

	/** The einzahlung festgelegt. */
	private float einzahlungFestgelegt;

	/**
	 * Gets the besteller id.
	 * 
	 * @return the besteller id
	 */
	public Long getBestellerId() {
		return this.bestellerId;
	}

	/**
	 * Sets the besteller id.
	 * 
	 * @param bestellerId
	 *            the new besteller id
	 */
	public void setBestellerId(final Long bestellerId) {
		this.bestellerId = bestellerId;
	}

	/**
	 * Gets the anrede.
	 * 
	 * @return the anrede
	 */
	public String getAnrede() {
		return this.anrede;
	}

	/**
	 * Sets the anrede.
	 * 
	 * @param anrede
	 *            the new anrede
	 */
	public void setAnrede(final String anrede) {
		this.anrede = anrede;
	}

	/**
	 * Gets the besteller name.
	 * 
	 * @return the besteller name
	 */
	public String getBestellerName() {
		return this.bestellerName;
	}

	/**
	 * Sets the besteller name.
	 * 
	 * @param bestellerName
	 *            the new besteller name
	 */
	public void setBestellerName(final String bestellerName) {
		this.bestellerName = bestellerName;
	}

	/**
	 * Gets the funktion.
	 * 
	 * @return the funktion
	 */
	public String getFunktion() {
		return this.funktion;
	}

	/**
	 * Sets the funktion.
	 * 
	 * @param funktion
	 *            the new funktion
	 */
	public void setFunktion(final String funktion) {
		this.funktion = funktion;
	}

	/**
	 * Gets the projekt.
	 * 
	 * @return the projekt
	 */
	public String getProjekt() {
		return this.projekt;
	}

	/**
	 * Sets the projekt.
	 * 
	 * @param projekt
	 *            the new projekt
	 */
	public void setProjekt(final String projekt) {
		this.projekt = projekt;
	}

	/**
	 * Gets the einzahlung erwuenscht.
	 * 
	 * @return the einzahlung erwuenscht
	 */
	public float getEinzahlungErwuenscht() {
		return this.einzahlungErwuenscht;
	}

	/**
	 * Sets the einzahlung erwuenscht.
	 * 
	 * @param einzahlungErwuenscht
	 *            the new einzahlung erwuenscht
	 */
	public void setEinzahlungErwuenscht(final float einzahlungErwuenscht) {
		this.einzahlungErwuenscht = einzahlungErwuenscht;
	}

	/**
	 * Gets the einzahlung festgelegt.
	 * 
	 * @return the einzahlung festgelegt
	 */
	public float getEinzahlungFestgelegt() {
		return this.einzahlungFestgelegt;
	}

	/**
	 * Sets the einzahlung festgelegt.
	 * 
	 * @param einzahlungFestgelegt
	 *            the new einzahlung festgelegt
	 */
	public void setEinzahlungFestgelegt(final float einzahlungFestgelegt) {
		this.einzahlungFestgelegt = einzahlungFestgelegt;
	}
}
