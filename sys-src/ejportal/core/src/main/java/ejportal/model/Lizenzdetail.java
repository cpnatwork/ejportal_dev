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
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 15:55:15 To
 * change this template use File | Settings | File Templates.
 */
@Entity
public class Lizenzdetail extends BaseObject {

	/** The lizenz id. */
	private Long lizenzId;

	/** The verlag. */
	private Institution verlag;

	/** The beginn. */
	private String beginn;

	/** The laufzeit. */
	private String laufzeit;

	/** The verlaengerung. */
	private String verlaengerung;

	/** The kosten. */
	private float kosten;

	/** The readme aktualisiert. */
	private String readmeAktualisiert;

	/**
	 * Gets the lizenz id.
	 * 
	 * @return the lizenz id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getLizenzId() {
		return this.lizenzId;
	}

	/**
	 * Sets the lizenz id.
	 * 
	 * @param lizenzId
	 *            the new lizenz id
	 */
	public void setLizenzId(final Long lizenzId) {
		this.lizenzId = lizenzId;
	}

	/**
	 * Gets the verlag.
	 * 
	 * @return the verlag
	 */
	@ManyToOne
	public Institution getVerlag() {
		return this.verlag;
	}

	/**
	 * Sets the verlag.
	 * 
	 * @param verlag
	 *            the new verlag
	 */
	public void setVerlag(final Institution verlag) {
		this.verlag = verlag;
	}

	/**
	 * Gets the beginn.
	 * 
	 * @return the beginn
	 */
	public String getBeginn() {
		return this.beginn;
	}

	/**
	 * Sets the beginn.
	 * 
	 * @param beginn
	 *            the new beginn
	 */
	public void setBeginn(final String beginn) {
		this.beginn = beginn;
	}

	/**
	 * Gets the laufzeit.
	 * 
	 * @return the laufzeit
	 */
	public String getLaufzeit() {
		return this.laufzeit;
	}

	/**
	 * Sets the laufzeit.
	 * 
	 * @param laufzeit
	 *            the new laufzeit
	 */
	public void setLaufzeit(final String laufzeit) {
		this.laufzeit = laufzeit;
	}

	/**
	 * Gets the verlaengerung.
	 * 
	 * @return the verlaengerung
	 */
	public String getVerlaengerung() {
		return this.verlaengerung;
	}

	/**
	 * Sets the verlaengerung.
	 * 
	 * @param verlaengerung
	 *            the new verlaengerung
	 */
	public void setVerlaengerung(final String verlaengerung) {
		this.verlaengerung = verlaengerung;
	}

	/**
	 * Gets the kosten.
	 * 
	 * @return the kosten
	 */
	public float getKosten() {
		return this.kosten;
	}

	/**
	 * Sets the kosten.
	 * 
	 * @param kosten
	 *            the new kosten
	 */
	public void setKosten(final float kosten) {
		this.kosten = kosten;
	}

	/**
	 * Gets the readme aktualisiert.
	 * 
	 * @return the readme aktualisiert
	 */
	public String getReadmeAktualisiert() {
		return this.readmeAktualisiert;
	}

	/**
	 * Sets the readme aktualisiert.
	 * 
	 * @param readmeAktualisiert
	 *            the new readme aktualisiert
	 */
	public void setReadmeAktualisiert(final String readmeAktualisiert) {
		this.readmeAktualisiert = readmeAktualisiert;
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

		final Lizenzdetail that = (Lizenzdetail) o;

		if (Float.compare(that.kosten, this.kosten) != 0)
			return false;
		if (this.beginn != null ? !this.beginn.equals(that.beginn)
				: that.beginn != null)
			return false;
		if (this.laufzeit != null ? !this.laufzeit.equals(that.laufzeit)
				: that.laufzeit != null)
			return false;
		if (this.lizenzId != null ? !this.lizenzId.equals(that.lizenzId)
				: that.lizenzId != null)
			return false;
		if (this.readmeAktualisiert != null ? !this.readmeAktualisiert
				.equals(that.readmeAktualisiert)
				: that.readmeAktualisiert != null)
			return false;
		if (this.verlaengerung != null ? !this.verlaengerung
				.equals(that.verlaengerung) : that.verlaengerung != null)
			return false;
		if (this.verlag != null ? !this.verlag.equals(that.verlag)
				: that.verlag != null)
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
		int result = this.lizenzId != null ? this.lizenzId.hashCode() : 0;
		result = (31 * result)
				+ (this.verlag != null ? this.verlag.hashCode() : 0);
		result = (31 * result)
				+ (this.beginn != null ? this.beginn.hashCode() : 0);
		result = (31 * result)
				+ (this.laufzeit != null ? this.laufzeit.hashCode() : 0);
		result = (31 * result)
				+ (this.verlaengerung != null ? this.verlaengerung.hashCode()
						: 0);
		result = (31 * result)
				+ (this.kosten != +0.0f ? Float.floatToIntBits(this.kosten) : 0);
		result = (31 * result)
				+ (this.readmeAktualisiert != null ? this.readmeAktualisiert
						.hashCode() : 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return "" + this.lizenzId + " " + this.laufzeit;
	}
}
