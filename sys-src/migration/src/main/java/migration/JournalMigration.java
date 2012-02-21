package migration;

import ejportal.model.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 15.07.2010
 * Time: 15:00:14
 * To change this template use File | Settings | File Templates.
 */
public class JournalMigration {

    private BeanFactory factory;
    private Helper help;
    private boolean verbose = false;

    JournalMigration(BeanFactory factory, Helper helper) {
        this.factory = factory;
        this.help = helper;
    }

    public void run() {

        // PORJEKTVERWALTUNG MIGRATION
        ProjektMigration pmigration = new ProjektMigration(factory, help);

        System.out.println("[INFO] Erasing Database");
        try {
            pmigration.cleanDB();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        try {
            System.out.println("[INFO] Establish Access-Database connection");
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String filename = "d:/Access/EJFrontendTest.mdb";
//            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
            database += filename.trim() + ";DriverID=22;READONLY=true}";
            Connection con = DriverManager.getConnection(database, "", "");
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
            String[] stringKonsortien = help.sqlToStringArray(con, statement, 1);
            if (verbose || false) help.printArray(stringKonsortien);
            Konsortium[] konsortien = help.createKonsortiumArray(stringKonsortien);
            if (verbose || false) help.printObjectArray(konsortien, "Konsortium");
            writeToDB(konsortien, "Konsortium");
            /**
             * Tabelle Paket
             */
            statement = "select Paketbez from Pakettabelle ORDER BY Paketbez ASC";
            System.out.println("[INFO] Processing Paket");
            String[] stringPakets = help.sqlToStringArray(con, statement, 1);
            if (verbose || false) help.printArray(stringPakets);
            Paket[] pakets = help.createPaketArray(stringPakets);
            if (verbose || false) help.printObjectArray(pakets, "Paket");
            writeToDB(pakets, "Paket");

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
            laenge = help.sqlGetLength(con, statement);
            s.execute(statement);
            rs = s.getResultSet();
            Bibliotheksmitarbeiter[] mitarbeiter = new Bibliotheksmitarbeiter[0];
            if (rs != null) {
                System.out.println("[INFO] Processing Bibliotheksmitarbeiter");
                mitarbeiter = help.createMitarbeiterArray(rs, laenge);
                if (verbose || false) help.printObjectArray(mitarbeiter, "Bibliotheksmitarbeiter");
                writeToDB(mitarbeiter, "Bibliotheksmitarbeiter");
            }
            /**
             * Tabelle Institution - abhängig von Bibliotheksmitarbeiter => Group 01
             */
            s = con.createStatement();
            statement = "select Verlag AS xName, Abteilung, Strasse, Postfach, PLZOrt, Bundesland, Land, " +
                    "Ansprechpartner, Email, Fax, Telefon, Bestellsprache, Bestellart, Status, Kennwoerter, " +
                    "Fernzugriff, FernzugangErl, Zugang, Personengruppe, Zugangsdaten, Kommentar, KommentarIntern, " +
                    "Internetadresse, NutzungURL, CopyrightURL, AccountURL, StatistikURL, SFXURL, UBlogoURL, " +
                    "StatistikZugang, Fernleihe, LizenzArt, LizenzAbbest, LizenzPaket, LizenzVorg, LizenzZust, " +
                    "LizenzBes, ID from Verlagstabelle";
            laenge = help.sqlGetLength(con, statement);
            s.execute(statement);
            rs = s.getResultSet();
            Institution[] institutions = new Institution[0];
            if (rs != null) {
                System.out.println("[INFO] Processing Institution");
                institutions = help.createInstitutionArray(rs, laenge, factory);
                if (verbose || false) help.printObjectArray(institutions, "Institution");
                writeToDB(institutions, "Institution");
            }
            /**
             * Tabelle Lizenzdetail -  Abhängig von Institution => Group 02
             */
            s = con.createStatement();
            statement = "select LizenzID AS id, Verlag, Beginn, Laufzeit, Verlaengerung, Kosten, " +
                    "Readmeakt AS ReadmeAktualisiert from LizenzdetailTabelle";
            laenge = help.sqlGetLength(con, statement);
            s.execute(statement);
            rs = s.getResultSet();
            Lizenzdetail[] lizenzdetails = new Lizenzdetail[0];
            if (rs != null) {
                System.out.println("[INFO] Processing Lizenzdetails");
                lizenzdetails = help.createLizenzdetailArray(rs, laenge, institutions, factory);
                if (verbose || false) help.printObjectArray(lizenzdetails, "Lizenzdetail");
                writeToDB(lizenzdetails, "Lizenzdetail");
            }

            /**
             * reading Fach      
             */
            s = con.createStatement();
            statement = "select Fach AS ID, FachText AS xName from Faechertabelle";
            laenge = help.sqlGetLength(con, statement);
            s.execute(statement);
            rs = s.getResultSet();
            Fach[] faecher = new Fach[0];
            if (rs != null) {
                System.out.println("[INFO] Processing Fach");
                faecher = help.createFachArray(rs, laenge);
                if (verbose || false) help.printObjectArray(faecher, "Fach");
                writeToDB(faecher, "Fach");
            }

            /**
             * reading Journal
             */
            s = con.createStatement();
            statement = "select Titelnummer AS ID, Verlag, Provider, Konsortium, Paketbez AS Paket, Bibliotheksnummer AS Bibliothek, Titel, Kurztitel, "
                    + "ISSN, ISSNPrint, KommentarProjekte AS Kommentar, Kommentar AS KommentarAdmin, KommentarFrei AS KommentarIntranet, Anmeldedatum, Freischaltdatum, "
                    + "ZugangsID, ZugangsPasswort, Nutzungsbestimmungen, Rotschaltungsdatum, Rotschaltungsbemerkungen, "
                    + "Status, Aenderungsdatum, ZDBNummer, EZBID, Anker, Readmetitelbezogen, Herausgeber, ZugangUeber, Fach1, Fach2, Fach3, Termin from ZSTiteltabelle";
            laenge = help.sqlGetLength(con, statement);
            s.execute(statement);
            rs = s.getResultSet();
            Journal[] journals = new Journal[0];
            if (rs != null) {
                System.out.println("[INFO] Processing Journals");
                /*while (rs.next()){
                    help.printTableRow(rs, false, 50);
                }*/
                journals = help.createJournalArray(rs, laenge, factory, stringPakets, stringKonsortien);
                if (verbose || false) help.printObjectArray(journals, "Journal");
                writeToDB(journals, "Journal");
            }

            /**
             * reading Sigel
             */
            s = con.createStatement();
            statement = "select Sigel, Bereichsname AS Bibliothek, Fakultaet, PersEmail, Bibansprechpartner1, " +
                    "Bibansprechpartner2 from Sigeltabelle";
            laenge = help.sqlGetLength(con, statement);
            s.execute(statement);
            rs = s.getResultSet();
            Sigel[] sigels = new Sigel[0];
            if (rs != null) {
                System.out.println("[INFO] Processing Sigel");
                sigels = help.createSigelArray(rs, laenge, factory);
                if(verbose || false)help.printObjectArray(sigels, "Sigel");
                writeToDB(sigels, "Sigel");
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
            s.close(); // close the Statement to let the database know we're done with it
            con.close(); // close the Connection to let the database know we're done with it
        }
        catch (Exception e) {
            System.out.println("FUCK --- Error: " + e);
            e.printStackTrace();

        }
    }

    /**
     * general write to database method. Writes all objects in array o to the database, knowing they are from type ident
     *
     * @param o
     * @param ident
     */
    private void writeToDB(Object[] o, String ident) {


        for (int i = 0; i < o.length; i++) {
            try {
                help.write(o[i], ident, factory, i);
            } catch (org.springframework.dao.DataAccessResourceFailureException e) {
                //e.printStackTrace();
                System.err.println("i: " + i);
                i--;
            }catch(org.springframework.dao.DataIntegrityViolationException v){
                v.printStackTrace();
            }
        }
    }



}
