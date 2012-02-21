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
package migration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;

import ejportal.dao.BibliotheksmitarbeiterDao;
import ejportal.dao.FachDao;
import ejportal.dao.InstitutionDao;
import ejportal.dao.KonsortiumDao;
import ejportal.dao.PaketDao;
import ejportal.dao.SigelDao;
import ejportal.model.Bibliotheksmitarbeiter;
import ejportal.model.Exemplar;
import ejportal.model.Fach;
import ejportal.model.Institution;
import ejportal.model.Journal;
import ejportal.model.Konsortium;
import ejportal.model.Lizenzdetail;
import ejportal.model.Paket;
import ejportal.model.Sigel;
import ejportal.service.BibliotheksmitarbeiterManager;
import ejportal.service.ExemplarManager;
import ejportal.service.FachManager;
import ejportal.service.InstitutionManager;
import ejportal.service.JournalManager;
import ejportal.service.KonsortiumManager;
import ejportal.service.LizenzdetailManager;
import ejportal.service.PaketManager;
import ejportal.service.SigelManager;

/**
 * Created by IntelliJ IDEA. User: Thomas Date: 04.08.2010 Time: 10:19:07 To
 * change this template use File | Settings | File Templates.
 */
public class Helper {

	/** The bibmitarb. */
	private int[] bibmitarb = new int[0];

	/** The institutionen. */
	private String[] institutionen = new String[0];

	/** The faecher. */
	private int[] faecher = new int[0];

	/** The sigel. */
	private String[] sigel = new String[0];

	/** The journalfaecher. */
	private Set<Fach>[] journalfaecher = new HashSet[0];

	/** The journals. */
	private int[] journals = new int[0];

	// private int[] exemplare = new int[0];

	/**
	 * Gets the bibmitarb.
	 * 
	 * @return the bibmitarb
	 */
	public int[] getBibmitarb() {
		return this.bibmitarb;
	}

	/**
	 * Gets the institutionen.
	 * 
	 * @return the institutionen
	 */
	public String[] getInstitutionen() {
		return this.institutionen;
	}

	/**
	 * Gets the faecher.
	 * 
	 * @return the faecher
	 */
	public int[] getFaecher() {
		return this.faecher;
	}

	/**
	 * Gets the sigel.
	 * 
	 * @return the sigel
	 */
	public String[] getSigel() {
		return this.sigel;
	}

	/**
	 * Gets the journalfaecher.
	 * 
	 * @return the journalfaecher
	 */
	public Set<Fach>[] getJournalfaecher() {
		return this.journalfaecher;
	}

	/**
	 * Gets the journals.
	 * 
	 * @return the journals
	 */
	public int[] getJournals() {
		return this.journals;
	}

	/**
	 * Creates an array of Bibliotheksmitarbeiter objects from the ResultSet rs.
	 * 
	 * @param rs
	 *            the rs
	 * @param laenge
	 *            the laenge
	 * @return the bibliotheksmitarbeiter[]
	 * @throws SQLException
	 *             the sQL exception
	 */
	Bibliotheksmitarbeiter[] createMitarbeiterArray(final ResultSet rs,
			final int laenge) throws SQLException {
		this.bibmitarb = new int[laenge];
		final Bibliotheksmitarbeiter[] ret = new Bibliotheksmitarbeiter[laenge];
		for (int i = 0; i < laenge; i++) {
			rs.next();
			ret[i] = new Bibliotheksmitarbeiter();
			this.bibmitarb[i] = rs.getInt(1);
			ret[i].setBibId((long) this.bibmitarb[i]);
			ret[i].setName(rs.getString("xName"));
			ret[i].setAbteilungsHauptstelle(rs
					.getString("AbteilungHauptstelle"));
			ret[i].setFensterumschlagAdresse(rs
					.getString("FensterumschlagAdresse"));
			ret[i].setHausanschrift(rs.getString("Hausanschrift"));
			ret[i].setPostanschrift(rs.getString("Postanschrift"));
			ret[i].setTelefon(rs.getString("Telefon"));
			ret[i].setTelefax(rs.getString("Telefax"));
			ret[i].setEmailanschrift(rs.getString("Emailanschrift"));
			ret[i].setUrl(rs.getString("URL"));
			ret[i].setUmstId(rs.getString("UmstId"));
			ret[i].setMitarbeiter(rs.getString("Mitarbeiter"));
			ret[i].setDienstort(rs.getString("Dienstort"));
		}
		return ret;
	}

