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

import ejportal.model.Exemplar;
import ejportal.service.dto.ExemplarBaseTO;

/**
 * Created by IntelliJ IDEA. User: Christoph Date: 14.07.2010 Time: 16:14:10 To
 * change this template use File | Settings | File Templates.
 */
public interface ExemplarManager extends GenericManager<Exemplar, Long> {

	/**
	 * Connect exemplar lieferant.
	 * 
	 * @param exemplarId
	 *            the exemplar id
	 * @param lieferantId
	 *            the lieferant id
	 */
	public void connectExemplarLieferant(long exemplarId, long lieferantId);

	/**
	 * Connect exemplar eigentuemer.
	 * 
	 * @param exemplarId
	 *            the exemplar id
	 * @param eigentuemerId
	 *            the eigentuemer id
	 */
	public void connectExemplarEigentuemer(long exemplarId, long eigentuemerId);

	/**
	 * Connect exemplar besteller.
	 * 
	 * @param exemplarId
	 *            the exemplar id
	 * @param bestellerId
	 *            the besteller id
	 */
	public void connectExemplarBesteller(long exemplarId, long bestellerId);

	/**
	 * Connect exemplar zustaendige bib.
	 * 
	 * @param exemplarId
	 *            the exemplar id
	 * @param zustaendigeBibId
	 *            the zustaendige bib id
	 */
	public void connectExemplarZustaendigeBib(long exemplarId,
			long zustaendigeBibId);

	/**
	 * Gets the exemplar base to.
	 * 
	 * @param id
	 *            the id
	 * @return the exemplar base to
	 */
	public ExemplarBaseTO getExemplarBaseTO(long id);

	/**
	 * Save base to.
	 * 
	 * @param exemplarBaseTO
	 *            the exemplar base to
	 * @return the exemplar
	 */
	public Exemplar saveBaseTO(ExemplarBaseTO exemplarBaseTO);

	/**
	 * Creates the.
	 * 
	 * @param exemplarBaseTO
	 *            the exemplar base to
	 * @param journalId
	 *            the journal id
	 * @return the exemplar
	 */
	public Exemplar create(ExemplarBaseTO exemplarBaseTO, Long journalId);

	/**
	 * Removes the safe.
	 * 
	 * @param exemplarId
	 *            the exemplar id
	 */
	public void removeSafe(Long exemplarId);
}
