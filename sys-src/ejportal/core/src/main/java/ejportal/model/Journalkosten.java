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

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.appfuse.model.BaseObject;

/**
 * Created by IntelliJ IDEA. User: ag35ogub Date: 09.08.2010 Time: 14:43:18 To
 * change this template use File | Settings | File Templates.
 */

@Entity
public class Journalkosten extends BaseObject {

	/** The journalkosten id. */
	private Long journalkostenId;

	/** The o preis po. */
	private float oPreisPO;

	/** The waehrung po. */
	private String waehrungPO;

	/** The mw st po. */
	private String mwStPO;

	/** The o preis o. */
	private float oPreisO;

	/** The waehrung o. */
	private String waehrungO;

	/** The mw st o. */
	private String mwStO;

	/** The o preis p. */
	private float oPreisP;

	/** The waehrung p. */
	private String waehrungP;

	/** The mw st p. */
	private String mwStP;

	/** The i preis po. */
	private float iPreisPO;

	/** The i waehrung po. */
	private String iWaehrungPO;

	/** The i mw st po. */
	private String iMwStPO;

	/** The i preis o. */
	private float iPreisO;

	/** The i waehrung o. */
	private String iWaehrungO;

	/** The i mw st o. */
	private String iMwStO;

	/** The i preis p. */
	private float iPreisP;

	/** The i waehrung p. */
	private String iWaehrungP;

	/** The i mw st p. */
	private String iMwStP;

	/** The impact. */
	private float impact;

	/** The impact datum. */
	private Date impactDatum;

	// relation

	/** The journal. */
	private Journal journal;

	/* GETTER UND SETTER */

	/**
	 * Gets the journalkosten id.
	 * 
	 * @return the journalkosten id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getJournalkostenId() {
		return this.journalkostenId;
	}

	/**
	 * Sets the journalkosten id.
	 * 
	 * @param journalkostenId
	 *            the new journalkosten id
	 */
	public void setJournalkostenId(final Long journalkostenId) {
		this.journalkostenId = journalkostenId;
	}

	/**
	 * Gets the o preis po.
	 * 
	 * @return the o preis po
	 */
	public float getOPreisPO() {
		return this.oPreisPO;
	}

	/**
	 * Sets the o preis po.
	 * 
	 * @param oPreisPO
	 *            the new o preis po
	 */
	public void setOPreisPO(final float oPreisPO) {
		this.oPreisPO = oPreisPO;
	}

	/**
	 * Gets the waehrung po.
	 * 
	 * @return the waehrung po
	 */
	public String getWaehrungPO() {
		return this.waehrungPO;
	}

	/**
	 * Sets the waehrung po.
	 * 
	 * @param waehrungPO
	 *            the new waehrung po
	 */
	public void setWaehrungPO(final String waehrungPO) {
		this.waehrungPO = waehrungPO;
	}

	/**
	 * Gets the mw st po.
	 * 
	 * @return the mw st po
	 */
	public String getMwStPO() {
		return this.mwStPO;
	}

	/**
	 * Sets the mw st po.
	 * 
	 * @param mwStPO
	 *            the new mw st po
	 */
	public void setMwStPO(final String mwStPO) {
		this.mwStPO = mwStPO;
	}

	/**
	 * Gets the o preis o.
	 * 
	 * @return the o preis o
	 */
	public float getOPreisO() {
		return this.oPreisO;
	}

	/**
	 * Sets the o preis o.
	 * 
	 * @param oPreisO
	 *            the new o preis o
	 */
	public void setOPreisO(final float oPreisO) {
		this.oPreisO = oPreisO;
	}

	/**
	 * Gets the waehrung o.
	 * 
	 * @return the waehrung o
	 */
	public String getWaehrungO() {
		return this.waehrungO;
	}

	/**
	 * Sets the waehrung o.
	 * 
	 * @param waehrungO
	 *            the new waehrung o
	 */
	public void setWaehrungO(final String waehrungO) {
		this.waehrungO = waehrungO;
	}

	/**
	 * Gets the mw st o.
	 * 
	 * @return the mw st o
	 */
	public String getMwStO() {
		return this.mwStO;
	}

	/**
	 * Sets the mw st o.
	 * 
	 * @param mwStO
	 *            the new mw st o
	 */
	public void setMwStO(final String mwStO) {
		this.mwStO = mwStO;
	}

	/**
	 * Gets the o preis p.
	 * 
	 * @return the o preis p
	 */
	public float getOPreisP() {
		return this.oPreisP;
	}

	/**
	 * Sets the o preis p.
	 * 
	 * @param oPreisP
	 *            the new o preis p
	 */
	public void setOPreisP(final float oPreisP) {
		this.oPreisP = oPreisP;
	}

	/**
	 * Gets the waehrung p.
	 * 
	 * @return the waehrung p
	 */
	public String getWaehrungP() {
		return this.waehrungP;
	}

	/**
	 * Sets the waehrung p.
	 * 
	 * @param waehrungP
	 *            the new waehrung p
	 */
	public void setWaehrungP(final String waehrungP) {
		this.waehrungP = waehrungP;
	}

