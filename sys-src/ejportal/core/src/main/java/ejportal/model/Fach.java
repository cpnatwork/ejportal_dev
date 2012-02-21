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

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.appfuse.model.BaseObject;

/**
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 15:42:45 To
 * change this template use File | Settings | File Templates.
 */

@Entity
public class Fach extends BaseObject {

	/** The fach id. */
	private Long fachId;

	/** The fach name. */
	private String fachName;

	/** The journals. */
	private Set<Journal> journals = new HashSet<Journal>();

	/**
	 * Gets the fach id.
	 * 
	 * @return the fach id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getFachId() {
		return this.fachId;
	}

	/**
	 * Sets the fach id.
	 * 
	 * @param fachId
	 *            the new fach id
	 */
	public void setFachId(final Long fachId) {
		this.fachId = fachId;
	}

	/**
	 * Gets the fach name.
	 * 
	 * @return the fach name
	 */
	public String getFachName() {
		return this.fachName;
	}

	/**
	 * Sets the fach name.
	 * 
	 * @param fachName
	 *            the new fach name
	 */
	public void setFachName(final String fachName) {
		this.fachName = fachName;
	}

	/**
	 * Gets the journals.
	 * 
	 * @return the journals
	 */
	@ManyToMany
	@JoinTable(name = "Journal_Fach", joinColumns = { @JoinColumn(name = "fachId") }, inverseJoinColumns = { @JoinColumn(name = "journalId") })
	public Set<Journal> getJournals() {
		return this.journals;
	}

	/**
	 * Sets the journals.
	 * 
	 * @param journals
	 *            the new journals
	 */
	public void setJournals(final Set<Journal> journals) {
		this.journals = journals;
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

		final Fach fach = (Fach) o;

		if (this.fachId != null ? !this.fachId.equals(fach.fachId)
				: fach.fachId != null)
			return false;
		if (this.fachName != null ? !this.fachName.equals(fach.fachName)
				: fach.fachName != null)
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
		int result = this.fachId != null ? this.fachId.hashCode() : 0;
		result = (31 * result)
				+ (this.fachName != null ? this.fachName.hashCode() : 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return "" + this.fachId + " " + this.fachName;
	}
}
