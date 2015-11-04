package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.RedefinedStaticMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Operation;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.RedefinedStatic pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class RedefinedStaticProcessor implements IMatchProcessor<RedefinedStaticMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pOp the value of pattern parameter op in the currently processed match
   * @param pRedefined the value of pattern parameter redefined in the currently processed match
   * 
   */
  public abstract void process(final Operation pOp, final Operation pRedefined);
  
  @Override
  public void process(final RedefinedStaticMatch match) {
    process(match.getOp(), match.getRedefined());
  }
}
