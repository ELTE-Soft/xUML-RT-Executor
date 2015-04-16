package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehaviorMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.ContainerClassOfBehavior pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ContainerClassOfBehaviorProcessor implements IMatchProcessor<ContainerClassOfBehaviorMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBehavior the value of pattern parameter behavior in the currently processed match
   * @param pContainerClassName the value of pattern parameter containerClassName in the currently processed match
   * 
   */
  public abstract void process(final Behavior pBehavior, final String pContainerClassName);
  
  @Override
  public void process(final ContainerClassOfBehaviorMatch match) {
    process(match.getBehavior(), match.getContainerClassName());
    
  }
}