package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ComponentNonPublicMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Component;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ComponentNonPublic pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ComponentNonPublicProcessor implements IMatchProcessor<ComponentNonPublicMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCp the value of pattern parameter cp in the currently processed match
   * 
   */
  public abstract void process(final Component pCp);
  
  @Override
  public void process(final ComponentNonPublicMatch match) {
    process(match.getCp());
  }
}
