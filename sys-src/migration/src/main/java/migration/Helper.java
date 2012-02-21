package migration;

import ejportal.dao.*;
import ejportal.model.*;
import ejportal.service.*;
import org.appfuse.service.GenericManager;
import org.springframework.beans.factory.BeanFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Thomas
 * Date: 04.08.2010
 * Time: 10:19:07
 * To change this template use File | Settings | File Templates.
 */
public class Helper {

    private int[] bibmitarb = new int[0];
    private String[] institutionen = new String[0];
    private int[] faecher = new int[0];
    private String[] sigel = new String[0];
    private Set<Fach>[] journalfaecher = new HashSet[0];
    private int[] journals = new int[0];
  //  private int[] exemplare = new int[0];

    public int[] getBibmitarb() {
        return bibmitarb;
    }

    public String[] getInstitutionen() {
        return institutionen;
    }

    public int[] getFaecher() {
        return faecher;
    }

    public String[] getSigel() {
        return sigel;
    }

    public Set<Fach>[] getJournalfaecher() {
        return journalfaecher;
    }

    public int[] getJournals() {
        return journals;
    }



    /**
     * Creates an array of Bibliotheksmitarbeiter objects from the ResultSet rs
     *
     * @param rs
     * @param laenge
     * @return
     * @throws java.sql.SQLException
     */
    Bibliotheksmitarbeiter[] createMitarbeiterArray(ResultSet rs, int laenge) throws SQLException {
        bibmitarb = new int[laenge];
        Bibliotheksmitarbeiter[] ret = new Bibliotheksmitarbeiter[laenge];
        for (int i = 0; i < laenge; i++) {
            rs.next();
            ret[i] = new Bibliotheksmitarbeiter();
            bibmitarb[i] = rs.getInt(1);
            ret[i].setBibId((long) bibmitarb[i]);
            ret[i].setName(rs.getString("xName"));
            ret[i].setAbteilungsHauptstelle(rs.getString("AbteilungHauptstelle"));
            ret[i].setFensterumschlagAdresse(rs.getString("FensterumschlagAdresse"));
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

    public Lizenzdetail[] createLizenzdetailArray(ResultSet rs, int laenge, Institution[] institutions, BeanFactory factory) throws SQLException {
        InstitutionDao dao = (InstitutionDao) factory.getBean("institutionDao");
        Lizenzdetail[] ret = new Lizenzdetail[laenge];
        for (int i = 0; i < laenge; i++) {
            rs.next();
            ret[i] = new Lizenzdetail();
            ret[i].setLizenzId(rs.getLong(1));
            String tmp = rs.getString(2);
            search:
            for (int j = 0; j < institutions.length; j++) {
                if (institutions[j].getName().equals(tmp)) {
                    ret[i].setVerlag(dao.get((long) (j + 1))); // Institution
                    break search;
                }
            }
            //ret[i].setBeginn(rs.getDate("Beginn"));      //TODO Feld muss string akzeptieren
            //ret[i].setLaufzeit(rs.getInt("Laufzeit"));     //TODO Feld muss string akzeptieren
            //ret[i].setVerlaengerung(rs.getInt("Verlaengerung"));  //TODO Feld muss string akzeptieren
            ret[i].setKosten(rs.getInt("Kosten"));
            ret[i].setReadmeAktualisiert(rs.getString("ReadmeAktualisiert"));
        }
        return ret;
    }

    public Institution[] createInstitutionArray(ResultSet rs, int laenge, BeanFactory factory) throws SQLException {
        institutionen = new String[laenge];
        Institution[] ret = new Institution[laenge];
        BibliotheksmitarbeiterDao dao = (BibliotheksmitarbeiterDao) factory.getBean("bibliotheksmitarbeiterDao");
        for (int i = 0; i < laenge; i++) {
            rs.next();
            ret[i] = new Institution();
            ret[i].setId((Long) (long) (i + 1));
            institutionen[i] = rs.getString("xName");
            ret[i].setName(institutionen[i]);
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
            //     ret[i].setKommentarIntern(rs.getString("KommentarIntern"));   400
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
            //   ret[i].setLizenzPaket(rs.getString("LizenzPaket"));      300
            ret[i].setLizenzVorgang(rs.getString("LizenzVorg"));
            ret[i].setLizenzZust(rs.getString("LizenzZust"));
            //   ret[i].setLizenzBes(rs.getString("LizenzBes"));         350
            int tmp = rs.getInt(38);
            if (tmp > 0)
                ret[i].setBibliotheksmitarbeiter(dao.get((long) getIdFromIntArray(bibmitarb, tmp))); //Bibliotheksmitarbeiter
        }
        return ret;
    }

    public Journal[] createJournalArray(ResultSet rs, int laenge, BeanFactory factory, String[] stringPakets, String[] stringKonsortien) throws SQLException {
        Journal[] ret = new Journal[laenge];
        journals = new int[laenge];
        PaketDao pdao = (PaketDao) factory.getBean("paketDao");
        KonsortiumDao kdao = (KonsortiumDao) factory.getBean("konsortiumDao");
        BibliotheksmitarbeiterDao bdao = (BibliotheksmitarbeiterDao) factory.getBean("bibliotheksmitarbeiterDao");
        InstitutionDao idao = (InstitutionDao) factory.getBean("institutionDao");
        FachDao fdao = (FachDao) factory.getBean("fachDao");
        boolean try_again = false;
        //Hilfsvariablen:
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
        Date  Rotschaltungsdatum = null;
        String Rotschaltungsbemerkungen = "";
        String Status = "";
        Date Aenderungsdatum = null;
        String ZdbNummer = "";
        Long EZBID = (long)-1;
        String Anker = "";
        Boolean Readmetitelbezogen = false;
        String Herausgeber = "";
        String ZugangUeber = "";
        Date termin = null;
        int Fach1 = -1;
        int Fach2 = -1;
        int Fach3 = -1;
        journalfaecher = new HashSet[laenge];
        for (int i = 0; i < laenge; i++) {
            try {
                if(!try_again){
                    rs.next();
                    jId = rs.getLong(1);
                    journals[i] = (int)jId;
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
                    Rotschaltungsbemerkungen = rs.getString("Rotschaltungsbemerkungen");
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
                int tmp = getIdFromStringArray(institutionen, Verlag);
                if (tmp > 0) ret[i].setVerlag(idao.get((long) tmp)); //Institution
                tmp = getIdFromStringArray(institutionen, Provider);
                if (tmp > 0) ret[i].setProvider(idao.get((long) tmp)); //Institution
                tmp = getIdFromStringArray(stringKonsortien, Konsortium);
                if (tmp > 0) ret[i].setKonsortium(kdao.get((long) tmp)); //Konsortium
                tmp = getIdFromStringArray(stringPakets, Paket);
                if (tmp > 0) ret[i].setPaket(pdao.get((long) tmp)); //Paket
                tmp = getIdFromIntArray(bibmitarb, Bibliothek);
                if (tmp > 0) ret[i].setBibliotheksmitarbeiter(bdao.get((long) tmp)); //Bibliotheksmitarbeiter
                ret[i].setTitel(Titel);
                ret[i].setKurztitel(Kurztitel);
                ret[i].setIssn(ISSN);
                ret[i].setIssnPrint(ISSNPrint);
                ret[i].setKommentar(Kommentar);
                ret[i].setKommentarAdmin(KommentarAdmin);
                //ret[i].setKommentarIntranet(KommentarIntranet);     TODO Einkommentieren wenn Martin ihn auf 2000 Zeichen gestellt hat ! 
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


                journalfaecher[i] = new HashSet();
                    tmp = getIdFromIntArray(faecher, Fach1);
                    if (tmp != 0) journalfaecher[i].add(fdao.get((long) tmp));
                    tmp = getIdFromIntArray(faecher, Fach2);
                    if (tmp != 0) journalfaecher[i].add(fdao.get((long) tmp));
                    tmp = getIdFromIntArray(faecher, Fach3);
                    if (tmp != 0) journalfaecher[i].add(fdao.get((long) tmp));
                if (!journalfaecher[i].isEmpty()) ret[i].setFaecher(journalfaecher[i]);
                //journalfaecher = null;
                try_again = false;
            } catch (org.springframework.dao.DataAccessResourceFailureException e) {
                //e.printStackTrace();
                //System.err.println("i: " + i);
                try_again = true;
                i--;
            }
        }


        return ret;
    }

    public Sigel[] createSigelArray(ResultSet rs, int laenge, BeanFactory factory) throws SQLException {
        SigelDao sdao = (SigelDao) factory.getBean("sigelDao");
        Sigel[] ret = new Sigel[laenge];
        sigel = new String[laenge];
        for(int i=0; i<laenge; i++){
            rs.next();
            ret[i] = new Sigel();
            sigel[i] = rs.getString("Sigel");
            ret[i].setName(sigel[i]);
            ret[i].setBibliothek(rs.getString("Bibliothek"));
            ret[i].setFakultaet(rs.getString("Fakultaet"));
            ret[i].setPersEmail("PerEmail");
            ret[i].setBibAnsprechpartner1("Bibansprechpartner1");
            ret[i].setBibAnsprechpartner2("Bibansprechpartner2");
        }
        return ret;
    }

 /*   public Exemplar[] createExemplarArray(ResultSet rs, int laenge, BeanFactory factory) throws SQLException {
        exemplare = new int[laenge];
        ExemplarDao edao = (ExemplarDao) factory.getBean("exemplarDao");
        SigelDao sdao = (SigelDao) factory.getBean("sigelDao");
        JournalDao jdao = (JournalDao) factory.getBean("journalDao");
        InstitutionDao idao = (InstitutionDao) factory.getBean("institutionDao");
        Exemplar[] ret = new Exemplar[laenge];
        //Sigel, Titelnummer AS Journal, Lieferant, Printan
        for(int i=0; i<laenge; i++){
            rs.next();
            String s = rs.getString("Sigel");
            Sigel set = sdao.get((long)getIdFromStringArray(sigel, s));
            ret[i] = new Exemplar();
            ret[i].setZustaendigeBib(set);
            s = rs.getString("Printan");
            set = null;
            if(getIdFromStringArray(sigel, s)!=0)set = sdao.get((long)getIdFromStringArray(sigel, s));
            if(set!=null)ret[i].setEigentuemer(set);
//            s = rs.getString("Besteller");
//            set = null;
//            if(getIdFromStringArray(sigel, s)!=0)set = sdao.get((long)getIdFromStringArray(sigel, s));
//            if(set!=null)ret[i].setBesteller(set);
            int tmp = this.getIdFromIntArray(journals, rs.getInt("Journal"));
            Journal j = jdao.get((long)tmp);
            ret[i].setJournal(j);
            s = rs.getString("Lieferant");
            int in = getIdFromStringArray(institutionen, s);
            if(in!=0){
                Institution inst = idao.get((long)in);
                if(inst!=null)ret[i].setLieferant(inst);
            }
            exemplare[i] = rs.getInt("Exemplar");
            ret[i].setExemplarId((long)exemplare[i]);
            ret[i].setBeteiligung(rs.getString("Beteiligung"));
            ret[i].setForm(rs.getString("Form"));
            ret[i].setZugangsart(rs.getString("Zugangsart"));
            ret[i].setStatus(rs.getString("Status"));
            ret[i].setBestellnummer(rs.getString("Bestellnummer"));
            ret[i].setKundennummer(rs.getString("Kundennummer"));
            ret[i].setAbonummer(rs.getString("AboNummer"));
            ret[i].setPrivatabo(rs.getBoolean("Privatabo"));
            ret[i].setExKommentar(rs.getString("ExKommentar"));
            ret[i].setPrintexBayern(rs.getString("PrintexBayern"));
            ret[i].setAbbestZum(rs.getDate("AbbestZum"));
            ret[i].setAbbestellung(rs.getString("Abbestellung"));
            ret[i].setUmbestZum(rs.getDate("UmbestZum"));
            ret[i].setUmbestellung(rs.getString("Umbestellung"));
            System.err.println("Foo "+ret[i]);
        }
        return ret;
    }    */
/*
    public Exemplar[] createExemplarArray(ResultSet rs, int laenge, BeanFactory factory, String[] bestellers, int[] bestellers_sigels) throws SQLException {
        ExemplarDao edao = (ExemplarDao) factory.getBean("exemplarDao");
        SigelDao sdao = (SigelDao) factory.getBean("sigelDao");
        JournalDao jdao = (JournalDao) factory.getBean("journalDao");
        InstitutionDao idao = (InstitutionDao) factory.getBean("institutionDao");
        Exemplar[] ret = new Exemplar[laenge];
        exemplare = new int[laenge];
        System.err.println("Argh1");
        for(int i=0; i<laenge; i++){
            System.err.println("Argh 2");
            rs.next();
            ret[i] = new Exemplar();
            //lesen der Altanwendung
            String besteller = rs.getString("Besteller");
            exemplare[i] = rs.getInt("Exemplar");

            
            String lief = rs.getString("Lieferant");
            String print = rs.getString("Printan");

            Sigel printAn = null;
            if(getIdFromStringArray(sigel, print)!=0)printAn = sdao.get((long)getIdFromStringArray(sigel, print));
            Sigel zustBib = null;
            String s = rs.getString("Sigel");
            if(getIdFromStringArray(sigel, s)!=0)zustBib = sdao.get((long)getIdFromStringArray(sigel, s));
            Institution lieferant = null;
            String lief = rs.getString("Lieferant");
            if(getIdFromStringArray(institutionen, lief)!=0)lieferant = idao.get((long)getIdFromStringArray(institutionen, lief));


            //schreibe Referenzen (außer Besteller)
            if(zustBib!=null)ret[i].setZustaendigeBib(zustBib);
            if(lieferant!=null)ret[i].setLieferant(lieferant);
            if(printAn!=null)ret[i].setEigentuemer(printAn);
            int tmp = this.getIdFromIntArray(journals, j);
            Journal jo = jdao.get((long)tmp);
            ret[i].setJournal(jo);


 //           ret[i].setExemplarId((long)exemplare[i]);

            ret[i].setBeteiligung(rs.getString("Beteiligung"));
            ret[i].setForm(rs.getString("Form"));
            ret[i].setZugangsart(rs.getString("Zugangsart"));
            ret[i].setStatus(rs.getString("Status"));
            ret[i].setBestellnummer(rs.getString("Bestellnummer"));
            ret[i].setKundennummer(rs.getString("Kundennummer"));
            ret[i].setAbonummer(rs.getString("AboNummer"));
            ret[i].setPrivatabo(rs.getBoolean("Privatabo"));
            ret[i].setExKommentar(rs.getString("ExKommentar"));
            ret[i].setPrintexBayern(rs.getString("PrintexBayern"));
            ret[i].setAbbestZum(rs.getDate("AbbestZum"));
            ret[i].setAbbestellung(rs.getString("Abbestellung"));
            ret[i].setUmbestZum(rs.getDate("UmbestZum"));
            ret[i].setUmbestellung(rs.getString("Umbestellung"));
System.out.println(ret[i].toString());
        }

        return ret;
    }
 */
    public Konsortium[] createKonsortiumArray(String[] s) {
        Konsortium[] ret = new Konsortium[s.length];
        for (int i = 0; i < s.length; i++) {
            ret[i] = new Konsortium();
            ret[i].setKonsortiumId((Long) (long) (i + 1));
            ret[i].setKonsortiumName(s[i]);
        }
        return ret;
    }

    public Paket[] createPaketArray(String[] s) {
        Paket[] ret = new Paket[s.length];
        for (int i = 0; i < s.length; i++) {
            ret[i] = new Paket();
            ret[i].setPaketId((Long) (long) (i + 1));
            ret[i].setPaketName(s[i]);
        }
        return ret;
    }

    public Fach[] createFachArray(ResultSet rs, int laenge) throws SQLException {
        faecher = new int[laenge];
        Fach[] ret = new Fach[laenge];
        for (int i = 0; i < laenge; i++) {
            rs.next();
            ret[i] = new Fach();
            faecher[i] = rs.getInt(1);
            ret[i].setFachId((long) faecher[i]);
            ret[i].setFachName(rs.getString(2));
        }
        return ret;
    }

    /**
     * Print a table row to stdout
     *
     * @param rs
     * @param only only one attribute?
     * @param show the only or last attribute number to be displayed
     * @throws SQLException
     */
    void printTableRow(ResultSet rs, boolean only, int show) throws SQLException {
        // get result set meta data
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();
        String[] names = new String[numberOfColumns];
        // get the column names; column indexes start from 1
        for (int i = 0; i < numberOfColumns; i++) {
            names[i] = rsMetaData.getColumnName(i + 1);
        }
        String tmp;
        for (int i = 0; i < numberOfColumns; i++) {
            if ((show >= (i + 1) && !only) || (only && show == (i + 1)))
                System.out.println(names[i] + " " + rs.getString(i + 1));
        }
        System.out.println(" ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" ");
    }

    /**
     * @param array print this array to StdOut form: "LineNumber: content" where line number is array index + 1
     */
    void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            int print = i + 1;
            System.out.println(print + ": " + array[i]);
        }
    }

    public void printObjectArray(Object[] o, String ident) {
        int id = convertToIntID(ident);
        switch (id) {
            case 1:  //Bibliotheksmitarbeiter
                Bibliotheksmitarbeiter[] bm = (Bibliotheksmitarbeiter[]) o;
                for (int i = 0; i < bm.length; i++) {
                    System.out.println(i + " | " + bm[i].getBibId() + " " + bm[i].getName() + " "
                            + bm[i].getAbteilungsHauptstelle() + " " + bm[i].getFensterumschlagAdresse() + " "
                            + bm[i].getHausanschrift() + " " + bm[i].getPostanschrift() + " " + bm[i].getTelefon()
                            + " " + bm[i].getTelefax() + " " + bm[i].getEmailanschrift() + " " +
                            bm[i].getUrl() + " " + bm[i].getUmstId() + " " + bm[i].getMitarbeiter() + " "
                            + bm[i].getDienstort() + '\n');
                }
                break;
            case 2:  //Lizenzdetail
                Lizenzdetail[] ldm = (Lizenzdetail[]) o;
                for (int i = 0; i < ldm.length; i++) {
                    System.out.println(i + " | " + ldm[i].getLizenzId() + " " + ldm[i].getVerlag() + " "
                            + ldm[i].getBeginn() + " " + ldm[i].getLaufzeit() + " "
                            + ldm[i].getVerlaengerung() + " " + ldm[i].getKosten() + " " + ldm[i].getReadmeAktualisiert()
                            + '\n');
                }
                break;
            case 3:  //Institution
                Institution[] inm = (Institution[]) o;
                for (int i = 0; i < inm.length; i++) {
                    System.out.println(i + " | " + inm[i].getId() + " " + inm[i].getName() + " "
                            + inm[i].getAbteilung() + " " + inm[i].getStrasse() + " "
                            + inm[i].getPostfach() + " " + inm[i].getPlz_ort() + " " + inm[i].getBundesland()
                            + inm[i].getLand() + " " + inm[i].getAnsprechpartner() + " " + inm[i].getEmail() + " "
                            + inm[i].getFax() + " " + inm[i].getTelefon() + " " + inm[i].getBestellsprache() + " "
                            + inm[i].getBestellart() + " " + inm[i].getStatus() + " " + inm[i].getKennwort() + " "
                            + inm[i].getFernzugriff() + " " + inm[i].getFernzugriffErlaeuterung() + " "
                            + inm[i].getZugang() + " " + inm[i].getPersonengruppe() + " " + inm[i].getZugangsdaten() + " "
                            + inm[i].getKommentar() + " " + inm[i].getKommentarIntern() + " " + inm[i].getInternetadresse() + " "
                            + inm[i].getNutzungsURL() + " " + inm[i].getCopyrightURL() + " " + inm[i].getAccountURL() + " "
                            + inm[i].getStatstikURL() + " " + inm[i].getSfxURL() + " " + inm[i].getUblogoURL()
                            + inm[i].getStatstikZugang() + " " + " " + inm[i].getFernleihe() + " " + inm[i].getLizenzArt() + " "
                            + inm[i].getLizenzAbbest() + " " + inm[i].getLizenzPaket() + " " + inm[i].getLizenzVorgang() + " "
                            + inm[i].getLizenzZust() + " " + inm[i].getLizenzBes() + " " + inm[i].getBibliotheksmitarbeiter() + " "
                            + '\n');
                }
                break;
            case 4:  //Konsortium
                Konsortium[] km = (Konsortium[]) o;
                for (int i = 0; i < km.length; i++) {
                    System.out.println(i + " | " + km[i].getKonsortiumId() + " " + km[i].getKonsortiumName() + '\n');
                }
                break;
            case 5:  //Paket
                Paket[] pm = (Paket[]) o;
                for (int i = 0; i < pm.length; i++) {
                    System.out.println(i + " | " + pm[i].getPaketId() + " " + pm[i].getPaketName() + '\n');
                }
                break;
            case 6:  //Fach
                System.out.println("Oops, das wurde noch nicht implementiert");
                break;
            case 7:  //Journal
                Journal[] jm = (Journal[]) o;
                for (int i = 0; i < jm.length; i++) {
                    System.out.println(i + " | " + jm[i].getId() + " " + jm[i].getVerlag()
                            + '\n');
                    /*     System.out.println(i + " | " + jm[i].getId() + " "  + jm[i].getVerlag() + " "
                   + jm[i].getProvider() + " "  + jm[i].getKonsortium() + " " + jm[i].getPaket() + " "
                   + jm[i].getBibliotheksmitarbeiter() + " "  + jm[i].getTitel() + jm[i].getKurztitel() + " "
                   + jm[i].getIssn() + " " + jm[i].getIssnPrint() + " " + jm[i].getKommentar() + " " + jm[i].getKommentarAdmin() + " "
                   + jm[i].getKommentarIntranet() + " " + jm[i].getAnmeldedatum() + " " + jm[i].getFreischaltdatum() + " "
                   + jm[i].getZugangsId() + " " + jm[i].getZugangsPasswort() + " " + jm[i].getNutzungsbestimmungen() + " "
                   + jm[i].getRotschaltungsdatum() + " " + jm[i].getRotschaltungsbemerkungen() + " " + jm[i].getStatus() + " "
                   + jm[i].getAenderungsdatum() + " " + jm[i].getZdbNummer() + " " + jm[i].getEzbId() + " "
                   + jm[i].getAnker() + " " + jm[i].getReadMeTitelbezogen() + " " + jm[i].getHerausgeber() + " "
         //          + jm[i].getZugangUeber() + " "  //Macht Stefan noch
                   + '\n');*/
                }
                break;
            case 8:  //Journal_Fach
                System.out.println("Oops, das wurde noch nicht implementiert");
                break;
            case 9:  //Sigel
                Sigel[] sm = (Sigel[]) o;
                for (int i = 0; i < sm.length; i++) {
                    //System.out.println(i + " | " + sm[i].getSigelId() + " "  + sm[i].getName() + sm[i].getb + '\n');
                    System.out.println("Oops, das wurde noch nicht implementiert");
                }
                break;
            case 10: //Exemplar
                System.out.println("Oops, das wurde noch nicht implementiert");
                break;
            default:
                System.out.println("Fehler: Ungültiger ident-key: " + ident);

        }
    }

    int convertToIntID(String ident) {
        if (ident.equals("Bibliotheksmitarbeiter")) return 1;
        if (ident.equals("Lizenzdetail")) return 2;
        if (ident.equals("Institution")) return 3;
        if (ident.equals("Konsortium")) return 4;
        if (ident.equals("Paket")) return 5;
        if (ident.equals("Fach")) return 6;
        if (ident.equals("Journal")) return 7;
        if (ident.equals("Journal_Fach")) return 8;
        if (ident.equals("Sigel")) return 9;
        if (ident.equals("Exemplar")) return 10;
        return -1;
    }

    /**
     * searches for a match between reference and array else returns 0
     *
     * @param array
     * @param reference
     * @return returns the ID (array index + 1 where array[i] matches reference
     */
    int getIdFromStringArray(String[] array, String reference) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(reference)) return (i + 1);
        }
        return 0;
    }

    /**
     * returns the new ID for mitarbeiter with old id oldID, if not found returns 0
     *
     * @param oldID
     * @return
     */
    int getIdFromIntArray(int[] array, int oldID) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == oldID) return i + 1;
        }
        return 0;
    }

    /**
     * @param con       - a valid DriverManager connection is required
     * @param statement statement is an SQL statement that is executed using connection con
     * @param column    the column of the query resut to be stored in the retuning array
     * @return a string array containing the values resulting from the statement execution, found in column column
     */
    String[] sqlToStringArray(Connection con, String statement, int column) throws SQLException {
        String[] ret = new String[sqlGetLength(con, statement)];
        Statement s = con.createStatement();
        s.execute(statement);
        ResultSet rs = s.getResultSet();
        if (rs != null) {
            int cheat = 0;
            while (rs.next()) ret[cheat++] = rs.getString(column);
        }
        s.close();
        return ret;
    }

    /**
     * @param con       - a valid DriverManager connection is required
     * @param statement is an SQL statement that is executed using connection con
     * @return the number of rows (int) in the result from the statement execution
     */
    int sqlGetLength(Connection con, String statement) {
        int ret = 0;
        try {
            Statement s = con.createStatement();
            s.execute(statement);
            ResultSet rs = s.getResultSet();
            if (rs != null) {
                while (rs.next()) ret++;
            }
            s.close(); // EndStatement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * public JournalMigration(JournalDao journalDao){
     * this.journalDao=journalDao;
     * }
     */
    public void write(Object o, String ident, BeanFactory factory, int i) {
        int id = convertToIntID(ident);
        boolean debug = false;
        switch (id) {
            case 1:  //Bibliotheksmitarbeiter
                Bibliotheksmitarbeiter bm = (Bibliotheksmitarbeiter) o;
                BibliotheksmitarbeiterManager bmm = (BibliotheksmitarbeiterManager) factory.getBean("bibliotheksmitarbeiterManager");
                bm = bmm.save(bm);
                if (debug) bm = bmm.get(bm.getBibId());
                break;
            case 2:  //Lizenzdetail
                Lizenzdetail ld = (Lizenzdetail) o;
                LizenzdetailManager ldm = (LizenzdetailManager) factory.getBean("lizenzdetailManager");
                ld = ldm.save(ld);
                if (debug) ld = ldm.get(ld.getLizenzId());
                break;
            case 3:  //Institution
                Institution in = (Institution) o;
                InstitutionManager inm = (InstitutionManager) factory.getBean("institutionManager");
                in = inm.save(in);
                if (debug) in = inm.get(in.getId());
                break;
            case 4:  //Konsortium
                Konsortium ko = (Konsortium) o;
                KonsortiumManager kom = (KonsortiumManager) factory.getBean("konsortiumManager");
                ko = kom.save(ko);
                if (debug) ko = kom.get(ko.getKonsortiumId());
                break;
            case 5:  //Paket
                Paket pa = (Paket) o;
                PaketManager pam = (PaketManager) factory.getBean("paketManager");
                pa = pam.save(pa);
                if (debug) pa = pam.get(pa.getPaketId());
                break;
            case 6:  //Fach
                Fach fa = (Fach) o;
                FachManager fam = (FachManager) factory.getBean("fachManager");
                fa = fam.save(fa);
                fam.save((Fach) o);
                if (debug) fa = fam.get(fa.getFachId());
                break;
            case 7:  //Journal
                Journal jo = (Journal) o;
                //System.err.println(jo.getId() + " " + jo.getTitel());
                JournalManager jom = (JournalManager) factory.getBean("journalManager");
//                Set<Fach> fs = jo.getFaecher();
//                Object[] ofas = fs.toArray();
                jo = jom.save(jo);
//                for(int j=0; j<ofas.length; j++){
//                    int result = getIdFromIntArray(faecher, (int)(long)((Fach)ofas[j]).getFachId());
//                    if(result!=0){
//                        jom.connectJournalFach((long)(i+1), result);
//                        System.err.println("connect Jounal" + i+1 +" mit Fach "+ result);
//                    }
//                }
                if (debug) jo = jom.get(jo.getId());
                break;
            case 8:  //Journal_Fach
                System.out.println("Oops, das wurde noch nicht implementiert");
                break;
            case 9:  //Sigel
                Sigel si = (Sigel) o;
                SigelManager sim = (SigelManager) factory.getBean("sigelManager");
                si = sim.save(si);
                if (debug) si = sim.get(si.getSigelId());
                break;
            case 10: //Exemplar
                Exemplar ex = (Exemplar) o;
                ExemplarManager exm = (ExemplarManager) factory.getBean("exemplarManager");
                ex = exm.save(ex);
                if (debug) ex = exm.get(ex.getExemplarId());
                break;
            default:
                System.out.println("Fehler: Ungültiger ident-key: " + ident);

        }
    }
}
