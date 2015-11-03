package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.InitialPseudostateNotPublicMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Pseudostate;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.InitialPseudostateNotPublic pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class InitialPseudostateNotPublicProcessor implements IMatchProcessor<InitialPseudostateNotPublicMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPs the value of pattern parameter ps in the currently processed match
   * 
   */
  public abstract void process(final Pseudostate pPs);
  
  @Override
  public void process(final InitialPseudostateNotPublicMatch match) {
    process(match.getPs());
  }
}
