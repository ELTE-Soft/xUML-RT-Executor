package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.MethodNotPublicMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.OpaqueBehavior;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.MethodNotPublic pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MethodNotPublicProcessor implements IMatchProcessor<MethodNotPublicMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pMe the value of pattern parameter me in the currently processed match
   * 
   */
  public abstract void process(final OpaqueBehavior pMe);
  
  @Override
  public void process(final MethodNotPublicMatch match) {
    process(match.getMe());
  }
}
