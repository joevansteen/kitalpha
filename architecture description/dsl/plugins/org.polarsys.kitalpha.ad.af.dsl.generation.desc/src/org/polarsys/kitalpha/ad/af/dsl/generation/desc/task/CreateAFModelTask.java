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

package org.polarsys.kitalpha.ad.af.dsl.generation.desc.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.egf.core.producer.InvocationException;
import org.eclipse.egf.ftask.producer.context.ITaskProductionContext;
import org.eclipse.egf.ftask.producer.invocation.ITaskProduction;
import org.eclipse.egf.model.domain.EMFDomain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.polarsys.kitalpha.ad.af.coredomain.af.model.AF;
import org.polarsys.kitalpha.ad.af.coredomain.af.model.AfFactory;
import org.polarsys.kitalpha.ad.af.dsl.as.desc.helper.model.AFSpecConfigurationHelper;
import org.polarsys.kitalpha.ad.af.dsl.as.model.afdesc.ArchitectureFramework;
import org.polarsys.kitalpha.ad.af.dsl.as.model.afdesc.Viewpoints;
import org.polarsys.kitalpha.ad.af.dsl.generation.desc.internal.Constants;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.desc.helper.configuration.VpDslConfigurationHelper;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.model.vpdesc.Viewpoint;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.helper.viewpoint.PlatformViewpointHelper;

/**
 * @author Boubekeur Zendagui
 */

public class CreateAFModelTask implements ITaskProduction {

	@Override
	public void preExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
	}

	@Override
	public void doExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
		
		EMFDomain domainModel = productionContext.getInputValue(Constants.CONTRACT_DOMAIN_MODEL, EMFDomain.class);
		String projectId = productionContext.getInputValue(Constants.CONTRACT_PROJECT_NAME, String.class);
		String shortName = productionContext.getInputValue(Constants.CONTRACT_SHORT_NAME, String.class);
		
		List<Viewpoint> notGeneratedViewpoints = new ArrayList<Viewpoint>();
		
		String uri_s = "/"+projectId+"/"+Constants.MODELS_FOLDER+"/"+shortName+ Constants.AF_MODELS_EXTENSION;
		URI uri = URI.createPlatformResourceURI(uri_s, false);
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		
		EList<Object> content = domainModel.getContent();
		if (content != null && content.size() > 0)
		{
			EObject eObject = (EObject) content.get(0);
			if (eObject instanceof ArchitectureFramework)
			{
				ArchitectureFramework af_d = (ArchitectureFramework) eObject;
				AF af = AfFactory.eINSTANCE.createAF();
				af.setName(af_d.getName());
				af.setDescription(af_d.getDescription());
				af.setId(EcoreUtil.generateUUID());
				String projectName = AFSpecConfigurationHelper.getAFProjectName(af_d);
				af.setVpid(projectName);
				resource.getContents().add(af);
				
				Viewpoints vps = af_d.getAf_viewpoints();
				if (vps != null)
				{
					for (Viewpoint viewpoint : vps.getOwned_viewpoints()) 
					{
						// model update
						String viewpointID = VpDslConfigurationHelper.getRootProjectName(viewpoint);
						org.polarsys.kitalpha.ad.viewpoint.coredomain.viewpoint.model.Viewpoint viewpoint_af = 
							PlatformViewpointHelper.getAFViewpoint(viewpointID, resourceSet);

						if (viewpoint_af != null)
							af.getViewpoints().add(viewpoint_af);
						else
							notGeneratedViewpoints.add(viewpoint);
					}
				}
			}
		}
		
		try {
			resource.save(Collections.EMPTY_MAP);
			resource.unload();
		} catch (IOException e) {
			throw new InvocationException(e.getCause());
		}
		
		productionContext.setOutputValue(Constants.CONTRACT_NOT_GENERATED_VP, notGeneratedViewpoints);
		productionContext.setOutputValue(Constants.CONTRACT_MODEL_STRING_URI, uri_s);
		
	}

	@Override
	public void postExecute(ITaskProductionContext productionContext,
			IProgressMonitor monitor) throws InvocationException {
	}

}