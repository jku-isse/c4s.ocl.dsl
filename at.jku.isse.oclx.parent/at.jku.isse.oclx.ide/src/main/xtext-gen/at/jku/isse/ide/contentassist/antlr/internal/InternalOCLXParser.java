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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_DESCRIPTION", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'*'", "'/'", "'+'", "'-'", "'.'", "'->'", "'not'", "'FORALL'", "'EXISTS'", "'COLLECT'", "'REJECT'", "'SELECT'", "'SET'", "'LIST'", "'MAP'", "'COLLECTION'", "'rule'", "'{'", "'context:'", "'expression:'", "'}'", "'description:'", "'is'", "'overrulable:'", "'('", "')'", "'null'", "'|'", "':'", "'()'", "','", "'self'", "'true'", "'false'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int RULE_DESCRIPTION=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
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

                if ( (LA1_0==38) ) {
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


    // $ANTLR start "entryRuleTypeExp"
    // InternalOCLX.g:803:1: entryRuleTypeExp : ruleTypeExp EOF ;
    public final void entryRuleTypeExp() throws RecognitionException {
        try {
            // InternalOCLX.g:804:1: ( ruleTypeExp EOF )
            // InternalOCLX.g:805:1: ruleTypeExp EOF
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
    // InternalOCLX.g:812:1: ruleTypeExp : ( ( rule__TypeExp__Alternatives ) ) ;
    public final void ruleTypeExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:816:2: ( ( ( rule__TypeExp__Alternatives ) ) )
            // InternalOCLX.g:817:2: ( ( rule__TypeExp__Alternatives ) )
            {
            // InternalOCLX.g:817:2: ( ( rule__TypeExp__Alternatives ) )
            // InternalOCLX.g:818:3: ( rule__TypeExp__Alternatives )
            {
             before(grammarAccess.getTypeExpAccess().getAlternatives()); 
            // InternalOCLX.g:819:3: ( rule__TypeExp__Alternatives )
            // InternalOCLX.g:819:4: rule__TypeExp__Alternatives
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
    // InternalOCLX.g:828:1: entryRuleCollectionTypeIdentifier : ruleCollectionTypeIdentifier EOF ;
    public final void entryRuleCollectionTypeIdentifier() throws RecognitionException {
        try {
            // InternalOCLX.g:829:1: ( ruleCollectionTypeIdentifier EOF )
            // InternalOCLX.g:830:1: ruleCollectionTypeIdentifier EOF
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
    // InternalOCLX.g:837:1: ruleCollectionTypeIdentifier : ( ( rule__CollectionTypeIdentifier__NameAssignment ) ) ;
    public final void ruleCollectionTypeIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:841:2: ( ( ( rule__CollectionTypeIdentifier__NameAssignment ) ) )
            // InternalOCLX.g:842:2: ( ( rule__CollectionTypeIdentifier__NameAssignment ) )
            {
            // InternalOCLX.g:842:2: ( ( rule__CollectionTypeIdentifier__NameAssignment ) )
            // InternalOCLX.g:843:3: ( rule__CollectionTypeIdentifier__NameAssignment )
            {
             before(grammarAccess.getCollectionTypeIdentifierAccess().getNameAssignment()); 
            // InternalOCLX.g:844:3: ( rule__CollectionTypeIdentifier__NameAssignment )
            // InternalOCLX.g:844:4: rule__CollectionTypeIdentifier__NameAssignment
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


    // $ANTLR start "entryRulePath"
    // InternalOCLX.g:853:1: entryRulePath : rulePath EOF ;
    public final void entryRulePath() throws RecognitionException {
        try {
            // InternalOCLX.g:854:1: ( rulePath EOF )
            // InternalOCLX.g:855:1: rulePath EOF
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
    // InternalOCLX.g:862:1: rulePath : ( ( rule__Path__Group__0 ) ) ;
    public final void rulePath() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:866:2: ( ( ( rule__Path__Group__0 ) ) )
            // InternalOCLX.g:867:2: ( ( rule__Path__Group__0 ) )
            {
            // InternalOCLX.g:867:2: ( ( rule__Path__Group__0 ) )
            // InternalOCLX.g:868:3: ( rule__Path__Group__0 )
            {
             before(grammarAccess.getPathAccess().getGroup()); 
            // InternalOCLX.g:869:3: ( rule__Path__Group__0 )
            // InternalOCLX.g:869:4: rule__Path__Group__0
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
    // InternalOCLX.g:878:1: entryRuleArgumentsExp : ruleArgumentsExp EOF ;
    public final void entryRuleArgumentsExp() throws RecognitionException {
        try {
            // InternalOCLX.g:879:1: ( ruleArgumentsExp EOF )
            // InternalOCLX.g:880:1: ruleArgumentsExp EOF
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
    // InternalOCLX.g:887:1: ruleArgumentsExp : ( ( rule__ArgumentsExp__Group__0 ) ) ;
    public final void ruleArgumentsExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:891:2: ( ( ( rule__ArgumentsExp__Group__0 ) ) )
            // InternalOCLX.g:892:2: ( ( rule__ArgumentsExp__Group__0 ) )
            {
            // InternalOCLX.g:892:2: ( ( rule__ArgumentsExp__Group__0 ) )
            // InternalOCLX.g:893:3: ( rule__ArgumentsExp__Group__0 )
            {
             before(grammarAccess.getArgumentsExpAccess().getGroup()); 
            // InternalOCLX.g:894:3: ( rule__ArgumentsExp__Group__0 )
            // InternalOCLX.g:894:4: rule__ArgumentsExp__Group__0
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
    // InternalOCLX.g:902:1: rule__PrefixedExp__Alternatives : ( ( ( rule__PrefixedExp__Group_0__0 ) ) | ( rulePrimaryExp ) );
    public final void rule__PrefixedExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:906:1: ( ( ( rule__PrefixedExp__Group_0__0 ) ) | ( rulePrimaryExp ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==25||LA2_0==28) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID||(LA2_0>=RULE_INT && LA2_0<=RULE_STRING)||LA2_0==46||LA2_0==48||(LA2_0>=53 && LA2_0<=55)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalOCLX.g:907:2: ( ( rule__PrefixedExp__Group_0__0 ) )
                    {
                    // InternalOCLX.g:907:2: ( ( rule__PrefixedExp__Group_0__0 ) )
                    // InternalOCLX.g:908:3: ( rule__PrefixedExp__Group_0__0 )
                    {
                     before(grammarAccess.getPrefixedExpAccess().getGroup_0()); 
                    // InternalOCLX.g:909:3: ( rule__PrefixedExp__Group_0__0 )
                    // InternalOCLX.g:909:4: rule__PrefixedExp__Group_0__0
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
                    // InternalOCLX.g:913:2: ( rulePrimaryExp )
                    {
                    // InternalOCLX.g:913:2: ( rulePrimaryExp )
                    // InternalOCLX.g:914:3: rulePrimaryExp
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
    // InternalOCLX.g:923:1: rule__InfixOperator__Alternatives : ( ( ruleBooleanOperator ) | ( ruleMathOperator ) );
    public final void rule__InfixOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:927:1: ( ( ruleBooleanOperator ) | ( ruleMathOperator ) )
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
                    // InternalOCLX.g:928:2: ( ruleBooleanOperator )
                    {
                    // InternalOCLX.g:928:2: ( ruleBooleanOperator )
                    // InternalOCLX.g:929:3: ruleBooleanOperator
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
                    // InternalOCLX.g:934:2: ( ruleMathOperator )
                    {
                    // InternalOCLX.g:934:2: ( ruleMathOperator )
                    // InternalOCLX.g:935:3: ruleMathOperator
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
    // InternalOCLX.g:944:1: rule__BooleanOperator__OpAlternatives_0 : ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '<>' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) );
    public final void rule__BooleanOperator__OpAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:948:1: ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '<>' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) )
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
                    // InternalOCLX.g:949:2: ( '>' )
                    {
                    // InternalOCLX.g:949:2: ( '>' )
                    // InternalOCLX.g:950:3: '>'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:955:2: ( '<' )
                    {
                    // InternalOCLX.g:955:2: ( '<' )
                    // InternalOCLX.g:956:3: '<'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:961:2: ( '>=' )
                    {
                    // InternalOCLX.g:961:2: ( '>=' )
                    // InternalOCLX.g:962:3: '>='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:967:2: ( '<=' )
                    {
                    // InternalOCLX.g:967:2: ( '<=' )
                    // InternalOCLX.g:968:3: '<='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOCLX.g:973:2: ( '=' )
                    {
                    // InternalOCLX.g:973:2: ( '=' )
                    // InternalOCLX.g:974:3: '='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOCLX.g:979:2: ( '<>' )
                    {
                    // InternalOCLX.g:979:2: ( '<>' )
                    // InternalOCLX.g:980:3: '<>'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignGreaterThanSignKeyword_0_5()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignGreaterThanSignKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalOCLX.g:985:2: ( 'and' )
                    {
                    // InternalOCLX.g:985:2: ( 'and' )
                    // InternalOCLX.g:986:3: 'and'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalOCLX.g:991:2: ( 'or' )
                    {
                    // InternalOCLX.g:991:2: ( 'or' )
                    // InternalOCLX.g:992:3: 'or'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalOCLX.g:997:2: ( 'xor' )
                    {
                    // InternalOCLX.g:997:2: ( 'xor' )
                    // InternalOCLX.g:998:3: 'xor'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalOCLX.g:1003:2: ( 'implies' )
                    {
                    // InternalOCLX.g:1003:2: ( 'implies' )
                    // InternalOCLX.g:1004:3: 'implies'
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
    // InternalOCLX.g:1013:1: rule__MathOperator__OpAlternatives_0 : ( ( '*' ) | ( '/' ) | ( '+' ) | ( '-' ) );
    public final void rule__MathOperator__OpAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1017:1: ( ( '*' ) | ( '/' ) | ( '+' ) | ( '-' ) )
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
                    // InternalOCLX.g:1018:2: ( '*' )
                    {
                    // InternalOCLX.g:1018:2: ( '*' )
                    // InternalOCLX.g:1019:3: '*'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1024:2: ( '/' )
                    {
                    // InternalOCLX.g:1024:2: ( '/' )
                    // InternalOCLX.g:1025:3: '/'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1030:2: ( '+' )
                    {
                    // InternalOCLX.g:1030:2: ( '+' )
                    // InternalOCLX.g:1031:3: '+'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1036:2: ( '-' )
                    {
                    // InternalOCLX.g:1036:2: ( '-' )
                    // InternalOCLX.g:1037:3: '-'
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
    // InternalOCLX.g:1046:1: rule__NavigationOperator__NameAlternatives_0 : ( ( '.' ) | ( '->' ) );
    public final void rule__NavigationOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1050:1: ( ( '.' ) | ( '->' ) )
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
                    // InternalOCLX.g:1051:2: ( '.' )
                    {
                    // InternalOCLX.g:1051:2: ( '.' )
                    // InternalOCLX.g:1052:3: '.'
                    {
                     before(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1057:2: ( '->' )
                    {
                    // InternalOCLX.g:1057:2: ( '->' )
                    // InternalOCLX.g:1058:3: '->'
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
    // InternalOCLX.g:1067:1: rule__UnaryOperator__NameAlternatives_0 : ( ( '-' ) | ( 'not' ) );
    public final void rule__UnaryOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1071:1: ( ( '-' ) | ( 'not' ) )
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
                    // InternalOCLX.g:1072:2: ( '-' )
                    {
                    // InternalOCLX.g:1072:2: ( '-' )
                    // InternalOCLX.g:1073:3: '-'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1078:2: ( 'not' )
                    {
                    // InternalOCLX.g:1078:2: ( 'not' )
                    // InternalOCLX.g:1079:3: 'not'
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
    // InternalOCLX.g:1088:1: rule__PrimaryExp__Alternatives : ( ( ruleNestedExp ) | ( ( rule__PrimaryExp__Group_1__0 ) ) | ( rulePrimitiveLiteralExp ) );
    public final void rule__PrimaryExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1092:1: ( ( ruleNestedExp ) | ( ( rule__PrimaryExp__Group_1__0 ) ) | ( rulePrimitiveLiteralExp ) )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt8=1;
                }
                break;
            case RULE_ID:
            case 53:
                {
                alt8=2;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 48:
            case 54:
            case 55:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalOCLX.g:1093:2: ( ruleNestedExp )
                    {
                    // InternalOCLX.g:1093:2: ( ruleNestedExp )
                    // InternalOCLX.g:1094:3: ruleNestedExp
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
                    // InternalOCLX.g:1099:2: ( ( rule__PrimaryExp__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1099:2: ( ( rule__PrimaryExp__Group_1__0 ) )
                    // InternalOCLX.g:1100:3: ( rule__PrimaryExp__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpAccess().getGroup_1()); 
                    // InternalOCLX.g:1101:3: ( rule__PrimaryExp__Group_1__0 )
                    // InternalOCLX.g:1101:4: rule__PrimaryExp__Group_1__0
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
                    // InternalOCLX.g:1105:2: ( rulePrimitiveLiteralExp )
                    {
                    // InternalOCLX.g:1105:2: ( rulePrimitiveLiteralExp )
                    // InternalOCLX.g:1106:3: rulePrimitiveLiteralExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getPrimitiveLiteralExpParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    rulePrimitiveLiteralExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getPrimitiveLiteralExpParserRuleCall_2()); 

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
    // InternalOCLX.g:1115:1: rule__VarOrSelfExp__Alternatives : ( ( ruleSelfExp ) | ( ruleVarReference ) );
    public final void rule__VarOrSelfExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1119:1: ( ( ruleSelfExp ) | ( ruleVarReference ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==53) ) {
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
                    // InternalOCLX.g:1120:2: ( ruleSelfExp )
                    {
                    // InternalOCLX.g:1120:2: ( ruleSelfExp )
                    // InternalOCLX.g:1121:3: ruleSelfExp
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
                    // InternalOCLX.g:1126:2: ( ruleVarReference )
                    {
                    // InternalOCLX.g:1126:2: ( ruleVarReference )
                    // InternalOCLX.g:1127:3: ruleVarReference
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
    // InternalOCLX.g:1136:1: rule__PrimitiveLiteralExp__Alternatives : ( ( ruleNumberLiteralExp ) | ( ruleStringLiteralExp ) | ( ruleBooleanLiteralExp ) | ( ruleNullLiteralExp ) );
    public final void rule__PrimitiveLiteralExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1140:1: ( ( ruleNumberLiteralExp ) | ( ruleStringLiteralExp ) | ( ruleBooleanLiteralExp ) | ( ruleNullLiteralExp ) )
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
            case 54:
            case 55:
                {
                alt10=3;
                }
                break;
            case 48:
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
                    // InternalOCLX.g:1141:2: ( ruleNumberLiteralExp )
                    {
                    // InternalOCLX.g:1141:2: ( ruleNumberLiteralExp )
                    // InternalOCLX.g:1142:3: ruleNumberLiteralExp
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
                    // InternalOCLX.g:1147:2: ( ruleStringLiteralExp )
                    {
                    // InternalOCLX.g:1147:2: ( ruleStringLiteralExp )
                    // InternalOCLX.g:1148:3: ruleStringLiteralExp
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
                    // InternalOCLX.g:1153:2: ( ruleBooleanLiteralExp )
                    {
                    // InternalOCLX.g:1153:2: ( ruleBooleanLiteralExp )
                    // InternalOCLX.g:1154:3: ruleBooleanLiteralExp
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
                    // InternalOCLX.g:1159:2: ( ruleNullLiteralExp )
                    {
                    // InternalOCLX.g:1159:2: ( ruleNullLiteralExp )
                    // InternalOCLX.g:1160:3: ruleNullLiteralExp
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
    // InternalOCLX.g:1169:1: rule__BooleanLiteralExp__Alternatives : ( ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) ) | ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) ) );
    public final void rule__BooleanLiteralExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1173:1: ( ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) ) | ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==54) ) {
                alt11=1;
            }
            else if ( (LA11_0==55) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalOCLX.g:1174:2: ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) )
                    {
                    // InternalOCLX.g:1174:2: ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) )
                    // InternalOCLX.g:1175:3: ( rule__BooleanLiteralExp__ValueAssignment_0 )
                    {
                     before(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_0()); 
                    // InternalOCLX.g:1176:3: ( rule__BooleanLiteralExp__ValueAssignment_0 )
                    // InternalOCLX.g:1176:4: rule__BooleanLiteralExp__ValueAssignment_0
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
                    // InternalOCLX.g:1180:2: ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) )
                    {
                    // InternalOCLX.g:1180:2: ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) )
                    // InternalOCLX.g:1181:3: ( rule__BooleanLiteralExp__ValueAssignment_1 )
                    {
                     before(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_1()); 
                    // InternalOCLX.g:1182:3: ( rule__BooleanLiteralExp__ValueAssignment_1 )
                    // InternalOCLX.g:1182:4: rule__BooleanLiteralExp__ValueAssignment_1
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
    // InternalOCLX.g:1190:1: rule__MethodExp__Alternatives : ( ( rulePropertyAccess ) | ( ruleMethodCall ) | ( ruleCollectionIterator ) );
    public final void rule__MethodExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1194:1: ( ( rulePropertyAccess ) | ( ruleMethodCall ) | ( ruleCollectionIterator ) )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==EOF||(LA12_1>=12 && LA12_1<=27)||LA12_1==42||LA12_1==47||LA12_1==52) ) {
                    alt12=1;
                }
                else if ( (LA12_1==46||LA12_1==51) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA12_0>=29 && LA12_0<=33)) ) {
                alt12=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalOCLX.g:1195:2: ( rulePropertyAccess )
                    {
                    // InternalOCLX.g:1195:2: ( rulePropertyAccess )
                    // InternalOCLX.g:1196:3: rulePropertyAccess
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
                    // InternalOCLX.g:1201:2: ( ruleMethodCall )
                    {
                    // InternalOCLX.g:1201:2: ( ruleMethodCall )
                    // InternalOCLX.g:1202:3: ruleMethodCall
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
                    // InternalOCLX.g:1207:2: ( ruleCollectionIterator )
                    {
                    // InternalOCLX.g:1207:2: ( ruleCollectionIterator )
                    // InternalOCLX.g:1208:3: ruleCollectionIterator
                    {
                     before(grammarAccess.getMethodExpAccess().getCollectionIteratorParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleCollectionIterator();

                    state._fsp--;

                     after(grammarAccess.getMethodExpAccess().getCollectionIteratorParserRuleCall_2()); 

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
    // InternalOCLX.g:1217:1: rule__IteratorName__NameAlternatives_0 : ( ( 'FORALL' ) | ( 'EXISTS' ) | ( 'COLLECT' ) | ( 'REJECT' ) | ( 'SELECT' ) );
    public final void rule__IteratorName__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1221:1: ( ( 'FORALL' ) | ( 'EXISTS' ) | ( 'COLLECT' ) | ( 'REJECT' ) | ( 'SELECT' ) )
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
                    // InternalOCLX.g:1222:2: ( 'FORALL' )
                    {
                    // InternalOCLX.g:1222:2: ( 'FORALL' )
                    // InternalOCLX.g:1223:3: 'FORALL'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameFORALLKeyword_0_0()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameFORALLKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1228:2: ( 'EXISTS' )
                    {
                    // InternalOCLX.g:1228:2: ( 'EXISTS' )
                    // InternalOCLX.g:1229:3: 'EXISTS'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameEXISTSKeyword_0_1()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameEXISTSKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1234:2: ( 'COLLECT' )
                    {
                    // InternalOCLX.g:1234:2: ( 'COLLECT' )
                    // InternalOCLX.g:1235:3: 'COLLECT'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameCOLLECTKeyword_0_2()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameCOLLECTKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1240:2: ( 'REJECT' )
                    {
                    // InternalOCLX.g:1240:2: ( 'REJECT' )
                    // InternalOCLX.g:1241:3: 'REJECT'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameREJECTKeyword_0_3()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameREJECTKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1246:2: ( 'SELECT' )
                    {
                    // InternalOCLX.g:1246:2: ( 'SELECT' )
                    // InternalOCLX.g:1247:3: 'SELECT'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameSELECTKeyword_0_4()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameSELECTKeyword_0_4()); 

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
    // InternalOCLX.g:1256:1: rule__IteratorVarDeclaration__Alternatives : ( ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) ) | ( ( rule__IteratorVarDeclaration__Group_1__0 ) ) );
    public final void rule__IteratorVarDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1260:1: ( ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) ) | ( ( rule__IteratorVarDeclaration__Group_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==EOF||LA14_1==49) ) {
                    alt14=1;
                }
                else if ( (LA14_1==50) ) {
                    alt14=2;
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
                    // InternalOCLX.g:1261:2: ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) )
                    {
                    // InternalOCLX.g:1261:2: ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) )
                    // InternalOCLX.g:1262:3: ( rule__IteratorVarDeclaration__NameAssignment_0 )
                    {
                     before(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_0()); 
                    // InternalOCLX.g:1263:3: ( rule__IteratorVarDeclaration__NameAssignment_0 )
                    // InternalOCLX.g:1263:4: rule__IteratorVarDeclaration__NameAssignment_0
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
                    // InternalOCLX.g:1267:2: ( ( rule__IteratorVarDeclaration__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1267:2: ( ( rule__IteratorVarDeclaration__Group_1__0 ) )
                    // InternalOCLX.g:1268:3: ( rule__IteratorVarDeclaration__Group_1__0 )
                    {
                     before(grammarAccess.getIteratorVarDeclarationAccess().getGroup_1()); 
                    // InternalOCLX.g:1269:3: ( rule__IteratorVarDeclaration__Group_1__0 )
                    // InternalOCLX.g:1269:4: rule__IteratorVarDeclaration__Group_1__0
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
    // InternalOCLX.g:1277:1: rule__MethodCall__Alternatives : ( ( ( rule__MethodCall__Group_0__0 ) ) | ( ( rule__MethodCall__Group_1__0 ) ) | ( ( rule__MethodCall__Group_2__0 ) ) );
    public final void rule__MethodCall__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1281:1: ( ( ( rule__MethodCall__Group_0__0 ) ) | ( ( rule__MethodCall__Group_1__0 ) ) | ( ( rule__MethodCall__Group_2__0 ) ) )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==46) ) {
                    int LA15_2 = input.LA(3);

                    if ( (LA15_2==RULE_ID||(LA15_2>=RULE_INT && LA15_2<=RULE_STRING)||LA15_2==25||LA15_2==28||LA15_2==46||LA15_2==48||(LA15_2>=53 && LA15_2<=55)) ) {
                        alt15=2;
                    }
                    else if ( (LA15_2==13||(LA15_2>=34 && LA15_2<=37)) ) {
                        alt15=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA15_1==51) ) {
                    alt15=1;
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
                    // InternalOCLX.g:1282:2: ( ( rule__MethodCall__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1282:2: ( ( rule__MethodCall__Group_0__0 ) )
                    // InternalOCLX.g:1283:3: ( rule__MethodCall__Group_0__0 )
                    {
                     before(grammarAccess.getMethodCallAccess().getGroup_0()); 
                    // InternalOCLX.g:1284:3: ( rule__MethodCall__Group_0__0 )
                    // InternalOCLX.g:1284:4: rule__MethodCall__Group_0__0
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
                    // InternalOCLX.g:1288:2: ( ( rule__MethodCall__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1288:2: ( ( rule__MethodCall__Group_1__0 ) )
                    // InternalOCLX.g:1289:3: ( rule__MethodCall__Group_1__0 )
                    {
                     before(grammarAccess.getMethodCallAccess().getGroup_1()); 
                    // InternalOCLX.g:1290:3: ( rule__MethodCall__Group_1__0 )
                    // InternalOCLX.g:1290:4: rule__MethodCall__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MethodCall__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMethodCallAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1294:2: ( ( rule__MethodCall__Group_2__0 ) )
                    {
                    // InternalOCLX.g:1294:2: ( ( rule__MethodCall__Group_2__0 ) )
                    // InternalOCLX.g:1295:3: ( rule__MethodCall__Group_2__0 )
                    {
                     before(grammarAccess.getMethodCallAccess().getGroup_2()); 
                    // InternalOCLX.g:1296:3: ( rule__MethodCall__Group_2__0 )
                    // InternalOCLX.g:1296:4: rule__MethodCall__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MethodCall__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getMethodCallAccess().getGroup_2()); 

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


    // $ANTLR start "rule__TypeExp__Alternatives"
    // InternalOCLX.g:1304:1: rule__TypeExp__Alternatives : ( ( ( rule__TypeExp__Group_0__0 ) ) | ( ( rule__TypeExp__Group_1__0 ) ) );
    public final void rule__TypeExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1308:1: ( ( ( rule__TypeExp__Group_0__0 ) ) | ( ( rule__TypeExp__Group_1__0 ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==13) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=34 && LA16_0<=37)) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalOCLX.g:1309:2: ( ( rule__TypeExp__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1309:2: ( ( rule__TypeExp__Group_0__0 ) )
                    // InternalOCLX.g:1310:3: ( rule__TypeExp__Group_0__0 )
                    {
                     before(grammarAccess.getTypeExpAccess().getGroup_0()); 
                    // InternalOCLX.g:1311:3: ( rule__TypeExp__Group_0__0 )
                    // InternalOCLX.g:1311:4: rule__TypeExp__Group_0__0
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
                    // InternalOCLX.g:1315:2: ( ( rule__TypeExp__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1315:2: ( ( rule__TypeExp__Group_1__0 ) )
                    // InternalOCLX.g:1316:3: ( rule__TypeExp__Group_1__0 )
                    {
                     before(grammarAccess.getTypeExpAccess().getGroup_1()); 
                    // InternalOCLX.g:1317:3: ( rule__TypeExp__Group_1__0 )
                    // InternalOCLX.g:1317:4: rule__TypeExp__Group_1__0
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
    // InternalOCLX.g:1325:1: rule__CollectionTypeIdentifier__NameAlternatives_0 : ( ( 'SET' ) | ( 'LIST' ) | ( 'MAP' ) | ( 'COLLECTION' ) );
    public final void rule__CollectionTypeIdentifier__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1329:1: ( ( 'SET' ) | ( 'LIST' ) | ( 'MAP' ) | ( 'COLLECTION' ) )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt17=1;
                }
                break;
            case 35:
                {
                alt17=2;
                }
                break;
            case 36:
                {
                alt17=3;
                }
                break;
            case 37:
                {
                alt17=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalOCLX.g:1330:2: ( 'SET' )
                    {
                    // InternalOCLX.g:1330:2: ( 'SET' )
                    // InternalOCLX.g:1331:3: 'SET'
                    {
                     before(grammarAccess.getCollectionTypeIdentifierAccess().getNameSETKeyword_0_0()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getCollectionTypeIdentifierAccess().getNameSETKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1336:2: ( 'LIST' )
                    {
                    // InternalOCLX.g:1336:2: ( 'LIST' )
                    // InternalOCLX.g:1337:3: 'LIST'
                    {
                     before(grammarAccess.getCollectionTypeIdentifierAccess().getNameLISTKeyword_0_1()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getCollectionTypeIdentifierAccess().getNameLISTKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1342:2: ( 'MAP' )
                    {
                    // InternalOCLX.g:1342:2: ( 'MAP' )
                    // InternalOCLX.g:1343:3: 'MAP'
                    {
                     before(grammarAccess.getCollectionTypeIdentifierAccess().getNameMAPKeyword_0_2()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getCollectionTypeIdentifierAccess().getNameMAPKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1348:2: ( 'COLLECTION' )
                    {
                    // InternalOCLX.g:1348:2: ( 'COLLECTION' )
                    // InternalOCLX.g:1349:3: 'COLLECTION'
                    {
                     before(grammarAccess.getCollectionTypeIdentifierAccess().getNameCOLLECTIONKeyword_0_3()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getCollectionTypeIdentifierAccess().getNameCOLLECTIONKeyword_0_3()); 

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


    // $ANTLR start "rule__Constraint__Group__0"
    // InternalOCLX.g:1358:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1362:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalOCLX.g:1363:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
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
    // InternalOCLX.g:1370:1: rule__Constraint__Group__0__Impl : ( 'rule' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1374:1: ( ( 'rule' ) )
            // InternalOCLX.g:1375:1: ( 'rule' )
            {
            // InternalOCLX.g:1375:1: ( 'rule' )
            // InternalOCLX.g:1376:2: 'rule'
            {
             before(grammarAccess.getConstraintAccess().getRuleKeyword_0()); 
            match(input,38,FOLLOW_2); 
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
    // InternalOCLX.g:1385:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1389:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalOCLX.g:1390:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
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
    // InternalOCLX.g:1397:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__NameAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1401:1: ( ( ( rule__Constraint__NameAssignment_1 ) ) )
            // InternalOCLX.g:1402:1: ( ( rule__Constraint__NameAssignment_1 ) )
            {
            // InternalOCLX.g:1402:1: ( ( rule__Constraint__NameAssignment_1 ) )
            // InternalOCLX.g:1403:2: ( rule__Constraint__NameAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getNameAssignment_1()); 
            // InternalOCLX.g:1404:2: ( rule__Constraint__NameAssignment_1 )
            // InternalOCLX.g:1404:3: rule__Constraint__NameAssignment_1
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
    // InternalOCLX.g:1412:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1416:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalOCLX.g:1417:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
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
    // InternalOCLX.g:1424:1: rule__Constraint__Group__2__Impl : ( '{' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1428:1: ( ( '{' ) )
            // InternalOCLX.g:1429:1: ( '{' )
            {
            // InternalOCLX.g:1429:1: ( '{' )
            // InternalOCLX.g:1430:2: '{'
            {
             before(grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,39,FOLLOW_2); 
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
    // InternalOCLX.g:1439:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1443:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalOCLX.g:1444:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
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
    // InternalOCLX.g:1451:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__Group_3__0 )? ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1455:1: ( ( ( rule__Constraint__Group_3__0 )? ) )
            // InternalOCLX.g:1456:1: ( ( rule__Constraint__Group_3__0 )? )
            {
            // InternalOCLX.g:1456:1: ( ( rule__Constraint__Group_3__0 )? )
            // InternalOCLX.g:1457:2: ( rule__Constraint__Group_3__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_3()); 
            // InternalOCLX.g:1458:2: ( rule__Constraint__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==43) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalOCLX.g:1458:3: rule__Constraint__Group_3__0
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
    // InternalOCLX.g:1466:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1470:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalOCLX.g:1471:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
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
    // InternalOCLX.g:1478:1: rule__Constraint__Group__4__Impl : ( ( rule__Constraint__Group_4__0 )? ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1482:1: ( ( ( rule__Constraint__Group_4__0 )? ) )
            // InternalOCLX.g:1483:1: ( ( rule__Constraint__Group_4__0 )? )
            {
            // InternalOCLX.g:1483:1: ( ( rule__Constraint__Group_4__0 )? )
            // InternalOCLX.g:1484:2: ( rule__Constraint__Group_4__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_4()); 
            // InternalOCLX.g:1485:2: ( rule__Constraint__Group_4__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==44) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalOCLX.g:1485:3: rule__Constraint__Group_4__0
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
    // InternalOCLX.g:1493:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl rule__Constraint__Group__6 ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1497:1: ( rule__Constraint__Group__5__Impl rule__Constraint__Group__6 )
            // InternalOCLX.g:1498:2: rule__Constraint__Group__5__Impl rule__Constraint__Group__6
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
    // InternalOCLX.g:1505:1: rule__Constraint__Group__5__Impl : ( 'context:' ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1509:1: ( ( 'context:' ) )
            // InternalOCLX.g:1510:1: ( 'context:' )
            {
            // InternalOCLX.g:1510:1: ( 'context:' )
            // InternalOCLX.g:1511:2: 'context:'
            {
             before(grammarAccess.getConstraintAccess().getContextKeyword_5()); 
            match(input,40,FOLLOW_2); 
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
    // InternalOCLX.g:1520:1: rule__Constraint__Group__6 : rule__Constraint__Group__6__Impl rule__Constraint__Group__7 ;
    public final void rule__Constraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1524:1: ( rule__Constraint__Group__6__Impl rule__Constraint__Group__7 )
            // InternalOCLX.g:1525:2: rule__Constraint__Group__6__Impl rule__Constraint__Group__7
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
    // InternalOCLX.g:1532:1: rule__Constraint__Group__6__Impl : ( ( rule__Constraint__ContextAssignment_6 ) ) ;
    public final void rule__Constraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1536:1: ( ( ( rule__Constraint__ContextAssignment_6 ) ) )
            // InternalOCLX.g:1537:1: ( ( rule__Constraint__ContextAssignment_6 ) )
            {
            // InternalOCLX.g:1537:1: ( ( rule__Constraint__ContextAssignment_6 ) )
            // InternalOCLX.g:1538:2: ( rule__Constraint__ContextAssignment_6 )
            {
             before(grammarAccess.getConstraintAccess().getContextAssignment_6()); 
            // InternalOCLX.g:1539:2: ( rule__Constraint__ContextAssignment_6 )
            // InternalOCLX.g:1539:3: rule__Constraint__ContextAssignment_6
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
    // InternalOCLX.g:1547:1: rule__Constraint__Group__7 : rule__Constraint__Group__7__Impl rule__Constraint__Group__8 ;
    public final void rule__Constraint__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1551:1: ( rule__Constraint__Group__7__Impl rule__Constraint__Group__8 )
            // InternalOCLX.g:1552:2: rule__Constraint__Group__7__Impl rule__Constraint__Group__8
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
    // InternalOCLX.g:1559:1: rule__Constraint__Group__7__Impl : ( 'expression:' ) ;
    public final void rule__Constraint__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1563:1: ( ( 'expression:' ) )
            // InternalOCLX.g:1564:1: ( 'expression:' )
            {
            // InternalOCLX.g:1564:1: ( 'expression:' )
            // InternalOCLX.g:1565:2: 'expression:'
            {
             before(grammarAccess.getConstraintAccess().getExpressionKeyword_7()); 
            match(input,41,FOLLOW_2); 
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
    // InternalOCLX.g:1574:1: rule__Constraint__Group__8 : rule__Constraint__Group__8__Impl rule__Constraint__Group__9 ;
    public final void rule__Constraint__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1578:1: ( rule__Constraint__Group__8__Impl rule__Constraint__Group__9 )
            // InternalOCLX.g:1579:2: rule__Constraint__Group__8__Impl rule__Constraint__Group__9
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
    // InternalOCLX.g:1586:1: rule__Constraint__Group__8__Impl : ( ( rule__Constraint__ExpressionAssignment_8 ) ) ;
    public final void rule__Constraint__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1590:1: ( ( ( rule__Constraint__ExpressionAssignment_8 ) ) )
            // InternalOCLX.g:1591:1: ( ( rule__Constraint__ExpressionAssignment_8 ) )
            {
            // InternalOCLX.g:1591:1: ( ( rule__Constraint__ExpressionAssignment_8 ) )
            // InternalOCLX.g:1592:2: ( rule__Constraint__ExpressionAssignment_8 )
            {
             before(grammarAccess.getConstraintAccess().getExpressionAssignment_8()); 
            // InternalOCLX.g:1593:2: ( rule__Constraint__ExpressionAssignment_8 )
            // InternalOCLX.g:1593:3: rule__Constraint__ExpressionAssignment_8
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
    // InternalOCLX.g:1601:1: rule__Constraint__Group__9 : rule__Constraint__Group__9__Impl ;
    public final void rule__Constraint__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1605:1: ( rule__Constraint__Group__9__Impl )
            // InternalOCLX.g:1606:2: rule__Constraint__Group__9__Impl
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
    // InternalOCLX.g:1612:1: rule__Constraint__Group__9__Impl : ( '}' ) ;
    public final void rule__Constraint__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1616:1: ( ( '}' ) )
            // InternalOCLX.g:1617:1: ( '}' )
            {
            // InternalOCLX.g:1617:1: ( '}' )
            // InternalOCLX.g:1618:2: '}'
            {
             before(grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_9()); 
            match(input,42,FOLLOW_2); 
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
    // InternalOCLX.g:1628:1: rule__Constraint__Group_3__0 : rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1 ;
    public final void rule__Constraint__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1632:1: ( rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1 )
            // InternalOCLX.g:1633:2: rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1
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
    // InternalOCLX.g:1640:1: rule__Constraint__Group_3__0__Impl : ( 'description:' ) ;
    public final void rule__Constraint__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1644:1: ( ( 'description:' ) )
            // InternalOCLX.g:1645:1: ( 'description:' )
            {
            // InternalOCLX.g:1645:1: ( 'description:' )
            // InternalOCLX.g:1646:2: 'description:'
            {
             before(grammarAccess.getConstraintAccess().getDescriptionKeyword_3_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalOCLX.g:1655:1: rule__Constraint__Group_3__1 : rule__Constraint__Group_3__1__Impl ;
    public final void rule__Constraint__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1659:1: ( rule__Constraint__Group_3__1__Impl )
            // InternalOCLX.g:1660:2: rule__Constraint__Group_3__1__Impl
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
    // InternalOCLX.g:1666:1: rule__Constraint__Group_3__1__Impl : ( ( rule__Constraint__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Constraint__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1670:1: ( ( ( rule__Constraint__DescriptionAssignment_3_1 ) ) )
            // InternalOCLX.g:1671:1: ( ( rule__Constraint__DescriptionAssignment_3_1 ) )
            {
            // InternalOCLX.g:1671:1: ( ( rule__Constraint__DescriptionAssignment_3_1 ) )
            // InternalOCLX.g:1672:2: ( rule__Constraint__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getConstraintAccess().getDescriptionAssignment_3_1()); 
            // InternalOCLX.g:1673:2: ( rule__Constraint__DescriptionAssignment_3_1 )
            // InternalOCLX.g:1673:3: rule__Constraint__DescriptionAssignment_3_1
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
    // InternalOCLX.g:1682:1: rule__Constraint__Group_4__0 : rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 ;
    public final void rule__Constraint__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1686:1: ( rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 )
            // InternalOCLX.g:1687:2: rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1
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
    // InternalOCLX.g:1694:1: rule__Constraint__Group_4__0__Impl : ( 'is' ) ;
    public final void rule__Constraint__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1698:1: ( ( 'is' ) )
            // InternalOCLX.g:1699:1: ( 'is' )
            {
            // InternalOCLX.g:1699:1: ( 'is' )
            // InternalOCLX.g:1700:2: 'is'
            {
             before(grammarAccess.getConstraintAccess().getIsKeyword_4_0()); 
            match(input,44,FOLLOW_2); 
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
    // InternalOCLX.g:1709:1: rule__Constraint__Group_4__1 : rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2 ;
    public final void rule__Constraint__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1713:1: ( rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2 )
            // InternalOCLX.g:1714:2: rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2
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
    // InternalOCLX.g:1721:1: rule__Constraint__Group_4__1__Impl : ( 'overrulable:' ) ;
    public final void rule__Constraint__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1725:1: ( ( 'overrulable:' ) )
            // InternalOCLX.g:1726:1: ( 'overrulable:' )
            {
            // InternalOCLX.g:1726:1: ( 'overrulable:' )
            // InternalOCLX.g:1727:2: 'overrulable:'
            {
             before(grammarAccess.getConstraintAccess().getOverrulableKeyword_4_1()); 
            match(input,45,FOLLOW_2); 
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
    // InternalOCLX.g:1736:1: rule__Constraint__Group_4__2 : rule__Constraint__Group_4__2__Impl ;
    public final void rule__Constraint__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1740:1: ( rule__Constraint__Group_4__2__Impl )
            // InternalOCLX.g:1741:2: rule__Constraint__Group_4__2__Impl
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
    // InternalOCLX.g:1747:1: rule__Constraint__Group_4__2__Impl : ( ( rule__Constraint__OverrulableAssignment_4_2 ) ) ;
    public final void rule__Constraint__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1751:1: ( ( ( rule__Constraint__OverrulableAssignment_4_2 ) ) )
            // InternalOCLX.g:1752:1: ( ( rule__Constraint__OverrulableAssignment_4_2 ) )
            {
            // InternalOCLX.g:1752:1: ( ( rule__Constraint__OverrulableAssignment_4_2 ) )
            // InternalOCLX.g:1753:2: ( rule__Constraint__OverrulableAssignment_4_2 )
            {
             before(grammarAccess.getConstraintAccess().getOverrulableAssignment_4_2()); 
            // InternalOCLX.g:1754:2: ( rule__Constraint__OverrulableAssignment_4_2 )
            // InternalOCLX.g:1754:3: rule__Constraint__OverrulableAssignment_4_2
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
    // InternalOCLX.g:1763:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1767:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalOCLX.g:1768:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalOCLX.g:1775:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1779:1: ( ( RULE_ID ) )
            // InternalOCLX.g:1780:1: ( RULE_ID )
            {
            // InternalOCLX.g:1780:1: ( RULE_ID )
            // InternalOCLX.g:1781:2: RULE_ID
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
    // InternalOCLX.g:1790:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1794:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalOCLX.g:1795:2: rule__QualifiedName__Group__1__Impl
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
    // InternalOCLX.g:1801:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1805:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalOCLX.g:1806:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalOCLX.g:1806:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalOCLX.g:1807:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalOCLX.g:1808:2: ( rule__QualifiedName__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==26) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalOCLX.g:1808:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalOCLX.g:1817:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1821:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalOCLX.g:1822:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalOCLX.g:1829:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1833:1: ( ( '.' ) )
            // InternalOCLX.g:1834:1: ( '.' )
            {
            // InternalOCLX.g:1834:1: ( '.' )
            // InternalOCLX.g:1835:2: '.'
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
    // InternalOCLX.g:1844:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1848:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalOCLX.g:1849:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalOCLX.g:1855:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1859:1: ( ( RULE_ID ) )
            // InternalOCLX.g:1860:1: ( RULE_ID )
            {
            // InternalOCLX.g:1860:1: ( RULE_ID )
            // InternalOCLX.g:1861:2: RULE_ID
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
    // InternalOCLX.g:1871:1: rule__Exp__Group__0 : rule__Exp__Group__0__Impl rule__Exp__Group__1 ;
    public final void rule__Exp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1875:1: ( rule__Exp__Group__0__Impl rule__Exp__Group__1 )
            // InternalOCLX.g:1876:2: rule__Exp__Group__0__Impl rule__Exp__Group__1
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
    // InternalOCLX.g:1883:1: rule__Exp__Group__0__Impl : ( rulePrefixedExp ) ;
    public final void rule__Exp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1887:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:1888:1: ( rulePrefixedExp )
            {
            // InternalOCLX.g:1888:1: ( rulePrefixedExp )
            // InternalOCLX.g:1889:2: rulePrefixedExp
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
    // InternalOCLX.g:1898:1: rule__Exp__Group__1 : rule__Exp__Group__1__Impl ;
    public final void rule__Exp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1902:1: ( rule__Exp__Group__1__Impl )
            // InternalOCLX.g:1903:2: rule__Exp__Group__1__Impl
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
    // InternalOCLX.g:1909:1: rule__Exp__Group__1__Impl : ( ( rule__Exp__Group_1__0 )? ) ;
    public final void rule__Exp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1913:1: ( ( ( rule__Exp__Group_1__0 )? ) )
            // InternalOCLX.g:1914:1: ( ( rule__Exp__Group_1__0 )? )
            {
            // InternalOCLX.g:1914:1: ( ( rule__Exp__Group_1__0 )? )
            // InternalOCLX.g:1915:2: ( rule__Exp__Group_1__0 )?
            {
             before(grammarAccess.getExpAccess().getGroup_1()); 
            // InternalOCLX.g:1916:2: ( rule__Exp__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=12 && LA21_0<=25)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalOCLX.g:1916:3: rule__Exp__Group_1__0
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
    // InternalOCLX.g:1925:1: rule__Exp__Group_1__0 : rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 ;
    public final void rule__Exp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1929:1: ( rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 )
            // InternalOCLX.g:1930:2: rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1
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
    // InternalOCLX.g:1937:1: rule__Exp__Group_1__0__Impl : ( () ) ;
    public final void rule__Exp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1941:1: ( ( () ) )
            // InternalOCLX.g:1942:1: ( () )
            {
            // InternalOCLX.g:1942:1: ( () )
            // InternalOCLX.g:1943:2: ()
            {
             before(grammarAccess.getExpAccess().getInfixExpExpressionsAction_1_0()); 
            // InternalOCLX.g:1944:2: ()
            // InternalOCLX.g:1944:3: 
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
    // InternalOCLX.g:1952:1: rule__Exp__Group_1__1 : rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2 ;
    public final void rule__Exp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1956:1: ( rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2 )
            // InternalOCLX.g:1957:2: rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2
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
    // InternalOCLX.g:1964:1: rule__Exp__Group_1__1__Impl : ( ( rule__Exp__OperatorsAssignment_1_1 ) ) ;
    public final void rule__Exp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1968:1: ( ( ( rule__Exp__OperatorsAssignment_1_1 ) ) )
            // InternalOCLX.g:1969:1: ( ( rule__Exp__OperatorsAssignment_1_1 ) )
            {
            // InternalOCLX.g:1969:1: ( ( rule__Exp__OperatorsAssignment_1_1 ) )
            // InternalOCLX.g:1970:2: ( rule__Exp__OperatorsAssignment_1_1 )
            {
             before(grammarAccess.getExpAccess().getOperatorsAssignment_1_1()); 
            // InternalOCLX.g:1971:2: ( rule__Exp__OperatorsAssignment_1_1 )
            // InternalOCLX.g:1971:3: rule__Exp__OperatorsAssignment_1_1
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
    // InternalOCLX.g:1979:1: rule__Exp__Group_1__2 : rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3 ;
    public final void rule__Exp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1983:1: ( rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3 )
            // InternalOCLX.g:1984:2: rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3
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
    // InternalOCLX.g:1991:1: rule__Exp__Group_1__2__Impl : ( ( rule__Exp__ExpressionsAssignment_1_2 ) ) ;
    public final void rule__Exp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1995:1: ( ( ( rule__Exp__ExpressionsAssignment_1_2 ) ) )
            // InternalOCLX.g:1996:1: ( ( rule__Exp__ExpressionsAssignment_1_2 ) )
            {
            // InternalOCLX.g:1996:1: ( ( rule__Exp__ExpressionsAssignment_1_2 ) )
            // InternalOCLX.g:1997:2: ( rule__Exp__ExpressionsAssignment_1_2 )
            {
             before(grammarAccess.getExpAccess().getExpressionsAssignment_1_2()); 
            // InternalOCLX.g:1998:2: ( rule__Exp__ExpressionsAssignment_1_2 )
            // InternalOCLX.g:1998:3: rule__Exp__ExpressionsAssignment_1_2
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
    // InternalOCLX.g:2006:1: rule__Exp__Group_1__3 : rule__Exp__Group_1__3__Impl ;
    public final void rule__Exp__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2010:1: ( rule__Exp__Group_1__3__Impl )
            // InternalOCLX.g:2011:2: rule__Exp__Group_1__3__Impl
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
    // InternalOCLX.g:2017:1: rule__Exp__Group_1__3__Impl : ( ( rule__Exp__Group_1_3__0 )* ) ;
    public final void rule__Exp__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2021:1: ( ( ( rule__Exp__Group_1_3__0 )* ) )
            // InternalOCLX.g:2022:1: ( ( rule__Exp__Group_1_3__0 )* )
            {
            // InternalOCLX.g:2022:1: ( ( rule__Exp__Group_1_3__0 )* )
            // InternalOCLX.g:2023:2: ( rule__Exp__Group_1_3__0 )*
            {
             before(grammarAccess.getExpAccess().getGroup_1_3()); 
            // InternalOCLX.g:2024:2: ( rule__Exp__Group_1_3__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=12 && LA22_0<=25)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalOCLX.g:2024:3: rule__Exp__Group_1_3__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Exp__Group_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalOCLX.g:2033:1: rule__Exp__Group_1_3__0 : rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1 ;
    public final void rule__Exp__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2037:1: ( rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1 )
            // InternalOCLX.g:2038:2: rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1
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
    // InternalOCLX.g:2045:1: rule__Exp__Group_1_3__0__Impl : ( ( rule__Exp__OperatorsAssignment_1_3_0 ) ) ;
    public final void rule__Exp__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2049:1: ( ( ( rule__Exp__OperatorsAssignment_1_3_0 ) ) )
            // InternalOCLX.g:2050:1: ( ( rule__Exp__OperatorsAssignment_1_3_0 ) )
            {
            // InternalOCLX.g:2050:1: ( ( rule__Exp__OperatorsAssignment_1_3_0 ) )
            // InternalOCLX.g:2051:2: ( rule__Exp__OperatorsAssignment_1_3_0 )
            {
             before(grammarAccess.getExpAccess().getOperatorsAssignment_1_3_0()); 
            // InternalOCLX.g:2052:2: ( rule__Exp__OperatorsAssignment_1_3_0 )
            // InternalOCLX.g:2052:3: rule__Exp__OperatorsAssignment_1_3_0
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
    // InternalOCLX.g:2060:1: rule__Exp__Group_1_3__1 : rule__Exp__Group_1_3__1__Impl ;
    public final void rule__Exp__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2064:1: ( rule__Exp__Group_1_3__1__Impl )
            // InternalOCLX.g:2065:2: rule__Exp__Group_1_3__1__Impl
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
    // InternalOCLX.g:2071:1: rule__Exp__Group_1_3__1__Impl : ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) ) ;
    public final void rule__Exp__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2075:1: ( ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) ) )
            // InternalOCLX.g:2076:1: ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) )
            {
            // InternalOCLX.g:2076:1: ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) )
            // InternalOCLX.g:2077:2: ( rule__Exp__ExpressionsAssignment_1_3_1 )
            {
             before(grammarAccess.getExpAccess().getExpressionsAssignment_1_3_1()); 
            // InternalOCLX.g:2078:2: ( rule__Exp__ExpressionsAssignment_1_3_1 )
            // InternalOCLX.g:2078:3: rule__Exp__ExpressionsAssignment_1_3_1
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
    // InternalOCLX.g:2087:1: rule__PrefixedExp__Group_0__0 : rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1 ;
    public final void rule__PrefixedExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2091:1: ( rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1 )
            // InternalOCLX.g:2092:2: rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1
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
    // InternalOCLX.g:2099:1: rule__PrefixedExp__Group_0__0__Impl : ( () ) ;
    public final void rule__PrefixedExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2103:1: ( ( () ) )
            // InternalOCLX.g:2104:1: ( () )
            {
            // InternalOCLX.g:2104:1: ( () )
            // InternalOCLX.g:2105:2: ()
            {
             before(grammarAccess.getPrefixedExpAccess().getPrefixExpAction_0_0()); 
            // InternalOCLX.g:2106:2: ()
            // InternalOCLX.g:2106:3: 
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
    // InternalOCLX.g:2114:1: rule__PrefixedExp__Group_0__1 : rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2 ;
    public final void rule__PrefixedExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2118:1: ( rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2 )
            // InternalOCLX.g:2119:2: rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2
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
    // InternalOCLX.g:2126:1: rule__PrefixedExp__Group_0__1__Impl : ( ( ( rule__PrefixedExp__OperatorsAssignment_0_1 ) ) ( ( rule__PrefixedExp__OperatorsAssignment_0_1 )* ) ) ;
    public final void rule__PrefixedExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2130:1: ( ( ( ( rule__PrefixedExp__OperatorsAssignment_0_1 ) ) ( ( rule__PrefixedExp__OperatorsAssignment_0_1 )* ) ) )
            // InternalOCLX.g:2131:1: ( ( ( rule__PrefixedExp__OperatorsAssignment_0_1 ) ) ( ( rule__PrefixedExp__OperatorsAssignment_0_1 )* ) )
            {
            // InternalOCLX.g:2131:1: ( ( ( rule__PrefixedExp__OperatorsAssignment_0_1 ) ) ( ( rule__PrefixedExp__OperatorsAssignment_0_1 )* ) )
            // InternalOCLX.g:2132:2: ( ( rule__PrefixedExp__OperatorsAssignment_0_1 ) ) ( ( rule__PrefixedExp__OperatorsAssignment_0_1 )* )
            {
            // InternalOCLX.g:2132:2: ( ( rule__PrefixedExp__OperatorsAssignment_0_1 ) )
            // InternalOCLX.g:2133:3: ( rule__PrefixedExp__OperatorsAssignment_0_1 )
            {
             before(grammarAccess.getPrefixedExpAccess().getOperatorsAssignment_0_1()); 
            // InternalOCLX.g:2134:3: ( rule__PrefixedExp__OperatorsAssignment_0_1 )
            // InternalOCLX.g:2134:4: rule__PrefixedExp__OperatorsAssignment_0_1
            {
            pushFollow(FOLLOW_18);
            rule__PrefixedExp__OperatorsAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getPrefixedExpAccess().getOperatorsAssignment_0_1()); 

            }

            // InternalOCLX.g:2137:2: ( ( rule__PrefixedExp__OperatorsAssignment_0_1 )* )
            // InternalOCLX.g:2138:3: ( rule__PrefixedExp__OperatorsAssignment_0_1 )*
            {
             before(grammarAccess.getPrefixedExpAccess().getOperatorsAssignment_0_1()); 
            // InternalOCLX.g:2139:3: ( rule__PrefixedExp__OperatorsAssignment_0_1 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==25||LA23_0==28) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalOCLX.g:2139:4: rule__PrefixedExp__OperatorsAssignment_0_1
            	    {
            	    pushFollow(FOLLOW_18);
            	    rule__PrefixedExp__OperatorsAssignment_0_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getPrefixedExpAccess().getOperatorsAssignment_0_1()); 

            }


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
    // InternalOCLX.g:2148:1: rule__PrefixedExp__Group_0__2 : rule__PrefixedExp__Group_0__2__Impl ;
    public final void rule__PrefixedExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2152:1: ( rule__PrefixedExp__Group_0__2__Impl )
            // InternalOCLX.g:2153:2: rule__PrefixedExp__Group_0__2__Impl
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
    // InternalOCLX.g:2159:1: rule__PrefixedExp__Group_0__2__Impl : ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) ) ;
    public final void rule__PrefixedExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2163:1: ( ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) ) )
            // InternalOCLX.g:2164:1: ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) )
            {
            // InternalOCLX.g:2164:1: ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) )
            // InternalOCLX.g:2165:2: ( rule__PrefixedExp__ExpressionAssignment_0_2 )
            {
             before(grammarAccess.getPrefixedExpAccess().getExpressionAssignment_0_2()); 
            // InternalOCLX.g:2166:2: ( rule__PrefixedExp__ExpressionAssignment_0_2 )
            // InternalOCLX.g:2166:3: rule__PrefixedExp__ExpressionAssignment_0_2
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
    // InternalOCLX.g:2175:1: rule__PrimaryExp__Group_1__0 : rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1 ;
    public final void rule__PrimaryExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2179:1: ( rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1 )
            // InternalOCLX.g:2180:2: rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:2187:1: rule__PrimaryExp__Group_1__0__Impl : ( ruleVarOrSelfExp ) ;
    public final void rule__PrimaryExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2191:1: ( ( ruleVarOrSelfExp ) )
            // InternalOCLX.g:2192:1: ( ruleVarOrSelfExp )
            {
            // InternalOCLX.g:2192:1: ( ruleVarOrSelfExp )
            // InternalOCLX.g:2193:2: ruleVarOrSelfExp
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
    // InternalOCLX.g:2202:1: rule__PrimaryExp__Group_1__1 : rule__PrimaryExp__Group_1__1__Impl ;
    public final void rule__PrimaryExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2206:1: ( rule__PrimaryExp__Group_1__1__Impl )
            // InternalOCLX.g:2207:2: rule__PrimaryExp__Group_1__1__Impl
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
    // InternalOCLX.g:2213:1: rule__PrimaryExp__Group_1__1__Impl : ( ( rule__PrimaryExp__Group_1_1__0 )* ) ;
    public final void rule__PrimaryExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2217:1: ( ( ( rule__PrimaryExp__Group_1_1__0 )* ) )
            // InternalOCLX.g:2218:1: ( ( rule__PrimaryExp__Group_1_1__0 )* )
            {
            // InternalOCLX.g:2218:1: ( ( rule__PrimaryExp__Group_1_1__0 )* )
            // InternalOCLX.g:2219:2: ( rule__PrimaryExp__Group_1_1__0 )*
            {
             before(grammarAccess.getPrimaryExpAccess().getGroup_1_1()); 
            // InternalOCLX.g:2220:2: ( rule__PrimaryExp__Group_1_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=26 && LA24_0<=27)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalOCLX.g:2220:3: rule__PrimaryExp__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__PrimaryExp__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalOCLX.g:2229:1: rule__PrimaryExp__Group_1_1__0 : rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1 ;
    public final void rule__PrimaryExp__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2233:1: ( rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1 )
            // InternalOCLX.g:2234:2: rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1
            {
            pushFollow(FOLLOW_21);
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
    // InternalOCLX.g:2241:1: rule__PrimaryExp__Group_1_1__0__Impl : ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) ) ;
    public final void rule__PrimaryExp__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2245:1: ( ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) ) )
            // InternalOCLX.g:2246:1: ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) )
            {
            // InternalOCLX.g:2246:1: ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) )
            // InternalOCLX.g:2247:2: ( rule__PrimaryExp__NavAssignment_1_1_0 )
            {
             before(grammarAccess.getPrimaryExpAccess().getNavAssignment_1_1_0()); 
            // InternalOCLX.g:2248:2: ( rule__PrimaryExp__NavAssignment_1_1_0 )
            // InternalOCLX.g:2248:3: rule__PrimaryExp__NavAssignment_1_1_0
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
    // InternalOCLX.g:2256:1: rule__PrimaryExp__Group_1_1__1 : rule__PrimaryExp__Group_1_1__1__Impl ;
    public final void rule__PrimaryExp__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2260:1: ( rule__PrimaryExp__Group_1_1__1__Impl )
            // InternalOCLX.g:2261:2: rule__PrimaryExp__Group_1_1__1__Impl
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
    // InternalOCLX.g:2267:1: rule__PrimaryExp__Group_1_1__1__Impl : ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) ) ;
    public final void rule__PrimaryExp__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2271:1: ( ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) ) )
            // InternalOCLX.g:2272:1: ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) )
            {
            // InternalOCLX.g:2272:1: ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) )
            // InternalOCLX.g:2273:2: ( rule__PrimaryExp__MethodsAssignment_1_1_1 )
            {
             before(grammarAccess.getPrimaryExpAccess().getMethodsAssignment_1_1_1()); 
            // InternalOCLX.g:2274:2: ( rule__PrimaryExp__MethodsAssignment_1_1_1 )
            // InternalOCLX.g:2274:3: rule__PrimaryExp__MethodsAssignment_1_1_1
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
    // InternalOCLX.g:2283:1: rule__NestedExp__Group__0 : rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 ;
    public final void rule__NestedExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2287:1: ( rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 )
            // InternalOCLX.g:2288:2: rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1
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
    // InternalOCLX.g:2295:1: rule__NestedExp__Group__0__Impl : ( '(' ) ;
    public final void rule__NestedExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2299:1: ( ( '(' ) )
            // InternalOCLX.g:2300:1: ( '(' )
            {
            // InternalOCLX.g:2300:1: ( '(' )
            // InternalOCLX.g:2301:2: '('
            {
             before(grammarAccess.getNestedExpAccess().getLeftParenthesisKeyword_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalOCLX.g:2310:1: rule__NestedExp__Group__1 : rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 ;
    public final void rule__NestedExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2314:1: ( rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 )
            // InternalOCLX.g:2315:2: rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:2322:1: rule__NestedExp__Group__1__Impl : ( ( rule__NestedExp__SourceAssignment_1 ) ) ;
    public final void rule__NestedExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2326:1: ( ( ( rule__NestedExp__SourceAssignment_1 ) ) )
            // InternalOCLX.g:2327:1: ( ( rule__NestedExp__SourceAssignment_1 ) )
            {
            // InternalOCLX.g:2327:1: ( ( rule__NestedExp__SourceAssignment_1 ) )
            // InternalOCLX.g:2328:2: ( rule__NestedExp__SourceAssignment_1 )
            {
             before(grammarAccess.getNestedExpAccess().getSourceAssignment_1()); 
            // InternalOCLX.g:2329:2: ( rule__NestedExp__SourceAssignment_1 )
            // InternalOCLX.g:2329:3: rule__NestedExp__SourceAssignment_1
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
    // InternalOCLX.g:2337:1: rule__NestedExp__Group__2 : rule__NestedExp__Group__2__Impl ;
    public final void rule__NestedExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2341:1: ( rule__NestedExp__Group__2__Impl )
            // InternalOCLX.g:2342:2: rule__NestedExp__Group__2__Impl
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
    // InternalOCLX.g:2348:1: rule__NestedExp__Group__2__Impl : ( ')' ) ;
    public final void rule__NestedExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2352:1: ( ( ')' ) )
            // InternalOCLX.g:2353:1: ( ')' )
            {
            // InternalOCLX.g:2353:1: ( ')' )
            // InternalOCLX.g:2354:2: ')'
            {
             before(grammarAccess.getNestedExpAccess().getRightParenthesisKeyword_2()); 
            match(input,47,FOLLOW_2); 
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
    // InternalOCLX.g:2364:1: rule__SelfExp__Group__0 : rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1 ;
    public final void rule__SelfExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2368:1: ( rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1 )
            // InternalOCLX.g:2369:2: rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1
            {
            pushFollow(FOLLOW_23);
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
    // InternalOCLX.g:2376:1: rule__SelfExp__Group__0__Impl : ( () ) ;
    public final void rule__SelfExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2380:1: ( ( () ) )
            // InternalOCLX.g:2381:1: ( () )
            {
            // InternalOCLX.g:2381:1: ( () )
            // InternalOCLX.g:2382:2: ()
            {
             before(grammarAccess.getSelfExpAccess().getSelfExpAction_0()); 
            // InternalOCLX.g:2383:2: ()
            // InternalOCLX.g:2383:3: 
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
    // InternalOCLX.g:2391:1: rule__SelfExp__Group__1 : rule__SelfExp__Group__1__Impl ;
    public final void rule__SelfExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2395:1: ( rule__SelfExp__Group__1__Impl )
            // InternalOCLX.g:2396:2: rule__SelfExp__Group__1__Impl
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
    // InternalOCLX.g:2402:1: rule__SelfExp__Group__1__Impl : ( ( rule__SelfExp__NameAssignment_1 ) ) ;
    public final void rule__SelfExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2406:1: ( ( ( rule__SelfExp__NameAssignment_1 ) ) )
            // InternalOCLX.g:2407:1: ( ( rule__SelfExp__NameAssignment_1 ) )
            {
            // InternalOCLX.g:2407:1: ( ( rule__SelfExp__NameAssignment_1 ) )
            // InternalOCLX.g:2408:2: ( rule__SelfExp__NameAssignment_1 )
            {
             before(grammarAccess.getSelfExpAccess().getNameAssignment_1()); 
            // InternalOCLX.g:2409:2: ( rule__SelfExp__NameAssignment_1 )
            // InternalOCLX.g:2409:3: rule__SelfExp__NameAssignment_1
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
    // InternalOCLX.g:2418:1: rule__NullLiteralExp__Group__0 : rule__NullLiteralExp__Group__0__Impl rule__NullLiteralExp__Group__1 ;
    public final void rule__NullLiteralExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2422:1: ( rule__NullLiteralExp__Group__0__Impl rule__NullLiteralExp__Group__1 )
            // InternalOCLX.g:2423:2: rule__NullLiteralExp__Group__0__Impl rule__NullLiteralExp__Group__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalOCLX.g:2430:1: rule__NullLiteralExp__Group__0__Impl : ( () ) ;
    public final void rule__NullLiteralExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2434:1: ( ( () ) )
            // InternalOCLX.g:2435:1: ( () )
            {
            // InternalOCLX.g:2435:1: ( () )
            // InternalOCLX.g:2436:2: ()
            {
             before(grammarAccess.getNullLiteralExpAccess().getNullLiteralExpCSAction_0()); 
            // InternalOCLX.g:2437:2: ()
            // InternalOCLX.g:2437:3: 
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
    // InternalOCLX.g:2445:1: rule__NullLiteralExp__Group__1 : rule__NullLiteralExp__Group__1__Impl ;
    public final void rule__NullLiteralExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2449:1: ( rule__NullLiteralExp__Group__1__Impl )
            // InternalOCLX.g:2450:2: rule__NullLiteralExp__Group__1__Impl
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
    // InternalOCLX.g:2456:1: rule__NullLiteralExp__Group__1__Impl : ( 'null' ) ;
    public final void rule__NullLiteralExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2460:1: ( ( 'null' ) )
            // InternalOCLX.g:2461:1: ( 'null' )
            {
            // InternalOCLX.g:2461:1: ( 'null' )
            // InternalOCLX.g:2462:2: 'null'
            {
             before(grammarAccess.getNullLiteralExpAccess().getNullKeyword_1()); 
            match(input,48,FOLLOW_2); 
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
    // InternalOCLX.g:2472:1: rule__CollectionIterator__Group__0 : rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 ;
    public final void rule__CollectionIterator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2476:1: ( rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 )
            // InternalOCLX.g:2477:2: rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1
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
    // InternalOCLX.g:2484:1: rule__CollectionIterator__Group__0__Impl : ( ( rule__CollectionIterator__NameAssignment_0 ) ) ;
    public final void rule__CollectionIterator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2488:1: ( ( ( rule__CollectionIterator__NameAssignment_0 ) ) )
            // InternalOCLX.g:2489:1: ( ( rule__CollectionIterator__NameAssignment_0 ) )
            {
            // InternalOCLX.g:2489:1: ( ( rule__CollectionIterator__NameAssignment_0 ) )
            // InternalOCLX.g:2490:2: ( rule__CollectionIterator__NameAssignment_0 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getNameAssignment_0()); 
            // InternalOCLX.g:2491:2: ( rule__CollectionIterator__NameAssignment_0 )
            // InternalOCLX.g:2491:3: rule__CollectionIterator__NameAssignment_0
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
    // InternalOCLX.g:2499:1: rule__CollectionIterator__Group__1 : rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 ;
    public final void rule__CollectionIterator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2503:1: ( rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 )
            // InternalOCLX.g:2504:2: rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2
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
    // InternalOCLX.g:2511:1: rule__CollectionIterator__Group__1__Impl : ( '(' ) ;
    public final void rule__CollectionIterator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2515:1: ( ( '(' ) )
            // InternalOCLX.g:2516:1: ( '(' )
            {
            // InternalOCLX.g:2516:1: ( '(' )
            // InternalOCLX.g:2517:2: '('
            {
             before(grammarAccess.getCollectionIteratorAccess().getLeftParenthesisKeyword_1()); 
            match(input,46,FOLLOW_2); 
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
    // InternalOCLX.g:2526:1: rule__CollectionIterator__Group__2 : rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 ;
    public final void rule__CollectionIterator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2530:1: ( rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 )
            // InternalOCLX.g:2531:2: rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3
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
    // InternalOCLX.g:2538:1: rule__CollectionIterator__Group__2__Impl : ( ( rule__CollectionIterator__ItervarAssignment_2 ) ) ;
    public final void rule__CollectionIterator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2542:1: ( ( ( rule__CollectionIterator__ItervarAssignment_2 ) ) )
            // InternalOCLX.g:2543:1: ( ( rule__CollectionIterator__ItervarAssignment_2 ) )
            {
            // InternalOCLX.g:2543:1: ( ( rule__CollectionIterator__ItervarAssignment_2 ) )
            // InternalOCLX.g:2544:2: ( rule__CollectionIterator__ItervarAssignment_2 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getItervarAssignment_2()); 
            // InternalOCLX.g:2545:2: ( rule__CollectionIterator__ItervarAssignment_2 )
            // InternalOCLX.g:2545:3: rule__CollectionIterator__ItervarAssignment_2
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
    // InternalOCLX.g:2553:1: rule__CollectionIterator__Group__3 : rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4 ;
    public final void rule__CollectionIterator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2557:1: ( rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4 )
            // InternalOCLX.g:2558:2: rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4
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
    // InternalOCLX.g:2565:1: rule__CollectionIterator__Group__3__Impl : ( '|' ) ;
    public final void rule__CollectionIterator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2569:1: ( ( '|' ) )
            // InternalOCLX.g:2570:1: ( '|' )
            {
            // InternalOCLX.g:2570:1: ( '|' )
            // InternalOCLX.g:2571:2: '|'
            {
             before(grammarAccess.getCollectionIteratorAccess().getVerticalLineKeyword_3()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:2580:1: rule__CollectionIterator__Group__4 : rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5 ;
    public final void rule__CollectionIterator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2584:1: ( rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5 )
            // InternalOCLX.g:2585:2: rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:2592:1: rule__CollectionIterator__Group__4__Impl : ( ( rule__CollectionIterator__BodyAssignment_4 ) ) ;
    public final void rule__CollectionIterator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2596:1: ( ( ( rule__CollectionIterator__BodyAssignment_4 ) ) )
            // InternalOCLX.g:2597:1: ( ( rule__CollectionIterator__BodyAssignment_4 ) )
            {
            // InternalOCLX.g:2597:1: ( ( rule__CollectionIterator__BodyAssignment_4 ) )
            // InternalOCLX.g:2598:2: ( rule__CollectionIterator__BodyAssignment_4 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getBodyAssignment_4()); 
            // InternalOCLX.g:2599:2: ( rule__CollectionIterator__BodyAssignment_4 )
            // InternalOCLX.g:2599:3: rule__CollectionIterator__BodyAssignment_4
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
    // InternalOCLX.g:2607:1: rule__CollectionIterator__Group__5 : rule__CollectionIterator__Group__5__Impl ;
    public final void rule__CollectionIterator__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2611:1: ( rule__CollectionIterator__Group__5__Impl )
            // InternalOCLX.g:2612:2: rule__CollectionIterator__Group__5__Impl
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
    // InternalOCLX.g:2618:1: rule__CollectionIterator__Group__5__Impl : ( ')' ) ;
    public final void rule__CollectionIterator__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2622:1: ( ( ')' ) )
            // InternalOCLX.g:2623:1: ( ')' )
            {
            // InternalOCLX.g:2623:1: ( ')' )
            // InternalOCLX.g:2624:2: ')'
            {
             before(grammarAccess.getCollectionIteratorAccess().getRightParenthesisKeyword_5()); 
            match(input,47,FOLLOW_2); 
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
    // InternalOCLX.g:2634:1: rule__IteratorVarDeclaration__Group_1__0 : rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1 ;
    public final void rule__IteratorVarDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2638:1: ( rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1 )
            // InternalOCLX.g:2639:2: rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1
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
    // InternalOCLX.g:2646:1: rule__IteratorVarDeclaration__Group_1__0__Impl : ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) ) ;
    public final void rule__IteratorVarDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2650:1: ( ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) ) )
            // InternalOCLX.g:2651:1: ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) )
            {
            // InternalOCLX.g:2651:1: ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) )
            // InternalOCLX.g:2652:2: ( rule__IteratorVarDeclaration__NameAssignment_1_0 )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_1_0()); 
            // InternalOCLX.g:2653:2: ( rule__IteratorVarDeclaration__NameAssignment_1_0 )
            // InternalOCLX.g:2653:3: rule__IteratorVarDeclaration__NameAssignment_1_0
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
    // InternalOCLX.g:2661:1: rule__IteratorVarDeclaration__Group_1__1 : rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2 ;
    public final void rule__IteratorVarDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2665:1: ( rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2 )
            // InternalOCLX.g:2666:2: rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2
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
    // InternalOCLX.g:2673:1: rule__IteratorVarDeclaration__Group_1__1__Impl : ( ':' ) ;
    public final void rule__IteratorVarDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2677:1: ( ( ':' ) )
            // InternalOCLX.g:2678:1: ( ':' )
            {
            // InternalOCLX.g:2678:1: ( ':' )
            // InternalOCLX.g:2679:2: ':'
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getColonKeyword_1_1()); 
            match(input,50,FOLLOW_2); 
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
    // InternalOCLX.g:2688:1: rule__IteratorVarDeclaration__Group_1__2 : rule__IteratorVarDeclaration__Group_1__2__Impl ;
    public final void rule__IteratorVarDeclaration__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2692:1: ( rule__IteratorVarDeclaration__Group_1__2__Impl )
            // InternalOCLX.g:2693:2: rule__IteratorVarDeclaration__Group_1__2__Impl
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
    // InternalOCLX.g:2699:1: rule__IteratorVarDeclaration__Group_1__2__Impl : ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) ) ;
    public final void rule__IteratorVarDeclaration__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2703:1: ( ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) ) )
            // InternalOCLX.g:2704:1: ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) )
            {
            // InternalOCLX.g:2704:1: ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) )
            // InternalOCLX.g:2705:2: ( rule__IteratorVarDeclaration__TypeAssignment_1_2 )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getTypeAssignment_1_2()); 
            // InternalOCLX.g:2706:2: ( rule__IteratorVarDeclaration__TypeAssignment_1_2 )
            // InternalOCLX.g:2706:3: rule__IteratorVarDeclaration__TypeAssignment_1_2
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
    // InternalOCLX.g:2715:1: rule__MethodCall__Group_0__0 : rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1 ;
    public final void rule__MethodCall__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2719:1: ( rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1 )
            // InternalOCLX.g:2720:2: rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1
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
    // InternalOCLX.g:2727:1: rule__MethodCall__Group_0__0__Impl : ( ( rule__MethodCall__NameAssignment_0_0 ) ) ;
    public final void rule__MethodCall__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2731:1: ( ( ( rule__MethodCall__NameAssignment_0_0 ) ) )
            // InternalOCLX.g:2732:1: ( ( rule__MethodCall__NameAssignment_0_0 ) )
            {
            // InternalOCLX.g:2732:1: ( ( rule__MethodCall__NameAssignment_0_0 ) )
            // InternalOCLX.g:2733:2: ( rule__MethodCall__NameAssignment_0_0 )
            {
             before(grammarAccess.getMethodCallAccess().getNameAssignment_0_0()); 
            // InternalOCLX.g:2734:2: ( rule__MethodCall__NameAssignment_0_0 )
            // InternalOCLX.g:2734:3: rule__MethodCall__NameAssignment_0_0
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
    // InternalOCLX.g:2742:1: rule__MethodCall__Group_0__1 : rule__MethodCall__Group_0__1__Impl ;
    public final void rule__MethodCall__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2746:1: ( rule__MethodCall__Group_0__1__Impl )
            // InternalOCLX.g:2747:2: rule__MethodCall__Group_0__1__Impl
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
    // InternalOCLX.g:2753:1: rule__MethodCall__Group_0__1__Impl : ( '()' ) ;
    public final void rule__MethodCall__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2757:1: ( ( '()' ) )
            // InternalOCLX.g:2758:1: ( '()' )
            {
            // InternalOCLX.g:2758:1: ( '()' )
            // InternalOCLX.g:2759:2: '()'
            {
             before(grammarAccess.getMethodCallAccess().getLeftParenthesisRightParenthesisKeyword_0_1()); 
            match(input,51,FOLLOW_2); 
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
    // InternalOCLX.g:2769:1: rule__MethodCall__Group_1__0 : rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1 ;
    public final void rule__MethodCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2773:1: ( rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1 )
            // InternalOCLX.g:2774:2: rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1
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
    // InternalOCLX.g:2781:1: rule__MethodCall__Group_1__0__Impl : ( ( rule__MethodCall__NameAssignment_1_0 ) ) ;
    public final void rule__MethodCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2785:1: ( ( ( rule__MethodCall__NameAssignment_1_0 ) ) )
            // InternalOCLX.g:2786:1: ( ( rule__MethodCall__NameAssignment_1_0 ) )
            {
            // InternalOCLX.g:2786:1: ( ( rule__MethodCall__NameAssignment_1_0 ) )
            // InternalOCLX.g:2787:2: ( rule__MethodCall__NameAssignment_1_0 )
            {
             before(grammarAccess.getMethodCallAccess().getNameAssignment_1_0()); 
            // InternalOCLX.g:2788:2: ( rule__MethodCall__NameAssignment_1_0 )
            // InternalOCLX.g:2788:3: rule__MethodCall__NameAssignment_1_0
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
    // InternalOCLX.g:2796:1: rule__MethodCall__Group_1__1 : rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2 ;
    public final void rule__MethodCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2800:1: ( rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2 )
            // InternalOCLX.g:2801:2: rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2
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
    // InternalOCLX.g:2808:1: rule__MethodCall__Group_1__1__Impl : ( '(' ) ;
    public final void rule__MethodCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2812:1: ( ( '(' ) )
            // InternalOCLX.g:2813:1: ( '(' )
            {
            // InternalOCLX.g:2813:1: ( '(' )
            // InternalOCLX.g:2814:2: '('
            {
             before(grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_1_1()); 
            match(input,46,FOLLOW_2); 
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
    // InternalOCLX.g:2823:1: rule__MethodCall__Group_1__2 : rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3 ;
    public final void rule__MethodCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2827:1: ( rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3 )
            // InternalOCLX.g:2828:2: rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:2835:1: rule__MethodCall__Group_1__2__Impl : ( ( rule__MethodCall__ArgsAssignment_1_2 ) ) ;
    public final void rule__MethodCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2839:1: ( ( ( rule__MethodCall__ArgsAssignment_1_2 ) ) )
            // InternalOCLX.g:2840:1: ( ( rule__MethodCall__ArgsAssignment_1_2 ) )
            {
            // InternalOCLX.g:2840:1: ( ( rule__MethodCall__ArgsAssignment_1_2 ) )
            // InternalOCLX.g:2841:2: ( rule__MethodCall__ArgsAssignment_1_2 )
            {
             before(grammarAccess.getMethodCallAccess().getArgsAssignment_1_2()); 
            // InternalOCLX.g:2842:2: ( rule__MethodCall__ArgsAssignment_1_2 )
            // InternalOCLX.g:2842:3: rule__MethodCall__ArgsAssignment_1_2
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
    // InternalOCLX.g:2850:1: rule__MethodCall__Group_1__3 : rule__MethodCall__Group_1__3__Impl ;
    public final void rule__MethodCall__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2854:1: ( rule__MethodCall__Group_1__3__Impl )
            // InternalOCLX.g:2855:2: rule__MethodCall__Group_1__3__Impl
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
    // InternalOCLX.g:2861:1: rule__MethodCall__Group_1__3__Impl : ( ')' ) ;
    public final void rule__MethodCall__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2865:1: ( ( ')' ) )
            // InternalOCLX.g:2866:1: ( ')' )
            {
            // InternalOCLX.g:2866:1: ( ')' )
            // InternalOCLX.g:2867:2: ')'
            {
             before(grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_1_3()); 
            match(input,47,FOLLOW_2); 
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


    // $ANTLR start "rule__MethodCall__Group_2__0"
    // InternalOCLX.g:2877:1: rule__MethodCall__Group_2__0 : rule__MethodCall__Group_2__0__Impl rule__MethodCall__Group_2__1 ;
    public final void rule__MethodCall__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2881:1: ( rule__MethodCall__Group_2__0__Impl rule__MethodCall__Group_2__1 )
            // InternalOCLX.g:2882:2: rule__MethodCall__Group_2__0__Impl rule__MethodCall__Group_2__1
            {
            pushFollow(FOLLOW_24);
            rule__MethodCall__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MethodCall__Group_2__1();

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
    // $ANTLR end "rule__MethodCall__Group_2__0"


    // $ANTLR start "rule__MethodCall__Group_2__0__Impl"
    // InternalOCLX.g:2889:1: rule__MethodCall__Group_2__0__Impl : ( ( rule__MethodCall__NameAssignment_2_0 ) ) ;
    public final void rule__MethodCall__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2893:1: ( ( ( rule__MethodCall__NameAssignment_2_0 ) ) )
            // InternalOCLX.g:2894:1: ( ( rule__MethodCall__NameAssignment_2_0 ) )
            {
            // InternalOCLX.g:2894:1: ( ( rule__MethodCall__NameAssignment_2_0 ) )
            // InternalOCLX.g:2895:2: ( rule__MethodCall__NameAssignment_2_0 )
            {
             before(grammarAccess.getMethodCallAccess().getNameAssignment_2_0()); 
            // InternalOCLX.g:2896:2: ( rule__MethodCall__NameAssignment_2_0 )
            // InternalOCLX.g:2896:3: rule__MethodCall__NameAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__MethodCall__NameAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getMethodCallAccess().getNameAssignment_2_0()); 

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
    // $ANTLR end "rule__MethodCall__Group_2__0__Impl"


    // $ANTLR start "rule__MethodCall__Group_2__1"
    // InternalOCLX.g:2904:1: rule__MethodCall__Group_2__1 : rule__MethodCall__Group_2__1__Impl rule__MethodCall__Group_2__2 ;
    public final void rule__MethodCall__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2908:1: ( rule__MethodCall__Group_2__1__Impl rule__MethodCall__Group_2__2 )
            // InternalOCLX.g:2909:2: rule__MethodCall__Group_2__1__Impl rule__MethodCall__Group_2__2
            {
            pushFollow(FOLLOW_27);
            rule__MethodCall__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MethodCall__Group_2__2();

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
    // $ANTLR end "rule__MethodCall__Group_2__1"


    // $ANTLR start "rule__MethodCall__Group_2__1__Impl"
    // InternalOCLX.g:2916:1: rule__MethodCall__Group_2__1__Impl : ( '(' ) ;
    public final void rule__MethodCall__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2920:1: ( ( '(' ) )
            // InternalOCLX.g:2921:1: ( '(' )
            {
            // InternalOCLX.g:2921:1: ( '(' )
            // InternalOCLX.g:2922:2: '('
            {
             before(grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_2_1()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_2_1()); 

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
    // $ANTLR end "rule__MethodCall__Group_2__1__Impl"


    // $ANTLR start "rule__MethodCall__Group_2__2"
    // InternalOCLX.g:2931:1: rule__MethodCall__Group_2__2 : rule__MethodCall__Group_2__2__Impl rule__MethodCall__Group_2__3 ;
    public final void rule__MethodCall__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2935:1: ( rule__MethodCall__Group_2__2__Impl rule__MethodCall__Group_2__3 )
            // InternalOCLX.g:2936:2: rule__MethodCall__Group_2__2__Impl rule__MethodCall__Group_2__3
            {
            pushFollow(FOLLOW_22);
            rule__MethodCall__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MethodCall__Group_2__3();

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
    // $ANTLR end "rule__MethodCall__Group_2__2"


    // $ANTLR start "rule__MethodCall__Group_2__2__Impl"
    // InternalOCLX.g:2943:1: rule__MethodCall__Group_2__2__Impl : ( ( rule__MethodCall__TypeAssignment_2_2 ) ) ;
    public final void rule__MethodCall__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2947:1: ( ( ( rule__MethodCall__TypeAssignment_2_2 ) ) )
            // InternalOCLX.g:2948:1: ( ( rule__MethodCall__TypeAssignment_2_2 ) )
            {
            // InternalOCLX.g:2948:1: ( ( rule__MethodCall__TypeAssignment_2_2 ) )
            // InternalOCLX.g:2949:2: ( rule__MethodCall__TypeAssignment_2_2 )
            {
             before(grammarAccess.getMethodCallAccess().getTypeAssignment_2_2()); 
            // InternalOCLX.g:2950:2: ( rule__MethodCall__TypeAssignment_2_2 )
            // InternalOCLX.g:2950:3: rule__MethodCall__TypeAssignment_2_2
            {
            pushFollow(FOLLOW_2);
            rule__MethodCall__TypeAssignment_2_2();

            state._fsp--;


            }

             after(grammarAccess.getMethodCallAccess().getTypeAssignment_2_2()); 

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
    // $ANTLR end "rule__MethodCall__Group_2__2__Impl"


    // $ANTLR start "rule__MethodCall__Group_2__3"
    // InternalOCLX.g:2958:1: rule__MethodCall__Group_2__3 : rule__MethodCall__Group_2__3__Impl ;
    public final void rule__MethodCall__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2962:1: ( rule__MethodCall__Group_2__3__Impl )
            // InternalOCLX.g:2963:2: rule__MethodCall__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MethodCall__Group_2__3__Impl();

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
    // $ANTLR end "rule__MethodCall__Group_2__3"


    // $ANTLR start "rule__MethodCall__Group_2__3__Impl"
    // InternalOCLX.g:2969:1: rule__MethodCall__Group_2__3__Impl : ( ')' ) ;
    public final void rule__MethodCall__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2973:1: ( ( ')' ) )
            // InternalOCLX.g:2974:1: ( ')' )
            {
            // InternalOCLX.g:2974:1: ( ')' )
            // InternalOCLX.g:2975:2: ')'
            {
             before(grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_2_3()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_2_3()); 

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
    // $ANTLR end "rule__MethodCall__Group_2__3__Impl"


    // $ANTLR start "rule__TypeExp__Group_0__0"
    // InternalOCLX.g:2985:1: rule__TypeExp__Group_0__0 : rule__TypeExp__Group_0__0__Impl rule__TypeExp__Group_0__1 ;
    public final void rule__TypeExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2989:1: ( rule__TypeExp__Group_0__0__Impl rule__TypeExp__Group_0__1 )
            // InternalOCLX.g:2990:2: rule__TypeExp__Group_0__0__Impl rule__TypeExp__Group_0__1
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
    // InternalOCLX.g:2997:1: rule__TypeExp__Group_0__0__Impl : ( () ) ;
    public final void rule__TypeExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3001:1: ( ( () ) )
            // InternalOCLX.g:3002:1: ( () )
            {
            // InternalOCLX.g:3002:1: ( () )
            // InternalOCLX.g:3003:2: ()
            {
             before(grammarAccess.getTypeExpAccess().getTypeExpAction_0_0()); 
            // InternalOCLX.g:3004:2: ()
            // InternalOCLX.g:3004:3: 
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
    // InternalOCLX.g:3012:1: rule__TypeExp__Group_0__1 : rule__TypeExp__Group_0__1__Impl rule__TypeExp__Group_0__2 ;
    public final void rule__TypeExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3016:1: ( rule__TypeExp__Group_0__1__Impl rule__TypeExp__Group_0__2 )
            // InternalOCLX.g:3017:2: rule__TypeExp__Group_0__1__Impl rule__TypeExp__Group_0__2
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
    // InternalOCLX.g:3024:1: rule__TypeExp__Group_0__1__Impl : ( '<' ) ;
    public final void rule__TypeExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3028:1: ( ( '<' ) )
            // InternalOCLX.g:3029:1: ( '<' )
            {
            // InternalOCLX.g:3029:1: ( '<' )
            // InternalOCLX.g:3030:2: '<'
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
    // InternalOCLX.g:3039:1: rule__TypeExp__Group_0__2 : rule__TypeExp__Group_0__2__Impl rule__TypeExp__Group_0__3 ;
    public final void rule__TypeExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3043:1: ( rule__TypeExp__Group_0__2__Impl rule__TypeExp__Group_0__3 )
            // InternalOCLX.g:3044:2: rule__TypeExp__Group_0__2__Impl rule__TypeExp__Group_0__3
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
    // InternalOCLX.g:3051:1: rule__TypeExp__Group_0__2__Impl : ( ( rule__TypeExp__NameAssignment_0_2 ) ) ;
    public final void rule__TypeExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3055:1: ( ( ( rule__TypeExp__NameAssignment_0_2 ) ) )
            // InternalOCLX.g:3056:1: ( ( rule__TypeExp__NameAssignment_0_2 ) )
            {
            // InternalOCLX.g:3056:1: ( ( rule__TypeExp__NameAssignment_0_2 ) )
            // InternalOCLX.g:3057:2: ( rule__TypeExp__NameAssignment_0_2 )
            {
             before(grammarAccess.getTypeExpAccess().getNameAssignment_0_2()); 
            // InternalOCLX.g:3058:2: ( rule__TypeExp__NameAssignment_0_2 )
            // InternalOCLX.g:3058:3: rule__TypeExp__NameAssignment_0_2
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
    // InternalOCLX.g:3066:1: rule__TypeExp__Group_0__3 : rule__TypeExp__Group_0__3__Impl ;
    public final void rule__TypeExp__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3070:1: ( rule__TypeExp__Group_0__3__Impl )
            // InternalOCLX.g:3071:2: rule__TypeExp__Group_0__3__Impl
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
    // InternalOCLX.g:3077:1: rule__TypeExp__Group_0__3__Impl : ( '>' ) ;
    public final void rule__TypeExp__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3081:1: ( ( '>' ) )
            // InternalOCLX.g:3082:1: ( '>' )
            {
            // InternalOCLX.g:3082:1: ( '>' )
            // InternalOCLX.g:3083:2: '>'
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
    // InternalOCLX.g:3093:1: rule__TypeExp__Group_1__0 : rule__TypeExp__Group_1__0__Impl rule__TypeExp__Group_1__1 ;
    public final void rule__TypeExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3097:1: ( rule__TypeExp__Group_1__0__Impl rule__TypeExp__Group_1__1 )
            // InternalOCLX.g:3098:2: rule__TypeExp__Group_1__0__Impl rule__TypeExp__Group_1__1
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
    // InternalOCLX.g:3105:1: rule__TypeExp__Group_1__0__Impl : ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) ) ;
    public final void rule__TypeExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3109:1: ( ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) ) )
            // InternalOCLX.g:3110:1: ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) )
            {
            // InternalOCLX.g:3110:1: ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) )
            // InternalOCLX.g:3111:2: ( rule__TypeExp__CollectionTypeAssignment_1_0 )
            {
             before(grammarAccess.getTypeExpAccess().getCollectionTypeAssignment_1_0()); 
            // InternalOCLX.g:3112:2: ( rule__TypeExp__CollectionTypeAssignment_1_0 )
            // InternalOCLX.g:3112:3: rule__TypeExp__CollectionTypeAssignment_1_0
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
    // InternalOCLX.g:3120:1: rule__TypeExp__Group_1__1 : rule__TypeExp__Group_1__1__Impl ;
    public final void rule__TypeExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3124:1: ( rule__TypeExp__Group_1__1__Impl )
            // InternalOCLX.g:3125:2: rule__TypeExp__Group_1__1__Impl
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
    // InternalOCLX.g:3131:1: rule__TypeExp__Group_1__1__Impl : ( ( rule__TypeExp__TypeAssignment_1_1 ) ) ;
    public final void rule__TypeExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3135:1: ( ( ( rule__TypeExp__TypeAssignment_1_1 ) ) )
            // InternalOCLX.g:3136:1: ( ( rule__TypeExp__TypeAssignment_1_1 ) )
            {
            // InternalOCLX.g:3136:1: ( ( rule__TypeExp__TypeAssignment_1_1 ) )
            // InternalOCLX.g:3137:2: ( rule__TypeExp__TypeAssignment_1_1 )
            {
             before(grammarAccess.getTypeExpAccess().getTypeAssignment_1_1()); 
            // InternalOCLX.g:3138:2: ( rule__TypeExp__TypeAssignment_1_1 )
            // InternalOCLX.g:3138:3: rule__TypeExp__TypeAssignment_1_1
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


    // $ANTLR start "rule__Path__Group__0"
    // InternalOCLX.g:3147:1: rule__Path__Group__0 : rule__Path__Group__0__Impl rule__Path__Group__1 ;
    public final void rule__Path__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3151:1: ( rule__Path__Group__0__Impl rule__Path__Group__1 )
            // InternalOCLX.g:3152:2: rule__Path__Group__0__Impl rule__Path__Group__1
            {
            pushFollow(FOLLOW_31);
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
    // InternalOCLX.g:3159:1: rule__Path__Group__0__Impl : ( ruleSimpleName ) ;
    public final void rule__Path__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3163:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:3164:1: ( ruleSimpleName )
            {
            // InternalOCLX.g:3164:1: ( ruleSimpleName )
            // InternalOCLX.g:3165:2: ruleSimpleName
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
    // InternalOCLX.g:3174:1: rule__Path__Group__1 : rule__Path__Group__1__Impl ;
    public final void rule__Path__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3178:1: ( rule__Path__Group__1__Impl )
            // InternalOCLX.g:3179:2: rule__Path__Group__1__Impl
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
    // InternalOCLX.g:3185:1: rule__Path__Group__1__Impl : ( ( rule__Path__Group_1__0 )* ) ;
    public final void rule__Path__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3189:1: ( ( ( rule__Path__Group_1__0 )* ) )
            // InternalOCLX.g:3190:1: ( ( rule__Path__Group_1__0 )* )
            {
            // InternalOCLX.g:3190:1: ( ( rule__Path__Group_1__0 )* )
            // InternalOCLX.g:3191:2: ( rule__Path__Group_1__0 )*
            {
             before(grammarAccess.getPathAccess().getGroup_1()); 
            // InternalOCLX.g:3192:2: ( rule__Path__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==23) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalOCLX.g:3192:3: rule__Path__Group_1__0
            	    {
            	    pushFollow(FOLLOW_32);
            	    rule__Path__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalOCLX.g:3201:1: rule__Path__Group_1__0 : rule__Path__Group_1__0__Impl rule__Path__Group_1__1 ;
    public final void rule__Path__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3205:1: ( rule__Path__Group_1__0__Impl rule__Path__Group_1__1 )
            // InternalOCLX.g:3206:2: rule__Path__Group_1__0__Impl rule__Path__Group_1__1
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
    // InternalOCLX.g:3213:1: rule__Path__Group_1__0__Impl : ( '/' ) ;
    public final void rule__Path__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3217:1: ( ( '/' ) )
            // InternalOCLX.g:3218:1: ( '/' )
            {
            // InternalOCLX.g:3218:1: ( '/' )
            // InternalOCLX.g:3219:2: '/'
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
    // InternalOCLX.g:3228:1: rule__Path__Group_1__1 : rule__Path__Group_1__1__Impl ;
    public final void rule__Path__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3232:1: ( rule__Path__Group_1__1__Impl )
            // InternalOCLX.g:3233:2: rule__Path__Group_1__1__Impl
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
    // InternalOCLX.g:3239:1: rule__Path__Group_1__1__Impl : ( ruleSimpleName ) ;
    public final void rule__Path__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3243:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:3244:1: ( ruleSimpleName )
            {
            // InternalOCLX.g:3244:1: ( ruleSimpleName )
            // InternalOCLX.g:3245:2: ruleSimpleName
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
    // InternalOCLX.g:3255:1: rule__ArgumentsExp__Group__0 : rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1 ;
    public final void rule__ArgumentsExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3259:1: ( rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1 )
            // InternalOCLX.g:3260:2: rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1
            {
            pushFollow(FOLLOW_33);
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
    // InternalOCLX.g:3267:1: rule__ArgumentsExp__Group__0__Impl : ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) ) ;
    public final void rule__ArgumentsExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3271:1: ( ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) ) )
            // InternalOCLX.g:3272:1: ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) )
            {
            // InternalOCLX.g:3272:1: ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) )
            // InternalOCLX.g:3273:2: ( rule__ArgumentsExp__OperatorsAssignment_0 )
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_0()); 
            // InternalOCLX.g:3274:2: ( rule__ArgumentsExp__OperatorsAssignment_0 )
            // InternalOCLX.g:3274:3: rule__ArgumentsExp__OperatorsAssignment_0
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
    // InternalOCLX.g:3282:1: rule__ArgumentsExp__Group__1 : rule__ArgumentsExp__Group__1__Impl ;
    public final void rule__ArgumentsExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3286:1: ( rule__ArgumentsExp__Group__1__Impl )
            // InternalOCLX.g:3287:2: rule__ArgumentsExp__Group__1__Impl
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
    // InternalOCLX.g:3293:1: rule__ArgumentsExp__Group__1__Impl : ( ( rule__ArgumentsExp__Group_1__0 )* ) ;
    public final void rule__ArgumentsExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3297:1: ( ( ( rule__ArgumentsExp__Group_1__0 )* ) )
            // InternalOCLX.g:3298:1: ( ( rule__ArgumentsExp__Group_1__0 )* )
            {
            // InternalOCLX.g:3298:1: ( ( rule__ArgumentsExp__Group_1__0 )* )
            // InternalOCLX.g:3299:2: ( rule__ArgumentsExp__Group_1__0 )*
            {
             before(grammarAccess.getArgumentsExpAccess().getGroup_1()); 
            // InternalOCLX.g:3300:2: ( rule__ArgumentsExp__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==52) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalOCLX.g:3300:3: rule__ArgumentsExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_34);
            	    rule__ArgumentsExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalOCLX.g:3309:1: rule__ArgumentsExp__Group_1__0 : rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1 ;
    public final void rule__ArgumentsExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3313:1: ( rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1 )
            // InternalOCLX.g:3314:2: rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1
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
    // InternalOCLX.g:3321:1: rule__ArgumentsExp__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ArgumentsExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3325:1: ( ( ',' ) )
            // InternalOCLX.g:3326:1: ( ',' )
            {
            // InternalOCLX.g:3326:1: ( ',' )
            // InternalOCLX.g:3327:2: ','
            {
             before(grammarAccess.getArgumentsExpAccess().getCommaKeyword_1_0()); 
            match(input,52,FOLLOW_2); 
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
    // InternalOCLX.g:3336:1: rule__ArgumentsExp__Group_1__1 : rule__ArgumentsExp__Group_1__1__Impl ;
    public final void rule__ArgumentsExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3340:1: ( rule__ArgumentsExp__Group_1__1__Impl )
            // InternalOCLX.g:3341:2: rule__ArgumentsExp__Group_1__1__Impl
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
    // InternalOCLX.g:3347:1: rule__ArgumentsExp__Group_1__1__Impl : ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) ) ;
    public final void rule__ArgumentsExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3351:1: ( ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) ) )
            // InternalOCLX.g:3352:1: ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) )
            {
            // InternalOCLX.g:3352:1: ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) )
            // InternalOCLX.g:3353:2: ( rule__ArgumentsExp__OperatorsAssignment_1_1 )
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_1_1()); 
            // InternalOCLX.g:3354:2: ( rule__ArgumentsExp__OperatorsAssignment_1_1 )
            // InternalOCLX.g:3354:3: rule__ArgumentsExp__OperatorsAssignment_1_1
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
    // InternalOCLX.g:3363:1: rule__Model__ConstraintsAssignment : ( ruleConstraint ) ;
    public final void rule__Model__ConstraintsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3367:1: ( ( ruleConstraint ) )
            // InternalOCLX.g:3368:2: ( ruleConstraint )
            {
            // InternalOCLX.g:3368:2: ( ruleConstraint )
            // InternalOCLX.g:3369:3: ruleConstraint
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
    // InternalOCLX.g:3378:1: rule__Constraint__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constraint__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3382:1: ( ( RULE_ID ) )
            // InternalOCLX.g:3383:2: ( RULE_ID )
            {
            // InternalOCLX.g:3383:2: ( RULE_ID )
            // InternalOCLX.g:3384:3: RULE_ID
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
    // InternalOCLX.g:3393:1: rule__Constraint__DescriptionAssignment_3_1 : ( RULE_DESCRIPTION ) ;
    public final void rule__Constraint__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3397:1: ( ( RULE_DESCRIPTION ) )
            // InternalOCLX.g:3398:2: ( RULE_DESCRIPTION )
            {
            // InternalOCLX.g:3398:2: ( RULE_DESCRIPTION )
            // InternalOCLX.g:3399:3: RULE_DESCRIPTION
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
    // InternalOCLX.g:3408:1: rule__Constraint__OverrulableAssignment_4_2 : ( ruleBooleanLiteralExp ) ;
    public final void rule__Constraint__OverrulableAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3412:1: ( ( ruleBooleanLiteralExp ) )
            // InternalOCLX.g:3413:2: ( ruleBooleanLiteralExp )
            {
            // InternalOCLX.g:3413:2: ( ruleBooleanLiteralExp )
            // InternalOCLX.g:3414:3: ruleBooleanLiteralExp
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
    // InternalOCLX.g:3423:1: rule__Constraint__ContextAssignment_6 : ( ruleContext ) ;
    public final void rule__Constraint__ContextAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3427:1: ( ( ruleContext ) )
            // InternalOCLX.g:3428:2: ( ruleContext )
            {
            // InternalOCLX.g:3428:2: ( ruleContext )
            // InternalOCLX.g:3429:3: ruleContext
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
    // InternalOCLX.g:3438:1: rule__Constraint__ExpressionAssignment_8 : ( ruleExp ) ;
    public final void rule__Constraint__ExpressionAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3442:1: ( ( ruleExp ) )
            // InternalOCLX.g:3443:2: ( ruleExp )
            {
            // InternalOCLX.g:3443:2: ( ruleExp )
            // InternalOCLX.g:3444:3: ruleExp
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
    // InternalOCLX.g:3453:1: rule__Context__NameAssignment : ( ruleQualifiedName ) ;
    public final void rule__Context__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3457:1: ( ( ruleQualifiedName ) )
            // InternalOCLX.g:3458:2: ( ruleQualifiedName )
            {
            // InternalOCLX.g:3458:2: ( ruleQualifiedName )
            // InternalOCLX.g:3459:3: ruleQualifiedName
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
    // InternalOCLX.g:3468:1: rule__Exp__OperatorsAssignment_1_1 : ( ruleBinaryOperator ) ;
    public final void rule__Exp__OperatorsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3472:1: ( ( ruleBinaryOperator ) )
            // InternalOCLX.g:3473:2: ( ruleBinaryOperator )
            {
            // InternalOCLX.g:3473:2: ( ruleBinaryOperator )
            // InternalOCLX.g:3474:3: ruleBinaryOperator
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
    // InternalOCLX.g:3483:1: rule__Exp__ExpressionsAssignment_1_2 : ( rulePrefixedExp ) ;
    public final void rule__Exp__ExpressionsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3487:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:3488:2: ( rulePrefixedExp )
            {
            // InternalOCLX.g:3488:2: ( rulePrefixedExp )
            // InternalOCLX.g:3489:3: rulePrefixedExp
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
    // InternalOCLX.g:3498:1: rule__Exp__OperatorsAssignment_1_3_0 : ( ruleBinaryOperator ) ;
    public final void rule__Exp__OperatorsAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3502:1: ( ( ruleBinaryOperator ) )
            // InternalOCLX.g:3503:2: ( ruleBinaryOperator )
            {
            // InternalOCLX.g:3503:2: ( ruleBinaryOperator )
            // InternalOCLX.g:3504:3: ruleBinaryOperator
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
    // InternalOCLX.g:3513:1: rule__Exp__ExpressionsAssignment_1_3_1 : ( rulePrefixedExp ) ;
    public final void rule__Exp__ExpressionsAssignment_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3517:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:3518:2: ( rulePrefixedExp )
            {
            // InternalOCLX.g:3518:2: ( rulePrefixedExp )
            // InternalOCLX.g:3519:3: rulePrefixedExp
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


    // $ANTLR start "rule__PrefixedExp__OperatorsAssignment_0_1"
    // InternalOCLX.g:3528:1: rule__PrefixedExp__OperatorsAssignment_0_1 : ( ruleUnaryOperator ) ;
    public final void rule__PrefixedExp__OperatorsAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3532:1: ( ( ruleUnaryOperator ) )
            // InternalOCLX.g:3533:2: ( ruleUnaryOperator )
            {
            // InternalOCLX.g:3533:2: ( ruleUnaryOperator )
            // InternalOCLX.g:3534:3: ruleUnaryOperator
            {
             before(grammarAccess.getPrefixedExpAccess().getOperatorsUnaryOperatorParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryOperator();

            state._fsp--;

             after(grammarAccess.getPrefixedExpAccess().getOperatorsUnaryOperatorParserRuleCall_0_1_0()); 

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
    // $ANTLR end "rule__PrefixedExp__OperatorsAssignment_0_1"


    // $ANTLR start "rule__PrefixedExp__ExpressionAssignment_0_2"
    // InternalOCLX.g:3543:1: rule__PrefixedExp__ExpressionAssignment_0_2 : ( rulePrimaryExp ) ;
    public final void rule__PrefixedExp__ExpressionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3547:1: ( ( rulePrimaryExp ) )
            // InternalOCLX.g:3548:2: ( rulePrimaryExp )
            {
            // InternalOCLX.g:3548:2: ( rulePrimaryExp )
            // InternalOCLX.g:3549:3: rulePrimaryExp
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
    // InternalOCLX.g:3558:1: rule__BooleanOperator__OpAssignment : ( ( rule__BooleanOperator__OpAlternatives_0 ) ) ;
    public final void rule__BooleanOperator__OpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3562:1: ( ( ( rule__BooleanOperator__OpAlternatives_0 ) ) )
            // InternalOCLX.g:3563:2: ( ( rule__BooleanOperator__OpAlternatives_0 ) )
            {
            // InternalOCLX.g:3563:2: ( ( rule__BooleanOperator__OpAlternatives_0 ) )
            // InternalOCLX.g:3564:3: ( rule__BooleanOperator__OpAlternatives_0 )
            {
             before(grammarAccess.getBooleanOperatorAccess().getOpAlternatives_0()); 
            // InternalOCLX.g:3565:3: ( rule__BooleanOperator__OpAlternatives_0 )
            // InternalOCLX.g:3565:4: rule__BooleanOperator__OpAlternatives_0
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
    // InternalOCLX.g:3573:1: rule__MathOperator__OpAssignment : ( ( rule__MathOperator__OpAlternatives_0 ) ) ;
    public final void rule__MathOperator__OpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3577:1: ( ( ( rule__MathOperator__OpAlternatives_0 ) ) )
            // InternalOCLX.g:3578:2: ( ( rule__MathOperator__OpAlternatives_0 ) )
            {
            // InternalOCLX.g:3578:2: ( ( rule__MathOperator__OpAlternatives_0 ) )
            // InternalOCLX.g:3579:3: ( rule__MathOperator__OpAlternatives_0 )
            {
             before(grammarAccess.getMathOperatorAccess().getOpAlternatives_0()); 
            // InternalOCLX.g:3580:3: ( rule__MathOperator__OpAlternatives_0 )
            // InternalOCLX.g:3580:4: rule__MathOperator__OpAlternatives_0
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
    // InternalOCLX.g:3588:1: rule__NavigationOperator__NameAssignment : ( ( rule__NavigationOperator__NameAlternatives_0 ) ) ;
    public final void rule__NavigationOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3592:1: ( ( ( rule__NavigationOperator__NameAlternatives_0 ) ) )
            // InternalOCLX.g:3593:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:3593:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            // InternalOCLX.g:3594:3: ( rule__NavigationOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getNavigationOperatorAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:3595:3: ( rule__NavigationOperator__NameAlternatives_0 )
            // InternalOCLX.g:3595:4: rule__NavigationOperator__NameAlternatives_0
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
    // InternalOCLX.g:3603:1: rule__UnaryOperator__NameAssignment : ( ( rule__UnaryOperator__NameAlternatives_0 ) ) ;
    public final void rule__UnaryOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3607:1: ( ( ( rule__UnaryOperator__NameAlternatives_0 ) ) )
            // InternalOCLX.g:3608:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:3608:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            // InternalOCLX.g:3609:3: ( rule__UnaryOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getUnaryOperatorAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:3610:3: ( rule__UnaryOperator__NameAlternatives_0 )
            // InternalOCLX.g:3610:4: rule__UnaryOperator__NameAlternatives_0
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
    // InternalOCLX.g:3618:1: rule__PrimaryExp__NavAssignment_1_1_0 : ( ruleNavigationOperator ) ;
    public final void rule__PrimaryExp__NavAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3622:1: ( ( ruleNavigationOperator ) )
            // InternalOCLX.g:3623:2: ( ruleNavigationOperator )
            {
            // InternalOCLX.g:3623:2: ( ruleNavigationOperator )
            // InternalOCLX.g:3624:3: ruleNavigationOperator
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
    // InternalOCLX.g:3633:1: rule__PrimaryExp__MethodsAssignment_1_1_1 : ( ruleMethodExp ) ;
    public final void rule__PrimaryExp__MethodsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3637:1: ( ( ruleMethodExp ) )
            // InternalOCLX.g:3638:2: ( ruleMethodExp )
            {
            // InternalOCLX.g:3638:2: ( ruleMethodExp )
            // InternalOCLX.g:3639:3: ruleMethodExp
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
    // InternalOCLX.g:3648:1: rule__NestedExp__SourceAssignment_1 : ( ruleExp ) ;
    public final void rule__NestedExp__SourceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3652:1: ( ( ruleExp ) )
            // InternalOCLX.g:3653:2: ( ruleExp )
            {
            // InternalOCLX.g:3653:2: ( ruleExp )
            // InternalOCLX.g:3654:3: ruleExp
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
    // InternalOCLX.g:3663:1: rule__SelfExp__NameAssignment_1 : ( ( 'self' ) ) ;
    public final void rule__SelfExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3667:1: ( ( ( 'self' ) ) )
            // InternalOCLX.g:3668:2: ( ( 'self' ) )
            {
            // InternalOCLX.g:3668:2: ( ( 'self' ) )
            // InternalOCLX.g:3669:3: ( 'self' )
            {
             before(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0()); 
            // InternalOCLX.g:3670:3: ( 'self' )
            // InternalOCLX.g:3671:4: 'self'
            {
             before(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0()); 
            match(input,53,FOLLOW_2); 
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
    // InternalOCLX.g:3682:1: rule__VarDeclaration__NameAssignment : ( ruleSimpleName ) ;
    public final void rule__VarDeclaration__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3686:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:3687:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:3687:2: ( ruleSimpleName )
            // InternalOCLX.g:3688:3: ruleSimpleName
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
    // InternalOCLX.g:3697:1: rule__VarReference__RefAssignment : ( ( RULE_ID ) ) ;
    public final void rule__VarReference__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3701:1: ( ( ( RULE_ID ) ) )
            // InternalOCLX.g:3702:2: ( ( RULE_ID ) )
            {
            // InternalOCLX.g:3702:2: ( ( RULE_ID ) )
            // InternalOCLX.g:3703:3: ( RULE_ID )
            {
             before(grammarAccess.getVarReferenceAccess().getRefVarDeclarationCrossReference_0()); 
            // InternalOCLX.g:3704:3: ( RULE_ID )
            // InternalOCLX.g:3705:4: RULE_ID
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
    // InternalOCLX.g:3716:1: rule__NumberLiteralExp__ValueAssignment : ( RULE_INT ) ;
    public final void rule__NumberLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3720:1: ( ( RULE_INT ) )
            // InternalOCLX.g:3721:2: ( RULE_INT )
            {
            // InternalOCLX.g:3721:2: ( RULE_INT )
            // InternalOCLX.g:3722:3: RULE_INT
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
    // InternalOCLX.g:3731:1: rule__StringLiteralExp__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3735:1: ( ( RULE_STRING ) )
            // InternalOCLX.g:3736:2: ( RULE_STRING )
            {
            // InternalOCLX.g:3736:2: ( RULE_STRING )
            // InternalOCLX.g:3737:3: RULE_STRING
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
    // InternalOCLX.g:3746:1: rule__BooleanLiteralExp__ValueAssignment_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralExp__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3750:1: ( ( ( 'true' ) ) )
            // InternalOCLX.g:3751:2: ( ( 'true' ) )
            {
            // InternalOCLX.g:3751:2: ( ( 'true' ) )
            // InternalOCLX.g:3752:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0()); 
            // InternalOCLX.g:3753:3: ( 'true' )
            // InternalOCLX.g:3754:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalOCLX.g:3765:1: rule__BooleanLiteralExp__ValueAssignment_1 : ( ( 'false' ) ) ;
    public final void rule__BooleanLiteralExp__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3769:1: ( ( ( 'false' ) ) )
            // InternalOCLX.g:3770:2: ( ( 'false' ) )
            {
            // InternalOCLX.g:3770:2: ( ( 'false' ) )
            // InternalOCLX.g:3771:3: ( 'false' )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0()); 
            // InternalOCLX.g:3772:3: ( 'false' )
            // InternalOCLX.g:3773:4: 'false'
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0()); 
            match(input,55,FOLLOW_2); 
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
    // InternalOCLX.g:3784:1: rule__CollectionIterator__NameAssignment_0 : ( ruleIteratorName ) ;
    public final void rule__CollectionIterator__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3788:1: ( ( ruleIteratorName ) )
            // InternalOCLX.g:3789:2: ( ruleIteratorName )
            {
            // InternalOCLX.g:3789:2: ( ruleIteratorName )
            // InternalOCLX.g:3790:3: ruleIteratorName
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
    // InternalOCLX.g:3799:1: rule__CollectionIterator__ItervarAssignment_2 : ( ruleIteratorVarDeclaration ) ;
    public final void rule__CollectionIterator__ItervarAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3803:1: ( ( ruleIteratorVarDeclaration ) )
            // InternalOCLX.g:3804:2: ( ruleIteratorVarDeclaration )
            {
            // InternalOCLX.g:3804:2: ( ruleIteratorVarDeclaration )
            // InternalOCLX.g:3805:3: ruleIteratorVarDeclaration
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
    // InternalOCLX.g:3814:1: rule__CollectionIterator__BodyAssignment_4 : ( ruleExp ) ;
    public final void rule__CollectionIterator__BodyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3818:1: ( ( ruleExp ) )
            // InternalOCLX.g:3819:2: ( ruleExp )
            {
            // InternalOCLX.g:3819:2: ( ruleExp )
            // InternalOCLX.g:3820:3: ruleExp
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
    // InternalOCLX.g:3829:1: rule__IteratorName__NameAssignment : ( ( rule__IteratorName__NameAlternatives_0 ) ) ;
    public final void rule__IteratorName__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3833:1: ( ( ( rule__IteratorName__NameAlternatives_0 ) ) )
            // InternalOCLX.g:3834:2: ( ( rule__IteratorName__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:3834:2: ( ( rule__IteratorName__NameAlternatives_0 ) )
            // InternalOCLX.g:3835:3: ( rule__IteratorName__NameAlternatives_0 )
            {
             before(grammarAccess.getIteratorNameAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:3836:3: ( rule__IteratorName__NameAlternatives_0 )
            // InternalOCLX.g:3836:4: rule__IteratorName__NameAlternatives_0
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
    // InternalOCLX.g:3844:1: rule__IteratorVarDeclaration__NameAssignment_0 : ( ruleVarDeclaration ) ;
    public final void rule__IteratorVarDeclaration__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3848:1: ( ( ruleVarDeclaration ) )
            // InternalOCLX.g:3849:2: ( ruleVarDeclaration )
            {
            // InternalOCLX.g:3849:2: ( ruleVarDeclaration )
            // InternalOCLX.g:3850:3: ruleVarDeclaration
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
    // InternalOCLX.g:3859:1: rule__IteratorVarDeclaration__NameAssignment_1_0 : ( ruleVarDeclaration ) ;
    public final void rule__IteratorVarDeclaration__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3863:1: ( ( ruleVarDeclaration ) )
            // InternalOCLX.g:3864:2: ( ruleVarDeclaration )
            {
            // InternalOCLX.g:3864:2: ( ruleVarDeclaration )
            // InternalOCLX.g:3865:3: ruleVarDeclaration
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
    // InternalOCLX.g:3874:1: rule__IteratorVarDeclaration__TypeAssignment_1_2 : ( ruleTypeExp ) ;
    public final void rule__IteratorVarDeclaration__TypeAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3878:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:3879:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:3879:2: ( ruleTypeExp )
            // InternalOCLX.g:3880:3: ruleTypeExp
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
    // InternalOCLX.g:3889:1: rule__PropertyAccess__NameAssignment : ( ruleSimpleName ) ;
    public final void rule__PropertyAccess__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3893:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:3894:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:3894:2: ( ruleSimpleName )
            // InternalOCLX.g:3895:3: ruleSimpleName
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
    // InternalOCLX.g:3904:1: rule__MethodCall__NameAssignment_0_0 : ( ruleSimpleName ) ;
    public final void rule__MethodCall__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3908:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:3909:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:3909:2: ( ruleSimpleName )
            // InternalOCLX.g:3910:3: ruleSimpleName
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
    // InternalOCLX.g:3919:1: rule__MethodCall__NameAssignment_1_0 : ( ruleSimpleName ) ;
    public final void rule__MethodCall__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3923:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:3924:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:3924:2: ( ruleSimpleName )
            // InternalOCLX.g:3925:3: ruleSimpleName
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
    // InternalOCLX.g:3934:1: rule__MethodCall__ArgsAssignment_1_2 : ( ruleArgumentsExp ) ;
    public final void rule__MethodCall__ArgsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3938:1: ( ( ruleArgumentsExp ) )
            // InternalOCLX.g:3939:2: ( ruleArgumentsExp )
            {
            // InternalOCLX.g:3939:2: ( ruleArgumentsExp )
            // InternalOCLX.g:3940:3: ruleArgumentsExp
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


    // $ANTLR start "rule__MethodCall__NameAssignment_2_0"
    // InternalOCLX.g:3949:1: rule__MethodCall__NameAssignment_2_0 : ( ruleSimpleName ) ;
    public final void rule__MethodCall__NameAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3953:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:3954:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:3954:2: ( ruleSimpleName )
            // InternalOCLX.g:3955:3: ruleSimpleName
            {
             before(grammarAccess.getMethodCallAccess().getNameSimpleNameParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSimpleName();

            state._fsp--;

             after(grammarAccess.getMethodCallAccess().getNameSimpleNameParserRuleCall_2_0_0()); 

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
    // $ANTLR end "rule__MethodCall__NameAssignment_2_0"


    // $ANTLR start "rule__MethodCall__TypeAssignment_2_2"
    // InternalOCLX.g:3964:1: rule__MethodCall__TypeAssignment_2_2 : ( ruleTypeExp ) ;
    public final void rule__MethodCall__TypeAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3968:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:3969:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:3969:2: ( ruleTypeExp )
            // InternalOCLX.g:3970:3: ruleTypeExp
            {
             before(grammarAccess.getMethodCallAccess().getTypeTypeExpParserRuleCall_2_2_0()); 
            pushFollow(FOLLOW_2);
            ruleTypeExp();

            state._fsp--;

             after(grammarAccess.getMethodCallAccess().getTypeTypeExpParserRuleCall_2_2_0()); 

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
    // $ANTLR end "rule__MethodCall__TypeAssignment_2_2"


    // $ANTLR start "rule__TypeExp__NameAssignment_0_2"
    // InternalOCLX.g:3979:1: rule__TypeExp__NameAssignment_0_2 : ( rulePath ) ;
    public final void rule__TypeExp__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3983:1: ( ( rulePath ) )
            // InternalOCLX.g:3984:2: ( rulePath )
            {
            // InternalOCLX.g:3984:2: ( rulePath )
            // InternalOCLX.g:3985:3: rulePath
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
    // InternalOCLX.g:3994:1: rule__TypeExp__CollectionTypeAssignment_1_0 : ( ruleCollectionTypeIdentifier ) ;
    public final void rule__TypeExp__CollectionTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3998:1: ( ( ruleCollectionTypeIdentifier ) )
            // InternalOCLX.g:3999:2: ( ruleCollectionTypeIdentifier )
            {
            // InternalOCLX.g:3999:2: ( ruleCollectionTypeIdentifier )
            // InternalOCLX.g:4000:3: ruleCollectionTypeIdentifier
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
    // InternalOCLX.g:4009:1: rule__TypeExp__TypeAssignment_1_1 : ( ruleTypeExp ) ;
    public final void rule__TypeExp__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4013:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:4014:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:4014:2: ( ruleTypeExp )
            // InternalOCLX.g:4015:3: ruleTypeExp
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
    // InternalOCLX.g:4024:1: rule__CollectionTypeIdentifier__NameAssignment : ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) ) ;
    public final void rule__CollectionTypeIdentifier__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4028:1: ( ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) ) )
            // InternalOCLX.g:4029:2: ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:4029:2: ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) )
            // InternalOCLX.g:4030:3: ( rule__CollectionTypeIdentifier__NameAlternatives_0 )
            {
             before(grammarAccess.getCollectionTypeIdentifierAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:4031:3: ( rule__CollectionTypeIdentifier__NameAlternatives_0 )
            // InternalOCLX.g:4031:4: rule__CollectionTypeIdentifier__NameAlternatives_0
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


    // $ANTLR start "rule__ArgumentsExp__OperatorsAssignment_0"
    // InternalOCLX.g:4039:1: rule__ArgumentsExp__OperatorsAssignment_0 : ( ruleExp ) ;
    public final void rule__ArgumentsExp__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4043:1: ( ( ruleExp ) )
            // InternalOCLX.g:4044:2: ( ruleExp )
            {
            // InternalOCLX.g:4044:2: ( ruleExp )
            // InternalOCLX.g:4045:3: ruleExp
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
    // InternalOCLX.g:4054:1: rule__ArgumentsExp__OperatorsAssignment_1_1 : ( ruleExp ) ;
    public final void rule__ArgumentsExp__OperatorsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4058:1: ( ( ruleExp ) )
            // InternalOCLX.g:4059:2: ( ruleExp )
            {
            // InternalOCLX.g:4059:2: ( ruleExp )
            // InternalOCLX.g:4060:3: ruleExp
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000190000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00E14000120000D0L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000003FFF000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000003FFF002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000012000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00000003E0000010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000003C00002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0010000000000002L});

}