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
package ejportal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.appfuse.model.BaseObject;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 15:35:49 To
 * change this template use File | Settings | File Templates.
 */

@Entity
public class Besteller extends BaseObject {

	/** The besteller id. */
	private Long bestellerId;

	/** The sigel. */
	private Sigel sigel;

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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	 * Gets the sigel.
	 * 
	 * @return the sigel
	 */
	@ManyToOne
	public Sigel getSigel() {
		return this.sigel;
	}

	/**
	 * Sets the sigel.
	 * 
	 * @param sigel
	 *            the new sigel
	 */
	public void setSigel(final Sigel sigel) {
		this.sigel = sigel;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;

		final Besteller besteller = (Besteller) o;

		if (Float.compare(besteller.einzahlungErwuenscht,
				this.einzahlungErwuenscht) != 0)
			return false;
		if (Float.compare(besteller.einzahlungFestgelegt,
				this.einzahlungFestgelegt) != 0)
			return false;
		if (this.anrede != null ? !this.anrede.equals(besteller.anrede)
				: besteller.anrede != null)
			return false;
		if (this.bestellerId != null ? !this.bestellerId
				.equals(besteller.bestellerId) : besteller.bestellerId != null)
			return false;
		if (this.bestellerName != null ? !this.bestellerName
				.equals(besteller.bestellerName)
				: besteller.bestellerName != null)
			return false;
		if (this.funktion != null ? !this.funktion.equals(besteller.funktion)
				: besteller.funktion != null)
			return false;
		if (this.projekt != null ? !this.projekt.equals(besteller.projekt)
				: besteller.projekt != null)
			return false;
		if (this.sigel != null ? !this.sigel.equals(besteller.sigel)
				: besteller.sigel != null)
			return false;

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#hashCode()
	 */
	@Override
	public int hashCode() {
		int result = this.bestellerId != null ? this.bestellerId.hashCode() : 0;
		result = (31 * result)
				+ (this.sigel != null ? this.sigel.hashCode() : 0);
		result = (31 * result)
				+ (this.anrede != null ? this.anrede.hashCode() : 0);
		result = (31 * result)
				+ (this.bestellerName != null ? this.bestellerName.hashCode()
						: 0);
		result = (31 * result)
				+ (this.funktion != null ? this.funktion.hashCode() : 0);
		result = (31 * result)
				+ (this.projekt != null ? this.projekt.hashCode() : 0);
		result = (31 * result)
				+ (this.einzahlungErwuenscht != +0.0f ? Float
						.floatToIntBits(this.einzahlungErwuenscht) : 0);
		result = (31 * result)
				+ (this.einzahlungFestgelegt != +0.0f ? Float
						.floatToIntBits(this.einzahlungFestgelegt) : 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return this.anrede + " " + this.bestellerName;
	}
}
