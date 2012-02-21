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
package ejportal.webapp.action;

import java.text.DecimalFormat;
import java.util.List;

import com.opensymphony.xwork2.Action;

import ejportal.model.Interesse;
import ejportal.model.Journalkosten;
import ejportal.model.Nutzung;
import ejportal.model.Rechnung;
import ejportal.service.InteresseManager;
import ejportal.service.JournalkostenManager;
import ejportal.service.NutzungManager;
import ejportal.service.RechnungManager;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 10.08.2010 Time: 15:03:33 To
 * change this template use File | Settings | File Templates.
 */
public class ProjectCockpitAction extends JournalBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9084370805811752073L;

	// JournalId
	/** The nutzung id. */
	private Long nutzungId;

	// ListAll f�r alle Listen
	/**
	 * List all.
	 * 
	 * @return the string
	 */
	public String listAll() {
		this.journalkosten = this.getJournalkostenForJournal();
		this.interessen = this.getInteressenForJournal();
		this.rechnungen = this.getRechnungenForJournal();
		this.nutzungen = this.getNutzungenForJournal();

		return Action.SUCCESS;
	}

	// Journalkosten
	/** The journalkosten manager. */
	private JournalkostenManager journalkostenManager;

	/** The journalkosten. */
	private Journalkosten journalkosten;

	/** The df. */
	DecimalFormat df = new DecimalFormat("###,##0.00");

	/**
	 * Gets the journalkosten manager.
	 * 
	 * @return the journalkosten manager
	 */
	public JournalkostenManager getJournalkostenManager() {
		return this.journalkostenManager;
	}

	/**
	 * Sets the journalkosten manager.
	 * 
	 * @param journalkostenManager
	 *            the new journalkosten manager
	 */
	public void setJournalkostenManager(
			final JournalkostenManager journalkostenManager) {
		this.journalkostenManager = journalkostenManager;
	}

	/**
	 * Gets the journalkosten.
	 * 
	 * @return the journalkosten
	 */
	public Journalkosten getJournalkosten() {
		return this.journalkosten;
	}

	/**
	 * Sets the journalkosten.
	 * 
	 * @param journalkosten
	 *            the new journalkosten
	 */
	public void setJournalkosten(final Journalkosten journalkosten) {
		this.journalkosten = journalkosten;
	}

	/**
	 * Gets the journalkosten for journal.
	 * 
	 * @return the journalkosten for journal
	 */
	public Journalkosten getJournalkostenForJournal() {
		return this.journalkostenManager.findByJournalId(this.getJournalId());
	}

	/**
	 * Gets the endpreis po.
	 * 
	 * @return the endpreis po
	 */
	public String getEndpreisPO() {
		return this.journalkostenManager.getEndpreisPO(this.journalId);
	}

	/**
	 * Gets the endpreis o.
	 * 
	 * @return the endpreis o
	 */
	public String getEndpreisO() {
		return this.journalkostenManager.getEndpreisO(this.journalId);
	}

	/**
	 * Gets the endpreis p.
	 * 
	 * @return the endpreis p
	 */
	public String getEndpreisP() {
		return this.journalkostenManager.getEndpreisP(this.journalId);
	}

	/**
	 * Gets the endpreis ipo.
	 * 
	 * @return the endpreis ipo
	 */
	public String getEndpreisIPO() {
		return this.journalkostenManager.getEndpreisIPO(this.journalId);
	}

	/**
	 * Gets the endpreis ip.
	 * 
	 * @return the endpreis ip
	 */
	public String getEndpreisIP() {
		return this.journalkostenManager.getEndpreisIP(this.journalId);
	}

	/**
	 * Gets the endpreis io.
	 * 
	 * @return the endpreis io
	 */
	public String getEndpreisIO() {
		return this.journalkostenManager.getEndpreisIO(this.journalId);
	}

	// formalierte Journalkosten
	/**
	 * Gets the preis po.
	 * 
	 * @return the preis po
	 */
	public String getPreisPO() {
		final float value = this.journalkosten.getOPreisPO();
		if (value == 0)
			return "";
		return this.df.format(value) + " " + this.journalkosten.getWaehrungPO();
	}

	/**
	 * Gets the preis o.
	 * 
	 * @return the preis o
	 */
	public String getPreisO() {
		final float value = this.journalkosten.getOPreisO();
		if (value == 0)
			return "";
		return this.df.format(value) + " " + this.journalkosten.getWaehrungO();
	}

	/**
	 * Gets the preis p.
	 * 
	 * @return the preis p
	 */
	public String getPreisP() {
		final float value = this.journalkosten.getOPreisP();
		if (value == 0)
			return "";
		return this.df.format(value) + " " + this.journalkosten.getWaehrungP();
	}

	/**
	 * Gets the i preis po.
	 * 
	 * @return the i preis po
	 */
	public String getIPreisPO() {
		final float value = this.journalkosten.getIPreisPO();
		if (value == 0)
			return "";
		return this.df.format(value) + " "
				+ this.journalkosten.getIWaehrungPO();
	}

	/**
	 * Gets the i preis o.
	 * 
	 * @return the i preis o
	 */
	public String getIPreisO() {
		final float value = this.journalkosten.getIPreisO();
		if (value == 0)
			return "";
		return this.df.format(value) + " " + this.journalkosten.getIWaehrungO();
	}

	/**
	 * Gets the i preis p.
	 * 
	 * @return the i preis p
	 */
	public String getIPreisP() {
		final float value = this.journalkosten.getIPreisP();
		if (value == 0)
			return "";
		return this.df.format(value) + " " + this.journalkosten.getIWaehrungP();
	}

	// Interesse
	/** The interesse manager. */
	private InteresseManager interesseManager;

	/** The interessen. */
	private List interessen;

	/**
	 * Sets the interesse manager.
	 * 
	 * @param interesseManager
	 *            the new interesse manager
	 */
	public void setInteresseManager(final InteresseManager interesseManager) {
		this.interesseManager = interesseManager;
	}

	/**
	 * Gets the interessen.
	 * 
	 * @return the interessen
	 */
	public List getInteressen() {
		return this.interessen;
	}

	/**
	 * Gets the interessen for journal.
	 * 
	 * @return the interessen for journal
	 */
	public List<Interesse> getInteressenForJournal() {
		return this.interesseManager.getListForJournal(this.journalId);
	}

	// Rechnungen
	/** The rechnung manager. */
	private RechnungManager rechnungManager;

	/** The rechnungen. */
	private List rechnungen;

	/**
	 * Sets the rechnung manager.
	 * 
	 * @param rechnungManager
	 *            the new rechnung manager
	 */
	public void setRechnungManager(final RechnungManager rechnungManager) {
		this.rechnungManager = rechnungManager;
	}

	/**
	 * Gets the rechnungen.
	 * 
	 * @return the rechnungen
	 */
	public List getRechnungen() {
		return this.rechnungen;
	}

	/**
	 * Gets the rechnungen for journal.
	 * 
	 * @return the rechnungen for journal
	 */
	public List<Rechnung> getRechnungenForJournal() {
		return this.rechnungManager.getListForJournal(this.journalId);
	}

	// TODO: Nutzung
	/** The nutzung manager. */
	private NutzungManager nutzungManager;

	/** The nutzungen. */
	private List nutzungen;

	/**
	 * Gets the nutzung id.
	 * 
	 * @return the nutzung id
	 */
	public Long getNutzungId() {
		return this.nutzungId;
	}

	/**
	 * Sets the nutzung id.
	 * 
	 * @param nutzungId
	 *            the new nutzung id
	 */
	public void setNutzungId(final Long nutzungId) {
		this.nutzungId = nutzungId;
	}

	/**
	 * Sets the nutzung manager.
	 * 
	 * @param nutzungManager
	 *            the new nutzung manager
	 */
	public void setNutzungManager(final NutzungManager nutzungManager) {
		this.nutzungManager = nutzungManager;
	}

	/**
	 * Gets the nutzungen.
	 * 
	 * @return the nutzungen
	 */
	public List getNutzungen() {
		return this.nutzungen;
	}

	/**
	 * Gets the nutzungen for journal.
	 * 
	 * @return the nutzungen for journal
	 */
	public List<Nutzung> getNutzungenForJournal() {
		return this.nutzungManager.findByJournalId(this.journalId);
	}

	/**
	 * Delete nutzung.
	 * 
	 * @return the string
	 */
	public String deleteNutzung() {
		this.nutzungManager.remove(this.nutzungId);
		this.saveMessage("Nutzung wurde erfolgreich entfernt.");

		return Action.SUCCESS;
	}
}