	/**
	 * Creates the lizenzdetail array.
	 * 
	 * @param rs
	 *            the rs
	 * @param laenge
	 *            the laenge
	 * @param institutions
	 *            the institutions
	 * @param factory
	 *            the factory
	 * @return the lizenzdetail[]
	 * @throws SQLException
	 *             the sQL exception
	 */
	public Lizenzdetail[] createLizenzdetailArray(final ResultSet rs,
			final int laenge, final Institution[] institutions,
			final BeanFactory factory) throws SQLException {
		final InstitutionDao dao = (InstitutionDao) factory
				.getBean("institutionDao");
		final Lizenzdetail[] ret = new Lizenzdetail[laenge];
		for (int i = 0; i < laenge; i++) {
			rs.next();
			ret[i] = new Lizenzdetail();
			ret[i].setLizenzId(rs.getLong(1));
			final String tmp = rs.getString(2);
			search: for (int j = 0; j < institutions.length; j++) {
				if (institutions[j].getName().equals(tmp)) {
					ret[i].setVerlag(dao.get((long) (j + 1))); // Institution
					break search;
				}
			}
			// ret[i].setBeginn(rs.getDate("Beginn")); //TODO Feld muss string
			// akzeptieren
			// ret[i].setLaufzeit(rs.getInt("Laufzeit")); //TODO Feld muss
			// string akzeptieren
			// ret[i].setVerlaengerung(rs.getInt("Verlaengerung")); //TODO Feld
			// muss string akzeptieren
			ret[i].setKosten(rs.getInt("Kosten"));
			ret[i].setReadmeAktualisiert(rs.getString("ReadmeAktualisiert"));
		}
		return ret;
	}

	/**
	 * Creates the institution array.
	 * 
	 * @param rs
	 *            the rs
	 * @param laenge
	 *            the laenge
	 * @param factory
	 *            the factory
	 * @return the institution[]
	 * @throws SQLException
	 *             the sQL exception
	 */
	public Institution[] createInstitutionArray(final ResultSet rs,
			final int laenge, final BeanFactory factory) throws SQLException {
		this.institutionen = new String[laenge];
		final Institution[] ret = new Institution[laenge];
		final BibliotheksmitarbeiterDao dao = (BibliotheksmitarbeiterDao) factory
				.getBean("bibliotheksmitarbeiterDao");
		for (int i = 0; i < laenge; i++) {
			rs.next();
			ret[i] = new Institution();
			ret[i].setId((long) (i + 1));
			this.institutionen[i] = rs.getString("xName");
			ret[i].setName(this.institutionen[i]);
			ret[i].setAbteilung(rs.getString("Abteilung"));
			ret[i].setStrasse(rs.getString("Strasse"));
			ret[i].setPostfach(rs.getString("Postfach"));
			ret[i].setPlz_ort(rs.getString("PLZOrt"));
			ret[i].setBundesland(rs.getString("Bundesland"));
			ret[i].setLand(rs.getString("Land"));
			ret[i].setAnsprechpartner(rs.getString("Ansprechpartner"));
			ret[i].setEmail(rs.getString("Email"));
			ret[i].setFax(rs.getString("Fax"));
			ret[i].setTelefon(rs.getString("Telefon"));
			ret[i].setBestellsprache(rs.getString("Bestellsprache"));
			ret[i].setBestellart(rs.getString("Bestellart"));
			ret[i].setStatus(rs.getString("Status"));
			ret[i].setKennwort(rs.getString("Kennwoerter"));
			ret[i].setFernzugriff(rs.getBoolean("Fernzugriff"));
			ret[i].setFernzugriffErlaeuterung(rs.getString("FernzugangErl"));
			ret[i].setZugang(rs.getString("Zugang"));
			ret[i].setPersonengruppe(rs.getString("Personengruppe"));
			ret[i].setZugangsdaten(rs.getString("Zugangsdaten"));
			ret[i].setKommentar(rs.getString("Kommentar"));
			// ret[i].setKommentarIntern(rs.getString("KommentarIntern")); 400
			ret[i].setInternetadresse(rs.getString("Internetadresse"));
			ret[i].setNutzungsURL(rs.getString("NutzungURL"));
			ret[i].setCopyrightURL(rs.getString("CopyrightURL"));
			ret[i].setAccountURL(rs.getString("AccountURL"));
			ret[i].setStatstikURL(rs.getString("StatistikURL"));
			ret[i].setSfxURL(rs.getString("SFXURL"));
			ret[i].setUblogoURL(rs.getString("UBlogoURL"));
			ret[i].setStatstikZugang(rs.getString("StatistikZugang"));
			ret[i].setFernleihe(rs.getString("Fernleihe"));
			ret[i].setLizenzArt(rs.getString("LizenzArt"));
			ret[i].setLizenzAbbest(rs.getString("LizenzAbbest"));
			// ret[i].setLizenzPaket(rs.getString("LizenzPaket")); 300
			ret[i].setLizenzVorgang(rs.getString("LizenzVorg"));
			ret[i].setLizenzZust(rs.getString("LizenzZust"));
			// ret[i].setLizenzBes(rs.getString("LizenzBes")); 350
			final int tmp = rs.getInt(38);
			if (tmp > 0) {
				ret[i].setBibliotheksmitarbeiter(dao.get((long) this
						.getIdFromIntArray(this.bibmitarb, tmp))); // Bibliotheksmitarbeiter
			}
		}
		return ret;
	}

