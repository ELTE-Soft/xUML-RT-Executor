package com.incquerylabs.uml.ralf.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.incquerylabs.uml.ralf.services.ReducedAlfLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalReducedAlfLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UNRESTRICTED_NAME", "RULE_BOOLEAN_VALUE", "RULE_NATURAL_VALUE", "RULE_REAL_VALUE", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "'::'", "'.'", "'->'", "'*'", "'this'", "'('", "')'", "','", "'=>'", "'super'", "'new'", "'instances'", "'null'", "'<'", "'>'", "'{'", "'}'", "'['", "']'", "'!'", "'~'", "'$'", "'/'", "'%'", "'+'", "'-'", "'&'", "'^'", "'|'", "'&&'", "'||'", "'?'", "':'", "';'", "'='", "'if'", "'else'", "'or'", "'switch'", "'case'", "'default'", "'while'", "'do'", "'for'", "'break'", "'return'", "'classify'", "'from'", "'to'", "'send'", "'link'", "'unlink'", "'set'", "'bag'", "'sequence'", "'++'", "'--'", "'>>'", "'<<'", "'>>>'", "'>='", "'<='", "'instanceof'", "'hastype'", "'=='", "'!='", "'+='", "'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'>>>='"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int RULE_REAL_VALUE=8;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_NATURAL_VALUE=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int RULE_BOOLEAN_VALUE=6;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=9;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=12;
    public static final int RULE_UNRESTRICTED_NAME=5;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__88=88;
    public static final int T__45=45;
    public static final int T__89=89;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalReducedAlfLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReducedAlfLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReducedAlfLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private ReducedAlfLanguageGrammarAccess grammarAccess;
     	
        public InternalReducedAlfLanguageParser(TokenStream input, ReducedAlfLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Statements";	
       	}
       	
       	@Override
       	protected ReducedAlfLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleStatements"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:74:1: entryRuleStatements returns [EObject current=null] : iv_ruleStatements= ruleStatements EOF ;
    public final EObject entryRuleStatements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatements = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:75:2: (iv_ruleStatements= ruleStatements EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:76:2: iv_ruleStatements= ruleStatements EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementsRule()); 
            }
            pushFollow(FOLLOW_ruleStatements_in_entryRuleStatements81);
            iv_ruleStatements=ruleStatements();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatements; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatements91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatements"


    // $ANTLR start "ruleStatements"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:83:1: ruleStatements returns [EObject current=null] : ( (lv_statement_0_0= ruleStatement ) )* ;
    public final EObject ruleStatements() throws RecognitionException {
        EObject current = null;

        EObject lv_statement_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:86:28: ( ( (lv_statement_0_0= ruleStatement ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:87:1: ( (lv_statement_0_0= ruleStatement ) )*
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:87:1: ( (lv_statement_0_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)||(LA1_0>=16 && LA1_0<=18)||(LA1_0>=22 && LA1_0<=23)||LA1_0==25||LA1_0==28||(LA1_0>=32 && LA1_0<=34)||(LA1_0>=37 && LA1_0<=38)||LA1_0==46||LA1_0==48||LA1_0==51||(LA1_0>=54 && LA1_0<=59)||LA1_0==62||(LA1_0>=65 && LA1_0<=69)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:88:1: (lv_statement_0_0= ruleStatement )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:88:1: (lv_statement_0_0= ruleStatement )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:89:3: lv_statement_0_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStatementsAccess().getStatementStatementParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStatement_in_ruleStatements136);
            	    lv_statement_0_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStatementsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"statement",
            	              		lv_statement_0_0, 
            	              		"Statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatements"


    // $ANTLR start "entryRuleName"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:113:1: entryRuleName returns [String current=null] : iv_ruleName= ruleName EOF ;
    public final String entryRuleName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleName = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:114:2: (iv_ruleName= ruleName EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:115:2: iv_ruleName= ruleName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameRule()); 
            }
            pushFollow(FOLLOW_ruleName_in_entryRuleName173);
            iv_ruleName=ruleName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleName184); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleName"


    // $ANTLR start "ruleName"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:122:1: ruleName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | this_UNRESTRICTED_NAME_1= RULE_UNRESTRICTED_NAME ) ;
    public final AntlrDatatypeRuleToken ruleName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token this_UNRESTRICTED_NAME_1=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:125:28: ( (this_ID_0= RULE_ID | this_UNRESTRICTED_NAME_1= RULE_UNRESTRICTED_NAME ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:126:1: (this_ID_0= RULE_ID | this_UNRESTRICTED_NAME_1= RULE_UNRESTRICTED_NAME )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:126:1: (this_ID_0= RULE_ID | this_UNRESTRICTED_NAME_1= RULE_UNRESTRICTED_NAME )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_UNRESTRICTED_NAME) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:126:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleName224); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getNameAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:134:10: this_UNRESTRICTED_NAME_1= RULE_UNRESTRICTED_NAME
                    {
                    this_UNRESTRICTED_NAME_1=(Token)match(input,RULE_UNRESTRICTED_NAME,FOLLOW_RULE_UNRESTRICTED_NAME_in_ruleName250); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_UNRESTRICTED_NAME_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_UNRESTRICTED_NAME_1, grammarAccess.getNameAccess().getUNRESTRICTED_NAMETerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleName"


    // $ANTLR start "entryRuleQualifiedName"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:149:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:150:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:151:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName296);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName307); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:158:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_Name_0= ruleName (kw= '::' this_Name_2= ruleName )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Name_0 = null;

        AntlrDatatypeRuleToken this_Name_2 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:161:28: ( (this_Name_0= ruleName (kw= '::' this_Name_2= ruleName )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:162:1: (this_Name_0= ruleName (kw= '::' this_Name_2= ruleName )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:162:1: (this_Name_0= ruleName (kw= '::' this_Name_2= ruleName )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:163:5: this_Name_0= ruleName (kw= '::' this_Name_2= ruleName )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getNameParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleName_in_ruleQualifiedName354);
            this_Name_0=ruleName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_Name_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:173:1: (kw= '::' this_Name_2= ruleName )*
            loop3:
            do {
                int alt3=2;
                alt3 = dfa3.predict(input);
                switch (alt3) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:174:2: kw= '::' this_Name_2= ruleName
            	    {
            	    kw=(Token)match(input,13,FOLLOW_13_in_ruleQualifiedName373); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getColonColonKeyword_1_0()); 
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getNameParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleName_in_ruleQualifiedName395);
            	    this_Name_2=ruleName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_Name_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:198:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:199:2: (iv_ruleExpression= ruleExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:200:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression442);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression452); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:207:1: ruleExpression returns [EObject current=null] : (this_AssignmentExpression_0= ruleAssignmentExpression | this_ConditionalExpression_1= ruleConditionalExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;

        EObject this_ConditionalExpression_1 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:210:28: ( (this_AssignmentExpression_0= ruleAssignmentExpression | this_ConditionalExpression_1= ruleConditionalExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:211:1: (this_AssignmentExpression_0= ruleAssignmentExpression | this_ConditionalExpression_1= ruleConditionalExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:211:1: (this_AssignmentExpression_0= ruleAssignmentExpression | this_ConditionalExpression_1= ruleConditionalExpression )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:212:2: this_AssignmentExpression_0= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleAssignmentExpression_in_ruleExpression502);
                    this_AssignmentExpression_0=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_AssignmentExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:225:2: this_ConditionalExpression_1= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpressionAccess().getConditionalExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleExpression532);
                    this_ConditionalExpression_1=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ConditionalExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:244:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:245:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:246:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression567);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression577); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:253:1: rulePrimaryExpression returns [EObject current=null] : (this_BaseExpression_0= ruleBaseExpression ( ( () (otherlv_2= '.' | ( (lv_isStatic_3_0= '::' ) ) ) ( ( ruleName ) ) ( (lv_parameters_5_0= ruleTuple ) ) ) | ( () otherlv_7= '.' ( ( ruleName ) ) ) | ( () otherlv_10= '->' ( ( ruleName ) ) ) | ( () ( (lv_index_13_0= ruleIndex ) ) ) )* ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_isStatic_3_0=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject this_BaseExpression_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_index_13_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:256:28: ( (this_BaseExpression_0= ruleBaseExpression ( ( () (otherlv_2= '.' | ( (lv_isStatic_3_0= '::' ) ) ) ( ( ruleName ) ) ( (lv_parameters_5_0= ruleTuple ) ) ) | ( () otherlv_7= '.' ( ( ruleName ) ) ) | ( () otherlv_10= '->' ( ( ruleName ) ) ) | ( () ( (lv_index_13_0= ruleIndex ) ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:257:1: (this_BaseExpression_0= ruleBaseExpression ( ( () (otherlv_2= '.' | ( (lv_isStatic_3_0= '::' ) ) ) ( ( ruleName ) ) ( (lv_parameters_5_0= ruleTuple ) ) ) | ( () otherlv_7= '.' ( ( ruleName ) ) ) | ( () otherlv_10= '->' ( ( ruleName ) ) ) | ( () ( (lv_index_13_0= ruleIndex ) ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:257:1: (this_BaseExpression_0= ruleBaseExpression ( ( () (otherlv_2= '.' | ( (lv_isStatic_3_0= '::' ) ) ) ( ( ruleName ) ) ( (lv_parameters_5_0= ruleTuple ) ) ) | ( () otherlv_7= '.' ( ( ruleName ) ) ) | ( () otherlv_10= '->' ( ( ruleName ) ) ) | ( () ( (lv_index_13_0= ruleIndex ) ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:258:2: this_BaseExpression_0= ruleBaseExpression ( ( () (otherlv_2= '.' | ( (lv_isStatic_3_0= '::' ) ) ) ( ( ruleName ) ) ( (lv_parameters_5_0= ruleTuple ) ) ) | ( () otherlv_7= '.' ( ( ruleName ) ) ) | ( () otherlv_10= '->' ( ( ruleName ) ) ) | ( () ( (lv_index_13_0= ruleIndex ) ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBaseExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleBaseExpression_in_rulePrimaryExpression627);
            this_BaseExpression_0=ruleBaseExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_BaseExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:269:1: ( ( () (otherlv_2= '.' | ( (lv_isStatic_3_0= '::' ) ) ) ( ( ruleName ) ) ( (lv_parameters_5_0= ruleTuple ) ) ) | ( () otherlv_7= '.' ( ( ruleName ) ) ) | ( () otherlv_10= '->' ( ( ruleName ) ) ) | ( () ( (lv_index_13_0= ruleIndex ) ) ) )*
            loop6:
            do {
                int alt6=5;
                switch ( input.LA(1) ) {
                case 14:
                    {
                    int LA6_2 = input.LA(2);

                    if ( (LA6_2==RULE_ID) ) {
                        int LA6_6 = input.LA(3);

                        if ( (LA6_6==18) ) {
                            alt6=1;
                        }
                        else if ( (synpred7_InternalReducedAlfLanguage()) ) {
                            alt6=2;
                        }


                    }
                    else if ( (LA6_2==RULE_UNRESTRICTED_NAME) ) {
                        int LA6_7 = input.LA(3);

                        if ( (LA6_7==18) ) {
                            alt6=1;
                        }
                        else if ( (synpred7_InternalReducedAlfLanguage()) ) {
                            alt6=2;
                        }


                    }


                    }
                    break;
                case 13:
                    {
                    alt6=1;
                    }
                    break;
                case 15:
                    {
                    alt6=3;
                    }
                    break;
                case 30:
                    {
                    alt6=4;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:269:2: ( () (otherlv_2= '.' | ( (lv_isStatic_3_0= '::' ) ) ) ( ( ruleName ) ) ( (lv_parameters_5_0= ruleTuple ) ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:269:2: ( () (otherlv_2= '.' | ( (lv_isStatic_3_0= '::' ) ) ) ( ( ruleName ) ) ( (lv_parameters_5_0= ruleTuple ) ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:269:3: () (otherlv_2= '.' | ( (lv_isStatic_3_0= '::' ) ) ) ( ( ruleName ) ) ( (lv_parameters_5_0= ruleTuple ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:269:3: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:270:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getPrimaryExpressionAccess().getFeatureInvocationExpressionContextAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:278:2: (otherlv_2= '.' | ( (lv_isStatic_3_0= '::' ) ) )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==14) ) {
            	        alt5=1;
            	    }
            	    else if ( (LA5_0==13) ) {
            	        alt5=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:278:4: otherlv_2= '.'
            	            {
            	            otherlv_2=(Token)match(input,14,FOLLOW_14_in_rulePrimaryExpression653); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_0_1_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:283:6: ( (lv_isStatic_3_0= '::' ) )
            	            {
            	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:283:6: ( (lv_isStatic_3_0= '::' ) )
            	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:284:1: (lv_isStatic_3_0= '::' )
            	            {
            	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:284:1: (lv_isStatic_3_0= '::' )
            	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:285:3: lv_isStatic_3_0= '::'
            	            {
            	            lv_isStatic_3_0=(Token)match(input,13,FOLLOW_13_in_rulePrimaryExpression677); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      newLeafNode(lv_isStatic_3_0, grammarAccess.getPrimaryExpressionAccess().getIsStaticColonColonKeyword_1_0_1_1_0());
            	                  
            	            }
            	            if ( state.backtracking==0 ) {

            	              	        if (current==null) {
            	              	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
            	              	        }
            	                     		setWithLastConsumed(current, "isStatic", true, "::");
            	              	    
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:298:3: ( ( ruleName ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:299:1: ( ruleName )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:299:1: ( ruleName )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:300:3: ruleName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOperationOperationCrossReference_1_0_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleName_in_rulePrimaryExpression718);
            	    ruleName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:316:2: ( (lv_parameters_5_0= ruleTuple ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:317:1: (lv_parameters_5_0= ruleTuple )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:317:1: (lv_parameters_5_0= ruleTuple )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:318:3: lv_parameters_5_0= ruleTuple
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParametersTupleParserRuleCall_1_0_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTuple_in_rulePrimaryExpression739);
            	    lv_parameters_5_0=ruleTuple();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"parameters",
            	              		lv_parameters_5_0, 
            	              		"Tuple");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:335:6: ( () otherlv_7= '.' ( ( ruleName ) ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:335:6: ( () otherlv_7= '.' ( ( ruleName ) ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:335:7: () otherlv_7= '.' ( ( ruleName ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:335:7: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:336:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getPrimaryExpressionAccess().getPropertyAccessExpressionContextAction_1_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_7=(Token)match(input,14,FOLLOW_14_in_rulePrimaryExpression771); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getPrimaryExpressionAccess().getFullStopKeyword_1_1_1());
            	          
            	    }
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:348:1: ( ( ruleName ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:349:1: ( ruleName )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:349:1: ( ruleName )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:350:3: ruleName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPropertyPropertyCrossReference_1_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleName_in_rulePrimaryExpression798);
            	    ruleName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:367:6: ( () otherlv_10= '->' ( ( ruleName ) ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:367:6: ( () otherlv_10= '->' ( ( ruleName ) ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:367:7: () otherlv_10= '->' ( ( ruleName ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:367:7: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:368:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getPrimaryExpressionAccess().getAssociationAccessExpressionContextAction_1_2_0(),
            	                  current);
            	          
            	    }

            	    }

            	    otherlv_10=(Token)match(input,15,FOLLOW_15_in_rulePrimaryExpression830); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_10, grammarAccess.getPrimaryExpressionAccess().getHyphenMinusGreaterThanSignKeyword_1_2_1());
            	          
            	    }
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:380:1: ( ( ruleName ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:381:1: ( ruleName )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:381:1: ( ruleName )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:382:3: ruleName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getPrimaryExpressionRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getAssociationPropertyCrossReference_1_2_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleName_in_rulePrimaryExpression857);
            	    ruleName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:399:6: ( () ( (lv_index_13_0= ruleIndex ) ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:399:6: ( () ( (lv_index_13_0= ruleIndex ) ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:399:7: () ( (lv_index_13_0= ruleIndex ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:399:7: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:400:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getPrimaryExpressionAccess().getSequenceAccessExpressionPrimaryAction_1_3_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:408:2: ( (lv_index_13_0= ruleIndex ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:409:1: (lv_index_13_0= ruleIndex )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:409:1: (lv_index_13_0= ruleIndex )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:410:3: lv_index_13_0= ruleIndex
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIndexIndexParserRuleCall_1_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleIndex_in_rulePrimaryExpression898);
            	    lv_index_13_0=ruleIndex();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"index",
            	              		lv_index_13_0, 
            	              		"Index");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleBaseExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:434:1: entryRuleBaseExpression returns [EObject current=null] : iv_ruleBaseExpression= ruleBaseExpression EOF ;
    public final EObject entryRuleBaseExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBaseExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:435:2: (iv_ruleBaseExpression= ruleBaseExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:436:2: iv_ruleBaseExpression= ruleBaseExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBaseExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBaseExpression_in_entryRuleBaseExpression937);
            iv_ruleBaseExpression=ruleBaseExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBaseExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBaseExpression947); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBaseExpression"


    // $ANTLR start "ruleBaseExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:443:1: ruleBaseExpression returns [EObject current=null] : (this_LiteralExpression_0= ruleLiteralExpression | this_CollectionLiteralExpression_1= ruleCollectionLiteralExpression | this_ThisExpression_2= ruleThisExpression | this_SuperInvocationExpression_3= ruleSuperInvocationExpression | this_InstanceCreationOrSequenceConstructionExpression_4= ruleInstanceCreationOrSequenceConstructionExpression | this_ClassExtentExpression_5= ruleClassExtentExpression | this_LinkOperationExpression_6= ruleLinkOperationExpression | this_NullExpression_7= ruleNullExpression | this_NameExpression_8= ruleNameExpression | this_ParenthesizedExpression_9= ruleParenthesizedExpression ) ;
    public final EObject ruleBaseExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralExpression_0 = null;

        EObject this_CollectionLiteralExpression_1 = null;

        EObject this_ThisExpression_2 = null;

        EObject this_SuperInvocationExpression_3 = null;

        EObject this_InstanceCreationOrSequenceConstructionExpression_4 = null;

        EObject this_ClassExtentExpression_5 = null;

        EObject this_LinkOperationExpression_6 = null;

        EObject this_NullExpression_7 = null;

        EObject this_NameExpression_8 = null;

        EObject this_ParenthesizedExpression_9 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:446:28: ( (this_LiteralExpression_0= ruleLiteralExpression | this_CollectionLiteralExpression_1= ruleCollectionLiteralExpression | this_ThisExpression_2= ruleThisExpression | this_SuperInvocationExpression_3= ruleSuperInvocationExpression | this_InstanceCreationOrSequenceConstructionExpression_4= ruleInstanceCreationOrSequenceConstructionExpression | this_ClassExtentExpression_5= ruleClassExtentExpression | this_LinkOperationExpression_6= ruleLinkOperationExpression | this_NullExpression_7= ruleNullExpression | this_NameExpression_8= ruleNameExpression | this_ParenthesizedExpression_9= ruleParenthesizedExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:447:1: (this_LiteralExpression_0= ruleLiteralExpression | this_CollectionLiteralExpression_1= ruleCollectionLiteralExpression | this_ThisExpression_2= ruleThisExpression | this_SuperInvocationExpression_3= ruleSuperInvocationExpression | this_InstanceCreationOrSequenceConstructionExpression_4= ruleInstanceCreationOrSequenceConstructionExpression | this_ClassExtentExpression_5= ruleClassExtentExpression | this_LinkOperationExpression_6= ruleLinkOperationExpression | this_NullExpression_7= ruleNullExpression | this_NameExpression_8= ruleNameExpression | this_ParenthesizedExpression_9= ruleParenthesizedExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:447:1: (this_LiteralExpression_0= ruleLiteralExpression | this_CollectionLiteralExpression_1= ruleCollectionLiteralExpression | this_ThisExpression_2= ruleThisExpression | this_SuperInvocationExpression_3= ruleSuperInvocationExpression | this_InstanceCreationOrSequenceConstructionExpression_4= ruleInstanceCreationOrSequenceConstructionExpression | this_ClassExtentExpression_5= ruleClassExtentExpression | this_LinkOperationExpression_6= ruleLinkOperationExpression | this_NullExpression_7= ruleNullExpression | this_NameExpression_8= ruleNameExpression | this_ParenthesizedExpression_9= ruleParenthesizedExpression )
            int alt7=10;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:448:2: this_LiteralExpression_0= ruleLiteralExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBaseExpressionAccess().getLiteralExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLiteralExpression_in_ruleBaseExpression997);
                    this_LiteralExpression_0=ruleLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LiteralExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:461:2: this_CollectionLiteralExpression_1= ruleCollectionLiteralExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBaseExpressionAccess().getCollectionLiteralExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCollectionLiteralExpression_in_ruleBaseExpression1027);
                    this_CollectionLiteralExpression_1=ruleCollectionLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionLiteralExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:474:2: this_ThisExpression_2= ruleThisExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBaseExpressionAccess().getThisExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleThisExpression_in_ruleBaseExpression1057);
                    this_ThisExpression_2=ruleThisExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ThisExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:487:2: this_SuperInvocationExpression_3= ruleSuperInvocationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBaseExpressionAccess().getSuperInvocationExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSuperInvocationExpression_in_ruleBaseExpression1087);
                    this_SuperInvocationExpression_3=ruleSuperInvocationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SuperInvocationExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:500:2: this_InstanceCreationOrSequenceConstructionExpression_4= ruleInstanceCreationOrSequenceConstructionExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBaseExpressionAccess().getInstanceCreationOrSequenceConstructionExpressionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleInstanceCreationOrSequenceConstructionExpression_in_ruleBaseExpression1117);
                    this_InstanceCreationOrSequenceConstructionExpression_4=ruleInstanceCreationOrSequenceConstructionExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_InstanceCreationOrSequenceConstructionExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:513:2: this_ClassExtentExpression_5= ruleClassExtentExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBaseExpressionAccess().getClassExtentExpressionParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClassExtentExpression_in_ruleBaseExpression1147);
                    this_ClassExtentExpression_5=ruleClassExtentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ClassExtentExpression_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:526:2: this_LinkOperationExpression_6= ruleLinkOperationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBaseExpressionAccess().getLinkOperationExpressionParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLinkOperationExpression_in_ruleBaseExpression1177);
                    this_LinkOperationExpression_6=ruleLinkOperationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LinkOperationExpression_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:539:2: this_NullExpression_7= ruleNullExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBaseExpressionAccess().getNullExpressionParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNullExpression_in_ruleBaseExpression1207);
                    this_NullExpression_7=ruleNullExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NullExpression_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:552:2: this_NameExpression_8= ruleNameExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBaseExpressionAccess().getNameExpressionParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNameExpression_in_ruleBaseExpression1237);
                    this_NameExpression_8=ruleNameExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NameExpression_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:565:2: this_ParenthesizedExpression_9= ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBaseExpressionAccess().getParenthesizedExpressionParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleParenthesizedExpression_in_ruleBaseExpression1267);
                    this_ParenthesizedExpression_9=ruleParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ParenthesizedExpression_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBaseExpression"


    // $ANTLR start "entryRuleLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:584:1: entryRuleLiteralExpression returns [EObject current=null] : iv_ruleLiteralExpression= ruleLiteralExpression EOF ;
    public final EObject entryRuleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:585:2: (iv_ruleLiteralExpression= ruleLiteralExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:586:2: iv_ruleLiteralExpression= ruleLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLiteralExpression_in_entryRuleLiteralExpression1302);
            iv_ruleLiteralExpression=ruleLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralExpression1312); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralExpression"


    // $ANTLR start "ruleLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:593:1: ruleLiteralExpression returns [EObject current=null] : (this_BooleanLiteralExpression_0= ruleBooleanLiteralExpression | this_NaturalLiteralExpression_1= ruleNaturalLiteralExpression | this_RealLiteralExpression_2= ruleRealLiteralExpression | this_UnboundedLiteralExpression_3= ruleUnboundedLiteralExpression | this_StringLiteralExpression_4= ruleStringLiteralExpression ) ;
    public final EObject ruleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteralExpression_0 = null;

        EObject this_NaturalLiteralExpression_1 = null;

        EObject this_RealLiteralExpression_2 = null;

        EObject this_UnboundedLiteralExpression_3 = null;

        EObject this_StringLiteralExpression_4 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:596:28: ( (this_BooleanLiteralExpression_0= ruleBooleanLiteralExpression | this_NaturalLiteralExpression_1= ruleNaturalLiteralExpression | this_RealLiteralExpression_2= ruleRealLiteralExpression | this_UnboundedLiteralExpression_3= ruleUnboundedLiteralExpression | this_StringLiteralExpression_4= ruleStringLiteralExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:597:1: (this_BooleanLiteralExpression_0= ruleBooleanLiteralExpression | this_NaturalLiteralExpression_1= ruleNaturalLiteralExpression | this_RealLiteralExpression_2= ruleRealLiteralExpression | this_UnboundedLiteralExpression_3= ruleUnboundedLiteralExpression | this_StringLiteralExpression_4= ruleStringLiteralExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:597:1: (this_BooleanLiteralExpression_0= ruleBooleanLiteralExpression | this_NaturalLiteralExpression_1= ruleNaturalLiteralExpression | this_RealLiteralExpression_2= ruleRealLiteralExpression | this_UnboundedLiteralExpression_3= ruleUnboundedLiteralExpression | this_StringLiteralExpression_4= ruleStringLiteralExpression )
            int alt8=5;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN_VALUE:
                {
                alt8=1;
                }
                break;
            case RULE_NATURAL_VALUE:
                {
                alt8=2;
                }
                break;
            case RULE_REAL_VALUE:
                {
                alt8=3;
                }
                break;
            case 16:
                {
                alt8=4;
                }
                break;
            case RULE_STRING:
                {
                alt8=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:598:2: this_BooleanLiteralExpression_0= ruleBooleanLiteralExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralExpressionAccess().getBooleanLiteralExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanLiteralExpression_in_ruleLiteralExpression1362);
                    this_BooleanLiteralExpression_0=ruleBooleanLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BooleanLiteralExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:611:2: this_NaturalLiteralExpression_1= ruleNaturalLiteralExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralExpressionAccess().getNaturalLiteralExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNaturalLiteralExpression_in_ruleLiteralExpression1392);
                    this_NaturalLiteralExpression_1=ruleNaturalLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NaturalLiteralExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:624:2: this_RealLiteralExpression_2= ruleRealLiteralExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralExpressionAccess().getRealLiteralExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRealLiteralExpression_in_ruleLiteralExpression1422);
                    this_RealLiteralExpression_2=ruleRealLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RealLiteralExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:637:2: this_UnboundedLiteralExpression_3= ruleUnboundedLiteralExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralExpressionAccess().getUnboundedLiteralExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnboundedLiteralExpression_in_ruleLiteralExpression1452);
                    this_UnboundedLiteralExpression_3=ruleUnboundedLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnboundedLiteralExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:650:2: this_StringLiteralExpression_4= ruleStringLiteralExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLiteralExpressionAccess().getStringLiteralExpressionParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleStringLiteralExpression_in_ruleLiteralExpression1482);
                    this_StringLiteralExpression_4=ruleStringLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringLiteralExpression_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralExpression"


    // $ANTLR start "entryRuleBooleanLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:669:1: entryRuleBooleanLiteralExpression returns [EObject current=null] : iv_ruleBooleanLiteralExpression= ruleBooleanLiteralExpression EOF ;
    public final EObject entryRuleBooleanLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:670:2: (iv_ruleBooleanLiteralExpression= ruleBooleanLiteralExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:671:2: iv_ruleBooleanLiteralExpression= ruleBooleanLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanLiteralExpression_in_entryRuleBooleanLiteralExpression1517);
            iv_ruleBooleanLiteralExpression=ruleBooleanLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralExpression1527); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteralExpression"


    // $ANTLR start "ruleBooleanLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:678:1: ruleBooleanLiteralExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN_VALUE ) ) ;
    public final EObject ruleBooleanLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:681:28: ( ( (lv_value_0_0= RULE_BOOLEAN_VALUE ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:682:1: ( (lv_value_0_0= RULE_BOOLEAN_VALUE ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:682:1: ( (lv_value_0_0= RULE_BOOLEAN_VALUE ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:683:1: (lv_value_0_0= RULE_BOOLEAN_VALUE )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:683:1: (lv_value_0_0= RULE_BOOLEAN_VALUE )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:684:3: lv_value_0_0= RULE_BOOLEAN_VALUE
            {
            lv_value_0_0=(Token)match(input,RULE_BOOLEAN_VALUE,FOLLOW_RULE_BOOLEAN_VALUE_in_ruleBooleanLiteralExpression1568); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_0_0, grammarAccess.getBooleanLiteralExpressionAccess().getValueBOOLEAN_VALUETerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getBooleanLiteralExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"BOOLEAN_VALUE");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteralExpression"


    // $ANTLR start "entryRuleNaturalLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:708:1: entryRuleNaturalLiteralExpression returns [EObject current=null] : iv_ruleNaturalLiteralExpression= ruleNaturalLiteralExpression EOF ;
    public final EObject entryRuleNaturalLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNaturalLiteralExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:709:2: (iv_ruleNaturalLiteralExpression= ruleNaturalLiteralExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:710:2: iv_ruleNaturalLiteralExpression= ruleNaturalLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNaturalLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNaturalLiteralExpression_in_entryRuleNaturalLiteralExpression1608);
            iv_ruleNaturalLiteralExpression=ruleNaturalLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNaturalLiteralExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNaturalLiteralExpression1618); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNaturalLiteralExpression"


    // $ANTLR start "ruleNaturalLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:717:1: ruleNaturalLiteralExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_NATURAL_VALUE ) ) ;
    public final EObject ruleNaturalLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:720:28: ( ( (lv_value_0_0= RULE_NATURAL_VALUE ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:721:1: ( (lv_value_0_0= RULE_NATURAL_VALUE ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:721:1: ( (lv_value_0_0= RULE_NATURAL_VALUE ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:722:1: (lv_value_0_0= RULE_NATURAL_VALUE )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:722:1: (lv_value_0_0= RULE_NATURAL_VALUE )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:723:3: lv_value_0_0= RULE_NATURAL_VALUE
            {
            lv_value_0_0=(Token)match(input,RULE_NATURAL_VALUE,FOLLOW_RULE_NATURAL_VALUE_in_ruleNaturalLiteralExpression1659); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_0_0, grammarAccess.getNaturalLiteralExpressionAccess().getValueNATURAL_VALUETerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNaturalLiteralExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"NATURAL_VALUE");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNaturalLiteralExpression"


    // $ANTLR start "entryRuleRealLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:747:1: entryRuleRealLiteralExpression returns [EObject current=null] : iv_ruleRealLiteralExpression= ruleRealLiteralExpression EOF ;
    public final EObject entryRuleRealLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealLiteralExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:748:2: (iv_ruleRealLiteralExpression= ruleRealLiteralExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:749:2: iv_ruleRealLiteralExpression= ruleRealLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRealLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRealLiteralExpression_in_entryRuleRealLiteralExpression1699);
            iv_ruleRealLiteralExpression=ruleRealLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRealLiteralExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealLiteralExpression1709); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealLiteralExpression"


    // $ANTLR start "ruleRealLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:756:1: ruleRealLiteralExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_REAL_VALUE ) ) ;
    public final EObject ruleRealLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:759:28: ( ( (lv_value_0_0= RULE_REAL_VALUE ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:760:1: ( (lv_value_0_0= RULE_REAL_VALUE ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:760:1: ( (lv_value_0_0= RULE_REAL_VALUE ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:761:1: (lv_value_0_0= RULE_REAL_VALUE )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:761:1: (lv_value_0_0= RULE_REAL_VALUE )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:762:3: lv_value_0_0= RULE_REAL_VALUE
            {
            lv_value_0_0=(Token)match(input,RULE_REAL_VALUE,FOLLOW_RULE_REAL_VALUE_in_ruleRealLiteralExpression1750); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_0_0, grammarAccess.getRealLiteralExpressionAccess().getValueREAL_VALUETerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getRealLiteralExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"REAL_VALUE");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealLiteralExpression"


    // $ANTLR start "entryRuleUnboundedLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:786:1: entryRuleUnboundedLiteralExpression returns [EObject current=null] : iv_ruleUnboundedLiteralExpression= ruleUnboundedLiteralExpression EOF ;
    public final EObject entryRuleUnboundedLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnboundedLiteralExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:787:2: (iv_ruleUnboundedLiteralExpression= ruleUnboundedLiteralExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:788:2: iv_ruleUnboundedLiteralExpression= ruleUnboundedLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnboundedLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnboundedLiteralExpression_in_entryRuleUnboundedLiteralExpression1790);
            iv_ruleUnboundedLiteralExpression=ruleUnboundedLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnboundedLiteralExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnboundedLiteralExpression1800); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnboundedLiteralExpression"


    // $ANTLR start "ruleUnboundedLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:795:1: ruleUnboundedLiteralExpression returns [EObject current=null] : ( () ( (lv_value_1_0= '*' ) ) ) ;
    public final EObject ruleUnboundedLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:798:28: ( ( () ( (lv_value_1_0= '*' ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:799:1: ( () ( (lv_value_1_0= '*' ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:799:1: ( () ( (lv_value_1_0= '*' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:799:2: () ( (lv_value_1_0= '*' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:799:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:800:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnboundedLiteralExpressionAccess().getUnboundedLiteralExpressionAction_0(),
                          current);
                  
            }

            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:808:2: ( (lv_value_1_0= '*' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:809:1: (lv_value_1_0= '*' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:809:1: (lv_value_1_0= '*' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:810:3: lv_value_1_0= '*'
            {
            lv_value_1_0=(Token)match(input,16,FOLLOW_16_in_ruleUnboundedLiteralExpression1855); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_value_1_0, grammarAccess.getUnboundedLiteralExpressionAccess().getValueAsteriskKeyword_1_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getUnboundedLiteralExpressionRule());
              	        }
                     		setWithLastConsumed(current, "value", lv_value_1_0, "*");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnboundedLiteralExpression"


    // $ANTLR start "entryRuleStringLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:831:1: entryRuleStringLiteralExpression returns [EObject current=null] : iv_ruleStringLiteralExpression= ruleStringLiteralExpression EOF ;
    public final EObject entryRuleStringLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:832:2: (iv_ruleStringLiteralExpression= ruleStringLiteralExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:833:2: iv_ruleStringLiteralExpression= ruleStringLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleStringLiteralExpression_in_entryRuleStringLiteralExpression1904);
            iv_ruleStringLiteralExpression=ruleStringLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralExpression1914); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteralExpression"


    // $ANTLR start "ruleStringLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:840:1: ruleStringLiteralExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:843:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:844:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:844:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:845:1: (lv_value_0_0= RULE_STRING )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:845:1: (lv_value_0_0= RULE_STRING )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:846:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteralExpression1955); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralExpressionAccess().getValueSTRINGTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getStringLiteralExpressionRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"value",
                      		lv_value_0_0, 
                      		"STRING");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteralExpression"


    // $ANTLR start "entryRuleNameExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:870:1: entryRuleNameExpression returns [EObject current=null] : iv_ruleNameExpression= ruleNameExpression EOF ;
    public final EObject entryRuleNameExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:871:2: (iv_ruleNameExpression= ruleNameExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:872:2: iv_ruleNameExpression= ruleNameExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNameExpression_in_entryRuleNameExpression1995);
            iv_ruleNameExpression=ruleNameExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameExpression2005); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNameExpression"


    // $ANTLR start "ruleNameExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:879:1: ruleNameExpression returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleNameExpression() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:882:28: ( ( ( ruleQualifiedName ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:883:1: ( ( ruleQualifiedName ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:883:1: ( ( ruleQualifiedName ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:884:1: ( ruleQualifiedName )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:884:1: ( ruleQualifiedName )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:885:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getNameExpressionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNameExpressionAccess().getReferenceNamedElementCrossReference_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleNameExpression2056);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNameExpression"


    // $ANTLR start "entryRuleThisExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:909:1: entryRuleThisExpression returns [EObject current=null] : iv_ruleThisExpression= ruleThisExpression EOF ;
    public final EObject entryRuleThisExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThisExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:910:2: (iv_ruleThisExpression= ruleThisExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:911:2: iv_ruleThisExpression= ruleThisExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThisExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleThisExpression_in_entryRuleThisExpression2091);
            iv_ruleThisExpression=ruleThisExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThisExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleThisExpression2101); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThisExpression"


    // $ANTLR start "ruleThisExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:918:1: ruleThisExpression returns [EObject current=null] : ( ( () otherlv_1= 'this' ( (lv_tuple_2_0= ruleTuple ) ) ) | ( () otherlv_4= 'this' ) ) ;
    public final EObject ruleThisExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_tuple_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:921:28: ( ( ( () otherlv_1= 'this' ( (lv_tuple_2_0= ruleTuple ) ) ) | ( () otherlv_4= 'this' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:922:1: ( ( () otherlv_1= 'this' ( (lv_tuple_2_0= ruleTuple ) ) ) | ( () otherlv_4= 'this' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:922:1: ( ( () otherlv_1= 'this' ( (lv_tuple_2_0= ruleTuple ) ) ) | ( () otherlv_4= 'this' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==18) ) {
                    alt9=1;
                }
                else if ( (LA9_1==EOF||(LA9_1>=13 && LA9_1<=16)||(LA9_1>=19 && LA9_1<=20)||(LA9_1>=26 && LA9_1<=27)||(LA9_1>=29 && LA9_1<=31)||(LA9_1>=35 && LA9_1<=46)||(LA9_1>=60 && LA9_1<=61)||(LA9_1>=70 && LA9_1<=78)) ) {
                    alt9=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:922:2: ( () otherlv_1= 'this' ( (lv_tuple_2_0= ruleTuple ) ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:922:2: ( () otherlv_1= 'this' ( (lv_tuple_2_0= ruleTuple ) ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:922:3: () otherlv_1= 'this' ( (lv_tuple_2_0= ruleTuple ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:922:3: ()
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:923:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getThisExpressionAccess().getFeatureInvocationExpressionAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleThisExpression2151); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getThisExpressionAccess().getThisKeyword_0_1());
                          
                    }
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:935:1: ( (lv_tuple_2_0= ruleTuple ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:936:1: (lv_tuple_2_0= ruleTuple )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:936:1: (lv_tuple_2_0= ruleTuple )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:937:3: lv_tuple_2_0= ruleTuple
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getThisExpressionAccess().getTupleTupleParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTuple_in_ruleThisExpression2172);
                    lv_tuple_2_0=ruleTuple();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getThisExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"tuple",
                              		lv_tuple_2_0, 
                              		"Tuple");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:954:6: ( () otherlv_4= 'this' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:954:6: ( () otherlv_4= 'this' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:954:7: () otherlv_4= 'this'
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:954:7: ()
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:955:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getThisExpressionAccess().getThisExpressionAction_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleThisExpression2204); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getThisExpressionAccess().getThisKeyword_1_1());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThisExpression"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:975:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:976:2: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:977:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression2241);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleParenthesizedExpression2251); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:984:1: ruleParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:987:28: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:988:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:988:1: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:988:3: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleParenthesizedExpression2288); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleParenthesizedExpression2313);
            this_Expression_1=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Expression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleParenthesizedExpression2324); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRulePropertyAccessExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1016:1: entryRulePropertyAccessExpression returns [EObject current=null] : iv_rulePropertyAccessExpression= rulePropertyAccessExpression EOF ;
    public final EObject entryRulePropertyAccessExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAccessExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1017:2: (iv_rulePropertyAccessExpression= rulePropertyAccessExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1018:2: iv_rulePropertyAccessExpression= rulePropertyAccessExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyAccessExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePropertyAccessExpression_in_entryRulePropertyAccessExpression2360);
            iv_rulePropertyAccessExpression=rulePropertyAccessExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyAccessExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyAccessExpression2370); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyAccessExpression"


    // $ANTLR start "rulePropertyAccessExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1025:1: rulePropertyAccessExpression returns [EObject current=null] : ( ( (lv_context_0_0= rulePrimaryExpression ) ) otherlv_1= '.' ( ( ruleName ) ) ) ;
    public final EObject rulePropertyAccessExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_context_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1028:28: ( ( ( (lv_context_0_0= rulePrimaryExpression ) ) otherlv_1= '.' ( ( ruleName ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1029:1: ( ( (lv_context_0_0= rulePrimaryExpression ) ) otherlv_1= '.' ( ( ruleName ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1029:1: ( ( (lv_context_0_0= rulePrimaryExpression ) ) otherlv_1= '.' ( ( ruleName ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1029:2: ( (lv_context_0_0= rulePrimaryExpression ) ) otherlv_1= '.' ( ( ruleName ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1029:2: ( (lv_context_0_0= rulePrimaryExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1030:1: (lv_context_0_0= rulePrimaryExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1030:1: (lv_context_0_0= rulePrimaryExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1031:3: lv_context_0_0= rulePrimaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyAccessExpressionAccess().getContextPrimaryExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePrimaryExpression_in_rulePropertyAccessExpression2416);
            lv_context_0_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPropertyAccessExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"context",
                      		lv_context_0_0, 
                      		"PrimaryExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_rulePropertyAccessExpression2428); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPropertyAccessExpressionAccess().getFullStopKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1051:1: ( ( ruleName ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1052:1: ( ruleName )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1052:1: ( ruleName )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1053:3: ruleName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPropertyAccessExpressionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPropertyAccessExpressionAccess().getPropertyPropertyCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleName_in_rulePropertyAccessExpression2455);
            ruleName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyAccessExpression"


    // $ANTLR start "entryRuleTuple"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1077:1: entryRuleTuple returns [EObject current=null] : iv_ruleTuple= ruleTuple EOF ;
    public final EObject entryRuleTuple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuple = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1078:2: (iv_ruleTuple= ruleTuple EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1079:2: iv_ruleTuple= ruleTuple EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleRule()); 
            }
            pushFollow(FOLLOW_ruleTuple_in_entryRuleTuple2491);
            iv_ruleTuple=ruleTuple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuple; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuple2501); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTuple"


    // $ANTLR start "ruleTuple"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1086:1: ruleTuple returns [EObject current=null] : ( ( () otherlv_1= '(' otherlv_2= ')' ) | (otherlv_3= '(' (this_NamedTupleExpressionList_4= ruleNamedTupleExpressionList | this_ExpressionList_5= ruleExpressionList ) otherlv_6= ')' ) ) ;
    public final EObject ruleTuple() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject this_NamedTupleExpressionList_4 = null;

        EObject this_ExpressionList_5 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1089:28: ( ( ( () otherlv_1= '(' otherlv_2= ')' ) | (otherlv_3= '(' (this_NamedTupleExpressionList_4= ruleNamedTupleExpressionList | this_ExpressionList_5= ruleExpressionList ) otherlv_6= ')' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1090:1: ( ( () otherlv_1= '(' otherlv_2= ')' ) | (otherlv_3= '(' (this_NamedTupleExpressionList_4= ruleNamedTupleExpressionList | this_ExpressionList_5= ruleExpressionList ) otherlv_6= ')' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1090:1: ( ( () otherlv_1= '(' otherlv_2= ')' ) | (otherlv_3= '(' (this_NamedTupleExpressionList_4= ruleNamedTupleExpressionList | this_ExpressionList_5= ruleExpressionList ) otherlv_6= ')' ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==19) ) {
                    int LA11_2 = input.LA(3);

                    if ( (synpred24_InternalReducedAlfLanguage()) ) {
                        alt11=1;
                    }
                    else if ( (true) ) {
                        alt11=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 2, input);

                        throw nvae;
                    }
                }
                else if ( ((LA11_1>=RULE_ID && LA11_1<=RULE_STRING)||(LA11_1>=16 && LA11_1<=18)||(LA11_1>=22 && LA11_1<=23)||LA11_1==25||LA11_1==28||(LA11_1>=32 && LA11_1<=34)||(LA11_1>=37 && LA11_1<=38)||(LA11_1>=65 && LA11_1<=69)) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1090:2: ( () otherlv_1= '(' otherlv_2= ')' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1090:2: ( () otherlv_1= '(' otherlv_2= ')' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1090:3: () otherlv_1= '(' otherlv_2= ')'
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1090:3: ()
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1091:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getTupleAccess().getExpressionListAction_0_0(),
                                  current);
                          
                    }

                    }

                    otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleTuple2551); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleAccess().getLeftParenthesisKeyword_0_1());
                          
                    }
                    otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleTuple2563); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTupleAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1108:6: (otherlv_3= '(' (this_NamedTupleExpressionList_4= ruleNamedTupleExpressionList | this_ExpressionList_5= ruleExpressionList ) otherlv_6= ')' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1108:6: (otherlv_3= '(' (this_NamedTupleExpressionList_4= ruleNamedTupleExpressionList | this_ExpressionList_5= ruleExpressionList ) otherlv_6= ')' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1108:8: otherlv_3= '(' (this_NamedTupleExpressionList_4= ruleNamedTupleExpressionList | this_ExpressionList_5= ruleExpressionList ) otherlv_6= ')'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleTuple2583); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTupleAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1112:1: (this_NamedTupleExpressionList_4= ruleNamedTupleExpressionList | this_ExpressionList_5= ruleExpressionList )
                    int alt10=2;
                    switch ( input.LA(1) ) {
                    case RULE_ID:
                        {
                        int LA10_1 = input.LA(2);

                        if ( (LA10_1==21) ) {
                            alt10=1;
                        }
                        else if ( ((LA10_1>=13 && LA10_1<=16)||(LA10_1>=19 && LA10_1<=20)||(LA10_1>=26 && LA10_1<=27)||LA10_1==30||(LA10_1>=35 && LA10_1<=44)||LA10_1==47||(LA10_1>=68 && LA10_1<=89)) ) {
                            alt10=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 1, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_UNRESTRICTED_NAME:
                        {
                        int LA10_2 = input.LA(2);

                        if ( ((LA10_2>=13 && LA10_2<=16)||(LA10_2>=19 && LA10_2<=20)||(LA10_2>=26 && LA10_2<=27)||LA10_2==30||(LA10_2>=35 && LA10_2<=44)||LA10_2==47||(LA10_2>=68 && LA10_2<=89)) ) {
                            alt10=2;
                        }
                        else if ( (LA10_2==21) ) {
                            alt10=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 2, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RULE_BOOLEAN_VALUE:
                    case RULE_NATURAL_VALUE:
                    case RULE_REAL_VALUE:
                    case RULE_STRING:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 22:
                    case 23:
                    case 25:
                    case 28:
                    case 32:
                    case 33:
                    case 34:
                    case 37:
                    case 38:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                        {
                        alt10=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;
                    }

                    switch (alt10) {
                        case 1 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1113:2: this_NamedTupleExpressionList_4= ruleNamedTupleExpressionList
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getTupleAccess().getNamedTupleExpressionListParserRuleCall_1_1_0()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleNamedTupleExpressionList_in_ruleTuple2609);
                            this_NamedTupleExpressionList_4=ruleNamedTupleExpressionList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                      current = this_NamedTupleExpressionList_4; 
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1126:2: this_ExpressionList_5= ruleExpressionList
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {
                               
                                      newCompositeNode(grammarAccess.getTupleAccess().getExpressionListParserRuleCall_1_1_1()); 
                                  
                            }
                            pushFollow(FOLLOW_ruleExpressionList_in_ruleTuple2639);
                            this_ExpressionList_5=ruleExpressionList();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {
                               
                                      current = this_ExpressionList_5; 
                                      afterParserOrEnumRuleCall();
                                  
                            }

                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,19,FOLLOW_19_in_ruleTuple2651); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getTupleAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTuple"


    // $ANTLR start "entryRuleExpressionList"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1149:1: entryRuleExpressionList returns [EObject current=null] : iv_ruleExpressionList= ruleExpressionList EOF ;
    public final EObject entryRuleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionList = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1150:2: (iv_ruleExpressionList= ruleExpressionList EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1151:2: iv_ruleExpressionList= ruleExpressionList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionListRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionList_in_entryRuleExpressionList2688);
            iv_ruleExpressionList=ruleExpressionList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionList2698); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionList"


    // $ANTLR start "ruleExpressionList"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1158:1: ruleExpressionList returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* )? ) ;
    public final EObject ruleExpressionList() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_expressions_1_0 = null;

        EObject lv_expressions_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1161:28: ( ( () ( ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* )? ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1162:1: ( () ( ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* )? )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1162:1: ( () ( ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* )? )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1162:2: () ( ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* )?
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1162:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1163:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getExpressionListAccess().getExpressionListAction_0(),
                          current);
                  
            }

            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1171:2: ( ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_STRING)||(LA13_0>=16 && LA13_0<=18)||(LA13_0>=22 && LA13_0<=23)||LA13_0==25||LA13_0==28||(LA13_0>=32 && LA13_0<=34)||(LA13_0>=37 && LA13_0<=38)||(LA13_0>=65 && LA13_0<=69)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1171:3: ( (lv_expressions_1_0= ruleExpression ) ) (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )*
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1171:3: ( (lv_expressions_1_0= ruleExpression ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1172:1: (lv_expressions_1_0= ruleExpression )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1172:1: (lv_expressions_1_0= ruleExpression )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1173:3: lv_expressions_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList2757);
                    lv_expressions_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionListRule());
                      	        }
                             		add(
                             			current, 
                             			"expressions",
                              		lv_expressions_1_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1189:2: (otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==20) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1189:4: otherlv_2= ',' ( (lv_expressions_3_0= ruleExpression ) )
                    	    {
                    	    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleExpressionList2770); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_2, grammarAccess.getExpressionListAccess().getCommaKeyword_1_1_0());
                    	          
                    	    }
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1193:1: ( (lv_expressions_3_0= ruleExpression ) )
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1194:1: (lv_expressions_3_0= ruleExpression )
                    	    {
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1194:1: (lv_expressions_3_0= ruleExpression )
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1195:3: lv_expressions_3_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getExpressionListAccess().getExpressionsExpressionParserRuleCall_1_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleExpression_in_ruleExpressionList2791);
                    	    lv_expressions_3_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getExpressionListRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"expressions",
                    	              		lv_expressions_3_0, 
                    	              		"Expression");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionList"


    // $ANTLR start "entryRuleNamedTupleExpressionList"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1219:1: entryRuleNamedTupleExpressionList returns [EObject current=null] : iv_ruleNamedTupleExpressionList= ruleNamedTupleExpressionList EOF ;
    public final EObject entryRuleNamedTupleExpressionList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedTupleExpressionList = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1220:2: (iv_ruleNamedTupleExpressionList= ruleNamedTupleExpressionList EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1221:2: iv_ruleNamedTupleExpressionList= ruleNamedTupleExpressionList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedTupleExpressionListRule()); 
            }
            pushFollow(FOLLOW_ruleNamedTupleExpressionList_in_entryRuleNamedTupleExpressionList2831);
            iv_ruleNamedTupleExpressionList=ruleNamedTupleExpressionList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedTupleExpressionList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedTupleExpressionList2841); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedTupleExpressionList"


    // $ANTLR start "ruleNamedTupleExpressionList"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1228:1: ruleNamedTupleExpressionList returns [EObject current=null] : ( ( (lv_expressions_0_0= ruleNamedExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleNamedExpression ) ) )* ) ;
    public final EObject ruleNamedTupleExpressionList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressions_0_0 = null;

        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1231:28: ( ( ( (lv_expressions_0_0= ruleNamedExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleNamedExpression ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1232:1: ( ( (lv_expressions_0_0= ruleNamedExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleNamedExpression ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1232:1: ( ( (lv_expressions_0_0= ruleNamedExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleNamedExpression ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1232:2: ( (lv_expressions_0_0= ruleNamedExpression ) ) (otherlv_1= ',' ( (lv_expressions_2_0= ruleNamedExpression ) ) )*
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1232:2: ( (lv_expressions_0_0= ruleNamedExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1233:1: (lv_expressions_0_0= ruleNamedExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1233:1: (lv_expressions_0_0= ruleNamedExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1234:3: lv_expressions_0_0= ruleNamedExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedTupleExpressionListAccess().getExpressionsNamedExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNamedExpression_in_ruleNamedTupleExpressionList2887);
            lv_expressions_0_0=ruleNamedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNamedTupleExpressionListRule());
              	        }
                     		add(
                     			current, 
                     			"expressions",
                      		lv_expressions_0_0, 
                      		"NamedExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1250:2: (otherlv_1= ',' ( (lv_expressions_2_0= ruleNamedExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==20) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1250:4: otherlv_1= ',' ( (lv_expressions_2_0= ruleNamedExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleNamedTupleExpressionList2900); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getNamedTupleExpressionListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1254:1: ( (lv_expressions_2_0= ruleNamedExpression ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1255:1: (lv_expressions_2_0= ruleNamedExpression )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1255:1: (lv_expressions_2_0= ruleNamedExpression )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1256:3: lv_expressions_2_0= ruleNamedExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNamedTupleExpressionListAccess().getExpressionsNamedExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNamedExpression_in_ruleNamedTupleExpressionList2921);
            	    lv_expressions_2_0=ruleNamedExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNamedTupleExpressionListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_2_0, 
            	              		"NamedExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamedTupleExpressionList"


    // $ANTLR start "entryRuleNamedExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1280:1: entryRuleNamedExpression returns [EObject current=null] : iv_ruleNamedExpression= ruleNamedExpression EOF ;
    public final EObject entryRuleNamedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1281:2: (iv_ruleNamedExpression= ruleNamedExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1282:2: iv_ruleNamedExpression= ruleNamedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNamedExpression_in_entryRuleNamedExpression2959);
            iv_ruleNamedExpression=ruleNamedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedExpression2969); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedExpression"


    // $ANTLR start "ruleNamedExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1289:1: ruleNamedExpression returns [EObject current=null] : ( ( (lv_name_0_0= ruleName ) ) otherlv_1= '=>' ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleNamedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1292:28: ( ( ( (lv_name_0_0= ruleName ) ) otherlv_1= '=>' ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1293:1: ( ( (lv_name_0_0= ruleName ) ) otherlv_1= '=>' ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1293:1: ( ( (lv_name_0_0= ruleName ) ) otherlv_1= '=>' ( (lv_expression_2_0= ruleExpression ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1293:2: ( (lv_name_0_0= ruleName ) ) otherlv_1= '=>' ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1293:2: ( (lv_name_0_0= ruleName ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1294:1: (lv_name_0_0= ruleName )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1294:1: (lv_name_0_0= ruleName )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1295:3: lv_name_0_0= ruleName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedExpressionAccess().getNameNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleName_in_ruleNamedExpression3015);
            lv_name_0_0=ruleName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNamedExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"Name");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleNamedExpression3027); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNamedExpressionAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1315:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1316:1: (lv_expression_2_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1316:1: (lv_expression_2_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1317:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNamedExpressionAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNamedExpression3048);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNamedExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamedExpression"


    // $ANTLR start "entryRuleSuperInvocationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1341:1: entryRuleSuperInvocationExpression returns [EObject current=null] : iv_ruleSuperInvocationExpression= ruleSuperInvocationExpression EOF ;
    public final EObject entryRuleSuperInvocationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperInvocationExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1342:2: (iv_ruleSuperInvocationExpression= ruleSuperInvocationExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1343:2: iv_ruleSuperInvocationExpression= ruleSuperInvocationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperInvocationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleSuperInvocationExpression_in_entryRuleSuperInvocationExpression3084);
            iv_ruleSuperInvocationExpression=ruleSuperInvocationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperInvocationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuperInvocationExpression3094); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuperInvocationExpression"


    // $ANTLR start "ruleSuperInvocationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1350:1: ruleSuperInvocationExpression returns [EObject current=null] : (otherlv_0= 'super' (otherlv_1= '.' ( ( ruleQualifiedName ) ) )? ( (lv_tuple_3_0= ruleTuple ) ) ) ;
    public final EObject ruleSuperInvocationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_tuple_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1353:28: ( (otherlv_0= 'super' (otherlv_1= '.' ( ( ruleQualifiedName ) ) )? ( (lv_tuple_3_0= ruleTuple ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1354:1: (otherlv_0= 'super' (otherlv_1= '.' ( ( ruleQualifiedName ) ) )? ( (lv_tuple_3_0= ruleTuple ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1354:1: (otherlv_0= 'super' (otherlv_1= '.' ( ( ruleQualifiedName ) ) )? ( (lv_tuple_3_0= ruleTuple ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1354:3: otherlv_0= 'super' (otherlv_1= '.' ( ( ruleQualifiedName ) ) )? ( (lv_tuple_3_0= ruleTuple ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleSuperInvocationExpression3131); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSuperInvocationExpressionAccess().getSuperKeyword_0());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1358:1: (otherlv_1= '.' ( ( ruleQualifiedName ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1358:3: otherlv_1= '.' ( ( ruleQualifiedName ) )
                    {
                    otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleSuperInvocationExpression3144); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getSuperInvocationExpressionAccess().getFullStopKeyword_1_0());
                          
                    }
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1362:1: ( ( ruleQualifiedName ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1363:1: ( ruleQualifiedName )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1363:1: ( ruleQualifiedName )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1364:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getSuperInvocationExpressionRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSuperInvocationExpressionAccess().getTargetOperationCrossReference_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuperInvocationExpression3171);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1380:4: ( (lv_tuple_3_0= ruleTuple ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1381:1: (lv_tuple_3_0= ruleTuple )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1381:1: (lv_tuple_3_0= ruleTuple )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1382:3: lv_tuple_3_0= ruleTuple
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSuperInvocationExpressionAccess().getTupleTupleParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTuple_in_ruleSuperInvocationExpression3194);
            lv_tuple_3_0=ruleTuple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSuperInvocationExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"tuple",
                      		lv_tuple_3_0, 
                      		"Tuple");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSuperInvocationExpression"


    // $ANTLR start "entryRuleInstanceCreationOrSequenceConstructionExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1406:1: entryRuleInstanceCreationOrSequenceConstructionExpression returns [EObject current=null] : iv_ruleInstanceCreationOrSequenceConstructionExpression= ruleInstanceCreationOrSequenceConstructionExpression EOF ;
    public final EObject entryRuleInstanceCreationOrSequenceConstructionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceCreationOrSequenceConstructionExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1407:2: (iv_ruleInstanceCreationOrSequenceConstructionExpression= ruleInstanceCreationOrSequenceConstructionExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1408:2: iv_ruleInstanceCreationOrSequenceConstructionExpression= ruleInstanceCreationOrSequenceConstructionExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstanceCreationOrSequenceConstructionExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleInstanceCreationOrSequenceConstructionExpression_in_entryRuleInstanceCreationOrSequenceConstructionExpression3230);
            iv_ruleInstanceCreationOrSequenceConstructionExpression=ruleInstanceCreationOrSequenceConstructionExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstanceCreationOrSequenceConstructionExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceCreationOrSequenceConstructionExpression3240); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceCreationOrSequenceConstructionExpression"


    // $ANTLR start "ruleInstanceCreationOrSequenceConstructionExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1415:1: ruleInstanceCreationOrSequenceConstructionExpression returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_tuple_3_0= ruleTuple ) ) ) ;
    public final EObject ruleInstanceCreationOrSequenceConstructionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_tuple_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1418:28: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_tuple_3_0= ruleTuple ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1419:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_tuple_3_0= ruleTuple ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1419:1: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_tuple_3_0= ruleTuple ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1419:2: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( (lv_tuple_3_0= ruleTuple ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1419:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1420:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInstanceCreationOrSequenceConstructionExpressionAccess().getInstanceCreationExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleInstanceCreationOrSequenceConstructionExpression3289); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInstanceCreationOrSequenceConstructionExpressionAccess().getNewKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1432:1: ( ( ruleQualifiedName ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1433:1: ( ruleQualifiedName )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1433:1: ( ruleQualifiedName )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1434:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getInstanceCreationOrSequenceConstructionExpressionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInstanceCreationOrSequenceConstructionExpressionAccess().getInstanceClassifierCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleInstanceCreationOrSequenceConstructionExpression3316);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1450:2: ( (lv_tuple_3_0= ruleTuple ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1451:1: (lv_tuple_3_0= ruleTuple )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1451:1: (lv_tuple_3_0= ruleTuple )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1452:3: lv_tuple_3_0= ruleTuple
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInstanceCreationOrSequenceConstructionExpressionAccess().getTupleTupleParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTuple_in_ruleInstanceCreationOrSequenceConstructionExpression3337);
            lv_tuple_3_0=ruleTuple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getInstanceCreationOrSequenceConstructionExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"tuple",
                      		lv_tuple_3_0, 
                      		"Tuple");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceCreationOrSequenceConstructionExpression"


    // $ANTLR start "entryRuleLinkOperationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1476:1: entryRuleLinkOperationExpression returns [EObject current=null] : iv_ruleLinkOperationExpression= ruleLinkOperationExpression EOF ;
    public final EObject entryRuleLinkOperationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinkOperationExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1477:2: (iv_ruleLinkOperationExpression= ruleLinkOperationExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1478:2: iv_ruleLinkOperationExpression= ruleLinkOperationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLinkOperationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLinkOperationExpression_in_entryRuleLinkOperationExpression3373);
            iv_ruleLinkOperationExpression=ruleLinkOperationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLinkOperationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLinkOperationExpression3383); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLinkOperationExpression"


    // $ANTLR start "ruleLinkOperationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1485:1: ruleLinkOperationExpression returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '::' ( (lv_operation_2_0= ruleLinkOperation ) ) ( (lv_tuple_3_0= ruleTuple ) ) ) ;
    public final EObject ruleLinkOperationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_operation_2_0 = null;

        EObject lv_tuple_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1488:28: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '::' ( (lv_operation_2_0= ruleLinkOperation ) ) ( (lv_tuple_3_0= ruleTuple ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1489:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '::' ( (lv_operation_2_0= ruleLinkOperation ) ) ( (lv_tuple_3_0= ruleTuple ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1489:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '::' ( (lv_operation_2_0= ruleLinkOperation ) ) ( (lv_tuple_3_0= ruleTuple ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1489:2: ( ( ruleQualifiedName ) ) otherlv_1= '::' ( (lv_operation_2_0= ruleLinkOperation ) ) ( (lv_tuple_3_0= ruleTuple ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1489:2: ( ( ruleQualifiedName ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1490:1: ( ruleQualifiedName )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1490:1: ( ruleQualifiedName )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1491:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getLinkOperationExpressionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLinkOperationExpressionAccess().getAssociationAssociationCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleLinkOperationExpression3435);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleLinkOperationExpression3447); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLinkOperationExpressionAccess().getColonColonKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1511:1: ( (lv_operation_2_0= ruleLinkOperation ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1512:1: (lv_operation_2_0= ruleLinkOperation )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1512:1: (lv_operation_2_0= ruleLinkOperation )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1513:3: lv_operation_2_0= ruleLinkOperation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLinkOperationExpressionAccess().getOperationLinkOperationEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLinkOperation_in_ruleLinkOperationExpression3468);
            lv_operation_2_0=ruleLinkOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLinkOperationExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"operation",
                      		lv_operation_2_0, 
                      		"LinkOperation");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1529:2: ( (lv_tuple_3_0= ruleTuple ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1530:1: (lv_tuple_3_0= ruleTuple )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1530:1: (lv_tuple_3_0= ruleTuple )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1531:3: lv_tuple_3_0= ruleTuple
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLinkOperationExpressionAccess().getTupleTupleParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTuple_in_ruleLinkOperationExpression3489);
            lv_tuple_3_0=ruleTuple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLinkOperationExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"tuple",
                      		lv_tuple_3_0, 
                      		"Tuple");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLinkOperationExpression"


    // $ANTLR start "entryRuleClassExtentExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1555:1: entryRuleClassExtentExpression returns [EObject current=null] : iv_ruleClassExtentExpression= ruleClassExtentExpression EOF ;
    public final EObject entryRuleClassExtentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassExtentExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1556:2: (iv_ruleClassExtentExpression= ruleClassExtentExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1557:2: iv_ruleClassExtentExpression= ruleClassExtentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassExtentExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleClassExtentExpression_in_entryRuleClassExtentExpression3525);
            iv_ruleClassExtentExpression=ruleClassExtentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassExtentExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassExtentExpression3535); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassExtentExpression"


    // $ANTLR start "ruleClassExtentExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1564:1: ruleClassExtentExpression returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '::' otherlv_2= 'instances' otherlv_3= '(' otherlv_4= ')' ) ;
    public final EObject ruleClassExtentExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1567:28: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '::' otherlv_2= 'instances' otherlv_3= '(' otherlv_4= ')' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1568:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '::' otherlv_2= 'instances' otherlv_3= '(' otherlv_4= ')' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1568:1: ( ( ( ruleQualifiedName ) ) otherlv_1= '::' otherlv_2= 'instances' otherlv_3= '(' otherlv_4= ')' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1568:2: ( ( ruleQualifiedName ) ) otherlv_1= '::' otherlv_2= 'instances' otherlv_3= '(' otherlv_4= ')'
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1568:2: ( ( ruleQualifiedName ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1569:1: ( ruleQualifiedName )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1569:1: ( ruleQualifiedName )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1570:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getClassExtentExpressionRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClassExtentExpressionAccess().getClassClassCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleClassExtentExpression3587);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleClassExtentExpression3599); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getClassExtentExpressionAccess().getColonColonKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleClassExtentExpression3611); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getClassExtentExpressionAccess().getInstancesKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleClassExtentExpression3623); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getClassExtentExpressionAccess().getLeftParenthesisKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleClassExtentExpression3635); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getClassExtentExpressionAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassExtentExpression"


    // $ANTLR start "entryRuleNullExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1610:1: entryRuleNullExpression returns [EObject current=null] : iv_ruleNullExpression= ruleNullExpression EOF ;
    public final EObject entryRuleNullExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1611:2: (iv_ruleNullExpression= ruleNullExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1612:2: iv_ruleNullExpression= ruleNullExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNullExpression_in_entryRuleNullExpression3671);
            iv_ruleNullExpression=ruleNullExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullExpression3681); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNullExpression"


    // $ANTLR start "ruleNullExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1619:1: ruleNullExpression returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1622:28: ( ( () otherlv_1= 'null' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1623:1: ( () otherlv_1= 'null' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1623:1: ( () otherlv_1= 'null' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1623:2: () otherlv_1= 'null'
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1623:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1624:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNullExpressionAccess().getNullExpressionAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,25,FOLLOW_25_in_ruleNullExpression3730); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNullExpressionAccess().getNullKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullExpression"


    // $ANTLR start "entryRuleCollectionLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1644:1: entryRuleCollectionLiteralExpression returns [EObject current=null] : iv_ruleCollectionLiteralExpression= ruleCollectionLiteralExpression EOF ;
    public final EObject entryRuleCollectionLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1645:2: (iv_ruleCollectionLiteralExpression= ruleCollectionLiteralExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1646:2: iv_ruleCollectionLiteralExpression= ruleCollectionLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleCollectionLiteralExpression_in_entryRuleCollectionLiteralExpression3766);
            iv_ruleCollectionLiteralExpression=ruleCollectionLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionLiteralExpression3776); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionLiteralExpression"


    // $ANTLR start "ruleCollectionLiteralExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1653:1: ruleCollectionLiteralExpression returns [EObject current=null] : ( () ( ( (lv_collectionType_1_0= ruleCollectionType ) ) otherlv_2= '<' ( (lv_typeDeclaration_3_0= ruleTypeDeclaration ) ) otherlv_4= '>' )? otherlv_5= '{' ( (lv_elements_6_0= ruleExpressionList ) )? otherlv_7= '}' ) ;
    public final EObject ruleCollectionLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_collectionType_1_0 = null;

        EObject lv_typeDeclaration_3_0 = null;

        EObject lv_elements_6_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1656:28: ( ( () ( ( (lv_collectionType_1_0= ruleCollectionType ) ) otherlv_2= '<' ( (lv_typeDeclaration_3_0= ruleTypeDeclaration ) ) otherlv_4= '>' )? otherlv_5= '{' ( (lv_elements_6_0= ruleExpressionList ) )? otherlv_7= '}' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1657:1: ( () ( ( (lv_collectionType_1_0= ruleCollectionType ) ) otherlv_2= '<' ( (lv_typeDeclaration_3_0= ruleTypeDeclaration ) ) otherlv_4= '>' )? otherlv_5= '{' ( (lv_elements_6_0= ruleExpressionList ) )? otherlv_7= '}' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1657:1: ( () ( ( (lv_collectionType_1_0= ruleCollectionType ) ) otherlv_2= '<' ( (lv_typeDeclaration_3_0= ruleTypeDeclaration ) ) otherlv_4= '>' )? otherlv_5= '{' ( (lv_elements_6_0= ruleExpressionList ) )? otherlv_7= '}' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1657:2: () ( ( (lv_collectionType_1_0= ruleCollectionType ) ) otherlv_2= '<' ( (lv_typeDeclaration_3_0= ruleTypeDeclaration ) ) otherlv_4= '>' )? otherlv_5= '{' ( (lv_elements_6_0= ruleExpressionList ) )? otherlv_7= '}'
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1657:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1658:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCollectionLiteralExpressionAccess().getElementCollectionExpressionAction_0(),
                          current);
                  
            }

            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1666:2: ( ( (lv_collectionType_1_0= ruleCollectionType ) ) otherlv_2= '<' ( (lv_typeDeclaration_3_0= ruleTypeDeclaration ) ) otherlv_4= '>' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=65 && LA16_0<=67)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1666:3: ( (lv_collectionType_1_0= ruleCollectionType ) ) otherlv_2= '<' ( (lv_typeDeclaration_3_0= ruleTypeDeclaration ) ) otherlv_4= '>'
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1666:3: ( (lv_collectionType_1_0= ruleCollectionType ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1667:1: (lv_collectionType_1_0= ruleCollectionType )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1667:1: (lv_collectionType_1_0= ruleCollectionType )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1668:3: lv_collectionType_1_0= ruleCollectionType
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpressionAccess().getCollectionTypeCollectionTypeEnumRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCollectionType_in_ruleCollectionLiteralExpression3835);
                    lv_collectionType_1_0=ruleCollectionType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"collectionType",
                              		lv_collectionType_1_0, 
                              		"CollectionType");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleCollectionLiteralExpression3847); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getCollectionLiteralExpressionAccess().getLessThanSignKeyword_1_1());
                          
                    }
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1688:1: ( (lv_typeDeclaration_3_0= ruleTypeDeclaration ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1689:1: (lv_typeDeclaration_3_0= ruleTypeDeclaration )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1689:1: (lv_typeDeclaration_3_0= ruleTypeDeclaration )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1690:3: lv_typeDeclaration_3_0= ruleTypeDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpressionAccess().getTypeDeclarationTypeDeclarationParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeDeclaration_in_ruleCollectionLiteralExpression3868);
                    lv_typeDeclaration_3_0=ruleTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"typeDeclaration",
                              		lv_typeDeclaration_3_0, 
                              		"TypeDeclaration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleCollectionLiteralExpression3880); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getCollectionLiteralExpressionAccess().getGreaterThanSignKeyword_1_3());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleCollectionLiteralExpression3894); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getCollectionLiteralExpressionAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1714:1: ( (lv_elements_6_0= ruleExpressionList ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=RULE_ID && LA17_0<=RULE_STRING)||(LA17_0>=16 && LA17_0<=18)||(LA17_0>=22 && LA17_0<=23)||LA17_0==25||LA17_0==28||(LA17_0>=32 && LA17_0<=34)||(LA17_0>=37 && LA17_0<=38)||(LA17_0>=65 && LA17_0<=69)) ) {
                alt17=1;
            }
            else if ( (LA17_0==29) ) {
                int LA17_2 = input.LA(2);

                if ( (synpred31_InternalReducedAlfLanguage()) ) {
                    alt17=1;
                }
            }
            switch (alt17) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1715:1: (lv_elements_6_0= ruleExpressionList )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1715:1: (lv_elements_6_0= ruleExpressionList )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1716:3: lv_elements_6_0= ruleExpressionList
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpressionAccess().getElementsExpressionListParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpressionList_in_ruleCollectionLiteralExpression3915);
                    lv_elements_6_0=ruleExpressionList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"elements",
                              		lv_elements_6_0, 
                              		"ExpressionList");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,29,FOLLOW_29_in_ruleCollectionLiteralExpression3928); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getCollectionLiteralExpressionAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionLiteralExpression"


    // $ANTLR start "entryRuleTypeDeclaration"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1744:1: entryRuleTypeDeclaration returns [EObject current=null] : iv_ruleTypeDeclaration= ruleTypeDeclaration EOF ;
    public final EObject entryRuleTypeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDeclaration = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1745:2: (iv_ruleTypeDeclaration= ruleTypeDeclaration EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1746:2: iv_ruleTypeDeclaration= ruleTypeDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleTypeDeclaration_in_entryRuleTypeDeclaration3964);
            iv_ruleTypeDeclaration=ruleTypeDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeDeclaration3974); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeDeclaration"


    // $ANTLR start "ruleTypeDeclaration"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1753:1: ruleTypeDeclaration returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleTypeDeclaration() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1756:28: ( ( ( ruleQualifiedName ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1757:1: ( ( ruleQualifiedName ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1757:1: ( ( ruleQualifiedName ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1758:1: ( ruleQualifiedName )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1758:1: ( ruleQualifiedName )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1759:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTypeDeclarationRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeDeclarationAccess().getTypeTypeCrossReference_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTypeDeclaration4025);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeDeclaration"


    // $ANTLR start "entryRuleIndex"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1783:1: entryRuleIndex returns [EObject current=null] : iv_ruleIndex= ruleIndex EOF ;
    public final EObject entryRuleIndex() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndex = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1784:2: (iv_ruleIndex= ruleIndex EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1785:2: iv_ruleIndex= ruleIndex EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIndexRule()); 
            }
            pushFollow(FOLLOW_ruleIndex_in_entryRuleIndex4060);
            iv_ruleIndex=ruleIndex();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIndex; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIndex4070); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndex"


    // $ANTLR start "ruleIndex"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1792:1: ruleIndex returns [EObject current=null] : (otherlv_0= '[' this_Expression_1= ruleExpression otherlv_2= ']' ) ;
    public final EObject ruleIndex() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1795:28: ( (otherlv_0= '[' this_Expression_1= ruleExpression otherlv_2= ']' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1796:1: (otherlv_0= '[' this_Expression_1= ruleExpression otherlv_2= ']' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1796:1: (otherlv_0= '[' this_Expression_1= ruleExpression otherlv_2= ']' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1796:3: otherlv_0= '[' this_Expression_1= ruleExpression otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleIndex4107); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIndexAccess().getLeftSquareBracketKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIndexAccess().getExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIndex4132);
            this_Expression_1=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Expression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,31,FOLLOW_31_in_ruleIndex4143); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIndexAccess().getRightSquareBracketKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndex"


    // $ANTLR start "entryRulePrefixExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1824:1: entryRulePrefixExpression returns [EObject current=null] : iv_rulePrefixExpression= rulePrefixExpression EOF ;
    public final EObject entryRulePrefixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1825:2: (iv_rulePrefixExpression= rulePrefixExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1826:2: iv_rulePrefixExpression= rulePrefixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePrefixExpression_in_entryRulePrefixExpression4179);
            iv_rulePrefixExpression=rulePrefixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrefixExpression4189); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixExpression"


    // $ANTLR start "rulePrefixExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1833:1: rulePrefixExpression returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleAffixOperator ) ) ( (lv_operand_2_0= ruleLeftHandSide ) ) ) ;
    public final EObject rulePrefixExpression() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_operand_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1836:28: ( ( () ( (lv_operator_1_0= ruleAffixOperator ) ) ( (lv_operand_2_0= ruleLeftHandSide ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1837:1: ( () ( (lv_operator_1_0= ruleAffixOperator ) ) ( (lv_operand_2_0= ruleLeftHandSide ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1837:1: ( () ( (lv_operator_1_0= ruleAffixOperator ) ) ( (lv_operand_2_0= ruleLeftHandSide ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1837:2: () ( (lv_operator_1_0= ruleAffixOperator ) ) ( (lv_operand_2_0= ruleLeftHandSide ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1837:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1838:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPrefixExpressionAccess().getPrefixExpressionAction_0(),
                          current);
                  
            }

            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1846:2: ( (lv_operator_1_0= ruleAffixOperator ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1847:1: (lv_operator_1_0= ruleAffixOperator )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1847:1: (lv_operator_1_0= ruleAffixOperator )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1848:3: lv_operator_1_0= ruleAffixOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrefixExpressionAccess().getOperatorAffixOperatorEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAffixOperator_in_rulePrefixExpression4247);
            lv_operator_1_0=ruleAffixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPrefixExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"operator",
                      		lv_operator_1_0, 
                      		"AffixOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1864:2: ( (lv_operand_2_0= ruleLeftHandSide ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1865:1: (lv_operand_2_0= ruleLeftHandSide )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1865:1: (lv_operand_2_0= ruleLeftHandSide )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1866:3: lv_operand_2_0= ruleLeftHandSide
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrefixExpressionAccess().getOperandLeftHandSideParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLeftHandSide_in_rulePrefixExpression4268);
            lv_operand_2_0=ruleLeftHandSide();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPrefixExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"operand",
                      		lv_operand_2_0, 
                      		"LeftHandSide");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1890:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1891:2: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1892:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression4304);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnaryExpression4314); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1899:1: ruleUnaryExpression returns [EObject current=null] : (this_PostfixOrCastExpression_0= rulePostfixOrCastExpression | this_NonPostfixNonCastUnaryExpression_1= ruleNonPostfixNonCastUnaryExpression | this_PrefixExpression_2= rulePrefixExpression ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PostfixOrCastExpression_0 = null;

        EObject this_NonPostfixNonCastUnaryExpression_1 = null;

        EObject this_PrefixExpression_2 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1902:28: ( (this_PostfixOrCastExpression_0= rulePostfixOrCastExpression | this_NonPostfixNonCastUnaryExpression_1= ruleNonPostfixNonCastUnaryExpression | this_PrefixExpression_2= rulePrefixExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1903:1: (this_PostfixOrCastExpression_0= rulePostfixOrCastExpression | this_NonPostfixNonCastUnaryExpression_1= ruleNonPostfixNonCastUnaryExpression | this_PrefixExpression_2= rulePrefixExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1903:1: (this_PostfixOrCastExpression_0= rulePostfixOrCastExpression | this_NonPostfixNonCastUnaryExpression_1= ruleNonPostfixNonCastUnaryExpression | this_PrefixExpression_2= rulePrefixExpression )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_UNRESTRICTED_NAME:
            case RULE_BOOLEAN_VALUE:
            case RULE_NATURAL_VALUE:
            case RULE_REAL_VALUE:
            case RULE_STRING:
            case 16:
            case 17:
            case 18:
            case 22:
            case 23:
            case 25:
            case 28:
            case 65:
            case 66:
            case 67:
                {
                alt18=1;
                }
                break;
            case 32:
            case 33:
            case 34:
            case 37:
            case 38:
                {
                alt18=2;
                }
                break;
            case 68:
            case 69:
                {
                alt18=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1904:2: this_PostfixOrCastExpression_0= rulePostfixOrCastExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixOrCastExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePostfixOrCastExpression_in_ruleUnaryExpression4364);
                    this_PostfixOrCastExpression_0=rulePostfixOrCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PostfixOrCastExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1917:2: this_NonPostfixNonCastUnaryExpression_1= ruleNonPostfixNonCastUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryExpressionAccess().getNonPostfixNonCastUnaryExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNonPostfixNonCastUnaryExpression_in_ruleUnaryExpression4394);
                    this_NonPostfixNonCastUnaryExpression_1=ruleNonPostfixNonCastUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NonPostfixNonCastUnaryExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1930:2: this_PrefixExpression_2= rulePrefixExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPrefixExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrefixExpression_in_ruleUnaryExpression4424);
                    this_PrefixExpression_2=rulePrefixExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRulePostfixOrCastExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1949:1: entryRulePostfixOrCastExpression returns [EObject current=null] : iv_rulePostfixOrCastExpression= rulePostfixOrCastExpression EOF ;
    public final EObject entryRulePostfixOrCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOrCastExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1950:2: (iv_rulePostfixOrCastExpression= rulePostfixOrCastExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1951:2: iv_rulePostfixOrCastExpression= rulePostfixOrCastExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixOrCastExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixOrCastExpression_in_entryRulePostfixOrCastExpression4459);
            iv_rulePostfixOrCastExpression=rulePostfixOrCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixOrCastExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixOrCastExpression4469); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostfixOrCastExpression"


    // $ANTLR start "rulePostfixOrCastExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1958:1: rulePostfixOrCastExpression returns [EObject current=null] : (this_PostfixExpression_0= rulePostfixExpression | this_CastExpression_1= ruleCastExpression | this_PrimaryExpression_2= rulePrimaryExpression ) ;
    public final EObject rulePostfixOrCastExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PostfixExpression_0 = null;

        EObject this_CastExpression_1 = null;

        EObject this_PrimaryExpression_2 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1961:28: ( (this_PostfixExpression_0= rulePostfixExpression | this_CastExpression_1= ruleCastExpression | this_PrimaryExpression_2= rulePrimaryExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1962:1: (this_PostfixExpression_0= rulePostfixExpression | this_CastExpression_1= ruleCastExpression | this_PrimaryExpression_2= rulePrimaryExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1962:1: (this_PostfixExpression_0= rulePostfixExpression | this_CastExpression_1= ruleCastExpression | this_PrimaryExpression_2= rulePrimaryExpression )
            int alt19=3;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1963:2: this_PostfixExpression_0= rulePostfixExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPostfixOrCastExpressionAccess().getPostfixExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePostfixExpression_in_rulePostfixOrCastExpression4519);
                    this_PostfixExpression_0=rulePostfixExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PostfixExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1976:2: this_CastExpression_1= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPostfixOrCastExpressionAccess().getCastExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCastExpression_in_rulePostfixOrCastExpression4549);
                    this_CastExpression_1=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CastExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1989:2: this_PrimaryExpression_2= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPostfixOrCastExpressionAccess().getPrimaryExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimaryExpression_in_rulePostfixOrCastExpression4579);
                    this_PrimaryExpression_2=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePostfixOrCastExpression"


    // $ANTLR start "entryRulePostfixExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2008:1: entryRulePostfixExpression returns [EObject current=null] : iv_rulePostfixExpression= rulePostfixExpression EOF ;
    public final EObject entryRulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2009:2: (iv_rulePostfixExpression= rulePostfixExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2010:2: iv_rulePostfixExpression= rulePostfixExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixExpressionRule()); 
            }
            pushFollow(FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression4614);
            iv_rulePostfixExpression=rulePostfixExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePostfixExpression4624); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostfixExpression"


    // $ANTLR start "rulePostfixExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2017:1: rulePostfixExpression returns [EObject current=null] : ( () ( (lv_operand_1_0= ruleLeftHandSide ) ) ( (lv_operator_2_0= ruleAffixOperator ) ) ) ;
    public final EObject rulePostfixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_operand_1_0 = null;

        Enumerator lv_operator_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2020:28: ( ( () ( (lv_operand_1_0= ruleLeftHandSide ) ) ( (lv_operator_2_0= ruleAffixOperator ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2021:1: ( () ( (lv_operand_1_0= ruleLeftHandSide ) ) ( (lv_operator_2_0= ruleAffixOperator ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2021:1: ( () ( (lv_operand_1_0= ruleLeftHandSide ) ) ( (lv_operator_2_0= ruleAffixOperator ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2021:2: () ( (lv_operand_1_0= ruleLeftHandSide ) ) ( (lv_operator_2_0= ruleAffixOperator ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2021:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2022:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getPostfixExpressionAccess().getPostfixExpressionAction_0(),
                          current);
                  
            }

            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2030:2: ( (lv_operand_1_0= ruleLeftHandSide ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2031:1: (lv_operand_1_0= ruleLeftHandSide )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2031:1: (lv_operand_1_0= ruleLeftHandSide )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2032:3: lv_operand_1_0= ruleLeftHandSide
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getOperandLeftHandSideParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLeftHandSide_in_rulePostfixExpression4682);
            lv_operand_1_0=ruleLeftHandSide();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"operand",
                      		lv_operand_1_0, 
                      		"LeftHandSide");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2048:2: ( (lv_operator_2_0= ruleAffixOperator ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2049:1: (lv_operator_2_0= ruleAffixOperator )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2049:1: (lv_operator_2_0= ruleAffixOperator )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2050:3: lv_operator_2_0= ruleAffixOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPostfixExpressionAccess().getOperatorAffixOperatorEnumRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAffixOperator_in_rulePostfixExpression4703);
            lv_operator_2_0=ruleAffixOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPostfixExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"operator",
                      		lv_operator_2_0, 
                      		"AffixOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePostfixExpression"


    // $ANTLR start "entryRuleNonPostfixNonCastUnaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2074:1: entryRuleNonPostfixNonCastUnaryExpression returns [EObject current=null] : iv_ruleNonPostfixNonCastUnaryExpression= ruleNonPostfixNonCastUnaryExpression EOF ;
    public final EObject entryRuleNonPostfixNonCastUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonPostfixNonCastUnaryExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2075:2: (iv_ruleNonPostfixNonCastUnaryExpression= ruleNonPostfixNonCastUnaryExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2076:2: iv_ruleNonPostfixNonCastUnaryExpression= ruleNonPostfixNonCastUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNonPostfixNonCastUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNonPostfixNonCastUnaryExpression_in_entryRuleNonPostfixNonCastUnaryExpression4739);
            iv_ruleNonPostfixNonCastUnaryExpression=ruleNonPostfixNonCastUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNonPostfixNonCastUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonPostfixNonCastUnaryExpression4749); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNonPostfixNonCastUnaryExpression"


    // $ANTLR start "ruleNonPostfixNonCastUnaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2083:1: ruleNonPostfixNonCastUnaryExpression returns [EObject current=null] : (this_NumericUnaryExpression_0= ruleNumericUnaryExpression | this_BooleanUnaryExpression_1= ruleBooleanUnaryExpression | this_BitStringUnaryExpression_2= ruleBitStringUnaryExpression | this_IsolationExpression_3= ruleIsolationExpression ) ;
    public final EObject ruleNonPostfixNonCastUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericUnaryExpression_0 = null;

        EObject this_BooleanUnaryExpression_1 = null;

        EObject this_BitStringUnaryExpression_2 = null;

        EObject this_IsolationExpression_3 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2086:28: ( (this_NumericUnaryExpression_0= ruleNumericUnaryExpression | this_BooleanUnaryExpression_1= ruleBooleanUnaryExpression | this_BitStringUnaryExpression_2= ruleBitStringUnaryExpression | this_IsolationExpression_3= ruleIsolationExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2087:1: (this_NumericUnaryExpression_0= ruleNumericUnaryExpression | this_BooleanUnaryExpression_1= ruleBooleanUnaryExpression | this_BitStringUnaryExpression_2= ruleBitStringUnaryExpression | this_IsolationExpression_3= ruleIsolationExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2087:1: (this_NumericUnaryExpression_0= ruleNumericUnaryExpression | this_BooleanUnaryExpression_1= ruleBooleanUnaryExpression | this_BitStringUnaryExpression_2= ruleBitStringUnaryExpression | this_IsolationExpression_3= ruleIsolationExpression )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 37:
            case 38:
                {
                alt20=1;
                }
                break;
            case 32:
                {
                alt20=2;
                }
                break;
            case 33:
                {
                alt20=3;
                }
                break;
            case 34:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2088:2: this_NumericUnaryExpression_0= ruleNumericUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNonPostfixNonCastUnaryExpressionAccess().getNumericUnaryExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNumericUnaryExpression_in_ruleNonPostfixNonCastUnaryExpression4799);
                    this_NumericUnaryExpression_0=ruleNumericUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NumericUnaryExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2101:2: this_BooleanUnaryExpression_1= ruleBooleanUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNonPostfixNonCastUnaryExpressionAccess().getBooleanUnaryExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanUnaryExpression_in_ruleNonPostfixNonCastUnaryExpression4829);
                    this_BooleanUnaryExpression_1=ruleBooleanUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BooleanUnaryExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2114:2: this_BitStringUnaryExpression_2= ruleBitStringUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNonPostfixNonCastUnaryExpressionAccess().getBitStringUnaryExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBitStringUnaryExpression_in_ruleNonPostfixNonCastUnaryExpression4859);
                    this_BitStringUnaryExpression_2=ruleBitStringUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BitStringUnaryExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2127:2: this_IsolationExpression_3= ruleIsolationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getNonPostfixNonCastUnaryExpressionAccess().getIsolationExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIsolationExpression_in_ruleNonPostfixNonCastUnaryExpression4889);
                    this_IsolationExpression_3=ruleIsolationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IsolationExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNonPostfixNonCastUnaryExpression"


    // $ANTLR start "entryRuleBooleanUnaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2146:1: entryRuleBooleanUnaryExpression returns [EObject current=null] : iv_ruleBooleanUnaryExpression= ruleBooleanUnaryExpression EOF ;
    public final EObject entryRuleBooleanUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanUnaryExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2147:2: (iv_ruleBooleanUnaryExpression= ruleBooleanUnaryExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2148:2: iv_ruleBooleanUnaryExpression= ruleBooleanUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBooleanUnaryExpression_in_entryRuleBooleanUnaryExpression4924);
            iv_ruleBooleanUnaryExpression=ruleBooleanUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanUnaryExpression4934); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanUnaryExpression"


    // $ANTLR start "ruleBooleanUnaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2155:1: ruleBooleanUnaryExpression returns [EObject current=null] : ( ( (lv_operator_0_0= '!' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleBooleanUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_0_0=null;
        EObject lv_operand_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2158:28: ( ( ( (lv_operator_0_0= '!' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2159:1: ( ( (lv_operator_0_0= '!' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2159:1: ( ( (lv_operator_0_0= '!' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2159:2: ( (lv_operator_0_0= '!' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2159:2: ( (lv_operator_0_0= '!' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2160:1: (lv_operator_0_0= '!' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2160:1: (lv_operator_0_0= '!' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2161:3: lv_operator_0_0= '!'
            {
            lv_operator_0_0=(Token)match(input,32,FOLLOW_32_in_ruleBooleanUnaryExpression4977); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_operator_0_0, grammarAccess.getBooleanUnaryExpressionAccess().getOperatorExclamationMarkKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getBooleanUnaryExpressionRule());
              	        }
                     		setWithLastConsumed(current, "operator", lv_operator_0_0, "!");
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2174:2: ( (lv_operand_1_0= ruleUnaryExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2175:1: (lv_operand_1_0= ruleUnaryExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2175:1: (lv_operand_1_0= ruleUnaryExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2176:3: lv_operand_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBooleanUnaryExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleBooleanUnaryExpression5011);
            lv_operand_1_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBooleanUnaryExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"operand",
                      		lv_operand_1_0, 
                      		"UnaryExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanUnaryExpression"


    // $ANTLR start "entryRuleBitStringUnaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2200:1: entryRuleBitStringUnaryExpression returns [EObject current=null] : iv_ruleBitStringUnaryExpression= ruleBitStringUnaryExpression EOF ;
    public final EObject entryRuleBitStringUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitStringUnaryExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2201:2: (iv_ruleBitStringUnaryExpression= ruleBitStringUnaryExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2202:2: iv_ruleBitStringUnaryExpression= ruleBitStringUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitStringUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleBitStringUnaryExpression_in_entryRuleBitStringUnaryExpression5047);
            iv_ruleBitStringUnaryExpression=ruleBitStringUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitStringUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBitStringUnaryExpression5057); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitStringUnaryExpression"


    // $ANTLR start "ruleBitStringUnaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2209:1: ruleBitStringUnaryExpression returns [EObject current=null] : ( ( (lv_operator_0_0= '~' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleBitStringUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_0_0=null;
        EObject lv_operand_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2212:28: ( ( ( (lv_operator_0_0= '~' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2213:1: ( ( (lv_operator_0_0= '~' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2213:1: ( ( (lv_operator_0_0= '~' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2213:2: ( (lv_operator_0_0= '~' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2213:2: ( (lv_operator_0_0= '~' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2214:1: (lv_operator_0_0= '~' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2214:1: (lv_operator_0_0= '~' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2215:3: lv_operator_0_0= '~'
            {
            lv_operator_0_0=(Token)match(input,33,FOLLOW_33_in_ruleBitStringUnaryExpression5100); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_operator_0_0, grammarAccess.getBitStringUnaryExpressionAccess().getOperatorTildeKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getBitStringUnaryExpressionRule());
              	        }
                     		setWithLastConsumed(current, "operator", lv_operator_0_0, "~");
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2228:2: ( (lv_operand_1_0= ruleUnaryExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2229:1: (lv_operand_1_0= ruleUnaryExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2229:1: (lv_operand_1_0= ruleUnaryExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2230:3: lv_operand_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBitStringUnaryExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleBitStringUnaryExpression5134);
            lv_operand_1_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBitStringUnaryExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"operand",
                      		lv_operand_1_0, 
                      		"UnaryExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitStringUnaryExpression"


    // $ANTLR start "entryRuleNumericUnaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2254:1: entryRuleNumericUnaryExpression returns [EObject current=null] : iv_ruleNumericUnaryExpression= ruleNumericUnaryExpression EOF ;
    public final EObject entryRuleNumericUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericUnaryExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2255:2: (iv_ruleNumericUnaryExpression= ruleNumericUnaryExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2256:2: iv_ruleNumericUnaryExpression= ruleNumericUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleNumericUnaryExpression_in_entryRuleNumericUnaryExpression5170);
            iv_ruleNumericUnaryExpression=ruleNumericUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericUnaryExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericUnaryExpression5180); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericUnaryExpression"


    // $ANTLR start "ruleNumericUnaryExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2263:1: ruleNumericUnaryExpression returns [EObject current=null] : ( ( ( (lv_operator_0_0= ruleNumericUnaryOperator ) ) ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) ) ) | ( ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) otherlv_3= '(' ( (lv_operand_4_0= rulePrefixExpression ) ) otherlv_5= ')' ) ) ;
    public final EObject ruleNumericUnaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_operator_0_0 = null;

        EObject lv_operand_1_1 = null;

        EObject lv_operand_1_2 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2266:28: ( ( ( ( (lv_operator_0_0= ruleNumericUnaryOperator ) ) ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) ) ) | ( ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) otherlv_3= '(' ( (lv_operand_4_0= rulePrefixExpression ) ) otherlv_5= ')' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2267:1: ( ( ( (lv_operator_0_0= ruleNumericUnaryOperator ) ) ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) ) ) | ( ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) otherlv_3= '(' ( (lv_operand_4_0= rulePrefixExpression ) ) otherlv_5= ')' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2267:1: ( ( ( (lv_operator_0_0= ruleNumericUnaryOperator ) ) ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) ) ) | ( ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) otherlv_3= '(' ( (lv_operand_4_0= rulePrefixExpression ) ) otherlv_5= ')' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==37) ) {
                int LA22_1 = input.LA(2);

                if ( (synpred40_InternalReducedAlfLanguage()) ) {
                    alt22=1;
                }
                else if ( (true) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA22_0==38) ) {
                int LA22_2 = input.LA(2);

                if ( (synpred40_InternalReducedAlfLanguage()) ) {
                    alt22=1;
                }
                else if ( (true) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2267:2: ( ( (lv_operator_0_0= ruleNumericUnaryOperator ) ) ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2267:2: ( ( (lv_operator_0_0= ruleNumericUnaryOperator ) ) ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2267:3: ( (lv_operator_0_0= ruleNumericUnaryOperator ) ) ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2267:3: ( (lv_operator_0_0= ruleNumericUnaryOperator ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2268:1: (lv_operator_0_0= ruleNumericUnaryOperator )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2268:1: (lv_operator_0_0= ruleNumericUnaryOperator )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2269:3: lv_operator_0_0= ruleNumericUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericUnaryExpressionAccess().getOperatorNumericUnaryOperatorEnumRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumericUnaryOperator_in_ruleNumericUnaryExpression5227);
                    lv_operator_0_0=ruleNumericUnaryOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operator",
                              		lv_operator_0_0, 
                              		"NumericUnaryOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2285:2: ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2286:1: ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2286:1: ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2287:1: (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2287:1: (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)||(LA21_0>=16 && LA21_0<=18)||(LA21_0>=22 && LA21_0<=23)||LA21_0==25||LA21_0==28||(LA21_0>=65 && LA21_0<=67)) ) {
                        alt21=1;
                    }
                    else if ( ((LA21_0>=32 && LA21_0<=34)||(LA21_0>=37 && LA21_0<=38)) ) {
                        alt21=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;
                    }
                    switch (alt21) {
                        case 1 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2288:3: lv_operand_1_1= rulePostfixOrCastExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNumericUnaryExpressionAccess().getOperandPostfixOrCastExpressionParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_rulePostfixOrCastExpression_in_ruleNumericUnaryExpression5250);
                            lv_operand_1_1=rulePostfixOrCastExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNumericUnaryExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"operand",
                                      		lv_operand_1_1, 
                                      		"PostfixOrCastExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2303:8: lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNumericUnaryExpressionAccess().getOperandNonPostfixNonCastUnaryExpressionParserRuleCall_0_1_0_1()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleNonPostfixNonCastUnaryExpression_in_ruleNumericUnaryExpression5269);
                            lv_operand_1_2=ruleNonPostfixNonCastUnaryExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNumericUnaryExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"operand",
                                      		lv_operand_1_2, 
                                      		"NonPostfixNonCastUnaryExpression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2322:6: ( ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) otherlv_3= '(' ( (lv_operand_4_0= rulePrefixExpression ) ) otherlv_5= ')' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2322:6: ( ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) otherlv_3= '(' ( (lv_operand_4_0= rulePrefixExpression ) ) otherlv_5= ')' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2322:7: ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) otherlv_3= '(' ( (lv_operand_4_0= rulePrefixExpression ) ) otherlv_5= ')'
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2322:7: ( (lv_operator_2_0= ruleNumericUnaryOperator ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2323:1: (lv_operator_2_0= ruleNumericUnaryOperator )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2323:1: (lv_operator_2_0= ruleNumericUnaryOperator )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2324:3: lv_operator_2_0= ruleNumericUnaryOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericUnaryExpressionAccess().getOperatorNumericUnaryOperatorEnumRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumericUnaryOperator_in_ruleNumericUnaryExpression5301);
                    lv_operator_2_0=ruleNumericUnaryOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operator",
                              		lv_operator_2_0, 
                              		"NumericUnaryOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleNumericUnaryExpression5313); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getNumericUnaryExpressionAccess().getLeftParenthesisKeyword_1_1());
                          
                    }
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2344:1: ( (lv_operand_4_0= rulePrefixExpression ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2345:1: (lv_operand_4_0= rulePrefixExpression )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2345:1: (lv_operand_4_0= rulePrefixExpression )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2346:3: lv_operand_4_0= rulePrefixExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNumericUnaryExpressionAccess().getOperandPrefixExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePrefixExpression_in_ruleNumericUnaryExpression5334);
                    lv_operand_4_0=rulePrefixExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNumericUnaryExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operand",
                              		lv_operand_4_0, 
                              		"PrefixExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleNumericUnaryExpression5346); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getNumericUnaryExpressionAccess().getRightParenthesisKeyword_1_3());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericUnaryExpression"


    // $ANTLR start "entryRuleIsolationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2374:1: entryRuleIsolationExpression returns [EObject current=null] : iv_ruleIsolationExpression= ruleIsolationExpression EOF ;
    public final EObject entryRuleIsolationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsolationExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2375:2: (iv_ruleIsolationExpression= ruleIsolationExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2376:2: iv_ruleIsolationExpression= ruleIsolationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIsolationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleIsolationExpression_in_entryRuleIsolationExpression5383);
            iv_ruleIsolationExpression=ruleIsolationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIsolationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIsolationExpression5393); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIsolationExpression"


    // $ANTLR start "ruleIsolationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2383:1: ruleIsolationExpression returns [EObject current=null] : ( ( (lv_operator_0_0= '$' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) ) ;
    public final EObject ruleIsolationExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_0_0=null;
        EObject lv_operand_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2386:28: ( ( ( (lv_operator_0_0= '$' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2387:1: ( ( (lv_operator_0_0= '$' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2387:1: ( ( (lv_operator_0_0= '$' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2387:2: ( (lv_operator_0_0= '$' ) ) ( (lv_operand_1_0= ruleUnaryExpression ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2387:2: ( (lv_operator_0_0= '$' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2388:1: (lv_operator_0_0= '$' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2388:1: (lv_operator_0_0= '$' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2389:3: lv_operator_0_0= '$'
            {
            lv_operator_0_0=(Token)match(input,34,FOLLOW_34_in_ruleIsolationExpression5436); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_operator_0_0, grammarAccess.getIsolationExpressionAccess().getOperatorDollarSignKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIsolationExpressionRule());
              	        }
                     		setWithLastConsumed(current, "operator", lv_operator_0_0, "$");
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2402:2: ( (lv_operand_1_0= ruleUnaryExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2403:1: (lv_operand_1_0= ruleUnaryExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2403:1: (lv_operand_1_0= ruleUnaryExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2404:3: lv_operand_1_0= ruleUnaryExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIsolationExpressionAccess().getOperandUnaryExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleIsolationExpression5470);
            lv_operand_1_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIsolationExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"operand",
                      		lv_operand_1_0, 
                      		"UnaryExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIsolationExpression"


    // $ANTLR start "entryRuleCastExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2428:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2429:2: (iv_ruleCastExpression= ruleCastExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2430:2: iv_ruleCastExpression= ruleCastExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCastExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleCastExpression_in_entryRuleCastExpression5506);
            iv_ruleCastExpression=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCastExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCastExpression5516); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCastExpression"


    // $ANTLR start "ruleCastExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2437:1: ruleCastExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_type_1_0= ruleTypeDeclaration ) ) otherlv_2= ')' ( (lv_operand_3_0= ruleCastCompletion ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;

        EObject lv_operand_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2440:28: ( (otherlv_0= '(' ( (lv_type_1_0= ruleTypeDeclaration ) ) otherlv_2= ')' ( (lv_operand_3_0= ruleCastCompletion ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2441:1: (otherlv_0= '(' ( (lv_type_1_0= ruleTypeDeclaration ) ) otherlv_2= ')' ( (lv_operand_3_0= ruleCastCompletion ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2441:1: (otherlv_0= '(' ( (lv_type_1_0= ruleTypeDeclaration ) ) otherlv_2= ')' ( (lv_operand_3_0= ruleCastCompletion ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2441:3: otherlv_0= '(' ( (lv_type_1_0= ruleTypeDeclaration ) ) otherlv_2= ')' ( (lv_operand_3_0= ruleCastCompletion ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleCastExpression5553); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2445:1: ( (lv_type_1_0= ruleTypeDeclaration ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2446:1: (lv_type_1_0= ruleTypeDeclaration )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2446:1: (lv_type_1_0= ruleTypeDeclaration )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2447:3: lv_type_1_0= ruleTypeDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeTypeDeclarationParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeDeclaration_in_ruleCastExpression5574);
            lv_type_1_0=ruleTypeDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCastExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"TypeDeclaration");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleCastExpression5586); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_2());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2467:1: ( (lv_operand_3_0= ruleCastCompletion ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2468:1: (lv_operand_3_0= ruleCastCompletion )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2468:1: (lv_operand_3_0= ruleCastCompletion )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2469:3: lv_operand_3_0= ruleCastCompletion
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCastExpressionAccess().getOperandCastCompletionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCastCompletion_in_ruleCastExpression5607);
            lv_operand_3_0=ruleCastCompletion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCastExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"operand",
                      		lv_operand_3_0, 
                      		"CastCompletion");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCastExpression"


    // $ANTLR start "entryRuleCastCompletion"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2493:1: entryRuleCastCompletion returns [EObject current=null] : iv_ruleCastCompletion= ruleCastCompletion EOF ;
    public final EObject entryRuleCastCompletion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastCompletion = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2494:2: (iv_ruleCastCompletion= ruleCastCompletion EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2495:2: iv_ruleCastCompletion= ruleCastCompletion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCastCompletionRule()); 
            }
            pushFollow(FOLLOW_ruleCastCompletion_in_entryRuleCastCompletion5643);
            iv_ruleCastCompletion=ruleCastCompletion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCastCompletion; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCastCompletion5653); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCastCompletion"


    // $ANTLR start "ruleCastCompletion"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2502:1: ruleCastCompletion returns [EObject current=null] : (this_PostfixOrCastExpression_0= rulePostfixOrCastExpression | this_BooleanUnaryExpression_1= ruleBooleanUnaryExpression | this_BitStringUnaryExpression_2= ruleBitStringUnaryExpression | this_IsolationExpression_3= ruleIsolationExpression ) ;
    public final EObject ruleCastCompletion() throws RecognitionException {
        EObject current = null;

        EObject this_PostfixOrCastExpression_0 = null;

        EObject this_BooleanUnaryExpression_1 = null;

        EObject this_BitStringUnaryExpression_2 = null;

        EObject this_IsolationExpression_3 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2505:28: ( (this_PostfixOrCastExpression_0= rulePostfixOrCastExpression | this_BooleanUnaryExpression_1= ruleBooleanUnaryExpression | this_BitStringUnaryExpression_2= ruleBitStringUnaryExpression | this_IsolationExpression_3= ruleIsolationExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2506:1: (this_PostfixOrCastExpression_0= rulePostfixOrCastExpression | this_BooleanUnaryExpression_1= ruleBooleanUnaryExpression | this_BitStringUnaryExpression_2= ruleBitStringUnaryExpression | this_IsolationExpression_3= ruleIsolationExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2506:1: (this_PostfixOrCastExpression_0= rulePostfixOrCastExpression | this_BooleanUnaryExpression_1= ruleBooleanUnaryExpression | this_BitStringUnaryExpression_2= ruleBitStringUnaryExpression | this_IsolationExpression_3= ruleIsolationExpression )
            int alt23=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_UNRESTRICTED_NAME:
            case RULE_BOOLEAN_VALUE:
            case RULE_NATURAL_VALUE:
            case RULE_REAL_VALUE:
            case RULE_STRING:
            case 16:
            case 17:
            case 18:
            case 22:
            case 23:
            case 25:
            case 28:
            case 65:
            case 66:
            case 67:
                {
                alt23=1;
                }
                break;
            case 32:
                {
                alt23=2;
                }
                break;
            case 33:
                {
                alt23=3;
                }
                break;
            case 34:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2507:2: this_PostfixOrCastExpression_0= rulePostfixOrCastExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCastCompletionAccess().getPostfixOrCastExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulePostfixOrCastExpression_in_ruleCastCompletion5703);
                    this_PostfixOrCastExpression_0=rulePostfixOrCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PostfixOrCastExpression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2520:2: this_BooleanUnaryExpression_1= ruleBooleanUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCastCompletionAccess().getBooleanUnaryExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBooleanUnaryExpression_in_ruleCastCompletion5733);
                    this_BooleanUnaryExpression_1=ruleBooleanUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BooleanUnaryExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2533:2: this_BitStringUnaryExpression_2= ruleBitStringUnaryExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCastCompletionAccess().getBitStringUnaryExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBitStringUnaryExpression_in_ruleCastCompletion5763);
                    this_BitStringUnaryExpression_2=ruleBitStringUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BitStringUnaryExpression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2546:2: this_IsolationExpression_3= ruleIsolationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getCastCompletionAccess().getIsolationExpressionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIsolationExpression_in_ruleCastCompletion5793);
                    this_IsolationExpression_3=ruleIsolationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IsolationExpression_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCastCompletion"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2565:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2566:2: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2567:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression5828);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeExpression5838); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2574:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_3_0= ruleUnaryExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_operand2_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2577:28: ( (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_3_0= ruleUnaryExpression ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2578:1: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_3_0= ruleUnaryExpression ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2578:1: (this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_3_0= ruleUnaryExpression ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2579:2: this_UnaryExpression_0= ruleUnaryExpression ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_3_0= ruleUnaryExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getUnaryExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression5888);
            this_UnaryExpression_0=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_UnaryExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2590:1: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_3_0= ruleUnaryExpression ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==16||(LA24_0>=35 && LA24_0<=36)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2590:2: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_operand2_3_0= ruleUnaryExpression ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2590:2: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2591:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getMultiplicativeExpressionAccess().getArithmeticExpressionOperand1Action_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2599:2: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2600:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2600:1: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2601:3: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperatorMultiplicativeOperatorParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpression5921);
            	    lv_operator_2_0=ruleMultiplicativeOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"MultiplicativeOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2617:2: ( (lv_operand2_3_0= ruleUnaryExpression ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2618:1: (lv_operand2_3_0= ruleUnaryExpression )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2618:1: (lv_operand2_3_0= ruleUnaryExpression )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2619:3: lv_operand2_3_0= ruleUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getOperand2UnaryExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression5942);
            	    lv_operand2_3_0=ruleUnaryExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operand2",
            	              		lv_operand2_3_0, 
            	              		"UnaryExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleMultiplicativeOperator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2643:1: entryRuleMultiplicativeOperator returns [String current=null] : iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF ;
    public final String entryRuleMultiplicativeOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicativeOperator = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2644:2: (iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2645:2: iv_ruleMultiplicativeOperator= ruleMultiplicativeOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator5981);
            iv_ruleMultiplicativeOperator=ruleMultiplicativeOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicativeOperator5992); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeOperator"


    // $ANTLR start "ruleMultiplicativeOperator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2652:1: ruleMultiplicativeOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= '%' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicativeOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2655:28: ( (kw= '*' | kw= '/' | kw= '%' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2656:1: (kw= '*' | kw= '/' | kw= '%' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2656:1: (kw= '*' | kw= '/' | kw= '%' )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt25=1;
                }
                break;
            case 35:
                {
                alt25=2;
                }
                break;
            case 36:
                {
                alt25=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2657:2: kw= '*'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleMultiplicativeOperator6030); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2664:2: kw= '/'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleMultiplicativeOperator6049); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2671:2: kw= '%'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleMultiplicativeOperator6068); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getMultiplicativeOperatorAccess().getPercentSignKeyword_2()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeOperator"


    // $ANTLR start "entryRuleAdditiveExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2684:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2685:2: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2686:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression6108);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveExpression6118); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2693:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_operand2_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_operand2_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2696:28: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_operand2_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2697:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_operand2_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2697:1: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_operand2_3_0= ruleMultiplicativeExpression ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2698:2: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_operand2_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6168);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_MultiplicativeExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2709:1: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_operand2_3_0= ruleMultiplicativeExpression ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=37 && LA26_0<=38)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2709:2: () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_operand2_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2709:2: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2710:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAdditiveExpressionAccess().getArithmeticExpressionOperand1Action_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2718:2: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2719:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2719:1: (lv_operator_2_0= ruleAdditiveOperator )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2720:3: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperatorAdditiveOperatorParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpression6201);
            	    lv_operator_2_0=ruleAdditiveOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"AdditiveOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2736:2: ( (lv_operand2_3_0= ruleMultiplicativeExpression ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2737:1: (lv_operand2_3_0= ruleMultiplicativeExpression )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2737:1: (lv_operand2_3_0= ruleMultiplicativeExpression )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2738:3: lv_operand2_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getOperand2MultiplicativeExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6222);
            	    lv_operand2_3_0=ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operand2",
            	              		lv_operand2_3_0, 
            	              		"MultiplicativeExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleAdditiveOperator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2762:1: entryRuleAdditiveOperator returns [String current=null] : iv_ruleAdditiveOperator= ruleAdditiveOperator EOF ;
    public final String entryRuleAdditiveOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAdditiveOperator = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2763:2: (iv_ruleAdditiveOperator= ruleAdditiveOperator EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2764:2: iv_ruleAdditiveOperator= ruleAdditiveOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveOperatorRule()); 
            }
            pushFollow(FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6261);
            iv_ruleAdditiveOperator=ruleAdditiveOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveOperator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdditiveOperator6272); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveOperator"


    // $ANTLR start "ruleAdditiveOperator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2771:1: ruleAdditiveOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleAdditiveOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2774:28: ( (kw= '+' | kw= '-' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2775:1: (kw= '+' | kw= '-' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2775:1: (kw= '+' | kw= '-' )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==37) ) {
                alt27=1;
            }
            else if ( (LA27_0==38) ) {
                alt27=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2776:2: kw= '+'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleAdditiveOperator6310); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getPlusSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2783:2: kw= '-'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleAdditiveOperator6329); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getAdditiveOperatorAccess().getHyphenMinusKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveOperator"


    // $ANTLR start "entryRuleShiftExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2796:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2797:2: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2798:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression6369);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleShiftExpression6379); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2805:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_operand2_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand2_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2808:28: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_operand2_3_0= ruleAdditiveExpression ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2809:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_operand2_3_0= ruleAdditiveExpression ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2809:1: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_operand2_3_0= ruleAdditiveExpression ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2810:2: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_operand2_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression6429);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AdditiveExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2821:1: ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_operand2_3_0= ruleAdditiveExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=70 && LA28_0<=72)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2821:2: () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_operand2_3_0= ruleAdditiveExpression ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2821:2: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2822:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getShiftExpressionAccess().getShiftExpressionOperand1Action_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2830:2: ( (lv_operator_2_0= ruleShiftOperator ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2831:1: (lv_operator_2_0= ruleShiftOperator )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2831:1: (lv_operator_2_0= ruleShiftOperator )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2832:3: lv_operator_2_0= ruleShiftOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleShiftOperator_in_ruleShiftExpression6462);
            	    lv_operator_2_0=ruleShiftOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"ShiftOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2848:2: ( (lv_operand2_3_0= ruleAdditiveExpression ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2849:1: (lv_operand2_3_0= ruleAdditiveExpression )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2849:1: (lv_operand2_3_0= ruleAdditiveExpression )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2850:3: lv_operand2_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getShiftExpressionAccess().getOperand2AdditiveExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression6483);
            	    lv_operand2_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operand2",
            	              		lv_operand2_3_0, 
            	              		"AdditiveExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleRelationalExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2874:1: entryRuleRelationalExpression returns [EObject current=null] : iv_ruleRelationalExpression= ruleRelationalExpression EOF ;
    public final EObject entryRuleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2875:2: (iv_ruleRelationalExpression= ruleRelationalExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2876:2: iv_ruleRelationalExpression= ruleRelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression6521);
            iv_ruleRelationalExpression=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationalExpression6531); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalExpression"


    // $ANTLR start "ruleRelationalExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2883:1: ruleRelationalExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_operand2_3_0= ruleShiftExpression ) ) )? ) ;
    public final EObject ruleRelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand2_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2886:28: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_operand2_3_0= ruleShiftExpression ) ) )? ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2887:1: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_operand2_3_0= ruleShiftExpression ) ) )? )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2887:1: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_operand2_3_0= ruleShiftExpression ) ) )? )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2888:2: this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_operand2_3_0= ruleShiftExpression ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getRelationalExpressionAccess().getShiftExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleShiftExpression_in_ruleRelationalExpression6581);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ShiftExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2899:1: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_operand2_3_0= ruleShiftExpression ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=26 && LA29_0<=27)||(LA29_0>=73 && LA29_0<=74)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2899:2: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_operand2_3_0= ruleShiftExpression ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2899:2: ()
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2900:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getRelationalExpressionAccess().getRelationalExpressionOperand1Action_1_0(),
                                  current);
                          
                    }

                    }

                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2908:2: ( (lv_operator_2_0= ruleRelationalOperator ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2909:1: (lv_operator_2_0= ruleRelationalOperator )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2909:1: (lv_operator_2_0= ruleRelationalOperator )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2910:3: lv_operator_2_0= ruleRelationalOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6614);
                    lv_operator_2_0=ruleRelationalOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operator",
                              		lv_operator_2_0, 
                              		"RelationalOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2926:2: ( (lv_operand2_3_0= ruleShiftExpression ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2927:1: (lv_operand2_3_0= ruleShiftExpression )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2927:1: (lv_operand2_3_0= ruleShiftExpression )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2928:3: lv_operand2_3_0= ruleShiftExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRelationalExpressionAccess().getOperand2ShiftExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleShiftExpression_in_ruleRelationalExpression6635);
                    lv_operand2_3_0=ruleShiftExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRelationalExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operand2",
                              		lv_operand2_3_0, 
                              		"ShiftExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalExpression"


    // $ANTLR start "entryRuleClassificationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2952:1: entryRuleClassificationExpression returns [EObject current=null] : iv_ruleClassificationExpression= ruleClassificationExpression EOF ;
    public final EObject entryRuleClassificationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassificationExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2953:2: (iv_ruleClassificationExpression= ruleClassificationExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2954:2: iv_ruleClassificationExpression= ruleClassificationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassificationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleClassificationExpression_in_entryRuleClassificationExpression6673);
            iv_ruleClassificationExpression=ruleClassificationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassificationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassificationExpression6683); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassificationExpression"


    // $ANTLR start "ruleClassificationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2961:1: ruleClassificationExpression returns [EObject current=null] : (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleClassificationOperator ) ) ( ( ruleQualifiedName ) ) )? ) ;
    public final EObject ruleClassificationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalExpression_0 = null;

        Enumerator lv_operator_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2964:28: ( (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleClassificationOperator ) ) ( ( ruleQualifiedName ) ) )? ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2965:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleClassificationOperator ) ) ( ( ruleQualifiedName ) ) )? )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2965:1: (this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleClassificationOperator ) ) ( ( ruleQualifiedName ) ) )? )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2966:2: this_RelationalExpression_0= ruleRelationalExpression ( () ( (lv_operator_2_0= ruleClassificationOperator ) ) ( ( ruleQualifiedName ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getClassificationExpressionAccess().getRelationalExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleRelationalExpression_in_ruleClassificationExpression6733);
            this_RelationalExpression_0=ruleRelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_RelationalExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2977:1: ( () ( (lv_operator_2_0= ruleClassificationOperator ) ) ( ( ruleQualifiedName ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=75 && LA30_0<=76)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2977:2: () ( (lv_operator_2_0= ruleClassificationOperator ) ) ( ( ruleQualifiedName ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2977:2: ()
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2978:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getClassificationExpressionAccess().getClassificationExpressionOperandAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2986:2: ( (lv_operator_2_0= ruleClassificationOperator ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2987:1: (lv_operator_2_0= ruleClassificationOperator )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2987:1: (lv_operator_2_0= ruleClassificationOperator )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2988:3: lv_operator_2_0= ruleClassificationOperator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassificationExpressionAccess().getOperatorClassificationOperatorEnumRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleClassificationOperator_in_ruleClassificationExpression6766);
                    lv_operator_2_0=ruleClassificationOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClassificationExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operator",
                              		lv_operator_2_0, 
                              		"ClassificationOperator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3004:2: ( ( ruleQualifiedName ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3005:1: ( ruleQualifiedName )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3005:1: ( ruleQualifiedName )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3006:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getClassificationExpressionRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassificationExpressionAccess().getTypeClassCrossReference_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleClassificationExpression6793);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassificationExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3030:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3031:2: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3032:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression6831);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEqualityExpression6841); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3039:1: ruleEqualityExpression returns [EObject current=null] : (this_ClassificationExpression_0= ruleClassificationExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_operand2_3_0= ruleClassificationExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ClassificationExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand2_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3042:28: ( (this_ClassificationExpression_0= ruleClassificationExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_operand2_3_0= ruleClassificationExpression ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3043:1: (this_ClassificationExpression_0= ruleClassificationExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_operand2_3_0= ruleClassificationExpression ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3043:1: (this_ClassificationExpression_0= ruleClassificationExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_operand2_3_0= ruleClassificationExpression ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3044:2: this_ClassificationExpression_0= ruleClassificationExpression ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_operand2_3_0= ruleClassificationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEqualityExpressionAccess().getClassificationExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleClassificationExpression_in_ruleEqualityExpression6891);
            this_ClassificationExpression_0=ruleClassificationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ClassificationExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3055:1: ( () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_operand2_3_0= ruleClassificationExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=77 && LA31_0<=78)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3055:2: () ( (lv_operator_2_0= ruleEqualityOperator ) ) ( (lv_operand2_3_0= ruleClassificationExpression ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3055:2: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3056:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getEqualityExpressionAccess().getEqualityExpressionOperand1Action_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3064:2: ( (lv_operator_2_0= ruleEqualityOperator ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3065:1: (lv_operator_2_0= ruleEqualityOperator )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3065:1: (lv_operator_2_0= ruleEqualityOperator )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3066:3: lv_operator_2_0= ruleEqualityOperator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperatorEqualityOperatorEnumRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression6924);
            	    lv_operator_2_0=ruleEqualityOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operator",
            	              		lv_operator_2_0, 
            	              		"EqualityOperator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3082:2: ( (lv_operand2_3_0= ruleClassificationExpression ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3083:1: (lv_operand2_3_0= ruleClassificationExpression )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3083:1: (lv_operand2_3_0= ruleClassificationExpression )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3084:3: lv_operand2_3_0= ruleClassificationExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getEqualityExpressionAccess().getOperand2ClassificationExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleClassificationExpression_in_ruleEqualityExpression6945);
            	    lv_operand2_3_0=ruleClassificationExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operand2",
            	              		lv_operand2_3_0, 
            	              		"ClassificationExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleAndExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3108:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3109:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3110:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression6983);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression6993); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3117:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= '&' ) ) ( (lv_operand2_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_operand2_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3120:28: ( (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= '&' ) ) ( (lv_operand2_3_0= ruleEqualityExpression ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3121:1: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= '&' ) ) ( (lv_operand2_3_0= ruleEqualityExpression ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3121:1: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= '&' ) ) ( (lv_operand2_3_0= ruleEqualityExpression ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3122:2: this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_operator_2_0= '&' ) ) ( (lv_operand2_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndExpression7043);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_EqualityExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3133:1: ( () ( (lv_operator_2_0= '&' ) ) ( (lv_operand2_3_0= ruleEqualityExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==39) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3133:2: () ( (lv_operator_2_0= '&' ) ) ( (lv_operand2_3_0= ruleEqualityExpression ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3133:2: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3134:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getAndExpressionAccess().getLogicalExpressionOperand1Action_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3142:2: ( (lv_operator_2_0= '&' ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3143:1: (lv_operator_2_0= '&' )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3143:1: (lv_operator_2_0= '&' )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3144:3: lv_operator_2_0= '&'
            	    {
            	    lv_operator_2_0=(Token)match(input,39,FOLLOW_39_in_ruleAndExpression7073); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_operator_2_0, grammarAccess.getAndExpressionAccess().getOperatorAmpersandKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getAndExpressionRule());
            	      	        }
            	             		setWithLastConsumed(current, "operator", lv_operator_2_0, "&");
            	      	    
            	    }

            	    }


            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3157:2: ( (lv_operand2_3_0= ruleEqualityExpression ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3158:1: (lv_operand2_3_0= ruleEqualityExpression )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3158:1: (lv_operand2_3_0= ruleEqualityExpression )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3159:3: lv_operand2_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAndExpressionAccess().getOperand2EqualityExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEqualityExpression_in_ruleAndExpression7107);
            	    lv_operand2_3_0=ruleEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operand2",
            	              		lv_operand2_3_0, 
            	              		"EqualityExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleExclusiveOrExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3183:1: entryRuleExclusiveOrExpression returns [EObject current=null] : iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF ;
    public final EObject entryRuleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveOrExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3184:2: (iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3185:2: iv_ruleExclusiveOrExpression= ruleExclusiveOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExclusiveOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExclusiveOrExpression_in_entryRuleExclusiveOrExpression7145);
            iv_ruleExclusiveOrExpression=ruleExclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExclusiveOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExclusiveOrExpression7155); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExclusiveOrExpression"


    // $ANTLR start "ruleExclusiveOrExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3192:1: ruleExclusiveOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '^' ) ) ( (lv_operand2_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleExclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_AndExpression_0 = null;

        EObject lv_operand2_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3195:28: ( (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '^' ) ) ( (lv_operand2_3_0= ruleAndExpression ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3196:1: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '^' ) ) ( (lv_operand2_3_0= ruleAndExpression ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3196:1: (this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '^' ) ) ( (lv_operand2_3_0= ruleAndExpression ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3197:2: this_AndExpression_0= ruleAndExpression ( () ( (lv_operator_2_0= '^' ) ) ( (lv_operand2_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleAndExpression_in_ruleExclusiveOrExpression7205);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_AndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3208:1: ( () ( (lv_operator_2_0= '^' ) ) ( (lv_operand2_3_0= ruleAndExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==40) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3208:2: () ( (lv_operator_2_0= '^' ) ) ( (lv_operand2_3_0= ruleAndExpression ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3208:2: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3209:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getExclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3217:2: ( (lv_operator_2_0= '^' ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3218:1: (lv_operator_2_0= '^' )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3218:1: (lv_operator_2_0= '^' )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3219:3: lv_operator_2_0= '^'
            	    {
            	    lv_operator_2_0=(Token)match(input,40,FOLLOW_40_in_ruleExclusiveOrExpression7235); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_operator_2_0, grammarAccess.getExclusiveOrExpressionAccess().getOperatorCircumflexAccentKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getExclusiveOrExpressionRule());
            	      	        }
            	             		setWithLastConsumed(current, "operator", lv_operator_2_0, "^");
            	      	    
            	    }

            	    }


            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3232:2: ( (lv_operand2_3_0= ruleAndExpression ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3233:1: (lv_operand2_3_0= ruleAndExpression )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3233:1: (lv_operand2_3_0= ruleAndExpression )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3234:3: lv_operand2_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExclusiveOrExpressionAccess().getOperand2AndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAndExpression_in_ruleExclusiveOrExpression7269);
            	    lv_operand2_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExclusiveOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operand2",
            	              		lv_operand2_3_0, 
            	              		"AndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExclusiveOrExpression"


    // $ANTLR start "entryRuleInclusiveOrExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3258:1: entryRuleInclusiveOrExpression returns [EObject current=null] : iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF ;
    public final EObject entryRuleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInclusiveOrExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3259:2: (iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3260:2: iv_ruleInclusiveOrExpression= ruleInclusiveOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInclusiveOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleInclusiveOrExpression_in_entryRuleInclusiveOrExpression7307);
            iv_ruleInclusiveOrExpression=ruleInclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInclusiveOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInclusiveOrExpression7317); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInclusiveOrExpression"


    // $ANTLR start "ruleInclusiveOrExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3267:1: ruleInclusiveOrExpression returns [EObject current=null] : (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_operator_2_0= '|' ) ) ( (lv_operand2_3_0= ruleExclusiveOrExpression ) ) )* ) ;
    public final EObject ruleInclusiveOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_ExclusiveOrExpression_0 = null;

        EObject lv_operand2_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3270:28: ( (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_operator_2_0= '|' ) ) ( (lv_operand2_3_0= ruleExclusiveOrExpression ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3271:1: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_operator_2_0= '|' ) ) ( (lv_operand2_3_0= ruleExclusiveOrExpression ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3271:1: (this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_operator_2_0= '|' ) ) ( (lv_operand2_3_0= ruleExclusiveOrExpression ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3272:2: this_ExclusiveOrExpression_0= ruleExclusiveOrExpression ( () ( (lv_operator_2_0= '|' ) ) ( (lv_operand2_3_0= ruleExclusiveOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getExclusiveOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleExclusiveOrExpression_in_ruleInclusiveOrExpression7367);
            this_ExclusiveOrExpression_0=ruleExclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ExclusiveOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3283:1: ( () ( (lv_operator_2_0= '|' ) ) ( (lv_operand2_3_0= ruleExclusiveOrExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==41) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3283:2: () ( (lv_operator_2_0= '|' ) ) ( (lv_operand2_3_0= ruleExclusiveOrExpression ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3283:2: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3284:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getInclusiveOrExpressionAccess().getLogicalExpressionOperand1Action_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3292:2: ( (lv_operator_2_0= '|' ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3293:1: (lv_operator_2_0= '|' )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3293:1: (lv_operator_2_0= '|' )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3294:3: lv_operator_2_0= '|'
            	    {
            	    lv_operator_2_0=(Token)match(input,41,FOLLOW_41_in_ruleInclusiveOrExpression7397); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_operator_2_0, grammarAccess.getInclusiveOrExpressionAccess().getOperatorVerticalLineKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getInclusiveOrExpressionRule());
            	      	        }
            	             		setWithLastConsumed(current, "operator", lv_operator_2_0, "|");
            	      	    
            	    }

            	    }


            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3307:2: ( (lv_operand2_3_0= ruleExclusiveOrExpression ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3308:1: (lv_operand2_3_0= ruleExclusiveOrExpression )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3308:1: (lv_operand2_3_0= ruleExclusiveOrExpression )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3309:3: lv_operand2_3_0= ruleExclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInclusiveOrExpressionAccess().getOperand2ExclusiveOrExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExclusiveOrExpression_in_ruleInclusiveOrExpression7431);
            	    lv_operand2_3_0=ruleExclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getInclusiveOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operand2",
            	              		lv_operand2_3_0, 
            	              		"ExclusiveOrExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInclusiveOrExpression"


    // $ANTLR start "entryRuleConditionalAndExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3333:1: entryRuleConditionalAndExpression returns [EObject current=null] : iv_ruleConditionalAndExpression= ruleConditionalAndExpression EOF ;
    public final EObject entryRuleConditionalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalAndExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3334:2: (iv_ruleConditionalAndExpression= ruleConditionalAndExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3335:2: iv_ruleConditionalAndExpression= ruleConditionalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalAndExpression_in_entryRuleConditionalAndExpression7469);
            iv_ruleConditionalAndExpression=ruleConditionalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalAndExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalAndExpression7479); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalAndExpression"


    // $ANTLR start "ruleConditionalAndExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3342:1: ruleConditionalAndExpression returns [EObject current=null] : (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_operand2_3_0= ruleInclusiveOrExpression ) ) )* ) ;
    public final EObject ruleConditionalAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_InclusiveOrExpression_0 = null;

        EObject lv_operand2_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3345:28: ( (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_operand2_3_0= ruleInclusiveOrExpression ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3346:1: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_operand2_3_0= ruleInclusiveOrExpression ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3346:1: (this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_operand2_3_0= ruleInclusiveOrExpression ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3347:2: this_InclusiveOrExpression_0= ruleInclusiveOrExpression ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_operand2_3_0= ruleInclusiveOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getInclusiveOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleInclusiveOrExpression_in_ruleConditionalAndExpression7529);
            this_InclusiveOrExpression_0=ruleInclusiveOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_InclusiveOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3358:1: ( () ( (lv_operator_2_0= '&&' ) ) ( (lv_operand2_3_0= ruleInclusiveOrExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==42) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3358:2: () ( (lv_operator_2_0= '&&' ) ) ( (lv_operand2_3_0= ruleInclusiveOrExpression ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3358:2: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3359:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getConditionalAndExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3367:2: ( (lv_operator_2_0= '&&' ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3368:1: (lv_operator_2_0= '&&' )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3368:1: (lv_operator_2_0= '&&' )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3369:3: lv_operator_2_0= '&&'
            	    {
            	    lv_operator_2_0=(Token)match(input,42,FOLLOW_42_in_ruleConditionalAndExpression7559); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_operator_2_0, grammarAccess.getConditionalAndExpressionAccess().getOperatorAmpersandAmpersandKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getConditionalAndExpressionRule());
            	      	        }
            	             		setWithLastConsumed(current, "operator", lv_operator_2_0, "&&");
            	      	    
            	    }

            	    }


            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3382:2: ( (lv_operand2_3_0= ruleInclusiveOrExpression ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3383:1: (lv_operand2_3_0= ruleInclusiveOrExpression )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3383:1: (lv_operand2_3_0= ruleInclusiveOrExpression )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3384:3: lv_operand2_3_0= ruleInclusiveOrExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConditionalAndExpressionAccess().getOperand2InclusiveOrExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleInclusiveOrExpression_in_ruleConditionalAndExpression7593);
            	    lv_operand2_3_0=ruleInclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getConditionalAndExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operand2",
            	              		lv_operand2_3_0, 
            	              		"InclusiveOrExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalAndExpression"


    // $ANTLR start "entryRuleConditionalOrExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3408:1: entryRuleConditionalOrExpression returns [EObject current=null] : iv_ruleConditionalOrExpression= ruleConditionalOrExpression EOF ;
    public final EObject entryRuleConditionalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalOrExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3409:2: (iv_ruleConditionalOrExpression= ruleConditionalOrExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3410:2: iv_ruleConditionalOrExpression= ruleConditionalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalOrExpression_in_entryRuleConditionalOrExpression7631);
            iv_ruleConditionalOrExpression=ruleConditionalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalOrExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalOrExpression7641); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalOrExpression"


    // $ANTLR start "ruleConditionalOrExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3417:1: ruleConditionalOrExpression returns [EObject current=null] : (this_ConditionalAndExpression_0= ruleConditionalAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_operand2_3_0= ruleConditionalAndExpression ) ) )* ) ;
    public final EObject ruleConditionalOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_0=null;
        EObject this_ConditionalAndExpression_0 = null;

        EObject lv_operand2_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3420:28: ( (this_ConditionalAndExpression_0= ruleConditionalAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_operand2_3_0= ruleConditionalAndExpression ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3421:1: (this_ConditionalAndExpression_0= ruleConditionalAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_operand2_3_0= ruleConditionalAndExpression ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3421:1: (this_ConditionalAndExpression_0= ruleConditionalAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_operand2_3_0= ruleConditionalAndExpression ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3422:2: this_ConditionalAndExpression_0= ruleConditionalAndExpression ( () ( (lv_operator_2_0= '||' ) ) ( (lv_operand2_3_0= ruleConditionalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getConditionalAndExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleConditionalAndExpression_in_ruleConditionalOrExpression7691);
            this_ConditionalAndExpression_0=ruleConditionalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ConditionalAndExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3433:1: ( () ( (lv_operator_2_0= '||' ) ) ( (lv_operand2_3_0= ruleConditionalAndExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==43) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3433:2: () ( (lv_operator_2_0= '||' ) ) ( (lv_operand2_3_0= ruleConditionalAndExpression ) )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3433:2: ()
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3434:2: 
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {

            	              current = forceCreateModelElementAndSet(
            	                  grammarAccess.getConditionalOrExpressionAccess().getConditionalLogicalExpressionOperand1Action_1_0(),
            	                  current);
            	          
            	    }

            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3442:2: ( (lv_operator_2_0= '||' ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3443:1: (lv_operator_2_0= '||' )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3443:1: (lv_operator_2_0= '||' )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3444:3: lv_operator_2_0= '||'
            	    {
            	    lv_operator_2_0=(Token)match(input,43,FOLLOW_43_in_ruleConditionalOrExpression7721); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              newLeafNode(lv_operator_2_0, grammarAccess.getConditionalOrExpressionAccess().getOperatorVerticalLineVerticalLineKeyword_1_1_0());
            	          
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getConditionalOrExpressionRule());
            	      	        }
            	             		setWithLastConsumed(current, "operator", lv_operator_2_0, "||");
            	      	    
            	    }

            	    }


            	    }

            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3457:2: ( (lv_operand2_3_0= ruleConditionalAndExpression ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3458:1: (lv_operand2_3_0= ruleConditionalAndExpression )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3458:1: (lv_operand2_3_0= ruleConditionalAndExpression )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3459:3: lv_operand2_3_0= ruleConditionalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConditionalOrExpressionAccess().getOperand2ConditionalAndExpressionParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleConditionalAndExpression_in_ruleConditionalOrExpression7755);
            	    lv_operand2_3_0=ruleConditionalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getConditionalOrExpressionRule());
            	      	        }
            	             		set(
            	             			current, 
            	             			"operand2",
            	              		lv_operand2_3_0, 
            	              		"ConditionalAndExpression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalOrExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3483:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3484:2: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3485:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression7793);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalExpression7803); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalExpression"


    // $ANTLR start "ruleConditionalExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3492:1: ruleConditionalExpression returns [EObject current=null] : (this_ConditionalOrExpression_0= ruleConditionalOrExpression ( () otherlv_2= '?' ( (lv_operand2_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand3_5_0= ruleConditionalExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_ConditionalOrExpression_0 = null;

        EObject lv_operand2_3_0 = null;

        EObject lv_operand3_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3495:28: ( (this_ConditionalOrExpression_0= ruleConditionalOrExpression ( () otherlv_2= '?' ( (lv_operand2_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand3_5_0= ruleConditionalExpression ) ) )? ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3496:1: (this_ConditionalOrExpression_0= ruleConditionalOrExpression ( () otherlv_2= '?' ( (lv_operand2_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand3_5_0= ruleConditionalExpression ) ) )? )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3496:1: (this_ConditionalOrExpression_0= ruleConditionalOrExpression ( () otherlv_2= '?' ( (lv_operand2_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand3_5_0= ruleConditionalExpression ) ) )? )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3497:2: this_ConditionalOrExpression_0= ruleConditionalOrExpression ( () otherlv_2= '?' ( (lv_operand2_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand3_5_0= ruleConditionalExpression ) ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConditionalExpressionAccess().getConditionalOrExpressionParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleConditionalOrExpression_in_ruleConditionalExpression7853);
            this_ConditionalOrExpression_0=ruleConditionalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ConditionalOrExpression_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3508:1: ( () otherlv_2= '?' ( (lv_operand2_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand3_5_0= ruleConditionalExpression ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==44) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3508:2: () otherlv_2= '?' ( (lv_operand2_3_0= ruleExpression ) ) otherlv_4= ':' ( (lv_operand3_5_0= ruleConditionalExpression ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3508:2: ()
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3509:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElementAndSet(
                                  grammarAccess.getConditionalExpressionAccess().getConditionalTestExpressionOperand1Action_1_0(),
                                  current);
                          
                    }

                    }

                    otherlv_2=(Token)match(input,44,FOLLOW_44_in_ruleConditionalExpression7877); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1());
                          
                    }
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3521:1: ( (lv_operand2_3_0= ruleExpression ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3522:1: (lv_operand2_3_0= ruleExpression )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3522:1: (lv_operand2_3_0= ruleExpression )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3523:3: lv_operand2_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperand2ExpressionParserRuleCall_1_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleConditionalExpression7898);
                    lv_operand2_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operand2",
                              		lv_operand2_3_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,45,FOLLOW_45_in_ruleConditionalExpression7910); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                          
                    }
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3543:1: ( (lv_operand3_5_0= ruleConditionalExpression ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3544:1: (lv_operand3_5_0= ruleConditionalExpression )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3544:1: (lv_operand3_5_0= ruleConditionalExpression )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3545:3: lv_operand3_5_0= ruleConditionalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalExpressionAccess().getOperand3ConditionalExpressionParserRuleCall_1_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleConditionalExpression_in_ruleConditionalExpression7931);
                    lv_operand3_5_0=ruleConditionalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"operand3",
                              		lv_operand3_5_0, 
                              		"ConditionalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3569:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3570:2: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3571:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression7969);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignmentExpression7979); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3578:1: ruleAssignmentExpression returns [EObject current=null] : ( ( (lv_leftHandSide_0_0= ruleLeftHandSide ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_rightHandSide_2_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_leftHandSide_0_0 = null;

        Enumerator lv_operator_1_0 = null;

        EObject lv_rightHandSide_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3581:28: ( ( ( (lv_leftHandSide_0_0= ruleLeftHandSide ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_rightHandSide_2_0= ruleExpression ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3582:1: ( ( (lv_leftHandSide_0_0= ruleLeftHandSide ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_rightHandSide_2_0= ruleExpression ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3582:1: ( ( (lv_leftHandSide_0_0= ruleLeftHandSide ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_rightHandSide_2_0= ruleExpression ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3582:2: ( (lv_leftHandSide_0_0= ruleLeftHandSide ) ) ( (lv_operator_1_0= ruleAssignmentOperator ) ) ( (lv_rightHandSide_2_0= ruleExpression ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3582:2: ( (lv_leftHandSide_0_0= ruleLeftHandSide ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3583:1: (lv_leftHandSide_0_0= ruleLeftHandSide )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3583:1: (lv_leftHandSide_0_0= ruleLeftHandSide )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3584:3: lv_leftHandSide_0_0= ruleLeftHandSide
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getLeftHandSideLeftHandSideParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLeftHandSide_in_ruleAssignmentExpression8025);
            lv_leftHandSide_0_0=ruleLeftHandSide();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"leftHandSide",
                      		lv_leftHandSide_0_0, 
                      		"LeftHandSide");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3600:2: ( (lv_operator_1_0= ruleAssignmentOperator ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3601:1: (lv_operator_1_0= ruleAssignmentOperator )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3601:1: (lv_operator_1_0= ruleAssignmentOperator )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3602:3: lv_operator_1_0= ruleAssignmentOperator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignmentOperatorEnumRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpression8046);
            lv_operator_1_0=ruleAssignmentOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"operator",
                      		lv_operator_1_0, 
                      		"AssignmentOperator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3618:2: ( (lv_rightHandSide_2_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3619:1: (lv_rightHandSide_2_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3619:1: (lv_rightHandSide_2_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3620:3: lv_rightHandSide_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getRightHandSideExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAssignmentExpression8067);
            lv_rightHandSide_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"rightHandSide",
                      		lv_rightHandSide_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleLeftHandSide"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3644:1: entryRuleLeftHandSide returns [EObject current=null] : iv_ruleLeftHandSide= ruleLeftHandSide EOF ;
    public final EObject entryRuleLeftHandSide() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftHandSide = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3645:2: (iv_ruleLeftHandSide= ruleLeftHandSide EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3646:2: iv_ruleLeftHandSide= ruleLeftHandSide EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLeftHandSideRule()); 
            }
            pushFollow(FOLLOW_ruleLeftHandSide_in_entryRuleLeftHandSide8103);
            iv_ruleLeftHandSide=ruleLeftHandSide();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLeftHandSide; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLeftHandSide8113); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLeftHandSide"


    // $ANTLR start "ruleLeftHandSide"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3653:1: ruleLeftHandSide returns [EObject current=null] : (this_NameLeftHandSide_0= ruleNameLeftHandSide | this_FeatureLeftHandSide_1= ruleFeatureLeftHandSide ) ;
    public final EObject ruleLeftHandSide() throws RecognitionException {
        EObject current = null;

        EObject this_NameLeftHandSide_0 = null;

        EObject this_FeatureLeftHandSide_1 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3656:28: ( (this_NameLeftHandSide_0= ruleNameLeftHandSide | this_FeatureLeftHandSide_1= ruleFeatureLeftHandSide ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3657:1: (this_NameLeftHandSide_0= ruleNameLeftHandSide | this_FeatureLeftHandSide_1= ruleFeatureLeftHandSide )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3657:1: (this_NameLeftHandSide_0= ruleNameLeftHandSide | this_FeatureLeftHandSide_1= ruleFeatureLeftHandSide )
            int alt38=2;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3658:2: this_NameLeftHandSide_0= ruleNameLeftHandSide
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLeftHandSideAccess().getNameLeftHandSideParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNameLeftHandSide_in_ruleLeftHandSide8163);
                    this_NameLeftHandSide_0=ruleNameLeftHandSide();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NameLeftHandSide_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3671:2: this_FeatureLeftHandSide_1= ruleFeatureLeftHandSide
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLeftHandSideAccess().getFeatureLeftHandSideParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFeatureLeftHandSide_in_ruleLeftHandSide8193);
                    this_FeatureLeftHandSide_1=ruleFeatureLeftHandSide();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FeatureLeftHandSide_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLeftHandSide"


    // $ANTLR start "entryRuleNameLeftHandSide"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3690:1: entryRuleNameLeftHandSide returns [EObject current=null] : iv_ruleNameLeftHandSide= ruleNameLeftHandSide EOF ;
    public final EObject entryRuleNameLeftHandSide() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameLeftHandSide = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3691:2: (iv_ruleNameLeftHandSide= ruleNameLeftHandSide EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3692:2: iv_ruleNameLeftHandSide= ruleNameLeftHandSide EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameLeftHandSideRule()); 
            }
            pushFollow(FOLLOW_ruleNameLeftHandSide_in_entryRuleNameLeftHandSide8228);
            iv_ruleNameLeftHandSide=ruleNameLeftHandSide();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameLeftHandSide; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameLeftHandSide8238); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNameLeftHandSide"


    // $ANTLR start "ruleNameLeftHandSide"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3699:1: ruleNameLeftHandSide returns [EObject current=null] : ( ( (lv_expression_0_0= ruleNameExpression ) ) ( (lv_index_1_0= ruleIndex ) )? ) ;
    public final EObject ruleNameLeftHandSide() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;

        EObject lv_index_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3702:28: ( ( ( (lv_expression_0_0= ruleNameExpression ) ) ( (lv_index_1_0= ruleIndex ) )? ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3703:1: ( ( (lv_expression_0_0= ruleNameExpression ) ) ( (lv_index_1_0= ruleIndex ) )? )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3703:1: ( ( (lv_expression_0_0= ruleNameExpression ) ) ( (lv_index_1_0= ruleIndex ) )? )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3703:2: ( (lv_expression_0_0= ruleNameExpression ) ) ( (lv_index_1_0= ruleIndex ) )?
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3703:2: ( (lv_expression_0_0= ruleNameExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3704:1: (lv_expression_0_0= ruleNameExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3704:1: (lv_expression_0_0= ruleNameExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3705:3: lv_expression_0_0= ruleNameExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNameLeftHandSideAccess().getExpressionNameExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNameExpression_in_ruleNameLeftHandSide8284);
            lv_expression_0_0=ruleNameExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNameLeftHandSideRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_0_0, 
                      		"NameExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3721:2: ( (lv_index_1_0= ruleIndex ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==30) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3722:1: (lv_index_1_0= ruleIndex )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3722:1: (lv_index_1_0= ruleIndex )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3723:3: lv_index_1_0= ruleIndex
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameLeftHandSideAccess().getIndexIndexParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIndex_in_ruleNameLeftHandSide8305);
                    lv_index_1_0=ruleIndex();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNameLeftHandSideRule());
                      	        }
                             		set(
                             			current, 
                             			"index",
                              		lv_index_1_0, 
                              		"Index");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNameLeftHandSide"


    // $ANTLR start "entryRuleFeatureLeftHandSide"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3747:1: entryRuleFeatureLeftHandSide returns [EObject current=null] : iv_ruleFeatureLeftHandSide= ruleFeatureLeftHandSide EOF ;
    public final EObject entryRuleFeatureLeftHandSide() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureLeftHandSide = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3748:2: (iv_ruleFeatureLeftHandSide= ruleFeatureLeftHandSide EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3749:2: iv_ruleFeatureLeftHandSide= ruleFeatureLeftHandSide EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureLeftHandSideRule()); 
            }
            pushFollow(FOLLOW_ruleFeatureLeftHandSide_in_entryRuleFeatureLeftHandSide8342);
            iv_ruleFeatureLeftHandSide=ruleFeatureLeftHandSide();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureLeftHandSide; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureLeftHandSide8352); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureLeftHandSide"


    // $ANTLR start "ruleFeatureLeftHandSide"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3756:1: ruleFeatureLeftHandSide returns [EObject current=null] : ( (lv_expression_0_0= rulePropertyAccessExpression ) ) ;
    public final EObject ruleFeatureLeftHandSide() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3759:28: ( ( (lv_expression_0_0= rulePropertyAccessExpression ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3760:1: ( (lv_expression_0_0= rulePropertyAccessExpression ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3760:1: ( (lv_expression_0_0= rulePropertyAccessExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3761:1: (lv_expression_0_0= rulePropertyAccessExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3761:1: (lv_expression_0_0= rulePropertyAccessExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3762:3: lv_expression_0_0= rulePropertyAccessExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFeatureLeftHandSideAccess().getExpressionPropertyAccessExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_rulePropertyAccessExpression_in_ruleFeatureLeftHandSide8397);
            lv_expression_0_0=rulePropertyAccessExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFeatureLeftHandSideRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_0_0, 
                      		"PropertyAccessExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureLeftHandSide"


    // $ANTLR start "entryRuleStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3786:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3787:2: (iv_ruleStatement= ruleStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3788:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement8432);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement8442); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3795:1: ruleStatement returns [EObject current=null] : ( (this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';' ) | this_BlockStatement_2= ruleBlockStatement | this_IfStatement_3= ruleIfStatement | this_SwitchStatement_4= ruleSwitchStatement | this_WhileStatement_5= ruleWhileStatement | this_ForStatement_6= ruleForStatement | this_ForEachStatement_7= ruleForEachStatement | this_DoStatement_8= ruleDoStatement | this_BreakStatement_9= ruleBreakStatement | this_ReturnStatement_10= ruleReturnStatement | this_ClassifyStatement_11= ruleClassifyStatement | this_SendSignalStatement_12= ruleSendSignalStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_SimpleStatement_0 = null;

        EObject this_BlockStatement_2 = null;

        EObject this_IfStatement_3 = null;

        EObject this_SwitchStatement_4 = null;

        EObject this_WhileStatement_5 = null;

        EObject this_ForStatement_6 = null;

        EObject this_ForEachStatement_7 = null;

        EObject this_DoStatement_8 = null;

        EObject this_BreakStatement_9 = null;

        EObject this_ReturnStatement_10 = null;

        EObject this_ClassifyStatement_11 = null;

        EObject this_SendSignalStatement_12 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3798:28: ( ( (this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';' ) | this_BlockStatement_2= ruleBlockStatement | this_IfStatement_3= ruleIfStatement | this_SwitchStatement_4= ruleSwitchStatement | this_WhileStatement_5= ruleWhileStatement | this_ForStatement_6= ruleForStatement | this_ForEachStatement_7= ruleForEachStatement | this_DoStatement_8= ruleDoStatement | this_BreakStatement_9= ruleBreakStatement | this_ReturnStatement_10= ruleReturnStatement | this_ClassifyStatement_11= ruleClassifyStatement | this_SendSignalStatement_12= ruleSendSignalStatement ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3799:1: ( (this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';' ) | this_BlockStatement_2= ruleBlockStatement | this_IfStatement_3= ruleIfStatement | this_SwitchStatement_4= ruleSwitchStatement | this_WhileStatement_5= ruleWhileStatement | this_ForStatement_6= ruleForStatement | this_ForEachStatement_7= ruleForEachStatement | this_DoStatement_8= ruleDoStatement | this_BreakStatement_9= ruleBreakStatement | this_ReturnStatement_10= ruleReturnStatement | this_ClassifyStatement_11= ruleClassifyStatement | this_SendSignalStatement_12= ruleSendSignalStatement )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3799:1: ( (this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';' ) | this_BlockStatement_2= ruleBlockStatement | this_IfStatement_3= ruleIfStatement | this_SwitchStatement_4= ruleSwitchStatement | this_WhileStatement_5= ruleWhileStatement | this_ForStatement_6= ruleForStatement | this_ForEachStatement_7= ruleForEachStatement | this_DoStatement_8= ruleDoStatement | this_BreakStatement_9= ruleBreakStatement | this_ReturnStatement_10= ruleReturnStatement | this_ClassifyStatement_11= ruleClassifyStatement | this_SendSignalStatement_12= ruleSendSignalStatement )
            int alt40=12;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3799:2: (this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3799:2: (this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3800:2: this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';'
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getSimpleStatementParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSimpleStatement_in_ruleStatement8493);
                    this_SimpleStatement_0=ruleSimpleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SimpleStatement_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_1=(Token)match(input,46,FOLLOW_46_in_ruleStatement8504); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3817:2: this_BlockStatement_2= ruleBlockStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getBlockStatementParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBlockStatement_in_ruleStatement8536);
                    this_BlockStatement_2=ruleBlockStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BlockStatement_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3830:2: this_IfStatement_3= ruleIfStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIfStatement_in_ruleStatement8566);
                    this_IfStatement_3=ruleIfStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IfStatement_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3843:2: this_SwitchStatement_4= ruleSwitchStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getSwitchStatementParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSwitchStatement_in_ruleStatement8596);
                    this_SwitchStatement_4=ruleSwitchStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SwitchStatement_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3856:2: this_WhileStatement_5= ruleWhileStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getWhileStatementParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleWhileStatement_in_ruleStatement8626);
                    this_WhileStatement_5=ruleWhileStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_WhileStatement_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3869:2: this_ForStatement_6= ruleForStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getForStatementParserRuleCall_5()); 
                          
                    }
                    pushFollow(FOLLOW_ruleForStatement_in_ruleStatement8656);
                    this_ForStatement_6=ruleForStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ForStatement_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3882:2: this_ForEachStatement_7= ruleForEachStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getForEachStatementParserRuleCall_6()); 
                          
                    }
                    pushFollow(FOLLOW_ruleForEachStatement_in_ruleStatement8686);
                    this_ForEachStatement_7=ruleForEachStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ForEachStatement_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3895:2: this_DoStatement_8= ruleDoStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getDoStatementParserRuleCall_7()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDoStatement_in_ruleStatement8716);
                    this_DoStatement_8=ruleDoStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DoStatement_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3908:2: this_BreakStatement_9= ruleBreakStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getBreakStatementParserRuleCall_8()); 
                          
                    }
                    pushFollow(FOLLOW_ruleBreakStatement_in_ruleStatement8746);
                    this_BreakStatement_9=ruleBreakStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BreakStatement_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3921:2: this_ReturnStatement_10= ruleReturnStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_ruleReturnStatement_in_ruleStatement8776);
                    this_ReturnStatement_10=ruleReturnStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ReturnStatement_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3934:2: this_ClassifyStatement_11= ruleClassifyStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getClassifyStatementParserRuleCall_10()); 
                          
                    }
                    pushFollow(FOLLOW_ruleClassifyStatement_in_ruleStatement8806);
                    this_ClassifyStatement_11=ruleClassifyStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ClassifyStatement_11; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3947:2: this_SendSignalStatement_12= ruleSendSignalStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getStatementAccess().getSendSignalStatementParserRuleCall_11()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSendSignalStatement_in_ruleStatement8836);
                    this_SendSignalStatement_12=ruleSendSignalStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SendSignalStatement_12; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleSimpleStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3966:1: entryRuleSimpleStatement returns [EObject current=null] : iv_ruleSimpleStatement= ruleSimpleStatement EOF ;
    public final EObject entryRuleSimpleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3967:2: (iv_ruleSimpleStatement= ruleSimpleStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3968:2: iv_ruleSimpleStatement= ruleSimpleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleStatementRule()); 
            }
            pushFollow(FOLLOW_ruleSimpleStatement_in_entryRuleSimpleStatement8871);
            iv_ruleSimpleStatement=ruleSimpleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleStatement8881); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSimpleStatement"


    // $ANTLR start "ruleSimpleStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3975:1: ruleSimpleStatement returns [EObject current=null] : (this_LocalNameDeclarationStatement_0= ruleLocalNameDeclarationStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_EmptyStatement_2= ruleEmptyStatement ) ;
    public final EObject ruleSimpleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_LocalNameDeclarationStatement_0 = null;

        EObject this_ExpressionStatement_1 = null;

        EObject this_EmptyStatement_2 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3978:28: ( (this_LocalNameDeclarationStatement_0= ruleLocalNameDeclarationStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_EmptyStatement_2= ruleEmptyStatement ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3979:1: (this_LocalNameDeclarationStatement_0= ruleLocalNameDeclarationStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_EmptyStatement_2= ruleEmptyStatement )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3979:1: (this_LocalNameDeclarationStatement_0= ruleLocalNameDeclarationStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_EmptyStatement_2= ruleEmptyStatement )
            int alt41=3;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3980:2: this_LocalNameDeclarationStatement_0= ruleLocalNameDeclarationStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSimpleStatementAccess().getLocalNameDeclarationStatementParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLocalNameDeclarationStatement_in_ruleSimpleStatement8931);
                    this_LocalNameDeclarationStatement_0=ruleLocalNameDeclarationStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LocalNameDeclarationStatement_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3993:2: this_ExpressionStatement_1= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSimpleStatementAccess().getExpressionStatementParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpressionStatement_in_ruleSimpleStatement8961);
                    this_ExpressionStatement_1=ruleExpressionStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ExpressionStatement_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4006:2: this_EmptyStatement_2= ruleEmptyStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSimpleStatementAccess().getEmptyStatementParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleEmptyStatement_in_ruleSimpleStatement8991);
                    this_EmptyStatement_2=ruleEmptyStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_EmptyStatement_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleStatement"


    // $ANTLR start "entryRuleBlock"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4025:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4026:2: (iv_ruleBlock= ruleBlock EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4027:2: iv_ruleBlock= ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockRule()); 
            }
            pushFollow(FOLLOW_ruleBlock_in_entryRuleBlock9026);
            iv_ruleBlock=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlock; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlock9036); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4034:1: ruleBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statement_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statement_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4037:28: ( ( () otherlv_1= '{' ( (lv_statement_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4038:1: ( () otherlv_1= '{' ( (lv_statement_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4038:1: ( () otherlv_1= '{' ( (lv_statement_2_0= ruleStatement ) )* otherlv_3= '}' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4038:2: () otherlv_1= '{' ( (lv_statement_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4038:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4039:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBlockAccess().getBlockAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleBlock9085); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4051:1: ( (lv_statement_2_0= ruleStatement ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==EOF||(LA42_0>=RULE_ID && LA42_0<=RULE_STRING)||(LA42_0>=16 && LA42_0<=19)||(LA42_0>=22 && LA42_0<=23)||LA42_0==25||LA42_0==28||(LA42_0>=32 && LA42_0<=34)||(LA42_0>=37 && LA42_0<=38)||LA42_0==46||LA42_0==48||LA42_0==51||(LA42_0>=54 && LA42_0<=59)||LA42_0==62||(LA42_0>=65 && LA42_0<=69)) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4052:1: (lv_statement_2_0= ruleStatement )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4052:1: (lv_statement_2_0= ruleStatement )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4053:3: lv_statement_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getBlockAccess().getStatementStatementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStatement_in_ruleBlock9106);
            	    lv_statement_2_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getBlockRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"statement",
            	              		lv_statement_2_0, 
            	              		"Statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleBlock9119); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleBlockStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4081:1: entryRuleBlockStatement returns [EObject current=null] : iv_ruleBlockStatement= ruleBlockStatement EOF ;
    public final EObject entryRuleBlockStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlockStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4082:2: (iv_ruleBlockStatement= ruleBlockStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4083:2: iv_ruleBlockStatement= ruleBlockStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockStatementRule()); 
            }
            pushFollow(FOLLOW_ruleBlockStatement_in_entryRuleBlockStatement9155);
            iv_ruleBlockStatement=ruleBlockStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlockStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBlockStatement9165); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlockStatement"


    // $ANTLR start "ruleBlockStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4090:1: ruleBlockStatement returns [EObject current=null] : this_Block_0= ruleBlock ;
    public final EObject ruleBlockStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Block_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4093:28: (this_Block_0= ruleBlock )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4095:2: this_Block_0= ruleBlock
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getBlockStatementAccess().getBlockParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleBlock_in_ruleBlockStatement9214);
            this_Block_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Block_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlockStatement"


    // $ANTLR start "entryRuleEmptyStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4114:1: entryRuleEmptyStatement returns [EObject current=null] : iv_ruleEmptyStatement= ruleEmptyStatement EOF ;
    public final EObject entryRuleEmptyStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEmptyStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4115:2: (iv_ruleEmptyStatement= ruleEmptyStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4116:2: iv_ruleEmptyStatement= ruleEmptyStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEmptyStatementRule()); 
            }
            pushFollow(FOLLOW_ruleEmptyStatement_in_entryRuleEmptyStatement9248);
            iv_ruleEmptyStatement=ruleEmptyStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEmptyStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEmptyStatement9258); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEmptyStatement"


    // $ANTLR start "ruleEmptyStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4123:1: ruleEmptyStatement returns [EObject current=null] : () ;
    public final EObject ruleEmptyStatement() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4126:28: ( () )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4127:1: ()
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4127:1: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4128:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getEmptyStatementAccess().getEmptyStatementAction(),
                          current);
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEmptyStatement"


    // $ANTLR start "entryRuleMultiplicityIndicator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4144:1: entryRuleMultiplicityIndicator returns [String current=null] : iv_ruleMultiplicityIndicator= ruleMultiplicityIndicator EOF ;
    public final String entryRuleMultiplicityIndicator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiplicityIndicator = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4145:2: (iv_ruleMultiplicityIndicator= ruleMultiplicityIndicator EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4146:2: iv_ruleMultiplicityIndicator= ruleMultiplicityIndicator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityIndicatorRule()); 
            }
            pushFollow(FOLLOW_ruleMultiplicityIndicator_in_entryRuleMultiplicityIndicator9330);
            iv_ruleMultiplicityIndicator=ruleMultiplicityIndicator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityIndicator.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityIndicator9341); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicityIndicator"


    // $ANTLR start "ruleMultiplicityIndicator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4153:1: ruleMultiplicityIndicator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleMultiplicityIndicator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4156:28: ( (kw= '[' kw= ']' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4157:1: (kw= '[' kw= ']' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4157:1: (kw= '[' kw= ']' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4158:2: kw= '[' kw= ']'
            {
            kw=(Token)match(input,30,FOLLOW_30_in_ruleMultiplicityIndicator9379); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getMultiplicityIndicatorAccess().getLeftSquareBracketKeyword_0()); 
                  
            }
            kw=(Token)match(input,31,FOLLOW_31_in_ruleMultiplicityIndicator9392); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getMultiplicityIndicatorAccess().getRightSquareBracketKeyword_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicityIndicator"


    // $ANTLR start "entryRuleVariableDeclaration"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4177:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4178:2: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4179:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration9432);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDeclaration9442); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4186:1: ruleVariableDeclaration returns [EObject current=null] : ( () ( (lv_type_1_0= ruleTypeDeclaration ) ) ( (lv_hasMultiplicity_2_0= ruleMultiplicityIndicator ) )? ( (lv_name_3_0= ruleName ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject lv_type_1_0 = null;

        AntlrDatatypeRuleToken lv_hasMultiplicity_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4189:28: ( ( () ( (lv_type_1_0= ruleTypeDeclaration ) ) ( (lv_hasMultiplicity_2_0= ruleMultiplicityIndicator ) )? ( (lv_name_3_0= ruleName ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4190:1: ( () ( (lv_type_1_0= ruleTypeDeclaration ) ) ( (lv_hasMultiplicity_2_0= ruleMultiplicityIndicator ) )? ( (lv_name_3_0= ruleName ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4190:1: ( () ( (lv_type_1_0= ruleTypeDeclaration ) ) ( (lv_hasMultiplicity_2_0= ruleMultiplicityIndicator ) )? ( (lv_name_3_0= ruleName ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4190:2: () ( (lv_type_1_0= ruleTypeDeclaration ) ) ( (lv_hasMultiplicity_2_0= ruleMultiplicityIndicator ) )? ( (lv_name_3_0= ruleName ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4190:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4191:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getVariableDeclarationAccess().getVariableAction_0(),
                          current);
                  
            }

            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4199:2: ( (lv_type_1_0= ruleTypeDeclaration ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4200:1: (lv_type_1_0= ruleTypeDeclaration )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4200:1: (lv_type_1_0= ruleTypeDeclaration )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4201:3: lv_type_1_0= ruleTypeDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeDeclarationParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTypeDeclaration_in_ruleVariableDeclaration9500);
            lv_type_1_0=ruleTypeDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"TypeDeclaration");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4217:2: ( (lv_hasMultiplicity_2_0= ruleMultiplicityIndicator ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==30) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4218:1: (lv_hasMultiplicity_2_0= ruleMultiplicityIndicator )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4218:1: (lv_hasMultiplicity_2_0= ruleMultiplicityIndicator )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4219:3: lv_hasMultiplicity_2_0= ruleMultiplicityIndicator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getHasMultiplicityMultiplicityIndicatorParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleMultiplicityIndicator_in_ruleVariableDeclaration9521);
                    lv_hasMultiplicity_2_0=ruleMultiplicityIndicator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      	        }
                             		set(
                             			current, 
                             			"hasMultiplicity",
                              		true, 
                              		"MultiplicityIndicator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4235:3: ( (lv_name_3_0= ruleName ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4236:1: (lv_name_3_0= ruleName )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4236:1: (lv_name_3_0= ruleName )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4237:3: lv_name_3_0= ruleName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameNameParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleName_in_ruleVariableDeclaration9543);
            lv_name_3_0=ruleName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_3_0, 
                      		"Name");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleLocalNameDeclarationStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4261:1: entryRuleLocalNameDeclarationStatement returns [EObject current=null] : iv_ruleLocalNameDeclarationStatement= ruleLocalNameDeclarationStatement EOF ;
    public final EObject entryRuleLocalNameDeclarationStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalNameDeclarationStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4262:2: (iv_ruleLocalNameDeclarationStatement= ruleLocalNameDeclarationStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4263:2: iv_ruleLocalNameDeclarationStatement= ruleLocalNameDeclarationStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLocalNameDeclarationStatementRule()); 
            }
            pushFollow(FOLLOW_ruleLocalNameDeclarationStatement_in_entryRuleLocalNameDeclarationStatement9579);
            iv_ruleLocalNameDeclarationStatement=ruleLocalNameDeclarationStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLocalNameDeclarationStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLocalNameDeclarationStatement9589); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalNameDeclarationStatement"


    // $ANTLR start "ruleLocalNameDeclarationStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4270:1: ruleLocalNameDeclarationStatement returns [EObject current=null] : ( ( (lv_variable_0_0= ruleVariableDeclaration ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleInitializationExpression ) ) ) ;
    public final EObject ruleLocalNameDeclarationStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_variable_0_0 = null;

        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4273:28: ( ( ( (lv_variable_0_0= ruleVariableDeclaration ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleInitializationExpression ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4274:1: ( ( (lv_variable_0_0= ruleVariableDeclaration ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleInitializationExpression ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4274:1: ( ( (lv_variable_0_0= ruleVariableDeclaration ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleInitializationExpression ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4274:2: ( (lv_variable_0_0= ruleVariableDeclaration ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleInitializationExpression ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4274:2: ( (lv_variable_0_0= ruleVariableDeclaration ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4275:1: (lv_variable_0_0= ruleVariableDeclaration )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4275:1: (lv_variable_0_0= ruleVariableDeclaration )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4276:3: lv_variable_0_0= ruleVariableDeclaration
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLocalNameDeclarationStatementAccess().getVariableVariableDeclarationParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleVariableDeclaration_in_ruleLocalNameDeclarationStatement9635);
            lv_variable_0_0=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLocalNameDeclarationStatementRule());
              	        }
                     		set(
                     			current, 
                     			"variable",
                      		lv_variable_0_0, 
                      		"VariableDeclaration");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleLocalNameDeclarationStatement9647); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLocalNameDeclarationStatementAccess().getEqualsSignKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4296:1: ( (lv_expression_2_0= ruleInitializationExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4297:1: (lv_expression_2_0= ruleInitializationExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4297:1: (lv_expression_2_0= ruleInitializationExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4298:3: lv_expression_2_0= ruleInitializationExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLocalNameDeclarationStatementAccess().getExpressionInitializationExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleInitializationExpression_in_ruleLocalNameDeclarationStatement9668);
            lv_expression_2_0=ruleInitializationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLocalNameDeclarationStatementRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"InitializationExpression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalNameDeclarationStatement"


    // $ANTLR start "entryRuleInitializationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4322:1: entryRuleInitializationExpression returns [EObject current=null] : iv_ruleInitializationExpression= ruleInitializationExpression EOF ;
    public final EObject entryRuleInitializationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitializationExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4323:2: (iv_ruleInitializationExpression= ruleInitializationExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4324:2: iv_ruleInitializationExpression= ruleInitializationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInitializationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleInitializationExpression_in_entryRuleInitializationExpression9704);
            iv_ruleInitializationExpression=ruleInitializationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInitializationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitializationExpression9714); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitializationExpression"


    // $ANTLR start "ruleInitializationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4331:1: ruleInitializationExpression returns [EObject current=null] : (this_Expression_0= ruleExpression | this_InstanceInitializationExpression_1= ruleInstanceInitializationExpression ) ;
    public final EObject ruleInitializationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Expression_0 = null;

        EObject this_InstanceInitializationExpression_1 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4334:28: ( (this_Expression_0= ruleExpression | this_InstanceInitializationExpression_1= ruleInstanceInitializationExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4335:1: (this_Expression_0= ruleExpression | this_InstanceInitializationExpression_1= ruleInstanceInitializationExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4335:1: (this_Expression_0= ruleExpression | this_InstanceInitializationExpression_1= ruleInstanceInitializationExpression )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_ID && LA44_0<=RULE_STRING)||(LA44_0>=16 && LA44_0<=18)||LA44_0==22||LA44_0==25||LA44_0==28||(LA44_0>=32 && LA44_0<=34)||(LA44_0>=37 && LA44_0<=38)||(LA44_0>=65 && LA44_0<=69)) ) {
                alt44=1;
            }
            else if ( (LA44_0==23) ) {
                int LA44_2 = input.LA(2);

                if ( ((LA44_2>=RULE_ID && LA44_2<=RULE_UNRESTRICTED_NAME)) ) {
                    alt44=1;
                }
                else if ( (LA44_2==18) ) {
                    alt44=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4336:2: this_Expression_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getInitializationExpressionAccess().getExpressionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleInitializationExpression9764);
                    this_Expression_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Expression_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4349:2: this_InstanceInitializationExpression_1= ruleInstanceInitializationExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getInitializationExpressionAccess().getInstanceInitializationExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleInstanceInitializationExpression_in_ruleInitializationExpression9794);
                    this_InstanceInitializationExpression_1=ruleInstanceInitializationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_InstanceInitializationExpression_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitializationExpression"


    // $ANTLR start "entryRuleInstanceInitializationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4368:1: entryRuleInstanceInitializationExpression returns [EObject current=null] : iv_ruleInstanceInitializationExpression= ruleInstanceInitializationExpression EOF ;
    public final EObject entryRuleInstanceInitializationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceInitializationExpression = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4369:2: (iv_ruleInstanceInitializationExpression= ruleInstanceInitializationExpression EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4370:2: iv_ruleInstanceInitializationExpression= ruleInstanceInitializationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInstanceInitializationExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleInstanceInitializationExpression_in_entryRuleInstanceInitializationExpression9829);
            iv_ruleInstanceInitializationExpression=ruleInstanceInitializationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInstanceInitializationExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceInitializationExpression9839); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceInitializationExpression"


    // $ANTLR start "ruleInstanceInitializationExpression"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4377:1: ruleInstanceInitializationExpression returns [EObject current=null] : (otherlv_0= 'new' ( (lv_tuple_1_0= ruleTuple ) ) ) ;
    public final EObject ruleInstanceInitializationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_tuple_1_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4380:28: ( (otherlv_0= 'new' ( (lv_tuple_1_0= ruleTuple ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4381:1: (otherlv_0= 'new' ( (lv_tuple_1_0= ruleTuple ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4381:1: (otherlv_0= 'new' ( (lv_tuple_1_0= ruleTuple ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4381:3: otherlv_0= 'new' ( (lv_tuple_1_0= ruleTuple ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleInstanceInitializationExpression9876); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInstanceInitializationExpressionAccess().getNewKeyword_0());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4385:1: ( (lv_tuple_1_0= ruleTuple ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4386:1: (lv_tuple_1_0= ruleTuple )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4386:1: (lv_tuple_1_0= ruleTuple )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4387:3: lv_tuple_1_0= ruleTuple
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getInstanceInitializationExpressionAccess().getTupleTupleParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTuple_in_ruleInstanceInitializationExpression9897);
            lv_tuple_1_0=ruleTuple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getInstanceInitializationExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"tuple",
                      		lv_tuple_1_0, 
                      		"Tuple");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceInitializationExpression"


    // $ANTLR start "entryRuleExpressionStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4411:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4412:2: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4413:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement9933);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressionStatement9943); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionStatement"


    // $ANTLR start "ruleExpressionStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4420:1: ruleExpressionStatement returns [EObject current=null] : ( (lv_expression_0_0= ruleExpression ) ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4423:28: ( ( (lv_expression_0_0= ruleExpression ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4424:1: ( (lv_expression_0_0= ruleExpression ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4424:1: ( (lv_expression_0_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4425:1: (lv_expression_0_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4425:1: (lv_expression_0_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4426:3: lv_expression_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExpressionStatementAccess().getExpressionExpressionParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleExpressionStatement9988);
            lv_expression_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_0_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionStatement"


    // $ANTLR start "entryRuleIfStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4450:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4451:2: (iv_ruleIfStatement= ruleIfStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4452:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfStatementRule()); 
            }
            pushFollow(FOLLOW_ruleIfStatement_in_entryRuleIfStatement10023);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfStatement10033); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4459:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' ( (lv_nonFinalClauses_1_0= ruleConcurrentClauses ) ) (otherlv_2= 'else' otherlv_3= 'if' ( (lv_nonFinalClauses_4_0= ruleConcurrentClauses ) ) )* (otherlv_5= 'else' ( (lv_finalClause_6_0= ruleBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_nonFinalClauses_1_0 = null;

        EObject lv_nonFinalClauses_4_0 = null;

        EObject lv_finalClause_6_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4462:28: ( (otherlv_0= 'if' ( (lv_nonFinalClauses_1_0= ruleConcurrentClauses ) ) (otherlv_2= 'else' otherlv_3= 'if' ( (lv_nonFinalClauses_4_0= ruleConcurrentClauses ) ) )* (otherlv_5= 'else' ( (lv_finalClause_6_0= ruleBlock ) ) )? ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4463:1: (otherlv_0= 'if' ( (lv_nonFinalClauses_1_0= ruleConcurrentClauses ) ) (otherlv_2= 'else' otherlv_3= 'if' ( (lv_nonFinalClauses_4_0= ruleConcurrentClauses ) ) )* (otherlv_5= 'else' ( (lv_finalClause_6_0= ruleBlock ) ) )? )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4463:1: (otherlv_0= 'if' ( (lv_nonFinalClauses_1_0= ruleConcurrentClauses ) ) (otherlv_2= 'else' otherlv_3= 'if' ( (lv_nonFinalClauses_4_0= ruleConcurrentClauses ) ) )* (otherlv_5= 'else' ( (lv_finalClause_6_0= ruleBlock ) ) )? )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4463:3: otherlv_0= 'if' ( (lv_nonFinalClauses_1_0= ruleConcurrentClauses ) ) (otherlv_2= 'else' otherlv_3= 'if' ( (lv_nonFinalClauses_4_0= ruleConcurrentClauses ) ) )* (otherlv_5= 'else' ( (lv_finalClause_6_0= ruleBlock ) ) )?
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleIfStatement10070); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4467:1: ( (lv_nonFinalClauses_1_0= ruleConcurrentClauses ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4468:1: (lv_nonFinalClauses_1_0= ruleConcurrentClauses )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4468:1: (lv_nonFinalClauses_1_0= ruleConcurrentClauses )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4469:3: lv_nonFinalClauses_1_0= ruleConcurrentClauses
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfStatementAccess().getNonFinalClausesConcurrentClausesParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConcurrentClauses_in_ruleIfStatement10091);
            lv_nonFinalClauses_1_0=ruleConcurrentClauses();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
              	        }
                     		add(
                     			current, 
                     			"nonFinalClauses",
                      		lv_nonFinalClauses_1_0, 
                      		"ConcurrentClauses");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4485:2: (otherlv_2= 'else' otherlv_3= 'if' ( (lv_nonFinalClauses_4_0= ruleConcurrentClauses ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==49) ) {
                    int LA45_1 = input.LA(2);

                    if ( (LA45_1==48) ) {
                        alt45=1;
                    }


                }


                switch (alt45) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4485:4: otherlv_2= 'else' otherlv_3= 'if' ( (lv_nonFinalClauses_4_0= ruleConcurrentClauses ) )
            	    {
            	    otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleIfStatement10104); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getIfStatementAccess().getElseKeyword_2_0());
            	          
            	    }
            	    otherlv_3=(Token)match(input,48,FOLLOW_48_in_ruleIfStatement10116); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getIfKeyword_2_1());
            	          
            	    }
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4493:1: ( (lv_nonFinalClauses_4_0= ruleConcurrentClauses ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4494:1: (lv_nonFinalClauses_4_0= ruleConcurrentClauses )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4494:1: (lv_nonFinalClauses_4_0= ruleConcurrentClauses )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4495:3: lv_nonFinalClauses_4_0= ruleConcurrentClauses
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIfStatementAccess().getNonFinalClausesConcurrentClausesParserRuleCall_2_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleConcurrentClauses_in_ruleIfStatement10137);
            	    lv_nonFinalClauses_4_0=ruleConcurrentClauses();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"nonFinalClauses",
            	              		lv_nonFinalClauses_4_0, 
            	              		"ConcurrentClauses");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4511:4: (otherlv_5= 'else' ( (lv_finalClause_6_0= ruleBlock ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==49) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4511:6: otherlv_5= 'else' ( (lv_finalClause_6_0= ruleBlock ) )
                    {
                    otherlv_5=(Token)match(input,49,FOLLOW_49_in_ruleIfStatement10152); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getIfStatementAccess().getElseKeyword_3_0());
                          
                    }
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4515:1: ( (lv_finalClause_6_0= ruleBlock ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4516:1: (lv_finalClause_6_0= ruleBlock )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4516:1: (lv_finalClause_6_0= ruleBlock )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4517:3: lv_finalClause_6_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfStatementAccess().getFinalClauseBlockParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleBlock_in_ruleIfStatement10173);
                    lv_finalClause_6_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"finalClause",
                              		lv_finalClause_6_0, 
                              		"Block");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleConcurrentClauses"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4541:1: entryRuleConcurrentClauses returns [EObject current=null] : iv_ruleConcurrentClauses= ruleConcurrentClauses EOF ;
    public final EObject entryRuleConcurrentClauses() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcurrentClauses = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4542:2: (iv_ruleConcurrentClauses= ruleConcurrentClauses EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4543:2: iv_ruleConcurrentClauses= ruleConcurrentClauses EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConcurrentClausesRule()); 
            }
            pushFollow(FOLLOW_ruleConcurrentClauses_in_entryRuleConcurrentClauses10211);
            iv_ruleConcurrentClauses=ruleConcurrentClauses();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConcurrentClauses; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcurrentClauses10221); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcurrentClauses"


    // $ANTLR start "ruleConcurrentClauses"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4550:1: ruleConcurrentClauses returns [EObject current=null] : ( ( (lv_clause_0_0= ruleNonFinalClause ) ) (otherlv_1= 'or' otherlv_2= 'if' ( (lv_clause_3_0= ruleNonFinalClause ) ) )* ) ;
    public final EObject ruleConcurrentClauses() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_clause_0_0 = null;

        EObject lv_clause_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4553:28: ( ( ( (lv_clause_0_0= ruleNonFinalClause ) ) (otherlv_1= 'or' otherlv_2= 'if' ( (lv_clause_3_0= ruleNonFinalClause ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4554:1: ( ( (lv_clause_0_0= ruleNonFinalClause ) ) (otherlv_1= 'or' otherlv_2= 'if' ( (lv_clause_3_0= ruleNonFinalClause ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4554:1: ( ( (lv_clause_0_0= ruleNonFinalClause ) ) (otherlv_1= 'or' otherlv_2= 'if' ( (lv_clause_3_0= ruleNonFinalClause ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4554:2: ( (lv_clause_0_0= ruleNonFinalClause ) ) (otherlv_1= 'or' otherlv_2= 'if' ( (lv_clause_3_0= ruleNonFinalClause ) ) )*
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4554:2: ( (lv_clause_0_0= ruleNonFinalClause ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4555:1: (lv_clause_0_0= ruleNonFinalClause )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4555:1: (lv_clause_0_0= ruleNonFinalClause )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4556:3: lv_clause_0_0= ruleNonFinalClause
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConcurrentClausesAccess().getClauseNonFinalClauseParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNonFinalClause_in_ruleConcurrentClauses10267);
            lv_clause_0_0=ruleNonFinalClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConcurrentClausesRule());
              	        }
                     		add(
                     			current, 
                     			"clause",
                      		lv_clause_0_0, 
                      		"NonFinalClause");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4572:2: (otherlv_1= 'or' otherlv_2= 'if' ( (lv_clause_3_0= ruleNonFinalClause ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==50) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4572:4: otherlv_1= 'or' otherlv_2= 'if' ( (lv_clause_3_0= ruleNonFinalClause ) )
            	    {
            	    otherlv_1=(Token)match(input,50,FOLLOW_50_in_ruleConcurrentClauses10280); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getConcurrentClausesAccess().getOrKeyword_1_0());
            	          
            	    }
            	    otherlv_2=(Token)match(input,48,FOLLOW_48_in_ruleConcurrentClauses10292); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getConcurrentClausesAccess().getIfKeyword_1_1());
            	          
            	    }
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4580:1: ( (lv_clause_3_0= ruleNonFinalClause ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4581:1: (lv_clause_3_0= ruleNonFinalClause )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4581:1: (lv_clause_3_0= ruleNonFinalClause )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4582:3: lv_clause_3_0= ruleNonFinalClause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConcurrentClausesAccess().getClauseNonFinalClauseParserRuleCall_1_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleNonFinalClause_in_ruleConcurrentClauses10313);
            	    lv_clause_3_0=ruleNonFinalClause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getConcurrentClausesRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"clause",
            	              		lv_clause_3_0, 
            	              		"NonFinalClause");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcurrentClauses"


    // $ANTLR start "entryRuleNonFinalClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4606:1: entryRuleNonFinalClause returns [EObject current=null] : iv_ruleNonFinalClause= ruleNonFinalClause EOF ;
    public final EObject entryRuleNonFinalClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonFinalClause = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4607:2: (iv_ruleNonFinalClause= ruleNonFinalClause EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4608:2: iv_ruleNonFinalClause= ruleNonFinalClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNonFinalClauseRule()); 
            }
            pushFollow(FOLLOW_ruleNonFinalClause_in_entryRuleNonFinalClause10351);
            iv_ruleNonFinalClause=ruleNonFinalClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNonFinalClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonFinalClause10361); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNonFinalClause"


    // $ANTLR start "ruleNonFinalClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4615:1: ruleNonFinalClause returns [EObject current=null] : (otherlv_0= '(' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= ')' ( (lv_body_3_0= ruleBlock ) ) ) ;
    public final EObject ruleNonFinalClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_body_3_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4618:28: ( (otherlv_0= '(' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= ')' ( (lv_body_3_0= ruleBlock ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4619:1: (otherlv_0= '(' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= ')' ( (lv_body_3_0= ruleBlock ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4619:1: (otherlv_0= '(' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= ')' ( (lv_body_3_0= ruleBlock ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4619:3: otherlv_0= '(' ( (lv_condition_1_0= ruleExpression ) ) otherlv_2= ')' ( (lv_body_3_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleNonFinalClause10398); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNonFinalClauseAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4623:1: ( (lv_condition_1_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4624:1: (lv_condition_1_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4624:1: (lv_condition_1_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4625:3: lv_condition_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNonFinalClauseAccess().getConditionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleNonFinalClause10419);
            lv_condition_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNonFinalClauseRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_1_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleNonFinalClause10431); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getNonFinalClauseAccess().getRightParenthesisKeyword_2());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4645:1: ( (lv_body_3_0= ruleBlock ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4646:1: (lv_body_3_0= ruleBlock )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4646:1: (lv_body_3_0= ruleBlock )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4647:3: lv_body_3_0= ruleBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNonFinalClauseAccess().getBodyBlockParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBlock_in_ruleNonFinalClause10452);
            lv_body_3_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNonFinalClauseRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_3_0, 
                      		"Block");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNonFinalClause"


    // $ANTLR start "entryRuleSwitchStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4671:1: entryRuleSwitchStatement returns [EObject current=null] : iv_ruleSwitchStatement= ruleSwitchStatement EOF ;
    public final EObject entryRuleSwitchStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4672:2: (iv_ruleSwitchStatement= ruleSwitchStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4673:2: iv_ruleSwitchStatement= ruleSwitchStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchStatementRule()); 
            }
            pushFollow(FOLLOW_ruleSwitchStatement_in_entryRuleSwitchStatement10488);
            iv_ruleSwitchStatement=ruleSwitchStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchStatement10498); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchStatement"


    // $ANTLR start "ruleSwitchStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4680:1: ruleSwitchStatement returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_nonDefaultClause_5_0= ruleSwitchClause ) )* ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )? otherlv_7= '}' ) ;
    public final EObject ruleSwitchStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_expression_2_0 = null;

        EObject lv_nonDefaultClause_5_0 = null;

        EObject lv_defaultClause_6_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4683:28: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_nonDefaultClause_5_0= ruleSwitchClause ) )* ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )? otherlv_7= '}' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4684:1: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_nonDefaultClause_5_0= ruleSwitchClause ) )* ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )? otherlv_7= '}' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4684:1: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_nonDefaultClause_5_0= ruleSwitchClause ) )* ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )? otherlv_7= '}' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4684:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_nonDefaultClause_5_0= ruleSwitchClause ) )* ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_51_in_ruleSwitchStatement10535); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSwitchStatementAccess().getSwitchKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleSwitchStatement10547); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSwitchStatementAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4692:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4693:1: (lv_expression_2_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4693:1: (lv_expression_2_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4694:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchStatement10568);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSwitchStatementRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleSwitchStatement10580); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSwitchStatementAccess().getRightParenthesisKeyword_3());
                  
            }
            otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleSwitchStatement10592); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSwitchStatementAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4718:1: ( (lv_nonDefaultClause_5_0= ruleSwitchClause ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==52) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4719:1: (lv_nonDefaultClause_5_0= ruleSwitchClause )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4719:1: (lv_nonDefaultClause_5_0= ruleSwitchClause )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4720:3: lv_nonDefaultClause_5_0= ruleSwitchClause
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSwitchStatementAccess().getNonDefaultClauseSwitchClauseParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSwitchClause_in_ruleSwitchStatement10613);
            	    lv_nonDefaultClause_5_0=ruleSwitchClause();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSwitchStatementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"nonDefaultClause",
            	              		lv_nonDefaultClause_5_0, 
            	              		"SwitchClause");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4736:3: ( (lv_defaultClause_6_0= ruleSwitchDefaultClause ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==53) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4737:1: (lv_defaultClause_6_0= ruleSwitchDefaultClause )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4737:1: (lv_defaultClause_6_0= ruleSwitchDefaultClause )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4738:3: lv_defaultClause_6_0= ruleSwitchDefaultClause
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSwitchStatementAccess().getDefaultClauseSwitchDefaultClauseParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSwitchDefaultClause_in_ruleSwitchStatement10635);
                    lv_defaultClause_6_0=ruleSwitchDefaultClause();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSwitchStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"defaultClause",
                              		lv_defaultClause_6_0, 
                              		"SwitchDefaultClause");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,29,FOLLOW_29_in_ruleSwitchStatement10648); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getSwitchStatementAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchStatement"


    // $ANTLR start "entryRuleSwitchClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4766:1: entryRuleSwitchClause returns [EObject current=null] : iv_ruleSwitchClause= ruleSwitchClause EOF ;
    public final EObject entryRuleSwitchClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchClause = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4767:2: (iv_ruleSwitchClause= ruleSwitchClause EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4768:2: iv_ruleSwitchClause= ruleSwitchClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchClauseRule()); 
            }
            pushFollow(FOLLOW_ruleSwitchClause_in_entryRuleSwitchClause10684);
            iv_ruleSwitchClause=ruleSwitchClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchClause10694); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchClause"


    // $ANTLR start "ruleSwitchClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4775:1: ruleSwitchClause returns [EObject current=null] : ( ( (lv_case_0_0= ruleSwitchCase ) ) ( (lv_case_1_0= ruleSwitchCase ) )* ( (lv_block_2_0= ruleNonEmptyStatementSequence ) ) ) ;
    public final EObject ruleSwitchClause() throws RecognitionException {
        EObject current = null;

        EObject lv_case_0_0 = null;

        EObject lv_case_1_0 = null;

        EObject lv_block_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4778:28: ( ( ( (lv_case_0_0= ruleSwitchCase ) ) ( (lv_case_1_0= ruleSwitchCase ) )* ( (lv_block_2_0= ruleNonEmptyStatementSequence ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4779:1: ( ( (lv_case_0_0= ruleSwitchCase ) ) ( (lv_case_1_0= ruleSwitchCase ) )* ( (lv_block_2_0= ruleNonEmptyStatementSequence ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4779:1: ( ( (lv_case_0_0= ruleSwitchCase ) ) ( (lv_case_1_0= ruleSwitchCase ) )* ( (lv_block_2_0= ruleNonEmptyStatementSequence ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4779:2: ( (lv_case_0_0= ruleSwitchCase ) ) ( (lv_case_1_0= ruleSwitchCase ) )* ( (lv_block_2_0= ruleNonEmptyStatementSequence ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4779:2: ( (lv_case_0_0= ruleSwitchCase ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4780:1: (lv_case_0_0= ruleSwitchCase )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4780:1: (lv_case_0_0= ruleSwitchCase )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4781:3: lv_case_0_0= ruleSwitchCase
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchClauseAccess().getCaseSwitchCaseParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSwitchCase_in_ruleSwitchClause10740);
            lv_case_0_0=ruleSwitchCase();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSwitchClauseRule());
              	        }
                     		add(
                     			current, 
                     			"case",
                      		lv_case_0_0, 
                      		"SwitchCase");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4797:2: ( (lv_case_1_0= ruleSwitchCase ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==52) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4798:1: (lv_case_1_0= ruleSwitchCase )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4798:1: (lv_case_1_0= ruleSwitchCase )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4799:3: lv_case_1_0= ruleSwitchCase
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSwitchClauseAccess().getCaseSwitchCaseParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleSwitchCase_in_ruleSwitchClause10761);
            	    lv_case_1_0=ruleSwitchCase();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSwitchClauseRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"case",
            	              		lv_case_1_0, 
            	              		"SwitchCase");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4815:3: ( (lv_block_2_0= ruleNonEmptyStatementSequence ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4816:1: (lv_block_2_0= ruleNonEmptyStatementSequence )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4816:1: (lv_block_2_0= ruleNonEmptyStatementSequence )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4817:3: lv_block_2_0= ruleNonEmptyStatementSequence
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitchClauseAccess().getBlockNonEmptyStatementSequenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleNonEmptyStatementSequence_in_ruleSwitchClause10783);
            lv_block_2_0=ruleNonEmptyStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSwitchClauseRule());
              	        }
                     		set(
                     			current, 
                     			"block",
                      		lv_block_2_0, 
                      		"NonEmptyStatementSequence");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchClause"


    // $ANTLR start "entryRuleSwitchCase"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4841:1: entryRuleSwitchCase returns [EObject current=null] : iv_ruleSwitchCase= ruleSwitchCase EOF ;
    public final EObject entryRuleSwitchCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchCase = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4842:2: (iv_ruleSwitchCase= ruleSwitchCase EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4843:2: iv_ruleSwitchCase= ruleSwitchCase EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchCaseRule()); 
            }
            pushFollow(FOLLOW_ruleSwitchCase_in_entryRuleSwitchCase10819);
            iv_ruleSwitchCase=ruleSwitchCase();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchCase; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchCase10829); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchCase"


    // $ANTLR start "ruleSwitchCase"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4850:1: ruleSwitchCase returns [EObject current=null] : (otherlv_0= 'case' this_Expression_1= ruleExpression otherlv_2= ':' ) ;
    public final EObject ruleSwitchCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4853:28: ( (otherlv_0= 'case' this_Expression_1= ruleExpression otherlv_2= ':' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4854:1: (otherlv_0= 'case' this_Expression_1= ruleExpression otherlv_2= ':' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4854:1: (otherlv_0= 'case' this_Expression_1= ruleExpression otherlv_2= ':' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4854:3: otherlv_0= 'case' this_Expression_1= ruleExpression otherlv_2= ':'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleSwitchCase10866); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSwitchCaseAccess().getCaseKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSwitchCaseAccess().getExpressionParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSwitchCase10891);
            this_Expression_1=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_Expression_1; 
                      afterParserOrEnumRuleCall();
                  
            }
            otherlv_2=(Token)match(input,45,FOLLOW_45_in_ruleSwitchCase10902); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSwitchCaseAccess().getColonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchCase"


    // $ANTLR start "entryRuleSwitchDefaultClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4882:1: entryRuleSwitchDefaultClause returns [EObject current=null] : iv_ruleSwitchDefaultClause= ruleSwitchDefaultClause EOF ;
    public final EObject entryRuleSwitchDefaultClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchDefaultClause = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4883:2: (iv_ruleSwitchDefaultClause= ruleSwitchDefaultClause EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4884:2: iv_ruleSwitchDefaultClause= ruleSwitchDefaultClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchDefaultClauseRule()); 
            }
            pushFollow(FOLLOW_ruleSwitchDefaultClause_in_entryRuleSwitchDefaultClause10938);
            iv_ruleSwitchDefaultClause=ruleSwitchDefaultClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchDefaultClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSwitchDefaultClause10948); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchDefaultClause"


    // $ANTLR start "ruleSwitchDefaultClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4891:1: ruleSwitchDefaultClause returns [EObject current=null] : (otherlv_0= 'default' otherlv_1= ':' this_NonEmptyStatementSequence_2= ruleNonEmptyStatementSequence ) ;
    public final EObject ruleSwitchDefaultClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject this_NonEmptyStatementSequence_2 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4894:28: ( (otherlv_0= 'default' otherlv_1= ':' this_NonEmptyStatementSequence_2= ruleNonEmptyStatementSequence ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4895:1: (otherlv_0= 'default' otherlv_1= ':' this_NonEmptyStatementSequence_2= ruleNonEmptyStatementSequence )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4895:1: (otherlv_0= 'default' otherlv_1= ':' this_NonEmptyStatementSequence_2= ruleNonEmptyStatementSequence )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4895:3: otherlv_0= 'default' otherlv_1= ':' this_NonEmptyStatementSequence_2= ruleNonEmptyStatementSequence
            {
            otherlv_0=(Token)match(input,53,FOLLOW_53_in_ruleSwitchDefaultClause10985); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSwitchDefaultClauseAccess().getDefaultKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleSwitchDefaultClause10997); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSwitchDefaultClauseAccess().getColonKeyword_1());
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getSwitchDefaultClauseAccess().getNonEmptyStatementSequenceParserRuleCall_2()); 
                  
            }
            pushFollow(FOLLOW_ruleNonEmptyStatementSequence_in_ruleSwitchDefaultClause11022);
            this_NonEmptyStatementSequence_2=ruleNonEmptyStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_NonEmptyStatementSequence_2; 
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchDefaultClause"


    // $ANTLR start "entryRuleNonEmptyStatementSequence"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4923:1: entryRuleNonEmptyStatementSequence returns [EObject current=null] : iv_ruleNonEmptyStatementSequence= ruleNonEmptyStatementSequence EOF ;
    public final EObject entryRuleNonEmptyStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNonEmptyStatementSequence = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4924:2: (iv_ruleNonEmptyStatementSequence= ruleNonEmptyStatementSequence EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4925:2: iv_ruleNonEmptyStatementSequence= ruleNonEmptyStatementSequence EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNonEmptyStatementSequenceRule()); 
            }
            pushFollow(FOLLOW_ruleNonEmptyStatementSequence_in_entryRuleNonEmptyStatementSequence11057);
            iv_ruleNonEmptyStatementSequence=ruleNonEmptyStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNonEmptyStatementSequence; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNonEmptyStatementSequence11067); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNonEmptyStatementSequence"


    // $ANTLR start "ruleNonEmptyStatementSequence"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4932:1: ruleNonEmptyStatementSequence returns [EObject current=null] : ( (lv_statement_0_0= ruleStatement ) )+ ;
    public final EObject ruleNonEmptyStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject lv_statement_0_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4935:28: ( ( (lv_statement_0_0= ruleStatement ) )+ )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4936:1: ( (lv_statement_0_0= ruleStatement ) )+
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4936:1: ( (lv_statement_0_0= ruleStatement ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( ((LA51_0>=RULE_ID && LA51_0<=RULE_STRING)||(LA51_0>=16 && LA51_0<=18)||(LA51_0>=22 && LA51_0<=23)||LA51_0==25||LA51_0==28||(LA51_0>=32 && LA51_0<=34)||(LA51_0>=37 && LA51_0<=38)||LA51_0==46||LA51_0==48||LA51_0==51||(LA51_0>=54 && LA51_0<=59)||LA51_0==62||(LA51_0>=65 && LA51_0<=69)) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4937:1: (lv_statement_0_0= ruleStatement )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4937:1: (lv_statement_0_0= ruleStatement )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4938:3: lv_statement_0_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNonEmptyStatementSequenceAccess().getStatementStatementParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleStatement_in_ruleNonEmptyStatementSequence11112);
            	    lv_statement_0_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNonEmptyStatementSequenceRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"statement",
            	              		lv_statement_0_0, 
            	              		"Statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNonEmptyStatementSequence"


    // $ANTLR start "entryRuleWhileStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4962:1: entryRuleWhileStatement returns [EObject current=null] : iv_ruleWhileStatement= ruleWhileStatement EOF ;
    public final EObject entryRuleWhileStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhileStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4963:2: (iv_ruleWhileStatement= ruleWhileStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4964:2: iv_ruleWhileStatement= ruleWhileStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhileStatementRule()); 
            }
            pushFollow(FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement11148);
            iv_ruleWhileStatement=ruleWhileStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhileStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhileStatement11158); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhileStatement"


    // $ANTLR start "ruleWhileStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4971:1: ruleWhileStatement returns [EObject current=null] : (otherlv_0= 'while' otherlv_1= '(' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleBlock ) ) ) ;
    public final EObject ruleWhileStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_body_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4974:28: ( (otherlv_0= 'while' otherlv_1= '(' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleBlock ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4975:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleBlock ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4975:1: (otherlv_0= 'while' otherlv_1= '(' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleBlock ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4975:3: otherlv_0= 'while' otherlv_1= '(' ( (lv_condition_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_body_4_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleWhileStatement11195); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getWhileStatementAccess().getWhileKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleWhileStatement11207); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWhileStatementAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4983:1: ( (lv_condition_2_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4984:1: (lv_condition_2_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4984:1: (lv_condition_2_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:4985:3: lv_condition_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWhileStatementAccess().getConditionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleWhileStatement11228);
            lv_condition_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getWhileStatementRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleWhileStatement11240); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getWhileStatementAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5005:1: ( (lv_body_4_0= ruleBlock ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5006:1: (lv_body_4_0= ruleBlock )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5006:1: (lv_body_4_0= ruleBlock )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5007:3: lv_body_4_0= ruleBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWhileStatementAccess().getBodyBlockParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBlock_in_ruleWhileStatement11261);
            lv_body_4_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getWhileStatementRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_4_0, 
                      		"Block");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhileStatement"


    // $ANTLR start "entryRuleDoStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5031:1: entryRuleDoStatement returns [EObject current=null] : iv_ruleDoStatement= ruleDoStatement EOF ;
    public final EObject entryRuleDoStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5032:2: (iv_ruleDoStatement= ruleDoStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5033:2: iv_ruleDoStatement= ruleDoStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDoStatementRule()); 
            }
            pushFollow(FOLLOW_ruleDoStatement_in_entryRuleDoStatement11297);
            iv_ruleDoStatement=ruleDoStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDoStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDoStatement11307); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDoStatement"


    // $ANTLR start "ruleDoStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5040:1: ruleDoStatement returns [EObject current=null] : (otherlv_0= 'do' ( (lv_body_1_0= ruleBlock ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' ) ;
    public final EObject ruleDoStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_body_1_0 = null;

        EObject lv_condition_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5043:28: ( (otherlv_0= 'do' ( (lv_body_1_0= ruleBlock ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5044:1: (otherlv_0= 'do' ( (lv_body_1_0= ruleBlock ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5044:1: (otherlv_0= 'do' ( (lv_body_1_0= ruleBlock ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5044:3: otherlv_0= 'do' ( (lv_body_1_0= ruleBlock ) ) otherlv_2= 'while' otherlv_3= '(' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ')' otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleDoStatement11344); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDoStatementAccess().getDoKeyword_0());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5048:1: ( (lv_body_1_0= ruleBlock ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5049:1: (lv_body_1_0= ruleBlock )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5049:1: (lv_body_1_0= ruleBlock )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5050:3: lv_body_1_0= ruleBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDoStatementAccess().getBodyBlockParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBlock_in_ruleDoStatement11365);
            lv_body_1_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDoStatementRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_1_0, 
                      		"Block");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,54,FOLLOW_54_in_ruleDoStatement11377); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getDoStatementAccess().getWhileKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleDoStatement11389); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDoStatementAccess().getLeftParenthesisKeyword_3());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5074:1: ( (lv_condition_4_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5075:1: (lv_condition_4_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5075:1: (lv_condition_4_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5076:3: lv_condition_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDoStatementAccess().getConditionExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleDoStatement11410);
            lv_condition_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDoStatementRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_4_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleDoStatement11422); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getDoStatementAccess().getRightParenthesisKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,46,FOLLOW_46_in_ruleDoStatement11434); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getDoStatementAccess().getSemicolonKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoStatement"


    // $ANTLR start "entryRuleForStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5108:1: entryRuleForStatement returns [EObject current=null] : iv_ruleForStatement= ruleForStatement EOF ;
    public final EObject entryRuleForStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5109:2: (iv_ruleForStatement= ruleForStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5110:2: iv_ruleForStatement= ruleForStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForStatementRule()); 
            }
            pushFollow(FOLLOW_ruleForStatement_in_entryRuleForStatement11470);
            iv_ruleForStatement=ruleForStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleForStatement11480); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForStatement"


    // $ANTLR start "ruleForStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5117:1: ruleForStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_initialization_2_0= ruleSimpleStatement ) ) otherlv_3= ';' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ';' ( (lv_update_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleBlock ) ) ) ;
    public final EObject ruleForStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_initialization_2_0 = null;

        EObject lv_condition_4_0 = null;

        EObject lv_update_6_0 = null;

        EObject lv_body_8_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5120:28: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_initialization_2_0= ruleSimpleStatement ) ) otherlv_3= ';' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ';' ( (lv_update_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleBlock ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5121:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_initialization_2_0= ruleSimpleStatement ) ) otherlv_3= ';' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ';' ( (lv_update_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleBlock ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5121:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_initialization_2_0= ruleSimpleStatement ) ) otherlv_3= ';' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ';' ( (lv_update_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleBlock ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5121:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_initialization_2_0= ruleSimpleStatement ) ) otherlv_3= ';' ( (lv_condition_4_0= ruleExpression ) ) otherlv_5= ';' ( (lv_update_6_0= ruleSimpleStatement ) ) otherlv_7= ')' ( (lv_body_8_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleForStatement11517); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getForStatementAccess().getForKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleForStatement11529); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getForStatementAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5129:1: ( (lv_initialization_2_0= ruleSimpleStatement ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5130:1: (lv_initialization_2_0= ruleSimpleStatement )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5130:1: (lv_initialization_2_0= ruleSimpleStatement )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5131:3: lv_initialization_2_0= ruleSimpleStatement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getForStatementAccess().getInitializationSimpleStatementParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSimpleStatement_in_ruleForStatement11550);
            lv_initialization_2_0=ruleSimpleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getForStatementRule());
              	        }
                     		set(
                     			current, 
                     			"initialization",
                      		lv_initialization_2_0, 
                      		"SimpleStatement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,46,FOLLOW_46_in_ruleForStatement11562); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getForStatementAccess().getSemicolonKeyword_3());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5151:1: ( (lv_condition_4_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5152:1: (lv_condition_4_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5152:1: (lv_condition_4_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5153:3: lv_condition_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getForStatementAccess().getConditionExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleForStatement11583);
            lv_condition_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getForStatementRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_4_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,46,FOLLOW_46_in_ruleForStatement11595); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getForStatementAccess().getSemicolonKeyword_5());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5173:1: ( (lv_update_6_0= ruleSimpleStatement ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5174:1: (lv_update_6_0= ruleSimpleStatement )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5174:1: (lv_update_6_0= ruleSimpleStatement )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5175:3: lv_update_6_0= ruleSimpleStatement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getForStatementAccess().getUpdateSimpleStatementParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSimpleStatement_in_ruleForStatement11616);
            lv_update_6_0=ruleSimpleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getForStatementRule());
              	        }
                     		set(
                     			current, 
                     			"update",
                      		lv_update_6_0, 
                      		"SimpleStatement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleForStatement11628); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getForStatementAccess().getRightParenthesisKeyword_7());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5195:1: ( (lv_body_8_0= ruleBlock ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5196:1: (lv_body_8_0= ruleBlock )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5196:1: (lv_body_8_0= ruleBlock )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5197:3: lv_body_8_0= ruleBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getForStatementAccess().getBodyBlockParserRuleCall_8_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBlock_in_ruleForStatement11649);
            lv_body_8_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getForStatementRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_8_0, 
                      		"Block");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForStatement"


    // $ANTLR start "entryRuleForEachStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5221:1: entryRuleForEachStatement returns [EObject current=null] : iv_ruleForEachStatement= ruleForEachStatement EOF ;
    public final EObject entryRuleForEachStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForEachStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5222:2: (iv_ruleForEachStatement= ruleForEachStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5223:2: iv_ruleForEachStatement= ruleForEachStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForEachStatementRule()); 
            }
            pushFollow(FOLLOW_ruleForEachStatement_in_entryRuleForEachStatement11685);
            iv_ruleForEachStatement=ruleForEachStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForEachStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleForEachStatement11695); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForEachStatement"


    // $ANTLR start "ruleForEachStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5230:1: ruleForEachStatement returns [EObject current=null] : (otherlv_0= 'for' otherlv_1= '(' ( (lv_variableDefinition_2_0= ruleLoopVariableDefinition ) ) otherlv_3= ')' ( (lv_body_4_0= ruleBlock ) ) ) ;
    public final EObject ruleForEachStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_variableDefinition_2_0 = null;

        EObject lv_body_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5233:28: ( (otherlv_0= 'for' otherlv_1= '(' ( (lv_variableDefinition_2_0= ruleLoopVariableDefinition ) ) otherlv_3= ')' ( (lv_body_4_0= ruleBlock ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5234:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_variableDefinition_2_0= ruleLoopVariableDefinition ) ) otherlv_3= ')' ( (lv_body_4_0= ruleBlock ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5234:1: (otherlv_0= 'for' otherlv_1= '(' ( (lv_variableDefinition_2_0= ruleLoopVariableDefinition ) ) otherlv_3= ')' ( (lv_body_4_0= ruleBlock ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5234:3: otherlv_0= 'for' otherlv_1= '(' ( (lv_variableDefinition_2_0= ruleLoopVariableDefinition ) ) otherlv_3= ')' ( (lv_body_4_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleForEachStatement11732); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getForEachStatementAccess().getForKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleForEachStatement11744); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getForEachStatementAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5242:1: ( (lv_variableDefinition_2_0= ruleLoopVariableDefinition ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5243:1: (lv_variableDefinition_2_0= ruleLoopVariableDefinition )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5243:1: (lv_variableDefinition_2_0= ruleLoopVariableDefinition )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5244:3: lv_variableDefinition_2_0= ruleLoopVariableDefinition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getForEachStatementAccess().getVariableDefinitionLoopVariableDefinitionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLoopVariableDefinition_in_ruleForEachStatement11765);
            lv_variableDefinition_2_0=ruleLoopVariableDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getForEachStatementRule());
              	        }
                     		set(
                     			current, 
                     			"variableDefinition",
                      		lv_variableDefinition_2_0, 
                      		"LoopVariableDefinition");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleForEachStatement11777); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getForEachStatementAccess().getRightParenthesisKeyword_3());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5264:1: ( (lv_body_4_0= ruleBlock ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5265:1: (lv_body_4_0= ruleBlock )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5265:1: (lv_body_4_0= ruleBlock )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5266:3: lv_body_4_0= ruleBlock
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getForEachStatementAccess().getBodyBlockParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleBlock_in_ruleForEachStatement11798);
            lv_body_4_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getForEachStatementRule());
              	        }
                     		set(
                     			current, 
                     			"body",
                      		lv_body_4_0, 
                      		"Block");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForEachStatement"


    // $ANTLR start "entryRuleLoopVariableDefinition"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5290:1: entryRuleLoopVariableDefinition returns [EObject current=null] : iv_ruleLoopVariableDefinition= ruleLoopVariableDefinition EOF ;
    public final EObject entryRuleLoopVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopVariableDefinition = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5291:2: (iv_ruleLoopVariableDefinition= ruleLoopVariableDefinition EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5292:2: iv_ruleLoopVariableDefinition= ruleLoopVariableDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopVariableDefinitionRule()); 
            }
            pushFollow(FOLLOW_ruleLoopVariableDefinition_in_entryRuleLoopVariableDefinition11834);
            iv_ruleLoopVariableDefinition=ruleLoopVariableDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoopVariableDefinition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLoopVariableDefinition11844); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoopVariableDefinition"


    // $ANTLR start "ruleLoopVariableDefinition"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5299:1: ruleLoopVariableDefinition returns [EObject current=null] : ( () ( ( (lv_name_1_0= ruleName ) ) | ( ( (lv_type_2_0= ruleTypeDeclaration ) ) ( (lv_name_3_0= ruleName ) ) ) ) otherlv_4= ':' ( (lv_expression_5_0= ruleExpression ) ) ) ;
    public final EObject ruleLoopVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_type_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5302:28: ( ( () ( ( (lv_name_1_0= ruleName ) ) | ( ( (lv_type_2_0= ruleTypeDeclaration ) ) ( (lv_name_3_0= ruleName ) ) ) ) otherlv_4= ':' ( (lv_expression_5_0= ruleExpression ) ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5303:1: ( () ( ( (lv_name_1_0= ruleName ) ) | ( ( (lv_type_2_0= ruleTypeDeclaration ) ) ( (lv_name_3_0= ruleName ) ) ) ) otherlv_4= ':' ( (lv_expression_5_0= ruleExpression ) ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5303:1: ( () ( ( (lv_name_1_0= ruleName ) ) | ( ( (lv_type_2_0= ruleTypeDeclaration ) ) ( (lv_name_3_0= ruleName ) ) ) ) otherlv_4= ':' ( (lv_expression_5_0= ruleExpression ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5303:2: () ( ( (lv_name_1_0= ruleName ) ) | ( ( (lv_type_2_0= ruleTypeDeclaration ) ) ( (lv_name_3_0= ruleName ) ) ) ) otherlv_4= ':' ( (lv_expression_5_0= ruleExpression ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5303:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5304:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getLoopVariableDefinitionAccess().getLoopVariableAction_0(),
                          current);
                  
            }

            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5312:2: ( ( (lv_name_1_0= ruleName ) ) | ( ( (lv_type_2_0= ruleTypeDeclaration ) ) ( (lv_name_3_0= ruleName ) ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                int LA52_1 = input.LA(2);

                if ( ((LA52_1>=RULE_ID && LA52_1<=RULE_UNRESTRICTED_NAME)||LA52_1==13) ) {
                    alt52=2;
                }
                else if ( (LA52_1==45) ) {
                    alt52=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA52_0==RULE_UNRESTRICTED_NAME) ) {
                int LA52_2 = input.LA(2);

                if ( (LA52_2==45) ) {
                    alt52=1;
                }
                else if ( ((LA52_2>=RULE_ID && LA52_2<=RULE_UNRESTRICTED_NAME)||LA52_2==13) ) {
                    alt52=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5312:3: ( (lv_name_1_0= ruleName ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5312:3: ( (lv_name_1_0= ruleName ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5313:1: (lv_name_1_0= ruleName )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5313:1: (lv_name_1_0= ruleName )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5314:3: lv_name_1_0= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLoopVariableDefinitionAccess().getNameNameParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleName_in_ruleLoopVariableDefinition11903);
                    lv_name_1_0=ruleName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLoopVariableDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"Name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5331:6: ( ( (lv_type_2_0= ruleTypeDeclaration ) ) ( (lv_name_3_0= ruleName ) ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5331:6: ( ( (lv_type_2_0= ruleTypeDeclaration ) ) ( (lv_name_3_0= ruleName ) ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5331:7: ( (lv_type_2_0= ruleTypeDeclaration ) ) ( (lv_name_3_0= ruleName ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5331:7: ( (lv_type_2_0= ruleTypeDeclaration ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5332:1: (lv_type_2_0= ruleTypeDeclaration )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5332:1: (lv_type_2_0= ruleTypeDeclaration )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5333:3: lv_type_2_0= ruleTypeDeclaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLoopVariableDefinitionAccess().getTypeTypeDeclarationParserRuleCall_1_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTypeDeclaration_in_ruleLoopVariableDefinition11931);
                    lv_type_2_0=ruleTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLoopVariableDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"type",
                              		lv_type_2_0, 
                              		"TypeDeclaration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5349:2: ( (lv_name_3_0= ruleName ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5350:1: (lv_name_3_0= ruleName )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5350:1: (lv_name_3_0= ruleName )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5351:3: lv_name_3_0= ruleName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLoopVariableDefinitionAccess().getNameNameParserRuleCall_1_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleName_in_ruleLoopVariableDefinition11952);
                    lv_name_3_0=ruleName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLoopVariableDefinitionRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_3_0, 
                              		"Name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,45,FOLLOW_45_in_ruleLoopVariableDefinition11966); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLoopVariableDefinitionAccess().getColonKeyword_2());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5371:1: ( (lv_expression_5_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5372:1: (lv_expression_5_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5372:1: (lv_expression_5_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5373:3: lv_expression_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLoopVariableDefinitionAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleLoopVariableDefinition11987);
            lv_expression_5_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLoopVariableDefinitionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_5_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoopVariableDefinition"


    // $ANTLR start "entryRuleBreakStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5397:1: entryRuleBreakStatement returns [EObject current=null] : iv_ruleBreakStatement= ruleBreakStatement EOF ;
    public final EObject entryRuleBreakStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBreakStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5398:2: (iv_ruleBreakStatement= ruleBreakStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5399:2: iv_ruleBreakStatement= ruleBreakStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBreakStatementRule()); 
            }
            pushFollow(FOLLOW_ruleBreakStatement_in_entryRuleBreakStatement12023);
            iv_ruleBreakStatement=ruleBreakStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBreakStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBreakStatement12033); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBreakStatement"


    // $ANTLR start "ruleBreakStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5406:1: ruleBreakStatement returns [EObject current=null] : ( () otherlv_1= 'break' otherlv_2= ';' ) ;
    public final EObject ruleBreakStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5409:28: ( ( () otherlv_1= 'break' otherlv_2= ';' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5410:1: ( () otherlv_1= 'break' otherlv_2= ';' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5410:1: ( () otherlv_1= 'break' otherlv_2= ';' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5410:2: () otherlv_1= 'break' otherlv_2= ';'
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5410:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5411:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getBreakStatementAccess().getBreakStatementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,57,FOLLOW_57_in_ruleBreakStatement12082); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getBreakStatementAccess().getBreakKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,46,FOLLOW_46_in_ruleBreakStatement12094); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getBreakStatementAccess().getSemicolonKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBreakStatement"


    // $ANTLR start "entryRuleReturnStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5435:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5436:2: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5437:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReturnStatementRule()); 
            }
            pushFollow(FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement12130);
            iv_ruleReturnStatement=ruleReturnStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReturnStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReturnStatement12140); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReturnStatement"


    // $ANTLR start "ruleReturnStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5444:1: ruleReturnStatement returns [EObject current=null] : ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? otherlv_3= ';' ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5447:28: ( ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? otherlv_3= ';' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5448:1: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? otherlv_3= ';' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5448:1: ( () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? otherlv_3= ';' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5448:2: () otherlv_1= 'return' ( (lv_expression_2_0= ruleExpression ) )? otherlv_3= ';'
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5448:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5449:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReturnStatementAccess().getReturnStatementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleReturnStatement12189); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getReturnStatementAccess().getReturnKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5461:1: ( (lv_expression_2_0= ruleExpression ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=RULE_ID && LA53_0<=RULE_STRING)||(LA53_0>=16 && LA53_0<=18)||(LA53_0>=22 && LA53_0<=23)||LA53_0==25||LA53_0==28||(LA53_0>=32 && LA53_0<=34)||(LA53_0>=37 && LA53_0<=38)||(LA53_0>=65 && LA53_0<=69)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5462:1: (lv_expression_2_0= ruleExpression )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5462:1: (lv_expression_2_0= ruleExpression )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5463:3: lv_expression_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleReturnStatement12210);
                    lv_expression_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getReturnStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_2_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,46,FOLLOW_46_in_ruleReturnStatement12223); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getReturnStatementAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReturnStatement"


    // $ANTLR start "entryRuleClassifyStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5491:1: entryRuleClassifyStatement returns [EObject current=null] : iv_ruleClassifyStatement= ruleClassifyStatement EOF ;
    public final EObject entryRuleClassifyStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifyStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5492:2: (iv_ruleClassifyStatement= ruleClassifyStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5493:2: iv_ruleClassifyStatement= ruleClassifyStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassifyStatementRule()); 
            }
            pushFollow(FOLLOW_ruleClassifyStatement_in_entryRuleClassifyStatement12259);
            iv_ruleClassifyStatement=ruleClassifyStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassifyStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassifyStatement12269); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassifyStatement"


    // $ANTLR start "ruleClassifyStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5500:1: ruleClassifyStatement returns [EObject current=null] : (otherlv_0= 'classify' ( (lv_expression_1_0= ruleExpression ) ) ( ( ( (lv_fromList_2_0= ruleClassificationFromClause ) ) ( (lv_toList_3_0= ruleClassificationToClause ) )? ) | ( ( (lv_isReclassifyAll_4_0= ruleReclassifyAllClause ) )? ( (lv_toList_5_0= ruleClassificationToClause ) ) ) ) otherlv_6= ';' ) ;
    public final EObject ruleClassifyStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_6=null;
        EObject lv_expression_1_0 = null;

        EObject lv_fromList_2_0 = null;

        EObject lv_toList_3_0 = null;

        AntlrDatatypeRuleToken lv_isReclassifyAll_4_0 = null;

        EObject lv_toList_5_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5503:28: ( (otherlv_0= 'classify' ( (lv_expression_1_0= ruleExpression ) ) ( ( ( (lv_fromList_2_0= ruleClassificationFromClause ) ) ( (lv_toList_3_0= ruleClassificationToClause ) )? ) | ( ( (lv_isReclassifyAll_4_0= ruleReclassifyAllClause ) )? ( (lv_toList_5_0= ruleClassificationToClause ) ) ) ) otherlv_6= ';' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5504:1: (otherlv_0= 'classify' ( (lv_expression_1_0= ruleExpression ) ) ( ( ( (lv_fromList_2_0= ruleClassificationFromClause ) ) ( (lv_toList_3_0= ruleClassificationToClause ) )? ) | ( ( (lv_isReclassifyAll_4_0= ruleReclassifyAllClause ) )? ( (lv_toList_5_0= ruleClassificationToClause ) ) ) ) otherlv_6= ';' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5504:1: (otherlv_0= 'classify' ( (lv_expression_1_0= ruleExpression ) ) ( ( ( (lv_fromList_2_0= ruleClassificationFromClause ) ) ( (lv_toList_3_0= ruleClassificationToClause ) )? ) | ( ( (lv_isReclassifyAll_4_0= ruleReclassifyAllClause ) )? ( (lv_toList_5_0= ruleClassificationToClause ) ) ) ) otherlv_6= ';' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5504:3: otherlv_0= 'classify' ( (lv_expression_1_0= ruleExpression ) ) ( ( ( (lv_fromList_2_0= ruleClassificationFromClause ) ) ( (lv_toList_3_0= ruleClassificationToClause ) )? ) | ( ( (lv_isReclassifyAll_4_0= ruleReclassifyAllClause ) )? ( (lv_toList_5_0= ruleClassificationToClause ) ) ) ) otherlv_6= ';'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleClassifyStatement12306); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClassifyStatementAccess().getClassifyKeyword_0());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5508:1: ( (lv_expression_1_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5509:1: (lv_expression_1_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5509:1: (lv_expression_1_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5510:3: lv_expression_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getClassifyStatementAccess().getExpressionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleClassifyStatement12327);
            lv_expression_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getClassifyStatementRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_1_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5526:2: ( ( ( (lv_fromList_2_0= ruleClassificationFromClause ) ) ( (lv_toList_3_0= ruleClassificationToClause ) )? ) | ( ( (lv_isReclassifyAll_4_0= ruleReclassifyAllClause ) )? ( (lv_toList_5_0= ruleClassificationToClause ) ) ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==60) ) {
                int LA56_1 = input.LA(2);

                if ( ((LA56_1>=RULE_ID && LA56_1<=RULE_UNRESTRICTED_NAME)) ) {
                    alt56=1;
                }
                else if ( (LA56_1==16) ) {
                    alt56=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA56_0==61) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5526:3: ( ( (lv_fromList_2_0= ruleClassificationFromClause ) ) ( (lv_toList_3_0= ruleClassificationToClause ) )? )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5526:3: ( ( (lv_fromList_2_0= ruleClassificationFromClause ) ) ( (lv_toList_3_0= ruleClassificationToClause ) )? )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5526:4: ( (lv_fromList_2_0= ruleClassificationFromClause ) ) ( (lv_toList_3_0= ruleClassificationToClause ) )?
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5526:4: ( (lv_fromList_2_0= ruleClassificationFromClause ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5527:1: (lv_fromList_2_0= ruleClassificationFromClause )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5527:1: (lv_fromList_2_0= ruleClassificationFromClause )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5528:3: lv_fromList_2_0= ruleClassificationFromClause
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassifyStatementAccess().getFromListClassificationFromClauseParserRuleCall_2_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleClassificationFromClause_in_ruleClassifyStatement12350);
                    lv_fromList_2_0=ruleClassificationFromClause();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClassifyStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"fromList",
                              		lv_fromList_2_0, 
                              		"ClassificationFromClause");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5544:2: ( (lv_toList_3_0= ruleClassificationToClause ) )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==61) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5545:1: (lv_toList_3_0= ruleClassificationToClause )
                            {
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5545:1: (lv_toList_3_0= ruleClassificationToClause )
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5546:3: lv_toList_3_0= ruleClassificationToClause
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getClassifyStatementAccess().getToListClassificationToClauseParserRuleCall_2_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleClassificationToClause_in_ruleClassifyStatement12371);
                            lv_toList_3_0=ruleClassificationToClause();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getClassifyStatementRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"toList",
                                      		lv_toList_3_0, 
                                      		"ClassificationToClause");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5563:6: ( ( (lv_isReclassifyAll_4_0= ruleReclassifyAllClause ) )? ( (lv_toList_5_0= ruleClassificationToClause ) ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5563:6: ( ( (lv_isReclassifyAll_4_0= ruleReclassifyAllClause ) )? ( (lv_toList_5_0= ruleClassificationToClause ) ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5563:7: ( (lv_isReclassifyAll_4_0= ruleReclassifyAllClause ) )? ( (lv_toList_5_0= ruleClassificationToClause ) )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5563:7: ( (lv_isReclassifyAll_4_0= ruleReclassifyAllClause ) )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==60) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5564:1: (lv_isReclassifyAll_4_0= ruleReclassifyAllClause )
                            {
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5564:1: (lv_isReclassifyAll_4_0= ruleReclassifyAllClause )
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5565:3: lv_isReclassifyAll_4_0= ruleReclassifyAllClause
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getClassifyStatementAccess().getIsReclassifyAllReclassifyAllClauseParserRuleCall_2_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleReclassifyAllClause_in_ruleClassifyStatement12401);
                            lv_isReclassifyAll_4_0=ruleReclassifyAllClause();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getClassifyStatementRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"isReclassifyAll",
                                      		true, 
                                      		"ReclassifyAllClause");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5581:3: ( (lv_toList_5_0= ruleClassificationToClause ) )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5582:1: (lv_toList_5_0= ruleClassificationToClause )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5582:1: (lv_toList_5_0= ruleClassificationToClause )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5583:3: lv_toList_5_0= ruleClassificationToClause
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClassifyStatementAccess().getToListClassificationToClauseParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleClassificationToClause_in_ruleClassifyStatement12423);
                    lv_toList_5_0=ruleClassificationToClause();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClassifyStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"toList",
                              		lv_toList_5_0, 
                              		"ClassificationToClause");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,46,FOLLOW_46_in_ruleClassifyStatement12437); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getClassifyStatementAccess().getSemicolonKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassifyStatement"


    // $ANTLR start "entryRuleClassificationFromClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5611:1: entryRuleClassificationFromClause returns [EObject current=null] : iv_ruleClassificationFromClause= ruleClassificationFromClause EOF ;
    public final EObject entryRuleClassificationFromClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassificationFromClause = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5612:2: (iv_ruleClassificationFromClause= ruleClassificationFromClause EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5613:2: iv_ruleClassificationFromClause= ruleClassificationFromClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassificationFromClauseRule()); 
            }
            pushFollow(FOLLOW_ruleClassificationFromClause_in_entryRuleClassificationFromClause12473);
            iv_ruleClassificationFromClause=ruleClassificationFromClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassificationFromClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassificationFromClause12483); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassificationFromClause"


    // $ANTLR start "ruleClassificationFromClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5620:1: ruleClassificationFromClause returns [EObject current=null] : (otherlv_0= 'from' this_QualifiedNameList_1= ruleQualifiedNameList ) ;
    public final EObject ruleClassificationFromClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_QualifiedNameList_1 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5623:28: ( (otherlv_0= 'from' this_QualifiedNameList_1= ruleQualifiedNameList ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5624:1: (otherlv_0= 'from' this_QualifiedNameList_1= ruleQualifiedNameList )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5624:1: (otherlv_0= 'from' this_QualifiedNameList_1= ruleQualifiedNameList )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5624:3: otherlv_0= 'from' this_QualifiedNameList_1= ruleQualifiedNameList
            {
            otherlv_0=(Token)match(input,60,FOLLOW_60_in_ruleClassificationFromClause12520); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClassificationFromClauseAccess().getFromKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getClassificationFromClauseAccess().getQualifiedNameListParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedNameList_in_ruleClassificationFromClause12545);
            this_QualifiedNameList_1=ruleQualifiedNameList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_QualifiedNameList_1; 
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassificationFromClause"


    // $ANTLR start "entryRuleClassificationToClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5648:1: entryRuleClassificationToClause returns [EObject current=null] : iv_ruleClassificationToClause= ruleClassificationToClause EOF ;
    public final EObject entryRuleClassificationToClause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassificationToClause = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5649:2: (iv_ruleClassificationToClause= ruleClassificationToClause EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5650:2: iv_ruleClassificationToClause= ruleClassificationToClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassificationToClauseRule()); 
            }
            pushFollow(FOLLOW_ruleClassificationToClause_in_entryRuleClassificationToClause12580);
            iv_ruleClassificationToClause=ruleClassificationToClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClassificationToClause; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassificationToClause12590); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassificationToClause"


    // $ANTLR start "ruleClassificationToClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5657:1: ruleClassificationToClause returns [EObject current=null] : (otherlv_0= 'to' this_QualifiedNameList_1= ruleQualifiedNameList ) ;
    public final EObject ruleClassificationToClause() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_QualifiedNameList_1 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5660:28: ( (otherlv_0= 'to' this_QualifiedNameList_1= ruleQualifiedNameList ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5661:1: (otherlv_0= 'to' this_QualifiedNameList_1= ruleQualifiedNameList )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5661:1: (otherlv_0= 'to' this_QualifiedNameList_1= ruleQualifiedNameList )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5661:3: otherlv_0= 'to' this_QualifiedNameList_1= ruleQualifiedNameList
            {
            otherlv_0=(Token)match(input,61,FOLLOW_61_in_ruleClassificationToClause12627); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getClassificationToClauseAccess().getToKeyword_0());
                  
            }
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getClassificationToClauseAccess().getQualifiedNameListParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleQualifiedNameList_in_ruleClassificationToClause12652);
            this_QualifiedNameList_1=ruleQualifiedNameList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_QualifiedNameList_1; 
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassificationToClause"


    // $ANTLR start "entryRuleReclassifyAllClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5685:1: entryRuleReclassifyAllClause returns [String current=null] : iv_ruleReclassifyAllClause= ruleReclassifyAllClause EOF ;
    public final String entryRuleReclassifyAllClause() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReclassifyAllClause = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5686:2: (iv_ruleReclassifyAllClause= ruleReclassifyAllClause EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5687:2: iv_ruleReclassifyAllClause= ruleReclassifyAllClause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReclassifyAllClauseRule()); 
            }
            pushFollow(FOLLOW_ruleReclassifyAllClause_in_entryRuleReclassifyAllClause12688);
            iv_ruleReclassifyAllClause=ruleReclassifyAllClause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReclassifyAllClause.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleReclassifyAllClause12699); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReclassifyAllClause"


    // $ANTLR start "ruleReclassifyAllClause"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5694:1: ruleReclassifyAllClause returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'from' kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleReclassifyAllClause() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5697:28: ( (kw= 'from' kw= '*' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5698:1: (kw= 'from' kw= '*' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5698:1: (kw= 'from' kw= '*' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5699:2: kw= 'from' kw= '*'
            {
            kw=(Token)match(input,60,FOLLOW_60_in_ruleReclassifyAllClause12737); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getReclassifyAllClauseAccess().getFromKeyword_0()); 
                  
            }
            kw=(Token)match(input,16,FOLLOW_16_in_ruleReclassifyAllClause12750); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getReclassifyAllClauseAccess().getAsteriskKeyword_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReclassifyAllClause"


    // $ANTLR start "entryRuleQualifiedNameList"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5718:1: entryRuleQualifiedNameList returns [EObject current=null] : iv_ruleQualifiedNameList= ruleQualifiedNameList EOF ;
    public final EObject entryRuleQualifiedNameList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualifiedNameList = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5719:2: (iv_ruleQualifiedNameList= ruleQualifiedNameList EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5720:2: iv_ruleQualifiedNameList= ruleQualifiedNameList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameListRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedNameList_in_entryRuleQualifiedNameList12790);
            iv_ruleQualifiedNameList=ruleQualifiedNameList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameList12800); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameList"


    // $ANTLR start "ruleQualifiedNameList"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5727:1: ruleQualifiedNameList returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= ',' ( (lv_name_2_0= ruleQualifiedName ) ) )* ) ;
    public final EObject ruleQualifiedNameList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5730:28: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= ',' ( (lv_name_2_0= ruleQualifiedName ) ) )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5731:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= ',' ( (lv_name_2_0= ruleQualifiedName ) ) )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5731:1: ( ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= ',' ( (lv_name_2_0= ruleQualifiedName ) ) )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5731:2: ( (lv_name_0_0= ruleQualifiedName ) ) (otherlv_1= ',' ( (lv_name_2_0= ruleQualifiedName ) ) )*
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5731:2: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5732:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5732:1: (lv_name_0_0= ruleQualifiedName )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5733:3: lv_name_0_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getQualifiedNameListAccess().getNameQualifiedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameList12846);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getQualifiedNameListRule());
              	        }
                     		add(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5749:2: (otherlv_1= ',' ( (lv_name_2_0= ruleQualifiedName ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==20) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5749:4: otherlv_1= ',' ( (lv_name_2_0= ruleQualifiedName ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleQualifiedNameList12859); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getQualifiedNameListAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5753:1: ( (lv_name_2_0= ruleQualifiedName ) )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5754:1: (lv_name_2_0= ruleQualifiedName )
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5754:1: (lv_name_2_0= ruleQualifiedName )
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5755:3: lv_name_2_0= ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getQualifiedNameListAccess().getNameQualifiedNameParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameList12880);
            	    lv_name_2_0=ruleQualifiedName();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getQualifiedNameListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"name",
            	              		lv_name_2_0, 
            	              		"QualifiedName");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameList"


    // $ANTLR start "entryRuleSendSignalStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5779:1: entryRuleSendSignalStatement returns [EObject current=null] : iv_ruleSendSignalStatement= ruleSendSignalStatement EOF ;
    public final EObject entryRuleSendSignalStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSendSignalStatement = null;


        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5780:2: (iv_ruleSendSignalStatement= ruleSendSignalStatement EOF )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5781:2: iv_ruleSendSignalStatement= ruleSendSignalStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSendSignalStatementRule()); 
            }
            pushFollow(FOLLOW_ruleSendSignalStatement_in_entryRuleSendSignalStatement12918);
            iv_ruleSendSignalStatement=ruleSendSignalStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSendSignalStatement; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSendSignalStatement12928); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSendSignalStatement"


    // $ANTLR start "ruleSendSignalStatement"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5788:1: ruleSendSignalStatement returns [EObject current=null] : ( () otherlv_1= 'send' ( (lv_signal_2_0= ruleExpression ) ) otherlv_3= 'to' ( (lv_target_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleSendSignalStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_signal_2_0 = null;

        EObject lv_target_4_0 = null;


         enterRule(); 
            
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5791:28: ( ( () otherlv_1= 'send' ( (lv_signal_2_0= ruleExpression ) ) otherlv_3= 'to' ( (lv_target_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5792:1: ( () otherlv_1= 'send' ( (lv_signal_2_0= ruleExpression ) ) otherlv_3= 'to' ( (lv_target_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5792:1: ( () otherlv_1= 'send' ( (lv_signal_2_0= ruleExpression ) ) otherlv_3= 'to' ( (lv_target_4_0= ruleExpression ) ) otherlv_5= ';' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5792:2: () otherlv_1= 'send' ( (lv_signal_2_0= ruleExpression ) ) otherlv_3= 'to' ( (lv_target_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5792:2: ()
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5793:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSendSignalStatementAccess().getSendSignalStatementAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleSendSignalStatement12977); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSendSignalStatementAccess().getSendKeyword_1());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5805:1: ( (lv_signal_2_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5806:1: (lv_signal_2_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5806:1: (lv_signal_2_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5807:3: lv_signal_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSendSignalStatementAccess().getSignalExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSendSignalStatement12998);
            lv_signal_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSendSignalStatementRule());
              	        }
                     		set(
                     			current, 
                     			"signal",
                      		lv_signal_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,61,FOLLOW_61_in_ruleSendSignalStatement13010); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSendSignalStatementAccess().getToKeyword_3());
                  
            }
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5827:1: ( (lv_target_4_0= ruleExpression ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5828:1: (lv_target_4_0= ruleExpression )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5828:1: (lv_target_4_0= ruleExpression )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5829:3: lv_target_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSendSignalStatementAccess().getTargetExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSendSignalStatement13031);
            lv_target_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSendSignalStatementRule());
              	        }
                     		set(
                     			current, 
                     			"target",
                      		lv_target_4_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,46,FOLLOW_46_in_ruleSendSignalStatement13043); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getSendSignalStatementAccess().getSemicolonKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSendSignalStatement"


    // $ANTLR start "ruleLinkOperation"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5857:1: ruleLinkOperation returns [Enumerator current=null] : ( (enumLiteral_0= 'link' ) | (enumLiteral_1= 'unlink' ) ) ;
    public final Enumerator ruleLinkOperation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5859:28: ( ( (enumLiteral_0= 'link' ) | (enumLiteral_1= 'unlink' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5860:1: ( (enumLiteral_0= 'link' ) | (enumLiteral_1= 'unlink' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5860:1: ( (enumLiteral_0= 'link' ) | (enumLiteral_1= 'unlink' ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==63) ) {
                alt58=1;
            }
            else if ( (LA58_0==64) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5860:2: (enumLiteral_0= 'link' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5860:2: (enumLiteral_0= 'link' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5860:4: enumLiteral_0= 'link'
                    {
                    enumLiteral_0=(Token)match(input,63,FOLLOW_63_in_ruleLinkOperation13093); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLinkOperationAccess().getLinkEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getLinkOperationAccess().getLinkEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5866:6: (enumLiteral_1= 'unlink' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5866:6: (enumLiteral_1= 'unlink' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5866:8: enumLiteral_1= 'unlink'
                    {
                    enumLiteral_1=(Token)match(input,64,FOLLOW_64_in_ruleLinkOperation13110); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getLinkOperationAccess().getUnlinkEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getLinkOperationAccess().getUnlinkEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLinkOperation"


    // $ANTLR start "ruleCollectionType"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5876:1: ruleCollectionType returns [Enumerator current=null] : ( (enumLiteral_0= 'set' ) | (enumLiteral_1= 'bag' ) | (enumLiteral_2= 'sequence' ) ) ;
    public final Enumerator ruleCollectionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5878:28: ( ( (enumLiteral_0= 'set' ) | (enumLiteral_1= 'bag' ) | (enumLiteral_2= 'sequence' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5879:1: ( (enumLiteral_0= 'set' ) | (enumLiteral_1= 'bag' ) | (enumLiteral_2= 'sequence' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5879:1: ( (enumLiteral_0= 'set' ) | (enumLiteral_1= 'bag' ) | (enumLiteral_2= 'sequence' ) )
            int alt59=3;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt59=1;
                }
                break;
            case 66:
                {
                alt59=2;
                }
                break;
            case 67:
                {
                alt59=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5879:2: (enumLiteral_0= 'set' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5879:2: (enumLiteral_0= 'set' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5879:4: enumLiteral_0= 'set'
                    {
                    enumLiteral_0=(Token)match(input,65,FOLLOW_65_in_ruleCollectionType13155); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCollectionTypeAccess().getSetEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getCollectionTypeAccess().getSetEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5885:6: (enumLiteral_1= 'bag' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5885:6: (enumLiteral_1= 'bag' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5885:8: enumLiteral_1= 'bag'
                    {
                    enumLiteral_1=(Token)match(input,66,FOLLOW_66_in_ruleCollectionType13172); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCollectionTypeAccess().getBagEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getCollectionTypeAccess().getBagEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5891:6: (enumLiteral_2= 'sequence' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5891:6: (enumLiteral_2= 'sequence' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5891:8: enumLiteral_2= 'sequence'
                    {
                    enumLiteral_2=(Token)match(input,67,FOLLOW_67_in_ruleCollectionType13189); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getCollectionTypeAccess().getSequenceEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getCollectionTypeAccess().getSequenceEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionType"


    // $ANTLR start "ruleAffixOperator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5901:1: ruleAffixOperator returns [Enumerator current=null] : ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) ;
    public final Enumerator ruleAffixOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5903:28: ( ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5904:1: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5904:1: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==68) ) {
                alt60=1;
            }
            else if ( (LA60_0==69) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5904:2: (enumLiteral_0= '++' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5904:2: (enumLiteral_0= '++' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5904:4: enumLiteral_0= '++'
                    {
                    enumLiteral_0=(Token)match(input,68,FOLLOW_68_in_ruleAffixOperator13234); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAffixOperatorAccess().getIncrementEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAffixOperatorAccess().getIncrementEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5910:6: (enumLiteral_1= '--' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5910:6: (enumLiteral_1= '--' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5910:8: enumLiteral_1= '--'
                    {
                    enumLiteral_1=(Token)match(input,69,FOLLOW_69_in_ruleAffixOperator13251); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAffixOperatorAccess().getDecrementEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAffixOperatorAccess().getDecrementEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAffixOperator"


    // $ANTLR start "ruleNumericUnaryOperator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5920:1: ruleNumericUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleNumericUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5922:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5923:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5923:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==37) ) {
                alt61=1;
            }
            else if ( (LA61_0==38) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5923:2: (enumLiteral_0= '+' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5923:2: (enumLiteral_0= '+' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5923:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,37,FOLLOW_37_in_ruleNumericUnaryOperator13296); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getNumericUnaryOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getNumericUnaryOperatorAccess().getPlusEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5929:6: (enumLiteral_1= '-' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5929:6: (enumLiteral_1= '-' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5929:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,38,FOLLOW_38_in_ruleNumericUnaryOperator13313); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getNumericUnaryOperatorAccess().getMinusEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getNumericUnaryOperatorAccess().getMinusEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericUnaryOperator"


    // $ANTLR start "ruleShiftOperator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5939:1: ruleShiftOperator returns [Enumerator current=null] : ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) | (enumLiteral_2= '>>>' ) ) ;
    public final Enumerator ruleShiftOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5941:28: ( ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) | (enumLiteral_2= '>>>' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5942:1: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) | (enumLiteral_2= '>>>' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5942:1: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) | (enumLiteral_2= '>>>' ) )
            int alt62=3;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt62=1;
                }
                break;
            case 71:
                {
                alt62=2;
                }
                break;
            case 72:
                {
                alt62=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5942:2: (enumLiteral_0= '>>' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5942:2: (enumLiteral_0= '>>' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5942:4: enumLiteral_0= '>>'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_70_in_ruleShiftOperator13358); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5948:6: (enumLiteral_1= '<<' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5948:6: (enumLiteral_1= '<<' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5948:8: enumLiteral_1= '<<'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_71_in_ruleShiftOperator13375); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5954:6: (enumLiteral_2= '>>>' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5954:6: (enumLiteral_2= '>>>' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5954:8: enumLiteral_2= '>>>'
                    {
                    enumLiteral_2=(Token)match(input,72,FOLLOW_72_in_ruleShiftOperator13392); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getShiftOperatorAccess().getTripleEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getShiftOperatorAccess().getTripleEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftOperator"


    // $ANTLR start "ruleRelationalOperator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5964:1: ruleRelationalOperator returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5966:28: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5967:1: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5967:1: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '<' ) | (enumLiteral_2= '>=' ) | (enumLiteral_3= '<=' ) )
            int alt63=4;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt63=1;
                }
                break;
            case 26:
                {
                alt63=2;
                }
                break;
            case 73:
                {
                alt63=3;
                }
                break;
            case 74:
                {
                alt63=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5967:2: (enumLiteral_0= '>' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5967:2: (enumLiteral_0= '>' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5967:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,27,FOLLOW_27_in_ruleRelationalOperator13437); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getRelationalOperatorAccess().getGreaterThanEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5973:6: (enumLiteral_1= '<' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5973:6: (enumLiteral_1= '<' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5973:8: enumLiteral_1= '<'
                    {
                    enumLiteral_1=(Token)match(input,26,FOLLOW_26_in_ruleRelationalOperator13454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getLesserThanEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getRelationalOperatorAccess().getLesserThanEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5979:6: (enumLiteral_2= '>=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5979:6: (enumLiteral_2= '>=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5979:8: enumLiteral_2= '>='
                    {
                    enumLiteral_2=(Token)match(input,73,FOLLOW_73_in_ruleRelationalOperator13471); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getGreaterOrEqualsEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getRelationalOperatorAccess().getGreaterOrEqualsEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5985:6: (enumLiteral_3= '<=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5985:6: (enumLiteral_3= '<=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5985:8: enumLiteral_3= '<='
                    {
                    enumLiteral_3=(Token)match(input,74,FOLLOW_74_in_ruleRelationalOperator13488); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getRelationalOperatorAccess().getLesserOrEqualsEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getRelationalOperatorAccess().getLesserOrEqualsEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "ruleClassificationOperator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5995:1: ruleClassificationOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'instanceof' ) | (enumLiteral_1= 'hastype' ) ) ;
    public final Enumerator ruleClassificationOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5997:28: ( ( (enumLiteral_0= 'instanceof' ) | (enumLiteral_1= 'hastype' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5998:1: ( (enumLiteral_0= 'instanceof' ) | (enumLiteral_1= 'hastype' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5998:1: ( (enumLiteral_0= 'instanceof' ) | (enumLiteral_1= 'hastype' ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==75) ) {
                alt64=1;
            }
            else if ( (LA64_0==76) ) {
                alt64=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5998:2: (enumLiteral_0= 'instanceof' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5998:2: (enumLiteral_0= 'instanceof' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:5998:4: enumLiteral_0= 'instanceof'
                    {
                    enumLiteral_0=(Token)match(input,75,FOLLOW_75_in_ruleClassificationOperator13533); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getClassificationOperatorAccess().getInstanceofEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getClassificationOperatorAccess().getInstanceofEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6004:6: (enumLiteral_1= 'hastype' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6004:6: (enumLiteral_1= 'hastype' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6004:8: enumLiteral_1= 'hastype'
                    {
                    enumLiteral_1=(Token)match(input,76,FOLLOW_76_in_ruleClassificationOperator13550); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getClassificationOperatorAccess().getHastypeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getClassificationOperatorAccess().getHastypeEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassificationOperator"


    // $ANTLR start "ruleEqualityOperator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6014:1: ruleEqualityOperator returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleEqualityOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6016:28: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6017:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6017:1: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==77) ) {
                alt65=1;
            }
            else if ( (LA65_0==78) ) {
                alt65=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6017:2: (enumLiteral_0= '==' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6017:2: (enumLiteral_0= '==' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6017:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,77,FOLLOW_77_in_ruleEqualityOperator13595); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getEqualityOperatorAccess().getEqualsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getEqualityOperatorAccess().getEqualsEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6023:6: (enumLiteral_1= '!=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6023:6: (enumLiteral_1= '!=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6023:8: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,78,FOLLOW_78_in_ruleEqualityOperator13612); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getEqualityOperatorAccess().getNotEqualsEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getEqualityOperatorAccess().getNotEqualsEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityOperator"


    // $ANTLR start "ruleAssignmentOperator"
    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6033:1: ruleAssignmentOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) | (enumLiteral_3= '*=' ) | (enumLiteral_4= '/=' ) | (enumLiteral_5= '%=' ) | (enumLiteral_6= '&=' ) | (enumLiteral_7= '|=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '<<=' ) | (enumLiteral_10= '>>=' ) | (enumLiteral_11= '>>>=' ) ) ;
    public final Enumerator ruleAssignmentOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;

         enterRule(); 
        try {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6035:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) | (enumLiteral_3= '*=' ) | (enumLiteral_4= '/=' ) | (enumLiteral_5= '%=' ) | (enumLiteral_6= '&=' ) | (enumLiteral_7= '|=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '<<=' ) | (enumLiteral_10= '>>=' ) | (enumLiteral_11= '>>>=' ) ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6036:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) | (enumLiteral_3= '*=' ) | (enumLiteral_4= '/=' ) | (enumLiteral_5= '%=' ) | (enumLiteral_6= '&=' ) | (enumLiteral_7= '|=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '<<=' ) | (enumLiteral_10= '>>=' ) | (enumLiteral_11= '>>>=' ) )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6036:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '+=' ) | (enumLiteral_2= '-=' ) | (enumLiteral_3= '*=' ) | (enumLiteral_4= '/=' ) | (enumLiteral_5= '%=' ) | (enumLiteral_6= '&=' ) | (enumLiteral_7= '|=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '<<=' ) | (enumLiteral_10= '>>=' ) | (enumLiteral_11= '>>>=' ) )
            int alt66=12;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt66=1;
                }
                break;
            case 79:
                {
                alt66=2;
                }
                break;
            case 80:
                {
                alt66=3;
                }
                break;
            case 81:
                {
                alt66=4;
                }
                break;
            case 82:
                {
                alt66=5;
                }
                break;
            case 83:
                {
                alt66=6;
                }
                break;
            case 84:
                {
                alt66=7;
                }
                break;
            case 85:
                {
                alt66=8;
                }
                break;
            case 86:
                {
                alt66=9;
                }
                break;
            case 87:
                {
                alt66=10;
                }
                break;
            case 88:
                {
                alt66=11;
                }
                break;
            case 89:
                {
                alt66=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6036:2: (enumLiteral_0= '=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6036:2: (enumLiteral_0= '=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6036:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,47,FOLLOW_47_in_ruleAssignmentOperator13657); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6042:6: (enumLiteral_1= '+=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6042:6: (enumLiteral_1= '+=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6042:8: enumLiteral_1= '+='
                    {
                    enumLiteral_1=(Token)match(input,79,FOLLOW_79_in_ruleAssignmentOperator13674); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getIncrementAssignEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getAssignmentOperatorAccess().getIncrementAssignEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6048:6: (enumLiteral_2= '-=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6048:6: (enumLiteral_2= '-=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6048:8: enumLiteral_2= '-='
                    {
                    enumLiteral_2=(Token)match(input,80,FOLLOW_80_in_ruleAssignmentOperator13691); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getDecrementAssignEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getAssignmentOperatorAccess().getDecrementAssignEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6054:6: (enumLiteral_3= '*=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6054:6: (enumLiteral_3= '*=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6054:8: enumLiteral_3= '*='
                    {
                    enumLiteral_3=(Token)match(input,81,FOLLOW_81_in_ruleAssignmentOperator13708); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getMultiplyAssignEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getAssignmentOperatorAccess().getMultiplyAssignEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6060:6: (enumLiteral_4= '/=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6060:6: (enumLiteral_4= '/=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6060:8: enumLiteral_4= '/='
                    {
                    enumLiteral_4=(Token)match(input,82,FOLLOW_82_in_ruleAssignmentOperator13725); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getDivisionAssignEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getAssignmentOperatorAccess().getDivisionAssignEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6066:6: (enumLiteral_5= '%=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6066:6: (enumLiteral_5= '%=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6066:8: enumLiteral_5= '%='
                    {
                    enumLiteral_5=(Token)match(input,83,FOLLOW_83_in_ruleAssignmentOperator13742); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getModuloAssignEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getAssignmentOperatorAccess().getModuloAssignEnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6072:6: (enumLiteral_6= '&=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6072:6: (enumLiteral_6= '&=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6072:8: enumLiteral_6= '&='
                    {
                    enumLiteral_6=(Token)match(input,84,FOLLOW_84_in_ruleAssignmentOperator13759); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_6, grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_6()); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6078:6: (enumLiteral_7= '|=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6078:6: (enumLiteral_7= '|=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6078:8: enumLiteral_7= '|='
                    {
                    enumLiteral_7=(Token)match(input,85,FOLLOW_85_in_ruleAssignmentOperator13776); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_7, grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_7()); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6084:6: (enumLiteral_8= '^=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6084:6: (enumLiteral_8= '^=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6084:8: enumLiteral_8= '^='
                    {
                    enumLiteral_8=(Token)match(input,86,FOLLOW_86_in_ruleAssignmentOperator13793); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_8, grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_8()); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6090:6: (enumLiteral_9= '<<=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6090:6: (enumLiteral_9= '<<=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6090:8: enumLiteral_9= '<<='
                    {
                    enumLiteral_9=(Token)match(input,87,FOLLOW_87_in_ruleAssignmentOperator13810); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_9, grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_9()); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6096:6: (enumLiteral_10= '>>=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6096:6: (enumLiteral_10= '>>=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6096:8: enumLiteral_10= '>>='
                    {
                    enumLiteral_10=(Token)match(input,88,FOLLOW_88_in_ruleAssignmentOperator13827); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_10, grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_10()); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6102:6: (enumLiteral_11= '>>>=' )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6102:6: (enumLiteral_11= '>>>=' )
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6102:8: enumLiteral_11= '>>>='
                    {
                    enumLiteral_11=(Token)match(input,89,FOLLOW_89_in_ruleAssignmentOperator13844); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getAssignmentOperatorAccess().getTripleShiftAssignEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_11, grammarAccess.getAssignmentOperatorAccess().getTripleShiftAssignEnumLiteralDeclaration_11()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentOperator"

    // $ANTLR start synpred3_InternalReducedAlfLanguage
    public final void synpred3_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        Token kw=null;
        AntlrDatatypeRuleToken this_Name_2 = null;


        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:174:2: (kw= '::' this_Name_2= ruleName )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:174:2: kw= '::' this_Name_2= ruleName
        {
        kw=(Token)match(input,13,FOLLOW_13_in_synpred3_InternalReducedAlfLanguage373); if (state.failed) return ;
        pushFollow(FOLLOW_ruleName_in_synpred3_InternalReducedAlfLanguage395);
        this_Name_2=ruleName();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalReducedAlfLanguage

    // $ANTLR start synpred4_InternalReducedAlfLanguage
    public final void synpred4_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        EObject this_AssignmentExpression_0 = null;


        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:212:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:212:2: this_AssignmentExpression_0= ruleAssignmentExpression
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleAssignmentExpression_in_synpred4_InternalReducedAlfLanguage502);
        this_AssignmentExpression_0=ruleAssignmentExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalReducedAlfLanguage

    // $ANTLR start synpred7_InternalReducedAlfLanguage
    public final void synpred7_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        Token otherlv_7=null;

        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:335:6: ( ( () otherlv_7= '.' ( ( ruleName ) ) ) )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:335:6: ( () otherlv_7= '.' ( ( ruleName ) ) )
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:335:6: ( () otherlv_7= '.' ( ( ruleName ) ) )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:335:7: () otherlv_7= '.' ( ( ruleName ) )
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:335:7: ()
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:336:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_7=(Token)match(input,14,FOLLOW_14_in_synpred7_InternalReducedAlfLanguage771); if (state.failed) return ;
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:348:1: ( ( ruleName ) )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:349:1: ( ruleName )
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:349:1: ( ruleName )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:350:3: ruleName
        {
        if ( state.backtracking==0 ) {
           
          		  /* */ 
          		
        }
        pushFollow(FOLLOW_ruleName_in_synpred7_InternalReducedAlfLanguage798);
        ruleName();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalReducedAlfLanguage

    // $ANTLR start synpred24_InternalReducedAlfLanguage
    public final void synpred24_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        Token otherlv_2=null;

        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1090:2: ( ( () otherlv_1= '(' otherlv_2= ')' ) )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1090:2: ( () otherlv_1= '(' otherlv_2= ')' )
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1090:2: ( () otherlv_1= '(' otherlv_2= ')' )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1090:3: () otherlv_1= '(' otherlv_2= ')'
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1090:3: ()
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1091:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        otherlv_1=(Token)match(input,18,FOLLOW_18_in_synpred24_InternalReducedAlfLanguage2551); if (state.failed) return ;
        otherlv_2=(Token)match(input,19,FOLLOW_19_in_synpred24_InternalReducedAlfLanguage2563); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred24_InternalReducedAlfLanguage

    // $ANTLR start synpred31_InternalReducedAlfLanguage
    public final void synpred31_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        EObject lv_elements_6_0 = null;


        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1715:1: ( (lv_elements_6_0= ruleExpressionList ) )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1715:1: (lv_elements_6_0= ruleExpressionList )
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1715:1: (lv_elements_6_0= ruleExpressionList )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1716:3: lv_elements_6_0= ruleExpressionList
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getCollectionLiteralExpressionAccess().getElementsExpressionListParserRuleCall_3_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleExpressionList_in_synpred31_InternalReducedAlfLanguage3915);
        lv_elements_6_0=ruleExpressionList();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred31_InternalReducedAlfLanguage

    // $ANTLR start synpred34_InternalReducedAlfLanguage
    public final void synpred34_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        EObject this_PostfixExpression_0 = null;


        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1963:2: (this_PostfixExpression_0= rulePostfixExpression )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1963:2: this_PostfixExpression_0= rulePostfixExpression
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_rulePostfixExpression_in_synpred34_InternalReducedAlfLanguage4519);
        this_PostfixExpression_0=rulePostfixExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalReducedAlfLanguage

    // $ANTLR start synpred35_InternalReducedAlfLanguage
    public final void synpred35_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        EObject this_CastExpression_1 = null;


        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1976:2: (this_CastExpression_1= ruleCastExpression )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1976:2: this_CastExpression_1= ruleCastExpression
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleCastExpression_in_synpred35_InternalReducedAlfLanguage4549);
        this_CastExpression_1=ruleCastExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalReducedAlfLanguage

    // $ANTLR start synpred40_InternalReducedAlfLanguage
    public final void synpred40_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        Enumerator lv_operator_0_0 = null;

        EObject lv_operand_1_1 = null;

        EObject lv_operand_1_2 = null;


        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2267:2: ( ( ( (lv_operator_0_0= ruleNumericUnaryOperator ) ) ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) ) ) )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2267:2: ( ( (lv_operator_0_0= ruleNumericUnaryOperator ) ) ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) ) )
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2267:2: ( ( (lv_operator_0_0= ruleNumericUnaryOperator ) ) ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) ) )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2267:3: ( (lv_operator_0_0= ruleNumericUnaryOperator ) ) ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) )
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2267:3: ( (lv_operator_0_0= ruleNumericUnaryOperator ) )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2268:1: (lv_operator_0_0= ruleNumericUnaryOperator )
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2268:1: (lv_operator_0_0= ruleNumericUnaryOperator )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2269:3: lv_operator_0_0= ruleNumericUnaryOperator
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getNumericUnaryExpressionAccess().getOperatorNumericUnaryOperatorEnumRuleCall_0_0_0()); 
          	    
        }
        pushFollow(FOLLOW_ruleNumericUnaryOperator_in_synpred40_InternalReducedAlfLanguage5227);
        lv_operator_0_0=ruleNumericUnaryOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2285:2: ( ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) ) )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2286:1: ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) )
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2286:1: ( (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression ) )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2287:1: (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression )
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2287:1: (lv_operand_1_1= rulePostfixOrCastExpression | lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression )
        int alt69=2;
        int LA69_0 = input.LA(1);

        if ( ((LA69_0>=RULE_ID && LA69_0<=RULE_STRING)||(LA69_0>=16 && LA69_0<=18)||(LA69_0>=22 && LA69_0<=23)||LA69_0==25||LA69_0==28||(LA69_0>=65 && LA69_0<=67)) ) {
            alt69=1;
        }
        else if ( ((LA69_0>=32 && LA69_0<=34)||(LA69_0>=37 && LA69_0<=38)) ) {
            alt69=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 69, 0, input);

            throw nvae;
        }
        switch (alt69) {
            case 1 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2288:3: lv_operand_1_1= rulePostfixOrCastExpression
                {
                pushFollow(FOLLOW_rulePostfixOrCastExpression_in_synpred40_InternalReducedAlfLanguage5250);
                lv_operand_1_1=rulePostfixOrCastExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;
            case 2 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:2303:8: lv_operand_1_2= ruleNonPostfixNonCastUnaryExpression
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getNumericUnaryExpressionAccess().getOperandNonPostfixNonCastUnaryExpressionParserRuleCall_0_1_0_1()); 
                  	    
                }
                pushFollow(FOLLOW_ruleNonPostfixNonCastUnaryExpression_in_synpred40_InternalReducedAlfLanguage5269);
                lv_operand_1_2=ruleNonPostfixNonCastUnaryExpression();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }


        }


        }


        }
    }
    // $ANTLR end synpred40_InternalReducedAlfLanguage

    // $ANTLR start synpred59_InternalReducedAlfLanguage
    public final void synpred59_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        EObject this_NameLeftHandSide_0 = null;


        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3658:2: (this_NameLeftHandSide_0= ruleNameLeftHandSide )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3658:2: this_NameLeftHandSide_0= ruleNameLeftHandSide
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleNameLeftHandSide_in_synpred59_InternalReducedAlfLanguage8163);
        this_NameLeftHandSide_0=ruleNameLeftHandSide();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred59_InternalReducedAlfLanguage

    // $ANTLR start synpred61_InternalReducedAlfLanguage
    public final void synpred61_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        EObject this_SimpleStatement_0 = null;


        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3799:2: ( (this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';' ) )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3799:2: (this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';' )
        {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3799:2: (this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';' )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3800:2: this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';'
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleSimpleStatement_in_synpred61_InternalReducedAlfLanguage8493);
        this_SimpleStatement_0=ruleSimpleStatement();

        state._fsp--;
        if (state.failed) return ;
        otherlv_1=(Token)match(input,46,FOLLOW_46_in_synpred61_InternalReducedAlfLanguage8504); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred61_InternalReducedAlfLanguage

    // $ANTLR start synpred62_InternalReducedAlfLanguage
    public final void synpred62_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        EObject this_BlockStatement_2 = null;


        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3817:2: (this_BlockStatement_2= ruleBlockStatement )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3817:2: this_BlockStatement_2= ruleBlockStatement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleBlockStatement_in_synpred62_InternalReducedAlfLanguage8536);
        this_BlockStatement_2=ruleBlockStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred62_InternalReducedAlfLanguage

    // $ANTLR start synpred66_InternalReducedAlfLanguage
    public final void synpred66_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        EObject this_ForStatement_6 = null;


        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3869:2: (this_ForStatement_6= ruleForStatement )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3869:2: this_ForStatement_6= ruleForStatement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleForStatement_in_synpred66_InternalReducedAlfLanguage8656);
        this_ForStatement_6=ruleForStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred66_InternalReducedAlfLanguage

    // $ANTLR start synpred67_InternalReducedAlfLanguage
    public final void synpred67_InternalReducedAlfLanguage_fragment() throws RecognitionException {   
        EObject this_ForEachStatement_7 = null;


        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3882:2: (this_ForEachStatement_7= ruleForEachStatement )
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:3882:2: this_ForEachStatement_7= ruleForEachStatement
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FOLLOW_ruleForEachStatement_in_synpred67_InternalReducedAlfLanguage8686);
        this_ForEachStatement_7=ruleForEachStatement();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred67_InternalReducedAlfLanguage

    // Delegated rules

    public final boolean synpred7_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred61_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred67_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred31_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalReducedAlfLanguage() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalReducedAlfLanguage_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA4 dfa4 = new DFA4(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA41 dfa41 = new DFA41(this);
    static final String DFA3_eotS =
        "\66\uffff";
    static final String DFA3_eofS =
        "\1\1\65\uffff";
    static final String DFA3_minS =
        "\1\4\2\uffff\1\0\62\uffff";
    static final String DFA3_maxS =
        "\1\131\2\uffff\1\0\62\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\2\63\uffff\1\1";
    static final String DFA3_specialS =
        "\3\uffff\1\0\62\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\1\7\uffff\1\3\3\1\1\uffff\3\1\5\uffff\2\1\1\uffff\3\1\3"+
            "\uffff\15\1\14\uffff\2\1\6\uffff\26\1",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()* loopback of 173:1: (kw= '::' this_Name_2= ruleName )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_3 = input.LA(1);

                         
                        int index3_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalReducedAlfLanguage()) ) {s = 53;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index3_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA4_eotS =
        "\31\uffff";
    static final String DFA4_eofS =
        "\31\uffff";
    static final String DFA4_minS =
        "\1\4\20\0\10\uffff";
    static final String DFA4_maxS =
        "\1\105\20\0\10\uffff";
    static final String DFA4_acceptS =
        "\21\uffff\1\2\6\uffff\1\1";
    static final String DFA4_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\10\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\7\6\uffff\1\6\1\14\1\20\3\uffff\1\15"+
            "\1\16\1\uffff\1\17\2\uffff\1\13\3\uffff\3\21\2\uffff\2\21\32"+
            "\uffff\1\10\1\11\1\12\2\21",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "211:1: (this_AssignmentExpression_0= ruleAssignmentExpression | this_ConditionalExpression_1= ruleConditionalExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_1 = input.LA(1);

                         
                        int index4_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_2 = input.LA(1);

                         
                        int index4_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA4_3 = input.LA(1);

                         
                        int index4_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA4_4 = input.LA(1);

                         
                        int index4_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA4_5 = input.LA(1);

                         
                        int index4_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA4_6 = input.LA(1);

                         
                        int index4_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA4_7 = input.LA(1);

                         
                        int index4_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA4_8 = input.LA(1);

                         
                        int index4_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA4_9 = input.LA(1);

                         
                        int index4_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA4_10 = input.LA(1);

                         
                        int index4_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA4_11 = input.LA(1);

                         
                        int index4_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA4_12 = input.LA(1);

                         
                        int index4_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA4_13 = input.LA(1);

                         
                        int index4_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA4_14 = input.LA(1);

                         
                        int index4_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA4_15 = input.LA(1);

                         
                        int index4_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA4_16 = input.LA(1);

                         
                        int index4_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_InternalReducedAlfLanguage()) ) {s = 24;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index4_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA7_eotS =
        "\20\uffff";
    static final String DFA7_eofS =
        "\6\uffff\2\13\5\uffff\2\13\1\uffff";
    static final String DFA7_minS =
        "\1\4\5\uffff\2\15\2\uffff\1\4\2\uffff\2\15\1\uffff";
    static final String DFA7_maxS =
        "\1\103\5\uffff\2\116\2\uffff\1\100\2\uffff\2\116\1\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\2\uffff\1\10\1\12\1\uffff\1\11\1\7"+
        "\2\uffff\1\6";
    static final String DFA7_specialS =
        "\20\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\6\1\7\4\1\6\uffff\1\1\1\3\1\11\3\uffff\1\4\1\5\1\uffff\1"+
            "\10\2\uffff\1\2\44\uffff\3\2",
            "",
            "",
            "",
            "",
            "",
            "\1\12\3\13\2\uffff\2\13\5\uffff\2\13\1\uffff\3\13\3\uffff"+
            "\14\13\15\uffff\2\13\10\uffff\11\13",
            "\1\12\3\13\2\uffff\2\13\5\uffff\2\13\1\uffff\3\13\3\uffff"+
            "\14\13\15\uffff\2\13\10\uffff\11\13",
            "",
            "",
            "\1\15\1\16\22\uffff\1\17\46\uffff\2\14",
            "",
            "",
            "\1\12\3\13\1\uffff\3\13\5\uffff\2\13\1\uffff\3\13\3\uffff"+
            "\14\13\15\uffff\2\13\10\uffff\11\13",
            "\1\12\3\13\1\uffff\3\13\5\uffff\2\13\1\uffff\3\13\3\uffff"+
            "\14\13\15\uffff\2\13\10\uffff\11\13",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "447:1: (this_LiteralExpression_0= ruleLiteralExpression | this_CollectionLiteralExpression_1= ruleCollectionLiteralExpression | this_ThisExpression_2= ruleThisExpression | this_SuperInvocationExpression_3= ruleSuperInvocationExpression | this_InstanceCreationOrSequenceConstructionExpression_4= ruleInstanceCreationOrSequenceConstructionExpression | this_ClassExtentExpression_5= ruleClassExtentExpression | this_LinkOperationExpression_6= ruleLinkOperationExpression | this_NullExpression_7= ruleNullExpression | this_NameExpression_8= ruleNameExpression | this_ParenthesizedExpression_9= ruleParenthesizedExpression )";
        }
    }
    static final String DFA19_eotS =
        "\24\uffff";
    static final String DFA19_eofS =
        "\24\uffff";
    static final String DFA19_minS =
        "\1\4\20\0\3\uffff";
    static final String DFA19_maxS =
        "\1\103\20\0\3\uffff";
    static final String DFA19_acceptS =
        "\21\uffff\1\1\1\3\1\2";
    static final String DFA19_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\16\1\17\3\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\7\6\uffff\1\6\1\14\1\20\3\uffff\1\15"+
            "\1\16\1\uffff\1\17\2\uffff\1\13\44\uffff\1\10\1\11\1\12",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1962:1: (this_PostfixExpression_0= rulePostfixExpression | this_CastExpression_1= ruleCastExpression | this_PrimaryExpression_2= rulePrimaryExpression )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_1 = input.LA(1);

                         
                        int index19_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_2 = input.LA(1);

                         
                        int index19_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_3 = input.LA(1);

                         
                        int index19_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA19_4 = input.LA(1);

                         
                        int index19_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA19_5 = input.LA(1);

                         
                        int index19_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA19_6 = input.LA(1);

                         
                        int index19_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA19_7 = input.LA(1);

                         
                        int index19_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA19_8 = input.LA(1);

                         
                        int index19_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA19_9 = input.LA(1);

                         
                        int index19_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA19_10 = input.LA(1);

                         
                        int index19_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA19_11 = input.LA(1);

                         
                        int index19_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA19_12 = input.LA(1);

                         
                        int index19_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA19_13 = input.LA(1);

                         
                        int index19_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA19_14 = input.LA(1);

                         
                        int index19_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA19_15 = input.LA(1);

                         
                        int index19_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA19_16 = input.LA(1);

                         
                        int index19_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred34_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (synpred35_InternalReducedAlfLanguage()) ) {s = 19;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index19_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA38_eotS =
        "\22\uffff";
    static final String DFA38_eofS =
        "\22\uffff";
    static final String DFA38_minS =
        "\1\4\2\0\17\uffff";
    static final String DFA38_maxS =
        "\1\103\2\0\17\uffff";
    static final String DFA38_acceptS =
        "\3\uffff\1\2\15\uffff\1\1";
    static final String DFA38_specialS =
        "\1\uffff\1\0\1\1\17\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\1\1\2\4\3\6\uffff\3\3\3\uffff\2\3\1\uffff\1\3\2\uffff\1"+
            "\3\44\uffff\3\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "3657:1: (this_NameLeftHandSide_0= ruleNameLeftHandSide | this_FeatureLeftHandSide_1= ruleFeatureLeftHandSide )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA38_1 = input.LA(1);

                         
                        int index38_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index38_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA38_2 = input.LA(1);

                         
                        int index38_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_InternalReducedAlfLanguage()) ) {s = 17;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index38_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 38, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA40_eotS =
        "\45\uffff";
    static final String DFA40_eofS =
        "\45\uffff";
    static final String DFA40_minS =
        "\1\4\12\uffff\1\0\20\uffff\1\0\10\uffff";
    static final String DFA40_maxS =
        "\1\105\12\uffff\1\0\20\uffff\1\0\10\uffff";
    static final String DFA40_acceptS =
        "\1\uffff\1\1\27\uffff\1\3\1\4\1\5\1\uffff\1\10\1\11\1\12\1\13\1"+
        "\14\1\2\1\6\1\7";
    static final String DFA40_specialS =
        "\13\uffff\1\0\20\uffff\1\1\10\uffff}>";
    static final String[] DFA40_transitionS = {
            "\6\1\6\uffff\3\1\3\uffff\2\1\1\uffff\1\1\2\uffff\1\13\3\uffff"+
            "\3\1\2\uffff\2\1\7\uffff\1\1\1\uffff\1\31\2\uffff\1\32\2\uffff"+
            "\1\33\1\35\1\34\1\36\1\37\1\40\2\uffff\1\41\2\uffff\5\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "3799:1: ( (this_SimpleStatement_0= ruleSimpleStatement otherlv_1= ';' ) | this_BlockStatement_2= ruleBlockStatement | this_IfStatement_3= ruleIfStatement | this_SwitchStatement_4= ruleSwitchStatement | this_WhileStatement_5= ruleWhileStatement | this_ForStatement_6= ruleForStatement | this_ForEachStatement_7= ruleForEachStatement | this_DoStatement_8= ruleDoStatement | this_BreakStatement_9= ruleBreakStatement | this_ReturnStatement_10= ruleReturnStatement | this_ClassifyStatement_11= ruleClassifyStatement | this_SendSignalStatement_12= ruleSendSignalStatement )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_11 = input.LA(1);

                         
                        int index40_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred61_InternalReducedAlfLanguage()) ) {s = 1;}

                        else if ( (synpred62_InternalReducedAlfLanguage()) ) {s = 34;}

                         
                        input.seek(index40_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_28 = input.LA(1);

                         
                        int index40_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred66_InternalReducedAlfLanguage()) ) {s = 35;}

                        else if ( (synpred67_InternalReducedAlfLanguage()) ) {s = 36;}

                         
                        input.seek(index40_28);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA41_eotS =
        "\12\uffff";
    static final String DFA41_eofS =
        "\1\4\2\3\5\uffff\2\3";
    static final String DFA41_minS =
        "\3\4\2\uffff\2\4\1\uffff\2\4";
    static final String DFA41_maxS =
        "\1\105\2\131\2\uffff\1\100\1\105\1\uffff\2\131";
    static final String DFA41_acceptS =
        "\3\uffff\1\2\1\3\2\uffff\1\1\2\uffff";
    static final String DFA41_specialS =
        "\12\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\1\1\2\4\3\6\uffff\3\3\1\4\2\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\1\3\3\uffff\3\3\2\uffff\2\3\7\uffff\1\4\22\uffff\5\3",
            "\2\7\7\uffff\1\5\3\3\2\uffff\1\3\6\uffff\2\3\2\uffff\1\6\4"+
            "\uffff\12\3\1\uffff\2\3\24\uffff\26\3",
            "\2\7\7\uffff\1\5\3\3\2\uffff\1\3\6\uffff\2\3\2\uffff\1\6\4"+
            "\uffff\12\3\1\uffff\2\3\24\uffff\26\3",
            "",
            "",
            "\1\10\1\11\22\uffff\1\3\46\uffff\2\3",
            "\6\3\6\uffff\3\3\3\uffff\2\3\1\uffff\1\3\2\uffff\1\3\2\uffff"+
            "\1\7\3\3\2\uffff\2\3\32\uffff\5\3",
            "",
            "\2\7\7\uffff\1\5\3\3\1\uffff\2\3\6\uffff\2\3\2\uffff\1\6\4"+
            "\uffff\12\3\1\uffff\2\3\24\uffff\26\3",
            "\2\7\7\uffff\1\5\3\3\1\uffff\2\3\6\uffff\2\3\2\uffff\1\6\4"+
            "\uffff\12\3\1\uffff\2\3\24\uffff\26\3"
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "3979:1: (this_LocalNameDeclarationStatement_0= ruleLocalNameDeclarationStatement | this_ExpressionStatement_1= ruleExpressionStatement | this_EmptyStatement_2= ruleEmptyStatement )";
        }
    }
 

    public static final BitSet FOLLOW_ruleStatements_in_entryRuleStatements81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatements91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleStatements136 = new BitSet(new long[]{0x4FC9006712C703F2L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleName_in_entryRuleName173 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleName184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleName224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNRESTRICTED_NAME_in_ruleName250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleQualifiedName354 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleQualifiedName373 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleName_in_ruleQualifiedName395 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_ruleExpression502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleExpression532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBaseExpression_in_rulePrimaryExpression627 = new BitSet(new long[]{0x000000004000E002L});
    public static final BitSet FOLLOW_14_in_rulePrimaryExpression653 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_13_in_rulePrimaryExpression677 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleName_in_rulePrimaryExpression718 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleTuple_in_rulePrimaryExpression739 = new BitSet(new long[]{0x000000004000E002L});
    public static final BitSet FOLLOW_14_in_rulePrimaryExpression771 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleName_in_rulePrimaryExpression798 = new BitSet(new long[]{0x000000004000E002L});
    public static final BitSet FOLLOW_15_in_rulePrimaryExpression830 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleName_in_rulePrimaryExpression857 = new BitSet(new long[]{0x000000004000E002L});
    public static final BitSet FOLLOW_ruleIndex_in_rulePrimaryExpression898 = new BitSet(new long[]{0x000000004000E002L});
    public static final BitSet FOLLOW_ruleBaseExpression_in_entryRuleBaseExpression937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBaseExpression947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_ruleBaseExpression997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralExpression_in_ruleBaseExpression1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThisExpression_in_ruleBaseExpression1057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperInvocationExpression_in_ruleBaseExpression1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceCreationOrSequenceConstructionExpression_in_ruleBaseExpression1117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassExtentExpression_in_ruleBaseExpression1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkOperationExpression_in_ruleBaseExpression1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_ruleBaseExpression1207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameExpression_in_ruleBaseExpression1237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_ruleBaseExpression1267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralExpression_in_entryRuleLiteralExpression1302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralExpression1312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralExpression_in_ruleLiteralExpression1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNaturalLiteralExpression_in_ruleLiteralExpression1392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralExpression_in_ruleLiteralExpression1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnboundedLiteralExpression_in_ruleLiteralExpression1452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralExpression_in_ruleLiteralExpression1482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralExpression_in_entryRuleBooleanLiteralExpression1517 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpression1527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_VALUE_in_ruleBooleanLiteralExpression1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNaturalLiteralExpression_in_entryRuleNaturalLiteralExpression1608 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNaturalLiteralExpression1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NATURAL_VALUE_in_ruleNaturalLiteralExpression1659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealLiteralExpression_in_entryRuleRealLiteralExpression1699 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealLiteralExpression1709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REAL_VALUE_in_ruleRealLiteralExpression1750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnboundedLiteralExpression_in_entryRuleUnboundedLiteralExpression1790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnboundedLiteralExpression1800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleUnboundedLiteralExpression1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralExpression_in_entryRuleStringLiteralExpression1904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpression1914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteralExpression1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameExpression_in_entryRuleNameExpression1995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameExpression2005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleNameExpression2056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleThisExpression_in_entryRuleThisExpression2091 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleThisExpression2101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleThisExpression2151 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleThisExpression2172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleThisExpression2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParenthesizedExpression_in_entryRuleParenthesizedExpression2241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParenthesizedExpression2251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleParenthesizedExpression2288 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleParenthesizedExpression2313 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleParenthesizedExpression2324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyAccessExpression_in_entryRulePropertyAccessExpression2360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyAccessExpression2370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePropertyAccessExpression2416 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePropertyAccessExpression2428 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleName_in_rulePropertyAccessExpression2455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuple_in_entryRuleTuple2491 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuple2501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleTuple2551 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTuple2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleTuple2583 = new BitSet(new long[]{0x0000006712CF03F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleNamedTupleExpressionList_in_ruleTuple2609 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleTuple2639 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTuple2651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionList_in_entryRuleExpressionList2688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionList2698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList2757 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleExpressionList2770 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionList2791 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleNamedTupleExpressionList_in_entryRuleNamedTupleExpressionList2831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedTupleExpressionList2841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedExpression_in_ruleNamedTupleExpressionList2887 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleNamedTupleExpressionList2900 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleNamedExpression_in_ruleNamedTupleExpressionList2921 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleNamedExpression_in_entryRuleNamedExpression2959 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedExpression2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleNamedExpression3015 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleNamedExpression3027 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNamedExpression3048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuperInvocationExpression_in_entryRuleSuperInvocationExpression3084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuperInvocationExpression3094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleSuperInvocationExpression3131 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_14_in_ruleSuperInvocationExpression3144 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuperInvocationExpression3171 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleSuperInvocationExpression3194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceCreationOrSequenceConstructionExpression_in_entryRuleInstanceCreationOrSequenceConstructionExpression3230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceCreationOrSequenceConstructionExpression3240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleInstanceCreationOrSequenceConstructionExpression3289 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleInstanceCreationOrSequenceConstructionExpression3316 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleInstanceCreationOrSequenceConstructionExpression3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLinkOperationExpression_in_entryRuleLinkOperationExpression3373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLinkOperationExpression3383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleLinkOperationExpression3435 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleLinkOperationExpression3447 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleLinkOperation_in_ruleLinkOperationExpression3468 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleLinkOperationExpression3489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassExtentExpression_in_entryRuleClassExtentExpression3525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassExtentExpression3535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleClassExtentExpression3587 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleClassExtentExpression3599 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleClassExtentExpression3611 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleClassExtentExpression3623 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleClassExtentExpression3635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullExpression_in_entryRuleNullExpression3671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullExpression3681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleNullExpression3730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralExpression_in_entryRuleCollectionLiteralExpression3766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpression3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionType_in_ruleCollectionLiteralExpression3835 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleCollectionLiteralExpression3847 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTypeDeclaration_in_ruleCollectionLiteralExpression3868 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleCollectionLiteralExpression3880 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleCollectionLiteralExpression3894 = new BitSet(new long[]{0x0000006732C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpressionList_in_ruleCollectionLiteralExpression3915 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleCollectionLiteralExpression3928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDeclaration_in_entryRuleTypeDeclaration3964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeDeclaration3974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTypeDeclaration4025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIndex_in_entryRuleIndex4060 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIndex4070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleIndex4107 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIndex4132 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleIndex4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixExpression_in_entryRulePrefixExpression4179 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrefixExpression4189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAffixOperator_in_rulePrefixExpression4247 = new BitSet(new long[]{0x0000000012C703F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleLeftHandSide_in_rulePrefixExpression4268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_entryRuleUnaryExpression4304 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnaryExpression4314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixOrCastExpression_in_ruleUnaryExpression4364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonPostfixNonCastUnaryExpression_in_ruleUnaryExpression4394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixExpression_in_ruleUnaryExpression4424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixOrCastExpression_in_entryRulePostfixOrCastExpression4459 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixOrCastExpression4469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_rulePostfixOrCastExpression4519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCastExpression_in_rulePostfixOrCastExpression4549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rulePostfixOrCastExpression4579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_entryRulePostfixExpression4614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePostfixExpression4624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLeftHandSide_in_rulePostfixExpression4682 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleAffixOperator_in_rulePostfixExpression4703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonPostfixNonCastUnaryExpression_in_entryRuleNonPostfixNonCastUnaryExpression4739 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonPostfixNonCastUnaryExpression4749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericUnaryExpression_in_ruleNonPostfixNonCastUnaryExpression4799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanUnaryExpression_in_ruleNonPostfixNonCastUnaryExpression4829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitStringUnaryExpression_in_ruleNonPostfixNonCastUnaryExpression4859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsolationExpression_in_ruleNonPostfixNonCastUnaryExpression4889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanUnaryExpression_in_entryRuleBooleanUnaryExpression4924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanUnaryExpression4934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleBooleanUnaryExpression4977 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleBooleanUnaryExpression5011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitStringUnaryExpression_in_entryRuleBitStringUnaryExpression5047 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBitStringUnaryExpression5057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleBitStringUnaryExpression5100 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleBitStringUnaryExpression5134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericUnaryExpression_in_entryRuleNumericUnaryExpression5170 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericUnaryExpression5180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericUnaryOperator_in_ruleNumericUnaryExpression5227 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_rulePostfixOrCastExpression_in_ruleNumericUnaryExpression5250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonPostfixNonCastUnaryExpression_in_ruleNumericUnaryExpression5269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericUnaryOperator_in_ruleNumericUnaryExpression5301 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleNumericUnaryExpression5313 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_rulePrefixExpression_in_ruleNumericUnaryExpression5334 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleNumericUnaryExpression5346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsolationExpression_in_entryRuleIsolationExpression5383 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIsolationExpression5393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleIsolationExpression5436 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleIsolationExpression5470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCastExpression_in_entryRuleCastExpression5506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCastExpression5516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleCastExpression5553 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTypeDeclaration_in_ruleCastExpression5574 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleCastExpression5586 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_ruleCastCompletion_in_ruleCastExpression5607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCastCompletion_in_entryRuleCastCompletion5643 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCastCompletion5653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixOrCastExpression_in_ruleCastCompletion5703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanUnaryExpression_in_ruleCastCompletion5733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBitStringUnaryExpression_in_ruleCastCompletion5763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsolationExpression_in_ruleCastCompletion5793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_entryRuleMultiplicativeExpression5828 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeExpression5838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression5888 = new BitSet(new long[]{0x0000001800010002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_ruleMultiplicativeExpression5921 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleUnaryExpression_in_ruleMultiplicativeExpression5942 = new BitSet(new long[]{0x0000001800010002L});
    public static final BitSet FOLLOW_ruleMultiplicativeOperator_in_entryRuleMultiplicativeOperator5981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicativeOperator5992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleMultiplicativeOperator6030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleMultiplicativeOperator6049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleMultiplicativeOperator6068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_entryRuleAdditiveExpression6108 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveExpression6118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6168 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_ruleAdditiveExpression6201 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleMultiplicativeExpression_in_ruleAdditiveExpression6222 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_ruleAdditiveOperator_in_entryRuleAdditiveOperator6261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdditiveOperator6272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleAdditiveOperator6310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleAdditiveOperator6329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_entryRuleShiftExpression6369 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShiftExpression6379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression6429 = new BitSet(new long[]{0x0000000000000002L,0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleShiftOperator_in_ruleShiftExpression6462 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleAdditiveExpression_in_ruleShiftExpression6483 = new BitSet(new long[]{0x0000000000000002L,0x00000000000001C0L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_entryRuleRelationalExpression6521 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationalExpression6531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleRelationalExpression6581 = new BitSet(new long[]{0x000000000C000002L,0x0000000000000600L});
    public static final BitSet FOLLOW_ruleRelationalOperator_in_ruleRelationalExpression6614 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleShiftExpression_in_ruleRelationalExpression6635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassificationExpression_in_entryRuleClassificationExpression6673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassificationExpression6683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationalExpression_in_ruleClassificationExpression6733 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001800L});
    public static final BitSet FOLLOW_ruleClassificationOperator_in_ruleClassificationExpression6766 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleClassificationExpression6793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_entryRuleEqualityExpression6831 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEqualityExpression6841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassificationExpression_in_ruleEqualityExpression6891 = new BitSet(new long[]{0x0000000000000002L,0x0000000000006000L});
    public static final BitSet FOLLOW_ruleEqualityOperator_in_ruleEqualityExpression6924 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleClassificationExpression_in_ruleEqualityExpression6945 = new BitSet(new long[]{0x0000000000000002L,0x0000000000006000L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression6983 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression6993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndExpression7043 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleAndExpression7073 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleEqualityExpression_in_ruleAndExpression7107 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_ruleExclusiveOrExpression_in_entryRuleExclusiveOrExpression7145 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExclusiveOrExpression7155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleExclusiveOrExpression7205 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_40_in_ruleExclusiveOrExpression7235 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleExclusiveOrExpression7269 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_ruleInclusiveOrExpression_in_entryRuleInclusiveOrExpression7307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInclusiveOrExpression7317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExclusiveOrExpression_in_ruleInclusiveOrExpression7367 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleInclusiveOrExpression7397 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExclusiveOrExpression_in_ruleInclusiveOrExpression7431 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleConditionalAndExpression_in_entryRuleConditionalAndExpression7469 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalAndExpression7479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInclusiveOrExpression_in_ruleConditionalAndExpression7529 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleConditionalAndExpression7559 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleInclusiveOrExpression_in_ruleConditionalAndExpression7593 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleConditionalOrExpression_in_entryRuleConditionalOrExpression7631 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalOrExpression7641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalAndExpression_in_ruleConditionalOrExpression7691 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleConditionalOrExpression7721 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleConditionalAndExpression_in_ruleConditionalOrExpression7755 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_entryRuleConditionalExpression7793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalExpression7803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalOrExpression_in_ruleConditionalExpression7853 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_ruleConditionalExpression7877 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalExpression7898 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleConditionalExpression7910 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleConditionalExpression_in_ruleConditionalExpression7931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_entryRuleAssignmentExpression7969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignmentExpression7979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLeftHandSide_in_ruleAssignmentExpression8025 = new BitSet(new long[]{0x0000800000000000L,0x0000000003FF8000L});
    public static final BitSet FOLLOW_ruleAssignmentOperator_in_ruleAssignmentExpression8046 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssignmentExpression8067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLeftHandSide_in_entryRuleLeftHandSide8103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLeftHandSide8113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameLeftHandSide_in_ruleLeftHandSide8163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureLeftHandSide_in_ruleLeftHandSide8193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameLeftHandSide_in_entryRuleNameLeftHandSide8228 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameLeftHandSide8238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameExpression_in_ruleNameLeftHandSide8284 = new BitSet(new long[]{0x000000004000E002L});
    public static final BitSet FOLLOW_ruleIndex_in_ruleNameLeftHandSide8305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureLeftHandSide_in_entryRuleFeatureLeftHandSide8342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureLeftHandSide8352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyAccessExpression_in_ruleFeatureLeftHandSide8397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement8432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement8442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleStatement_in_ruleStatement8493 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleStatement8504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockStatement_in_ruleStatement8536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_ruleStatement8566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchStatement_in_ruleStatement8596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhileStatement_in_ruleStatement8626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForStatement_in_ruleStatement8656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForEachStatement_in_ruleStatement8686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoStatement_in_ruleStatement8716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBreakStatement_in_ruleStatement8746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_ruleStatement8776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassifyStatement_in_ruleStatement8806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSendSignalStatement_in_ruleStatement8836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleStatement_in_entryRuleSimpleStatement8871 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleStatement8881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalNameDeclarationStatement_in_ruleSimpleStatement8931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_ruleSimpleStatement8961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyStatement_in_ruleSimpleStatement8991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock9026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlock9036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleBlock9085 = new BitSet(new long[]{0x4FC9006732C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleStatement_in_ruleBlock9106 = new BitSet(new long[]{0x4FC9006732C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_29_in_ruleBlock9119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockStatement_in_entryRuleBlockStatement9155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBlockStatement9165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleBlockStatement9214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEmptyStatement_in_entryRuleEmptyStatement9248 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEmptyStatement9258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityIndicator_in_entryRuleMultiplicityIndicator9330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityIndicator9341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleMultiplicityIndicator9379 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleMultiplicityIndicator9392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_entryRuleVariableDeclaration9432 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDeclaration9442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeDeclaration_in_ruleVariableDeclaration9500 = new BitSet(new long[]{0x0000000040000030L});
    public static final BitSet FOLLOW_ruleMultiplicityIndicator_in_ruleVariableDeclaration9521 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleName_in_ruleVariableDeclaration9543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLocalNameDeclarationStatement_in_entryRuleLocalNameDeclarationStatement9579 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLocalNameDeclarationStatement9589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDeclaration_in_ruleLocalNameDeclarationStatement9635 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleLocalNameDeclarationStatement9647 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleInitializationExpression_in_ruleLocalNameDeclarationStatement9668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitializationExpression_in_entryRuleInitializationExpression9704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitializationExpression9714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleInitializationExpression9764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceInitializationExpression_in_ruleInitializationExpression9794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceInitializationExpression_in_entryRuleInstanceInitializationExpression9829 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceInitializationExpression9839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleInstanceInitializationExpression9876 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleTuple_in_ruleInstanceInitializationExpression9897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionStatement_in_entryRuleExpressionStatement9933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressionStatement9943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExpressionStatement9988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfStatement_in_entryRuleIfStatement10023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfStatement10033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleIfStatement10070 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleConcurrentClauses_in_ruleIfStatement10091 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleIfStatement10104 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleIfStatement10116 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleConcurrentClauses_in_ruleIfStatement10137 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleIfStatement10152 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleIfStatement10173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcurrentClauses_in_entryRuleConcurrentClauses10211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcurrentClauses10221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonFinalClause_in_ruleConcurrentClauses10267 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_ruleConcurrentClauses10280 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_48_in_ruleConcurrentClauses10292 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleNonFinalClause_in_ruleConcurrentClauses10313 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_ruleNonFinalClause_in_entryRuleNonFinalClause10351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonFinalClause10361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleNonFinalClause10398 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleNonFinalClause10419 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleNonFinalClause10431 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleNonFinalClause10452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchStatement_in_entryRuleSwitchStatement10488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchStatement10498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleSwitchStatement10535 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleSwitchStatement10547 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchStatement10568 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleSwitchStatement10580 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleSwitchStatement10592 = new BitSet(new long[]{0x0030000020000000L});
    public static final BitSet FOLLOW_ruleSwitchClause_in_ruleSwitchStatement10613 = new BitSet(new long[]{0x0030000020000000L});
    public static final BitSet FOLLOW_ruleSwitchDefaultClause_in_ruleSwitchStatement10635 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleSwitchStatement10648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchClause_in_entryRuleSwitchClause10684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchClause10694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchCase_in_ruleSwitchClause10740 = new BitSet(new long[]{0x4FD9006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleSwitchCase_in_ruleSwitchClause10761 = new BitSet(new long[]{0x4FD9006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleNonEmptyStatementSequence_in_ruleSwitchClause10783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchCase_in_entryRuleSwitchCase10819 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchCase10829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSwitchCase10866 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSwitchCase10891 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleSwitchCase10902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSwitchDefaultClause_in_entryRuleSwitchDefaultClause10938 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSwitchDefaultClause10948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleSwitchDefaultClause10985 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleSwitchDefaultClause10997 = new BitSet(new long[]{0x4FD9006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleNonEmptyStatementSequence_in_ruleSwitchDefaultClause11022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonEmptyStatementSequence_in_entryRuleNonEmptyStatementSequence11057 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNonEmptyStatementSequence11067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleNonEmptyStatementSequence11112 = new BitSet(new long[]{0x4FC9006712C703F2L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleWhileStatement_in_entryRuleWhileStatement11148 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhileStatement11158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleWhileStatement11195 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleWhileStatement11207 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleWhileStatement11228 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleWhileStatement11240 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleWhileStatement11261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDoStatement_in_entryRuleDoStatement11297 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDoStatement11307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleDoStatement11344 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleDoStatement11365 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleDoStatement11377 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleDoStatement11389 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleDoStatement11410 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleDoStatement11422 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleDoStatement11434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForStatement_in_entryRuleForStatement11470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForStatement11480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleForStatement11517 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleForStatement11529 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleSimpleStatement_in_ruleForStatement11550 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleForStatement11562 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleForStatement11583 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleForStatement11595 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleSimpleStatement_in_ruleForStatement11616 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleForStatement11628 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleForStatement11649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForEachStatement_in_entryRuleForEachStatement11685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForEachStatement11695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleForEachStatement11732 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleForEachStatement11744 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleLoopVariableDefinition_in_ruleForEachStatement11765 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleForEachStatement11777 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ruleBlock_in_ruleForEachStatement11798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLoopVariableDefinition_in_entryRuleLoopVariableDefinition11834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLoopVariableDefinition11844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleName_in_ruleLoopVariableDefinition11903 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleTypeDeclaration_in_ruleLoopVariableDefinition11931 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleName_in_ruleLoopVariableDefinition11952 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleLoopVariableDefinition11966 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLoopVariableDefinition11987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBreakStatement_in_entryRuleBreakStatement12023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBreakStatement12033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleBreakStatement12082 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleBreakStatement12094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReturnStatement_in_entryRuleReturnStatement12130 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReturnStatement12140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleReturnStatement12189 = new BitSet(new long[]{0x0000406712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleReturnStatement12210 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleReturnStatement12223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassifyStatement_in_entryRuleClassifyStatement12259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassifyStatement12269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleClassifyStatement12306 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleClassifyStatement12327 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_ruleClassificationFromClause_in_ruleClassifyStatement12350 = new BitSet(new long[]{0x3000400000000000L});
    public static final BitSet FOLLOW_ruleClassificationToClause_in_ruleClassifyStatement12371 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ruleReclassifyAllClause_in_ruleClassifyStatement12401 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_ruleClassificationToClause_in_ruleClassifyStatement12423 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleClassifyStatement12437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassificationFromClause_in_entryRuleClassificationFromClause12473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassificationFromClause12483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleClassificationFromClause12520 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQualifiedNameList_in_ruleClassificationFromClause12545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassificationToClause_in_entryRuleClassificationToClause12580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassificationToClause12590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleClassificationToClause12627 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQualifiedNameList_in_ruleClassificationToClause12652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReclassifyAllClause_in_entryRuleReclassifyAllClause12688 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReclassifyAllClause12699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleReclassifyAllClause12737 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleReclassifyAllClause12750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameList_in_entryRuleQualifiedNameList12790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameList12800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameList12846 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleQualifiedNameList12859 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameList12880 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleSendSignalStatement_in_entryRuleSendSignalStatement12918 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSendSignalStatement12928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleSendSignalStatement12977 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSendSignalStatement12998 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleSendSignalStatement13010 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000003EL});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSendSignalStatement13031 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_ruleSendSignalStatement13043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleLinkOperation13093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleLinkOperation13110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleCollectionType13155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleCollectionType13172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleCollectionType13189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleAffixOperator13234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleAffixOperator13251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleNumericUnaryOperator13296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleNumericUnaryOperator13313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleShiftOperator13358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleShiftOperator13375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleShiftOperator13392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleRelationalOperator13437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleRelationalOperator13454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleRelationalOperator13471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleRelationalOperator13488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_ruleClassificationOperator13533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_ruleClassificationOperator13550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_ruleEqualityOperator13595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleEqualityOperator13612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleAssignmentOperator13657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleAssignmentOperator13674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleAssignmentOperator13691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleAssignmentOperator13708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleAssignmentOperator13725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleAssignmentOperator13742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleAssignmentOperator13759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_ruleAssignmentOperator13776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_ruleAssignmentOperator13793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_ruleAssignmentOperator13810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleAssignmentOperator13827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_ruleAssignmentOperator13844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_synpred3_InternalReducedAlfLanguage373 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleName_in_synpred3_InternalReducedAlfLanguage395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignmentExpression_in_synpred4_InternalReducedAlfLanguage502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_synpred7_InternalReducedAlfLanguage771 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleName_in_synpred7_InternalReducedAlfLanguage798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_synpred24_InternalReducedAlfLanguage2551 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_synpred24_InternalReducedAlfLanguage2563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressionList_in_synpred31_InternalReducedAlfLanguage3915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePostfixExpression_in_synpred34_InternalReducedAlfLanguage4519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCastExpression_in_synpred35_InternalReducedAlfLanguage4549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericUnaryOperator_in_synpred40_InternalReducedAlfLanguage5227 = new BitSet(new long[]{0x0000006712C703F0L,0x000000000000000EL});
    public static final BitSet FOLLOW_rulePostfixOrCastExpression_in_synpred40_InternalReducedAlfLanguage5250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNonPostfixNonCastUnaryExpression_in_synpred40_InternalReducedAlfLanguage5269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameLeftHandSide_in_synpred59_InternalReducedAlfLanguage8163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleStatement_in_synpred61_InternalReducedAlfLanguage8493 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_synpred61_InternalReducedAlfLanguage8504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlockStatement_in_synpred62_InternalReducedAlfLanguage8536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForStatement_in_synpred66_InternalReducedAlfLanguage8656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForEachStatement_in_synpred67_InternalReducedAlfLanguage8686 = new BitSet(new long[]{0x0000000000000002L});

}