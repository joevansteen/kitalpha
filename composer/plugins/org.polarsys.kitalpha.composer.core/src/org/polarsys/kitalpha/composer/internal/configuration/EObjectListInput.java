/*******************************************************************************
 * Copyright (c) 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    THALES GLOBAL SERVICES - Initial API and implementation.
 *******************************************************************************/


package org.polarsys.kitalpha.composer.internal.configuration;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.polarsys.kitalpha.composer.api.configuration.ICodeManagerInput;

/**
 * Input that is a list of {@link EObject}s.
 * 
 * @author Yann Mortier
 */
public class EObjectListInput implements ICodeManagerInput {

	private final List<EObject> input;

	private EObjectListInput(List<EObject> input) {
		this.input = input;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.polarsys.kitalpha.composer.api.ICodeManagerInput#getListInput()
	 */
	public List<EObject> getListInput() {
		return this.input;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.polarsys.kitalpha.composer.api.ICodeManagerInput#getRootsInputs()
	 */
	public List<EObject> getRootsInputs() {
		return Collections.<EObject> emptyList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.polarsys.kitalpha.composer.api.ICodeManagerInput#isMultipleObjectsInput()
	 */
	public boolean isMultipleObjectsInput() {
		return true;
	}

	public static ICodeManagerInput create(List<EObject> input) {
		if (input == null) {
			throw new IllegalArgumentException("The input is null");
		}
		return new EObjectListInput(input);
	}
}