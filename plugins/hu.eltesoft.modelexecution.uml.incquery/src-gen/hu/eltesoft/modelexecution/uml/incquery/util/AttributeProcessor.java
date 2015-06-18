package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.AttributeMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Property;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.Attribute pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AttributeProcessor implements IMatchProcessor<AttributeMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pAttribute the value of pattern parameter attribute in the currently processed match
   * @param pIsStatic the value of pattern parameter isStatic in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Boolean pIsStatic);
  
  @Override
  public void process(final AttributeMatch match) {
    process(match.getCls(), match.getAttribute(), match.getIsStatic());
    
  }
}
