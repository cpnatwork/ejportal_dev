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
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 14:45:18 To
 * change this template use File | Settings | File Templates.
 */

@Entity
public class Bibliotheksmitarbeiter extends BaseObject {

	/** The bib id. */
	private Long bibId;

	/** The name. */
	private String name;

	/** The abteilungs hauptstelle. */
	private String abteilungsHauptstelle;

	/** The fensterumschlag adresse. */
	private String fensterumschlagAdresse;

	/** The hausanschrift. */
	private String hausanschrift;

	/** The postanschrift. */
	private String postanschrift;

	/** The telefon. */
	private String telefon;

	/** The telefax. */
	private String telefax;

	/** The emailanschrift. */
	private String emailanschrift;

	/** The url. */
	private String url;

	/** The umst id. */
	private String umstId;

	/** The mitarbeiter. */
	private String mitarbeiter;

	/** The dienstort. */
	private String dienstort;

	/**
	 * Gets the bib id.
	 * 
	 * @return the bib id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getBibId() {
		return this.bibId;
	}

	/**
	 * Sets the bib id.
	 * 
	 * @param bibId
	 *            the new bib id
	 */
	public void setBibId(final Long bibId) {
		this.bibId = bibId;
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
	 * Gets the fensterumschlag adresse.
	 * 
	 * @return the fensterumschlag adresse
	 */
	public String getFensterumschlagAdresse() {
		return this.fensterumschlagAdresse;
	}

	/**
	 * Sets the fensterumschlag adresse.
	 * 
	 * @param fensterumschlagAdresse
	 *            the new fensterumschlag adresse
	 */
	public void setFensterumschlagAdresse(final String fensterumschlagAdresse) {
		this.fensterumschlagAdresse = fensterumschlagAdresse;
	}

	/**
	 * Gets the hausanschrift.
	 * 
	 * @return the hausanschrift
	 */
	public String getHausanschrift() {
		return this.hausanschrift;
	}

	/**
	 * Sets the hausanschrift.
	 * 
	 * @param hausanschrift
	 *            the new hausanschrift
	 */
	public void setHausanschrift(final String hausanschrift) {
		this.hausanschrift = hausanschrift;
	}

	/**
	 * Gets the postanschrift.
	 * 
	 * @return the postanschrift
	 */
	public String getPostanschrift() {
		return this.postanschrift;
	}

	/**
	 * Sets the postanschrift.
	 * 
	 * @param postanschrift
	 *            the new postanschrift
	 */
	public void setPostanschrift(final String postanschrift) {
		this.postanschrift = postanschrift;
	}

	/**
	 * Gets the telefon.
	 * 
	 * @return the telefon
	 */
	public String getTelefon() {
		return this.telefon;
	}

	/**
	 * Sets the telefon.
	 * 
	 * @param telefon
	 *            the new telefon
	 */
	public void setTelefon(final String telefon) {
		this.telefon = telefon;
	}

	/**
	 * Gets the telefax.
	 * 
	 * @return the telefax
	 */
	public String getTelefax() {
		return this.telefax;
	}

	/**
	 * Sets the telefax.
	 * 
	 * @param telefax
	 *            the new telefax
	 */
	public void setTelefax(final String telefax) {
		this.telefax = telefax;
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

	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * Sets the url.
	 * 
	 * @param url
	 *            the new url
	 */
	public void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * Gets the umst id.
	 * 
	 * @return the umst id
	 */
	public String getUmstId() {
		return this.umstId;
	}

	/**
	 * Sets the umst id.
	 * 
	 * @param umstId
	 *            the new umst id
	 */
	public void setUmstId(final String umstId) {
		this.umstId = umstId;
	}

	/**
	 * Gets the mitarbeiter.
	 * 
	 * @return the mitarbeiter
	 */
	public String getMitarbeiter() {
		return this.mitarbeiter;
	}

	/**
	 * Sets the mitarbeiter.
	 * 
	 * @param mitarbeiter
	 *            the new mitarbeiter
	 */
	public void setMitarbeiter(final String mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	/**
	 * Gets the dienstort.
	 * 
	 * @return the dienstort
	 */
	public String getDienstort() {
		return this.dienstort;
	}

	/**
	 * Sets the dienstort.
	 * 
	 * @param dienstort
	 *            the new dienstort
	 */
	public void setDienstort(final String dienstort) {
		this.dienstort = dienstort;
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

		final Bibliotheksmitarbeiter that = (Bibliotheksmitarbeiter) o;

		if (this.abteilungsHauptstelle != null ? !this.abteilungsHauptstelle
				.equals(that.abteilungsHauptstelle)
				: that.abteilungsHauptstelle != null)
			return false;
		if (this.dienstort != null ? !this.dienstort.equals(that.dienstort)
				: that.dienstort != null)
			return false;
		if (this.emailanschrift != null ? !this.emailanschrift
				.equals(that.emailanschrift) : that.emailanschrift != null)
			return false;
		if (this.fensterumschlagAdresse != null ? !this.fensterumschlagAdresse
				.equals(that.fensterumschlagAdresse)
				: that.fensterumschlagAdresse != null)
			return false;
		if (this.hausanschrift != null ? !this.hausanschrift
				.equals(that.hausanschrift) : that.hausanschrift != null)
			return false;
		if (this.bibId != null ? !this.bibId.equals(that.bibId)
				: that.bibId != null)
			return false;
		if (this.mitarbeiter != null ? !this.mitarbeiter
				.equals(that.mitarbeiter) : that.mitarbeiter != null)
			return false;
		if (this.name != null ? !this.name.equals(that.name)
				: that.name != null)
			return false;
		if (this.postanschrift != null ? !this.postanschrift
				.equals(that.postanschrift) : that.postanschrift != null)
			return false;
		if (this.telefax != null ? !this.telefax.equals(that.telefax)
				: that.telefax != null)
			return false;
		if (this.telefon != null ? !this.telefon.equals(that.telefon)
				: that.telefon != null)
			return false;
		if (this.umstId != null ? !this.umstId.equals(that.umstId)
				: that.umstId != null)
			return false;
		if (this.url != null ? !this.url.equals(that.url) : that.url != null)
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
		int result = this.bibId != null ? this.bibId.hashCode() : 0;
		result = (31 * result) + (this.name != null ? this.name.hashCode() : 0);
		result = (31 * result)
				+ (this.abteilungsHauptstelle != null ? this.abteilungsHauptstelle
						.hashCode() : 0);
		result = (31 * result)
				+ (this.fensterumschlagAdresse != null ? this.fensterumschlagAdresse
						.hashCode() : 0);
		result = (31 * result)
				+ (this.hausanschrift != null ? this.hausanschrift.hashCode()
						: 0);
		result = (31 * result)
				+ (this.postanschrift != null ? this.postanschrift.hashCode()
						: 0);
		result = (31 * result)
				+ (this.telefon != null ? this.telefon.hashCode() : 0);
		result = (31 * result)
				+ (this.telefax != null ? this.telefax.hashCode() : 0);
		result = (31 * result)
				+ (this.emailanschrift != null ? this.emailanschrift.hashCode()
						: 0);
		result = (31 * result) + (this.url != null ? this.url.hashCode() : 0);
		result = (31 * result)
				+ (this.umstId != null ? this.umstId.hashCode() : 0);
		result = (31 * result)
				+ (this.mitarbeiter != null ? this.mitarbeiter.hashCode() : 0);
		result = (31 * result)
				+ (this.dienstort != null ? this.dienstort.hashCode() : 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return ("" + this.bibId + " " + this.name);
	}
}
