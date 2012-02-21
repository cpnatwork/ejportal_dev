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
 * Created by IntelliJ IDEA. User: Christoph Date: 28.06.2010 Time: 15:02:30 To
 * change this template use File | Settings | File Templates.
 */
@Entity
public class Sigel extends BaseObject {

	/** The sigel id. */
	private Long sigelId;

	/** The name. */
	private String name;

	/** The bibliothek. */
	private String bibliothek;

	/** The fakultaet. */
	private String fakultaet;

	/** The pers email. */
	private String persEmail;

	/** The bib ansprechpartner1. */
	private String bibAnsprechpartner1;

	/** The bib ansprechpartner2. */
	private String bibAnsprechpartner2;

	/**
	 * Gets the sigel id.
	 * 
	 * @return the sigel id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getSigelId() {
		return this.sigelId;
	}

	/**
	 * Sets the sigel id.
	 * 
	 * @param sigelId
	 *            the new sigel id
	 */
	public void setSigelId(final Long sigelId) {
		this.sigelId = sigelId;
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
	 * Gets the bibliothek.
	 * 
	 * @return the bibliothek
	 */
	public String getBibliothek() {
		return this.bibliothek;
	}

	/**
	 * Sets the bibliothek.
	 * 
	 * @param bibliothek
	 *            the new bibliothek
	 */
	public void setBibliothek(final String bibliothek) {
		this.bibliothek = bibliothek;
	}

	/**
	 * Gets the fakultaet.
	 * 
	 * @return the fakultaet
	 */
	public String getFakultaet() {
		return this.fakultaet;
	}

	/**
	 * Sets the fakultaet.
	 * 
	 * @param fakultaet
	 *            the new fakultaet
	 */
	public void setFakultaet(final String fakultaet) {
		this.fakultaet = fakultaet;
	}

	/**
	 * Gets the pers email.
	 * 
	 * @return the pers email
	 */
	public String getPersEmail() {
		return this.persEmail;
	}

	/**
	 * Sets the pers email.
	 * 
	 * @param persEmail
	 *            the new pers email
	 */
	public void setPersEmail(final String persEmail) {
		this.persEmail = persEmail;
	}

	/**
	 * Gets the bib ansprechpartner1.
	 * 
	 * @return the bib ansprechpartner1
	 */
	public String getBibAnsprechpartner1() {
		return this.bibAnsprechpartner1;
	}

	/**
	 * Sets the bib ansprechpartner1.
	 * 
	 * @param bibAnsprechpartner1
	 *            the new bib ansprechpartner1
	 */
	public void setBibAnsprechpartner1(final String bibAnsprechpartner1) {
		this.bibAnsprechpartner1 = bibAnsprechpartner1;
	}

	/**
	 * Gets the bib ansprechpartner2.
	 * 
	 * @return the bib ansprechpartner2
	 */
	public String getBibAnsprechpartner2() {
		return this.bibAnsprechpartner2;
	}

	/**
	 * Sets the bib ansprechpartner2.
	 * 
	 * @param bibAnsprechpartner2
	 *            the new bib ansprechpartner2
	 */
	public void setBibAnsprechpartner2(final String bibAnsprechpartner2) {
		this.bibAnsprechpartner2 = bibAnsprechpartner2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return this.sigelId + " " + this.name;
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

		final Sigel sigel1 = (Sigel) o;

		if (this.bibAnsprechpartner1 != null ? !this.bibAnsprechpartner1
				.equals(sigel1.bibAnsprechpartner1)
				: sigel1.bibAnsprechpartner1 != null)
			return false;
		if (this.bibAnsprechpartner2 != null ? !this.bibAnsprechpartner2
				.equals(sigel1.bibAnsprechpartner2)
				: sigel1.bibAnsprechpartner2 != null)
			return false;
		if (this.bibliothek != null ? !this.bibliothek
				.equals(sigel1.bibliothek) : sigel1.bibliothek != null)
			return false;
		if (this.fakultaet != null ? !this.fakultaet.equals(sigel1.fakultaet)
				: sigel1.fakultaet != null)
			return false;
		if (this.sigelId != null ? !this.sigelId.equals(sigel1.sigelId)
				: sigel1.sigelId != null)
			return false;
		if (this.persEmail != null ? !this.persEmail.equals(sigel1.persEmail)
				: sigel1.persEmail != null)
			return false;
		if (this.name != null ? !this.name.equals(sigel1.name)
				: sigel1.name != null)
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
		int result = this.sigelId != null ? this.sigelId.hashCode() : 0;
		result = (31 * result) + (this.name != null ? this.name.hashCode() : 0);
		result = (31 * result)
				+ (this.bibliothek != null ? this.bibliothek.hashCode() : 0);
		result = (31 * result)
				+ (this.fakultaet != null ? this.fakultaet.hashCode() : 0);
		result = (31 * result)
				+ (this.persEmail != null ? this.persEmail.hashCode() : 0);
		result = (31 * result)
				+ (this.bibAnsprechpartner1 != null ? this.bibAnsprechpartner1
						.hashCode() : 0);
		result = (31 * result)
				+ (this.bibAnsprechpartner2 != null ? this.bibAnsprechpartner2
						.hashCode() : 0);
		return result;
	}
}