	/**
	 * Creates the journal array.
	 * 
	 * @param rs
	 *            the rs
	 * @param laenge
	 *            the laenge
	 * @param factory
	 *            the factory
	 * @param stringPakets
	 *            the string pakets
	 * @param stringKonsortien
	 *            the string konsortien
	 * @return the journal[]
	 * @throws SQLException
	 *             the sQL exception
	 */
	public Journal[] createJournalArray(final ResultSet rs, final int laenge,
			final BeanFactory factory, final String[] stringPakets,
			final String[] stringKonsortien) throws SQLException {
		final Journal[] ret = new Journal[laenge];
		this.journals = new int[laenge];
		final PaketDao pdao = (PaketDao) factory.getBean("paketDao");
		final KonsortiumDao kdao = (KonsortiumDao) factory
				.getBean("konsortiumDao");
		final BibliotheksmitarbeiterDao bdao = (BibliotheksmitarbeiterDao) factory
				.getBean("bibliotheksmitarbeiterDao");
		final InstitutionDao idao = (InstitutionDao) factory
				.getBean("institutionDao");
		final FachDao fdao = (FachDao) factory.getBean("fachDao");
		boolean try_again = false;
		// Hilfsvariablen:
		long jId = -1;
		String Verlag = "";
		String Provider = "";
		String Konsortium = "";
		String Paket = "";
		int Bibliothek = -1;
		String Titel = "";
		String Kurztitel = "";
		String ISSN = "";
		String ISSNPrint = "";
		String Kommentar = "";
		String KommentarAdmin = "";
		String KommentarIntranet = "";
		Date Anmeldedatum = null;
		Date Freischaltdatum = null;
		String ZugangsID = "";
		String ZugangsPasswort = "";
		String Nutzungsbestimmungen = "";
		Date Rotschaltungsdatum = null;
		String Rotschaltungsbemerkungen = "";
		String Status = "";
		Date Aenderungsdatum = null;
		String ZdbNummer = "";
		Long EZBID = (long) -1;
		String Anker = "";
		Boolean Readmetitelbezogen = false;
		String Herausgeber = "";
		String ZugangUeber = "";
		Date termin = null;
		int Fach1 = -1;
		int Fach2 = -1;
		int Fach3 = -1;
		this.journalfaecher = new HashSet[laenge];
		for (int i = 0; i < laenge; i++) {
			try {
				if (!try_again) {
					rs.next();
					jId = rs.getLong(1);
					this.journals[i] = (int) jId;
					Verlag = rs.getString("Verlag");
					Provider = rs.getString("Provider");
					Konsortium = rs.getString("Konsortium");
					Paket = rs.getString("Paket");
					Bibliothek = rs.getInt("Bibliothek");
					Titel = rs.getString("Titel");
					Kurztitel = rs.getString("Kurztitel");
					ISSN = rs.getString("ISSN");
					ISSNPrint = rs.getString("ISSNPrint");
					Kommentar = rs.getString("Kommentar");
					KommentarAdmin = rs.getString("KommentarAdmin");
					KommentarIntranet = rs.getString("KommentarIntranet");
					Anmeldedatum = rs.getDate("Anmeldedatum");
					Freischaltdatum = rs.getDate("Freischaltdatum");
					ZugangsID = rs.getString("ZugangsId");
					ZugangsPasswort = rs.getString("ZugangsPasswort");
					Nutzungsbestimmungen = rs.getString("Nutzungsbestimmungen");
					Rotschaltungsdatum = rs.getDate("Rotschaltungsdatum");
					Rotschaltungsbemerkungen = rs
							.getString("Rotschaltungsbemerkungen");
					Status = rs.getString("Status");
					Aenderungsdatum = rs.getDate("Aenderungsdatum");
					ZdbNummer = rs.getString("ZdbNummer");
					EZBID = rs.getLong("EZBID");
					Anker = rs.getString("Anker");
					Readmetitelbezogen = rs.getBoolean("Readmetitelbezogen");
					Herausgeber = rs.getString("Herausgeber");
					ZugangUeber = rs.getString("ZugangUeber");
					Fach1 = rs.getInt("Fach1");
					Fach2 = rs.getInt("Fach2");
					Fach3 = rs.getInt("Fach3");
					termin = rs.getDate("Termin");
				}
				ret[i] = new Journal();
				ret[i].setId(jId);
				int tmp = this.getIdFromStringArray(this.institutionen, Verlag);
				if (tmp > 0) {
					ret[i].setVerlag(idao.get((long) tmp)); // Institution
				}
				tmp = this.getIdFromStringArray(this.institutionen, Provider);
				if (tmp > 0) {
					ret[i].setProvider(idao.get((long) tmp)); // Institution
				}
				tmp = this.getIdFromStringArray(stringKonsortien, Konsortium);
				if (tmp > 0) {
					ret[i].setKonsortium(kdao.get((long) tmp)); // Konsortium
				}
				tmp = this.getIdFromStringArray(stringPakets, Paket);
				if (tmp > 0) {
					ret[i].setPaket(pdao.get((long) tmp)); // Paket
				}
				tmp = this.getIdFromIntArray(this.bibmitarb, Bibliothek);
				if (tmp > 0) {
					ret[i].setBibliotheksmitarbeiter(bdao.get((long) tmp)); // Bibliotheksmitarbeiter
				}
				ret[i].setTitel(Titel);
				ret[i].setKurztitel(Kurztitel);
				ret[i].setIssn(ISSN);
				ret[i].setIssnPrint(ISSNPrint);
				ret[i].setKommentar(Kommentar);
				ret[i].setKommentarAdmin(KommentarAdmin);
				// ret[i].setKommentarIntranet(KommentarIntranet); TODO
				// Einkommentieren wenn Martin ihn auf 2000 Zeichen gestellt hat
				// !
				ret[i].setAnmeldedatum(Anmeldedatum);
				ret[i].setFreischaltdatum(Freischaltdatum);
				ret[i].setZugangsId(ZugangsID);
				ret[i].setZugangsPasswort(ZugangsPasswort);
				ret[i].setNutzungsbestimmungen(Nutzungsbestimmungen);
				ret[i].setRotschaltungsdatum(Rotschaltungsdatum);
				ret[i].setRotschaltungsbemerkungen(Rotschaltungsbemerkungen);
				ret[i].setStatus(Status);
				ret[i].setAenderungsdatum(Aenderungsdatum);
				ret[i].setZdbNummer(ZdbNummer);
				ret[i].setEzbId(EZBID);
				ret[i].setAnker(Anker);
				ret[i].setReadMeTitelbezogen(Readmetitelbezogen);
				ret[i].setHerausgeber(Herausgeber);
				ret[i].setZugangUeber(ZugangUeber);
				ret[i].setBearbeitungsdatum(termin);

				this.journalfaecher[i] = new HashSet();
				tmp = this.getIdFromIntArray(this.faecher, Fach1);
				if (tmp != 0) {
					this.journalfaecher[i].add(fdao.get((long) tmp));
				}
				tmp = this.getIdFromIntArray(this.faecher, Fach2);
				if (tmp != 0) {
					this.journalfaecher[i].add(fdao.get((long) tmp));
				}
				tmp = this.getIdFromIntArray(this.faecher, Fach3);
				if (tmp != 0) {
					this.journalfaecher[i].add(fdao.get((long) tmp));
				}
				if (!this.journalfaecher[i].isEmpty()) {
					ret[i].setFaecher(this.journalfaecher[i]);
				}
				// journalfaecher = null;
				try_again = false;
			} catch (final org.springframework.dao.DataAccessResourceFailureException e) {
				// e.printStackTrace();
				// System.err.println("i: " + i);
				try_again = true;
				i--;
			}
		}

		return ret;
	}

