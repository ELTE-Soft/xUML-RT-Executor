package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ForbiddenComponentMemberMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Element;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ForbiddenComponentMember pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ForbiddenComponentMemberProcessor implements IMatchProcessor<ForbiddenComponentMemberMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCp the value of pattern parameter cp in the currently processed match
   * @param pElem the value of pattern parameter elem in the currently processed match
   * 
   */
  public abstract void process(final Component pCp, final Element pElem);
  
  @Override
  public void process(final ForbiddenComponentMemberMatch match) {
    process(match.getCp(), match.getElem());
  }
}
