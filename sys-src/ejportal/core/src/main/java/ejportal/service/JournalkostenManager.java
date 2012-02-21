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
package ejportal.service;

import org.appfuse.service.GenericManager;

import ejportal.model.Journalkosten;

/**
 * Created by IntelliJ IDEA. User: ag35ogub Date: 09.08.2010 Time: 15:28:15 To
 * change this template use File | Settings | File Templates.
 */
public interface JournalkostenManager extends
		GenericManager<Journalkosten, Long> {

	/**
	 * Find by journal id.
	 * 
	 * @param journalId
	 *            the journal id
	 * @return the journalkosten
	 */
	public Journalkosten findByJournalId(long journalId);

	/**
	 * Gets the endpreis po.
	 * 
	 * @param journalId
	 *            the journal id
	 * @return the endpreis po
	 */
	public String getEndpreisPO(long journalId);

	/**
	 * Gets the endpreis p.
	 * 
	 * @param journalId
	 *            the journal id
	 * @return the endpreis p
	 */
	public String getEndpreisP(long journalId);

	/**
	 * Gets the endpreis o.
	 * 
	 * @param journalId
	 *            the journal id
	 * @return the endpreis o
	 */
	public String getEndpreisO(long journalId);

	/**
	 * Gets the endpreis ipo.
	 * 
	 * @param journalId
	 *            the journal id
	 * @return the endpreis ipo
	 */
	public String getEndpreisIPO(long journalId);

	/**
	 * Gets the endpreis ip.
	 * 
	 * @param journalId
	 *            the journal id
	 * @return the endpreis ip
	 */
	public String getEndpreisIP(long journalId);

	/**
	 * Gets the endpreis io.
	 * 
	 * @param journalId
	 *            the journal id
	 * @return the endpreis io
	 */
	public String getEndpreisIO(long journalId);

	/**
	 * Save with journal.
	 * 
	 * @param journalkosten
	 *            the journalkosten
	 * @param journalId
	 *            the journal id
	 * @return the journalkosten
	 */
	public Journalkosten saveWithJournal(Journalkosten journalkosten,
			Long journalId);

}