	/**
	 * Creates the sigel array.
	 * 
	 * @param rs
	 *            the rs
	 * @param laenge
	 *            the laenge
	 * @param factory
	 *            the factory
	 * @return the sigel[]
	 * @throws SQLException
	 *             the sQL exception
	 */
	public Sigel[] createSigelArray(final ResultSet rs, final int laenge,
			final BeanFactory factory) throws SQLException {
		final SigelDao sdao = (SigelDao) factory.getBean("sigelDao");
		final Sigel[] ret = new Sigel[laenge];
		this.sigel = new String[laenge];
		for (int i = 0; i < laenge; i++) {
			rs.next();
			ret[i] = new Sigel();
			this.sigel[i] = rs.getString("Sigel");
			ret[i].setName(this.sigel[i]);
			ret[i].setBibliothek(rs.getString("Bibliothek"));
			ret[i].setFakultaet(rs.getString("Fakultaet"));
			ret[i].setPersEmail("PerEmail");
			ret[i].setBibAnsprechpartner1("Bibansprechpartner1");
			ret[i].setBibAnsprechpartner2("Bibansprechpartner2");
		}
		return ret;
	}

	/*
	 * public Exemplar[] createExemplarArray(ResultSet rs, int laenge,
	 * BeanFactory factory) throws SQLException { exemplare = new int[laenge];
	 * ExemplarDao edao = (ExemplarDao) factory.getBean("exemplarDao"); SigelDao
	 * sdao = (SigelDao) factory.getBean("sigelDao"); JournalDao jdao =
	 * (JournalDao) factory.getBean("journalDao"); InstitutionDao idao =
	 * (InstitutionDao) factory.getBean("institutionDao"); Exemplar[] ret = new
	 * Exemplar[laenge]; //Sigel, Titelnummer AS Journal, Lieferant, Printan
	 * for(int i=0; i<laenge; i++){ rs.next(); String s = rs.getString("Sigel");
	 * Sigel set = sdao.get((long)getIdFromStringArray(sigel, s)); ret[i] = new
	 * Exemplar(); ret[i].setZustaendigeBib(set); s = rs.getString("Printan");
	 * set = null; if(getIdFromStringArray(sigel, s)!=0)set =
	 * sdao.get((long)getIdFromStringArray(sigel, s));
	 * if(set!=null)ret[i].setEigentuemer(set); // s =
	 * rs.getString("Besteller"); // set = null; //
	 * if(getIdFromStringArray(sigel, s)!=0)set =
	 * sdao.get((long)getIdFromStringArray(sigel, s)); //
	 * if(set!=null)ret[i].setBesteller(set); int tmp =
	 * this.getIdFromIntArray(journals, rs.getInt("Journal")); Journal j =
	 * jdao.get((long)tmp); ret[i].setJournal(j); s = rs.getString("Lieferant");
	 * int in = getIdFromStringArray(institutionen, s); if(in!=0){ Institution
	 * inst = idao.get((long)in); if(inst!=null)ret[i].setLieferant(inst); }
	 * exemplare[i] = rs.getInt("Exemplar");
	 * ret[i].setExemplarId((long)exemplare[i]);
	 * ret[i].setBeteiligung(rs.getString("Beteiligung"));
	 * ret[i].setForm(rs.getString("Form"));
	 * ret[i].setZugangsart(rs.getString("Zugangsart"));
	 * ret[i].setStatus(rs.getString("Status"));
	 * ret[i].setBestellnummer(rs.getString("Bestellnummer"));
	 * ret[i].setKundennummer(rs.getString("Kundennummer"));
	 * ret[i].setAbonummer(rs.getString("AboNummer"));
	 * ret[i].setPrivatabo(rs.getBoolean("Privatabo"));
	 * ret[i].setExKommentar(rs.getString("ExKommentar"));
	 * ret[i].setPrintexBayern(rs.getString("PrintexBayern"));
	 * ret[i].setAbbestZum(rs.getDate("AbbestZum"));
	 * ret[i].setAbbestellung(rs.getString("Abbestellung"));
	 * ret[i].setUmbestZum(rs.getDate("UmbestZum"));
	 * ret[i].setUmbestellung(rs.getString("Umbestellung"));
	 * System.err.println("Foo "+ret[i]); } return ret; }
	 */
	/*
	 * public Exemplar[] createExemplarArray(ResultSet rs, int laenge,
	 * BeanFactory factory, String[] bestellers, int[] bestellers_sigels) throws
	 * SQLException { ExemplarDao edao = (ExemplarDao)
	 * factory.getBean("exemplarDao"); SigelDao sdao = (SigelDao)
	 * factory.getBean("sigelDao"); JournalDao jdao = (JournalDao)
	 * factory.getBean("journalDao"); InstitutionDao idao = (InstitutionDao)
	 * factory.getBean("institutionDao"); Exemplar[] ret = new Exemplar[laenge];
	 * exemplare = new int[laenge]; System.err.println("Argh1"); for(int i=0;
	 * i<laenge; i++){ System.err.println("Argh 2"); rs.next(); ret[i] = new
	 * Exemplar(); //lesen der Altanwendung String besteller =
	 * rs.getString("Besteller"); exemplare[i] = rs.getInt("Exemplar");
	 * 
	 * 
	 * String lief = rs.getString("Lieferant"); String print =
	 * rs.getString("Printan");
	 * 
	 * Sigel printAn = null; if(getIdFromStringArray(sigel, print)!=0)printAn =
	 * sdao.get((long)getIdFromStringArray(sigel, print)); Sigel zustBib = null;
	 * String s = rs.getString("Sigel"); if(getIdFromStringArray(sigel,
	 * s)!=0)zustBib = sdao.get((long)getIdFromStringArray(sigel, s));
	 * Institution lieferant = null; String lief = rs.getString("Lieferant");
	 * if(getIdFromStringArray(institutionen, lief)!=0)lieferant =
	 * idao.get((long)getIdFromStringArray(institutionen, lief));
	 * 
	 * 
	 * //schreibe Referenzen (außer Besteller)
	 * if(zustBib!=null)ret[i].setZustaendigeBib(zustBib);
	 * if(lieferant!=null)ret[i].setLieferant(lieferant);
	 * if(printAn!=null)ret[i].setEigentuemer(printAn); int tmp =
	 * this.getIdFromIntArray(journals, j); Journal jo = jdao.get((long)tmp);
	 * ret[i].setJournal(jo);
	 * 
	 * 
	 * // ret[i].setExemplarId((long)exemplare[i]);
	 * 
	 * ret[i].setBeteiligung(rs.getString("Beteiligung"));
	 * ret[i].setForm(rs.getString("Form"));
	 * ret[i].setZugangsart(rs.getString("Zugangsart"));
	 * ret[i].setStatus(rs.getString("Status"));
	 * ret[i].setBestellnummer(rs.getString("Bestellnummer"));
	 * ret[i].setKundennummer(rs.getString("Kundennummer"));
	 * ret[i].setAbonummer(rs.getString("AboNummer"));
	 * ret[i].setPrivatabo(rs.getBoolean("Privatabo"));
	 * ret[i].setExKommentar(rs.getString("ExKommentar"));
	 * ret[i].setPrintexBayern(rs.getString("PrintexBayern"));
	 * ret[i].setAbbestZum(rs.getDate("AbbestZum"));
	 * ret[i].setAbbestellung(rs.getString("Abbestellung"));
	 * ret[i].setUmbestZum(rs.getDate("UmbestZum"));
	 * ret[i].setUmbestellung(rs.getString("Umbestellung"));
	 * System.out.println(ret[i].toString()); }
	 * 
	 * return ret; }
	 */
	/**
	 * Creates the konsortium array.
	 * 
	 * @param s
	 *            the s
	 * @return the konsortium[]
	 */
	public Konsortium[] createKonsortiumArray(final String[] s) {
		final Konsortium[] ret = new Konsortium[s.length];
		for (int i = 0; i < s.length; i++) {
			ret[i] = new Konsortium();
			ret[i].setKonsortiumId((long) (i + 1));
			ret[i].setKonsortiumName(s[i]);
		}
		return ret;
	}

