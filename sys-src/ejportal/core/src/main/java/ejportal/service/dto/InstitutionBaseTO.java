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

import java.util.ArrayList;
import java.util.List;

import ejportal.model.Journal;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 07.07.2010 Time: 12:51:40 To
 * change this template use File | Settings | File Templates.
 */
public class InstitutionBaseTO {

	/** The id. */
	private Long id;

	/** The name. */
	private String name;

	/** The abteilung. */
	private String abteilung;

	/** The strasse. */
	private String strasse;

	/** The postfach. */
	private String postfach;

	/** The plz_ort. */
	private String plz_ort;

	/** The bundesland. */
	private String bundesland;

	/** The land. */
	private String land;

	/** The ansprechpartner. */
	private String ansprechpartner;

	/** The email. */
	private String email;

	/** The fax. */
	private String fax;

	/** The telefon. */
	private String telefon;

	/** The bestellsprache. */
	private String bestellsprache;

	/** The status. */
	private String status;

	/** The kommentar. */
	private String kommentar;

	/** The kennwort. */
	private String kennwort;

	/** The fernzugriff. */
	private boolean fernzugriff;

	/** The bestellart. */
	private String bestellart;

	/** The fernzugriff erlaeuterung. */
	private String fernzugriffErlaeuterung;

	/** The zugang. */
	private String zugang;

	/** The personengruppe. */
	private String personengruppe;

	/** The zugangsdaten. */
	private String zugangsdaten;

	/** The kommentar intern. */
	private String kommentarIntern;

	/** The internetadresse. */
	private String internetadresse;

	/** The nutzungs url. */
	private String nutzungsURL;

	/** The copyright url. */
	private String copyrightURL;

	/** The account url. */
	private String accountURL;

	/** The statstik url. */
	private String statstikURL;

	/** The sfx url. */
	private String sfxURL;

	/** The ublogo url. */
	private String ublogoURL;

	/** The statstik zugang. */
	private String statstikZugang;

	/** The fernleihe. */
	private String fernleihe;

	/** The lizenz art. */
	private String lizenzArt;

	/** The lizenz abbest. */
	private String lizenzAbbest;

	/** The lizenz paket. */
	private String lizenzPaket;

	/** The lizenz vorgang. */
	private String lizenzVorgang;

	/** The lizenz zust. */
	private String lizenzZust;

	/** The lizenz bes. */
	private String lizenzBes;

	/** The verlag journals. */
	private List<Journal> verlagJournals = new ArrayList<Journal>();

	/** The provider journals. */
	private List<Journal> providerJournals = new ArrayList<Journal>();

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
	 * Gets the abteilung.
	 * 
	 * @return the abteilung
	 */
	public String getAbteilung() {
		return this.abteilung;
	}

	/**
	 * Sets the abteilung.
	 * 
	 * @param abteilung
	 *            the new abteilung
	 */
	public void setAbteilung(final String abteilung) {
		this.abteilung = abteilung;
	}

	/**
	 * Gets the strasse.
	 * 
	 * @return the strasse
	 */
	public String getStrasse() {
		return this.strasse;
	}

	/**
	 * Sets the strasse.
	 * 
	 * @param strasse
	 *            the new strasse
	 */
	public void setStrasse(final String strasse) {
		this.strasse = strasse;
	}

	/**
	 * Gets the postfach.
	 * 
	 * @return the postfach
	 */
	public String getPostfach() {
		return this.postfach;
	}

	/**
	 * Sets the postfach.
	 * 
	 * @param postfach
	 *            the new postfach
	 */
	public void setPostfach(final String postfach) {
		this.postfach = postfach;
	}

	/**
	 * Gets the plz_ort.
	 * 
	 * @return the plz_ort
	 */
	public String getPlz_ort() {
		return this.plz_ort;
	}

	/**
	 * Sets the plz_ort.
	 * 
	 * @param plz_ort
	 *            the new plz_ort
	 */
	public void setPlz_ort(final String plz_ort) {
		this.plz_ort = plz_ort;
	}

	/**
	 * Gets the bundesland.
	 * 
	 * @return the bundesland
	 */
	public String getBundesland() {
		return this.bundesland;
	}

