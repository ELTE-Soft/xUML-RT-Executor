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
 *  Jeremie Tatibouet (CEA LIST)
 * 
 *****************************************************************************/
package org.eclipse.papyrus.alf.libraries.helper;

import java.sql.Timestamp;

public class BackupState {

	public enum EditionStatus{NONE, SAVED, MERGED};
	
	public Timestamp timestamp;
	
	public EditionStatus status;
	
	public BackupState() {
		this.timestamp = null;
		this.status = EditionStatus.NONE;
	}

	public BackupState(Timestamp timestamp, EditionStatus status){
		this.timestamp = timestamp;
		this.status = status;
	}
}
