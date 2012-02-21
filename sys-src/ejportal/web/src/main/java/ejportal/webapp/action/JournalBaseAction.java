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

import ejportal.service.JournalTitelService;

/**
 * Created by IntelliJ IDEA. User: florian Date: 11.08.2010 Time: 13:20:53 To
 * change this template use File | Settings | File Templates.
 */
public class JournalBaseAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 850162683112554044L;

	/** The journal titel service. */
	private JournalTitelService journalTitelService;

	/** The journal id. */
	protected Long journalId;

	/**
	 * Gets the journal id.
	 * 
	 * @return the journal id
	 */
	public long getJournalId() {
		return this.journalId;
	}

	/**
	 * Sets the journal id.
	 * 
	 * @param journalId
	 *            the new journal id
	 */
	public void setJournalId(final long journalId) {
		this.journalId = journalId;
	}

	/**
	 * Sets the journal titel service.
	 * 
	 * @param journalTitelService
	 *            the new journal titel service
	 */
	public void setJournalTitelService(
			final JournalTitelService journalTitelService) {
		this.journalTitelService = journalTitelService;
	}

	/**
	 * Gets the titel.
	 * 
	 * @return the titel
	 */
	public String getTitel() {
		return this.journalTitelService.getTitel(this.journalId);
	}

}
