package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.TransitionMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.Transition pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TransitionProcessor implements IMatchProcessor<TransitionMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRegion the value of pattern parameter region in the currently processed match
   * @param pSource the value of pattern parameter source in the currently processed match
   * @param pTransition the value of pattern parameter transition in the currently processed match
   * @param pEventName the value of pattern parameter eventName in the currently processed match
   * @param pMessageName the value of pattern parameter messageName in the currently processed match
   * @param pTarget the value of pattern parameter target in the currently processed match
   * 
   */
  public abstract void process(final Region pRegion, final State pSource, final Transition pTransition, final String pEventName, final String pMessageName, final State pTarget);
  
  @Override
  public void process(final TransitionMatch match) {
    process(match.getRegion(), match.getSource(), match.getTransition(), match.getEventName(), match.getMessageName(), match.getTarget());
    
  }
}
