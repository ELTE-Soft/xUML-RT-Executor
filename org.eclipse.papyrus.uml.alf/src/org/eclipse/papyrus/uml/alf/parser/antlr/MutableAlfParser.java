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
 *  Jérémie Tatibouet
 *  Arnaud Cuccuru
 * 
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.parser.antlr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;

/**
 * Provide an extended ALF parser capable to adapt the parser entry rule
 * according to the textual representation which is going to be parsed
 */
public class MutableAlfParser extends AlfParser {

	public static EObject SEMANTIC_ELEMENT = null;

	private static final String UNIT_DEFINITION_RULE = "UnitDefinition";

	private static final String CLASS_MEMBER_RULE = "ClassMember";

	/**
	 * Take advantage of editor configuration
	 */
	@Override
	protected String getDefaultRuleName() {
		return this.selectParserEntryRule(SEMANTIC_ELEMENT);
	}

	/**
	 * Change the entry rule used by the parser to start recognition of an Alf Model
	 * 
	 * @param objectToEdit
	 * @return the entry rule
	 */
	protected String selectParserEntryRule(EObject objectToEdit) {
		if (objectToEdit instanceof Class) {
			return UNIT_DEFINITION_RULE;
		} else if (objectToEdit instanceof Property) {
			return CLASS_MEMBER_RULE;
		} else {
			return null;
		}
	}
}
