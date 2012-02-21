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
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 15:54:50 To
 * change this template use File | Settings | File Templates.
 */
@Entity
public class Interesse extends BaseObject {

	/** The interesse id. */
	Long interesseId;

	/** The interesse. */
	String interesse;

	/** The journal. */
	Journal journal;

	/** The besteller. */
	Besteller besteller;

	/**
	 * Gets the interesse id.
	 * 
	 * @return the interesse id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getInteresseId() {
		return this.interesseId;
	}

	/**
	 * Sets the interesse id.
	 * 
	 * @param interesseId
	 *            the new interesse id
	 */
	public void setInteresseId(final Long interesseId) {
		this.interesseId = interesseId;
	}

	/**
	 * Gets the interesse.
	 * 
	 * @return the interesse
	 */
	public String getInteresse() {
		return this.interesse;
	}

	/**
	 * Sets the interesse.
	 * 
	 * @param interesse
	 *            the new interesse
	 */
	public void setInteresse(final String interesse) {
		this.interesse = interesse;
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
	 * Gets the besteller.
	 * 
	 * @return the besteller
	 */
	@ManyToOne
	public Besteller getBesteller() {
		return this.besteller;
	}

	/**
	 * Sets the besteller.
	 * 
	 * @param besteller
	 *            the new besteller
	 */
	public void setBesteller(final Besteller besteller) {
		this.besteller = besteller;
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

		final Interesse interesse1 = (Interesse) o;

		if (this.besteller != null ? !this.besteller
				.equals(interesse1.besteller) : interesse1.besteller != null)
			return false;
		if (this.interesse != null ? !this.interesse
				.equals(interesse1.interesse) : interesse1.interesse != null)
			return false;
		if (this.interesseId != null ? !this.interesseId
				.equals(interesse1.interesseId)
				: interesse1.interesseId != null)
			return false;
		if (this.journal != null ? !this.journal.equals(interesse1.journal)
				: interesse1.journal != null)
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
		int result = this.interesseId != null ? this.interesseId.hashCode() : 0;
		result = (31 * result)
				+ (this.interesse != null ? this.interesse.hashCode() : 0);
		result = (31 * result)
				+ (this.journal != null ? this.journal.hashCode() : 0);
		result = (31 * result)
				+ (this.besteller != null ? this.besteller.hashCode() : 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return this.interesse;
	}
}
