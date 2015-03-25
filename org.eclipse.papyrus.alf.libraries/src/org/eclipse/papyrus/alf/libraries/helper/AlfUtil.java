/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  IJI - Adapted for new Alf integration
 *  MDS - Revised for Luna
 *  Jeremie Tatibouet (CEA LIST)
 *
 *****************************************************************************/
package org.eclipse.papyrus.alf.libraries.helper;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.extensionpoints.profile.IRegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Singleton class providing a set of methods to manipulate the ALF profile
 */
public class AlfUtil {
	
	private AlfUtil(){}
	
	private static AlfUtil singleton;
	
	/**
	 * The Standard Profile
	 */
	protected Profile standardProfile;

	/**
	 * The Action Language profile
	 */
	protected Profile actionLanguageProfile;
	
	/**
	 * The TextualRepresentation stereotype (from the Action Language profile)
	 */
	protected Stereotype textualRepresentationStereotype;

	/**
	 * Provide a getter to obtain a reference over the helper;
	 * @return singleton
	 */
	public static AlfUtil getInstance(){
		if(singleton==null){
			singleton = new AlfUtil();
		}
		return singleton;
	}

	/**
	 * This retrieve the textual representation associated to a particular UML element.
	 * if there is no associated textual representation the result obtain is TextualRepresentation
	 * object which is not initialized
	 * @param element - the UML element from which we extract the textual representation
	 * @return representation - the textual representation
	 */
	public String getTextualRepresentation(Element element) {
		String representation = "";
		Comment textualRepresentationComment = this.getTextualRepresentationComment(element);
		if (textualRepresentationComment != null) {
			representation = textualRepresentationComment.getBody();
		}
		return representation;
	}
		
	/**
	 * Retrieve the first comment owned by this element being a textual representation comment
	 * @param element - the UML element that is expected to own the comment
	 * @return textualRepresentationComment - the textual representation comment found
	 */
	public Comment getTextualRepresentationComment(Element element) {
		Comment textualRepresentationComment = null;
		Iterator<Comment> commentsIterator = element.getOwnedComments().iterator();
		while(commentsIterator.hasNext() && textualRepresentationComment==null){
			Comment comment = commentsIterator.next();
			if (comment.getBody() != null && isATextualRepresentationComment(comment)) {
				textualRepresentationComment = comment;
			}
		}
		return textualRepresentationComment;
	}

	/**
	 * Load the standard profile in the context of the resource in which root is placed.
	 * @param root - the context
	 * @return a reference to the standard profile
	 */
	public Profile getStandardProfile(Model context) {
		if (this.standardProfile == null) {
			this.standardProfile = getProfile(context, AlfUtilConstants.STANDARD_PROFILE_NAME);
		}
		return standardProfile;
	}
	
	/**
	 * Load the action language profile in the context of the resource in which root is placed.
	 * @param root - the context
	 * @return a reference to the action language profile
	 */
	public Profile getActionLanguageProfile(Model context) {
		if (this.actionLanguageProfile == null) {
			actionLanguageProfile = getProfile(context, AlfUtilConstants.ACTION_LANGUAGE_PROFILE_NAME);
			textualRepresentationStereotype =
					actionLanguageProfile.getOwnedStereotype(
							AlfUtilConstants.TEXTUAL_REPRESENTATION_STEREOTYPE_NAME);
		}
		return actionLanguageProfile;
	}

	/**
	 * Load a profile in the context of the resource containing the model
	 * @param root - the context
	 * @param name - the name of the profile that needs to be loaded
	 * @return profile - a reference to the loaded profile
	 */
	protected Profile getProfile(Model context, String name) {
		Profile profile = null;
		IRegisteredProfile registeredProfile = RegisteredProfile.getRegisteredProfile(name);
		if(registeredProfile!=null){
			Resource modelResource = context.eResource().getResourceSet().getResource(registeredProfile.getUri(), true);
			if (modelResource.getContents().get(0) instanceof Profile) {
				profile = (Profile) modelResource.getContents().get(0);
			}
		}
		return profile;
	}

