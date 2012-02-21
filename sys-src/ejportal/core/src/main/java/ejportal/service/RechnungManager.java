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

import ejportal.model.Rechnung;
import ejportal.service.dto.RechnungBaseTO;

/**
 * Created by IntelliJ IDEA. User: Tselmeg Date: 09.08.2010 Time: 15:02:46 To
 * change this template use File | Settings | File Templates.
 */
public interface RechnungManager extends GenericManager<Rechnung, Long> {

	/**
	 * Gets the list for exemplar.
	 * 
	 * @param exemplarId
	 *            the exemplar id
	 * @return the list for exemplar
	 */
	public List<Rechnung> getListForExemplar(long exemplarId);

	/**
	 * Gets the list for journal.
	 * 
	 * @param journalId
	 *            the journal id
	 * @return the list for journal
	 */
	public List<Rechnung> getListForJournal(long journalId);

	/**
	 * Connect rechnung exemplar.
	 * 
	 * @param rechnungId
	 *            the rechnung id
	 * @param exemplarId
	 *            the exemplar id
	 */
	public void connectRechnungExemplar(long rechnungId, long exemplarId);

	/**
	 * Gets the rechnung base to.
	 * 
	 * @param rechnungId
	 *            the rechnung id
	 * @return the rechnung base to
	 */
	public RechnungBaseTO getRechnungBaseTO(Long rechnungId);

	/**
	 * Save base to.
	 * 
	 * @param rechnungBaseTO
	 *            the rechnung base to
	 * @return the rechnung
	 */
	public Rechnung saveBaseTO(RechnungBaseTO rechnungBaseTO);

	/**
	 * Creates the.
	 * 
	 * @param rechnungBaseTO
	 *            the rechnung base to
	 * @param exemplarId
	 *            the exemplar id
	 * @return the rechnung
	 */
	public Rechnung create(RechnungBaseTO rechnungBaseTO, Long exemplarId);
}
