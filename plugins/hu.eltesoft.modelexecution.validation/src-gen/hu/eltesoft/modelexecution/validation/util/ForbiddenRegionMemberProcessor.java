package hu.eltesoft.modelexecution.validation.util;

import hu.eltesoft.modelexecution.validation.ForbiddenRegionMemberMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Region;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.validation.ForbiddenRegionMember pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ForbiddenRegionMemberProcessor implements IMatchProcessor<ForbiddenRegionMemberMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pRg the value of pattern parameter rg in the currently processed match
   * @param pElem the value of pattern parameter elem in the currently processed match
   * 
   */
  public abstract void process(final Region pRg, final Element pElem);
  
  @Override
  public void process(final ForbiddenRegionMemberMatch match) {
    process(match.getRg(), match.getElem());
  }
}
