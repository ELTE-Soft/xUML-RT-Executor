package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.AssociationOtherEndMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.AssociationOtherEnd pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationOtherEndProcessor implements IMatchProcessor<AssociationOtherEndMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pEnd the value of pattern parameter end in the currently processed match
   * @param pOtherEnd the value of pattern parameter otherEnd in the currently processed match
   * 
   */
  public abstract void process(final Property pEnd, final Property pOtherEnd);
  
  @Override
  public void process(final AssociationOtherEndMatch match) {
    process(match.getEnd(), match.getOtherEnd());
    
  }
}
