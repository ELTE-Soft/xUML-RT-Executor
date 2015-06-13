package hu.eltesoft.modelexecution.uml.incquery.util;

import hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBoundMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * A match processor tailored for the hu.eltesoft.modelexecution.uml.incquery.AttributeUpperBound pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class AttributeUpperBoundProcessor implements IMatchProcessor<AttributeUpperBoundMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCls the value of pattern parameter cls in the currently processed match
   * @param pAttribute the value of pattern parameter attribute in the currently processed match
   * @param pType the value of pattern parameter type in the currently processed match
   * @param pUpperBound the value of pattern parameter upperBound in the currently processed match
   * 
   */
  public abstract void process(final org.eclipse.uml2.uml.Class pCls, final Property pAttribute, final Type pType, final ValueSpecification pUpperBound);
  
  @Override
  public void process(final AttributeUpperBoundMatch match) {
    process(match.getCls(), match.getAttribute(), match.getType(), match.getUpperBound());
    
  }
}
