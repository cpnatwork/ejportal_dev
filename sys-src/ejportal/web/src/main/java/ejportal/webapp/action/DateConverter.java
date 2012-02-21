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

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.appfuse.util.DateUtil;

import com.opensymphony.xwork2.conversion.TypeConversionException;

/**
 * This class implements a Struts Type Converter and can be used by struts to
 * convert Date's to Strings.
 * 
 * @author mraible
 */
public class DateConverter extends StrutsTypeConverter {

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object convertFromString(final Map ctx, final String[] value,
			final Class arg2) {
		if ((value[0] == null) || value[0].trim().equals(""))
			return null;

		try {
			return DateUtil.convertStringToDate(value[0]);
		} catch (final ParseException pe) {
			pe.printStackTrace();
			throw new TypeConversionException(pe.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public String convertToString(final Map ctx, final Object data) {
		return DateUtil.convertDateToString((Date) data);
	}
}
