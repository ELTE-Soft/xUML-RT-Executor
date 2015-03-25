package org.eclipse.papyrus.uml.alf.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.alf.services.AlfGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class AlfSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AlfGrammarAccess grammarAccess;
	protected AbstractElementAlias match_PackageImportQualifiedName___ColonColonKeyword_1_0_1_AsteriskKeyword_1_0_2___or___FullStopKeyword_1_1_1_AsteriskKeyword_1_1_2__;
	protected AbstractElementAlias match_ParenthesizedExpression_LeftParenthesisKeyword_0_a;
	protected AbstractElementAlias match_ParenthesizedExpression_LeftParenthesisKeyword_0_p;
	protected AbstractElementAlias match_SequenceExpressionList_CommaKeyword_2_q;
	protected AbstractElementAlias match_SequenceInitializationExpression_NewKeyword_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AlfGrammarAccess) access;
		match_PackageImportQualifiedName___ColonColonKeyword_1_0_1_AsteriskKeyword_1_0_2___or___FullStopKeyword_1_1_1_AsteriskKeyword_1_1_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getPackageImportQualifiedNameAccess().getColonColonKeyword_1_0_1()), new TokenAlias(false, false, grammarAccess.getPackageImportQualifiedNameAccess().getAsteriskKeyword_1_0_2())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getPackageImportQualifiedNameAccess().getFullStopKeyword_1_1_1()), new TokenAlias(false, false, grammarAccess.getPackageImportQualifiedNameAccess().getAsteriskKeyword_1_1_2())));
		match_ParenthesizedExpression_LeftParenthesisKeyword_0_a = new TokenAlias(true, true, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_ParenthesizedExpression_LeftParenthesisKeyword_0_p = new TokenAlias(true, false, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
		match_SequenceExpressionList_CommaKeyword_2_q = new TokenAlias(false, true, grammarAccess.getSequenceExpressionListAccess().getCommaKeyword_2());
		match_SequenceInitializationExpression_NewKeyword_0_q = new TokenAlias(false, true, grammarAccess.getSequenceInitializationExpressionAccess().getNewKeyword_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getMultiplicityIndicatorRule())
			return getMultiplicityIndicatorToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getReclassifyAllClauseRule())
			return getReclassifyAllClauseToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * MultiplicityIndicator : 
	 * 	'[' ']'
	 * ;
	 */
	protected String getMultiplicityIndicatorToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "[]";
	}
	
	/**
	 * ReclassifyAllClause : 
	 * 	'from' '*'
	 * ;
	 */
	protected String getReclassifyAllClauseToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "from*";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_PackageImportQualifiedName___ColonColonKeyword_1_0_1_AsteriskKeyword_1_0_2___or___FullStopKeyword_1_1_1_AsteriskKeyword_1_1_2__.equals(syntax))
				emit_PackageImportQualifiedName___ColonColonKeyword_1_0_1_AsteriskKeyword_1_0_2___or___FullStopKeyword_1_1_1_AsteriskKeyword_1_1_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParenthesizedExpression_LeftParenthesisKeyword_0_a.equals(syntax))
				emit_ParenthesizedExpression_LeftParenthesisKeyword_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParenthesizedExpression_LeftParenthesisKeyword_0_p.equals(syntax))
				emit_ParenthesizedExpression_LeftParenthesisKeyword_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SequenceExpressionList_CommaKeyword_2_q.equals(syntax))
				emit_SequenceExpressionList_CommaKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SequenceInitializationExpression_NewKeyword_0_q.equals(syntax))
				emit_SequenceInitializationExpression_NewKeyword_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('::' '*') | ('.' '*')
	 */
	protected void emit_PackageImportQualifiedName___ColonColonKeyword_1_0_1_AsteriskKeyword_1_0_2___or___FullStopKeyword_1_1_1_AsteriskKeyword_1_1_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('*
	 */
	protected void emit_ParenthesizedExpression_LeftParenthesisKeyword_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '('+
	 */
	protected void emit_ParenthesizedExpression_LeftParenthesisKeyword_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ','?
	 */
	protected void emit_SequenceExpressionList_CommaKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'new'?
	 */
	protected void emit_SequenceInitializationExpression_NewKeyword_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
