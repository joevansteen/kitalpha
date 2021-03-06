/*******************************************************************************
 * Copyright (c)  2017 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.kitalpha.vp.componentsample.ui.filters;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.polarsys.kitalpha.vp.componentsample.ComponentSample.ComponentElement;

/**
 * 
 * @author Faycal Abka
 *
 */
public class ComponentSamplePropertyTabFilterDiagram implements IFilter {

	@Override
	public boolean select(Object toTest) {
		if (toTest instanceof GraphicalEditPart){
			EObject target;
			EObject semanticElement = ((GraphicalEditPart)toTest).resolveSemanticElement();
			if (semanticElement instanceof DSemanticDiagram){
				target = ((DSemanticDiagram)semanticElement).getTarget();
				return isComponentElement(target);
			}
			if (semanticElement instanceof DRepresentationElement){
				target = ((DRepresentationElement)semanticElement).getTarget();
				return isComponentElement(target);
			}
		}
		return false;
	}

	private boolean isComponentElement(EObject target) {
		return target instanceof ComponentElement;
	}
}
