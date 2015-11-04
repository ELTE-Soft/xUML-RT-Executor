package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.AssociationNonPublicMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Association;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.AssociationNonPublic pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationNonPublicProcessor implements IMatchProcessor<AssociationNonPublicMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pAc the value of pattern parameter ac in the currently processed match
   * 
   */
  public abstract void process(final Association pAc);
  
  @Override
  public void process(final AssociationNonPublicMatch match) {
    process(match.getAc());
  }
}
