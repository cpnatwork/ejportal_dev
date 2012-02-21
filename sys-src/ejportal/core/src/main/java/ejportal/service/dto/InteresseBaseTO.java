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
package ejportal.service.dto;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 10.08.2010 Time: 11:37:24 To
 * change this template use File | Settings | File Templates.
 */
public class InteresseBaseTO {

	/** The interesse id. */
	Long interesseId;

	/** The interesse. */
	String interesse;

	/**
	 * Gets the interesse id.
	 * 
	 * @return the interesse id
	 */
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
}
