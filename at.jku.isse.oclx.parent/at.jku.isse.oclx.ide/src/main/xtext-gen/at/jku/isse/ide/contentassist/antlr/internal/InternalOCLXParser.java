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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_DESCRIPTION", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'*'", "'/'", "'+'", "'-'", "'.'", "'->'", "'not'", "'forAll'", "'exists'", "'collect'", "'reject'", "'select'", "'asType'", "'isTypeOf'", "'isKindOf'", "'set'", "'list'", "'map'", "'collection'", "'next'", "'always'", "'eventually'", "'rule'", "'{'", "'context:'", "'expression:'", "'}'", "'description:'", "'is'", "'overrulable:'", "'('", "')'", "'|'", "':'", "'()'", "'ensureThat'", "'asLongAs'", "'then'", "'thenAtLeastOnce'", "','", "'self'", "'true'", "'false'", "'everyTime'", "'whenOnce'", "'until'", "'asSoonAs'", "'everytime'"
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
    public static final int RULE_DESCRIPTION=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
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


    // $ANTLR start "entryRuleFloat"
    // InternalOCLX.g:153:1: entryRuleFloat : ruleFloat EOF ;
    public final void entryRuleFloat() throws RecognitionException {
        try {
            // InternalOCLX.g:154:1: ( ruleFloat EOF )
            // InternalOCLX.g:155:1: ruleFloat EOF
            {
             before(grammarAccess.getFloatRule()); 
            pushFollow(FOLLOW_1);
            ruleFloat();

            state._fsp--;

             after(grammarAccess.getFloatRule()); 
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
    // $ANTLR end "entryRuleFloat"


    // $ANTLR start "ruleFloat"
    // InternalOCLX.g:162:1: ruleFloat : ( ( rule__Float__Group__0 ) ) ;
    public final void ruleFloat() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:166:2: ( ( ( rule__Float__Group__0 ) ) )
            // InternalOCLX.g:167:2: ( ( rule__Float__Group__0 ) )
            {
            // InternalOCLX.g:167:2: ( ( rule__Float__Group__0 ) )
            // InternalOCLX.g:168:3: ( rule__Float__Group__0 )
            {
             before(grammarAccess.getFloatAccess().getGroup()); 
            // InternalOCLX.g:169:3: ( rule__Float__Group__0 )
            // InternalOCLX.g:169:4: rule__Float__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Float__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFloatAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFloat"


    // $ANTLR start "entryRuleContext"
    // InternalOCLX.g:178:1: entryRuleContext : ruleContext EOF ;
    public final void entryRuleContext() throws RecognitionException {
        try {
            // InternalOCLX.g:179:1: ( ruleContext EOF )
            // InternalOCLX.g:180:1: ruleContext EOF
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
    // InternalOCLX.g:187:1: ruleContext : ( ( rule__Context__NameAssignment ) ) ;
    public final void ruleContext() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:191:2: ( ( ( rule__Context__NameAssignment ) ) )
            // InternalOCLX.g:192:2: ( ( rule__Context__NameAssignment ) )
            {
            // InternalOCLX.g:192:2: ( ( rule__Context__NameAssignment ) )
            // InternalOCLX.g:193:3: ( rule__Context__NameAssignment )
            {
             before(grammarAccess.getContextAccess().getNameAssignment()); 
            // InternalOCLX.g:194:3: ( rule__Context__NameAssignment )
            // InternalOCLX.g:194:4: rule__Context__NameAssignment
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
    // InternalOCLX.g:203:1: entryRuleExp : ruleExp EOF ;
    public final void entryRuleExp() throws RecognitionException {
        try {
            // InternalOCLX.g:204:1: ( ruleExp EOF )
            // InternalOCLX.g:205:1: ruleExp EOF
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
    // InternalOCLX.g:212:1: ruleExp : ( ( rule__Exp__Group__0 ) ) ;
    public final void ruleExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:216:2: ( ( ( rule__Exp__Group__0 ) ) )
            // InternalOCLX.g:217:2: ( ( rule__Exp__Group__0 ) )
            {
            // InternalOCLX.g:217:2: ( ( rule__Exp__Group__0 ) )
            // InternalOCLX.g:218:3: ( rule__Exp__Group__0 )
            {
             before(grammarAccess.getExpAccess().getGroup()); 
            // InternalOCLX.g:219:3: ( rule__Exp__Group__0 )
            // InternalOCLX.g:219:4: rule__Exp__Group__0
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
    // InternalOCLX.g:228:1: entryRulePrefixedExp : rulePrefixedExp EOF ;
    public final void entryRulePrefixedExp() throws RecognitionException {
        try {
            // InternalOCLX.g:229:1: ( rulePrefixedExp EOF )
            // InternalOCLX.g:230:1: rulePrefixedExp EOF
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
    // InternalOCLX.g:237:1: rulePrefixedExp : ( ( rule__PrefixedExp__Alternatives ) ) ;
    public final void rulePrefixedExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:241:2: ( ( ( rule__PrefixedExp__Alternatives ) ) )
            // InternalOCLX.g:242:2: ( ( rule__PrefixedExp__Alternatives ) )
            {
            // InternalOCLX.g:242:2: ( ( rule__PrefixedExp__Alternatives ) )
            // InternalOCLX.g:243:3: ( rule__PrefixedExp__Alternatives )
            {
             before(grammarAccess.getPrefixedExpAccess().getAlternatives()); 
            // InternalOCLX.g:244:3: ( rule__PrefixedExp__Alternatives )
            // InternalOCLX.g:244:4: rule__PrefixedExp__Alternatives
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
    // InternalOCLX.g:253:1: entryRuleBinaryOperator : ruleBinaryOperator EOF ;
    public final void entryRuleBinaryOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:254:1: ( ruleBinaryOperator EOF )
            // InternalOCLX.g:255:1: ruleBinaryOperator EOF
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
    // InternalOCLX.g:262:1: ruleBinaryOperator : ( ruleInfixOperator ) ;
    public final void ruleBinaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:266:2: ( ( ruleInfixOperator ) )
            // InternalOCLX.g:267:2: ( ruleInfixOperator )
            {
            // InternalOCLX.g:267:2: ( ruleInfixOperator )
            // InternalOCLX.g:268:3: ruleInfixOperator
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
    // InternalOCLX.g:278:1: entryRuleInfixOperator : ruleInfixOperator EOF ;
    public final void entryRuleInfixOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:279:1: ( ruleInfixOperator EOF )
            // InternalOCLX.g:280:1: ruleInfixOperator EOF
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
    // InternalOCLX.g:287:1: ruleInfixOperator : ( ( rule__InfixOperator__Alternatives ) ) ;
    public final void ruleInfixOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:291:2: ( ( ( rule__InfixOperator__Alternatives ) ) )
            // InternalOCLX.g:292:2: ( ( rule__InfixOperator__Alternatives ) )
            {
            // InternalOCLX.g:292:2: ( ( rule__InfixOperator__Alternatives ) )
            // InternalOCLX.g:293:3: ( rule__InfixOperator__Alternatives )
            {
             before(grammarAccess.getInfixOperatorAccess().getAlternatives()); 
            // InternalOCLX.g:294:3: ( rule__InfixOperator__Alternatives )
            // InternalOCLX.g:294:4: rule__InfixOperator__Alternatives
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
    // InternalOCLX.g:303:1: entryRuleBooleanOperator : ruleBooleanOperator EOF ;
    public final void entryRuleBooleanOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:304:1: ( ruleBooleanOperator EOF )
            // InternalOCLX.g:305:1: ruleBooleanOperator EOF
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
    // InternalOCLX.g:312:1: ruleBooleanOperator : ( ( rule__BooleanOperator__OpAssignment ) ) ;
    public final void ruleBooleanOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:316:2: ( ( ( rule__BooleanOperator__OpAssignment ) ) )
            // InternalOCLX.g:317:2: ( ( rule__BooleanOperator__OpAssignment ) )
            {
            // InternalOCLX.g:317:2: ( ( rule__BooleanOperator__OpAssignment ) )
            // InternalOCLX.g:318:3: ( rule__BooleanOperator__OpAssignment )
            {
             before(grammarAccess.getBooleanOperatorAccess().getOpAssignment()); 
            // InternalOCLX.g:319:3: ( rule__BooleanOperator__OpAssignment )
            // InternalOCLX.g:319:4: rule__BooleanOperator__OpAssignment
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
    // InternalOCLX.g:328:1: entryRuleMathOperator : ruleMathOperator EOF ;
    public final void entryRuleMathOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:329:1: ( ruleMathOperator EOF )
            // InternalOCLX.g:330:1: ruleMathOperator EOF
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
    // InternalOCLX.g:337:1: ruleMathOperator : ( ( rule__MathOperator__OpAssignment ) ) ;
    public final void ruleMathOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:341:2: ( ( ( rule__MathOperator__OpAssignment ) ) )
            // InternalOCLX.g:342:2: ( ( rule__MathOperator__OpAssignment ) )
            {
            // InternalOCLX.g:342:2: ( ( rule__MathOperator__OpAssignment ) )
            // InternalOCLX.g:343:3: ( rule__MathOperator__OpAssignment )
            {
             before(grammarAccess.getMathOperatorAccess().getOpAssignment()); 
            // InternalOCLX.g:344:3: ( rule__MathOperator__OpAssignment )
            // InternalOCLX.g:344:4: rule__MathOperator__OpAssignment
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
    // InternalOCLX.g:353:1: entryRuleNavigationOperator : ruleNavigationOperator EOF ;
    public final void entryRuleNavigationOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:354:1: ( ruleNavigationOperator EOF )
            // InternalOCLX.g:355:1: ruleNavigationOperator EOF
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
    // InternalOCLX.g:362:1: ruleNavigationOperator : ( ( rule__NavigationOperator__NameAssignment ) ) ;
    public final void ruleNavigationOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:366:2: ( ( ( rule__NavigationOperator__NameAssignment ) ) )
            // InternalOCLX.g:367:2: ( ( rule__NavigationOperator__NameAssignment ) )
            {
            // InternalOCLX.g:367:2: ( ( rule__NavigationOperator__NameAssignment ) )
            // InternalOCLX.g:368:3: ( rule__NavigationOperator__NameAssignment )
            {
             before(grammarAccess.getNavigationOperatorAccess().getNameAssignment()); 
            // InternalOCLX.g:369:3: ( rule__NavigationOperator__NameAssignment )
            // InternalOCLX.g:369:4: rule__NavigationOperator__NameAssignment
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
    // InternalOCLX.g:378:1: entryRuleUnaryOperator : ruleUnaryOperator EOF ;
    public final void entryRuleUnaryOperator() throws RecognitionException {
        try {
            // InternalOCLX.g:379:1: ( ruleUnaryOperator EOF )
            // InternalOCLX.g:380:1: ruleUnaryOperator EOF
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
    // InternalOCLX.g:387:1: ruleUnaryOperator : ( ( rule__UnaryOperator__NameAssignment ) ) ;
    public final void ruleUnaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:391:2: ( ( ( rule__UnaryOperator__NameAssignment ) ) )
            // InternalOCLX.g:392:2: ( ( rule__UnaryOperator__NameAssignment ) )
            {
            // InternalOCLX.g:392:2: ( ( rule__UnaryOperator__NameAssignment ) )
            // InternalOCLX.g:393:3: ( rule__UnaryOperator__NameAssignment )
            {
             before(grammarAccess.getUnaryOperatorAccess().getNameAssignment()); 
            // InternalOCLX.g:394:3: ( rule__UnaryOperator__NameAssignment )
            // InternalOCLX.g:394:4: rule__UnaryOperator__NameAssignment
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
    // InternalOCLX.g:403:1: entryRulePrimaryExp : rulePrimaryExp EOF ;
    public final void entryRulePrimaryExp() throws RecognitionException {
        try {
            // InternalOCLX.g:404:1: ( rulePrimaryExp EOF )
            // InternalOCLX.g:405:1: rulePrimaryExp EOF
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
    // InternalOCLX.g:412:1: rulePrimaryExp : ( ( rule__PrimaryExp__Alternatives ) ) ;
    public final void rulePrimaryExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:416:2: ( ( ( rule__PrimaryExp__Alternatives ) ) )
            // InternalOCLX.g:417:2: ( ( rule__PrimaryExp__Alternatives ) )
            {
            // InternalOCLX.g:417:2: ( ( rule__PrimaryExp__Alternatives ) )
            // InternalOCLX.g:418:3: ( rule__PrimaryExp__Alternatives )
            {
             before(grammarAccess.getPrimaryExpAccess().getAlternatives()); 
            // InternalOCLX.g:419:3: ( rule__PrimaryExp__Alternatives )
            // InternalOCLX.g:419:4: rule__PrimaryExp__Alternatives
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
    // InternalOCLX.g:428:1: entryRuleNestedExp : ruleNestedExp EOF ;
    public final void entryRuleNestedExp() throws RecognitionException {
        try {
            // InternalOCLX.g:429:1: ( ruleNestedExp EOF )
            // InternalOCLX.g:430:1: ruleNestedExp EOF
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
    // InternalOCLX.g:437:1: ruleNestedExp : ( ( rule__NestedExp__Group__0 ) ) ;
    public final void ruleNestedExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:441:2: ( ( ( rule__NestedExp__Group__0 ) ) )
            // InternalOCLX.g:442:2: ( ( rule__NestedExp__Group__0 ) )
            {
            // InternalOCLX.g:442:2: ( ( rule__NestedExp__Group__0 ) )
            // InternalOCLX.g:443:3: ( rule__NestedExp__Group__0 )
            {
             before(grammarAccess.getNestedExpAccess().getGroup()); 
            // InternalOCLX.g:444:3: ( rule__NestedExp__Group__0 )
            // InternalOCLX.g:444:4: rule__NestedExp__Group__0
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
    // InternalOCLX.g:453:1: entryRuleVarOrSelfExp : ruleVarOrSelfExp EOF ;
    public final void entryRuleVarOrSelfExp() throws RecognitionException {
        try {
            // InternalOCLX.g:454:1: ( ruleVarOrSelfExp EOF )
            // InternalOCLX.g:455:1: ruleVarOrSelfExp EOF
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
    // InternalOCLX.g:462:1: ruleVarOrSelfExp : ( ( rule__VarOrSelfExp__Alternatives ) ) ;
    public final void ruleVarOrSelfExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:466:2: ( ( ( rule__VarOrSelfExp__Alternatives ) ) )
            // InternalOCLX.g:467:2: ( ( rule__VarOrSelfExp__Alternatives ) )
            {
            // InternalOCLX.g:467:2: ( ( rule__VarOrSelfExp__Alternatives ) )
            // InternalOCLX.g:468:3: ( rule__VarOrSelfExp__Alternatives )
            {
             before(grammarAccess.getVarOrSelfExpAccess().getAlternatives()); 
            // InternalOCLX.g:469:3: ( rule__VarOrSelfExp__Alternatives )
            // InternalOCLX.g:469:4: rule__VarOrSelfExp__Alternatives
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
    // InternalOCLX.g:478:1: entryRuleSelfExp : ruleSelfExp EOF ;
    public final void entryRuleSelfExp() throws RecognitionException {
        try {
            // InternalOCLX.g:479:1: ( ruleSelfExp EOF )
            // InternalOCLX.g:480:1: ruleSelfExp EOF
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
    // InternalOCLX.g:487:1: ruleSelfExp : ( ( rule__SelfExp__Group__0 ) ) ;
    public final void ruleSelfExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:491:2: ( ( ( rule__SelfExp__Group__0 ) ) )
            // InternalOCLX.g:492:2: ( ( rule__SelfExp__Group__0 ) )
            {
            // InternalOCLX.g:492:2: ( ( rule__SelfExp__Group__0 ) )
            // InternalOCLX.g:493:3: ( rule__SelfExp__Group__0 )
            {
             before(grammarAccess.getSelfExpAccess().getGroup()); 
            // InternalOCLX.g:494:3: ( rule__SelfExp__Group__0 )
            // InternalOCLX.g:494:4: rule__SelfExp__Group__0
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
    // InternalOCLX.g:503:1: entryRuleVarDeclaration : ruleVarDeclaration EOF ;
    public final void entryRuleVarDeclaration() throws RecognitionException {
        try {
            // InternalOCLX.g:504:1: ( ruleVarDeclaration EOF )
            // InternalOCLX.g:505:1: ruleVarDeclaration EOF
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
    // InternalOCLX.g:512:1: ruleVarDeclaration : ( ( rule__VarDeclaration__NameAssignment ) ) ;
    public final void ruleVarDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:516:2: ( ( ( rule__VarDeclaration__NameAssignment ) ) )
            // InternalOCLX.g:517:2: ( ( rule__VarDeclaration__NameAssignment ) )
            {
            // InternalOCLX.g:517:2: ( ( rule__VarDeclaration__NameAssignment ) )
            // InternalOCLX.g:518:3: ( rule__VarDeclaration__NameAssignment )
            {
             before(grammarAccess.getVarDeclarationAccess().getNameAssignment()); 
            // InternalOCLX.g:519:3: ( rule__VarDeclaration__NameAssignment )
            // InternalOCLX.g:519:4: rule__VarDeclaration__NameAssignment
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
    // InternalOCLX.g:528:1: entryRuleVarReference : ruleVarReference EOF ;
    public final void entryRuleVarReference() throws RecognitionException {
        try {
            // InternalOCLX.g:529:1: ( ruleVarReference EOF )
            // InternalOCLX.g:530:1: ruleVarReference EOF
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
    // InternalOCLX.g:537:1: ruleVarReference : ( ( rule__VarReference__RefAssignment ) ) ;
    public final void ruleVarReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:541:2: ( ( ( rule__VarReference__RefAssignment ) ) )
            // InternalOCLX.g:542:2: ( ( rule__VarReference__RefAssignment ) )
            {
            // InternalOCLX.g:542:2: ( ( rule__VarReference__RefAssignment ) )
            // InternalOCLX.g:543:3: ( rule__VarReference__RefAssignment )
            {
             before(grammarAccess.getVarReferenceAccess().getRefAssignment()); 
            // InternalOCLX.g:544:3: ( rule__VarReference__RefAssignment )
            // InternalOCLX.g:544:4: rule__VarReference__RefAssignment
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
    // InternalOCLX.g:553:1: entryRulePrimitiveLiteralExp : rulePrimitiveLiteralExp EOF ;
    public final void entryRulePrimitiveLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:554:1: ( rulePrimitiveLiteralExp EOF )
            // InternalOCLX.g:555:1: rulePrimitiveLiteralExp EOF
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
    // InternalOCLX.g:562:1: rulePrimitiveLiteralExp : ( ( rule__PrimitiveLiteralExp__Alternatives ) ) ;
    public final void rulePrimitiveLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:566:2: ( ( ( rule__PrimitiveLiteralExp__Alternatives ) ) )
            // InternalOCLX.g:567:2: ( ( rule__PrimitiveLiteralExp__Alternatives ) )
            {
            // InternalOCLX.g:567:2: ( ( rule__PrimitiveLiteralExp__Alternatives ) )
            // InternalOCLX.g:568:3: ( rule__PrimitiveLiteralExp__Alternatives )
            {
             before(grammarAccess.getPrimitiveLiteralExpAccess().getAlternatives()); 
            // InternalOCLX.g:569:3: ( rule__PrimitiveLiteralExp__Alternatives )
            // InternalOCLX.g:569:4: rule__PrimitiveLiteralExp__Alternatives
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


    // $ANTLR start "entryRuleIntLiteralExp"
    // InternalOCLX.g:578:1: entryRuleIntLiteralExp : ruleIntLiteralExp EOF ;
    public final void entryRuleIntLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:579:1: ( ruleIntLiteralExp EOF )
            // InternalOCLX.g:580:1: ruleIntLiteralExp EOF
            {
             before(grammarAccess.getIntLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            ruleIntLiteralExp();

            state._fsp--;

             after(grammarAccess.getIntLiteralExpRule()); 
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
    // $ANTLR end "entryRuleIntLiteralExp"


    // $ANTLR start "ruleIntLiteralExp"
    // InternalOCLX.g:587:1: ruleIntLiteralExp : ( ( rule__IntLiteralExp__ValueAssignment ) ) ;
    public final void ruleIntLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:591:2: ( ( ( rule__IntLiteralExp__ValueAssignment ) ) )
            // InternalOCLX.g:592:2: ( ( rule__IntLiteralExp__ValueAssignment ) )
            {
            // InternalOCLX.g:592:2: ( ( rule__IntLiteralExp__ValueAssignment ) )
            // InternalOCLX.g:593:3: ( rule__IntLiteralExp__ValueAssignment )
            {
             before(grammarAccess.getIntLiteralExpAccess().getValueAssignment()); 
            // InternalOCLX.g:594:3: ( rule__IntLiteralExp__ValueAssignment )
            // InternalOCLX.g:594:4: rule__IntLiteralExp__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__IntLiteralExp__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntLiteralExpAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntLiteralExp"


    // $ANTLR start "entryRuleStringLiteralExp"
    // InternalOCLX.g:603:1: entryRuleStringLiteralExp : ruleStringLiteralExp EOF ;
    public final void entryRuleStringLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:604:1: ( ruleStringLiteralExp EOF )
            // InternalOCLX.g:605:1: ruleStringLiteralExp EOF
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
    // InternalOCLX.g:612:1: ruleStringLiteralExp : ( ( rule__StringLiteralExp__ValueAssignment ) ) ;
    public final void ruleStringLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:616:2: ( ( ( rule__StringLiteralExp__ValueAssignment ) ) )
            // InternalOCLX.g:617:2: ( ( rule__StringLiteralExp__ValueAssignment ) )
            {
            // InternalOCLX.g:617:2: ( ( rule__StringLiteralExp__ValueAssignment ) )
            // InternalOCLX.g:618:3: ( rule__StringLiteralExp__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralExpAccess().getValueAssignment()); 
            // InternalOCLX.g:619:3: ( rule__StringLiteralExp__ValueAssignment )
            // InternalOCLX.g:619:4: rule__StringLiteralExp__ValueAssignment
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
    // InternalOCLX.g:628:1: entryRuleBooleanLiteralExp : ruleBooleanLiteralExp EOF ;
    public final void entryRuleBooleanLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:629:1: ( ruleBooleanLiteralExp EOF )
            // InternalOCLX.g:630:1: ruleBooleanLiteralExp EOF
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
    // InternalOCLX.g:637:1: ruleBooleanLiteralExp : ( ( rule__BooleanLiteralExp__Alternatives ) ) ;
    public final void ruleBooleanLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:641:2: ( ( ( rule__BooleanLiteralExp__Alternatives ) ) )
            // InternalOCLX.g:642:2: ( ( rule__BooleanLiteralExp__Alternatives ) )
            {
            // InternalOCLX.g:642:2: ( ( rule__BooleanLiteralExp__Alternatives ) )
            // InternalOCLX.g:643:3: ( rule__BooleanLiteralExp__Alternatives )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getAlternatives()); 
            // InternalOCLX.g:644:3: ( rule__BooleanLiteralExp__Alternatives )
            // InternalOCLX.g:644:4: rule__BooleanLiteralExp__Alternatives
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


    // $ANTLR start "entryRuleFloatLiteralExp"
    // InternalOCLX.g:653:1: entryRuleFloatLiteralExp : ruleFloatLiteralExp EOF ;
    public final void entryRuleFloatLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:654:1: ( ruleFloatLiteralExp EOF )
            // InternalOCLX.g:655:1: ruleFloatLiteralExp EOF
            {
             before(grammarAccess.getFloatLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            ruleFloatLiteralExp();

            state._fsp--;

             after(grammarAccess.getFloatLiteralExpRule()); 
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
    // $ANTLR end "entryRuleFloatLiteralExp"


    // $ANTLR start "ruleFloatLiteralExp"
    // InternalOCLX.g:662:1: ruleFloatLiteralExp : ( ( rule__FloatLiteralExp__ValueAssignment ) ) ;
    public final void ruleFloatLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:666:2: ( ( ( rule__FloatLiteralExp__ValueAssignment ) ) )
            // InternalOCLX.g:667:2: ( ( rule__FloatLiteralExp__ValueAssignment ) )
            {
            // InternalOCLX.g:667:2: ( ( rule__FloatLiteralExp__ValueAssignment ) )
            // InternalOCLX.g:668:3: ( rule__FloatLiteralExp__ValueAssignment )
            {
             before(grammarAccess.getFloatLiteralExpAccess().getValueAssignment()); 
            // InternalOCLX.g:669:3: ( rule__FloatLiteralExp__ValueAssignment )
            // InternalOCLX.g:669:4: rule__FloatLiteralExp__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__FloatLiteralExp__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getFloatLiteralExpAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFloatLiteralExp"


    // $ANTLR start "entryRuleMethodExp"
    // InternalOCLX.g:678:1: entryRuleMethodExp : ruleMethodExp EOF ;
    public final void entryRuleMethodExp() throws RecognitionException {
        try {
            // InternalOCLX.g:679:1: ( ruleMethodExp EOF )
            // InternalOCLX.g:680:1: ruleMethodExp EOF
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
    // InternalOCLX.g:687:1: ruleMethodExp : ( ( rule__MethodExp__Alternatives ) ) ;
    public final void ruleMethodExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:691:2: ( ( ( rule__MethodExp__Alternatives ) ) )
            // InternalOCLX.g:692:2: ( ( rule__MethodExp__Alternatives ) )
            {
            // InternalOCLX.g:692:2: ( ( rule__MethodExp__Alternatives ) )
            // InternalOCLX.g:693:3: ( rule__MethodExp__Alternatives )
            {
             before(grammarAccess.getMethodExpAccess().getAlternatives()); 
            // InternalOCLX.g:694:3: ( rule__MethodExp__Alternatives )
            // InternalOCLX.g:694:4: rule__MethodExp__Alternatives
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
    // InternalOCLX.g:703:1: entryRuleCollectionIterator : ruleCollectionIterator EOF ;
    public final void entryRuleCollectionIterator() throws RecognitionException {
        try {
            // InternalOCLX.g:704:1: ( ruleCollectionIterator EOF )
            // InternalOCLX.g:705:1: ruleCollectionIterator EOF
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
    // InternalOCLX.g:712:1: ruleCollectionIterator : ( ( rule__CollectionIterator__Group__0 ) ) ;
    public final void ruleCollectionIterator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:716:2: ( ( ( rule__CollectionIterator__Group__0 ) ) )
            // InternalOCLX.g:717:2: ( ( rule__CollectionIterator__Group__0 ) )
            {
            // InternalOCLX.g:717:2: ( ( rule__CollectionIterator__Group__0 ) )
            // InternalOCLX.g:718:3: ( rule__CollectionIterator__Group__0 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getGroup()); 
            // InternalOCLX.g:719:3: ( rule__CollectionIterator__Group__0 )
            // InternalOCLX.g:719:4: rule__CollectionIterator__Group__0
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
    // InternalOCLX.g:728:1: entryRuleIteratorName : ruleIteratorName EOF ;
    public final void entryRuleIteratorName() throws RecognitionException {
        try {
            // InternalOCLX.g:729:1: ( ruleIteratorName EOF )
            // InternalOCLX.g:730:1: ruleIteratorName EOF
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
    // InternalOCLX.g:737:1: ruleIteratorName : ( ( rule__IteratorName__NameAssignment ) ) ;
    public final void ruleIteratorName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:741:2: ( ( ( rule__IteratorName__NameAssignment ) ) )
            // InternalOCLX.g:742:2: ( ( rule__IteratorName__NameAssignment ) )
            {
            // InternalOCLX.g:742:2: ( ( rule__IteratorName__NameAssignment ) )
            // InternalOCLX.g:743:3: ( rule__IteratorName__NameAssignment )
            {
             before(grammarAccess.getIteratorNameAccess().getNameAssignment()); 
            // InternalOCLX.g:744:3: ( rule__IteratorName__NameAssignment )
            // InternalOCLX.g:744:4: rule__IteratorName__NameAssignment
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
    // InternalOCLX.g:753:1: entryRuleIteratorVarDeclaration : ruleIteratorVarDeclaration EOF ;
    public final void entryRuleIteratorVarDeclaration() throws RecognitionException {
        try {
            // InternalOCLX.g:754:1: ( ruleIteratorVarDeclaration EOF )
            // InternalOCLX.g:755:1: ruleIteratorVarDeclaration EOF
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
    // InternalOCLX.g:762:1: ruleIteratorVarDeclaration : ( ( rule__IteratorVarDeclaration__Alternatives ) ) ;
    public final void ruleIteratorVarDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:766:2: ( ( ( rule__IteratorVarDeclaration__Alternatives ) ) )
            // InternalOCLX.g:767:2: ( ( rule__IteratorVarDeclaration__Alternatives ) )
            {
            // InternalOCLX.g:767:2: ( ( rule__IteratorVarDeclaration__Alternatives ) )
            // InternalOCLX.g:768:3: ( rule__IteratorVarDeclaration__Alternatives )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getAlternatives()); 
            // InternalOCLX.g:769:3: ( rule__IteratorVarDeclaration__Alternatives )
            // InternalOCLX.g:769:4: rule__IteratorVarDeclaration__Alternatives
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
    // InternalOCLX.g:778:1: entryRulePropertyAccess : rulePropertyAccess EOF ;
    public final void entryRulePropertyAccess() throws RecognitionException {
        try {
            // InternalOCLX.g:779:1: ( rulePropertyAccess EOF )
            // InternalOCLX.g:780:1: rulePropertyAccess EOF
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
    // InternalOCLX.g:787:1: rulePropertyAccess : ( ( rule__PropertyAccess__NameAssignment ) ) ;
    public final void rulePropertyAccess() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:791:2: ( ( ( rule__PropertyAccess__NameAssignment ) ) )
            // InternalOCLX.g:792:2: ( ( rule__PropertyAccess__NameAssignment ) )
            {
            // InternalOCLX.g:792:2: ( ( rule__PropertyAccess__NameAssignment ) )
            // InternalOCLX.g:793:3: ( rule__PropertyAccess__NameAssignment )
            {
             before(grammarAccess.getPropertyAccessAccess().getNameAssignment()); 
            // InternalOCLX.g:794:3: ( rule__PropertyAccess__NameAssignment )
            // InternalOCLX.g:794:4: rule__PropertyAccess__NameAssignment
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
    // InternalOCLX.g:803:1: entryRuleMethodCall : ruleMethodCall EOF ;
    public final void entryRuleMethodCall() throws RecognitionException {
        try {
            // InternalOCLX.g:804:1: ( ruleMethodCall EOF )
            // InternalOCLX.g:805:1: ruleMethodCall EOF
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
    // InternalOCLX.g:812:1: ruleMethodCall : ( ( rule__MethodCall__Alternatives ) ) ;
    public final void ruleMethodCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:816:2: ( ( ( rule__MethodCall__Alternatives ) ) )
            // InternalOCLX.g:817:2: ( ( rule__MethodCall__Alternatives ) )
            {
            // InternalOCLX.g:817:2: ( ( rule__MethodCall__Alternatives ) )
            // InternalOCLX.g:818:3: ( rule__MethodCall__Alternatives )
            {
             before(grammarAccess.getMethodCallAccess().getAlternatives()); 
            // InternalOCLX.g:819:3: ( rule__MethodCall__Alternatives )
            // InternalOCLX.g:819:4: rule__MethodCall__Alternatives
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
    // InternalOCLX.g:828:1: entryRuleTypeCall : ruleTypeCall EOF ;
    public final void entryRuleTypeCall() throws RecognitionException {
        try {
            // InternalOCLX.g:829:1: ( ruleTypeCall EOF )
            // InternalOCLX.g:830:1: ruleTypeCall EOF
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
    // InternalOCLX.g:837:1: ruleTypeCall : ( ( rule__TypeCall__Group__0 ) ) ;
    public final void ruleTypeCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:841:2: ( ( ( rule__TypeCall__Group__0 ) ) )
            // InternalOCLX.g:842:2: ( ( rule__TypeCall__Group__0 ) )
            {
            // InternalOCLX.g:842:2: ( ( rule__TypeCall__Group__0 ) )
            // InternalOCLX.g:843:3: ( rule__TypeCall__Group__0 )
            {
             before(grammarAccess.getTypeCallAccess().getGroup()); 
            // InternalOCLX.g:844:3: ( rule__TypeCall__Group__0 )
            // InternalOCLX.g:844:4: rule__TypeCall__Group__0
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
    // InternalOCLX.g:853:1: entryRuleTypeExp : ruleTypeExp EOF ;
    public final void entryRuleTypeExp() throws RecognitionException {
        try {
            // InternalOCLX.g:854:1: ( ruleTypeExp EOF )
            // InternalOCLX.g:855:1: ruleTypeExp EOF
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
    // InternalOCLX.g:862:1: ruleTypeExp : ( ( rule__TypeExp__Alternatives ) ) ;
    public final void ruleTypeExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:866:2: ( ( ( rule__TypeExp__Alternatives ) ) )
            // InternalOCLX.g:867:2: ( ( rule__TypeExp__Alternatives ) )
            {
            // InternalOCLX.g:867:2: ( ( rule__TypeExp__Alternatives ) )
            // InternalOCLX.g:868:3: ( rule__TypeExp__Alternatives )
            {
             before(grammarAccess.getTypeExpAccess().getAlternatives()); 
            // InternalOCLX.g:869:3: ( rule__TypeExp__Alternatives )
            // InternalOCLX.g:869:4: rule__TypeExp__Alternatives
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
    // InternalOCLX.g:878:1: entryRuleCollectionTypeIdentifier : ruleCollectionTypeIdentifier EOF ;
    public final void entryRuleCollectionTypeIdentifier() throws RecognitionException {
        try {
            // InternalOCLX.g:879:1: ( ruleCollectionTypeIdentifier EOF )
            // InternalOCLX.g:880:1: ruleCollectionTypeIdentifier EOF
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
    // InternalOCLX.g:887:1: ruleCollectionTypeIdentifier : ( ( rule__CollectionTypeIdentifier__NameAssignment ) ) ;
    public final void ruleCollectionTypeIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:891:2: ( ( ( rule__CollectionTypeIdentifier__NameAssignment ) ) )
            // InternalOCLX.g:892:2: ( ( rule__CollectionTypeIdentifier__NameAssignment ) )
            {
            // InternalOCLX.g:892:2: ( ( rule__CollectionTypeIdentifier__NameAssignment ) )
            // InternalOCLX.g:893:3: ( rule__CollectionTypeIdentifier__NameAssignment )
            {
             before(grammarAccess.getCollectionTypeIdentifierAccess().getNameAssignment()); 
            // InternalOCLX.g:894:3: ( rule__CollectionTypeIdentifier__NameAssignment )
            // InternalOCLX.g:894:4: rule__CollectionTypeIdentifier__NameAssignment
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
    // InternalOCLX.g:903:1: entryRuleTemporalExp : ruleTemporalExp EOF ;
    public final void entryRuleTemporalExp() throws RecognitionException {
        try {
            // InternalOCLX.g:904:1: ( ruleTemporalExp EOF )
            // InternalOCLX.g:905:1: ruleTemporalExp EOF
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
    // InternalOCLX.g:912:1: ruleTemporalExp : ( ( rule__TemporalExp__Alternatives ) ) ;
    public final void ruleTemporalExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:916:2: ( ( ( rule__TemporalExp__Alternatives ) ) )
            // InternalOCLX.g:917:2: ( ( rule__TemporalExp__Alternatives ) )
            {
            // InternalOCLX.g:917:2: ( ( rule__TemporalExp__Alternatives ) )
            // InternalOCLX.g:918:3: ( rule__TemporalExp__Alternatives )
            {
             before(grammarAccess.getTemporalExpAccess().getAlternatives()); 
            // InternalOCLX.g:919:3: ( rule__TemporalExp__Alternatives )
            // InternalOCLX.g:919:4: rule__TemporalExp__Alternatives
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
    // InternalOCLX.g:928:1: entryRuleUnaryTemporalExp : ruleUnaryTemporalExp EOF ;
    public final void entryRuleUnaryTemporalExp() throws RecognitionException {
        try {
            // InternalOCLX.g:929:1: ( ruleUnaryTemporalExp EOF )
            // InternalOCLX.g:930:1: ruleUnaryTemporalExp EOF
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
    // InternalOCLX.g:937:1: ruleUnaryTemporalExp : ( ( rule__UnaryTemporalExp__Group__0 ) ) ;
    public final void ruleUnaryTemporalExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:941:2: ( ( ( rule__UnaryTemporalExp__Group__0 ) ) )
            // InternalOCLX.g:942:2: ( ( rule__UnaryTemporalExp__Group__0 ) )
            {
            // InternalOCLX.g:942:2: ( ( rule__UnaryTemporalExp__Group__0 ) )
            // InternalOCLX.g:943:3: ( rule__UnaryTemporalExp__Group__0 )
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getGroup()); 
            // InternalOCLX.g:944:3: ( rule__UnaryTemporalExp__Group__0 )
            // InternalOCLX.g:944:4: rule__UnaryTemporalExp__Group__0
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
    // InternalOCLX.g:953:1: entryRuleUnaryTemporalOp : ruleUnaryTemporalOp EOF ;
    public final void entryRuleUnaryTemporalOp() throws RecognitionException {
        try {
            // InternalOCLX.g:954:1: ( ruleUnaryTemporalOp EOF )
            // InternalOCLX.g:955:1: ruleUnaryTemporalOp EOF
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
    // InternalOCLX.g:962:1: ruleUnaryTemporalOp : ( ( rule__UnaryTemporalOp__Alternatives ) ) ;
    public final void ruleUnaryTemporalOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:966:2: ( ( ( rule__UnaryTemporalOp__Alternatives ) ) )
            // InternalOCLX.g:967:2: ( ( rule__UnaryTemporalOp__Alternatives ) )
            {
            // InternalOCLX.g:967:2: ( ( rule__UnaryTemporalOp__Alternatives ) )
            // InternalOCLX.g:968:3: ( rule__UnaryTemporalOp__Alternatives )
            {
             before(grammarAccess.getUnaryTemporalOpAccess().getAlternatives()); 
            // InternalOCLX.g:969:3: ( rule__UnaryTemporalOp__Alternatives )
            // InternalOCLX.g:969:4: rule__UnaryTemporalOp__Alternatives
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
    // InternalOCLX.g:978:1: entryRuleTriggeredTemporalExp : ruleTriggeredTemporalExp EOF ;
    public final void entryRuleTriggeredTemporalExp() throws RecognitionException {
        try {
            // InternalOCLX.g:979:1: ( ruleTriggeredTemporalExp EOF )
            // InternalOCLX.g:980:1: ruleTriggeredTemporalExp EOF
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
    // InternalOCLX.g:987:1: ruleTriggeredTemporalExp : ( ( rule__TriggeredTemporalExp__Alternatives ) ) ;
    public final void ruleTriggeredTemporalExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:991:2: ( ( ( rule__TriggeredTemporalExp__Alternatives ) ) )
            // InternalOCLX.g:992:2: ( ( rule__TriggeredTemporalExp__Alternatives ) )
            {
            // InternalOCLX.g:992:2: ( ( rule__TriggeredTemporalExp__Alternatives ) )
            // InternalOCLX.g:993:3: ( rule__TriggeredTemporalExp__Alternatives )
            {
             before(grammarAccess.getTriggeredTemporalExpAccess().getAlternatives()); 
            // InternalOCLX.g:994:3: ( rule__TriggeredTemporalExp__Alternatives )
            // InternalOCLX.g:994:4: rule__TriggeredTemporalExp__Alternatives
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
    // InternalOCLX.g:1003:1: entryRuleTemporalAsLongAs : ruleTemporalAsLongAs EOF ;
    public final void entryRuleTemporalAsLongAs() throws RecognitionException {
        try {
            // InternalOCLX.g:1004:1: ( ruleTemporalAsLongAs EOF )
            // InternalOCLX.g:1005:1: ruleTemporalAsLongAs EOF
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
    // InternalOCLX.g:1012:1: ruleTemporalAsLongAs : ( ( rule__TemporalAsLongAs__Group__0 ) ) ;
    public final void ruleTemporalAsLongAs() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1016:2: ( ( ( rule__TemporalAsLongAs__Group__0 ) ) )
            // InternalOCLX.g:1017:2: ( ( rule__TemporalAsLongAs__Group__0 ) )
            {
            // InternalOCLX.g:1017:2: ( ( rule__TemporalAsLongAs__Group__0 ) )
            // InternalOCLX.g:1018:3: ( rule__TemporalAsLongAs__Group__0 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getGroup()); 
            // InternalOCLX.g:1019:3: ( rule__TemporalAsLongAs__Group__0 )
            // InternalOCLX.g:1019:4: rule__TemporalAsLongAs__Group__0
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
    // InternalOCLX.g:1028:1: entryRuleTemporalUntil : ruleTemporalUntil EOF ;
    public final void entryRuleTemporalUntil() throws RecognitionException {
        try {
            // InternalOCLX.g:1029:1: ( ruleTemporalUntil EOF )
            // InternalOCLX.g:1030:1: ruleTemporalUntil EOF
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
    // InternalOCLX.g:1037:1: ruleTemporalUntil : ( ( rule__TemporalUntil__Group__0 ) ) ;
    public final void ruleTemporalUntil() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1041:2: ( ( ( rule__TemporalUntil__Group__0 ) ) )
            // InternalOCLX.g:1042:2: ( ( rule__TemporalUntil__Group__0 ) )
            {
            // InternalOCLX.g:1042:2: ( ( rule__TemporalUntil__Group__0 ) )
            // InternalOCLX.g:1043:3: ( rule__TemporalUntil__Group__0 )
            {
             before(grammarAccess.getTemporalUntilAccess().getGroup()); 
            // InternalOCLX.g:1044:3: ( rule__TemporalUntil__Group__0 )
            // InternalOCLX.g:1044:4: rule__TemporalUntil__Group__0
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
    // InternalOCLX.g:1053:1: entryRuleTemporalEverytime : ruleTemporalEverytime EOF ;
    public final void entryRuleTemporalEverytime() throws RecognitionException {
        try {
            // InternalOCLX.g:1054:1: ( ruleTemporalEverytime EOF )
            // InternalOCLX.g:1055:1: ruleTemporalEverytime EOF
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
    // InternalOCLX.g:1062:1: ruleTemporalEverytime : ( ( rule__TemporalEverytime__Group__0 ) ) ;
    public final void ruleTemporalEverytime() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1066:2: ( ( ( rule__TemporalEverytime__Group__0 ) ) )
            // InternalOCLX.g:1067:2: ( ( rule__TemporalEverytime__Group__0 ) )
            {
            // InternalOCLX.g:1067:2: ( ( rule__TemporalEverytime__Group__0 ) )
            // InternalOCLX.g:1068:3: ( rule__TemporalEverytime__Group__0 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getGroup()); 
            // InternalOCLX.g:1069:3: ( rule__TemporalEverytime__Group__0 )
            // InternalOCLX.g:1069:4: rule__TemporalEverytime__Group__0
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
    // InternalOCLX.g:1078:1: entryRuleTemporalAtLeastOnce : ruleTemporalAtLeastOnce EOF ;
    public final void entryRuleTemporalAtLeastOnce() throws RecognitionException {
        try {
            // InternalOCLX.g:1079:1: ( ruleTemporalAtLeastOnce EOF )
            // InternalOCLX.g:1080:1: ruleTemporalAtLeastOnce EOF
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
    // InternalOCLX.g:1087:1: ruleTemporalAtLeastOnce : ( ( rule__TemporalAtLeastOnce__Group__0 ) ) ;
    public final void ruleTemporalAtLeastOnce() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1091:2: ( ( ( rule__TemporalAtLeastOnce__Group__0 ) ) )
            // InternalOCLX.g:1092:2: ( ( rule__TemporalAtLeastOnce__Group__0 ) )
            {
            // InternalOCLX.g:1092:2: ( ( rule__TemporalAtLeastOnce__Group__0 ) )
            // InternalOCLX.g:1093:3: ( rule__TemporalAtLeastOnce__Group__0 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getGroup()); 
            // InternalOCLX.g:1094:3: ( rule__TemporalAtLeastOnce__Group__0 )
            // InternalOCLX.g:1094:4: rule__TemporalAtLeastOnce__Group__0
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
    // InternalOCLX.g:1103:1: entryRuleLegacyUntil : ruleLegacyUntil EOF ;
    public final void entryRuleLegacyUntil() throws RecognitionException {
        try {
            // InternalOCLX.g:1104:1: ( ruleLegacyUntil EOF )
            // InternalOCLX.g:1105:1: ruleLegacyUntil EOF
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
    // InternalOCLX.g:1112:1: ruleLegacyUntil : ( ( rule__LegacyUntil__Group__0 ) ) ;
    public final void ruleLegacyUntil() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1116:2: ( ( ( rule__LegacyUntil__Group__0 ) ) )
            // InternalOCLX.g:1117:2: ( ( rule__LegacyUntil__Group__0 ) )
            {
            // InternalOCLX.g:1117:2: ( ( rule__LegacyUntil__Group__0 ) )
            // InternalOCLX.g:1118:3: ( rule__LegacyUntil__Group__0 )
            {
             before(grammarAccess.getLegacyUntilAccess().getGroup()); 
            // InternalOCLX.g:1119:3: ( rule__LegacyUntil__Group__0 )
            // InternalOCLX.g:1119:4: rule__LegacyUntil__Group__0
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
    // InternalOCLX.g:1128:1: entryRuleLegacyAsSoonAs : ruleLegacyAsSoonAs EOF ;
    public final void entryRuleLegacyAsSoonAs() throws RecognitionException {
        try {
            // InternalOCLX.g:1129:1: ( ruleLegacyAsSoonAs EOF )
            // InternalOCLX.g:1130:1: ruleLegacyAsSoonAs EOF
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
    // InternalOCLX.g:1137:1: ruleLegacyAsSoonAs : ( ( rule__LegacyAsSoonAs__Group__0 ) ) ;
    public final void ruleLegacyAsSoonAs() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1141:2: ( ( ( rule__LegacyAsSoonAs__Group__0 ) ) )
            // InternalOCLX.g:1142:2: ( ( rule__LegacyAsSoonAs__Group__0 ) )
            {
            // InternalOCLX.g:1142:2: ( ( rule__LegacyAsSoonAs__Group__0 ) )
            // InternalOCLX.g:1143:3: ( rule__LegacyAsSoonAs__Group__0 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getGroup()); 
            // InternalOCLX.g:1144:3: ( rule__LegacyAsSoonAs__Group__0 )
            // InternalOCLX.g:1144:4: rule__LegacyAsSoonAs__Group__0
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
    // InternalOCLX.g:1153:1: entryRuleLegacyEverytime : ruleLegacyEverytime EOF ;
    public final void entryRuleLegacyEverytime() throws RecognitionException {
        try {
            // InternalOCLX.g:1154:1: ( ruleLegacyEverytime EOF )
            // InternalOCLX.g:1155:1: ruleLegacyEverytime EOF
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
    // InternalOCLX.g:1162:1: ruleLegacyEverytime : ( ( rule__LegacyEverytime__Group__0 ) ) ;
    public final void ruleLegacyEverytime() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1166:2: ( ( ( rule__LegacyEverytime__Group__0 ) ) )
            // InternalOCLX.g:1167:2: ( ( rule__LegacyEverytime__Group__0 ) )
            {
            // InternalOCLX.g:1167:2: ( ( rule__LegacyEverytime__Group__0 ) )
            // InternalOCLX.g:1168:3: ( rule__LegacyEverytime__Group__0 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getGroup()); 
            // InternalOCLX.g:1169:3: ( rule__LegacyEverytime__Group__0 )
            // InternalOCLX.g:1169:4: rule__LegacyEverytime__Group__0
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
    // InternalOCLX.g:1178:1: entryRulePath : rulePath EOF ;
    public final void entryRulePath() throws RecognitionException {
        try {
            // InternalOCLX.g:1179:1: ( rulePath EOF )
            // InternalOCLX.g:1180:1: rulePath EOF
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
    // InternalOCLX.g:1187:1: rulePath : ( ( rule__Path__Group__0 ) ) ;
    public final void rulePath() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1191:2: ( ( ( rule__Path__Group__0 ) ) )
            // InternalOCLX.g:1192:2: ( ( rule__Path__Group__0 ) )
            {
            // InternalOCLX.g:1192:2: ( ( rule__Path__Group__0 ) )
            // InternalOCLX.g:1193:3: ( rule__Path__Group__0 )
            {
             before(grammarAccess.getPathAccess().getGroup()); 
            // InternalOCLX.g:1194:3: ( rule__Path__Group__0 )
            // InternalOCLX.g:1194:4: rule__Path__Group__0
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
    // InternalOCLX.g:1203:1: entryRuleArgumentsExp : ruleArgumentsExp EOF ;
    public final void entryRuleArgumentsExp() throws RecognitionException {
        try {
            // InternalOCLX.g:1204:1: ( ruleArgumentsExp EOF )
            // InternalOCLX.g:1205:1: ruleArgumentsExp EOF
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
    // InternalOCLX.g:1212:1: ruleArgumentsExp : ( ( rule__ArgumentsExp__Group__0 ) ) ;
    public final void ruleArgumentsExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1216:2: ( ( ( rule__ArgumentsExp__Group__0 ) ) )
            // InternalOCLX.g:1217:2: ( ( rule__ArgumentsExp__Group__0 ) )
            {
            // InternalOCLX.g:1217:2: ( ( rule__ArgumentsExp__Group__0 ) )
            // InternalOCLX.g:1218:3: ( rule__ArgumentsExp__Group__0 )
            {
             before(grammarAccess.getArgumentsExpAccess().getGroup()); 
            // InternalOCLX.g:1219:3: ( rule__ArgumentsExp__Group__0 )
            // InternalOCLX.g:1219:4: rule__ArgumentsExp__Group__0
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
    // InternalOCLX.g:1227:1: rule__PrefixedExp__Alternatives : ( ( ( rule__PrefixedExp__Group_0__0 ) ) | ( rulePrimaryExp ) );
    public final void rule__PrefixedExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1231:1: ( ( ( rule__PrefixedExp__Group_0__0 ) ) | ( rulePrimaryExp ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==25||LA2_0==28) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_INT)||LA2_0==RULE_STRING||(LA2_0>=41 && LA2_0<=43)||LA2_0==52||(LA2_0>=57 && LA2_0<=58)||(LA2_0>=62 && LA2_0<=69)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalOCLX.g:1232:2: ( ( rule__PrefixedExp__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1232:2: ( ( rule__PrefixedExp__Group_0__0 ) )
                    // InternalOCLX.g:1233:3: ( rule__PrefixedExp__Group_0__0 )
                    {
                     before(grammarAccess.getPrefixedExpAccess().getGroup_0()); 
                    // InternalOCLX.g:1234:3: ( rule__PrefixedExp__Group_0__0 )
                    // InternalOCLX.g:1234:4: rule__PrefixedExp__Group_0__0
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
                    // InternalOCLX.g:1238:2: ( rulePrimaryExp )
                    {
                    // InternalOCLX.g:1238:2: ( rulePrimaryExp )
                    // InternalOCLX.g:1239:3: rulePrimaryExp
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
    // InternalOCLX.g:1248:1: rule__InfixOperator__Alternatives : ( ( ruleBooleanOperator ) | ( ruleMathOperator ) );
    public final void rule__InfixOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1252:1: ( ( ruleBooleanOperator ) | ( ruleMathOperator ) )
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
                    // InternalOCLX.g:1253:2: ( ruleBooleanOperator )
                    {
                    // InternalOCLX.g:1253:2: ( ruleBooleanOperator )
                    // InternalOCLX.g:1254:3: ruleBooleanOperator
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
                    // InternalOCLX.g:1259:2: ( ruleMathOperator )
                    {
                    // InternalOCLX.g:1259:2: ( ruleMathOperator )
                    // InternalOCLX.g:1260:3: ruleMathOperator
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
    // InternalOCLX.g:1269:1: rule__BooleanOperator__OpAlternatives_0 : ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '<>' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) );
    public final void rule__BooleanOperator__OpAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1273:1: ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '<>' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) )
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
                    // InternalOCLX.g:1274:2: ( '>' )
                    {
                    // InternalOCLX.g:1274:2: ( '>' )
                    // InternalOCLX.g:1275:3: '>'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1280:2: ( '<' )
                    {
                    // InternalOCLX.g:1280:2: ( '<' )
                    // InternalOCLX.g:1281:3: '<'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1286:2: ( '>=' )
                    {
                    // InternalOCLX.g:1286:2: ( '>=' )
                    // InternalOCLX.g:1287:3: '>='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1292:2: ( '<=' )
                    {
                    // InternalOCLX.g:1292:2: ( '<=' )
                    // InternalOCLX.g:1293:3: '<='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1298:2: ( '=' )
                    {
                    // InternalOCLX.g:1298:2: ( '=' )
                    // InternalOCLX.g:1299:3: '='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOCLX.g:1304:2: ( '<>' )
                    {
                    // InternalOCLX.g:1304:2: ( '<>' )
                    // InternalOCLX.g:1305:3: '<>'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignGreaterThanSignKeyword_0_5()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignGreaterThanSignKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalOCLX.g:1310:2: ( 'and' )
                    {
                    // InternalOCLX.g:1310:2: ( 'and' )
                    // InternalOCLX.g:1311:3: 'and'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalOCLX.g:1316:2: ( 'or' )
                    {
                    // InternalOCLX.g:1316:2: ( 'or' )
                    // InternalOCLX.g:1317:3: 'or'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalOCLX.g:1322:2: ( 'xor' )
                    {
                    // InternalOCLX.g:1322:2: ( 'xor' )
                    // InternalOCLX.g:1323:3: 'xor'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalOCLX.g:1328:2: ( 'implies' )
                    {
                    // InternalOCLX.g:1328:2: ( 'implies' )
                    // InternalOCLX.g:1329:3: 'implies'
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
    // InternalOCLX.g:1338:1: rule__MathOperator__OpAlternatives_0 : ( ( '*' ) | ( '/' ) | ( '+' ) | ( '-' ) );
    public final void rule__MathOperator__OpAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1342:1: ( ( '*' ) | ( '/' ) | ( '+' ) | ( '-' ) )
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
                    // InternalOCLX.g:1343:2: ( '*' )
                    {
                    // InternalOCLX.g:1343:2: ( '*' )
                    // InternalOCLX.g:1344:3: '*'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1349:2: ( '/' )
                    {
                    // InternalOCLX.g:1349:2: ( '/' )
                    // InternalOCLX.g:1350:3: '/'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1355:2: ( '+' )
                    {
                    // InternalOCLX.g:1355:2: ( '+' )
                    // InternalOCLX.g:1356:3: '+'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1361:2: ( '-' )
                    {
                    // InternalOCLX.g:1361:2: ( '-' )
                    // InternalOCLX.g:1362:3: '-'
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
    // InternalOCLX.g:1371:1: rule__NavigationOperator__NameAlternatives_0 : ( ( '.' ) | ( '->' ) );
    public final void rule__NavigationOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1375:1: ( ( '.' ) | ( '->' ) )
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
                    // InternalOCLX.g:1376:2: ( '.' )
                    {
                    // InternalOCLX.g:1376:2: ( '.' )
                    // InternalOCLX.g:1377:3: '.'
                    {
                     before(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1382:2: ( '->' )
                    {
                    // InternalOCLX.g:1382:2: ( '->' )
                    // InternalOCLX.g:1383:3: '->'
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
    // InternalOCLX.g:1392:1: rule__UnaryOperator__NameAlternatives_0 : ( ( '-' ) | ( 'not' ) );
    public final void rule__UnaryOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1396:1: ( ( '-' ) | ( 'not' ) )
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
                    // InternalOCLX.g:1397:2: ( '-' )
                    {
                    // InternalOCLX.g:1397:2: ( '-' )
                    // InternalOCLX.g:1398:3: '-'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1403:2: ( 'not' )
                    {
                    // InternalOCLX.g:1403:2: ( 'not' )
                    // InternalOCLX.g:1404:3: 'not'
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
    // InternalOCLX.g:1413:1: rule__PrimaryExp__Alternatives : ( ( ruleNestedExp ) | ( ( rule__PrimaryExp__Group_1__0 ) ) | ( rulePrimitiveLiteralExp ) | ( ruleTemporalExp ) );
    public final void rule__PrimaryExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1417:1: ( ( ruleNestedExp ) | ( ( rule__PrimaryExp__Group_1__0 ) ) | ( rulePrimitiveLiteralExp ) | ( ruleTemporalExp ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt8=1;
                }
                break;
            case RULE_ID:
            case 62:
                {
                alt8=2;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 63:
            case 64:
                {
                alt8=3;
                }
                break;
            case 41:
            case 42:
            case 43:
            case 57:
            case 58:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
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
                    // InternalOCLX.g:1418:2: ( ruleNestedExp )
                    {
                    // InternalOCLX.g:1418:2: ( ruleNestedExp )
                    // InternalOCLX.g:1419:3: ruleNestedExp
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
                    // InternalOCLX.g:1424:2: ( ( rule__PrimaryExp__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1424:2: ( ( rule__PrimaryExp__Group_1__0 ) )
                    // InternalOCLX.g:1425:3: ( rule__PrimaryExp__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpAccess().getGroup_1()); 
                    // InternalOCLX.g:1426:3: ( rule__PrimaryExp__Group_1__0 )
                    // InternalOCLX.g:1426:4: rule__PrimaryExp__Group_1__0
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
                    // InternalOCLX.g:1430:2: ( rulePrimitiveLiteralExp )
                    {
                    // InternalOCLX.g:1430:2: ( rulePrimitiveLiteralExp )
                    // InternalOCLX.g:1431:3: rulePrimitiveLiteralExp
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
                    // InternalOCLX.g:1436:2: ( ruleTemporalExp )
                    {
                    // InternalOCLX.g:1436:2: ( ruleTemporalExp )
                    // InternalOCLX.g:1437:3: ruleTemporalExp
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
    // InternalOCLX.g:1446:1: rule__VarOrSelfExp__Alternatives : ( ( ruleSelfExp ) | ( ruleVarReference ) );
    public final void rule__VarOrSelfExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1450:1: ( ( ruleSelfExp ) | ( ruleVarReference ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==62) ) {
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
                    // InternalOCLX.g:1451:2: ( ruleSelfExp )
                    {
                    // InternalOCLX.g:1451:2: ( ruleSelfExp )
                    // InternalOCLX.g:1452:3: ruleSelfExp
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
                    // InternalOCLX.g:1457:2: ( ruleVarReference )
                    {
                    // InternalOCLX.g:1457:2: ( ruleVarReference )
                    // InternalOCLX.g:1458:3: ruleVarReference
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
    // InternalOCLX.g:1467:1: rule__PrimitiveLiteralExp__Alternatives : ( ( ruleIntLiteralExp ) | ( ruleStringLiteralExp ) | ( ruleBooleanLiteralExp ) | ( ruleFloatLiteralExp ) );
    public final void rule__PrimitiveLiteralExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1471:1: ( ( ruleIntLiteralExp ) | ( ruleStringLiteralExp ) | ( ruleBooleanLiteralExp ) | ( ruleFloatLiteralExp ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==EOF||(LA10_1>=12 && LA10_1<=25)||LA10_1==48||LA10_1==53||(LA10_1>=57 && LA10_1<=61)) ) {
                    alt10=1;
                }
                else if ( (LA10_1==26) ) {
                    alt10=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                alt10=2;
                }
                break;
            case 63:
            case 64:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalOCLX.g:1472:2: ( ruleIntLiteralExp )
                    {
                    // InternalOCLX.g:1472:2: ( ruleIntLiteralExp )
                    // InternalOCLX.g:1473:3: ruleIntLiteralExp
                    {
                     before(grammarAccess.getPrimitiveLiteralExpAccess().getIntLiteralExpParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIntLiteralExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveLiteralExpAccess().getIntLiteralExpParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1478:2: ( ruleStringLiteralExp )
                    {
                    // InternalOCLX.g:1478:2: ( ruleStringLiteralExp )
                    // InternalOCLX.g:1479:3: ruleStringLiteralExp
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
                    // InternalOCLX.g:1484:2: ( ruleBooleanLiteralExp )
                    {
                    // InternalOCLX.g:1484:2: ( ruleBooleanLiteralExp )
                    // InternalOCLX.g:1485:3: ruleBooleanLiteralExp
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
                    // InternalOCLX.g:1490:2: ( ruleFloatLiteralExp )
                    {
                    // InternalOCLX.g:1490:2: ( ruleFloatLiteralExp )
                    // InternalOCLX.g:1491:3: ruleFloatLiteralExp
                    {
                     before(grammarAccess.getPrimitiveLiteralExpAccess().getFloatLiteralExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleFloatLiteralExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveLiteralExpAccess().getFloatLiteralExpParserRuleCall_3()); 

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
    // InternalOCLX.g:1500:1: rule__BooleanLiteralExp__Alternatives : ( ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) ) | ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) ) );
    public final void rule__BooleanLiteralExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1504:1: ( ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) ) | ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==63) ) {
                alt11=1;
            }
            else if ( (LA11_0==64) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalOCLX.g:1505:2: ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) )
                    {
                    // InternalOCLX.g:1505:2: ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) )
                    // InternalOCLX.g:1506:3: ( rule__BooleanLiteralExp__ValueAssignment_0 )
                    {
                     before(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_0()); 
                    // InternalOCLX.g:1507:3: ( rule__BooleanLiteralExp__ValueAssignment_0 )
                    // InternalOCLX.g:1507:4: rule__BooleanLiteralExp__ValueAssignment_0
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
                    // InternalOCLX.g:1511:2: ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) )
                    {
                    // InternalOCLX.g:1511:2: ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) )
                    // InternalOCLX.g:1512:3: ( rule__BooleanLiteralExp__ValueAssignment_1 )
                    {
                     before(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_1()); 
                    // InternalOCLX.g:1513:3: ( rule__BooleanLiteralExp__ValueAssignment_1 )
                    // InternalOCLX.g:1513:4: rule__BooleanLiteralExp__ValueAssignment_1
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
    // InternalOCLX.g:1521:1: rule__MethodExp__Alternatives : ( ( rulePropertyAccess ) | ( ruleMethodCall ) | ( ruleCollectionIterator ) | ( ruleTypeCall ) );
    public final void rule__MethodExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1525:1: ( ( rulePropertyAccess ) | ( ruleMethodCall ) | ( ruleCollectionIterator ) | ( ruleTypeCall ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==52||LA12_1==56) ) {
                    alt12=2;
                }
                else if ( (LA12_1==EOF||(LA12_1>=12 && LA12_1<=27)||LA12_1==48||LA12_1==53||(LA12_1>=57 && LA12_1<=61)) ) {
                    alt12=1;
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
                    // InternalOCLX.g:1526:2: ( rulePropertyAccess )
                    {
                    // InternalOCLX.g:1526:2: ( rulePropertyAccess )
                    // InternalOCLX.g:1527:3: rulePropertyAccess
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
                    // InternalOCLX.g:1532:2: ( ruleMethodCall )
                    {
                    // InternalOCLX.g:1532:2: ( ruleMethodCall )
                    // InternalOCLX.g:1533:3: ruleMethodCall
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
                    // InternalOCLX.g:1538:2: ( ruleCollectionIterator )
                    {
                    // InternalOCLX.g:1538:2: ( ruleCollectionIterator )
                    // InternalOCLX.g:1539:3: ruleCollectionIterator
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
                    // InternalOCLX.g:1544:2: ( ruleTypeCall )
                    {
                    // InternalOCLX.g:1544:2: ( ruleTypeCall )
                    // InternalOCLX.g:1545:3: ruleTypeCall
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
    // InternalOCLX.g:1554:1: rule__IteratorName__NameAlternatives_0 : ( ( 'forAll' ) | ( 'exists' ) | ( 'collect' ) | ( 'reject' ) | ( 'select' ) );
    public final void rule__IteratorName__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1558:1: ( ( 'forAll' ) | ( 'exists' ) | ( 'collect' ) | ( 'reject' ) | ( 'select' ) )
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
                    // InternalOCLX.g:1559:2: ( 'forAll' )
                    {
                    // InternalOCLX.g:1559:2: ( 'forAll' )
                    // InternalOCLX.g:1560:3: 'forAll'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameForAllKeyword_0_0()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameForAllKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1565:2: ( 'exists' )
                    {
                    // InternalOCLX.g:1565:2: ( 'exists' )
                    // InternalOCLX.g:1566:3: 'exists'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameExistsKeyword_0_1()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameExistsKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1571:2: ( 'collect' )
                    {
                    // InternalOCLX.g:1571:2: ( 'collect' )
                    // InternalOCLX.g:1572:3: 'collect'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameCollectKeyword_0_2()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameCollectKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1577:2: ( 'reject' )
                    {
                    // InternalOCLX.g:1577:2: ( 'reject' )
                    // InternalOCLX.g:1578:3: 'reject'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameRejectKeyword_0_3()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameRejectKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1583:2: ( 'select' )
                    {
                    // InternalOCLX.g:1583:2: ( 'select' )
                    // InternalOCLX.g:1584:3: 'select'
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
    // InternalOCLX.g:1593:1: rule__IteratorVarDeclaration__Alternatives : ( ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) ) | ( ( rule__IteratorVarDeclaration__Group_1__0 ) ) );
    public final void rule__IteratorVarDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1597:1: ( ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) ) | ( ( rule__IteratorVarDeclaration__Group_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==55) ) {
                    alt14=2;
                }
                else if ( (LA14_1==EOF||LA14_1==54) ) {
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
                    // InternalOCLX.g:1598:2: ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) )
                    {
                    // InternalOCLX.g:1598:2: ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) )
                    // InternalOCLX.g:1599:3: ( rule__IteratorVarDeclaration__NameAssignment_0 )
                    {
                     before(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_0()); 
                    // InternalOCLX.g:1600:3: ( rule__IteratorVarDeclaration__NameAssignment_0 )
                    // InternalOCLX.g:1600:4: rule__IteratorVarDeclaration__NameAssignment_0
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
                    // InternalOCLX.g:1604:2: ( ( rule__IteratorVarDeclaration__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1604:2: ( ( rule__IteratorVarDeclaration__Group_1__0 ) )
                    // InternalOCLX.g:1605:3: ( rule__IteratorVarDeclaration__Group_1__0 )
                    {
                     before(grammarAccess.getIteratorVarDeclarationAccess().getGroup_1()); 
                    // InternalOCLX.g:1606:3: ( rule__IteratorVarDeclaration__Group_1__0 )
                    // InternalOCLX.g:1606:4: rule__IteratorVarDeclaration__Group_1__0
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
    // InternalOCLX.g:1614:1: rule__MethodCall__Alternatives : ( ( ( rule__MethodCall__Group_0__0 ) ) | ( ( rule__MethodCall__Group_1__0 ) ) );
    public final void rule__MethodCall__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1618:1: ( ( ( rule__MethodCall__Group_0__0 ) ) | ( ( rule__MethodCall__Group_1__0 ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==56) ) {
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
                    // InternalOCLX.g:1619:2: ( ( rule__MethodCall__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1619:2: ( ( rule__MethodCall__Group_0__0 ) )
                    // InternalOCLX.g:1620:3: ( rule__MethodCall__Group_0__0 )
                    {
                     before(grammarAccess.getMethodCallAccess().getGroup_0()); 
                    // InternalOCLX.g:1621:3: ( rule__MethodCall__Group_0__0 )
                    // InternalOCLX.g:1621:4: rule__MethodCall__Group_0__0
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
                    // InternalOCLX.g:1625:2: ( ( rule__MethodCall__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1625:2: ( ( rule__MethodCall__Group_1__0 ) )
                    // InternalOCLX.g:1626:3: ( rule__MethodCall__Group_1__0 )
                    {
                     before(grammarAccess.getMethodCallAccess().getGroup_1()); 
                    // InternalOCLX.g:1627:3: ( rule__MethodCall__Group_1__0 )
                    // InternalOCLX.g:1627:4: rule__MethodCall__Group_1__0
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
    // InternalOCLX.g:1635:1: rule__TypeCall__NameAlternatives_0_0 : ( ( 'asType' ) | ( 'isTypeOf' ) | ( 'isKindOf' ) );
    public final void rule__TypeCall__NameAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1639:1: ( ( 'asType' ) | ( 'isTypeOf' ) | ( 'isKindOf' ) )
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
                    // InternalOCLX.g:1640:2: ( 'asType' )
                    {
                    // InternalOCLX.g:1640:2: ( 'asType' )
                    // InternalOCLX.g:1641:3: 'asType'
                    {
                     before(grammarAccess.getTypeCallAccess().getNameAsTypeKeyword_0_0_0()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getTypeCallAccess().getNameAsTypeKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1646:2: ( 'isTypeOf' )
                    {
                    // InternalOCLX.g:1646:2: ( 'isTypeOf' )
                    // InternalOCLX.g:1647:3: 'isTypeOf'
                    {
                     before(grammarAccess.getTypeCallAccess().getNameIsTypeOfKeyword_0_0_1()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getTypeCallAccess().getNameIsTypeOfKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1652:2: ( 'isKindOf' )
                    {
                    // InternalOCLX.g:1652:2: ( 'isKindOf' )
                    // InternalOCLX.g:1653:3: 'isKindOf'
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
    // InternalOCLX.g:1662:1: rule__TypeExp__Alternatives : ( ( ( rule__TypeExp__Group_0__0 ) ) | ( ( rule__TypeExp__Group_1__0 ) ) );
    public final void rule__TypeExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1666:1: ( ( ( rule__TypeExp__Group_0__0 ) ) | ( ( rule__TypeExp__Group_1__0 ) ) )
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
                    // InternalOCLX.g:1667:2: ( ( rule__TypeExp__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1667:2: ( ( rule__TypeExp__Group_0__0 ) )
                    // InternalOCLX.g:1668:3: ( rule__TypeExp__Group_0__0 )
                    {
                     before(grammarAccess.getTypeExpAccess().getGroup_0()); 
                    // InternalOCLX.g:1669:3: ( rule__TypeExp__Group_0__0 )
                    // InternalOCLX.g:1669:4: rule__TypeExp__Group_0__0
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
                    // InternalOCLX.g:1673:2: ( ( rule__TypeExp__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1673:2: ( ( rule__TypeExp__Group_1__0 ) )
                    // InternalOCLX.g:1674:3: ( rule__TypeExp__Group_1__0 )
                    {
                     before(grammarAccess.getTypeExpAccess().getGroup_1()); 
                    // InternalOCLX.g:1675:3: ( rule__TypeExp__Group_1__0 )
                    // InternalOCLX.g:1675:4: rule__TypeExp__Group_1__0
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
    // InternalOCLX.g:1683:1: rule__CollectionTypeIdentifier__NameAlternatives_0 : ( ( 'set' ) | ( 'list' ) | ( 'map' ) | ( 'collection' ) );
    public final void rule__CollectionTypeIdentifier__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1687:1: ( ( 'set' ) | ( 'list' ) | ( 'map' ) | ( 'collection' ) )
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
                    // InternalOCLX.g:1688:2: ( 'set' )
                    {
                    // InternalOCLX.g:1688:2: ( 'set' )
                    // InternalOCLX.g:1689:3: 'set'
                    {
                     before(grammarAccess.getCollectionTypeIdentifierAccess().getNameSetKeyword_0_0()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getCollectionTypeIdentifierAccess().getNameSetKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1694:2: ( 'list' )
                    {
                    // InternalOCLX.g:1694:2: ( 'list' )
                    // InternalOCLX.g:1695:3: 'list'
                    {
                     before(grammarAccess.getCollectionTypeIdentifierAccess().getNameListKeyword_0_1()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getCollectionTypeIdentifierAccess().getNameListKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1700:2: ( 'map' )
                    {
                    // InternalOCLX.g:1700:2: ( 'map' )
                    // InternalOCLX.g:1701:3: 'map'
                    {
                     before(grammarAccess.getCollectionTypeIdentifierAccess().getNameMapKeyword_0_2()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getCollectionTypeIdentifierAccess().getNameMapKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1706:2: ( 'collection' )
                    {
                    // InternalOCLX.g:1706:2: ( 'collection' )
                    // InternalOCLX.g:1707:3: 'collection'
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
    // InternalOCLX.g:1716:1: rule__TemporalExp__Alternatives : ( ( ruleUnaryTemporalExp ) | ( ruleTriggeredTemporalExp ) );
    public final void rule__TemporalExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1720:1: ( ( ruleUnaryTemporalExp ) | ( ruleTriggeredTemporalExp ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=41 && LA19_0<=43)) ) {
                alt19=1;
            }
            else if ( ((LA19_0>=57 && LA19_0<=58)||(LA19_0>=65 && LA19_0<=69)) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalOCLX.g:1721:2: ( ruleUnaryTemporalExp )
                    {
                    // InternalOCLX.g:1721:2: ( ruleUnaryTemporalExp )
                    // InternalOCLX.g:1722:3: ruleUnaryTemporalExp
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
                    // InternalOCLX.g:1727:2: ( ruleTriggeredTemporalExp )
                    {
                    // InternalOCLX.g:1727:2: ( ruleTriggeredTemporalExp )
                    // InternalOCLX.g:1728:3: ruleTriggeredTemporalExp
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
    // InternalOCLX.g:1737:1: rule__UnaryTemporalOp__Alternatives : ( ( 'next' ) | ( 'always' ) | ( 'eventually' ) );
    public final void rule__UnaryTemporalOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1741:1: ( ( 'next' ) | ( 'always' ) | ( 'eventually' ) )
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
                    // InternalOCLX.g:1742:2: ( 'next' )
                    {
                    // InternalOCLX.g:1742:2: ( 'next' )
                    // InternalOCLX.g:1743:3: 'next'
                    {
                     before(grammarAccess.getUnaryTemporalOpAccess().getNextKeyword_0()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getUnaryTemporalOpAccess().getNextKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1748:2: ( 'always' )
                    {
                    // InternalOCLX.g:1748:2: ( 'always' )
                    // InternalOCLX.g:1749:3: 'always'
                    {
                     before(grammarAccess.getUnaryTemporalOpAccess().getAlwaysKeyword_1()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getUnaryTemporalOpAccess().getAlwaysKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1754:2: ( 'eventually' )
                    {
                    // InternalOCLX.g:1754:2: ( 'eventually' )
                    // InternalOCLX.g:1755:3: 'eventually'
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
    // InternalOCLX.g:1764:1: rule__TriggeredTemporalExp__Alternatives : ( ( ruleTemporalAsLongAs ) | ( ruleTemporalUntil ) | ( ruleTemporalEverytime ) | ( ruleTemporalAtLeastOnce ) | ( ruleLegacyUntil ) | ( ruleLegacyAsSoonAs ) | ( ruleLegacyEverytime ) );
    public final void rule__TriggeredTemporalExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1768:1: ( ( ruleTemporalAsLongAs ) | ( ruleTemporalUntil ) | ( ruleTemporalEverytime ) | ( ruleTemporalAtLeastOnce ) | ( ruleLegacyUntil ) | ( ruleLegacyAsSoonAs ) | ( ruleLegacyEverytime ) )
            int alt21=7;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt21=1;
                }
                break;
            case 57:
                {
                alt21=2;
                }
                break;
            case 65:
                {
                alt21=3;
                }
                break;
            case 66:
                {
                alt21=4;
                }
                break;
            case 67:
                {
                alt21=5;
                }
                break;
            case 68:
                {
                alt21=6;
                }
                break;
            case 69:
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
                    // InternalOCLX.g:1769:2: ( ruleTemporalAsLongAs )
                    {
                    // InternalOCLX.g:1769:2: ( ruleTemporalAsLongAs )
                    // InternalOCLX.g:1770:3: ruleTemporalAsLongAs
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
                    // InternalOCLX.g:1775:2: ( ruleTemporalUntil )
                    {
                    // InternalOCLX.g:1775:2: ( ruleTemporalUntil )
                    // InternalOCLX.g:1776:3: ruleTemporalUntil
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
                    // InternalOCLX.g:1781:2: ( ruleTemporalEverytime )
                    {
                    // InternalOCLX.g:1781:2: ( ruleTemporalEverytime )
                    // InternalOCLX.g:1782:3: ruleTemporalEverytime
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
                    // InternalOCLX.g:1787:2: ( ruleTemporalAtLeastOnce )
                    {
                    // InternalOCLX.g:1787:2: ( ruleTemporalAtLeastOnce )
                    // InternalOCLX.g:1788:3: ruleTemporalAtLeastOnce
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
                    // InternalOCLX.g:1793:2: ( ruleLegacyUntil )
                    {
                    // InternalOCLX.g:1793:2: ( ruleLegacyUntil )
                    // InternalOCLX.g:1794:3: ruleLegacyUntil
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
                    // InternalOCLX.g:1799:2: ( ruleLegacyAsSoonAs )
                    {
                    // InternalOCLX.g:1799:2: ( ruleLegacyAsSoonAs )
                    // InternalOCLX.g:1800:3: ruleLegacyAsSoonAs
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
                    // InternalOCLX.g:1805:2: ( ruleLegacyEverytime )
                    {
                    // InternalOCLX.g:1805:2: ( ruleLegacyEverytime )
                    // InternalOCLX.g:1806:3: ruleLegacyEverytime
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
    // InternalOCLX.g:1815:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1819:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalOCLX.g:1820:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
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
    // InternalOCLX.g:1827:1: rule__Constraint__Group__0__Impl : ( 'rule' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1831:1: ( ( 'rule' ) )
            // InternalOCLX.g:1832:1: ( 'rule' )
            {
            // InternalOCLX.g:1832:1: ( 'rule' )
            // InternalOCLX.g:1833:2: 'rule'
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
    // InternalOCLX.g:1842:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1846:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalOCLX.g:1847:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
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
    // InternalOCLX.g:1854:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__NameAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1858:1: ( ( ( rule__Constraint__NameAssignment_1 ) ) )
            // InternalOCLX.g:1859:1: ( ( rule__Constraint__NameAssignment_1 ) )
            {
            // InternalOCLX.g:1859:1: ( ( rule__Constraint__NameAssignment_1 ) )
            // InternalOCLX.g:1860:2: ( rule__Constraint__NameAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getNameAssignment_1()); 
            // InternalOCLX.g:1861:2: ( rule__Constraint__NameAssignment_1 )
            // InternalOCLX.g:1861:3: rule__Constraint__NameAssignment_1
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
    // InternalOCLX.g:1869:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1873:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalOCLX.g:1874:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
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
    // InternalOCLX.g:1881:1: rule__Constraint__Group__2__Impl : ( '{' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1885:1: ( ( '{' ) )
            // InternalOCLX.g:1886:1: ( '{' )
            {
            // InternalOCLX.g:1886:1: ( '{' )
            // InternalOCLX.g:1887:2: '{'
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
    // InternalOCLX.g:1896:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1900:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalOCLX.g:1901:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
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
    // InternalOCLX.g:1908:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__Group_3__0 )? ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1912:1: ( ( ( rule__Constraint__Group_3__0 )? ) )
            // InternalOCLX.g:1913:1: ( ( rule__Constraint__Group_3__0 )? )
            {
            // InternalOCLX.g:1913:1: ( ( rule__Constraint__Group_3__0 )? )
            // InternalOCLX.g:1914:2: ( rule__Constraint__Group_3__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_3()); 
            // InternalOCLX.g:1915:2: ( rule__Constraint__Group_3__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==49) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalOCLX.g:1915:3: rule__Constraint__Group_3__0
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
    // InternalOCLX.g:1923:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1927:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalOCLX.g:1928:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
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
    // InternalOCLX.g:1935:1: rule__Constraint__Group__4__Impl : ( ( rule__Constraint__Group_4__0 )? ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1939:1: ( ( ( rule__Constraint__Group_4__0 )? ) )
            // InternalOCLX.g:1940:1: ( ( rule__Constraint__Group_4__0 )? )
            {
            // InternalOCLX.g:1940:1: ( ( rule__Constraint__Group_4__0 )? )
            // InternalOCLX.g:1941:2: ( rule__Constraint__Group_4__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_4()); 
            // InternalOCLX.g:1942:2: ( rule__Constraint__Group_4__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==50) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalOCLX.g:1942:3: rule__Constraint__Group_4__0
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
    // InternalOCLX.g:1950:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl rule__Constraint__Group__6 ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1954:1: ( rule__Constraint__Group__5__Impl rule__Constraint__Group__6 )
            // InternalOCLX.g:1955:2: rule__Constraint__Group__5__Impl rule__Constraint__Group__6
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
    // InternalOCLX.g:1962:1: rule__Constraint__Group__5__Impl : ( 'context:' ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1966:1: ( ( 'context:' ) )
            // InternalOCLX.g:1967:1: ( 'context:' )
            {
            // InternalOCLX.g:1967:1: ( 'context:' )
            // InternalOCLX.g:1968:2: 'context:'
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
    // InternalOCLX.g:1977:1: rule__Constraint__Group__6 : rule__Constraint__Group__6__Impl rule__Constraint__Group__7 ;
    public final void rule__Constraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1981:1: ( rule__Constraint__Group__6__Impl rule__Constraint__Group__7 )
            // InternalOCLX.g:1982:2: rule__Constraint__Group__6__Impl rule__Constraint__Group__7
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
    // InternalOCLX.g:1989:1: rule__Constraint__Group__6__Impl : ( ( rule__Constraint__ContextAssignment_6 ) ) ;
    public final void rule__Constraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1993:1: ( ( ( rule__Constraint__ContextAssignment_6 ) ) )
            // InternalOCLX.g:1994:1: ( ( rule__Constraint__ContextAssignment_6 ) )
            {
            // InternalOCLX.g:1994:1: ( ( rule__Constraint__ContextAssignment_6 ) )
            // InternalOCLX.g:1995:2: ( rule__Constraint__ContextAssignment_6 )
            {
             before(grammarAccess.getConstraintAccess().getContextAssignment_6()); 
            // InternalOCLX.g:1996:2: ( rule__Constraint__ContextAssignment_6 )
            // InternalOCLX.g:1996:3: rule__Constraint__ContextAssignment_6
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
    // InternalOCLX.g:2004:1: rule__Constraint__Group__7 : rule__Constraint__Group__7__Impl rule__Constraint__Group__8 ;
    public final void rule__Constraint__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2008:1: ( rule__Constraint__Group__7__Impl rule__Constraint__Group__8 )
            // InternalOCLX.g:2009:2: rule__Constraint__Group__7__Impl rule__Constraint__Group__8
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
    // InternalOCLX.g:2016:1: rule__Constraint__Group__7__Impl : ( 'expression:' ) ;
    public final void rule__Constraint__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2020:1: ( ( 'expression:' ) )
            // InternalOCLX.g:2021:1: ( 'expression:' )
            {
            // InternalOCLX.g:2021:1: ( 'expression:' )
            // InternalOCLX.g:2022:2: 'expression:'
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
    // InternalOCLX.g:2031:1: rule__Constraint__Group__8 : rule__Constraint__Group__8__Impl rule__Constraint__Group__9 ;
    public final void rule__Constraint__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2035:1: ( rule__Constraint__Group__8__Impl rule__Constraint__Group__9 )
            // InternalOCLX.g:2036:2: rule__Constraint__Group__8__Impl rule__Constraint__Group__9
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
    // InternalOCLX.g:2043:1: rule__Constraint__Group__8__Impl : ( ( rule__Constraint__ExpressionAssignment_8 ) ) ;
    public final void rule__Constraint__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2047:1: ( ( ( rule__Constraint__ExpressionAssignment_8 ) ) )
            // InternalOCLX.g:2048:1: ( ( rule__Constraint__ExpressionAssignment_8 ) )
            {
            // InternalOCLX.g:2048:1: ( ( rule__Constraint__ExpressionAssignment_8 ) )
            // InternalOCLX.g:2049:2: ( rule__Constraint__ExpressionAssignment_8 )
            {
             before(grammarAccess.getConstraintAccess().getExpressionAssignment_8()); 
            // InternalOCLX.g:2050:2: ( rule__Constraint__ExpressionAssignment_8 )
            // InternalOCLX.g:2050:3: rule__Constraint__ExpressionAssignment_8
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
    // InternalOCLX.g:2058:1: rule__Constraint__Group__9 : rule__Constraint__Group__9__Impl ;
    public final void rule__Constraint__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2062:1: ( rule__Constraint__Group__9__Impl )
            // InternalOCLX.g:2063:2: rule__Constraint__Group__9__Impl
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
    // InternalOCLX.g:2069:1: rule__Constraint__Group__9__Impl : ( '}' ) ;
    public final void rule__Constraint__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2073:1: ( ( '}' ) )
            // InternalOCLX.g:2074:1: ( '}' )
            {
            // InternalOCLX.g:2074:1: ( '}' )
            // InternalOCLX.g:2075:2: '}'
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
    // InternalOCLX.g:2085:1: rule__Constraint__Group_3__0 : rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1 ;
    public final void rule__Constraint__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2089:1: ( rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1 )
            // InternalOCLX.g:2090:2: rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1
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
    // InternalOCLX.g:2097:1: rule__Constraint__Group_3__0__Impl : ( 'description:' ) ;
    public final void rule__Constraint__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2101:1: ( ( 'description:' ) )
            // InternalOCLX.g:2102:1: ( 'description:' )
            {
            // InternalOCLX.g:2102:1: ( 'description:' )
            // InternalOCLX.g:2103:2: 'description:'
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
    // InternalOCLX.g:2112:1: rule__Constraint__Group_3__1 : rule__Constraint__Group_3__1__Impl ;
    public final void rule__Constraint__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2116:1: ( rule__Constraint__Group_3__1__Impl )
            // InternalOCLX.g:2117:2: rule__Constraint__Group_3__1__Impl
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
    // InternalOCLX.g:2123:1: rule__Constraint__Group_3__1__Impl : ( ( rule__Constraint__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Constraint__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2127:1: ( ( ( rule__Constraint__DescriptionAssignment_3_1 ) ) )
            // InternalOCLX.g:2128:1: ( ( rule__Constraint__DescriptionAssignment_3_1 ) )
            {
            // InternalOCLX.g:2128:1: ( ( rule__Constraint__DescriptionAssignment_3_1 ) )
            // InternalOCLX.g:2129:2: ( rule__Constraint__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getConstraintAccess().getDescriptionAssignment_3_1()); 
            // InternalOCLX.g:2130:2: ( rule__Constraint__DescriptionAssignment_3_1 )
            // InternalOCLX.g:2130:3: rule__Constraint__DescriptionAssignment_3_1
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
    // InternalOCLX.g:2139:1: rule__Constraint__Group_4__0 : rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 ;
    public final void rule__Constraint__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2143:1: ( rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 )
            // InternalOCLX.g:2144:2: rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1
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
    // InternalOCLX.g:2151:1: rule__Constraint__Group_4__0__Impl : ( 'is' ) ;
    public final void rule__Constraint__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2155:1: ( ( 'is' ) )
            // InternalOCLX.g:2156:1: ( 'is' )
            {
            // InternalOCLX.g:2156:1: ( 'is' )
            // InternalOCLX.g:2157:2: 'is'
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
    // InternalOCLX.g:2166:1: rule__Constraint__Group_4__1 : rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2 ;
    public final void rule__Constraint__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2170:1: ( rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2 )
            // InternalOCLX.g:2171:2: rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2
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
    // InternalOCLX.g:2178:1: rule__Constraint__Group_4__1__Impl : ( 'overrulable:' ) ;
    public final void rule__Constraint__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2182:1: ( ( 'overrulable:' ) )
            // InternalOCLX.g:2183:1: ( 'overrulable:' )
            {
            // InternalOCLX.g:2183:1: ( 'overrulable:' )
            // InternalOCLX.g:2184:2: 'overrulable:'
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
    // InternalOCLX.g:2193:1: rule__Constraint__Group_4__2 : rule__Constraint__Group_4__2__Impl ;
    public final void rule__Constraint__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2197:1: ( rule__Constraint__Group_4__2__Impl )
            // InternalOCLX.g:2198:2: rule__Constraint__Group_4__2__Impl
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
    // InternalOCLX.g:2204:1: rule__Constraint__Group_4__2__Impl : ( ( rule__Constraint__OverrulableAssignment_4_2 ) ) ;
    public final void rule__Constraint__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2208:1: ( ( ( rule__Constraint__OverrulableAssignment_4_2 ) ) )
            // InternalOCLX.g:2209:1: ( ( rule__Constraint__OverrulableAssignment_4_2 ) )
            {
            // InternalOCLX.g:2209:1: ( ( rule__Constraint__OverrulableAssignment_4_2 ) )
            // InternalOCLX.g:2210:2: ( rule__Constraint__OverrulableAssignment_4_2 )
            {
             before(grammarAccess.getConstraintAccess().getOverrulableAssignment_4_2()); 
            // InternalOCLX.g:2211:2: ( rule__Constraint__OverrulableAssignment_4_2 )
            // InternalOCLX.g:2211:3: rule__Constraint__OverrulableAssignment_4_2
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
    // InternalOCLX.g:2220:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2224:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalOCLX.g:2225:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalOCLX.g:2232:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2236:1: ( ( RULE_ID ) )
            // InternalOCLX.g:2237:1: ( RULE_ID )
            {
            // InternalOCLX.g:2237:1: ( RULE_ID )
            // InternalOCLX.g:2238:2: RULE_ID
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
    // InternalOCLX.g:2247:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2251:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalOCLX.g:2252:2: rule__QualifiedName__Group__1__Impl
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
    // InternalOCLX.g:2258:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2262:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalOCLX.g:2263:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalOCLX.g:2263:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalOCLX.g:2264:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalOCLX.g:2265:2: ( rule__QualifiedName__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==26) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalOCLX.g:2265:3: rule__QualifiedName__Group_1__0
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
    // InternalOCLX.g:2274:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2278:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalOCLX.g:2279:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalOCLX.g:2286:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2290:1: ( ( '.' ) )
            // InternalOCLX.g:2291:1: ( '.' )
            {
            // InternalOCLX.g:2291:1: ( '.' )
            // InternalOCLX.g:2292:2: '.'
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
    // InternalOCLX.g:2301:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2305:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalOCLX.g:2306:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalOCLX.g:2312:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2316:1: ( ( RULE_ID ) )
            // InternalOCLX.g:2317:1: ( RULE_ID )
            {
            // InternalOCLX.g:2317:1: ( RULE_ID )
            // InternalOCLX.g:2318:2: RULE_ID
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


    // $ANTLR start "rule__Float__Group__0"
    // InternalOCLX.g:2328:1: rule__Float__Group__0 : rule__Float__Group__0__Impl rule__Float__Group__1 ;
    public final void rule__Float__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2332:1: ( rule__Float__Group__0__Impl rule__Float__Group__1 )
            // InternalOCLX.g:2333:2: rule__Float__Group__0__Impl rule__Float__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__Float__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Float__Group__1();

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
    // $ANTLR end "rule__Float__Group__0"


    // $ANTLR start "rule__Float__Group__0__Impl"
    // InternalOCLX.g:2340:1: rule__Float__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__Float__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2344:1: ( ( RULE_INT ) )
            // InternalOCLX.g:2345:1: ( RULE_INT )
            {
            // InternalOCLX.g:2345:1: ( RULE_INT )
            // InternalOCLX.g:2346:2: RULE_INT
            {
             before(grammarAccess.getFloatAccess().getINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFloatAccess().getINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float__Group__0__Impl"


    // $ANTLR start "rule__Float__Group__1"
    // InternalOCLX.g:2355:1: rule__Float__Group__1 : rule__Float__Group__1__Impl rule__Float__Group__2 ;
    public final void rule__Float__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2359:1: ( rule__Float__Group__1__Impl rule__Float__Group__2 )
            // InternalOCLX.g:2360:2: rule__Float__Group__1__Impl rule__Float__Group__2
            {
            pushFollow(FOLLOW_15);
            rule__Float__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Float__Group__2();

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
    // $ANTLR end "rule__Float__Group__1"


    // $ANTLR start "rule__Float__Group__1__Impl"
    // InternalOCLX.g:2367:1: rule__Float__Group__1__Impl : ( '.' ) ;
    public final void rule__Float__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2371:1: ( ( '.' ) )
            // InternalOCLX.g:2372:1: ( '.' )
            {
            // InternalOCLX.g:2372:1: ( '.' )
            // InternalOCLX.g:2373:2: '.'
            {
             before(grammarAccess.getFloatAccess().getFullStopKeyword_1()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getFloatAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float__Group__1__Impl"


    // $ANTLR start "rule__Float__Group__2"
    // InternalOCLX.g:2382:1: rule__Float__Group__2 : rule__Float__Group__2__Impl ;
    public final void rule__Float__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2386:1: ( rule__Float__Group__2__Impl )
            // InternalOCLX.g:2387:2: rule__Float__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Float__Group__2__Impl();

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
    // $ANTLR end "rule__Float__Group__2"


    // $ANTLR start "rule__Float__Group__2__Impl"
    // InternalOCLX.g:2393:1: rule__Float__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__Float__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2397:1: ( ( RULE_INT ) )
            // InternalOCLX.g:2398:1: ( RULE_INT )
            {
            // InternalOCLX.g:2398:1: ( RULE_INT )
            // InternalOCLX.g:2399:2: RULE_INT
            {
             before(grammarAccess.getFloatAccess().getINTTerminalRuleCall_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFloatAccess().getINTTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Float__Group__2__Impl"


    // $ANTLR start "rule__Exp__Group__0"
    // InternalOCLX.g:2409:1: rule__Exp__Group__0 : rule__Exp__Group__0__Impl rule__Exp__Group__1 ;
    public final void rule__Exp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2413:1: ( rule__Exp__Group__0__Impl rule__Exp__Group__1 )
            // InternalOCLX.g:2414:2: rule__Exp__Group__0__Impl rule__Exp__Group__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalOCLX.g:2421:1: rule__Exp__Group__0__Impl : ( rulePrefixedExp ) ;
    public final void rule__Exp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2425:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:2426:1: ( rulePrefixedExp )
            {
            // InternalOCLX.g:2426:1: ( rulePrefixedExp )
            // InternalOCLX.g:2427:2: rulePrefixedExp
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
    // InternalOCLX.g:2436:1: rule__Exp__Group__1 : rule__Exp__Group__1__Impl ;
    public final void rule__Exp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2440:1: ( rule__Exp__Group__1__Impl )
            // InternalOCLX.g:2441:2: rule__Exp__Group__1__Impl
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
    // InternalOCLX.g:2447:1: rule__Exp__Group__1__Impl : ( ( rule__Exp__Group_1__0 )? ) ;
    public final void rule__Exp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2451:1: ( ( ( rule__Exp__Group_1__0 )? ) )
            // InternalOCLX.g:2452:1: ( ( rule__Exp__Group_1__0 )? )
            {
            // InternalOCLX.g:2452:1: ( ( rule__Exp__Group_1__0 )? )
            // InternalOCLX.g:2453:2: ( rule__Exp__Group_1__0 )?
            {
             before(grammarAccess.getExpAccess().getGroup_1()); 
            // InternalOCLX.g:2454:2: ( rule__Exp__Group_1__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=12 && LA25_0<=25)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalOCLX.g:2454:3: rule__Exp__Group_1__0
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
    // InternalOCLX.g:2463:1: rule__Exp__Group_1__0 : rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 ;
    public final void rule__Exp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2467:1: ( rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 )
            // InternalOCLX.g:2468:2: rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalOCLX.g:2475:1: rule__Exp__Group_1__0__Impl : ( () ) ;
    public final void rule__Exp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2479:1: ( ( () ) )
            // InternalOCLX.g:2480:1: ( () )
            {
            // InternalOCLX.g:2480:1: ( () )
            // InternalOCLX.g:2481:2: ()
            {
             before(grammarAccess.getExpAccess().getInfixExpExpressionsAction_1_0()); 
            // InternalOCLX.g:2482:2: ()
            // InternalOCLX.g:2482:3: 
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
    // InternalOCLX.g:2490:1: rule__Exp__Group_1__1 : rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2 ;
    public final void rule__Exp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2494:1: ( rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2 )
            // InternalOCLX.g:2495:2: rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2
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
    // InternalOCLX.g:2502:1: rule__Exp__Group_1__1__Impl : ( ( rule__Exp__OperatorsAssignment_1_1 ) ) ;
    public final void rule__Exp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2506:1: ( ( ( rule__Exp__OperatorsAssignment_1_1 ) ) )
            // InternalOCLX.g:2507:1: ( ( rule__Exp__OperatorsAssignment_1_1 ) )
            {
            // InternalOCLX.g:2507:1: ( ( rule__Exp__OperatorsAssignment_1_1 ) )
            // InternalOCLX.g:2508:2: ( rule__Exp__OperatorsAssignment_1_1 )
            {
             before(grammarAccess.getExpAccess().getOperatorsAssignment_1_1()); 
            // InternalOCLX.g:2509:2: ( rule__Exp__OperatorsAssignment_1_1 )
            // InternalOCLX.g:2509:3: rule__Exp__OperatorsAssignment_1_1
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
    // InternalOCLX.g:2517:1: rule__Exp__Group_1__2 : rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3 ;
    public final void rule__Exp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2521:1: ( rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3 )
            // InternalOCLX.g:2522:2: rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3
            {
            pushFollow(FOLLOW_16);
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
    // InternalOCLX.g:2529:1: rule__Exp__Group_1__2__Impl : ( ( rule__Exp__ExpressionsAssignment_1_2 ) ) ;
    public final void rule__Exp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2533:1: ( ( ( rule__Exp__ExpressionsAssignment_1_2 ) ) )
            // InternalOCLX.g:2534:1: ( ( rule__Exp__ExpressionsAssignment_1_2 ) )
            {
            // InternalOCLX.g:2534:1: ( ( rule__Exp__ExpressionsAssignment_1_2 ) )
            // InternalOCLX.g:2535:2: ( rule__Exp__ExpressionsAssignment_1_2 )
            {
             before(grammarAccess.getExpAccess().getExpressionsAssignment_1_2()); 
            // InternalOCLX.g:2536:2: ( rule__Exp__ExpressionsAssignment_1_2 )
            // InternalOCLX.g:2536:3: rule__Exp__ExpressionsAssignment_1_2
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
    // InternalOCLX.g:2544:1: rule__Exp__Group_1__3 : rule__Exp__Group_1__3__Impl ;
    public final void rule__Exp__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2548:1: ( rule__Exp__Group_1__3__Impl )
            // InternalOCLX.g:2549:2: rule__Exp__Group_1__3__Impl
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
    // InternalOCLX.g:2555:1: rule__Exp__Group_1__3__Impl : ( ( rule__Exp__Group_1_3__0 )* ) ;
    public final void rule__Exp__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2559:1: ( ( ( rule__Exp__Group_1_3__0 )* ) )
            // InternalOCLX.g:2560:1: ( ( rule__Exp__Group_1_3__0 )* )
            {
            // InternalOCLX.g:2560:1: ( ( rule__Exp__Group_1_3__0 )* )
            // InternalOCLX.g:2561:2: ( rule__Exp__Group_1_3__0 )*
            {
             before(grammarAccess.getExpAccess().getGroup_1_3()); 
            // InternalOCLX.g:2562:2: ( rule__Exp__Group_1_3__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=12 && LA26_0<=25)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalOCLX.g:2562:3: rule__Exp__Group_1_3__0
            	    {
            	    pushFollow(FOLLOW_17);
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
    // InternalOCLX.g:2571:1: rule__Exp__Group_1_3__0 : rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1 ;
    public final void rule__Exp__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2575:1: ( rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1 )
            // InternalOCLX.g:2576:2: rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1
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
    // InternalOCLX.g:2583:1: rule__Exp__Group_1_3__0__Impl : ( ( rule__Exp__OperatorsAssignment_1_3_0 ) ) ;
    public final void rule__Exp__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2587:1: ( ( ( rule__Exp__OperatorsAssignment_1_3_0 ) ) )
            // InternalOCLX.g:2588:1: ( ( rule__Exp__OperatorsAssignment_1_3_0 ) )
            {
            // InternalOCLX.g:2588:1: ( ( rule__Exp__OperatorsAssignment_1_3_0 ) )
            // InternalOCLX.g:2589:2: ( rule__Exp__OperatorsAssignment_1_3_0 )
            {
             before(grammarAccess.getExpAccess().getOperatorsAssignment_1_3_0()); 
            // InternalOCLX.g:2590:2: ( rule__Exp__OperatorsAssignment_1_3_0 )
            // InternalOCLX.g:2590:3: rule__Exp__OperatorsAssignment_1_3_0
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
    // InternalOCLX.g:2598:1: rule__Exp__Group_1_3__1 : rule__Exp__Group_1_3__1__Impl ;
    public final void rule__Exp__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2602:1: ( rule__Exp__Group_1_3__1__Impl )
            // InternalOCLX.g:2603:2: rule__Exp__Group_1_3__1__Impl
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
    // InternalOCLX.g:2609:1: rule__Exp__Group_1_3__1__Impl : ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) ) ;
    public final void rule__Exp__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2613:1: ( ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) ) )
            // InternalOCLX.g:2614:1: ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) )
            {
            // InternalOCLX.g:2614:1: ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) )
            // InternalOCLX.g:2615:2: ( rule__Exp__ExpressionsAssignment_1_3_1 )
            {
             before(grammarAccess.getExpAccess().getExpressionsAssignment_1_3_1()); 
            // InternalOCLX.g:2616:2: ( rule__Exp__ExpressionsAssignment_1_3_1 )
            // InternalOCLX.g:2616:3: rule__Exp__ExpressionsAssignment_1_3_1
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
    // InternalOCLX.g:2625:1: rule__PrefixedExp__Group_0__0 : rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1 ;
    public final void rule__PrefixedExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2629:1: ( rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1 )
            // InternalOCLX.g:2630:2: rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalOCLX.g:2637:1: rule__PrefixedExp__Group_0__0__Impl : ( () ) ;
    public final void rule__PrefixedExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2641:1: ( ( () ) )
            // InternalOCLX.g:2642:1: ( () )
            {
            // InternalOCLX.g:2642:1: ( () )
            // InternalOCLX.g:2643:2: ()
            {
             before(grammarAccess.getPrefixedExpAccess().getPrefixExpAction_0_0()); 
            // InternalOCLX.g:2644:2: ()
            // InternalOCLX.g:2644:3: 
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
    // InternalOCLX.g:2652:1: rule__PrefixedExp__Group_0__1 : rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2 ;
    public final void rule__PrefixedExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2656:1: ( rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2 )
            // InternalOCLX.g:2657:2: rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2
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
    // InternalOCLX.g:2664:1: rule__PrefixedExp__Group_0__1__Impl : ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) ) ;
    public final void rule__PrefixedExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2668:1: ( ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) ) )
            // InternalOCLX.g:2669:1: ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) )
            {
            // InternalOCLX.g:2669:1: ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) )
            // InternalOCLX.g:2670:2: ( rule__PrefixedExp__OperatorAssignment_0_1 )
            {
             before(grammarAccess.getPrefixedExpAccess().getOperatorAssignment_0_1()); 
            // InternalOCLX.g:2671:2: ( rule__PrefixedExp__OperatorAssignment_0_1 )
            // InternalOCLX.g:2671:3: rule__PrefixedExp__OperatorAssignment_0_1
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
    // InternalOCLX.g:2679:1: rule__PrefixedExp__Group_0__2 : rule__PrefixedExp__Group_0__2__Impl ;
    public final void rule__PrefixedExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2683:1: ( rule__PrefixedExp__Group_0__2__Impl )
            // InternalOCLX.g:2684:2: rule__PrefixedExp__Group_0__2__Impl
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
    // InternalOCLX.g:2690:1: rule__PrefixedExp__Group_0__2__Impl : ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) ) ;
    public final void rule__PrefixedExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2694:1: ( ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) ) )
            // InternalOCLX.g:2695:1: ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) )
            {
            // InternalOCLX.g:2695:1: ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) )
            // InternalOCLX.g:2696:2: ( rule__PrefixedExp__ExpressionAssignment_0_2 )
            {
             before(grammarAccess.getPrefixedExpAccess().getExpressionAssignment_0_2()); 
            // InternalOCLX.g:2697:2: ( rule__PrefixedExp__ExpressionAssignment_0_2 )
            // InternalOCLX.g:2697:3: rule__PrefixedExp__ExpressionAssignment_0_2
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
    // InternalOCLX.g:2706:1: rule__PrimaryExp__Group_1__0 : rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1 ;
    public final void rule__PrimaryExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2710:1: ( rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1 )
            // InternalOCLX.g:2711:2: rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1
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
    // InternalOCLX.g:2718:1: rule__PrimaryExp__Group_1__0__Impl : ( ruleVarOrSelfExp ) ;
    public final void rule__PrimaryExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2722:1: ( ( ruleVarOrSelfExp ) )
            // InternalOCLX.g:2723:1: ( ruleVarOrSelfExp )
            {
            // InternalOCLX.g:2723:1: ( ruleVarOrSelfExp )
            // InternalOCLX.g:2724:2: ruleVarOrSelfExp
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
    // InternalOCLX.g:2733:1: rule__PrimaryExp__Group_1__1 : rule__PrimaryExp__Group_1__1__Impl ;
    public final void rule__PrimaryExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2737:1: ( rule__PrimaryExp__Group_1__1__Impl )
            // InternalOCLX.g:2738:2: rule__PrimaryExp__Group_1__1__Impl
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
    // InternalOCLX.g:2744:1: rule__PrimaryExp__Group_1__1__Impl : ( ( rule__PrimaryExp__Group_1_1__0 )* ) ;
    public final void rule__PrimaryExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2748:1: ( ( ( rule__PrimaryExp__Group_1_1__0 )* ) )
            // InternalOCLX.g:2749:1: ( ( rule__PrimaryExp__Group_1_1__0 )* )
            {
            // InternalOCLX.g:2749:1: ( ( rule__PrimaryExp__Group_1_1__0 )* )
            // InternalOCLX.g:2750:2: ( rule__PrimaryExp__Group_1_1__0 )*
            {
             before(grammarAccess.getPrimaryExpAccess().getGroup_1_1()); 
            // InternalOCLX.g:2751:2: ( rule__PrimaryExp__Group_1_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=26 && LA27_0<=27)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalOCLX.g:2751:3: rule__PrimaryExp__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_20);
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
    // InternalOCLX.g:2760:1: rule__PrimaryExp__Group_1_1__0 : rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1 ;
    public final void rule__PrimaryExp__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2764:1: ( rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1 )
            // InternalOCLX.g:2765:2: rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1
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
    // InternalOCLX.g:2772:1: rule__PrimaryExp__Group_1_1__0__Impl : ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) ) ;
    public final void rule__PrimaryExp__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2776:1: ( ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) ) )
            // InternalOCLX.g:2777:1: ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) )
            {
            // InternalOCLX.g:2777:1: ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) )
            // InternalOCLX.g:2778:2: ( rule__PrimaryExp__NavAssignment_1_1_0 )
            {
             before(grammarAccess.getPrimaryExpAccess().getNavAssignment_1_1_0()); 
            // InternalOCLX.g:2779:2: ( rule__PrimaryExp__NavAssignment_1_1_0 )
            // InternalOCLX.g:2779:3: rule__PrimaryExp__NavAssignment_1_1_0
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
    // InternalOCLX.g:2787:1: rule__PrimaryExp__Group_1_1__1 : rule__PrimaryExp__Group_1_1__1__Impl ;
    public final void rule__PrimaryExp__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2791:1: ( rule__PrimaryExp__Group_1_1__1__Impl )
            // InternalOCLX.g:2792:2: rule__PrimaryExp__Group_1_1__1__Impl
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
    // InternalOCLX.g:2798:1: rule__PrimaryExp__Group_1_1__1__Impl : ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) ) ;
    public final void rule__PrimaryExp__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2802:1: ( ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) ) )
            // InternalOCLX.g:2803:1: ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) )
            {
            // InternalOCLX.g:2803:1: ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) )
            // InternalOCLX.g:2804:2: ( rule__PrimaryExp__MethodsAssignment_1_1_1 )
            {
             before(grammarAccess.getPrimaryExpAccess().getMethodsAssignment_1_1_1()); 
            // InternalOCLX.g:2805:2: ( rule__PrimaryExp__MethodsAssignment_1_1_1 )
            // InternalOCLX.g:2805:3: rule__PrimaryExp__MethodsAssignment_1_1_1
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
    // InternalOCLX.g:2814:1: rule__NestedExp__Group__0 : rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 ;
    public final void rule__NestedExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2818:1: ( rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 )
            // InternalOCLX.g:2819:2: rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1
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
    // InternalOCLX.g:2826:1: rule__NestedExp__Group__0__Impl : ( '(' ) ;
    public final void rule__NestedExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2830:1: ( ( '(' ) )
            // InternalOCLX.g:2831:1: ( '(' )
            {
            // InternalOCLX.g:2831:1: ( '(' )
            // InternalOCLX.g:2832:2: '('
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
    // InternalOCLX.g:2841:1: rule__NestedExp__Group__1 : rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 ;
    public final void rule__NestedExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2845:1: ( rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 )
            // InternalOCLX.g:2846:2: rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2
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
    // InternalOCLX.g:2853:1: rule__NestedExp__Group__1__Impl : ( ( rule__NestedExp__SourceAssignment_1 ) ) ;
    public final void rule__NestedExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2857:1: ( ( ( rule__NestedExp__SourceAssignment_1 ) ) )
            // InternalOCLX.g:2858:1: ( ( rule__NestedExp__SourceAssignment_1 ) )
            {
            // InternalOCLX.g:2858:1: ( ( rule__NestedExp__SourceAssignment_1 ) )
            // InternalOCLX.g:2859:2: ( rule__NestedExp__SourceAssignment_1 )
            {
             before(grammarAccess.getNestedExpAccess().getSourceAssignment_1()); 
            // InternalOCLX.g:2860:2: ( rule__NestedExp__SourceAssignment_1 )
            // InternalOCLX.g:2860:3: rule__NestedExp__SourceAssignment_1
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
    // InternalOCLX.g:2868:1: rule__NestedExp__Group__2 : rule__NestedExp__Group__2__Impl ;
    public final void rule__NestedExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2872:1: ( rule__NestedExp__Group__2__Impl )
            // InternalOCLX.g:2873:2: rule__NestedExp__Group__2__Impl
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
    // InternalOCLX.g:2879:1: rule__NestedExp__Group__2__Impl : ( ')' ) ;
    public final void rule__NestedExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2883:1: ( ( ')' ) )
            // InternalOCLX.g:2884:1: ( ')' )
            {
            // InternalOCLX.g:2884:1: ( ')' )
            // InternalOCLX.g:2885:2: ')'
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
    // InternalOCLX.g:2895:1: rule__SelfExp__Group__0 : rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1 ;
    public final void rule__SelfExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2899:1: ( rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1 )
            // InternalOCLX.g:2900:2: rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1
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
    // InternalOCLX.g:2907:1: rule__SelfExp__Group__0__Impl : ( () ) ;
    public final void rule__SelfExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2911:1: ( ( () ) )
            // InternalOCLX.g:2912:1: ( () )
            {
            // InternalOCLX.g:2912:1: ( () )
            // InternalOCLX.g:2913:2: ()
            {
             before(grammarAccess.getSelfExpAccess().getSelfExpAction_0()); 
            // InternalOCLX.g:2914:2: ()
            // InternalOCLX.g:2914:3: 
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
    // InternalOCLX.g:2922:1: rule__SelfExp__Group__1 : rule__SelfExp__Group__1__Impl ;
    public final void rule__SelfExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2926:1: ( rule__SelfExp__Group__1__Impl )
            // InternalOCLX.g:2927:2: rule__SelfExp__Group__1__Impl
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
    // InternalOCLX.g:2933:1: rule__SelfExp__Group__1__Impl : ( ( rule__SelfExp__NameAssignment_1 ) ) ;
    public final void rule__SelfExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2937:1: ( ( ( rule__SelfExp__NameAssignment_1 ) ) )
            // InternalOCLX.g:2938:1: ( ( rule__SelfExp__NameAssignment_1 ) )
            {
            // InternalOCLX.g:2938:1: ( ( rule__SelfExp__NameAssignment_1 ) )
            // InternalOCLX.g:2939:2: ( rule__SelfExp__NameAssignment_1 )
            {
             before(grammarAccess.getSelfExpAccess().getNameAssignment_1()); 
            // InternalOCLX.g:2940:2: ( rule__SelfExp__NameAssignment_1 )
            // InternalOCLX.g:2940:3: rule__SelfExp__NameAssignment_1
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


    // $ANTLR start "rule__CollectionIterator__Group__0"
    // InternalOCLX.g:2949:1: rule__CollectionIterator__Group__0 : rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 ;
    public final void rule__CollectionIterator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2953:1: ( rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 )
            // InternalOCLX.g:2954:2: rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1
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
    // InternalOCLX.g:2961:1: rule__CollectionIterator__Group__0__Impl : ( ( rule__CollectionIterator__NameAssignment_0 ) ) ;
    public final void rule__CollectionIterator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2965:1: ( ( ( rule__CollectionIterator__NameAssignment_0 ) ) )
            // InternalOCLX.g:2966:1: ( ( rule__CollectionIterator__NameAssignment_0 ) )
            {
            // InternalOCLX.g:2966:1: ( ( rule__CollectionIterator__NameAssignment_0 ) )
            // InternalOCLX.g:2967:2: ( rule__CollectionIterator__NameAssignment_0 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getNameAssignment_0()); 
            // InternalOCLX.g:2968:2: ( rule__CollectionIterator__NameAssignment_0 )
            // InternalOCLX.g:2968:3: rule__CollectionIterator__NameAssignment_0
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
    // InternalOCLX.g:2976:1: rule__CollectionIterator__Group__1 : rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 ;
    public final void rule__CollectionIterator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2980:1: ( rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 )
            // InternalOCLX.g:2981:2: rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2
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
    // InternalOCLX.g:2988:1: rule__CollectionIterator__Group__1__Impl : ( '(' ) ;
    public final void rule__CollectionIterator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2992:1: ( ( '(' ) )
            // InternalOCLX.g:2993:1: ( '(' )
            {
            // InternalOCLX.g:2993:1: ( '(' )
            // InternalOCLX.g:2994:2: '('
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
    // InternalOCLX.g:3003:1: rule__CollectionIterator__Group__2 : rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 ;
    public final void rule__CollectionIterator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3007:1: ( rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 )
            // InternalOCLX.g:3008:2: rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3
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
    // InternalOCLX.g:3015:1: rule__CollectionIterator__Group__2__Impl : ( ( rule__CollectionIterator__ItervarAssignment_2 ) ) ;
    public final void rule__CollectionIterator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3019:1: ( ( ( rule__CollectionIterator__ItervarAssignment_2 ) ) )
            // InternalOCLX.g:3020:1: ( ( rule__CollectionIterator__ItervarAssignment_2 ) )
            {
            // InternalOCLX.g:3020:1: ( ( rule__CollectionIterator__ItervarAssignment_2 ) )
            // InternalOCLX.g:3021:2: ( rule__CollectionIterator__ItervarAssignment_2 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getItervarAssignment_2()); 
            // InternalOCLX.g:3022:2: ( rule__CollectionIterator__ItervarAssignment_2 )
            // InternalOCLX.g:3022:3: rule__CollectionIterator__ItervarAssignment_2
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
    // InternalOCLX.g:3030:1: rule__CollectionIterator__Group__3 : rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4 ;
    public final void rule__CollectionIterator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3034:1: ( rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4 )
            // InternalOCLX.g:3035:2: rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4
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
    // InternalOCLX.g:3042:1: rule__CollectionIterator__Group__3__Impl : ( '|' ) ;
    public final void rule__CollectionIterator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3046:1: ( ( '|' ) )
            // InternalOCLX.g:3047:1: ( '|' )
            {
            // InternalOCLX.g:3047:1: ( '|' )
            // InternalOCLX.g:3048:2: '|'
            {
             before(grammarAccess.getCollectionIteratorAccess().getVerticalLineKeyword_3()); 
            match(input,54,FOLLOW_2); 
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
    // InternalOCLX.g:3057:1: rule__CollectionIterator__Group__4 : rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5 ;
    public final void rule__CollectionIterator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3061:1: ( rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5 )
            // InternalOCLX.g:3062:2: rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5
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
    // InternalOCLX.g:3069:1: rule__CollectionIterator__Group__4__Impl : ( ( rule__CollectionIterator__BodyAssignment_4 ) ) ;
    public final void rule__CollectionIterator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3073:1: ( ( ( rule__CollectionIterator__BodyAssignment_4 ) ) )
            // InternalOCLX.g:3074:1: ( ( rule__CollectionIterator__BodyAssignment_4 ) )
            {
            // InternalOCLX.g:3074:1: ( ( rule__CollectionIterator__BodyAssignment_4 ) )
            // InternalOCLX.g:3075:2: ( rule__CollectionIterator__BodyAssignment_4 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getBodyAssignment_4()); 
            // InternalOCLX.g:3076:2: ( rule__CollectionIterator__BodyAssignment_4 )
            // InternalOCLX.g:3076:3: rule__CollectionIterator__BodyAssignment_4
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
    // InternalOCLX.g:3084:1: rule__CollectionIterator__Group__5 : rule__CollectionIterator__Group__5__Impl ;
    public final void rule__CollectionIterator__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3088:1: ( rule__CollectionIterator__Group__5__Impl )
            // InternalOCLX.g:3089:2: rule__CollectionIterator__Group__5__Impl
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
    // InternalOCLX.g:3095:1: rule__CollectionIterator__Group__5__Impl : ( ')' ) ;
    public final void rule__CollectionIterator__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3099:1: ( ( ')' ) )
            // InternalOCLX.g:3100:1: ( ')' )
            {
            // InternalOCLX.g:3100:1: ( ')' )
            // InternalOCLX.g:3101:2: ')'
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
    // InternalOCLX.g:3111:1: rule__IteratorVarDeclaration__Group_1__0 : rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1 ;
    public final void rule__IteratorVarDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3115:1: ( rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1 )
            // InternalOCLX.g:3116:2: rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1
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
    // InternalOCLX.g:3123:1: rule__IteratorVarDeclaration__Group_1__0__Impl : ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) ) ;
    public final void rule__IteratorVarDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3127:1: ( ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) ) )
            // InternalOCLX.g:3128:1: ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) )
            {
            // InternalOCLX.g:3128:1: ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) )
            // InternalOCLX.g:3129:2: ( rule__IteratorVarDeclaration__NameAssignment_1_0 )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_1_0()); 
            // InternalOCLX.g:3130:2: ( rule__IteratorVarDeclaration__NameAssignment_1_0 )
            // InternalOCLX.g:3130:3: rule__IteratorVarDeclaration__NameAssignment_1_0
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
    // InternalOCLX.g:3138:1: rule__IteratorVarDeclaration__Group_1__1 : rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2 ;
    public final void rule__IteratorVarDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3142:1: ( rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2 )
            // InternalOCLX.g:3143:2: rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2
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
    // InternalOCLX.g:3150:1: rule__IteratorVarDeclaration__Group_1__1__Impl : ( ':' ) ;
    public final void rule__IteratorVarDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3154:1: ( ( ':' ) )
            // InternalOCLX.g:3155:1: ( ':' )
            {
            // InternalOCLX.g:3155:1: ( ':' )
            // InternalOCLX.g:3156:2: ':'
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getColonKeyword_1_1()); 
            match(input,55,FOLLOW_2); 
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
    // InternalOCLX.g:3165:1: rule__IteratorVarDeclaration__Group_1__2 : rule__IteratorVarDeclaration__Group_1__2__Impl ;
    public final void rule__IteratorVarDeclaration__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3169:1: ( rule__IteratorVarDeclaration__Group_1__2__Impl )
            // InternalOCLX.g:3170:2: rule__IteratorVarDeclaration__Group_1__2__Impl
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
    // InternalOCLX.g:3176:1: rule__IteratorVarDeclaration__Group_1__2__Impl : ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) ) ;
    public final void rule__IteratorVarDeclaration__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3180:1: ( ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) ) )
            // InternalOCLX.g:3181:1: ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) )
            {
            // InternalOCLX.g:3181:1: ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) )
            // InternalOCLX.g:3182:2: ( rule__IteratorVarDeclaration__TypeAssignment_1_2 )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getTypeAssignment_1_2()); 
            // InternalOCLX.g:3183:2: ( rule__IteratorVarDeclaration__TypeAssignment_1_2 )
            // InternalOCLX.g:3183:3: rule__IteratorVarDeclaration__TypeAssignment_1_2
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
    // InternalOCLX.g:3192:1: rule__MethodCall__Group_0__0 : rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1 ;
    public final void rule__MethodCall__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3196:1: ( rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1 )
            // InternalOCLX.g:3197:2: rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1
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
    // InternalOCLX.g:3204:1: rule__MethodCall__Group_0__0__Impl : ( ( rule__MethodCall__NameAssignment_0_0 ) ) ;
    public final void rule__MethodCall__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3208:1: ( ( ( rule__MethodCall__NameAssignment_0_0 ) ) )
            // InternalOCLX.g:3209:1: ( ( rule__MethodCall__NameAssignment_0_0 ) )
            {
            // InternalOCLX.g:3209:1: ( ( rule__MethodCall__NameAssignment_0_0 ) )
            // InternalOCLX.g:3210:2: ( rule__MethodCall__NameAssignment_0_0 )
            {
             before(grammarAccess.getMethodCallAccess().getNameAssignment_0_0()); 
            // InternalOCLX.g:3211:2: ( rule__MethodCall__NameAssignment_0_0 )
            // InternalOCLX.g:3211:3: rule__MethodCall__NameAssignment_0_0
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
    // InternalOCLX.g:3219:1: rule__MethodCall__Group_0__1 : rule__MethodCall__Group_0__1__Impl ;
    public final void rule__MethodCall__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3223:1: ( rule__MethodCall__Group_0__1__Impl )
            // InternalOCLX.g:3224:2: rule__MethodCall__Group_0__1__Impl
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
    // InternalOCLX.g:3230:1: rule__MethodCall__Group_0__1__Impl : ( '()' ) ;
    public final void rule__MethodCall__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3234:1: ( ( '()' ) )
            // InternalOCLX.g:3235:1: ( '()' )
            {
            // InternalOCLX.g:3235:1: ( '()' )
            // InternalOCLX.g:3236:2: '()'
            {
             before(grammarAccess.getMethodCallAccess().getLeftParenthesisRightParenthesisKeyword_0_1()); 
            match(input,56,FOLLOW_2); 
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
    // InternalOCLX.g:3246:1: rule__MethodCall__Group_1__0 : rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1 ;
    public final void rule__MethodCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3250:1: ( rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1 )
            // InternalOCLX.g:3251:2: rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1
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
    // InternalOCLX.g:3258:1: rule__MethodCall__Group_1__0__Impl : ( ( rule__MethodCall__NameAssignment_1_0 ) ) ;
    public final void rule__MethodCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3262:1: ( ( ( rule__MethodCall__NameAssignment_1_0 ) ) )
            // InternalOCLX.g:3263:1: ( ( rule__MethodCall__NameAssignment_1_0 ) )
            {
            // InternalOCLX.g:3263:1: ( ( rule__MethodCall__NameAssignment_1_0 ) )
            // InternalOCLX.g:3264:2: ( rule__MethodCall__NameAssignment_1_0 )
            {
             before(grammarAccess.getMethodCallAccess().getNameAssignment_1_0()); 
            // InternalOCLX.g:3265:2: ( rule__MethodCall__NameAssignment_1_0 )
            // InternalOCLX.g:3265:3: rule__MethodCall__NameAssignment_1_0
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
    // InternalOCLX.g:3273:1: rule__MethodCall__Group_1__1 : rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2 ;
    public final void rule__MethodCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3277:1: ( rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2 )
            // InternalOCLX.g:3278:2: rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2
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
    // InternalOCLX.g:3285:1: rule__MethodCall__Group_1__1__Impl : ( '(' ) ;
    public final void rule__MethodCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3289:1: ( ( '(' ) )
            // InternalOCLX.g:3290:1: ( '(' )
            {
            // InternalOCLX.g:3290:1: ( '(' )
            // InternalOCLX.g:3291:2: '('
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
    // InternalOCLX.g:3300:1: rule__MethodCall__Group_1__2 : rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3 ;
    public final void rule__MethodCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3304:1: ( rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3 )
            // InternalOCLX.g:3305:2: rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3
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
    // InternalOCLX.g:3312:1: rule__MethodCall__Group_1__2__Impl : ( ( rule__MethodCall__ArgsAssignment_1_2 ) ) ;
    public final void rule__MethodCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3316:1: ( ( ( rule__MethodCall__ArgsAssignment_1_2 ) ) )
            // InternalOCLX.g:3317:1: ( ( rule__MethodCall__ArgsAssignment_1_2 ) )
            {
            // InternalOCLX.g:3317:1: ( ( rule__MethodCall__ArgsAssignment_1_2 ) )
            // InternalOCLX.g:3318:2: ( rule__MethodCall__ArgsAssignment_1_2 )
            {
             before(grammarAccess.getMethodCallAccess().getArgsAssignment_1_2()); 
            // InternalOCLX.g:3319:2: ( rule__MethodCall__ArgsAssignment_1_2 )
            // InternalOCLX.g:3319:3: rule__MethodCall__ArgsAssignment_1_2
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
    // InternalOCLX.g:3327:1: rule__MethodCall__Group_1__3 : rule__MethodCall__Group_1__3__Impl ;
    public final void rule__MethodCall__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3331:1: ( rule__MethodCall__Group_1__3__Impl )
            // InternalOCLX.g:3332:2: rule__MethodCall__Group_1__3__Impl
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
    // InternalOCLX.g:3338:1: rule__MethodCall__Group_1__3__Impl : ( ')' ) ;
    public final void rule__MethodCall__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3342:1: ( ( ')' ) )
            // InternalOCLX.g:3343:1: ( ')' )
            {
            // InternalOCLX.g:3343:1: ( ')' )
            // InternalOCLX.g:3344:2: ')'
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
    // InternalOCLX.g:3354:1: rule__TypeCall__Group__0 : rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1 ;
    public final void rule__TypeCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3358:1: ( rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1 )
            // InternalOCLX.g:3359:2: rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1
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
    // InternalOCLX.g:3366:1: rule__TypeCall__Group__0__Impl : ( ( rule__TypeCall__NameAssignment_0 ) ) ;
    public final void rule__TypeCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3370:1: ( ( ( rule__TypeCall__NameAssignment_0 ) ) )
            // InternalOCLX.g:3371:1: ( ( rule__TypeCall__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3371:1: ( ( rule__TypeCall__NameAssignment_0 ) )
            // InternalOCLX.g:3372:2: ( rule__TypeCall__NameAssignment_0 )
            {
             before(grammarAccess.getTypeCallAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3373:2: ( rule__TypeCall__NameAssignment_0 )
            // InternalOCLX.g:3373:3: rule__TypeCall__NameAssignment_0
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
    // InternalOCLX.g:3381:1: rule__TypeCall__Group__1 : rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2 ;
    public final void rule__TypeCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3385:1: ( rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2 )
            // InternalOCLX.g:3386:2: rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2
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
    // InternalOCLX.g:3393:1: rule__TypeCall__Group__1__Impl : ( '(' ) ;
    public final void rule__TypeCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3397:1: ( ( '(' ) )
            // InternalOCLX.g:3398:1: ( '(' )
            {
            // InternalOCLX.g:3398:1: ( '(' )
            // InternalOCLX.g:3399:2: '('
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
    // InternalOCLX.g:3408:1: rule__TypeCall__Group__2 : rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3 ;
    public final void rule__TypeCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3412:1: ( rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3 )
            // InternalOCLX.g:3413:2: rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:3420:1: rule__TypeCall__Group__2__Impl : ( ( rule__TypeCall__TypeAssignment_2 ) ) ;
    public final void rule__TypeCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3424:1: ( ( ( rule__TypeCall__TypeAssignment_2 ) ) )
            // InternalOCLX.g:3425:1: ( ( rule__TypeCall__TypeAssignment_2 ) )
            {
            // InternalOCLX.g:3425:1: ( ( rule__TypeCall__TypeAssignment_2 ) )
            // InternalOCLX.g:3426:2: ( rule__TypeCall__TypeAssignment_2 )
            {
             before(grammarAccess.getTypeCallAccess().getTypeAssignment_2()); 
            // InternalOCLX.g:3427:2: ( rule__TypeCall__TypeAssignment_2 )
            // InternalOCLX.g:3427:3: rule__TypeCall__TypeAssignment_2
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
    // InternalOCLX.g:3435:1: rule__TypeCall__Group__3 : rule__TypeCall__Group__3__Impl ;
    public final void rule__TypeCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3439:1: ( rule__TypeCall__Group__3__Impl )
            // InternalOCLX.g:3440:2: rule__TypeCall__Group__3__Impl
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
    // InternalOCLX.g:3446:1: rule__TypeCall__Group__3__Impl : ( ')' ) ;
    public final void rule__TypeCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3450:1: ( ( ')' ) )
            // InternalOCLX.g:3451:1: ( ')' )
            {
            // InternalOCLX.g:3451:1: ( ')' )
            // InternalOCLX.g:3452:2: ')'
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
    // InternalOCLX.g:3462:1: rule__TypeExp__Group_0__0 : rule__TypeExp__Group_0__0__Impl rule__TypeExp__Group_0__1 ;
    public final void rule__TypeExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3466:1: ( rule__TypeExp__Group_0__0__Impl rule__TypeExp__Group_0__1 )
            // InternalOCLX.g:3467:2: rule__TypeExp__Group_0__0__Impl rule__TypeExp__Group_0__1
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
    // InternalOCLX.g:3474:1: rule__TypeExp__Group_0__0__Impl : ( () ) ;
    public final void rule__TypeExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3478:1: ( ( () ) )
            // InternalOCLX.g:3479:1: ( () )
            {
            // InternalOCLX.g:3479:1: ( () )
            // InternalOCLX.g:3480:2: ()
            {
             before(grammarAccess.getTypeExpAccess().getTypeExpAction_0_0()); 
            // InternalOCLX.g:3481:2: ()
            // InternalOCLX.g:3481:3: 
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
    // InternalOCLX.g:3489:1: rule__TypeExp__Group_0__1 : rule__TypeExp__Group_0__1__Impl rule__TypeExp__Group_0__2 ;
    public final void rule__TypeExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3493:1: ( rule__TypeExp__Group_0__1__Impl rule__TypeExp__Group_0__2 )
            // InternalOCLX.g:3494:2: rule__TypeExp__Group_0__1__Impl rule__TypeExp__Group_0__2
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
    // InternalOCLX.g:3501:1: rule__TypeExp__Group_0__1__Impl : ( '<' ) ;
    public final void rule__TypeExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3505:1: ( ( '<' ) )
            // InternalOCLX.g:3506:1: ( '<' )
            {
            // InternalOCLX.g:3506:1: ( '<' )
            // InternalOCLX.g:3507:2: '<'
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
    // InternalOCLX.g:3516:1: rule__TypeExp__Group_0__2 : rule__TypeExp__Group_0__2__Impl rule__TypeExp__Group_0__3 ;
    public final void rule__TypeExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3520:1: ( rule__TypeExp__Group_0__2__Impl rule__TypeExp__Group_0__3 )
            // InternalOCLX.g:3521:2: rule__TypeExp__Group_0__2__Impl rule__TypeExp__Group_0__3
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
    // InternalOCLX.g:3528:1: rule__TypeExp__Group_0__2__Impl : ( ( rule__TypeExp__NameAssignment_0_2 ) ) ;
    public final void rule__TypeExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3532:1: ( ( ( rule__TypeExp__NameAssignment_0_2 ) ) )
            // InternalOCLX.g:3533:1: ( ( rule__TypeExp__NameAssignment_0_2 ) )
            {
            // InternalOCLX.g:3533:1: ( ( rule__TypeExp__NameAssignment_0_2 ) )
            // InternalOCLX.g:3534:2: ( rule__TypeExp__NameAssignment_0_2 )
            {
             before(grammarAccess.getTypeExpAccess().getNameAssignment_0_2()); 
            // InternalOCLX.g:3535:2: ( rule__TypeExp__NameAssignment_0_2 )
            // InternalOCLX.g:3535:3: rule__TypeExp__NameAssignment_0_2
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
    // InternalOCLX.g:3543:1: rule__TypeExp__Group_0__3 : rule__TypeExp__Group_0__3__Impl ;
    public final void rule__TypeExp__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3547:1: ( rule__TypeExp__Group_0__3__Impl )
            // InternalOCLX.g:3548:2: rule__TypeExp__Group_0__3__Impl
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
    // InternalOCLX.g:3554:1: rule__TypeExp__Group_0__3__Impl : ( '>' ) ;
    public final void rule__TypeExp__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3558:1: ( ( '>' ) )
            // InternalOCLX.g:3559:1: ( '>' )
            {
            // InternalOCLX.g:3559:1: ( '>' )
            // InternalOCLX.g:3560:2: '>'
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
    // InternalOCLX.g:3570:1: rule__TypeExp__Group_1__0 : rule__TypeExp__Group_1__0__Impl rule__TypeExp__Group_1__1 ;
    public final void rule__TypeExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3574:1: ( rule__TypeExp__Group_1__0__Impl rule__TypeExp__Group_1__1 )
            // InternalOCLX.g:3575:2: rule__TypeExp__Group_1__0__Impl rule__TypeExp__Group_1__1
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
    // InternalOCLX.g:3582:1: rule__TypeExp__Group_1__0__Impl : ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) ) ;
    public final void rule__TypeExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3586:1: ( ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) ) )
            // InternalOCLX.g:3587:1: ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) )
            {
            // InternalOCLX.g:3587:1: ( ( rule__TypeExp__CollectionTypeAssignment_1_0 ) )
            // InternalOCLX.g:3588:2: ( rule__TypeExp__CollectionTypeAssignment_1_0 )
            {
             before(grammarAccess.getTypeExpAccess().getCollectionTypeAssignment_1_0()); 
            // InternalOCLX.g:3589:2: ( rule__TypeExp__CollectionTypeAssignment_1_0 )
            // InternalOCLX.g:3589:3: rule__TypeExp__CollectionTypeAssignment_1_0
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
    // InternalOCLX.g:3597:1: rule__TypeExp__Group_1__1 : rule__TypeExp__Group_1__1__Impl ;
    public final void rule__TypeExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3601:1: ( rule__TypeExp__Group_1__1__Impl )
            // InternalOCLX.g:3602:2: rule__TypeExp__Group_1__1__Impl
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
    // InternalOCLX.g:3608:1: rule__TypeExp__Group_1__1__Impl : ( ( rule__TypeExp__TypeAssignment_1_1 ) ) ;
    public final void rule__TypeExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3612:1: ( ( ( rule__TypeExp__TypeAssignment_1_1 ) ) )
            // InternalOCLX.g:3613:1: ( ( rule__TypeExp__TypeAssignment_1_1 ) )
            {
            // InternalOCLX.g:3613:1: ( ( rule__TypeExp__TypeAssignment_1_1 ) )
            // InternalOCLX.g:3614:2: ( rule__TypeExp__TypeAssignment_1_1 )
            {
             before(grammarAccess.getTypeExpAccess().getTypeAssignment_1_1()); 
            // InternalOCLX.g:3615:2: ( rule__TypeExp__TypeAssignment_1_1 )
            // InternalOCLX.g:3615:3: rule__TypeExp__TypeAssignment_1_1
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
    // InternalOCLX.g:3624:1: rule__UnaryTemporalExp__Group__0 : rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1 ;
    public final void rule__UnaryTemporalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3628:1: ( rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1 )
            // InternalOCLX.g:3629:2: rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1
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
    // InternalOCLX.g:3636:1: rule__UnaryTemporalExp__Group__0__Impl : ( ( rule__UnaryTemporalExp__NameAssignment_0 ) ) ;
    public final void rule__UnaryTemporalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3640:1: ( ( ( rule__UnaryTemporalExp__NameAssignment_0 ) ) )
            // InternalOCLX.g:3641:1: ( ( rule__UnaryTemporalExp__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3641:1: ( ( rule__UnaryTemporalExp__NameAssignment_0 ) )
            // InternalOCLX.g:3642:2: ( rule__UnaryTemporalExp__NameAssignment_0 )
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3643:2: ( rule__UnaryTemporalExp__NameAssignment_0 )
            // InternalOCLX.g:3643:3: rule__UnaryTemporalExp__NameAssignment_0
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
    // InternalOCLX.g:3651:1: rule__UnaryTemporalExp__Group__1 : rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2 ;
    public final void rule__UnaryTemporalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3655:1: ( rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2 )
            // InternalOCLX.g:3656:2: rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2
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
    // InternalOCLX.g:3663:1: rule__UnaryTemporalExp__Group__1__Impl : ( '(' ) ;
    public final void rule__UnaryTemporalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3667:1: ( ( '(' ) )
            // InternalOCLX.g:3668:1: ( '(' )
            {
            // InternalOCLX.g:3668:1: ( '(' )
            // InternalOCLX.g:3669:2: '('
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
    // InternalOCLX.g:3678:1: rule__UnaryTemporalExp__Group__2 : rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3 ;
    public final void rule__UnaryTemporalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3682:1: ( rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3 )
            // InternalOCLX.g:3683:2: rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:3690:1: rule__UnaryTemporalExp__Group__2__Impl : ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) ) ;
    public final void rule__UnaryTemporalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3694:1: ( ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) ) )
            // InternalOCLX.g:3695:1: ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) )
            {
            // InternalOCLX.g:3695:1: ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) )
            // InternalOCLX.g:3696:2: ( rule__UnaryTemporalExp__ExpAssignment_2 )
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getExpAssignment_2()); 
            // InternalOCLX.g:3697:2: ( rule__UnaryTemporalExp__ExpAssignment_2 )
            // InternalOCLX.g:3697:3: rule__UnaryTemporalExp__ExpAssignment_2
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
    // InternalOCLX.g:3705:1: rule__UnaryTemporalExp__Group__3 : rule__UnaryTemporalExp__Group__3__Impl ;
    public final void rule__UnaryTemporalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3709:1: ( rule__UnaryTemporalExp__Group__3__Impl )
            // InternalOCLX.g:3710:2: rule__UnaryTemporalExp__Group__3__Impl
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
    // InternalOCLX.g:3716:1: rule__UnaryTemporalExp__Group__3__Impl : ( ')' ) ;
    public final void rule__UnaryTemporalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3720:1: ( ( ')' ) )
            // InternalOCLX.g:3721:1: ( ')' )
            {
            // InternalOCLX.g:3721:1: ( ')' )
            // InternalOCLX.g:3722:2: ')'
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
    // InternalOCLX.g:3732:1: rule__TemporalAsLongAs__Group__0 : rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1 ;
    public final void rule__TemporalAsLongAs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3736:1: ( rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1 )
            // InternalOCLX.g:3737:2: rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1
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
    // InternalOCLX.g:3744:1: rule__TemporalAsLongAs__Group__0__Impl : ( ( rule__TemporalAsLongAs__NameAssignment_0 ) ) ;
    public final void rule__TemporalAsLongAs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3748:1: ( ( ( rule__TemporalAsLongAs__NameAssignment_0 ) ) )
            // InternalOCLX.g:3749:1: ( ( rule__TemporalAsLongAs__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3749:1: ( ( rule__TemporalAsLongAs__NameAssignment_0 ) )
            // InternalOCLX.g:3750:2: ( rule__TemporalAsLongAs__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3751:2: ( rule__TemporalAsLongAs__NameAssignment_0 )
            // InternalOCLX.g:3751:3: rule__TemporalAsLongAs__NameAssignment_0
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
    // InternalOCLX.g:3759:1: rule__TemporalAsLongAs__Group__1 : rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2 ;
    public final void rule__TemporalAsLongAs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3763:1: ( rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2 )
            // InternalOCLX.g:3764:2: rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2
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
    // InternalOCLX.g:3771:1: rule__TemporalAsLongAs__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalAsLongAs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3775:1: ( ( '(' ) )
            // InternalOCLX.g:3776:1: ( '(' )
            {
            // InternalOCLX.g:3776:1: ( '(' )
            // InternalOCLX.g:3777:2: '('
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
    // InternalOCLX.g:3786:1: rule__TemporalAsLongAs__Group__2 : rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3 ;
    public final void rule__TemporalAsLongAs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3790:1: ( rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3 )
            // InternalOCLX.g:3791:2: rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3
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
    // InternalOCLX.g:3798:1: rule__TemporalAsLongAs__Group__2__Impl : ( ( rule__TemporalAsLongAs__BAssignment_2 ) ) ;
    public final void rule__TemporalAsLongAs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3802:1: ( ( ( rule__TemporalAsLongAs__BAssignment_2 ) ) )
            // InternalOCLX.g:3803:1: ( ( rule__TemporalAsLongAs__BAssignment_2 ) )
            {
            // InternalOCLX.g:3803:1: ( ( rule__TemporalAsLongAs__BAssignment_2 ) )
            // InternalOCLX.g:3804:2: ( rule__TemporalAsLongAs__BAssignment_2 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getBAssignment_2()); 
            // InternalOCLX.g:3805:2: ( rule__TemporalAsLongAs__BAssignment_2 )
            // InternalOCLX.g:3805:3: rule__TemporalAsLongAs__BAssignment_2
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
    // InternalOCLX.g:3813:1: rule__TemporalAsLongAs__Group__3 : rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4 ;
    public final void rule__TemporalAsLongAs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3817:1: ( rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4 )
            // InternalOCLX.g:3818:2: rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4
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
    // InternalOCLX.g:3825:1: rule__TemporalAsLongAs__Group__3__Impl : ( 'ensureThat' ) ;
    public final void rule__TemporalAsLongAs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3829:1: ( ( 'ensureThat' ) )
            // InternalOCLX.g:3830:1: ( 'ensureThat' )
            {
            // InternalOCLX.g:3830:1: ( 'ensureThat' )
            // InternalOCLX.g:3831:2: 'ensureThat'
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getEnsureThatKeyword_3()); 
            match(input,57,FOLLOW_2); 
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
    // InternalOCLX.g:3840:1: rule__TemporalAsLongAs__Group__4 : rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5 ;
    public final void rule__TemporalAsLongAs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3844:1: ( rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5 )
            // InternalOCLX.g:3845:2: rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:3852:1: rule__TemporalAsLongAs__Group__4__Impl : ( ( rule__TemporalAsLongAs__AAssignment_4 ) ) ;
    public final void rule__TemporalAsLongAs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3856:1: ( ( ( rule__TemporalAsLongAs__AAssignment_4 ) ) )
            // InternalOCLX.g:3857:1: ( ( rule__TemporalAsLongAs__AAssignment_4 ) )
            {
            // InternalOCLX.g:3857:1: ( ( rule__TemporalAsLongAs__AAssignment_4 ) )
            // InternalOCLX.g:3858:2: ( rule__TemporalAsLongAs__AAssignment_4 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getAAssignment_4()); 
            // InternalOCLX.g:3859:2: ( rule__TemporalAsLongAs__AAssignment_4 )
            // InternalOCLX.g:3859:3: rule__TemporalAsLongAs__AAssignment_4
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
    // InternalOCLX.g:3867:1: rule__TemporalAsLongAs__Group__5 : rule__TemporalAsLongAs__Group__5__Impl ;
    public final void rule__TemporalAsLongAs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3871:1: ( rule__TemporalAsLongAs__Group__5__Impl )
            // InternalOCLX.g:3872:2: rule__TemporalAsLongAs__Group__5__Impl
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
    // InternalOCLX.g:3878:1: rule__TemporalAsLongAs__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalAsLongAs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3882:1: ( ( ')' ) )
            // InternalOCLX.g:3883:1: ( ')' )
            {
            // InternalOCLX.g:3883:1: ( ')' )
            // InternalOCLX.g:3884:2: ')'
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
    // InternalOCLX.g:3894:1: rule__TemporalUntil__Group__0 : rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1 ;
    public final void rule__TemporalUntil__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3898:1: ( rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1 )
            // InternalOCLX.g:3899:2: rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1
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
    // InternalOCLX.g:3906:1: rule__TemporalUntil__Group__0__Impl : ( ( rule__TemporalUntil__NameAssignment_0 ) ) ;
    public final void rule__TemporalUntil__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3910:1: ( ( ( rule__TemporalUntil__NameAssignment_0 ) ) )
            // InternalOCLX.g:3911:1: ( ( rule__TemporalUntil__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3911:1: ( ( rule__TemporalUntil__NameAssignment_0 ) )
            // InternalOCLX.g:3912:2: ( rule__TemporalUntil__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalUntilAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3913:2: ( rule__TemporalUntil__NameAssignment_0 )
            // InternalOCLX.g:3913:3: rule__TemporalUntil__NameAssignment_0
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
    // InternalOCLX.g:3921:1: rule__TemporalUntil__Group__1 : rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2 ;
    public final void rule__TemporalUntil__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3925:1: ( rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2 )
            // InternalOCLX.g:3926:2: rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2
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
    // InternalOCLX.g:3933:1: rule__TemporalUntil__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalUntil__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3937:1: ( ( '(' ) )
            // InternalOCLX.g:3938:1: ( '(' )
            {
            // InternalOCLX.g:3938:1: ( '(' )
            // InternalOCLX.g:3939:2: '('
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
    // InternalOCLX.g:3948:1: rule__TemporalUntil__Group__2 : rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3 ;
    public final void rule__TemporalUntil__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3952:1: ( rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3 )
            // InternalOCLX.g:3953:2: rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3
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
    // InternalOCLX.g:3960:1: rule__TemporalUntil__Group__2__Impl : ( ( rule__TemporalUntil__AAssignment_2 ) ) ;
    public final void rule__TemporalUntil__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3964:1: ( ( ( rule__TemporalUntil__AAssignment_2 ) ) )
            // InternalOCLX.g:3965:1: ( ( rule__TemporalUntil__AAssignment_2 ) )
            {
            // InternalOCLX.g:3965:1: ( ( rule__TemporalUntil__AAssignment_2 ) )
            // InternalOCLX.g:3966:2: ( rule__TemporalUntil__AAssignment_2 )
            {
             before(grammarAccess.getTemporalUntilAccess().getAAssignment_2()); 
            // InternalOCLX.g:3967:2: ( rule__TemporalUntil__AAssignment_2 )
            // InternalOCLX.g:3967:3: rule__TemporalUntil__AAssignment_2
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
    // InternalOCLX.g:3975:1: rule__TemporalUntil__Group__3 : rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4 ;
    public final void rule__TemporalUntil__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3979:1: ( rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4 )
            // InternalOCLX.g:3980:2: rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4
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
    // InternalOCLX.g:3987:1: rule__TemporalUntil__Group__3__Impl : ( 'asLongAs' ) ;
    public final void rule__TemporalUntil__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3991:1: ( ( 'asLongAs' ) )
            // InternalOCLX.g:3992:1: ( 'asLongAs' )
            {
            // InternalOCLX.g:3992:1: ( 'asLongAs' )
            // InternalOCLX.g:3993:2: 'asLongAs'
            {
             before(grammarAccess.getTemporalUntilAccess().getAsLongAsKeyword_3()); 
            match(input,58,FOLLOW_2); 
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
    // InternalOCLX.g:4002:1: rule__TemporalUntil__Group__4 : rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5 ;
    public final void rule__TemporalUntil__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4006:1: ( rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5 )
            // InternalOCLX.g:4007:2: rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:4014:1: rule__TemporalUntil__Group__4__Impl : ( ( rule__TemporalUntil__BAssignment_4 ) ) ;
    public final void rule__TemporalUntil__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4018:1: ( ( ( rule__TemporalUntil__BAssignment_4 ) ) )
            // InternalOCLX.g:4019:1: ( ( rule__TemporalUntil__BAssignment_4 ) )
            {
            // InternalOCLX.g:4019:1: ( ( rule__TemporalUntil__BAssignment_4 ) )
            // InternalOCLX.g:4020:2: ( rule__TemporalUntil__BAssignment_4 )
            {
             before(grammarAccess.getTemporalUntilAccess().getBAssignment_4()); 
            // InternalOCLX.g:4021:2: ( rule__TemporalUntil__BAssignment_4 )
            // InternalOCLX.g:4021:3: rule__TemporalUntil__BAssignment_4
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
    // InternalOCLX.g:4029:1: rule__TemporalUntil__Group__5 : rule__TemporalUntil__Group__5__Impl ;
    public final void rule__TemporalUntil__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4033:1: ( rule__TemporalUntil__Group__5__Impl )
            // InternalOCLX.g:4034:2: rule__TemporalUntil__Group__5__Impl
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
    // InternalOCLX.g:4040:1: rule__TemporalUntil__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalUntil__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4044:1: ( ( ')' ) )
            // InternalOCLX.g:4045:1: ( ')' )
            {
            // InternalOCLX.g:4045:1: ( ')' )
            // InternalOCLX.g:4046:2: ')'
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
    // InternalOCLX.g:4056:1: rule__TemporalEverytime__Group__0 : rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1 ;
    public final void rule__TemporalEverytime__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4060:1: ( rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1 )
            // InternalOCLX.g:4061:2: rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1
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
    // InternalOCLX.g:4068:1: rule__TemporalEverytime__Group__0__Impl : ( ( rule__TemporalEverytime__NameAssignment_0 ) ) ;
    public final void rule__TemporalEverytime__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4072:1: ( ( ( rule__TemporalEverytime__NameAssignment_0 ) ) )
            // InternalOCLX.g:4073:1: ( ( rule__TemporalEverytime__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4073:1: ( ( rule__TemporalEverytime__NameAssignment_0 ) )
            // InternalOCLX.g:4074:2: ( rule__TemporalEverytime__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4075:2: ( rule__TemporalEverytime__NameAssignment_0 )
            // InternalOCLX.g:4075:3: rule__TemporalEverytime__NameAssignment_0
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
    // InternalOCLX.g:4083:1: rule__TemporalEverytime__Group__1 : rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2 ;
    public final void rule__TemporalEverytime__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4087:1: ( rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2 )
            // InternalOCLX.g:4088:2: rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2
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
    // InternalOCLX.g:4095:1: rule__TemporalEverytime__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalEverytime__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4099:1: ( ( '(' ) )
            // InternalOCLX.g:4100:1: ( '(' )
            {
            // InternalOCLX.g:4100:1: ( '(' )
            // InternalOCLX.g:4101:2: '('
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
    // InternalOCLX.g:4110:1: rule__TemporalEverytime__Group__2 : rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3 ;
    public final void rule__TemporalEverytime__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4114:1: ( rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3 )
            // InternalOCLX.g:4115:2: rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3
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
    // InternalOCLX.g:4122:1: rule__TemporalEverytime__Group__2__Impl : ( ( rule__TemporalEverytime__AAssignment_2 ) ) ;
    public final void rule__TemporalEverytime__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4126:1: ( ( ( rule__TemporalEverytime__AAssignment_2 ) ) )
            // InternalOCLX.g:4127:1: ( ( rule__TemporalEverytime__AAssignment_2 ) )
            {
            // InternalOCLX.g:4127:1: ( ( rule__TemporalEverytime__AAssignment_2 ) )
            // InternalOCLX.g:4128:2: ( rule__TemporalEverytime__AAssignment_2 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getAAssignment_2()); 
            // InternalOCLX.g:4129:2: ( rule__TemporalEverytime__AAssignment_2 )
            // InternalOCLX.g:4129:3: rule__TemporalEverytime__AAssignment_2
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
    // InternalOCLX.g:4137:1: rule__TemporalEverytime__Group__3 : rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4 ;
    public final void rule__TemporalEverytime__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4141:1: ( rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4 )
            // InternalOCLX.g:4142:2: rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4
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
    // InternalOCLX.g:4149:1: rule__TemporalEverytime__Group__3__Impl : ( 'then' ) ;
    public final void rule__TemporalEverytime__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4153:1: ( ( 'then' ) )
            // InternalOCLX.g:4154:1: ( 'then' )
            {
            // InternalOCLX.g:4154:1: ( 'then' )
            // InternalOCLX.g:4155:2: 'then'
            {
             before(grammarAccess.getTemporalEverytimeAccess().getThenKeyword_3()); 
            match(input,59,FOLLOW_2); 
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
    // InternalOCLX.g:4164:1: rule__TemporalEverytime__Group__4 : rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5 ;
    public final void rule__TemporalEverytime__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4168:1: ( rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5 )
            // InternalOCLX.g:4169:2: rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:4176:1: rule__TemporalEverytime__Group__4__Impl : ( ( rule__TemporalEverytime__BAssignment_4 ) ) ;
    public final void rule__TemporalEverytime__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4180:1: ( ( ( rule__TemporalEverytime__BAssignment_4 ) ) )
            // InternalOCLX.g:4181:1: ( ( rule__TemporalEverytime__BAssignment_4 ) )
            {
            // InternalOCLX.g:4181:1: ( ( rule__TemporalEverytime__BAssignment_4 ) )
            // InternalOCLX.g:4182:2: ( rule__TemporalEverytime__BAssignment_4 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getBAssignment_4()); 
            // InternalOCLX.g:4183:2: ( rule__TemporalEverytime__BAssignment_4 )
            // InternalOCLX.g:4183:3: rule__TemporalEverytime__BAssignment_4
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
    // InternalOCLX.g:4191:1: rule__TemporalEverytime__Group__5 : rule__TemporalEverytime__Group__5__Impl ;
    public final void rule__TemporalEverytime__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4195:1: ( rule__TemporalEverytime__Group__5__Impl )
            // InternalOCLX.g:4196:2: rule__TemporalEverytime__Group__5__Impl
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
    // InternalOCLX.g:4202:1: rule__TemporalEverytime__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalEverytime__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4206:1: ( ( ')' ) )
            // InternalOCLX.g:4207:1: ( ')' )
            {
            // InternalOCLX.g:4207:1: ( ')' )
            // InternalOCLX.g:4208:2: ')'
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
    // InternalOCLX.g:4218:1: rule__TemporalAtLeastOnce__Group__0 : rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1 ;
    public final void rule__TemporalAtLeastOnce__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4222:1: ( rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1 )
            // InternalOCLX.g:4223:2: rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1
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
    // InternalOCLX.g:4230:1: rule__TemporalAtLeastOnce__Group__0__Impl : ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4234:1: ( ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) ) )
            // InternalOCLX.g:4235:1: ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4235:1: ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) )
            // InternalOCLX.g:4236:2: ( rule__TemporalAtLeastOnce__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4237:2: ( rule__TemporalAtLeastOnce__NameAssignment_0 )
            // InternalOCLX.g:4237:3: rule__TemporalAtLeastOnce__NameAssignment_0
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
    // InternalOCLX.g:4245:1: rule__TemporalAtLeastOnce__Group__1 : rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2 ;
    public final void rule__TemporalAtLeastOnce__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4249:1: ( rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2 )
            // InternalOCLX.g:4250:2: rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2
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
    // InternalOCLX.g:4257:1: rule__TemporalAtLeastOnce__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalAtLeastOnce__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4261:1: ( ( '(' ) )
            // InternalOCLX.g:4262:1: ( '(' )
            {
            // InternalOCLX.g:4262:1: ( '(' )
            // InternalOCLX.g:4263:2: '('
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
    // InternalOCLX.g:4272:1: rule__TemporalAtLeastOnce__Group__2 : rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3 ;
    public final void rule__TemporalAtLeastOnce__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4276:1: ( rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3 )
            // InternalOCLX.g:4277:2: rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3
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
    // InternalOCLX.g:4284:1: rule__TemporalAtLeastOnce__Group__2__Impl : ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4288:1: ( ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) ) )
            // InternalOCLX.g:4289:1: ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) )
            {
            // InternalOCLX.g:4289:1: ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) )
            // InternalOCLX.g:4290:2: ( rule__TemporalAtLeastOnce__AAssignment_2 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getAAssignment_2()); 
            // InternalOCLX.g:4291:2: ( rule__TemporalAtLeastOnce__AAssignment_2 )
            // InternalOCLX.g:4291:3: rule__TemporalAtLeastOnce__AAssignment_2
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
    // InternalOCLX.g:4299:1: rule__TemporalAtLeastOnce__Group__3 : rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4 ;
    public final void rule__TemporalAtLeastOnce__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4303:1: ( rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4 )
            // InternalOCLX.g:4304:2: rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4
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
    // InternalOCLX.g:4311:1: rule__TemporalAtLeastOnce__Group__3__Impl : ( 'thenAtLeastOnce' ) ;
    public final void rule__TemporalAtLeastOnce__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4315:1: ( ( 'thenAtLeastOnce' ) )
            // InternalOCLX.g:4316:1: ( 'thenAtLeastOnce' )
            {
            // InternalOCLX.g:4316:1: ( 'thenAtLeastOnce' )
            // InternalOCLX.g:4317:2: 'thenAtLeastOnce'
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getThenAtLeastOnceKeyword_3()); 
            match(input,60,FOLLOW_2); 
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
    // InternalOCLX.g:4326:1: rule__TemporalAtLeastOnce__Group__4 : rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5 ;
    public final void rule__TemporalAtLeastOnce__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4330:1: ( rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5 )
            // InternalOCLX.g:4331:2: rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:4338:1: rule__TemporalAtLeastOnce__Group__4__Impl : ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4342:1: ( ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) ) )
            // InternalOCLX.g:4343:1: ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) )
            {
            // InternalOCLX.g:4343:1: ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) )
            // InternalOCLX.g:4344:2: ( rule__TemporalAtLeastOnce__BAssignment_4 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getBAssignment_4()); 
            // InternalOCLX.g:4345:2: ( rule__TemporalAtLeastOnce__BAssignment_4 )
            // InternalOCLX.g:4345:3: rule__TemporalAtLeastOnce__BAssignment_4
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
    // InternalOCLX.g:4353:1: rule__TemporalAtLeastOnce__Group__5 : rule__TemporalAtLeastOnce__Group__5__Impl ;
    public final void rule__TemporalAtLeastOnce__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4357:1: ( rule__TemporalAtLeastOnce__Group__5__Impl )
            // InternalOCLX.g:4358:2: rule__TemporalAtLeastOnce__Group__5__Impl
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
    // InternalOCLX.g:4364:1: rule__TemporalAtLeastOnce__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalAtLeastOnce__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4368:1: ( ( ')' ) )
            // InternalOCLX.g:4369:1: ( ')' )
            {
            // InternalOCLX.g:4369:1: ( ')' )
            // InternalOCLX.g:4370:2: ')'
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
    // InternalOCLX.g:4380:1: rule__LegacyUntil__Group__0 : rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1 ;
    public final void rule__LegacyUntil__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4384:1: ( rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1 )
            // InternalOCLX.g:4385:2: rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1
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
    // InternalOCLX.g:4392:1: rule__LegacyUntil__Group__0__Impl : ( ( rule__LegacyUntil__NameAssignment_0 ) ) ;
    public final void rule__LegacyUntil__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4396:1: ( ( ( rule__LegacyUntil__NameAssignment_0 ) ) )
            // InternalOCLX.g:4397:1: ( ( rule__LegacyUntil__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4397:1: ( ( rule__LegacyUntil__NameAssignment_0 ) )
            // InternalOCLX.g:4398:2: ( rule__LegacyUntil__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyUntilAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4399:2: ( rule__LegacyUntil__NameAssignment_0 )
            // InternalOCLX.g:4399:3: rule__LegacyUntil__NameAssignment_0
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
    // InternalOCLX.g:4407:1: rule__LegacyUntil__Group__1 : rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2 ;
    public final void rule__LegacyUntil__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4411:1: ( rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2 )
            // InternalOCLX.g:4412:2: rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2
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
    // InternalOCLX.g:4419:1: rule__LegacyUntil__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyUntil__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4423:1: ( ( '(' ) )
            // InternalOCLX.g:4424:1: ( '(' )
            {
            // InternalOCLX.g:4424:1: ( '(' )
            // InternalOCLX.g:4425:2: '('
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
    // InternalOCLX.g:4434:1: rule__LegacyUntil__Group__2 : rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3 ;
    public final void rule__LegacyUntil__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4438:1: ( rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3 )
            // InternalOCLX.g:4439:2: rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3
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
    // InternalOCLX.g:4446:1: rule__LegacyUntil__Group__2__Impl : ( ( rule__LegacyUntil__AAssignment_2 ) ) ;
    public final void rule__LegacyUntil__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4450:1: ( ( ( rule__LegacyUntil__AAssignment_2 ) ) )
            // InternalOCLX.g:4451:1: ( ( rule__LegacyUntil__AAssignment_2 ) )
            {
            // InternalOCLX.g:4451:1: ( ( rule__LegacyUntil__AAssignment_2 ) )
            // InternalOCLX.g:4452:2: ( rule__LegacyUntil__AAssignment_2 )
            {
             before(grammarAccess.getLegacyUntilAccess().getAAssignment_2()); 
            // InternalOCLX.g:4453:2: ( rule__LegacyUntil__AAssignment_2 )
            // InternalOCLX.g:4453:3: rule__LegacyUntil__AAssignment_2
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
    // InternalOCLX.g:4461:1: rule__LegacyUntil__Group__3 : rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4 ;
    public final void rule__LegacyUntil__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4465:1: ( rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4 )
            // InternalOCLX.g:4466:2: rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4
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
    // InternalOCLX.g:4473:1: rule__LegacyUntil__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyUntil__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4477:1: ( ( ',' ) )
            // InternalOCLX.g:4478:1: ( ',' )
            {
            // InternalOCLX.g:4478:1: ( ',' )
            // InternalOCLX.g:4479:2: ','
            {
             before(grammarAccess.getLegacyUntilAccess().getCommaKeyword_3()); 
            match(input,61,FOLLOW_2); 
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
    // InternalOCLX.g:4488:1: rule__LegacyUntil__Group__4 : rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5 ;
    public final void rule__LegacyUntil__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4492:1: ( rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5 )
            // InternalOCLX.g:4493:2: rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:4500:1: rule__LegacyUntil__Group__4__Impl : ( ( rule__LegacyUntil__BAssignment_4 ) ) ;
    public final void rule__LegacyUntil__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4504:1: ( ( ( rule__LegacyUntil__BAssignment_4 ) ) )
            // InternalOCLX.g:4505:1: ( ( rule__LegacyUntil__BAssignment_4 ) )
            {
            // InternalOCLX.g:4505:1: ( ( rule__LegacyUntil__BAssignment_4 ) )
            // InternalOCLX.g:4506:2: ( rule__LegacyUntil__BAssignment_4 )
            {
             before(grammarAccess.getLegacyUntilAccess().getBAssignment_4()); 
            // InternalOCLX.g:4507:2: ( rule__LegacyUntil__BAssignment_4 )
            // InternalOCLX.g:4507:3: rule__LegacyUntil__BAssignment_4
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
    // InternalOCLX.g:4515:1: rule__LegacyUntil__Group__5 : rule__LegacyUntil__Group__5__Impl ;
    public final void rule__LegacyUntil__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4519:1: ( rule__LegacyUntil__Group__5__Impl )
            // InternalOCLX.g:4520:2: rule__LegacyUntil__Group__5__Impl
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
    // InternalOCLX.g:4526:1: rule__LegacyUntil__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyUntil__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4530:1: ( ( ')' ) )
            // InternalOCLX.g:4531:1: ( ')' )
            {
            // InternalOCLX.g:4531:1: ( ')' )
            // InternalOCLX.g:4532:2: ')'
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
    // InternalOCLX.g:4542:1: rule__LegacyAsSoonAs__Group__0 : rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1 ;
    public final void rule__LegacyAsSoonAs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4546:1: ( rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1 )
            // InternalOCLX.g:4547:2: rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1
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
    // InternalOCLX.g:4554:1: rule__LegacyAsSoonAs__Group__0__Impl : ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4558:1: ( ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) ) )
            // InternalOCLX.g:4559:1: ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4559:1: ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) )
            // InternalOCLX.g:4560:2: ( rule__LegacyAsSoonAs__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4561:2: ( rule__LegacyAsSoonAs__NameAssignment_0 )
            // InternalOCLX.g:4561:3: rule__LegacyAsSoonAs__NameAssignment_0
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
    // InternalOCLX.g:4569:1: rule__LegacyAsSoonAs__Group__1 : rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2 ;
    public final void rule__LegacyAsSoonAs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4573:1: ( rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2 )
            // InternalOCLX.g:4574:2: rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2
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
    // InternalOCLX.g:4581:1: rule__LegacyAsSoonAs__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyAsSoonAs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4585:1: ( ( '(' ) )
            // InternalOCLX.g:4586:1: ( '(' )
            {
            // InternalOCLX.g:4586:1: ( '(' )
            // InternalOCLX.g:4587:2: '('
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
    // InternalOCLX.g:4596:1: rule__LegacyAsSoonAs__Group__2 : rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3 ;
    public final void rule__LegacyAsSoonAs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4600:1: ( rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3 )
            // InternalOCLX.g:4601:2: rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3
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
    // InternalOCLX.g:4608:1: rule__LegacyAsSoonAs__Group__2__Impl : ( ( rule__LegacyAsSoonAs__AAssignment_2 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4612:1: ( ( ( rule__LegacyAsSoonAs__AAssignment_2 ) ) )
            // InternalOCLX.g:4613:1: ( ( rule__LegacyAsSoonAs__AAssignment_2 ) )
            {
            // InternalOCLX.g:4613:1: ( ( rule__LegacyAsSoonAs__AAssignment_2 ) )
            // InternalOCLX.g:4614:2: ( rule__LegacyAsSoonAs__AAssignment_2 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getAAssignment_2()); 
            // InternalOCLX.g:4615:2: ( rule__LegacyAsSoonAs__AAssignment_2 )
            // InternalOCLX.g:4615:3: rule__LegacyAsSoonAs__AAssignment_2
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
    // InternalOCLX.g:4623:1: rule__LegacyAsSoonAs__Group__3 : rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4 ;
    public final void rule__LegacyAsSoonAs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4627:1: ( rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4 )
            // InternalOCLX.g:4628:2: rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4
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
    // InternalOCLX.g:4635:1: rule__LegacyAsSoonAs__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyAsSoonAs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4639:1: ( ( ',' ) )
            // InternalOCLX.g:4640:1: ( ',' )
            {
            // InternalOCLX.g:4640:1: ( ',' )
            // InternalOCLX.g:4641:2: ','
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getCommaKeyword_3()); 
            match(input,61,FOLLOW_2); 
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
    // InternalOCLX.g:4650:1: rule__LegacyAsSoonAs__Group__4 : rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5 ;
    public final void rule__LegacyAsSoonAs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4654:1: ( rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5 )
            // InternalOCLX.g:4655:2: rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:4662:1: rule__LegacyAsSoonAs__Group__4__Impl : ( ( rule__LegacyAsSoonAs__BAssignment_4 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4666:1: ( ( ( rule__LegacyAsSoonAs__BAssignment_4 ) ) )
            // InternalOCLX.g:4667:1: ( ( rule__LegacyAsSoonAs__BAssignment_4 ) )
            {
            // InternalOCLX.g:4667:1: ( ( rule__LegacyAsSoonAs__BAssignment_4 ) )
            // InternalOCLX.g:4668:2: ( rule__LegacyAsSoonAs__BAssignment_4 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getBAssignment_4()); 
            // InternalOCLX.g:4669:2: ( rule__LegacyAsSoonAs__BAssignment_4 )
            // InternalOCLX.g:4669:3: rule__LegacyAsSoonAs__BAssignment_4
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
    // InternalOCLX.g:4677:1: rule__LegacyAsSoonAs__Group__5 : rule__LegacyAsSoonAs__Group__5__Impl ;
    public final void rule__LegacyAsSoonAs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4681:1: ( rule__LegacyAsSoonAs__Group__5__Impl )
            // InternalOCLX.g:4682:2: rule__LegacyAsSoonAs__Group__5__Impl
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
    // InternalOCLX.g:4688:1: rule__LegacyAsSoonAs__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyAsSoonAs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4692:1: ( ( ')' ) )
            // InternalOCLX.g:4693:1: ( ')' )
            {
            // InternalOCLX.g:4693:1: ( ')' )
            // InternalOCLX.g:4694:2: ')'
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
    // InternalOCLX.g:4704:1: rule__LegacyEverytime__Group__0 : rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1 ;
    public final void rule__LegacyEverytime__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4708:1: ( rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1 )
            // InternalOCLX.g:4709:2: rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1
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
    // InternalOCLX.g:4716:1: rule__LegacyEverytime__Group__0__Impl : ( ( rule__LegacyEverytime__NameAssignment_0 ) ) ;
    public final void rule__LegacyEverytime__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4720:1: ( ( ( rule__LegacyEverytime__NameAssignment_0 ) ) )
            // InternalOCLX.g:4721:1: ( ( rule__LegacyEverytime__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4721:1: ( ( rule__LegacyEverytime__NameAssignment_0 ) )
            // InternalOCLX.g:4722:2: ( rule__LegacyEverytime__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4723:2: ( rule__LegacyEverytime__NameAssignment_0 )
            // InternalOCLX.g:4723:3: rule__LegacyEverytime__NameAssignment_0
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
    // InternalOCLX.g:4731:1: rule__LegacyEverytime__Group__1 : rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2 ;
    public final void rule__LegacyEverytime__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4735:1: ( rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2 )
            // InternalOCLX.g:4736:2: rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2
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
    // InternalOCLX.g:4743:1: rule__LegacyEverytime__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyEverytime__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4747:1: ( ( '(' ) )
            // InternalOCLX.g:4748:1: ( '(' )
            {
            // InternalOCLX.g:4748:1: ( '(' )
            // InternalOCLX.g:4749:2: '('
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
    // InternalOCLX.g:4758:1: rule__LegacyEverytime__Group__2 : rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3 ;
    public final void rule__LegacyEverytime__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4762:1: ( rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3 )
            // InternalOCLX.g:4763:2: rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3
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
    // InternalOCLX.g:4770:1: rule__LegacyEverytime__Group__2__Impl : ( ( rule__LegacyEverytime__AAssignment_2 ) ) ;
    public final void rule__LegacyEverytime__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4774:1: ( ( ( rule__LegacyEverytime__AAssignment_2 ) ) )
            // InternalOCLX.g:4775:1: ( ( rule__LegacyEverytime__AAssignment_2 ) )
            {
            // InternalOCLX.g:4775:1: ( ( rule__LegacyEverytime__AAssignment_2 ) )
            // InternalOCLX.g:4776:2: ( rule__LegacyEverytime__AAssignment_2 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getAAssignment_2()); 
            // InternalOCLX.g:4777:2: ( rule__LegacyEverytime__AAssignment_2 )
            // InternalOCLX.g:4777:3: rule__LegacyEverytime__AAssignment_2
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
    // InternalOCLX.g:4785:1: rule__LegacyEverytime__Group__3 : rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4 ;
    public final void rule__LegacyEverytime__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4789:1: ( rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4 )
            // InternalOCLX.g:4790:2: rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4
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
    // InternalOCLX.g:4797:1: rule__LegacyEverytime__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyEverytime__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4801:1: ( ( ',' ) )
            // InternalOCLX.g:4802:1: ( ',' )
            {
            // InternalOCLX.g:4802:1: ( ',' )
            // InternalOCLX.g:4803:2: ','
            {
             before(grammarAccess.getLegacyEverytimeAccess().getCommaKeyword_3()); 
            match(input,61,FOLLOW_2); 
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
    // InternalOCLX.g:4812:1: rule__LegacyEverytime__Group__4 : rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5 ;
    public final void rule__LegacyEverytime__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4816:1: ( rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5 )
            // InternalOCLX.g:4817:2: rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5
            {
            pushFollow(FOLLOW_22);
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
    // InternalOCLX.g:4824:1: rule__LegacyEverytime__Group__4__Impl : ( ( rule__LegacyEverytime__BAssignment_4 ) ) ;
    public final void rule__LegacyEverytime__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4828:1: ( ( ( rule__LegacyEverytime__BAssignment_4 ) ) )
            // InternalOCLX.g:4829:1: ( ( rule__LegacyEverytime__BAssignment_4 ) )
            {
            // InternalOCLX.g:4829:1: ( ( rule__LegacyEverytime__BAssignment_4 ) )
            // InternalOCLX.g:4830:2: ( rule__LegacyEverytime__BAssignment_4 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getBAssignment_4()); 
            // InternalOCLX.g:4831:2: ( rule__LegacyEverytime__BAssignment_4 )
            // InternalOCLX.g:4831:3: rule__LegacyEverytime__BAssignment_4
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
    // InternalOCLX.g:4839:1: rule__LegacyEverytime__Group__5 : rule__LegacyEverytime__Group__5__Impl ;
    public final void rule__LegacyEverytime__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4843:1: ( rule__LegacyEverytime__Group__5__Impl )
            // InternalOCLX.g:4844:2: rule__LegacyEverytime__Group__5__Impl
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
    // InternalOCLX.g:4850:1: rule__LegacyEverytime__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyEverytime__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4854:1: ( ( ')' ) )
            // InternalOCLX.g:4855:1: ( ')' )
            {
            // InternalOCLX.g:4855:1: ( ')' )
            // InternalOCLX.g:4856:2: ')'
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
    // InternalOCLX.g:4866:1: rule__Path__Group__0 : rule__Path__Group__0__Impl rule__Path__Group__1 ;
    public final void rule__Path__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4870:1: ( rule__Path__Group__0__Impl rule__Path__Group__1 )
            // InternalOCLX.g:4871:2: rule__Path__Group__0__Impl rule__Path__Group__1
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
    // InternalOCLX.g:4878:1: rule__Path__Group__0__Impl : ( ruleSimpleName ) ;
    public final void rule__Path__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4882:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:4883:1: ( ruleSimpleName )
            {
            // InternalOCLX.g:4883:1: ( ruleSimpleName )
            // InternalOCLX.g:4884:2: ruleSimpleName
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
    // InternalOCLX.g:4893:1: rule__Path__Group__1 : rule__Path__Group__1__Impl ;
    public final void rule__Path__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4897:1: ( rule__Path__Group__1__Impl )
            // InternalOCLX.g:4898:2: rule__Path__Group__1__Impl
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
    // InternalOCLX.g:4904:1: rule__Path__Group__1__Impl : ( ( rule__Path__Group_1__0 )* ) ;
    public final void rule__Path__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4908:1: ( ( ( rule__Path__Group_1__0 )* ) )
            // InternalOCLX.g:4909:1: ( ( rule__Path__Group_1__0 )* )
            {
            // InternalOCLX.g:4909:1: ( ( rule__Path__Group_1__0 )* )
            // InternalOCLX.g:4910:2: ( rule__Path__Group_1__0 )*
            {
             before(grammarAccess.getPathAccess().getGroup_1()); 
            // InternalOCLX.g:4911:2: ( rule__Path__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==23) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalOCLX.g:4911:3: rule__Path__Group_1__0
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
    // InternalOCLX.g:4920:1: rule__Path__Group_1__0 : rule__Path__Group_1__0__Impl rule__Path__Group_1__1 ;
    public final void rule__Path__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4924:1: ( rule__Path__Group_1__0__Impl rule__Path__Group_1__1 )
            // InternalOCLX.g:4925:2: rule__Path__Group_1__0__Impl rule__Path__Group_1__1
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
    // InternalOCLX.g:4932:1: rule__Path__Group_1__0__Impl : ( '/' ) ;
    public final void rule__Path__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4936:1: ( ( '/' ) )
            // InternalOCLX.g:4937:1: ( '/' )
            {
            // InternalOCLX.g:4937:1: ( '/' )
            // InternalOCLX.g:4938:2: '/'
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
    // InternalOCLX.g:4947:1: rule__Path__Group_1__1 : rule__Path__Group_1__1__Impl ;
    public final void rule__Path__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4951:1: ( rule__Path__Group_1__1__Impl )
            // InternalOCLX.g:4952:2: rule__Path__Group_1__1__Impl
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
    // InternalOCLX.g:4958:1: rule__Path__Group_1__1__Impl : ( ruleSimpleName ) ;
    public final void rule__Path__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4962:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:4963:1: ( ruleSimpleName )
            {
            // InternalOCLX.g:4963:1: ( ruleSimpleName )
            // InternalOCLX.g:4964:2: ruleSimpleName
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
    // InternalOCLX.g:4974:1: rule__ArgumentsExp__Group__0 : rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1 ;
    public final void rule__ArgumentsExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4978:1: ( rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1 )
            // InternalOCLX.g:4979:2: rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1
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
    // InternalOCLX.g:4986:1: rule__ArgumentsExp__Group__0__Impl : ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) ) ;
    public final void rule__ArgumentsExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4990:1: ( ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) ) )
            // InternalOCLX.g:4991:1: ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) )
            {
            // InternalOCLX.g:4991:1: ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) )
            // InternalOCLX.g:4992:2: ( rule__ArgumentsExp__OperatorsAssignment_0 )
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_0()); 
            // InternalOCLX.g:4993:2: ( rule__ArgumentsExp__OperatorsAssignment_0 )
            // InternalOCLX.g:4993:3: rule__ArgumentsExp__OperatorsAssignment_0
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
    // InternalOCLX.g:5001:1: rule__ArgumentsExp__Group__1 : rule__ArgumentsExp__Group__1__Impl ;
    public final void rule__ArgumentsExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5005:1: ( rule__ArgumentsExp__Group__1__Impl )
            // InternalOCLX.g:5006:2: rule__ArgumentsExp__Group__1__Impl
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
    // InternalOCLX.g:5012:1: rule__ArgumentsExp__Group__1__Impl : ( ( rule__ArgumentsExp__Group_1__0 )* ) ;
    public final void rule__ArgumentsExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5016:1: ( ( ( rule__ArgumentsExp__Group_1__0 )* ) )
            // InternalOCLX.g:5017:1: ( ( rule__ArgumentsExp__Group_1__0 )* )
            {
            // InternalOCLX.g:5017:1: ( ( rule__ArgumentsExp__Group_1__0 )* )
            // InternalOCLX.g:5018:2: ( rule__ArgumentsExp__Group_1__0 )*
            {
             before(grammarAccess.getArgumentsExpAccess().getGroup_1()); 
            // InternalOCLX.g:5019:2: ( rule__ArgumentsExp__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==61) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalOCLX.g:5019:3: rule__ArgumentsExp__Group_1__0
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
    // InternalOCLX.g:5028:1: rule__ArgumentsExp__Group_1__0 : rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1 ;
    public final void rule__ArgumentsExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5032:1: ( rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1 )
            // InternalOCLX.g:5033:2: rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1
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
    // InternalOCLX.g:5040:1: rule__ArgumentsExp__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ArgumentsExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5044:1: ( ( ',' ) )
            // InternalOCLX.g:5045:1: ( ',' )
            {
            // InternalOCLX.g:5045:1: ( ',' )
            // InternalOCLX.g:5046:2: ','
            {
             before(grammarAccess.getArgumentsExpAccess().getCommaKeyword_1_0()); 
            match(input,61,FOLLOW_2); 
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
    // InternalOCLX.g:5055:1: rule__ArgumentsExp__Group_1__1 : rule__ArgumentsExp__Group_1__1__Impl ;
    public final void rule__ArgumentsExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5059:1: ( rule__ArgumentsExp__Group_1__1__Impl )
            // InternalOCLX.g:5060:2: rule__ArgumentsExp__Group_1__1__Impl
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
    // InternalOCLX.g:5066:1: rule__ArgumentsExp__Group_1__1__Impl : ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) ) ;
    public final void rule__ArgumentsExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5070:1: ( ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) ) )
            // InternalOCLX.g:5071:1: ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) )
            {
            // InternalOCLX.g:5071:1: ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) )
            // InternalOCLX.g:5072:2: ( rule__ArgumentsExp__OperatorsAssignment_1_1 )
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_1_1()); 
            // InternalOCLX.g:5073:2: ( rule__ArgumentsExp__OperatorsAssignment_1_1 )
            // InternalOCLX.g:5073:3: rule__ArgumentsExp__OperatorsAssignment_1_1
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
    // InternalOCLX.g:5082:1: rule__Model__ConstraintsAssignment : ( ruleConstraint ) ;
    public final void rule__Model__ConstraintsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5086:1: ( ( ruleConstraint ) )
            // InternalOCLX.g:5087:2: ( ruleConstraint )
            {
            // InternalOCLX.g:5087:2: ( ruleConstraint )
            // InternalOCLX.g:5088:3: ruleConstraint
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
    // InternalOCLX.g:5097:1: rule__Constraint__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constraint__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5101:1: ( ( RULE_ID ) )
            // InternalOCLX.g:5102:2: ( RULE_ID )
            {
            // InternalOCLX.g:5102:2: ( RULE_ID )
            // InternalOCLX.g:5103:3: RULE_ID
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
    // InternalOCLX.g:5112:1: rule__Constraint__DescriptionAssignment_3_1 : ( RULE_DESCRIPTION ) ;
    public final void rule__Constraint__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5116:1: ( ( RULE_DESCRIPTION ) )
            // InternalOCLX.g:5117:2: ( RULE_DESCRIPTION )
            {
            // InternalOCLX.g:5117:2: ( RULE_DESCRIPTION )
            // InternalOCLX.g:5118:3: RULE_DESCRIPTION
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
    // InternalOCLX.g:5127:1: rule__Constraint__OverrulableAssignment_4_2 : ( ruleBooleanLiteralExp ) ;
    public final void rule__Constraint__OverrulableAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5131:1: ( ( ruleBooleanLiteralExp ) )
            // InternalOCLX.g:5132:2: ( ruleBooleanLiteralExp )
            {
            // InternalOCLX.g:5132:2: ( ruleBooleanLiteralExp )
            // InternalOCLX.g:5133:3: ruleBooleanLiteralExp
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
    // InternalOCLX.g:5142:1: rule__Constraint__ContextAssignment_6 : ( ruleContext ) ;
    public final void rule__Constraint__ContextAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5146:1: ( ( ruleContext ) )
            // InternalOCLX.g:5147:2: ( ruleContext )
            {
            // InternalOCLX.g:5147:2: ( ruleContext )
            // InternalOCLX.g:5148:3: ruleContext
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
    // InternalOCLX.g:5157:1: rule__Constraint__ExpressionAssignment_8 : ( ruleExp ) ;
    public final void rule__Constraint__ExpressionAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5161:1: ( ( ruleExp ) )
            // InternalOCLX.g:5162:2: ( ruleExp )
            {
            // InternalOCLX.g:5162:2: ( ruleExp )
            // InternalOCLX.g:5163:3: ruleExp
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
    // InternalOCLX.g:5172:1: rule__Context__NameAssignment : ( ruleQualifiedName ) ;
    public final void rule__Context__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5176:1: ( ( ruleQualifiedName ) )
            // InternalOCLX.g:5177:2: ( ruleQualifiedName )
            {
            // InternalOCLX.g:5177:2: ( ruleQualifiedName )
            // InternalOCLX.g:5178:3: ruleQualifiedName
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
    // InternalOCLX.g:5187:1: rule__Exp__OperatorsAssignment_1_1 : ( ruleBinaryOperator ) ;
    public final void rule__Exp__OperatorsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5191:1: ( ( ruleBinaryOperator ) )
            // InternalOCLX.g:5192:2: ( ruleBinaryOperator )
            {
            // InternalOCLX.g:5192:2: ( ruleBinaryOperator )
            // InternalOCLX.g:5193:3: ruleBinaryOperator
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
    // InternalOCLX.g:5202:1: rule__Exp__ExpressionsAssignment_1_2 : ( rulePrefixedExp ) ;
    public final void rule__Exp__ExpressionsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5206:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:5207:2: ( rulePrefixedExp )
            {
            // InternalOCLX.g:5207:2: ( rulePrefixedExp )
            // InternalOCLX.g:5208:3: rulePrefixedExp
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
    // InternalOCLX.g:5217:1: rule__Exp__OperatorsAssignment_1_3_0 : ( ruleBinaryOperator ) ;
    public final void rule__Exp__OperatorsAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5221:1: ( ( ruleBinaryOperator ) )
            // InternalOCLX.g:5222:2: ( ruleBinaryOperator )
            {
            // InternalOCLX.g:5222:2: ( ruleBinaryOperator )
            // InternalOCLX.g:5223:3: ruleBinaryOperator
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
    // InternalOCLX.g:5232:1: rule__Exp__ExpressionsAssignment_1_3_1 : ( rulePrefixedExp ) ;
    public final void rule__Exp__ExpressionsAssignment_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5236:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:5237:2: ( rulePrefixedExp )
            {
            // InternalOCLX.g:5237:2: ( rulePrefixedExp )
            // InternalOCLX.g:5238:3: rulePrefixedExp
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
    // InternalOCLX.g:5247:1: rule__PrefixedExp__OperatorAssignment_0_1 : ( ruleUnaryOperator ) ;
    public final void rule__PrefixedExp__OperatorAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5251:1: ( ( ruleUnaryOperator ) )
            // InternalOCLX.g:5252:2: ( ruleUnaryOperator )
            {
            // InternalOCLX.g:5252:2: ( ruleUnaryOperator )
            // InternalOCLX.g:5253:3: ruleUnaryOperator
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
    // InternalOCLX.g:5262:1: rule__PrefixedExp__ExpressionAssignment_0_2 : ( rulePrimaryExp ) ;
    public final void rule__PrefixedExp__ExpressionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5266:1: ( ( rulePrimaryExp ) )
            // InternalOCLX.g:5267:2: ( rulePrimaryExp )
            {
            // InternalOCLX.g:5267:2: ( rulePrimaryExp )
            // InternalOCLX.g:5268:3: rulePrimaryExp
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
    // InternalOCLX.g:5277:1: rule__BooleanOperator__OpAssignment : ( ( rule__BooleanOperator__OpAlternatives_0 ) ) ;
    public final void rule__BooleanOperator__OpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5281:1: ( ( ( rule__BooleanOperator__OpAlternatives_0 ) ) )
            // InternalOCLX.g:5282:2: ( ( rule__BooleanOperator__OpAlternatives_0 ) )
            {
            // InternalOCLX.g:5282:2: ( ( rule__BooleanOperator__OpAlternatives_0 ) )
            // InternalOCLX.g:5283:3: ( rule__BooleanOperator__OpAlternatives_0 )
            {
             before(grammarAccess.getBooleanOperatorAccess().getOpAlternatives_0()); 
            // InternalOCLX.g:5284:3: ( rule__BooleanOperator__OpAlternatives_0 )
            // InternalOCLX.g:5284:4: rule__BooleanOperator__OpAlternatives_0
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
    // InternalOCLX.g:5292:1: rule__MathOperator__OpAssignment : ( ( rule__MathOperator__OpAlternatives_0 ) ) ;
    public final void rule__MathOperator__OpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5296:1: ( ( ( rule__MathOperator__OpAlternatives_0 ) ) )
            // InternalOCLX.g:5297:2: ( ( rule__MathOperator__OpAlternatives_0 ) )
            {
            // InternalOCLX.g:5297:2: ( ( rule__MathOperator__OpAlternatives_0 ) )
            // InternalOCLX.g:5298:3: ( rule__MathOperator__OpAlternatives_0 )
            {
             before(grammarAccess.getMathOperatorAccess().getOpAlternatives_0()); 
            // InternalOCLX.g:5299:3: ( rule__MathOperator__OpAlternatives_0 )
            // InternalOCLX.g:5299:4: rule__MathOperator__OpAlternatives_0
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
    // InternalOCLX.g:5307:1: rule__NavigationOperator__NameAssignment : ( ( rule__NavigationOperator__NameAlternatives_0 ) ) ;
    public final void rule__NavigationOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5311:1: ( ( ( rule__NavigationOperator__NameAlternatives_0 ) ) )
            // InternalOCLX.g:5312:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:5312:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            // InternalOCLX.g:5313:3: ( rule__NavigationOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getNavigationOperatorAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:5314:3: ( rule__NavigationOperator__NameAlternatives_0 )
            // InternalOCLX.g:5314:4: rule__NavigationOperator__NameAlternatives_0
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
    // InternalOCLX.g:5322:1: rule__UnaryOperator__NameAssignment : ( ( rule__UnaryOperator__NameAlternatives_0 ) ) ;
    public final void rule__UnaryOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5326:1: ( ( ( rule__UnaryOperator__NameAlternatives_0 ) ) )
            // InternalOCLX.g:5327:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:5327:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            // InternalOCLX.g:5328:3: ( rule__UnaryOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getUnaryOperatorAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:5329:3: ( rule__UnaryOperator__NameAlternatives_0 )
            // InternalOCLX.g:5329:4: rule__UnaryOperator__NameAlternatives_0
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
    // InternalOCLX.g:5337:1: rule__PrimaryExp__NavAssignment_1_1_0 : ( ruleNavigationOperator ) ;
    public final void rule__PrimaryExp__NavAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5341:1: ( ( ruleNavigationOperator ) )
            // InternalOCLX.g:5342:2: ( ruleNavigationOperator )
            {
            // InternalOCLX.g:5342:2: ( ruleNavigationOperator )
            // InternalOCLX.g:5343:3: ruleNavigationOperator
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
    // InternalOCLX.g:5352:1: rule__PrimaryExp__MethodsAssignment_1_1_1 : ( ruleMethodExp ) ;
    public final void rule__PrimaryExp__MethodsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5356:1: ( ( ruleMethodExp ) )
            // InternalOCLX.g:5357:2: ( ruleMethodExp )
            {
            // InternalOCLX.g:5357:2: ( ruleMethodExp )
            // InternalOCLX.g:5358:3: ruleMethodExp
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
    // InternalOCLX.g:5367:1: rule__NestedExp__SourceAssignment_1 : ( ruleExp ) ;
    public final void rule__NestedExp__SourceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5371:1: ( ( ruleExp ) )
            // InternalOCLX.g:5372:2: ( ruleExp )
            {
            // InternalOCLX.g:5372:2: ( ruleExp )
            // InternalOCLX.g:5373:3: ruleExp
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
    // InternalOCLX.g:5382:1: rule__SelfExp__NameAssignment_1 : ( ( 'self' ) ) ;
    public final void rule__SelfExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5386:1: ( ( ( 'self' ) ) )
            // InternalOCLX.g:5387:2: ( ( 'self' ) )
            {
            // InternalOCLX.g:5387:2: ( ( 'self' ) )
            // InternalOCLX.g:5388:3: ( 'self' )
            {
             before(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0()); 
            // InternalOCLX.g:5389:3: ( 'self' )
            // InternalOCLX.g:5390:4: 'self'
            {
             before(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalOCLX.g:5401:1: rule__VarDeclaration__NameAssignment : ( ruleSimpleName ) ;
    public final void rule__VarDeclaration__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5405:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5406:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5406:2: ( ruleSimpleName )
            // InternalOCLX.g:5407:3: ruleSimpleName
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
    // InternalOCLX.g:5416:1: rule__VarReference__RefAssignment : ( ( RULE_ID ) ) ;
    public final void rule__VarReference__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5420:1: ( ( ( RULE_ID ) ) )
            // InternalOCLX.g:5421:2: ( ( RULE_ID ) )
            {
            // InternalOCLX.g:5421:2: ( ( RULE_ID ) )
            // InternalOCLX.g:5422:3: ( RULE_ID )
            {
             before(grammarAccess.getVarReferenceAccess().getRefVarDeclarationCrossReference_0()); 
            // InternalOCLX.g:5423:3: ( RULE_ID )
            // InternalOCLX.g:5424:4: RULE_ID
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


    // $ANTLR start "rule__IntLiteralExp__ValueAssignment"
    // InternalOCLX.g:5435:1: rule__IntLiteralExp__ValueAssignment : ( RULE_INT ) ;
    public final void rule__IntLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5439:1: ( ( RULE_INT ) )
            // InternalOCLX.g:5440:2: ( RULE_INT )
            {
            // InternalOCLX.g:5440:2: ( RULE_INT )
            // InternalOCLX.g:5441:3: RULE_INT
            {
             before(grammarAccess.getIntLiteralExpAccess().getValueINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getIntLiteralExpAccess().getValueINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntLiteralExp__ValueAssignment"


    // $ANTLR start "rule__StringLiteralExp__ValueAssignment"
    // InternalOCLX.g:5450:1: rule__StringLiteralExp__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5454:1: ( ( RULE_STRING ) )
            // InternalOCLX.g:5455:2: ( RULE_STRING )
            {
            // InternalOCLX.g:5455:2: ( RULE_STRING )
            // InternalOCLX.g:5456:3: RULE_STRING
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
    // InternalOCLX.g:5465:1: rule__BooleanLiteralExp__ValueAssignment_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralExp__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5469:1: ( ( ( 'true' ) ) )
            // InternalOCLX.g:5470:2: ( ( 'true' ) )
            {
            // InternalOCLX.g:5470:2: ( ( 'true' ) )
            // InternalOCLX.g:5471:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0()); 
            // InternalOCLX.g:5472:3: ( 'true' )
            // InternalOCLX.g:5473:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalOCLX.g:5484:1: rule__BooleanLiteralExp__ValueAssignment_1 : ( ( 'false' ) ) ;
    public final void rule__BooleanLiteralExp__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5488:1: ( ( ( 'false' ) ) )
            // InternalOCLX.g:5489:2: ( ( 'false' ) )
            {
            // InternalOCLX.g:5489:2: ( ( 'false' ) )
            // InternalOCLX.g:5490:3: ( 'false' )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0()); 
            // InternalOCLX.g:5491:3: ( 'false' )
            // InternalOCLX.g:5492:4: 'false'
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0()); 
            match(input,64,FOLLOW_2); 
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


    // $ANTLR start "rule__FloatLiteralExp__ValueAssignment"
    // InternalOCLX.g:5503:1: rule__FloatLiteralExp__ValueAssignment : ( ruleFloat ) ;
    public final void rule__FloatLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5507:1: ( ( ruleFloat ) )
            // InternalOCLX.g:5508:2: ( ruleFloat )
            {
            // InternalOCLX.g:5508:2: ( ruleFloat )
            // InternalOCLX.g:5509:3: ruleFloat
            {
             before(grammarAccess.getFloatLiteralExpAccess().getValueFloatParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleFloat();

            state._fsp--;

             after(grammarAccess.getFloatLiteralExpAccess().getValueFloatParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatLiteralExp__ValueAssignment"


    // $ANTLR start "rule__CollectionIterator__NameAssignment_0"
    // InternalOCLX.g:5518:1: rule__CollectionIterator__NameAssignment_0 : ( ruleIteratorName ) ;
    public final void rule__CollectionIterator__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5522:1: ( ( ruleIteratorName ) )
            // InternalOCLX.g:5523:2: ( ruleIteratorName )
            {
            // InternalOCLX.g:5523:2: ( ruleIteratorName )
            // InternalOCLX.g:5524:3: ruleIteratorName
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
    // InternalOCLX.g:5533:1: rule__CollectionIterator__ItervarAssignment_2 : ( ruleIteratorVarDeclaration ) ;
    public final void rule__CollectionIterator__ItervarAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5537:1: ( ( ruleIteratorVarDeclaration ) )
            // InternalOCLX.g:5538:2: ( ruleIteratorVarDeclaration )
            {
            // InternalOCLX.g:5538:2: ( ruleIteratorVarDeclaration )
            // InternalOCLX.g:5539:3: ruleIteratorVarDeclaration
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
    // InternalOCLX.g:5548:1: rule__CollectionIterator__BodyAssignment_4 : ( ruleExp ) ;
    public final void rule__CollectionIterator__BodyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5552:1: ( ( ruleExp ) )
            // InternalOCLX.g:5553:2: ( ruleExp )
            {
            // InternalOCLX.g:5553:2: ( ruleExp )
            // InternalOCLX.g:5554:3: ruleExp
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
    // InternalOCLX.g:5563:1: rule__IteratorName__NameAssignment : ( ( rule__IteratorName__NameAlternatives_0 ) ) ;
    public final void rule__IteratorName__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5567:1: ( ( ( rule__IteratorName__NameAlternatives_0 ) ) )
            // InternalOCLX.g:5568:2: ( ( rule__IteratorName__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:5568:2: ( ( rule__IteratorName__NameAlternatives_0 ) )
            // InternalOCLX.g:5569:3: ( rule__IteratorName__NameAlternatives_0 )
            {
             before(grammarAccess.getIteratorNameAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:5570:3: ( rule__IteratorName__NameAlternatives_0 )
            // InternalOCLX.g:5570:4: rule__IteratorName__NameAlternatives_0
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
    // InternalOCLX.g:5578:1: rule__IteratorVarDeclaration__NameAssignment_0 : ( ruleVarDeclaration ) ;
    public final void rule__IteratorVarDeclaration__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5582:1: ( ( ruleVarDeclaration ) )
            // InternalOCLX.g:5583:2: ( ruleVarDeclaration )
            {
            // InternalOCLX.g:5583:2: ( ruleVarDeclaration )
            // InternalOCLX.g:5584:3: ruleVarDeclaration
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
    // InternalOCLX.g:5593:1: rule__IteratorVarDeclaration__NameAssignment_1_0 : ( ruleVarDeclaration ) ;
    public final void rule__IteratorVarDeclaration__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5597:1: ( ( ruleVarDeclaration ) )
            // InternalOCLX.g:5598:2: ( ruleVarDeclaration )
            {
            // InternalOCLX.g:5598:2: ( ruleVarDeclaration )
            // InternalOCLX.g:5599:3: ruleVarDeclaration
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
    // InternalOCLX.g:5608:1: rule__IteratorVarDeclaration__TypeAssignment_1_2 : ( ruleTypeExp ) ;
    public final void rule__IteratorVarDeclaration__TypeAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5612:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:5613:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:5613:2: ( ruleTypeExp )
            // InternalOCLX.g:5614:3: ruleTypeExp
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
    // InternalOCLX.g:5623:1: rule__PropertyAccess__NameAssignment : ( ruleSimpleName ) ;
    public final void rule__PropertyAccess__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5627:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5628:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5628:2: ( ruleSimpleName )
            // InternalOCLX.g:5629:3: ruleSimpleName
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
    // InternalOCLX.g:5638:1: rule__MethodCall__NameAssignment_0_0 : ( ruleSimpleName ) ;
    public final void rule__MethodCall__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5642:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5643:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5643:2: ( ruleSimpleName )
            // InternalOCLX.g:5644:3: ruleSimpleName
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
    // InternalOCLX.g:5653:1: rule__MethodCall__NameAssignment_1_0 : ( ruleSimpleName ) ;
    public final void rule__MethodCall__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5657:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5658:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5658:2: ( ruleSimpleName )
            // InternalOCLX.g:5659:3: ruleSimpleName
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
    // InternalOCLX.g:5668:1: rule__MethodCall__ArgsAssignment_1_2 : ( ruleArgumentsExp ) ;
    public final void rule__MethodCall__ArgsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5672:1: ( ( ruleArgumentsExp ) )
            // InternalOCLX.g:5673:2: ( ruleArgumentsExp )
            {
            // InternalOCLX.g:5673:2: ( ruleArgumentsExp )
            // InternalOCLX.g:5674:3: ruleArgumentsExp
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
    // InternalOCLX.g:5683:1: rule__TypeCall__NameAssignment_0 : ( ( rule__TypeCall__NameAlternatives_0_0 ) ) ;
    public final void rule__TypeCall__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5687:1: ( ( ( rule__TypeCall__NameAlternatives_0_0 ) ) )
            // InternalOCLX.g:5688:2: ( ( rule__TypeCall__NameAlternatives_0_0 ) )
            {
            // InternalOCLX.g:5688:2: ( ( rule__TypeCall__NameAlternatives_0_0 ) )
            // InternalOCLX.g:5689:3: ( rule__TypeCall__NameAlternatives_0_0 )
            {
             before(grammarAccess.getTypeCallAccess().getNameAlternatives_0_0()); 
            // InternalOCLX.g:5690:3: ( rule__TypeCall__NameAlternatives_0_0 )
            // InternalOCLX.g:5690:4: rule__TypeCall__NameAlternatives_0_0
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
    // InternalOCLX.g:5698:1: rule__TypeCall__TypeAssignment_2 : ( ruleTypeExp ) ;
    public final void rule__TypeCall__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5702:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:5703:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:5703:2: ( ruleTypeExp )
            // InternalOCLX.g:5704:3: ruleTypeExp
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
    // InternalOCLX.g:5713:1: rule__TypeExp__NameAssignment_0_2 : ( rulePath ) ;
    public final void rule__TypeExp__NameAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5717:1: ( ( rulePath ) )
            // InternalOCLX.g:5718:2: ( rulePath )
            {
            // InternalOCLX.g:5718:2: ( rulePath )
            // InternalOCLX.g:5719:3: rulePath
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
    // InternalOCLX.g:5728:1: rule__TypeExp__CollectionTypeAssignment_1_0 : ( ruleCollectionTypeIdentifier ) ;
    public final void rule__TypeExp__CollectionTypeAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5732:1: ( ( ruleCollectionTypeIdentifier ) )
            // InternalOCLX.g:5733:2: ( ruleCollectionTypeIdentifier )
            {
            // InternalOCLX.g:5733:2: ( ruleCollectionTypeIdentifier )
            // InternalOCLX.g:5734:3: ruleCollectionTypeIdentifier
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
    // InternalOCLX.g:5743:1: rule__TypeExp__TypeAssignment_1_1 : ( ruleTypeExp ) ;
    public final void rule__TypeExp__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5747:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:5748:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:5748:2: ( ruleTypeExp )
            // InternalOCLX.g:5749:3: ruleTypeExp
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
    // InternalOCLX.g:5758:1: rule__CollectionTypeIdentifier__NameAssignment : ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) ) ;
    public final void rule__CollectionTypeIdentifier__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5762:1: ( ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) ) )
            // InternalOCLX.g:5763:2: ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:5763:2: ( ( rule__CollectionTypeIdentifier__NameAlternatives_0 ) )
            // InternalOCLX.g:5764:3: ( rule__CollectionTypeIdentifier__NameAlternatives_0 )
            {
             before(grammarAccess.getCollectionTypeIdentifierAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:5765:3: ( rule__CollectionTypeIdentifier__NameAlternatives_0 )
            // InternalOCLX.g:5765:4: rule__CollectionTypeIdentifier__NameAlternatives_0
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
    // InternalOCLX.g:5773:1: rule__UnaryTemporalExp__NameAssignment_0 : ( ruleUnaryTemporalOp ) ;
    public final void rule__UnaryTemporalExp__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5777:1: ( ( ruleUnaryTemporalOp ) )
            // InternalOCLX.g:5778:2: ( ruleUnaryTemporalOp )
            {
            // InternalOCLX.g:5778:2: ( ruleUnaryTemporalOp )
            // InternalOCLX.g:5779:3: ruleUnaryTemporalOp
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
    // InternalOCLX.g:5788:1: rule__UnaryTemporalExp__ExpAssignment_2 : ( ruleExp ) ;
    public final void rule__UnaryTemporalExp__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5792:1: ( ( ruleExp ) )
            // InternalOCLX.g:5793:2: ( ruleExp )
            {
            // InternalOCLX.g:5793:2: ( ruleExp )
            // InternalOCLX.g:5794:3: ruleExp
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
    // InternalOCLX.g:5803:1: rule__TemporalAsLongAs__NameAssignment_0 : ( ( 'asLongAs' ) ) ;
    public final void rule__TemporalAsLongAs__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5807:1: ( ( ( 'asLongAs' ) ) )
            // InternalOCLX.g:5808:2: ( ( 'asLongAs' ) )
            {
            // InternalOCLX.g:5808:2: ( ( 'asLongAs' ) )
            // InternalOCLX.g:5809:3: ( 'asLongAs' )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0()); 
            // InternalOCLX.g:5810:3: ( 'asLongAs' )
            // InternalOCLX.g:5811:4: 'asLongAs'
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0()); 
            match(input,58,FOLLOW_2); 
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
    // InternalOCLX.g:5822:1: rule__TemporalAsLongAs__BAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalAsLongAs__BAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5826:1: ( ( ruleExp ) )
            // InternalOCLX.g:5827:2: ( ruleExp )
            {
            // InternalOCLX.g:5827:2: ( ruleExp )
            // InternalOCLX.g:5828:3: ruleExp
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
    // InternalOCLX.g:5837:1: rule__TemporalAsLongAs__AAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalAsLongAs__AAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5841:1: ( ( ruleExp ) )
            // InternalOCLX.g:5842:2: ( ruleExp )
            {
            // InternalOCLX.g:5842:2: ( ruleExp )
            // InternalOCLX.g:5843:3: ruleExp
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
    // InternalOCLX.g:5852:1: rule__TemporalUntil__NameAssignment_0 : ( ( 'ensureThat' ) ) ;
    public final void rule__TemporalUntil__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5856:1: ( ( ( 'ensureThat' ) ) )
            // InternalOCLX.g:5857:2: ( ( 'ensureThat' ) )
            {
            // InternalOCLX.g:5857:2: ( ( 'ensureThat' ) )
            // InternalOCLX.g:5858:3: ( 'ensureThat' )
            {
             before(grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0()); 
            // InternalOCLX.g:5859:3: ( 'ensureThat' )
            // InternalOCLX.g:5860:4: 'ensureThat'
            {
             before(grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0()); 
            match(input,57,FOLLOW_2); 
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
    // InternalOCLX.g:5871:1: rule__TemporalUntil__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalUntil__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5875:1: ( ( ruleExp ) )
            // InternalOCLX.g:5876:2: ( ruleExp )
            {
            // InternalOCLX.g:5876:2: ( ruleExp )
            // InternalOCLX.g:5877:3: ruleExp
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
    // InternalOCLX.g:5886:1: rule__TemporalUntil__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalUntil__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5890:1: ( ( ruleExp ) )
            // InternalOCLX.g:5891:2: ( ruleExp )
            {
            // InternalOCLX.g:5891:2: ( ruleExp )
            // InternalOCLX.g:5892:3: ruleExp
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
    // InternalOCLX.g:5901:1: rule__TemporalEverytime__NameAssignment_0 : ( ( 'everyTime' ) ) ;
    public final void rule__TemporalEverytime__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5905:1: ( ( ( 'everyTime' ) ) )
            // InternalOCLX.g:5906:2: ( ( 'everyTime' ) )
            {
            // InternalOCLX.g:5906:2: ( ( 'everyTime' ) )
            // InternalOCLX.g:5907:3: ( 'everyTime' )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0()); 
            // InternalOCLX.g:5908:3: ( 'everyTime' )
            // InternalOCLX.g:5909:4: 'everyTime'
            {
             before(grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalOCLX.g:5920:1: rule__TemporalEverytime__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalEverytime__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5924:1: ( ( ruleExp ) )
            // InternalOCLX.g:5925:2: ( ruleExp )
            {
            // InternalOCLX.g:5925:2: ( ruleExp )
            // InternalOCLX.g:5926:3: ruleExp
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
    // InternalOCLX.g:5935:1: rule__TemporalEverytime__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalEverytime__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5939:1: ( ( ruleExp ) )
            // InternalOCLX.g:5940:2: ( ruleExp )
            {
            // InternalOCLX.g:5940:2: ( ruleExp )
            // InternalOCLX.g:5941:3: ruleExp
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
    // InternalOCLX.g:5950:1: rule__TemporalAtLeastOnce__NameAssignment_0 : ( ( 'whenOnce' ) ) ;
    public final void rule__TemporalAtLeastOnce__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5954:1: ( ( ( 'whenOnce' ) ) )
            // InternalOCLX.g:5955:2: ( ( 'whenOnce' ) )
            {
            // InternalOCLX.g:5955:2: ( ( 'whenOnce' ) )
            // InternalOCLX.g:5956:3: ( 'whenOnce' )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0()); 
            // InternalOCLX.g:5957:3: ( 'whenOnce' )
            // InternalOCLX.g:5958:4: 'whenOnce'
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalOCLX.g:5969:1: rule__TemporalAtLeastOnce__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalAtLeastOnce__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5973:1: ( ( ruleExp ) )
            // InternalOCLX.g:5974:2: ( ruleExp )
            {
            // InternalOCLX.g:5974:2: ( ruleExp )
            // InternalOCLX.g:5975:3: ruleExp
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
    // InternalOCLX.g:5984:1: rule__TemporalAtLeastOnce__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalAtLeastOnce__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5988:1: ( ( ruleExp ) )
            // InternalOCLX.g:5989:2: ( ruleExp )
            {
            // InternalOCLX.g:5989:2: ( ruleExp )
            // InternalOCLX.g:5990:3: ruleExp
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
    // InternalOCLX.g:5999:1: rule__LegacyUntil__NameAssignment_0 : ( ( 'until' ) ) ;
    public final void rule__LegacyUntil__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6003:1: ( ( ( 'until' ) ) )
            // InternalOCLX.g:6004:2: ( ( 'until' ) )
            {
            // InternalOCLX.g:6004:2: ( ( 'until' ) )
            // InternalOCLX.g:6005:3: ( 'until' )
            {
             before(grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0()); 
            // InternalOCLX.g:6006:3: ( 'until' )
            // InternalOCLX.g:6007:4: 'until'
            {
             before(grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0()); 
            match(input,67,FOLLOW_2); 
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
    // InternalOCLX.g:6018:1: rule__LegacyUntil__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyUntil__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6022:1: ( ( ruleExp ) )
            // InternalOCLX.g:6023:2: ( ruleExp )
            {
            // InternalOCLX.g:6023:2: ( ruleExp )
            // InternalOCLX.g:6024:3: ruleExp
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
    // InternalOCLX.g:6033:1: rule__LegacyUntil__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyUntil__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6037:1: ( ( ruleExp ) )
            // InternalOCLX.g:6038:2: ( ruleExp )
            {
            // InternalOCLX.g:6038:2: ( ruleExp )
            // InternalOCLX.g:6039:3: ruleExp
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
    // InternalOCLX.g:6048:1: rule__LegacyAsSoonAs__NameAssignment_0 : ( ( 'asSoonAs' ) ) ;
    public final void rule__LegacyAsSoonAs__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6052:1: ( ( ( 'asSoonAs' ) ) )
            // InternalOCLX.g:6053:2: ( ( 'asSoonAs' ) )
            {
            // InternalOCLX.g:6053:2: ( ( 'asSoonAs' ) )
            // InternalOCLX.g:6054:3: ( 'asSoonAs' )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0()); 
            // InternalOCLX.g:6055:3: ( 'asSoonAs' )
            // InternalOCLX.g:6056:4: 'asSoonAs'
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0()); 
            match(input,68,FOLLOW_2); 
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
    // InternalOCLX.g:6067:1: rule__LegacyAsSoonAs__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyAsSoonAs__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6071:1: ( ( ruleExp ) )
            // InternalOCLX.g:6072:2: ( ruleExp )
            {
            // InternalOCLX.g:6072:2: ( ruleExp )
            // InternalOCLX.g:6073:3: ruleExp
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
    // InternalOCLX.g:6082:1: rule__LegacyAsSoonAs__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyAsSoonAs__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6086:1: ( ( ruleExp ) )
            // InternalOCLX.g:6087:2: ( ruleExp )
            {
            // InternalOCLX.g:6087:2: ( ruleExp )
            // InternalOCLX.g:6088:3: ruleExp
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
    // InternalOCLX.g:6097:1: rule__LegacyEverytime__NameAssignment_0 : ( ( 'everytime' ) ) ;
    public final void rule__LegacyEverytime__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6101:1: ( ( ( 'everytime' ) ) )
            // InternalOCLX.g:6102:2: ( ( 'everytime' ) )
            {
            // InternalOCLX.g:6102:2: ( ( 'everytime' ) )
            // InternalOCLX.g:6103:3: ( 'everytime' )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0()); 
            // InternalOCLX.g:6104:3: ( 'everytime' )
            // InternalOCLX.g:6105:4: 'everytime'
            {
             before(grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0()); 
            match(input,69,FOLLOW_2); 
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
    // InternalOCLX.g:6116:1: rule__LegacyEverytime__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyEverytime__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6120:1: ( ( ruleExp ) )
            // InternalOCLX.g:6121:2: ( ruleExp )
            {
            // InternalOCLX.g:6121:2: ( ruleExp )
            // InternalOCLX.g:6122:3: ruleExp
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
    // InternalOCLX.g:6131:1: rule__LegacyEverytime__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyEverytime__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6135:1: ( ( ruleExp ) )
            // InternalOCLX.g:6136:2: ( ruleExp )
            {
            // InternalOCLX.g:6136:2: ( ruleExp )
            // InternalOCLX.g:6137:3: ruleExp
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
    // InternalOCLX.g:6146:1: rule__ArgumentsExp__OperatorsAssignment_0 : ( ruleExp ) ;
    public final void rule__ArgumentsExp__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6150:1: ( ( ruleExp ) )
            // InternalOCLX.g:6151:2: ( ruleExp )
            {
            // InternalOCLX.g:6151:2: ( ruleExp )
            // InternalOCLX.g:6152:3: ruleExp
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
    // InternalOCLX.g:6161:1: rule__ArgumentsExp__OperatorsAssignment_1_1 : ( ruleExp ) ;
    public final void rule__ArgumentsExp__OperatorsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:6165:1: ( ( ruleExp ) )
            // InternalOCLX.g:6166:2: ( ruleExp )
            {
            // InternalOCLX.g:6166:2: ( ruleExp )
            // InternalOCLX.g:6167:3: ruleExp
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
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0xC6100E00120000B0L,0x000000000000003FL});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000003FFF000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000003FFF002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000012000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000001FE0000010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x000001E000002000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x2000000000000002L});

}