	/**
	 * Creates the paket array.
	 * 
	 * @param s
	 *            the s
	 * @return the paket[]
	 */
	public Paket[] createPaketArray(final String[] s) {
		final Paket[] ret = new Paket[s.length];
		for (int i = 0; i < s.length; i++) {
			ret[i] = new Paket();
			ret[i].setPaketId((long) (i + 1));
			ret[i].setPaketName(s[i]);
		}
		return ret;
	}

	/**
	 * Creates the fach array.
	 * 
	 * @param rs
	 *            the rs
	 * @param laenge
	 *            the laenge
	 * @return the fach[]
	 * @throws SQLException
	 *             the sQL exception
	 */
	public Fach[] createFachArray(final ResultSet rs, final int laenge)
			throws SQLException {
		this.faecher = new int[laenge];
		final Fach[] ret = new Fach[laenge];
		for (int i = 0; i < laenge; i++) {
			rs.next();
			ret[i] = new Fach();
			this.faecher[i] = rs.getInt(1);
			ret[i].setFachId((long) this.faecher[i]);
			ret[i].setFachName(rs.getString(2));
		}
		return ret;
	}

	/**
	 * Print a table row to stdout.
	 * 
	 * @param rs
	 *            the rs
	 * @param only
	 *            only one attribute?
	 * @param show
	 *            the only or last attribute number to be displayed
	 * @throws SQLException
	 *             the sQL exception
	 */
	void printTableRow(final ResultSet rs, final boolean only, final int show)
			throws SQLException {
		// get result set meta data
		final ResultSetMetaData rsMetaData = rs.getMetaData();
		final int numberOfColumns = rsMetaData.getColumnCount();
		final String[] names = new String[numberOfColumns];
		// get the column names; column indexes start from 1
		for (int i = 0; i < numberOfColumns; i++) {
			names[i] = rsMetaData.getColumnName(i + 1);
		}
		final String tmp;
		for (int i = 0; i < numberOfColumns; i++) {
			if (((show >= (i + 1)) && !only) || (only && (show == (i + 1)))) {
				System.out.println(names[i] + " " + rs.getString(i + 1));
			}
		}
		System.out.println(" ");
		System.out
				.println("----------------------------------------------------------------------");
		System.out.println(" ");
	}

