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

import org.appfuse.model.BaseObject;

/**
 * Created by IntelliJ IDEA. User: ag35ogub Date: 11.08.2010 Time: 12:28:22 To
 * change this template use File | Settings | File Templates.
 */
@Entity
public class Wechselkurs extends BaseObject {

	/** The wechselkurs id. */
	private Long wechselkursId;

	/** The waehrung. */
	private String waehrung;

	/** The umrechnungsfaktor. */
	private float umrechnungsfaktor;

	// getter and setter

	/**
	 * Gets the wechselkurs id.
	 * 
	 * @return the wechselkurs id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getWechselkursId() {
		return this.wechselkursId;
	}

	/**
	 * Sets the wechselkurs id.
	 * 
	 * @param id
	 *            the new wechselkurs id
	 */
	public void setWechselkursId(final Long id) {
		this.wechselkursId = id;
	}

	/**
	 * Gets the waehrung.
	 * 
	 * @return the waehrung
	 */
	public String getWaehrung() {
		return this.waehrung;
	}

	/**
	 * Sets the waehrung.
	 * 
	 * @param waehrung
	 *            the new waehrung
	 */
	public void setWaehrung(final String waehrung) {
		this.waehrung = waehrung;
	}

	/**
	 * Gets the umrechnungsfaktor.
	 * 
	 * @return the umrechnungsfaktor
	 */
	public float getUmrechnungsfaktor() {
		return this.umrechnungsfaktor;
	}

	/**
	 * Sets the umrechnungsfaktor.
	 * 
	 * @param umrechnungsfaktor
	 *            the new umrechnungsfaktor
	 */
	public void setUmrechnungsfaktor(final float umrechnungsfaktor) {
		this.umrechnungsfaktor = umrechnungsfaktor;
	}

	// hashcode, toString, equals

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

		final Wechselkurs that = (Wechselkurs) o;

		if (Float.compare(that.umrechnungsfaktor, this.umrechnungsfaktor) != 0)
			return false;
		if (this.wechselkursId != null ? !this.wechselkursId
				.equals(that.wechselkursId) : that.wechselkursId != null)
			return false;
		if (this.waehrung != null ? !this.waehrung.equals(that.waehrung)
				: that.waehrung != null)
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
		int result = this.wechselkursId != null ? this.wechselkursId.hashCode()
				: 0;
		result = (31 * result)
				+ (this.waehrung != null ? this.waehrung.hashCode() : 0);
		result = (31 * result)
				+ (this.umrechnungsfaktor != +0.0f ? Float
						.floatToIntBits(this.umrechnungsfaktor) : 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return "Wechselkurs{" + "wechselkursId=" + this.wechselkursId
				+ ", waehrung='" + this.waehrung + '\'' + '}';
	}
}
