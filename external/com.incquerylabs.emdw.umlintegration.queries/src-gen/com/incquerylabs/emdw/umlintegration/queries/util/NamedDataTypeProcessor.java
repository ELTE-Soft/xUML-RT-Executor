package com.incquerylabs.emdw.umlintegration.queries.util;

import com.incquerylabs.emdw.umlintegration.queries.NamedDataTypeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.DataType;

/**
 * A match processor tailored for the com.incquerylabs.emdw.umlintegration.queries.namedDataType pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class NamedDataTypeProcessor implements IMatchProcessor<NamedDataTypeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pDataType the value of pattern parameter dataType in the currently processed match
   * @param pName the value of pattern parameter name in the currently processed match
   * 
   */
  public abstract void process(final DataType pDataType, final String pName);
  
  @Override
  public void process(final NamedDataTypeMatch match) {
    process(match.getDataType(), match.getName());
  }
}
