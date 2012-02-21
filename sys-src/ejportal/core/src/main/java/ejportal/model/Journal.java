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

/**
 * Created by IntelliJ IDEA.
 * User: Christian
 * Date: 10.06.2010
 * Time: 10:49:00
 * To change this template use File | Settings | File Templates.
 */

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.appfuse.model.BaseObject;

/**
 * The Class Journal.
 */
@Entity
public class Journal extends BaseObject {

	/** The id. */
	private Long id;

	/** The herausgeber. */
	private String herausgeber;

	/** The bibliotheksmitarbeiter. */
	private Bibliotheksmitarbeiter bibliotheksmitarbeiter;

	/** The verlag. */
	private Institution verlag;

	/** The provider. */
	private Institution provider;

	/** The eigentuemer. */
	private Sigel eigentuemer;

	/** The freischalter. */
	private Bibliotheksmitarbeiter freischalter;

	/** The konsortium. */
	private Konsortium konsortium;

	/** The paket. */
	private Paket paket;

	/** The faecher. */
	private Set<Fach> faecher = new HashSet<Fach>();

	/** The exemplare. */
	private Set<Exemplar> exemplare = new HashSet<Exemplar>();
	// private EzbDaten ezbImport;

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

	/** The ezb id. */
	private Long ezbId; // -->ezbImport

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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	 * Gets the verlag.
	 * 
	 * @return the verlag
	 */
	@ManyToOne
	public Institution getVerlag() {
		return this.verlag;
	}

	/**
	 * Sets the verlag.
	 * 
	 * @param institution
	 *            the new verlag
	 */
	public void setVerlag(final Institution institution) {
		this.verlag = institution;
	}

	/**
	 * Gets the provider.
	 * 
	 * @return the provider
	 */
	@ManyToOne
	public Institution getProvider() {
		return this.provider;
	}

	/**
	 * Sets the provider.
	 * 
	 * @param provider
	 *            the new provider
	 */
	public void setProvider(final Institution provider) {
		this.provider = provider;
	}

	/**
	 * Gets the eigentuemer.
	 * 
	 * @return the eigentuemer
	 */
	@ManyToOne
	public Sigel getEigentuemer() {
		return this.eigentuemer;
	}

	/**
	 * Sets the eigentuemer.
	 * 
	 * @param eigentuemer
	 *            the new eigentuemer
	 */
	public void setEigentuemer(final Sigel eigentuemer) {
		this.eigentuemer = eigentuemer;
	}

	/**
	 * Gets the freischalter.
	 * 
	 * @return the freischalter
	 */
	@ManyToOne
	public Bibliotheksmitarbeiter getFreischalter() {
		return this.freischalter;
	}

	/**
	 * Sets the freischalter.
	 * 
	 * @param freischalter
	 *            the new freischalter
	 */
	public void setFreischalter(final Bibliotheksmitarbeiter freischalter) {
		this.freischalter = freischalter;
	}

	/**
	 * Gets the konsortium.
	 * 
	 * @return the konsortium
	 */
	@ManyToOne
	public Konsortium getKonsortium() {
		return this.konsortium;
	}

	/**
	 * Sets the konsortium.
	 * 
	 * @param konsortium
	 *            the new konsortium
	 */
	public void setKonsortium(final Konsortium konsortium) {
		this.konsortium = konsortium;
	}

	/**
	 * Gets the paket.
	 * 
	 * @return the paket
	 */
	@ManyToOne
	public Paket getPaket() {
		return this.paket;
	}

