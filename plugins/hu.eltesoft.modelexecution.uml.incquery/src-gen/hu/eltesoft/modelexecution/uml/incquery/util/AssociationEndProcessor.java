package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.AssociationEndMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.AssociationEnd pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationEndProcessor implements IMatchProcessor<AssociationEndMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pAssociation the value of pattern parameter association in the currently processed match
   * @param pEnd the value of pattern parameter end in the currently processed match
   * 
   */
  public abstract void process(final Association pAssociation, final Property pEnd);
  
  @Override
  public void process(final AssociationEndMatch match) {
    process(match.getAssociation(), match.getEnd());
    
  }
}
