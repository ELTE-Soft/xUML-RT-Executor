package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.AssociationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Association;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.Association pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationProcessor implements IMatchProcessor<AssociationMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pAssociation the value of pattern parameter association in the currently processed match
   * 
   */
  public abstract void process(final Association pAssociation);
  
  @Override
  public void process(final AssociationMatch match) {
    process(match.getAssociation());
    
  }
}
