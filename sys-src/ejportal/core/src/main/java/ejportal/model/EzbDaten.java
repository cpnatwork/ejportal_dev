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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.appfuse.model.BaseObject;

/**
 * Created by IntelliJ IDEA. User: Florian Date: 09.08.2010 Time: 11:50:47 To
 * change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "ezb1")
@SecondaryTables({ @SecondaryTable(name = "ezb2"),
		@SecondaryTable(name = "ezb3") })
public class EzbDaten extends BaseObject {

	/** The ezb id. */
	private long ezbId;

	/** The titel. */
	private String titel;

	/** The zdb nummer. */
	private String zdbNummer;

	/** The ampelfarbe. */
	private int ampelfarbe;

	/** The verlag. */
	private String verlag;

	/** The typ. */
	private String typ;

	/** The preistyp. */
	private String preistyp;

	/** The zugangsbedingung. */
	private String zugangsbedingung;

	/** The issne. */
	private String issne;

	/** The issnp. */
	private String issnp;

	/** The biburl. */
	private String biburl;

	/** The volltexturl. */
	private String volltexturl;

	/** The frontdoorurl. */
	private String frontdoorurl;

	/** The link. */
	private String link;

	/**
	 * Gets the ezb id.
	 * 
	 * @return the ezb id
	 */
	@Id
	public long getEzbId() {
		return this.ezbId;
	}

	/**
	 * Sets the ezb id.
	 * 
	 * @param ezbId
	 *            the new ezb id
	 */
	public void setEzbId(final long ezbId) {
		this.ezbId = ezbId;
	}

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
	 * Gets the ampelfarbe.
	 * 
	 * @return the ampelfarbe
	 */
	public int getAmpelfarbe() {
		return this.ampelfarbe;
	}

	/**
	 * Sets the ampelfarbe.
	 * 
	 * @param ampelfarbe
	 *            the new ampelfarbe
	 */
	public void setAmpelfarbe(final int ampelfarbe) {
		this.ampelfarbe = ampelfarbe;
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
	 * Gets the typ.
	 * 
	 * @return the typ
	 */
	public String getTyp() {
		return this.typ;
	}

	/**
	 * Sets the typ.
	 * 
	 * @param typ
	 *            the new typ
	 */
	public void setTyp(final String typ) {
		this.typ = typ;
	}

	/**
	 * Gets the preistyp.
	 * 
	 * @return the preistyp
	 */
	public String getPreistyp() {
		return this.preistyp;
	}

	/**
	 * Sets the preistyp.
	 * 
	 * @param preistyp
	 *            the new preistyp
	 */
	public void setPreistyp(final String preistyp) {
		this.preistyp = preistyp;
	}

	/**
	 * Gets the zugangsbedingung.
	 * 
	 * @return the zugangsbedingung
	 */
	public String getZugangsbedingung() {
		return this.zugangsbedingung;
	}

	/**
	 * Sets the zugangsbedingung.
	 * 
	 * @param zugangsbedingung
	 *            the new zugangsbedingung
	 */
	public void setZugangsbedingung(final String zugangsbedingung) {
		this.zugangsbedingung = zugangsbedingung;
	}

	/**
	 * Gets the issne.
	 * 
	 * @return the issne
	 */
	@Column(table = "ezb2")
	public String getIssne() {
		return this.issne;
	}

	/**
	 * Sets the issne.
	 * 
	 * @param issne
	 *            the new issne
	 */
	public void setIssne(final String issne) {
		this.issne = issne;
	}

	/**
	 * Gets the issnp.
	 * 
	 * @return the issnp
	 */
	@Column(table = "ezb2")
	public String getIssnp() {
		return this.issnp;
	}

	/**
	 * Sets the issnp.
	 * 
	 * @param issnp
	 *            the new issnp
	 */
	public void setIssnp(final String issnp) {
		this.issnp = issnp;
	}

	/**
	 * Gets the zdb nummer.
	 * 
	 * @return the zdb nummer
	 */
	@Column(table = "ezb2")
	public String getZdbNummer() {
		return this.zdbNummer;
	}

	/**
	 * Sets the zdb nummer.
	 * 
	 * @param zdbNummer
	 *            the new zdb nummer
	 */
	public void setZdbNummer(final String zdbNummer) {
		this.zdbNummer = zdbNummer;
	}

	/**
	 * Gets the biburl.
	 * 
	 * @return the biburl
	 */
	@Column(table = "ezb2")
	public String getBiburl() {
		return this.biburl;
	}

	/**
	 * Sets the biburl.
	 * 
	 * @param biburl
	 *            the new biburl
	 */
	public void setBiburl(final String biburl) {
		this.biburl = biburl;
	}

	/**
	 * Gets the volltexturl.
	 * 
	 * @return the volltexturl
	 */
	@Column(table = "ezb3")
	public String getVolltexturl() {
		return this.volltexturl;
	}

	/**
	 * Sets the volltexturl.
	 * 
	 * @param volltexturl
	 *            the new volltexturl
	 */
	public void setVolltexturl(final String volltexturl) {
		this.volltexturl = volltexturl;
	}

	/**
	 * Gets the frontdoorurl.
	 * 
	 * @return the frontdoorurl
	 */
	@Column(table = "ezb3")
	public String getFrontdoorurl() {
		return this.frontdoorurl;
	}

	/**
	 * Sets the frontdoorurl.
	 * 
	 * @param frontdoorurl
	 *            the new frontdoorurl
	 */
	public void setFrontdoorurl(final String frontdoorurl) {
		this.frontdoorurl = frontdoorurl;
	}

	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	@Column(table = "ezb3")
	public String getLink() {
		return this.link;
	}

	/**
	 * Sets the link.
	 * 
	 * @param link
	 *            the new link
	 */
	public void setLink(final String link) {
		this.link = link;
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

		final EzbDaten ezbDaten = (EzbDaten) o;

		if (this.ampelfarbe != ezbDaten.ampelfarbe)
			return false;
		if (this.ezbId != ezbDaten.ezbId)
			return false;
		if (this.biburl != null ? !this.biburl.equals(ezbDaten.biburl)
				: ezbDaten.biburl != null)
			return false;
		if (this.frontdoorurl != null ? !this.frontdoorurl
				.equals(ezbDaten.frontdoorurl) : ezbDaten.frontdoorurl != null)
			return false;
		if (this.issne != null ? !this.issne.equals(ezbDaten.issne)
				: ezbDaten.issne != null)
			return false;
		if (this.issnp != null ? !this.issnp.equals(ezbDaten.issnp)
				: ezbDaten.issnp != null)
			return false;
		if (this.link != null ? !this.link.equals(ezbDaten.link)
				: ezbDaten.link != null)
			return false;
		if (this.preistyp != null ? !this.preistyp.equals(ezbDaten.preistyp)
				: ezbDaten.preistyp != null)
			return false;
		if (this.titel != null ? !this.titel.equals(ezbDaten.titel)
				: ezbDaten.titel != null)
			return false;
		if (this.typ != null ? !this.typ.equals(ezbDaten.typ)
				: ezbDaten.typ != null)
			return false;
		if (this.verlag != null ? !this.verlag.equals(ezbDaten.verlag)
				: ezbDaten.verlag != null)
			return false;
		if (this.volltexturl != null ? !this.volltexturl
				.equals(ezbDaten.volltexturl) : ezbDaten.volltexturl != null)
			return false;
		if (this.zdbNummer != null ? !this.zdbNummer.equals(ezbDaten.zdbNummer)
				: ezbDaten.zdbNummer != null)
			return false;
		if (this.zugangsbedingung != null ? !this.zugangsbedingung
				.equals(ezbDaten.zugangsbedingung)
				: ezbDaten.zugangsbedingung != null)
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
		int result = (int) (this.ezbId ^ (this.ezbId >>> 32));
		result = (31 * result)
				+ (this.titel != null ? this.titel.hashCode() : 0);
		result = (31 * result)
				+ (this.zdbNummer != null ? this.zdbNummer.hashCode() : 0);
		result = (31 * result) + this.ampelfarbe;
		result = (31 * result)
				+ (this.verlag != null ? this.verlag.hashCode() : 0);
		result = (31 * result) + (this.typ != null ? this.typ.hashCode() : 0);
		result = (31 * result)
				+ (this.preistyp != null ? this.preistyp.hashCode() : 0);
		result = (31 * result)
				+ (this.zugangsbedingung != null ? this.zugangsbedingung
						.hashCode() : 0);
		result = (31 * result)
				+ (this.issne != null ? this.issne.hashCode() : 0);
		result = (31 * result)
				+ (this.issnp != null ? this.issnp.hashCode() : 0);
		result = (31 * result)
				+ (this.biburl != null ? this.biburl.hashCode() : 0);
		result = (31 * result)
				+ (this.volltexturl != null ? this.volltexturl.hashCode() : 0);
		result = (31 * result)
				+ (this.frontdoorurl != null ? this.frontdoorurl.hashCode() : 0);
		result = (31 * result) + (this.link != null ? this.link.hashCode() : 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return "EzbDaten{" + "ezbId=" + this.ezbId + ", titel='" + this.titel
				+ '\'' + ", zdbNummer='" + this.zdbNummer + '\''
				+ ", ampelfarbe=" + this.ampelfarbe + ", verlag='"
				+ this.verlag + '\'' + ", typ='" + this.typ + '\''
				+ ", preistyp='" + this.preistyp + '\''
				+ ", zugangsbedingung='" + this.zugangsbedingung + '\''
				+ ", issne='" + this.issne + '\'' + ", issnp='" + this.issnp
				+ '\'' + ", biburl='" + this.biburl + '\'' + ", volltexturl='"
				+ this.volltexturl + '\'' + ", frontdoorurl='"
				+ this.frontdoorurl + '\'' + ", link='" + this.link + '\''
				+ '}';
	}
}
