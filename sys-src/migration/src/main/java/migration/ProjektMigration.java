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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;

import ejportal.model.Fach;

/**
 * Created by IntelliJ IDEA. User: Florian Date: 15.07.2010 Time: 15:00:14 To
 * change this template use File | Settings | File Templates.
 */
public class ProjektMigration {

	/**
	 * Gets the bestellers.
	 * 
	 * @return the bestellers
	 */
	public String[] getBestellers() {
		return this.bestellers;
	}

	/**
	 * Gets the bestellers_sigels.
	 * 
	 * @return the bestellers_sigels
	 */
	public int[] getBestellers_sigels() {
		return this.bestellers_sigels;
	}

	/** The bestellers. */
	private String[] bestellers = new String[0];

	/** The bestellers_sigels. */
	private int[] bestellers_sigels = new int[0];

	/**
	 * Gets the exemplare.
	 * 
	 * @return the exemplare
	 */
	public int[] getExemplare() {
		return this.exemplare;
	}

	/** The exemplare. */
	private int[] exemplare = new int[0];

	/** The logger. */
	private final Logger logger = Logger.getLogger(this.getClass()
			.getSimpleName());

	/** The factory. */
	private final BeanFactory factory;

	/** The help. */
	private final Helper help;

	/** The leg_con. */
	private Connection leg_con = null;

	/** The tgt_con. */
	private Connection tgt_con = null;

	/**
	 * Instantiates a new projekt migration.
	 * 
	 * @param factory
	 *            the factory
	 * @param helper
	 *            the helper
	 */
	ProjektMigration(final BeanFactory factory, final Helper helper) {
		this.factory = factory;
		this.help = helper;
		this.initDriverLegacyDb();
		this.initConnectionLegacyDb();
		this.initConnectionTargetDb();
	}

