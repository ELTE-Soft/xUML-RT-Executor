package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.MultipleInitialTransitionsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Transition;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.MultipleInitialTransitions pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MultipleInitialTransitionsProcessor implements IMatchProcessor<MultipleInitialTransitionsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSrc the value of pattern parameter src in the currently processed match
   * @param pTr1 the value of pattern parameter tr1 in the currently processed match
   * @param pTr2 the value of pattern parameter tr2 in the currently processed match
   * 
   */
  public abstract void process(final Pseudostate pSrc, final Transition pTr1, final Transition pTr2);
  
  @Override
  public void process(final MultipleInitialTransitionsMatch match) {
    process(match.getSrc(), match.getTr1(), match.getTr2());
  }
}
