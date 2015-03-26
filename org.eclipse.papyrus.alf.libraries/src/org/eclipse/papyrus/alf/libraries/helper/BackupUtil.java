/*****************************************************************************
 * Copyright (c) 2015 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Jérémie Tatibouet (CEA LIST)
 * 
 *****************************************************************************/
package org.eclipse.papyrus.alf.libraries.helper;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.papyrus.alf.libraries.helper.BackupState.EditionStatus;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Singleton class providing a set of methods to manipulate the backup profile
 */
public class BackupUtil {
	
	/**
	 * A reference to the unique instance of that class
	 */
	private static BackupUtil singleton;
	
	/**
	 * A reference on the Backup profile 
	 */
	protected Profile backupProfile;
	
	/**
	 * A reference on the stereotype Backup
	 */
	protected Stereotype backupStereotype;
	
	/**
	 * A reference to the enumeration BackupState
	 */
	protected Enumeration backupStateEnumeration;
	
	/**
	 * Mapping between UML Enumeration BackupState and its Java Implementation
	 */
	private HashMap<EditionStatus, EnumerationLiteral> stateMapping;
	
	/**
	 * Reverse mapping
	 */
	private HashMap<EnumerationLiteral, EditionStatus> inverseStateMapping;
	
	private BackupUtil(){
		this.stateMapping = new HashMap<EditionStatus, EnumerationLiteral>();
		this.inverseStateMapping = new HashMap<EnumerationLiteral, EditionStatus>();
	}
	
	/**
	 * Returns an instance of the singleton
	 * @return singleton - the instance of the class
	 */
	public static BackupUtil getInstance(){
		if(singleton==null){
			singleton = new BackupUtil();
		}
		return singleton;
	}
		
	/**
	 * Load the backup profile in the context of the resource owning the element given as a parameter.
	 * @param context - the context element
	 * @return backupProfile - a reference to the loaded profile
	 */
	public Profile getBackupProfile(Element context){
		if(this.backupProfile==null){
			this.backupProfile = AlfUtil.getInstance().getProfile(context.getModel(), BackupUtilConstants.BACKUP_PROFILE_NAME);
			this.backupStereotype = this.backupProfile.getOwnedStereotype(BackupUtilConstants.BACKUP_STEREOTYPE_NAME);
			this.backupStateEnumeration = (Enumeration)this.backupProfile.getOwnedType(BackupUtilConstants.BACKUP_BACKUP_STATE_ENUMERATION_NAME);
			this.initInternalConverter();
		}
		return this.backupProfile;
	}
	
	private void initInternalConverter(){
		for(EnumerationLiteral literal: this.backupStateEnumeration.getOwnedLiterals()){
			if(literal.getLabel().equals("NONE")){
				stateMapping.put(EditionStatus.NONE, literal);
				inverseStateMapping.put(literal, EditionStatus.NONE);
			}else if(literal.getLabel().equals("SAVED")){
				stateMapping.put(EditionStatus.SAVED, literal);
				inverseStateMapping.put(literal, EditionStatus.SAVED);
			}else{
				stateMapping.put(EditionStatus.MERGED, literal);
				inverseStateMapping.put(literal, EditionStatus.MERGED);
			}
		}
	}
	
	/**
	 * Returns whether the element has a comment with the Backup stereotype
	 * @param element - the assessed element
	 * @return true if the stereotype is applied
	 */
	public boolean isBackup(Element element){
		boolean found = false;
		Iterator<Comment> iteratorComments = element.getOwnedComments().iterator();
		while(iteratorComments.hasNext() && !found){
			Comment current = iteratorComments.next();
			if(current.getAppliedStereotypes().contains(this.backupStereotype)){
				found = true;
			}
		}
		return found;
	}
	
	public boolean isBackup(Comment comment){
		return comment.getAppliedStereotypes().contains(this.backupStereotype);
	}
	
	/**
	 * Retrieve the Backup stereotype definition
	 * @param element - the context element
	 * @return backupStereotype - the definition of the stereotype 
	 */
	public Stereotype getBackuStereotype(Element element){
		if(this.backupStereotype!=null){
			return this.backupStereotype;
		}
		else if(this.isBackupProfileApplied(element) && !element.getOwnedComments().isEmpty()){
			this.backupStereotype = element.getOwnedComments().get(0).getApplicableStereotype(BackupUtilConstants.BACKUP_STEREOTYPE_NAME);
			return this.backupStereotype;
		}else{
			return null;
		}
	}
	
