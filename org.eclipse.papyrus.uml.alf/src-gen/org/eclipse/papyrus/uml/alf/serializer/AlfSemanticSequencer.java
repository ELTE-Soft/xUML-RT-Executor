package org.eclipse.papyrus.uml.alf.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.AcceptBlock;
import org.eclipse.papyrus.uml.alf.AcceptStatement;
import org.eclipse.papyrus.uml.alf.ActiveClassDefinition;
import org.eclipse.papyrus.uml.alf.ActivityDefinition;
import org.eclipse.papyrus.uml.alf.AlfPackage;
import org.eclipse.papyrus.uml.alf.AnnotatedStatement;
import org.eclipse.papyrus.uml.alf.ArithmeticExpression;
import org.eclipse.papyrus.uml.alf.AssignmentExpression;
import org.eclipse.papyrus.uml.alf.AssociationDefinition;
import org.eclipse.papyrus.uml.alf.BehaviorInvocationExpression;
import org.eclipse.papyrus.uml.alf.BitStringUnaryExpression;
import org.eclipse.papyrus.uml.alf.Block;
import org.eclipse.papyrus.uml.alf.BlockStatement;
import org.eclipse.papyrus.uml.alf.BooleanLiteralExpression;
import org.eclipse.papyrus.uml.alf.BooleanUnaryExpression;
import org.eclipse.papyrus.uml.alf.BreakStatement;
import org.eclipse.papyrus.uml.alf.CastExpression;
import org.eclipse.papyrus.uml.alf.ClassDefinition;
import org.eclipse.papyrus.uml.alf.ClassExtentExpression;
import org.eclipse.papyrus.uml.alf.ClassificationExpression;
import org.eclipse.papyrus.uml.alf.ClassifierDefinition;
import org.eclipse.papyrus.uml.alf.ClassifierTemplateParameter;
import org.eclipse.papyrus.uml.alf.ClassifyStatement;
import org.eclipse.papyrus.uml.alf.ConcurrentClauses;
import org.eclipse.papyrus.uml.alf.ConditionalLogicalExpression;
import org.eclipse.papyrus.uml.alf.ConditionalTestExpression;
import org.eclipse.papyrus.uml.alf.DataTypeDefinition;
import org.eclipse.papyrus.uml.alf.DoStatement;
import org.eclipse.papyrus.uml.alf.ElementImportReference;
import org.eclipse.papyrus.uml.alf.EmptyStatement;
import org.eclipse.papyrus.uml.alf.EnumerationDefinition;
import org.eclipse.papyrus.uml.alf.EnumerationLiteralName;
import org.eclipse.papyrus.uml.alf.EqualityExpression;
import org.eclipse.papyrus.uml.alf.ExpressionStatement;
import org.eclipse.papyrus.uml.alf.ExtentOrExpression;
import org.eclipse.papyrus.uml.alf.FeatureInvocationExpression;
import org.eclipse.papyrus.uml.alf.FeatureLeftHandSide;
import org.eclipse.papyrus.uml.alf.FeatureReference;
import org.eclipse.papyrus.uml.alf.ForStatement;
import org.eclipse.papyrus.uml.alf.IfStatement;
import org.eclipse.papyrus.uml.alf.InLineStatement;
import org.eclipse.papyrus.uml.alf.IncrementOrDecrementExpression;
import org.eclipse.papyrus.uml.alf.InstanceCreationExpression;
import org.eclipse.papyrus.uml.alf.IsolationExpression;
import org.eclipse.papyrus.uml.alf.LinkOperationExpression;
import org.eclipse.papyrus.uml.alf.LocalNameDeclarationStatement;
import org.eclipse.papyrus.uml.alf.LogicalExpression;
import org.eclipse.papyrus.uml.alf.LoopVariableDefinition;
import org.eclipse.papyrus.uml.alf.Member;
import org.eclipse.papyrus.uml.alf.NameBinding;
import org.eclipse.papyrus.uml.alf.NameExpression;
import org.eclipse.papyrus.uml.alf.NameLeftHandSide;
import org.eclipse.papyrus.uml.alf.NamedExpression;
import org.eclipse.papyrus.uml.alf.NamedTemplateBinding;
import org.eclipse.papyrus.uml.alf.NamedTuple;
import org.eclipse.papyrus.uml.alf.NaturalLiteralExpression;
import org.eclipse.papyrus.uml.alf.NonFinalClause;
import org.eclipse.papyrus.uml.alf.NonReturnParameter;
import org.eclipse.papyrus.uml.alf.NumericUnaryExpression;
import org.eclipse.papyrus.uml.alf.OperationDefinition;
import org.eclipse.papyrus.uml.alf.PackageDefinition;
import org.eclipse.papyrus.uml.alf.PackageImportReference;
import org.eclipse.papyrus.uml.alf.PositionalTemplateBinding;
import org.eclipse.papyrus.uml.alf.PositionalTuple;
import org.eclipse.papyrus.uml.alf.PropertyAccessExpression;
import org.eclipse.papyrus.uml.alf.PropertyDefinition;
import org.eclipse.papyrus.uml.alf.QualifiedName;
import org.eclipse.papyrus.uml.alf.QualifiedNameList;
import org.eclipse.papyrus.uml.alf.ReceptionDefinition;
import org.eclipse.papyrus.uml.alf.RelationalExpression;
import org.eclipse.papyrus.uml.alf.ReturnParameter;
import org.eclipse.papyrus.uml.alf.ReturnStatement;
import org.eclipse.papyrus.uml.alf.SequenceAccessExpression;
import org.eclipse.papyrus.uml.alf.SequenceConstructionExpression;
import org.eclipse.papyrus.uml.alf.SequenceExpansionExpression;
import org.eclipse.papyrus.uml.alf.SequenceExpressionList;
import org.eclipse.papyrus.uml.alf.SequenceOperationExpression;
import org.eclipse.papyrus.uml.alf.SequenceRange;
import org.eclipse.papyrus.uml.alf.SequenceReductionExpression;
import org.eclipse.papyrus.uml.alf.ShiftExpression;
import org.eclipse.papyrus.uml.alf.SignalDefinition;
import org.eclipse.papyrus.uml.alf.SignalReceptionDefinition;
import org.eclipse.papyrus.uml.alf.StereotypeAnnotation;
import org.eclipse.papyrus.uml.alf.StringLiteralExpression;
import org.eclipse.papyrus.uml.alf.SuperInvocationExpression;
import org.eclipse.papyrus.uml.alf.SwitchClause;
import org.eclipse.papyrus.uml.alf.SwitchStatement;
import org.eclipse.papyrus.uml.alf.TaggedValue;
import org.eclipse.papyrus.uml.alf.TaggedValueList;
import org.eclipse.papyrus.uml.alf.TemplateParameterSubstitution;
import org.eclipse.papyrus.uml.alf.ThisExpression;
import org.eclipse.papyrus.uml.alf.TypedElementDefinition;
import org.eclipse.papyrus.uml.alf.UnboundedLiteralExpression;
import org.eclipse.papyrus.uml.alf.UnitDefinition;
import org.eclipse.papyrus.uml.alf.WhileStatement;
import org.eclipse.papyrus.uml.alf.services.AlfGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public class AlfSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AlfGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == AlfPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case AlfPackage.ACCEPT_BLOCK:
				if(context == grammarAccess.getAcceptBlockRule()) {
					sequence_AcceptBlock_AcceptClause(context, (AcceptBlock) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAcceptClauseRule()) {
					sequence_AcceptClause(context, (AcceptBlock) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ACCEPT_STATEMENT:
				if(context == grammarAccess.getAcceptStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_AcceptStatement(context, (AcceptStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ACTIVE_CLASS_DEFINITION:
				if(context == grammarAccess.getActiveClassDeclarationRule()) {
					sequence_ActiveClassDeclaration(context, (ActiveClassDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActiveClassDefinitionOrStubRule() ||
				   context == grammarAccess.getActiveClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassifierDefinitionOrStubRule() ||
				   context == grammarAccess.getPackagedElementDefinitionRule()) {
					sequence_ActiveClassDeclaration_ActiveClassDefinitionOrStub(context, (ActiveClassDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActiveClassDefinitionRule() ||
				   context == grammarAccess.getClassifierDefinitionRule() ||
				   context == grammarAccess.getNamespaceDefinitionRule()) {
					sequence_ActiveClassDeclaration_ActiveClassDefinition(context, (ActiveClassDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ACTIVITY_DEFINITION:
				if(context == grammarAccess.getActivityDeclarationRule()) {
					sequence_ActivityDeclaration(context, (ActivityDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActiveClassMemberDefinitionRule() ||
				   context == grammarAccess.getActivityDefinitionOrStubRule() ||
				   context == grammarAccess.getClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassifierDefinitionOrStubRule() ||
				   context == grammarAccess.getPackagedElementDefinitionRule()) {
					sequence_ActivityDeclaration_ActivityDefinitionOrStub(context, (ActivityDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActivityDefinitionRule() ||
				   context == grammarAccess.getClassifierDefinitionRule() ||
				   context == grammarAccess.getNamespaceDefinitionRule()) {
					sequence_ActivityDeclaration_ActivityDefinition(context, (ActivityDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getBehaviorClauseRule()) {
					sequence_BehaviorClause(context, (ActivityDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ANNOTATED_STATEMENT:
				if(context == grammarAccess.getAnnotatedStatementRule() ||
				   context == grammarAccess.getDocumentedStatementRule()) {
					sequence_AnnotatedStatement(context, (AnnotatedStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ARITHMETIC_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_AdditiveExpression_MultiplicativeExpression(context, (ArithmeticExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ASSIGNMENT_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAssignmentExpressionRule() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_AssignmentExpression(context, (AssignmentExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ASSOCIATION_DEFINITION:
				if(context == grammarAccess.getAssociationDeclarationRule()) {
					sequence_AssociationDeclaration(context, (AssociationDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActiveClassMemberDefinitionRule() ||
				   context == grammarAccess.getAssociationDefinitionOrStubRule() ||
				   context == grammarAccess.getClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassifierDefinitionOrStubRule() ||
				   context == grammarAccess.getPackagedElementDefinitionRule()) {
					sequence_AssociationDeclaration_AssociationDefinitionOrStub(context, (AssociationDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAssociationDefinitionRule() ||
				   context == grammarAccess.getClassifierDefinitionRule() ||
				   context == grammarAccess.getNamespaceDefinitionRule()) {
					sequence_AssociationDeclaration_AssociationDefinition(context, (AssociationDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.BEHAVIOR_INVOCATION_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getBehaviorInvocationExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_BehaviorInvocationExpression(context, (BehaviorInvocationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.BIT_STRING_UNARY_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getBitStringUnaryExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getNonPostfixNonCastUnaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_BitStringUnaryExpression(context, (BitStringUnaryExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.BLOCK:
				if(context == grammarAccess.getBlockRule()) {
					sequence_Block(context, (Block) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNonEmptyStatementSequenceRule() ||
				   context == grammarAccess.getSwitchDefaultClauseRule()) {
					sequence_NonEmptyStatementSequence(context, (Block) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getStatementSequenceRule()) {
					sequence_StatementSequence(context, (Block) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.BLOCK_STATEMENT:
				if(context == grammarAccess.getBlockStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_BlockStatement(context, (BlockStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.BOOLEAN_LITERAL_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getBooleanLiteralExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_BooleanLiteralExpression(context, (BooleanLiteralExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.BOOLEAN_UNARY_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getBooleanUnaryExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getNonPostfixNonCastUnaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_BooleanUnaryExpression(context, (BooleanUnaryExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.BREAK_STATEMENT:
				if(context == grammarAccess.getBreakStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_BreakStatement(context, (BreakStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CAST_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getCastExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_CastExpression(context, (CastExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASS_DEFINITION:
				if(context == grammarAccess.getClassDeclarationRule()) {
					sequence_ClassDeclaration(context, (ClassDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActiveClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassDefinitionOrStubRule() ||
				   context == grammarAccess.getClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassifierDefinitionOrStubRule() ||
				   context == grammarAccess.getPackagedElementDefinitionRule()) {
					sequence_ClassDeclaration_ClassDefinitionOrStub(context, (ClassDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getClassDefinitionRule() ||
				   context == grammarAccess.getClassifierDefinitionRule() ||
				   context == grammarAccess.getNamespaceDefinitionRule()) {
					sequence_ClassDeclaration_ClassDefinition(context, (ClassDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASS_EXTENT_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassExtentExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_ClassExtentExpression(context, (ClassExtentExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASSIFICATION_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_ClassificationExpression(context, (ClassificationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASSIFIER_DEFINITION:
				if(context == grammarAccess.getClassifierSignatureRule()) {
					sequence_ClassifierSignature(context, (ClassifierDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASSIFIER_TEMPLATE_PARAMETER:
				if(context == grammarAccess.getClassifierTemplateParameterDefinitionRule()) {
					sequence_ClassifierTemplateParameterDefinition(context, (ClassifierTemplateParameter) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CLASSIFY_STATEMENT:
				if(context == grammarAccess.getClassifyStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_ClassifyStatement(context, (ClassifyStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CONCURRENT_CLAUSES:
				if(context == grammarAccess.getConcurrentClausesRule()) {
					sequence_ConcurrentClauses(context, (ConcurrentClauses) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CONDITIONAL_LOGICAL_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_ConditionalAndExpression_ConditionalOrExpression(context, (ConditionalLogicalExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.CONDITIONAL_TEST_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_ConditionalExpression(context, (ConditionalTestExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.DATA_TYPE_DEFINITION:
				if(context == grammarAccess.getDataTypeDeclarationRule()) {
					sequence_DataTypeDeclaration(context, (DataTypeDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActiveClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassifierDefinitionOrStubRule() ||
				   context == grammarAccess.getDataTypeDefinitionOrStubRule() ||
				   context == grammarAccess.getPackagedElementDefinitionRule()) {
					sequence_DataTypeDeclaration_DataTypeDefinitionOrStub(context, (DataTypeDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getClassifierDefinitionRule() ||
				   context == grammarAccess.getDataTypeDefinitionRule() ||
				   context == grammarAccess.getNamespaceDefinitionRule()) {
					sequence_DataTypeDeclaration_DataTypeDefinition(context, (DataTypeDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.DO_STATEMENT:
				if(context == grammarAccess.getDoStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_DoStatement(context, (DoStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ELEMENT_IMPORT_REFERENCE:
				if(context == grammarAccess.getElementImportReferenceRule() ||
				   context == grammarAccess.getImportDeclarationRule()) {
					sequence_ElementImportReference(context, (ElementImportReference) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.EMPTY_STATEMENT:
				if(context == grammarAccess.getEmptyStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_EmptyStatement(context, (EmptyStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ENUMERATION_DEFINITION:
				if(context == grammarAccess.getEnumerationDeclarationRule()) {
					sequence_EnumerationDeclaration(context, (EnumerationDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActiveClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassifierDefinitionOrStubRule() ||
				   context == grammarAccess.getEnumerationDefinitionOrStubRule() ||
				   context == grammarAccess.getPackagedElementDefinitionRule()) {
					sequence_EnumerationDeclaration_EnumerationDefinitionOrStub(context, (EnumerationDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getClassifierDefinitionRule() ||
				   context == grammarAccess.getEnumerationDefinitionRule() ||
				   context == grammarAccess.getNamespaceDefinitionRule()) {
					sequence_EnumerationDeclaration_EnumerationDefinition(context, (EnumerationDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ENUMERATION_LITERAL_NAME:
				if(context == grammarAccess.getEnumerationLiteralNameDefinitionRule()) {
					sequence_EnumerationLiteralNameDefinition(context, (EnumerationLiteralName) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.EQUALITY_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_EqualityExpression(context, (EqualityExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.EXPRESSION_STATEMENT:
				if(context == grammarAccess.getExpressionStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_ExpressionStatement(context, (ExpressionStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.EXTENT_OR_EXPRESSION:
				if(context == grammarAccess.getPrimaryExpressionAccess().getSequenceExpansionExpressionPrimaryAction_1_2_2_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceOperationExpressionPrimaryAction_1_2_2_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceReductionExpressionPrimaryAction_1_2_2_1_0()) {
					sequence_PrimaryExpression_SequenceExpansionExpression_1_2_2_2_0_SequenceOperationExpression_1_2_2_0_0_SequenceReductionExpression_1_2_2_1_0(context, (ExtentOrExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSequenceOperationOrReductionOrExpansionExpressionAccess().getSequenceExpansionExpressionPrimaryAction_3_2_0() ||
				   context == grammarAccess.getSequenceOperationOrReductionOrExpansionExpressionAccess().getSequenceOperationExpressionPrimaryAction_3_0_0() ||
				   context == grammarAccess.getSequenceOperationOrReductionOrExpansionExpressionAccess().getSequenceReductionExpressionPrimaryAction_3_1_0()) {
					sequence_SequenceOperationOrReductionOrExpansionExpression_SequenceExpansionExpression_3_2_0_SequenceOperationExpression_3_0_0_SequenceReductionExpression_3_1_0(context, (ExtentOrExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.FEATURE_INVOCATION_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_PrimaryExpression_ThisExpression(context, (FeatureInvocationExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getThisExpressionRule()) {
					sequence_ThisExpression(context, (FeatureInvocationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.FEATURE_LEFT_HAND_SIDE:
				if(context == grammarAccess.getFeatureLeftHandSideRule() ||
				   context == grammarAccess.getLeftHandSideRule()) {
					sequence_FeatureLeftHandSide(context, (FeatureLeftHandSide) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.FEATURE_REFERENCE:
				if(context == grammarAccess.getPrimaryExpressionAccess().getFeatureInvocationExpressionTargetAction_1_0_3()) {
					sequence_PrimaryExpression_FeatureInvocationExpression_1_0_3(context, (FeatureReference) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPrimaryExpressionAccess().getPropertyAccessExpressionFeatureReferenceAction_1_1_3()) {
					sequence_PrimaryExpression_PropertyAccessExpression_1_1_3(context, (FeatureReference) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.FOR_STATEMENT:
				if(context == grammarAccess.getForStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_ForStatement(context, (ForStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.IF_STATEMENT:
				if(context == grammarAccess.getIfStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_IfStatement(context, (IfStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.IN_LINE_STATEMENT:
				if(context == grammarAccess.getInLineStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_InLineStatement(context, (InLineStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.INCREMENT_OR_DECREMENT_EXPRESSION:
				if(context == grammarAccess.getPostfixExpressionRule()) {
					sequence_PostfixExpression(context, (IncrementOrDecrementExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_PostfixExpression_PrefixExpression_UnaryExpression(context, (IncrementOrDecrementExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNonPostfixNonCastUnaryExpressionRule() ||
				   context == grammarAccess.getPrefixExpressionRule()) {
					sequence_PrefixExpression(context, (IncrementOrDecrementExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.INSTANCE_CREATION_EXPRESSION:
				if(context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getInitializationExpressionRule()) {
					sequence_InitializationExpression_InstanceCreationOrSequenceConstructionExpression_InstanceInitializationExpression(context, (InstanceCreationExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInstanceCreationOrSequenceConstructionExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_InstanceCreationOrSequenceConstructionExpression(context, (InstanceCreationExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getInstanceInitializationExpressionRule()) {
					sequence_InstanceInitializationExpression(context, (InstanceCreationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.ISOLATION_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getIsolationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getNonPostfixNonCastUnaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_IsolationExpression(context, (IsolationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.LINK_OPERATION_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getLinkOperationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_LinkOperationExpression(context, (LinkOperationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.LOCAL_NAME_DECLARATION_STATEMENT:
				if(context == grammarAccess.getLocalNameDeclarationStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_LocalNameDeclarationStatement(context, (LocalNameDeclarationStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.LOGICAL_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_AndExpression_ExclusiveOrExpression_InclusiveOrExpression(context, (LogicalExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.LOOP_VARIABLE_DEFINITION:
				if(context == grammarAccess.getLoopVariableDefinitionRule()) {
					sequence_LoopVariableDefinition(context, (LoopVariableDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.MEMBER:
				if(context == grammarAccess.getActiveClassMemberRule()) {
					sequence_ActiveClassMember(context, (Member) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getClassMemberRule()) {
					sequence_ClassMember(context, (Member) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getClassifierTemplateParameterRule()) {
					sequence_ClassifierTemplateParameter(context, (Member) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getEnumerationLiteralNameRule()) {
					sequence_EnumerationLiteralName(context, (Member) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getFormalParameterRule()) {
					sequence_FormalParameter(context, (Member) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPackagedElementRule()) {
					sequence_PackagedElement(context, (Member) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getReturnParameterRule()) {
					sequence_ReturnParameter(context, (Member) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getStructuredMemberRule()) {
					sequence_StructuredMember(context, (Member) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NAME_BINDING:
				if(context == grammarAccess.getNameBindingRule()) {
					sequence_NameBinding(context, (NameBinding) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NAME_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getNameExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_NameExpression(context, (NameExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NAME_LEFT_HAND_SIDE:
				if(context == grammarAccess.getLeftHandSideRule() ||
				   context == grammarAccess.getNameLeftHandSideRule()) {
					sequence_NameLeftHandSide(context, (NameLeftHandSide) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NAMED_EXPRESSION:
				if(context == grammarAccess.getIndexedNamedExpressionRule()) {
					sequence_IndexedNamedExpression(context, (NamedExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNamedExpressionRule()) {
					sequence_NamedExpression(context, (NamedExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NAMED_TEMPLATE_BINDING:
				if(context == grammarAccess.getNamedTemplateBindingRule() ||
				   context == grammarAccess.getTemplateBindingRule()) {
					sequence_NamedTemplateBinding(context, (NamedTemplateBinding) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NAMED_TUPLE:
				if(context == grammarAccess.getIndexedNamedTupleExpressionListRule() ||
				   context == grammarAccess.getLinkOperationTupleRule()) {
					sequence_IndexedNamedTupleExpressionList(context, (NamedTuple) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNamedTupleExpressionListRule() ||
				   context == grammarAccess.getTupleRule()) {
					sequence_NamedTupleExpressionList(context, (NamedTuple) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NATURAL_LITERAL_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getNaturalLiteralExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_NaturalLiteralExpression(context, (NaturalLiteralExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NON_FINAL_CLAUSE:
				if(context == grammarAccess.getNonFinalClauseRule()) {
					sequence_NonFinalClause(context, (NonFinalClause) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NON_RETURN_PARAMETER:
				if(context == grammarAccess.getFormalParameterDefinitionRule()) {
					sequence_FormalParameterDefinition(context, (NonReturnParameter) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.NUMERIC_UNARY_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getNonPostfixNonCastUnaryExpressionRule() ||
				   context == grammarAccess.getNumericUnaryExpressionRule() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_NumericUnaryExpression(context, (NumericUnaryExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.OPERATION_DEFINITION:
				if(context == grammarAccess.getOperationDeclarationRule()) {
					sequence_OperationDeclaration(context, (OperationDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActiveClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassMemberDefinitionRule() ||
				   context == grammarAccess.getFeatureDefinitionOrStubRule() ||
				   context == grammarAccess.getOperationDefinitionOrStubRule()) {
					sequence_OperationDeclaration_OperationDefinitionOrStub(context, (OperationDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.PACKAGE_DEFINITION:
				if(context == grammarAccess.getPackageDefinitionOrStubRule() ||
				   context == grammarAccess.getPackagedElementDefinitionRule()) {
					sequence_PackageDefinitionOrStub(context, (PackageDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNamespaceDefinitionRule() ||
				   context == grammarAccess.getPackageDefinitionRule()) {
					sequence_PackageDefinition(context, (PackageDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.PACKAGE_IMPORT_REFERENCE:
				if(context == grammarAccess.getImportDeclarationRule() ||
				   context == grammarAccess.getPackageImportReferenceRule()) {
					sequence_PackageImportReference(context, (PackageImportReference) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.POSITIONAL_TEMPLATE_BINDING:
				if(context == grammarAccess.getPositionalTemplateBindingRule() ||
				   context == grammarAccess.getTemplateBindingRule()) {
					sequence_PositionalTemplateBinding(context, (PositionalTemplateBinding) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.POSITIONAL_TUPLE:
				if(context == grammarAccess.getLinkOperationTupleRule() ||
				   context == grammarAccess.getPositionalTupleExpressionListRule() ||
				   context == grammarAccess.getTupleRule()) {
					sequence_PositionalTupleExpressionList(context, (PositionalTuple) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.PROPERTY_ACCESS_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_PrimaryExpression(context, (PropertyAccessExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.PROPERTY_DEFINITION:
				if(context == grammarAccess.getActiveClassMemberDefinitionRule() ||
				   context == grammarAccess.getAttributeDefinitionRule() ||
				   context == grammarAccess.getClassMemberDefinitionRule() ||
				   context == grammarAccess.getFeatureDefinitionOrStubRule()) {
					sequence_AttributeDefinition_PropertyDeclaration(context, (PropertyDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPropertyDeclarationRule() ||
				   context == grammarAccess.getPropertyDefinitionRule()) {
					sequence_PropertyDeclaration(context, (PropertyDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.QUALIFIED_NAME:
				if(context == grammarAccess.getColonQualifiedNameRule()) {
					sequence_ColonQualifiedName_UnqualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getDotQualifiedNameRule()) {
					sequence_DotQualifiedName_UnqualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPackageImportQualifiedNameRule()) {
					sequence_PackageImportQualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPotentiallyAmbiguousQualifiedNameRule()) {
					sequence_PotentiallyAmbiguousQualifiedName_UnqualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNamespaceDeclarationRule() ||
				   context == grammarAccess.getQualifiedNameRule()) {
					sequence_QualifiedName_UnqualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getUnqualifiedNameRule()) {
					sequence_UnqualifiedName(context, (QualifiedName) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.QUALIFIED_NAME_LIST:
				if(context == grammarAccess.getClassificationFromClauseRule() ||
				   context == grammarAccess.getClassificationToClauseRule() ||
				   context == grammarAccess.getQualifiedNameListRule() ||
				   context == grammarAccess.getRedefinitionClauseRule() ||
				   context == grammarAccess.getSpecializationClauseRule()) {
					sequence_QualifiedNameList(context, (QualifiedNameList) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTemplateParameterConstraintRule()) {
					sequence_TemplateParameterConstraint(context, (QualifiedNameList) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.RECEPTION_DEFINITION:
				if(context == grammarAccess.getActiveClassMemberDefinitionRule() ||
				   context == grammarAccess.getActiveFeatureDefinitionOrStubRule() ||
				   context == grammarAccess.getReceptionDefinitionRule()) {
					sequence_ReceptionDefinition(context, (ReceptionDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.RELATIONAL_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_RelationalExpression(context, (RelationalExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.RETURN_PARAMETER:
				if(context == grammarAccess.getReturnParameterDefinitionRule()) {
					sequence_ReturnParameterDefinition(context, (ReturnParameter) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.RETURN_STATEMENT:
				if(context == grammarAccess.getReturnStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_ReturnStatement(context, (ReturnStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENCE_ACCESS_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_PrimaryExpression(context, (SequenceAccessExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENCE_CONSTRUCTION_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_BaseExpression_InstanceCreationOrSequenceConstructionExpression_SequenceConstructionExpression(context, (SequenceConstructionExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getSequenceElementRule()) {
					sequence_InitializationExpression_InstanceCreationOrSequenceConstructionExpression_SequenceConstructionExpression_SequenceInitializationExpression(context, (SequenceConstructionExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getInstanceCreationOrSequenceConstructionExpressionRule()) {
					sequence_InstanceCreationOrSequenceConstructionExpression(context, (SequenceConstructionExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSequenceConstructionExpressionRule()) {
					sequence_SequenceConstructionExpression(context, (SequenceConstructionExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSequenceInitializationExpressionRule()) {
					sequence_SequenceInitializationExpression(context, (SequenceConstructionExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENCE_EXPANSION_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_PrimaryExpression_SequenceOperationOrReductionOrExpansionExpression(context, (SequenceExpansionExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSequenceOperationOrReductionOrExpansionExpressionRule()) {
					sequence_SequenceOperationOrReductionOrExpansionExpression(context, (SequenceExpansionExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENCE_EXPRESSION_LIST:
				if(context == grammarAccess.getSequenceElementsRule() ||
				   context == grammarAccess.getSequenceExpressionListRule()) {
					sequence_SequenceExpressionList(context, (SequenceExpressionList) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENCE_OPERATION_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_PrimaryExpression_SequenceOperationOrReductionOrExpansionExpression(context, (SequenceOperationExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSequenceOperationOrReductionOrExpansionExpressionRule()) {
					sequence_SequenceOperationOrReductionOrExpansionExpression(context, (SequenceOperationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENCE_RANGE:
				if(context == grammarAccess.getSequenceElementsRule() ||
				   context == grammarAccess.getSequenceRangeRule()) {
					sequence_SequenceRange(context, (SequenceRange) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SEQUENCE_REDUCTION_EXPRESSION:
				if(context == grammarAccess.getBaseExpressionRule()) {
					sequence_BaseExpression_PrimaryExpression_SequenceOperationOrReductionOrExpansionExpression(context, (SequenceReductionExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_PrimaryExpression_SequenceOperationOrReductionOrExpansionExpression(context, (SequenceReductionExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getSequenceOperationOrReductionOrExpansionExpressionRule()) {
					sequence_SequenceOperationOrReductionOrExpansionExpression(context, (SequenceReductionExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SHIFT_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_ShiftExpression(context, (ShiftExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SIGNAL_DEFINITION:
				if(context == grammarAccess.getSignalDeclarationRule()) {
					sequence_SignalDeclaration(context, (SignalDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActiveClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassMemberDefinitionRule() ||
				   context == grammarAccess.getClassifierDefinitionOrStubRule() ||
				   context == grammarAccess.getPackagedElementDefinitionRule() ||
				   context == grammarAccess.getSignalDefinitionOrStubRule()) {
					sequence_SignalDeclaration_SignalDefinitionOrStub(context, (SignalDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getClassifierDefinitionRule() ||
				   context == grammarAccess.getNamespaceDefinitionRule() ||
				   context == grammarAccess.getSignalDefinitionRule()) {
					sequence_SignalDeclaration_SignalDefinition(context, (SignalDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SIGNAL_RECEPTION_DEFINITION:
				if(context == grammarAccess.getSignalReceptionDeclarationRule()) {
					sequence_SignalReceptionDeclaration(context, (SignalReceptionDefinition) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getActiveClassMemberDefinitionRule() ||
				   context == grammarAccess.getActiveFeatureDefinitionOrStubRule() ||
				   context == grammarAccess.getSignalReceptionDefinitionOrStubRule()) {
					sequence_SignalReceptionDeclaration_SignalReceptionDefinitionOrStub(context, (SignalReceptionDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.STEREOTYPE_ANNOTATION:
				if(context == grammarAccess.getStereotypeAnnotationRule()) {
					sequence_StereotypeAnnotation(context, (StereotypeAnnotation) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.STRING_LITERAL_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getStringLiteralExpressionRule() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_StringLiteralExpression(context, (StringLiteralExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SUPER_INVOCATION_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSuperInvocationExpressionRule() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_SuperInvocationExpression(context, (SuperInvocationExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SWITCH_CLAUSE:
				if(context == grammarAccess.getSwitchClauseRule()) {
					sequence_SwitchClause(context, (SwitchClause) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.SWITCH_STATEMENT:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getSwitchStatementRule()) {
					sequence_SwitchStatement(context, (SwitchStatement) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.TAGGED_VALUE:
				if(context == grammarAccess.getTaggedValueRule()) {
					sequence_TaggedValue(context, (TaggedValue) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.TAGGED_VALUE_LIST:
				if(context == grammarAccess.getTaggedValueListRule()) {
					sequence_TaggedValueList(context, (TaggedValueList) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.TEMPLATE_PARAMETER_SUBSTITUTION:
				if(context == grammarAccess.getTemplateParameterSubstitutionRule()) {
					sequence_TemplateParameterSubstitution(context, (TemplateParameterSubstitution) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.THIS_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getThisExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionRule()) {
					sequence_ThisExpression(context, (ThisExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.TYPED_ELEMENT_DEFINITION:
				if(context == grammarAccess.getTypePartRule()) {
					sequence_TypePart(context, (TypedElementDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.UNBOUNDED_LITERAL_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule() ||
				   context == grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getAttributeInitializerRule() ||
				   context == grammarAccess.getBaseExpressionRule() ||
				   context == grammarAccess.getCastCompletionRule() ||
				   context == grammarAccess.getClassificationExpressionRule() ||
				   context == grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0() ||
				   context == grammarAccess.getConditionalAndExpressionRule() ||
				   context == grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalExpressionRule() ||
				   context == grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getConditionalOrExpressionRule() ||
				   context == grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getEqualityExpressionRule() ||
				   context == grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExclusiveOrExpressionRule() ||
				   context == grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionRule() ||
				   context == grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getIndexRule() ||
				   context == grammarAccess.getInitializationExpressionRule() ||
				   context == grammarAccess.getLiteralExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionRule() ||
				   context == grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getParenthesizedExpressionRule() ||
				   context == grammarAccess.getPostfixOrCastExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionRule() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getExtentOrExpressionNonNameExpressionAction_1_2_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_0_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getFeatureReferenceExpressionAction_1_1_0() ||
				   context == grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0() ||
				   context == grammarAccess.getRelationalExpressionRule() ||
				   context == grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSequenceElementRule() ||
				   context == grammarAccess.getShiftExpressionRule() ||
				   context == grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0() ||
				   context == grammarAccess.getSwitchCaseRule() ||
				   context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnboundedLiteralExpressionRule()) {
					sequence_UnboundedLiteralExpression(context, (UnboundedLiteralExpression) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.UNIT_DEFINITION:
				if(context == grammarAccess.getUnitDefinitionRule()) {
					sequence_UnitDefinition(context, (UnitDefinition) semanticObject); 
					return; 
				}
				else break;
			case AlfPackage.WHILE_STATEMENT:
				if(context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getWhileStatementRule()) {
					sequence_WhileStatement(context, (WhileStatement) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=Name? signalNames=QualifiedNameList block=Block)
	 */
	protected void sequence_AcceptBlock_AcceptClause(EObject context, AcceptBlock semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name? signalNames=QualifiedNameList)
	 */
	protected void sequence_AcceptClause(EObject context, AcceptBlock semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (acceptBlock+=AcceptClause | (acceptBlock+=AcceptBlock acceptBlock+=AcceptBlock*))
	 */
	protected void sequence_AcceptStatement(EObject context, AcceptStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause?
	 *     )
	 */
	protected void sequence_ActiveClassDeclaration(EObject context, ActiveClassDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause? 
	 *         (isStub?=';' | (ownedMember+=ActiveClassMember* classifierBehavior=BehaviorClause?))
	 *     )
	 */
	protected void sequence_ActiveClassDeclaration_ActiveClassDefinitionOrStub(EObject context, ActiveClassDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause? 
	 *         ownedMember+=ActiveClassMember* 
	 *         classifierBehavior=BehaviorClause?
	 *     )
	 */
	protected void sequence_ActiveClassDeclaration_ActiveClassDefinition(EObject context, ActiveClassDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (documentation+=DOCUMENTATION_COMMENT? annotation+=StereotypeAnnotation* visibility=VisibilityIndicator? definition=ActiveClassMemberDefinition)
	 */
	protected void sequence_ActiveClassMember(EObject context, Member semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         (ownedMember+=FormalParameter ownedMember+=FormalParameter*)? 
	 *         ownedMember+=ReturnParameter?
	 *     )
	 */
	protected void sequence_ActivityDeclaration(EObject context, ActivityDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         (ownedMember+=FormalParameter ownedMember+=FormalParameter*)? 
	 *         ownedMember+=ReturnParameter? 
	 *         (isStub?=';' | body=Block)
	 *     )
	 */
	protected void sequence_ActivityDeclaration_ActivityDefinitionOrStub(EObject context, ActivityDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         (ownedMember+=FormalParameter ownedMember+=FormalParameter*)? 
	 *         ownedMember+=ReturnParameter? 
	 *         body=Block
	 *     )
	 */
	protected void sequence_ActivityDeclaration_ActivityDefinition(EObject context, ActivityDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (operand1=AdditiveExpression_ArithmeticExpression_1_0 operator=AdditiveOperator operand2=MultiplicativeExpression) | 
	 *         (operand1=MultiplicativeExpression_ArithmeticExpression_1_0 operator=MultiplicativeOperator operand2=UnaryExpression)
	 *     )
	 */
	protected void sequence_AdditiveExpression_MultiplicativeExpression(EObject context, ArithmeticExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (operand1=ExclusiveOrExpression_LogicalExpression_1_0 operator='^' operand2=AndExpression) | 
	 *         (operand1=AndExpression_LogicalExpression_1_0 operator='&' operand2=EqualityExpression) | 
	 *         (operand1=InclusiveOrExpression_LogicalExpression_1_0 operator='|' operand2=ExclusiveOrExpression)
	 *     )
	 */
	protected void sequence_AndExpression_ExclusiveOrExpression_InclusiveOrExpression(EObject context, LogicalExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (documentation+=DOCUMENTATION_COMMENT? annotation+=STATEMENT_ANNOTATION* statement=Statement)
	 */
	protected void sequence_AnnotatedStatement(EObject context, AnnotatedStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (leftHandSide=LeftHandSide operator=AssignmentOperator rightHandSide=Expression)
	 */
	protected void sequence_AssignmentExpression(EObject context, AssignmentExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause?
	 *     )
	 */
	protected void sequence_AssociationDeclaration(EObject context, AssociationDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause? 
	 *         (isStub?=';' | ownedMember+=StructuredMember*)
	 *     )
	 */
	protected void sequence_AssociationDeclaration_AssociationDefinitionOrStub(EObject context, AssociationDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause? 
	 *         ownedMember+=StructuredMember*
	 *     )
	 */
	protected void sequence_AssociationDeclaration_AssociationDefinition(EObject context, AssociationDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name isComposite?='compose'? typePart=TypePart initializer=AttributeInitializer?)
	 */
	protected void sequence_AttributeDefinition_PropertyDeclaration(EObject context, PropertyDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (typeName=QualifiedName hasMultiplicity?=MultiplicityIndicator? elements=SequenceElements?) | 
	 *         ((isAny?='any' | typeName=QualifiedName) hasMultiplicity?=MultiplicityIndicator? elements=SequenceElements?) | 
	 *         hasMultiplicity?='null'
	 *     )
	 */
	protected void sequence_BaseExpression_InstanceCreationOrSequenceConstructionExpression_SequenceConstructionExpression(EObject context, SequenceConstructionExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (primary=SequenceOperationOrReductionOrExpansionExpression_SequenceReductionExpression_3_1_0 isOrdered?='ordered'? behaviorName=QualifiedName) | 
	 *         (primary=SequenceOperationOrReductionOrExpansionExpression_SequenceReductionExpression_3_1_0 behaviorName=QualifiedName) | 
	 *         (primary=PrimaryExpression_SequenceReductionExpression_1_2_2_1_0 isOrdered?='ordered'? behaviorName=QualifiedName) | 
	 *         (primary=PrimaryExpression_SequenceReductionExpression_1_2_2_1_0 behaviorName=QualifiedName)
	 *     )
	 */
	protected void sequence_BaseExpression_PrimaryExpression_SequenceOperationOrReductionOrExpansionExpression(EObject context, SequenceReductionExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (body=Block | name=Name)
	 */
	protected void sequence_BehaviorClause(EObject context, ActivityDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (target=PotentiallyAmbiguousQualifiedName tuple=Tuple)
	 */
	protected void sequence_BehaviorInvocationExpression(EObject context, BehaviorInvocationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operator='~' operand=UnaryExpression)
	 */
	protected void sequence_BitStringUnaryExpression(EObject context, BitStringUnaryExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     block=Block
	 */
	protected void sequence_BlockStatement(EObject context, BlockStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (statement+=DocumentedStatement*)
	 */
	protected void sequence_Block(EObject context, Block semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     image=BOOLEAN_VALUE
	 */
	protected void sequence_BooleanLiteralExpression(EObject context, BooleanLiteralExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operator='!' operand=UnaryExpression)
	 */
	protected void sequence_BooleanUnaryExpression(EObject context, BooleanUnaryExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {BreakStatement}
	 */
	protected void sequence_BreakStatement(EObject context, BreakStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((isAny?='any' | typeName=QualifiedName) operand=CastCompletion)
	 */
	protected void sequence_CastExpression(EObject context, CastExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause?
	 *     )
	 */
	protected void sequence_ClassDeclaration(EObject context, ClassDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause? 
	 *         (isStub?=';' | ownedMember+=ClassMember*)
	 *     )
	 */
	protected void sequence_ClassDeclaration_ClassDefinitionOrStub(EObject context, ClassDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause? 
	 *         ownedMember+=ClassMember*
	 *     )
	 */
	protected void sequence_ClassDeclaration_ClassDefinition(EObject context, ClassDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     className=PotentiallyAmbiguousQualifiedName
	 */
	protected void sequence_ClassExtentExpression(EObject context, ClassExtentExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (documentation+=DOCUMENTATION_COMMENT? annotation+=StereotypeAnnotation* visibility=VisibilityIndicator? definition=ClassMemberDefinition)
	 */
	protected void sequence_ClassMember(EObject context, Member semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operand=ClassificationExpression_ClassificationExpression_1_0 operator=ClassificationOperator typeName=QualifiedName)
	 */
	protected void sequence_ClassificationExpression(EObject context, ClassificationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? specialization=SpecializationClause?)
	 */
	protected void sequence_ClassifierSignature(EObject context, ClassifierDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name specialization=TemplateParameterConstraint?)
	 */
	protected void sequence_ClassifierTemplateParameterDefinition(EObject context, ClassifierTemplateParameter semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (documentation+=DOCUMENTATION_COMMENT? definition=ClassifierTemplateParameterDefinition)
	 */
	protected void sequence_ClassifierTemplateParameter(EObject context, Member semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         expression=Expression 
	 *         ((fromList=ClassificationFromClause toList=ClassificationToClause?) | (isReclassifyAll?=ReclassifyAllClause? toList=ClassificationToClause))
	 *     )
	 */
	protected void sequence_ClassifyStatement(EObject context, ClassifyStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (nameBinding+=NameBinding nameBinding+=NameBinding+)
	 */
	protected void sequence_ColonQualifiedName_UnqualifiedName(EObject context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (clause+=NonFinalClause clause+=NonFinalClause*)
	 */
	protected void sequence_ConcurrentClauses(EObject context, ConcurrentClauses semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (operand1=ConditionalOrExpression_ConditionalLogicalExpression_1_0 operator='||' operand2=ConditionalAndExpression) | 
	 *         (operand1=ConditionalAndExpression_ConditionalLogicalExpression_1_0 operator='&&' operand2=InclusiveOrExpression)
	 *     )
	 */
	protected void sequence_ConditionalAndExpression_ConditionalOrExpression(EObject context, ConditionalLogicalExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operand1=ConditionalExpression_ConditionalTestExpression_1_0 operand2=Expression operand3=ConditionalExpression)
	 */
	protected void sequence_ConditionalExpression(EObject context, ConditionalTestExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause?
	 *     )
	 */
	protected void sequence_DataTypeDeclaration(EObject context, DataTypeDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause? 
	 *         (isStub?=';' | ownedMember+=StructuredMember*)
	 *     )
	 */
	protected void sequence_DataTypeDeclaration_DataTypeDefinitionOrStub(EObject context, DataTypeDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause? 
	 *         ownedMember+=StructuredMember*
	 *     )
	 */
	protected void sequence_DataTypeDeclaration_DataTypeDefinition(EObject context, DataTypeDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (body=Block condition=Expression)
	 */
	protected void sequence_DoStatement(EObject context, DoStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (nameBinding+=NameBinding nameBinding+=NameBinding+)
	 */
	protected void sequence_DotQualifiedName_UnqualifiedName(EObject context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (visibility=ImportVisibilityIndicator referentName=QualifiedName alias=Name?)
	 */
	protected void sequence_ElementImportReference(EObject context, ElementImportReference semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {EmptyStatement}
	 */
	protected void sequence_EmptyStatement(EObject context, EmptyStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name specialization=SpecializationClause?)
	 */
	protected void sequence_EnumerationDeclaration(EObject context, EnumerationDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name specialization=SpecializationClause? (isStub?=';' | (ownedMember+=EnumerationLiteralName ownedMember+=EnumerationLiteralName*)?))
	 */
	protected void sequence_EnumerationDeclaration_EnumerationDefinitionOrStub(EObject context, EnumerationDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name specialization=SpecializationClause? (ownedMember+=EnumerationLiteralName ownedMember+=EnumerationLiteralName*)?)
	 */
	protected void sequence_EnumerationDeclaration_EnumerationDefinition(EObject context, EnumerationDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=Name
	 */
	protected void sequence_EnumerationLiteralNameDefinition(EObject context, EnumerationLiteralName semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (documentation+=DOCUMENTATION_COMMENT? definition=EnumerationLiteralNameDefinition)
	 */
	protected void sequence_EnumerationLiteralName(EObject context, Member semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operand1=EqualityExpression_EqualityExpression_1_0 operator=EqualityOperator operand2=ClassificationExpression)
	 */
	protected void sequence_EqualityExpression(EObject context, EqualityExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_ExpressionStatement(EObject context, ExpressionStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=PrimaryExpression
	 */
	protected void sequence_FeatureLeftHandSide(EObject context, FeatureLeftHandSide semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (variableDefinition+=LoopVariableDefinition variableDefinition+=LoopVariableDefinition* body=Block)
	 */
	protected void sequence_ForStatement(EObject context, ForStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (direction=ParameterDirection name=Name typePart=TypePart)
	 */
	protected void sequence_FormalParameterDefinition(EObject context, NonReturnParameter semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (documentation+=DOCUMENTATION_COMMENT? annotation+=StereotypeAnnotation* definition=FormalParameterDefinition)
	 */
	protected void sequence_FormalParameter(EObject context, Member semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (nonFinalClauses+=ConcurrentClauses nonFinalClauses+=ConcurrentClauses* finalClause=Block?)
	 */
	protected void sequence_IfStatement(EObject context, IfStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     code=INLINE_STATEMENT
	 */
	protected void sequence_InLineStatement(EObject context, InLineStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name index=Index? expression=Expression)
	 */
	protected void sequence_IndexedNamedExpression(EObject context, NamedExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (namedExpression+=IndexedNamedExpression namedExpression+=IndexedNamedExpression*)
	 */
	protected void sequence_IndexedNamedTupleExpressionList(EObject context, NamedTuple semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((constructor=QualifiedName tuple=Tuple) | tuple=Tuple)
	 */
	protected void sequence_InitializationExpression_InstanceCreationOrSequenceConstructionExpression_InstanceInitializationExpression(EObject context, InstanceCreationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (typeName=QualifiedName hasMultiplicity?=MultiplicityIndicator? elements=SequenceElements?) | 
	 *         ((isAny?='any' | typeName=QualifiedName) hasMultiplicity?=MultiplicityIndicator? elements=SequenceElements?) | 
	 *         hasMultiplicity?='null' | 
	 *         elements=SequenceElements
	 *     )
	 */
	protected void sequence_InitializationExpression_InstanceCreationOrSequenceConstructionExpression_SequenceConstructionExpression_SequenceInitializationExpression(EObject context, SequenceConstructionExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (constructor=QualifiedName tuple=Tuple)
	 */
	protected void sequence_InstanceCreationOrSequenceConstructionExpression(EObject context, InstanceCreationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (typeName=QualifiedName hasMultiplicity?=MultiplicityIndicator? elements=SequenceElements?)
	 */
	protected void sequence_InstanceCreationOrSequenceConstructionExpression(EObject context, SequenceConstructionExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     tuple=Tuple
	 */
	protected void sequence_InstanceInitializationExpression(EObject context, InstanceCreationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operator='$' operand=UnaryExpression)
	 */
	protected void sequence_IsolationExpression(EObject context, IsolationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (associationName=PotentiallyAmbiguousQualifiedName operation=LinkOperation tuple=LinkOperationTuple)
	 */
	protected void sequence_LinkOperationExpression(EObject context, LinkOperationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (
	 *             (name=Name (isAny?='any' | typeName=QualifiedName) hasMultiplicity?=MultiplicityIndicator?) | 
	 *             ((isAny?='any' | typeName=QualifiedName) hasMultiplicity?=MultiplicityIndicator? name=Name)
	 *         ) 
	 *         expression=InitializationExpression
	 *     )
	 */
	protected void sequence_LocalNameDeclarationStatement(EObject context, LocalNameDeclarationStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (variable=Name typeIsInferred?='in' expression1=Expression expression2=Expression?) | 
	 *         ((isAny?='any' | typeName=QualifiedName) variable=Name expression1=Expression)
	 *     )
	 */
	protected void sequence_LoopVariableDefinition(EObject context, LoopVariableDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name binding=TemplateBinding?)
	 */
	protected void sequence_NameBinding(EObject context, NameBinding semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=PotentiallyAmbiguousQualifiedName
	 */
	protected void sequence_NameExpression(EObject context, NameExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (target=PotentiallyAmbiguousQualifiedName index=Index?)
	 */
	protected void sequence_NameLeftHandSide(EObject context, NameLeftHandSide semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name expression=Expression)
	 */
	protected void sequence_NamedExpression(EObject context, NamedExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (substitution+=TemplateParameterSubstitution substitution+=TemplateParameterSubstitution*)
	 */
	protected void sequence_NamedTemplateBinding(EObject context, NamedTemplateBinding semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (namedExpression+=NamedExpression namedExpression+=NamedExpression*)
	 */
	protected void sequence_NamedTupleExpressionList(EObject context, NamedTuple semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     image=NATURAL_VALUE
	 */
	protected void sequence_NaturalLiteralExpression(EObject context, NaturalLiteralExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     statement+=DocumentedStatement+
	 */
	protected void sequence_NonEmptyStatementSequence(EObject context, Block semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expression body=Block)
	 */
	protected void sequence_NonFinalClause(EObject context, NonFinalClause semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operator=NumericUnaryOperator operand=UnaryExpression)
	 */
	protected void sequence_NumericUnaryExpression(EObject context, NumericUnaryExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=FormalParameter ownedMember+=FormalParameter*)? 
	 *         ownedMember+=ReturnParameter? 
	 *         redefinition=RedefinitionClause?
	 *     )
	 */
	protected void sequence_OperationDeclaration(EObject context, OperationDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=FormalParameter ownedMember+=FormalParameter*)? 
	 *         ownedMember+=ReturnParameter? 
	 *         redefinition=RedefinitionClause? 
	 *         (isStub?=';' | body=Block)
	 *     )
	 */
	protected void sequence_OperationDeclaration_OperationDefinitionOrStub(EObject context, OperationDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name (isStub?=';' | ownedMember+=PackagedElement*))
	 */
	protected void sequence_PackageDefinitionOrStub(EObject context, PackageDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name ownedMember+=PackagedElement*)
	 */
	protected void sequence_PackageDefinition(EObject context, PackageDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (nameBinding+=NameBinding (nameBinding+=NameBinding* | nameBinding+=NameBinding*))
	 */
	protected void sequence_PackageImportQualifiedName(EObject context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (visibility=ImportVisibilityIndicator referentName=PackageImportQualifiedName)
	 */
	protected void sequence_PackageImportReference(EObject context, PackageImportReference semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         documentation+=DOCUMENTATION_COMMENT? 
	 *         annotation+=StereotypeAnnotation* 
	 *         visibility=ImportVisibilityIndicator 
	 *         definition=PackagedElementDefinition
	 *     )
	 */
	protected void sequence_PackagedElement(EObject context, Member semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (argumentName+=QualifiedName argumentName+=QualifiedName*)
	 */
	protected void sequence_PositionalTemplateBinding(EObject context, PositionalTemplateBinding semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((expression+=Expression expression+=Expression*)?)
	 */
	protected void sequence_PositionalTupleExpressionList(EObject context, PositionalTuple semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operand=LeftHandSide operator=AffixOperator)
	 */
	protected void sequence_PostfixExpression(EObject context, IncrementOrDecrementExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((operand=LeftHandSide operator=AffixOperator) | (operator=AffixOperator operand=LeftHandSide))
	 */
	protected void sequence_PostfixExpression_PrefixExpression_UnaryExpression(EObject context, IncrementOrDecrementExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (nameBinding+=NameBinding (nameBinding+=NameBinding+ | (isAmbiguous?='.' nameBinding+=NameBinding nameBinding+=NameBinding*))?)
	 */
	protected void sequence_PotentiallyAmbiguousQualifiedName_UnqualifiedName(EObject context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operator=AffixOperator operand=LeftHandSide)
	 */
	protected void sequence_PrefixExpression(EObject context, IncrementOrDecrementExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression=PrimaryExpression_FeatureReference_1_0_0 nameBinding=NameBinding)
	 */
	protected void sequence_PrimaryExpression_FeatureInvocationExpression_1_0_3(EObject context, FeatureReference semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     featureReference=PrimaryExpression_PropertyAccessExpression_1_1_3
	 */
	protected void sequence_PrimaryExpression(EObject context, PropertyAccessExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression=PrimaryExpression_FeatureReference_1_1_0 nameBinding=NameBinding)
	 */
	protected void sequence_PrimaryExpression_PropertyAccessExpression_1_1_3(EObject context, FeatureReference semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (primary=PrimaryExpression_SequenceAccessExpression_1_3_0 index=Index)
	 */
	protected void sequence_PrimaryExpression(EObject context, SequenceAccessExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     nonNameExpression=PrimaryExpression_ExtentOrExpression_1_2_0
	 */
	protected void sequence_PrimaryExpression_SequenceExpansionExpression_1_2_2_2_0_SequenceOperationExpression_1_2_2_0_0_SequenceReductionExpression_1_2_2_1_0(EObject context, ExtentOrExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (primary=PrimaryExpression_SequenceExpansionExpression_1_2_2_2_0 operation=ID variable=Name argument=Expression) | 
	 *         (primary=SequenceOperationOrReductionOrExpansionExpression_SequenceExpansionExpression_3_2_0 operation=ID variable=Name argument=Expression)
	 *     )
	 */
	protected void sequence_PrimaryExpression_SequenceOperationOrReductionOrExpansionExpression(EObject context, SequenceExpansionExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (primary=PrimaryExpression_SequenceOperationExpression_1_2_2_0_0 operation=QualifiedName tuple=Tuple) | 
	 *         (primary=SequenceOperationOrReductionOrExpansionExpression_SequenceOperationExpression_3_0_0 operation=QualifiedName tuple=Tuple)
	 *     )
	 */
	protected void sequence_PrimaryExpression_SequenceOperationOrReductionOrExpansionExpression(EObject context, SequenceOperationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (primary=PrimaryExpression_SequenceReductionExpression_1_2_2_1_0 isOrdered?='ordered'? behaviorName=QualifiedName) | 
	 *         (primary=PrimaryExpression_SequenceReductionExpression_1_2_2_1_0 behaviorName=QualifiedName) | 
	 *         (
	 *             (primary=SequenceOperationOrReductionOrExpansionExpression_SequenceReductionExpression_3_1_0 isOrdered?='ordered'? behaviorName=QualifiedName) | 
	 *             (primary=SequenceOperationOrReductionOrExpansionExpression_SequenceReductionExpression_3_1_0 behaviorName=QualifiedName)
	 *         )
	 *     )
	 */
	protected void sequence_PrimaryExpression_SequenceOperationOrReductionOrExpansionExpression(EObject context, SequenceReductionExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((target=PrimaryExpression_FeatureInvocationExpression_1_0_3 tuple=Tuple) | tuple=Tuple)
	 */
	protected void sequence_PrimaryExpression_ThisExpression(EObject context, FeatureInvocationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name isComposite?='compose'? typePart=TypePart)
	 */
	protected void sequence_PropertyDeclaration(EObject context, PropertyDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name+=QualifiedName name+=QualifiedName*)
	 */
	protected void sequence_QualifiedNameList(EObject context, QualifiedNameList semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (nameBinding+=NameBinding (nameBinding+=NameBinding+ | nameBinding+=NameBinding+)?)
	 */
	protected void sequence_QualifiedName_UnqualifiedName(EObject context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     signalName=QualifiedName
	 */
	protected void sequence_ReceptionDefinition(EObject context, ReceptionDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operand1=RelationalExpression_RelationalExpression_1_0 operator=RelationalOperator operand2=ShiftExpression)
	 */
	protected void sequence_RelationalExpression(EObject context, RelationalExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     typePart=TypePart
	 */
	protected void sequence_ReturnParameterDefinition(EObject context, ReturnParameter semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     definition=ReturnParameterDefinition
	 */
	protected void sequence_ReturnParameter(EObject context, Member semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression=Expression?)
	 */
	protected void sequence_ReturnStatement(EObject context, ReturnStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (((isAny?='any' | typeName=QualifiedName) hasMultiplicity?=MultiplicityIndicator? elements=SequenceElements?) | hasMultiplicity?='null')
	 */
	protected void sequence_SequenceConstructionExpression(EObject context, SequenceConstructionExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (element+=SequenceElement element+=SequenceElement*)
	 */
	protected void sequence_SequenceExpressionList(EObject context, SequenceExpressionList semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     elements=SequenceElements
	 */
	protected void sequence_SequenceInitializationExpression(EObject context, SequenceConstructionExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (primary=SequenceOperationOrReductionOrExpansionExpression_SequenceExpansionExpression_3_2_0 operation=ID variable=Name argument=Expression)
	 */
	protected void sequence_SequenceOperationOrReductionOrExpansionExpression(EObject context, SequenceExpansionExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=PotentiallyAmbiguousQualifiedName
	 */
	protected void sequence_SequenceOperationOrReductionOrExpansionExpression_SequenceExpansionExpression_3_2_0_SequenceOperationExpression_3_0_0_SequenceReductionExpression_3_1_0(EObject context, ExtentOrExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (primary=SequenceOperationOrReductionOrExpansionExpression_SequenceOperationExpression_3_0_0 operation=QualifiedName tuple=Tuple)
	 */
	protected void sequence_SequenceOperationOrReductionOrExpansionExpression(EObject context, SequenceOperationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (primary=SequenceOperationOrReductionOrExpansionExpression_SequenceReductionExpression_3_1_0 isOrdered?='ordered'? behaviorName=QualifiedName) | 
	 *         (primary=SequenceOperationOrReductionOrExpansionExpression_SequenceReductionExpression_3_1_0 behaviorName=QualifiedName)
	 *     )
	 */
	protected void sequence_SequenceOperationOrReductionOrExpansionExpression(EObject context, SequenceReductionExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (rangeLower=Expression rangeUpper=Expression)
	 */
	protected void sequence_SequenceRange(EObject context, SequenceRange semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (operand1=ShiftExpression_ShiftExpression_1_0 operator=ShiftOperator operand2=AdditiveExpression)
	 */
	protected void sequence_ShiftExpression(EObject context, ShiftExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause?
	 *     )
	 */
	protected void sequence_SignalDeclaration(EObject context, SignalDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause? 
	 *         (isStub?=';' | ownedMember+=StructuredMember*)
	 *     )
	 */
	protected void sequence_SignalDeclaration_SignalDefinitionOrStub(EObject context, SignalDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         isAbstract?='abstract'? 
	 *         name=Name 
	 *         (ownedMember+=ClassifierTemplateParameter ownedMember+=ClassifierTemplateParameter*)? 
	 *         specialization=SpecializationClause? 
	 *         ownedMember+=StructuredMember*
	 *     )
	 */
	protected void sequence_SignalDeclaration_SignalDefinition(EObject context, SignalDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name specialization=SpecializationClause?)
	 */
	protected void sequence_SignalReceptionDeclaration(EObject context, SignalReceptionDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name specialization=SpecializationClause? (isStub?=';' | ownedMember+=StructuredMember*))
	 */
	protected void sequence_SignalReceptionDeclaration_SignalReceptionDefinitionOrStub(EObject context, SignalReceptionDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (statement+=DocumentedStatement*)
	 */
	protected void sequence_StatementSequence(EObject context, Block semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (stereotypeName=QualifiedName (names=QualifiedNameList | taggedValues=TaggedValueList)?)
	 */
	protected void sequence_StereotypeAnnotation(EObject context, StereotypeAnnotation semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     image=STRING
	 */
	protected void sequence_StringLiteralExpression(EObject context, StringLiteralExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (documentation+=DOCUMENTATION_COMMENT? annotation+=StereotypeAnnotation* visibility='public'? definition=PropertyDefinition)
	 */
	protected void sequence_StructuredMember(EObject context, Member semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (target=QualifiedName? tuple=Tuple)
	 */
	protected void sequence_SuperInvocationExpression(EObject context, SuperInvocationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (case+=SwitchCase case+=SwitchCase* block=NonEmptyStatementSequence)
	 */
	protected void sequence_SwitchClause(EObject context, SwitchClause semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression=Expression nonDefaultClause+=SwitchClause* defaultClause=SwitchDefaultClause?)
	 */
	protected void sequence_SwitchStatement(EObject context, SwitchStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (taggedValue+=TaggedValue taggedValue+=TaggedValue*)
	 */
	protected void sequence_TaggedValueList(EObject context, TaggedValueList semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=Name (value=BOOLEAN_VALUE | (operator=NumericUnaryOperator? value=NATURAL_VALUE) | value='*' | value=STRING))
	 */
	protected void sequence_TaggedValue(EObject context, TaggedValue semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name+=QualifiedName
	 */
	protected void sequence_TemplateParameterConstraint(EObject context, QualifiedNameList semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (parameterName=Name argumentName=QualifiedName)
	 */
	protected void sequence_TemplateParameterSubstitution(EObject context, TemplateParameterSubstitution semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     tuple=Tuple
	 */
	protected void sequence_ThisExpression(EObject context, FeatureInvocationExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {ThisExpression}
	 */
	protected void sequence_ThisExpression(EObject context, ThisExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (isAny?='any' | typeName=QualifiedName) 
	 *         (
	 *             (isMultiplicity?=']' | (lowerBound=NATURAL_VALUE? upperBound=UnlimitedNaturalLiteral))? 
	 *             ((isOrdered?='ordered' isNonunique?='nonunique'?) | (isNonunique?='nonunique' isOrdered?='ordered'?) | isSequence?='sequence')?
	 *         )?
	 *     )
	 */
	protected void sequence_TypePart(EObject context, TypedElementDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {UnboundedLiteralExpression}
	 */
	protected void sequence_UnboundedLiteralExpression(EObject context, UnboundedLiteralExpression semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         namespaceName=NamespaceDeclaration? 
	 *         import+=ImportDeclaration* 
	 *         documentation+=DOCUMENTATION_COMMENT? 
	 *         annotation+=StereotypeAnnotation* 
	 *         definition=NamespaceDefinition
	 *     )
	 */
	protected void sequence_UnitDefinition(EObject context, UnitDefinition semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     nameBinding+=NameBinding
	 */
	protected void sequence_UnqualifiedName(EObject context, QualifiedName semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (condition=Expression body=Block)
	 */
	protected void sequence_WhileStatement(EObject context, WhileStatement semanticObject) {
		genericSequencer.createSequence(context, (EObject)semanticObject);
	}
}