	/**
	 * Gets the mw st p.
	 * 
	 * @return the mw st p
	 */
	public String getMwStP() {
		return this.mwStP;
	}

	/**
	 * Sets the mw st p.
	 * 
	 * @param mwStP
	 *            the new mw st p
	 */
	public void setMwStP(final String mwStP) {
		this.mwStP = mwStP;
	}

	/**
	 * Gets the i preis po.
	 * 
	 * @return the i preis po
	 */
	public float getIPreisPO() {
		return this.iPreisPO;
	}

	/**
	 * Sets the i preis po.
	 * 
	 * @param iPreisPO
	 *            the new i preis po
	 */
	public void setIPreisPO(final float iPreisPO) {
		this.iPreisPO = iPreisPO;
	}

	/**
	 * Gets the i waehrung po.
	 * 
	 * @return the i waehrung po
	 */
	public String getIWaehrungPO() {
		return this.iWaehrungPO;
	}

	/**
	 * Sets the i waehrung po.
	 * 
	 * @param iWaehrungPO
	 *            the new i waehrung po
	 */
	public void setIWaehrungPO(final String iWaehrungPO) {
		this.iWaehrungPO = iWaehrungPO;
	}

	/**
	 * Gets the i mw st po.
	 * 
	 * @return the i mw st po
	 */
	public String getIMwStPO() {
		return this.iMwStPO;
	}

	/**
	 * Sets the i mw st po.
	 * 
	 * @param iMwStPO
	 *            the new i mw st po
	 */
	public void setIMwStPO(final String iMwStPO) {
		this.iMwStPO = iMwStPO;
	}

	/**
	 * Gets the i preis o.
	 * 
	 * @return the i preis o
	 */
	public float getIPreisO() {
		return this.iPreisO;
	}

	/**
	 * Sets the i preis o.
	 * 
	 * @param iPreisO
	 *            the new i preis o
	 */
	public void setIPreisO(final float iPreisO) {
		this.iPreisO = iPreisO;
	}

	/**
	 * Gets the i waehrung o.
	 * 
	 * @return the i waehrung o
	 */
	public String getIWaehrungO() {
		return this.iWaehrungO;
	}

	/**
	 * Sets the i waehrung o.
	 * 
	 * @param iWaehrungO
	 *            the new i waehrung o
	 */
	public void setIWaehrungO(final String iWaehrungO) {
		this.iWaehrungO = iWaehrungO;
	}

	/**
	 * Gets the i mw st o.
	 * 
	 * @return the i mw st o
	 */
	public String getIMwStO() {
		return this.iMwStO;
	}

	/**
	 * Sets the i mw st o.
	 * 
	 * @param iMwStO
	 *            the new i mw st o
	 */
	public void setIMwStO(final String iMwStO) {
		this.iMwStO = iMwStO;
	}

	/**
	 * Gets the i preis p.
	 * 
	 * @return the i preis p
	 */
	public float getIPreisP() {
		return this.iPreisP;
	}

	/**
	 * Sets the i preis p.
	 * 
	 * @param iPreisP
	 *            the new i preis p
	 */
	public void setIPreisP(final float iPreisP) {
		this.iPreisP = iPreisP;
	}

	/**
	 * Gets the i waehrung p.
	 * 
	 * @return the i waehrung p
	 */
	public String getIWaehrungP() {
		return this.iWaehrungP;
	}

	/**
	 * Sets the i waehrung p.
	 * 
	 * @param iWaehrungP
	 *            the new i waehrung p
	 */
	public void setIWaehrungP(final String iWaehrungP) {
		this.iWaehrungP = iWaehrungP;
	}

	/**
	 * Gets the i mw st p.
	 * 
	 * @return the i mw st p
	 */
	public String getIMwStP() {
		return this.iMwStP;
	}

	/**
	 * Sets the i mw st p.
	 * 
	 * @param iMwStP
	 *            the new i mw st p
	 */
	public void setIMwStP(final String iMwStP) {
		this.iMwStP = iMwStP;
	}

	/**
	 * Gets the impact.
	 * 
	 * @return the impact
	 */
	public float getImpact() {
		return this.impact;
	}

	/**
	 * Sets the impact.
	 * 
	 * @param impact
	 *            the new impact
	 */
	public void setImpact(final float impact) {
		this.impact = impact;
	}

	/**
	 * Gets the impact datum.
	 * 
	 * @return the impact datum
	 */
	public Date getImpactDatum() {
		return this.impactDatum;
	}

	/**
	 * Sets the impact datum.
	 * 
	 * @param impactDatum
	 *            the new impact datum
	 */
	public void setImpactDatum(final Date impactDatum) {
		this.impactDatum = impactDatum;
	}

	/**
	 * Gets the journal.
	 * 
	 * @return the journal
	 */
	@OneToOne(fetch = FetchType.EAGER)
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

		final Journalkosten that = (Journalkosten) o;

