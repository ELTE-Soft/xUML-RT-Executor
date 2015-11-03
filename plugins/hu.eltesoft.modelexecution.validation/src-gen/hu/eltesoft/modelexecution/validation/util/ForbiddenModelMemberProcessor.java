package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ForbiddenModelMemberMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ForbiddenModelMember pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ForbiddenModelMemberProcessor implements IMatchProcessor<ForbiddenModelMemberMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pMd the value of pattern parameter md in the currently processed match
   * @param pElem the value of pattern parameter elem in the currently processed match
   * 
   */
  public abstract void process(final Model pMd, final Element pElem);
  
  @Override
  public void process(final ForbiddenModelMemberMatch match) {
    process(match.getMd(), match.getElem());
  }
}
