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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.BeanFactory;

import ejportal.model.Bibliotheksmitarbeiter;
import ejportal.model.Fach;
import ejportal.model.Institution;
import ejportal.model.Journal;
import ejportal.model.Konsortium;
import ejportal.model.Lizenzdetail;
import ejportal.model.Paket;
import ejportal.model.Sigel;

/**
 * Created by IntelliJ IDEA. User: Florian Date: 15.07.2010 Time: 15:00:14 To
 * change this template use File | Settings | File Templates.
 */
public class JournalMigration {

	/** The factory. */
	private final BeanFactory factory;

	/** The help. */
	private final Helper help;

	/** The verbose. */
	private final boolean verbose = false;

	/**
	 * Instantiates a new journal migration.
	 * 
	 * @param factory
	 *            the factory
	 * @param helper
	 *            the helper
	 */
	JournalMigration(final BeanFactory factory, final Helper helper) {
		this.factory = factory;
		this.help = helper;
	}

	/**
	 * Run.
	 */
	public void run() {

		// PORJEKTVERWALTUNG MIGRATION
		final ProjektMigration pmigration = new ProjektMigration(this.factory,
				this.help);

		System.out.println("[INFO] Erasing Database");
		try {
			pmigration.cleanDB();
		} catch (final SQLException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

		try {
			System.out.println("[INFO] Establish Access-Database connection");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			final String filename = "d:/Access/EJFrontendTest.mdb";
			// String database =
			// "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
			String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
			database += filename.trim() + ";DriverID=22;READONLY=true}";
			final Connection con = DriverManager
					.getConnection(database, "", "");
			System.out.println("[INFO] Connection successful");
			/**
			 * initialize variables for reuse
			 */
			String statement;
			Statement s;
			ResultSet rs;
			int laenge;

			/**
			 * Anlegen von Arrays für Tabellenübergänge
			 */

			/**
			 * Tabelle Konsortium
			 */
			System.out.println("[INFO] Processing Konsortium");
			statement = "select Konsortium from Konsortien ORDER BY Konsortium ASC";
			final String[] stringKonsortien = this.help.sqlToStringArray(con,
					statement, 1);
			if (this.verbose || false) {
				this.help.printArray(stringKonsortien);
			}
			final Konsortium[] konsortien = this.help
					.createKonsortiumArray(stringKonsortien);
			if (this.verbose || false) {
				this.help.printObjectArray(konsortien, "Konsortium");
			}
			this.writeToDB(konsortien, "Konsortium");
			/**
			 * Tabelle Paket
			 */
			statement = "select Paketbez from Pakettabelle ORDER BY Paketbez ASC";
			System.out.println("[INFO] Processing Paket");
			final String[] stringPakets = this.help.sqlToStringArray(con,
					statement, 1);
			if (this.verbose || false) {
				this.help.printArray(stringPakets);
			}
			final Paket[] pakets = this.help.createPaketArray(stringPakets);
			if (this.verbose || false) {
				this.help.printObjectArray(pakets, "Paket");
			}
			this.writeToDB(pakets, "Paket");

			/**
			 * Umziehen der Tabellen
			 */
			/**
			 * Tabelle Bibliotheksmitarbeiter - keine Abhängigkeiten => Group 01
			 */
			s = con.createStatement();
			statement = "select ID, Bibliotheksname AS xName, AbteilungoderHauptstelle AS AbteilungHauptstelle, FensterumschlagAdresse, "
					+ "Hausanschrift, Postfachanschrift AS Postanschrift, Telefon, Telefax, Emailanschrift, HomepageImInternet AS URL, "
					+ "UmsatzsteuerNummer AS UmstID, Mitarbeiter, Dienstort  from Bibliothekstabelle ORDER BY ID ASC";
			laenge = this.help.sqlGetLength(con, statement);
			s.execute(statement);
			rs = s.getResultSet();
			Bibliotheksmitarbeiter[] mitarbeiter = new Bibliotheksmitarbeiter[0];
			if (rs != null) {
				System.out.println("[INFO] Processing Bibliotheksmitarbeiter");
				mitarbeiter = this.help.createMitarbeiterArray(rs, laenge);
				if (this.verbose || false) {
					this.help.printObjectArray(mitarbeiter,
							"Bibliotheksmitarbeiter");
				}
				this.writeToDB(mitarbeiter, "Bibliotheksmitarbeiter");
			}
			/**
			 * Tabelle Institution - abhängig von Bibliotheksmitarbeiter =>
			 * Group 01
			 */
			s = con.createStatement();
			statement = "select Verlag AS xName, Abteilung, Strasse, Postfach, PLZOrt, Bundesland, Land, "
					+ "Ansprechpartner, Email, Fax, Telefon, Bestellsprache, Bestellart, Status, Kennwoerter, "
					+ "Fernzugriff, FernzugangErl, Zugang, Personengruppe, Zugangsdaten, Kommentar, KommentarIntern, "
					+ "Internetadresse, NutzungURL, CopyrightURL, AccountURL, StatistikURL, SFXURL, UBlogoURL, "
					+ "StatistikZugang, Fernleihe, LizenzArt, LizenzAbbest, LizenzPaket, LizenzVorg, LizenzZust, "
					+ "LizenzBes, ID from Verlagstabelle";
			laenge = this.help.sqlGetLength(con, statement);
			s.execute(statement);
			rs = s.getResultSet();
			Institution[] institutions = new Institution[0];
			if (rs != null) {
				System.out.println("[INFO] Processing Institution");
				institutions = this.help.createInstitutionArray(rs, laenge,
						this.factory);
				if (this.verbose || false) {
					this.help.printObjectArray(institutions, "Institution");
				}
				this.writeToDB(institutions, "Institution");
			}
			/**
			 * Tabelle Lizenzdetail - Abhängig von Institution => Group 02
			 */
			s = con.createStatement();
			statement = "select LizenzID AS id, Verlag, Beginn, Laufzeit, Verlaengerung, Kosten, "
					+ "Readmeakt AS ReadmeAktualisiert from LizenzdetailTabelle";
			laenge = this.help.sqlGetLength(con, statement);
			s.execute(statement);
			rs = s.getResultSet();
			Lizenzdetail[] lizenzdetails = new Lizenzdetail[0];
			if (rs != null) {
				System.out.println("[INFO] Processing Lizenzdetails");
				lizenzdetails = this.help.createLizenzdetailArray(rs, laenge,
						institutions, this.factory);
				if (this.verbose || false) {
					this.help.printObjectArray(lizenzdetails, "Lizenzdetail");
				}
				this.writeToDB(lizenzdetails, "Lizenzdetail");
			}

			/**
			 * reading Fach
			 */
			s = con.createStatement();
			statement = "select Fach AS ID, FachText AS xName from Faechertabelle";
			laenge = this.help.sqlGetLength(con, statement);
			s.execute(statement);
			rs = s.getResultSet();
			Fach[] faecher = new Fach[0];
			if (rs != null) {
				System.out.println("[INFO] Processing Fach");
				faecher = this.help.createFachArray(rs, laenge);
				if (this.verbose || false) {
					this.help.printObjectArray(faecher, "Fach");
				}
				this.writeToDB(faecher, "Fach");
			}

			/**
			 * reading Journal
			 */
			s = con.createStatement();
			statement = "select Titelnummer AS ID, Verlag, Provider, Konsortium, Paketbez AS Paket, Bibliotheksnummer AS Bibliothek, Titel, Kurztitel, "
					+ "ISSN, ISSNPrint, KommentarProjekte AS Kommentar, Kommentar AS KommentarAdmin, KommentarFrei AS KommentarIntranet, Anmeldedatum, Freischaltdatum, "
					+ "ZugangsID, ZugangsPasswort, Nutzungsbestimmungen, Rotschaltungsdatum, Rotschaltungsbemerkungen, "
					+ "Status, Aenderungsdatum, ZDBNummer, EZBID, Anker, Readmetitelbezogen, Herausgeber, ZugangUeber, Fach1, Fach2, Fach3, Termin from ZSTiteltabelle";
			laenge = this.help.sqlGetLength(con, statement);
			s.execute(statement);
			rs = s.getResultSet();
			Journal[] journals = new Journal[0];
			if (rs != null) {
				System.out.println("[INFO] Processing Journals");
				/*
				 * while (rs.next()){ help.printTableRow(rs, false, 50); }
				 */
				journals = this.help.createJournalArray(rs, laenge,
						this.factory, stringPakets, stringKonsortien);
				if (this.verbose || false) {
					this.help.printObjectArray(journals, "Journal");
				}
				this.writeToDB(journals, "Journal");
			}

			/**
			 * reading Sigel
			 */
			s = con.createStatement();
			statement = "select Sigel, Bereichsname AS Bibliothek, Fakultaet, PersEmail, Bibansprechpartner1, "
					+ "Bibansprechpartner2 from Sigeltabelle";
			laenge = this.help.sqlGetLength(con, statement);
			s.execute(statement);
			rs = s.getResultSet();
			Sigel[] sigels = new Sigel[0];
			if (rs != null) {
				System.out.println("[INFO] Processing Sigel");
				sigels = this.help.createSigelArray(rs, laenge, this.factory);
				if (this.verbose || false) {
					this.help.printObjectArray(sigels, "Sigel");
				}
				this.writeToDB(sigels, "Sigel");
			}

			/**
			 * connect Journal_Fach
			 */
			System.out.println("[INFO] Connecting Journal_Fach");
			pmigration.connectJournalFach();

			/**
			 * reading Besteller
			 */
			System.out.println("[INFO] Processing Besteller");
			pmigration.createBesteller(con);

			/**
			 * reading Exemplar
			 */
			System.out.println("[INFO] Processing Exemplar");
			pmigration.createExemplar(con);

			/**
			 * reading Nutzung
			 */
			System.out.println("[INFO] Processing Nutzung");
			pmigration.createNutzung();

			/**
			 * reading Journalkosten
			 */
			System.out.println("[INFO] Processing Journalkosten");
			pmigration.createJournalkosten();

			/**
			 * reading Rechnung
			 */
			System.out.println("[INFO] Processing Rechnung");
			pmigration.createRechnung();

			/**
			 * reading Interessen
			 */
			System.out.println("[INFO] Processing Interessen");
			pmigration.createInteressen();

			System.out.println("[INFO] DONE");
			s.close(); // close the Statement to let the database know we're
						// done with it
			con.close(); // close the Connection to let the database know we're
							// done with it
		} catch (final Exception e) {
			System.out.println("FUCK --- Error: " + e);
			e.printStackTrace();

		}
	}

	/**
	 * general write to database method. Writes all objects in array o to the
	 * database, knowing they are from type ident
	 * 
	 * @param o
	 *            the o
	 * @param ident
	 *            the ident
	 */
	private void writeToDB(final Object[] o, final String ident) {

		for (int i = 0; i < o.length; i++) {
			try {
				this.help.write(o[i], ident, this.factory, i);
			} catch (final org.springframework.dao.DataAccessResourceFailureException e) {
				// e.printStackTrace();
				System.err.println("i: " + i);
				i--;
			} catch (final org.springframework.dao.DataIntegrityViolationException v) {
				v.printStackTrace();
			}
		}
	}

}
