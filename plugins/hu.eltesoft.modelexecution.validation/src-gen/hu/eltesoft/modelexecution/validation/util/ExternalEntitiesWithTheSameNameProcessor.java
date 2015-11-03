package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ExternalEntitiesWithTheSameNameMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ExternalEntitiesWithTheSameName pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ExternalEntitiesWithTheSameNameProcessor implements IMatchProcessor<ExternalEntitiesWithTheSameNameMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCl1 the value of pattern parameter cl1 in the currently processed match
   * @param pCl2 the value of pattern parameter cl2 in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCl1, final org.eclipse.uml2.uml.Class pCl2);
  
  @Override
  public void process(final ExternalEntitiesWithTheSameNameMatch match) {
    process(match.getCl1(), match.getCl2());
  }
}
