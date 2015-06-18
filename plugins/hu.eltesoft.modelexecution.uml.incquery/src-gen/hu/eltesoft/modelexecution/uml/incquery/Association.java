package hu.eltesoft.modelexecution.uml.incquery;

import hu.eltesoft.modelexecution.uml.incquery.AssociationEndMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AssociationMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AssociationOtherEndMatcher;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationEndQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationEndTypeQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationOtherEndQuerySpecification;
import hu.eltesoft.modelexecution.uml.incquery.util.AssociationQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in association.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file association.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package hu.eltesoft.modelexecution.uml.incquery, the group contains the definition of the following patterns: <ul>
 * <li>Association</li>
 * <li>AssociationEnd</li>
 * <li>AssociationEndType</li>
 * <li>AssociationOtherEnd</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Association extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Association instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Association();
    }
    return INSTANCE;
    
  }
  
  private static Association INSTANCE;
  
  private Association() throws IncQueryException {
    querySpecifications.add(AssociationQuerySpecification.instance());
    querySpecifications.add(AssociationEndQuerySpecification.instance());
    querySpecifications.add(AssociationEndTypeQuerySpecification.instance());
    querySpecifications.add(AssociationOtherEndQuerySpecification.instance());
    
  }
  
  public AssociationQuerySpecification getAssociation() throws IncQueryException {
    return AssociationQuerySpecification.instance();
  }
  
  public AssociationMatcher getAssociation(final IncQueryEngine engine) throws IncQueryException {
    return AssociationMatcher.on(engine);
  }
  
  public AssociationEndQuerySpecification getAssociationEnd() throws IncQueryException {
    return AssociationEndQuerySpecification.instance();
  }
  
  public AssociationEndMatcher getAssociationEnd(final IncQueryEngine engine) throws IncQueryException {
    return AssociationEndMatcher.on(engine);
  }
  
  public AssociationEndTypeQuerySpecification getAssociationEndType() throws IncQueryException {
    return AssociationEndTypeQuerySpecification.instance();
  }
  
  public AssociationEndTypeMatcher getAssociationEndType(final IncQueryEngine engine) throws IncQueryException {
    return AssociationEndTypeMatcher.on(engine);
  }
  
  public AssociationOtherEndQuerySpecification getAssociationOtherEnd() throws IncQueryException {
    return AssociationOtherEndQuerySpecification.instance();
  }
  
  public AssociationOtherEndMatcher getAssociationOtherEnd(final IncQueryEngine engine) throws IncQueryException {
    return AssociationOtherEndMatcher.on(engine);
  }
}
