package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.InitialsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.Initials pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InitialsProcessor implements IMatchProcessor<InitialsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRegion the value of pattern parameter region in the currently processed match
   * @param pInitPseudostate the value of pattern parameter initPseudostate in the currently processed match
   * @param pInitTransition the value of pattern parameter initTransition in the currently processed match
   * @param pFirstState the value of pattern parameter firstState in the currently processed match
   * 
   */
  public abstract void process(final Region pRegion, final Pseudostate pInitPseudostate, final Transition pInitTransition, final State pFirstState);
  
  @Override
  public void process(final InitialsMatch match) {
    process(match.getRegion(), match.getInitPseudostate(), match.getInitTransition(), match.getFirstState());
    
  }
}
