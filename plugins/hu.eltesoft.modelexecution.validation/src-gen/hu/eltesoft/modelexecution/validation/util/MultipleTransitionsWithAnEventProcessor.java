package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.MultipleTransitionsWithAnEventMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Transition;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.MultipleTransitionsWithAnEvent pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MultipleTransitionsWithAnEventProcessor implements IMatchProcessor<MultipleTransitionsWithAnEventMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTr1 the value of pattern parameter tr1 in the currently processed match
   * @param pTr2 the value of pattern parameter tr2 in the currently processed match
   * @param pSrc the value of pattern parameter src in the currently processed match
   * @param pEv the value of pattern parameter ev in the currently processed match
   * 
   */
  public abstract void process(final Transition pTr1, final Transition pTr2, final State pSrc, final Event pEv);
  
  @Override
  public void process(final MultipleTransitionsWithAnEventMatch match) {
    process(match.getTr1(), match.getTr2(), match.getSrc(), match.getEv());
  }
}
