package ejportal.service.dto;

/**
 * Created by IntelliJ IDEA.
 * User: Nina
 * Date: 05.08.2010
 * Time: 13:30:08
 * To change this template use File | Settings | File Templates.
 */
public class BibliotheksmitarbeiterSearchTO {
    private Long journalId;
    private String name;
    private String abteilungsHauptstelle;
    private String emailanschrift;

    public Long getJournalId() {
        return journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbteilungsHauptstelle() {
        return abteilungsHauptstelle;
    }

    public void setAbteilungsHauptstelle(String abteilungsHauptstelle) {
        this.abteilungsHauptstelle = abteilungsHauptstelle;
    }

    public String getEmailanschrift() {
        return emailanschrift;
    }

    public void setEmailanschrift(String emailanschrift) {
        this.emailanschrift = emailanschrift;
    }
}