	/**
	 * Sets the paket.
	 * 
	 * @param paket
	 *            the new paket
	 */
	public void setPaket(final Paket paket) {
		this.paket = paket;
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
	@Column(length = 2000)
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
	@Column(length = 2000)
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
	@Column(length = 2000)
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
	 * Gets the bibliotheksmitarbeiter.
	 * 
	 * @return the bibliotheksmitarbeiter
	 */
	@ManyToOne
	public Bibliotheksmitarbeiter getBibliotheksmitarbeiter() {
		return this.bibliotheksmitarbeiter;
	}

	/**
	 * Sets the bibliotheksmitarbeiter.
	 * 
	 * @param bibliotheksmitarbeiter
	 *            the new bibliotheksmitarbeiter
	 */
	public void setBibliotheksmitarbeiter(
			final Bibliotheksmitarbeiter bibliotheksmitarbeiter) {
		this.bibliotheksmitarbeiter = bibliotheksmitarbeiter;
	}

	/**
	 * Gets the faecher.
	 * 
	 * @return the faecher
	 */
	@ManyToMany(mappedBy = "journals", fetch = FetchType.EAGER)
	@OrderBy(value = "fachId")
	public Set<Fach> getFaecher() {
		return this.faecher;
	}

	/**
	 * Sets the faecher.
	 * 
	 * @param faecher
	 *            the new faecher
	 */
	public void setFaecher(final Set<Fach> faecher) {
		this.faecher = faecher;
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

	/**
	 * Gets the exemplare.
	 * 
	 * @return the exemplare
	 */
	@OneToMany(mappedBy = "journal", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy(value = "exemplarId")
	public Set<Exemplar> getExemplare() {
		return this.exemplare;
	}

	/**
	 * Sets the exemplare.
	 * 
	 * @param exemplare
	 *            the new exemplare
	 */
	public void setExemplare(final Set<Exemplar> exemplare) {
		this.exemplare = exemplare;
	}

	/**
	 * Gets the ezb id.
	 * 
	 * @return the ezb id
	 */
	public Long getEzbId() {
		return this.ezbId;
	}

	/**
	 * Sets the ezb id.
	 * 
	 * @param ezbId
	 *            the new ezb id
	 */
	public void setEzbId(final Long ezbId) {
		this.ezbId = ezbId;
	}

	// von Hand, da sonst bei einem neuen Import die Fremdschluessel auf null
	// gesetzt werden :-(

	/**
	 * Equals.
	 * 
	 * @param o
	 *            the o
	 * @return true, if successful
	 * @OneToOne public EzbDaten getEzbImport() { return ezbImport; }
	 * 
	 *           public void setEzbImport(EzbDaten ezbImport) { this.ezbImport =
	 *           ezbImport; }
	 */

	@Override
	public boolean equals(final Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Journal))
			return false;

		final Journal journal = (Journal) o;

		if (this.id != journal.id)
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
		int result = this.id != null ? this.id.hashCode() : 0;
		result = (31 * result)
				+ (this.herausgeber != null ? this.herausgeber.hashCode() : 0);
		result = (31 * result)
				+ (this.titel != null ? this.titel.hashCode() : 0);
		result = (31 * result)
				+ (this.kurztitel != null ? this.kurztitel.hashCode() : 0);
		result = (31 * result) + (this.issn != null ? this.issn.hashCode() : 0);
		result = (31 * result)
				+ (this.issnPrint != null ? this.issnPrint.hashCode() : 0);
		result = (31 * result)
				+ (this.kommentar != null ? this.kommentar.hashCode() : 0);
		result = (31 * result)
				+ (this.kommentarAdmin != null ? this.kommentarAdmin.hashCode()
						: 0);
		result = (31 * result)
				+ (this.kommentarIntranet != null ? this.kommentarIntranet
						.hashCode() : 0);
		result = (31 * result)
				+ (this.zugangUeber != null ? this.zugangUeber.hashCode() : 0);
		result = (31 * result)
				+ (this.anmeldedatum != null ? this.anmeldedatum.hashCode() : 0);
		result = (31 * result)
				+ (this.freischaltdatum != null ? this.freischaltdatum
						.hashCode() : 0);
		result = (31 * result)
				+ (this.zugangsId != null ? this.zugangsId.hashCode() : 0);
		result = (31 * result)
				+ (this.zugangsPasswort != null ? this.zugangsPasswort
						.hashCode() : 0);
		result = (31 * result)
				+ (this.nutzungsbestimmungen != null ? this.nutzungsbestimmungen
						.hashCode() : 0);
		result = (31 * result)
				+ (this.rotschaltungsdatum != null ? this.rotschaltungsdatum
						.hashCode() : 0);
		result = (31 * result)
				+ (this.rotschaltungsbemerkungen != null ? this.rotschaltungsbemerkungen
						.hashCode() : 0);
		result = (31 * result)
				+ (this.status != null ? this.status.hashCode() : 0);
		result = (31 * result)
				+ (this.aenderungsdatum != null ? this.aenderungsdatum
						.hashCode() : 0);
		result = (31 * result)
				+ (this.zdbNummer != null ? this.zdbNummer.hashCode() : 0);
		result = (31 * result)
				+ (this.anker != null ? this.anker.hashCode() : 0);
		result = (31 * result) + (this.readMeTitelbezogen ? 1 : 0);
		result = (31 * result)
				+ (this.importId != null ? this.importId.hashCode() : 0);
		result = (31 * result)
				+ (this.bearbeitungsdatum != null ? this.bearbeitungsdatum
						.hashCode() : 0);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.appfuse.model.BaseObject#toString()
	 */
	@Override
	public String toString() {
		return (this.getId() + this.getTitel());
	}

}