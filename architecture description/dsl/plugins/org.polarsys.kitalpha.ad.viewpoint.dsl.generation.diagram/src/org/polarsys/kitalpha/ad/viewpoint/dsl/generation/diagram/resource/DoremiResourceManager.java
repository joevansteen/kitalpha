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

package org.polarsys.kitalpha.ad.viewpoint.dsl.generation.diagram.resource;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.sirius.ui.tools.api.project.ViewpointSpecificationProject;
import org.eclipse.sirius.viewpoint.description.DescriptionFactory;
import org.eclipse.sirius.viewpoint.description.Group;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.polarsys.kitalpha.ad.viewpoint.dsl.as.diagram.helper.extension.ExtensionManager;
import org.polarsys.kitalpha.ad.viewpoint.dsl.generation.provider.resourceimpl.ViewpointResourceProviderRegistry;

/**
 * @author Boubekeur Zendagui
 */

public class DoremiResourceManager {
	
	public static Group group;
	
	public static Viewpoint generate_viewpoint;
	private static EObject root_model_object;
	
	private static ResourceSet rSet;
	private static Resource doremiResource;
	
	public static void clear(){
		generate_viewpoint = null;
		root_model_object = null;
		doremiResource = null;
		rSet = null;
	}
	
	public static void loadAndInitODesignModel(String projectName, String modelFolder, String modelName){
		IProject vProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		boolean loaded = false;
		if (vProject.exists())
		{
			IFolder model_folder = vProject.getFolder(modelFolder);
			if (model_folder.exists())
			{
				IFile model_file = model_folder.getFile(modelName+"."+ViewpointSpecificationProject.VIEWPOINT_MODEL_EXTENSION);
				if (model_file.exists())
				{
					rSet = new ResourceSetImpl();
					URI doremiURI = URI.createPlatformResourceURI(model_file.getFullPath().toString(), true);
					doremiResource = rSet.getResource(doremiURI, true);
					root_model_object = doremiResource.getContents().get(0);
					if (root_model_object instanceof Group)
					{
						group = (Group)root_model_object;
						Viewpoint vp = DescriptionFactory.eINSTANCE.createViewpoint();
						String newModelName = modelName.substring(0, 1).toUpperCase()+modelName.substring(1, modelName.length());
						vp.setLabel(newModelName);
						vp.setName(newModelName+"_ID");
						vp.setModelFileExtension(diagramExtensions(modelName.toLowerCase()));
						group.getOwnedViewpoints().add(vp);
						
						generate_viewpoint = vp;
					}
					loaded = true;
				}
			}
		}
		if (!loaded)
		{
			// TODO: handle case
		}
	}
	
	public static void loadODesignModel(String projectName, String modelFolder, String modelName){
		IProject vProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (vProject.exists())
		{
			IFolder model_folder = vProject.getFolder(modelFolder);
			if (model_folder.exists())
			{
				IFile model_file = model_folder.getFile(modelName+"."+ViewpointSpecificationProject.VIEWPOINT_MODEL_EXTENSION);
				if (model_file.exists())
				{
					rSet = new ResourceSetImpl();
					URI doremiURI = URI.createPlatformResourceURI(model_file.getFullPath().toString(), true);
					doremiResource = rSet.getResource(doremiURI, true);
					root_model_object = doremiResource.getContents().get(0);
					if (root_model_object instanceof Group)
					{
						group = (Group)root_model_object;
					}
				}
			}
		}
	}
	
	private static String diagramExtensions(String modelName){
		String result = modelName;
		
		// Add diagram filters extensions
		EObject viewpoint = ViewpointResourceProviderRegistry.getInstance().getViewpoint();
		List<String> taExtensions = ExtensionManager.getDiagramFilters(viewpoint);
		
		if (! taExtensions.isEmpty())
		{
			for (String extension : taExtensions) 
				result += " " + extension;
		}

		return result;
	}
	
	public static void save(){
		try {
			doremiResource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}