	/**
	 * Retrieve a reference on the definition of the textual representation stereotype
	 * @param comment - the comment from which the definition can retrived
	 * @return textualRepresentation - the definition of the stereotype textual representation
	 */
	private Stereotype getTextualRepresentationStereotype(Comment comment) {
		if (this.textualRepresentationStereotype == null) {
			// There is a chance to find it if the root model has ActionLanguage profile applied
			// In this case, the stereotype is included in comment.getApplicableStereotypes()
			for (Stereotype stereotype : comment.getApplicableStereotypes()) {
				if (stereotype.getName().equals(AlfUtilConstants.TEXTUAL_REPRESENTATION_STEREOTYPE_NAME)) {
					textualRepresentationStereotype = stereotype;
				}
			}
		}
		return textualRepresentationStereotype;
	}

	
	/**
	 * Returns whether the given comment has the stereotype textual representation applied
	 * @param comment - the assessed comment
	 * @return true if the textual representation stereotype is applied
	 */
	public boolean isATextualRepresentationComment(Comment comment) {
		Stereotype textualRepresentationStereotype = getTextualRepresentationStereotype(comment);
		return textualRepresentationStereotype != null &&
				comment.getAppliedStereotypes().contains(textualRepresentationStereotype) &&
				"Alf".equals(comment.getValue(textualRepresentationStereotype, 
						AlfUtilConstants.TEXTUALREPRESENTATION_LANGUAGE_ATTR_NAME));
	}

	/**
	 * Returns whether the action language profile is applied
	 * @param element - the context
	 * @return true - if it is applied
	 */
	public boolean isActionLanguageProfileApplied(Element context) {
		if(context.getModel()!=null){
			List<Profile> appliedProfiles = context.getModel().getAppliedProfiles();
			return appliedProfiles.contains(getActionLanguageProfile(context.getModel()));
		}
		return false;
	}

	/**
	 * Returns whether the standard profile is applied
	 * @param element - the context
	 * @return true - if it is applied
	 */
	public boolean isStandardProfileApplied(Element context) {
		if(context.getModel()!=null){
			List<Profile> appliedProfiles = context.getModel().getAppliedProfiles();
			return appliedProfiles.contains(getStandardProfile(context.getModel()));
		}
		return false;
	}

	
	/**
	 * Applies the Action Language Profile over the model owning the context element given as parameter
	 * @param context - the context element
	 * @return true if the profile was applied
	 */
	public boolean applyActionLanguageProfile(Element context){
		boolean applied = this.isActionLanguageProfileApplied(context);
		if(!applied){
			AbstractTransactionalCommand command = new ApplyProfileCommand(this.actionLanguageProfile, context.getModel());
			TransactionalEditingDomain domain = command.getEditingDomain();
			domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
			if(command.getCommandResult().getStatus().isOK()){
				applied = true;
			}
		}
		return applied;
	}
	
	/**
	 * Applies the Standard Profile over the model owning the context element given as parameter
	 * @param context - the context element
	 * @return true if the profile was applied
	 */
	public boolean applyStandardProfile(Element context){
		boolean applied = this.isStandardProfileApplied(context);
		if(!applied){
			AbstractTransactionalCommand command = new ApplyProfileCommand(this.standardProfile, context.getModel());
			TransactionalEditingDomain domain = command.getEditingDomain();
			domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
			if(command.getCommandResult().getStatus().isOK()){
				applied = true;
			}
		}
		return applied;
	}
	
	/**
	 * Create a new textual representation for the given element. This implies the application of the action
	 * profile over the model containing the element if this not already done.
	 * @param element - the element for which the comment is created
	 * @return textualRepresentationComment - the created comment
	 */
	public Comment createTextualRepresentationComment(Element element) {
		Comment textualRepresentationComment = element.createOwnedComment();
		this.applyActionLanguageProfile(element);
		Stereotype textualRepresentationStereotype =
				this.getTextualRepresentationStereotype(textualRepresentationComment);
		textualRepresentationComment.applyStereotype(textualRepresentationStereotype);
		textualRepresentationComment.setValue(textualRepresentationStereotype, 
				AlfUtilConstants.TEXTUALREPRESENTATION_LANGUAGE_ATTR_NAME, "Alf");
		return textualRepresentationComment;
	}
	
	public boolean applyTextualRepresentation(Comment comment){
		boolean applied = this.isActionLanguageProfileApplied(comment);
		if(!applied){
			applied = this.applyActionLanguageProfile(comment);
		}
		if(applied){
			comment.applyStereotype(this.textualRepresentationStereotype);
			comment.setValue(this.textualRepresentationStereotype,
					AlfUtilConstants.TEXTUALREPRESENTATION_LANGUAGE_ATTR_NAME, "Alf");
		}
		return applied;
	}
	
	public void clean() {
		this.actionLanguageProfile = null;
		this.textualRepresentationStereotype = null;
	}
	
	/**
	 * Constants used by AlfUtil
	 */
	class AlfUtilConstants{
		protected static final String STANDARD_PROFILE_NAME = "Standard";
		protected static final String ACTION_LANGUAGE_PROFILE_NAME = "ActionLanguage";
		protected static final String TEXTUAL_REPRESENTATION_STEREOTYPE_NAME = "TextualRepresentation";
		protected static final String TEXTUALREPRESENTATION_LANGUAGE_ATTR_NAME = "language";
	}
}