		if (Float.compare(that.iPreisO, this.iPreisO) != 0)
			return false;
		if (Float.compare(that.iPreisP, this.iPreisP) != 0)
			return false;
		if (Float.compare(that.iPreisPO, this.iPreisPO) != 0)
			return false;
		if (Float.compare(that.impact, this.impact) != 0)
			return false;
		if (Float.compare(that.oPreisO, this.oPreisO) != 0)
			return false;
		if (Float.compare(that.oPreisP, this.oPreisP) != 0)
			return false;
		if (Float.compare(that.oPreisPO, this.oPreisPO) != 0)
			return false;
		if (this.iMwStO != null ? !this.iMwStO.equals(that.iMwStO)
				: that.iMwStO != null)
			return false;
		if (this.iMwStP != null ? !this.iMwStP.equals(that.iMwStP)
				: that.iMwStP != null)
			return false;
		if (this.iMwStPO != null ? !this.iMwStPO.equals(that.iMwStPO)
				: that.iMwStPO != null)
			return false;
		if (this.iWaehrungO != null ? !this.iWaehrungO.equals(that.iWaehrungO)
				: that.iWaehrungO != null)
			return false;
		if (this.iWaehrungP != null ? !this.iWaehrungP.equals(that.iWaehrungP)
				: that.iWaehrungP != null)
			return false;
		if (this.iWaehrungPO != null ? !this.iWaehrungPO
				.equals(that.iWaehrungPO) : that.iWaehrungPO != null)
			return false;
		if (this.impactDatum != null ? !this.impactDatum
				.equals(that.impactDatum) : that.impactDatum != null)
			return false;
		if (this.journal != null ? !this.journal.equals(that.journal)
				: that.journal != null)
			return false;
		if (this.journalkostenId != null ? !this.journalkostenId
				.equals(that.journalkostenId) : that.journalkostenId != null)
			return false;
		if (this.mwStO != null ? !this.mwStO.equals(that.mwStO)
				: that.mwStO != null)
			return false;
		if (this.mwStP != null ? !this.mwStP.equals(that.mwStP)
				: that.mwStP != null)
			return false;
		if (this.mwStPO != null ? !this.mwStPO.equals(that.mwStPO)
				: that.mwStPO != null)
			return false;
		if (this.waehrungO != null ? !this.waehrungO.equals(that.waehrungO)
				: that.waehrungO != null)
			return false;
		if (this.waehrungP != null ? !this.waehrungP.equals(that.waehrungP)
				: that.waehrungP != null)
			return false;
		if (this.waehrungPO != null ? !this.waehrungPO.equals(that.waehrungPO)
				: that.waehrungPO != null)
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
		int result = this.journalkostenId != null ? this.journalkostenId
				.hashCode() : 0;
		result = (31 * result)
				+ (this.oPreisPO != +0.0f ? Float.floatToIntBits(this.oPreisPO)
						: 0);
		result = (31 * result)
				+ (this.waehrungPO != null ? this.waehrungPO.hashCode() : 0);
		result = (31 * result)
				+ (this.mwStPO != null ? this.mwStPO.hashCode() : 0);
		result = (31 * result)
				+ (this.oPreisO != +0.0f ? Float.floatToIntBits(this.oPreisO)
						: 0);
		result = (31 * result)
				+ (this.waehrungO != null ? this.waehrungO.hashCode() : 0);
		result = (31 * result)
				+ (this.mwStO != null ? this.mwStO.hashCode() : 0);
		result = (31 * result)
				+ (this.oPreisP != +0.0f ? Float.floatToIntBits(this.oPreisP)
						: 0);
		result = (31 * result)
				+ (this.waehrungP != null ? this.waehrungP.hashCode() : 0);
		result = (31 * result)
				+ (this.mwStP != null ? this.mwStP.hashCode() : 0);
		result = (31 * result)
				+ (this.iPreisPO != +0.0f ? Float.floatToIntBits(this.iPreisPO)
						: 0);
		result = (31 * result)
				+ (this.iWaehrungPO != null ? this.iWaehrungPO.hashCode() : 0);
		result = (31 * result)
				+ (this.iMwStPO != null ? this.iMwStPO.hashCode() : 0);
		result = (31 * result)
				+ (this.iPreisO != +0.0f ? Float.floatToIntBits(this.iPreisO)
						: 0);
		result = (31 * result)
				+ (this.iWaehrungO != null ? this.iWaehrungO.hashCode() : 0);
		result = (31 * result)
				+ (this.iMwStO != null ? this.iMwStO.hashCode() : 0);
		result = (31 * result)
				+ (this.iPreisP != +0.0f ? Float.floatToIntBits(this.iPreisP)
						: 0);
		result = (31 * result)
				+ (this.iWaehrungP != null ? this.iWaehrungP.hashCode() : 0);
		result = (31 * result)
				+ (this.iMwStP != null ? this.iMwStP.hashCode() : 0);
		result = (31 * result)
				+ (this.impact != +0.0f ? Float.floatToIntBits(this.impact) : 0);
		result = (31 * result)
				+ (this.impactDatum != null ? this.impactDatum.hashCode() : 0);
		result = (31 * result)
				+ (this.journal != null ? this.journal.hashCode() : 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return "Journalkosten{" + "journalkostenId=" + this.journalkostenId
				+ '}';
	}
}
