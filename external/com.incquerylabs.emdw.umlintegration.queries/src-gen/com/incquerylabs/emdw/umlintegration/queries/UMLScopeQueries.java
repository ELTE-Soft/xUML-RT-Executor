package com.incquerylabs.emdw.umlintegration.queries;

import com.incquerylabs.emdw.umlintegration.queries.AssociationsOfClassMatcher;
import com.incquerylabs.emdw.umlintegration.queries.AttributesOfClassMatcher;
import com.incquerylabs.emdw.umlintegration.queries.SignalsMatcher;
import com.incquerylabs.emdw.umlintegration.queries.UmlTypesMatcher;
import com.incquerylabs.emdw.umlintegration.queries.util.AssociationsOfClassQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.AttributesOfClassQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.SignalsQuerySpecification;
import com.incquerylabs.emdw.umlintegration.queries.util.UmlTypesQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in UMLScopeQueries.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file UMLScopeQueries.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.emdw.umlintegration.queries, the group contains the definition of the following patterns: <ul>
 * <li>signals</li>
 * <li>umlTypes</li>
 * <li>attributesOfClass</li>
 * <li>associationsOfClass</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class UMLScopeQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static UMLScopeQueries instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new UMLScopeQueries();
    }
    return INSTANCE;
  }
  
  private static UMLScopeQueries INSTANCE;
  
  private UMLScopeQueries() throws IncQueryException {
    querySpecifications.add(SignalsQuerySpecification.instance());
    querySpecifications.add(UmlTypesQuerySpecification.instance());
    querySpecifications.add(AttributesOfClassQuerySpecification.instance());
    querySpecifications.add(AssociationsOfClassQuerySpecification.instance());
  }
  
  public SignalsQuerySpecification getSignals() throws IncQueryException {
    return SignalsQuerySpecification.instance();
  }
  
  public SignalsMatcher getSignals(final IncQueryEngine engine) throws IncQueryException {
    return SignalsMatcher.on(engine);
  }
  
  public UmlTypesQuerySpecification getUmlTypes() throws IncQueryException {
    return UmlTypesQuerySpecification.instance();
  }
  
  public UmlTypesMatcher getUmlTypes(final IncQueryEngine engine) throws IncQueryException {
    return UmlTypesMatcher.on(engine);
  }
  
  public AttributesOfClassQuerySpecification getAttributesOfClass() throws IncQueryException {
    return AttributesOfClassQuerySpecification.instance();
  }
  
  public AttributesOfClassMatcher getAttributesOfClass(final IncQueryEngine engine) throws IncQueryException {
    return AttributesOfClassMatcher.on(engine);
  }
  
  public AssociationsOfClassQuerySpecification getAssociationsOfClass() throws IncQueryException {
    return AssociationsOfClassQuerySpecification.instance();
  }
  
  public AssociationsOfClassMatcher getAssociationsOfClass(final IncQueryEngine engine) throws IncQueryException {
    return AssociationsOfClassMatcher.on(engine);
  }
}
