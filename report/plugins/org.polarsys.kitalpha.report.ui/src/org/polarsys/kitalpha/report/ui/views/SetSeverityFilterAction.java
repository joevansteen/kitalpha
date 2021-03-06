/*******************************************************************************
 * Copyright (c) 2014, 2018 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *   Thales Global Services S.A.S - initial API and implementation
 *******************************************************************************/

package org.polarsys.kitalpha.report.ui.views;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Control;
import org.polarsys.kitalpha.report.model.Severity;
import org.polarsys.kitalpha.report.registry.ReportRegistry;
import org.polarsys.kitalpha.report.ui.Activator;
import org.polarsys.kitalpha.report.ui.ReportImages;

/**
 * @author Thomas Guiu
 * 
 */
public class SetSeverityFilterAction extends MenuCreatorAction {

	private final ReportsView view;

	public SetSeverityFilterAction(ReportsView view) {
		this.view = view;
		setToolTipText("Filter displayed reports");
		setImageDescriptor(Activator.getDefault().getImageDescriptor(ReportImages.IMG_SEVERITY_FILTER));
	}

	@Override
	protected void fillMenu(Control parent) {
		Severity threshold = computeSeverityThreshold();
		for (Severity elt : ReportRegistry.INSTANCE.getSeverities()) {
			ChooseSeverityAction action = new ChooseSeverityAction(elt);
			if (elt == threshold) {
				action.setChecked(true);
			}
			addActionToMenu(menu, action);
		}
	}

	private Severity computeSeverityThreshold() {
		Severity lowerOne = null;
		for (Severity elt : ReportRegistry.INSTANCE.getSeverities()) {
			if (elt.getCode() == view.getSeverityThreshold()) {
				return elt;
			}
			if (elt.getCode() > view.getSeverityThreshold()) {
				lowerOne = elt;
			} else {
				return lowerOne;
			}
		}
		return null;
	}

	class ChooseSeverityAction extends Action {

		private final Severity elt;

		public ChooseSeverityAction(Severity elt) {
			super(elt.getLabel(), AS_RADIO_BUTTON);
			this.elt = elt;
		}

		@Override
		public void run() {
			view.setSeverityThreshold(elt.getCode());
		}

	}
}
