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

import java.util.Date;

/**
 * Created by IntelliJ IDEA. User: Florian Date: 01.07.2010 Time: 13:15:54 To
 * change this template use File | Settings | File Templates.
 */
public class JournalBaseTO {

	/** The id. */
	private Long id;

	/** The herausgeber. */
	private String herausgeber;

	/** The titel. */
	private String titel;

	/** The kurztitel. */
	private String kurztitel;

	/** The issn. */
	private String issn;

	/** The issn print. */
	private String issnPrint;

	/** The kommentar. */
	private String kommentar;

	/** The kommentar admin. */
	private String kommentarAdmin;

	/** The kommentar intranet. */
	private String kommentarIntranet;

	/** The zugang ueber. */
	private String zugangUeber;

	/** The anmeldedatum. */
	private Date anmeldedatum;

	/** The freischaltdatum. */
	private Date freischaltdatum;

	/** The zugangs id. */
	private String zugangsId;

	/** The zugangs passwort. */
	private String zugangsPasswort;

	/** The nutzungsbestimmungen. */
	private String nutzungsbestimmungen;

	/** The rotschaltungsdatum. */
	private Date rotschaltungsdatum;

	/** The rotschaltungsbemerkungen. */
	private String rotschaltungsbemerkungen;

	/** The status. */
	private String status;

	/** The aenderungsdatum. */
	private Date aenderungsdatum;

	/** The zdb nummer. */
	private String zdbNummer;

	/** The anker. */
	private String anker;

	/** The read me titelbezogen. */
	private boolean readMeTitelbezogen;

	/** The import id. */
	private String importId;

	/** The bearbeitungsdatum. */
	private Date bearbeitungsdatum;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * Gets the herausgeber.
	 * 
	 * @return the herausgeber
	 */
	public String getHerausgeber() {
		return this.herausgeber;
	}

