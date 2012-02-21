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
package ejportal.webapp.taglib;

import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.appfuse.model.LabelValue;
import org.displaytag.tags.el.ExpressionEvaluator;

/**
 * Tag for creating multiple &lt;select&gt; options for displaying a list of
 * country names.
 * 
 * <p>
 * <b>NOTE</b> - This tag requires a Java2 (JDK 1.2 or later) platform.
 * </p>
 * 
 * @author Jens Fischer, Matt Raible
 * @version $Revision$ $Date$
 */
public class CountryTag extends TagSupport {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3905528206810167095L;

	/** The name. */
	private String name;

	/** The prompt. */
	private String prompt;

	/** The scope. */
	private String scope;

	/** The selected. */
	private String selected;

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * Sets the prompt.
	 * 
	 * @param prompt
	 *            the new prompt
	 */
	public void setPrompt(final String prompt) {
		this.prompt = prompt;
	}

	/**
	 * Sets the default.
	 * 
	 * @param selected
	 *            the new default
	 */
	public void setDefault(final String selected) {
		this.selected = selected;
	}

	/**
	 * Sets the to scope.
	 * 
	 * @param scope
	 *            the new to scope
	 */
	public void setToScope(final String scope) {
		this.scope = scope;
	}

	/**
	 * Process the start of this tag.
	 * 
	 * @return int status
	 * @throws JspException
	 *             if a JSP exception has occurred
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		final ExpressionEvaluator eval = new ExpressionEvaluator(this,
				this.pageContext);

		if (this.selected != null) {
			this.selected = eval.evalString("default", this.selected);
		}

		final Locale userLocale = this.pageContext.getRequest().getLocale();
		final List countries = this.buildCountryList(userLocale);

		if (this.scope != null) {
			if (this.scope.equals("page")) {
				this.pageContext.setAttribute(this.name, countries);
			} else if (this.scope.equals("request")) {
				this.pageContext.getRequest()
						.setAttribute(this.name, countries);
			} else if (this.scope.equals("session")) {
				this.pageContext.getSession()
						.setAttribute(this.name, countries);
			} else if (this.scope.equals("application")) {
				this.pageContext.getServletContext().setAttribute(this.name,
						countries);
			} else
				throw new JspException(
						"Attribute 'scope' must be: page, request, session or application");
		} else {
			final StringBuffer sb = new StringBuffer();
			sb.append("<select name=\"").append(this.name).append("\" id=\"")
					.append(this.name).append("\" class=\"select\">\n");

			if (this.prompt != null) {
				sb.append("    <option value=\"\" selected=\"selected\">");
				sb.append(eval.evalString("prompt", this.prompt)).append(
						"</option>\n");
			}

			for (final Object country1 : countries) {
				final LabelValue country = (LabelValue) country1;
				sb.append("    <option value=\"").append(country.getValue())
						.append("\"");

				if ((this.selected != null)
						&& this.selected.equals(country.getValue())) {
					sb.append(" selected=\"selected\"");
				}

				sb.append(">").append(country.getLabel()).append("</option>\n");
			}

			sb.append("</select>");

			try {
				this.pageContext.getOut().write(sb.toString());
			} catch (final IOException io) {
				throw new JspException(io);
			}
		}

		return super.doStartTag();
	}

	// /**
	// * Release aquired resources to enable tag reusage.
	// *
	// * @see javax.servlet.jsp.tagext.Tag#release()
	// */
	// public void release() {
	// super.release();
	// }

	/**
	 * Build a List of LabelValues for all the available countries. Uses the two
	 * letter uppercase ISO name of the country as the value and the localized
	 * country name as the label.
	 * 
	 * @param locale
	 *            The Locale used to localize the country names.
	 * 
	 * @return List of LabelValues for all available countries.
	 */
	@SuppressWarnings("unchecked")
	protected List<LabelValue> buildCountryList(final Locale locale) {
		final Locale[] available = Locale.getAvailableLocales();

		final List<LabelValue> countries = new ArrayList<LabelValue>();

		for (final Locale anAvailable : available) {
			final String iso = anAvailable.getCountry();
			final String name = anAvailable.getDisplayCountry(locale);

			if (!"".equals(iso) && !"".equals(name)) {
				final LabelValue country = new LabelValue(name, iso);

				if (!countries.contains(country)) {
					countries.add(new LabelValue(name, iso));
				}
			}
		}

		Collections.sort(countries, new LabelValueComparator(locale));

		return countries;
	}

	/**
	 * Class to compare LabelValues using their labels with locale-sensitive
	 * behaviour.
	 */
	public class LabelValueComparator implements Comparator {

		/** The c. */
		private final Comparator c;

		/**
		 * Creates a new LabelValueComparator object.
		 * 
		 * @param locale
		 *            The Locale used for localized String comparison.
		 */
		public LabelValueComparator(final Locale locale) {
			this.c = Collator.getInstance(locale);
		}

		/**
		 * Compares the localized labels of two LabelValues.
		 * 
		 * @param o1
		 *            The first LabelValue to compare.
		 * @param o2
		 *            The second LabelValue to compare.
		 * 
		 * @return The value returned by comparing the localized labels.
		 */
		@SuppressWarnings("unchecked")
		public final int compare(final Object o1, final Object o2) {
			final LabelValue lhs = (LabelValue) o1;
			final LabelValue rhs = (LabelValue) o2;

			return this.c.compare(lhs.getLabel(), rhs.getLabel());
		}
	}
}
