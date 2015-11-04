package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.RedefinedOperationParameterNumMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.RedefinedOperationParameterNum pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class RedefinedOperationParameterNumProcessor implements IMatchProcessor<RedefinedOperationParameterNumMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRedefined the value of pattern parameter redefined in the currently processed match
   * @param pRedefiner the value of pattern parameter redefiner in the currently processed match
   * @param pRedefinerParams the value of pattern parameter redefinerParams in the currently processed match
   * @param pRedefinedParams the value of pattern parameter redefinedParams in the currently processed match
   * 
   */
  public abstract void process(final Operation pRedefined, final Operation pRedefiner, final Integer pRedefinerParams, final Integer pRedefinedParams);
  
  @Override
  public void process(final RedefinedOperationParameterNumMatch match) {
    process(match.getRedefined(), match.getRedefiner(), match.getRedefinerParams(), match.getRedefinedParams());
  }
}