	/**
	 * Prints the array.
	 * 
	 * @param array
	 *            print this array to StdOut form: "LineNumber: content" where
	 *            line number is array index + 1
	 */
	void printArray(final String[] array) {
		for (int i = 0; i < array.length; i++) {
			final int print = i + 1;
			System.out.println(print + ": " + array[i]);
		}
	}

	/**
	 * Prints the object array.
	 * 
	 * @param o
	 *            the o
	 * @param ident
	 *            the ident
	 */
	public void printObjectArray(final Object[] o, final String ident) {
		final int id = this.convertToIntID(ident);
		switch (id) {
		case 1: // Bibliotheksmitarbeiter
			final Bibliotheksmitarbeiter[] bm = (Bibliotheksmitarbeiter[]) o;
			for (int i = 0; i < bm.length; i++) {
				System.out.println(i + " | " + bm[i].getBibId() + " "
						+ bm[i].getName() + " "
						+ bm[i].getAbteilungsHauptstelle() + " "
						+ bm[i].getFensterumschlagAdresse() + " "
						+ bm[i].getHausanschrift() + " "
						+ bm[i].getPostanschrift() + " " + bm[i].getTelefon()
						+ " " + bm[i].getTelefax() + " "
						+ bm[i].getEmailanschrift() + " " + bm[i].getUrl()
						+ " " + bm[i].getUmstId() + " "
						+ bm[i].getMitarbeiter() + " " + bm[i].getDienstort()
						+ '\n');
			}
			break;
		case 2: // Lizenzdetail
			final Lizenzdetail[] ldm = (Lizenzdetail[]) o;
			for (int i = 0; i < ldm.length; i++) {
				System.out.println(i + " | " + ldm[i].getLizenzId() + " "
						+ ldm[i].getVerlag() + " " + ldm[i].getBeginn() + " "
						+ ldm[i].getLaufzeit() + " "
						+ ldm[i].getVerlaengerung() + " " + ldm[i].getKosten()
						+ " " + ldm[i].getReadmeAktualisiert() + '\n');
			}
			break;
		case 3: // Institution
			final Institution[] inm = (Institution[]) o;
			for (int i = 0; i < inm.length; i++) {
				System.out
						.println(i + " | " + inm[i].getId() + " "
								+ inm[i].getName() + " "
								+ inm[i].getAbteilung() + " "
								+ inm[i].getStrasse() + " "
								+ inm[i].getPostfach() + " "
								+ inm[i].getPlz_ort() + " "
								+ inm[i].getBundesland() + inm[i].getLand()
								+ " " + inm[i].getAnsprechpartner() + " "
								+ inm[i].getEmail() + " " + inm[i].getFax()
								+ " " + inm[i].getTelefon() + " "
								+ inm[i].getBestellsprache() + " "
								+ inm[i].getBestellart() + " "
								+ inm[i].getStatus() + " "
								+ inm[i].getKennwort() + " "
								+ inm[i].getFernzugriff() + " "
								+ inm[i].getFernzugriffErlaeuterung() + " "
								+ inm[i].getZugang() + " "
								+ inm[i].getPersonengruppe() + " "
								+ inm[i].getZugangsdaten() + " "
								+ inm[i].getKommentar() + " "
								+ inm[i].getKommentarIntern() + " "
								+ inm[i].getInternetadresse() + " "
								+ inm[i].getNutzungsURL() + " "
								+ inm[i].getCopyrightURL() + " "
								+ inm[i].getAccountURL() + " "
								+ inm[i].getStatstikURL() + " "
								+ inm[i].getSfxURL() + " "
								+ inm[i].getUblogoURL()
								+ inm[i].getStatstikZugang() + " " + " "
								+ inm[i].getFernleihe() + " "
								+ inm[i].getLizenzArt() + " "
								+ inm[i].getLizenzAbbest() + " "
								+ inm[i].getLizenzPaket() + " "
								+ inm[i].getLizenzVorgang() + " "
								+ inm[i].getLizenzZust() + " "
								+ inm[i].getLizenzBes() + " "
								+ inm[i].getBibliotheksmitarbeiter() + " "
								+ '\n');
			}
			break;
		case 4: // Konsortium
			final Konsortium[] km = (Konsortium[]) o;
			for (int i = 0; i < km.length; i++) {
				System.out.println(i + " | " + km[i].getKonsortiumId() + " "
						+ km[i].getKonsortiumName() + '\n');
			}
			break;
		case 5: // Paket
			final Paket[] pm = (Paket[]) o;
			for (int i = 0; i < pm.length; i++) {
				System.out.println(i + " | " + pm[i].getPaketId() + " "
						+ pm[i].getPaketName() + '\n');
			}
			break;
		case 6: // Fach
			System.out.println("Oops, das wurde noch nicht implementiert");
			break;
		case 7: // Journal
			final Journal[] jm = (Journal[]) o;
			for (int i = 0; i < jm.length; i++) {
				System.out.println(i + " | " + jm[i].getId() + " "
						+ jm[i].getVerlag() + '\n');
				/*
				 * System.out.println(i + " | " + jm[i].getId() + " " +
				 * jm[i].getVerlag() + " " + jm[i].getProvider() + " " +
				 * jm[i].getKonsortium() + " " + jm[i].getPaket() + " " +
				 * jm[i].getBibliotheksmitarbeiter() + " " + jm[i].getTitel() +
				 * jm[i].getKurztitel() + " " + jm[i].getIssn() + " " +
				 * jm[i].getIssnPrint() + " " + jm[i].getKommentar() + " " +
				 * jm[i].getKommentarAdmin() + " " +
				 * jm[i].getKommentarIntranet() + " " + jm[i].getAnmeldedatum()
				 * + " " + jm[i].getFreischaltdatum() + " " +
				 * jm[i].getZugangsId() + " " + jm[i].getZugangsPasswort() + " "
				 * + jm[i].getNutzungsbestimmungen() + " " +
				 * jm[i].getRotschaltungsdatum() + " " +
				 * jm[i].getRotschaltungsbemerkungen() + " " + jm[i].getStatus()
				 * + " " + jm[i].getAenderungsdatum() + " " +
				 * jm[i].getZdbNummer() + " " + jm[i].getEzbId() + " " +
				 * jm[i].getAnker() + " " + jm[i].getReadMeTitelbezogen() + " "
				 * + jm[i].getHerausgeber() + " " // + jm[i].getZugangUeber() +
				 * " " //Macht Stefan noch + '\n');
				 */
			}
			break;
		case 8: // Journal_Fach
			System.out.println("Oops, das wurde noch nicht implementiert");
			break;
		case 9: // Sigel
			final Sigel[] sm = (Sigel[]) o;
			for (final Sigel element : sm) {
				// System.out.println(i + " | " + sm[i].getSigelId() + " " +
				// sm[i].getName() + sm[i].getb + '\n');
				System.out.println("Oops, das wurde noch nicht implementiert");
			}
			break;
		case 10: // Exemplar
			System.out.println("Oops, das wurde noch nicht implementiert");
			break;
		default:
			System.out.println("Fehler: Ungültiger ident-key: " + ident);

		}
	}

