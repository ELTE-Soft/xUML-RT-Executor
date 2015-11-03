package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.GeneralizationOfAssocClassMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.AssociationClass;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.GeneralizationOfAssocClass pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GeneralizationOfAssocClassProcessor implements IMatchProcessor<GeneralizationOfAssocClassMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pAc the value of pattern parameter ac in the currently processed match
   * @param pSpec the value of pattern parameter spec in the currently processed match
   * 
   */
  public abstract void process(final AssociationClass pAc, final org.eclipse.uml2.uml.Class pSpec);
  
  @Override
  public void process(final GeneralizationOfAssocClassMatch match) {
    process(match.getAc(), match.getSpec());
  }
}
