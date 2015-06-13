package hu.eltesoft.modelexecution.m2m.logic.translators;

import hu.eltesoft.modelexecution.m2m.logic.translators.base.AbstractFeatureNode;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootElementTranslator;
import hu.eltesoft.modelexecution.m2m.logic.translators.base.RootNode;
import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociation;
import hu.eltesoft.modelexecution.m2m.metamodel.association.AsAssociationEnd;
import hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationFactory;
import hu.eltesoft.modelexecution.m2m.metamodel.association.AssociationPackage;
import hu.eltesoft.modelexecution.m2m.metamodel.base.NamedReference;
import hu.eltesoft.modelexecution.m2m.metamodel.base.Type;
import hu.eltesoft.modelexecution.m2t.java.Template;
import hu.eltesoft.modelexecution.m2t.java.templates.AssociationTemplate;
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndMatch;
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndTypeMatch;
import hu.eltesoft.modelexecution.uml.incquery.AssociationEndTypeMatcher;
import hu.eltesoft.modelexecution.uml.incquery.AssociationMatch;
import hu.eltesoft.modelexecution.uml.incquery.AssociationMatcher;
import java.util.function.Function;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

@SuppressWarnings("all")
public class AssociationTranslator extends RootElementTranslator<Association, AsAssociation, AssociationMatch> {
  private final static AssociationFactory FACTORY = AssociationFactory.eINSTANCE;
  
  private final static AssociationPackage PACKAGE = AssociationPackage.eINSTANCE;
  
  public AssociationTranslator(final IncQueryEngine engine) throws IncQueryException {
    super(engine);
  }
  
  protected RootNode<Association, AsAssociation, AssociationMatch> buildMapper(final IncQueryEngine engine) throws IncQueryException {
    AssociationMatcher _on = AssociationMatcher.on(engine);
    final Function<AssociationMatch, AsAssociation> _function = new Function<AssociationMatch, AsAssociation>() {
      public AsAssociation apply(final AssociationMatch it) {
        final AsAssociation root = AssociationTranslator.FACTORY.createAsAssociation();
        Association _association = it.getAssociation();
        NamedReference _namedReference = new NamedReference(_association);
        root.setReference(_namedReference);
        return root;
      }
    };
    final RootNode<Association, AsAssociation, AssociationMatch> rootNode = this.fromRoot(_on, _function);
    EReference _asAssociation_Ends = AssociationTranslator.PACKAGE.getAsAssociation_Ends();
    AssociationEndMatcher _on_1 = AssociationEndMatcher.on(engine);
    final Function<AssociationEndMatch, AsAssociationEnd> _function_1 = new Function<AssociationEndMatch, AsAssociationEnd>() {
      public AsAssociationEnd apply(final AssociationEndMatch it) {
        final AsAssociationEnd elem = AssociationTranslator.FACTORY.createAsAssociationEnd();
        Property _end = it.getEnd();
        NamedReference _namedReference = new NamedReference(_end);
        elem.setReference(_namedReference);
        return elem;
      }
    };
    final AbstractFeatureNode<AsAssociationEnd, AssociationEndMatch> endNode = rootNode.<AsAssociationEnd, AssociationEndMatch>onEObject(_asAssociation_Ends, _on_1, _function_1);
    EReference _asAssociationEnd_Type = AssociationTranslator.PACKAGE.getAsAssociationEnd_Type();
    AssociationEndTypeMatcher _on_2 = AssociationEndTypeMatcher.on(engine);
    final Function<AssociationEndTypeMatch, Type> _function_2 = new Function<AssociationEndTypeMatch, Type>() {
      public Type apply(final AssociationEndTypeMatch it) {
        org.eclipse.uml2.uml.Class _cls = it.getCls();
        return AssociationTranslator.this.convert(_cls);
      }
    };
    endNode.<Type, AssociationEndTypeMatch>on(_asAssociationEnd_Type, _on_2, _function_2);
    return rootNode;
  }
  
  public Template createTemplate(final AsAssociation association) {
    return new AssociationTemplate(association);
  }
}
