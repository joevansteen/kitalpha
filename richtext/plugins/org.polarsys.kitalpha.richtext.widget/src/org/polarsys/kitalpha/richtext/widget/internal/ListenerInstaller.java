/*******************************************************************************
 * Copyright (c) 2017 Thales Global Services S.A.S.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Thales Global Services S.A.S - initial API and implementation
 ******************************************************************************/
package org.polarsys.kitalpha.richtext.widget.internal;

import java.beans.PropertyChangeEvent;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.browser.BrowserFunction;
import org.polarsys.kitalpha.richtext.nebula.widget.MDENebulaBasedRichTextWidget;
import org.polarsys.kitalpha.richtext.widget.tools.manager.LinkManagerImpl;

/**
 * 
 * @author Faycal Abka
 *
 */
public class ListenerInstaller {
	
	public void installOpenLinkListener(final MDENebulaBasedRichTextWidget widget) {

		new BrowserFunction(widget.getBrowser(), "openLinks"){ //$NON-NLS-1$
			public Object function(Object[] arguments) {
				if (arguments != null && arguments.length > 0){
					for (Object object : arguments) {
						(new LinkManagerImpl(widget)).openLink((String)object);
					}
				}
				return null;
			};
		};
		
		StringBuffer scriptAddMenu = new StringBuffer();
		
		/*
		 * Script to be executed
		 * 
		 * CKEDITOR.on('instanceReady', function(e) {
    	 *		CKEDITOR.instances.editor.addCommand("openLink", {
         *			exec: function(editor) {
         *   			if (typeof editor.getSelection().getStartElement().is('a')) {
         *       			openLinks(editor.getSelection().getStartElement().getAttribute('href'));
         *   			}
         *			}
    	 *		});
    	 *		var openLink = {
         *			label: 'Open',
         *			command: 'openLink'
    	 *		};
    	 *		CKEDITOR.instances.editor.contextMenu.addListener(function(element, selection) {
         *			return {
         *   			openLink: CKEDITOR.TRISTATE_ON
         *			};
    	 *		});
    	 *		CKEDITOR.instances.editor.addMenuItems({
         *			openLink: {
         *   			label: 'Open',
         *   			command: 'openLink',
         *    			group: 'link',
         *    			order: 1
         *			}
    	 *		});
		 *	});
		 */

		scriptAddMenu.append("CKEDITOR.on( 'instanceReady', function(e) {");
		scriptAddMenu.append("CKEDITOR.instances.editor.addCommand(\"openLink\", {");
		scriptAddMenu.append("exec : function( editor ) {");
		scriptAddMenu.append("          if (typeof editor.getSelection().getStartElement().is('a')){ openLinks(editor.getSelection().getStartElement().getAttribute('href'));}");
		scriptAddMenu.append("    }});");
		scriptAddMenu.append("	var openLink = {");
		scriptAddMenu.append("   label : 'Open Link',");
		scriptAddMenu.append("   command : 'openLink'");
		scriptAddMenu.append("	};");
		scriptAddMenu.append("	CKEDITOR.instances.editor.contextMenu.addListener( function( element, selection ) {");
		scriptAddMenu.append("	   if (element.is('a')){return { ");
		scriptAddMenu.append("     openLink : CKEDITOR.TRISTATE_ON ");
		scriptAddMenu.append("   };}");
		scriptAddMenu.append("	});");
		scriptAddMenu.append("	CKEDITOR.instances.editor.addMenuItems({");
		scriptAddMenu.append("  openLink : {");
		scriptAddMenu.append(" label : 'Open Link',");
		scriptAddMenu.append("      command : 'openLink',");
		scriptAddMenu.append("	      group : 'link',");
		scriptAddMenu.append("	      order : 1");
		scriptAddMenu.append("	   }});");
		scriptAddMenu.append("});");
		
		if (!widget.executeScript(scriptAddMenu.toString())){
			Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Rich text widget cannot install the open link command")); //$NON-NLS-1$
		}
	}


	
	
	public void installSaveListener(final MDENebulaBasedRichTextWidget widget){
		
		/**
		 * Callback which save the content at focus out event
		 */
		new BrowserFunction(widget.getBrowser(), "saveContent"){ //$NON-NLS-1$
			public Object function(Object[] arguments) {
				widget.saveContent();
				return null;
			};
		};
		
		
		/*
		 * Script:
		 * 
		 * CKEDITOR.instances.editor.on('blur', function() {
         * 		saveContent();
		 * });
		 */
		
		
		StringBuffer script = new StringBuffer();
		
		script.append("CKEDITOR.instances.editor.on('blur', function () {");
		script.append("saveContent();");
		script.append("});");
		
		if (!widget.executeScript(script.toString())){
			Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Rich text widget cannot install the save handler")); //$NON-NLS-1$
		}
	}
	
	
	public void installChangeNotificationHandlerListener(final MDENebulaBasedRichTextWidget widget) {
		
		/**
		 * Fire change content notification to all widgets  
		 */
		new BrowserFunction(widget.getBrowser(), "changeHandler"){ //$NON-NLS-1$
			public Object function(Object[] arguments) {
				if (arguments != null && arguments.length > 0) {
					PropertyChangeEvent event = new PropertyChangeEvent(widget, "widgetContent", null, (String)arguments[0]);
 					widget.firePropertyChangeEvent(event);
				}
				return null;
			};
		};
		
		/*
		 * Script:
		 * 
		 * CKEDITOR.instances.editor.on('blur', function() {
         * 		saveContent();
         * 		changeHandler(data);
		 * });
		 */
		StringBuffer script = new StringBuffer();
		
		script.append("CKEDITOR.instances.editor.on('blur', function () {");
		script.append("changeHandler(CKEDITOR.instances.editor.getData());");
		script.append("});");
		
		if (!widget.executeScript(script.toString())){
			Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Rich text widget cannot install the notification handler")); //$NON-NLS-1$
		}
	}
	

	public void installChangeContentListener(final MDENebulaBasedRichTextWidget widget) {

		StringBuffer script = new StringBuffer();

		/**
		 * Notice that firePropertyChangeEvent() javascript function is defined MDERichTextEditor.
		 */
		script.append("CKEDITOR.instances.editor.on('change', function () {");
		script.append("firePropertyChangeEvent();");
		script.append("});");

		if (!widget.executeScript(script.toString())){
			Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Rich text widget cannot install firePropertyChangeEvent handler")); //$NON-NLS-1$
		};
	}
}
