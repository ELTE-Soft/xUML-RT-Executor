package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.TransitionEffectMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.TransitionEffect pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TransitionEffectProcessor implements IMatchProcessor<TransitionEffectMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRegion the value of pattern parameter region in the currently processed match
   * @param pTransition the value of pattern parameter transition in the currently processed match
   * @param pEffect the value of pattern parameter effect in the currently processed match
   * 
   */
  public abstract void process(final Region pRegion, final Transition pTransition, final Behavior pEffect);
  
  @Override
  public void process(final TransitionEffectMatch match) {
    process(match.getRegion(), match.getTransition(), match.getEffect());
    
  }
}
