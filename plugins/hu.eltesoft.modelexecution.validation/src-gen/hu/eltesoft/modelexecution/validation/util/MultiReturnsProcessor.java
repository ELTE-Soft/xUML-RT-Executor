package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.MultiReturnsMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Parameter;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.MultiReturns pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class MultiReturnsProcessor implements IMatchProcessor<MultiReturnsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pBf the value of pattern parameter bf in the currently processed match
   * @param pPm1 the value of pattern parameter pm1 in the currently processed match
   * @param pPm2 the value of pattern parameter pm2 in the currently processed match
   * 
   */
  public abstract void process(final BehavioralFeature pBf, final Parameter pPm1, final Parameter pPm2);
  
  @Override
  public void process(final MultiReturnsMatch match) {
    process(match.getBf(), match.getPm1(), match.getPm2());
  }
}
