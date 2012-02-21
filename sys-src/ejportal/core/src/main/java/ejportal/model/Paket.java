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
 * Created by IntelliJ IDEA. User: uj32uvac Date: 07.07.2010 Time: 15:51:23 To
 * change this template use File | Settings | File Templates.
 */

@Entity
public class Paket extends BaseObject {

	/** The paket id. */
	private Long paketId;

	/** The paket name. */
	private String paketName;

	/**
	 * Gets the paket id.
	 * 
	 * @return the paket id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPaketId() {
		return this.paketId;
	}

	/**
	 * Sets the paket id.
	 * 
	 * @param paketId
	 *            the new paket id
	 */
	public void setPaketId(final Long paketId) {
		this.paketId = paketId;
	}

	/**
	 * Gets the paket name.
	 * 
	 * @return the paket name
	 */
	public String getPaketName() {
		return this.paketName;
	}

	/**
	 * Sets the paket name.
	 * 
	 * @param paketName
	 *            the new paket name
	 */
	public void setPaketName(final String paketName) {
		this.paketName = paketName;
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

		final Paket paket = (Paket) o;

		if (this.paketId != null ? !this.paketId.equals(paket.paketId)
				: paket.paketId != null)
			return false;
		if (this.paketName != null ? !this.paketName.equals(paket.paketName)
				: paket.paketName != null)
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
		int result = this.paketId != null ? this.paketId.hashCode() : 0;
		result = (31 * result)
				+ (this.paketName != null ? this.paketName.hashCode() : 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return "" + this.paketId + " " + this.paketName;
	}
}
