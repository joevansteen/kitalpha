/*******************************************************************************
 * Copyright (c) 2013 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    THALES GLOBAL SERVICES - Initial API and implementation
 *******************************************************************************/

/**
 * 
 */
package org.polarsys.kitalpha.composer.ui.launch.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import org.polarsys.kitalpha.composer.ui.Activator;
import org.polarsys.kitalpha.composer.ui.launch.ICodeManagerLaunchConfigurationConstants;
import org.polarsys.kitalpha.composer.ui.launch.tabs.widgets.composer.GeneratorTypeWidget;
import org.polarsys.kitalpha.composer.ui.launch.tabs.widgets.composer.GeneratorWidget;
import org.polarsys.kitalpha.composer.ui.launch.tabs.widgets.composer.RefineryWidget;
import org.polarsys.kitalpha.composer.ui.launch.tabs.widgets.composer.StrategyWidget;

/**
 * @author Guillaume Gebhart
 *
 */
public class ComposerTab extends AbstractLaunchConfigurationTab{

	private static final String TAB_NAME = "Composer";
	private final GeneratorTypeWidget typeWidget = new GeneratorTypeWidget(this);
	private final StrategyWidget strategyWidget = new StrategyWidget(this);
	private final RefineryWidget refineryWidget = new RefineryWidget(this);
	private final GeneratorWidget generatorWidget = new GeneratorWidget(this);
	
	
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout topLayout = new GridLayout();
		topLayout.marginHeight = 0;
		topLayout.marginWidth = 0;
		topLayout.numColumns = 1;
		topLayout.marginTop = 10;
		topLayout.marginLeft = 10;
		topLayout.marginRight = 10;
		comp.setLayout(topLayout);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		comp.setLayoutData(gd);
		setControl(comp);
		
		
		typeWidget.createContents(comp);
		strategyWidget.createContents(comp);
		refineryWidget.createContents(comp);
		generatorWidget.createContents(comp);
		
	}

	
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		try {
			setGlobalNsUri(workingCopy
							.getAttribute(
									ICodeManagerLaunchConfigurationConstants.GENERATION_ALLOCATION_URI,
									""));
		} catch (CoreException e) {
			Activator.getDefault().getLog().log(e.getStatus());
		}
	}

	public String getName() {
		// TODO Auto-generated method stub
		return TAB_NAME;
	}
	
	public Image getImage() {
		String img = "icons/composer.png";
		ImageDescriptor descriptor =  Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, img);
		return descriptor.createImage();
		
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		typeWidget.initializeFrom(configuration);
		strategyWidget.initializeFrom(configuration);
		refineryWidget.initializeFrom(configuration);
		generatorWidget.initializeFrom(configuration);
		
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		typeWidget.performApply(configuration);
		strategyWidget.performApply(configuration);
		refineryWidget.performApply(configuration);
		generatorWidget.performApply(configuration);
		
		
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
		
	}
	
		
	
	public Shell getShell(){
		return super.getShell();
	}

	public void updateLaunchConfigurationDialog(){
		super.updateLaunchConfigurationDialog();
	}
	

	public boolean isDirty(){
		return super.isDirty();
	}
	
	public void update(){
		setDirty(true);
		updateLaunchConfigurationDialog();
		
	}


	public final void setGlobalNsUri(String nsUri_p) {
		strategyWidget.setNsUri(nsUri_p);
		refineryWidget.setNsUri(nsUri_p);
		generatorWidget.setNsUri(nsUri_p);
	}
		
	
}