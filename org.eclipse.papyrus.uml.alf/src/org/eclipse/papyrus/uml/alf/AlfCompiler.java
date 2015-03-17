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
 *  IJI - Initial implementation
 * 
 *****************************************************************************/

package org.eclipse.papyrus.uml.alf;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;

public class AlfCompiler extends AlfMapper {

	protected NamedElement contextElement = null;
	protected IParser parser = null;

	public AlfCompiler() {
		super();
		this.parser = this.getInjector().getInstance(IParser.class);
	}

	public AlfCompiler(ResourceSet resourceSet) {
		super(resourceSet);
		this.parser = this.getInjector().getInstance(IParser.class);
	}

	public AlfCompiler(NamedElement contextElement) {
		this(contextElement.eResource().getResourceSet());
		this.setContextElement(contextElement);
	}

	public AlfCompiler(NamedElement contextElement,
			Profile standardProfile, Profile actionLanguageProfile) {
		super(contextElement.eResource().getResourceSet(),
				standardProfile, actionLanguageProfile);
		this.parser = this.getInjector().getInstance(IParser.class);
		this.setContextElement(contextElement);
	}

	public void setContextElement(NamedElement contextElement) {
		this.contextElement = contextElement;
	}

	public EObject parse(String textualRepresentation) throws ParsingError {
		IParseResult result = parser.parse(new StringReader(textualRepresentation));
		if (result.hasSyntaxErrors()) {
			throw new ParsingError(result.getSyntaxErrors());
		} else {
			return result.getRootASTElement();
		}
	}

	public void compile(String textualRepresentation) throws ParsingError, MappingError {
		List<EObject> alf = new BasicEList<EObject>();
		alf.add(this.parse(textualRepresentation));
		this.map(this.contextElement, alf);

		// Delete the temporary resource, so it doesn't show up in the Papyrus
		// model explorer.
		try {
			this.resource.delete(null);
		} catch (IOException e) {
		}
	}


}
