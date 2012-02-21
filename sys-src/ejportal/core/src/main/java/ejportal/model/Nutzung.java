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
 * Created by IntelliJ IDEA. User: Nina Date: 09.08.2010 Time: 15:33:54 To
 * change this template use File | Settings | File Templates.
 */

@Entity
public class Nutzung extends BaseObject {

	/** The journal. */
	private Journal journal;

	/** The nutzung id. */
	private Long nutzungId;

	/** The zugriffe. */
	private Integer zugriffe;

	/** The zeitraum. */
	private Integer zeitraum;

	/** The nutzungsjahr. */
	private Integer nutzungsjahr;

	/** The rechnungsbetrag. */
	private Float rechnungsbetrag;

	/**
	 * Gets the nutzung id.
	 * 
	 * @return the nutzung id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getNutzungId() {
		return this.nutzungId;
	}

	/**
	 * Sets the nutzung id.
	 * 
	 * @param nutzungId
	 *            the new nutzung id
	 */
	public void setNutzungId(final Long nutzungId) {
		this.nutzungId = nutzungId;
	}

	/**
	 * Gets the journal.
	 * 
	 * @return the journal
	 */
	@ManyToOne
	public Journal getJournal() {
		return this.journal;
	}

	/**
	 * Sets the journal.
	 * 
	 * @param journal
	 *            the new journal
	 */
	public void setJournal(final Journal journal) {
		this.journal = journal;
	}

	/**
	 * Gets the zugriffe.
	 * 
	 * @return the zugriffe
	 */
	public Integer getZugriffe() {
		return this.zugriffe;
	}

	/**
	 * Sets the zugriffe.
	 * 
	 * @param zugriffe
	 *            the new zugriffe
	 */
	public void setZugriffe(final Integer zugriffe) {
		this.zugriffe = zugriffe;
	}

	/**
	 * Gets the zeitraum.
	 * 
	 * @return the zeitraum
	 */
	public Integer getZeitraum() {
		return this.zeitraum;
	}

	/**
	 * Sets the zeitraum.
	 * 
	 * @param zeitraum
	 *            the new zeitraum
	 */
	public void setZeitraum(final Integer zeitraum) {
		this.zeitraum = zeitraum;
	}

	/**
	 * Gets the nutzungsjahr.
	 * 
	 * @return the nutzungsjahr
	 */
	public Integer getNutzungsjahr() {
		return this.nutzungsjahr;
	}

	/**
	 * Sets the nutzungsjahr.
	 * 
	 * @param nutzungsjahr
	 *            the new nutzungsjahr
	 */
	public void setNutzungsjahr(final Integer nutzungsjahr) {
		this.nutzungsjahr = nutzungsjahr;
	}

	/**
	 * Gets the rechnungsbetrag.
	 * 
	 * @return the rechnungsbetrag
	 */
	public Float getRechnungsbetrag() {
		return this.rechnungsbetrag;
	}

	/**
	 * Sets the rechnungsbetrag.
	 * 
	 * @param rechnungsbetrag
	 *            the new rechnungsbetrag
	 */
	public void setRechnungsbetrag(final Float rechnungsbetrag) {
		this.rechnungsbetrag = rechnungsbetrag;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return "Nutzung{" + "nutzungId=" + this.nutzungId + '}';
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

		final Nutzung nutzung = (Nutzung) o;

		if (this.nutzungId != null ? !this.nutzungId.equals(nutzung.nutzungId)
				: nutzung.nutzungId != null)
			return false;
		if (this.nutzungsjahr != null ? !this.nutzungsjahr
				.equals(nutzung.nutzungsjahr) : nutzung.nutzungsjahr != null)
			return false;
		if (this.rechnungsbetrag != null ? !this.rechnungsbetrag
				.equals(nutzung.rechnungsbetrag)
				: nutzung.rechnungsbetrag != null)
			return false;
		if (this.zeitraum != null ? !this.zeitraum.equals(nutzung.zeitraum)
				: nutzung.zeitraum != null)
			return false;
		if (this.zugriffe != null ? !this.zugriffe.equals(nutzung.zugriffe)
				: nutzung.zugriffe != null)
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
		int result = this.nutzungId != null ? this.nutzungId.hashCode() : 0;
		result = (31 * result)
				+ (this.zugriffe != null ? this.zugriffe.hashCode() : 0);
		result = (31 * result)
				+ (this.zeitraum != null ? this.zeitraum.hashCode() : 0);
		result = (31 * result)
				+ (this.nutzungsjahr != null ? this.nutzungsjahr.hashCode() : 0);
		result = (31 * result)
				+ (this.rechnungsbetrag != null ? this.rechnungsbetrag
						.hashCode() : 0);
		return result;
	}
}