	/**
	 * Inits the driver legacy db.
	 */
	private void initDriverLegacyDb() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (final ClassNotFoundException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

	/**
	 * Inits the connection legacy db.
	 */
	private void initConnectionLegacyDb() {
		try {
			final String filename = "d:/Access/EJFrontendTest.mdb";
			// String database =
			// "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
			String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
			database += filename.trim() + ";DriverID=22;READONLY=true}";
			this.leg_con = DriverManager.getConnection(database, "", "");
		} catch (final SQLException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

	/**
	 * Inits the connection target db.
	 */
	private void initConnectionTargetDb() {
		final DataSource ds = (DataSource) this.factory.getBean("dataSource");
		try {
			this.tgt_con = ds.getConnection();
		} catch (final SQLException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

	/**
	 * Creates the besteller.
	 * 
	 * @param con
	 *            the con
	 */
	public void createBesteller(final Connection con) {

		String load_sql;
		Statement load_stmt;
		ResultSet load_rs;

		String store_sql;
		PreparedStatement store_prepstmt;
		final ResultSet store_rs;

		try {
			// insert into Besteller (anrede, bestellerName,
			// einzahlungErwuenscht, einzahlungFestgelegt, funktion, projekt,
			// sigel_sigelId) values (?, ?, ?, ?, ?, ?, ?)

			load_sql = "SELECT Besteller, AnredeKuv, Einzahlungerwuenscht, Einzahlungfestgelegt, Sigel, Projekt, Funktion FROM Bestellertabelle";
			load_stmt = this.leg_con.createStatement();

			store_sql = "INSERT INTO Besteller (anrede, bestellerName, einzahlungErwuenscht, einzahlungFestgelegt, funktion, projekt, sigel_sigelId) VALUES (?, ?, ?, ?, ?, ?, ?)";
			store_prepstmt = this.tgt_con.prepareStatement(store_sql); // evtl.
																		// brauchen
																		// wir
																		// was
																		// in
																		// Richtung:
																		// Statement.RETURN_GENERATED_KEYS
			final int laenge = this.help.sqlGetLength(con, load_sql);
			this.bestellers = new String[laenge];
			this.bestellers_sigels = new int[laenge];
			// logger.info("Lese von Besteller");
			load_stmt.execute(load_sql);
			load_rs = load_stmt.getResultSet();

			// logger.info("Schreibe nach Besteller");
			for (int i = 0; i < laenge; i++) {
				load_rs.next();
				store_prepstmt.setString(1, load_rs.getString("AnredeKuv"));
				this.bestellers[i] = load_rs.getString("Besteller");
				store_prepstmt.setString(2, this.bestellers[i]);
				store_prepstmt.setFloat(3,
						load_rs.getFloat("Einzahlungerwuenscht"));
				store_prepstmt.setFloat(4,
						load_rs.getFloat("Einzahlungfestgelegt"));
				store_prepstmt.setString(5, load_rs.getString("Funktion"));
				store_prepstmt.setString(6, load_rs.getString("Projekt"));
				this.bestellers_sigels[i] = this.help.getIdFromStringArray(
						this.help.getSigel(), load_rs.getString("Sigel"));
				store_prepstmt.setInt(7, this.bestellers_sigels[i]);
				store_prepstmt.executeUpdate();
			}

		} catch (final SQLException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

		// insert into Interesse (besteller_bestellerId, interesse, journal_id)
		// values (?, ?, ?)
		// insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag,
		// zeitraum, zugriffe) values (?, ?, ?, ?, ?)
		// insert into Rechnung (betrag, bezugsform, bezugsjahr,
		// exemplar_exemplarId, sigel_sigelId) values (?, ?, ?, ?, ?)

	}

	/**
	 * Creates the interessen.
	 */
	public void createInteressen() {

		String load_sql;
		Statement load_stmt;
		ResultSet load_rs;

		String store_sql;
		PreparedStatement store_prepstmt;
		final ResultSet store_rs;

		try {

			load_sql = "SELECT Besteller, Titelnummer, Interesse FROM Interessentabelle";
			load_stmt = this.leg_con.createStatement();

			store_sql = "INSERT INTO Interesse (besteller_bestellerId, interesse, journal_id) values (?, ?, ?)";
			store_prepstmt = this.tgt_con.prepareStatement(store_sql); // evtl.
																		// brauchen
																		// wir
																		// was
																		// in
																		// Richtung:
																		// Statement.RETURN_GENERATED_KEYS

			// logger.info("Lese von Interessen");
			load_stmt.execute(load_sql);
			load_rs = load_stmt.getResultSet();

			// logger.info("Schreibe nach Interessen");
			while (load_rs.next()) {
				final int titelnummer = load_rs.getInt("Titelnummer");
				final int journalID = this.help.getIdFromIntArray(
						this.help.getJournals(), titelnummer);
				// System.out.println("Titelnummer: " + titelnummer +
				// " JournalID " + journalID);
				if ((titelnummer > 0) && (journalID > 0)) {
					store_prepstmt.setLong(1, this.help.getIdFromStringArray(
							this.bestellers, load_rs.getString("Besteller")));
					store_prepstmt.setString(2, load_rs.getString("Interesse"));
					store_prepstmt.setLong(3, journalID);// help.getIdFromIntArray(help.getJournals(),
															// load_rs.getInt("Titelnummer")));
					store_prepstmt.executeUpdate();
				}
			}

		} catch (final SQLException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

		// insert into Interesse (besteller_bestellerId, interesse, journal_id)
		// values (?, ?, ?)
		// insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag,
		// zeitraum, zugriffe) values (?, ?, ?, ?, ?)
		// insert into Rechnung (betrag, bezugsform, bezugsjahr,
		// exemplar_exemplarId, sigel_sigelId) values (?, ?, ?, ?, ?)

	}

	/**
	 * Creates the rechnung.
	 */
	public void createRechnung() {

		String load_sql;
		Statement load_stmt;
		ResultSet load_rs;

		String store_sql;
		PreparedStatement store_prepstmt;
		final ResultSet store_rs;

		try {

			load_sql = "SELECT Rechnungsbetrag, Bezugsform, Bezugsjahr, Sigel, Exemplar, ExImportID FROM ExRechnungstabelle";
			load_stmt = this.leg_con.createStatement();

			store_sql = "insert into Rechnung (betrag, bezugsform, bezugsjahr, exemplar_exemplarId) values (?, ?, ?, ?)";// ,
																															// sigel_sigelId
			store_prepstmt = this.tgt_con.prepareStatement(store_sql); // evtl.
																		// brauchen
																		// wir
																		// was
																		// in
																		// Richtung:
																		// Statement.RETURN_GENERATED_KEYS

			// logger.info("Lese von ExRechnungstabelle");
			load_stmt.execute(load_sql);
			load_rs = load_stmt.getResultSet();

			// logger.info("Schreibe nach Rechnung");
			while (load_rs.next()) {
				store_prepstmt.setInt(1, load_rs.getInt("Rechnungsbetrag"));
				store_prepstmt.setString(2, load_rs.getString("Bezugsform"));
				store_prepstmt.setString(3, load_rs.getString("Bezugsjahr"));
				int tmp = this.help.getIdFromIntArray(this.getExemplare(),
						load_rs.getInt("Exemplar"));
				if (tmp > 0) {
					store_prepstmt.setLong(4, tmp);
				} else {
					store_prepstmt.setNull(4, java.sql.Types.BIGINT);
				}
				tmp = this.help.getIdFromStringArray(this.help.getSigel(),
						load_rs.getString("Sigel"));
				// store_prepstmt.setLong(5, (long)tmp);
				store_prepstmt.executeUpdate();
			}

		} catch (final SQLException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

		// insert into Interesse (besteller_bestellerId, interesse, journal_id)
		// values (?, ?, ?)
		// insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag,
		// zeitraum, zugriffe) values (?, ?, ?, ?, ?)
		// insert into Rechnung (betrag, bezugsform, bezugsjahr,
		// exemplar_exemplarId, sigel_sigelId) values (?, ?, ?, ?, ?)

	}

	/**
	 * Creates the journalkosten.
	 */
	public void createJournalkosten() {

		String load_sql;
		Statement load_stmt;
		ResultSet load_rs;

		String store_sql;
		PreparedStatement store_prepstmt;
		final ResultSet store_rs;

		try {

			load_sql = "SELECT IMwStO, IMwStP, IMwStPO, IPreisO, IPreisP, IPreisPO, IWaehrungO, IWaehrungP, IWaehrungPO, OPreisO, OPreisP, OPreisPO, Impact, ImpactDatum, MwStO, MwStP, MwStPO, WaehrungO, WaehrungP, WaehrungPO, Titelnummer FROM ZSTiteltabelle";
			load_stmt = this.leg_con.createStatement();

			store_sql = "INSERT INTO Journalkosten (IMwStO, IMwStP, IMwStPO, IPreisO, IPreisP, IPreisPO, IWaehrungO, IWaehrungP, IWaehrungPO, OPreisO, OPreisP, OPreisPO, impact, impactDatum, mwStO, mwStP, mwStPO, waehrungO, waehrungP, waehrungPO, journal_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			store_prepstmt = this.tgt_con.prepareStatement(store_sql); // evtl.
																		// brauchen
																		// wir
																		// was
																		// in
																		// Richtung:
																		// Statement.RETURN_GENERATED_KEYS

			// logger.info("Lese von ZSTiteltabelle (Journalkosten)");
			load_stmt.execute(load_sql);
			load_rs = load_stmt.getResultSet();

			// logger.info("Schreibe nach Journalkosten");
			while (load_rs.next()) {
				final int titelnummer = load_rs.getInt("Titelnummer");
				final int journalID = this.help.getIdFromIntArray(
						this.help.getJournals(), titelnummer);
				// ystem.out.println("Titelnummer: " + titelnummer +
				// " JournalID " + journalID);
				if ((titelnummer > 0) && (journalID > 0)) {
					store_prepstmt.setString(1, load_rs.getString("IMwStO"));
					store_prepstmt.setString(2, load_rs.getString("IMwStP"));
					store_prepstmt.setString(3, load_rs.getString("IMwStPO"));
					store_prepstmt.setFloat(4, load_rs.getFloat("IPreisO"));
					store_prepstmt.setFloat(5, load_rs.getFloat("IPreisP"));
					store_prepstmt.setFloat(6, load_rs.getFloat("IPreisPO"));
					store_prepstmt
							.setString(7, load_rs.getString("IWaehrungO"));
					store_prepstmt
							.setString(8, load_rs.getString("IWaehrungP"));
					store_prepstmt.setString(9,
							load_rs.getString("IWaehrungPO"));
					store_prepstmt.setFloat(10, load_rs.getFloat("OPreisO"));
					store_prepstmt.setFloat(11, load_rs.getFloat("OPreisP"));
					store_prepstmt.setFloat(12, load_rs.getFloat("OPreisPO"));
					store_prepstmt.setFloat(13, load_rs.getFloat("Impact"));
					store_prepstmt.setDate(14, load_rs.getDate("ImpactDatum"));
					store_prepstmt.setString(15, load_rs.getString("MwStO"));
					store_prepstmt.setString(16, load_rs.getString("MwStP"));
					store_prepstmt.setString(17, load_rs.getString("MwStPO"));
					store_prepstmt
							.setString(18, load_rs.getString("WaehrungO"));
					store_prepstmt
							.setString(19, load_rs.getString("WaehrungP"));
					store_prepstmt.setString(20,
							load_rs.getString("WaehrungPO"));
					store_prepstmt.setLong(21, journalID);
					store_prepstmt.executeUpdate();
				}
			}

		} catch (final SQLException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

	}

	/**
	 * Creates the nutzung.
	 */
	public void createNutzung() {

		String load_sql;
		Statement load_stmt;
		ResultSet load_rs;

		String store_sql;
		PreparedStatement store_prepstmt;
		final ResultSet store_rs;

		try {

			load_sql = "SELECT Zugriffe, Zeitraum, Nutzungsjahr, Rechnungsbetrag, Titelnummer FROM Nutzungstabelle";
			load_stmt = this.leg_con.createStatement();

			store_sql = "insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag, zeitraum, zugriffe) values (?, ?, ?, ?, ?)";
			store_prepstmt = this.tgt_con.prepareStatement(store_sql); // evtl.
																		// brauchen
																		// wir
																		// was
																		// in
																		// Richtung:
																		// Statement.RETURN_GENERATED_KEYS

			// logger.info("Lese von Nutzungstabelle");
			load_stmt.execute(load_sql);
			load_rs = load_stmt.getResultSet();

			// logger.info("Schreibe nach Nutzung");
			while (load_rs.next()) {
				final int titelnummer = load_rs.getInt("Titelnummer");
				final int journalID = this.help.getIdFromIntArray(
						this.help.getJournals(), titelnummer);
				// System.out.println("Titelnummer: " + titelnummer +
				// " JournalID " + journalID);
				if ((titelnummer > 0) && (journalID > 0)) {
					store_prepstmt.setLong(1, journalID);
					store_prepstmt.setLong(2, load_rs.getLong("Nutzungsjahr"));
					store_prepstmt.setFloat(3,
							load_rs.getFloat("Rechnungsbetrag"));
					store_prepstmt.setLong(4, load_rs.getLong("Zeitraum"));
					store_prepstmt.setLong(5, load_rs.getLong("Zugriffe"));
					store_prepstmt.executeUpdate();
				}
			}

		} catch (final SQLException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

		// insert into Interesse (besteller_bestellerId, interesse, journal_id)
		// values (?, ?, ?)
		// insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag,
		// zeitraum, zugriffe) values (?, ?, ?, ?, ?)
		// insert into Rechnung (betrag, bezugsform, bezugsjahr,
		// exemplar_exemplarId, sigel_sigelId) values (?, ?, ?, ?, ?)

	}

	/**
	 * Creates the exemplar.
	 * 
	 * @param con
	 *            the con
	 */
	public void createExemplar(final Connection con) {

		String load_sql;
		Statement load_stmt;
		ResultSet load_rs;

		String store_sql;
		PreparedStatement store_prepstmt;
		final ResultSet store_rs;

		try {

			load_sql = "select Besteller, Exemplar, Sigel, Titelnummer AS Journal, Lieferant, Printan, Beteiligung, Form, Zugangsart, "
					+ "Status, Bestellnummer, Kundennummer, AboNummer, Privatabo, ExKommentar, PrintexBayern, "
					+ "AbbestZum, Abbestellung, UmbestZum, Umbestellung from Exemplartabelle ";
			load_stmt = this.leg_con.createStatement();

			store_sql = "insert into exemplar (abbestZum, abbestellung, abonummer, bestellnummer, beteiligung, "
					+ "exKommentar, form, kundennummer, printexBayern, privatabo, status, umbestZum, umbestellung, zugangsart, "
					+ "besteller_sigelId, eigentuemer_sigelId, journal_id, lieferant_id, zustaendigeBib_sigelId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			store_prepstmt = this.tgt_con.prepareStatement(store_sql); // evtl.
																		// brauchen
																		// wir
																		// was
																		// in
																		// Richtung:
																		// Statement.RETURN_GENERATED_KEYS

			final int laenge = this.help.sqlGetLength(con, load_sql);
			this.exemplare = new int[laenge];
			// logger.info("Lese von Besteller");
			load_stmt.execute(load_sql);
			load_rs = load_stmt.getResultSet();

			// logger.info("Schreibe nach Besteller");
			for (int i = 0; i < laenge; i++) {
				// System.err.println("geht doch!");
				load_rs.next();
				this.exemplare[i] = load_rs.getInt("Exemplar");
				store_prepstmt.setDate(1, load_rs.getDate("AbbestZum"));
				store_prepstmt.setString(2, load_rs.getString("Abbestellung"));
				store_prepstmt.setString(3, load_rs.getString("AboNummer"));
				store_prepstmt.setString(4, load_rs.getString("Bestellnummer"));
				store_prepstmt.setString(5, load_rs.getString("Beteiligung"));
				store_prepstmt.setString(6, load_rs.getString("exKommentar"));
				store_prepstmt.setString(7, load_rs.getString("Form"));
				store_prepstmt.setString(8, load_rs.getString("Kundennummer"));
				store_prepstmt.setString(9, load_rs.getString("PrintexBayern"));
				store_prepstmt.setBoolean(10, load_rs.getBoolean("privatabo"));
				store_prepstmt.setString(11, load_rs.getString("Status"));
				store_prepstmt.setDate(12, load_rs.getDate("UmbestZum"));
				store_prepstmt.setString(13, load_rs.getString("Umbestellung"));
				store_prepstmt.setString(14, load_rs.getString("Zugangsart"));
				final String besteller = load_rs.getString("Besteller");
				final int bestellerID_neu = this.help.getIdFromStringArray(
						this.bestellers, besteller);
				int sigelID = 0;
				if (bestellerID_neu != 0) {
					sigelID = this.bestellers_sigels[bestellerID_neu - 1];
				}
				if (sigelID != 0) {
					store_prepstmt.setLong(15, sigelID);
				} else {
					store_prepstmt.setNull(15, java.sql.Types.BIGINT);
				}
				final String print = load_rs.getString("Printan");
				// System.err.println("print: "+print+" getID: "+help.getIdFromStringArray(help.getSigel(),
				// print));
				if (this.help.getIdFromStringArray(this.help.getSigel(), print) != 0) {
					store_prepstmt.setLong(
							16,
							(this.help.getIdFromStringArray(
									this.help.getSigel(), print)));
				} else {
					store_prepstmt.setNull(16, java.sql.Types.BIGINT);
				}
				final int j = load_rs.getInt("Journal");
				// System.err.println("journal: "+j+" getID: "+help.getIdFromIntArray(help.getJournals(),
				// j));
				if (this.help.getIdFromIntArray(this.help.getJournals(), j) != 0) {
					store_prepstmt.setLong(17, this.help.getIdFromIntArray(
							this.help.getJournals(), j));
				} else {
					store_prepstmt.setNull(17, java.sql.Types.BIGINT);
				}
				final String lief = load_rs.getString("Lieferant");
				// System.err.println("lieferant: "+ lief +
				// " ist "+help.getIdFromStringArray(help.getInstitutionen(),
				// lief));
				if (this.help.getIdFromStringArray(
						this.help.getInstitutionen(), lief) != 0) {
					store_prepstmt.setLong(
							18,
							this.help.getIdFromStringArray(
									this.help.getInstitutionen(), lief));
				} else {
					store_prepstmt.setNull(18, java.sql.Types.BIGINT);
				}
				final String s = load_rs.getString("Sigel");
				// System.err.println("zust�ndige Bib: "+ s +
				// " ist "+help.getIdFromStringArray(help.getSigel(), s));
				if (this.help.getIdFromStringArray(this.help.getSigel(), s) != 0) {
					store_prepstmt.setLong(19, this.help.getIdFromStringArray(
							this.help.getSigel(), s));
				} else {
					store_prepstmt.setNull(19, java.sql.Types.BIGINT);
				}
				store_prepstmt.executeUpdate();
			}

		} catch (final SQLException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

		// insert into Interesse (besteller_bestellerId, interesse, journal_id)
		// values (?, ?, ?)
		// insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag,
		// zeitraum, zugriffe) values (?, ?, ?, ?, ?)
		// insert into Rechnung (betrag, bezugsform, bezugsjahr,
		// exemplar_exemplarId, sigel_sigelId) values (?, ?, ?, ?, ?)

	}

	/**
	 * Clean db.
	 * 
	 * @throws SQLException
	 *             the sQL exception
	 */
	public void cleanDB() throws SQLException {
		String store_sql;
		PreparedStatement store_prepstmt;
		final ResultSet store_rs;
		store_sql = "Delete From interesse Where true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE interesse AUTO_INCREMENT=1;";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM besteller WHERE true;";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE besteller AUTO_INCREMENT=1;";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM journalkosten WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE journalkosten AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM nutzung WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE nutzung AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM rechnung WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE rechnung AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM journal_fach WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE journal_fach AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM exemplar WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE exemplar AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM journal WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE journal AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM konsortium WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE konsortium AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM paket WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE paket AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM sigel WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE sigel AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM lizenzdetail WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE lizenzdetail AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM institution WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE institution AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM fach WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE fach AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "DELETE FROM bibliotheksmitarbeiter WHERE true";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
		store_sql = "ALTER TABLE bibliotheksmitarbeiter AUTO_INCREMENT=1";
		store_prepstmt = this.tgt_con.prepareStatement(store_sql);
		store_prepstmt.execute();
	}

	/**
	 * Connect journal fach.
	 */
	public void connectJournalFach() {
		final String load_sql;
		final Statement load_stmt;
		final ResultSet load_rs;

		String store_sql;
		PreparedStatement store_prepstmt;
		final ResultSet store_rs;

		try {
			store_sql = "insert into Journal_Fach (fachId, journalId) values (?, ?)";
			store_prepstmt = this.tgt_con.prepareStatement(store_sql); // evtl.
																		// brauchen
																		// wir
																		// was
																		// in
																		// Richtung:
																		// Statement.RETURN_GENERATED_KEYS
			final Set<Fach>[] fs = this.help.getJournalfaecher();
			for (int k = 0; k < fs.length; k++) {
				final Object[] ofas = fs[k].toArray();
				for (final Object ofa : ofas) {
					final int result = this.help.getIdFromIntArray(
							this.help.getFaecher(),
							(int) (long) ((Fach) ofa).getFachId());
					if (result != 0) {
						// System.err.println("connect Jounal" + (k + 1) +
						// " mit Fach " + result);
						store_prepstmt.setLong(1, result);
						store_prepstmt.setLong(2, (k + 1));
						store_prepstmt.executeUpdate();
					}
				}
			}

		} catch (final SQLException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}

	}
}
