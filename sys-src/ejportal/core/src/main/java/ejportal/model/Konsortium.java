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
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 15:54:00 To
 * change this template use File | Settings | File Templates.
 */
@Entity
public class Konsortium extends BaseObject {

	/** The konsortium id. */
	private Long konsortiumId;

	/** The konsortium name. */
	private String konsortiumName;

	/**
	 * Gets the konsortium id.
	 * 
	 * @return the konsortium id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getKonsortiumId() {
		return this.konsortiumId;
	}

	/**
	 * Sets the konsortium id.
	 * 
	 * @param konsortiumId
	 *            the new konsortium id
	 */
	public void setKonsortiumId(final Long konsortiumId) {
		this.konsortiumId = konsortiumId;
	}

	/**
	 * Gets the konsortium name.
	 * 
	 * @return the konsortium name
	 */
	public String getKonsortiumName() {
		return this.konsortiumName;
	}

	/**
	 * Sets the konsortium name.
	 * 
	 * @param konsortiumName
	 *            the new konsortium name
	 */
	public void setKonsortiumName(final String konsortiumName) {
		this.konsortiumName = konsortiumName;
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

		final Konsortium that = (Konsortium) o;

		if (this.konsortiumId != null ? !this.konsortiumId
				.equals(that.konsortiumId) : that.konsortiumId != null)
			return false;
		if (this.konsortiumName != null ? !this.konsortiumName
				.equals(that.konsortiumName) : that.konsortiumName != null)
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
		int result = this.konsortiumId != null ? this.konsortiumId.hashCode()
				: 0;
		result = (31 * result)
				+ (this.konsortiumName != null ? this.konsortiumName.hashCode()
						: 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return "" + this.konsortiumId + " " + this.konsortiumName;
	}
}
