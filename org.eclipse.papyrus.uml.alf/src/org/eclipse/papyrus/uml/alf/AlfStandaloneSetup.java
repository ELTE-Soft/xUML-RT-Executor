/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class AlfStandaloneSetup extends AlfStandaloneSetupGenerated {

	public static void doSetup() {
		new AlfStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
