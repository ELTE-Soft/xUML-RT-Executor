package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.MultipleInitialStateMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.MultipleInitialState pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MultipleInitialStateProcessor implements IMatchProcessor<MultipleInitialStateMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRg the value of pattern parameter rg in the currently processed match
   * @param pInit1 the value of pattern parameter init1 in the currently processed match
   * @param pInit2 the value of pattern parameter init2 in the currently processed match
   * 
   */
  public abstract void process(final Region pRg, final Pseudostate pInit1, final Pseudostate pInit2);
  
  @Override
  public void process(final MultipleInitialStateMatch match) {
    process(match.getRg(), match.getInit1(), match.getInit2());
  }
}
