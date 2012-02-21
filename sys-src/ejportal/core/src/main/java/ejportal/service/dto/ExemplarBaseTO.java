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

import java.util.Date;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 04.08.2010 Time: 15:00:05 To
 * change this template use File | Settings | File Templates.
 */
public class ExemplarBaseTO {

	/** The exemplar id. */
	private Long exemplarId;

	/** The beteiligung. */
	private String beteiligung; /* Werte: Autor, Herausgeber, Mitglied */

	/** The form. */
	private String form; /*
						 * Werte: Online, Print, Print + Online, Online
						 * Kons-Anteil
						 */

	/** The zugangsart. */
	private String zugangsart; /*
								 * Werte: Geschenk / Spende, Kauf, kein Abo.,
								 * Konsortium, Mitgliedschaft
								 */

	/** The status. */
	private String status; /*
							 * Werte: bearbeiten, beendet, kein Abo., laufend,
							 * zentral bestellt,
							 */

	/** The bestellnummer. */
	private String bestellnummer;

	/** The kundennummer. */
	private String kundennummer;

	/** The abonummer. */
	private String abonummer;

	/** The privatabo. */
	private boolean privatabo;

	/** The ex kommentar. */
	private String exKommentar;

	/** The printex bayern. */
	private String printexBayern;

	/** The abbest zum. */
	private Date abbestZum;

	/** The abbestellung. */
	private String abbestellung;

	/** The umbest zum. */
	private Date umbestZum;

	/** The umbestellung. */
	private String umbestellung;

	/**
	 * Gets the exemplar id.
	 * 
	 * @return the exemplar id
	 */
	public Long getExemplarId() {
		return this.exemplarId;
	}

	/**
	 * Sets the exemplar id.
	 * 
	 * @param exemplarId
	 *            the new exemplar id
	 */
	public void setExemplarId(final Long exemplarId) {
		this.exemplarId = exemplarId;
	}

	/**
	 * Gets the beteiligung.
	 * 
	 * @return the beteiligung
	 */
	public String getBeteiligung() {
		return this.beteiligung;
	}

	/**
	 * Sets the beteiligung.
	 * 
	 * @param beteiligung
	 *            the new beteiligung
	 */
	public void setBeteiligung(final String beteiligung) {
		this.beteiligung = beteiligung;
	}

	/**
	 * Gets the form.
	 * 
	 * @return the form
	 */
	public String getForm() {
		return this.form;
	}

	/**
	 * Sets the form.
	 * 
	 * @param form
	 *            the new form
	 */
	public void setForm(final String form) {
		this.form = form;
	}

	/**
	 * Gets the zugangsart.
	 * 
	 * @return the zugangsart
	 */
	public String getZugangsart() {
		return this.zugangsart;
	}

	/**
	 * Sets the zugangsart.
	 * 
	 * @param zugangsart
	 *            the new zugangsart
	 */
	public void setZugangsart(final String zugangsart) {
		this.zugangsart = zugangsart;
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
	 * Gets the bestellnummer.
	 * 
	 * @return the bestellnummer
	 */
	public String getBestellnummer() {
		return this.bestellnummer;
	}

	/**
	 * Sets the bestellnummer.
	 * 
	 * @param bestellnummer
	 *            the new bestellnummer
	 */
	public void setBestellnummer(final String bestellnummer) {
		this.bestellnummer = bestellnummer;
	}

	/**
	 * Gets the kundennummer.
	 * 
	 * @return the kundennummer
	 */
	public String getKundennummer() {
		return this.kundennummer;
	}

	/**
	 * Sets the kundennummer.
	 * 
	 * @param kundennummer
	 *            the new kundennummer
	 */
	public void setKundennummer(final String kundennummer) {
		this.kundennummer = kundennummer;
	}

	/**
	 * Gets the abonummer.
	 * 
	 * @return the abonummer
	 */
	public String getAbonummer() {
		return this.abonummer;
	}

	/**
	 * Sets the abonummer.
	 * 
	 * @param abonummer
	 *            the new abonummer
	 */
	public void setAbonummer(final String abonummer) {
		this.abonummer = abonummer;
	}

	/**
	 * Gets the privatabo.
	 * 
	 * @return the privatabo
	 */
	public boolean getPrivatabo() {
		return this.privatabo;
	}

	/**
	 * Sets the privatabo.
	 * 
	 * @param privatabo
	 *            the new privatabo
	 */
	public void setPrivatabo(final boolean privatabo) {
		this.privatabo = privatabo;
	}

	/**
	 * Gets the ex kommentar.
	 * 
	 * @return the ex kommentar
	 */
	public String getExKommentar() {
		return this.exKommentar;
	}

	/**
	 * Sets the ex kommentar.
	 * 
	 * @param exKommentar
	 *            the new ex kommentar
	 */
	public void setExKommentar(final String exKommentar) {
		this.exKommentar = exKommentar;
	}

	/**
	 * Gets the printex bayern.
	 * 
	 * @return the printex bayern
	 */
	public String getPrintexBayern() {
		return this.printexBayern;
	}

	/**
	 * Sets the printex bayern.
	 * 
	 * @param printexBayern
	 *            the new printex bayern
	 */
	public void setPrintexBayern(final String printexBayern) {
		this.printexBayern = printexBayern;
	}

	/**
	 * Gets the abbest zum.
	 * 
	 * @return the abbest zum
	 */
	public Date getAbbestZum() {
		return this.abbestZum;
	}

	/**
	 * Sets the abbest zum.
	 * 
	 * @param abbestZum
	 *            the new abbest zum
	 */
	public void setAbbestZum(final Date abbestZum) {
		this.abbestZum = abbestZum;
	}

	/**
	 * Gets the abbestellung.
	 * 
	 * @return the abbestellung
	 */
	public String getAbbestellung() {
		return this.abbestellung;
	}

	/**
	 * Sets the abbestellung.
	 * 
	 * @param abbestellung
	 *            the new abbestellung
	 */
	public void setAbbestellung(final String abbestellung) {
		this.abbestellung = abbestellung;
	}

	/**
	 * Gets the umbest zum.
	 * 
	 * @return the umbest zum
	 */
	public Date getUmbestZum() {
		return this.umbestZum;
	}

	/**
	 * Sets the umbest zum.
	 * 
	 * @param umbestZum
	 *            the new umbest zum
	 */
	public void setUmbestZum(final Date umbestZum) {
		this.umbestZum = umbestZum;
	}

	/**
	 * Gets the umbestellung.
	 * 
	 * @return the umbestellung
	 */
	public String getUmbestellung() {
		return this.umbestellung;
	}

	/**
	 * Sets the umbestellung.
	 * 
	 * @param umbestellung
	 *            the new umbestellung
	 */
	public void setUmbestellung(final String umbestellung) {
		this.umbestellung = umbestellung;
	}
}
