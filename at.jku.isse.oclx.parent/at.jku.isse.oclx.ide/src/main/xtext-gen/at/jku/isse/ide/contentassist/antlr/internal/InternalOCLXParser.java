package at.jku.isse.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import at.jku.isse.services.OCLXGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOCLXParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_DESCRIPTION", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'*'", "'/'", "'+'", "'-'", "'.'", "'->'", "'not'", "'forAll'", "'exists'", "'collect'", "'reject'", "'select'", "'asType'", "'isTypeOf'", "'isKindOf'", "'set'", "'list'", "'map'", "'collection'", "'next'", "'always'", "'eventually'", "'rule'", "'{'", "'context:'", "'expression:'", "'}'", "'description:'", "'is'", "'overrulable:'", "'('", "')'", "'null'", "'|'", "':'", "'()'", "'ensureThat'", "'asLongAs'", "'then'", "'thenAtLeastOnce'", "','", "'self'", "'true'", "'false'", "'everyTime'", "'whenOnce'", "'until'", "'asSoonAs'", "'everytime'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
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
    public static final int RULE_DESCRIPTION=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
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
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalOCLXParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOCLXParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOCLXParser.tokenNames; }
    public String getGrammarFileName() { return "InternalOCLX.g"; }


    	private OCLXGrammarAccess grammarAccess;

    	public void setGrammarAccess(OCLXGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalOCLX.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalOCLX.g:54:1: ( ruleModel EOF )
            // InternalOCLX.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalOCLX.g:62:1: ruleModel : ( ( rule__Model__ConstraintsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:66:2: ( ( ( rule__Model__ConstraintsAssignment )* ) )
            // InternalOCLX.g:67:2: ( ( rule__Model__ConstraintsAssignment )* )
            {
            // InternalOCLX.g:67:2: ( ( rule__Model__ConstraintsAssignment )* )
            // InternalOCLX.g:68:3: ( rule__Model__ConstraintsAssignment )*
            {
             before(grammarAccess.getModelAccess().getConstraintsAssignment()); 
            // InternalOCLX.g:69:3: ( rule__Model__ConstraintsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==44) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOCLX.g:69:4: rule__Model__ConstraintsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__ConstraintsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getConstraintsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleConstraint"
    // InternalOCLX.g:78:1: entryRuleConstraint : ruleConstraint EOF ;
    public final void entryRuleConstraint() throws RecognitionException {
        try {
            // InternalOCLX.g:79:1: ( ruleConstraint EOF )
            // InternalOCLX.g:80:1: ruleConstraint EOF
            {
             before(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getConstraintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalOCLX.g:87:1: ruleConstraint : ( ( rule__Constraint__Group__0 ) ) ;
    public final void ruleConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:91:2: ( ( ( rule__Constraint__Group__0 ) ) )
            // InternalOCLX.g:92:2: ( ( rule__Constraint__Group__0 ) )
            {
            // InternalOCLX.g:92:2: ( ( rule__Constraint__Group__0 ) )
            // InternalOCLX.g:93:3: ( rule__Constraint__Group__0 )
            {
             before(grammarAccess.getConstraintAccess().getGroup()); 
            // InternalOCLX.g:94:3: ( rule__Constraint__Group__0 )
            // InternalOCLX.g:94:4: rule__Constraint__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalOCLX.g:103:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalOCLX.g:104:1: ( ruleQualifiedName EOF )
            // InternalOCLX.g:105:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalOCLX.g:112:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:116:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalOCLX.g:117:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalOCLX.g:117:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalOCLX.g:118:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalOCLX.g:119:3: ( rule__QualifiedName__Group__0 )
            // InternalOCLX.g:119:4: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleSimpleName"
    // InternalOCLX.g:128:1: entryRuleSimpleName : ruleSimpleName EOF ;
    public final void entryRuleSimpleName() throws RecognitionException {
        try {
            // InternalOCLX.g:129:1: ( ruleSimpleName EOF )
            // InternalOCLX.g:130:1: ruleSimpleName EOF
            {
             before(grammarAccess.getSimpleNameRule()); 
            pushFollow(FOLLOW_1);
            ruleSimpleName();

            state._fsp--;

             after(grammarAccess.getSimpleNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSimpleName"


    // $ANTLR start "ruleSimpleName"
    // InternalOCLX.g:137:1: ruleSimpleName : ( RULE_ID ) ;
    public final void ruleSimpleName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:141:2: ( ( RULE_ID ) )
            // InternalOCLX.g:142:2: ( RULE_ID )
            {
            // InternalOCLX.g:142:2: ( RULE_ID )
            // InternalOCLX.g:143:3: RULE_ID
            {
             before(grammarAccess.getSimpleNameAccess().getIDTerminalRuleCall()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSimpleNameAccess().getIDTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSimpleName"


    // $ANTLR start "entryRuleContext"
    // InternalOCLX.g:153:1: entryRuleContext : ruleContext EOF ;
    public final void entryRuleContext() throws RecognitionException {
        try {
            // InternalOCLX.g:154:1: ( ruleContext EOF )
            // InternalOCLX.g:155:1: ruleContext EOF
            {
             before(grammarAccess.getContextRule()); 
            pushFollow(FOLLOW_1);
            ruleContext();

            state._fsp--;

             after(grammarAccess.getContextRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContext"


    // $ANTLR start "ruleContext"
    // InternalOCLX.g:162:1: ruleContext : ( ( rule__Context__NameAssignment ) ) ;
    public final void ruleContext() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:166:2: ( ( ( rule__Context__NameAssignment ) ) )
            // InternalOCLX.g:167:2: ( ( rule__Context__NameAssignment ) )
            {
            // InternalOCLX.g:167:2: ( ( rule__Context__NameAssignment ) )
            // InternalOCLX.g:168:3: ( rule__Context__NameAssignment )
            {
             before(grammarAccess.getContextAccess().getNameAssignment()); 
            // InternalOCLX.g:169:3: ( rule__Context__NameAssignment )
            // InternalOCLX.g:169:4: rule__Context__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Context__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getContextAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContext"


    // $ANTLR start "entryRuleExp"
    // InternalOCLX.g:178:1: entryRuleExp : ruleExp EOF ;
    public final void entryRuleExp() throws RecognitionException {
        try {
            // InternalOCLX.g:179:1: ( ruleExp EOF )
            // InternalOCLX.g:180:1: ruleExp EOF
            {
             before(grammarAccess.getExpRule()); 
            pushFollow(FOLLOW_1);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExp"


    // $ANTLR start "ruleExp"
    // InternalOCLX.g:187:1: ruleExp : ( ( rule__Exp__Group__0 ) ) ;
    public final void ruleExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:191:2: ( ( ( rule__Exp__Group__0 ) ) )
            // InternalOCLX.g:192:2: ( ( rule__Exp__Group__0 ) )
            {
            // InternalOCLX.g:192:2: ( ( rule__Exp__Group__0 ) )
            // InternalOCLX.g:193:3: ( rule__Exp__Group__0 )
            {
             before(grammarAccess.getExpAccess().getGroup()); 
            // InternalOCLX.g:194:3: ( rule__Exp__Group__0 )
            // InternalOCLX.g:194:4: rule__Exp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Exp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExp"


    // $ANTLR start "entryRulePrefixedExp"
    // InternalOCLX.g:203:1: entryRulePrefixedExp : rulePrefixedExp EOF ;
    public final void entryRulePrefixedExp() throws RecognitionException {
        try {
            // InternalOCLX.g:204:1: ( rulePrefixedExp EOF )
            // InternalOCLX.g:205:1: rulePrefixedExp EOF
            {
             before(grammarAccess.getPrefixedExpRule()); 
            pushFollow(FOLLOW_1);
            rulePrefixedExp();

            state._fsp--;

             after(grammarAccess.getPrefixedExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrefixedExp"


    // $ANTLR start "rulePrefixedExp"
    // InternalOCLX.g:212:1: rulePrefixedExp : ( ( rule__PrefixedExp__Alternatives ) ) ;
    public final void rulePrefixedExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:216:2: ( ( ( rule__PrefixedExp__Alternatives ) ) )
            // InternalOCLX.g:217:2: ( ( rule__PrefixedExp__Alternatives ) )
            {
            // InternalOCLX.g:217:2: ( ( rule__PrefixedExp__Alternatives ) )
            // InternalOCLX.g:218:3: ( rule__PrefixedExp__Alternatives )
            {
             before(grammarAccess.getPrefixedExpAccess().getAlternatives()); 
            // InternalOCLX.g:219:3: ( rule__PrefixedExp__Alternatives )
            // InternalOCLX.g:219:4: rule__PrefixedExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrefixedExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrefixedExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrefixedExp"


    // $ANTLR start "entryRuleBinaryOperator"
    // InternalOCLX.g:228:1: entryRuleBinaryOperator : ruleBinaryOperator EOF ;
    public final void entryRuleBinaryOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:229:1: ( ruleBinaryOperator EOF )
            // InternalOCLX.g:230:1: ruleBinaryOperator EOF
            {
             before(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleBinaryOperator();

            state._fsp--;

             after(grammarAccess.getBinaryOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBinaryOperator"


    // $ANTLR start "ruleBinaryOperator"
    // InternalOCLX.g:237:1: ruleBinaryOperator : ( ruleInfixOperator ) ;
    public final void ruleBinaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:241:2: ( ( ruleInfixOperator ) )
            // InternalOCLX.g:242:2: ( ruleInfixOperator )
            {
            // InternalOCLX.g:242:2: ( ruleInfixOperator )
            // InternalOCLX.g:243:3: ruleInfixOperator
            {
             before(grammarAccess.getBinaryOperatorAccess().getInfixOperatorParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleInfixOperator();

            state._fsp--;

             after(grammarAccess.getBinaryOperatorAccess().getInfixOperatorParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBinaryOperator"


    // $ANTLR start "entryRuleInfixOperator"
    // InternalOCLX.g:253:1: entryRuleInfixOperator : ruleInfixOperator EOF ;
    public final void entryRuleInfixOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:254:1: ( ruleInfixOperator EOF )
            // InternalOCLX.g:255:1: ruleInfixOperator EOF
            {
             before(grammarAccess.getInfixOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleInfixOperator();

            state._fsp--;

             after(grammarAccess.getInfixOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInfixOperator"


    // $ANTLR start "ruleInfixOperator"
    // InternalOCLX.g:262:1: ruleInfixOperator : ( ( rule__InfixOperator__Alternatives ) ) ;
    public final void ruleInfixOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:266:2: ( ( ( rule__InfixOperator__Alternatives ) ) )
            // InternalOCLX.g:267:2: ( ( rule__InfixOperator__Alternatives ) )
            {
            // InternalOCLX.g:267:2: ( ( rule__InfixOperator__Alternatives ) )
            // InternalOCLX.g:268:3: ( rule__InfixOperator__Alternatives )
            {
             before(grammarAccess.getInfixOperatorAccess().getAlternatives()); 
            // InternalOCLX.g:269:3: ( rule__InfixOperator__Alternatives )
            // InternalOCLX.g:269:4: rule__InfixOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__InfixOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getInfixOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInfixOperator"


    // $ANTLR start "entryRuleBooleanOperator"
    // InternalOCLX.g:278:1: entryRuleBooleanOperator : ruleBooleanOperator EOF ;
    public final void entryRuleBooleanOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:279:1: ( ruleBooleanOperator EOF )
            // InternalOCLX.g:280:1: ruleBooleanOperator EOF
            {
             before(grammarAccess.getBooleanOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanOperator();

            state._fsp--;

             after(grammarAccess.getBooleanOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanOperator"


    // $ANTLR start "ruleBooleanOperator"
    // InternalOCLX.g:287:1: ruleBooleanOperator : ( ( rule__BooleanOperator__OpAssignment ) ) ;
    public final void ruleBooleanOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:291:2: ( ( ( rule__BooleanOperator__OpAssignment ) ) )
            // InternalOCLX.g:292:2: ( ( rule__BooleanOperator__OpAssignment ) )
            {
            // InternalOCLX.g:292:2: ( ( rule__BooleanOperator__OpAssignment ) )
            // InternalOCLX.g:293:3: ( rule__BooleanOperator__OpAssignment )
            {
             before(grammarAccess.getBooleanOperatorAccess().getOpAssignment()); 
            // InternalOCLX.g:294:3: ( rule__BooleanOperator__OpAssignment )
            // InternalOCLX.g:294:4: rule__BooleanOperator__OpAssignment
            {
            pushFollow(FOLLOW_2);
            rule__BooleanOperator__OpAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBooleanOperatorAccess().getOpAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanOperator"


    // $ANTLR start "entryRuleMathOperator"
    // InternalOCLX.g:303:1: entryRuleMathOperator : ruleMathOperator EOF ;
    public final void entryRuleMathOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:304:1: ( ruleMathOperator EOF )
            // InternalOCLX.g:305:1: ruleMathOperator EOF
            {
             before(grammarAccess.getMathOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleMathOperator();

            state._fsp--;

             after(grammarAccess.getMathOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMathOperator"


    // $ANTLR start "ruleMathOperator"
    // InternalOCLX.g:312:1: ruleMathOperator : ( ( rule__MathOperator__OpAssignment ) ) ;
    public final void ruleMathOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:316:2: ( ( ( rule__MathOperator__OpAssignment ) ) )
            // InternalOCLX.g:317:2: ( ( rule__MathOperator__OpAssignment ) )
            {
            // InternalOCLX.g:317:2: ( ( rule__MathOperator__OpAssignment ) )
            // InternalOCLX.g:318:3: ( rule__MathOperator__OpAssignment )
            {
             before(grammarAccess.getMathOperatorAccess().getOpAssignment()); 
            // InternalOCLX.g:319:3: ( rule__MathOperator__OpAssignment )
            // InternalOCLX.g:319:4: rule__MathOperator__OpAssignment
            {
            pushFollow(FOLLOW_2);
            rule__MathOperator__OpAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMathOperatorAccess().getOpAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMathOperator"


    // $ANTLR start "entryRuleNavigationOperator"
    // InternalOCLX.g:328:1: entryRuleNavigationOperator : ruleNavigationOperator EOF ;
    public final void entryRuleNavigationOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:329:1: ( ruleNavigationOperator EOF )
            // InternalOCLX.g:330:1: ruleNavigationOperator EOF
            {
             before(grammarAccess.getNavigationOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleNavigationOperator();

            state._fsp--;

             after(grammarAccess.getNavigationOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNavigationOperator"


    // $ANTLR start "ruleNavigationOperator"
    // InternalOCLX.g:337:1: ruleNavigationOperator : ( ( rule__NavigationOperator__NameAssignment ) ) ;
    public final void ruleNavigationOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:341:2: ( ( ( rule__NavigationOperator__NameAssignment ) ) )
            // InternalOCLX.g:342:2: ( ( rule__NavigationOperator__NameAssignment ) )
            {
            // InternalOCLX.g:342:2: ( ( rule__NavigationOperator__NameAssignment ) )
            // InternalOCLX.g:343:3: ( rule__NavigationOperator__NameAssignment )
            {
             before(grammarAccess.getNavigationOperatorAccess().getNameAssignment()); 
            // InternalOCLX.g:344:3: ( rule__NavigationOperator__NameAssignment )
            // InternalOCLX.g:344:4: rule__NavigationOperator__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__NavigationOperator__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getNavigationOperatorAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNavigationOperator"


    // $ANTLR start "entryRuleUnaryOperator"
    // InternalOCLX.g:353:1: entryRuleUnaryOperator : ruleUnaryOperator EOF ;
    public final void entryRuleUnaryOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:354:1: ( ruleUnaryOperator EOF )
            // InternalOCLX.g:355:1: ruleUnaryOperator EOF
            {
             before(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryOperator();

            state._fsp--;

             after(grammarAccess.getUnaryOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // InternalOCLX.g:362:1: ruleUnaryOperator : ( ( rule__UnaryOperator__NameAssignment ) ) ;
    public final void ruleUnaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:366:2: ( ( ( rule__UnaryOperator__NameAssignment ) ) )
            // InternalOCLX.g:367:2: ( ( rule__UnaryOperator__NameAssignment ) )
            {
            // InternalOCLX.g:367:2: ( ( rule__UnaryOperator__NameAssignment ) )
            // InternalOCLX.g:368:3: ( rule__UnaryOperator__NameAssignment )
            {
             before(grammarAccess.getUnaryOperatorAccess().getNameAssignment()); 
            // InternalOCLX.g:369:3: ( rule__UnaryOperator__NameAssignment )
            // InternalOCLX.g:369:4: rule__UnaryOperator__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOperator__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getUnaryOperatorAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRulePrimaryExp"
    // InternalOCLX.g:378:1: entryRulePrimaryExp : rulePrimaryExp EOF ;
    public final void entryRulePrimaryExp() throws RecognitionException {
        try {
            // InternalOCLX.g:379:1: ( rulePrimaryExp EOF )
            // InternalOCLX.g:380:1: rulePrimaryExp EOF
            {
             before(grammarAccess.getPrimaryExpRule()); 
            pushFollow(FOLLOW_1);
            rulePrimaryExp();

            state._fsp--;

             after(grammarAccess.getPrimaryExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryExp"


    // $ANTLR start "rulePrimaryExp"
    // InternalOCLX.g:387:1: rulePrimaryExp : ( ( rule__PrimaryExp__Alternatives ) ) ;
    public final void rulePrimaryExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:391:2: ( ( ( rule__PrimaryExp__Alternatives ) ) )
            // InternalOCLX.g:392:2: ( ( rule__PrimaryExp__Alternatives ) )
            {
            // InternalOCLX.g:392:2: ( ( rule__PrimaryExp__Alternatives ) )
            // InternalOCLX.g:393:3: ( rule__PrimaryExp__Alternatives )
            {
             before(grammarAccess.getPrimaryExpAccess().getAlternatives()); 
            // InternalOCLX.g:394:3: ( rule__PrimaryExp__Alternatives )
            // InternalOCLX.g:394:4: rule__PrimaryExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExp"


    // $ANTLR start "entryRuleNestedExp"
    // InternalOCLX.g:403:1: entryRuleNestedExp : ruleNestedExp EOF ;
    public final void entryRuleNestedExp() throws RecognitionException {
        try {
            // InternalOCLX.g:404:1: ( ruleNestedExp EOF )
            // InternalOCLX.g:405:1: ruleNestedExp EOF
            {
             before(grammarAccess.getNestedExpRule()); 
            pushFollow(FOLLOW_1);
            ruleNestedExp();

            state._fsp--;

             after(grammarAccess.getNestedExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNestedExp"


    // $ANTLR start "ruleNestedExp"
    // InternalOCLX.g:412:1: ruleNestedExp : ( ( rule__NestedExp__Group__0 ) ) ;
    public final void ruleNestedExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:416:2: ( ( ( rule__NestedExp__Group__0 ) ) )
            // InternalOCLX.g:417:2: ( ( rule__NestedExp__Group__0 ) )
            {
            // InternalOCLX.g:417:2: ( ( rule__NestedExp__Group__0 ) )
            // InternalOCLX.g:418:3: ( rule__NestedExp__Group__0 )
            {
             before(grammarAccess.getNestedExpAccess().getGroup()); 
            // InternalOCLX.g:419:3: ( rule__NestedExp__Group__0 )
            // InternalOCLX.g:419:4: rule__NestedExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NestedExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNestedExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNestedExp"


    // $ANTLR start "entryRuleVarOrSelfExp"
    // InternalOCLX.g:428:1: entryRuleVarOrSelfExp : ruleVarOrSelfExp EOF ;
    public final void entryRuleVarOrSelfExp() throws RecognitionException {
        try {
            // InternalOCLX.g:429:1: ( ruleVarOrSelfExp EOF )
            // InternalOCLX.g:430:1: ruleVarOrSelfExp EOF
            {
             before(grammarAccess.getVarOrSelfExpRule()); 
            pushFollow(FOLLOW_1);
            ruleVarOrSelfExp();

            state._fsp--;

             after(grammarAccess.getVarOrSelfExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVarOrSelfExp"


    // $ANTLR start "ruleVarOrSelfExp"
    // InternalOCLX.g:437:1: ruleVarOrSelfExp : ( ( rule__VarOrSelfExp__Alternatives ) ) ;
    public final void ruleVarOrSelfExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:441:2: ( ( ( rule__VarOrSelfExp__Alternatives ) ) )
            // InternalOCLX.g:442:2: ( ( rule__VarOrSelfExp__Alternatives ) )
            {
            // InternalOCLX.g:442:2: ( ( rule__VarOrSelfExp__Alternatives ) )
            // InternalOCLX.g:443:3: ( rule__VarOrSelfExp__Alternatives )
            {
             before(grammarAccess.getVarOrSelfExpAccess().getAlternatives()); 
            // InternalOCLX.g:444:3: ( rule__VarOrSelfExp__Alternatives )
            // InternalOCLX.g:444:4: rule__VarOrSelfExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__VarOrSelfExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVarOrSelfExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVarOrSelfExp"


    // $ANTLR start "entryRuleSelfExp"
    // InternalOCLX.g:453:1: entryRuleSelfExp : ruleSelfExp EOF ;
    public final void entryRuleSelfExp() throws RecognitionException {
        try {
            // InternalOCLX.g:454:1: ( ruleSelfExp EOF )
            // InternalOCLX.g:455:1: ruleSelfExp EOF
            {
             before(grammarAccess.getSelfExpRule()); 
            pushFollow(FOLLOW_1);
            ruleSelfExp();

            state._fsp--;

             after(grammarAccess.getSelfExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSelfExp"


    // $ANTLR start "ruleSelfExp"
    // InternalOCLX.g:462:1: ruleSelfExp : ( ( rule__SelfExp__Group__0 ) ) ;
    public final void ruleSelfExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:466:2: ( ( ( rule__SelfExp__Group__0 ) ) )
            // InternalOCLX.g:467:2: ( ( rule__SelfExp__Group__0 ) )
            {
            // InternalOCLX.g:467:2: ( ( rule__SelfExp__Group__0 ) )
            // InternalOCLX.g:468:3: ( rule__SelfExp__Group__0 )
            {
             before(grammarAccess.getSelfExpAccess().getGroup()); 
            // InternalOCLX.g:469:3: ( rule__SelfExp__Group__0 )
            // InternalOCLX.g:469:4: rule__SelfExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SelfExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSelfExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSelfExp"


    // $ANTLR start "entryRuleVarDeclaration"
    // InternalOCLX.g:478:1: entryRuleVarDeclaration : ruleVarDeclaration EOF ;
    public final void entryRuleVarDeclaration() throws RecognitionException {
        try {
            // InternalOCLX.g:479:1: ( ruleVarDeclaration EOF )
            // InternalOCLX.g:480:1: ruleVarDeclaration EOF
            {
             before(grammarAccess.getVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleVarDeclaration();

            state._fsp--;

             after(grammarAccess.getVarDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVarDeclaration"


    // $ANTLR start "ruleVarDeclaration"
    // InternalOCLX.g:487:1: ruleVarDeclaration : ( ( rule__VarDeclaration__NameAssignment ) ) ;
    public final void ruleVarDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:491:2: ( ( ( rule__VarDeclaration__NameAssignment ) ) )
            // InternalOCLX.g:492:2: ( ( rule__VarDeclaration__NameAssignment ) )
            {
            // InternalOCLX.g:492:2: ( ( rule__VarDeclaration__NameAssignment ) )
            // InternalOCLX.g:493:3: ( rule__VarDeclaration__NameAssignment )
            {
             before(grammarAccess.getVarDeclarationAccess().getNameAssignment()); 
            // InternalOCLX.g:494:3: ( rule__VarDeclaration__NameAssignment )
            // InternalOCLX.g:494:4: rule__VarDeclaration__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__VarDeclaration__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVarDeclarationAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVarDeclaration"


    // $ANTLR start "entryRuleVarReference"
    // InternalOCLX.g:503:1: entryRuleVarReference : ruleVarReference EOF ;
    public final void entryRuleVarReference() throws RecognitionException {
        try {
            // InternalOCLX.g:504:1: ( ruleVarReference EOF )
            // InternalOCLX.g:505:1: ruleVarReference EOF
            {
             before(grammarAccess.getVarReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleVarReference();

            state._fsp--;

             after(grammarAccess.getVarReferenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVarReference"


    // $ANTLR start "ruleVarReference"
    // InternalOCLX.g:512:1: ruleVarReference : ( ( rule__VarReference__RefAssignment ) ) ;
    public final void ruleVarReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:516:2: ( ( ( rule__VarReference__RefAssignment ) ) )
            // InternalOCLX.g:517:2: ( ( rule__VarReference__RefAssignment ) )
            {
            // InternalOCLX.g:517:2: ( ( rule__VarReference__RefAssignment ) )
            // InternalOCLX.g:518:3: ( rule__VarReference__RefAssignment )
            {
             before(grammarAccess.getVarReferenceAccess().getRefAssignment()); 
            // InternalOCLX.g:519:3: ( rule__VarReference__RefAssignment )
            // InternalOCLX.g:519:4: rule__VarReference__RefAssignment
            {
            pushFollow(FOLLOW_2);
            rule__VarReference__RefAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVarReferenceAccess().getRefAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVarReference"


    // $ANTLR start "entryRulePrimitiveLiteralExp"
    // InternalOCLX.g:528:1: entryRulePrimitiveLiteralExp : rulePrimitiveLiteralExp EOF ;
    public final void entryRulePrimitiveLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:529:1: ( rulePrimitiveLiteralExp EOF )
            // InternalOCLX.g:530:1: rulePrimitiveLiteralExp EOF
            {
             before(grammarAccess.getPrimitiveLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            rulePrimitiveLiteralExp();

            state._fsp--;

             after(grammarAccess.getPrimitiveLiteralExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimitiveLiteralExp"


    // $ANTLR start "rulePrimitiveLiteralExp"
    // InternalOCLX.g:537:1: rulePrimitiveLiteralExp : ( ( rule__PrimitiveLiteralExp__Alternatives ) ) ;
    public final void rulePrimitiveLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:541:2: ( ( ( rule__PrimitiveLiteralExp__Alternatives ) ) )
            // InternalOCLX.g:542:2: ( ( rule__PrimitiveLiteralExp__Alternatives ) )
            {
            // InternalOCLX.g:542:2: ( ( rule__PrimitiveLiteralExp__Alternatives ) )
            // InternalOCLX.g:543:3: ( rule__PrimitiveLiteralExp__Alternatives )
            {
             before(grammarAccess.getPrimitiveLiteralExpAccess().getAlternatives()); 
            // InternalOCLX.g:544:3: ( rule__PrimitiveLiteralExp__Alternatives )
            // InternalOCLX.g:544:4: rule__PrimitiveLiteralExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveLiteralExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveLiteralExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimitiveLiteralExp"


    // $ANTLR start "entryRuleNumberLiteralExp"
    // InternalOCLX.g:553:1: entryRuleNumberLiteralExp : ruleNumberLiteralExp EOF ;
    public final void entryRuleNumberLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:554:1: ( ruleNumberLiteralExp EOF )
            // InternalOCLX.g:555:1: ruleNumberLiteralExp EOF
            {
             before(grammarAccess.getNumberLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            ruleNumberLiteralExp();

            state._fsp--;

             after(grammarAccess.getNumberLiteralExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumberLiteralExp"


    // $ANTLR start "ruleNumberLiteralExp"
    // InternalOCLX.g:562:1: ruleNumberLiteralExp : ( ( rule__NumberLiteralExp__ValueAssignment ) ) ;
    public final void ruleNumberLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:566:2: ( ( ( rule__NumberLiteralExp__ValueAssignment ) ) )
            // InternalOCLX.g:567:2: ( ( rule__NumberLiteralExp__ValueAssignment ) )
            {
            // InternalOCLX.g:567:2: ( ( rule__NumberLiteralExp__ValueAssignment ) )
            // InternalOCLX.g:568:3: ( rule__NumberLiteralExp__ValueAssignment )
            {
             before(grammarAccess.getNumberLiteralExpAccess().getValueAssignment()); 
            // InternalOCLX.g:569:3: ( rule__NumberLiteralExp__ValueAssignment )
            // InternalOCLX.g:569:4: rule__NumberLiteralExp__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__NumberLiteralExp__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getNumberLiteralExpAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumberLiteralExp"


    // $ANTLR start "entryRuleStringLiteralExp"
    // InternalOCLX.g:578:1: entryRuleStringLiteralExp : ruleStringLiteralExp EOF ;
    public final void entryRuleStringLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:579:1: ( ruleStringLiteralExp EOF )
            // InternalOCLX.g:580:1: ruleStringLiteralExp EOF
            {
             before(grammarAccess.getStringLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            ruleStringLiteralExp();

            state._fsp--;

             after(grammarAccess.getStringLiteralExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringLiteralExp"


    // $ANTLR start "ruleStringLiteralExp"
    // InternalOCLX.g:587:1: ruleStringLiteralExp : ( ( rule__StringLiteralExp__ValueAssignment ) ) ;
    public final void ruleStringLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:591:2: ( ( ( rule__StringLiteralExp__ValueAssignment ) ) )
            // InternalOCLX.g:592:2: ( ( rule__StringLiteralExp__ValueAssignment ) )
            {
            // InternalOCLX.g:592:2: ( ( rule__StringLiteralExp__ValueAssignment ) )
            // InternalOCLX.g:593:3: ( rule__StringLiteralExp__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralExpAccess().getValueAssignment()); 
            // InternalOCLX.g:594:3: ( rule__StringLiteralExp__ValueAssignment )
            // InternalOCLX.g:594:4: rule__StringLiteralExp__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__StringLiteralExp__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStringLiteralExpAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringLiteralExp"


    // $ANTLR start "entryRuleBooleanLiteralExp"
    // InternalOCLX.g:603:1: entryRuleBooleanLiteralExp : ruleBooleanLiteralExp EOF ;
    public final void entryRuleBooleanLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:604:1: ( ruleBooleanLiteralExp EOF )
            // InternalOCLX.g:605:1: ruleBooleanLiteralExp EOF
            {
             before(grammarAccess.getBooleanLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanLiteralExp();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanLiteralExp"


    // $ANTLR start "ruleBooleanLiteralExp"
    // InternalOCLX.g:612:1: ruleBooleanLiteralExp : ( ( rule__BooleanLiteralExp__Alternatives ) ) ;
    public final void ruleBooleanLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:616:2: ( ( ( rule__BooleanLiteralExp__Alternatives ) ) )
            // InternalOCLX.g:617:2: ( ( rule__BooleanLiteralExp__Alternatives ) )
            {
            // InternalOCLX.g:617:2: ( ( rule__BooleanLiteralExp__Alternatives ) )
            // InternalOCLX.g:618:3: ( rule__BooleanLiteralExp__Alternatives )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getAlternatives()); 
            // InternalOCLX.g:619:3: ( rule__BooleanLiteralExp__Alternatives )
            // InternalOCLX.g:619:4: rule__BooleanLiteralExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteralExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBooleanLiteralExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanLiteralExp"


    // $ANTLR start "entryRuleNullLiteralExp"
    // InternalOCLX.g:628:1: entryRuleNullLiteralExp : ruleNullLiteralExp EOF ;
    public final void entryRuleNullLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:629:1: ( ruleNullLiteralExp EOF )
            // InternalOCLX.g:630:1: ruleNullLiteralExp EOF
            {
             before(grammarAccess.getNullLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            ruleNullLiteralExp();

            state._fsp--;

             after(grammarAccess.getNullLiteralExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNullLiteralExp"


    // $ANTLR start "ruleNullLiteralExp"
    // InternalOCLX.g:637:1: ruleNullLiteralExp : ( ( rule__NullLiteralExp__Group__0 ) ) ;
    public final void ruleNullLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:641:2: ( ( ( rule__NullLiteralExp__Group__0 ) ) )
            // InternalOCLX.g:642:2: ( ( rule__NullLiteralExp__Group__0 ) )
            {
            // InternalOCLX.g:642:2: ( ( rule__NullLiteralExp__Group__0 ) )
            // InternalOCLX.g:643:3: ( rule__NullLiteralExp__Group__0 )
            {
             before(grammarAccess.getNullLiteralExpAccess().getGroup()); 
            // InternalOCLX.g:644:3: ( rule__NullLiteralExp__Group__0 )
            // InternalOCLX.g:644:4: rule__NullLiteralExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NullLiteralExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNullLiteralExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNullLiteralExp"


    // $ANTLR start "entryRuleMethodExp"
    // InternalOCLX.g:653:1: entryRuleMethodExp : ruleMethodExp EOF ;
    public final void entryRuleMethodExp() throws RecognitionException {
        try {
            // InternalOCLX.g:654:1: ( ruleMethodExp EOF )
            // InternalOCLX.g:655:1: ruleMethodExp EOF
            {
             before(grammarAccess.getMethodExpRule()); 
            pushFollow(FOLLOW_1);
            ruleMethodExp();

            state._fsp--;

             after(grammarAccess.getMethodExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMethodExp"


    // $ANTLR start "ruleMethodExp"
    // InternalOCLX.g:662:1: ruleMethodExp : ( ( rule__MethodExp__Alternatives ) ) ;
    public final void ruleMethodExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:666:2: ( ( ( rule__MethodExp__Alternatives ) ) )
            // InternalOCLX.g:667:2: ( ( rule__MethodExp__Alternatives ) )
            {
            // InternalOCLX.g:667:2: ( ( rule__MethodExp__Alternatives ) )
            // InternalOCLX.g:668:3: ( rule__MethodExp__Alternatives )
            {
             before(grammarAccess.getMethodExpAccess().getAlternatives()); 
            // InternalOCLX.g:669:3: ( rule__MethodExp__Alternatives )
            // InternalOCLX.g:669:4: rule__MethodExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MethodExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMethodExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMethodExp"


    // $ANTLR start "entryRuleCollectionIterator"
    // InternalOCLX.g:678:1: entryRuleCollectionIterator : ruleCollectionIterator EOF ;
    public final void entryRuleCollectionIterator() throws RecognitionException {
        try {
            // InternalOCLX.g:679:1: ( ruleCollectionIterator EOF )
            // InternalOCLX.g:680:1: ruleCollectionIterator EOF
            {
             before(grammarAccess.getCollectionIteratorRule()); 
            pushFollow(FOLLOW_1);
            ruleCollectionIterator();

            state._fsp--;

             after(grammarAccess.getCollectionIteratorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCollectionIterator"


    // $ANTLR start "ruleCollectionIterator"
    // InternalOCLX.g:687:1: ruleCollectionIterator : ( ( rule__CollectionIterator__Group__0 ) ) ;
    public final void ruleCollectionIterator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:691:2: ( ( ( rule__CollectionIterator__Group__0 ) ) )
            // InternalOCLX.g:692:2: ( ( rule__CollectionIterator__Group__0 ) )
            {
            // InternalOCLX.g:692:2: ( ( rule__CollectionIterator__Group__0 ) )
            // InternalOCLX.g:693:3: ( rule__CollectionIterator__Group__0 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getGroup()); 
            // InternalOCLX.g:694:3: ( rule__CollectionIterator__Group__0 )
            // InternalOCLX.g:694:4: rule__CollectionIterator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CollectionIterator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCollectionIteratorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCollectionIterator"


    // $ANTLR start "entryRuleIteratorName"
    // InternalOCLX.g:703:1: entryRuleIteratorName : ruleIteratorName EOF ;
    public final void entryRuleIteratorName() throws RecognitionException {
        try {
            // InternalOCLX.g:704:1: ( ruleIteratorName EOF )
            // InternalOCLX.g:705:1: ruleIteratorName EOF
            {
             before(grammarAccess.getIteratorNameRule()); 
            pushFollow(FOLLOW_1);
            ruleIteratorName();

            state._fsp--;

             after(grammarAccess.getIteratorNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIteratorName"


    // $ANTLR start "ruleIteratorName"
    // InternalOCLX.g:712:1: ruleIteratorName : ( ( rule__IteratorName__NameAssignment ) ) ;
    public final void ruleIteratorName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:716:2: ( ( ( rule__IteratorName__NameAssignment ) ) )
            // InternalOCLX.g:717:2: ( ( rule__IteratorName__NameAssignment ) )
            {
            // InternalOCLX.g:717:2: ( ( rule__IteratorName__NameAssignment ) )
            // InternalOCLX.g:718:3: ( rule__IteratorName__NameAssignment )
            {
             before(grammarAccess.getIteratorNameAccess().getNameAssignment()); 
            // InternalOCLX.g:719:3: ( rule__IteratorName__NameAssignment )
            // InternalOCLX.g:719:4: rule__IteratorName__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__IteratorName__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIteratorNameAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIteratorName"


    // $ANTLR start "entryRuleIteratorVarDeclaration"
    // InternalOCLX.g:728:1: entryRuleIteratorVarDeclaration : ruleIteratorVarDeclaration EOF ;
    public final void entryRuleIteratorVarDeclaration() throws RecognitionException {
        try {
            // InternalOCLX.g:729:1: ( ruleIteratorVarDeclaration EOF )
            // InternalOCLX.g:730:1: ruleIteratorVarDeclaration EOF
            {
             before(grammarAccess.getIteratorVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleIteratorVarDeclaration();

            state._fsp--;

             after(grammarAccess.getIteratorVarDeclarationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIteratorVarDeclaration"


    // $ANTLR start "ruleIteratorVarDeclaration"
    // InternalOCLX.g:737:1: ruleIteratorVarDeclaration : ( ( rule__IteratorVarDeclaration__Alternatives ) ) ;
    public final void ruleIteratorVarDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:741:2: ( ( ( rule__IteratorVarDeclaration__Alternatives ) ) )
            // InternalOCLX.g:742:2: ( ( rule__IteratorVarDeclaration__Alternatives ) )
            {
            // InternalOCLX.g:742:2: ( ( rule__IteratorVarDeclaration__Alternatives ) )
            // InternalOCLX.g:743:3: ( rule__IteratorVarDeclaration__Alternatives )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getAlternatives()); 
            // InternalOCLX.g:744:3: ( rule__IteratorVarDeclaration__Alternatives )
            // InternalOCLX.g:744:4: rule__IteratorVarDeclaration__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__IteratorVarDeclaration__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIteratorVarDeclarationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIteratorVarDeclaration"


    // $ANTLR start "entryRulePropertyAccess"
    // InternalOCLX.g:753:1: entryRulePropertyAccess : rulePropertyAccess EOF ;
    public final void entryRulePropertyAccess() throws RecognitionException {
        try {
            // InternalOCLX.g:754:1: ( rulePropertyAccess EOF )
            // InternalOCLX.g:755:1: rulePropertyAccess EOF
            {
             before(grammarAccess.getPropertyAccessRule()); 
            pushFollow(FOLLOW_1);
            rulePropertyAccess();

            state._fsp--;

             after(grammarAccess.getPropertyAccessRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePropertyAccess"


    // $ANTLR start "rulePropertyAccess"
    // InternalOCLX.g:762:1: rulePropertyAccess : ( ( rule__PropertyAccess__NameAssignment ) ) ;
    public final void rulePropertyAccess() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:766:2: ( ( ( rule__PropertyAccess__NameAssignment ) ) )
            // InternalOCLX.g:767:2: ( ( rule__PropertyAccess__NameAssignment ) )
            {
            // InternalOCLX.g:767:2: ( ( rule__PropertyAccess__NameAssignment ) )
            // InternalOCLX.g:768:3: ( rule__PropertyAccess__NameAssignment )
            {
             before(grammarAccess.getPropertyAccessAccess().getNameAssignment()); 
            // InternalOCLX.g:769:3: ( rule__PropertyAccess__NameAssignment )
            // InternalOCLX.g:769:4: rule__PropertyAccess__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PropertyAccess__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPropertyAccessAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePropertyAccess"


    // $ANTLR start "entryRuleMethodCall"
    // InternalOCLX.g:778:1: entryRuleMethodCall : ruleMethodCall EOF ;
    public final void entryRuleMethodCall() throws RecognitionException {
        try {
            // InternalOCLX.g:779:1: ( ruleMethodCall EOF )
            // InternalOCLX.g:780:1: ruleMethodCall EOF
            {
             before(grammarAccess.getMethodCallRule()); 
            pushFollow(FOLLOW_1);
            ruleMethodCall();

            state._fsp--;

             after(grammarAccess.getMethodCallRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMethodCall"


    // $ANTLR start "ruleMethodCall"
    // InternalOCLX.g:787:1: ruleMethodCall : ( ( rule__MethodCall__Alternatives ) ) ;
    public final void ruleMethodCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:791:2: ( ( ( rule__MethodCall__Alternatives ) ) )
            // InternalOCLX.g:792:2: ( ( rule__MethodCall__Alternatives ) )
            {
            // InternalOCLX.g:792:2: ( ( rule__MethodCall__Alternatives ) )
            // InternalOCLX.g:793:3: ( rule__MethodCall__Alternatives )
            {
             before(grammarAccess.getMethodCallAccess().getAlternatives()); 
            // InternalOCLX.g:794:3: ( rule__MethodCall__Alternatives )
            // InternalOCLX.g:794:4: rule__MethodCall__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MethodCall__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMethodCallAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMethodCall"


    // $ANTLR start "entryRuleTypeCall"
    // InternalOCLX.g:803:1: entryRuleTypeCall : ruleTypeCall EOF ;
    public final void entryRuleTypeCall() throws RecognitionException {
        try {
            // InternalOCLX.g:804:1: ( ruleTypeCall EOF )
            // InternalOCLX.g:805:1: ruleTypeCall EOF
            {
             before(grammarAccess.getTypeCallRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeCall();

            state._fsp--;

             after(grammarAccess.getTypeCallRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeCall"


    // $ANTLR start "ruleTypeCall"
    // InternalOCLX.g:812:1: ruleTypeCall : ( ( rule__TypeCall__Group__0 ) ) ;
    public final void ruleTypeCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:816:2: ( ( ( rule__TypeCall__Group__0 ) ) )
            // InternalOCLX.g:817:2: ( ( rule__TypeCall__Group__0 ) )
            {
            // InternalOCLX.g:817:2: ( ( rule__TypeCall__Group__0 ) )
            // InternalOCLX.g:818:3: ( rule__TypeCall__Group__0 )
            {
             before(grammarAccess.getTypeCallAccess().getGroup()); 
            // InternalOCLX.g:819:3: ( rule__TypeCall__Group__0 )
            // InternalOCLX.g:819:4: rule__TypeCall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypeCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeCall"


    // $ANTLR start "entryRuleTypeExp"
    // InternalOCLX.g:828:1: entryRuleTypeExp : ruleTypeExp EOF ;
    public final void entryRuleTypeExp() throws RecognitionException {
        try {
            // InternalOCLX.g:829:1: ( ruleTypeExp EOF )
            // InternalOCLX.g:830:1: ruleTypeExp EOF
            {
             before(grammarAccess.getTypeExpRule()); 
            pushFollow(FOLLOW_1);
            ruleTypeExp();

            state._fsp--;

             after(grammarAccess.getTypeExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTypeExp"


    // $ANTLR start "ruleTypeExp"
    // InternalOCLX.g:837:1: ruleTypeExp : ( ( rule__TypeExp__Alternatives ) ) ;
    public final void ruleTypeExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:841:2: ( ( ( rule__TypeExp__Alternatives ) ) )
            // InternalOCLX.g:842:2: ( ( rule__TypeExp__Alternatives ) )
            {
            // InternalOCLX.g:842:2: ( ( rule__TypeExp__Alternatives ) )
            // InternalOCLX.g:843:3: ( rule__TypeExp__Alternatives )
            {
             before(grammarAccess.getTypeExpAccess().getAlternatives()); 
            // InternalOCLX.g:844:3: ( rule__TypeExp__Alternatives )
            // InternalOCLX.g:844:4: rule__TypeExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TypeExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTypeExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTypeExp"


    // $ANTLR start "entryRuleCollectionTypeIdentifier"
    // InternalOCLX.g:853:1: entryRuleCollectionTypeIdentifier : ruleCollectionTypeIdentifier EOF ;
    public final void entryRuleCollectionTypeIdentifier() throws RecognitionException {
        try {
            // InternalOCLX.g:854:1: ( ruleCollectionTypeIdentifier EOF )
            // InternalOCLX.g:855:1: ruleCollectionTypeIdentifier EOF
            {
             before(grammarAccess.getCollectionTypeIdentifierRule()); 
            pushFollow(FOLLOW_1);
            ruleCollectionTypeIdentifier();

            state._fsp--;

             after(grammarAccess.getCollectionTypeIdentifierRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCollectionTypeIdentifier"


    // $ANTLR start "ruleCollectionTypeIdentifier"
    // InternalOCLX.g:862:1: ruleCollectionTypeIdentifier : ( ( rule__CollectionTypeIdentifier__NameAssignment ) ) ;
    public final void ruleCollectionTypeIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:866:2: ( ( ( rule__CollectionTypeIdentifier__NameAssignment ) ) )
            // InternalOCLX.g:867:2: ( ( rule__CollectionTypeIdentifier__NameAssignment ) )
            {
            // InternalOCLX.g:867:2: ( ( rule__CollectionTypeIdentifier__NameAssignment ) )
            // InternalOCLX.g:868:3: ( rule__CollectionTypeIdentifier__NameAssignment )
            {
             before(grammarAccess.getCollectionTypeIdentifierAccess().getNameAssignment()); 
            // InternalOCLX.g:869:3: ( rule__CollectionTypeIdentifier__NameAssignment )
            // InternalOCLX.g:869:4: rule__CollectionTypeIdentifier__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__CollectionTypeIdentifier__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getCollectionTypeIdentifierAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCollectionTypeIdentifier"


    // $ANTLR start "entryRuleTemporalExp"
    // InternalOCLX.g:878:1: entryRuleTemporalExp : ruleTemporalExp EOF ;
    public final void entryRuleTemporalExp() throws RecognitionException {
        try {
            // InternalOCLX.g:879:1: ( ruleTemporalExp EOF )
            // InternalOCLX.g:880:1: ruleTemporalExp EOF
            {
             before(grammarAccess.getTemporalExpRule()); 
            pushFollow(FOLLOW_1);
            ruleTemporalExp();

            state._fsp--;

             after(grammarAccess.getTemporalExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTemporalExp"


    // $ANTLR start "ruleTemporalExp"
    // InternalOCLX.g:887:1: ruleTemporalExp : ( ( rule__TemporalExp__Alternatives ) ) ;
    public final void ruleTemporalExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:891:2: ( ( ( rule__TemporalExp__Alternatives ) ) )
            // InternalOCLX.g:892:2: ( ( rule__TemporalExp__Alternatives ) )
            {
            // InternalOCLX.g:892:2: ( ( rule__TemporalExp__Alternatives ) )
            // InternalOCLX.g:893:3: ( rule__TemporalExp__Alternatives )
            {
             before(grammarAccess.getTemporalExpAccess().getAlternatives()); 
            // InternalOCLX.g:894:3: ( rule__TemporalExp__Alternatives )
            // InternalOCLX.g:894:4: rule__TemporalExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TemporalExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTemporalExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTemporalExp"


    // $ANTLR start "entryRuleUnaryTemporalExp"
    // InternalOCLX.g:903:1: entryRuleUnaryTemporalExp : ruleUnaryTemporalExp EOF ;
    public final void entryRuleUnaryTemporalExp() throws RecognitionException {
        try {
            // InternalOCLX.g:904:1: ( ruleUnaryTemporalExp EOF )
            // InternalOCLX.g:905:1: ruleUnaryTemporalExp EOF
            {
             before(grammarAccess.getUnaryTemporalExpRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryTemporalExp();

            state._fsp--;

             after(grammarAccess.getUnaryTemporalExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryTemporalExp"


    // $ANTLR start "ruleUnaryTemporalExp"
    // InternalOCLX.g:912:1: ruleUnaryTemporalExp : ( ( rule__UnaryTemporalExp__Group__0 ) ) ;
    public final void ruleUnaryTemporalExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:916:2: ( ( ( rule__UnaryTemporalExp__Group__0 ) ) )
            // InternalOCLX.g:917:2: ( ( rule__UnaryTemporalExp__Group__0 ) )
            {
            // InternalOCLX.g:917:2: ( ( rule__UnaryTemporalExp__Group__0 ) )
            // InternalOCLX.g:918:3: ( rule__UnaryTemporalExp__Group__0 )
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getGroup()); 
            // InternalOCLX.g:919:3: ( rule__UnaryTemporalExp__Group__0 )
            // InternalOCLX.g:919:4: rule__UnaryTemporalExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UnaryTemporalExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnaryTemporalExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryTemporalExp"


    // $ANTLR start "entryRuleUnaryTemporalOp"
    // InternalOCLX.g:928:1: entryRuleUnaryTemporalOp : ruleUnaryTemporalOp EOF ;
    public final void entryRuleUnaryTemporalOp() throws RecognitionException {
        try {
            // InternalOCLX.g:929:1: ( ruleUnaryTemporalOp EOF )
            // InternalOCLX.g:930:1: ruleUnaryTemporalOp EOF
            {
             before(grammarAccess.getUnaryTemporalOpRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryTemporalOp();

            state._fsp--;

             after(grammarAccess.getUnaryTemporalOpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryTemporalOp"


    // $ANTLR start "ruleUnaryTemporalOp"
    // InternalOCLX.g:937:1: ruleUnaryTemporalOp : ( ( rule__UnaryTemporalOp__Alternatives ) ) ;
    public final void ruleUnaryTemporalOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:941:2: ( ( ( rule__UnaryTemporalOp__Alternatives ) ) )
            // InternalOCLX.g:942:2: ( ( rule__UnaryTemporalOp__Alternatives ) )
            {
            // InternalOCLX.g:942:2: ( ( rule__UnaryTemporalOp__Alternatives ) )
            // InternalOCLX.g:943:3: ( rule__UnaryTemporalOp__Alternatives )
            {
             before(grammarAccess.getUnaryTemporalOpAccess().getAlternatives()); 
            // InternalOCLX.g:944:3: ( rule__UnaryTemporalOp__Alternatives )
            // InternalOCLX.g:944:4: rule__UnaryTemporalOp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__UnaryTemporalOp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnaryTemporalOpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryTemporalOp"


    // $ANTLR start "entryRuleTriggeredTemporalExp"
    // InternalOCLX.g:953:1: entryRuleTriggeredTemporalExp : ruleTriggeredTemporalExp EOF ;
    public final void entryRuleTriggeredTemporalExp() throws RecognitionException {
        try {
            // InternalOCLX.g:954:1: ( ruleTriggeredTemporalExp EOF )
            // InternalOCLX.g:955:1: ruleTriggeredTemporalExp EOF
            {
             before(grammarAccess.getTriggeredTemporalExpRule()); 
            pushFollow(FOLLOW_1);
            ruleTriggeredTemporalExp();

            state._fsp--;

             after(grammarAccess.getTriggeredTemporalExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTriggeredTemporalExp"


    // $ANTLR start "ruleTriggeredTemporalExp"
    // InternalOCLX.g:962:1: ruleTriggeredTemporalExp : ( ( rule__TriggeredTemporalExp__Alternatives ) ) ;
    public final void ruleTriggeredTemporalExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:966:2: ( ( ( rule__TriggeredTemporalExp__Alternatives ) ) )
            // InternalOCLX.g:967:2: ( ( rule__TriggeredTemporalExp__Alternatives ) )
            {
            // InternalOCLX.g:967:2: ( ( rule__TriggeredTemporalExp__Alternatives ) )
            // InternalOCLX.g:968:3: ( rule__TriggeredTemporalExp__Alternatives )
            {
             before(grammarAccess.getTriggeredTemporalExpAccess().getAlternatives()); 
            // InternalOCLX.g:969:3: ( rule__TriggeredTemporalExp__Alternatives )
            // InternalOCLX.g:969:4: rule__TriggeredTemporalExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TriggeredTemporalExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTriggeredTemporalExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTriggeredTemporalExp"


    // $ANTLR start "entryRuleTemporalAsLongAs"
    // InternalOCLX.g:978:1: entryRuleTemporalAsLongAs : ruleTemporalAsLongAs EOF ;
    public final void entryRuleTemporalAsLongAs() throws RecognitionException {
        try {
            // InternalOCLX.g:979:1: ( ruleTemporalAsLongAs EOF )
            // InternalOCLX.g:980:1: ruleTemporalAsLongAs EOF
            {
             before(grammarAccess.getTemporalAsLongAsRule()); 
            pushFollow(FOLLOW_1);
            ruleTemporalAsLongAs();

            state._fsp--;

             after(grammarAccess.getTemporalAsLongAsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTemporalAsLongAs"


    // $ANTLR start "ruleTemporalAsLongAs"
    // InternalOCLX.g:987:1: ruleTemporalAsLongAs : ( ( rule__TemporalAsLongAs__Group__0 ) ) ;
    public final void ruleTemporalAsLongAs() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:991:2: ( ( ( rule__TemporalAsLongAs__Group__0 ) ) )
            // InternalOCLX.g:992:2: ( ( rule__TemporalAsLongAs__Group__0 ) )
            {
            // InternalOCLX.g:992:2: ( ( rule__TemporalAsLongAs__Group__0 ) )
            // InternalOCLX.g:993:3: ( rule__TemporalAsLongAs__Group__0 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getGroup()); 
            // InternalOCLX.g:994:3: ( rule__TemporalAsLongAs__Group__0 )
            // InternalOCLX.g:994:4: rule__TemporalAsLongAs__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TemporalAsLongAs__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTemporalAsLongAsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTemporalAsLongAs"


    // $ANTLR start "entryRuleTemporalUntil"
    // InternalOCLX.g:1003:1: entryRuleTemporalUntil : ruleTemporalUntil EOF ;
    public final void entryRuleTemporalUntil() throws RecognitionException {
        try {
            // InternalOCLX.g:1004:1: ( ruleTemporalUntil EOF )
            // InternalOCLX.g:1005:1: ruleTemporalUntil EOF
            {
             before(grammarAccess.getTemporalUntilRule()); 
            pushFollow(FOLLOW_1);
            ruleTemporalUntil();

            state._fsp--;

             after(grammarAccess.getTemporalUntilRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTemporalUntil"


    // $ANTLR start "ruleTemporalUntil"
    // InternalOCLX.g:1012:1: ruleTemporalUntil : ( ( rule__TemporalUntil__Group__0 ) ) ;
    public final void ruleTemporalUntil() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1016:2: ( ( ( rule__TemporalUntil__Group__0 ) ) )
            // InternalOCLX.g:1017:2: ( ( rule__TemporalUntil__Group__0 ) )
            {
            // InternalOCLX.g:1017:2: ( ( rule__TemporalUntil__Group__0 ) )
            // InternalOCLX.g:1018:3: ( rule__TemporalUntil__Group__0 )
            {
             before(grammarAccess.getTemporalUntilAccess().getGroup()); 
            // InternalOCLX.g:1019:3: ( rule__TemporalUntil__Group__0 )
            // InternalOCLX.g:1019:4: rule__TemporalUntil__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TemporalUntil__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTemporalUntilAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTemporalUntil"


    // $ANTLR start "entryRuleTemporalEverytime"
    // InternalOCLX.g:1028:1: entryRuleTemporalEverytime : ruleTemporalEverytime EOF ;
    public final void entryRuleTemporalEverytime() throws RecognitionException {
        try {
            // InternalOCLX.g:1029:1: ( ruleTemporalEverytime EOF )
            // InternalOCLX.g:1030:1: ruleTemporalEverytime EOF
            {
             before(grammarAccess.getTemporalEverytimeRule()); 
            pushFollow(FOLLOW_1);
            ruleTemporalEverytime();

            state._fsp--;

             after(grammarAccess.getTemporalEverytimeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTemporalEverytime"


    // $ANTLR start "ruleTemporalEverytime"
    // InternalOCLX.g:1037:1: ruleTemporalEverytime : ( ( rule__TemporalEverytime__Group__0 ) ) ;
    public final void ruleTemporalEverytime() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1041:2: ( ( ( rule__TemporalEverytime__Group__0 ) ) )
            // InternalOCLX.g:1042:2: ( ( rule__TemporalEverytime__Group__0 ) )
            {
            // InternalOCLX.g:1042:2: ( ( rule__TemporalEverytime__Group__0 ) )
            // InternalOCLX.g:1043:3: ( rule__TemporalEverytime__Group__0 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getGroup()); 
            // InternalOCLX.g:1044:3: ( rule__TemporalEverytime__Group__0 )
            // InternalOCLX.g:1044:4: rule__TemporalEverytime__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TemporalEverytime__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTemporalEverytimeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTemporalEverytime"


    // $ANTLR start "entryRuleTemporalAtLeastOnce"
    // InternalOCLX.g:1053:1: entryRuleTemporalAtLeastOnce : ruleTemporalAtLeastOnce EOF ;
    public final void entryRuleTemporalAtLeastOnce() throws RecognitionException {
        try {
            // InternalOCLX.g:1054:1: ( ruleTemporalAtLeastOnce EOF )
            // InternalOCLX.g:1055:1: ruleTemporalAtLeastOnce EOF
            {
             before(grammarAccess.getTemporalAtLeastOnceRule()); 
            pushFollow(FOLLOW_1);
            ruleTemporalAtLeastOnce();

            state._fsp--;

             after(grammarAccess.getTemporalAtLeastOnceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTemporalAtLeastOnce"


    // $ANTLR start "ruleTemporalAtLeastOnce"
    // InternalOCLX.g:1062:1: ruleTemporalAtLeastOnce : ( ( rule__TemporalAtLeastOnce__Group__0 ) ) ;
    public final void ruleTemporalAtLeastOnce() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1066:2: ( ( ( rule__TemporalAtLeastOnce__Group__0 ) ) )
            // InternalOCLX.g:1067:2: ( ( rule__TemporalAtLeastOnce__Group__0 ) )
            {
            // InternalOCLX.g:1067:2: ( ( rule__TemporalAtLeastOnce__Group__0 ) )
            // InternalOCLX.g:1068:3: ( rule__TemporalAtLeastOnce__Group__0 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getGroup()); 
            // InternalOCLX.g:1069:3: ( rule__TemporalAtLeastOnce__Group__0 )
            // InternalOCLX.g:1069:4: rule__TemporalAtLeastOnce__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TemporalAtLeastOnce__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTemporalAtLeastOnceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTemporalAtLeastOnce"


    // $ANTLR start "entryRuleLegacyUntil"
    // InternalOCLX.g:1078:1: entryRuleLegacyUntil : ruleLegacyUntil EOF ;
    public final void entryRuleLegacyUntil() throws RecognitionException {
        try {
            // InternalOCLX.g:1079:1: ( ruleLegacyUntil EOF )
            // InternalOCLX.g:1080:1: ruleLegacyUntil EOF
            {
             before(grammarAccess.getLegacyUntilRule()); 
            pushFollow(FOLLOW_1);
            ruleLegacyUntil();

            state._fsp--;

             after(grammarAccess.getLegacyUntilRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLegacyUntil"


    // $ANTLR start "ruleLegacyUntil"
    // InternalOCLX.g:1087:1: ruleLegacyUntil : ( ( rule__LegacyUntil__Group__0 ) ) ;
    public final void ruleLegacyUntil() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1091:2: ( ( ( rule__LegacyUntil__Group__0 ) ) )
            // InternalOCLX.g:1092:2: ( ( rule__LegacyUntil__Group__0 ) )
            {
            // InternalOCLX.g:1092:2: ( ( rule__LegacyUntil__Group__0 ) )
            // InternalOCLX.g:1093:3: ( rule__LegacyUntil__Group__0 )
            {
             before(grammarAccess.getLegacyUntilAccess().getGroup()); 
            // InternalOCLX.g:1094:3: ( rule__LegacyUntil__Group__0 )
            // InternalOCLX.g:1094:4: rule__LegacyUntil__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LegacyUntil__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLegacyUntilAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLegacyUntil"


    // $ANTLR start "entryRuleLegacyAsSoonAs"
    // InternalOCLX.g:1103:1: entryRuleLegacyAsSoonAs : ruleLegacyAsSoonAs EOF ;
    public final void entryRuleLegacyAsSoonAs() throws RecognitionException {
        try {
            // InternalOCLX.g:1104:1: ( ruleLegacyAsSoonAs EOF )
            // InternalOCLX.g:1105:1: ruleLegacyAsSoonAs EOF
            {
             before(grammarAccess.getLegacyAsSoonAsRule()); 
            pushFollow(FOLLOW_1);
            ruleLegacyAsSoonAs();

            state._fsp--;

             after(grammarAccess.getLegacyAsSoonAsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLegacyAsSoonAs"


    // $ANTLR start "ruleLegacyAsSoonAs"
    // InternalOCLX.g:1112:1: ruleLegacyAsSoonAs : ( ( rule__LegacyAsSoonAs__Group__0 ) ) ;
    public final void ruleLegacyAsSoonAs() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1116:2: ( ( ( rule__LegacyAsSoonAs__Group__0 ) ) )
            // InternalOCLX.g:1117:2: ( ( rule__LegacyAsSoonAs__Group__0 ) )
            {
            // InternalOCLX.g:1117:2: ( ( rule__LegacyAsSoonAs__Group__0 ) )
            // InternalOCLX.g:1118:3: ( rule__LegacyAsSoonAs__Group__0 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getGroup()); 
            // InternalOCLX.g:1119:3: ( rule__LegacyAsSoonAs__Group__0 )
            // InternalOCLX.g:1119:4: rule__LegacyAsSoonAs__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LegacyAsSoonAs__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLegacyAsSoonAsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLegacyAsSoonAs"


    // $ANTLR start "entryRuleLegacyEverytime"
    // InternalOCLX.g:1128:1: entryRuleLegacyEverytime : ruleLegacyEverytime EOF ;
    public final void entryRuleLegacyEverytime() throws RecognitionException {
        try {
            // InternalOCLX.g:1129:1: ( ruleLegacyEverytime EOF )
            // InternalOCLX.g:1130:1: ruleLegacyEverytime EOF
            {
             before(grammarAccess.getLegacyEverytimeRule()); 
            pushFollow(FOLLOW_1);
            ruleLegacyEverytime();

            state._fsp--;

             after(grammarAccess.getLegacyEverytimeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLegacyEverytime"


    // $ANTLR start "ruleLegacyEverytime"
    // InternalOCLX.g:1137:1: ruleLegacyEverytime : ( ( rule__LegacyEverytime__Group__0 ) ) ;
    public final void ruleLegacyEverytime() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1141:2: ( ( ( rule__LegacyEverytime__Group__0 ) ) )
            // InternalOCLX.g:1142:2: ( ( rule__LegacyEverytime__Group__0 ) )
            {
            // InternalOCLX.g:1142:2: ( ( rule__LegacyEverytime__Group__0 ) )
            // InternalOCLX.g:1143:3: ( rule__LegacyEverytime__Group__0 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getGroup()); 
            // InternalOCLX.g:1144:3: ( rule__LegacyEverytime__Group__0 )
            // InternalOCLX.g:1144:4: rule__LegacyEverytime__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LegacyEverytime__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLegacyEverytimeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLegacyEverytime"


    // $ANTLR start "entryRulePath"
    // InternalOCLX.g:1153:1: entryRulePath : rulePath EOF ;
    public final void entryRulePath() throws RecognitionException {
        try {
            // InternalOCLX.g:1154:1: ( rulePath EOF )
            // InternalOCLX.g:1155:1: rulePath EOF
            {
             before(grammarAccess.getPathRule()); 
            pushFollow(FOLLOW_1);
            rulePath();

            state._fsp--;

             after(grammarAccess.getPathRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalOCLX.g:1162:1: rulePath : ( ( rule__Path__Group__0 ) ) ;
    public final void rulePath() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1166:2: ( ( ( rule__Path__Group__0 ) ) )
            // InternalOCLX.g:1167:2: ( ( rule__Path__Group__0 ) )
            {
            // InternalOCLX.g:1167:2: ( ( rule__Path__Group__0 ) )
            // InternalOCLX.g:1168:3: ( rule__Path__Group__0 )
            {
             before(grammarAccess.getPathAccess().getGroup()); 
            // InternalOCLX.g:1169:3: ( rule__Path__Group__0 )
            // InternalOCLX.g:1169:4: rule__Path__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Path__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPathAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleArgumentsExp"
    // InternalOCLX.g:1178:1: entryRuleArgumentsExp : ruleArgumentsExp EOF ;
    public final void entryRuleArgumentsExp() throws RecognitionException {
        try {
            // InternalOCLX.g:1179:1: ( ruleArgumentsExp EOF )
            // InternalOCLX.g:1180:1: ruleArgumentsExp EOF
            {
             before(grammarAccess.getArgumentsExpRule()); 
            pushFollow(FOLLOW_1);
            ruleArgumentsExp();

            state._fsp--;

             after(grammarAccess.getArgumentsExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArgumentsExp"


    // $ANTLR start "ruleArgumentsExp"
    // InternalOCLX.g:1187:1: ruleArgumentsExp : ( ( rule__ArgumentsExp__Group__0 ) ) ;
    public final void ruleArgumentsExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1191:2: ( ( ( rule__ArgumentsExp__Group__0 ) ) )
            // InternalOCLX.g:1192:2: ( ( rule__ArgumentsExp__Group__0 ) )
            {
            // InternalOCLX.g:1192:2: ( ( rule__ArgumentsExp__Group__0 ) )
            // InternalOCLX.g:1193:3: ( rule__ArgumentsExp__Group__0 )
            {
             before(grammarAccess.getArgumentsExpAccess().getGroup()); 
            // InternalOCLX.g:1194:3: ( rule__ArgumentsExp__Group__0 )
            // InternalOCLX.g:1194:4: rule__ArgumentsExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ArgumentsExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArgumentsExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArgumentsExp"


    // $ANTLR start "rule__PrefixedExp__Alternatives"
    // InternalOCLX.g:1202:1: rule__PrefixedExp__Alternatives : ( ( ( rule__PrefixedExp__Group_0__0 ) ) | ( rulePrimaryExp ) );
    public final void rule__PrefixedExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1206:1: ( ( ( rule__PrefixedExp__Group_0__0 ) ) | ( rulePrimaryExp ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==25||LA2_0==28) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID||(LA2_0>=RULE_INT && LA2_0<=RULE_STRING)||(LA2_0>=41 && LA2_0<=43)||LA2_0==52||LA2_0==54||(LA2_0>=58 && LA2_0<=59)||(LA2_0>=63 && LA2_0<=70)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalOCLX.g:1207:2: ( ( rule__PrefixedExp__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1207:2: ( ( rule__PrefixedExp__Group_0__0 ) )
                    // InternalOCLX.g:1208:3: ( rule__PrefixedExp__Group_0__0 )
                    {
                     before(grammarAccess.getPrefixedExpAccess().getGroup_0()); 
                    // InternalOCLX.g:1209:3: ( rule__PrefixedExp__Group_0__0 )
                    // InternalOCLX.g:1209:4: rule__PrefixedExp__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrefixedExp__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrefixedExpAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1213:2: ( rulePrimaryExp )
                    {
                    // InternalOCLX.g:1213:2: ( rulePrimaryExp )
                    // InternalOCLX.g:1214:3: rulePrimaryExp
                    {
                     before(grammarAccess.getPrefixedExpAccess().getPrimaryExpParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePrimaryExp();

                    state._fsp--;

                     after(grammarAccess.getPrefixedExpAccess().getPrimaryExpParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixedExp__Alternatives"


    // $ANTLR start "rule__InfixOperator__Alternatives"
    // InternalOCLX.g:1223:1: rule__InfixOperator__Alternatives : ( ( ruleBooleanOperator ) | ( ruleMathOperator ) );
    public final void rule__InfixOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1227:1: ( ( ruleBooleanOperator ) | ( ruleMathOperator ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=12 && LA3_0<=21)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=22 && LA3_0<=25)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalOCLX.g:1228:2: ( ruleBooleanOperator )
                    {
                    // InternalOCLX.g:1228:2: ( ruleBooleanOperator )
                    // InternalOCLX.g:1229:3: ruleBooleanOperator
                    {
                     before(grammarAccess.getInfixOperatorAccess().getBooleanOperatorParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanOperator();

                    state._fsp--;

                     after(grammarAccess.getInfixOperatorAccess().getBooleanOperatorParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1234:2: ( ruleMathOperator )
                    {
                    // InternalOCLX.g:1234:2: ( ruleMathOperator )
                    // InternalOCLX.g:1235:3: ruleMathOperator
                    {
                     before(grammarAccess.getInfixOperatorAccess().getMathOperatorParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleMathOperator();

                    state._fsp--;

                     after(grammarAccess.getInfixOperatorAccess().getMathOperatorParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfixOperator__Alternatives"


    // $ANTLR start "rule__BooleanOperator__OpAlternatives_0"
    // InternalOCLX.g:1244:1: rule__BooleanOperator__OpAlternatives_0 : ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '<>' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) );
    public final void rule__BooleanOperator__OpAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1248:1: ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '<>' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) )
            int alt4=10;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt4=1;
                }
                break;
            case 13:
                {
                alt4=2;
                }
                break;
            case 14:
                {
                alt4=3;
                }
                break;
            case 15:
                {
                alt4=4;
                }
                break;
            case 16:
                {
                alt4=5;
                }
                break;
            case 17:
                {
                alt4=6;
                }
                break;
            case 18:
                {
                alt4=7;
                }
                break;
            case 19:
                {
                alt4=8;
                }
                break;
            case 20:
                {
                alt4=9;
                }
                break;
            case 21:
                {
                alt4=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalOCLX.g:1249:2: ( '>' )
                    {
                    // InternalOCLX.g:1249:2: ( '>' )
                    // InternalOCLX.g:1250:3: '>'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1255:2: ( '<' )
                    {
                    // InternalOCLX.g:1255:2: ( '<' )
                    // InternalOCLX.g:1256:3: '<'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1261:2: ( '>=' )
                    {
                    // InternalOCLX.g:1261:2: ( '>=' )
                    // InternalOCLX.g:1262:3: '>='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1267:2: ( '<=' )
                    {
                    // InternalOCLX.g:1267:2: ( '<=' )
                    // InternalOCLX.g:1268:3: '<='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1273:2: ( '=' )
                    {
                    // InternalOCLX.g:1273:2: ( '=' )
                    // InternalOCLX.g:1274:3: '='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOCLX.g:1279:2: ( '<>' )
                    {
                    // InternalOCLX.g:1279:2: ( '<>' )
                    // InternalOCLX.g:1280:3: '<>'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignGreaterThanSignKeyword_0_5()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignGreaterThanSignKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalOCLX.g:1285:2: ( 'and' )
                    {
                    // InternalOCLX.g:1285:2: ( 'and' )
                    // InternalOCLX.g:1286:3: 'and'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalOCLX.g:1291:2: ( 'or' )
                    {
                    // InternalOCLX.g:1291:2: ( 'or' )
                    // InternalOCLX.g:1292:3: 'or'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalOCLX.g:1297:2: ( 'xor' )
                    {
                    // InternalOCLX.g:1297:2: ( 'xor' )
                    // InternalOCLX.g:1298:3: 'xor'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalOCLX.g:1303:2: ( 'implies' )
                    {
                    // InternalOCLX.g:1303:2: ( 'implies' )
                    // InternalOCLX.g:1304:3: 'implies'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpImpliesKeyword_0_9()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpImpliesKeyword_0_9()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanOperator__OpAlternatives_0"


    // $ANTLR start "rule__MathOperator__OpAlternatives_0"
    // InternalOCLX.g:1313:1: rule__MathOperator__OpAlternatives_0 : ( ( '*' ) | ( '/' ) | ( '+' ) | ( '-' ) );
    public final void rule__MathOperator__OpAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1317:1: ( ( '*' ) | ( '/' ) | ( '+' ) | ( '-' ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt5=1;
                }
                break;
            case 23:
                {
                alt5=2;
                }
                break;
            case 24:
                {
                alt5=3;
                }
                break;
            case 25:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalOCLX.g:1318:2: ( '*' )
                    {
                    // InternalOCLX.g:1318:2: ( '*' )
                    // InternalOCLX.g:1319:3: '*'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1324:2: ( '/' )
                    {
                    // InternalOCLX.g:1324:2: ( '/' )
                    // InternalOCLX.g:1325:3: '/'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1330:2: ( '+' )
                    {
                    // InternalOCLX.g:1330:2: ( '+' )
                    // InternalOCLX.g:1331:3: '+'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1336:2: ( '-' )
                    {
                    // InternalOCLX.g:1336:2: ( '-' )
                    // InternalOCLX.g:1337:3: '-'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpHyphenMinusKeyword_0_3()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpHyphenMinusKeyword_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MathOperator__OpAlternatives_0"


    // $ANTLR start "rule__NavigationOperator__NameAlternatives_0"
    // InternalOCLX.g:1346:1: rule__NavigationOperator__NameAlternatives_0 : ( ( '.' ) | ( '->' ) );
    public final void rule__NavigationOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1350:1: ( ( '.' ) | ( '->' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==26) ) {
                alt6=1;
            }
            else if ( (LA6_0==27) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalOCLX.g:1351:2: ( '.' )
                    {
                    // InternalOCLX.g:1351:2: ( '.' )
                    // InternalOCLX.g:1352:3: '.'
                    {
                     before(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1357:2: ( '->' )
                    {
                    // InternalOCLX.g:1357:2: ( '->' )
                    // InternalOCLX.g:1358:3: '->'
                    {
                     before(grammarAccess.getNavigationOperatorAccess().getNameHyphenMinusGreaterThanSignKeyword_0_1()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getNavigationOperatorAccess().getNameHyphenMinusGreaterThanSignKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationOperator__NameAlternatives_0"


    // $ANTLR start "rule__UnaryOperator__NameAlternatives_0"
    // InternalOCLX.g:1367:1: rule__UnaryOperator__NameAlternatives_0 : ( ( '-' ) | ( 'not' ) );
    public final void rule__UnaryOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1371:1: ( ( '-' ) | ( 'not' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==25) ) {
                alt7=1;
            }
            else if ( (LA7_0==28) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalOCLX.g:1372:2: ( '-' )
                    {
                    // InternalOCLX.g:1372:2: ( '-' )
                    // InternalOCLX.g:1373:3: '-'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1378:2: ( 'not' )
                    {
                    // InternalOCLX.g:1378:2: ( 'not' )
                    // InternalOCLX.g:1379:3: 'not'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getNameNotKeyword_0_1()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getUnaryOperatorAccess().getNameNotKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperator__NameAlternatives_0"


    // $ANTLR start "rule__PrimaryExp__Alternatives"
    // InternalOCLX.g:1388:1: rule__PrimaryExp__Alternatives : ( ( ruleNestedExp ) | ( ( rule__PrimaryExp__Group_1__0 ) ) | ( rulePrimitiveLiteralExp ) | ( ruleTemporalExp ) );
    public final void rule__PrimaryExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1392:1: ( ( ruleNestedExp ) | ( ( rule__PrimaryExp__Group_1__0 ) ) | ( rulePrimitiveLiteralExp ) | ( ruleTemporalExp ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt8=1;
                }
                break;
            case RULE_ID:
            case 63:
                {
                alt8=2;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 54:
            case 64:
            case 65:
                {
                alt8=3;
                }
                break;
            case 41:
            case 42:
            case 43:
            case 58:
            case 59:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalOCLX.g:1393:2: ( ruleNestedExp )
                    {
                    // InternalOCLX.g:1393:2: ( ruleNestedExp )
                    // InternalOCLX.g:1394:3: ruleNestedExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getNestedExpParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNestedExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getNestedExpParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1399:2: ( ( rule__PrimaryExp__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1399:2: ( ( rule__PrimaryExp__Group_1__0 ) )
                    // InternalOCLX.g:1400:3: ( rule__PrimaryExp__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpAccess().getGroup_1()); 
                    // InternalOCLX.g:1401:3: ( rule__PrimaryExp__Group_1__0 )
                    // InternalOCLX.g:1401:4: rule__PrimaryExp__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__PrimaryExp__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryExpAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1405:2: ( rulePrimitiveLiteralExp )
                    {
                    // InternalOCLX.g:1405:2: ( rulePrimitiveLiteralExp )
                    // InternalOCLX.g:1406:3: rulePrimitiveLiteralExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getPrimitiveLiteralExpParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    rulePrimitiveLiteralExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getPrimitiveLiteralExpParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1411:2: ( ruleTemporalExp )
                    {
                    // InternalOCLX.g:1411:2: ( ruleTemporalExp )
                    // InternalOCLX.g:1412:3: ruleTemporalExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getTemporalExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleTemporalExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getTemporalExpParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__Alternatives"


    // $ANTLR start "rule__VarOrSelfExp__Alternatives"
    // InternalOCLX.g:1421:1: rule__VarOrSelfExp__Alternatives : ( ( ruleSelfExp ) | ( ruleVarReference ) );
    public final void rule__VarOrSelfExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1425:1: ( ( ruleSelfExp ) | ( ruleVarReference ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==63) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalOCLX.g:1426:2: ( ruleSelfExp )
                    {
                    // InternalOCLX.g:1426:2: ( ruleSelfExp )
                    // InternalOCLX.g:1427:3: ruleSelfExp
                    {
                     before(grammarAccess.getVarOrSelfExpAccess().getSelfExpParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSelfExp();

                    state._fsp--;

                     after(grammarAccess.getVarOrSelfExpAccess().getSelfExpParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1432:2: ( ruleVarReference )
                    {
                    // InternalOCLX.g:1432:2: ( ruleVarReference )
                    // InternalOCLX.g:1433:3: ruleVarReference
                    {
                     before(grammarAccess.getVarOrSelfExpAccess().getVarReferenceParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleVarReference();

                    state._fsp--;

                     after(grammarAccess.getVarOrSelfExpAccess().getVarReferenceParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarOrSelfExp__Alternatives"


    // $ANTLR start "rule__PrimitiveLiteralExp__Alternatives"
    // InternalOCLX.g:1442:1: rule__PrimitiveLiteralExp__Alternatives : ( ( ruleNumberLiteralExp ) | ( ruleStringLiteralExp ) | ( ruleBooleanLiteralExp ) | ( ruleNullLiteralExp ) );
    public final void rule__PrimitiveLiteralExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1446:1: ( ( ruleNumberLiteralExp ) | ( ruleStringLiteralExp ) | ( ruleBooleanLiteralExp ) | ( ruleNullLiteralExp ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt10=1;
                }
                break;
            case RULE_STRING:
                {
                alt10=2;
                }
                break;
            case 64:
            case 65:
                {
                alt10=3;
                }
                break;
            case 54:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalOCLX.g:1447:2: ( ruleNumberLiteralExp )
                    {
                    // InternalOCLX.g:1447:2: ( ruleNumberLiteralExp )
                    // InternalOCLX.g:1448:3: ruleNumberLiteralExp
                    {
                     before(grammarAccess.getPrimitiveLiteralExpAccess().getNumberLiteralExpParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNumberLiteralExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveLiteralExpAccess().getNumberLiteralExpParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1453:2: ( ruleStringLiteralExp )
                    {
                    // InternalOCLX.g:1453:2: ( ruleStringLiteralExp )
                    // InternalOCLX.g:1454:3: ruleStringLiteralExp
                    {
                     before(grammarAccess.getPrimitiveLiteralExpAccess().getStringLiteralExpParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleStringLiteralExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveLiteralExpAccess().getStringLiteralExpParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1459:2: ( ruleBooleanLiteralExp )
                    {
                    // InternalOCLX.g:1459:2: ( ruleBooleanLiteralExp )
                    // InternalOCLX.g:1460:3: ruleBooleanLiteralExp
                    {
                     before(grammarAccess.getPrimitiveLiteralExpAccess().getBooleanLiteralExpParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanLiteralExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveLiteralExpAccess().getBooleanLiteralExpParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1465:2: ( ruleNullLiteralExp )
                    {
                    // InternalOCLX.g:1465:2: ( ruleNullLiteralExp )
                    // InternalOCLX.g:1466:3: ruleNullLiteralExp
                    {
                     before(grammarAccess.getPrimitiveLiteralExpAccess().getNullLiteralExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleNullLiteralExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveLiteralExpAccess().getNullLiteralExpParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveLiteralExp__Alternatives"


    // $ANTLR start "rule__BooleanLiteralExp__Alternatives"
    // InternalOCLX.g:1475:1: rule__BooleanLiteralExp__Alternatives : ( ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) ) | ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) ) );
    public final void rule__BooleanLiteralExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1479:1: ( ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) ) | ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==64) ) {
                alt11=1;
            }
            else if ( (LA11_0==65) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalOCLX.g:1480:2: ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) )
                    {
                    // InternalOCLX.g:1480:2: ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) )
                    // InternalOCLX.g:1481:3: ( rule__BooleanLiteralExp__ValueAssignment_0 )
                    {
                     before(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_0()); 
                    // InternalOCLX.g:1482:3: ( rule__BooleanLiteralExp__ValueAssignment_0 )
                    // InternalOCLX.g:1482:4: rule__BooleanLiteralExp__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanLiteralExp__ValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1486:2: ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) )
                    {
                    // InternalOCLX.g:1486:2: ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) )
                    // InternalOCLX.g:1487:3: ( rule__BooleanLiteralExp__ValueAssignment_1 )
                    {
                     before(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_1()); 
                    // InternalOCLX.g:1488:3: ( rule__BooleanLiteralExp__ValueAssignment_1 )
                    // InternalOCLX.g:1488:4: rule__BooleanLiteralExp__ValueAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanLiteralExp__ValueAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralExp__Alternatives"


    // $ANTLR start "rule__MethodExp__Alternatives"
    // InternalOCLX.g:1496:1: rule__MethodExp__Alternatives : ( ( rulePropertyAccess ) | ( ruleMethodCall ) | ( ruleCollectionIterator ) | ( ruleTypeCall ) );
    public final void rule__MethodExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1500:1: ( ( rulePropertyAccess ) | ( ruleMethodCall ) | ( ruleCollectionIterator ) | ( ruleTypeCall ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==EOF||(LA12_1>=12 && LA12_1<=27)||LA12_1==48||LA12_1==53||(LA12_1>=58 && LA12_1<=62)) ) {
                    alt12=1;
                }
                else if ( (LA12_1==52||LA12_1==57) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
                }
                break;
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
                {
                alt12=3;
                }
                break;
            case 34:
            case 35:
            case 36:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalOCLX.g:1501:2: ( rulePropertyAccess )
                    {
                    // InternalOCLX.g:1501:2: ( rulePropertyAccess )
                    // InternalOCLX.g:1502:3: rulePropertyAccess
                    {
                     before(grammarAccess.getMethodExpAccess().getPropertyAccessParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePropertyAccess();

                    state._fsp--;

                     after(grammarAccess.getMethodExpAccess().getPropertyAccessParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1507:2: ( ruleMethodCall )
                    {
                    // InternalOCLX.g:1507:2: ( ruleMethodCall )
                    // InternalOCLX.g:1508:3: ruleMethodCall
                    {
                     before(grammarAccess.getMethodExpAccess().getMethodCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleMethodCall();

                    state._fsp--;

                     after(grammarAccess.getMethodExpAccess().getMethodCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1513:2: ( ruleCollectionIterator )
                    {
                    // InternalOCLX.g:1513:2: ( ruleCollectionIterator )
                    // InternalOCLX.g:1514:3: ruleCollectionIterator
                    {
                     before(grammarAccess.getMethodExpAccess().getCollectionIteratorParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleCollectionIterator();

                    state._fsp--;

                     after(grammarAccess.getMethodExpAccess().getCollectionIteratorParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1519:2: ( ruleTypeCall )
                    {
                    // InternalOCLX.g:1519:2: ( ruleTypeCall )
                    // InternalOCLX.g:1520:3: ruleTypeCall
                    {
                     before(grammarAccess.getMethodExpAccess().getTypeCallParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleTypeCall();

                    state._fsp--;

                     after(grammarAccess.getMethodExpAccess().getTypeCallParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodExp__Alternatives"


    // $ANTLR start "rule__IteratorName__NameAlternatives_0"
    // InternalOCLX.g:1529:1: rule__IteratorName__NameAlternatives_0 : ( ( 'forAll' ) | ( 'exists' ) | ( 'collect' ) | ( 'reject' ) | ( 'select' ) );
    public final void rule__IteratorName__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1533:1: ( ( 'forAll' ) | ( 'exists' ) | ( 'collect' ) | ( 'reject' ) | ( 'select' ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt13=1;
                }
                break;
            case 30:
                {
                alt13=2;
                }
                break;
            case 31:
                {
                alt13=3;
                }
                break;
            case 32:
                {
                alt13=4;
                }
                break;
            case 33:
                {
                alt13=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalOCLX.g:1534:2: ( 'forAll' )
                    {
                    // InternalOCLX.g:1534:2: ( 'forAll' )
                    // InternalOCLX.g:1535:3: 'forAll'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameForAllKeyword_0_0()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameForAllKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1540:2: ( 'exists' )
                    {
                    // InternalOCLX.g:1540:2: ( 'exists' )
                    // InternalOCLX.g:1541:3: 'exists'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameExistsKeyword_0_1()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameExistsKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1546:2: ( 'collect' )
                    {
                    // InternalOCLX.g:1546:2: ( 'collect' )
                    // InternalOCLX.g:1547:3: 'collect'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameCollectKeyword_0_2()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameCollectKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1552:2: ( 'reject' )
                    {
                    // InternalOCLX.g:1552:2: ( 'reject' )
                    // InternalOCLX.g:1553:3: 'reject'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameRejectKeyword_0_3()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameRejectKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1558:2: ( 'select' )
                    {
                    // InternalOCLX.g:1558:2: ( 'select' )
                    // InternalOCLX.g:1559:3: 'select'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameSelectKeyword_0_4()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameSelectKeyword_0_4()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorName__NameAlternatives_0"


    // $ANTLR start "rule__IteratorVarDeclaration__Alternatives"
    // InternalOCLX.g:1568:1: rule__IteratorVarDeclaration__Alternatives : ( ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) ) | ( ( rule__IteratorVarDeclaration__Group_1__0 ) ) );
    public final void rule__IteratorVarDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1572:1: ( ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) ) | ( ( rule__IteratorVarDeclaration__Group_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==56) ) {
                    alt14=2;
                }
                else if ( (LA14_1==EOF||LA14_1==55) ) {
                    alt14=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalOCLX.g:1573:2: ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) )
                    {
                    // InternalOCLX.g:1573:2: ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) )
                    // InternalOCLX.g:1574:3: ( rule__IteratorVarDeclaration__NameAssignment_0 )
                    {
                     before(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_0()); 
                    // InternalOCLX.g:1575:3: ( rule__IteratorVarDeclaration__NameAssignment_0 )
                    // InternalOCLX.g:1575:4: rule__IteratorVarDeclaration__NameAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IteratorVarDeclaration__NameAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1579:2: ( ( rule__IteratorVarDeclaration__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1579:2: ( ( rule__IteratorVarDeclaration__Group_1__0 ) )
                    // InternalOCLX.g:1580:3: ( rule__IteratorVarDeclaration__Group_1__0 )
                    {
                     before(grammarAccess.getIteratorVarDeclarationAccess().getGroup_1()); 
                    // InternalOCLX.g:1581:3: ( rule__IteratorVarDeclaration__Group_1__0 )
                    // InternalOCLX.g:1581:4: rule__IteratorVarDeclaration__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IteratorVarDeclaration__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getIteratorVarDeclarationAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorVarDeclaration__Alternatives"


    // $ANTLR start "rule__MethodCall__Alternatives"
    // InternalOCLX.g:1589:1: rule__MethodCall__Alternatives : ( ( ( rule__MethodCall__Group_0__0 ) ) | ( ( rule__MethodCall__Group_1__0 ) ) );
    public final void rule__MethodCall__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1593:1: ( ( ( rule__MethodCall__Group_0__0 ) ) | ( ( rule__MethodCall__Group_1__0 ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==57) ) {
                    alt15=1;
                }
                else if ( (LA15_1==52) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalOCLX.g:1594:2: ( ( rule__MethodCall__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1594:2: ( ( rule__MethodCall__Group_0__0 ) )
                    // InternalOCLX.g:1595:3: ( rule__MethodCall__Group_0__0 )
                    {
                     before(grammarAccess.getMethodCallAccess().getGroup_0()); 
                    // InternalOCLX.g:1596:3: ( rule__MethodCall__Group_0__0 )
                    // InternalOCLX.g:1596:4: rule__MethodCall__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MethodCall__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMethodCallAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1600:2: ( ( rule__MethodCall__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1600:2: ( ( rule__MethodCall__Group_1__0 ) )
                    // InternalOCLX.g:1601:3: ( rule__MethodCall__Group_1__0 )
                    {
                     before(grammarAccess.getMethodCallAccess().getGroup_1()); 
                    // InternalOCLX.g:1602:3: ( rule__MethodCall__Group_1__0 )
                    // InternalOCLX.g:1602:4: rule__MethodCall__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MethodCall__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMethodCallAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Alternatives"


    // $ANTLR start "rule__TypeCall__NameAlternatives_0_0"
    // InternalOCLX.g:1610:1: rule__TypeCall__NameAlternatives_0_0 : ( ( 'asType' ) | ( 'isTypeOf' ) | ( 'isKindOf' ) );
    public final void rule__TypeCall__NameAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1614:1: ( ( 'asType' ) | ( 'isTypeOf' ) | ( 'isKindOf' ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt16=1;
                }
                break;
            case 35:
                {
                alt16=2;
                }
                break;
            case 36:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalOCLX.g:1615:2: ( 'asType' )
                    {
                    // InternalOCLX.g:1615:2: ( 'asType' )
                    // InternalOCLX.g:1616:3: 'asType'
                    {
                     before(grammarAccess.getTypeCallAccess().getNameAsTypeKeyword_0_0_0()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getTypeCallAccess().getNameAsTypeKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1621:2: ( 'isTypeOf' )
                    {
                    // InternalOCLX.g:1621:2: ( 'isTypeOf' )
                    // InternalOCLX.g:1622:3: 'isTypeOf'
                    {
                     before(grammarAccess.getTypeCallAccess().getNameIsTypeOfKeyword_0_0_1()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getTypeCallAccess().getNameIsTypeOfKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1627:2: ( 'isKindOf' )
                    {
                    // InternalOCLX.g:1627:2: ( 'isKindOf' )
                    // InternalOCLX.g:1628:3: 'isKindOf'
                    {
                     before(grammarAccess.getTypeCallAccess().getNameIsKindOfKeyword_0_0_2()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getTypeCallAccess().getNameIsKindOfKeyword_0_0_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeCall__NameAlternatives_0_0"


    // $ANTLR start "rule__TypeExp__Alternatives"
    // InternalOCLX.g:1637:1: rule__TypeExp__Alternatives : ( ( ( rule__TypeExp__Group_0__0 ) ) | ( ( rule__TypeExp__Group_1__0 ) ) );
    public final void rule__TypeExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1641:1: ( ( ( rule__TypeExp__Group_0__0 ) ) | ( ( rule__TypeExp__Group_1__0 ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==13) ) {
                alt17=1;
            }
            else if ( ((LA17_0>=37 && LA17_0<=40)) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalOCLX.g:1642:2: ( ( rule__TypeExp__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1642:2: ( ( rule__TypeExp__Group_0__0 ) )
                    // InternalOCLX.g:1643:3: ( rule__TypeExp__Group_0__0 )
                    {
                     before(grammarAccess.getTypeExpAccess().getGroup_0()); 
                    // InternalOCLX.g:1644:3: ( rule__TypeExp__Group_0__0 )
                    // InternalOCLX.g:1644:4: rule__TypeExp__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeExp__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeExpAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1648:2: ( ( rule__TypeExp__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1648:2: ( ( rule__TypeExp__Group_1__0 ) )
                    // InternalOCLX.g:1649:3: ( rule__TypeExp__Group_1__0 )
                    {
                     before(grammarAccess.getTypeExpAccess().getGroup_1()); 
                    // InternalOCLX.g:1650:3: ( rule__TypeExp__Group_1__0 )
                    // InternalOCLX.g:1650:4: rule__TypeExp__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TypeExp__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTypeExpAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Alternatives"


    // $ANTLR start "rule__CollectionTypeIdentifier__NameAlternatives_0"
    // InternalOCLX.g:1658:1: rule__CollectionTypeIdentifier__NameAlternatives_0 : ( ( 'set' ) | ( 'list' ) | ( 'map' ) | ( 'collection' ) );
    public final void rule__CollectionTypeIdentifier__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1662:1: ( ( 'set' ) | ( 'list' ) | ( 'map' ) | ( 'collection' ) )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt18=1;
                }
                break;
            case 38:
                {
                alt18=2;
                }
                break;
            case 39:
                {
                alt18=3;
                }
                break;
            case 40:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalOCLX.g:1663:2: ( 'set' )
                    {
                    // InternalOCLX.g:1663:2: ( 'set' )
                    // InternalOCLX.g:1664:3: 'set'
                    {
                     before(grammarAccess.getCollectionTypeIdentifierAccess().getNameSetKeyword_0_0()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getCollectionTypeIdentifierAccess().getNameSetKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1669:2: ( 'list' )
                    {
                    // InternalOCLX.g:1669:2: ( 'list' )
                    // InternalOCLX.g:1670:3: 'list'
                    {
                     before(grammarAccess.getCollectionTypeIdentifierAccess().getNameListKeyword_0_1()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getCollectionTypeIdentifierAccess().getNameListKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1675:2: ( 'map' )
                    {
                    // InternalOCLX.g:1675:2: ( 'map' )
                    // InternalOCLX.g:1676:3: 'map'
                    {
                     before(grammarAccess.getCollectionTypeIdentifierAccess().getNameMapKeyword_0_2()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getCollectionTypeIdentifierAccess().getNameMapKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1681:2: ( 'collection' )
                    {
                    // InternalOCLX.g:1681:2: ( 'collection' )
                    // InternalOCLX.g:1682:3: 'collection'
                    {
                     before(grammarAccess.getCollectionTypeIdentifierAccess().getNameCollectionKeyword_0_3()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getCollectionTypeIdentifierAccess().getNameCollectionKeyword_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionTypeIdentifier__NameAlternatives_0"


    // $ANTLR start "rule__TemporalExp__Alternatives"
    // InternalOCLX.g:1691:1: rule__TemporalExp__Alternatives : ( ( ruleUnaryTemporalExp ) | ( ruleTriggeredTemporalExp ) );
    public final void rule__TemporalExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1695:1: ( ( ruleUnaryTemporalExp ) | ( ruleTriggeredTemporalExp ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=41 && LA19_0<=43)) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=58 && LA19_0<=59)||(LA19_0>=66 && LA19_0<=70)) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalOCLX.g:1696:2: ( ruleUnaryTemporalExp )
                    {
                    // InternalOCLX.g:1696:2: ( ruleUnaryTemporalExp )
                    // InternalOCLX.g:1697:3: ruleUnaryTemporalExp
                    {
                     before(grammarAccess.getTemporalExpAccess().getUnaryTemporalExpParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleUnaryTemporalExp();

                    state._fsp--;

                     after(grammarAccess.getTemporalExpAccess().getUnaryTemporalExpParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1702:2: ( ruleTriggeredTemporalExp )
                    {
                    // InternalOCLX.g:1702:2: ( ruleTriggeredTemporalExp )
                    // InternalOCLX.g:1703:3: ruleTriggeredTemporalExp
                    {
                     before(grammarAccess.getTemporalExpAccess().getTriggeredTemporalExpParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleTriggeredTemporalExp();

                    state._fsp--;

                     after(grammarAccess.getTemporalExpAccess().getTriggeredTemporalExpParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalExp__Alternatives"


    // $ANTLR start "rule__UnaryTemporalOp__Alternatives"
    // InternalOCLX.g:1712:1: rule__UnaryTemporalOp__Alternatives : ( ( 'next' ) | ( 'always' ) | ( 'eventually' ) );
    public final void rule__UnaryTemporalOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1716:1: ( ( 'next' ) | ( 'always' ) | ( 'eventually' ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt20=1;
                }
                break;
            case 42:
                {
                alt20=2;
                }
                break;
            case 43:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalOCLX.g:1717:2: ( 'next' )
                    {
                    // InternalOCLX.g:1717:2: ( 'next' )
                    // InternalOCLX.g:1718:3: 'next'
                    {
                     before(grammarAccess.getUnaryTemporalOpAccess().getNextKeyword_0()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getUnaryTemporalOpAccess().getNextKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1723:2: ( 'always' )
                    {
                    // InternalOCLX.g:1723:2: ( 'always' )
                    // InternalOCLX.g:1724:3: 'always'
                    {
                     before(grammarAccess.getUnaryTemporalOpAccess().getAlwaysKeyword_1()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getUnaryTemporalOpAccess().getAlwaysKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1729:2: ( 'eventually' )
                    {
                    // InternalOCLX.g:1729:2: ( 'eventually' )
                    // InternalOCLX.g:1730:3: 'eventually'
                    {
                     before(grammarAccess.getUnaryTemporalOpAccess().getEventuallyKeyword_2()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getUnaryTemporalOpAccess().getEventuallyKeyword_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryTemporalOp__Alternatives"


    // $ANTLR start "rule__TriggeredTemporalExp__Alternatives"
    // InternalOCLX.g:1739:1: rule__TriggeredTemporalExp__Alternatives : ( ( ruleTemporalAsLongAs ) | ( ruleTemporalUntil ) | ( ruleTemporalEverytime ) | ( ruleTemporalAtLeastOnce ) | ( ruleLegacyUntil ) | ( ruleLegacyAsSoonAs ) | ( ruleLegacyEverytime ) );
    public final void rule__TriggeredTemporalExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1743:1: ( ( ruleTemporalAsLongAs ) | ( ruleTemporalUntil ) | ( ruleTemporalEverytime ) | ( ruleTemporalAtLeastOnce ) | ( ruleLegacyUntil ) | ( ruleLegacyAsSoonAs ) | ( ruleLegacyEverytime ) )
            int alt21=7;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt21=1;
                }
                break;
            case 58:
                {
                alt21=2;
                }
                break;
            case 66:
                {
                alt21=3;
                }
                break;
            case 67:
                {
                alt21=4;
                }
                break;
            case 68:
                {
                alt21=5;
                }
                break;
            case 69:
                {
                alt21=6;
                }
                break;
            case 70:
                {
                alt21=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalOCLX.g:1744:2: ( ruleTemporalAsLongAs )
                    {
                    // InternalOCLX.g:1744:2: ( ruleTemporalAsLongAs )
                    // InternalOCLX.g:1745:3: ruleTemporalAsLongAs
                    {
                     before(grammarAccess.getTriggeredTemporalExpAccess().getTemporalAsLongAsParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleTemporalAsLongAs();

                    state._fsp--;

                     after(grammarAccess.getTriggeredTemporalExpAccess().getTemporalAsLongAsParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1750:2: ( ruleTemporalUntil )
                    {
                    // InternalOCLX.g:1750:2: ( ruleTemporalUntil )
                    // InternalOCLX.g:1751:3: ruleTemporalUntil
                    {
                     before(grammarAccess.getTriggeredTemporalExpAccess().getTemporalUntilParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleTemporalUntil();

                    state._fsp--;

                     after(grammarAccess.getTriggeredTemporalExpAccess().getTemporalUntilParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1756:2: ( ruleTemporalEverytime )
                    {
                    // InternalOCLX.g:1756:2: ( ruleTemporalEverytime )
                    // InternalOCLX.g:1757:3: ruleTemporalEverytime
                    {
                     before(grammarAccess.getTriggeredTemporalExpAccess().getTemporalEverytimeParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleTemporalEverytime();

                    state._fsp--;

                     after(grammarAccess.getTriggeredTemporalExpAccess().getTemporalEverytimeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1762:2: ( ruleTemporalAtLeastOnce )
                    {
                    // InternalOCLX.g:1762:2: ( ruleTemporalAtLeastOnce )
                    // InternalOCLX.g:1763:3: ruleTemporalAtLeastOnce
                    {
                     before(grammarAccess.getTriggeredTemporalExpAccess().getTemporalAtLeastOnceParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleTemporalAtLeastOnce();

                    state._fsp--;

                     after(grammarAccess.getTriggeredTemporalExpAccess().getTemporalAtLeastOnceParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1768:2: ( ruleLegacyUntil )
                    {
                    // InternalOCLX.g:1768:2: ( ruleLegacyUntil )
                    // InternalOCLX.g:1769:3: ruleLegacyUntil
                    {
                     before(grammarAccess.getTriggeredTemporalExpAccess().getLegacyUntilParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleLegacyUntil();

                    state._fsp--;

                     after(grammarAccess.getTriggeredTemporalExpAccess().getLegacyUntilParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOCLX.g:1774:2: ( ruleLegacyAsSoonAs )
                    {
                    // InternalOCLX.g:1774:2: ( ruleLegacyAsSoonAs )
                    // InternalOCLX.g:1775:3: ruleLegacyAsSoonAs
                    {
                     before(grammarAccess.getTriggeredTemporalExpAccess().getLegacyAsSoonAsParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleLegacyAsSoonAs();

                    state._fsp--;

                     after(grammarAccess.getTriggeredTemporalExpAccess().getLegacyAsSoonAsParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalOCLX.g:1780:2: ( ruleLegacyEverytime )
                    {
                    // InternalOCLX.g:1780:2: ( ruleLegacyEverytime )
                    // InternalOCLX.g:1781:3: ruleLegacyEverytime
                    {
                     before(grammarAccess.getTriggeredTemporalExpAccess().getLegacyEverytimeParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleLegacyEverytime();

                    state._fsp--;

                     after(grammarAccess.getTriggeredTemporalExpAccess().getLegacyEverytimeParserRuleCall_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TriggeredTemporalExp__Alternatives"


    // $ANTLR start "rule__Constraint__Group__0"
    // InternalOCLX.g:1790:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1794:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalOCLX.g:1795:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Constraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__0"


    // $ANTLR start "rule__Constraint__Group__0__Impl"
    // InternalOCLX.g:1802:1: rule__Constraint__Group__0__Impl : ( 'rule' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1806:1: ( ( 'rule' ) )
            // InternalOCLX.g:1807:1: ( 'rule' )
            {
            // InternalOCLX.g:1807:1: ( 'rule' )
            // InternalOCLX.g:1808:2: 'rule'
            {
             before(grammarAccess.getConstraintAccess().getRuleKeyword_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getRuleKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__0__Impl"


    // $ANTLR start "rule__Constraint__Group__1"
    // InternalOCLX.g:1817:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1821:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalOCLX.g:1822:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Constraint__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__1"


    // $ANTLR start "rule__Constraint__Group__1__Impl"
    // InternalOCLX.g:1829:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__NameAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1833:1: ( ( ( rule__Constraint__NameAssignment_1 ) ) )
            // InternalOCLX.g:1834:1: ( ( rule__Constraint__NameAssignment_1 ) )
            {
            // InternalOCLX.g:1834:1: ( ( rule__Constraint__NameAssignment_1 ) )
            // InternalOCLX.g:1835:2: ( rule__Constraint__NameAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getNameAssignment_1()); 
            // InternalOCLX.g:1836:2: ( rule__Constraint__NameAssignment_1 )
            // InternalOCLX.g:1836:3: rule__Constraint__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__1__Impl"


    // $ANTLR start "rule__Constraint__Group__2"
    // InternalOCLX.g:1844:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1848:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalOCLX.g:1849:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Constraint__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__2"


    // $ANTLR start "rule__Constraint__Group__2__Impl"
    // InternalOCLX.g:1856:1: rule__Constraint__Group__2__Impl : ( '{' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1860:1: ( ( '{' ) )
            // InternalOCLX.g:1861:1: ( '{' )
            {
            // InternalOCLX.g:1861:1: ( '{' )
            // InternalOCLX.g:1862:2: '{'
            {
             before(grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__2__Impl"


    // $ANTLR start "rule__Constraint__Group__3"
    // InternalOCLX.g:1871:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1875:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalOCLX.g:1876:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Constraint__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__3"


    // $ANTLR start "rule__Constraint__Group__3__Impl"
    // InternalOCLX.g:1883:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__Group_3__0 )? ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1887:1: ( ( ( rule__Constraint__Group_3__0 )? ) )
            // InternalOCLX.g:1888:1: ( ( rule__Constraint__Group_3__0 )? )
            {
            // InternalOCLX.g:1888:1: ( ( rule__Constraint__Group_3__0 )? )
            // InternalOCLX.g:1889:2: ( rule__Constraint__Group_3__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_3()); 
            // InternalOCLX.g:1890:2: ( rule__Constraint__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==49) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalOCLX.g:1890:3: rule__Constraint__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Constraint__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConstraintAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__3__Impl"


    // $ANTLR start "rule__Constraint__Group__4"
    // InternalOCLX.g:1898:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1902:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalOCLX.g:1903:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
            {
            pushFollow(FOLLOW_6);
            rule__Constraint__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__4"


    // $ANTLR start "rule__Constraint__Group__4__Impl"
    // InternalOCLX.g:1910:1: rule__Constraint__Group__4__Impl : ( ( rule__Constraint__Group_4__0 )? ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1914:1: ( ( ( rule__Constraint__Group_4__0 )? ) )
            // InternalOCLX.g:1915:1: ( ( rule__Constraint__Group_4__0 )? )
            {
            // InternalOCLX.g:1915:1: ( ( rule__Constraint__Group_4__0 )? )
            // InternalOCLX.g:1916:2: ( rule__Constraint__Group_4__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_4()); 
            // InternalOCLX.g:1917:2: ( rule__Constraint__Group_4__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==50) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalOCLX.g:1917:3: rule__Constraint__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Constraint__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConstraintAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__4__Impl"


    // $ANTLR start "rule__Constraint__Group__5"
    // InternalOCLX.g:1925:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl rule__Constraint__Group__6 ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1929:1: ( rule__Constraint__Group__5__Impl rule__Constraint__Group__6 )
            // InternalOCLX.g:1930:2: rule__Constraint__Group__5__Impl rule__Constraint__Group__6
            {
            pushFollow(FOLLOW_4);
            rule__Constraint__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__5"


    // $ANTLR start "rule__Constraint__Group__5__Impl"
    // InternalOCLX.g:1937:1: rule__Constraint__Group__5__Impl : ( 'context:' ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1941:1: ( ( 'context:' ) )
            // InternalOCLX.g:1942:1: ( 'context:' )
            {
            // InternalOCLX.g:1942:1: ( 'context:' )
            // InternalOCLX.g:1943:2: 'context:'
            {
             before(grammarAccess.getConstraintAccess().getContextKeyword_5()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getContextKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__5__Impl"


    // $ANTLR start "rule__Constraint__Group__6"
    // InternalOCLX.g:1952:1: rule__Constraint__Group__6 : rule__Constraint__Group__6__Impl rule__Constraint__Group__7 ;
    public final void rule__Constraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1956:1: ( rule__Constraint__Group__6__Impl rule__Constraint__Group__7 )
            // InternalOCLX.g:1957:2: rule__Constraint__Group__6__Impl rule__Constraint__Group__7
            {
            pushFollow(FOLLOW_7);
            rule__Constraint__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__6"


    // $ANTLR start "rule__Constraint__Group__6__Impl"
    // InternalOCLX.g:1964:1: rule__Constraint__Group__6__Impl : ( ( rule__Constraint__ContextAssignment_6 ) ) ;
    public final void rule__Constraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1968:1: ( ( ( rule__Constraint__ContextAssignment_6 ) ) )
            // InternalOCLX.g:1969:1: ( ( rule__Constraint__ContextAssignment_6 ) )
            {
            // InternalOCLX.g:1969:1: ( ( rule__Constraint__ContextAssignment_6 ) )
            // InternalOCLX.g:1970:2: ( rule__Constraint__ContextAssignment_6 )
            {
             before(grammarAccess.getConstraintAccess().getContextAssignment_6()); 
            // InternalOCLX.g:1971:2: ( rule__Constraint__ContextAssignment_6 )
            // InternalOCLX.g:1971:3: rule__Constraint__ContextAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__ContextAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getContextAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__6__Impl"


    // $ANTLR start "rule__Constraint__Group__7"
    // InternalOCLX.g:1979:1: rule__Constraint__Group__7 : rule__Constraint__Group__7__Impl rule__Constraint__Group__8 ;
    public final void rule__Constraint__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1983:1: ( rule__Constraint__Group__7__Impl rule__Constraint__Group__8 )
            // InternalOCLX.g:1984:2: rule__Constraint__Group__7__Impl rule__Constraint__Group__8
            {
            pushFollow(FOLLOW_8);
            rule__Constraint__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__7"


    // $ANTLR start "rule__Constraint__Group__7__Impl"
    // InternalOCLX.g:1991:1: rule__Constraint__Group__7__Impl : ( 'expression:' ) ;
    public final void rule__Constraint__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1995:1: ( ( 'expression:' ) )
            // InternalOCLX.g:1996:1: ( 'expression:' )
            {
            // InternalOCLX.g:1996:1: ( 'expression:' )
            // InternalOCLX.g:1997:2: 'expression:'
            {
             before(grammarAccess.getConstraintAccess().getExpressionKeyword_7()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getExpressionKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__7__Impl"


    // $ANTLR start "rule__Constraint__Group__8"
    // InternalOCLX.g:2006:1: rule__Constraint__Group__8 : rule__Constraint__Group__8__Impl rule__Constraint__Group__9 ;
    public final void rule__Constraint__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2010:1: ( rule__Constraint__Group__8__Impl rule__Constraint__Group__9 )
            // InternalOCLX.g:2011:2: rule__Constraint__Group__8__Impl rule__Constraint__Group__9
            {
            pushFollow(FOLLOW_9);
            rule__Constraint__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__8"


    // $ANTLR start "rule__Constraint__Group__8__Impl"
    // InternalOCLX.g:2018:1: rule__Constraint__Group__8__Impl : ( ( rule__Constraint__ExpressionAssignment_8 ) ) ;
    public final void rule__Constraint__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2022:1: ( ( ( rule__Constraint__ExpressionAssignment_8 ) ) )
            // InternalOCLX.g:2023:1: ( ( rule__Constraint__ExpressionAssignment_8 ) )
            {
            // InternalOCLX.g:2023:1: ( ( rule__Constraint__ExpressionAssignment_8 ) )
            // InternalOCLX.g:2024:2: ( rule__Constraint__ExpressionAssignment_8 )
            {
             before(grammarAccess.getConstraintAccess().getExpressionAssignment_8()); 
            // InternalOCLX.g:2025:2: ( rule__Constraint__ExpressionAssignment_8 )
            // InternalOCLX.g:2025:3: rule__Constraint__ExpressionAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__ExpressionAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getExpressionAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__8__Impl"


    // $ANTLR start "rule__Constraint__Group__9"
    // InternalOCLX.g:2033:1: rule__Constraint__Group__9 : rule__Constraint__Group__9__Impl ;
    public final void rule__Constraint__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2037:1: ( rule__Constraint__Group__9__Impl )
            // InternalOCLX.g:2038:2: rule__Constraint__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__9"


    // $ANTLR start "rule__Constraint__Group__9__Impl"
    // InternalOCLX.g:2044:1: rule__Constraint__Group__9__Impl : ( '}' ) ;
    public final void rule__Constraint__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2048:1: ( ( '}' ) )
            // InternalOCLX.g:2049:1: ( '}' )
            {
            // InternalOCLX.g:2049:1: ( '}' )
            // InternalOCLX.g:2050:2: '}'
            {
             before(grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_9()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group__9__Impl"


    // $ANTLR start "rule__Constraint__Group_3__0"
    // InternalOCLX.g:2060:1: rule__Constraint__Group_3__0 : rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1 ;
    public final void rule__Constraint__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2064:1: ( rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1 )
            // InternalOCLX.g:2065:2: rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1
            {
            pushFollow(FOLLOW_10);
            rule__Constraint__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_3__0"


    // $ANTLR start "rule__Constraint__Group_3__0__Impl"
    // InternalOCLX.g:2072:1: rule__Constraint__Group_3__0__Impl : ( 'description:' ) ;
    public final void rule__Constraint__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2076:1: ( ( 'description:' ) )
            // InternalOCLX.g:2077:1: ( 'description:' )
            {
            // InternalOCLX.g:2077:1: ( 'description:' )
            // InternalOCLX.g:2078:2: 'description:'
            {
             before(grammarAccess.getConstraintAccess().getDescriptionKeyword_3_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getDescriptionKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_3__0__Impl"


    // $ANTLR start "rule__Constraint__Group_3__1"
    // InternalOCLX.g:2087:1: rule__Constraint__Group_3__1 : rule__Constraint__Group_3__1__Impl ;
    public final void rule__Constraint__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2091:1: ( rule__Constraint__Group_3__1__Impl )
            // InternalOCLX.g:2092:2: rule__Constraint__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_3__1"


    // $ANTLR start "rule__Constraint__Group_3__1__Impl"
    // InternalOCLX.g:2098:1: rule__Constraint__Group_3__1__Impl : ( ( rule__Constraint__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Constraint__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2102:1: ( ( ( rule__Constraint__DescriptionAssignment_3_1 ) ) )
            // InternalOCLX.g:2103:1: ( ( rule__Constraint__DescriptionAssignment_3_1 ) )
            {
            // InternalOCLX.g:2103:1: ( ( rule__Constraint__DescriptionAssignment_3_1 ) )
            // InternalOCLX.g:2104:2: ( rule__Constraint__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getConstraintAccess().getDescriptionAssignment_3_1()); 
            // InternalOCLX.g:2105:2: ( rule__Constraint__DescriptionAssignment_3_1 )
            // InternalOCLX.g:2105:3: rule__Constraint__DescriptionAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__DescriptionAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getDescriptionAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_3__1__Impl"


    // $ANTLR start "rule__Constraint__Group_4__0"
    // InternalOCLX.g:2114:1: rule__Constraint__Group_4__0 : rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 ;
    public final void rule__Constraint__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2118:1: ( rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 )
            // InternalOCLX.g:2119:2: rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1
            {
            pushFollow(FOLLOW_11);
            rule__Constraint__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_4__0"


    // $ANTLR start "rule__Constraint__Group_4__0__Impl"
    // InternalOCLX.g:2126:1: rule__Constraint__Group_4__0__Impl : ( 'is' ) ;
    public final void rule__Constraint__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2130:1: ( ( 'is' ) )
            // InternalOCLX.g:2131:1: ( 'is' )
            {
            // InternalOCLX.g:2131:1: ( 'is' )
            // InternalOCLX.g:2132:2: 'is'
            {
             before(grammarAccess.getConstraintAccess().getIsKeyword_4_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getIsKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_4__0__Impl"


    // $ANTLR start "rule__Constraint__Group_4__1"
    // InternalOCLX.g:2141:1: rule__Constraint__Group_4__1 : rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2 ;
    public final void rule__Constraint__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2145:1: ( rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2 )
            // InternalOCLX.g:2146:2: rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2
            {
            pushFollow(FOLLOW_12);
            rule__Constraint__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constraint__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_4__1"


    // $ANTLR start "rule__Constraint__Group_4__1__Impl"
    // InternalOCLX.g:2153:1: rule__Constraint__Group_4__1__Impl : ( 'overrulable:' ) ;
    public final void rule__Constraint__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2157:1: ( ( 'overrulable:' ) )
            // InternalOCLX.g:2158:1: ( 'overrulable:' )
            {
            // InternalOCLX.g:2158:1: ( 'overrulable:' )
            // InternalOCLX.g:2159:2: 'overrulable:'
            {
             before(grammarAccess.getConstraintAccess().getOverrulableKeyword_4_1()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getOverrulableKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_4__1__Impl"


    // $ANTLR start "rule__Constraint__Group_4__2"
    // InternalOCLX.g:2168:1: rule__Constraint__Group_4__2 : rule__Constraint__Group_4__2__Impl ;
    public final void rule__Constraint__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2172:1: ( rule__Constraint__Group_4__2__Impl )
            // InternalOCLX.g:2173:2: rule__Constraint__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_4__2"


    // $ANTLR start "rule__Constraint__Group_4__2__Impl"
    // InternalOCLX.g:2179:1: rule__Constraint__Group_4__2__Impl : ( ( rule__Constraint__OverrulableAssignment_4_2 ) ) ;
    public final void rule__Constraint__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2183:1: ( ( ( rule__Constraint__OverrulableAssignment_4_2 ) ) )
            // InternalOCLX.g:2184:1: ( ( rule__Constraint__OverrulableAssignment_4_2 ) )
            {
            // InternalOCLX.g:2184:1: ( ( rule__Constraint__OverrulableAssignment_4_2 ) )
            // InternalOCLX.g:2185:2: ( rule__Constraint__OverrulableAssignment_4_2 )
            {
             before(grammarAccess.getConstraintAccess().getOverrulableAssignment_4_2()); 
            // InternalOCLX.g:2186:2: ( rule__Constraint__OverrulableAssignment_4_2 )
            // InternalOCLX.g:2186:3: rule__Constraint__OverrulableAssignment_4_2
            {
            pushFollow(FOLLOW_2);
            rule__Constraint__OverrulableAssignment_4_2();

            state._fsp--;


            }

             after(grammarAccess.getConstraintAccess().getOverrulableAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__Group_4__2__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalOCLX.g:2195:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2199:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalOCLX.g:2200:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalOCLX.g:2207:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2211:1: ( ( RULE_ID ) )
            // InternalOCLX.g:2212:1: ( RULE_ID )
            {
            // InternalOCLX.g:2212:1: ( RULE_ID )
            // InternalOCLX.g:2213:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalOCLX.g:2222:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2226:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalOCLX.g:2227:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalOCLX.g:2233:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2237:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalOCLX.g:2238:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalOCLX.g:2238:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalOCLX.g:2239:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalOCLX.g:2240:2: ( rule__QualifiedName__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==26) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalOCLX.g:2240:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalOCLX.g:2249:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2253:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalOCLX.g:2254:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalOCLX.g:2261:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2265:1: ( ( '.' ) )
            // InternalOCLX.g:2266:1: ( '.' )
            {
            // InternalOCLX.g:2266:1: ( '.' )
            // InternalOCLX.g:2267:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalOCLX.g:2276:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2280:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalOCLX.g:2281:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalOCLX.g:2287:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2291:1: ( ( RULE_ID ) )
            // InternalOCLX.g:2292:1: ( RULE_ID )
            {
            // InternalOCLX.g:2292:1: ( RULE_ID )
            // InternalOCLX.g:2293:2: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Exp__Group__0"
    // InternalOCLX.g:2303:1: rule__Exp__Group__0 : rule__Exp__Group__0__Impl rule__Exp__Group__1 ;
    public final void rule__Exp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2307:1: ( rule__Exp__Group__0__Impl rule__Exp__Group__1 )
            // InternalOCLX.g:2308:2: rule__Exp__Group__0__Impl rule__Exp__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Exp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group__0"


    // $ANTLR start "rule__Exp__Group__0__Impl"
    // InternalOCLX.g:2315:1: rule__Exp__Group__0__Impl : ( rulePrefixedExp ) ;
    public final void rule__Exp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2319:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:2320:1: ( rulePrefixedExp )
            {
            // InternalOCLX.g:2320:1: ( rulePrefixedExp )
            // InternalOCLX.g:2321:2: rulePrefixedExp
            {
             before(grammarAccess.getExpAccess().getPrefixedExpParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePrefixedExp();

            state._fsp--;

             after(grammarAccess.getExpAccess().getPrefixedExpParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group__0__Impl"


    // $ANTLR start "rule__Exp__Group__1"
    // InternalOCLX.g:2330:1: rule__Exp__Group__1 : rule__Exp__Group__1__Impl ;
    public final void rule__Exp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2334:1: ( rule__Exp__Group__1__Impl )
            // InternalOCLX.g:2335:2: rule__Exp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Exp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group__1"


    // $ANTLR start "rule__Exp__Group__1__Impl"
    // InternalOCLX.g:2341:1: rule__Exp__Group__1__Impl : ( ( rule__Exp__Group_1__0 )? ) ;
    public final void rule__Exp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2345:1: ( ( ( rule__Exp__Group_1__0 )? ) )
            // InternalOCLX.g:2346:1: ( ( rule__Exp__Group_1__0 )? )
            {
            // InternalOCLX.g:2346:1: ( ( rule__Exp__Group_1__0 )? )
            // InternalOCLX.g:2347:2: ( rule__Exp__Group_1__0 )?
            {
             before(grammarAccess.getExpAccess().getGroup_1()); 
            // InternalOCLX.g:2348:2: ( rule__Exp__Group_1__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=12 && LA25_0<=25)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalOCLX.g:2348:3: rule__Exp__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Exp__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group__1__Impl"


    // $ANTLR start "rule__Exp__Group_1__0"
    // InternalOCLX.g:2357:1: rule__Exp__Group_1__0 : rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 ;
    public final void rule__Exp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2361:1: ( rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 )
            // InternalOCLX.g:2362:2: rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1
            {
            pushFollow(FOLLOW_15);
            rule__Exp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1__0"


    // $ANTLR start "rule__Exp__Group_1__0__Impl"
    // InternalOCLX.g:2369:1: rule__Exp__Group_1__0__Impl : ( () ) ;
    public final void rule__Exp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2373:1: ( ( () ) )
            // InternalOCLX.g:2374:1: ( () )
            {
            // InternalOCLX.g:2374:1: ( () )
            // InternalOCLX.g:2375:2: ()
            {
             before(grammarAccess.getExpAccess().getInfixExpExpressionsAction_1_0()); 
            // InternalOCLX.g:2376:2: ()
            // InternalOCLX.g:2376:3: 
            {
            }

             after(grammarAccess.getExpAccess().getInfixExpExpressionsAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1__0__Impl"


    // $ANTLR start "rule__Exp__Group_1__1"
    // InternalOCLX.g:2384:1: rule__Exp__Group_1__1 : rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2 ;
    public final void rule__Exp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2388:1: ( rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2 )
            // InternalOCLX.g:2389:2: rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2
            {
            pushFollow(FOLLOW_8);
            rule__Exp__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exp__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1__1"


    // $ANTLR start "rule__Exp__Group_1__1__Impl"
    // InternalOCLX.g:2396:1: rule__Exp__Group_1__1__Impl : ( ( rule__Exp__OperatorsAssignment_1_1 ) ) ;
    public final void rule__Exp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2400:1: ( ( ( rule__Exp__OperatorsAssignment_1_1 ) ) )
            // InternalOCLX.g:2401:1: ( ( rule__Exp__OperatorsAssignment_1_1 ) )
            {
            // InternalOCLX.g:2401:1: ( ( rule__Exp__OperatorsAssignment_1_1 ) )
            // InternalOCLX.g:2402:2: ( rule__Exp__OperatorsAssignment_1_1 )
            {
             before(grammarAccess.getExpAccess().getOperatorsAssignment_1_1()); 
            // InternalOCLX.g:2403:2: ( rule__Exp__OperatorsAssignment_1_1 )
            // InternalOCLX.g:2403:3: rule__Exp__OperatorsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Exp__OperatorsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getExpAccess().getOperatorsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1__1__Impl"


    // $ANTLR start "rule__Exp__Group_1__2"
    // InternalOCLX.g:2411:1: rule__Exp__Group_1__2 : rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3 ;
    public final void rule__Exp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2415:1: ( rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3 )
            // InternalOCLX.g:2416:2: rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3
            {
            pushFollow(FOLLOW_15);
            rule__Exp__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exp__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1__2"


    // $ANTLR start "rule__Exp__Group_1__2__Impl"
    // InternalOCLX.g:2423:1: rule__Exp__Group_1__2__Impl : ( ( rule__Exp__ExpressionsAssignment_1_2 ) ) ;
    public final void rule__Exp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2427:1: ( ( ( rule__Exp__ExpressionsAssignment_1_2 ) ) )
            // InternalOCLX.g:2428:1: ( ( rule__Exp__ExpressionsAssignment_1_2 ) )
            {
            // InternalOCLX.g:2428:1: ( ( rule__Exp__ExpressionsAssignment_1_2 ) )
            // InternalOCLX.g:2429:2: ( rule__Exp__ExpressionsAssignment_1_2 )
            {
             before(grammarAccess.getExpAccess().getExpressionsAssignment_1_2()); 
            // InternalOCLX.g:2430:2: ( rule__Exp__ExpressionsAssignment_1_2 )
            // InternalOCLX.g:2430:3: rule__Exp__ExpressionsAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Exp__ExpressionsAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getExpAccess().getExpressionsAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1__2__Impl"


    // $ANTLR start "rule__Exp__Group_1__3"
    // InternalOCLX.g:2438:1: rule__Exp__Group_1__3 : rule__Exp__Group_1__3__Impl ;
    public final void rule__Exp__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2442:1: ( rule__Exp__Group_1__3__Impl )
            // InternalOCLX.g:2443:2: rule__Exp__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Exp__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1__3"


    // $ANTLR start "rule__Exp__Group_1__3__Impl"
    // InternalOCLX.g:2449:1: rule__Exp__Group_1__3__Impl : ( ( rule__Exp__Group_1_3__0 )* ) ;
    public final void rule__Exp__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2453:1: ( ( ( rule__Exp__Group_1_3__0 )* ) )
            // InternalOCLX.g:2454:1: ( ( rule__Exp__Group_1_3__0 )* )
            {
            // InternalOCLX.g:2454:1: ( ( rule__Exp__Group_1_3__0 )* )
            // InternalOCLX.g:2455:2: ( rule__Exp__Group_1_3__0 )*
            {
             before(grammarAccess.getExpAccess().getGroup_1_3()); 
            // InternalOCLX.g:2456:2: ( rule__Exp__Group_1_3__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=12 && LA26_0<=25)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalOCLX.g:2456:3: rule__Exp__Group_1_3__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Exp__Group_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getExpAccess().getGroup_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1__3__Impl"


    // $ANTLR start "rule__Exp__Group_1_3__0"
    // InternalOCLX.g:2465:1: rule__Exp__Group_1_3__0 : rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1 ;
    public final void rule__Exp__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2469:1: ( rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1 )
            // InternalOCLX.g:2470:2: rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1
            {
            pushFollow(FOLLOW_8);
            rule__Exp__Group_1_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Exp__Group_1_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1_3__0"


    // $ANTLR start "rule__Exp__Group_1_3__0__Impl"
    // InternalOCLX.g:2477:1: rule__Exp__Group_1_3__0__Impl : ( ( rule__Exp__OperatorsAssignment_1_3_0 ) ) ;
    public final void rule__Exp__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2481:1: ( ( ( rule__Exp__OperatorsAssignment_1_3_0 ) ) )
            // InternalOCLX.g:2482:1: ( ( rule__Exp__OperatorsAssignment_1_3_0 ) )
            {
            // InternalOCLX.g:2482:1: ( ( rule__Exp__OperatorsAssignment_1_3_0 ) )
            // InternalOCLX.g:2483:2: ( rule__Exp__OperatorsAssignment_1_3_0 )
            {
             before(grammarAccess.getExpAccess().getOperatorsAssignment_1_3_0()); 
            // InternalOCLX.g:2484:2: ( rule__Exp__OperatorsAssignment_1_3_0 )
            // InternalOCLX.g:2484:3: rule__Exp__OperatorsAssignment_1_3_0
            {
            pushFollow(FOLLOW_2);
            rule__Exp__OperatorsAssignment_1_3_0();

            state._fsp--;


            }

             after(grammarAccess.getExpAccess().getOperatorsAssignment_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1_3__0__Impl"


    // $ANTLR start "rule__Exp__Group_1_3__1"
    // InternalOCLX.g:2492:1: rule__Exp__Group_1_3__1 : rule__Exp__Group_1_3__1__Impl ;
    public final void rule__Exp__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2496:1: ( rule__Exp__Group_1_3__1__Impl )
            // InternalOCLX.g:2497:2: rule__Exp__Group_1_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Exp__Group_1_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1_3__1"


    // $ANTLR start "rule__Exp__Group_1_3__1__Impl"
    // InternalOCLX.g:2503:1: rule__Exp__Group_1_3__1__Impl : ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) ) ;
    public final void rule__Exp__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2507:1: ( ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) ) )
            // InternalOCLX.g:2508:1: ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) )
            {
            // InternalOCLX.g:2508:1: ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) )
            // InternalOCLX.g:2509:2: ( rule__Exp__ExpressionsAssignment_1_3_1 )
            {
             before(grammarAccess.getExpAccess().getExpressionsAssignment_1_3_1()); 
            // InternalOCLX.g:2510:2: ( rule__Exp__ExpressionsAssignment_1_3_1 )
            // InternalOCLX.g:2510:3: rule__Exp__ExpressionsAssignment_1_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Exp__ExpressionsAssignment_1_3_1();

            state._fsp--;


            }

             after(grammarAccess.getExpAccess().getExpressionsAssignment_1_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__Group_1_3__1__Impl"


    // $ANTLR start "rule__PrefixedExp__Group_0__0"
    // InternalOCLX.g:2519:1: rule__PrefixedExp__Group_0__0 : rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1 ;
    public final void rule__PrefixedExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2523:1: ( rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1 )
            // InternalOCLX.g:2524:2: rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1
            {
            pushFollow(FOLLOW_17);
            rule__PrefixedExp__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrefixedExp__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixedExp__Group_0__0"


    // $ANTLR start "rule__PrefixedExp__Group_0__0__Impl"
    // InternalOCLX.g:2531:1: rule__PrefixedExp__Group_0__0__Impl : ( () ) ;
    public final void rule__PrefixedExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2535:1: ( ( () ) )
            // InternalOCLX.g:2536:1: ( () )
            {
            // InternalOCLX.g:2536:1: ( () )
            // InternalOCLX.g:2537:2: ()
            {
             before(grammarAccess.getPrefixedExpAccess().getPrefixExpAction_0_0()); 
            // InternalOCLX.g:2538:2: ()
            // InternalOCLX.g:2538:3: 
            {
            }

             after(grammarAccess.getPrefixedExpAccess().getPrefixExpAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixedExp__Group_0__0__Impl"


    // $ANTLR start "rule__PrefixedExp__Group_0__1"
    // InternalOCLX.g:2546:1: rule__PrefixedExp__Group_0__1 : rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2 ;
    public final void rule__PrefixedExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2550:1: ( rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2 )
            // InternalOCLX.g:2551:2: rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2
            {
            pushFollow(FOLLOW_8);
            rule__PrefixedExp__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrefixedExp__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixedExp__Group_0__1"


    // $ANTLR start "rule__PrefixedExp__Group_0__1__Impl"
    // InternalOCLX.g:2558:1: rule__PrefixedExp__Group_0__1__Impl : ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) ) ;
    public final void rule__PrefixedExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2562:1: ( ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) ) )
            // InternalOCLX.g:2563:1: ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) )
            {
            // InternalOCLX.g:2563:1: ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) )
            // InternalOCLX.g:2564:2: ( rule__PrefixedExp__OperatorAssignment_0_1 )
            {
             before(grammarAccess.getPrefixedExpAccess().getOperatorAssignment_0_1()); 
            // InternalOCLX.g:2565:2: ( rule__PrefixedExp__OperatorAssignment_0_1 )
            // InternalOCLX.g:2565:3: rule__PrefixedExp__OperatorAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__PrefixedExp__OperatorAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getPrefixedExpAccess().getOperatorAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixedExp__Group_0__1__Impl"


    // $ANTLR start "rule__PrefixedExp__Group_0__2"
    // InternalOCLX.g:2573:1: rule__PrefixedExp__Group_0__2 : rule__PrefixedExp__Group_0__2__Impl ;
    public final void rule__PrefixedExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2577:1: ( rule__PrefixedExp__Group_0__2__Impl )
            // InternalOCLX.g:2578:2: rule__PrefixedExp__Group_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrefixedExp__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixedExp__Group_0__2"


    // $ANTLR start "rule__PrefixedExp__Group_0__2__Impl"
    // InternalOCLX.g:2584:1: rule__PrefixedExp__Group_0__2__Impl : ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) ) ;
    public final void rule__PrefixedExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2588:1: ( ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) ) )
            // InternalOCLX.g:2589:1: ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) )
            {
            // InternalOCLX.g:2589:1: ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) )
            // InternalOCLX.g:2590:2: ( rule__PrefixedExp__ExpressionAssignment_0_2 )
            {
             before(grammarAccess.getPrefixedExpAccess().getExpressionAssignment_0_2()); 
            // InternalOCLX.g:2591:2: ( rule__PrefixedExp__ExpressionAssignment_0_2 )
            // InternalOCLX.g:2591:3: rule__PrefixedExp__ExpressionAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__PrefixedExp__ExpressionAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getPrefixedExpAccess().getExpressionAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixedExp__Group_0__2__Impl"


    // $ANTLR start "rule__PrimaryExp__Group_1__0"
    // InternalOCLX.g:2600:1: rule__PrimaryExp__Group_1__0 : rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1 ;
    public final void rule__PrimaryExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2604:1: ( rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1 )
            // InternalOCLX.g:2605:2: rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1
            {
            pushFollow(FOLLOW_18);
            rule__PrimaryExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__Group_1__0"


    // $ANTLR start "rule__PrimaryExp__Group_1__0__Impl"
    // InternalOCLX.g:2612:1: rule__PrimaryExp__Group_1__0__Impl : ( ruleVarOrSelfExp ) ;
    public final void rule__PrimaryExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2616:1: ( ( ruleVarOrSelfExp ) )
            // InternalOCLX.g:2617:1: ( ruleVarOrSelfExp )
            {
            // InternalOCLX.g:2617:1: ( ruleVarOrSelfExp )
            // InternalOCLX.g:2618:2: ruleVarOrSelfExp
            {
             before(grammarAccess.getPrimaryExpAccess().getVarOrSelfExpParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVarOrSelfExp();

            state._fsp--;

             after(grammarAccess.getPrimaryExpAccess().getVarOrSelfExpParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__Group_1__0__Impl"


    // $ANTLR start "rule__PrimaryExp__Group_1__1"
    // InternalOCLX.g:2627:1: rule__PrimaryExp__Group_1__1 : rule__PrimaryExp__Group_1__1__Impl ;
    public final void rule__PrimaryExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2631:1: ( rule__PrimaryExp__Group_1__1__Impl )
            // InternalOCLX.g:2632:2: rule__PrimaryExp__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExp__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__Group_1__1"


    // $ANTLR start "rule__PrimaryExp__Group_1__1__Impl"
    // InternalOCLX.g:2638:1: rule__PrimaryExp__Group_1__1__Impl : ( ( rule__PrimaryExp__Group_1_1__0 )* ) ;
    public final void rule__PrimaryExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2642:1: ( ( ( rule__PrimaryExp__Group_1_1__0 )* ) )
            // InternalOCLX.g:2643:1: ( ( rule__PrimaryExp__Group_1_1__0 )* )
            {
            // InternalOCLX.g:2643:1: ( ( rule__PrimaryExp__Group_1_1__0 )* )
            // InternalOCLX.g:2644:2: ( rule__PrimaryExp__Group_1_1__0 )*
            {
             before(grammarAccess.getPrimaryExpAccess().getGroup_1_1()); 
            // InternalOCLX.g:2645:2: ( rule__PrimaryExp__Group_1_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=26 && LA27_0<=27)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalOCLX.g:2645:3: rule__PrimaryExp__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__PrimaryExp__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getPrimaryExpAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__Group_1__1__Impl"


    // $ANTLR start "rule__PrimaryExp__Group_1_1__0"
    // InternalOCLX.g:2654:1: rule__PrimaryExp__Group_1_1__0 : rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1 ;
    public final void rule__PrimaryExp__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2658:1: ( rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1 )
            // InternalOCLX.g:2659:2: rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1
            {
            pushFollow(FOLLOW_20);
            rule__PrimaryExp__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PrimaryExp__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__Group_1_1__0"


    // $ANTLR start "rule__PrimaryExp__Group_1_1__0__Impl"
    // InternalOCLX.g:2666:1: rule__PrimaryExp__Group_1_1__0__Impl : ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) ) ;
    public final void rule__PrimaryExp__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2670:1: ( ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) ) )
            // InternalOCLX.g:2671:1: ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) )
            {
            // InternalOCLX.g:2671:1: ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) )
            // InternalOCLX.g:2672:2: ( rule__PrimaryExp__NavAssignment_1_1_0 )
            {
             before(grammarAccess.getPrimaryExpAccess().getNavAssignment_1_1_0()); 
            // InternalOCLX.g:2673:2: ( rule__PrimaryExp__NavAssignment_1_1_0 )
            // InternalOCLX.g:2673:3: rule__PrimaryExp__NavAssignment_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExp__NavAssignment_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpAccess().getNavAssignment_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__Group_1_1__0__Impl"


    // $ANTLR start "rule__PrimaryExp__Group_1_1__1"
    // InternalOCLX.g:2681:1: rule__PrimaryExp__Group_1_1__1 : rule__PrimaryExp__Group_1_1__1__Impl ;
    public final void rule__PrimaryExp__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2685:1: ( rule__PrimaryExp__Group_1_1__1__Impl )
            // InternalOCLX.g:2686:2: rule__PrimaryExp__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExp__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__Group_1_1__1"


    // $ANTLR start "rule__PrimaryExp__Group_1_1__1__Impl"
    // InternalOCLX.g:2692:1: rule__PrimaryExp__Group_1_1__1__Impl : ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) ) ;
    public final void rule__PrimaryExp__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2696:1: ( ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) ) )
            // InternalOCLX.g:2697:1: ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) )
            {
            // InternalOCLX.g:2697:1: ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) )
            // InternalOCLX.g:2698:2: ( rule__PrimaryExp__MethodsAssignment_1_1_1 )
            {
             before(grammarAccess.getPrimaryExpAccess().getMethodsAssignment_1_1_1()); 
            // InternalOCLX.g:2699:2: ( rule__PrimaryExp__MethodsAssignment_1_1_1 )
            // InternalOCLX.g:2699:3: rule__PrimaryExp__MethodsAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExp__MethodsAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpAccess().getMethodsAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__Group_1_1__1__Impl"


    // $ANTLR start "rule__NestedExp__Group__0"
    // InternalOCLX.g:2708:1: rule__NestedExp__Group__0 : rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 ;
    public final void rule__NestedExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2712:1: ( rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 )
            // InternalOCLX.g:2713:2: rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__NestedExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NestedExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__0"


    // $ANTLR start "rule__NestedExp__Group__0__Impl"
    // InternalOCLX.g:2720:1: rule__NestedExp__Group__0__Impl : ( '(' ) ;
    public final void rule__NestedExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2724:1: ( ( '(' ) )
            // InternalOCLX.g:2725:1: ( '(' )
            {
            // InternalOCLX.g:2725:1: ( '(' )
            // InternalOCLX.g:2726:2: '('
            {
             before(grammarAccess.getNestedExpAccess().getLeftParenthesisKeyword_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getNestedExpAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__0__Impl"


    // $ANTLR start "rule__NestedExp__Group__1"
    // InternalOCLX.g:2735:1: rule__NestedExp__Group__1 : rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 ;
    public final void rule__NestedExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2739:1: ( rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 )
            // InternalOCLX.g:2740:2: rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__NestedExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NestedExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__1"


    // $ANTLR start "rule__NestedExp__Group__1__Impl"
    // InternalOCLX.g:2747:1: rule__NestedExp__Group__1__Impl : ( ( rule__NestedExp__SourceAssignment_1 ) ) ;
    public final void rule__NestedExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2751:1: ( ( ( rule__NestedExp__SourceAssignment_1 ) ) )
            // InternalOCLX.g:2752:1: ( ( rule__NestedExp__SourceAssignment_1 ) )
            {
            // InternalOCLX.g:2752:1: ( ( rule__NestedExp__SourceAssignment_1 ) )
            // InternalOCLX.g:2753:2: ( rule__NestedExp__SourceAssignment_1 )
            {
             before(grammarAccess.getNestedExpAccess().getSourceAssignment_1()); 
            // InternalOCLX.g:2754:2: ( rule__NestedExp__SourceAssignment_1 )
            // InternalOCLX.g:2754:3: rule__NestedExp__SourceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__NestedExp__SourceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNestedExpAccess().getSourceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__1__Impl"


    // $ANTLR start "rule__NestedExp__Group__2"
    // InternalOCLX.g:2762:1: rule__NestedExp__Group__2 : rule__NestedExp__Group__2__Impl ;
    public final void rule__NestedExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2766:1: ( rule__NestedExp__Group__2__Impl )
            // InternalOCLX.g:2767:2: rule__NestedExp__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NestedExp__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__2"


    // $ANTLR start "rule__NestedExp__Group__2__Impl"
    // InternalOCLX.g:2773:1: rule__NestedExp__Group__2__Impl : ( ')' ) ;
    public final void rule__NestedExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2777:1: ( ( ')' ) )
            // InternalOCLX.g:2778:1: ( ')' )
            {
            // InternalOCLX.g:2778:1: ( ')' )
            // InternalOCLX.g:2779:2: ')'
            {
             before(grammarAccess.getNestedExpAccess().getRightParenthesisKeyword_2()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getNestedExpAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__2__Impl"


    // $ANTLR start "rule__SelfExp__Group__0"
    // InternalOCLX.g:2789:1: rule__SelfExp__Group__0 : rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1 ;
    public final void rule__SelfExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2793:1: ( rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1 )
            // InternalOCLX.g:2794:2: rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__SelfExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SelfExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfExp__Group__0"


    // $ANTLR start "rule__SelfExp__Group__0__Impl"
    // InternalOCLX.g:2801:1: rule__SelfExp__Group__0__Impl : ( () ) ;
    public final void rule__SelfExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2805:1: ( ( () ) )
            // InternalOCLX.g:2806:1: ( () )
            {
            // InternalOCLX.g:2806:1: ( () )
            // InternalOCLX.g:2807:2: ()
            {
             before(grammarAccess.getSelfExpAccess().getSelfExpAction_0()); 
            // InternalOCLX.g:2808:2: ()
            // InternalOCLX.g:2808:3: 
            {
            }

             after(grammarAccess.getSelfExpAccess().getSelfExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfExp__Group__0__Impl"


    // $ANTLR start "rule__SelfExp__Group__1"
    // InternalOCLX.g:2816:1: rule__SelfExp__Group__1 : rule__SelfExp__Group__1__Impl ;
    public final void rule__SelfExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2820:1: ( rule__SelfExp__Group__1__Impl )
            // InternalOCLX.g:2821:2: rule__SelfExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SelfExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfExp__Group__1"


    // $ANTLR start "rule__SelfExp__Group__1__Impl"
    // InternalOCLX.g:2827:1: rule__SelfExp__Group__1__Impl : ( ( rule__SelfExp__NameAssignment_1 ) ) ;
    public final void rule__SelfExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2831:1: ( ( ( rule__SelfExp__NameAssignment_1 ) ) )
            // InternalOCLX.g:2832:1: ( ( rule__SelfExp__NameAssignment_1 ) )
            {
            // InternalOCLX.g:2832:1: ( ( rule__SelfExp__NameAssignment_1 ) )
            // InternalOCLX.g:2833:2: ( rule__SelfExp__NameAssignment_1 )
            {
             before(grammarAccess.getSelfExpAccess().getNameAssignment_1()); 
            // InternalOCLX.g:2834:2: ( rule__SelfExp__NameAssignment_1 )
            // InternalOCLX.g:2834:3: rule__SelfExp__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SelfExp__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSelfExpAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfExp__Group__1__Impl"


    // $ANTLR start "rule__NullLiteralExp__Group__0"
    // InternalOCLX.g:2843:1: rule__NullLiteralExp__Group__0 : rule__NullLiteralExp__Group__0__Impl rule__NullLiteralExp__Group__1 ;
    public final void rule__NullLiteralExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2847:1: ( rule__NullLiteralExp__Group__0__Impl rule__NullLiteralExp__Group__1 )
            // InternalOCLX.g:2848:2: rule__NullLiteralExp__Group__0__Impl rule__NullLiteralExp__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__NullLiteralExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NullLiteralExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullLiteralExp__Group__0"


    // $ANTLR start "rule__NullLiteralExp__Group__0__Impl"
    // InternalOCLX.g:2855:1: rule__NullLiteralExp__Group__0__Impl : ( () ) ;
    public final void rule__NullLiteralExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2859:1: ( ( () ) )
            // InternalOCLX.g:2860:1: ( () )
            {
            // InternalOCLX.g:2860:1: ( () )
            // InternalOCLX.g:2861:2: ()
            {
             before(grammarAccess.getNullLiteralExpAccess().getNullLiteralExpCSAction_0()); 
            // InternalOCLX.g:2862:2: ()
            // InternalOCLX.g:2862:3: 
            {
            }

             after(grammarAccess.getNullLiteralExpAccess().getNullLiteralExpCSAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullLiteralExp__Group__0__Impl"


    // $ANTLR start "rule__NullLiteralExp__Group__1"
    // InternalOCLX.g:2870:1: rule__NullLiteralExp__Group__1 : rule__NullLiteralExp__Group__1__Impl ;
    public final void rule__NullLiteralExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2874:1: ( rule__NullLiteralExp__Group__1__Impl )
            // InternalOCLX.g:2875:2: rule__NullLiteralExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NullLiteralExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullLiteralExp__Group__1"


    // $ANTLR start "rule__NullLiteralExp__Group__1__Impl"
    // InternalOCLX.g:2881:1: rule__NullLiteralExp__Group__1__Impl : ( 'null' ) ;
    public final void rule__NullLiteralExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2885:1: ( ( 'null' ) )
            // InternalOCLX.g:2886:1: ( 'null' )
            {
            // InternalOCLX.g:2886:1: ( 'null' )
            // InternalOCLX.g:2887:2: 'null'
            {
             before(grammarAccess.getNullLiteralExpAccess().getNullKeyword_1()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getNullLiteralExpAccess().getNullKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullLiteralExp__Group__1__Impl"


    // $ANTLR start "rule__CollectionIterator__Group__0"
    // InternalOCLX.g:2897:1: rule__CollectionIterator__Group__0 : rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 ;
    public final void rule__CollectionIterator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2901:1: ( rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 )
            // InternalOCLX.g:2902:2: rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__CollectionIterator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionIterator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__0"


    // $ANTLR start "rule__CollectionIterator__Group__0__Impl"
    // InternalOCLX.g:2909:1: rule__CollectionIterator__Group__0__Impl : ( ( rule__CollectionIterator__NameAssignment_0 ) ) ;
    public final void rule__CollectionIterator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2913:1: ( ( ( rule__CollectionIterator__NameAssignment_0 ) ) )
            // InternalOCLX.g:2914:1: ( ( rule__CollectionIterator__NameAssignment_0 ) )
            {
            // InternalOCLX.g:2914:1: ( ( rule__CollectionIterator__NameAssignment_0 ) )
            // InternalOCLX.g:2915:2: ( rule__CollectionIterator__NameAssignment_0 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getNameAssignment_0()); 
            // InternalOCLX.g:2916:2: ( rule__CollectionIterator__NameAssignment_0 )
            // InternalOCLX.g:2916:3: rule__CollectionIterator__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CollectionIterator__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCollectionIteratorAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__0__Impl"


    // $ANTLR start "rule__CollectionIterator__Group__1"
    // InternalOCLX.g:2924:1: rule__CollectionIterator__Group__1 : rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 ;
    public final void rule__CollectionIterator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2928:1: ( rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 )
            // InternalOCLX.g:2929:2: rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__CollectionIterator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionIterator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__1"


    // $ANTLR start "rule__CollectionIterator__Group__1__Impl"
    // InternalOCLX.g:2936:1: rule__CollectionIterator__Group__1__Impl : ( '(' ) ;
    public final void rule__CollectionIterator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2940:1: ( ( '(' ) )
            // InternalOCLX.g:2941:1: ( '(' )
            {
            // InternalOCLX.g:2941:1: ( '(' )
            // InternalOCLX.g:2942:2: '('
            {
             before(grammarAccess.getCollectionIteratorAccess().getLeftParenthesisKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getCollectionIteratorAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__1__Impl"


    // $ANTLR start "rule__CollectionIterator__Group__2"
    // InternalOCLX.g:2951:1: rule__CollectionIterator__Group__2 : rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 ;
    public final void rule__CollectionIterator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2955:1: ( rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 )
            // InternalOCLX.g:2956:2: rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__CollectionIterator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionIterator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__2"


    // $ANTLR start "rule__CollectionIterator__Group__2__Impl"
    // InternalOCLX.g:2963:1: rule__CollectionIterator__Group__2__Impl : ( ( rule__CollectionIterator__ItervarAssignment_2 ) ) ;
    public final void rule__CollectionIterator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2967:1: ( ( ( rule__CollectionIterator__ItervarAssignment_2 ) ) )
            // InternalOCLX.g:2968:1: ( ( rule__CollectionIterator__ItervarAssignment_2 ) )
            {
            // InternalOCLX.g:2968:1: ( ( rule__CollectionIterator__ItervarAssignment_2 ) )
            // InternalOCLX.g:2969:2: ( rule__CollectionIterator__ItervarAssignment_2 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getItervarAssignment_2()); 
            // InternalOCLX.g:2970:2: ( rule__CollectionIterator__ItervarAssignment_2 )
            // InternalOCLX.g:2970:3: rule__CollectionIterator__ItervarAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__CollectionIterator__ItervarAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCollectionIteratorAccess().getItervarAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__2__Impl"


    // $ANTLR start "rule__CollectionIterator__Group__3"
    // InternalOCLX.g:2978:1: rule__CollectionIterator__Group__3 : rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4 ;
    public final void rule__CollectionIterator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2982:1: ( rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4 )
            // InternalOCLX.g:2983:2: rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__CollectionIterator__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionIterator__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__3"


    // $ANTLR start "rule__CollectionIterator__Group__3__Impl"
    // InternalOCLX.g:2990:1: rule__CollectionIterator__Group__3__Impl : ( '|' ) ;
    public final void rule__CollectionIterator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2994:1: ( ( '|' ) )
            // InternalOCLX.g:2995:1: ( '|' )
            {
            // InternalOCLX.g:2995:1: ( '|' )
            // InternalOCLX.g:2996:2: '|'
            {
             before(grammarAccess.getCollectionIteratorAccess().getVerticalLineKeyword_3()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getCollectionIteratorAccess().getVerticalLineKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__3__Impl"


    // $ANTLR start "rule__CollectionIterator__Group__4"
    // InternalOCLX.g:3005:1: rule__CollectionIterator__Group__4 : rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5 ;
    public final void rule__CollectionIterator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3009:1: ( rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5 )
            // InternalOCLX.g:3010:2: rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5
            {
            pushFollow(FOLLOW_21);
            rule__CollectionIterator__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionIterator__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__4"


    // $ANTLR start "rule__CollectionIterator__Group__4__Impl"
    // InternalOCLX.g:3017:1: rule__CollectionIterator__Group__4__Impl : ( ( rule__CollectionIterator__BodyAssignment_4 ) ) ;
    public final void rule__CollectionIterator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3021:1: ( ( ( rule__CollectionIterator__BodyAssignment_4 ) ) )
            // InternalOCLX.g:3022:1: ( ( rule__CollectionIterator__BodyAssignment_4 ) )
            {
            // InternalOCLX.g:3022:1: ( ( rule__CollectionIterator__BodyAssignment_4 ) )
            // InternalOCLX.g:3023:2: ( rule__CollectionIterator__BodyAssignment_4 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getBodyAssignment_4()); 
            // InternalOCLX.g:3024:2: ( rule__CollectionIterator__BodyAssignment_4 )
            // InternalOCLX.g:3024:3: rule__CollectionIterator__BodyAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__CollectionIterator__BodyAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getCollectionIteratorAccess().getBodyAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__4__Impl"


    // $ANTLR start "rule__CollectionIterator__Group__5"
    // InternalOCLX.g:3032:1: rule__CollectionIterator__Group__5 : rule__CollectionIterator__Group__5__Impl ;
    public final void rule__CollectionIterator__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3036:1: ( rule__CollectionIterator__Group__5__Impl )
            // InternalOCLX.g:3037:2: rule__CollectionIterator__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectionIterator__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__5"


    // $ANTLR start "rule__CollectionIterator__Group__5__Impl"
    // InternalOCLX.g:3043:1: rule__CollectionIterator__Group__5__Impl : ( ')' ) ;
    public final void rule__CollectionIterator__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3047:1: ( ( ')' ) )
            // InternalOCLX.g:3048:1: ( ')' )
            {
            // InternalOCLX.g:3048:1: ( ')' )
            // InternalOCLX.g:3049:2: ')'
            {
             before(grammarAccess.getCollectionIteratorAccess().getRightParenthesisKeyword_5()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getCollectionIteratorAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__Group__5__Impl"


    // $ANTLR start "rule__IteratorVarDeclaration__Group_1__0"
    // InternalOCLX.g:3059:1: rule__IteratorVarDeclaration__Group_1__0 : rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1 ;
    public final void rule__IteratorVarDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3063:1: ( rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1 )
            // InternalOCLX.g:3064:2: rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1
            {
            pushFollow(FOLLOW_26);
            rule__IteratorVarDeclaration__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IteratorVarDeclaration__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorVarDeclaration__Group_1__0"


    // $ANTLR start "rule__IteratorVarDeclaration__Group_1__0__Impl"
    // InternalOCLX.g:3071:1: rule__IteratorVarDeclaration__Group_1__0__Impl : ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) ) ;
    public final void rule__IteratorVarDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3075:1: ( ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) ) )
            // InternalOCLX.g:3076:1: ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) )
            {
            // InternalOCLX.g:3076:1: ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) )
            // InternalOCLX.g:3077:2: ( rule__IteratorVarDeclaration__NameAssignment_1_0 )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_1_0()); 
            // InternalOCLX.g:3078:2: ( rule__IteratorVarDeclaration__NameAssignment_1_0 )
            // InternalOCLX.g:3078:3: rule__IteratorVarDeclaration__NameAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__IteratorVarDeclaration__NameAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorVarDeclaration__Group_1__0__Impl"


    // $ANTLR start "rule__IteratorVarDeclaration__Group_1__1"
    // InternalOCLX.g:3086:1: rule__IteratorVarDeclaration__Group_1__1 : rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2 ;
    public final void rule__IteratorVarDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3090:1: ( rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2 )
            // InternalOCLX.g:3091:2: rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2
            {
            pushFollow(FOLLOW_27);
            rule__IteratorVarDeclaration__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IteratorVarDeclaration__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorVarDeclaration__Group_1__1"


    // $ANTLR start "rule__IteratorVarDeclaration__Group_1__1__Impl"
    // InternalOCLX.g:3098:1: rule__IteratorVarDeclaration__Group_1__1__Impl : ( ':' ) ;
    public final void rule__IteratorVarDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3102:1: ( ( ':' ) )
            // InternalOCLX.g:3103:1: ( ':' )
            {
            // InternalOCLX.g:3103:1: ( ':' )
            // InternalOCLX.g:3104:2: ':'
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getColonKeyword_1_1()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getIteratorVarDeclarationAccess().getColonKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorVarDeclaration__Group_1__1__Impl"


    // $ANTLR start "rule__IteratorVarDeclaration__Group_1__2"
    // InternalOCLX.g:3113:1: rule__IteratorVarDeclaration__Group_1__2 : rule__IteratorVarDeclaration__Group_1__2__Impl ;
    public final void rule__IteratorVarDeclaration__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3117:1: ( rule__IteratorVarDeclaration__Group_1__2__Impl )
            // InternalOCLX.g:3118:2: rule__IteratorVarDeclaration__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IteratorVarDeclaration__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorVarDeclaration__Group_1__2"


    // $ANTLR start "rule__IteratorVarDeclaration__Group_1__2__Impl"
    // InternalOCLX.g:3124:1: rule__IteratorVarDeclaration__Group_1__2__Impl : ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) ) ;
    public final void rule__IteratorVarDeclaration__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3128:1: ( ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) ) )
            // InternalOCLX.g:3129:1: ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) )
            {
            // InternalOCLX.g:3129:1: ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) )
            // InternalOCLX.g:3130:2: ( rule__IteratorVarDeclaration__TypeAssignment_1_2 )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getTypeAssignment_1_2()); 
            // InternalOCLX.g:3131:2: ( rule__IteratorVarDeclaration__TypeAssignment_1_2 )
            // InternalOCLX.g:3131:3: rule__IteratorVarDeclaration__TypeAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__IteratorVarDeclaration__TypeAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getIteratorVarDeclarationAccess().getTypeAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorVarDeclaration__Group_1__2__Impl"


    // $ANTLR start "rule__MethodCall__Group_0__0"
    // InternalOCLX.g:3140:1: rule__MethodCall__Group_0__0 : rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1 ;
    public final void rule__MethodCall__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3144:1: ( rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1 )
            // InternalOCLX.g:3145:2: rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1
            {
            pushFollow(FOLLOW_28);
            rule__MethodCall__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MethodCall__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_0__0"


    // $ANTLR start "rule__MethodCall__Group_0__0__Impl"
    // InternalOCLX.g:3152:1: rule__MethodCall__Group_0__0__Impl : ( ( rule__MethodCall__NameAssignment_0_0 ) ) ;
    public final void rule__MethodCall__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3156:1: ( ( ( rule__MethodCall__NameAssignment_0_0 ) ) )
            // InternalOCLX.g:3157:1: ( ( rule__MethodCall__NameAssignment_0_0 ) )
            {
            // InternalOCLX.g:3157:1: ( ( rule__MethodCall__NameAssignment_0_0 ) )
            // InternalOCLX.g:3158:2: ( rule__MethodCall__NameAssignment_0_0 )
            {
             before(grammarAccess.getMethodCallAccess().getNameAssignment_0_0()); 
            // InternalOCLX.g:3159:2: ( rule__MethodCall__NameAssignment_0_0 )
            // InternalOCLX.g:3159:3: rule__MethodCall__NameAssignment_0_0
            {
            pushFollow(FOLLOW_2);
            rule__MethodCall__NameAssignment_0_0();

            state._fsp--;


            }

             after(grammarAccess.getMethodCallAccess().getNameAssignment_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_0__0__Impl"


    // $ANTLR start "rule__MethodCall__Group_0__1"
    // InternalOCLX.g:3167:1: rule__MethodCall__Group_0__1 : rule__MethodCall__Group_0__1__Impl ;
    public final void rule__MethodCall__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3171:1: ( rule__MethodCall__Group_0__1__Impl )
            // InternalOCLX.g:3172:2: rule__MethodCall__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MethodCall__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_0__1"


    // $ANTLR start "rule__MethodCall__Group_0__1__Impl"
    // InternalOCLX.g:3178:1: rule__MethodCall__Group_0__1__Impl : ( '()' ) ;
    public final void rule__MethodCall__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3182:1: ( ( '()' ) )
            // InternalOCLX.g:3183:1: ( '()' )
            {
            // InternalOCLX.g:3183:1: ( '()' )
            // InternalOCLX.g:3184:2: '()'
            {
             before(grammarAccess.getMethodCallAccess().getLeftParenthesisRightParenthesisKeyword_0_1()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getMethodCallAccess().getLeftParenthesisRightParenthesisKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_0__1__Impl"


    // $ANTLR start "rule__MethodCall__Group_1__0"
    // InternalOCLX.g:3194:1: rule__MethodCall__Group_1__0 : rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1 ;
    public final void rule__MethodCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3198:1: ( rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1 )
            // InternalOCLX.g:3199:2: rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__MethodCall__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MethodCall__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_1__0"


    // $ANTLR start "rule__MethodCall__Group_1__0__Impl"
    // InternalOCLX.g:3206:1: rule__MethodCall__Group_1__0__Impl : ( ( rule__MethodCall__NameAssignment_1_0 ) ) ;
    public final void rule__MethodCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3210:1: ( ( ( rule__MethodCall__NameAssignment_1_0 ) ) )
            // InternalOCLX.g:3211:1: ( ( rule__MethodCall__NameAssignment_1_0 ) )
            {
            // InternalOCLX.g:3211:1: ( ( rule__MethodCall__NameAssignment_1_0 ) )
            // InternalOCLX.g:3212:2: ( rule__MethodCall__NameAssignment_1_0 )
            {
             before(grammarAccess.getMethodCallAccess().getNameAssignment_1_0()); 
            // InternalOCLX.g:3213:2: ( rule__MethodCall__NameAssignment_1_0 )
            // InternalOCLX.g:3213:3: rule__MethodCall__NameAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MethodCall__NameAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMethodCallAccess().getNameAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_1__0__Impl"


    // $ANTLR start "rule__MethodCall__Group_1__1"
    // InternalOCLX.g:3221:1: rule__MethodCall__Group_1__1 : rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2 ;
    public final void rule__MethodCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3225:1: ( rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2 )
            // InternalOCLX.g:3226:2: rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2
            {
            pushFollow(FOLLOW_8);
            rule__MethodCall__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MethodCall__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_1__1"


    // $ANTLR start "rule__MethodCall__Group_1__1__Impl"
    // InternalOCLX.g:3233:1: rule__MethodCall__Group_1__1__Impl : ( '(' ) ;
    public final void rule__MethodCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3237:1: ( ( '(' ) )
            // InternalOCLX.g:3238:1: ( '(' )
            {
            // InternalOCLX.g:3238:1: ( '(' )
            // InternalOCLX.g:3239:2: '('
            {
             before(grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_1_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_1__1__Impl"


    // $ANTLR start "rule__MethodCall__Group_1__2"
    // InternalOCLX.g:3248:1: rule__MethodCall__Group_1__2 : rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3 ;
    public final void rule__MethodCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3252:1: ( rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3 )
            // InternalOCLX.g:3253:2: rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3
            {
            pushFollow(FOLLOW_21);
            rule__MethodCall__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MethodCall__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_1__2"


    // $ANTLR start "rule__MethodCall__Group_1__2__Impl"
    // InternalOCLX.g:3260:1: rule__MethodCall__Group_1__2__Impl : ( ( rule__MethodCall__ArgsAssignment_1_2 ) ) ;
    public final void rule__MethodCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3264:1: ( ( ( rule__MethodCall__ArgsAssignment_1_2 ) ) )
            // InternalOCLX.g:3265:1: ( ( rule__MethodCall__ArgsAssignment_1_2 ) )
            {
            // InternalOCLX.g:3265:1: ( ( rule__MethodCall__ArgsAssignment_1_2 ) )
            // InternalOCLX.g:3266:2: ( rule__MethodCall__ArgsAssignment_1_2 )
            {
             before(grammarAccess.getMethodCallAccess().getArgsAssignment_1_2()); 
            // InternalOCLX.g:3267:2: ( rule__MethodCall__ArgsAssignment_1_2 )
            // InternalOCLX.g:3267:3: rule__MethodCall__ArgsAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__MethodCall__ArgsAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getMethodCallAccess().getArgsAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_1__2__Impl"


    // $ANTLR start "rule__MethodCall__Group_1__3"
    // InternalOCLX.g:3275:1: rule__MethodCall__Group_1__3 : rule__MethodCall__Group_1__3__Impl ;
    public final void rule__MethodCall__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3279:1: ( rule__MethodCall__Group_1__3__Impl )
            // InternalOCLX.g:3280:2: rule__MethodCall__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MethodCall__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_1__3"


    // $ANTLR start "rule__MethodCall__Group_1__3__Impl"
    // InternalOCLX.g:3286:1: rule__MethodCall__Group_1__3__Impl : ( ')' ) ;
    public final void rule__MethodCall__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3290:1: ( ( ')' ) )
            // InternalOCLX.g:3291:1: ( ')' )
            {
            // InternalOCLX.g:3291:1: ( ')' )
            // InternalOCLX.g:3292:2: ')'
            {
             before(grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_1_3()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__Group_1__3__Impl"


    // $ANTLR start "rule__TypeCall__Group__0"
    // InternalOCLX.g:3302:1: rule__TypeCall__Group__0 : rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1 ;
    public final void rule__TypeCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3306:1: ( rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1 )
            // InternalOCLX.g:3307:2: rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__TypeCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeCall__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeCall__Group__0"


    // $ANTLR start "rule__TypeCall__Group__0__Impl"
    // InternalOCLX.g:3314:1: rule__TypeCall__Group__0__Impl : ( ( rule__TypeCall__NameAssignment_0 ) ) ;
    public final void rule__TypeCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3318:1: ( ( ( rule__TypeCall__NameAssignment_0 ) ) )
            // InternalOCLX.g:3319:1: ( ( rule__TypeCall__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3319:1: ( ( rule__TypeCall__NameAssignment_0 ) )
            // InternalOCLX.g:3320:2: ( rule__TypeCall__NameAssignment_0 )
            {
             before(grammarAccess.getTypeCallAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3321:2: ( rule__TypeCall__NameAssignment_0 )
            // InternalOCLX.g:3321:3: rule__TypeCall__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TypeCall__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeCallAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeCall__Group__0__Impl"


    // $ANTLR start "rule__TypeCall__Group__1"
    // InternalOCLX.g:3329:1: rule__TypeCall__Group__1 : rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2 ;
    public final void rule__TypeCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3333:1: ( rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2 )
            // InternalOCLX.g:3334:2: rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__TypeCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeCall__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeCall__Group__1"


    // $ANTLR start "rule__TypeCall__Group__1__Impl"
    // InternalOCLX.g:3341:1: rule__TypeCall__Group__1__Impl : ( '(' ) ;
    public final void rule__TypeCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3345:1: ( ( '(' ) )
            // InternalOCLX.g:3346:1: ( '(' )
            {
            // InternalOCLX.g:3346:1: ( '(' )
            // InternalOCLX.g:3347:2: '('
            {
             before(grammarAccess.getTypeCallAccess().getLeftParenthesisKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getTypeCallAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeCall__Group__1__Impl"


    // $ANTLR start "rule__TypeCall__Group__2"
    // InternalOCLX.g:3356:1: rule__TypeCall__Group__2 : rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3 ;
    public final void rule__TypeCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3360:1: ( rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3 )
            // InternalOCLX.g:3361:2: rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__TypeCall__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeCall__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeCall__Group__2"


    // $ANTLR start "rule__TypeCall__Group__2__Impl"
    // InternalOCLX.g:3368:1: rule__TypeCall__Group__2__Impl : ( ( rule__TypeCall__TypeAssignment_2 ) ) ;
    public final void rule__TypeCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3372:1: ( ( ( rule__TypeCall__TypeAssignment_2 ) ) )
            // InternalOCLX.g:3373:1: ( ( rule__TypeCall__TypeAssignment_2 ) )
            {
            // InternalOCLX.g:3373:1: ( ( rule__TypeCall__TypeAssignment_2 ) )
            // InternalOCLX.g:3374:2: ( rule__TypeCall__TypeAssignment_2 )
            {
             before(grammarAccess.getTypeCallAccess().getTypeAssignment_2()); 
            // InternalOCLX.g:3375:2: ( rule__TypeCall__TypeAssignment_2 )
            // InternalOCLX.g:3375:3: rule__TypeCall__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TypeCall__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTypeCallAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeCall__Group__2__Impl"


    // $ANTLR start "rule__TypeCall__Group__3"
    // InternalOCLX.g:3383:1: rule__TypeCall__Group__3 : rule__TypeCall__Group__3__Impl ;
    public final void rule__TypeCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3387:1: ( rule__TypeCall__Group__3__Impl )
            // InternalOCLX.g:3388:2: rule__TypeCall__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeCall__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeCall__Group__3"


    // $ANTLR start "rule__TypeCall__Group__3__Impl"
    // InternalOCLX.g:3394:1: rule__TypeCall__Group__3__Impl : ( ')' ) ;
    public final void rule__TypeCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3398:1: ( ( ')' ) )
            // InternalOCLX.g:3399:1: ( ')' )
            {
            // InternalOCLX.g:3399:1: ( ')' )
            // InternalOCLX.g:3400:2: ')'
            {
             before(grammarAccess.getTypeCallAccess().getRightParenthesisKeyword_3()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getTypeCallAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeCall__Group__3__Impl"


    // $ANTLR start "rule__TypeExp__Group_0__0"
    // InternalOCLX.g:3410:1: rule__TypeExp__Group_0__0 : rule__TypeExp__Group_0__0__Impl rule__TypeExp__Group_0__1 ;
    public final void rule__TypeExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3414:1: ( rule__TypeExp__Group_0__0__Impl rule__TypeExp__Group_0__1 )
            // InternalOCLX.g:3415:2: rule__TypeExp__Group_0__0__Impl rule__TypeExp__Group_0__1
            {
            pushFollow(FOLLOW_29);
            rule__TypeExp__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeExp__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_0__0"


    // $ANTLR start "rule__TypeExp__Group_0__0__Impl"
    // InternalOCLX.g:3422:1: rule__TypeExp__Group_0__0__Impl : ( () ) ;
    public final void rule__TypeExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3426:1: ( ( () ) )
            // InternalOCLX.g:3427:1: ( () )
            {
            // InternalOCLX.g:3427:1: ( () )
            // InternalOCLX.g:3428:2: ()
            {
             before(grammarAccess.getTypeExpAccess().getTypeExpAction_0_0()); 
            // InternalOCLX.g:3429:2: ()
            // InternalOCLX.g:3429:3: 
            {
            }

             after(grammarAccess.getTypeExpAccess().getTypeExpAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_0__0__Impl"


    // $ANTLR start "rule__TypeExp__Group_0__1"
    // InternalOCLX.g:3437:1: rule__TypeExp__Group_0__1 : rule__TypeExp__Group_0__1__Impl rule__TypeExp__Group_0__2 ;
    public final void rule__TypeExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3441:1: ( rule__TypeExp__Group_0__1__Impl rule__TypeExp__Group_0__2 )
            // InternalOCLX.g:3442:2: rule__TypeExp__Group_0__1__Impl rule__TypeExp__Group_0__2
            {
            pushFollow(FOLLOW_4);
            rule__TypeExp__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeExp__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_0__1"


    // $ANTLR start "rule__TypeExp__Group_0__1__Impl"
    // InternalOCLX.g:3449:1: rule__TypeExp__Group_0__1__Impl : ( '<' ) ;
    public final void rule__TypeExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3453:1: ( ( '<' ) )
            // InternalOCLX.g:3454:1: ( '<' )
            {
            // InternalOCLX.g:3454:1: ( '<' )
            // InternalOCLX.g:3455:2: '<'
            {
             before(grammarAccess.getTypeExpAccess().getLessThanSignKeyword_0_1()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getTypeExpAccess().getLessThanSignKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_0__1__Impl"


    // $ANTLR start "rule__TypeExp__Group_0__2"
    // InternalOCLX.g:3464:1: rule__TypeExp__Group_0__2 : rule__TypeExp__Group_0__2__Impl rule__TypeExp__Group_0__3 ;
    public final void rule__TypeExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3468:1: ( rule__TypeExp__Group_0__2__Impl rule__TypeExp__Group_0__3 )
            // InternalOCLX.g:3469:2: rule__TypeExp__Group_0__2__Impl rule__TypeExp__Group_0__3
            {
            pushFollow(FOLLOW_30);
            rule__TypeExp__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeExp__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_0__2"


    // $ANTLR start "rule__TypeExp__Group_0__2__Impl"
    // InternalOCLX.g:3476:1: rule__TypeExp__Group_0__2__Impl : ( ( rule__TypeExp__NameAssignment_0_2 ) ) ;
    public final void rule__TypeExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3480:1: ( ( ( rule__TypeExp__NameAssignment_0_2 ) ) )
            // InternalOCLX.g:3481:1: ( ( rule__TypeExp__NameAssignment_0_2 ) )
            {
            // InternalOCLX.g:3481:1: ( ( rule__TypeExp__NameAssignment_0_2 ) )
            // InternalOCLX.g:3482:2: ( rule__TypeExp__NameAssignment_0_2 )
            {
             before(grammarAccess.getTypeExpAccess().getNameAssignment_0_2()); 
            // InternalOCLX.g:3483:2: ( rule__TypeExp__NameAssignment_0_2 )
            // InternalOCLX.g:3483:3: rule__TypeExp__NameAssignment_0_2
            {
            pushFollow(FOLLOW_2);
            rule__TypeExp__NameAssignment_0_2();

            state._fsp--;


            }

             after(grammarAccess.getTypeExpAccess().getNameAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_0__2__Impl"


    // $ANTLR start "rule__TypeExp__Group_0__3"
    // InternalOCLX.g:3491:1: rule__TypeExp__Group_0__3 : rule__TypeExp__Group_0__3__Impl ;
    public final void rule__TypeExp__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3495:1: ( rule__TypeExp__Group_0__3__Impl )
            // InternalOCLX.g:3496:2: rule__TypeExp__Group_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeExp__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_0__3"


    // $ANTLR start "rule__TypeExp__Group_0__3__Impl"
    // InternalOCLX.g:3502:1: rule__TypeExp__Group_0__3__Impl : ( '>' ) ;
    public final void rule__TypeExp__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3506:1: ( ( '>' ) )
            // InternalOCLX.g:3507:1: ( '>' )
            {
            // InternalOCLX.g:3507:1: ( '>' )
            // InternalOCLX.g:3508:2: '>'
            {
             before(grammarAccess.getTypeExpAccess().getGreaterThanSignKeyword_0_3()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getTypeExpAccess().getGreaterThanSignKeyword_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_0__3__Impl"


    // $ANTLR start "rule__TypeExp__Group_1__0"
    // InternalOCLX.g:3518:1: rule__TypeExp__Group_1__0 : rule__TypeExp__Group_1__0__Impl rule__TypeExp__Group_1__1 ;
    public final void rule__TypeExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3522:1: ( rule__TypeExp__Group_1__0__Impl rule__TypeExp__Group_1__1 )
            // InternalOCLX.g:3523:2: rule__TypeExp__Group_1__0__Impl rule__TypeExp__Group_1__1
            {
            pushFollow(FOLLOW_27);
            rule__TypeExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_1__0"


    // $ANTLR start "rule__TypeExp__Group_1__0__Impl"
    // InternalOCLX.g:3530:1: rule__TypeExp__Group_1__0__Impl : ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) ) ;
    public final void rule__TypeExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3534:1: ( ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) ) )
            // InternalOCLX.g:3535:1: ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) )
            {
            // InternalOCLX.g:3535:1: ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) )
            // InternalOCLX.g:3536:2: ( rule__TypeExp__CollectionTypeAssignment_1_0 )
            {
             before(grammarAccess.getTypeExpAccess().getCollectionTypeAssignment_1_0()); 
            // InternalOCLX.g:3537:2: ( rule__TypeExp__CollectionTypeAssignment_1_0 )
            // InternalOCLX.g:3537:3: rule__TypeExp__CollectionTypeAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__TypeExp__CollectionTypeAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeExpAccess().getCollectionTypeAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_1__0__Impl"


    // $ANTLR start "rule__TypeExp__Group_1__1"
    // InternalOCLX.g:3545:1: rule__TypeExp__Group_1__1 : rule__TypeExp__Group_1__1__Impl ;
    public final void rule__TypeExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3549:1: ( rule__TypeExp__Group_1__1__Impl )
            // InternalOCLX.g:3550:2: rule__TypeExp__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeExp__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_1__1"


    // $ANTLR start "rule__TypeExp__Group_1__1__Impl"
    // InternalOCLX.g:3556:1: rule__TypeExp__Group_1__1__Impl : ( ( rule__TypeExp__TypeAssignment_1_1 ) ) ;
    public final void rule__TypeExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3560:1: ( ( ( rule__TypeExp__TypeAssignment_1_1 ) ) )
            // InternalOCLX.g:3561:1: ( ( rule__TypeExp__TypeAssignment_1_1 ) )
            {
            // InternalOCLX.g:3561:1: ( ( rule__TypeExp__TypeAssignment_1_1 ) )
            // InternalOCLX.g:3562:2: ( rule__TypeExp__TypeAssignment_1_1 )
            {
             before(grammarAccess.getTypeExpAccess().getTypeAssignment_1_1()); 
            // InternalOCLX.g:3563:2: ( rule__TypeExp__TypeAssignment_1_1 )
            // InternalOCLX.g:3563:3: rule__TypeExp__TypeAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeExp__TypeAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeExpAccess().getTypeAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group_1__1__Impl"


    // $ANTLR start "rule__UnaryTemporalExp__Group__0"
    // InternalOCLX.g:3572:1: rule__UnaryTemporalExp__Group__0 : rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1 ;
    public final void rule__UnaryTemporalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3576:1: ( rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1 )
            // InternalOCLX.g:3577:2: rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__UnaryTemporalExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnaryTemporalExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryTemporalExp__Group__0"


    // $ANTLR start "rule__UnaryTemporalExp__Group__0__Impl"
    // InternalOCLX.g:3584:1: rule__UnaryTemporalExp__Group__0__Impl : ( ( rule__UnaryTemporalExp__NameAssignment_0 ) ) ;
    public final void rule__UnaryTemporalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3588:1: ( ( ( rule__UnaryTemporalExp__NameAssignment_0 ) ) )
            // InternalOCLX.g:3589:1: ( ( rule__UnaryTemporalExp__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3589:1: ( ( rule__UnaryTemporalExp__NameAssignment_0 ) )
            // InternalOCLX.g:3590:2: ( rule__UnaryTemporalExp__NameAssignment_0 )
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3591:2: ( rule__UnaryTemporalExp__NameAssignment_0 )
            // InternalOCLX.g:3591:3: rule__UnaryTemporalExp__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__UnaryTemporalExp__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getUnaryTemporalExpAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryTemporalExp__Group__0__Impl"


    // $ANTLR start "rule__UnaryTemporalExp__Group__1"
    // InternalOCLX.g:3599:1: rule__UnaryTemporalExp__Group__1 : rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2 ;
    public final void rule__UnaryTemporalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3603:1: ( rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2 )
            // InternalOCLX.g:3604:2: rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__UnaryTemporalExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnaryTemporalExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryTemporalExp__Group__1"


    // $ANTLR start "rule__UnaryTemporalExp__Group__1__Impl"
    // InternalOCLX.g:3611:1: rule__UnaryTemporalExp__Group__1__Impl : ( '(' ) ;
    public final void rule__UnaryTemporalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3615:1: ( ( '(' ) )
            // InternalOCLX.g:3616:1: ( '(' )
            {
            // InternalOCLX.g:3616:1: ( '(' )
            // InternalOCLX.g:3617:2: '('
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getLeftParenthesisKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getUnaryTemporalExpAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryTemporalExp__Group__1__Impl"


    // $ANTLR start "rule__UnaryTemporalExp__Group__2"
    // InternalOCLX.g:3626:1: rule__UnaryTemporalExp__Group__2 : rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3 ;
    public final void rule__UnaryTemporalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3630:1: ( rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3 )
            // InternalOCLX.g:3631:2: rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__UnaryTemporalExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnaryTemporalExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryTemporalExp__Group__2"


    // $ANTLR start "rule__UnaryTemporalExp__Group__2__Impl"
    // InternalOCLX.g:3638:1: rule__UnaryTemporalExp__Group__2__Impl : ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) ) ;
    public final void rule__UnaryTemporalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3642:1: ( ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) ) )
            // InternalOCLX.g:3643:1: ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) )
            {
            // InternalOCLX.g:3643:1: ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) )
            // InternalOCLX.g:3644:2: ( rule__UnaryTemporalExp__ExpAssignment_2 )
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getExpAssignment_2()); 
            // InternalOCLX.g:3645:2: ( rule__UnaryTemporalExp__ExpAssignment_2 )
            // InternalOCLX.g:3645:3: rule__UnaryTemporalExp__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__UnaryTemporalExp__ExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getUnaryTemporalExpAccess().getExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryTemporalExp__Group__2__Impl"


    // $ANTLR start "rule__UnaryTemporalExp__Group__3"
    // InternalOCLX.g:3653:1: rule__UnaryTemporalExp__Group__3 : rule__UnaryTemporalExp__Group__3__Impl ;
    public final void rule__UnaryTemporalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3657:1: ( rule__UnaryTemporalExp__Group__3__Impl )
            // InternalOCLX.g:3658:2: rule__UnaryTemporalExp__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnaryTemporalExp__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryTemporalExp__Group__3"


    // $ANTLR start "rule__UnaryTemporalExp__Group__3__Impl"
    // InternalOCLX.g:3664:1: rule__UnaryTemporalExp__Group__3__Impl : ( ')' ) ;
    public final void rule__UnaryTemporalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3668:1: ( ( ')' ) )
            // InternalOCLX.g:3669:1: ( ')' )
            {
            // InternalOCLX.g:3669:1: ( ')' )
            // InternalOCLX.g:3670:2: ')'
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getRightParenthesisKeyword_3()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getUnaryTemporalExpAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryTemporalExp__Group__3__Impl"


    // $ANTLR start "rule__TemporalAsLongAs__Group__0"
    // InternalOCLX.g:3680:1: rule__TemporalAsLongAs__Group__0 : rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1 ;
    public final void rule__TemporalAsLongAs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3684:1: ( rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1 )
            // InternalOCLX.g:3685:2: rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__TemporalAsLongAs__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalAsLongAs__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__0"


    // $ANTLR start "rule__TemporalAsLongAs__Group__0__Impl"
    // InternalOCLX.g:3692:1: rule__TemporalAsLongAs__Group__0__Impl : ( ( rule__TemporalAsLongAs__NameAssignment_0 ) ) ;
    public final void rule__TemporalAsLongAs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3696:1: ( ( ( rule__TemporalAsLongAs__NameAssignment_0 ) ) )
            // InternalOCLX.g:3697:1: ( ( rule__TemporalAsLongAs__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3697:1: ( ( rule__TemporalAsLongAs__NameAssignment_0 ) )
            // InternalOCLX.g:3698:2: ( rule__TemporalAsLongAs__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3699:2: ( rule__TemporalAsLongAs__NameAssignment_0 )
            // InternalOCLX.g:3699:3: rule__TemporalAsLongAs__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TemporalAsLongAs__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTemporalAsLongAsAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__0__Impl"


    // $ANTLR start "rule__TemporalAsLongAs__Group__1"
    // InternalOCLX.g:3707:1: rule__TemporalAsLongAs__Group__1 : rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2 ;
    public final void rule__TemporalAsLongAs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3711:1: ( rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2 )
            // InternalOCLX.g:3712:2: rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__TemporalAsLongAs__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalAsLongAs__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__1"


    // $ANTLR start "rule__TemporalAsLongAs__Group__1__Impl"
    // InternalOCLX.g:3719:1: rule__TemporalAsLongAs__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalAsLongAs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3723:1: ( ( '(' ) )
            // InternalOCLX.g:3724:1: ( '(' )
            {
            // InternalOCLX.g:3724:1: ( '(' )
            // InternalOCLX.g:3725:2: '('
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getLeftParenthesisKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getTemporalAsLongAsAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__1__Impl"


    // $ANTLR start "rule__TemporalAsLongAs__Group__2"
    // InternalOCLX.g:3734:1: rule__TemporalAsLongAs__Group__2 : rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3 ;
    public final void rule__TemporalAsLongAs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3738:1: ( rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3 )
            // InternalOCLX.g:3739:2: rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__TemporalAsLongAs__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalAsLongAs__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__2"


    // $ANTLR start "rule__TemporalAsLongAs__Group__2__Impl"
    // InternalOCLX.g:3746:1: rule__TemporalAsLongAs__Group__2__Impl : ( ( rule__TemporalAsLongAs__BAssignment_2 ) ) ;
    public final void rule__TemporalAsLongAs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3750:1: ( ( ( rule__TemporalAsLongAs__BAssignment_2 ) ) )
            // InternalOCLX.g:3751:1: ( ( rule__TemporalAsLongAs__BAssignment_2 ) )
            {
            // InternalOCLX.g:3751:1: ( ( rule__TemporalAsLongAs__BAssignment_2 ) )
            // InternalOCLX.g:3752:2: ( rule__TemporalAsLongAs__BAssignment_2 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getBAssignment_2()); 
            // InternalOCLX.g:3753:2: ( rule__TemporalAsLongAs__BAssignment_2 )
            // InternalOCLX.g:3753:3: rule__TemporalAsLongAs__BAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TemporalAsLongAs__BAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTemporalAsLongAsAccess().getBAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__2__Impl"


    // $ANTLR start "rule__TemporalAsLongAs__Group__3"
    // InternalOCLX.g:3761:1: rule__TemporalAsLongAs__Group__3 : rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4 ;
    public final void rule__TemporalAsLongAs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3765:1: ( rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4 )
            // InternalOCLX.g:3766:2: rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__TemporalAsLongAs__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalAsLongAs__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__3"


    // $ANTLR start "rule__TemporalAsLongAs__Group__3__Impl"
    // InternalOCLX.g:3773:1: rule__TemporalAsLongAs__Group__3__Impl : ( 'ensureThat' ) ;
    public final void rule__TemporalAsLongAs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3777:1: ( ( 'ensureThat' ) )
            // InternalOCLX.g:3778:1: ( 'ensureThat' )
            {
            // InternalOCLX.g:3778:1: ( 'ensureThat' )
            // InternalOCLX.g:3779:2: 'ensureThat'
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getEnsureThatKeyword_3()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getTemporalAsLongAsAccess().getEnsureThatKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__3__Impl"


    // $ANTLR start "rule__TemporalAsLongAs__Group__4"
    // InternalOCLX.g:3788:1: rule__TemporalAsLongAs__Group__4 : rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5 ;
    public final void rule__TemporalAsLongAs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3792:1: ( rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5 )
            // InternalOCLX.g:3793:2: rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5
            {
            pushFollow(FOLLOW_21);
            rule__TemporalAsLongAs__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalAsLongAs__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__4"


    // $ANTLR start "rule__TemporalAsLongAs__Group__4__Impl"
    // InternalOCLX.g:3800:1: rule__TemporalAsLongAs__Group__4__Impl : ( ( rule__TemporalAsLongAs__AAssignment_4 ) ) ;
    public final void rule__TemporalAsLongAs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3804:1: ( ( ( rule__TemporalAsLongAs__AAssignment_4 ) ) )
            // InternalOCLX.g:3805:1: ( ( rule__TemporalAsLongAs__AAssignment_4 ) )
            {
            // InternalOCLX.g:3805:1: ( ( rule__TemporalAsLongAs__AAssignment_4 ) )
            // InternalOCLX.g:3806:2: ( rule__TemporalAsLongAs__AAssignment_4 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getAAssignment_4()); 
            // InternalOCLX.g:3807:2: ( rule__TemporalAsLongAs__AAssignment_4 )
            // InternalOCLX.g:3807:3: rule__TemporalAsLongAs__AAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__TemporalAsLongAs__AAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTemporalAsLongAsAccess().getAAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__4__Impl"


    // $ANTLR start "rule__TemporalAsLongAs__Group__5"
    // InternalOCLX.g:3815:1: rule__TemporalAsLongAs__Group__5 : rule__TemporalAsLongAs__Group__5__Impl ;
    public final void rule__TemporalAsLongAs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3819:1: ( rule__TemporalAsLongAs__Group__5__Impl )
            // InternalOCLX.g:3820:2: rule__TemporalAsLongAs__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TemporalAsLongAs__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__5"


    // $ANTLR start "rule__TemporalAsLongAs__Group__5__Impl"
    // InternalOCLX.g:3826:1: rule__TemporalAsLongAs__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalAsLongAs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3830:1: ( ( ')' ) )
            // InternalOCLX.g:3831:1: ( ')' )
            {
            // InternalOCLX.g:3831:1: ( ')' )
            // InternalOCLX.g:3832:2: ')'
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getRightParenthesisKeyword_5()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getTemporalAsLongAsAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__Group__5__Impl"


    // $ANTLR start "rule__TemporalUntil__Group__0"
    // InternalOCLX.g:3842:1: rule__TemporalUntil__Group__0 : rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1 ;
    public final void rule__TemporalUntil__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3846:1: ( rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1 )
            // InternalOCLX.g:3847:2: rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__TemporalUntil__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalUntil__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__0"


    // $ANTLR start "rule__TemporalUntil__Group__0__Impl"
    // InternalOCLX.g:3854:1: rule__TemporalUntil__Group__0__Impl : ( ( rule__TemporalUntil__NameAssignment_0 ) ) ;
    public final void rule__TemporalUntil__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3858:1: ( ( ( rule__TemporalUntil__NameAssignment_0 ) ) )
            // InternalOCLX.g:3859:1: ( ( rule__TemporalUntil__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3859:1: ( ( rule__TemporalUntil__NameAssignment_0 ) )
            // InternalOCLX.g:3860:2: ( rule__TemporalUntil__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalUntilAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3861:2: ( rule__TemporalUntil__NameAssignment_0 )
            // InternalOCLX.g:3861:3: rule__TemporalUntil__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TemporalUntil__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTemporalUntilAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__0__Impl"


    // $ANTLR start "rule__TemporalUntil__Group__1"
    // InternalOCLX.g:3869:1: rule__TemporalUntil__Group__1 : rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2 ;
    public final void rule__TemporalUntil__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3873:1: ( rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2 )
            // InternalOCLX.g:3874:2: rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__TemporalUntil__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalUntil__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__1"


    // $ANTLR start "rule__TemporalUntil__Group__1__Impl"
    // InternalOCLX.g:3881:1: rule__TemporalUntil__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalUntil__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3885:1: ( ( '(' ) )
            // InternalOCLX.g:3886:1: ( '(' )
            {
            // InternalOCLX.g:3886:1: ( '(' )
            // InternalOCLX.g:3887:2: '('
            {
             before(grammarAccess.getTemporalUntilAccess().getLeftParenthesisKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getTemporalUntilAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__1__Impl"


    // $ANTLR start "rule__TemporalUntil__Group__2"
    // InternalOCLX.g:3896:1: rule__TemporalUntil__Group__2 : rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3 ;
    public final void rule__TemporalUntil__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3900:1: ( rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3 )
            // InternalOCLX.g:3901:2: rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3
            {
            pushFollow(FOLLOW_32);
            rule__TemporalUntil__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalUntil__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__2"


    // $ANTLR start "rule__TemporalUntil__Group__2__Impl"
    // InternalOCLX.g:3908:1: rule__TemporalUntil__Group__2__Impl : ( ( rule__TemporalUntil__AAssignment_2 ) ) ;
    public final void rule__TemporalUntil__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3912:1: ( ( ( rule__TemporalUntil__AAssignment_2 ) ) )
            // InternalOCLX.g:3913:1: ( ( rule__TemporalUntil__AAssignment_2 ) )
            {
            // InternalOCLX.g:3913:1: ( ( rule__TemporalUntil__AAssignment_2 ) )
            // InternalOCLX.g:3914:2: ( rule__TemporalUntil__AAssignment_2 )
            {
             before(grammarAccess.getTemporalUntilAccess().getAAssignment_2()); 
            // InternalOCLX.g:3915:2: ( rule__TemporalUntil__AAssignment_2 )
            // InternalOCLX.g:3915:3: rule__TemporalUntil__AAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TemporalUntil__AAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTemporalUntilAccess().getAAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__2__Impl"


    // $ANTLR start "rule__TemporalUntil__Group__3"
    // InternalOCLX.g:3923:1: rule__TemporalUntil__Group__3 : rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4 ;
    public final void rule__TemporalUntil__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3927:1: ( rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4 )
            // InternalOCLX.g:3928:2: rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__TemporalUntil__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalUntil__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__3"


    // $ANTLR start "rule__TemporalUntil__Group__3__Impl"
    // InternalOCLX.g:3935:1: rule__TemporalUntil__Group__3__Impl : ( 'asLongAs' ) ;
    public final void rule__TemporalUntil__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3939:1: ( ( 'asLongAs' ) )
            // InternalOCLX.g:3940:1: ( 'asLongAs' )
            {
            // InternalOCLX.g:3940:1: ( 'asLongAs' )
            // InternalOCLX.g:3941:2: 'asLongAs'
            {
             before(grammarAccess.getTemporalUntilAccess().getAsLongAsKeyword_3()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getTemporalUntilAccess().getAsLongAsKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__3__Impl"


    // $ANTLR start "rule__TemporalUntil__Group__4"
    // InternalOCLX.g:3950:1: rule__TemporalUntil__Group__4 : rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5 ;
    public final void rule__TemporalUntil__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3954:1: ( rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5 )
            // InternalOCLX.g:3955:2: rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5
            {
            pushFollow(FOLLOW_21);
            rule__TemporalUntil__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalUntil__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__4"


    // $ANTLR start "rule__TemporalUntil__Group__4__Impl"
    // InternalOCLX.g:3962:1: rule__TemporalUntil__Group__4__Impl : ( ( rule__TemporalUntil__BAssignment_4 ) ) ;
    public final void rule__TemporalUntil__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3966:1: ( ( ( rule__TemporalUntil__BAssignment_4 ) ) )
            // InternalOCLX.g:3967:1: ( ( rule__TemporalUntil__BAssignment_4 ) )
            {
            // InternalOCLX.g:3967:1: ( ( rule__TemporalUntil__BAssignment_4 ) )
            // InternalOCLX.g:3968:2: ( rule__TemporalUntil__BAssignment_4 )
            {
             before(grammarAccess.getTemporalUntilAccess().getBAssignment_4()); 
            // InternalOCLX.g:3969:2: ( rule__TemporalUntil__BAssignment_4 )
            // InternalOCLX.g:3969:3: rule__TemporalUntil__BAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__TemporalUntil__BAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTemporalUntilAccess().getBAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__4__Impl"


    // $ANTLR start "rule__TemporalUntil__Group__5"
    // InternalOCLX.g:3977:1: rule__TemporalUntil__Group__5 : rule__TemporalUntil__Group__5__Impl ;
    public final void rule__TemporalUntil__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3981:1: ( rule__TemporalUntil__Group__5__Impl )
            // InternalOCLX.g:3982:2: rule__TemporalUntil__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TemporalUntil__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__5"


    // $ANTLR start "rule__TemporalUntil__Group__5__Impl"
    // InternalOCLX.g:3988:1: rule__TemporalUntil__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalUntil__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3992:1: ( ( ')' ) )
            // InternalOCLX.g:3993:1: ( ')' )
            {
            // InternalOCLX.g:3993:1: ( ')' )
            // InternalOCLX.g:3994:2: ')'
            {
             before(grammarAccess.getTemporalUntilAccess().getRightParenthesisKeyword_5()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getTemporalUntilAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__Group__5__Impl"


    // $ANTLR start "rule__TemporalEverytime__Group__0"
    // InternalOCLX.g:4004:1: rule__TemporalEverytime__Group__0 : rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1 ;
    public final void rule__TemporalEverytime__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4008:1: ( rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1 )
            // InternalOCLX.g:4009:2: rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__TemporalEverytime__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalEverytime__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__0"


    // $ANTLR start "rule__TemporalEverytime__Group__0__Impl"
    // InternalOCLX.g:4016:1: rule__TemporalEverytime__Group__0__Impl : ( ( rule__TemporalEverytime__NameAssignment_0 ) ) ;
    public final void rule__TemporalEverytime__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4020:1: ( ( ( rule__TemporalEverytime__NameAssignment_0 ) ) )
            // InternalOCLX.g:4021:1: ( ( rule__TemporalEverytime__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4021:1: ( ( rule__TemporalEverytime__NameAssignment_0 ) )
            // InternalOCLX.g:4022:2: ( rule__TemporalEverytime__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4023:2: ( rule__TemporalEverytime__NameAssignment_0 )
            // InternalOCLX.g:4023:3: rule__TemporalEverytime__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TemporalEverytime__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTemporalEverytimeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__0__Impl"


    // $ANTLR start "rule__TemporalEverytime__Group__1"
    // InternalOCLX.g:4031:1: rule__TemporalEverytime__Group__1 : rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2 ;
    public final void rule__TemporalEverytime__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4035:1: ( rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2 )
            // InternalOCLX.g:4036:2: rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__TemporalEverytime__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalEverytime__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__1"


    // $ANTLR start "rule__TemporalEverytime__Group__1__Impl"
    // InternalOCLX.g:4043:1: rule__TemporalEverytime__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalEverytime__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4047:1: ( ( '(' ) )
            // InternalOCLX.g:4048:1: ( '(' )
            {
            // InternalOCLX.g:4048:1: ( '(' )
            // InternalOCLX.g:4049:2: '('
            {
             before(grammarAccess.getTemporalEverytimeAccess().getLeftParenthesisKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getTemporalEverytimeAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__1__Impl"


    // $ANTLR start "rule__TemporalEverytime__Group__2"
    // InternalOCLX.g:4058:1: rule__TemporalEverytime__Group__2 : rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3 ;
    public final void rule__TemporalEverytime__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4062:1: ( rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3 )
            // InternalOCLX.g:4063:2: rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3
            {
            pushFollow(FOLLOW_33);
            rule__TemporalEverytime__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalEverytime__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__2"


    // $ANTLR start "rule__TemporalEverytime__Group__2__Impl"
    // InternalOCLX.g:4070:1: rule__TemporalEverytime__Group__2__Impl : ( ( rule__TemporalEverytime__AAssignment_2 ) ) ;
    public final void rule__TemporalEverytime__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4074:1: ( ( ( rule__TemporalEverytime__AAssignment_2 ) ) )
            // InternalOCLX.g:4075:1: ( ( rule__TemporalEverytime__AAssignment_2 ) )
            {
            // InternalOCLX.g:4075:1: ( ( rule__TemporalEverytime__AAssignment_2 ) )
            // InternalOCLX.g:4076:2: ( rule__TemporalEverytime__AAssignment_2 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getAAssignment_2()); 
            // InternalOCLX.g:4077:2: ( rule__TemporalEverytime__AAssignment_2 )
            // InternalOCLX.g:4077:3: rule__TemporalEverytime__AAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TemporalEverytime__AAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTemporalEverytimeAccess().getAAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__2__Impl"


    // $ANTLR start "rule__TemporalEverytime__Group__3"
    // InternalOCLX.g:4085:1: rule__TemporalEverytime__Group__3 : rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4 ;
    public final void rule__TemporalEverytime__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4089:1: ( rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4 )
            // InternalOCLX.g:4090:2: rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__TemporalEverytime__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalEverytime__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__3"


    // $ANTLR start "rule__TemporalEverytime__Group__3__Impl"
    // InternalOCLX.g:4097:1: rule__TemporalEverytime__Group__3__Impl : ( 'then' ) ;
    public final void rule__TemporalEverytime__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4101:1: ( ( 'then' ) )
            // InternalOCLX.g:4102:1: ( 'then' )
            {
            // InternalOCLX.g:4102:1: ( 'then' )
            // InternalOCLX.g:4103:2: 'then'
            {
             before(grammarAccess.getTemporalEverytimeAccess().getThenKeyword_3()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getTemporalEverytimeAccess().getThenKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__3__Impl"


    // $ANTLR start "rule__TemporalEverytime__Group__4"
    // InternalOCLX.g:4112:1: rule__TemporalEverytime__Group__4 : rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5 ;
    public final void rule__TemporalEverytime__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4116:1: ( rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5 )
            // InternalOCLX.g:4117:2: rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5
            {
            pushFollow(FOLLOW_21);
            rule__TemporalEverytime__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalEverytime__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__4"


    // $ANTLR start "rule__TemporalEverytime__Group__4__Impl"
    // InternalOCLX.g:4124:1: rule__TemporalEverytime__Group__4__Impl : ( ( rule__TemporalEverytime__BAssignment_4 ) ) ;
    public final void rule__TemporalEverytime__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4128:1: ( ( ( rule__TemporalEverytime__BAssignment_4 ) ) )
            // InternalOCLX.g:4129:1: ( ( rule__TemporalEverytime__BAssignment_4 ) )
            {
            // InternalOCLX.g:4129:1: ( ( rule__TemporalEverytime__BAssignment_4 ) )
            // InternalOCLX.g:4130:2: ( rule__TemporalEverytime__BAssignment_4 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getBAssignment_4()); 
            // InternalOCLX.g:4131:2: ( rule__TemporalEverytime__BAssignment_4 )
            // InternalOCLX.g:4131:3: rule__TemporalEverytime__BAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__TemporalEverytime__BAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTemporalEverytimeAccess().getBAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__4__Impl"


    // $ANTLR start "rule__TemporalEverytime__Group__5"
    // InternalOCLX.g:4139:1: rule__TemporalEverytime__Group__5 : rule__TemporalEverytime__Group__5__Impl ;
    public final void rule__TemporalEverytime__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4143:1: ( rule__TemporalEverytime__Group__5__Impl )
            // InternalOCLX.g:4144:2: rule__TemporalEverytime__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TemporalEverytime__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__5"


    // $ANTLR start "rule__TemporalEverytime__Group__5__Impl"
    // InternalOCLX.g:4150:1: rule__TemporalEverytime__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalEverytime__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4154:1: ( ( ')' ) )
            // InternalOCLX.g:4155:1: ( ')' )
            {
            // InternalOCLX.g:4155:1: ( ')' )
            // InternalOCLX.g:4156:2: ')'
            {
             before(grammarAccess.getTemporalEverytimeAccess().getRightParenthesisKeyword_5()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getTemporalEverytimeAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__Group__5__Impl"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__0"
    // InternalOCLX.g:4166:1: rule__TemporalAtLeastOnce__Group__0 : rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1 ;
    public final void rule__TemporalAtLeastOnce__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4170:1: ( rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1 )
            // InternalOCLX.g:4171:2: rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__TemporalAtLeastOnce__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalAtLeastOnce__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__0"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__0__Impl"
    // InternalOCLX.g:4178:1: rule__TemporalAtLeastOnce__Group__0__Impl : ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4182:1: ( ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) ) )
            // InternalOCLX.g:4183:1: ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4183:1: ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) )
            // InternalOCLX.g:4184:2: ( rule__TemporalAtLeastOnce__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4185:2: ( rule__TemporalAtLeastOnce__NameAssignment_0 )
            // InternalOCLX.g:4185:3: rule__TemporalAtLeastOnce__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TemporalAtLeastOnce__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTemporalAtLeastOnceAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__0__Impl"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__1"
    // InternalOCLX.g:4193:1: rule__TemporalAtLeastOnce__Group__1 : rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2 ;
    public final void rule__TemporalAtLeastOnce__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4197:1: ( rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2 )
            // InternalOCLX.g:4198:2: rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__TemporalAtLeastOnce__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalAtLeastOnce__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__1"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__1__Impl"
    // InternalOCLX.g:4205:1: rule__TemporalAtLeastOnce__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalAtLeastOnce__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4209:1: ( ( '(' ) )
            // InternalOCLX.g:4210:1: ( '(' )
            {
            // InternalOCLX.g:4210:1: ( '(' )
            // InternalOCLX.g:4211:2: '('
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getLeftParenthesisKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getTemporalAtLeastOnceAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__1__Impl"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__2"
    // InternalOCLX.g:4220:1: rule__TemporalAtLeastOnce__Group__2 : rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3 ;
    public final void rule__TemporalAtLeastOnce__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4224:1: ( rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3 )
            // InternalOCLX.g:4225:2: rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3
            {
            pushFollow(FOLLOW_34);
            rule__TemporalAtLeastOnce__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalAtLeastOnce__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__2"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__2__Impl"
    // InternalOCLX.g:4232:1: rule__TemporalAtLeastOnce__Group__2__Impl : ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4236:1: ( ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) ) )
            // InternalOCLX.g:4237:1: ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) )
            {
            // InternalOCLX.g:4237:1: ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) )
            // InternalOCLX.g:4238:2: ( rule__TemporalAtLeastOnce__AAssignment_2 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getAAssignment_2()); 
            // InternalOCLX.g:4239:2: ( rule__TemporalAtLeastOnce__AAssignment_2 )
            // InternalOCLX.g:4239:3: rule__TemporalAtLeastOnce__AAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__TemporalAtLeastOnce__AAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTemporalAtLeastOnceAccess().getAAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__2__Impl"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__3"
    // InternalOCLX.g:4247:1: rule__TemporalAtLeastOnce__Group__3 : rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4 ;
    public final void rule__TemporalAtLeastOnce__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4251:1: ( rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4 )
            // InternalOCLX.g:4252:2: rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__TemporalAtLeastOnce__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalAtLeastOnce__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__3"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__3__Impl"
    // InternalOCLX.g:4259:1: rule__TemporalAtLeastOnce__Group__3__Impl : ( 'thenAtLeastOnce' ) ;
    public final void rule__TemporalAtLeastOnce__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4263:1: ( ( 'thenAtLeastOnce' ) )
            // InternalOCLX.g:4264:1: ( 'thenAtLeastOnce' )
            {
            // InternalOCLX.g:4264:1: ( 'thenAtLeastOnce' )
            // InternalOCLX.g:4265:2: 'thenAtLeastOnce'
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getThenAtLeastOnceKeyword_3()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getTemporalAtLeastOnceAccess().getThenAtLeastOnceKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__3__Impl"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__4"
    // InternalOCLX.g:4274:1: rule__TemporalAtLeastOnce__Group__4 : rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5 ;
    public final void rule__TemporalAtLeastOnce__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4278:1: ( rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5 )
            // InternalOCLX.g:4279:2: rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5
            {
            pushFollow(FOLLOW_21);
            rule__TemporalAtLeastOnce__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TemporalAtLeastOnce__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__4"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__4__Impl"
    // InternalOCLX.g:4286:1: rule__TemporalAtLeastOnce__Group__4__Impl : ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4290:1: ( ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) ) )
            // InternalOCLX.g:4291:1: ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) )
            {
            // InternalOCLX.g:4291:1: ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) )
            // InternalOCLX.g:4292:2: ( rule__TemporalAtLeastOnce__BAssignment_4 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getBAssignment_4()); 
            // InternalOCLX.g:4293:2: ( rule__TemporalAtLeastOnce__BAssignment_4 )
            // InternalOCLX.g:4293:3: rule__TemporalAtLeastOnce__BAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__TemporalAtLeastOnce__BAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTemporalAtLeastOnceAccess().getBAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__4__Impl"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__5"
    // InternalOCLX.g:4301:1: rule__TemporalAtLeastOnce__Group__5 : rule__TemporalAtLeastOnce__Group__5__Impl ;
    public final void rule__TemporalAtLeastOnce__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4305:1: ( rule__TemporalAtLeastOnce__Group__5__Impl )
            // InternalOCLX.g:4306:2: rule__TemporalAtLeastOnce__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TemporalAtLeastOnce__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__5"


    // $ANTLR start "rule__TemporalAtLeastOnce__Group__5__Impl"
    // InternalOCLX.g:4312:1: rule__TemporalAtLeastOnce__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalAtLeastOnce__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4316:1: ( ( ')' ) )
            // InternalOCLX.g:4317:1: ( ')' )
            {
            // InternalOCLX.g:4317:1: ( ')' )
            // InternalOCLX.g:4318:2: ')'
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getRightParenthesisKeyword_5()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getTemporalAtLeastOnceAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__Group__5__Impl"


    // $ANTLR start "rule__LegacyUntil__Group__0"
    // InternalOCLX.g:4328:1: rule__LegacyUntil__Group__0 : rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1 ;
    public final void rule__LegacyUntil__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4332:1: ( rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1 )
            // InternalOCLX.g:4333:2: rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__LegacyUntil__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyUntil__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__0"


    // $ANTLR start "rule__LegacyUntil__Group__0__Impl"
    // InternalOCLX.g:4340:1: rule__LegacyUntil__Group__0__Impl : ( ( rule__LegacyUntil__NameAssignment_0 ) ) ;
    public final void rule__LegacyUntil__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4344:1: ( ( ( rule__LegacyUntil__NameAssignment_0 ) ) )
            // InternalOCLX.g:4345:1: ( ( rule__LegacyUntil__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4345:1: ( ( rule__LegacyUntil__NameAssignment_0 ) )
            // InternalOCLX.g:4346:2: ( rule__LegacyUntil__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyUntilAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4347:2: ( rule__LegacyUntil__NameAssignment_0 )
            // InternalOCLX.g:4347:3: rule__LegacyUntil__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LegacyUntil__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLegacyUntilAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__0__Impl"


    // $ANTLR start "rule__LegacyUntil__Group__1"
    // InternalOCLX.g:4355:1: rule__LegacyUntil__Group__1 : rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2 ;
    public final void rule__LegacyUntil__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4359:1: ( rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2 )
            // InternalOCLX.g:4360:2: rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__LegacyUntil__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyUntil__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__1"


    // $ANTLR start "rule__LegacyUntil__Group__1__Impl"
    // InternalOCLX.g:4367:1: rule__LegacyUntil__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyUntil__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4371:1: ( ( '(' ) )
            // InternalOCLX.g:4372:1: ( '(' )
            {
            // InternalOCLX.g:4372:1: ( '(' )
            // InternalOCLX.g:4373:2: '('
            {
             before(grammarAccess.getLegacyUntilAccess().getLeftParenthesisKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getLegacyUntilAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__1__Impl"


    // $ANTLR start "rule__LegacyUntil__Group__2"
    // InternalOCLX.g:4382:1: rule__LegacyUntil__Group__2 : rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3 ;
    public final void rule__LegacyUntil__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4386:1: ( rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3 )
            // InternalOCLX.g:4387:2: rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3
            {
            pushFollow(FOLLOW_35);
            rule__LegacyUntil__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyUntil__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__2"


    // $ANTLR start "rule__LegacyUntil__Group__2__Impl"
    // InternalOCLX.g:4394:1: rule__LegacyUntil__Group__2__Impl : ( ( rule__LegacyUntil__AAssignment_2 ) ) ;
    public final void rule__LegacyUntil__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4398:1: ( ( ( rule__LegacyUntil__AAssignment_2 ) ) )
            // InternalOCLX.g:4399:1: ( ( rule__LegacyUntil__AAssignment_2 ) )
            {
            // InternalOCLX.g:4399:1: ( ( rule__LegacyUntil__AAssignment_2 ) )
            // InternalOCLX.g:4400:2: ( rule__LegacyUntil__AAssignment_2 )
            {
             before(grammarAccess.getLegacyUntilAccess().getAAssignment_2()); 
            // InternalOCLX.g:4401:2: ( rule__LegacyUntil__AAssignment_2 )
            // InternalOCLX.g:4401:3: rule__LegacyUntil__AAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__LegacyUntil__AAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLegacyUntilAccess().getAAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__2__Impl"


    // $ANTLR start "rule__LegacyUntil__Group__3"
    // InternalOCLX.g:4409:1: rule__LegacyUntil__Group__3 : rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4 ;
    public final void rule__LegacyUntil__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4413:1: ( rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4 )
            // InternalOCLX.g:4414:2: rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__LegacyUntil__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyUntil__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__3"


    // $ANTLR start "rule__LegacyUntil__Group__3__Impl"
    // InternalOCLX.g:4421:1: rule__LegacyUntil__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyUntil__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4425:1: ( ( ',' ) )
            // InternalOCLX.g:4426:1: ( ',' )
            {
            // InternalOCLX.g:4426:1: ( ',' )
            // InternalOCLX.g:4427:2: ','
            {
             before(grammarAccess.getLegacyUntilAccess().getCommaKeyword_3()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getLegacyUntilAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__3__Impl"


    // $ANTLR start "rule__LegacyUntil__Group__4"
    // InternalOCLX.g:4436:1: rule__LegacyUntil__Group__4 : rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5 ;
    public final void rule__LegacyUntil__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4440:1: ( rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5 )
            // InternalOCLX.g:4441:2: rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5
            {
            pushFollow(FOLLOW_21);
            rule__LegacyUntil__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyUntil__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__4"


    // $ANTLR start "rule__LegacyUntil__Group__4__Impl"
    // InternalOCLX.g:4448:1: rule__LegacyUntil__Group__4__Impl : ( ( rule__LegacyUntil__BAssignment_4 ) ) ;
    public final void rule__LegacyUntil__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4452:1: ( ( ( rule__LegacyUntil__BAssignment_4 ) ) )
            // InternalOCLX.g:4453:1: ( ( rule__LegacyUntil__BAssignment_4 ) )
            {
            // InternalOCLX.g:4453:1: ( ( rule__LegacyUntil__BAssignment_4 ) )
            // InternalOCLX.g:4454:2: ( rule__LegacyUntil__BAssignment_4 )
            {
             before(grammarAccess.getLegacyUntilAccess().getBAssignment_4()); 
            // InternalOCLX.g:4455:2: ( rule__LegacyUntil__BAssignment_4 )
            // InternalOCLX.g:4455:3: rule__LegacyUntil__BAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__LegacyUntil__BAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getLegacyUntilAccess().getBAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__4__Impl"


    // $ANTLR start "rule__LegacyUntil__Group__5"
    // InternalOCLX.g:4463:1: rule__LegacyUntil__Group__5 : rule__LegacyUntil__Group__5__Impl ;
    public final void rule__LegacyUntil__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4467:1: ( rule__LegacyUntil__Group__5__Impl )
            // InternalOCLX.g:4468:2: rule__LegacyUntil__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LegacyUntil__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__5"


    // $ANTLR start "rule__LegacyUntil__Group__5__Impl"
    // InternalOCLX.g:4474:1: rule__LegacyUntil__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyUntil__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4478:1: ( ( ')' ) )
            // InternalOCLX.g:4479:1: ( ')' )
            {
            // InternalOCLX.g:4479:1: ( ')' )
            // InternalOCLX.g:4480:2: ')'
            {
             before(grammarAccess.getLegacyUntilAccess().getRightParenthesisKeyword_5()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getLegacyUntilAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__Group__5__Impl"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__0"
    // InternalOCLX.g:4490:1: rule__LegacyAsSoonAs__Group__0 : rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1 ;
    public final void rule__LegacyAsSoonAs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4494:1: ( rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1 )
            // InternalOCLX.g:4495:2: rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__LegacyAsSoonAs__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyAsSoonAs__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__0"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__0__Impl"
    // InternalOCLX.g:4502:1: rule__LegacyAsSoonAs__Group__0__Impl : ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4506:1: ( ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) ) )
            // InternalOCLX.g:4507:1: ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4507:1: ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) )
            // InternalOCLX.g:4508:2: ( rule__LegacyAsSoonAs__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4509:2: ( rule__LegacyAsSoonAs__NameAssignment_0 )
            // InternalOCLX.g:4509:3: rule__LegacyAsSoonAs__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LegacyAsSoonAs__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLegacyAsSoonAsAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__0__Impl"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__1"
    // InternalOCLX.g:4517:1: rule__LegacyAsSoonAs__Group__1 : rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2 ;
    public final void rule__LegacyAsSoonAs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4521:1: ( rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2 )
            // InternalOCLX.g:4522:2: rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__LegacyAsSoonAs__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyAsSoonAs__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__1"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__1__Impl"
    // InternalOCLX.g:4529:1: rule__LegacyAsSoonAs__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyAsSoonAs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4533:1: ( ( '(' ) )
            // InternalOCLX.g:4534:1: ( '(' )
            {
            // InternalOCLX.g:4534:1: ( '(' )
            // InternalOCLX.g:4535:2: '('
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getLeftParenthesisKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getLegacyAsSoonAsAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__1__Impl"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__2"
    // InternalOCLX.g:4544:1: rule__LegacyAsSoonAs__Group__2 : rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3 ;
    public final void rule__LegacyAsSoonAs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4548:1: ( rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3 )
            // InternalOCLX.g:4549:2: rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3
            {
            pushFollow(FOLLOW_35);
            rule__LegacyAsSoonAs__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyAsSoonAs__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__2"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__2__Impl"
    // InternalOCLX.g:4556:1: rule__LegacyAsSoonAs__Group__2__Impl : ( ( rule__LegacyAsSoonAs__AAssignment_2 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4560:1: ( ( ( rule__LegacyAsSoonAs__AAssignment_2 ) ) )
            // InternalOCLX.g:4561:1: ( ( rule__LegacyAsSoonAs__AAssignment_2 ) )
            {
            // InternalOCLX.g:4561:1: ( ( rule__LegacyAsSoonAs__AAssignment_2 ) )
            // InternalOCLX.g:4562:2: ( rule__LegacyAsSoonAs__AAssignment_2 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getAAssignment_2()); 
            // InternalOCLX.g:4563:2: ( rule__LegacyAsSoonAs__AAssignment_2 )
            // InternalOCLX.g:4563:3: rule__LegacyAsSoonAs__AAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__LegacyAsSoonAs__AAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLegacyAsSoonAsAccess().getAAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__2__Impl"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__3"
    // InternalOCLX.g:4571:1: rule__LegacyAsSoonAs__Group__3 : rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4 ;
    public final void rule__LegacyAsSoonAs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4575:1: ( rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4 )
            // InternalOCLX.g:4576:2: rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__LegacyAsSoonAs__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyAsSoonAs__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__3"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__3__Impl"
    // InternalOCLX.g:4583:1: rule__LegacyAsSoonAs__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyAsSoonAs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4587:1: ( ( ',' ) )
            // InternalOCLX.g:4588:1: ( ',' )
            {
            // InternalOCLX.g:4588:1: ( ',' )
            // InternalOCLX.g:4589:2: ','
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getCommaKeyword_3()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getLegacyAsSoonAsAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__3__Impl"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__4"
    // InternalOCLX.g:4598:1: rule__LegacyAsSoonAs__Group__4 : rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5 ;
    public final void rule__LegacyAsSoonAs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4602:1: ( rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5 )
            // InternalOCLX.g:4603:2: rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5
            {
            pushFollow(FOLLOW_21);
            rule__LegacyAsSoonAs__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyAsSoonAs__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__4"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__4__Impl"
    // InternalOCLX.g:4610:1: rule__LegacyAsSoonAs__Group__4__Impl : ( ( rule__LegacyAsSoonAs__BAssignment_4 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4614:1: ( ( ( rule__LegacyAsSoonAs__BAssignment_4 ) ) )
            // InternalOCLX.g:4615:1: ( ( rule__LegacyAsSoonAs__BAssignment_4 ) )
            {
            // InternalOCLX.g:4615:1: ( ( rule__LegacyAsSoonAs__BAssignment_4 ) )
            // InternalOCLX.g:4616:2: ( rule__LegacyAsSoonAs__BAssignment_4 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getBAssignment_4()); 
            // InternalOCLX.g:4617:2: ( rule__LegacyAsSoonAs__BAssignment_4 )
            // InternalOCLX.g:4617:3: rule__LegacyAsSoonAs__BAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__LegacyAsSoonAs__BAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getLegacyAsSoonAsAccess().getBAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__4__Impl"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__5"
    // InternalOCLX.g:4625:1: rule__LegacyAsSoonAs__Group__5 : rule__LegacyAsSoonAs__Group__5__Impl ;
    public final void rule__LegacyAsSoonAs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4629:1: ( rule__LegacyAsSoonAs__Group__5__Impl )
            // InternalOCLX.g:4630:2: rule__LegacyAsSoonAs__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LegacyAsSoonAs__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__5"


    // $ANTLR start "rule__LegacyAsSoonAs__Group__5__Impl"
    // InternalOCLX.g:4636:1: rule__LegacyAsSoonAs__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyAsSoonAs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4640:1: ( ( ')' ) )
            // InternalOCLX.g:4641:1: ( ')' )
            {
            // InternalOCLX.g:4641:1: ( ')' )
            // InternalOCLX.g:4642:2: ')'
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getRightParenthesisKeyword_5()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getLegacyAsSoonAsAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__Group__5__Impl"


    // $ANTLR start "rule__LegacyEverytime__Group__0"
    // InternalOCLX.g:4652:1: rule__LegacyEverytime__Group__0 : rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1 ;
    public final void rule__LegacyEverytime__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4656:1: ( rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1 )
            // InternalOCLX.g:4657:2: rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__LegacyEverytime__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyEverytime__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__0"


    // $ANTLR start "rule__LegacyEverytime__Group__0__Impl"
    // InternalOCLX.g:4664:1: rule__LegacyEverytime__Group__0__Impl : ( ( rule__LegacyEverytime__NameAssignment_0 ) ) ;
    public final void rule__LegacyEverytime__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4668:1: ( ( ( rule__LegacyEverytime__NameAssignment_0 ) ) )
            // InternalOCLX.g:4669:1: ( ( rule__LegacyEverytime__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4669:1: ( ( rule__LegacyEverytime__NameAssignment_0 ) )
            // InternalOCLX.g:4670:2: ( rule__LegacyEverytime__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4671:2: ( rule__LegacyEverytime__NameAssignment_0 )
            // InternalOCLX.g:4671:3: rule__LegacyEverytime__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LegacyEverytime__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLegacyEverytimeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__0__Impl"


    // $ANTLR start "rule__LegacyEverytime__Group__1"
    // InternalOCLX.g:4679:1: rule__LegacyEverytime__Group__1 : rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2 ;
    public final void rule__LegacyEverytime__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4683:1: ( rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2 )
            // InternalOCLX.g:4684:2: rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__LegacyEverytime__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyEverytime__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__1"


    // $ANTLR start "rule__LegacyEverytime__Group__1__Impl"
    // InternalOCLX.g:4691:1: rule__LegacyEverytime__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyEverytime__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4695:1: ( ( '(' ) )
            // InternalOCLX.g:4696:1: ( '(' )
            {
            // InternalOCLX.g:4696:1: ( '(' )
            // InternalOCLX.g:4697:2: '('
            {
             before(grammarAccess.getLegacyEverytimeAccess().getLeftParenthesisKeyword_1()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getLegacyEverytimeAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__1__Impl"


    // $ANTLR start "rule__LegacyEverytime__Group__2"
    // InternalOCLX.g:4706:1: rule__LegacyEverytime__Group__2 : rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3 ;
    public final void rule__LegacyEverytime__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4710:1: ( rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3 )
            // InternalOCLX.g:4711:2: rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3
            {
            pushFollow(FOLLOW_35);
            rule__LegacyEverytime__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyEverytime__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__2"


    // $ANTLR start "rule__LegacyEverytime__Group__2__Impl"
    // InternalOCLX.g:4718:1: rule__LegacyEverytime__Group__2__Impl : ( ( rule__LegacyEverytime__AAssignment_2 ) ) ;
    public final void rule__LegacyEverytime__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4722:1: ( ( ( rule__LegacyEverytime__AAssignment_2 ) ) )
            // InternalOCLX.g:4723:1: ( ( rule__LegacyEverytime__AAssignment_2 ) )
            {
            // InternalOCLX.g:4723:1: ( ( rule__LegacyEverytime__AAssignment_2 ) )
            // InternalOCLX.g:4724:2: ( rule__LegacyEverytime__AAssignment_2 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getAAssignment_2()); 
            // InternalOCLX.g:4725:2: ( rule__LegacyEverytime__AAssignment_2 )
            // InternalOCLX.g:4725:3: rule__LegacyEverytime__AAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__LegacyEverytime__AAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLegacyEverytimeAccess().getAAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__2__Impl"


    // $ANTLR start "rule__LegacyEverytime__Group__3"
    // InternalOCLX.g:4733:1: rule__LegacyEverytime__Group__3 : rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4 ;
    public final void rule__LegacyEverytime__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4737:1: ( rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4 )
            // InternalOCLX.g:4738:2: rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__LegacyEverytime__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyEverytime__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__3"


    // $ANTLR start "rule__LegacyEverytime__Group__3__Impl"
    // InternalOCLX.g:4745:1: rule__LegacyEverytime__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyEverytime__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4749:1: ( ( ',' ) )
            // InternalOCLX.g:4750:1: ( ',' )
            {
            // InternalOCLX.g:4750:1: ( ',' )
            // InternalOCLX.g:4751:2: ','
            {
             before(grammarAccess.getLegacyEverytimeAccess().getCommaKeyword_3()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getLegacyEverytimeAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__3__Impl"


    // $ANTLR start "rule__LegacyEverytime__Group__4"
    // InternalOCLX.g:4760:1: rule__LegacyEverytime__Group__4 : rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5 ;
    public final void rule__LegacyEverytime__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4764:1: ( rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5 )
            // InternalOCLX.g:4765:2: rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5
            {
            pushFollow(FOLLOW_21);
            rule__LegacyEverytime__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LegacyEverytime__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__4"


    // $ANTLR start "rule__LegacyEverytime__Group__4__Impl"
    // InternalOCLX.g:4772:1: rule__LegacyEverytime__Group__4__Impl : ( ( rule__LegacyEverytime__BAssignment_4 ) ) ;
    public final void rule__LegacyEverytime__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4776:1: ( ( ( rule__LegacyEverytime__BAssignment_4 ) ) )
            // InternalOCLX.g:4777:1: ( ( rule__LegacyEverytime__BAssignment_4 ) )
            {
            // InternalOCLX.g:4777:1: ( ( rule__LegacyEverytime__BAssignment_4 ) )
            // InternalOCLX.g:4778:2: ( rule__LegacyEverytime__BAssignment_4 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getBAssignment_4()); 
            // InternalOCLX.g:4779:2: ( rule__LegacyEverytime__BAssignment_4 )
            // InternalOCLX.g:4779:3: rule__LegacyEverytime__BAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__LegacyEverytime__BAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getLegacyEverytimeAccess().getBAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__4__Impl"


    // $ANTLR start "rule__LegacyEverytime__Group__5"
    // InternalOCLX.g:4787:1: rule__LegacyEverytime__Group__5 : rule__LegacyEverytime__Group__5__Impl ;
    public final void rule__LegacyEverytime__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4791:1: ( rule__LegacyEverytime__Group__5__Impl )
            // InternalOCLX.g:4792:2: rule__LegacyEverytime__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LegacyEverytime__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__5"


    // $ANTLR start "rule__LegacyEverytime__Group__5__Impl"
    // InternalOCLX.g:4798:1: rule__LegacyEverytime__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyEverytime__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4802:1: ( ( ')' ) )
            // InternalOCLX.g:4803:1: ( ')' )
            {
            // InternalOCLX.g:4803:1: ( ')' )
            // InternalOCLX.g:4804:2: ')'
            {
             before(grammarAccess.getLegacyEverytimeAccess().getRightParenthesisKeyword_5()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getLegacyEverytimeAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__Group__5__Impl"


    // $ANTLR start "rule__Path__Group__0"
    // InternalOCLX.g:4814:1: rule__Path__Group__0 : rule__Path__Group__0__Impl rule__Path__Group__1 ;
    public final void rule__Path__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4818:1: ( rule__Path__Group__0__Impl rule__Path__Group__1 )
            // InternalOCLX.g:4819:2: rule__Path__Group__0__Impl rule__Path__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__Path__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__0"


    // $ANTLR start "rule__Path__Group__0__Impl"
    // InternalOCLX.g:4826:1: rule__Path__Group__0__Impl : ( ruleSimpleName ) ;
    public final void rule__Path__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4830:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:4831:1: ( ruleSimpleName )
            {
            // InternalOCLX.g:4831:1: ( ruleSimpleName )
            // InternalOCLX.g:4832:2: ruleSimpleName
            {
             before(grammarAccess.getPathAccess().getSimpleNameParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleName();

            state._fsp--;

             after(grammarAccess.getPathAccess().getSimpleNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__0__Impl"


    // $ANTLR start "rule__Path__Group__1"
    // InternalOCLX.g:4841:1: rule__Path__Group__1 : rule__Path__Group__1__Impl ;
    public final void rule__Path__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4845:1: ( rule__Path__Group__1__Impl )
            // InternalOCLX.g:4846:2: rule__Path__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Path__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__1"


    // $ANTLR start "rule__Path__Group__1__Impl"
    // InternalOCLX.g:4852:1: rule__Path__Group__1__Impl : ( ( rule__Path__Group_1__0 )* ) ;
    public final void rule__Path__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4856:1: ( ( ( rule__Path__Group_1__0 )* ) )
            // InternalOCLX.g:4857:1: ( ( rule__Path__Group_1__0 )* )
            {
            // InternalOCLX.g:4857:1: ( ( rule__Path__Group_1__0 )* )
            // InternalOCLX.g:4858:2: ( rule__Path__Group_1__0 )*
            {
             before(grammarAccess.getPathAccess().getGroup_1()); 
            // InternalOCLX.g:4859:2: ( rule__Path__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==23) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalOCLX.g:4859:3: rule__Path__Group_1__0
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__Path__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getPathAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group__1__Impl"


    // $ANTLR start "rule__Path__Group_1__0"
    // InternalOCLX.g:4868:1: rule__Path__Group_1__0 : rule__Path__Group_1__0__Impl rule__Path__Group_1__1 ;
    public final void rule__Path__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4872:1: ( rule__Path__Group_1__0__Impl rule__Path__Group_1__1 )
            // InternalOCLX.g:4873:2: rule__Path__Group_1__0__Impl rule__Path__Group_1__1
            {
            pushFollow(FOLLOW_4);
            rule__Path__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Path__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_1__0"


    // $ANTLR start "rule__Path__Group_1__0__Impl"
    // InternalOCLX.g:4880:1: rule__Path__Group_1__0__Impl : ( '/' ) ;
    public final void rule__Path__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4884:1: ( ( '/' ) )
            // InternalOCLX.g:4885:1: ( '/' )
            {
            // InternalOCLX.g:4885:1: ( '/' )
            // InternalOCLX.g:4886:2: '/'
            {
             before(grammarAccess.getPathAccess().getSolidusKeyword_1_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getPathAccess().getSolidusKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_1__0__Impl"


    // $ANTLR start "rule__Path__Group_1__1"
    // InternalOCLX.g:4895:1: rule__Path__Group_1__1 : rule__Path__Group_1__1__Impl ;
    public final void rule__Path__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4899:1: ( rule__Path__Group_1__1__Impl )
            // InternalOCLX.g:4900:2: rule__Path__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Path__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_1__1"


    // $ANTLR start "rule__Path__Group_1__1__Impl"
    // InternalOCLX.g:4906:1: rule__Path__Group_1__1__Impl : ( ruleSimpleName ) ;
    public final void rule__Path__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4910:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:4911:1: ( ruleSimpleName )
            {
            // InternalOCLX.g:4911:1: ( ruleSimpleName )
            // InternalOCLX.g:4912:2: ruleSimpleName
            {
             before(grammarAccess.getPathAccess().getSimpleNameParserRuleCall_1_1()); 
            pushFollow(FOLLOW_2);
            ruleSimpleName();

            state._fsp--;

             after(grammarAccess.getPathAccess().getSimpleNameParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Path__Group_1__1__Impl"


    // $ANTLR start "rule__ArgumentsExp__Group__0"
    // InternalOCLX.g:4922:1: rule__ArgumentsExp__Group__0 : rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1 ;
    public final void rule__ArgumentsExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4926:1: ( rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1 )
            // InternalOCLX.g:4927:2: rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1
            {
            pushFollow(FOLLOW_35);
            rule__ArgumentsExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArgumentsExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentsExp__Group__0"


    // $ANTLR start "rule__ArgumentsExp__Group__0__Impl"
    // InternalOCLX.g:4934:1: rule__ArgumentsExp__Group__0__Impl : ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) ) ;
    public final void rule__ArgumentsExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4938:1: ( ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) ) )
            // InternalOCLX.g:4939:1: ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) )
            {
            // InternalOCLX.g:4939:1: ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) )
            // InternalOCLX.g:4940:2: ( rule__ArgumentsExp__OperatorsAssignment_0 )
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_0()); 
            // InternalOCLX.g:4941:2: ( rule__ArgumentsExp__OperatorsAssignment_0 )
            // InternalOCLX.g:4941:3: rule__ArgumentsExp__OperatorsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ArgumentsExp__OperatorsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentsExp__Group__0__Impl"


    // $ANTLR start "rule__ArgumentsExp__Group__1"
    // InternalOCLX.g:4949:1: rule__ArgumentsExp__Group__1 : rule__ArgumentsExp__Group__1__Impl ;
    public final void rule__ArgumentsExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4953:1: ( rule__ArgumentsExp__Group__1__Impl )
            // InternalOCLX.g:4954:2: rule__ArgumentsExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArgumentsExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentsExp__Group__1"


    // $ANTLR start "rule__ArgumentsExp__Group__1__Impl"
    // InternalOCLX.g:4960:1: rule__ArgumentsExp__Group__1__Impl : ( ( rule__ArgumentsExp__Group_1__0 )* ) ;
    public final void rule__ArgumentsExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4964:1: ( ( ( rule__ArgumentsExp__Group_1__0 )* ) )
            // InternalOCLX.g:4965:1: ( ( rule__ArgumentsExp__Group_1__0 )* )
            {
            // InternalOCLX.g:4965:1: ( ( rule__ArgumentsExp__Group_1__0 )* )
            // InternalOCLX.g:4966:2: ( rule__ArgumentsExp__Group_1__0 )*
            {
             before(grammarAccess.getArgumentsExpAccess().getGroup_1()); 
            // InternalOCLX.g:4967:2: ( rule__ArgumentsExp__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==62) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOCLX.g:4967:3: rule__ArgumentsExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__ArgumentsExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getArgumentsExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentsExp__Group__1__Impl"


    // $ANTLR start "rule__ArgumentsExp__Group_1__0"
    // InternalOCLX.g:4976:1: rule__ArgumentsExp__Group_1__0 : rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1 ;
    public final void rule__ArgumentsExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4980:1: ( rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1 )
            // InternalOCLX.g:4981:2: rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__ArgumentsExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ArgumentsExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentsExp__Group_1__0"


    // $ANTLR start "rule__ArgumentsExp__Group_1__0__Impl"
    // InternalOCLX.g:4988:1: rule__ArgumentsExp__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ArgumentsExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4992:1: ( ( ',' ) )
            // InternalOCLX.g:4993:1: ( ',' )
            {
            // InternalOCLX.g:4993:1: ( ',' )
            // InternalOCLX.g:4994:2: ','
            {
             before(grammarAccess.getArgumentsExpAccess().getCommaKeyword_1_0()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getArgumentsExpAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentsExp__Group_1__0__Impl"


    // $ANTLR start "rule__ArgumentsExp__Group_1__1"
    // InternalOCLX.g:5003:1: rule__ArgumentsExp__Group_1__1 : rule__ArgumentsExp__Group_1__1__Impl ;
    public final void rule__ArgumentsExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5007:1: ( rule__ArgumentsExp__Group_1__1__Impl )
            // InternalOCLX.g:5008:2: rule__ArgumentsExp__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ArgumentsExp__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentsExp__Group_1__1"


    // $ANTLR start "rule__ArgumentsExp__Group_1__1__Impl"
    // InternalOCLX.g:5014:1: rule__ArgumentsExp__Group_1__1__Impl : ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) ) ;
    public final void rule__ArgumentsExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5018:1: ( ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) ) )
            // InternalOCLX.g:5019:1: ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) )
            {
            // InternalOCLX.g:5019:1: ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) )
            // InternalOCLX.g:5020:2: ( rule__ArgumentsExp__OperatorsAssignment_1_1 )
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_1_1()); 
            // InternalOCLX.g:5021:2: ( rule__ArgumentsExp__OperatorsAssignment_1_1 )
            // InternalOCLX.g:5021:3: rule__ArgumentsExp__OperatorsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ArgumentsExp__OperatorsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentsExp__Group_1__1__Impl"


    // $ANTLR start "rule__Model__ConstraintsAssignment"
    // InternalOCLX.g:5030:1: rule__Model__ConstraintsAssignment : ( ruleConstraint ) ;
    public final void rule__Model__ConstraintsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5034:1: ( ( ruleConstraint ) )
            // InternalOCLX.g:5035:2: ( ruleConstraint )
            {
            // InternalOCLX.g:5035:2: ( ruleConstraint )
            // InternalOCLX.g:5036:3: ruleConstraint
            {
             before(grammarAccess.getModelAccess().getConstraintsConstraintParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleConstraint();

            state._fsp--;

             after(grammarAccess.getModelAccess().getConstraintsConstraintParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__ConstraintsAssignment"


    // $ANTLR start "rule__Constraint__NameAssignment_1"
    // InternalOCLX.g:5045:1: rule__Constraint__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constraint__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5049:1: ( ( RULE_ID ) )
            // InternalOCLX.g:5050:2: ( RULE_ID )
            {
            // InternalOCLX.g:5050:2: ( RULE_ID )
            // InternalOCLX.g:5051:3: RULE_ID
            {
             before(grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__NameAssignment_1"


    // $ANTLR start "rule__Constraint__DescriptionAssignment_3_1"
    // InternalOCLX.g:5060:1: rule__Constraint__DescriptionAssignment_3_1 : ( RULE_DESCRIPTION ) ;
    public final void rule__Constraint__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5064:1: ( ( RULE_DESCRIPTION ) )
            // InternalOCLX.g:5065:2: ( RULE_DESCRIPTION )
            {
            // InternalOCLX.g:5065:2: ( RULE_DESCRIPTION )
            // InternalOCLX.g:5066:3: RULE_DESCRIPTION
            {
             before(grammarAccess.getConstraintAccess().getDescriptionDESCRIPTIONTerminalRuleCall_3_1_0()); 
            match(input,RULE_DESCRIPTION,FOLLOW_2); 
             after(grammarAccess.getConstraintAccess().getDescriptionDESCRIPTIONTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__DescriptionAssignment_3_1"


    // $ANTLR start "rule__Constraint__OverrulableAssignment_4_2"
    // InternalOCLX.g:5075:1: rule__Constraint__OverrulableAssignment_4_2 : ( ruleBooleanLiteralExp ) ;
    public final void rule__Constraint__OverrulableAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5079:1: ( ( ruleBooleanLiteralExp ) )
            // InternalOCLX.g:5080:2: ( ruleBooleanLiteralExp )
            {
            // InternalOCLX.g:5080:2: ( ruleBooleanLiteralExp )
            // InternalOCLX.g:5081:3: ruleBooleanLiteralExp
            {
             before(grammarAccess.getConstraintAccess().getOverrulableBooleanLiteralExpParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBooleanLiteralExp();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getOverrulableBooleanLiteralExpParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__OverrulableAssignment_4_2"


    // $ANTLR start "rule__Constraint__ContextAssignment_6"
    // InternalOCLX.g:5090:1: rule__Constraint__ContextAssignment_6 : ( ruleContext ) ;
    public final void rule__Constraint__ContextAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5094:1: ( ( ruleContext ) )
            // InternalOCLX.g:5095:2: ( ruleContext )
            {
            // InternalOCLX.g:5095:2: ( ruleContext )
            // InternalOCLX.g:5096:3: ruleContext
            {
             before(grammarAccess.getConstraintAccess().getContextContextParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleContext();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getContextContextParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__ContextAssignment_6"


    // $ANTLR start "rule__Constraint__ExpressionAssignment_8"
    // InternalOCLX.g:5105:1: rule__Constraint__ExpressionAssignment_8 : ( ruleExp ) ;
    public final void rule__Constraint__ExpressionAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5109:1: ( ( ruleExp ) )
            // InternalOCLX.g:5110:2: ( ruleExp )
            {
            // InternalOCLX.g:5110:2: ( ruleExp )
            // InternalOCLX.g:5111:3: ruleExp
            {
             before(grammarAccess.getConstraintAccess().getExpressionExpParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getConstraintAccess().getExpressionExpParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constraint__ExpressionAssignment_8"


    // $ANTLR start "rule__Context__NameAssignment"
    // InternalOCLX.g:5120:1: rule__Context__NameAssignment : ( ruleQualifiedName ) ;
    public final void rule__Context__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5124:1: ( ( ruleQualifiedName ) )
            // InternalOCLX.g:5125:2: ( ruleQualifiedName )
            {
            // InternalOCLX.g:5125:2: ( ruleQualifiedName )
            // InternalOCLX.g:5126:3: ruleQualifiedName
            {
             before(grammarAccess.getContextAccess().getNameQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getContextAccess().getNameQualifiedNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Context__NameAssignment"


    // $ANTLR start "rule__Exp__OperatorsAssignment_1_1"
    // InternalOCLX.g:5135:1: rule__Exp__OperatorsAssignment_1_1 : ( ruleBinaryOperator ) ;
    public final void rule__Exp__OperatorsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5139:1: ( ( ruleBinaryOperator ) )
            // InternalOCLX.g:5140:2: ( ruleBinaryOperator )
            {
            // InternalOCLX.g:5140:2: ( ruleBinaryOperator )
            // InternalOCLX.g:5141:3: ruleBinaryOperator
            {
             before(grammarAccess.getExpAccess().getOperatorsBinaryOperatorParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBinaryOperator();

            state._fsp--;

             after(grammarAccess.getExpAccess().getOperatorsBinaryOperatorParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__OperatorsAssignment_1_1"


    // $ANTLR start "rule__Exp__ExpressionsAssignment_1_2"
    // InternalOCLX.g:5150:1: rule__Exp__ExpressionsAssignment_1_2 : ( rulePrefixedExp ) ;
    public final void rule__Exp__ExpressionsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5154:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:5155:2: ( rulePrefixedExp )
            {
            // InternalOCLX.g:5155:2: ( rulePrefixedExp )
            // InternalOCLX.g:5156:3: rulePrefixedExp
            {
             before(grammarAccess.getExpAccess().getExpressionsPrefixedExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrefixedExp();

            state._fsp--;

             after(grammarAccess.getExpAccess().getExpressionsPrefixedExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__ExpressionsAssignment_1_2"


    // $ANTLR start "rule__Exp__OperatorsAssignment_1_3_0"
    // InternalOCLX.g:5165:1: rule__Exp__OperatorsAssignment_1_3_0 : ( ruleBinaryOperator ) ;
    public final void rule__Exp__OperatorsAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5169:1: ( ( ruleBinaryOperator ) )
            // InternalOCLX.g:5170:2: ( ruleBinaryOperator )
            {
            // InternalOCLX.g:5170:2: ( ruleBinaryOperator )
            // InternalOCLX.g:5171:3: ruleBinaryOperator
            {
             before(grammarAccess.getExpAccess().getOperatorsBinaryOperatorParserRuleCall_1_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleBinaryOperator();

            state._fsp--;

             after(grammarAccess.getExpAccess().getOperatorsBinaryOperatorParserRuleCall_1_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__OperatorsAssignment_1_3_0"


    // $ANTLR start "rule__Exp__ExpressionsAssignment_1_3_1"
    // InternalOCLX.g:5180:1: rule__Exp__ExpressionsAssignment_1_3_1 : ( rulePrefixedExp ) ;
    public final void rule__Exp__ExpressionsAssignment_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5184:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:5185:2: ( rulePrefixedExp )
            {
            // InternalOCLX.g:5185:2: ( rulePrefixedExp )
            // InternalOCLX.g:5186:3: rulePrefixedExp
            {
             before(grammarAccess.getExpAccess().getExpressionsPrefixedExpParserRuleCall_1_3_1_0()); 
            pushFollow(FOLLOW_2);
            rulePrefixedExp();

            state._fsp--;

             after(grammarAccess.getExpAccess().getExpressionsPrefixedExpParserRuleCall_1_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Exp__ExpressionsAssignment_1_3_1"


    // $ANTLR start "rule__PrefixedExp__OperatorAssignment_0_1"
    // InternalOCLX.g:5195:1: rule__PrefixedExp__OperatorAssignment_0_1 : ( ruleUnaryOperator ) ;
    public final void rule__PrefixedExp__OperatorAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5199:1: ( ( ruleUnaryOperator ) )
            // InternalOCLX.g:5200:2: ( ruleUnaryOperator )
            {
            // InternalOCLX.g:5200:2: ( ruleUnaryOperator )
            // InternalOCLX.g:5201:3: ruleUnaryOperator
            {
             before(grammarAccess.getPrefixedExpAccess().getOperatorUnaryOperatorParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryOperator();

            state._fsp--;

             after(grammarAccess.getPrefixedExpAccess().getOperatorUnaryOperatorParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixedExp__OperatorAssignment_0_1"


    // $ANTLR start "rule__PrefixedExp__ExpressionAssignment_0_2"
    // InternalOCLX.g:5210:1: rule__PrefixedExp__ExpressionAssignment_0_2 : ( rulePrimaryExp ) ;
    public final void rule__PrefixedExp__ExpressionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5214:1: ( ( rulePrimaryExp ) )
            // InternalOCLX.g:5215:2: ( rulePrimaryExp )
            {
            // InternalOCLX.g:5215:2: ( rulePrimaryExp )
            // InternalOCLX.g:5216:3: rulePrimaryExp
            {
             before(grammarAccess.getPrefixedExpAccess().getExpressionPrimaryExpParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimaryExp();

            state._fsp--;

             after(grammarAccess.getPrefixedExpAccess().getExpressionPrimaryExpParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrefixedExp__ExpressionAssignment_0_2"


    // $ANTLR start "rule__BooleanOperator__OpAssignment"
    // InternalOCLX.g:5225:1: rule__BooleanOperator__OpAssignment : ( ( rule__BooleanOperator__OpAlternatives_0 ) ) ;
    public final void rule__BooleanOperator__OpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5229:1: ( ( ( rule__BooleanOperator__OpAlternatives_0 ) ) )
            // InternalOCLX.g:5230:2: ( ( rule__BooleanOperator__OpAlternatives_0 ) )
            {
            // InternalOCLX.g:5230:2: ( ( rule__BooleanOperator__OpAlternatives_0 ) )
            // InternalOCLX.g:5231:3: ( rule__BooleanOperator__OpAlternatives_0 )
            {
             before(grammarAccess.getBooleanOperatorAccess().getOpAlternatives_0()); 
            // InternalOCLX.g:5232:3: ( rule__BooleanOperator__OpAlternatives_0 )
            // InternalOCLX.g:5232:4: rule__BooleanOperator__OpAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanOperator__OpAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanOperatorAccess().getOpAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanOperator__OpAssignment"


    // $ANTLR start "rule__MathOperator__OpAssignment"
    // InternalOCLX.g:5240:1: rule__MathOperator__OpAssignment : ( ( rule__MathOperator__OpAlternatives_0 ) ) ;
    public final void rule__MathOperator__OpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5244:1: ( ( ( rule__MathOperator__OpAlternatives_0 ) ) )
            // InternalOCLX.g:5245:2: ( ( rule__MathOperator__OpAlternatives_0 ) )
            {
            // InternalOCLX.g:5245:2: ( ( rule__MathOperator__OpAlternatives_0 ) )
            // InternalOCLX.g:5246:3: ( rule__MathOperator__OpAlternatives_0 )
            {
             before(grammarAccess.getMathOperatorAccess().getOpAlternatives_0()); 
            // InternalOCLX.g:5247:3: ( rule__MathOperator__OpAlternatives_0 )
            // InternalOCLX.g:5247:4: rule__MathOperator__OpAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__MathOperator__OpAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getMathOperatorAccess().getOpAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MathOperator__OpAssignment"


    // $ANTLR start "rule__NavigationOperator__NameAssignment"
    // InternalOCLX.g:5255:1: rule__NavigationOperator__NameAssignment : ( ( rule__NavigationOperator__NameAlternatives_0 ) ) ;
    public final void rule__NavigationOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5259:1: ( ( ( rule__NavigationOperator__NameAlternatives_0 ) ) )
            // InternalOCLX.g:5260:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:5260:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            // InternalOCLX.g:5261:3: ( rule__NavigationOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getNavigationOperatorAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:5262:3: ( rule__NavigationOperator__NameAlternatives_0 )
            // InternalOCLX.g:5262:4: rule__NavigationOperator__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__NavigationOperator__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getNavigationOperatorAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationOperator__NameAssignment"


    // $ANTLR start "rule__UnaryOperator__NameAssignment"
    // InternalOCLX.g:5270:1: rule__UnaryOperator__NameAssignment : ( ( rule__UnaryOperator__NameAlternatives_0 ) ) ;
    public final void rule__UnaryOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5274:1: ( ( ( rule__UnaryOperator__NameAlternatives_0 ) ) )
            // InternalOCLX.g:5275:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:5275:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            // InternalOCLX.g:5276:3: ( rule__UnaryOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getUnaryOperatorAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:5277:3: ( rule__UnaryOperator__NameAlternatives_0 )
            // InternalOCLX.g:5277:4: rule__UnaryOperator__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOperator__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getUnaryOperatorAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperator__NameAssignment"


    // $ANTLR start "rule__PrimaryExp__NavAssignment_1_1_0"
    // InternalOCLX.g:5285:1: rule__PrimaryExp__NavAssignment_1_1_0 : ( ruleNavigationOperator ) ;
    public final void rule__PrimaryExp__NavAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5289:1: ( ( ruleNavigationOperator ) )
            // InternalOCLX.g:5290:2: ( ruleNavigationOperator )
            {
            // InternalOCLX.g:5290:2: ( ruleNavigationOperator )
            // InternalOCLX.g:5291:3: ruleNavigationOperator
            {
             before(grammarAccess.getPrimaryExpAccess().getNavNavigationOperatorParserRuleCall_1_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNavigationOperator();

            state._fsp--;

             after(grammarAccess.getPrimaryExpAccess().getNavNavigationOperatorParserRuleCall_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__NavAssignment_1_1_0"


    // $ANTLR start "rule__PrimaryExp__MethodsAssignment_1_1_1"
    // InternalOCLX.g:5300:1: rule__PrimaryExp__MethodsAssignment_1_1_1 : ( ruleMethodExp ) ;
    public final void rule__PrimaryExp__MethodsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5304:1: ( ( ruleMethodExp ) )
            // InternalOCLX.g:5305:2: ( ruleMethodExp )
            {
            // InternalOCLX.g:5305:2: ( ruleMethodExp )
            // InternalOCLX.g:5306:3: ruleMethodExp
            {
             before(grammarAccess.getPrimaryExpAccess().getMethodsMethodExpParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMethodExp();

            state._fsp--;

             after(grammarAccess.getPrimaryExpAccess().getMethodsMethodExpParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__MethodsAssignment_1_1_1"


    // $ANTLR start "rule__NestedExp__SourceAssignment_1"
    // InternalOCLX.g:5315:1: rule__NestedExp__SourceAssignment_1 : ( ruleExp ) ;
    public final void rule__NestedExp__SourceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5319:1: ( ( ruleExp ) )
            // InternalOCLX.g:5320:2: ( ruleExp )
            {
            // InternalOCLX.g:5320:2: ( ruleExp )
            // InternalOCLX.g:5321:3: ruleExp
            {
             before(grammarAccess.getNestedExpAccess().getSourceExpParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getNestedExpAccess().getSourceExpParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__SourceAssignment_1"


    // $ANTLR start "rule__SelfExp__NameAssignment_1"
    // InternalOCLX.g:5330:1: rule__SelfExp__NameAssignment_1 : ( ( 'self' ) ) ;
    public final void rule__SelfExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5334:1: ( ( ( 'self' ) ) )
            // InternalOCLX.g:5335:2: ( ( 'self' ) )
            {
            // InternalOCLX.g:5335:2: ( ( 'self' ) )
            // InternalOCLX.g:5336:3: ( 'self' )
            {
             before(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0()); 
            // InternalOCLX.g:5337:3: ( 'self' )
            // InternalOCLX.g:5338:4: 'self'
            {
             before(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0()); 

            }

             after(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SelfExp__NameAssignment_1"


    // $ANTLR start "rule__VarDeclaration__NameAssignment"
    // InternalOCLX.g:5349:1: rule__VarDeclaration__NameAssignment : ( ruleSimpleName ) ;
    public final void rule__VarDeclaration__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5353:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5354:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5354:2: ( ruleSimpleName )
            // InternalOCLX.g:5355:3: ruleSimpleName
            {
             before(grammarAccess.getVarDeclarationAccess().getNameSimpleNameParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleName();

            state._fsp--;

             after(grammarAccess.getVarDeclarationAccess().getNameSimpleNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarDeclaration__NameAssignment"


    // $ANTLR start "rule__VarReference__RefAssignment"
    // InternalOCLX.g:5364:1: rule__VarReference__RefAssignment : ( ( RULE_ID ) ) ;
    public final void rule__VarReference__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5368:1: ( ( ( RULE_ID ) ) )
            // InternalOCLX.g:5369:2: ( ( RULE_ID ) )
            {
            // InternalOCLX.g:5369:2: ( ( RULE_ID ) )
            // InternalOCLX.g:5370:3: ( RULE_ID )
            {
             before(grammarAccess.getVarReferenceAccess().getRefVarDeclarationCrossReference_0()); 
            // InternalOCLX.g:5371:3: ( RULE_ID )
            // InternalOCLX.g:5372:4: RULE_ID
            {
             before(grammarAccess.getVarReferenceAccess().getRefVarDeclarationIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVarReferenceAccess().getRefVarDeclarationIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getVarReferenceAccess().getRefVarDeclarationCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VarReference__RefAssignment"


    // $ANTLR start "rule__NumberLiteralExp__ValueAssignment"
    // InternalOCLX.g:5383:1: rule__NumberLiteralExp__ValueAssignment : ( RULE_INT ) ;
    public final void rule__NumberLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5387:1: ( ( RULE_INT ) )
            // InternalOCLX.g:5388:2: ( RULE_INT )
            {
            // InternalOCLX.g:5388:2: ( RULE_INT )
            // InternalOCLX.g:5389:3: RULE_INT
            {
             before(grammarAccess.getNumberLiteralExpAccess().getValueINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getNumberLiteralExpAccess().getValueINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberLiteralExp__ValueAssignment"


    // $ANTLR start "rule__StringLiteralExp__ValueAssignment"
    // InternalOCLX.g:5398:1: rule__StringLiteralExp__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5402:1: ( ( RULE_STRING ) )
            // InternalOCLX.g:5403:2: ( RULE_STRING )
            {
            // InternalOCLX.g:5403:2: ( RULE_STRING )
            // InternalOCLX.g:5404:3: RULE_STRING
            {
             before(grammarAccess.getStringLiteralExpAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getStringLiteralExpAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringLiteralExp__ValueAssignment"


    // $ANTLR start "rule__BooleanLiteralExp__ValueAssignment_0"
    // InternalOCLX.g:5413:1: rule__BooleanLiteralExp__ValueAssignment_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralExp__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5417:1: ( ( ( 'true' ) ) )
            // InternalOCLX.g:5418:2: ( ( 'true' ) )
            {
            // InternalOCLX.g:5418:2: ( ( 'true' ) )
            // InternalOCLX.g:5419:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0()); 
            // InternalOCLX.g:5420:3: ( 'true' )
            // InternalOCLX.g:5421:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0()); 

            }

             after(grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralExp__ValueAssignment_0"


    // $ANTLR start "rule__BooleanLiteralExp__ValueAssignment_1"
    // InternalOCLX.g:5432:1: rule__BooleanLiteralExp__ValueAssignment_1 : ( ( 'false' ) ) ;
    public final void rule__BooleanLiteralExp__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5436:1: ( ( ( 'false' ) ) )
            // InternalOCLX.g:5437:2: ( ( 'false' ) )
            {
            // InternalOCLX.g:5437:2: ( ( 'false' ) )
            // InternalOCLX.g:5438:3: ( 'false' )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0()); 
            // InternalOCLX.g:5439:3: ( 'false' )
            // InternalOCLX.g:5440:4: 'false'
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0()); 

            }

             after(grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteralExp__ValueAssignment_1"


    // $ANTLR start "rule__CollectionIterator__NameAssignment_0"
    // InternalOCLX.g:5451:1: rule__CollectionIterator__NameAssignment_0 : ( ruleIteratorName ) ;
    public final void rule__CollectionIterator__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5455:1: ( ( ruleIteratorName ) )
            // InternalOCLX.g:5456:2: ( ruleIteratorName )
            {
            // InternalOCLX.g:5456:2: ( ruleIteratorName )
            // InternalOCLX.g:5457:3: ruleIteratorName
            {
             before(grammarAccess.getCollectionIteratorAccess().getNameIteratorNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleIteratorName();

            state._fsp--;

             after(grammarAccess.getCollectionIteratorAccess().getNameIteratorNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__NameAssignment_0"


    // $ANTLR start "rule__CollectionIterator__ItervarAssignment_2"
    // InternalOCLX.g:5466:1: rule__CollectionIterator__ItervarAssignment_2 : ( ruleIteratorVarDeclaration ) ;
    public final void rule__CollectionIterator__ItervarAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5470:1: ( ( ruleIteratorVarDeclaration ) )
            // InternalOCLX.g:5471:2: ( ruleIteratorVarDeclaration )
            {
            // InternalOCLX.g:5471:2: ( ruleIteratorVarDeclaration )
            // InternalOCLX.g:5472:3: ruleIteratorVarDeclaration
            {
             before(grammarAccess.getCollectionIteratorAccess().getItervarIteratorVarDeclarationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleIteratorVarDeclaration();

            state._fsp--;

             after(grammarAccess.getCollectionIteratorAccess().getItervarIteratorVarDeclarationParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__ItervarAssignment_2"


    // $ANTLR start "rule__CollectionIterator__BodyAssignment_4"
    // InternalOCLX.g:5481:1: rule__CollectionIterator__BodyAssignment_4 : ( ruleExp ) ;
    public final void rule__CollectionIterator__BodyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5485:1: ( ( ruleExp ) )
            // InternalOCLX.g:5486:2: ( ruleExp )
            {
            // InternalOCLX.g:5486:2: ( ruleExp )
            // InternalOCLX.g:5487:3: ruleExp
            {
             before(grammarAccess.getCollectionIteratorAccess().getBodyExpParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getCollectionIteratorAccess().getBodyExpParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionIterator__BodyAssignment_4"


    // $ANTLR start "rule__IteratorName__NameAssignment"
    // InternalOCLX.g:5496:1: rule__IteratorName__NameAssignment : ( ( rule__IteratorName__NameAlternatives_0 ) ) ;
    public final void rule__IteratorName__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5500:1: ( ( ( rule__IteratorName__NameAlternatives_0 ) ) )
            // InternalOCLX.g:5501:2: ( ( rule__IteratorName__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:5501:2: ( ( rule__IteratorName__NameAlternatives_0 ) )
            // InternalOCLX.g:5502:3: ( rule__IteratorName__NameAlternatives_0 )
            {
             before(grammarAccess.getIteratorNameAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:5503:3: ( rule__IteratorName__NameAlternatives_0 )
            // InternalOCLX.g:5503:4: rule__IteratorName__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__IteratorName__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getIteratorNameAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorName__NameAssignment"


    // $ANTLR start "rule__IteratorVarDeclaration__NameAssignment_0"
    // InternalOCLX.g:5511:1: rule__IteratorVarDeclaration__NameAssignment_0 : ( ruleVarDeclaration ) ;
    public final void rule__IteratorVarDeclaration__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5515:1: ( ( ruleVarDeclaration ) )
            // InternalOCLX.g:5516:2: ( ruleVarDeclaration )
            {
            // InternalOCLX.g:5516:2: ( ruleVarDeclaration )
            // InternalOCLX.g:5517:3: ruleVarDeclaration
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getNameVarDeclarationParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleVarDeclaration();

            state._fsp--;

             after(grammarAccess.getIteratorVarDeclarationAccess().getNameVarDeclarationParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorVarDeclaration__NameAssignment_0"


    // $ANTLR start "rule__IteratorVarDeclaration__NameAssignment_1_0"
    // InternalOCLX.g:5526:1: rule__IteratorVarDeclaration__NameAssignment_1_0 : ( ruleVarDeclaration ) ;
    public final void rule__IteratorVarDeclaration__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5530:1: ( ( ruleVarDeclaration ) )
            // InternalOCLX.g:5531:2: ( ruleVarDeclaration )
            {
            // InternalOCLX.g:5531:2: ( ruleVarDeclaration )
            // InternalOCLX.g:5532:3: ruleVarDeclaration
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getNameVarDeclarationParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleVarDeclaration();

            state._fsp--;

             after(grammarAccess.getIteratorVarDeclarationAccess().getNameVarDeclarationParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorVarDeclaration__NameAssignment_1_0"


    // $ANTLR start "rule__IteratorVarDeclaration__TypeAssignment_1_2"
    // InternalOCLX.g:5541:1: rule__IteratorVarDeclaration__TypeAssignment_1_2 : ( ruleTypeExp ) ;
    public final void rule__IteratorVarDeclaration__TypeAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5545:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:5546:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:5546:2: ( ruleTypeExp )
            // InternalOCLX.g:5547:3: ruleTypeExp
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getTypeTypeExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeExp();

            state._fsp--;

             after(grammarAccess.getIteratorVarDeclarationAccess().getTypeTypeExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorVarDeclaration__TypeAssignment_1_2"


    // $ANTLR start "rule__PropertyAccess__NameAssignment"
    // InternalOCLX.g:5556:1: rule__PropertyAccess__NameAssignment : ( ruleSimpleName ) ;
    public final void rule__PropertyAccess__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5560:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5561:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5561:2: ( ruleSimpleName )
            // InternalOCLX.g:5562:3: ruleSimpleName
            {
             before(grammarAccess.getPropertyAccessAccess().getNameSimpleNameParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleName();

            state._fsp--;

             after(grammarAccess.getPropertyAccessAccess().getNameSimpleNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PropertyAccess__NameAssignment"


    // $ANTLR start "rule__MethodCall__NameAssignment_0_0"
    // InternalOCLX.g:5571:1: rule__MethodCall__NameAssignment_0_0 : ( ruleSimpleName ) ;
    public final void rule__MethodCall__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5575:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5576:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5576:2: ( ruleSimpleName )
            // InternalOCLX.g:5577:3: ruleSimpleName
            {
             before(grammarAccess.getMethodCallAccess().getNameSimpleNameParserRuleCall_0_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleName();

            state._fsp--;

             after(grammarAccess.getMethodCallAccess().getNameSimpleNameParserRuleCall_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__NameAssignment_0_0"


    // $ANTLR start "rule__MethodCall__NameAssignment_1_0"
    // InternalOCLX.g:5586:1: rule__MethodCall__NameAssignment_1_0 : ( ruleSimpleName ) ;
    public final void rule__MethodCall__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5590:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5591:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5591:2: ( ruleSimpleName )
            // InternalOCLX.g:5592:3: ruleSimpleName
            {
             before(grammarAccess.getMethodCallAccess().getNameSimpleNameParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleName();

            state._fsp--;

             after(grammarAccess.getMethodCallAccess().getNameSimpleNameParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__NameAssignment_1_0"


    // $ANTLR start "rule__MethodCall__ArgsAssignment_1_2"
    // InternalOCLX.g:5601:1: rule__MethodCall__ArgsAssignment_1_2 : ( ruleArgumentsExp ) ;
    public final void rule__MethodCall__ArgsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5605:1: ( ( ruleArgumentsExp ) )
            // InternalOCLX.g:5606:2: ( ruleArgumentsExp )
            {
            // InternalOCLX.g:5606:2: ( ruleArgumentsExp )
            // InternalOCLX.g:5607:3: ruleArgumentsExp
            {
             before(grammarAccess.getMethodCallAccess().getArgsArgumentsExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleArgumentsExp();

            state._fsp--;

             after(grammarAccess.getMethodCallAccess().getArgsArgumentsExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodCall__ArgsAssignment_1_2"


    // $ANTLR start "rule__TypeCall__NameAssignment_0"
    // InternalOCLX.g:5616:1: rule__TypeCall__NameAssignment_0 : ( ( rule__TypeCall__NameAlternatives_0_0 ) ) ;
    public final void rule__TypeCall__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5620:1: ( ( ( rule__TypeCall__NameAlternatives_0_0 ) ) )
            // InternalOCLX.g:5621:2: ( ( rule__TypeCall__NameAlternatives_0_0 ) )
            {
            // InternalOCLX.g:5621:2: ( ( rule__TypeCall__NameAlternatives_0_0 ) )
            // InternalOCLX.g:5622:3: ( rule__TypeCall__NameAlternatives_0_0 )
            {
             before(grammarAccess.getTypeCallAccess().getNameAlternatives_0_0()); 
            // InternalOCLX.g:5623:3: ( rule__TypeCall__NameAlternatives_0_0 )
            // InternalOCLX.g:5623:4: rule__TypeCall__NameAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__TypeCall__NameAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getTypeCallAccess().getNameAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeCall__NameAssignment_0"


    // $ANTLR start "rule__TypeCall__TypeAssignment_2"
    // InternalOCLX.g:5631:1: rule__TypeCall__TypeAssignment_2 : ( ruleTypeExp ) ;
    public final void rule__TypeCall__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5635:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:5636:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:5636:2: ( ruleTypeExp )
            // InternalOCLX.g:5637:3: ruleTypeExp
            {
             before(grammarAccess.getTypeCallAccess().getTypeTypeExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeExp();

            state._fsp--;

             after(grammarAccess.getTypeCallAccess().getTypeTypeExpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeCall__TypeAssignment_2"


    // $ANTLR start "rule__TypeExp__NameAssignment_0_2"
    // InternalOCLX.g:5646:1: rule__TypeExp__NameAssignment_0_2 : ( rulePath ) ;
    public final void rule__TypeExp__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5650:1: ( ( rulePath ) )
            // InternalOCLX.g:5651:2: ( rulePath )
            {
            // InternalOCLX.g:5651:2: ( rulePath )
            // InternalOCLX.g:5652:3: rulePath
            {
             before(grammarAccess.getTypeExpAccess().getNamePathParserRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            rulePath();

            state._fsp--;

             after(grammarAccess.getTypeExpAccess().getNamePathParserRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__NameAssignment_0_2"


    // $ANTLR start "rule__TypeExp__CollectionTypeAssignment_1_0"
    // InternalOCLX.g:5661:1: rule__TypeExp__CollectionTypeAssignment_1_0 : ( ruleCollectionTypeIdentifier ) ;
    public final void rule__TypeExp__CollectionTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5665:1: ( ( ruleCollectionTypeIdentifier ) )
            // InternalOCLX.g:5666:2: ( ruleCollectionTypeIdentifier )
            {
            // InternalOCLX.g:5666:2: ( ruleCollectionTypeIdentifier )
            // InternalOCLX.g:5667:3: ruleCollectionTypeIdentifier
            {
             before(grammarAccess.getTypeExpAccess().getCollectionTypeCollectionTypeIdentifierParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleCollectionTypeIdentifier();

            state._fsp--;

             after(grammarAccess.getTypeExpAccess().getCollectionTypeCollectionTypeIdentifierParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__CollectionTypeAssignment_1_0"


    // $ANTLR start "rule__TypeExp__TypeAssignment_1_1"
    // InternalOCLX.g:5676:1: rule__TypeExp__TypeAssignment_1_1 : ( ruleTypeExp ) ;
    public final void rule__TypeExp__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5680:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:5681:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:5681:2: ( ruleTypeExp )
            // InternalOCLX.g:5682:3: ruleTypeExp
            {
             before(grammarAccess.getTypeExpAccess().getTypeTypeExpParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeExp();

            state._fsp--;

             after(grammarAccess.getTypeExpAccess().getTypeTypeExpParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__TypeAssignment_1_1"


    // $ANTLR start "rule__CollectionTypeIdentifier__NameAssignment"
    // InternalOCLX.g:5691:1: rule__CollectionTypeIdentifier__NameAssignment : ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) ) ;
    public final void rule__CollectionTypeIdentifier__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5695:1: ( ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) ) )
            // InternalOCLX.g:5696:2: ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:5696:2: ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) )
            // InternalOCLX.g:5697:3: ( rule__CollectionTypeIdentifier__NameAlternatives_0 )
            {
             before(grammarAccess.getCollectionTypeIdentifierAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:5698:3: ( rule__CollectionTypeIdentifier__NameAlternatives_0 )
            // InternalOCLX.g:5698:4: rule__CollectionTypeIdentifier__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__CollectionTypeIdentifier__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getCollectionTypeIdentifierAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionTypeIdentifier__NameAssignment"


    // $ANTLR start "rule__UnaryTemporalExp__NameAssignment_0"
    // InternalOCLX.g:5706:1: rule__UnaryTemporalExp__NameAssignment_0 : ( ruleUnaryTemporalOp ) ;
    public final void rule__UnaryTemporalExp__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5710:1: ( ( ruleUnaryTemporalOp ) )
            // InternalOCLX.g:5711:2: ( ruleUnaryTemporalOp )
            {
            // InternalOCLX.g:5711:2: ( ruleUnaryTemporalOp )
            // InternalOCLX.g:5712:3: ruleUnaryTemporalOp
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getNameUnaryTemporalOpParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryTemporalOp();

            state._fsp--;

             after(grammarAccess.getUnaryTemporalExpAccess().getNameUnaryTemporalOpParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryTemporalExp__NameAssignment_0"


    // $ANTLR start "rule__UnaryTemporalExp__ExpAssignment_2"
    // InternalOCLX.g:5721:1: rule__UnaryTemporalExp__ExpAssignment_2 : ( ruleExp ) ;
    public final void rule__UnaryTemporalExp__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5725:1: ( ( ruleExp ) )
            // InternalOCLX.g:5726:2: ( ruleExp )
            {
            // InternalOCLX.g:5726:2: ( ruleExp )
            // InternalOCLX.g:5727:3: ruleExp
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getExpExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getUnaryTemporalExpAccess().getExpExpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryTemporalExp__ExpAssignment_2"


    // $ANTLR start "rule__TemporalAsLongAs__NameAssignment_0"
    // InternalOCLX.g:5736:1: rule__TemporalAsLongAs__NameAssignment_0 : ( ( 'asLongAs' ) ) ;
    public final void rule__TemporalAsLongAs__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5740:1: ( ( ( 'asLongAs' ) ) )
            // InternalOCLX.g:5741:2: ( ( 'asLongAs' ) )
            {
            // InternalOCLX.g:5741:2: ( ( 'asLongAs' ) )
            // InternalOCLX.g:5742:3: ( 'asLongAs' )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0()); 
            // InternalOCLX.g:5743:3: ( 'asLongAs' )
            // InternalOCLX.g:5744:4: 'asLongAs'
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0()); 

            }

             after(grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__NameAssignment_0"


    // $ANTLR start "rule__TemporalAsLongAs__BAssignment_2"
    // InternalOCLX.g:5755:1: rule__TemporalAsLongAs__BAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalAsLongAs__BAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5759:1: ( ( ruleExp ) )
            // InternalOCLX.g:5760:2: ( ruleExp )
            {
            // InternalOCLX.g:5760:2: ( ruleExp )
            // InternalOCLX.g:5761:3: ruleExp
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getBExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getTemporalAsLongAsAccess().getBExpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__BAssignment_2"


    // $ANTLR start "rule__TemporalAsLongAs__AAssignment_4"
    // InternalOCLX.g:5770:1: rule__TemporalAsLongAs__AAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalAsLongAs__AAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5774:1: ( ( ruleExp ) )
            // InternalOCLX.g:5775:2: ( ruleExp )
            {
            // InternalOCLX.g:5775:2: ( ruleExp )
            // InternalOCLX.g:5776:3: ruleExp
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getAExpParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getTemporalAsLongAsAccess().getAExpParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAsLongAs__AAssignment_4"


    // $ANTLR start "rule__TemporalUntil__NameAssignment_0"
    // InternalOCLX.g:5785:1: rule__TemporalUntil__NameAssignment_0 : ( ( 'ensureThat' ) ) ;
    public final void rule__TemporalUntil__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5789:1: ( ( ( 'ensureThat' ) ) )
            // InternalOCLX.g:5790:2: ( ( 'ensureThat' ) )
            {
            // InternalOCLX.g:5790:2: ( ( 'ensureThat' ) )
            // InternalOCLX.g:5791:3: ( 'ensureThat' )
            {
             before(grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0()); 
            // InternalOCLX.g:5792:3: ( 'ensureThat' )
            // InternalOCLX.g:5793:4: 'ensureThat'
            {
             before(grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0()); 

            }

             after(grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__NameAssignment_0"


    // $ANTLR start "rule__TemporalUntil__AAssignment_2"
    // InternalOCLX.g:5804:1: rule__TemporalUntil__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalUntil__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5808:1: ( ( ruleExp ) )
            // InternalOCLX.g:5809:2: ( ruleExp )
            {
            // InternalOCLX.g:5809:2: ( ruleExp )
            // InternalOCLX.g:5810:3: ruleExp
            {
             before(grammarAccess.getTemporalUntilAccess().getAExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getTemporalUntilAccess().getAExpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__AAssignment_2"


    // $ANTLR start "rule__TemporalUntil__BAssignment_4"
    // InternalOCLX.g:5819:1: rule__TemporalUntil__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalUntil__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5823:1: ( ( ruleExp ) )
            // InternalOCLX.g:5824:2: ( ruleExp )
            {
            // InternalOCLX.g:5824:2: ( ruleExp )
            // InternalOCLX.g:5825:3: ruleExp
            {
             before(grammarAccess.getTemporalUntilAccess().getBExpParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getTemporalUntilAccess().getBExpParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalUntil__BAssignment_4"


    // $ANTLR start "rule__TemporalEverytime__NameAssignment_0"
    // InternalOCLX.g:5834:1: rule__TemporalEverytime__NameAssignment_0 : ( ( 'everyTime' ) ) ;
    public final void rule__TemporalEverytime__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5838:1: ( ( ( 'everyTime' ) ) )
            // InternalOCLX.g:5839:2: ( ( 'everyTime' ) )
            {
            // InternalOCLX.g:5839:2: ( ( 'everyTime' ) )
            // InternalOCLX.g:5840:3: ( 'everyTime' )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0()); 
            // InternalOCLX.g:5841:3: ( 'everyTime' )
            // InternalOCLX.g:5842:4: 'everyTime'
            {
             before(grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0()); 

            }

             after(grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__NameAssignment_0"


    // $ANTLR start "rule__TemporalEverytime__AAssignment_2"
    // InternalOCLX.g:5853:1: rule__TemporalEverytime__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalEverytime__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5857:1: ( ( ruleExp ) )
            // InternalOCLX.g:5858:2: ( ruleExp )
            {
            // InternalOCLX.g:5858:2: ( ruleExp )
            // InternalOCLX.g:5859:3: ruleExp
            {
             before(grammarAccess.getTemporalEverytimeAccess().getAExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getTemporalEverytimeAccess().getAExpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__AAssignment_2"


    // $ANTLR start "rule__TemporalEverytime__BAssignment_4"
    // InternalOCLX.g:5868:1: rule__TemporalEverytime__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalEverytime__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5872:1: ( ( ruleExp ) )
            // InternalOCLX.g:5873:2: ( ruleExp )
            {
            // InternalOCLX.g:5873:2: ( ruleExp )
            // InternalOCLX.g:5874:3: ruleExp
            {
             before(grammarAccess.getTemporalEverytimeAccess().getBExpParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getTemporalEverytimeAccess().getBExpParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalEverytime__BAssignment_4"


    // $ANTLR start "rule__TemporalAtLeastOnce__NameAssignment_0"
    // InternalOCLX.g:5883:1: rule__TemporalAtLeastOnce__NameAssignment_0 : ( ( 'whenOnce' ) ) ;
    public final void rule__TemporalAtLeastOnce__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5887:1: ( ( ( 'whenOnce' ) ) )
            // InternalOCLX.g:5888:2: ( ( 'whenOnce' ) )
            {
            // InternalOCLX.g:5888:2: ( ( 'whenOnce' ) )
            // InternalOCLX.g:5889:3: ( 'whenOnce' )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0()); 
            // InternalOCLX.g:5890:3: ( 'whenOnce' )
            // InternalOCLX.g:5891:4: 'whenOnce'
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0()); 

            }

             after(grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__NameAssignment_0"


    // $ANTLR start "rule__TemporalAtLeastOnce__AAssignment_2"
    // InternalOCLX.g:5902:1: rule__TemporalAtLeastOnce__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalAtLeastOnce__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5906:1: ( ( ruleExp ) )
            // InternalOCLX.g:5907:2: ( ruleExp )
            {
            // InternalOCLX.g:5907:2: ( ruleExp )
            // InternalOCLX.g:5908:3: ruleExp
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getAExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getTemporalAtLeastOnceAccess().getAExpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__AAssignment_2"


    // $ANTLR start "rule__TemporalAtLeastOnce__BAssignment_4"
    // InternalOCLX.g:5917:1: rule__TemporalAtLeastOnce__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalAtLeastOnce__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5921:1: ( ( ruleExp ) )
            // InternalOCLX.g:5922:2: ( ruleExp )
            {
            // InternalOCLX.g:5922:2: ( ruleExp )
            // InternalOCLX.g:5923:3: ruleExp
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getBExpParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getTemporalAtLeastOnceAccess().getBExpParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TemporalAtLeastOnce__BAssignment_4"


    // $ANTLR start "rule__LegacyUntil__NameAssignment_0"
    // InternalOCLX.g:5932:1: rule__LegacyUntil__NameAssignment_0 : ( ( 'until' ) ) ;
    public final void rule__LegacyUntil__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5936:1: ( ( ( 'until' ) ) )
            // InternalOCLX.g:5937:2: ( ( 'until' ) )
            {
            // InternalOCLX.g:5937:2: ( ( 'until' ) )
            // InternalOCLX.g:5938:3: ( 'until' )
            {
             before(grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0()); 
            // InternalOCLX.g:5939:3: ( 'until' )
            // InternalOCLX.g:5940:4: 'until'
            {
             before(grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0()); 

            }

             after(grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__NameAssignment_0"


    // $ANTLR start "rule__LegacyUntil__AAssignment_2"
    // InternalOCLX.g:5951:1: rule__LegacyUntil__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyUntil__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5955:1: ( ( ruleExp ) )
            // InternalOCLX.g:5956:2: ( ruleExp )
            {
            // InternalOCLX.g:5956:2: ( ruleExp )
            // InternalOCLX.g:5957:3: ruleExp
            {
             before(grammarAccess.getLegacyUntilAccess().getAExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getLegacyUntilAccess().getAExpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__AAssignment_2"


    // $ANTLR start "rule__LegacyUntil__BAssignment_4"
    // InternalOCLX.g:5966:1: rule__LegacyUntil__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyUntil__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5970:1: ( ( ruleExp ) )
            // InternalOCLX.g:5971:2: ( ruleExp )
            {
            // InternalOCLX.g:5971:2: ( ruleExp )
            // InternalOCLX.g:5972:3: ruleExp
            {
             before(grammarAccess.getLegacyUntilAccess().getBExpParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getLegacyUntilAccess().getBExpParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyUntil__BAssignment_4"


    // $ANTLR start "rule__LegacyAsSoonAs__NameAssignment_0"
    // InternalOCLX.g:5981:1: rule__LegacyAsSoonAs__NameAssignment_0 : ( ( 'asSoonAs' ) ) ;
    public final void rule__LegacyAsSoonAs__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5985:1: ( ( ( 'asSoonAs' ) ) )
            // InternalOCLX.g:5986:2: ( ( 'asSoonAs' ) )
            {
            // InternalOCLX.g:5986:2: ( ( 'asSoonAs' ) )
            // InternalOCLX.g:5987:3: ( 'asSoonAs' )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0()); 
            // InternalOCLX.g:5988:3: ( 'asSoonAs' )
            // InternalOCLX.g:5989:4: 'asSoonAs'
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0()); 

            }

             after(grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__NameAssignment_0"


    // $ANTLR start "rule__LegacyAsSoonAs__AAssignment_2"
    // InternalOCLX.g:6000:1: rule__LegacyAsSoonAs__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyAsSoonAs__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6004:1: ( ( ruleExp ) )
            // InternalOCLX.g:6005:2: ( ruleExp )
            {
            // InternalOCLX.g:6005:2: ( ruleExp )
            // InternalOCLX.g:6006:3: ruleExp
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getAExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getLegacyAsSoonAsAccess().getAExpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__AAssignment_2"


    // $ANTLR start "rule__LegacyAsSoonAs__BAssignment_4"
    // InternalOCLX.g:6015:1: rule__LegacyAsSoonAs__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyAsSoonAs__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6019:1: ( ( ruleExp ) )
            // InternalOCLX.g:6020:2: ( ruleExp )
            {
            // InternalOCLX.g:6020:2: ( ruleExp )
            // InternalOCLX.g:6021:3: ruleExp
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getBExpParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getLegacyAsSoonAsAccess().getBExpParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyAsSoonAs__BAssignment_4"


    // $ANTLR start "rule__LegacyEverytime__NameAssignment_0"
    // InternalOCLX.g:6030:1: rule__LegacyEverytime__NameAssignment_0 : ( ( 'everytime' ) ) ;
    public final void rule__LegacyEverytime__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6034:1: ( ( ( 'everytime' ) ) )
            // InternalOCLX.g:6035:2: ( ( 'everytime' ) )
            {
            // InternalOCLX.g:6035:2: ( ( 'everytime' ) )
            // InternalOCLX.g:6036:3: ( 'everytime' )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0()); 
            // InternalOCLX.g:6037:3: ( 'everytime' )
            // InternalOCLX.g:6038:4: 'everytime'
            {
             before(grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0()); 

            }

             after(grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__NameAssignment_0"


    // $ANTLR start "rule__LegacyEverytime__AAssignment_2"
    // InternalOCLX.g:6049:1: rule__LegacyEverytime__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyEverytime__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6053:1: ( ( ruleExp ) )
            // InternalOCLX.g:6054:2: ( ruleExp )
            {
            // InternalOCLX.g:6054:2: ( ruleExp )
            // InternalOCLX.g:6055:3: ruleExp
            {
             before(grammarAccess.getLegacyEverytimeAccess().getAExpParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getLegacyEverytimeAccess().getAExpParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__AAssignment_2"


    // $ANTLR start "rule__LegacyEverytime__BAssignment_4"
    // InternalOCLX.g:6064:1: rule__LegacyEverytime__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyEverytime__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6068:1: ( ( ruleExp ) )
            // InternalOCLX.g:6069:2: ( ruleExp )
            {
            // InternalOCLX.g:6069:2: ( ruleExp )
            // InternalOCLX.g:6070:3: ruleExp
            {
             before(grammarAccess.getLegacyEverytimeAccess().getBExpParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getLegacyEverytimeAccess().getBExpParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LegacyEverytime__BAssignment_4"


    // $ANTLR start "rule__ArgumentsExp__OperatorsAssignment_0"
    // InternalOCLX.g:6079:1: rule__ArgumentsExp__OperatorsAssignment_0 : ( ruleExp ) ;
    public final void rule__ArgumentsExp__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6083:1: ( ( ruleExp ) )
            // InternalOCLX.g:6084:2: ( ruleExp )
            {
            // InternalOCLX.g:6084:2: ( ruleExp )
            // InternalOCLX.g:6085:3: ruleExp
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsExpParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getArgumentsExpAccess().getOperatorsExpParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentsExp__OperatorsAssignment_0"


    // $ANTLR start "rule__ArgumentsExp__OperatorsAssignment_1_1"
    // InternalOCLX.g:6094:1: rule__ArgumentsExp__OperatorsAssignment_1_1 : ( ruleExp ) ;
    public final void rule__ArgumentsExp__OperatorsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6098:1: ( ( ruleExp ) )
            // InternalOCLX.g:6099:2: ( ruleExp )
            {
            // InternalOCLX.g:6099:2: ( ruleExp )
            // InternalOCLX.g:6100:3: ruleExp
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsExpParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleExp();

            state._fsp--;

             after(grammarAccess.getArgumentsExpAccess().getOperatorsExpParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArgumentsExp__OperatorsAssignment_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0006400000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x8C500E00120000D0L,0x000000000000007FL});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000003FFF000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000003FFF002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000001FE0000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00400000000000C0L,0x0000000000000003L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000001E000002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x4000000000000002L});

}