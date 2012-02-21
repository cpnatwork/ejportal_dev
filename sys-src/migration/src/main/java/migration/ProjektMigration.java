package migration;

import ejportal.model.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.dao.DataAccessResourceFailureException;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Florian
 * Date: 15.07.2010
 * Time: 15:00:14
 * To change this template use File | Settings | File Templates.
 */
public class ProjektMigration {

    public String[] getBestellers() {
        return bestellers;
    }

    public int[] getBestellers_sigels() {
        return bestellers_sigels;
    }

    private String[] bestellers = new String[0];
    private int[]bestellers_sigels = new int[0];

    public int[] getExemplare() {
        return exemplare;
    }

    private int[] exemplare = new int[0];

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    private BeanFactory factory;
    private Helper help;

    private Connection leg_con = null;
    private Connection tgt_con = null;

    ProjektMigration(BeanFactory factory, Helper helper) {
        this.factory = factory;
        this.help = helper;
        initDriverLegacyDb();
        initConnectionLegacyDb();
        initConnectionTargetDb();
    }

    private void initDriverLegacyDb() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void initConnectionLegacyDb() {
        try {
            String filename = "d:/Access/EJFrontendTest.mdb";
//            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=";
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=";
            database += filename.trim() + ";DriverID=22;READONLY=true}";
            leg_con = DriverManager.getConnection(database, "", "");
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private void initConnectionTargetDb() {
        DataSource ds = (DataSource) factory.getBean("dataSource");
        try {
            tgt_con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    public void createBesteller(Connection con) {

        String load_sql;
        Statement load_stmt;
        ResultSet load_rs;

        String store_sql;
        PreparedStatement store_prepstmt;
        ResultSet store_rs;


        try {
//        insert into Besteller (anrede, bestellerName, einzahlungErwuenscht, einzahlungFestgelegt, funktion, projekt, sigel_sigelId) values (?, ?, ?, ?, ?, ?, ?)


            load_sql = "SELECT Besteller, AnredeKuv, Einzahlungerwuenscht, Einzahlungfestgelegt, Sigel, Projekt, Funktion FROM Bestellertabelle";
            load_stmt = leg_con.createStatement();


            store_sql = "INSERT INTO Besteller (anrede, bestellerName, einzahlungErwuenscht, einzahlungFestgelegt, funktion, projekt, sigel_sigelId) VALUES (?, ?, ?, ?, ?, ?, ?)";
            store_prepstmt = tgt_con.prepareStatement(store_sql); // evtl. brauchen wir was in Richtung: Statement.RETURN_GENERATED_KEYS
            int laenge = help.sqlGetLength(con, load_sql);
            bestellers = new String[laenge];
            bestellers_sigels = new int[laenge];
            //logger.info("Lese von Besteller");
            load_stmt.execute(load_sql);
            load_rs = load_stmt.getResultSet();

            //logger.info("Schreibe nach Besteller");
            for(int i=0; i<laenge; i++){
                load_rs.next();
                store_prepstmt.setString(1, load_rs.getString("AnredeKuv"));
                bestellers[i] = load_rs.getString("Besteller");
                store_prepstmt.setString(2, bestellers[i]);
                store_prepstmt.setFloat(3, load_rs.getFloat("Einzahlungerwuenscht"));
                store_prepstmt.setFloat(4, load_rs.getFloat("Einzahlungfestgelegt"));
                store_prepstmt.setString(5, load_rs.getString("Funktion"));
                store_prepstmt.setString(6, load_rs.getString("Projekt"));
                bestellers_sigels[i] = help.getIdFromStringArray(help.getSigel(), load_rs.getString("Sigel"));
                store_prepstmt.setInt(7, bestellers_sigels[i]);
               store_prepstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

//        insert into Interesse (besteller_bestellerId, interesse, journal_id) values (?, ?, ?)
//        insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag, zeitraum, zugriffe) values (?, ?, ?, ?, ?)
//        insert into Rechnung (betrag, bezugsform, bezugsjahr, exemplar_exemplarId, sigel_sigelId) values (?, ?, ?, ?, ?)

    }

        public void createInteressen() {

        String load_sql;
        Statement load_stmt;
        ResultSet load_rs;

        String store_sql;
        PreparedStatement store_prepstmt;
        ResultSet store_rs;


        try {

            load_sql = "SELECT Besteller, Titelnummer, Interesse FROM Interessentabelle";
            load_stmt = leg_con.createStatement();


            store_sql = "INSERT INTO Interesse (besteller_bestellerId, interesse, journal_id) values (?, ?, ?)";
            store_prepstmt = tgt_con.prepareStatement(store_sql); // evtl. brauchen wir was in Richtung: Statement.RETURN_GENERATED_KEYS

            //logger.info("Lese von Interessen");
            load_stmt.execute(load_sql);
            load_rs = load_stmt.getResultSet();

            //logger.info("Schreibe nach Interessen");
            while (load_rs.next()) {
                int titelnummer = load_rs.getInt("Titelnummer");
                int journalID = help.getIdFromIntArray(help.getJournals(), titelnummer);
                //System.out.println("Titelnummer: " + titelnummer + " JournalID " + journalID);
                if(titelnummer>0 && journalID>0){
                store_prepstmt.setLong(1, help.getIdFromStringArray(bestellers, load_rs.getString("Besteller")));
                store_prepstmt.setString(2, load_rs.getString("Interesse"));
                store_prepstmt.setLong(3, (long)journalID);//help.getIdFromIntArray(help.getJournals(), load_rs.getInt("Titelnummer")));
                store_prepstmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

//        insert into Interesse (besteller_bestellerId, interesse, journal_id) values (?, ?, ?)
//        insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag, zeitraum, zugriffe) values (?, ?, ?, ?, ?)
//        insert into Rechnung (betrag, bezugsform, bezugsjahr, exemplar_exemplarId, sigel_sigelId) values (?, ?, ?, ?, ?)

    }

    public void createRechnung() {

        String load_sql;
        Statement load_stmt;
        ResultSet load_rs;

        String store_sql;
        PreparedStatement store_prepstmt;
        ResultSet store_rs;


        try {


            load_sql = "SELECT Rechnungsbetrag, Bezugsform, Bezugsjahr, Sigel, Exemplar, ExImportID FROM ExRechnungstabelle";
            load_stmt = leg_con.createStatement();


            store_sql = "insert into Rechnung (betrag, bezugsform, bezugsjahr, exemplar_exemplarId) values (?, ?, ?, ?)";//, sigel_sigelId
            store_prepstmt = tgt_con.prepareStatement(store_sql); // evtl. brauchen wir was in Richtung: Statement.RETURN_GENERATED_KEYS

            //logger.info("Lese von ExRechnungstabelle");
            load_stmt.execute(load_sql);
            load_rs = load_stmt.getResultSet();

            //logger.info("Schreibe nach Rechnung");
            while (load_rs.next()) {
                store_prepstmt.setInt(1, load_rs.getInt("Rechnungsbetrag"));
                store_prepstmt.setString(2, load_rs.getString("Bezugsform"));
                store_prepstmt.setString(3, load_rs.getString("Bezugsjahr"));
                int tmp = help.getIdFromIntArray(getExemplare(), load_rs.getInt("Exemplar"));
                if(tmp>0){
                    store_prepstmt.setLong(4, (long)tmp);
                }else{
                    store_prepstmt.setNull(4, java.sql.Types.BIGINT);
                }
                tmp = help.getIdFromStringArray(help.getSigel(), load_rs.getString("Sigel"));
                //store_prepstmt.setLong(5, (long)tmp);
                store_prepstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

//        insert into Interesse (besteller_bestellerId, interesse, journal_id) values (?, ?, ?)
//        insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag, zeitraum, zugriffe) values (?, ?, ?, ?, ?)
//        insert into Rechnung (betrag, bezugsform, bezugsjahr, exemplar_exemplarId, sigel_sigelId) values (?, ?, ?, ?, ?)

    }

    public void createJournalkosten() {

        String load_sql;
        Statement load_stmt;
        ResultSet load_rs;

        String store_sql;
        PreparedStatement store_prepstmt;
        ResultSet store_rs;


        try {

            load_sql = "SELECT IMwStO, IMwStP, IMwStPO, IPreisO, IPreisP, IPreisPO, IWaehrungO, IWaehrungP, IWaehrungPO, OPreisO, OPreisP, OPreisPO, Impact, ImpactDatum, MwStO, MwStP, MwStPO, WaehrungO, WaehrungP, WaehrungPO, Titelnummer FROM ZSTiteltabelle";
            load_stmt = leg_con.createStatement();


            store_sql = "INSERT INTO Journalkosten (IMwStO, IMwStP, IMwStPO, IPreisO, IPreisP, IPreisPO, IWaehrungO, IWaehrungP, IWaehrungPO, OPreisO, OPreisP, OPreisPO, impact, impactDatum, mwStO, mwStP, mwStPO, waehrungO, waehrungP, waehrungPO, journal_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            store_prepstmt = tgt_con.prepareStatement(store_sql); // evtl. brauchen wir was in Richtung: Statement.RETURN_GENERATED_KEYS

            //logger.info("Lese von ZSTiteltabelle (Journalkosten)");
            load_stmt.execute(load_sql);
            load_rs = load_stmt.getResultSet();

            //logger.info("Schreibe nach Journalkosten");
            while (load_rs.next()) {
                int titelnummer = load_rs.getInt("Titelnummer");
                int journalID = help.getIdFromIntArray(help.getJournals(), titelnummer);
                //ystem.out.println("Titelnummer: " + titelnummer + " JournalID " + journalID);
                if(titelnummer>0 && journalID>0){
                store_prepstmt.setString(1, load_rs.getString("IMwStO"));
                store_prepstmt.setString(2, load_rs.getString("IMwStP"));
                store_prepstmt.setString(3, load_rs.getString("IMwStPO"));
                store_prepstmt.setFloat(4, load_rs.getFloat("IPreisO"));
                store_prepstmt.setFloat(5, load_rs.getFloat("IPreisP"));
                store_prepstmt.setFloat(6, load_rs.getFloat("IPreisPO"));
                store_prepstmt.setString(7, load_rs.getString("IWaehrungO"));
                store_prepstmt.setString(8, load_rs.getString("IWaehrungP"));
                store_prepstmt.setString(9, load_rs.getString("IWaehrungPO"));
                store_prepstmt.setFloat(10, load_rs.getFloat("OPreisO"));
                store_prepstmt.setFloat(11, load_rs.getFloat("OPreisP"));
                store_prepstmt.setFloat(12, load_rs.getFloat("OPreisPO"));
                store_prepstmt.setFloat(13, load_rs.getFloat("Impact"));
                store_prepstmt.setDate(14, load_rs.getDate("ImpactDatum"));
                store_prepstmt.setString(15, load_rs.getString("MwStO"));
                store_prepstmt.setString(16, load_rs.getString("MwStP"));
                store_prepstmt.setString(17, load_rs.getString("MwStPO"));
                store_prepstmt.setString(18, load_rs.getString("WaehrungO"));
                store_prepstmt.setString(19, load_rs.getString("WaehrungP"));
                store_prepstmt.setString(20, load_rs.getString("WaehrungPO"));
                store_prepstmt.setLong(21, (long)journalID);
                store_prepstmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
    
    public void createNutzung() {

        String load_sql;
        Statement load_stmt;
        ResultSet load_rs;

        String store_sql;
        PreparedStatement store_prepstmt;
        ResultSet store_rs;


        try {

            load_sql = "SELECT Zugriffe, Zeitraum, Nutzungsjahr, Rechnungsbetrag, Titelnummer FROM Nutzungstabelle";
            load_stmt = leg_con.createStatement();


            store_sql = "insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag, zeitraum, zugriffe) values (?, ?, ?, ?, ?)";
            store_prepstmt = tgt_con.prepareStatement(store_sql); // evtl. brauchen wir was in Richtung: Statement.RETURN_GENERATED_KEYS

            //logger.info("Lese von Nutzungstabelle");
            load_stmt.execute(load_sql);
            load_rs = load_stmt.getResultSet();

            //logger.info("Schreibe nach Nutzung");
            while (load_rs.next()) {
                int titelnummer = load_rs.getInt("Titelnummer");
                int journalID = help.getIdFromIntArray(help.getJournals(), titelnummer);
                //System.out.println("Titelnummer: " + titelnummer + " JournalID " + journalID);
                if(titelnummer>0 && journalID>0){
                store_prepstmt.setLong(1, (long)journalID);
                store_prepstmt.setLong(2, load_rs.getLong("Nutzungsjahr"));
                store_prepstmt.setFloat(3, load_rs.getFloat("Rechnungsbetrag"));
                store_prepstmt.setLong(4, load_rs.getLong("Zeitraum"));
                store_prepstmt.setLong(5, load_rs.getLong("Zugriffe"));
                store_prepstmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

//        insert into Interesse (besteller_bestellerId, interesse, journal_id) values (?, ?, ?)
//        insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag, zeitraum, zugriffe) values (?, ?, ?, ?, ?)
//        insert into Rechnung (betrag, bezugsform, bezugsjahr, exemplar_exemplarId, sigel_sigelId) values (?, ?, ?, ?, ?)

    }

public void createExemplar(Connection con) {

        String load_sql;
        Statement load_stmt;
        ResultSet load_rs;

        String store_sql;
        PreparedStatement store_prepstmt;
        ResultSet store_rs;


        try {

            load_sql = "select Besteller, Exemplar, Sigel, Titelnummer AS Journal, Lieferant, Printan, Beteiligung, Form, Zugangsart, " +
                    "Status, Bestellnummer, Kundennummer, AboNummer, Privatabo, ExKommentar, PrintexBayern, " +
                    "AbbestZum, Abbestellung, UmbestZum, Umbestellung from Exemplartabelle ";
            load_stmt = leg_con.createStatement();


            store_sql = "insert into exemplar (abbestZum, abbestellung, abonummer, bestellnummer, beteiligung, " +
                    "exKommentar, form, kundennummer, printexBayern, privatabo, status, umbestZum, umbestellung, zugangsart, " +
                    "besteller_sigelId, eigentuemer_sigelId, journal_id, lieferant_id, zustaendigeBib_sigelId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            store_prepstmt = tgt_con.prepareStatement(store_sql); // evtl. brauchen wir was in Richtung: Statement.RETURN_GENERATED_KEYS

            int laenge = help.sqlGetLength(con, load_sql);
            exemplare = new int[laenge];
            //logger.info("Lese von Besteller");
            load_stmt.execute(load_sql);
            load_rs = load_stmt.getResultSet();

            //logger.info("Schreibe nach Besteller");
            for(int i=0; i<laenge; i++){
              //  System.err.println("geht doch!");
                load_rs.next();
                exemplare[i]= load_rs.getInt("Exemplar");
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
                String besteller = load_rs.getString("Besteller");
                int bestellerID_neu = help.getIdFromStringArray(bestellers, besteller);
                int sigelID = 0;
                if(bestellerID_neu!=0)sigelID = bestellers_sigels[bestellerID_neu - 1];
                if(sigelID!=0){
                    store_prepstmt.setLong(15, (long)sigelID);
                }else{
                    store_prepstmt.setNull(15, java.sql.Types.BIGINT);
                }
                String print = load_rs.getString("Printan");
                //System.err.println("print: "+print+" getID: "+help.getIdFromStringArray(help.getSigel(), print));
                if(help.getIdFromStringArray(help.getSigel(), print)!=0){
                    store_prepstmt.setLong(16, (long)(help.getIdFromStringArray(help.getSigel(), print)));
                }else{
                    store_prepstmt.setNull(16, java.sql.Types.BIGINT);
                }
                int j = load_rs.getInt("Journal");
                //System.err.println("journal: "+j+" getID: "+help.getIdFromIntArray(help.getJournals(), j));
                if(help.getIdFromIntArray(help.getJournals(), j)!=0){
                    store_prepstmt.setLong(17, (long)help.getIdFromIntArray(help.getJournals(), j));
                }else{
                    store_prepstmt.setNull(17, java.sql.Types.BIGINT);
                }
                String lief = load_rs.getString("Lieferant");
                //System.err.println("lieferant: "+ lief + " ist "+help.getIdFromStringArray(help.getInstitutionen(), lief));
                if(help.getIdFromStringArray(help.getInstitutionen(), lief)!=0){
                    store_prepstmt.setLong(18, (long)help.getIdFromStringArray(help.getInstitutionen(), lief));
                }else{
                    store_prepstmt.setNull(18, java.sql.Types.BIGINT);
                }
                String s = load_rs.getString("Sigel");
                //System.err.println("zuständige Bib: "+ s + " ist "+help.getIdFromStringArray(help.getSigel(), s));
                if(help.getIdFromStringArray(help.getSigel(), s)!=0){
                    store_prepstmt.setLong(19, (long)help.getIdFromStringArray(help.getSigel(), s));
                }else{
                    store_prepstmt.setNull(19, java.sql.Types.BIGINT);
                }
               store_prepstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

//        insert into Interesse (besteller_bestellerId, interesse, journal_id) values (?, ?, ?)
//        insert into Nutzung (journal_id, nutzungsjahr, rechnungsbetrag, zeitraum, zugriffe) values (?, ?, ?, ?, ?)
//        insert into Rechnung (betrag, bezugsform, bezugsjahr, exemplar_exemplarId, sigel_sigelId) values (?, ?, ?, ?, ?)

    }



    public void cleanDB() throws SQLException {
        String store_sql;
        PreparedStatement store_prepstmt;
        ResultSet store_rs;
        store_sql = "Delete From interesse Where true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE interesse AUTO_INCREMENT=1;";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM besteller WHERE true;";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE besteller AUTO_INCREMENT=1;";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM journalkosten WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE journalkosten AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM nutzung WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE nutzung AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM rechnung WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE rechnung AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM journal_fach WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE journal_fach AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM exemplar WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE exemplar AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM journal WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE journal AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM konsortium WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE konsortium AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM paket WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE paket AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM sigel WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE sigel AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM lizenzdetail WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE lizenzdetail AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM institution WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE institution AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM fach WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE fach AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "DELETE FROM bibliotheksmitarbeiter WHERE true";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
        store_sql = "ALTER TABLE bibliotheksmitarbeiter AUTO_INCREMENT=1";
        store_prepstmt = tgt_con.prepareStatement(store_sql);
        store_prepstmt.execute();
    }

    public void connectJournalFach() {
        String load_sql;
        Statement load_stmt;
        ResultSet load_rs;

        String store_sql;
        PreparedStatement store_prepstmt;
        ResultSet store_rs;


        try {
            store_sql = "insert into Journal_Fach (fachId, journalId) values (?, ?)";
            store_prepstmt = tgt_con.prepareStatement(store_sql); // evtl. brauchen wir was in Richtung: Statement.RETURN_GENERATED_KEYS
            Set<Fach>[] fs = help.getJournalfaecher();
            for (int k = 0; k < fs.length; k++) {
                Object[] ofas = fs[k].toArray();
                for (int j = 0; j < ofas.length; j++) {
                    int result = help.getIdFromIntArray(help.getFaecher(), (int) (long) ((Fach) ofas[j]).getFachId());
                    if (result != 0) {
                        //System.err.println("connect Jounal" + (k + 1) + " mit Fach " + result);
                        store_prepstmt.setLong(1, (long) result);
                        store_prepstmt.setLong(2, (long) (k + 1));
                        store_prepstmt.executeUpdate();
                    }
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
