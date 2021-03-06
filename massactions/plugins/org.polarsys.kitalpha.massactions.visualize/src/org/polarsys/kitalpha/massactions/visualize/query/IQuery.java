/*******************************************************************************
 * Copyright (c) 2018  Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.massactions.visualize.query;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

public interface IQuery {

	void setTarget(EObject target);
	
	String getName();	

	void setName(String name);	

	boolean isValidFor(List<Object> values);

	boolean isValidFor(Object... values);

	void setParameterValues(List<Object> values);

	void setParameterValues(Object... values);

	void setParameters(List<QueryParameter> parameters);

	void setParameters(QueryParameter... parameters);

	public Object evaluate();

}
