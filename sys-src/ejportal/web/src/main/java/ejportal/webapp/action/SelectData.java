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
package ejportal.webapp.action;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA. User: ag35ogub Date: 02.08.2010 Time: 13:42:45 To
 * change this template use File | Settings | File Templates.
 */

public class SelectData {

	/** The journal zugang ueber. */
	private final Map<String, String> journalZugangUeber = new HashMap<String, String>();

	/** The journal nutzungsbestimmungen. */
	private final Map<String, String> journalNutzungsbestimmungen = new HashMap<String, String>();

	/** The journal status. */
	private final Map<String, String> journalStatus = new HashMap<String, String>();

	/** The exemplar status. */
	private final Map<String, String> exemplarStatus = new HashMap<String, String>();

	/** The exemplar beteiligung. */
	private final Map<String, String> exemplarBeteiligung = new HashMap<String, String>();

	/** The exemplar form. */
	private final Map<String, String> exemplarForm = new HashMap<String, String>();

	/** The exemplar zugangsart. */
	private final Map<String, String> exemplarZugangsart = new HashMap<String, String>();

	/** The exemplar abbestellung. */
	private final Map<String, String> exemplarAbbestellung = new HashMap<String, String>();

	/** The exemplar umbestellung. */
	private final Map<String, String> exemplarUmbestellung = new HashMap<String, String>();

	/** The institution lizenz art. */
	private final Map<String, String> institutionLizenzArt = new HashMap<String, String>();

	/** The institution zugang. */
	private final Map<String, String> institutionZugang = new HashMap<String, String>();

	/** The institution personengruppe. */
	private final Map<String, String> institutionPersonengruppe = new HashMap<String, String>();

	/** The institution fernleihe. */
	private final Map<String, String> institutionFernleihe = new HashMap<String, String>();

	/** The institution bestellsprache. */
	private final Map<String, String> institutionBestellsprache = new HashMap<String, String>();

	/** The institution bestellart. */
	private final Map<String, String> institutionBestellart = new HashMap<String, String>();

	/** The projekt waehrung. */
	private final Map<String, String> projektWaehrung = new HashMap<String, String>();

	/** The projekt mw st. */
	private final Map<String, String> projektMwSt = new HashMap<String, String>();

	/**
	 * Instantiates a new select data.
	 */
	public SelectData() {

		// Journal
		this.setJournalZugangUeber("Konsortium ohne Abo.");
		this.setJournalZugangUeber("Konsortium mit Abo.");
		this.setJournalZugangUeber("Eigenes Abo.");

		this.setJournalNutzungsbestimmungen("frei zug�nglich");
		this.setJournalNutzungsbestimmungen("Kennung erhalten die Universit�ts-Angeh�rigen an den Info-Stellen der Bibliothek");
		this.setJournalNutzungsbestimmungen("Zugriff von der Domain Universit�t Erlangen-N�rnberg");

		this.setJournalStatus("bearbeitet");
		this.setJournalStatus("Projektimport");

		// Exemplar
		this.setExemplarStatus("laufend");
		this.setExemplarStatus("zentral bestellt");
		this.setExemplarStatus("zentral vorgemerkt");
		this.setExemplarStatus("bearbeiten");
		this.setExemplarStatus("beendet");
		this.setExemplarStatus("kein Abo.");

		this.setExemplarBeteiligung("Mitglied");
		this.setExemplarBeteiligung("Herausgeber");
		this.setExemplarBeteiligung("Autor");

		this.setExemplarForm("Online");
		this.setExemplarForm("Print");
		this.setExemplarForm("Print + Online");
		this.setExemplarForm("Online Kons-Anteil");

		this.setExemplarZugangsart("Kauf");
		this.setExemplarZugangsart("Konsortium");
		this.setExemplarZugangsart("Geschenk / Spende");
		this.setExemplarZugangsart("Mitgliedschaft");
		this.setExemplarZugangsart("kein Abo.");

		this.setExemplarAbbestellung("abbestellt");
		this.setExemplarAbbestellung("Abbestellwunsch");

		this.setExemplarUmbestellung("umbestellt");

		// Institution
		this.setInstitutionLizenzArt("Konsortium");
		this.setInstitutionLizenzArt("Nationallizenz (Archiv)");
		this.setInstitutionLizenzArt("Nationallizenz (laufende ZS)");
		this.setInstitutionLizenzArt("Vertrag");

		this.setInstitutionZugang("IP");
		this.setInstitutionZugang("PW");
		this.setInstitutionZugang("Han-IP");
		this.setInstitutionZugang("Han-PW");

		this.setInstitutionPersonengruppe("uniweit");
		this.setInstitutionPersonengruppe("Professoren");
		this.setInstitutionPersonengruppe("Mitarbeiter");

		this.setInstitutionFernleihe("Fernleihkopien nur f�r den Deutschen Leihverkehr m�glich");
		this.setInstitutionFernleihe("Keine Fernleihkopien m�glich");
		this.setInstitutionFernleihe("Fernleihkopien f�r den Deutschen und Internationalen Leihverkehr m�glich");

		this.setInstitutionBestellsprache("dt.");
		this.setInstitutionBestellsprache("engl.");

		this.setInstitutionBestellart("Email");
		this.setInstitutionBestellart("Brief");

		// Projektplanung
		this.setProjektWaehrung("EUR");
		this.setProjektWaehrung("CHF");
		this.setProjektWaehrung("GBP");
		this.setProjektWaehrung("USD");

		this.setProjektMwSt("7.00", "7,00%");
		this.setProjektMwSt("16.00", "16,00%");
		this.setProjektMwSt("19.00", "19,00%");
		this.setProjektMwSt("0.00", "0");

	}

