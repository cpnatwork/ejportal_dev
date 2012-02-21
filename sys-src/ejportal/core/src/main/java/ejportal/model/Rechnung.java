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
 * Created by IntelliJ IDEA. User: Tselmeg Date: 09.08.2010 Time: 13:59:04 To
 * change this template use File | Settings | File Templates.
 */
@Entity
public class Rechnung extends BaseObject {

	/** The rechnung id. */
	private Long rechnungId;

	/** The exemplar. */
	private Exemplar exemplar;

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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	 * Gets the exemplar.
	 * 
	 * @return the exemplar
	 */
	@ManyToOne
	public Exemplar getExemplar() {
		return this.exemplar;
	}

	/**
	 * Sets the exemplar.
	 * 
	 * @param exemplar
	 *            the new exemplar
	 */
	public void setExemplar(final Exemplar exemplar) {
		this.exemplar = exemplar;
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

		final Rechnung rechnung = (Rechnung) o;
		final Float betragF = new Float(this.betrag);
		if (betragF != null ? !betragF.equals(rechnung.betrag) : new Float(
				rechnung.betrag) != null)
			return false;
		if (this.rechnungId != null ? !this.rechnungId
				.equals(rechnung.rechnungId) : rechnung.rechnungId != null)
			return false;
		if (this.bezugsform != null ? !this.bezugsform
				.equals(rechnung.bezugsform) : rechnung.bezugsform != null)
			return false;
		if (this.bezugsjahr != null ? !this.bezugsjahr
				.equals(rechnung.bezugsjahr) : rechnung.bezugsjahr != null)
			return false;
		if (this.exemplar != null ? !this.exemplar.equals(rechnung.exemplar)
				: rechnung.exemplar != null)
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
		int result = this.rechnungId != null ? this.rechnungId.hashCode() : 0;
		result = (31 * result)
				+ (this.betrag != +0.0f ? Float.floatToIntBits(this.betrag) : 0);
		result = (31 * result)
				+ (this.bezugsform != null ? this.bezugsform.hashCode() : 0);
		result = (31 * result)
				+ (this.bezugsjahr != null ? this.bezugsjahr.hashCode() : 0);
		result = (31 * result)
				+ (this.exemplar != null ? this.exemplar.hashCode() : 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return ("" + this.rechnungId + " " + this.betrag);
	}

}
