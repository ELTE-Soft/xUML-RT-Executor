package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ComponentDirectlyInstantiatedMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Component;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ComponentDirectlyInstantiated pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ComponentDirectlyInstantiatedProcessor implements IMatchProcessor<ComponentDirectlyInstantiatedMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCp the value of pattern parameter cp in the currently processed match
   * 
   */
  public abstract void process(final Component pCp);
  
  @Override
  public void process(final ComponentDirectlyInstantiatedMatch match) {
    process(match.getCp());
  }
}