	/**
	 * Sets the herausgeber.
	 * 
	 * @param herausgeber
	 *            the new herausgeber
	 */
	public void setHerausgeber(final String herausgeber) {
		this.herausgeber = herausgeber;
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
	 * Gets the issn.
	 * 
	 * @return the issn
	 */
	public String getIssn() {
		return this.issn;
	}

	/**
	 * Sets the issn.
	 * 
	 * @param issn
	 *            the new issn
	 */
	public void setIssn(final String issn) {
		this.issn = issn;
	}

	/**
	 * Gets the issn print.
	 * 
	 * @return the issn print
	 */
	public String getIssnPrint() {
		return this.issnPrint;
	}

	/**
	 * Sets the issn print.
	 * 
	 * @param issnPrint
	 *            the new issn print
	 */
	public void setIssnPrint(final String issnPrint) {
		this.issnPrint = issnPrint;
	}

	/**
	 * Gets the kommentar.
	 * 
	 * @return the kommentar
	 */
	public String getKommentar() {
		return this.kommentar;
	}

	/**
	 * Sets the kommentar.
	 * 
	 * @param kommentar
	 *            the new kommentar
	 */
	public void setKommentar(final String kommentar) {
		this.kommentar = kommentar;
	}

	/**
	 * Gets the kommentar admin.
	 * 
	 * @return the kommentar admin
	 */
	public String getKommentarAdmin() {
		return this.kommentarAdmin;
	}

	/**
	 * Sets the kommentar admin.
	 * 
	 * @param kommentarAdmin
	 *            the new kommentar admin
	 */
	public void setKommentarAdmin(final String kommentarAdmin) {
		this.kommentarAdmin = kommentarAdmin;
	}

	/**
	 * Gets the kommentar intranet.
	 * 
	 * @return the kommentar intranet
	 */
	public String getKommentarIntranet() {
		return this.kommentarIntranet;
	}

	/**
	 * Sets the kommentar intranet.
	 * 
	 * @param kommentarIntranet
	 *            the new kommentar intranet
	 */
	public void setKommentarIntranet(final String kommentarIntranet) {
		this.kommentarIntranet = kommentarIntranet;
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

	/**
	 * Gets the anmeldedatum.
	 * 
	 * @return the anmeldedatum
	 */
	public Date getAnmeldedatum() {
		return this.anmeldedatum;
	}

	/**
	 * Sets the anmeldedatum.
	 * 
	 * @param anmeldedatum
	 *            the new anmeldedatum
	 */
	public void setAnmeldedatum(final Date anmeldedatum) {
		this.anmeldedatum = anmeldedatum;
	}

	/**
	 * Gets the freischaltdatum.
	 * 
	 * @return the freischaltdatum
	 */
	public Date getFreischaltdatum() {
		return this.freischaltdatum;
	}

	/**
	 * Sets the freischaltdatum.
	 * 
	 * @param freischaltdatum
	 *            the new freischaltdatum
	 */
	public void setFreischaltdatum(final Date freischaltdatum) {
		this.freischaltdatum = freischaltdatum;
	}

	/**
	 * Gets the zugangs id.
	 * 
	 * @return the zugangs id
	 */
	public String getZugangsId() {
		return this.zugangsId;
	}

	/**
	 * Sets the zugangs id.
	 * 
	 * @param zugangsId
	 *            the new zugangs id
	 */
	public void setZugangsId(final String zugangsId) {
		this.zugangsId = zugangsId;
	}

	/**
	 * Gets the zugangs passwort.
	 * 
	 * @return the zugangs passwort
	 */
	public String getZugangsPasswort() {
		return this.zugangsPasswort;
	}

	/**
	 * Sets the zugangs passwort.
	 * 
	 * @param zugangsPasswort
	 *            the new zugangs passwort
	 */
	public void setZugangsPasswort(final String zugangsPasswort) {
		this.zugangsPasswort = zugangsPasswort;
	}

	/**
	 * Gets the nutzungsbestimmungen.
	 * 
	 * @return the nutzungsbestimmungen
	 */
	public String getNutzungsbestimmungen() {
		return this.nutzungsbestimmungen;
	}

	/**
	 * Sets the nutzungsbestimmungen.
	 * 
	 * @param nutzungsbestimmungen
	 *            the new nutzungsbestimmungen
	 */
	public void setNutzungsbestimmungen(final String nutzungsbestimmungen) {
		this.nutzungsbestimmungen = nutzungsbestimmungen;
	}

	/**
	 * Gets the rotschaltungsdatum.
	 * 
	 * @return the rotschaltungsdatum
	 */
	public Date getRotschaltungsdatum() {
		return this.rotschaltungsdatum;
	}

	/**
	 * Sets the rotschaltungsdatum.
	 * 
	 * @param rotschaltungsdatum
	 *            the new rotschaltungsdatum
	 */
	public void setRotschaltungsdatum(final Date rotschaltungsdatum) {
		this.rotschaltungsdatum = rotschaltungsdatum;
	}

	/**
	 * Gets the rotschaltungsbemerkungen.
	 * 
	 * @return the rotschaltungsbemerkungen
	 */
	public String getRotschaltungsbemerkungen() {
		return this.rotschaltungsbemerkungen;
	}

	/**
	 * Sets the rotschaltungsbemerkungen.
	 * 
	 * @param rotschaltungsbemerkungen
	 *            the new rotschaltungsbemerkungen
	 */
	public void setRotschaltungsbemerkungen(
			final String rotschaltungsbemerkungen) {
		this.rotschaltungsbemerkungen = rotschaltungsbemerkungen;
	}

	/**
	 * Gets the status.
	 * 
	 * @return the status
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Sets the status.
	 * 
	 * @param status
	 *            the new status
	 */
	public void setStatus(final String status) {
		this.status = status;
	}

	/**
	 * Gets the aenderungsdatum.
	 * 
	 * @return the aenderungsdatum
	 */
	public Date getAenderungsdatum() {
		return this.aenderungsdatum;
	}

	/**
	 * Sets the aenderungsdatum.
	 * 
	 * @param aenderungsdatum
	 *            the new aenderungsdatum
	 */
	public void setAenderungsdatum(final Date aenderungsdatum) {
		this.aenderungsdatum = aenderungsdatum;
	}

	/**
	 * Gets the zdb nummer.
	 * 
	 * @return the zdb nummer
	 */
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
	 * Gets the anker.
	 * 
	 * @return the anker
	 */
	public String getAnker() {
		return this.anker;
	}

	/**
	 * Sets the anker.
	 * 
	 * @param anker
	 *            the new anker
	 */
	public void setAnker(final String anker) {
		this.anker = anker;
	}

	/**
	 * Gets the read me titelbezogen.
	 * 
	 * @return the read me titelbezogen
	 */
	public boolean getReadMeTitelbezogen() {
		return this.readMeTitelbezogen;
	}

	/**
	 * Sets the read me titelbezogen.
	 * 
	 * @param readMeTitelbezogen
	 *            the new read me titelbezogen
	 */
	public void setReadMeTitelbezogen(final boolean readMeTitelbezogen) {
		this.readMeTitelbezogen = readMeTitelbezogen;
	}

	/**
	 * Gets the import id.
	 * 
	 * @return the import id
	 */
	public String getImportId() {
		return this.importId;
	}

	/**
	 * Sets the import id.
	 * 
	 * @param importId
	 *            the new import id
	 */
	public void setImportId(final String importId) {
		this.importId = importId;
	}

	/**
	 * Gets the bearbeitungsdatum.
	 * 
	 * @return the bearbeitungsdatum
	 */
	public Date getBearbeitungsdatum() {
		return this.bearbeitungsdatum;
	}

	/**
	 * Sets the bearbeitungsdatum.
	 * 
	 * @param bearbeitungsdatum
	 *            the new bearbeitungsdatum
	 */
	public void setBearbeitungsdatum(final Date bearbeitungsdatum) {
		this.bearbeitungsdatum = bearbeitungsdatum;
	}
}