	/**
	 * Gets the journal zugang ueber.
	 * 
	 * @return the journal zugang ueber
	 */
	public Map<String, String> getJournalZugangUeber() {
		return this.journalZugangUeber;
	}

	/**
	 * Sets the journal zugang ueber.
	 * 
	 * @param value
	 *            the new journal zugang ueber
	 */
	public void setJournalZugangUeber(final String value) {
		this.journalZugangUeber.put(value, value);
	}

	/**
	 * Gets the journal nutzungsbestimmungen.
	 * 
	 * @return the journal nutzungsbestimmungen
	 */
	public Map<String, String> getJournalNutzungsbestimmungen() {
		return this.journalNutzungsbestimmungen;
	}

	/**
	 * Sets the journal nutzungsbestimmungen.
	 * 
	 * @param value
	 *            the new journal nutzungsbestimmungen
	 */
	public void setJournalNutzungsbestimmungen(final String value) {
		this.journalNutzungsbestimmungen.put(value, value);
	}

	/**
	 * Gets the journal status.
	 * 
	 * @return the journal status
	 */
	public Map<String, String> getJournalStatus() {
		return this.journalStatus;
	}

	/**
	 * Sets the journal status.
	 * 
	 * @param value
	 *            the new journal status
	 */
	public void setJournalStatus(final String value) {
		this.journalStatus.put(value, value);
	}

	/**
	 * Gets the exemplar status.
	 * 
	 * @return the exemplar status
	 */
	public Map<String, String> getExemplarStatus() {
		return this.exemplarStatus;
	}

	/**
	 * Sets the exemplar status.
	 * 
	 * @param value
	 *            the new exemplar status
	 */
	public void setExemplarStatus(final String value) {
		this.exemplarStatus.put(value, value);
	}

	/**
	 * Gets the exemplar beteiligung.
	 * 
	 * @return the exemplar beteiligung
	 */
	public Map<String, String> getExemplarBeteiligung() {
		return this.exemplarBeteiligung;
	}

	/**
	 * Sets the exemplar beteiligung.
	 * 
	 * @param value
	 *            the new exemplar beteiligung
	 */
	public void setExemplarBeteiligung(final String value) {
		this.exemplarBeteiligung.put(value, value);
	}

	/**
	 * Gets the exemplar form.
	 * 
	 * @return the exemplar form
	 */
	public Map<String, String> getExemplarForm() {
		return this.exemplarForm;
	}

	/**
	 * Sets the exemplar form.
	 * 
	 * @param value
	 *            the new exemplar form
	 */
	public void setExemplarForm(final String value) {
		this.exemplarForm.put(value, value);
	}

	/**
	 * Gets the exemplar zugangsart.
	 * 
	 * @return the exemplar zugangsart
	 */
	public Map<String, String> getExemplarZugangsart() {
		return this.exemplarZugangsart;
	}

	/**
	 * Sets the exemplar zugangsart.
	 * 
	 * @param value
	 *            the new exemplar zugangsart
	 */
	public void setExemplarZugangsart(final String value) {
		this.exemplarZugangsart.put(value, value);
	}

