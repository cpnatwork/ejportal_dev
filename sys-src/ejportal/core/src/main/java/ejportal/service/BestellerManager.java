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

import ejportal.model.Besteller;
import ejportal.service.dto.BestellerBaseTO;
import ejportal.service.dto.BestellerSearchTO;

/**
 * Created by IntelliJ IDEA. User: mkoerner Date: 09.08.2010 Time: 16:13:01 To
 * change this template use File | Settings | File Templates.
 */
public interface BestellerManager extends GenericManager<Besteller, Long> {

	/**
	 * Search.
	 * 
	 * @param bestellerSearchTO
	 *            the besteller search to
	 * @param maxResults
	 *            the max results
	 * @return the list
	 */
	public List<Besteller> search(BestellerSearchTO bestellerSearchTO,
			Integer maxResults);

	/**
	 * Connect besteller sigel.
	 * 
	 * @param bestellerId
	 *            the besteller id
	 * @param sigelId
	 *            the sigel id
	 */
	public void connectBestellerSigel(long bestellerId, long sigelId);

	/**
	 * Gets the besteller base to.
	 * 
	 * @param bestellerId
	 *            the besteller id
	 * @return the besteller base to
	 */
	public BestellerBaseTO getBestellerBaseTO(long bestellerId);

	/**
	 * Save base to.
	 * 
	 * @param bestellerBaseTO
	 *            the besteller base to
	 * @return the besteller
	 */
	public Besteller saveBaseTO(BestellerBaseTO bestellerBaseTO);

	/**
	 * Creates the.
	 * 
	 * @param bestellerBaseTO
	 *            the besteller base to
	 * @return the besteller
	 */
	public Besteller create(BestellerBaseTO bestellerBaseTO);

}
