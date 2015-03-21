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
 * 	Ed Seidewitz
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.validation.CancelableDiagnostician;

import com.google.inject.Inject;

public class CachingDiagnostician extends CancelableDiagnostician {

	private boolean caching = false;

	@Inject
	public CachingDiagnostician(Registry registry) {
		super(registry);
	}

	public CachingDiagnostician() {
		this(EValidator.Registry.INSTANCE);
	}

	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result;
		if (this.caching) {
			result = super.validate(eObject, diagnostics, context);
		} else {
			this.caching = true;
			result = super.validate(eObject, diagnostics, context);
			this.caching = false;
			RunTimeCaching.clearAll();
		}
		return result;
	}

}
