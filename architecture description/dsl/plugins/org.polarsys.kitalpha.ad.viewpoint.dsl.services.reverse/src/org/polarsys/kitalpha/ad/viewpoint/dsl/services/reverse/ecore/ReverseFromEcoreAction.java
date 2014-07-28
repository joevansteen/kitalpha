/*******************************************************************************
 * Copyright (c) 2014 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/

package org.polarsys.kitalpha.ad.viewpoint.dsl.services.reverse.ecore;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.polarsys.kitalpha.ad.viewpoint.dsl.services.reverse.message.Messages;
import org.polarsys.kitalpha.ad.viewpoint.dsl.services.reverse.wizard.ReverseDSLVPProjectWizard;

/**
 * @author Boubekeur Zendagui
 */

public class ReverseFromEcoreAction extends BaseSelectionListenerAction implements IObjectActionDelegate{
	
	private IStructuredSelection selection;

	public ReverseFromEcoreAction() 
	{
		super(Messages.Reverse_EcoreAction_Name);
	}

	public void run(IAction action) {
		 ReverseDSLVPProjectWizard wizard = new ReverseDSLVPProjectWizard(selection);
		 WizardDialog wizard_dialog = new WizardDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), wizard);
		 wizard_dialog.open();
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = (IStructuredSelection) selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		
	}
	
}