	/**
	 * Sets the bundesland.
	 * 
	 * @param bundesland
	 *            the new bundesland
	 */
	public void setBundesland(final String bundesland) {
		this.bundesland = bundesland;
	}

	/**
	 * Gets the land.
	 * 
	 * @return the land
	 */
	public String getLand() {
		return this.land;
	}

	/**
	 * Sets the land.
	 * 
	 * @param land
	 *            the new land
	 */
	public void setLand(final String land) {
		this.land = land;
	}

	/**
	 * Gets the ansprechpartner.
	 * 
	 * @return the ansprechpartner
	 */
	public String getAnsprechpartner() {
		return this.ansprechpartner;
	}

	/**
	 * Sets the ansprechpartner.
	 * 
	 * @param ansprechpartner
	 *            the new ansprechpartner
	 */
	public void setAnsprechpartner(final String ansprechpartner) {
		this.ansprechpartner = ansprechpartner;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Gets the fax.
	 * 
	 * @return the fax
	 */
	public String getFax() {
		return this.fax;
	}

	/**
	 * Sets the fax.
	 * 
	 * @param fax
	 *            the new fax
	 */
	public void setFax(final String fax) {
		this.fax = fax;
	}

	/**
	 * Gets the telefon.
	 * 
	 * @return the telefon
	 */
	public String getTelefon() {
		return this.telefon;
	}

	/**
	 * Sets the telefon.
	 * 
	 * @param telefon
	 *            the new telefon
	 */
	public void setTelefon(final String telefon) {
		this.telefon = telefon;
	}

	/**
	 * Gets the bestellsprache.
	 * 
	 * @return the bestellsprache
	 */
	public String getBestellsprache() {
		return this.bestellsprache;
	}

	/**
	 * Sets the bestellsprache.
	 * 
	 * @param bestellsprache
	 *            the new bestellsprache
	 */
	public void setBestellsprache(final String bestellsprache) {
		this.bestellsprache = bestellsprache;
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
	 * Gets the kennwort.
	 * 
	 * @return the kennwort
	 */
	public String getKennwort() {
		return this.kennwort;
	}

	/**
	 * Sets the kennwort.
	 * 
	 * @param kennwort
	 *            the new kennwort
	 */
	public void setKennwort(final String kennwort) {
		this.kennwort = kennwort;
	}

	/**
	 * Gets the fernzugriff.
	 * 
	 * @return the fernzugriff
	 */
	public boolean getFernzugriff() {
		return this.fernzugriff;
	}

	/**
	 * Sets the fernzugriff.
	 * 
	 * @param fernzugriff
	 *            the new fernzugriff
	 */
	public void setFernzugriff(final boolean fernzugriff) {
		this.fernzugriff = fernzugriff;
	}

	/**
	 * Gets the verlag journals.
	 * 
	 * @return the verlag journals
	 */
	public List<Journal> getVerlagJournals() {
		return this.verlagJournals;
	}

	/**
	 * Sets the verlag journals.
	 * 
	 * @param verlagJournals
	 *            the new verlag journals
	 */
	public void setVerlagJournals(final List<Journal> verlagJournals) {
		this.verlagJournals = verlagJournals;
	}

	/**
	 * Gets the provider journals.
	 * 
	 * @return the provider journals
	 */
	public List<Journal> getProviderJournals() {
		return this.providerJournals;
	}

	/**
	 * Sets the provider journals.
	 * 
	 * @param providerJournals
	 *            the new provider journals
	 */
	public void setProviderJournals(final List<Journal> providerJournals) {
		this.providerJournals = providerJournals;
	}

	/**
	 * Gets the bestellart.
	 * 
	 * @return the bestellart
	 */
	public String getBestellart() {
		return this.bestellart;
	}

	/**
	 * Sets the bestellart.
	 * 
	 * @param bestellart
	 *            the new bestellart
	 */
	public void setBestellart(final String bestellart) {
		this.bestellart = bestellart;
	}

	/**
	 * Gets the fernzugriff erlaeuterung.
	 * 
	 * @return the fernzugriff erlaeuterung
	 */
	public String getFernzugriffErlaeuterung() {
		return this.fernzugriffErlaeuterung;
	}

	/**
	 * Sets the fernzugriff erlaeuterung.
	 * 
	 * @param fernzugriffErlaeuterung
	 *            the new fernzugriff erlaeuterung
	 */
	public void setFernzugriffErlaeuterung(final String fernzugriffErlaeuterung) {
		this.fernzugriffErlaeuterung = fernzugriffErlaeuterung;
	}

	/**
	 * Gets the zugang.
	 * 
	 * @return the zugang
	 */
	public String getZugang() {
		return this.zugang;
	}

	/**
	 * Sets the zugang.
	 * 
	 * @param zugang
	 *            the new zugang
	 */
	public void setZugang(final String zugang) {
		this.zugang = zugang;
	}

	/**
	 * Gets the personengruppe.
	 * 
	 * @return the personengruppe
	 */
	public String getPersonengruppe() {
		return this.personengruppe;
	}

	/**
	 * Sets the personengruppe.
	 * 
	 * @param personengruppe
	 *            the new personengruppe
	 */
	public void setPersonengruppe(final String personengruppe) {
		this.personengruppe = personengruppe;
	}

	/**
	 * Gets the zugangsdaten.
	 * 
	 * @return the zugangsdaten
	 */
	public String getZugangsdaten() {
		return this.zugangsdaten;
	}

	/**
	 * Sets the zugangsdaten.
	 * 
	 * @param zugangsdaten
	 *            the new zugangsdaten
	 */
	public void setZugangsdaten(final String zugangsdaten) {
		this.zugangsdaten = zugangsdaten;
	}

	/**
	 * Gets the kommentar intern.
	 * 
	 * @return the kommentar intern
	 */
	public String getKommentarIntern() {
		return this.kommentarIntern;
	}

	/**
	 * Sets the kommentar intern.
	 * 
	 * @param kommentarIntern
	 *            the new kommentar intern
	 */
	public void setKommentarIntern(final String kommentarIntern) {
		this.kommentarIntern = kommentarIntern;
	}

	/**
	 * Gets the internetadresse.
	 * 
	 * @return the internetadresse
	 */
	public String getInternetadresse() {
		return this.internetadresse;
	}

	/**
	 * Sets the internetadresse.
	 * 
	 * @param internetadresse
	 *            the new internetadresse
	 */
	public void setInternetadresse(final String internetadresse) {
		this.internetadresse = internetadresse;
	}

	/**
	 * Gets the nutzungs url.
	 * 
	 * @return the nutzungs url
	 */
	public String getNutzungsURL() {
		return this.nutzungsURL;
	}

	/**
	 * Sets the nutzungs url.
	 * 
	 * @param nutzungsURL
	 *            the new nutzungs url
	 */
	public void setNutzungsURL(final String nutzungsURL) {
		this.nutzungsURL = nutzungsURL;
	}

	/**
	 * Gets the copyright url.
	 * 
	 * @return the copyright url
	 */
	public String getCopyrightURL() {
		return this.copyrightURL;
	}

	/**
	 * Sets the copyright url.
	 * 
	 * @param copyrightURL
	 *            the new copyright url
	 */
	public void setCopyrightURL(final String copyrightURL) {
		this.copyrightURL = copyrightURL;
	}

	/**
	 * Gets the account url.
	 * 
	 * @return the account url
	 */
	public String getAccountURL() {
		return this.accountURL;
	}

	/**
	 * Sets the account url.
	 * 
	 * @param accountURL
	 *            the new account url
	 */
	public void setAccountURL(final String accountURL) {
		this.accountURL = accountURL;
	}

	/**
	 * Gets the statstik url.
	 * 
	 * @return the statstik url
	 */
	public String getStatstikURL() {
		return this.statstikURL;
	}

	/**
	 * Sets the statstik url.
	 * 
	 * @param statstikURL
	 *            the new statstik url
	 */
	public void setStatstikURL(final String statstikURL) {
		this.statstikURL = statstikURL;
	}

	/**
	 * Gets the sfx url.
	 * 
	 * @return the sfx url
	 */
	public String getSfxURL() {
		return this.sfxURL;
	}

	/**
	 * Sets the sfx url.
	 * 
	 * @param sfxURL
	 *            the new sfx url
	 */
	public void setSfxURL(final String sfxURL) {
		this.sfxURL = sfxURL;
	}

	/**
	 * Gets the ublogo url.
	 * 
	 * @return the ublogo url
	 */
	public String getUblogoURL() {
		return this.ublogoURL;
	}

	/**
	 * Sets the ublogo url.
	 * 
	 * @param ublogoURL
	 *            the new ublogo url
	 */
	public void setUblogoURL(final String ublogoURL) {
		this.ublogoURL = ublogoURL;
	}

	/**
	 * Gets the statstik zugang.
	 * 
	 * @return the statstik zugang
	 */
	public String getStatstikZugang() {
		return this.statstikZugang;
	}

	/**
	 * Sets the statstik zugang.
	 * 
	 * @param statstikZugang
	 *            the new statstik zugang
	 */
	public void setStatstikZugang(final String statstikZugang) {
		this.statstikZugang = statstikZugang;
	}

	/**
	 * Gets the fernleihe.
	 * 
	 * @return the fernleihe
	 */
	public String getFernleihe() {
		return this.fernleihe;
	}

	/**
	 * Sets the fernleihe.
	 * 
	 * @param fernleihe
	 *            the new fernleihe
	 */
	public void setFernleihe(final String fernleihe) {
		this.fernleihe = fernleihe;
	}

	/**
	 * Gets the lizenz art.
	 * 
	 * @return the lizenz art
	 */
	public String getLizenzArt() {
		return this.lizenzArt;
	}

	/**
	 * Sets the lizenz art.
	 * 
	 * @param lizenzArt
	 *            the new lizenz art
	 */
	public void setLizenzArt(final String lizenzArt) {
		this.lizenzArt = lizenzArt;
	}

	/**
	 * Gets the lizenz abbest.
	 * 
	 * @return the lizenz abbest
	 */
	public String getLizenzAbbest() {
		return this.lizenzAbbest;
	}

	/**
	 * Sets the lizenz abbest.
	 * 
	 * @param lizenzAbbest
	 *            the new lizenz abbest
	 */
	public void setLizenzAbbest(final String lizenzAbbest) {
		this.lizenzAbbest = lizenzAbbest;
	}

	/**
	 * Gets the lizenz paket.
	 * 
	 * @return the lizenz paket
	 */
	public String getLizenzPaket() {
		return this.lizenzPaket;
	}

	/**
	 * Sets the lizenz paket.
	 * 
	 * @param lizenzPaket
	 *            the new lizenz paket
	 */
	public void setLizenzPaket(final String lizenzPaket) {
		this.lizenzPaket = lizenzPaket;
	}

	/**
	 * Gets the lizenz vorgang.
	 * 
	 * @return the lizenz vorgang
	 */
	public String getLizenzVorgang() {
		return this.lizenzVorgang;
	}

	/**
	 * Sets the lizenz vorgang.
	 * 
	 * @param lizenzVorgang
	 *            the new lizenz vorgang
	 */
	public void setLizenzVorgang(final String lizenzVorgang) {
		this.lizenzVorgang = lizenzVorgang;
	}

	/**
	 * Gets the lizenz zust.
	 * 
	 * @return the lizenz zust
	 */
	public String getLizenzZust() {
		return this.lizenzZust;
	}

	/**
	 * Sets the lizenz zust.
	 * 
	 * @param lizenzZust
	 *            the new lizenz zust
	 */
	public void setLizenzZust(final String lizenzZust) {
		this.lizenzZust = lizenzZust;
	}

	/**
	 * Gets the lizenz bes.
	 * 
	 * @return the lizenz bes
	 */
	public String getLizenzBes() {
		return this.lizenzBes;
	}

	/**
	 * Sets the lizenz bes.
	 * 
	 * @param lizenzBes
	 *            the new lizenz bes
	 */
	public void setLizenzBes(final String lizenzBes) {
		this.lizenzBes = lizenzBes;
	}

}