	/**
	 * Applies the Backup stereotype over a comment and sets the stereotype attributes. It implies
	 * the application of the backup stereotype over the context model if is not already done. 
	 * @param comment - the comment on which the stereotype is applied
	 * @param timestamp - the value for the time stamp attribute
	 * @param state - the value for the state attribute
	 * @return true if the applications was realized
	 */
	public boolean applyBackup(Comment comment, final BackupState state){
		boolean applied = false;
		boolean profileApplied = true;
		if(!this.isBackupProfileApplied(comment)){
			if(this.backupProfile==null){
				this.getBackupProfile(comment);
			}
			profileApplied = PackageUtil.applyProfile((org.eclipse.uml2.uml.Package)
					comment.getModel(), this.backupProfile, true);
		}
		if(profileApplied){
			/*1. Apply the stereotype*/
			if(!this.isBackup(comment)){
				comment.applyStereotype(this.backupStereotype);
			}
			/*2. Set time stamp attribute*/
			comment.setValue(this.backupStereotype, BackupUtilConstants.BACKUP_TIMESTAMP_ATTR_NAME, state.timestamp.toString());
			/*3. Set state attribute*/
			comment.setValue(this.backupStereotype, BackupUtilConstants.BACKUP_STATE_ATTR_NAME, this.stateMapping.get(state.status));
		}
		return applied;
	}
	
	/**
	 * Returns the BackupState applied to this comment
	 * @param comment - the comment containing the backup information
	 * @return state - the backup information
	 */
	public BackupState getBackupState(Comment comment){
		BackupState state = null; 
		if(this.isBackup(comment)){
			state = new BackupState();
			String timestamp = (String) comment.getValue(this.backupStereotype, BackupUtilConstants.BACKUP_TIMESTAMP_ATTR_NAME);
			if(timestamp!=null && !timestamp.isEmpty()){
				try{
					state.timestamp = Timestamp.valueOf(timestamp);
				}catch(Exception e){}
			}
			EnumerationLiteral literal = (EnumerationLiteral)comment.getValue(this.backupStereotype, BackupUtilConstants.BACKUP_STATE_ATTR_NAME);
			if(state!=null){
				state.status = this.inverseStateMapping.get(literal);
			}
		}
		return state;
	}
	
	/**
	 * Applies the backup profile over the model owning the context element provided as a parameter
	 * @param context - the context element
	 * @return true if the profile was applied
	 */
	public boolean applyBackupProfile(Element context){
		if(this.backupProfile==null){
			this.backupProfile = this.getBackupProfile(context);
		}
		return PackageUtil.applyProfile((Package)context.getModel(), this.backupProfile, true);
	}
	
	/**
	 * Returns whether the backup profile is applied over the context model
	 * @param context - the UML element used as context
	 * @return true if the profile is applied
	 */
	public boolean isBackupProfileApplied(Element context){
		return context.getModel().getAllAppliedProfiles().contains(this.backupProfile);
	}
	
	public Comment getBackupComment(Element element){
		Comment comment = null;
		Iterator<Comment> iteratorComments = element.getOwnedComments().iterator();
		while(iteratorComments.hasNext() && comment==null){
			Comment current = iteratorComments.next();
			if(current.getAppliedStereotypes().contains(this.backupStereotype)){
				comment = current;
			}
		}
		return comment;
	}
	
	public Enumeration getBackupState(Element context){
		if(this.backupStateEnumeration==null){
			this.getBackupProfile(context);
		}
		return this.backupStateEnumeration;
	}
	
	public class BackupUtilConstants{
		public static final String BACKUP_PROFILE_NAME = "TextualRepresentationBackup";
		public static final String BACKUP_STEREOTYPE_NAME = "Backup";
		public static final String BACKUP_BACKUP_STATE_ENUMERATION_NAME = "BackupState";
		public static final String BACKUP_TIMESTAMP_ATTR_NAME = "timestamp";
		public static final String BACKUP_STATE_ATTR_NAME = "state";
	}
}
