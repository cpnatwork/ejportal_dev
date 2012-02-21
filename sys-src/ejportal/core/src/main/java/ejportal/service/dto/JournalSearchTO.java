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
 * Created by IntelliJ IDEA. User: Florian Date: 24.06.2010 Time: 16:17:26 To
 * change this template use File | Settings | File Templates.
 */
public class JournalSearchTO {

	/** The titel. */
	private String titel = "";

	/** The kurztitel. */
	private String kurztitel = "";

	/** The verlag. */
	private String verlag = "";

	/** The provider. */
	private String provider = "";

	/** The konsortium. */
	private String konsortium = "";

	/** The paket. */
	private String paket = "";

	/** The zugang ueber. */
	private String zugangUeber = "";

	/**
	 * Gets the titel.
	 * 
	 * @return the titel
	 */
	public String getTitel() {
		return this.titel;
	}

	/**
	 * Sets the titel.
	 * 
	 * @param titel
	 *            the new titel
	 */
	public void setTitel(final String titel) {
		this.titel = titel;
	}

	/**
	 * Gets the kurztitel.
	 * 
	 * @return the kurztitel
	 */
	public String getKurztitel() {
		return this.kurztitel;
	}

	/**
	 * Sets the kurztitel.
	 * 
	 * @param kurztitel
	 *            the new kurztitel
	 */
	public void setKurztitel(final String kurztitel) {
		this.kurztitel = kurztitel;
	}

	/**
	 * Gets the verlag.
	 * 
	 * @return the verlag
	 */
	public String getVerlag() {
		return this.verlag;
	}

	/**
	 * Sets the verlag.
	 * 
	 * @param verlag
	 *            the new verlag
	 */
	public void setVerlag(final String verlag) {
		this.verlag = verlag;
	}

	/**
	 * Gets the provider.
	 * 
	 * @return the provider
	 */
	public String getProvider() {
		return this.provider;
	}

	/**
	 * Sets the provider.
	 * 
	 * @param provider
	 *            the new provider
	 */
	public void setProvider(final String provider) {
		this.provider = provider;
	}

	/**
	 * Gets the konsortium.
	 * 
	 * @return the konsortium
	 */
	public String getKonsortium() {
		return this.konsortium;
	}

	/**
	 * Sets the konsortium.
	 * 
	 * @param konsortium
	 *            the new konsortium
	 */
	public void setKonsortium(final String konsortium) {
		this.konsortium = konsortium;
	}

	/**
	 * Gets the paket.
	 * 
	 * @return the paket
	 */
	public String getPaket() {
		return this.paket;
	}

	/**
	 * Sets the paket.
	 * 
	 * @param paket
	 *            the new paket
	 */
	public void setPaket(final String paket) {
		this.paket = paket;
	}

	/**
	 * Gets the zugang ueber.
	 * 
	 * @return the zugang ueber
	 */
	public String getZugangUeber() {
		return this.zugangUeber;
	}

	/**
	 * Sets the zugang ueber.
	 * 
	 * @param zugangUeber
	 *            the new zugang ueber
	 */
	public void setZugangUeber(final String zugangUeber) {
		this.zugangUeber = zugangUeber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JournalSearchTO{" + "titel='" + this.titel + '\''
				+ ", kurztitel='" + this.kurztitel + '\'' + ", verlag='"
				+ this.verlag + '\'' + ", provider='" + this.provider + '\''
				+ ", konsortium='" + this.konsortium + '\'' + ", paket='"
				+ this.paket + '\'' + ", zugangUeber='" + this.zugangUeber
				+ '\'' + '}';
	}
}
