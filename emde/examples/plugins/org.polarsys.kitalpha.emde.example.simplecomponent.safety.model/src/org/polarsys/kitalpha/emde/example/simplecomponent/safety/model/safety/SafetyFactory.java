/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.emde.example.simplecomponent.safety.model.safety;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.polarsys.kitalpha.emde.example.simplecomponent.safety.model.safety.SafetyPackage
 * @generated
 */
public interface SafetyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SafetyFactory eINSTANCE = org.polarsys.kitalpha.emde.example.simplecomponent.safety.model.safety.impl.SafetyFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>Simple VP Safety</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple VP Safety</em>'.
	 * @generated
	 */
	SimpleVPSafety createSimpleVPSafety();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SafetyPackage getSafetyPackage();

} //SafetyFactory
