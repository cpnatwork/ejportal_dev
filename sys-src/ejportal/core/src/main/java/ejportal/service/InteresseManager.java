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

import java.util.List;

import org.appfuse.service.GenericManager;

import ejportal.model.Interesse;
import ejportal.service.dto.InteresseBaseTO;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 16:14:14 To
 * change this template use File | Settings | File Templates.
 */
public interface InteresseManager extends GenericManager<Interesse, Long> {

	/**
	 * Gets the list for journal.
	 * 
	 * @param journalId
	 *            the journal id
	 * @return the list for journal
	 */
	public List<Interesse> getListForJournal(Long journalId);

	/**
	 * Connect interesse journal.
	 * 
	 * @param interesseId
	 *            the interesse id
	 * @param journalId
	 *            the journal id
	 */
	public void connectInteresseJournal(Long interesseId, Long journalId);

	/**
	 * Connect interesse besteller.
	 * 
	 * @param interesseID
	 *            the interesse id
	 * @param bestellerId
	 *            the besteller id
	 */
	public void connectInteresseBesteller(Long interesseID, Long bestellerId);

	/**
	 * Gets the interesse base to.
	 * 
	 * @param interesseId
	 *            the interesse id
	 * @return the interesse base to
	 */
	public InteresseBaseTO getInteresseBaseTO(Long interesseId);

	/**
	 * Save base to.
	 * 
	 * @param interesseBaseTO
	 *            the interesse base to
	 * @return the interesse
	 */
	public Interesse saveBaseTO(InteresseBaseTO interesseBaseTO);

	/**
	 * Creates the.
	 * 
	 * @param interesseBaseTO
	 *            the interesse base to
	 * @param journalId
	 *            the journal id
	 * @return the interesse
	 */
	public Interesse create(InteresseBaseTO interesseBaseTO, Long journalId);
}
