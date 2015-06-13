package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.AssociationEndUpperBoundMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.AssociationEndUpperBound pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AssociationEndUpperBoundProcessor implements IMatchProcessor<AssociationEndUpperBoundMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pAssociation the value of pattern parameter association in the currently processed match
   * @param pEnd the value of pattern parameter end in the currently processed match
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pUpperBound the value of pattern parameter upperBound in the currently processed match
   * 
   */
  public abstract void process(final Association pAssociation, final Property pEnd, final org.eclipse.uml2.uml.Class pCls, final ValueSpecification pUpperBound);
  
  @Override
  public void process(final AssociationEndUpperBoundMatch match) {
    process(match.getAssociation(), match.getEnd(), match.getCls(), match.getUpperBound());
    
  }
}
