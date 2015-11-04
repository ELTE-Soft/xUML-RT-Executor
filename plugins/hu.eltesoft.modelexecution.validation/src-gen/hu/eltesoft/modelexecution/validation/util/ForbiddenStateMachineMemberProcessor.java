package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ForbiddenStateMachineMemberMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.StateMachine;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ForbiddenStateMachineMember pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ForbiddenStateMachineMemberProcessor implements IMatchProcessor<ForbiddenStateMachineMemberMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSm the value of pattern parameter sm in the currently processed match
   * @param pElem the value of pattern parameter elem in the currently processed match
   * 
   */
  public abstract void process(final StateMachine pSm, final Element pElem);
  
  @Override
  public void process(final ForbiddenStateMachineMemberMatch match) {
    process(match.getSm(), match.getElem());
  }
}
