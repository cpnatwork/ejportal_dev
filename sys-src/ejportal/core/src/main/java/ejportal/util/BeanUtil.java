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
package ejportal.util;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Created by IntelliJ IDEA. User: Florian Date: 01.07.2010 Time: 13:20:02 To
 * change this template use File | Settings | File Templates.
 */
public class BeanUtil {

	/**
	 * Copy entity to base to.
	 * 
	 * @param entity
	 *            the entity
	 * @param entityBase
	 *            the entity base
	 * @throws Exception
	 *             the exception
	 */
	public void copyEntityToBaseTO(final Object entity, final Object entityBase)
			throws Exception {
		final Class entityClazz = entity.getClass();
		final Class baseClazz = entityBase.getClass();

		// alle Methoden holen
		final Method[] allMethods = baseClazz.getDeclaredMethods();
		for (final Method baseMethod : allMethods) {
			final String methodName = baseMethod.getName();

			// ab hier sind nur die setter interessant
			if (!methodName.startsWith("set")) {
				continue;
			}

			// kleine Fehlerpruefung
			final Type[] types = baseMethod.getGenericParameterTypes();
			if (types.length != 1)
				throw new Exception("BeanUtil: Moep! Da ging was total schief");

			// wie heisst wohl der getter zum setter ;-)
			final String getter = "get"
					+ methodName.substring(3, methodName.length());

			// Do it!
			try {
				final Method entityMethod = entityClazz
						.getDeclaredMethod(getter);
				baseMethod.invoke(entityBase, entityMethod.invoke(entity));

			} catch (final Exception e) {
				// TODO Fehlerbehandlung
				System.err.println("## Fehler bei " + methodName);
				e.printStackTrace();
				throw new Exception("BeanUtil: Reflection Voodoo ging schief");
			}

		}

	}

	/**
	 * Copy base t oto entity.
	 * 
	 * @param entityBase
	 *            the entity base
	 * @param entity
	 *            the entity
	 * @throws Exception
	 *             the exception
	 */
	public void copyBaseTOtoEntity(final Object entityBase, final Object entity)
			throws Exception {
		final Class entityClazz = entity.getClass();
		final Class baseClazz = entityBase.getClass();

		// alle Methoden holen
		final Method[] allMethods = baseClazz.getDeclaredMethods();
		for (final Method baseMethod : allMethods) {
			final String methodName = baseMethod.getName();

			// ab hier sind nur die getter interessant
			if (!methodName.startsWith("get")) {
				continue;
			}

			// kleine Fehlerpruefung
			final Type[] types = baseMethod.getGenericParameterTypes();
			if (types.length != 0)
				throw new Exception("BeanUtil: Moep! Da ging was total schief");

			// wie heisst wohl der setter zum getter ;-)
			final String setter = "set"
					+ methodName.substring(3, methodName.length());

			try {
				// Do it!
				final Method entityMethod = entityClazz.getDeclaredMethod(
						setter, baseMethod.getReturnType());
				entityMethod.invoke(entity, baseMethod.invoke(entityBase));

			} catch (final Exception e) {
				// TODO Fehlerbehandlung
				e.printStackTrace();
				throw new Exception("BeanUtil: Reflection Voodoo ging schief");
			}

		}

	}
}
