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
 * Created by IntelliJ IDEA. User: Nina Date: 04.08.2010 Time: 15:50:30 To
 * change this template use File | Settings | File Templates.
 */
public class SigelSearchTO {

	/** The name. */
	private String name;

	/** The bibliothek. */
	private String bibliothek;

	/** The fakultaet. */
	private String fakultaet;

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
}
