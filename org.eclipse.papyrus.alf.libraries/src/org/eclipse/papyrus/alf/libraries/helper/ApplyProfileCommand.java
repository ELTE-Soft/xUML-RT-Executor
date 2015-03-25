/*****************************************************************************
 * Copyright (c) 2015 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Jeremie Tatibouet (CEA LIST)
 *   
 *****************************************************************************/
package org.eclipse.papyrus.alf.libraries.helper;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;

public class ApplyProfileCommand extends AbstractTransactionalCommand {

	public static final String NAME = "ApplyProfile";
	
	protected Profile profile;
	
	protected Model context;
	
	public ApplyProfileCommand(Profile profile, Model context){
		super(TransactionUtil.getEditingDomain(context), NAME, Collections.EMPTY_LIST);
		this.profile = profile;
		this.context = context;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(PackageUtil.applyProfile((org.eclipse.uml2.uml.Package)this.context, this.profile, true)){
			return CommandResult.newOKCommandResult();
		}
		return CommandResult.newErrorCommandResult("Profile "+this.profile.getName()+" could not be applied");
	}
}