	/**
	 * Convert to int id.
	 * 
	 * @param ident
	 *            the ident
	 * @return the int
	 */
	int convertToIntID(final String ident) {
		if (ident.equals("Bibliotheksmitarbeiter"))
			return 1;
		if (ident.equals("Lizenzdetail"))
			return 2;
		if (ident.equals("Institution"))
			return 3;
		if (ident.equals("Konsortium"))
			return 4;
		if (ident.equals("Paket"))
			return 5;
		if (ident.equals("Fach"))
			return 6;
		if (ident.equals("Journal"))
			return 7;
		if (ident.equals("Journal_Fach"))
			return 8;
		if (ident.equals("Sigel"))
			return 9;
		if (ident.equals("Exemplar"))
			return 10;
		return -1;
	}

	/**
	 * searches for a match between reference and array else returns 0.
	 * 
	 * @param array
	 *            the array
	 * @param reference
	 *            the reference
	 * @return returns the ID (array index + 1 where array[i] matches reference
	 */
	int getIdFromStringArray(final String[] array, final String reference) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(reference))
				return (i + 1);
		}
		return 0;
	}

	/**
	 * returns the new ID for mitarbeiter with old id oldID, if not found
	 * returns 0.
	 * 
	 * @param array
	 *            the array
	 * @param oldID
	 *            the old id
	 * @return the id from int array
	 */
	int getIdFromIntArray(final int[] array, final int oldID) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == oldID)
				return i + 1;
		}
		return 0;
	}

	/**
	 * Sql to string array.
	 * 
	 * @param con
	 *            - a valid DriverManager connection is required
	 * @param statement
	 *            statement is an SQL statement that is executed using
	 *            connection con
	 * @param column
	 *            the column of the query resut to be stored in the retuning
	 *            array
	 * @return a string array containing the values resulting from the statement
	 *         execution, found in column column
	 * @throws SQLException
	 *             the sQL exception
	 */
	String[] sqlToStringArray(final Connection con, final String statement,
			final int column) throws SQLException {
		final String[] ret = new String[this.sqlGetLength(con, statement)];
		final Statement s = con.createStatement();
		s.execute(statement);
		final ResultSet rs = s.getResultSet();
		if (rs != null) {
			int cheat = 0;
			while (rs.next()) {
				ret[cheat++] = rs.getString(column);
			}
		}
		s.close();
		return ret;
	}

	/**
	 * Sql get length.
	 * 
	 * @param con
	 *            - a valid DriverManager connection is required
	 * @param statement
	 *            is an SQL statement that is executed using connection con
	 * @return the number of rows (int) in the result from the statement
	 *         execution
	 */
	int sqlGetLength(final Connection con, final String statement) {
		int ret = 0;
		try {
			final Statement s = con.createStatement();
			s.execute(statement);
			final ResultSet rs = s.getResultSet();
			if (rs != null) {
				while (rs.next()) {
					ret++;
				}
			}
			s.close(); // EndStatement
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * public JournalMigration(JournalDao journalDao){
	 * this.journalDao=journalDao; }
	 * 
	 * @param o
	 *            the o
	 * @param ident
	 *            the ident
	 * @param factory
	 *            the factory
	 * @param i
	 *            the i
	 */
	public void write(final Object o, final String ident,
			final BeanFactory factory, final int i) {
		final int id = this.convertToIntID(ident);
		final boolean debug = false;
		switch (id) {
		case 1: // Bibliotheksmitarbeiter
			Bibliotheksmitarbeiter bm = (Bibliotheksmitarbeiter) o;
			final BibliotheksmitarbeiterManager bmm = (BibliotheksmitarbeiterManager) factory
					.getBean("bibliotheksmitarbeiterManager");
			bm = bmm.save(bm);
			if (debug) {
				bm = bmm.get(bm.getBibId());
			}
			break;
		case 2: // Lizenzdetail
			Lizenzdetail ld = (Lizenzdetail) o;
			final LizenzdetailManager ldm = (LizenzdetailManager) factory
					.getBean("lizenzdetailManager");
			ld = ldm.save(ld);
			if (debug) {
				ld = ldm.get(ld.getLizenzId());
			}
			break;
		case 3: // Institution
			Institution in = (Institution) o;
			final InstitutionManager inm = (InstitutionManager) factory
					.getBean("institutionManager");
			in = inm.save(in);
			if (debug) {
				in = inm.get(in.getId());
			}
			break;
		case 4: // Konsortium
			Konsortium ko = (Konsortium) o;
			final KonsortiumManager kom = (KonsortiumManager) factory
					.getBean("konsortiumManager");
			ko = kom.save(ko);
			if (debug) {
				ko = kom.get(ko.getKonsortiumId());
			}
			break;
		case 5: // Paket
			Paket pa = (Paket) o;
			final PaketManager pam = (PaketManager) factory
					.getBean("paketManager");
			pa = pam.save(pa);
			if (debug) {
				pa = pam.get(pa.getPaketId());
			}
			break;
		case 6: // Fach
			Fach fa = (Fach) o;
			final FachManager fam = (FachManager) factory
					.getBean("fachManager");
			fa = fam.save(fa);
			fam.save((Fach) o);
			if (debug) {
				fa = fam.get(fa.getFachId());
			}
			break;
		case 7: // Journal
			Journal jo = (Journal) o;
			// System.err.println(jo.getId() + " " + jo.getTitel());
			final JournalManager jom = (JournalManager) factory
					.getBean("journalManager");
			// Set<Fach> fs = jo.getFaecher();
			// Object[] ofas = fs.toArray();
			jo = jom.save(jo);
			// for(int j=0; j<ofas.length; j++){
			// int result = getIdFromIntArray(faecher,
			// (int)(long)((Fach)ofas[j]).getFachId());
			// if(result!=0){
			// jom.connectJournalFach((long)(i+1), result);
			// System.err.println("connect Jounal" + i+1 +" mit Fach "+ result);
			// }
			// }
			if (debug) {
				jo = jom.get(jo.getId());
			}
			break;
		case 8: // Journal_Fach
			System.out.println("Oops, das wurde noch nicht implementiert");
			break;
		case 9: // Sigel
			Sigel si = (Sigel) o;
			final SigelManager sim = (SigelManager) factory
					.getBean("sigelManager");
			si = sim.save(si);
			if (debug) {
				si = sim.get(si.getSigelId());
			}
			break;
		case 10: // Exemplar
			Exemplar ex = (Exemplar) o;
			final ExemplarManager exm = (ExemplarManager) factory
					.getBean("exemplarManager");
			ex = exm.save(ex);
			if (debug) {
				ex = exm.get(ex.getExemplarId());
			}
			break;
		default:
			System.out.println("Fehler: Ungültiger ident-key: " + ident);

		}
	}
}
