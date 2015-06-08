package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.AssociationMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

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
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pAssociation the value of pattern parameter association in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * @param pLower the value of pattern parameter lower in the currently processed match
   * @param pUpper the value of pattern parameter upper in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Association pAssociation, final Type pType, final ValueSpecification pLower, final ValueSpecification pUpper);
  
  @Override
  public void process(final AssociationMatch match) {
    process(match.getCls(), match.getAssociation(), match.getType(), match.getLower(), match.getUpper());
    
  }
}
