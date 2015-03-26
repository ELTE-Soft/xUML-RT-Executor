/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  IJI - Initial implementation
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf;

import org.eclipse.xtext.nodemodel.INode;

public class ParsingError extends Exception {

	private static final long serialVersionUID = 1L;
	Iterable<INode> syntaxErrors;

	public ParsingError(Iterable<INode> syntaxErrors) {
		this.syntaxErrors = syntaxErrors;
	}

	public Iterable<INode> getSyntaxErrors() {
		return this.syntaxErrors;
	}

}
