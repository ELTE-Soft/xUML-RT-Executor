package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.StructMemberMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.structMember pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class StructMemberProcessor implements IMatchProcessor<StructMemberMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pStructType the value of pattern parameter structType in the currently processed match
   * @param pMember the value of pattern parameter member in the currently processed match
   * 
   */
  public abstract void process(final DataType pStructType, final Property pMember);
  
  @Override
  public void process(final StructMemberMatch match) {
    process(match.getStructType(), match.getMember());
  }
}
