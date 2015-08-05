package com.incquerylabs.uml.ralf.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReducedAlfLanguageLexer extends Lexer {
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

    public InternalReducedAlfLanguageLexer() {;} 
    public InternalReducedAlfLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalReducedAlfLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g"; }

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:11:7: ( '::' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:11:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:12:7: ( '.' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:12:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:13:7: ( '->' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:13:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:14:7: ( '*' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:14:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:15:7: ( 'this' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:15:9: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:16:7: ( '(' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:16:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:17:7: ( ')' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:17:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:18:7: ( ',' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:18:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:19:7: ( '=>' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:19:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:20:7: ( 'super' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:20:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:21:7: ( 'new' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:21:9: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:22:7: ( 'instances' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:22:9: 'instances'
            {
            match("instances"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:23:7: ( 'null' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:23:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:24:7: ( '<' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:24:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:25:7: ( '>' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:25:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:26:7: ( '{' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:26:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:27:7: ( '}' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:27:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:28:7: ( '[' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:28:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:29:7: ( ']' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:29:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:30:7: ( '!' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:30:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:31:7: ( '~' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:31:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:32:7: ( '$' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:32:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:33:7: ( '/' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:33:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:34:7: ( '%' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:34:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:35:7: ( '+' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:35:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:36:7: ( '-' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:36:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:37:7: ( '&' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:37:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:38:7: ( '^' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:38:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:39:7: ( '|' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:39:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:40:7: ( '&&' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:40:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:41:7: ( '||' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:41:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:42:7: ( '?' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:42:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:43:7: ( ':' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:43:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:44:7: ( ';' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:44:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:45:7: ( '=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:45:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:46:7: ( 'if' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:46:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:47:7: ( 'else' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:47:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:48:7: ( 'or' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:48:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:49:7: ( 'switch' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:49:9: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:50:7: ( 'case' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:50:9: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:51:7: ( 'default' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:51:9: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:52:7: ( 'while' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:52:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:53:7: ( 'do' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:53:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:54:7: ( 'for' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:54:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:55:7: ( 'break' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:55:9: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:56:7: ( 'return' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:56:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:57:7: ( 'classify' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:57:9: 'classify'
            {
            match("classify"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:58:7: ( 'from' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:58:9: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:59:7: ( 'to' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:59:9: 'to'
            {
            match("to"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:60:7: ( 'send' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:60:9: 'send'
            {
            match("send"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:61:7: ( 'link' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:61:9: 'link'
            {
            match("link"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:62:7: ( 'unlink' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:62:9: 'unlink'
            {
            match("unlink"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:63:7: ( 'set' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:63:9: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:64:7: ( 'bag' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:64:9: 'bag'
            {
            match("bag"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:65:7: ( 'sequence' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:65:9: 'sequence'
            {
            match("sequence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:66:7: ( '++' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:66:9: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:67:7: ( '--' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:67:9: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:68:7: ( '>>' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:68:9: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:69:7: ( '<<' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:69:9: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:70:7: ( '>>>' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:70:9: '>>>'
            {
            match(">>>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:71:7: ( '>=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:71:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:72:7: ( '<=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:72:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:73:7: ( 'instanceof' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:73:9: 'instanceof'
            {
            match("instanceof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:74:7: ( 'hastype' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:74:9: 'hastype'
            {
            match("hastype"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:75:7: ( '==' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:75:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:76:7: ( '!=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:76:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:77:7: ( '+=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:77:9: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:78:7: ( '-=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:78:9: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:79:7: ( '*=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:79:9: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:80:7: ( '/=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:80:9: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:81:7: ( '%=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:81:9: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:82:7: ( '&=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:82:9: '&='
            {
            match("&="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:83:7: ( '|=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:83:9: '|='
            {
            match("|="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:84:7: ( '^=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:84:9: '^='
            {
            match("^="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:85:7: ( '<<=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:85:9: '<<='
            {
            match("<<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:86:7: ( '>>=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:86:9: '>>='
            {
            match(">>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:87:7: ( '>>>=' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:87:9: '>>>='
            {
            match(">>>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "RULE_BOOLEAN_VALUE"
    public final void mRULE_BOOLEAN_VALUE() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6111:20: ( ( 'true' | 'false' ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6111:22: ( 'true' | 'false' )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6111:22: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6111:23: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6111:30: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN_VALUE"

    // $ANTLR start "RULE_NATURAL_VALUE"
    public final void mRULE_NATURAL_VALUE() throws RecognitionException {
        try {
            int _type = RULE_NATURAL_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:20: ( ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* ) )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:22: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) | ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )* | ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )* | '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )* )
            int alt14=4;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='0') ) {
                switch ( input.LA(2) ) {
                case 'B':
                case 'b':
                    {
                    alt14=2;
                    }
                    break;
                case 'X':
                case 'x':
                    {
                    alt14=3;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '_':
                    {
                    alt14=4;
                    }
                    break;
                default:
                    alt14=1;}

            }
            else if ( ((LA14_0>='1' && LA14_0<='9')) ) {
                alt14=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:23: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='0') ) {
                        alt4=1;
                    }
                    else if ( ((LA4_0>='1' && LA4_0<='9')) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:24: '0'
                            {
                            match('0'); 

                            }
                            break;
                        case 2 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:28: '1' .. '9' ( ( '_' )? '0' .. '9' )*
                            {
                            matchRange('1','9'); 
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:37: ( ( '_' )? '0' .. '9' )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( ((LA3_0>='0' && LA3_0<='9')||LA3_0=='_') ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:38: ( '_' )? '0' .. '9'
                            	    {
                            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:38: ( '_' )?
                            	    int alt2=2;
                            	    int LA2_0 = input.LA(1);

                            	    if ( (LA2_0=='_') ) {
                            	        alt2=1;
                            	    }
                            	    switch (alt2) {
                            	        case 1 :
                            	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:38: '_'
                            	            {
                            	            match('_'); 

                            	            }
                            	            break;

                            	    }

                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:55: ( '0b' | '0B' ) '0' .. '1' ( ( '_' )? '0' .. '1' )*
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:55: ( '0b' | '0B' )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='0') ) {
                        int LA5_1 = input.LA(2);

                        if ( (LA5_1=='b') ) {
                            alt5=1;
                        }
                        else if ( (LA5_1=='B') ) {
                            alt5=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 5, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;
                    }
                    switch (alt5) {
                        case 1 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:56: '0b'
                            {
                            match("0b"); 


                            }
                            break;
                        case 2 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:61: '0B'
                            {
                            match("0B"); 


                            }
                            break;

                    }

                    matchRange('0','1'); 
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:76: ( ( '_' )? '0' .. '1' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='1')||LA7_0=='_') ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:77: ( '_' )? '0' .. '1'
                    	    {
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:77: ( '_' )?
                    	    int alt6=2;
                    	    int LA6_0 = input.LA(1);

                    	    if ( (LA6_0=='_') ) {
                    	        alt6=1;
                    	    }
                    	    switch (alt6) {
                    	        case 1 :
                    	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:77: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','1'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:93: ( '0x' | '0X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:93: ( '0x' | '0X' )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='0') ) {
                        int LA8_1 = input.LA(2);

                        if ( (LA8_1=='x') ) {
                            alt8=1;
                        }
                        else if ( (LA8_1=='X') ) {
                            alt8=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 8, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:94: '0x'
                            {
                            match("0x"); 


                            }
                            break;
                        case 2 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:99: '0X'
                            {
                            match("0X"); 


                            }
                            break;

                    }

                    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:134: ( ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='F')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='f')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:135: ( '_' )? ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )
                    	    {
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:135: ( '_' )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( (LA9_0=='_') ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:135: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;
                case 4 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:171: '0' ( '_' )? '0' .. '7' ( ( '_' )? '0' .. '7' )*
                    {
                    match('0'); 
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:175: ( '_' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='_') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:175: '_'
                            {
                            match('_'); 

                            }
                            break;

                    }

                    matchRange('0','7'); 
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:189: ( ( '_' )? '0' .. '7' )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>='0' && LA13_0<='7')||LA13_0=='_') ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:190: ( '_' )? '0' .. '7'
                    	    {
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:190: ( '_' )?
                    	    int alt12=2;
                    	    int LA12_0 = input.LA(1);

                    	    if ( (LA12_0=='_') ) {
                    	        alt12=1;
                    	    }
                    	    switch (alt12) {
                    	        case 1 :
                    	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6113:190: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','7'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NATURAL_VALUE"

    // $ANTLR start "RULE_REAL_VALUE"
    public final void mRULE_REAL_VALUE() throws RecognitionException {
        try {
            int _type = RULE_REAL_VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:17: ( ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) '.' '0' .. '9' ( ( '_' )? '0' .. '9' )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:19: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* ) '.' '0' .. '9' ( ( '_' )? '0' .. '9' )*
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:19: ( '0' | '1' .. '9' ( ( '_' )? '0' .. '9' )* )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='0') ) {
                alt17=1;
            }
            else if ( ((LA17_0>='1' && LA17_0<='9')) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:20: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:24: '1' .. '9' ( ( '_' )? '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:33: ( ( '_' )? '0' .. '9' )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>='0' && LA16_0<='9')||LA16_0=='_') ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:34: ( '_' )? '0' .. '9'
                    	    {
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:34: ( '_' )?
                    	    int alt15=2;
                    	    int LA15_0 = input.LA(1);

                    	    if ( (LA15_0=='_') ) {
                    	        alt15=1;
                    	    }
                    	    switch (alt15) {
                    	        case 1 :
                    	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:34: '_'
                    	            {
                    	            match('_'); 

                    	            }
                    	            break;

                    	    }

                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            match('.'); 
            matchRange('0','9'); 
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:64: ( ( '_' )? '0' .. '9' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>='0' && LA19_0<='9')||LA19_0=='_') ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:65: ( '_' )? '0' .. '9'
            	    {
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:65: ( '_' )?
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0=='_') ) {
            	        alt18=1;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6115:65: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_REAL_VALUE"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6117:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6117:11: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6117:35: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>='0' && LA20_0<='9')||(LA20_0>='A' && LA20_0<='Z')||LA20_0=='_'||(LA20_0>='a' && LA20_0<='z')) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_UNRESTRICTED_NAME"
    public final void mRULE_UNRESTRICTED_NAME() throws RecognitionException {
        try {
            int _type = RULE_UNRESTRICTED_NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6119:24: ( '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6119:26: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); 
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6119:31: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\\') ) {
                    alt21=1;
                }
                else if ( ((LA21_0>='\u0000' && LA21_0<='&')||(LA21_0>='(' && LA21_0<='[')||(LA21_0>=']' && LA21_0<='\uFFFF')) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6119:32: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6119:73: ~ ( ( '\\\\' | '\\'' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_UNRESTRICTED_NAME"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6121:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6121:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6121:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='\\') ) {
                    alt22=1;
                }
                else if ( ((LA22_0>='\u0000' && LA22_0<='!')||(LA22_0>='#' && LA22_0<='[')||(LA22_0>=']' && LA22_0<='\uFFFF')) ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6121:20: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6121:61: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6123:17: ( '/*' ~ ( ( '*' | '@' ) ) ( options {greedy=false; } : . )* '*/' )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6123:19: '/*' ~ ( ( '*' | '@' ) ) ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            if ( (input.LA(1)>='\u0000' && input.LA(1)<=')')||(input.LA(1)>='+' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6123:37: ( options {greedy=false; } : . )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0=='*') ) {
                    int LA23_1 = input.LA(2);

                    if ( (LA23_1=='/') ) {
                        alt23=2;
                    }
                    else if ( ((LA23_1>='\u0000' && LA23_1<='.')||(LA23_1>='0' && LA23_1<='\uFFFF')) ) {
                        alt23=1;
                    }


                }
                else if ( ((LA23_0>='\u0000' && LA23_0<=')')||(LA23_0>='+' && LA23_0<='\uFFFF')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6123:65: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6125:17: ( '//' (~ ( ( '@' | '\\n' | '\\r' ) ) (~ ( ( '\\n' | '\\r' ) ) )* )? ( ( '\\r' )? '\\n' )? )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6125:19: '//' (~ ( ( '@' | '\\n' | '\\r' ) ) (~ ( ( '\\n' | '\\r' ) ) )* )? ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6125:24: (~ ( ( '@' | '\\n' | '\\r' ) ) (~ ( ( '\\n' | '\\r' ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>='\u0000' && LA25_0<='\t')||(LA25_0>='\u000B' && LA25_0<='\f')||(LA25_0>='\u000E' && LA25_0<='?')||(LA25_0>='A' && LA25_0<='\uFFFF')) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6125:25: ~ ( ( '@' | '\\n' | '\\r' ) ) (~ ( ( '\\n' | '\\r' ) ) )*
                    {
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='?')||(input.LA(1)>='A' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6125:44: (~ ( ( '\\n' | '\\r' ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>='\u0000' && LA24_0<='\t')||(LA24_0>='\u000B' && LA24_0<='\f')||(LA24_0>='\u000E' && LA24_0<='\uFFFF')) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6125:44: ~ ( ( '\\n' | '\\r' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6125:62: ( ( '\\r' )? '\\n' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0=='\n'||LA27_0=='\r') ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6125:63: ( '\\r' )? '\\n'
                    {
                    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6125:63: ( '\\r' )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0=='\r') ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6125:63: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6127:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6127:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:6127:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>='\t' && LA28_0<='\n')||LA28_0=='\r'||LA28_0==' ') ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    public void mTokens() throws RecognitionException {
        // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:8: ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | RULE_BOOLEAN_VALUE | RULE_NATURAL_VALUE | RULE_REAL_VALUE | RULE_ID | RULE_UNRESTRICTED_NAME | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS )
        int alt29=86;
        alt29 = dfa29.predict(input);
        switch (alt29) {
            case 1 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:10: T__13
                {
                mT__13(); 

                }
                break;
            case 2 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:16: T__14
                {
                mT__14(); 

                }
                break;
            case 3 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:22: T__15
                {
                mT__15(); 

                }
                break;
            case 4 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:28: T__16
                {
                mT__16(); 

                }
                break;
            case 5 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:34: T__17
                {
                mT__17(); 

                }
                break;
            case 6 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:40: T__18
                {
                mT__18(); 

                }
                break;
            case 7 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:46: T__19
                {
                mT__19(); 

                }
                break;
            case 8 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:52: T__20
                {
                mT__20(); 

                }
                break;
            case 9 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:58: T__21
                {
                mT__21(); 

                }
                break;
            case 10 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:64: T__22
                {
                mT__22(); 

                }
                break;
            case 11 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:70: T__23
                {
                mT__23(); 

                }
                break;
            case 12 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:76: T__24
                {
                mT__24(); 

                }
                break;
            case 13 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:82: T__25
                {
                mT__25(); 

                }
                break;
            case 14 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:88: T__26
                {
                mT__26(); 

                }
                break;
            case 15 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:94: T__27
                {
                mT__27(); 

                }
                break;
            case 16 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:100: T__28
                {
                mT__28(); 

                }
                break;
            case 17 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:106: T__29
                {
                mT__29(); 

                }
                break;
            case 18 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:112: T__30
                {
                mT__30(); 

                }
                break;
            case 19 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:118: T__31
                {
                mT__31(); 

                }
                break;
            case 20 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:124: T__32
                {
                mT__32(); 

                }
                break;
            case 21 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:130: T__33
                {
                mT__33(); 

                }
                break;
            case 22 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:136: T__34
                {
                mT__34(); 

                }
                break;
            case 23 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:142: T__35
                {
                mT__35(); 

                }
                break;
            case 24 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:148: T__36
                {
                mT__36(); 

                }
                break;
            case 25 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:154: T__37
                {
                mT__37(); 

                }
                break;
            case 26 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:160: T__38
                {
                mT__38(); 

                }
                break;
            case 27 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:166: T__39
                {
                mT__39(); 

                }
                break;
            case 28 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:172: T__40
                {
                mT__40(); 

                }
                break;
            case 29 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:178: T__41
                {
                mT__41(); 

                }
                break;
            case 30 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:184: T__42
                {
                mT__42(); 

                }
                break;
            case 31 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:190: T__43
                {
                mT__43(); 

                }
                break;
            case 32 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:196: T__44
                {
                mT__44(); 

                }
                break;
            case 33 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:202: T__45
                {
                mT__45(); 

                }
                break;
            case 34 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:208: T__46
                {
                mT__46(); 

                }
                break;
            case 35 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:214: T__47
                {
                mT__47(); 

                }
                break;
            case 36 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:220: T__48
                {
                mT__48(); 

                }
                break;
            case 37 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:226: T__49
                {
                mT__49(); 

                }
                break;
            case 38 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:232: T__50
                {
                mT__50(); 

                }
                break;
            case 39 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:238: T__51
                {
                mT__51(); 

                }
                break;
            case 40 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:244: T__52
                {
                mT__52(); 

                }
                break;
            case 41 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:250: T__53
                {
                mT__53(); 

                }
                break;
            case 42 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:256: T__54
                {
                mT__54(); 

                }
                break;
            case 43 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:262: T__55
                {
                mT__55(); 

                }
                break;
            case 44 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:268: T__56
                {
                mT__56(); 

                }
                break;
            case 45 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:274: T__57
                {
                mT__57(); 

                }
                break;
            case 46 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:280: T__58
                {
                mT__58(); 

                }
                break;
            case 47 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:286: T__59
                {
                mT__59(); 

                }
                break;
            case 48 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:292: T__60
                {
                mT__60(); 

                }
                break;
            case 49 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:298: T__61
                {
                mT__61(); 

                }
                break;
            case 50 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:304: T__62
                {
                mT__62(); 

                }
                break;
            case 51 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:310: T__63
                {
                mT__63(); 

                }
                break;
            case 52 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:316: T__64
                {
                mT__64(); 

                }
                break;
            case 53 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:322: T__65
                {
                mT__65(); 

                }
                break;
            case 54 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:328: T__66
                {
                mT__66(); 

                }
                break;
            case 55 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:334: T__67
                {
                mT__67(); 

                }
                break;
            case 56 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:340: T__68
                {
                mT__68(); 

                }
                break;
            case 57 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:346: T__69
                {
                mT__69(); 

                }
                break;
            case 58 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:352: T__70
                {
                mT__70(); 

                }
                break;
            case 59 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:358: T__71
                {
                mT__71(); 

                }
                break;
            case 60 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:364: T__72
                {
                mT__72(); 

                }
                break;
            case 61 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:370: T__73
                {
                mT__73(); 

                }
                break;
            case 62 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:376: T__74
                {
                mT__74(); 

                }
                break;
            case 63 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:382: T__75
                {
                mT__75(); 

                }
                break;
            case 64 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:388: T__76
                {
                mT__76(); 

                }
                break;
            case 65 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:394: T__77
                {
                mT__77(); 

                }
                break;
            case 66 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:400: T__78
                {
                mT__78(); 

                }
                break;
            case 67 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:406: T__79
                {
                mT__79(); 

                }
                break;
            case 68 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:412: T__80
                {
                mT__80(); 

                }
                break;
            case 69 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:418: T__81
                {
                mT__81(); 

                }
                break;
            case 70 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:424: T__82
                {
                mT__82(); 

                }
                break;
            case 71 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:430: T__83
                {
                mT__83(); 

                }
                break;
            case 72 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:436: T__84
                {
                mT__84(); 

                }
                break;
            case 73 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:442: T__85
                {
                mT__85(); 

                }
                break;
            case 74 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:448: T__86
                {
                mT__86(); 

                }
                break;
            case 75 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:454: T__87
                {
                mT__87(); 

                }
                break;
            case 76 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:460: T__88
                {
                mT__88(); 

                }
                break;
            case 77 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:466: T__89
                {
                mT__89(); 

                }
                break;
            case 78 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:472: RULE_BOOLEAN_VALUE
                {
                mRULE_BOOLEAN_VALUE(); 

                }
                break;
            case 79 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:491: RULE_NATURAL_VALUE
                {
                mRULE_NATURAL_VALUE(); 

                }
                break;
            case 80 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:510: RULE_REAL_VALUE
                {
                mRULE_REAL_VALUE(); 

                }
                break;
            case 81 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:526: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 82 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:534: RULE_UNRESTRICTED_NAME
                {
                mRULE_UNRESTRICTED_NAME(); 

                }
                break;
            case 83 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:557: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 84 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:569: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 85 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:585: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 86 :
                // ../com.incquerylabs.uml.ralf/src-gen/com/incquerylabs/uml/ralf/parser/antlr/internal/InternalReducedAlfLanguage.g:1:601: RULE_WS
                {
                mRULE_WS(); 

                }
                break;

        }

    }


    protected DFA29 dfa29 = new DFA29(this);
    static final String DFA29_eotS =
        "\1\uffff\1\60\1\uffff\1\64\1\66\1\53\3\uffff\1\74\3\53\1\106\1"+
        "\111\4\uffff\1\113\2\uffff\1\117\1\121\1\124\1\127\1\131\1\134\2"+
        "\uffff\13\53\2\155\14\uffff\1\53\1\162\1\53\3\uffff\6\53\1\174\1"+
        "\176\2\uffff\1\u0081\25\uffff\1\53\1\u0083\3\53\1\u0087\12\53\3"+
        "\uffff\1\155\1\53\1\uffff\4\53\1\u0097\1\53\1\u0099\2\53\3\uffff"+
        "\1\u009d\2\uffff\1\53\1\uffff\3\53\1\uffff\1\53\1\u00a3\3\53\1\u00a7"+
        "\4\53\1\u00ac\1\u00ad\2\53\1\u00b0\1\uffff\1\53\1\uffff\1\u00b2"+
        "\1\53\2\uffff\1\u00b4\1\u00b5\3\53\1\uffff\1\u00b9\2\53\1\uffff"+
        "\1\53\1\u00bd\2\53\2\uffff\1\u00c0\1\53\1\uffff\1\53\1\uffff\1\53"+
        "\2\uffff\2\53\1\u00c6\1\uffff\1\u00ad\1\u00c7\1\53\1\uffff\2\53"+
        "\1\uffff\1\u00cb\4\53\2\uffff\1\u00d0\1\u00d1\1\53\1\uffff\3\53"+
        "\1\u00d6\2\uffff\1\u00d7\1\u00d8\1\53\1\u00db\3\uffff\1\u00dc\1"+
        "\53\2\uffff\1\u00de\1\uffff";
    static final String DFA29_eofS =
        "\u00df\uffff";
    static final String DFA29_minS =
        "\1\11\1\72\1\uffff\1\55\1\75\1\150\3\uffff\1\75\2\145\1\146\1\74"+
        "\1\75\4\uffff\1\75\2\uffff\1\52\1\75\1\53\1\46\2\75\2\uffff\1\154"+
        "\1\162\1\141\1\145\1\150\2\141\1\145\1\151\1\156\1\141\2\56\14\uffff"+
        "\1\151\1\60\1\165\3\uffff\1\160\1\151\1\156\1\167\1\154\1\163\1"+
        "\60\1\75\2\uffff\1\75\25\uffff\1\163\1\60\1\163\1\141\1\146\1\60"+
        "\1\151\1\162\1\157\1\154\1\145\1\147\1\164\1\156\1\154\1\163\2\uffff"+
        "\1\60\1\56\1\163\1\uffff\2\145\1\164\1\144\1\60\1\165\1\60\1\154"+
        "\1\164\3\uffff\1\75\2\uffff\1\145\1\uffff\1\145\1\163\1\141\1\uffff"+
        "\1\154\1\60\1\155\1\163\1\141\1\60\1\165\1\153\1\151\1\164\2\60"+
        "\1\162\1\143\1\60\1\uffff\1\145\1\uffff\1\60\1\141\2\uffff\2\60"+
        "\1\163\1\165\1\145\1\uffff\1\60\1\145\1\153\1\uffff\1\162\1\60\1"+
        "\156\1\171\2\uffff\1\60\1\150\1\uffff\1\156\1\uffff\1\156\2\uffff"+
        "\1\151\1\154\1\60\1\uffff\2\60\1\156\1\uffff\1\153\1\160\1\uffff"+
        "\1\60\2\143\1\146\1\164\2\uffff\2\60\1\145\1\uffff\2\145\1\171\1"+
        "\60\2\uffff\2\60\1\157\1\60\3\uffff\1\60\1\146\2\uffff\1\60\1\uffff";
    static final String DFA29_maxS =
        "\1\176\1\72\1\uffff\1\76\1\75\1\162\3\uffff\1\76\1\167\1\165\1"+
        "\156\1\75\1\76\4\uffff\1\75\2\uffff\5\75\1\174\2\uffff\1\154\1\162"+
        "\1\154\1\157\1\150\2\162\1\145\1\151\1\156\1\141\1\56\1\137\14\uffff"+
        "\1\151\1\172\1\165\3\uffff\1\160\1\151\1\164\1\167\1\154\1\163\1"+
        "\172\1\75\2\uffff\1\76\25\uffff\1\163\1\172\1\163\1\141\1\146\1"+
        "\172\1\151\1\162\1\157\1\154\1\145\1\147\1\164\1\156\1\154\1\163"+
        "\2\uffff\1\71\1\137\1\163\1\uffff\2\145\1\164\1\144\1\172\1\165"+
        "\1\172\1\154\1\164\3\uffff\1\75\2\uffff\1\145\1\uffff\1\145\1\163"+
        "\1\141\1\uffff\1\154\1\172\1\155\1\163\1\141\1\172\1\165\1\153\1"+
        "\151\1\164\2\172\1\162\1\143\1\172\1\uffff\1\145\1\uffff\1\172\1"+
        "\141\2\uffff\2\172\1\163\1\165\1\145\1\uffff\1\172\1\145\1\153\1"+
        "\uffff\1\162\1\172\1\156\1\171\2\uffff\1\172\1\150\1\uffff\1\156"+
        "\1\uffff\1\156\2\uffff\1\151\1\154\1\172\1\uffff\2\172\1\156\1\uffff"+
        "\1\153\1\160\1\uffff\1\172\2\143\1\146\1\164\2\uffff\2\172\1\145"+
        "\1\uffff\2\145\1\171\1\172\2\uffff\2\172\1\163\1\172\3\uffff\1\172"+
        "\1\146\2\uffff\1\172\1\uffff";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\3\uffff\1\6\1\7\1\10\6\uffff\1\20\1\21\1\22\1\23\1"+
        "\uffff\1\25\1\26\6\uffff\1\40\1\42\15\uffff\1\121\1\122\1\123\1"+
        "\126\1\1\1\41\1\3\1\71\1\104\1\32\1\105\1\4\3\uffff\1\11\1\101\1"+
        "\43\10\uffff\1\76\1\16\1\uffff\1\75\1\17\1\102\1\24\1\106\1\124"+
        "\1\125\1\27\1\107\1\30\1\70\1\103\1\31\1\36\1\110\1\33\1\112\1\34"+
        "\1\37\1\111\1\35\20\uffff\1\117\1\120\3\uffff\1\61\11\uffff\1\44"+
        "\1\113\1\73\1\uffff\1\114\1\72\1\uffff\1\46\3\uffff\1\53\17\uffff"+
        "\1\65\1\uffff\1\13\2\uffff\1\115\1\74\5\uffff\1\54\3\uffff\1\66"+
        "\4\uffff\1\5\1\116\2\uffff\1\62\1\uffff\1\15\1\uffff\1\45\1\50\3"+
        "\uffff\1\60\3\uffff\1\63\2\uffff\1\12\5\uffff\1\52\1\55\3\uffff"+
        "\1\47\4\uffff\1\56\1\64\4\uffff\1\51\1\100\1\67\2\uffff\1\57\1\14"+
        "\1\uffff\1\77";
    static final String DFA29_specialS =
        "\u00df\uffff}>";
    static final String[] DFA29_transitionS = {
            "\2\56\2\uffff\1\56\22\uffff\1\56\1\23\1\55\1\uffff\1\25\1\27"+
            "\1\31\1\54\1\6\1\7\1\4\1\30\1\10\1\3\1\2\1\26\1\51\11\52\1\1"+
            "\1\35\1\15\1\11\1\16\1\34\1\uffff\32\53\1\21\1\uffff\1\22\1"+
            "\32\1\53\1\uffff\1\53\1\44\1\40\1\41\1\36\1\43\1\53\1\50\1\14"+
            "\2\53\1\46\1\53\1\13\1\37\2\53\1\45\1\12\1\5\1\47\1\53\1\42"+
            "\3\53\1\17\1\33\1\20\1\24",
            "\1\57",
            "",
            "\1\62\17\uffff\1\63\1\61",
            "\1\65",
            "\1\67\6\uffff\1\70\2\uffff\1\71",
            "",
            "",
            "",
            "\1\73\1\72",
            "\1\77\17\uffff\1\75\1\uffff\1\76",
            "\1\100\17\uffff\1\101",
            "\1\103\7\uffff\1\102",
            "\1\104\1\105",
            "\1\110\1\107",
            "",
            "",
            "",
            "",
            "\1\112",
            "",
            "",
            "\1\115\4\uffff\1\116\15\uffff\1\114",
            "\1\120",
            "\1\122\21\uffff\1\123",
            "\1\125\26\uffff\1\126",
            "\1\130",
            "\1\133\76\uffff\1\132",
            "",
            "",
            "\1\135",
            "\1\136",
            "\1\137\12\uffff\1\140",
            "\1\141\11\uffff\1\142",
            "\1\143",
            "\1\146\15\uffff\1\144\2\uffff\1\145",
            "\1\150\20\uffff\1\147",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\156",
            "\1\156\1\uffff\12\160\45\uffff\1\157",
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
            "\1\161",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\163",
            "",
            "",
            "",
            "\1\164",
            "\1\165",
            "\1\166\2\uffff\1\170\2\uffff\1\167",
            "\1\171",
            "\1\172",
            "\1\173",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\175",
            "",
            "",
            "\1\u0080\1\177",
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
            "\1\u0082",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "",
            "",
            "\12\160",
            "\1\156\1\uffff\12\160\45\uffff\1\157",
            "\1\u0092",
            "",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u0098",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u009a",
            "\1\u009b",
            "",
            "",
            "",
            "\1\u009c",
            "",
            "",
            "\1\u009e",
            "",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "",
            "\1\u00a2",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00ae",
            "\1\u00af",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\1\u00b1",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00b3",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00ba",
            "\1\u00bb",
            "",
            "\1\u00bc",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00be",
            "\1\u00bf",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00c1",
            "",
            "\1\u00c2",
            "",
            "\1\u00c3",
            "",
            "",
            "\1\u00c4",
            "\1\u00c5",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00c8",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00d2",
            "",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00da\3\uffff\1\u00d9",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            "\1\u00dd",
            "",
            "",
            "\12\53\7\uffff\32\53\4\uffff\1\53\1\uffff\32\53",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | RULE_BOOLEAN_VALUE | RULE_NATURAL_VALUE | RULE_REAL_VALUE | RULE_ID | RULE_UNRESTRICTED_NAME | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS );";
        }
    }
 

}