	/**
	 * Gets the exemplar abbestellung.
	 * 
	 * @return the exemplar abbestellung
	 */
	public Map<String, String> getExemplarAbbestellung() {
		return this.exemplarAbbestellung;
	}

	/**
	 * Sets the exemplar abbestellung.
	 * 
	 * @param value
	 *            the new exemplar abbestellung
	 */
	public void setExemplarAbbestellung(final String value) {
		this.exemplarAbbestellung.put(value, value);
	}

	/**
	 * Gets the exemplar umbestellung.
	 * 
	 * @return the exemplar umbestellung
	 */
	public Map<String, String> getExemplarUmbestellung() {
		return this.exemplarUmbestellung;
	}

	/**
	 * Sets the exemplar umbestellung.
	 * 
	 * @param exemplarUmbestellung
	 *            the new exemplar umbestellung
	 */
	public void setExemplarUmbestellung(final String exemplarUmbestellung) {
		this.exemplarUmbestellung.put(exemplarUmbestellung,
				exemplarUmbestellung);
	}

	/**
	 * Gets the institution lizenz art.
	 * 
	 * @return the institution lizenz art
	 */
	public Map<String, String> getInstitutionLizenzArt() {
		return this.institutionLizenzArt;
	}

	/**
	 * Sets the institution lizenz art.
	 * 
	 * @param value
	 *            the new institution lizenz art
	 */
	public void setInstitutionLizenzArt(final String value) {
		this.institutionLizenzArt.put(value, value);
	}

	/**
	 * Gets the institution zugang.
	 * 
	 * @return the institution zugang
	 */
	public Map<String, String> getInstitutionZugang() {
		return this.institutionZugang;
	}

	/**
	 * Sets the institution zugang.
	 * 
	 * @param value
	 *            the new institution zugang
	 */
	public void setInstitutionZugang(final String value) {
		this.institutionZugang.put(value, value);
	}

	/**
	 * Gets the institution personengruppe.
	 * 
	 * @return the institution personengruppe
	 */
	public Map<String, String> getInstitutionPersonengruppe() {
		return this.institutionPersonengruppe;
	}

	/**
	 * Sets the institution personengruppe.
	 * 
	 * @param value
	 *            the new institution personengruppe
	 */
	public void setInstitutionPersonengruppe(final String value) {
		this.institutionPersonengruppe.put(value, value);
	}

	/**
	 * Gets the institution fernleihe.
	 * 
	 * @return the institution fernleihe
	 */
	public Map<String, String> getInstitutionFernleihe() {
		return this.institutionFernleihe;
	}

	/**
	 * Sets the institution fernleihe.
	 * 
	 * @param value
	 *            the new institution fernleihe
	 */
	public void setInstitutionFernleihe(final String value) {
		this.institutionFernleihe.put(value, value);
	}

	/**
	 * Gets the institution bestellsprache.
	 * 
	 * @return the institution bestellsprache
	 */
	public Map<String, String> getInstitutionBestellsprache() {
		return this.institutionBestellsprache;
	}

	/**
	 * Sets the institution bestellsprache.
	 * 
	 * @param value
	 *            the new institution bestellsprache
	 */
	public void setInstitutionBestellsprache(final String value) {
		this.institutionBestellsprache.put(value, value);
	}

	/**
	 * Gets the institution bestellart.
	 * 
	 * @return the institution bestellart
	 */
	public Map<String, String> getInstitutionBestellart() {
		return this.institutionBestellart;
	}

	/**
	 * Sets the institution bestellart.
	 * 
	 * @param value
	 *            the new institution bestellart
	 */
	public void setInstitutionBestellart(final String value) {
		this.institutionBestellart.put(value, value);
	}

	/**
	 * Gets the projekt waehrung.
	 * 
	 * @return the projekt waehrung
	 */
	public Map<String, String> getProjektWaehrung() {
		return this.projektWaehrung;
	}

	/**
	 * Sets the projekt waehrung.
	 * 
	 * @param value
	 *            the new projekt waehrung
	 */
	public void setProjektWaehrung(final String value) {
		this.projektWaehrung.put(value, value);
	}

	/**
	 * Gets the projekt mw st.
	 * 
	 * @return the projekt mw st
	 */
	public Map<String, String> getProjektMwSt() {
		return this.projektMwSt;
	}

	/**
	 * Sets the projekt mw st.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public void setProjektMwSt(final String key, final String value) {
		this.projektMwSt.put(key, value);
	}
}
