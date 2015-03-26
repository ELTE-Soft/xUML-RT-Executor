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

import java.util.ArrayList;

import org.eclipse.papyrus.uml.alf.impl.SyntaxElementImpl;

public class RunTimeCaching {

	public static final RunTimeCaching INSTANCE = new RunTimeCaching();

	public static void register(SyntaxElementImpl element) {
		INSTANCE.add(element);
	}

	public static void clearAll() {
		INSTANCE.clear();
	}

	private ArrayList<SyntaxElementImpl> registry = new ArrayList<SyntaxElementImpl>();

	private RunTimeCaching() {
	}

	public void add(SyntaxElementImpl element) {
		this.registry.add(element);
	}

	public void clear() {
		for (SyntaxElementImpl element : registry) {
			// System.out.println("[clear] " + element.getId());
			element.clear();
		}
		// Reallocate registry to avoid memory leaks.
		this.registry = new ArrayList<SyntaxElementImpl>();
	}

}
