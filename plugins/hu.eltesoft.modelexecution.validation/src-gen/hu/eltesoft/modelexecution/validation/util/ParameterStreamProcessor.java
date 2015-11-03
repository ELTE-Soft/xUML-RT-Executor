package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ParameterStreamMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Parameter;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ParameterStream pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ParameterStreamProcessor implements IMatchProcessor<ParameterStreamMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pPm the value of pattern parameter pm in the currently processed match
   * 
   */
  public abstract void process(final Parameter pPm);
  
  @Override
  public void process(final ParameterStreamMatch match) {
    process(match.getPm());
  }
}
