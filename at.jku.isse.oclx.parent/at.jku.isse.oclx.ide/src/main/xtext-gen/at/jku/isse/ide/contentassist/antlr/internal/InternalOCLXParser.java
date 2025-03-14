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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_DESCRIPTION", "RULE_STRING", "RULE_URI", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'>'", "'<'", "'>='", "'<='", "'='", "'!='", "'and'", "'or'", "'xor'", "'implies'", "'*'", "'/'", "'+'", "'-'", "'.'", "'->'", "'not'", "'forAll'", "'exists'", "'collect'", "'reject'", "'select'", "'asType'", "'isTypeOf'", "'isKindOf'", "'next'", "'always'", "'eventually'", "'rule'", "'{'", "'context:'", "'expression:'", "'}'", "'description:'", "'is'", "'overrulable:'", "'('", "')'", "'|'", "':'", "'()'", "'ensureThat'", "'asLongAs'", "'then'", "'thenAtLeastOnce'", "','", "'self'", "'true'", "'false'", "'everyTime'", "'whenOnce'", "'until'", "'asSoonAs'", "'everytime'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
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
    public static final int RULE_DESCRIPTION=6;
    public static final int RULE_URI=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=10;
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
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
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

                if ( (LA1_0==41) ) {
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
    // InternalOCLX.g:862:1: ruleTypeExp : ( ( rule__TypeExp__Group__0 ) ) ;
    public final void ruleTypeExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:866:2: ( ( ( rule__TypeExp__Group__0 ) ) )
            // InternalOCLX.g:867:2: ( ( rule__TypeExp__Group__0 ) )
            {
            // InternalOCLX.g:867:2: ( ( rule__TypeExp__Group__0 ) )
            // InternalOCLX.g:868:3: ( rule__TypeExp__Group__0 )
            {
             before(grammarAccess.getTypeExpAccess().getGroup()); 
            // InternalOCLX.g:869:3: ( rule__TypeExp__Group__0 )
            // InternalOCLX.g:869:4: rule__TypeExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TypeExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTypeExpAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleArgumentsExp"
    // InternalOCLX.g:1153:1: entryRuleArgumentsExp : ruleArgumentsExp EOF ;
    public final void entryRuleArgumentsExp() throws RecognitionException {
        try {
            // InternalOCLX.g:1154:1: ( ruleArgumentsExp EOF )
            // InternalOCLX.g:1155:1: ruleArgumentsExp EOF
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
    // InternalOCLX.g:1162:1: ruleArgumentsExp : ( ( rule__ArgumentsExp__Group__0 ) ) ;
    public final void ruleArgumentsExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1166:2: ( ( ( rule__ArgumentsExp__Group__0 ) ) )
            // InternalOCLX.g:1167:2: ( ( rule__ArgumentsExp__Group__0 ) )
            {
            // InternalOCLX.g:1167:2: ( ( rule__ArgumentsExp__Group__0 ) )
            // InternalOCLX.g:1168:3: ( rule__ArgumentsExp__Group__0 )
            {
             before(grammarAccess.getArgumentsExpAccess().getGroup()); 
            // InternalOCLX.g:1169:3: ( rule__ArgumentsExp__Group__0 )
            // InternalOCLX.g:1169:4: rule__ArgumentsExp__Group__0
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
    // InternalOCLX.g:1177:1: rule__PrefixedExp__Alternatives : ( ( ( rule__PrefixedExp__Group_0__0 ) ) | ( rulePrimaryExp ) );
    public final void rule__PrefixedExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1181:1: ( ( ( rule__PrefixedExp__Group_0__0 ) ) | ( rulePrimaryExp ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==26||LA2_0==29) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_INT)||LA2_0==RULE_STRING||(LA2_0>=38 && LA2_0<=40)||LA2_0==49||(LA2_0>=54 && LA2_0<=55)||(LA2_0>=59 && LA2_0<=66)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalOCLX.g:1182:2: ( ( rule__PrefixedExp__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1182:2: ( ( rule__PrefixedExp__Group_0__0 ) )
                    // InternalOCLX.g:1183:3: ( rule__PrefixedExp__Group_0__0 )
                    {
                     before(grammarAccess.getPrefixedExpAccess().getGroup_0()); 
                    // InternalOCLX.g:1184:3: ( rule__PrefixedExp__Group_0__0 )
                    // InternalOCLX.g:1184:4: rule__PrefixedExp__Group_0__0
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
                    // InternalOCLX.g:1188:2: ( rulePrimaryExp )
                    {
                    // InternalOCLX.g:1188:2: ( rulePrimaryExp )
                    // InternalOCLX.g:1189:3: rulePrimaryExp
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
    // InternalOCLX.g:1198:1: rule__InfixOperator__Alternatives : ( ( ruleBooleanOperator ) | ( ruleMathOperator ) );
    public final void rule__InfixOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1202:1: ( ( ruleBooleanOperator ) | ( ruleMathOperator ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=13 && LA3_0<=22)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=23 && LA3_0<=26)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalOCLX.g:1203:2: ( ruleBooleanOperator )
                    {
                    // InternalOCLX.g:1203:2: ( ruleBooleanOperator )
                    // InternalOCLX.g:1204:3: ruleBooleanOperator
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
                    // InternalOCLX.g:1209:2: ( ruleMathOperator )
                    {
                    // InternalOCLX.g:1209:2: ( ruleMathOperator )
                    // InternalOCLX.g:1210:3: ruleMathOperator
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
    // InternalOCLX.g:1219:1: rule__BooleanOperator__OpAlternatives_0 : ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '!=' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) );
    public final void rule__BooleanOperator__OpAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1223:1: ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '!=' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) )
            int alt4=10;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt4=1;
                }
                break;
            case 14:
                {
                alt4=2;
                }
                break;
            case 15:
                {
                alt4=3;
                }
                break;
            case 16:
                {
                alt4=4;
                }
                break;
            case 17:
                {
                alt4=5;
                }
                break;
            case 18:
                {
                alt4=6;
                }
                break;
            case 19:
                {
                alt4=7;
                }
                break;
            case 20:
                {
                alt4=8;
                }
                break;
            case 21:
                {
                alt4=9;
                }
                break;
            case 22:
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
                    // InternalOCLX.g:1224:2: ( '>' )
                    {
                    // InternalOCLX.g:1224:2: ( '>' )
                    // InternalOCLX.g:1225:3: '>'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1230:2: ( '<' )
                    {
                    // InternalOCLX.g:1230:2: ( '<' )
                    // InternalOCLX.g:1231:3: '<'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1236:2: ( '>=' )
                    {
                    // InternalOCLX.g:1236:2: ( '>=' )
                    // InternalOCLX.g:1237:3: '>='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1242:2: ( '<=' )
                    {
                    // InternalOCLX.g:1242:2: ( '<=' )
                    // InternalOCLX.g:1243:3: '<='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1248:2: ( '=' )
                    {
                    // InternalOCLX.g:1248:2: ( '=' )
                    // InternalOCLX.g:1249:3: '='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOCLX.g:1254:2: ( '!=' )
                    {
                    // InternalOCLX.g:1254:2: ( '!=' )
                    // InternalOCLX.g:1255:3: '!='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpExclamationMarkEqualsSignKeyword_0_5()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpExclamationMarkEqualsSignKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalOCLX.g:1260:2: ( 'and' )
                    {
                    // InternalOCLX.g:1260:2: ( 'and' )
                    // InternalOCLX.g:1261:3: 'and'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalOCLX.g:1266:2: ( 'or' )
                    {
                    // InternalOCLX.g:1266:2: ( 'or' )
                    // InternalOCLX.g:1267:3: 'or'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalOCLX.g:1272:2: ( 'xor' )
                    {
                    // InternalOCLX.g:1272:2: ( 'xor' )
                    // InternalOCLX.g:1273:3: 'xor'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalOCLX.g:1278:2: ( 'implies' )
                    {
                    // InternalOCLX.g:1278:2: ( 'implies' )
                    // InternalOCLX.g:1279:3: 'implies'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpImpliesKeyword_0_9()); 
                    match(input,22,FOLLOW_2); 
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
    // InternalOCLX.g:1288:1: rule__MathOperator__OpAlternatives_0 : ( ( '*' ) | ( '/' ) | ( '+' ) | ( '-' ) );
    public final void rule__MathOperator__OpAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1292:1: ( ( '*' ) | ( '/' ) | ( '+' ) | ( '-' ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt5=1;
                }
                break;
            case 24:
                {
                alt5=2;
                }
                break;
            case 25:
                {
                alt5=3;
                }
                break;
            case 26:
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
                    // InternalOCLX.g:1293:2: ( '*' )
                    {
                    // InternalOCLX.g:1293:2: ( '*' )
                    // InternalOCLX.g:1294:3: '*'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1299:2: ( '/' )
                    {
                    // InternalOCLX.g:1299:2: ( '/' )
                    // InternalOCLX.g:1300:3: '/'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1305:2: ( '+' )
                    {
                    // InternalOCLX.g:1305:2: ( '+' )
                    // InternalOCLX.g:1306:3: '+'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1311:2: ( '-' )
                    {
                    // InternalOCLX.g:1311:2: ( '-' )
                    // InternalOCLX.g:1312:3: '-'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpHyphenMinusKeyword_0_3()); 
                    match(input,26,FOLLOW_2); 
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
    // InternalOCLX.g:1321:1: rule__NavigationOperator__NameAlternatives_0 : ( ( '.' ) | ( '->' ) );
    public final void rule__NavigationOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1325:1: ( ( '.' ) | ( '->' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==27) ) {
                alt6=1;
            }
            else if ( (LA6_0==28) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalOCLX.g:1326:2: ( '.' )
                    {
                    // InternalOCLX.g:1326:2: ( '.' )
                    // InternalOCLX.g:1327:3: '.'
                    {
                     before(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1332:2: ( '->' )
                    {
                    // InternalOCLX.g:1332:2: ( '->' )
                    // InternalOCLX.g:1333:3: '->'
                    {
                     before(grammarAccess.getNavigationOperatorAccess().getNameHyphenMinusGreaterThanSignKeyword_0_1()); 
                    match(input,28,FOLLOW_2); 
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
    // InternalOCLX.g:1342:1: rule__UnaryOperator__NameAlternatives_0 : ( ( '-' ) | ( 'not' ) );
    public final void rule__UnaryOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1346:1: ( ( '-' ) | ( 'not' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==26) ) {
                alt7=1;
            }
            else if ( (LA7_0==29) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalOCLX.g:1347:2: ( '-' )
                    {
                    // InternalOCLX.g:1347:2: ( '-' )
                    // InternalOCLX.g:1348:3: '-'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1353:2: ( 'not' )
                    {
                    // InternalOCLX.g:1353:2: ( 'not' )
                    // InternalOCLX.g:1354:3: 'not'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getNameNotKeyword_0_1()); 
                    match(input,29,FOLLOW_2); 
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
    // InternalOCLX.g:1363:1: rule__PrimaryExp__Alternatives : ( ( ruleNestedExp ) | ( ( rule__PrimaryExp__Group_1__0 ) ) | ( rulePrimitiveLiteralExp ) | ( ruleTemporalExp ) );
    public final void rule__PrimaryExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1367:1: ( ( ruleNestedExp ) | ( ( rule__PrimaryExp__Group_1__0 ) ) | ( rulePrimitiveLiteralExp ) | ( ruleTemporalExp ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt8=1;
                }
                break;
            case RULE_ID:
            case 59:
                {
                alt8=2;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 60:
            case 61:
                {
                alt8=3;
                }
                break;
            case 38:
            case 39:
            case 40:
            case 54:
            case 55:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
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
                    // InternalOCLX.g:1368:2: ( ruleNestedExp )
                    {
                    // InternalOCLX.g:1368:2: ( ruleNestedExp )
                    // InternalOCLX.g:1369:3: ruleNestedExp
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
                    // InternalOCLX.g:1374:2: ( ( rule__PrimaryExp__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1374:2: ( ( rule__PrimaryExp__Group_1__0 ) )
                    // InternalOCLX.g:1375:3: ( rule__PrimaryExp__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryExpAccess().getGroup_1()); 
                    // InternalOCLX.g:1376:3: ( rule__PrimaryExp__Group_1__0 )
                    // InternalOCLX.g:1376:4: rule__PrimaryExp__Group_1__0
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
                    // InternalOCLX.g:1380:2: ( rulePrimitiveLiteralExp )
                    {
                    // InternalOCLX.g:1380:2: ( rulePrimitiveLiteralExp )
                    // InternalOCLX.g:1381:3: rulePrimitiveLiteralExp
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
                    // InternalOCLX.g:1386:2: ( ruleTemporalExp )
                    {
                    // InternalOCLX.g:1386:2: ( ruleTemporalExp )
                    // InternalOCLX.g:1387:3: ruleTemporalExp
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
    // InternalOCLX.g:1396:1: rule__VarOrSelfExp__Alternatives : ( ( ruleSelfExp ) | ( ruleVarReference ) );
    public final void rule__VarOrSelfExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1400:1: ( ( ruleSelfExp ) | ( ruleVarReference ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==59) ) {
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
                    // InternalOCLX.g:1401:2: ( ruleSelfExp )
                    {
                    // InternalOCLX.g:1401:2: ( ruleSelfExp )
                    // InternalOCLX.g:1402:3: ruleSelfExp
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
                    // InternalOCLX.g:1407:2: ( ruleVarReference )
                    {
                    // InternalOCLX.g:1407:2: ( ruleVarReference )
                    // InternalOCLX.g:1408:3: ruleVarReference
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
    // InternalOCLX.g:1417:1: rule__PrimitiveLiteralExp__Alternatives : ( ( ruleIntLiteralExp ) | ( ruleStringLiteralExp ) | ( ruleBooleanLiteralExp ) | ( ruleFloatLiteralExp ) );
    public final void rule__PrimitiveLiteralExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1421:1: ( ( ruleIntLiteralExp ) | ( ruleStringLiteralExp ) | ( ruleBooleanLiteralExp ) | ( ruleFloatLiteralExp ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==EOF||(LA10_1>=13 && LA10_1<=26)||LA10_1==45||LA10_1==50||(LA10_1>=54 && LA10_1<=58)) ) {
                    alt10=1;
                }
                else if ( (LA10_1==27) ) {
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
            case 60:
            case 61:
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
                    // InternalOCLX.g:1422:2: ( ruleIntLiteralExp )
                    {
                    // InternalOCLX.g:1422:2: ( ruleIntLiteralExp )
                    // InternalOCLX.g:1423:3: ruleIntLiteralExp
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
                    // InternalOCLX.g:1428:2: ( ruleStringLiteralExp )
                    {
                    // InternalOCLX.g:1428:2: ( ruleStringLiteralExp )
                    // InternalOCLX.g:1429:3: ruleStringLiteralExp
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
                    // InternalOCLX.g:1434:2: ( ruleBooleanLiteralExp )
                    {
                    // InternalOCLX.g:1434:2: ( ruleBooleanLiteralExp )
                    // InternalOCLX.g:1435:3: ruleBooleanLiteralExp
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
                    // InternalOCLX.g:1440:2: ( ruleFloatLiteralExp )
                    {
                    // InternalOCLX.g:1440:2: ( ruleFloatLiteralExp )
                    // InternalOCLX.g:1441:3: ruleFloatLiteralExp
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
    // InternalOCLX.g:1450:1: rule__BooleanLiteralExp__Alternatives : ( ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) ) | ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) ) );
    public final void rule__BooleanLiteralExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1454:1: ( ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) ) | ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==60) ) {
                alt11=1;
            }
            else if ( (LA11_0==61) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalOCLX.g:1455:2: ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) )
                    {
                    // InternalOCLX.g:1455:2: ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) )
                    // InternalOCLX.g:1456:3: ( rule__BooleanLiteralExp__ValueAssignment_0 )
                    {
                     before(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_0()); 
                    // InternalOCLX.g:1457:3: ( rule__BooleanLiteralExp__ValueAssignment_0 )
                    // InternalOCLX.g:1457:4: rule__BooleanLiteralExp__ValueAssignment_0
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
                    // InternalOCLX.g:1461:2: ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) )
                    {
                    // InternalOCLX.g:1461:2: ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) )
                    // InternalOCLX.g:1462:3: ( rule__BooleanLiteralExp__ValueAssignment_1 )
                    {
                     before(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_1()); 
                    // InternalOCLX.g:1463:3: ( rule__BooleanLiteralExp__ValueAssignment_1 )
                    // InternalOCLX.g:1463:4: rule__BooleanLiteralExp__ValueAssignment_1
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
    // InternalOCLX.g:1471:1: rule__MethodExp__Alternatives : ( ( rulePropertyAccess ) | ( ruleMethodCall ) | ( ruleCollectionIterator ) | ( ruleTypeCall ) );
    public final void rule__MethodExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1475:1: ( ( rulePropertyAccess ) | ( ruleMethodCall ) | ( ruleCollectionIterator ) | ( ruleTypeCall ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==EOF||(LA12_1>=13 && LA12_1<=28)||LA12_1==45||LA12_1==50||(LA12_1>=54 && LA12_1<=58)) ) {
                    alt12=1;
                }
                else if ( (LA12_1==49||LA12_1==53) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
                }
                break;
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
                {
                alt12=3;
                }
                break;
            case 35:
            case 36:
            case 37:
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
                    // InternalOCLX.g:1476:2: ( rulePropertyAccess )
                    {
                    // InternalOCLX.g:1476:2: ( rulePropertyAccess )
                    // InternalOCLX.g:1477:3: rulePropertyAccess
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
                    // InternalOCLX.g:1482:2: ( ruleMethodCall )
                    {
                    // InternalOCLX.g:1482:2: ( ruleMethodCall )
                    // InternalOCLX.g:1483:3: ruleMethodCall
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
                    // InternalOCLX.g:1488:2: ( ruleCollectionIterator )
                    {
                    // InternalOCLX.g:1488:2: ( ruleCollectionIterator )
                    // InternalOCLX.g:1489:3: ruleCollectionIterator
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
                    // InternalOCLX.g:1494:2: ( ruleTypeCall )
                    {
                    // InternalOCLX.g:1494:2: ( ruleTypeCall )
                    // InternalOCLX.g:1495:3: ruleTypeCall
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
    // InternalOCLX.g:1504:1: rule__IteratorName__NameAlternatives_0 : ( ( 'forAll' ) | ( 'exists' ) | ( 'collect' ) | ( 'reject' ) | ( 'select' ) );
    public final void rule__IteratorName__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1508:1: ( ( 'forAll' ) | ( 'exists' ) | ( 'collect' ) | ( 'reject' ) | ( 'select' ) )
            int alt13=5;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt13=1;
                }
                break;
            case 31:
                {
                alt13=2;
                }
                break;
            case 32:
                {
                alt13=3;
                }
                break;
            case 33:
                {
                alt13=4;
                }
                break;
            case 34:
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
                    // InternalOCLX.g:1509:2: ( 'forAll' )
                    {
                    // InternalOCLX.g:1509:2: ( 'forAll' )
                    // InternalOCLX.g:1510:3: 'forAll'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameForAllKeyword_0_0()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameForAllKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1515:2: ( 'exists' )
                    {
                    // InternalOCLX.g:1515:2: ( 'exists' )
                    // InternalOCLX.g:1516:3: 'exists'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameExistsKeyword_0_1()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameExistsKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1521:2: ( 'collect' )
                    {
                    // InternalOCLX.g:1521:2: ( 'collect' )
                    // InternalOCLX.g:1522:3: 'collect'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameCollectKeyword_0_2()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameCollectKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1527:2: ( 'reject' )
                    {
                    // InternalOCLX.g:1527:2: ( 'reject' )
                    // InternalOCLX.g:1528:3: 'reject'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameRejectKeyword_0_3()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameRejectKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1533:2: ( 'select' )
                    {
                    // InternalOCLX.g:1533:2: ( 'select' )
                    // InternalOCLX.g:1534:3: 'select'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameSelectKeyword_0_4()); 
                    match(input,34,FOLLOW_2); 
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
    // InternalOCLX.g:1543:1: rule__IteratorVarDeclaration__Alternatives : ( ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) ) | ( ( rule__IteratorVarDeclaration__Group_1__0 ) ) );
    public final void rule__IteratorVarDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1547:1: ( ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) ) | ( ( rule__IteratorVarDeclaration__Group_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==EOF||LA14_1==51) ) {
                    alt14=1;
                }
                else if ( (LA14_1==52) ) {
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
                    // InternalOCLX.g:1548:2: ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) )
                    {
                    // InternalOCLX.g:1548:2: ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) )
                    // InternalOCLX.g:1549:3: ( rule__IteratorVarDeclaration__NameAssignment_0 )
                    {
                     before(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_0()); 
                    // InternalOCLX.g:1550:3: ( rule__IteratorVarDeclaration__NameAssignment_0 )
                    // InternalOCLX.g:1550:4: rule__IteratorVarDeclaration__NameAssignment_0
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
                    // InternalOCLX.g:1554:2: ( ( rule__IteratorVarDeclaration__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1554:2: ( ( rule__IteratorVarDeclaration__Group_1__0 ) )
                    // InternalOCLX.g:1555:3: ( rule__IteratorVarDeclaration__Group_1__0 )
                    {
                     before(grammarAccess.getIteratorVarDeclarationAccess().getGroup_1()); 
                    // InternalOCLX.g:1556:3: ( rule__IteratorVarDeclaration__Group_1__0 )
                    // InternalOCLX.g:1556:4: rule__IteratorVarDeclaration__Group_1__0
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
    // InternalOCLX.g:1564:1: rule__MethodCall__Alternatives : ( ( ( rule__MethodCall__Group_0__0 ) ) | ( ( rule__MethodCall__Group_1__0 ) ) );
    public final void rule__MethodCall__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1568:1: ( ( ( rule__MethodCall__Group_0__0 ) ) | ( ( rule__MethodCall__Group_1__0 ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==53) ) {
                    alt15=1;
                }
                else if ( (LA15_1==49) ) {
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
                    // InternalOCLX.g:1569:2: ( ( rule__MethodCall__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1569:2: ( ( rule__MethodCall__Group_0__0 ) )
                    // InternalOCLX.g:1570:3: ( rule__MethodCall__Group_0__0 )
                    {
                     before(grammarAccess.getMethodCallAccess().getGroup_0()); 
                    // InternalOCLX.g:1571:3: ( rule__MethodCall__Group_0__0 )
                    // InternalOCLX.g:1571:4: rule__MethodCall__Group_0__0
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
                    // InternalOCLX.g:1575:2: ( ( rule__MethodCall__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1575:2: ( ( rule__MethodCall__Group_1__0 ) )
                    // InternalOCLX.g:1576:3: ( rule__MethodCall__Group_1__0 )
                    {
                     before(grammarAccess.getMethodCallAccess().getGroup_1()); 
                    // InternalOCLX.g:1577:3: ( rule__MethodCall__Group_1__0 )
                    // InternalOCLX.g:1577:4: rule__MethodCall__Group_1__0
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
    // InternalOCLX.g:1585:1: rule__TypeCall__NameAlternatives_0_0 : ( ( 'asType' ) | ( 'isTypeOf' ) | ( 'isKindOf' ) );
    public final void rule__TypeCall__NameAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1589:1: ( ( 'asType' ) | ( 'isTypeOf' ) | ( 'isKindOf' ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt16=1;
                }
                break;
            case 36:
                {
                alt16=2;
                }
                break;
            case 37:
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
                    // InternalOCLX.g:1590:2: ( 'asType' )
                    {
                    // InternalOCLX.g:1590:2: ( 'asType' )
                    // InternalOCLX.g:1591:3: 'asType'
                    {
                     before(grammarAccess.getTypeCallAccess().getNameAsTypeKeyword_0_0_0()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getTypeCallAccess().getNameAsTypeKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1596:2: ( 'isTypeOf' )
                    {
                    // InternalOCLX.g:1596:2: ( 'isTypeOf' )
                    // InternalOCLX.g:1597:3: 'isTypeOf'
                    {
                     before(grammarAccess.getTypeCallAccess().getNameIsTypeOfKeyword_0_0_1()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getTypeCallAccess().getNameIsTypeOfKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1602:2: ( 'isKindOf' )
                    {
                    // InternalOCLX.g:1602:2: ( 'isKindOf' )
                    // InternalOCLX.g:1603:3: 'isKindOf'
                    {
                     before(grammarAccess.getTypeCallAccess().getNameIsKindOfKeyword_0_0_2()); 
                    match(input,37,FOLLOW_2); 
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


    // $ANTLR start "rule__TemporalExp__Alternatives"
    // InternalOCLX.g:1612:1: rule__TemporalExp__Alternatives : ( ( ruleUnaryTemporalExp ) | ( ruleTriggeredTemporalExp ) );
    public final void rule__TemporalExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1616:1: ( ( ruleUnaryTemporalExp ) | ( ruleTriggeredTemporalExp ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=38 && LA17_0<=40)) ) {
                alt17=1;
            }
            else if ( ((LA17_0>=54 && LA17_0<=55)||(LA17_0>=62 && LA17_0<=66)) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalOCLX.g:1617:2: ( ruleUnaryTemporalExp )
                    {
                    // InternalOCLX.g:1617:2: ( ruleUnaryTemporalExp )
                    // InternalOCLX.g:1618:3: ruleUnaryTemporalExp
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
                    // InternalOCLX.g:1623:2: ( ruleTriggeredTemporalExp )
                    {
                    // InternalOCLX.g:1623:2: ( ruleTriggeredTemporalExp )
                    // InternalOCLX.g:1624:3: ruleTriggeredTemporalExp
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
    // InternalOCLX.g:1633:1: rule__UnaryTemporalOp__Alternatives : ( ( 'next' ) | ( 'always' ) | ( 'eventually' ) );
    public final void rule__UnaryTemporalOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1637:1: ( ( 'next' ) | ( 'always' ) | ( 'eventually' ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt18=1;
                }
                break;
            case 39:
                {
                alt18=2;
                }
                break;
            case 40:
                {
                alt18=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalOCLX.g:1638:2: ( 'next' )
                    {
                    // InternalOCLX.g:1638:2: ( 'next' )
                    // InternalOCLX.g:1639:3: 'next'
                    {
                     before(grammarAccess.getUnaryTemporalOpAccess().getNextKeyword_0()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getUnaryTemporalOpAccess().getNextKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1644:2: ( 'always' )
                    {
                    // InternalOCLX.g:1644:2: ( 'always' )
                    // InternalOCLX.g:1645:3: 'always'
                    {
                     before(grammarAccess.getUnaryTemporalOpAccess().getAlwaysKeyword_1()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getUnaryTemporalOpAccess().getAlwaysKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1650:2: ( 'eventually' )
                    {
                    // InternalOCLX.g:1650:2: ( 'eventually' )
                    // InternalOCLX.g:1651:3: 'eventually'
                    {
                     before(grammarAccess.getUnaryTemporalOpAccess().getEventuallyKeyword_2()); 
                    match(input,40,FOLLOW_2); 
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
    // InternalOCLX.g:1660:1: rule__TriggeredTemporalExp__Alternatives : ( ( ruleTemporalAsLongAs ) | ( ruleTemporalUntil ) | ( ruleTemporalEverytime ) | ( ruleTemporalAtLeastOnce ) | ( ruleLegacyUntil ) | ( ruleLegacyAsSoonAs ) | ( ruleLegacyEverytime ) );
    public final void rule__TriggeredTemporalExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1664:1: ( ( ruleTemporalAsLongAs ) | ( ruleTemporalUntil ) | ( ruleTemporalEverytime ) | ( ruleTemporalAtLeastOnce ) | ( ruleLegacyUntil ) | ( ruleLegacyAsSoonAs ) | ( ruleLegacyEverytime ) )
            int alt19=7;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt19=1;
                }
                break;
            case 54:
                {
                alt19=2;
                }
                break;
            case 62:
                {
                alt19=3;
                }
                break;
            case 63:
                {
                alt19=4;
                }
                break;
            case 64:
                {
                alt19=5;
                }
                break;
            case 65:
                {
                alt19=6;
                }
                break;
            case 66:
                {
                alt19=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalOCLX.g:1665:2: ( ruleTemporalAsLongAs )
                    {
                    // InternalOCLX.g:1665:2: ( ruleTemporalAsLongAs )
                    // InternalOCLX.g:1666:3: ruleTemporalAsLongAs
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
                    // InternalOCLX.g:1671:2: ( ruleTemporalUntil )
                    {
                    // InternalOCLX.g:1671:2: ( ruleTemporalUntil )
                    // InternalOCLX.g:1672:3: ruleTemporalUntil
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
                    // InternalOCLX.g:1677:2: ( ruleTemporalEverytime )
                    {
                    // InternalOCLX.g:1677:2: ( ruleTemporalEverytime )
                    // InternalOCLX.g:1678:3: ruleTemporalEverytime
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
                    // InternalOCLX.g:1683:2: ( ruleTemporalAtLeastOnce )
                    {
                    // InternalOCLX.g:1683:2: ( ruleTemporalAtLeastOnce )
                    // InternalOCLX.g:1684:3: ruleTemporalAtLeastOnce
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
                    // InternalOCLX.g:1689:2: ( ruleLegacyUntil )
                    {
                    // InternalOCLX.g:1689:2: ( ruleLegacyUntil )
                    // InternalOCLX.g:1690:3: ruleLegacyUntil
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
                    // InternalOCLX.g:1695:2: ( ruleLegacyAsSoonAs )
                    {
                    // InternalOCLX.g:1695:2: ( ruleLegacyAsSoonAs )
                    // InternalOCLX.g:1696:3: ruleLegacyAsSoonAs
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
                    // InternalOCLX.g:1701:2: ( ruleLegacyEverytime )
                    {
                    // InternalOCLX.g:1701:2: ( ruleLegacyEverytime )
                    // InternalOCLX.g:1702:3: ruleLegacyEverytime
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
    // InternalOCLX.g:1711:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1715:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalOCLX.g:1716:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
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
    // InternalOCLX.g:1723:1: rule__Constraint__Group__0__Impl : ( 'rule' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1727:1: ( ( 'rule' ) )
            // InternalOCLX.g:1728:1: ( 'rule' )
            {
            // InternalOCLX.g:1728:1: ( 'rule' )
            // InternalOCLX.g:1729:2: 'rule'
            {
             before(grammarAccess.getConstraintAccess().getRuleKeyword_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalOCLX.g:1738:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1742:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalOCLX.g:1743:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
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
    // InternalOCLX.g:1750:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__NameAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1754:1: ( ( ( rule__Constraint__NameAssignment_1 ) ) )
            // InternalOCLX.g:1755:1: ( ( rule__Constraint__NameAssignment_1 ) )
            {
            // InternalOCLX.g:1755:1: ( ( rule__Constraint__NameAssignment_1 ) )
            // InternalOCLX.g:1756:2: ( rule__Constraint__NameAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getNameAssignment_1()); 
            // InternalOCLX.g:1757:2: ( rule__Constraint__NameAssignment_1 )
            // InternalOCLX.g:1757:3: rule__Constraint__NameAssignment_1
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
    // InternalOCLX.g:1765:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1769:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalOCLX.g:1770:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
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
    // InternalOCLX.g:1777:1: rule__Constraint__Group__2__Impl : ( '{' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1781:1: ( ( '{' ) )
            // InternalOCLX.g:1782:1: ( '{' )
            {
            // InternalOCLX.g:1782:1: ( '{' )
            // InternalOCLX.g:1783:2: '{'
            {
             before(grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,42,FOLLOW_2); 
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
    // InternalOCLX.g:1792:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1796:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalOCLX.g:1797:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
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
    // InternalOCLX.g:1804:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__Group_3__0 )? ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1808:1: ( ( ( rule__Constraint__Group_3__0 )? ) )
            // InternalOCLX.g:1809:1: ( ( rule__Constraint__Group_3__0 )? )
            {
            // InternalOCLX.g:1809:1: ( ( rule__Constraint__Group_3__0 )? )
            // InternalOCLX.g:1810:2: ( rule__Constraint__Group_3__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_3()); 
            // InternalOCLX.g:1811:2: ( rule__Constraint__Group_3__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==46) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalOCLX.g:1811:3: rule__Constraint__Group_3__0
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
    // InternalOCLX.g:1819:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1823:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalOCLX.g:1824:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
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
    // InternalOCLX.g:1831:1: rule__Constraint__Group__4__Impl : ( ( rule__Constraint__Group_4__0 )? ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1835:1: ( ( ( rule__Constraint__Group_4__0 )? ) )
            // InternalOCLX.g:1836:1: ( ( rule__Constraint__Group_4__0 )? )
            {
            // InternalOCLX.g:1836:1: ( ( rule__Constraint__Group_4__0 )? )
            // InternalOCLX.g:1837:2: ( rule__Constraint__Group_4__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_4()); 
            // InternalOCLX.g:1838:2: ( rule__Constraint__Group_4__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==47) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalOCLX.g:1838:3: rule__Constraint__Group_4__0
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
    // InternalOCLX.g:1846:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl rule__Constraint__Group__6 ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1850:1: ( rule__Constraint__Group__5__Impl rule__Constraint__Group__6 )
            // InternalOCLX.g:1851:2: rule__Constraint__Group__5__Impl rule__Constraint__Group__6
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
    // InternalOCLX.g:1858:1: rule__Constraint__Group__5__Impl : ( 'context:' ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1862:1: ( ( 'context:' ) )
            // InternalOCLX.g:1863:1: ( 'context:' )
            {
            // InternalOCLX.g:1863:1: ( 'context:' )
            // InternalOCLX.g:1864:2: 'context:'
            {
             before(grammarAccess.getConstraintAccess().getContextKeyword_5()); 
            match(input,43,FOLLOW_2); 
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
    // InternalOCLX.g:1873:1: rule__Constraint__Group__6 : rule__Constraint__Group__6__Impl rule__Constraint__Group__7 ;
    public final void rule__Constraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1877:1: ( rule__Constraint__Group__6__Impl rule__Constraint__Group__7 )
            // InternalOCLX.g:1878:2: rule__Constraint__Group__6__Impl rule__Constraint__Group__7
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
    // InternalOCLX.g:1885:1: rule__Constraint__Group__6__Impl : ( ( rule__Constraint__ContextAssignment_6 ) ) ;
    public final void rule__Constraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1889:1: ( ( ( rule__Constraint__ContextAssignment_6 ) ) )
            // InternalOCLX.g:1890:1: ( ( rule__Constraint__ContextAssignment_6 ) )
            {
            // InternalOCLX.g:1890:1: ( ( rule__Constraint__ContextAssignment_6 ) )
            // InternalOCLX.g:1891:2: ( rule__Constraint__ContextAssignment_6 )
            {
             before(grammarAccess.getConstraintAccess().getContextAssignment_6()); 
            // InternalOCLX.g:1892:2: ( rule__Constraint__ContextAssignment_6 )
            // InternalOCLX.g:1892:3: rule__Constraint__ContextAssignment_6
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
    // InternalOCLX.g:1900:1: rule__Constraint__Group__7 : rule__Constraint__Group__7__Impl rule__Constraint__Group__8 ;
    public final void rule__Constraint__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1904:1: ( rule__Constraint__Group__7__Impl rule__Constraint__Group__8 )
            // InternalOCLX.g:1905:2: rule__Constraint__Group__7__Impl rule__Constraint__Group__8
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
    // InternalOCLX.g:1912:1: rule__Constraint__Group__7__Impl : ( 'expression:' ) ;
    public final void rule__Constraint__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1916:1: ( ( 'expression:' ) )
            // InternalOCLX.g:1917:1: ( 'expression:' )
            {
            // InternalOCLX.g:1917:1: ( 'expression:' )
            // InternalOCLX.g:1918:2: 'expression:'
            {
             before(grammarAccess.getConstraintAccess().getExpressionKeyword_7()); 
            match(input,44,FOLLOW_2); 
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
    // InternalOCLX.g:1927:1: rule__Constraint__Group__8 : rule__Constraint__Group__8__Impl rule__Constraint__Group__9 ;
    public final void rule__Constraint__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1931:1: ( rule__Constraint__Group__8__Impl rule__Constraint__Group__9 )
            // InternalOCLX.g:1932:2: rule__Constraint__Group__8__Impl rule__Constraint__Group__9
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
    // InternalOCLX.g:1939:1: rule__Constraint__Group__8__Impl : ( ( rule__Constraint__ExpressionAssignment_8 ) ) ;
    public final void rule__Constraint__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1943:1: ( ( ( rule__Constraint__ExpressionAssignment_8 ) ) )
            // InternalOCLX.g:1944:1: ( ( rule__Constraint__ExpressionAssignment_8 ) )
            {
            // InternalOCLX.g:1944:1: ( ( rule__Constraint__ExpressionAssignment_8 ) )
            // InternalOCLX.g:1945:2: ( rule__Constraint__ExpressionAssignment_8 )
            {
             before(grammarAccess.getConstraintAccess().getExpressionAssignment_8()); 
            // InternalOCLX.g:1946:2: ( rule__Constraint__ExpressionAssignment_8 )
            // InternalOCLX.g:1946:3: rule__Constraint__ExpressionAssignment_8
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
    // InternalOCLX.g:1954:1: rule__Constraint__Group__9 : rule__Constraint__Group__9__Impl ;
    public final void rule__Constraint__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1958:1: ( rule__Constraint__Group__9__Impl )
            // InternalOCLX.g:1959:2: rule__Constraint__Group__9__Impl
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
    // InternalOCLX.g:1965:1: rule__Constraint__Group__9__Impl : ( '}' ) ;
    public final void rule__Constraint__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1969:1: ( ( '}' ) )
            // InternalOCLX.g:1970:1: ( '}' )
            {
            // InternalOCLX.g:1970:1: ( '}' )
            // InternalOCLX.g:1971:2: '}'
            {
             before(grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_9()); 
            match(input,45,FOLLOW_2); 
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
    // InternalOCLX.g:1981:1: rule__Constraint__Group_3__0 : rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1 ;
    public final void rule__Constraint__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1985:1: ( rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1 )
            // InternalOCLX.g:1986:2: rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1
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
    // InternalOCLX.g:1993:1: rule__Constraint__Group_3__0__Impl : ( 'description:' ) ;
    public final void rule__Constraint__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1997:1: ( ( 'description:' ) )
            // InternalOCLX.g:1998:1: ( 'description:' )
            {
            // InternalOCLX.g:1998:1: ( 'description:' )
            // InternalOCLX.g:1999:2: 'description:'
            {
             before(grammarAccess.getConstraintAccess().getDescriptionKeyword_3_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalOCLX.g:2008:1: rule__Constraint__Group_3__1 : rule__Constraint__Group_3__1__Impl ;
    public final void rule__Constraint__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2012:1: ( rule__Constraint__Group_3__1__Impl )
            // InternalOCLX.g:2013:2: rule__Constraint__Group_3__1__Impl
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
    // InternalOCLX.g:2019:1: rule__Constraint__Group_3__1__Impl : ( ( rule__Constraint__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Constraint__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2023:1: ( ( ( rule__Constraint__DescriptionAssignment_3_1 ) ) )
            // InternalOCLX.g:2024:1: ( ( rule__Constraint__DescriptionAssignment_3_1 ) )
            {
            // InternalOCLX.g:2024:1: ( ( rule__Constraint__DescriptionAssignment_3_1 ) )
            // InternalOCLX.g:2025:2: ( rule__Constraint__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getConstraintAccess().getDescriptionAssignment_3_1()); 
            // InternalOCLX.g:2026:2: ( rule__Constraint__DescriptionAssignment_3_1 )
            // InternalOCLX.g:2026:3: rule__Constraint__DescriptionAssignment_3_1
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
    // InternalOCLX.g:2035:1: rule__Constraint__Group_4__0 : rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 ;
    public final void rule__Constraint__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2039:1: ( rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 )
            // InternalOCLX.g:2040:2: rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1
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
    // InternalOCLX.g:2047:1: rule__Constraint__Group_4__0__Impl : ( 'is' ) ;
    public final void rule__Constraint__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2051:1: ( ( 'is' ) )
            // InternalOCLX.g:2052:1: ( 'is' )
            {
            // InternalOCLX.g:2052:1: ( 'is' )
            // InternalOCLX.g:2053:2: 'is'
            {
             before(grammarAccess.getConstraintAccess().getIsKeyword_4_0()); 
            match(input,47,FOLLOW_2); 
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
    // InternalOCLX.g:2062:1: rule__Constraint__Group_4__1 : rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2 ;
    public final void rule__Constraint__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2066:1: ( rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2 )
            // InternalOCLX.g:2067:2: rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2
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
    // InternalOCLX.g:2074:1: rule__Constraint__Group_4__1__Impl : ( 'overrulable:' ) ;
    public final void rule__Constraint__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2078:1: ( ( 'overrulable:' ) )
            // InternalOCLX.g:2079:1: ( 'overrulable:' )
            {
            // InternalOCLX.g:2079:1: ( 'overrulable:' )
            // InternalOCLX.g:2080:2: 'overrulable:'
            {
             before(grammarAccess.getConstraintAccess().getOverrulableKeyword_4_1()); 
            match(input,48,FOLLOW_2); 
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
    // InternalOCLX.g:2089:1: rule__Constraint__Group_4__2 : rule__Constraint__Group_4__2__Impl ;
    public final void rule__Constraint__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2093:1: ( rule__Constraint__Group_4__2__Impl )
            // InternalOCLX.g:2094:2: rule__Constraint__Group_4__2__Impl
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
    // InternalOCLX.g:2100:1: rule__Constraint__Group_4__2__Impl : ( ( rule__Constraint__OverrulableAssignment_4_2 ) ) ;
    public final void rule__Constraint__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2104:1: ( ( ( rule__Constraint__OverrulableAssignment_4_2 ) ) )
            // InternalOCLX.g:2105:1: ( ( rule__Constraint__OverrulableAssignment_4_2 ) )
            {
            // InternalOCLX.g:2105:1: ( ( rule__Constraint__OverrulableAssignment_4_2 ) )
            // InternalOCLX.g:2106:2: ( rule__Constraint__OverrulableAssignment_4_2 )
            {
             before(grammarAccess.getConstraintAccess().getOverrulableAssignment_4_2()); 
            // InternalOCLX.g:2107:2: ( rule__Constraint__OverrulableAssignment_4_2 )
            // InternalOCLX.g:2107:3: rule__Constraint__OverrulableAssignment_4_2
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
    // InternalOCLX.g:2116:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2120:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalOCLX.g:2121:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalOCLX.g:2128:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2132:1: ( ( RULE_ID ) )
            // InternalOCLX.g:2133:1: ( RULE_ID )
            {
            // InternalOCLX.g:2133:1: ( RULE_ID )
            // InternalOCLX.g:2134:2: RULE_ID
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
    // InternalOCLX.g:2143:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2147:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalOCLX.g:2148:2: rule__QualifiedName__Group__1__Impl
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
    // InternalOCLX.g:2154:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2158:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalOCLX.g:2159:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalOCLX.g:2159:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalOCLX.g:2160:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalOCLX.g:2161:2: ( rule__QualifiedName__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==27) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalOCLX.g:2161:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalOCLX.g:2170:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2174:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalOCLX.g:2175:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalOCLX.g:2182:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2186:1: ( ( '.' ) )
            // InternalOCLX.g:2187:1: ( '.' )
            {
            // InternalOCLX.g:2187:1: ( '.' )
            // InternalOCLX.g:2188:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,27,FOLLOW_2); 
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
    // InternalOCLX.g:2197:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2201:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalOCLX.g:2202:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalOCLX.g:2208:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2212:1: ( ( RULE_ID ) )
            // InternalOCLX.g:2213:1: ( RULE_ID )
            {
            // InternalOCLX.g:2213:1: ( RULE_ID )
            // InternalOCLX.g:2214:2: RULE_ID
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
    // InternalOCLX.g:2224:1: rule__Float__Group__0 : rule__Float__Group__0__Impl rule__Float__Group__1 ;
    public final void rule__Float__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2228:1: ( rule__Float__Group__0__Impl rule__Float__Group__1 )
            // InternalOCLX.g:2229:2: rule__Float__Group__0__Impl rule__Float__Group__1
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
    // InternalOCLX.g:2236:1: rule__Float__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__Float__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2240:1: ( ( RULE_INT ) )
            // InternalOCLX.g:2241:1: ( RULE_INT )
            {
            // InternalOCLX.g:2241:1: ( RULE_INT )
            // InternalOCLX.g:2242:2: RULE_INT
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
    // InternalOCLX.g:2251:1: rule__Float__Group__1 : rule__Float__Group__1__Impl rule__Float__Group__2 ;
    public final void rule__Float__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2255:1: ( rule__Float__Group__1__Impl rule__Float__Group__2 )
            // InternalOCLX.g:2256:2: rule__Float__Group__1__Impl rule__Float__Group__2
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
    // InternalOCLX.g:2263:1: rule__Float__Group__1__Impl : ( '.' ) ;
    public final void rule__Float__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2267:1: ( ( '.' ) )
            // InternalOCLX.g:2268:1: ( '.' )
            {
            // InternalOCLX.g:2268:1: ( '.' )
            // InternalOCLX.g:2269:2: '.'
            {
             before(grammarAccess.getFloatAccess().getFullStopKeyword_1()); 
            match(input,27,FOLLOW_2); 
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
    // InternalOCLX.g:2278:1: rule__Float__Group__2 : rule__Float__Group__2__Impl ;
    public final void rule__Float__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2282:1: ( rule__Float__Group__2__Impl )
            // InternalOCLX.g:2283:2: rule__Float__Group__2__Impl
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
    // InternalOCLX.g:2289:1: rule__Float__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__Float__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2293:1: ( ( RULE_INT ) )
            // InternalOCLX.g:2294:1: ( RULE_INT )
            {
            // InternalOCLX.g:2294:1: ( RULE_INT )
            // InternalOCLX.g:2295:2: RULE_INT
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
    // InternalOCLX.g:2305:1: rule__Exp__Group__0 : rule__Exp__Group__0__Impl rule__Exp__Group__1 ;
    public final void rule__Exp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2309:1: ( rule__Exp__Group__0__Impl rule__Exp__Group__1 )
            // InternalOCLX.g:2310:2: rule__Exp__Group__0__Impl rule__Exp__Group__1
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
    // InternalOCLX.g:2317:1: rule__Exp__Group__0__Impl : ( rulePrefixedExp ) ;
    public final void rule__Exp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2321:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:2322:1: ( rulePrefixedExp )
            {
            // InternalOCLX.g:2322:1: ( rulePrefixedExp )
            // InternalOCLX.g:2323:2: rulePrefixedExp
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
    // InternalOCLX.g:2332:1: rule__Exp__Group__1 : rule__Exp__Group__1__Impl ;
    public final void rule__Exp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2336:1: ( rule__Exp__Group__1__Impl )
            // InternalOCLX.g:2337:2: rule__Exp__Group__1__Impl
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
    // InternalOCLX.g:2343:1: rule__Exp__Group__1__Impl : ( ( rule__Exp__Group_1__0 )? ) ;
    public final void rule__Exp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2347:1: ( ( ( rule__Exp__Group_1__0 )? ) )
            // InternalOCLX.g:2348:1: ( ( rule__Exp__Group_1__0 )? )
            {
            // InternalOCLX.g:2348:1: ( ( rule__Exp__Group_1__0 )? )
            // InternalOCLX.g:2349:2: ( rule__Exp__Group_1__0 )?
            {
             before(grammarAccess.getExpAccess().getGroup_1()); 
            // InternalOCLX.g:2350:2: ( rule__Exp__Group_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=13 && LA23_0<=26)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalOCLX.g:2350:3: rule__Exp__Group_1__0
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
    // InternalOCLX.g:2359:1: rule__Exp__Group_1__0 : rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 ;
    public final void rule__Exp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2363:1: ( rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 )
            // InternalOCLX.g:2364:2: rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1
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
    // InternalOCLX.g:2371:1: rule__Exp__Group_1__0__Impl : ( () ) ;
    public final void rule__Exp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2375:1: ( ( () ) )
            // InternalOCLX.g:2376:1: ( () )
            {
            // InternalOCLX.g:2376:1: ( () )
            // InternalOCLX.g:2377:2: ()
            {
             before(grammarAccess.getExpAccess().getInfixExpExpressionsAction_1_0()); 
            // InternalOCLX.g:2378:2: ()
            // InternalOCLX.g:2378:3: 
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
    // InternalOCLX.g:2386:1: rule__Exp__Group_1__1 : rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2 ;
    public final void rule__Exp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2390:1: ( rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2 )
            // InternalOCLX.g:2391:2: rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2
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
    // InternalOCLX.g:2398:1: rule__Exp__Group_1__1__Impl : ( ( rule__Exp__OperatorsAssignment_1_1 ) ) ;
    public final void rule__Exp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2402:1: ( ( ( rule__Exp__OperatorsAssignment_1_1 ) ) )
            // InternalOCLX.g:2403:1: ( ( rule__Exp__OperatorsAssignment_1_1 ) )
            {
            // InternalOCLX.g:2403:1: ( ( rule__Exp__OperatorsAssignment_1_1 ) )
            // InternalOCLX.g:2404:2: ( rule__Exp__OperatorsAssignment_1_1 )
            {
             before(grammarAccess.getExpAccess().getOperatorsAssignment_1_1()); 
            // InternalOCLX.g:2405:2: ( rule__Exp__OperatorsAssignment_1_1 )
            // InternalOCLX.g:2405:3: rule__Exp__OperatorsAssignment_1_1
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
    // InternalOCLX.g:2413:1: rule__Exp__Group_1__2 : rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3 ;
    public final void rule__Exp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2417:1: ( rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3 )
            // InternalOCLX.g:2418:2: rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3
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
    // InternalOCLX.g:2425:1: rule__Exp__Group_1__2__Impl : ( ( rule__Exp__ExpressionsAssignment_1_2 ) ) ;
    public final void rule__Exp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2429:1: ( ( ( rule__Exp__ExpressionsAssignment_1_2 ) ) )
            // InternalOCLX.g:2430:1: ( ( rule__Exp__ExpressionsAssignment_1_2 ) )
            {
            // InternalOCLX.g:2430:1: ( ( rule__Exp__ExpressionsAssignment_1_2 ) )
            // InternalOCLX.g:2431:2: ( rule__Exp__ExpressionsAssignment_1_2 )
            {
             before(grammarAccess.getExpAccess().getExpressionsAssignment_1_2()); 
            // InternalOCLX.g:2432:2: ( rule__Exp__ExpressionsAssignment_1_2 )
            // InternalOCLX.g:2432:3: rule__Exp__ExpressionsAssignment_1_2
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
    // InternalOCLX.g:2440:1: rule__Exp__Group_1__3 : rule__Exp__Group_1__3__Impl ;
    public final void rule__Exp__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2444:1: ( rule__Exp__Group_1__3__Impl )
            // InternalOCLX.g:2445:2: rule__Exp__Group_1__3__Impl
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
    // InternalOCLX.g:2451:1: rule__Exp__Group_1__3__Impl : ( ( rule__Exp__Group_1_3__0 )* ) ;
    public final void rule__Exp__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2455:1: ( ( ( rule__Exp__Group_1_3__0 )* ) )
            // InternalOCLX.g:2456:1: ( ( rule__Exp__Group_1_3__0 )* )
            {
            // InternalOCLX.g:2456:1: ( ( rule__Exp__Group_1_3__0 )* )
            // InternalOCLX.g:2457:2: ( rule__Exp__Group_1_3__0 )*
            {
             before(grammarAccess.getExpAccess().getGroup_1_3()); 
            // InternalOCLX.g:2458:2: ( rule__Exp__Group_1_3__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=13 && LA24_0<=26)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalOCLX.g:2458:3: rule__Exp__Group_1_3__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__Exp__Group_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalOCLX.g:2467:1: rule__Exp__Group_1_3__0 : rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1 ;
    public final void rule__Exp__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2471:1: ( rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1 )
            // InternalOCLX.g:2472:2: rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1
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
    // InternalOCLX.g:2479:1: rule__Exp__Group_1_3__0__Impl : ( ( rule__Exp__OperatorsAssignment_1_3_0 ) ) ;
    public final void rule__Exp__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2483:1: ( ( ( rule__Exp__OperatorsAssignment_1_3_0 ) ) )
            // InternalOCLX.g:2484:1: ( ( rule__Exp__OperatorsAssignment_1_3_0 ) )
            {
            // InternalOCLX.g:2484:1: ( ( rule__Exp__OperatorsAssignment_1_3_0 ) )
            // InternalOCLX.g:2485:2: ( rule__Exp__OperatorsAssignment_1_3_0 )
            {
             before(grammarAccess.getExpAccess().getOperatorsAssignment_1_3_0()); 
            // InternalOCLX.g:2486:2: ( rule__Exp__OperatorsAssignment_1_3_0 )
            // InternalOCLX.g:2486:3: rule__Exp__OperatorsAssignment_1_3_0
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
    // InternalOCLX.g:2494:1: rule__Exp__Group_1_3__1 : rule__Exp__Group_1_3__1__Impl ;
    public final void rule__Exp__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2498:1: ( rule__Exp__Group_1_3__1__Impl )
            // InternalOCLX.g:2499:2: rule__Exp__Group_1_3__1__Impl
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
    // InternalOCLX.g:2505:1: rule__Exp__Group_1_3__1__Impl : ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) ) ;
    public final void rule__Exp__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2509:1: ( ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) ) )
            // InternalOCLX.g:2510:1: ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) )
            {
            // InternalOCLX.g:2510:1: ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) )
            // InternalOCLX.g:2511:2: ( rule__Exp__ExpressionsAssignment_1_3_1 )
            {
             before(grammarAccess.getExpAccess().getExpressionsAssignment_1_3_1()); 
            // InternalOCLX.g:2512:2: ( rule__Exp__ExpressionsAssignment_1_3_1 )
            // InternalOCLX.g:2512:3: rule__Exp__ExpressionsAssignment_1_3_1
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
    // InternalOCLX.g:2521:1: rule__PrefixedExp__Group_0__0 : rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1 ;
    public final void rule__PrefixedExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2525:1: ( rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1 )
            // InternalOCLX.g:2526:2: rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1
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
    // InternalOCLX.g:2533:1: rule__PrefixedExp__Group_0__0__Impl : ( () ) ;
    public final void rule__PrefixedExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2537:1: ( ( () ) )
            // InternalOCLX.g:2538:1: ( () )
            {
            // InternalOCLX.g:2538:1: ( () )
            // InternalOCLX.g:2539:2: ()
            {
             before(grammarAccess.getPrefixedExpAccess().getPrefixExpAction_0_0()); 
            // InternalOCLX.g:2540:2: ()
            // InternalOCLX.g:2540:3: 
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
    // InternalOCLX.g:2548:1: rule__PrefixedExp__Group_0__1 : rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2 ;
    public final void rule__PrefixedExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2552:1: ( rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2 )
            // InternalOCLX.g:2553:2: rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2
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
    // InternalOCLX.g:2560:1: rule__PrefixedExp__Group_0__1__Impl : ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) ) ;
    public final void rule__PrefixedExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2564:1: ( ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) ) )
            // InternalOCLX.g:2565:1: ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) )
            {
            // InternalOCLX.g:2565:1: ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) )
            // InternalOCLX.g:2566:2: ( rule__PrefixedExp__OperatorAssignment_0_1 )
            {
             before(grammarAccess.getPrefixedExpAccess().getOperatorAssignment_0_1()); 
            // InternalOCLX.g:2567:2: ( rule__PrefixedExp__OperatorAssignment_0_1 )
            // InternalOCLX.g:2567:3: rule__PrefixedExp__OperatorAssignment_0_1
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
    // InternalOCLX.g:2575:1: rule__PrefixedExp__Group_0__2 : rule__PrefixedExp__Group_0__2__Impl ;
    public final void rule__PrefixedExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2579:1: ( rule__PrefixedExp__Group_0__2__Impl )
            // InternalOCLX.g:2580:2: rule__PrefixedExp__Group_0__2__Impl
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
    // InternalOCLX.g:2586:1: rule__PrefixedExp__Group_0__2__Impl : ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) ) ;
    public final void rule__PrefixedExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2590:1: ( ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) ) )
            // InternalOCLX.g:2591:1: ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) )
            {
            // InternalOCLX.g:2591:1: ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) )
            // InternalOCLX.g:2592:2: ( rule__PrefixedExp__ExpressionAssignment_0_2 )
            {
             before(grammarAccess.getPrefixedExpAccess().getExpressionAssignment_0_2()); 
            // InternalOCLX.g:2593:2: ( rule__PrefixedExp__ExpressionAssignment_0_2 )
            // InternalOCLX.g:2593:3: rule__PrefixedExp__ExpressionAssignment_0_2
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
    // InternalOCLX.g:2602:1: rule__PrimaryExp__Group_1__0 : rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1 ;
    public final void rule__PrimaryExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2606:1: ( rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1 )
            // InternalOCLX.g:2607:2: rule__PrimaryExp__Group_1__0__Impl rule__PrimaryExp__Group_1__1
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
    // InternalOCLX.g:2614:1: rule__PrimaryExp__Group_1__0__Impl : ( ruleVarOrSelfExp ) ;
    public final void rule__PrimaryExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2618:1: ( ( ruleVarOrSelfExp ) )
            // InternalOCLX.g:2619:1: ( ruleVarOrSelfExp )
            {
            // InternalOCLX.g:2619:1: ( ruleVarOrSelfExp )
            // InternalOCLX.g:2620:2: ruleVarOrSelfExp
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
    // InternalOCLX.g:2629:1: rule__PrimaryExp__Group_1__1 : rule__PrimaryExp__Group_1__1__Impl ;
    public final void rule__PrimaryExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2633:1: ( rule__PrimaryExp__Group_1__1__Impl )
            // InternalOCLX.g:2634:2: rule__PrimaryExp__Group_1__1__Impl
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
    // InternalOCLX.g:2640:1: rule__PrimaryExp__Group_1__1__Impl : ( ( rule__PrimaryExp__Group_1_1__0 )* ) ;
    public final void rule__PrimaryExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2644:1: ( ( ( rule__PrimaryExp__Group_1_1__0 )* ) )
            // InternalOCLX.g:2645:1: ( ( rule__PrimaryExp__Group_1_1__0 )* )
            {
            // InternalOCLX.g:2645:1: ( ( rule__PrimaryExp__Group_1_1__0 )* )
            // InternalOCLX.g:2646:2: ( rule__PrimaryExp__Group_1_1__0 )*
            {
             before(grammarAccess.getPrimaryExpAccess().getGroup_1_1()); 
            // InternalOCLX.g:2647:2: ( rule__PrimaryExp__Group_1_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=27 && LA25_0<=28)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalOCLX.g:2647:3: rule__PrimaryExp__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_20);
            	    rule__PrimaryExp__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalOCLX.g:2656:1: rule__PrimaryExp__Group_1_1__0 : rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1 ;
    public final void rule__PrimaryExp__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2660:1: ( rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1 )
            // InternalOCLX.g:2661:2: rule__PrimaryExp__Group_1_1__0__Impl rule__PrimaryExp__Group_1_1__1
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
    // InternalOCLX.g:2668:1: rule__PrimaryExp__Group_1_1__0__Impl : ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) ) ;
    public final void rule__PrimaryExp__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2672:1: ( ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) ) )
            // InternalOCLX.g:2673:1: ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) )
            {
            // InternalOCLX.g:2673:1: ( ( rule__PrimaryExp__NavAssignment_1_1_0 ) )
            // InternalOCLX.g:2674:2: ( rule__PrimaryExp__NavAssignment_1_1_0 )
            {
             before(grammarAccess.getPrimaryExpAccess().getNavAssignment_1_1_0()); 
            // InternalOCLX.g:2675:2: ( rule__PrimaryExp__NavAssignment_1_1_0 )
            // InternalOCLX.g:2675:3: rule__PrimaryExp__NavAssignment_1_1_0
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
    // InternalOCLX.g:2683:1: rule__PrimaryExp__Group_1_1__1 : rule__PrimaryExp__Group_1_1__1__Impl ;
    public final void rule__PrimaryExp__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2687:1: ( rule__PrimaryExp__Group_1_1__1__Impl )
            // InternalOCLX.g:2688:2: rule__PrimaryExp__Group_1_1__1__Impl
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
    // InternalOCLX.g:2694:1: rule__PrimaryExp__Group_1_1__1__Impl : ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) ) ;
    public final void rule__PrimaryExp__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2698:1: ( ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) ) )
            // InternalOCLX.g:2699:1: ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) )
            {
            // InternalOCLX.g:2699:1: ( ( rule__PrimaryExp__MethodsAssignment_1_1_1 ) )
            // InternalOCLX.g:2700:2: ( rule__PrimaryExp__MethodsAssignment_1_1_1 )
            {
             before(grammarAccess.getPrimaryExpAccess().getMethodsAssignment_1_1_1()); 
            // InternalOCLX.g:2701:2: ( rule__PrimaryExp__MethodsAssignment_1_1_1 )
            // InternalOCLX.g:2701:3: rule__PrimaryExp__MethodsAssignment_1_1_1
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
    // InternalOCLX.g:2710:1: rule__NestedExp__Group__0 : rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 ;
    public final void rule__NestedExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2714:1: ( rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 )
            // InternalOCLX.g:2715:2: rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1
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
    // InternalOCLX.g:2722:1: rule__NestedExp__Group__0__Impl : ( '(' ) ;
    public final void rule__NestedExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2726:1: ( ( '(' ) )
            // InternalOCLX.g:2727:1: ( '(' )
            {
            // InternalOCLX.g:2727:1: ( '(' )
            // InternalOCLX.g:2728:2: '('
            {
             before(grammarAccess.getNestedExpAccess().getLeftParenthesisKeyword_0()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:2737:1: rule__NestedExp__Group__1 : rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 ;
    public final void rule__NestedExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2741:1: ( rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 )
            // InternalOCLX.g:2742:2: rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2
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
    // InternalOCLX.g:2749:1: rule__NestedExp__Group__1__Impl : ( ( rule__NestedExp__SourceAssignment_1 ) ) ;
    public final void rule__NestedExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2753:1: ( ( ( rule__NestedExp__SourceAssignment_1 ) ) )
            // InternalOCLX.g:2754:1: ( ( rule__NestedExp__SourceAssignment_1 ) )
            {
            // InternalOCLX.g:2754:1: ( ( rule__NestedExp__SourceAssignment_1 ) )
            // InternalOCLX.g:2755:2: ( rule__NestedExp__SourceAssignment_1 )
            {
             before(grammarAccess.getNestedExpAccess().getSourceAssignment_1()); 
            // InternalOCLX.g:2756:2: ( rule__NestedExp__SourceAssignment_1 )
            // InternalOCLX.g:2756:3: rule__NestedExp__SourceAssignment_1
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
    // InternalOCLX.g:2764:1: rule__NestedExp__Group__2 : rule__NestedExp__Group__2__Impl ;
    public final void rule__NestedExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2768:1: ( rule__NestedExp__Group__2__Impl )
            // InternalOCLX.g:2769:2: rule__NestedExp__Group__2__Impl
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
    // InternalOCLX.g:2775:1: rule__NestedExp__Group__2__Impl : ( ')' ) ;
    public final void rule__NestedExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2779:1: ( ( ')' ) )
            // InternalOCLX.g:2780:1: ( ')' )
            {
            // InternalOCLX.g:2780:1: ( ')' )
            // InternalOCLX.g:2781:2: ')'
            {
             before(grammarAccess.getNestedExpAccess().getRightParenthesisKeyword_2()); 
            match(input,50,FOLLOW_2); 
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
    // InternalOCLX.g:2791:1: rule__SelfExp__Group__0 : rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1 ;
    public final void rule__SelfExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2795:1: ( rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1 )
            // InternalOCLX.g:2796:2: rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1
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
    // InternalOCLX.g:2803:1: rule__SelfExp__Group__0__Impl : ( () ) ;
    public final void rule__SelfExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2807:1: ( ( () ) )
            // InternalOCLX.g:2808:1: ( () )
            {
            // InternalOCLX.g:2808:1: ( () )
            // InternalOCLX.g:2809:2: ()
            {
             before(grammarAccess.getSelfExpAccess().getSelfExpAction_0()); 
            // InternalOCLX.g:2810:2: ()
            // InternalOCLX.g:2810:3: 
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
    // InternalOCLX.g:2818:1: rule__SelfExp__Group__1 : rule__SelfExp__Group__1__Impl ;
    public final void rule__SelfExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2822:1: ( rule__SelfExp__Group__1__Impl )
            // InternalOCLX.g:2823:2: rule__SelfExp__Group__1__Impl
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
    // InternalOCLX.g:2829:1: rule__SelfExp__Group__1__Impl : ( ( rule__SelfExp__NameAssignment_1 ) ) ;
    public final void rule__SelfExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2833:1: ( ( ( rule__SelfExp__NameAssignment_1 ) ) )
            // InternalOCLX.g:2834:1: ( ( rule__SelfExp__NameAssignment_1 ) )
            {
            // InternalOCLX.g:2834:1: ( ( rule__SelfExp__NameAssignment_1 ) )
            // InternalOCLX.g:2835:2: ( rule__SelfExp__NameAssignment_1 )
            {
             before(grammarAccess.getSelfExpAccess().getNameAssignment_1()); 
            // InternalOCLX.g:2836:2: ( rule__SelfExp__NameAssignment_1 )
            // InternalOCLX.g:2836:3: rule__SelfExp__NameAssignment_1
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
    // InternalOCLX.g:2845:1: rule__CollectionIterator__Group__0 : rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 ;
    public final void rule__CollectionIterator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2849:1: ( rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 )
            // InternalOCLX.g:2850:2: rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1
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
    // InternalOCLX.g:2857:1: rule__CollectionIterator__Group__0__Impl : ( ( rule__CollectionIterator__NameAssignment_0 ) ) ;
    public final void rule__CollectionIterator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2861:1: ( ( ( rule__CollectionIterator__NameAssignment_0 ) ) )
            // InternalOCLX.g:2862:1: ( ( rule__CollectionIterator__NameAssignment_0 ) )
            {
            // InternalOCLX.g:2862:1: ( ( rule__CollectionIterator__NameAssignment_0 ) )
            // InternalOCLX.g:2863:2: ( rule__CollectionIterator__NameAssignment_0 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getNameAssignment_0()); 
            // InternalOCLX.g:2864:2: ( rule__CollectionIterator__NameAssignment_0 )
            // InternalOCLX.g:2864:3: rule__CollectionIterator__NameAssignment_0
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
    // InternalOCLX.g:2872:1: rule__CollectionIterator__Group__1 : rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 ;
    public final void rule__CollectionIterator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2876:1: ( rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 )
            // InternalOCLX.g:2877:2: rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2
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
    // InternalOCLX.g:2884:1: rule__CollectionIterator__Group__1__Impl : ( '(' ) ;
    public final void rule__CollectionIterator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2888:1: ( ( '(' ) )
            // InternalOCLX.g:2889:1: ( '(' )
            {
            // InternalOCLX.g:2889:1: ( '(' )
            // InternalOCLX.g:2890:2: '('
            {
             before(grammarAccess.getCollectionIteratorAccess().getLeftParenthesisKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:2899:1: rule__CollectionIterator__Group__2 : rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 ;
    public final void rule__CollectionIterator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2903:1: ( rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 )
            // InternalOCLX.g:2904:2: rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3
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
    // InternalOCLX.g:2911:1: rule__CollectionIterator__Group__2__Impl : ( ( rule__CollectionIterator__ItervarAssignment_2 ) ) ;
    public final void rule__CollectionIterator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2915:1: ( ( ( rule__CollectionIterator__ItervarAssignment_2 ) ) )
            // InternalOCLX.g:2916:1: ( ( rule__CollectionIterator__ItervarAssignment_2 ) )
            {
            // InternalOCLX.g:2916:1: ( ( rule__CollectionIterator__ItervarAssignment_2 ) )
            // InternalOCLX.g:2917:2: ( rule__CollectionIterator__ItervarAssignment_2 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getItervarAssignment_2()); 
            // InternalOCLX.g:2918:2: ( rule__CollectionIterator__ItervarAssignment_2 )
            // InternalOCLX.g:2918:3: rule__CollectionIterator__ItervarAssignment_2
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
    // InternalOCLX.g:2926:1: rule__CollectionIterator__Group__3 : rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4 ;
    public final void rule__CollectionIterator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2930:1: ( rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4 )
            // InternalOCLX.g:2931:2: rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4
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
    // InternalOCLX.g:2938:1: rule__CollectionIterator__Group__3__Impl : ( '|' ) ;
    public final void rule__CollectionIterator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2942:1: ( ( '|' ) )
            // InternalOCLX.g:2943:1: ( '|' )
            {
            // InternalOCLX.g:2943:1: ( '|' )
            // InternalOCLX.g:2944:2: '|'
            {
             before(grammarAccess.getCollectionIteratorAccess().getVerticalLineKeyword_3()); 
            match(input,51,FOLLOW_2); 
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
    // InternalOCLX.g:2953:1: rule__CollectionIterator__Group__4 : rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5 ;
    public final void rule__CollectionIterator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2957:1: ( rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5 )
            // InternalOCLX.g:2958:2: rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5
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
    // InternalOCLX.g:2965:1: rule__CollectionIterator__Group__4__Impl : ( ( rule__CollectionIterator__BodyAssignment_4 ) ) ;
    public final void rule__CollectionIterator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2969:1: ( ( ( rule__CollectionIterator__BodyAssignment_4 ) ) )
            // InternalOCLX.g:2970:1: ( ( rule__CollectionIterator__BodyAssignment_4 ) )
            {
            // InternalOCLX.g:2970:1: ( ( rule__CollectionIterator__BodyAssignment_4 ) )
            // InternalOCLX.g:2971:2: ( rule__CollectionIterator__BodyAssignment_4 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getBodyAssignment_4()); 
            // InternalOCLX.g:2972:2: ( rule__CollectionIterator__BodyAssignment_4 )
            // InternalOCLX.g:2972:3: rule__CollectionIterator__BodyAssignment_4
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
    // InternalOCLX.g:2980:1: rule__CollectionIterator__Group__5 : rule__CollectionIterator__Group__5__Impl ;
    public final void rule__CollectionIterator__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2984:1: ( rule__CollectionIterator__Group__5__Impl )
            // InternalOCLX.g:2985:2: rule__CollectionIterator__Group__5__Impl
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
    // InternalOCLX.g:2991:1: rule__CollectionIterator__Group__5__Impl : ( ')' ) ;
    public final void rule__CollectionIterator__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2995:1: ( ( ')' ) )
            // InternalOCLX.g:2996:1: ( ')' )
            {
            // InternalOCLX.g:2996:1: ( ')' )
            // InternalOCLX.g:2997:2: ')'
            {
             before(grammarAccess.getCollectionIteratorAccess().getRightParenthesisKeyword_5()); 
            match(input,50,FOLLOW_2); 
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
    // InternalOCLX.g:3007:1: rule__IteratorVarDeclaration__Group_1__0 : rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1 ;
    public final void rule__IteratorVarDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3011:1: ( rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1 )
            // InternalOCLX.g:3012:2: rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1
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
    // InternalOCLX.g:3019:1: rule__IteratorVarDeclaration__Group_1__0__Impl : ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) ) ;
    public final void rule__IteratorVarDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3023:1: ( ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) ) )
            // InternalOCLX.g:3024:1: ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) )
            {
            // InternalOCLX.g:3024:1: ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) )
            // InternalOCLX.g:3025:2: ( rule__IteratorVarDeclaration__NameAssignment_1_0 )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_1_0()); 
            // InternalOCLX.g:3026:2: ( rule__IteratorVarDeclaration__NameAssignment_1_0 )
            // InternalOCLX.g:3026:3: rule__IteratorVarDeclaration__NameAssignment_1_0
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
    // InternalOCLX.g:3034:1: rule__IteratorVarDeclaration__Group_1__1 : rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2 ;
    public final void rule__IteratorVarDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3038:1: ( rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2 )
            // InternalOCLX.g:3039:2: rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2
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
    // InternalOCLX.g:3046:1: rule__IteratorVarDeclaration__Group_1__1__Impl : ( ':' ) ;
    public final void rule__IteratorVarDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3050:1: ( ( ':' ) )
            // InternalOCLX.g:3051:1: ( ':' )
            {
            // InternalOCLX.g:3051:1: ( ':' )
            // InternalOCLX.g:3052:2: ':'
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getColonKeyword_1_1()); 
            match(input,52,FOLLOW_2); 
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
    // InternalOCLX.g:3061:1: rule__IteratorVarDeclaration__Group_1__2 : rule__IteratorVarDeclaration__Group_1__2__Impl ;
    public final void rule__IteratorVarDeclaration__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3065:1: ( rule__IteratorVarDeclaration__Group_1__2__Impl )
            // InternalOCLX.g:3066:2: rule__IteratorVarDeclaration__Group_1__2__Impl
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
    // InternalOCLX.g:3072:1: rule__IteratorVarDeclaration__Group_1__2__Impl : ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) ) ;
    public final void rule__IteratorVarDeclaration__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3076:1: ( ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) ) )
            // InternalOCLX.g:3077:1: ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) )
            {
            // InternalOCLX.g:3077:1: ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) )
            // InternalOCLX.g:3078:2: ( rule__IteratorVarDeclaration__TypeAssignment_1_2 )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getTypeAssignment_1_2()); 
            // InternalOCLX.g:3079:2: ( rule__IteratorVarDeclaration__TypeAssignment_1_2 )
            // InternalOCLX.g:3079:3: rule__IteratorVarDeclaration__TypeAssignment_1_2
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
    // InternalOCLX.g:3088:1: rule__MethodCall__Group_0__0 : rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1 ;
    public final void rule__MethodCall__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3092:1: ( rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1 )
            // InternalOCLX.g:3093:2: rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1
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
    // InternalOCLX.g:3100:1: rule__MethodCall__Group_0__0__Impl : ( ( rule__MethodCall__NameAssignment_0_0 ) ) ;
    public final void rule__MethodCall__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3104:1: ( ( ( rule__MethodCall__NameAssignment_0_0 ) ) )
            // InternalOCLX.g:3105:1: ( ( rule__MethodCall__NameAssignment_0_0 ) )
            {
            // InternalOCLX.g:3105:1: ( ( rule__MethodCall__NameAssignment_0_0 ) )
            // InternalOCLX.g:3106:2: ( rule__MethodCall__NameAssignment_0_0 )
            {
             before(grammarAccess.getMethodCallAccess().getNameAssignment_0_0()); 
            // InternalOCLX.g:3107:2: ( rule__MethodCall__NameAssignment_0_0 )
            // InternalOCLX.g:3107:3: rule__MethodCall__NameAssignment_0_0
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
    // InternalOCLX.g:3115:1: rule__MethodCall__Group_0__1 : rule__MethodCall__Group_0__1__Impl ;
    public final void rule__MethodCall__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3119:1: ( rule__MethodCall__Group_0__1__Impl )
            // InternalOCLX.g:3120:2: rule__MethodCall__Group_0__1__Impl
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
    // InternalOCLX.g:3126:1: rule__MethodCall__Group_0__1__Impl : ( '()' ) ;
    public final void rule__MethodCall__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3130:1: ( ( '()' ) )
            // InternalOCLX.g:3131:1: ( '()' )
            {
            // InternalOCLX.g:3131:1: ( '()' )
            // InternalOCLX.g:3132:2: '()'
            {
             before(grammarAccess.getMethodCallAccess().getLeftParenthesisRightParenthesisKeyword_0_1()); 
            match(input,53,FOLLOW_2); 
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
    // InternalOCLX.g:3142:1: rule__MethodCall__Group_1__0 : rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1 ;
    public final void rule__MethodCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3146:1: ( rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1 )
            // InternalOCLX.g:3147:2: rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1
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
    // InternalOCLX.g:3154:1: rule__MethodCall__Group_1__0__Impl : ( ( rule__MethodCall__NameAssignment_1_0 ) ) ;
    public final void rule__MethodCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3158:1: ( ( ( rule__MethodCall__NameAssignment_1_0 ) ) )
            // InternalOCLX.g:3159:1: ( ( rule__MethodCall__NameAssignment_1_0 ) )
            {
            // InternalOCLX.g:3159:1: ( ( rule__MethodCall__NameAssignment_1_0 ) )
            // InternalOCLX.g:3160:2: ( rule__MethodCall__NameAssignment_1_0 )
            {
             before(grammarAccess.getMethodCallAccess().getNameAssignment_1_0()); 
            // InternalOCLX.g:3161:2: ( rule__MethodCall__NameAssignment_1_0 )
            // InternalOCLX.g:3161:3: rule__MethodCall__NameAssignment_1_0
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
    // InternalOCLX.g:3169:1: rule__MethodCall__Group_1__1 : rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2 ;
    public final void rule__MethodCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3173:1: ( rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2 )
            // InternalOCLX.g:3174:2: rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2
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
    // InternalOCLX.g:3181:1: rule__MethodCall__Group_1__1__Impl : ( '(' ) ;
    public final void rule__MethodCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3185:1: ( ( '(' ) )
            // InternalOCLX.g:3186:1: ( '(' )
            {
            // InternalOCLX.g:3186:1: ( '(' )
            // InternalOCLX.g:3187:2: '('
            {
             before(grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_1_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:3196:1: rule__MethodCall__Group_1__2 : rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3 ;
    public final void rule__MethodCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3200:1: ( rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3 )
            // InternalOCLX.g:3201:2: rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3
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
    // InternalOCLX.g:3208:1: rule__MethodCall__Group_1__2__Impl : ( ( rule__MethodCall__ArgsAssignment_1_2 ) ) ;
    public final void rule__MethodCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3212:1: ( ( ( rule__MethodCall__ArgsAssignment_1_2 ) ) )
            // InternalOCLX.g:3213:1: ( ( rule__MethodCall__ArgsAssignment_1_2 ) )
            {
            // InternalOCLX.g:3213:1: ( ( rule__MethodCall__ArgsAssignment_1_2 ) )
            // InternalOCLX.g:3214:2: ( rule__MethodCall__ArgsAssignment_1_2 )
            {
             before(grammarAccess.getMethodCallAccess().getArgsAssignment_1_2()); 
            // InternalOCLX.g:3215:2: ( rule__MethodCall__ArgsAssignment_1_2 )
            // InternalOCLX.g:3215:3: rule__MethodCall__ArgsAssignment_1_2
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
    // InternalOCLX.g:3223:1: rule__MethodCall__Group_1__3 : rule__MethodCall__Group_1__3__Impl ;
    public final void rule__MethodCall__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3227:1: ( rule__MethodCall__Group_1__3__Impl )
            // InternalOCLX.g:3228:2: rule__MethodCall__Group_1__3__Impl
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
    // InternalOCLX.g:3234:1: rule__MethodCall__Group_1__3__Impl : ( ')' ) ;
    public final void rule__MethodCall__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3238:1: ( ( ')' ) )
            // InternalOCLX.g:3239:1: ( ')' )
            {
            // InternalOCLX.g:3239:1: ( ')' )
            // InternalOCLX.g:3240:2: ')'
            {
             before(grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_1_3()); 
            match(input,50,FOLLOW_2); 
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
    // InternalOCLX.g:3250:1: rule__TypeCall__Group__0 : rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1 ;
    public final void rule__TypeCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3254:1: ( rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1 )
            // InternalOCLX.g:3255:2: rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1
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
    // InternalOCLX.g:3262:1: rule__TypeCall__Group__0__Impl : ( ( rule__TypeCall__NameAssignment_0 ) ) ;
    public final void rule__TypeCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3266:1: ( ( ( rule__TypeCall__NameAssignment_0 ) ) )
            // InternalOCLX.g:3267:1: ( ( rule__TypeCall__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3267:1: ( ( rule__TypeCall__NameAssignment_0 ) )
            // InternalOCLX.g:3268:2: ( rule__TypeCall__NameAssignment_0 )
            {
             before(grammarAccess.getTypeCallAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3269:2: ( rule__TypeCall__NameAssignment_0 )
            // InternalOCLX.g:3269:3: rule__TypeCall__NameAssignment_0
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
    // InternalOCLX.g:3277:1: rule__TypeCall__Group__1 : rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2 ;
    public final void rule__TypeCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3281:1: ( rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2 )
            // InternalOCLX.g:3282:2: rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2
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
    // InternalOCLX.g:3289:1: rule__TypeCall__Group__1__Impl : ( '(' ) ;
    public final void rule__TypeCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3293:1: ( ( '(' ) )
            // InternalOCLX.g:3294:1: ( '(' )
            {
            // InternalOCLX.g:3294:1: ( '(' )
            // InternalOCLX.g:3295:2: '('
            {
             before(grammarAccess.getTypeCallAccess().getLeftParenthesisKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:3304:1: rule__TypeCall__Group__2 : rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3 ;
    public final void rule__TypeCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3308:1: ( rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3 )
            // InternalOCLX.g:3309:2: rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3
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
    // InternalOCLX.g:3316:1: rule__TypeCall__Group__2__Impl : ( ( rule__TypeCall__TypeAssignment_2 ) ) ;
    public final void rule__TypeCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3320:1: ( ( ( rule__TypeCall__TypeAssignment_2 ) ) )
            // InternalOCLX.g:3321:1: ( ( rule__TypeCall__TypeAssignment_2 ) )
            {
            // InternalOCLX.g:3321:1: ( ( rule__TypeCall__TypeAssignment_2 ) )
            // InternalOCLX.g:3322:2: ( rule__TypeCall__TypeAssignment_2 )
            {
             before(grammarAccess.getTypeCallAccess().getTypeAssignment_2()); 
            // InternalOCLX.g:3323:2: ( rule__TypeCall__TypeAssignment_2 )
            // InternalOCLX.g:3323:3: rule__TypeCall__TypeAssignment_2
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
    // InternalOCLX.g:3331:1: rule__TypeCall__Group__3 : rule__TypeCall__Group__3__Impl ;
    public final void rule__TypeCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3335:1: ( rule__TypeCall__Group__3__Impl )
            // InternalOCLX.g:3336:2: rule__TypeCall__Group__3__Impl
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
    // InternalOCLX.g:3342:1: rule__TypeCall__Group__3__Impl : ( ')' ) ;
    public final void rule__TypeCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3346:1: ( ( ')' ) )
            // InternalOCLX.g:3347:1: ( ')' )
            {
            // InternalOCLX.g:3347:1: ( ')' )
            // InternalOCLX.g:3348:2: ')'
            {
             before(grammarAccess.getTypeCallAccess().getRightParenthesisKeyword_3()); 
            match(input,50,FOLLOW_2); 
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


    // $ANTLR start "rule__TypeExp__Group__0"
    // InternalOCLX.g:3358:1: rule__TypeExp__Group__0 : rule__TypeExp__Group__0__Impl rule__TypeExp__Group__1 ;
    public final void rule__TypeExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3362:1: ( rule__TypeExp__Group__0__Impl rule__TypeExp__Group__1 )
            // InternalOCLX.g:3363:2: rule__TypeExp__Group__0__Impl rule__TypeExp__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__TypeExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TypeExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group__0"


    // $ANTLR start "rule__TypeExp__Group__0__Impl"
    // InternalOCLX.g:3370:1: rule__TypeExp__Group__0__Impl : ( () ) ;
    public final void rule__TypeExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3374:1: ( ( () ) )
            // InternalOCLX.g:3375:1: ( () )
            {
            // InternalOCLX.g:3375:1: ( () )
            // InternalOCLX.g:3376:2: ()
            {
             before(grammarAccess.getTypeExpAccess().getTypeExpAction_0()); 
            // InternalOCLX.g:3377:2: ()
            // InternalOCLX.g:3377:3: 
            {
            }

             after(grammarAccess.getTypeExpAccess().getTypeExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group__0__Impl"


    // $ANTLR start "rule__TypeExp__Group__1"
    // InternalOCLX.g:3385:1: rule__TypeExp__Group__1 : rule__TypeExp__Group__1__Impl ;
    public final void rule__TypeExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3389:1: ( rule__TypeExp__Group__1__Impl )
            // InternalOCLX.g:3390:2: rule__TypeExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TypeExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group__1"


    // $ANTLR start "rule__TypeExp__Group__1__Impl"
    // InternalOCLX.g:3396:1: rule__TypeExp__Group__1__Impl : ( ( rule__TypeExp__NameAssignment_1 ) ) ;
    public final void rule__TypeExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3400:1: ( ( ( rule__TypeExp__NameAssignment_1 ) ) )
            // InternalOCLX.g:3401:1: ( ( rule__TypeExp__NameAssignment_1 ) )
            {
            // InternalOCLX.g:3401:1: ( ( rule__TypeExp__NameAssignment_1 ) )
            // InternalOCLX.g:3402:2: ( rule__TypeExp__NameAssignment_1 )
            {
             before(grammarAccess.getTypeExpAccess().getNameAssignment_1()); 
            // InternalOCLX.g:3403:2: ( rule__TypeExp__NameAssignment_1 )
            // InternalOCLX.g:3403:3: rule__TypeExp__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TypeExp__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTypeExpAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__Group__1__Impl"


    // $ANTLR start "rule__UnaryTemporalExp__Group__0"
    // InternalOCLX.g:3412:1: rule__UnaryTemporalExp__Group__0 : rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1 ;
    public final void rule__UnaryTemporalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3416:1: ( rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1 )
            // InternalOCLX.g:3417:2: rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1
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
    // InternalOCLX.g:3424:1: rule__UnaryTemporalExp__Group__0__Impl : ( ( rule__UnaryTemporalExp__NameAssignment_0 ) ) ;
    public final void rule__UnaryTemporalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3428:1: ( ( ( rule__UnaryTemporalExp__NameAssignment_0 ) ) )
            // InternalOCLX.g:3429:1: ( ( rule__UnaryTemporalExp__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3429:1: ( ( rule__UnaryTemporalExp__NameAssignment_0 ) )
            // InternalOCLX.g:3430:2: ( rule__UnaryTemporalExp__NameAssignment_0 )
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3431:2: ( rule__UnaryTemporalExp__NameAssignment_0 )
            // InternalOCLX.g:3431:3: rule__UnaryTemporalExp__NameAssignment_0
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
    // InternalOCLX.g:3439:1: rule__UnaryTemporalExp__Group__1 : rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2 ;
    public final void rule__UnaryTemporalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3443:1: ( rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2 )
            // InternalOCLX.g:3444:2: rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2
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
    // InternalOCLX.g:3451:1: rule__UnaryTemporalExp__Group__1__Impl : ( '(' ) ;
    public final void rule__UnaryTemporalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3455:1: ( ( '(' ) )
            // InternalOCLX.g:3456:1: ( '(' )
            {
            // InternalOCLX.g:3456:1: ( '(' )
            // InternalOCLX.g:3457:2: '('
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getLeftParenthesisKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:3466:1: rule__UnaryTemporalExp__Group__2 : rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3 ;
    public final void rule__UnaryTemporalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3470:1: ( rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3 )
            // InternalOCLX.g:3471:2: rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3
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
    // InternalOCLX.g:3478:1: rule__UnaryTemporalExp__Group__2__Impl : ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) ) ;
    public final void rule__UnaryTemporalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3482:1: ( ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) ) )
            // InternalOCLX.g:3483:1: ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) )
            {
            // InternalOCLX.g:3483:1: ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) )
            // InternalOCLX.g:3484:2: ( rule__UnaryTemporalExp__ExpAssignment_2 )
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getExpAssignment_2()); 
            // InternalOCLX.g:3485:2: ( rule__UnaryTemporalExp__ExpAssignment_2 )
            // InternalOCLX.g:3485:3: rule__UnaryTemporalExp__ExpAssignment_2
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
    // InternalOCLX.g:3493:1: rule__UnaryTemporalExp__Group__3 : rule__UnaryTemporalExp__Group__3__Impl ;
    public final void rule__UnaryTemporalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3497:1: ( rule__UnaryTemporalExp__Group__3__Impl )
            // InternalOCLX.g:3498:2: rule__UnaryTemporalExp__Group__3__Impl
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
    // InternalOCLX.g:3504:1: rule__UnaryTemporalExp__Group__3__Impl : ( ')' ) ;
    public final void rule__UnaryTemporalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3508:1: ( ( ')' ) )
            // InternalOCLX.g:3509:1: ( ')' )
            {
            // InternalOCLX.g:3509:1: ( ')' )
            // InternalOCLX.g:3510:2: ')'
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getRightParenthesisKeyword_3()); 
            match(input,50,FOLLOW_2); 
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
    // InternalOCLX.g:3520:1: rule__TemporalAsLongAs__Group__0 : rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1 ;
    public final void rule__TemporalAsLongAs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3524:1: ( rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1 )
            // InternalOCLX.g:3525:2: rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1
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
    // InternalOCLX.g:3532:1: rule__TemporalAsLongAs__Group__0__Impl : ( ( rule__TemporalAsLongAs__NameAssignment_0 ) ) ;
    public final void rule__TemporalAsLongAs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3536:1: ( ( ( rule__TemporalAsLongAs__NameAssignment_0 ) ) )
            // InternalOCLX.g:3537:1: ( ( rule__TemporalAsLongAs__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3537:1: ( ( rule__TemporalAsLongAs__NameAssignment_0 ) )
            // InternalOCLX.g:3538:2: ( rule__TemporalAsLongAs__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3539:2: ( rule__TemporalAsLongAs__NameAssignment_0 )
            // InternalOCLX.g:3539:3: rule__TemporalAsLongAs__NameAssignment_0
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
    // InternalOCLX.g:3547:1: rule__TemporalAsLongAs__Group__1 : rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2 ;
    public final void rule__TemporalAsLongAs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3551:1: ( rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2 )
            // InternalOCLX.g:3552:2: rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2
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
    // InternalOCLX.g:3559:1: rule__TemporalAsLongAs__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalAsLongAs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3563:1: ( ( '(' ) )
            // InternalOCLX.g:3564:1: ( '(' )
            {
            // InternalOCLX.g:3564:1: ( '(' )
            // InternalOCLX.g:3565:2: '('
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getLeftParenthesisKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:3574:1: rule__TemporalAsLongAs__Group__2 : rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3 ;
    public final void rule__TemporalAsLongAs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3578:1: ( rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3 )
            // InternalOCLX.g:3579:2: rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3
            {
            pushFollow(FOLLOW_29);
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
    // InternalOCLX.g:3586:1: rule__TemporalAsLongAs__Group__2__Impl : ( ( rule__TemporalAsLongAs__BAssignment_2 ) ) ;
    public final void rule__TemporalAsLongAs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3590:1: ( ( ( rule__TemporalAsLongAs__BAssignment_2 ) ) )
            // InternalOCLX.g:3591:1: ( ( rule__TemporalAsLongAs__BAssignment_2 ) )
            {
            // InternalOCLX.g:3591:1: ( ( rule__TemporalAsLongAs__BAssignment_2 ) )
            // InternalOCLX.g:3592:2: ( rule__TemporalAsLongAs__BAssignment_2 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getBAssignment_2()); 
            // InternalOCLX.g:3593:2: ( rule__TemporalAsLongAs__BAssignment_2 )
            // InternalOCLX.g:3593:3: rule__TemporalAsLongAs__BAssignment_2
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
    // InternalOCLX.g:3601:1: rule__TemporalAsLongAs__Group__3 : rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4 ;
    public final void rule__TemporalAsLongAs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3605:1: ( rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4 )
            // InternalOCLX.g:3606:2: rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4
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
    // InternalOCLX.g:3613:1: rule__TemporalAsLongAs__Group__3__Impl : ( 'ensureThat' ) ;
    public final void rule__TemporalAsLongAs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3617:1: ( ( 'ensureThat' ) )
            // InternalOCLX.g:3618:1: ( 'ensureThat' )
            {
            // InternalOCLX.g:3618:1: ( 'ensureThat' )
            // InternalOCLX.g:3619:2: 'ensureThat'
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getEnsureThatKeyword_3()); 
            match(input,54,FOLLOW_2); 
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
    // InternalOCLX.g:3628:1: rule__TemporalAsLongAs__Group__4 : rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5 ;
    public final void rule__TemporalAsLongAs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3632:1: ( rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5 )
            // InternalOCLX.g:3633:2: rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5
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
    // InternalOCLX.g:3640:1: rule__TemporalAsLongAs__Group__4__Impl : ( ( rule__TemporalAsLongAs__AAssignment_4 ) ) ;
    public final void rule__TemporalAsLongAs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3644:1: ( ( ( rule__TemporalAsLongAs__AAssignment_4 ) ) )
            // InternalOCLX.g:3645:1: ( ( rule__TemporalAsLongAs__AAssignment_4 ) )
            {
            // InternalOCLX.g:3645:1: ( ( rule__TemporalAsLongAs__AAssignment_4 ) )
            // InternalOCLX.g:3646:2: ( rule__TemporalAsLongAs__AAssignment_4 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getAAssignment_4()); 
            // InternalOCLX.g:3647:2: ( rule__TemporalAsLongAs__AAssignment_4 )
            // InternalOCLX.g:3647:3: rule__TemporalAsLongAs__AAssignment_4
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
    // InternalOCLX.g:3655:1: rule__TemporalAsLongAs__Group__5 : rule__TemporalAsLongAs__Group__5__Impl ;
    public final void rule__TemporalAsLongAs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3659:1: ( rule__TemporalAsLongAs__Group__5__Impl )
            // InternalOCLX.g:3660:2: rule__TemporalAsLongAs__Group__5__Impl
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
    // InternalOCLX.g:3666:1: rule__TemporalAsLongAs__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalAsLongAs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3670:1: ( ( ')' ) )
            // InternalOCLX.g:3671:1: ( ')' )
            {
            // InternalOCLX.g:3671:1: ( ')' )
            // InternalOCLX.g:3672:2: ')'
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getRightParenthesisKeyword_5()); 
            match(input,50,FOLLOW_2); 
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
    // InternalOCLX.g:3682:1: rule__TemporalUntil__Group__0 : rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1 ;
    public final void rule__TemporalUntil__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3686:1: ( rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1 )
            // InternalOCLX.g:3687:2: rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1
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
    // InternalOCLX.g:3694:1: rule__TemporalUntil__Group__0__Impl : ( ( rule__TemporalUntil__NameAssignment_0 ) ) ;
    public final void rule__TemporalUntil__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3698:1: ( ( ( rule__TemporalUntil__NameAssignment_0 ) ) )
            // InternalOCLX.g:3699:1: ( ( rule__TemporalUntil__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3699:1: ( ( rule__TemporalUntil__NameAssignment_0 ) )
            // InternalOCLX.g:3700:2: ( rule__TemporalUntil__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalUntilAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3701:2: ( rule__TemporalUntil__NameAssignment_0 )
            // InternalOCLX.g:3701:3: rule__TemporalUntil__NameAssignment_0
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
    // InternalOCLX.g:3709:1: rule__TemporalUntil__Group__1 : rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2 ;
    public final void rule__TemporalUntil__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3713:1: ( rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2 )
            // InternalOCLX.g:3714:2: rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2
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
    // InternalOCLX.g:3721:1: rule__TemporalUntil__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalUntil__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3725:1: ( ( '(' ) )
            // InternalOCLX.g:3726:1: ( '(' )
            {
            // InternalOCLX.g:3726:1: ( '(' )
            // InternalOCLX.g:3727:2: '('
            {
             before(grammarAccess.getTemporalUntilAccess().getLeftParenthesisKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:3736:1: rule__TemporalUntil__Group__2 : rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3 ;
    public final void rule__TemporalUntil__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3740:1: ( rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3 )
            // InternalOCLX.g:3741:2: rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalOCLX.g:3748:1: rule__TemporalUntil__Group__2__Impl : ( ( rule__TemporalUntil__AAssignment_2 ) ) ;
    public final void rule__TemporalUntil__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3752:1: ( ( ( rule__TemporalUntil__AAssignment_2 ) ) )
            // InternalOCLX.g:3753:1: ( ( rule__TemporalUntil__AAssignment_2 ) )
            {
            // InternalOCLX.g:3753:1: ( ( rule__TemporalUntil__AAssignment_2 ) )
            // InternalOCLX.g:3754:2: ( rule__TemporalUntil__AAssignment_2 )
            {
             before(grammarAccess.getTemporalUntilAccess().getAAssignment_2()); 
            // InternalOCLX.g:3755:2: ( rule__TemporalUntil__AAssignment_2 )
            // InternalOCLX.g:3755:3: rule__TemporalUntil__AAssignment_2
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
    // InternalOCLX.g:3763:1: rule__TemporalUntil__Group__3 : rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4 ;
    public final void rule__TemporalUntil__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3767:1: ( rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4 )
            // InternalOCLX.g:3768:2: rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4
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
    // InternalOCLX.g:3775:1: rule__TemporalUntil__Group__3__Impl : ( 'asLongAs' ) ;
    public final void rule__TemporalUntil__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3779:1: ( ( 'asLongAs' ) )
            // InternalOCLX.g:3780:1: ( 'asLongAs' )
            {
            // InternalOCLX.g:3780:1: ( 'asLongAs' )
            // InternalOCLX.g:3781:2: 'asLongAs'
            {
             before(grammarAccess.getTemporalUntilAccess().getAsLongAsKeyword_3()); 
            match(input,55,FOLLOW_2); 
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
    // InternalOCLX.g:3790:1: rule__TemporalUntil__Group__4 : rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5 ;
    public final void rule__TemporalUntil__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3794:1: ( rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5 )
            // InternalOCLX.g:3795:2: rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5
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
    // InternalOCLX.g:3802:1: rule__TemporalUntil__Group__4__Impl : ( ( rule__TemporalUntil__BAssignment_4 ) ) ;
    public final void rule__TemporalUntil__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3806:1: ( ( ( rule__TemporalUntil__BAssignment_4 ) ) )
            // InternalOCLX.g:3807:1: ( ( rule__TemporalUntil__BAssignment_4 ) )
            {
            // InternalOCLX.g:3807:1: ( ( rule__TemporalUntil__BAssignment_4 ) )
            // InternalOCLX.g:3808:2: ( rule__TemporalUntil__BAssignment_4 )
            {
             before(grammarAccess.getTemporalUntilAccess().getBAssignment_4()); 
            // InternalOCLX.g:3809:2: ( rule__TemporalUntil__BAssignment_4 )
            // InternalOCLX.g:3809:3: rule__TemporalUntil__BAssignment_4
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
    // InternalOCLX.g:3817:1: rule__TemporalUntil__Group__5 : rule__TemporalUntil__Group__5__Impl ;
    public final void rule__TemporalUntil__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3821:1: ( rule__TemporalUntil__Group__5__Impl )
            // InternalOCLX.g:3822:2: rule__TemporalUntil__Group__5__Impl
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
    // InternalOCLX.g:3828:1: rule__TemporalUntil__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalUntil__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3832:1: ( ( ')' ) )
            // InternalOCLX.g:3833:1: ( ')' )
            {
            // InternalOCLX.g:3833:1: ( ')' )
            // InternalOCLX.g:3834:2: ')'
            {
             before(grammarAccess.getTemporalUntilAccess().getRightParenthesisKeyword_5()); 
            match(input,50,FOLLOW_2); 
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
    // InternalOCLX.g:3844:1: rule__TemporalEverytime__Group__0 : rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1 ;
    public final void rule__TemporalEverytime__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3848:1: ( rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1 )
            // InternalOCLX.g:3849:2: rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1
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
    // InternalOCLX.g:3856:1: rule__TemporalEverytime__Group__0__Impl : ( ( rule__TemporalEverytime__NameAssignment_0 ) ) ;
    public final void rule__TemporalEverytime__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3860:1: ( ( ( rule__TemporalEverytime__NameAssignment_0 ) ) )
            // InternalOCLX.g:3861:1: ( ( rule__TemporalEverytime__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3861:1: ( ( rule__TemporalEverytime__NameAssignment_0 ) )
            // InternalOCLX.g:3862:2: ( rule__TemporalEverytime__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3863:2: ( rule__TemporalEverytime__NameAssignment_0 )
            // InternalOCLX.g:3863:3: rule__TemporalEverytime__NameAssignment_0
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
    // InternalOCLX.g:3871:1: rule__TemporalEverytime__Group__1 : rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2 ;
    public final void rule__TemporalEverytime__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3875:1: ( rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2 )
            // InternalOCLX.g:3876:2: rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2
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
    // InternalOCLX.g:3883:1: rule__TemporalEverytime__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalEverytime__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3887:1: ( ( '(' ) )
            // InternalOCLX.g:3888:1: ( '(' )
            {
            // InternalOCLX.g:3888:1: ( '(' )
            // InternalOCLX.g:3889:2: '('
            {
             before(grammarAccess.getTemporalEverytimeAccess().getLeftParenthesisKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:3898:1: rule__TemporalEverytime__Group__2 : rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3 ;
    public final void rule__TemporalEverytime__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3902:1: ( rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3 )
            // InternalOCLX.g:3903:2: rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3
            {
            pushFollow(FOLLOW_31);
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
    // InternalOCLX.g:3910:1: rule__TemporalEverytime__Group__2__Impl : ( ( rule__TemporalEverytime__AAssignment_2 ) ) ;
    public final void rule__TemporalEverytime__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3914:1: ( ( ( rule__TemporalEverytime__AAssignment_2 ) ) )
            // InternalOCLX.g:3915:1: ( ( rule__TemporalEverytime__AAssignment_2 ) )
            {
            // InternalOCLX.g:3915:1: ( ( rule__TemporalEverytime__AAssignment_2 ) )
            // InternalOCLX.g:3916:2: ( rule__TemporalEverytime__AAssignment_2 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getAAssignment_2()); 
            // InternalOCLX.g:3917:2: ( rule__TemporalEverytime__AAssignment_2 )
            // InternalOCLX.g:3917:3: rule__TemporalEverytime__AAssignment_2
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
    // InternalOCLX.g:3925:1: rule__TemporalEverytime__Group__3 : rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4 ;
    public final void rule__TemporalEverytime__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3929:1: ( rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4 )
            // InternalOCLX.g:3930:2: rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4
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
    // InternalOCLX.g:3937:1: rule__TemporalEverytime__Group__3__Impl : ( 'then' ) ;
    public final void rule__TemporalEverytime__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3941:1: ( ( 'then' ) )
            // InternalOCLX.g:3942:1: ( 'then' )
            {
            // InternalOCLX.g:3942:1: ( 'then' )
            // InternalOCLX.g:3943:2: 'then'
            {
             before(grammarAccess.getTemporalEverytimeAccess().getThenKeyword_3()); 
            match(input,56,FOLLOW_2); 
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
    // InternalOCLX.g:3952:1: rule__TemporalEverytime__Group__4 : rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5 ;
    public final void rule__TemporalEverytime__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3956:1: ( rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5 )
            // InternalOCLX.g:3957:2: rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5
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
    // InternalOCLX.g:3964:1: rule__TemporalEverytime__Group__4__Impl : ( ( rule__TemporalEverytime__BAssignment_4 ) ) ;
    public final void rule__TemporalEverytime__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3968:1: ( ( ( rule__TemporalEverytime__BAssignment_4 ) ) )
            // InternalOCLX.g:3969:1: ( ( rule__TemporalEverytime__BAssignment_4 ) )
            {
            // InternalOCLX.g:3969:1: ( ( rule__TemporalEverytime__BAssignment_4 ) )
            // InternalOCLX.g:3970:2: ( rule__TemporalEverytime__BAssignment_4 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getBAssignment_4()); 
            // InternalOCLX.g:3971:2: ( rule__TemporalEverytime__BAssignment_4 )
            // InternalOCLX.g:3971:3: rule__TemporalEverytime__BAssignment_4
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
    // InternalOCLX.g:3979:1: rule__TemporalEverytime__Group__5 : rule__TemporalEverytime__Group__5__Impl ;
    public final void rule__TemporalEverytime__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3983:1: ( rule__TemporalEverytime__Group__5__Impl )
            // InternalOCLX.g:3984:2: rule__TemporalEverytime__Group__5__Impl
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
    // InternalOCLX.g:3990:1: rule__TemporalEverytime__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalEverytime__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3994:1: ( ( ')' ) )
            // InternalOCLX.g:3995:1: ( ')' )
            {
            // InternalOCLX.g:3995:1: ( ')' )
            // InternalOCLX.g:3996:2: ')'
            {
             before(grammarAccess.getTemporalEverytimeAccess().getRightParenthesisKeyword_5()); 
            match(input,50,FOLLOW_2); 
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
    // InternalOCLX.g:4006:1: rule__TemporalAtLeastOnce__Group__0 : rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1 ;
    public final void rule__TemporalAtLeastOnce__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4010:1: ( rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1 )
            // InternalOCLX.g:4011:2: rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1
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
    // InternalOCLX.g:4018:1: rule__TemporalAtLeastOnce__Group__0__Impl : ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4022:1: ( ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) ) )
            // InternalOCLX.g:4023:1: ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4023:1: ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) )
            // InternalOCLX.g:4024:2: ( rule__TemporalAtLeastOnce__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4025:2: ( rule__TemporalAtLeastOnce__NameAssignment_0 )
            // InternalOCLX.g:4025:3: rule__TemporalAtLeastOnce__NameAssignment_0
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
    // InternalOCLX.g:4033:1: rule__TemporalAtLeastOnce__Group__1 : rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2 ;
    public final void rule__TemporalAtLeastOnce__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4037:1: ( rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2 )
            // InternalOCLX.g:4038:2: rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2
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
    // InternalOCLX.g:4045:1: rule__TemporalAtLeastOnce__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalAtLeastOnce__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4049:1: ( ( '(' ) )
            // InternalOCLX.g:4050:1: ( '(' )
            {
            // InternalOCLX.g:4050:1: ( '(' )
            // InternalOCLX.g:4051:2: '('
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getLeftParenthesisKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:4060:1: rule__TemporalAtLeastOnce__Group__2 : rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3 ;
    public final void rule__TemporalAtLeastOnce__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4064:1: ( rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3 )
            // InternalOCLX.g:4065:2: rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3
            {
            pushFollow(FOLLOW_32);
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
    // InternalOCLX.g:4072:1: rule__TemporalAtLeastOnce__Group__2__Impl : ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4076:1: ( ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) ) )
            // InternalOCLX.g:4077:1: ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) )
            {
            // InternalOCLX.g:4077:1: ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) )
            // InternalOCLX.g:4078:2: ( rule__TemporalAtLeastOnce__AAssignment_2 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getAAssignment_2()); 
            // InternalOCLX.g:4079:2: ( rule__TemporalAtLeastOnce__AAssignment_2 )
            // InternalOCLX.g:4079:3: rule__TemporalAtLeastOnce__AAssignment_2
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
    // InternalOCLX.g:4087:1: rule__TemporalAtLeastOnce__Group__3 : rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4 ;
    public final void rule__TemporalAtLeastOnce__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4091:1: ( rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4 )
            // InternalOCLX.g:4092:2: rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4
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
    // InternalOCLX.g:4099:1: rule__TemporalAtLeastOnce__Group__3__Impl : ( 'thenAtLeastOnce' ) ;
    public final void rule__TemporalAtLeastOnce__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4103:1: ( ( 'thenAtLeastOnce' ) )
            // InternalOCLX.g:4104:1: ( 'thenAtLeastOnce' )
            {
            // InternalOCLX.g:4104:1: ( 'thenAtLeastOnce' )
            // InternalOCLX.g:4105:2: 'thenAtLeastOnce'
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getThenAtLeastOnceKeyword_3()); 
            match(input,57,FOLLOW_2); 
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
    // InternalOCLX.g:4114:1: rule__TemporalAtLeastOnce__Group__4 : rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5 ;
    public final void rule__TemporalAtLeastOnce__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4118:1: ( rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5 )
            // InternalOCLX.g:4119:2: rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5
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
    // InternalOCLX.g:4126:1: rule__TemporalAtLeastOnce__Group__4__Impl : ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4130:1: ( ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) ) )
            // InternalOCLX.g:4131:1: ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) )
            {
            // InternalOCLX.g:4131:1: ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) )
            // InternalOCLX.g:4132:2: ( rule__TemporalAtLeastOnce__BAssignment_4 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getBAssignment_4()); 
            // InternalOCLX.g:4133:2: ( rule__TemporalAtLeastOnce__BAssignment_4 )
            // InternalOCLX.g:4133:3: rule__TemporalAtLeastOnce__BAssignment_4
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
    // InternalOCLX.g:4141:1: rule__TemporalAtLeastOnce__Group__5 : rule__TemporalAtLeastOnce__Group__5__Impl ;
    public final void rule__TemporalAtLeastOnce__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4145:1: ( rule__TemporalAtLeastOnce__Group__5__Impl )
            // InternalOCLX.g:4146:2: rule__TemporalAtLeastOnce__Group__5__Impl
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
    // InternalOCLX.g:4152:1: rule__TemporalAtLeastOnce__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalAtLeastOnce__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4156:1: ( ( ')' ) )
            // InternalOCLX.g:4157:1: ( ')' )
            {
            // InternalOCLX.g:4157:1: ( ')' )
            // InternalOCLX.g:4158:2: ')'
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getRightParenthesisKeyword_5()); 
            match(input,50,FOLLOW_2); 
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
    // InternalOCLX.g:4168:1: rule__LegacyUntil__Group__0 : rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1 ;
    public final void rule__LegacyUntil__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4172:1: ( rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1 )
            // InternalOCLX.g:4173:2: rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1
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
    // InternalOCLX.g:4180:1: rule__LegacyUntil__Group__0__Impl : ( ( rule__LegacyUntil__NameAssignment_0 ) ) ;
    public final void rule__LegacyUntil__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4184:1: ( ( ( rule__LegacyUntil__NameAssignment_0 ) ) )
            // InternalOCLX.g:4185:1: ( ( rule__LegacyUntil__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4185:1: ( ( rule__LegacyUntil__NameAssignment_0 ) )
            // InternalOCLX.g:4186:2: ( rule__LegacyUntil__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyUntilAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4187:2: ( rule__LegacyUntil__NameAssignment_0 )
            // InternalOCLX.g:4187:3: rule__LegacyUntil__NameAssignment_0
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
    // InternalOCLX.g:4195:1: rule__LegacyUntil__Group__1 : rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2 ;
    public final void rule__LegacyUntil__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4199:1: ( rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2 )
            // InternalOCLX.g:4200:2: rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2
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
    // InternalOCLX.g:4207:1: rule__LegacyUntil__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyUntil__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4211:1: ( ( '(' ) )
            // InternalOCLX.g:4212:1: ( '(' )
            {
            // InternalOCLX.g:4212:1: ( '(' )
            // InternalOCLX.g:4213:2: '('
            {
             before(grammarAccess.getLegacyUntilAccess().getLeftParenthesisKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:4222:1: rule__LegacyUntil__Group__2 : rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3 ;
    public final void rule__LegacyUntil__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4226:1: ( rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3 )
            // InternalOCLX.g:4227:2: rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3
            {
            pushFollow(FOLLOW_33);
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
    // InternalOCLX.g:4234:1: rule__LegacyUntil__Group__2__Impl : ( ( rule__LegacyUntil__AAssignment_2 ) ) ;
    public final void rule__LegacyUntil__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4238:1: ( ( ( rule__LegacyUntil__AAssignment_2 ) ) )
            // InternalOCLX.g:4239:1: ( ( rule__LegacyUntil__AAssignment_2 ) )
            {
            // InternalOCLX.g:4239:1: ( ( rule__LegacyUntil__AAssignment_2 ) )
            // InternalOCLX.g:4240:2: ( rule__LegacyUntil__AAssignment_2 )
            {
             before(grammarAccess.getLegacyUntilAccess().getAAssignment_2()); 
            // InternalOCLX.g:4241:2: ( rule__LegacyUntil__AAssignment_2 )
            // InternalOCLX.g:4241:3: rule__LegacyUntil__AAssignment_2
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
    // InternalOCLX.g:4249:1: rule__LegacyUntil__Group__3 : rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4 ;
    public final void rule__LegacyUntil__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4253:1: ( rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4 )
            // InternalOCLX.g:4254:2: rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4
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
    // InternalOCLX.g:4261:1: rule__LegacyUntil__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyUntil__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4265:1: ( ( ',' ) )
            // InternalOCLX.g:4266:1: ( ',' )
            {
            // InternalOCLX.g:4266:1: ( ',' )
            // InternalOCLX.g:4267:2: ','
            {
             before(grammarAccess.getLegacyUntilAccess().getCommaKeyword_3()); 
            match(input,58,FOLLOW_2); 
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
    // InternalOCLX.g:4276:1: rule__LegacyUntil__Group__4 : rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5 ;
    public final void rule__LegacyUntil__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4280:1: ( rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5 )
            // InternalOCLX.g:4281:2: rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5
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
    // InternalOCLX.g:4288:1: rule__LegacyUntil__Group__4__Impl : ( ( rule__LegacyUntil__BAssignment_4 ) ) ;
    public final void rule__LegacyUntil__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4292:1: ( ( ( rule__LegacyUntil__BAssignment_4 ) ) )
            // InternalOCLX.g:4293:1: ( ( rule__LegacyUntil__BAssignment_4 ) )
            {
            // InternalOCLX.g:4293:1: ( ( rule__LegacyUntil__BAssignment_4 ) )
            // InternalOCLX.g:4294:2: ( rule__LegacyUntil__BAssignment_4 )
            {
             before(grammarAccess.getLegacyUntilAccess().getBAssignment_4()); 
            // InternalOCLX.g:4295:2: ( rule__LegacyUntil__BAssignment_4 )
            // InternalOCLX.g:4295:3: rule__LegacyUntil__BAssignment_4
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
    // InternalOCLX.g:4303:1: rule__LegacyUntil__Group__5 : rule__LegacyUntil__Group__5__Impl ;
    public final void rule__LegacyUntil__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4307:1: ( rule__LegacyUntil__Group__5__Impl )
            // InternalOCLX.g:4308:2: rule__LegacyUntil__Group__5__Impl
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
    // InternalOCLX.g:4314:1: rule__LegacyUntil__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyUntil__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4318:1: ( ( ')' ) )
            // InternalOCLX.g:4319:1: ( ')' )
            {
            // InternalOCLX.g:4319:1: ( ')' )
            // InternalOCLX.g:4320:2: ')'
            {
             before(grammarAccess.getLegacyUntilAccess().getRightParenthesisKeyword_5()); 
            match(input,50,FOLLOW_2); 
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
    // InternalOCLX.g:4330:1: rule__LegacyAsSoonAs__Group__0 : rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1 ;
    public final void rule__LegacyAsSoonAs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4334:1: ( rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1 )
            // InternalOCLX.g:4335:2: rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1
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
    // InternalOCLX.g:4342:1: rule__LegacyAsSoonAs__Group__0__Impl : ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4346:1: ( ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) ) )
            // InternalOCLX.g:4347:1: ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4347:1: ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) )
            // InternalOCLX.g:4348:2: ( rule__LegacyAsSoonAs__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4349:2: ( rule__LegacyAsSoonAs__NameAssignment_0 )
            // InternalOCLX.g:4349:3: rule__LegacyAsSoonAs__NameAssignment_0
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
    // InternalOCLX.g:4357:1: rule__LegacyAsSoonAs__Group__1 : rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2 ;
    public final void rule__LegacyAsSoonAs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4361:1: ( rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2 )
            // InternalOCLX.g:4362:2: rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2
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
    // InternalOCLX.g:4369:1: rule__LegacyAsSoonAs__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyAsSoonAs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4373:1: ( ( '(' ) )
            // InternalOCLX.g:4374:1: ( '(' )
            {
            // InternalOCLX.g:4374:1: ( '(' )
            // InternalOCLX.g:4375:2: '('
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getLeftParenthesisKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:4384:1: rule__LegacyAsSoonAs__Group__2 : rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3 ;
    public final void rule__LegacyAsSoonAs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4388:1: ( rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3 )
            // InternalOCLX.g:4389:2: rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3
            {
            pushFollow(FOLLOW_33);
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
    // InternalOCLX.g:4396:1: rule__LegacyAsSoonAs__Group__2__Impl : ( ( rule__LegacyAsSoonAs__AAssignment_2 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4400:1: ( ( ( rule__LegacyAsSoonAs__AAssignment_2 ) ) )
            // InternalOCLX.g:4401:1: ( ( rule__LegacyAsSoonAs__AAssignment_2 ) )
            {
            // InternalOCLX.g:4401:1: ( ( rule__LegacyAsSoonAs__AAssignment_2 ) )
            // InternalOCLX.g:4402:2: ( rule__LegacyAsSoonAs__AAssignment_2 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getAAssignment_2()); 
            // InternalOCLX.g:4403:2: ( rule__LegacyAsSoonAs__AAssignment_2 )
            // InternalOCLX.g:4403:3: rule__LegacyAsSoonAs__AAssignment_2
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
    // InternalOCLX.g:4411:1: rule__LegacyAsSoonAs__Group__3 : rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4 ;
    public final void rule__LegacyAsSoonAs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4415:1: ( rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4 )
            // InternalOCLX.g:4416:2: rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4
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
    // InternalOCLX.g:4423:1: rule__LegacyAsSoonAs__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyAsSoonAs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4427:1: ( ( ',' ) )
            // InternalOCLX.g:4428:1: ( ',' )
            {
            // InternalOCLX.g:4428:1: ( ',' )
            // InternalOCLX.g:4429:2: ','
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getCommaKeyword_3()); 
            match(input,58,FOLLOW_2); 
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
    // InternalOCLX.g:4438:1: rule__LegacyAsSoonAs__Group__4 : rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5 ;
    public final void rule__LegacyAsSoonAs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4442:1: ( rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5 )
            // InternalOCLX.g:4443:2: rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5
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
    // InternalOCLX.g:4450:1: rule__LegacyAsSoonAs__Group__4__Impl : ( ( rule__LegacyAsSoonAs__BAssignment_4 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4454:1: ( ( ( rule__LegacyAsSoonAs__BAssignment_4 ) ) )
            // InternalOCLX.g:4455:1: ( ( rule__LegacyAsSoonAs__BAssignment_4 ) )
            {
            // InternalOCLX.g:4455:1: ( ( rule__LegacyAsSoonAs__BAssignment_4 ) )
            // InternalOCLX.g:4456:2: ( rule__LegacyAsSoonAs__BAssignment_4 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getBAssignment_4()); 
            // InternalOCLX.g:4457:2: ( rule__LegacyAsSoonAs__BAssignment_4 )
            // InternalOCLX.g:4457:3: rule__LegacyAsSoonAs__BAssignment_4
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
    // InternalOCLX.g:4465:1: rule__LegacyAsSoonAs__Group__5 : rule__LegacyAsSoonAs__Group__5__Impl ;
    public final void rule__LegacyAsSoonAs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4469:1: ( rule__LegacyAsSoonAs__Group__5__Impl )
            // InternalOCLX.g:4470:2: rule__LegacyAsSoonAs__Group__5__Impl
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
    // InternalOCLX.g:4476:1: rule__LegacyAsSoonAs__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyAsSoonAs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4480:1: ( ( ')' ) )
            // InternalOCLX.g:4481:1: ( ')' )
            {
            // InternalOCLX.g:4481:1: ( ')' )
            // InternalOCLX.g:4482:2: ')'
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getRightParenthesisKeyword_5()); 
            match(input,50,FOLLOW_2); 
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
    // InternalOCLX.g:4492:1: rule__LegacyEverytime__Group__0 : rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1 ;
    public final void rule__LegacyEverytime__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4496:1: ( rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1 )
            // InternalOCLX.g:4497:2: rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1
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
    // InternalOCLX.g:4504:1: rule__LegacyEverytime__Group__0__Impl : ( ( rule__LegacyEverytime__NameAssignment_0 ) ) ;
    public final void rule__LegacyEverytime__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4508:1: ( ( ( rule__LegacyEverytime__NameAssignment_0 ) ) )
            // InternalOCLX.g:4509:1: ( ( rule__LegacyEverytime__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4509:1: ( ( rule__LegacyEverytime__NameAssignment_0 ) )
            // InternalOCLX.g:4510:2: ( rule__LegacyEverytime__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4511:2: ( rule__LegacyEverytime__NameAssignment_0 )
            // InternalOCLX.g:4511:3: rule__LegacyEverytime__NameAssignment_0
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
    // InternalOCLX.g:4519:1: rule__LegacyEverytime__Group__1 : rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2 ;
    public final void rule__LegacyEverytime__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4523:1: ( rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2 )
            // InternalOCLX.g:4524:2: rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2
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
    // InternalOCLX.g:4531:1: rule__LegacyEverytime__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyEverytime__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4535:1: ( ( '(' ) )
            // InternalOCLX.g:4536:1: ( '(' )
            {
            // InternalOCLX.g:4536:1: ( '(' )
            // InternalOCLX.g:4537:2: '('
            {
             before(grammarAccess.getLegacyEverytimeAccess().getLeftParenthesisKeyword_1()); 
            match(input,49,FOLLOW_2); 
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
    // InternalOCLX.g:4546:1: rule__LegacyEverytime__Group__2 : rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3 ;
    public final void rule__LegacyEverytime__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4550:1: ( rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3 )
            // InternalOCLX.g:4551:2: rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3
            {
            pushFollow(FOLLOW_33);
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
    // InternalOCLX.g:4558:1: rule__LegacyEverytime__Group__2__Impl : ( ( rule__LegacyEverytime__AAssignment_2 ) ) ;
    public final void rule__LegacyEverytime__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4562:1: ( ( ( rule__LegacyEverytime__AAssignment_2 ) ) )
            // InternalOCLX.g:4563:1: ( ( rule__LegacyEverytime__AAssignment_2 ) )
            {
            // InternalOCLX.g:4563:1: ( ( rule__LegacyEverytime__AAssignment_2 ) )
            // InternalOCLX.g:4564:2: ( rule__LegacyEverytime__AAssignment_2 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getAAssignment_2()); 
            // InternalOCLX.g:4565:2: ( rule__LegacyEverytime__AAssignment_2 )
            // InternalOCLX.g:4565:3: rule__LegacyEverytime__AAssignment_2
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
    // InternalOCLX.g:4573:1: rule__LegacyEverytime__Group__3 : rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4 ;
    public final void rule__LegacyEverytime__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4577:1: ( rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4 )
            // InternalOCLX.g:4578:2: rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4
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
    // InternalOCLX.g:4585:1: rule__LegacyEverytime__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyEverytime__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4589:1: ( ( ',' ) )
            // InternalOCLX.g:4590:1: ( ',' )
            {
            // InternalOCLX.g:4590:1: ( ',' )
            // InternalOCLX.g:4591:2: ','
            {
             before(grammarAccess.getLegacyEverytimeAccess().getCommaKeyword_3()); 
            match(input,58,FOLLOW_2); 
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
    // InternalOCLX.g:4600:1: rule__LegacyEverytime__Group__4 : rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5 ;
    public final void rule__LegacyEverytime__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4604:1: ( rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5 )
            // InternalOCLX.g:4605:2: rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5
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
    // InternalOCLX.g:4612:1: rule__LegacyEverytime__Group__4__Impl : ( ( rule__LegacyEverytime__BAssignment_4 ) ) ;
    public final void rule__LegacyEverytime__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4616:1: ( ( ( rule__LegacyEverytime__BAssignment_4 ) ) )
            // InternalOCLX.g:4617:1: ( ( rule__LegacyEverytime__BAssignment_4 ) )
            {
            // InternalOCLX.g:4617:1: ( ( rule__LegacyEverytime__BAssignment_4 ) )
            // InternalOCLX.g:4618:2: ( rule__LegacyEverytime__BAssignment_4 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getBAssignment_4()); 
            // InternalOCLX.g:4619:2: ( rule__LegacyEverytime__BAssignment_4 )
            // InternalOCLX.g:4619:3: rule__LegacyEverytime__BAssignment_4
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
    // InternalOCLX.g:4627:1: rule__LegacyEverytime__Group__5 : rule__LegacyEverytime__Group__5__Impl ;
    public final void rule__LegacyEverytime__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4631:1: ( rule__LegacyEverytime__Group__5__Impl )
            // InternalOCLX.g:4632:2: rule__LegacyEverytime__Group__5__Impl
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
    // InternalOCLX.g:4638:1: rule__LegacyEverytime__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyEverytime__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4642:1: ( ( ')' ) )
            // InternalOCLX.g:4643:1: ( ')' )
            {
            // InternalOCLX.g:4643:1: ( ')' )
            // InternalOCLX.g:4644:2: ')'
            {
             before(grammarAccess.getLegacyEverytimeAccess().getRightParenthesisKeyword_5()); 
            match(input,50,FOLLOW_2); 
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


    // $ANTLR start "rule__ArgumentsExp__Group__0"
    // InternalOCLX.g:4654:1: rule__ArgumentsExp__Group__0 : rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1 ;
    public final void rule__ArgumentsExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4658:1: ( rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1 )
            // InternalOCLX.g:4659:2: rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1
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
    // InternalOCLX.g:4666:1: rule__ArgumentsExp__Group__0__Impl : ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) ) ;
    public final void rule__ArgumentsExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4670:1: ( ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) ) )
            // InternalOCLX.g:4671:1: ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) )
            {
            // InternalOCLX.g:4671:1: ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) )
            // InternalOCLX.g:4672:2: ( rule__ArgumentsExp__OperatorsAssignment_0 )
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_0()); 
            // InternalOCLX.g:4673:2: ( rule__ArgumentsExp__OperatorsAssignment_0 )
            // InternalOCLX.g:4673:3: rule__ArgumentsExp__OperatorsAssignment_0
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
    // InternalOCLX.g:4681:1: rule__ArgumentsExp__Group__1 : rule__ArgumentsExp__Group__1__Impl ;
    public final void rule__ArgumentsExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4685:1: ( rule__ArgumentsExp__Group__1__Impl )
            // InternalOCLX.g:4686:2: rule__ArgumentsExp__Group__1__Impl
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
    // InternalOCLX.g:4692:1: rule__ArgumentsExp__Group__1__Impl : ( ( rule__ArgumentsExp__Group_1__0 )* ) ;
    public final void rule__ArgumentsExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4696:1: ( ( ( rule__ArgumentsExp__Group_1__0 )* ) )
            // InternalOCLX.g:4697:1: ( ( rule__ArgumentsExp__Group_1__0 )* )
            {
            // InternalOCLX.g:4697:1: ( ( rule__ArgumentsExp__Group_1__0 )* )
            // InternalOCLX.g:4698:2: ( rule__ArgumentsExp__Group_1__0 )*
            {
             before(grammarAccess.getArgumentsExpAccess().getGroup_1()); 
            // InternalOCLX.g:4699:2: ( rule__ArgumentsExp__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==58) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalOCLX.g:4699:3: rule__ArgumentsExp__Group_1__0
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
    // InternalOCLX.g:4708:1: rule__ArgumentsExp__Group_1__0 : rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1 ;
    public final void rule__ArgumentsExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4712:1: ( rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1 )
            // InternalOCLX.g:4713:2: rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1
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
    // InternalOCLX.g:4720:1: rule__ArgumentsExp__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ArgumentsExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4724:1: ( ( ',' ) )
            // InternalOCLX.g:4725:1: ( ',' )
            {
            // InternalOCLX.g:4725:1: ( ',' )
            // InternalOCLX.g:4726:2: ','
            {
             before(grammarAccess.getArgumentsExpAccess().getCommaKeyword_1_0()); 
            match(input,58,FOLLOW_2); 
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
    // InternalOCLX.g:4735:1: rule__ArgumentsExp__Group_1__1 : rule__ArgumentsExp__Group_1__1__Impl ;
    public final void rule__ArgumentsExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4739:1: ( rule__ArgumentsExp__Group_1__1__Impl )
            // InternalOCLX.g:4740:2: rule__ArgumentsExp__Group_1__1__Impl
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
    // InternalOCLX.g:4746:1: rule__ArgumentsExp__Group_1__1__Impl : ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) ) ;
    public final void rule__ArgumentsExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4750:1: ( ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) ) )
            // InternalOCLX.g:4751:1: ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) )
            {
            // InternalOCLX.g:4751:1: ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) )
            // InternalOCLX.g:4752:2: ( rule__ArgumentsExp__OperatorsAssignment_1_1 )
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_1_1()); 
            // InternalOCLX.g:4753:2: ( rule__ArgumentsExp__OperatorsAssignment_1_1 )
            // InternalOCLX.g:4753:3: rule__ArgumentsExp__OperatorsAssignment_1_1
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
    // InternalOCLX.g:4762:1: rule__Model__ConstraintsAssignment : ( ruleConstraint ) ;
    public final void rule__Model__ConstraintsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4766:1: ( ( ruleConstraint ) )
            // InternalOCLX.g:4767:2: ( ruleConstraint )
            {
            // InternalOCLX.g:4767:2: ( ruleConstraint )
            // InternalOCLX.g:4768:3: ruleConstraint
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
    // InternalOCLX.g:4777:1: rule__Constraint__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constraint__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4781:1: ( ( RULE_ID ) )
            // InternalOCLX.g:4782:2: ( RULE_ID )
            {
            // InternalOCLX.g:4782:2: ( RULE_ID )
            // InternalOCLX.g:4783:3: RULE_ID
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
    // InternalOCLX.g:4792:1: rule__Constraint__DescriptionAssignment_3_1 : ( RULE_DESCRIPTION ) ;
    public final void rule__Constraint__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4796:1: ( ( RULE_DESCRIPTION ) )
            // InternalOCLX.g:4797:2: ( RULE_DESCRIPTION )
            {
            // InternalOCLX.g:4797:2: ( RULE_DESCRIPTION )
            // InternalOCLX.g:4798:3: RULE_DESCRIPTION
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
    // InternalOCLX.g:4807:1: rule__Constraint__OverrulableAssignment_4_2 : ( ruleBooleanLiteralExp ) ;
    public final void rule__Constraint__OverrulableAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4811:1: ( ( ruleBooleanLiteralExp ) )
            // InternalOCLX.g:4812:2: ( ruleBooleanLiteralExp )
            {
            // InternalOCLX.g:4812:2: ( ruleBooleanLiteralExp )
            // InternalOCLX.g:4813:3: ruleBooleanLiteralExp
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
    // InternalOCLX.g:4822:1: rule__Constraint__ContextAssignment_6 : ( ruleContext ) ;
    public final void rule__Constraint__ContextAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4826:1: ( ( ruleContext ) )
            // InternalOCLX.g:4827:2: ( ruleContext )
            {
            // InternalOCLX.g:4827:2: ( ruleContext )
            // InternalOCLX.g:4828:3: ruleContext
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
    // InternalOCLX.g:4837:1: rule__Constraint__ExpressionAssignment_8 : ( ruleExp ) ;
    public final void rule__Constraint__ExpressionAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4841:1: ( ( ruleExp ) )
            // InternalOCLX.g:4842:2: ( ruleExp )
            {
            // InternalOCLX.g:4842:2: ( ruleExp )
            // InternalOCLX.g:4843:3: ruleExp
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
    // InternalOCLX.g:4852:1: rule__Context__NameAssignment : ( ruleQualifiedName ) ;
    public final void rule__Context__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4856:1: ( ( ruleQualifiedName ) )
            // InternalOCLX.g:4857:2: ( ruleQualifiedName )
            {
            // InternalOCLX.g:4857:2: ( ruleQualifiedName )
            // InternalOCLX.g:4858:3: ruleQualifiedName
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
    // InternalOCLX.g:4867:1: rule__Exp__OperatorsAssignment_1_1 : ( ruleBinaryOperator ) ;
    public final void rule__Exp__OperatorsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4871:1: ( ( ruleBinaryOperator ) )
            // InternalOCLX.g:4872:2: ( ruleBinaryOperator )
            {
            // InternalOCLX.g:4872:2: ( ruleBinaryOperator )
            // InternalOCLX.g:4873:3: ruleBinaryOperator
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
    // InternalOCLX.g:4882:1: rule__Exp__ExpressionsAssignment_1_2 : ( rulePrefixedExp ) ;
    public final void rule__Exp__ExpressionsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4886:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:4887:2: ( rulePrefixedExp )
            {
            // InternalOCLX.g:4887:2: ( rulePrefixedExp )
            // InternalOCLX.g:4888:3: rulePrefixedExp
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
    // InternalOCLX.g:4897:1: rule__Exp__OperatorsAssignment_1_3_0 : ( ruleBinaryOperator ) ;
    public final void rule__Exp__OperatorsAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4901:1: ( ( ruleBinaryOperator ) )
            // InternalOCLX.g:4902:2: ( ruleBinaryOperator )
            {
            // InternalOCLX.g:4902:2: ( ruleBinaryOperator )
            // InternalOCLX.g:4903:3: ruleBinaryOperator
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
    // InternalOCLX.g:4912:1: rule__Exp__ExpressionsAssignment_1_3_1 : ( rulePrefixedExp ) ;
    public final void rule__Exp__ExpressionsAssignment_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4916:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:4917:2: ( rulePrefixedExp )
            {
            // InternalOCLX.g:4917:2: ( rulePrefixedExp )
            // InternalOCLX.g:4918:3: rulePrefixedExp
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
    // InternalOCLX.g:4927:1: rule__PrefixedExp__OperatorAssignment_0_1 : ( ruleUnaryOperator ) ;
    public final void rule__PrefixedExp__OperatorAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4931:1: ( ( ruleUnaryOperator ) )
            // InternalOCLX.g:4932:2: ( ruleUnaryOperator )
            {
            // InternalOCLX.g:4932:2: ( ruleUnaryOperator )
            // InternalOCLX.g:4933:3: ruleUnaryOperator
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
    // InternalOCLX.g:4942:1: rule__PrefixedExp__ExpressionAssignment_0_2 : ( rulePrimaryExp ) ;
    public final void rule__PrefixedExp__ExpressionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4946:1: ( ( rulePrimaryExp ) )
            // InternalOCLX.g:4947:2: ( rulePrimaryExp )
            {
            // InternalOCLX.g:4947:2: ( rulePrimaryExp )
            // InternalOCLX.g:4948:3: rulePrimaryExp
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
    // InternalOCLX.g:4957:1: rule__BooleanOperator__OpAssignment : ( ( rule__BooleanOperator__OpAlternatives_0 ) ) ;
    public final void rule__BooleanOperator__OpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4961:1: ( ( ( rule__BooleanOperator__OpAlternatives_0 ) ) )
            // InternalOCLX.g:4962:2: ( ( rule__BooleanOperator__OpAlternatives_0 ) )
            {
            // InternalOCLX.g:4962:2: ( ( rule__BooleanOperator__OpAlternatives_0 ) )
            // InternalOCLX.g:4963:3: ( rule__BooleanOperator__OpAlternatives_0 )
            {
             before(grammarAccess.getBooleanOperatorAccess().getOpAlternatives_0()); 
            // InternalOCLX.g:4964:3: ( rule__BooleanOperator__OpAlternatives_0 )
            // InternalOCLX.g:4964:4: rule__BooleanOperator__OpAlternatives_0
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
    // InternalOCLX.g:4972:1: rule__MathOperator__OpAssignment : ( ( rule__MathOperator__OpAlternatives_0 ) ) ;
    public final void rule__MathOperator__OpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4976:1: ( ( ( rule__MathOperator__OpAlternatives_0 ) ) )
            // InternalOCLX.g:4977:2: ( ( rule__MathOperator__OpAlternatives_0 ) )
            {
            // InternalOCLX.g:4977:2: ( ( rule__MathOperator__OpAlternatives_0 ) )
            // InternalOCLX.g:4978:3: ( rule__MathOperator__OpAlternatives_0 )
            {
             before(grammarAccess.getMathOperatorAccess().getOpAlternatives_0()); 
            // InternalOCLX.g:4979:3: ( rule__MathOperator__OpAlternatives_0 )
            // InternalOCLX.g:4979:4: rule__MathOperator__OpAlternatives_0
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
    // InternalOCLX.g:4987:1: rule__NavigationOperator__NameAssignment : ( ( rule__NavigationOperator__NameAlternatives_0 ) ) ;
    public final void rule__NavigationOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4991:1: ( ( ( rule__NavigationOperator__NameAlternatives_0 ) ) )
            // InternalOCLX.g:4992:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:4992:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            // InternalOCLX.g:4993:3: ( rule__NavigationOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getNavigationOperatorAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:4994:3: ( rule__NavigationOperator__NameAlternatives_0 )
            // InternalOCLX.g:4994:4: rule__NavigationOperator__NameAlternatives_0
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
    // InternalOCLX.g:5002:1: rule__UnaryOperator__NameAssignment : ( ( rule__UnaryOperator__NameAlternatives_0 ) ) ;
    public final void rule__UnaryOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5006:1: ( ( ( rule__UnaryOperator__NameAlternatives_0 ) ) )
            // InternalOCLX.g:5007:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:5007:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            // InternalOCLX.g:5008:3: ( rule__UnaryOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getUnaryOperatorAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:5009:3: ( rule__UnaryOperator__NameAlternatives_0 )
            // InternalOCLX.g:5009:4: rule__UnaryOperator__NameAlternatives_0
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
    // InternalOCLX.g:5017:1: rule__PrimaryExp__NavAssignment_1_1_0 : ( ruleNavigationOperator ) ;
    public final void rule__PrimaryExp__NavAssignment_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5021:1: ( ( ruleNavigationOperator ) )
            // InternalOCLX.g:5022:2: ( ruleNavigationOperator )
            {
            // InternalOCLX.g:5022:2: ( ruleNavigationOperator )
            // InternalOCLX.g:5023:3: ruleNavigationOperator
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
    // InternalOCLX.g:5032:1: rule__PrimaryExp__MethodsAssignment_1_1_1 : ( ruleMethodExp ) ;
    public final void rule__PrimaryExp__MethodsAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5036:1: ( ( ruleMethodExp ) )
            // InternalOCLX.g:5037:2: ( ruleMethodExp )
            {
            // InternalOCLX.g:5037:2: ( ruleMethodExp )
            // InternalOCLX.g:5038:3: ruleMethodExp
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
    // InternalOCLX.g:5047:1: rule__NestedExp__SourceAssignment_1 : ( ruleExp ) ;
    public final void rule__NestedExp__SourceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5051:1: ( ( ruleExp ) )
            // InternalOCLX.g:5052:2: ( ruleExp )
            {
            // InternalOCLX.g:5052:2: ( ruleExp )
            // InternalOCLX.g:5053:3: ruleExp
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
    // InternalOCLX.g:5062:1: rule__SelfExp__NameAssignment_1 : ( ( 'self' ) ) ;
    public final void rule__SelfExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5066:1: ( ( ( 'self' ) ) )
            // InternalOCLX.g:5067:2: ( ( 'self' ) )
            {
            // InternalOCLX.g:5067:2: ( ( 'self' ) )
            // InternalOCLX.g:5068:3: ( 'self' )
            {
             before(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0()); 
            // InternalOCLX.g:5069:3: ( 'self' )
            // InternalOCLX.g:5070:4: 'self'
            {
             before(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0()); 
            match(input,59,FOLLOW_2); 
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
    // InternalOCLX.g:5081:1: rule__VarDeclaration__NameAssignment : ( ruleSimpleName ) ;
    public final void rule__VarDeclaration__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5085:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5086:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5086:2: ( ruleSimpleName )
            // InternalOCLX.g:5087:3: ruleSimpleName
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
    // InternalOCLX.g:5096:1: rule__VarReference__RefAssignment : ( ( RULE_ID ) ) ;
    public final void rule__VarReference__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5100:1: ( ( ( RULE_ID ) ) )
            // InternalOCLX.g:5101:2: ( ( RULE_ID ) )
            {
            // InternalOCLX.g:5101:2: ( ( RULE_ID ) )
            // InternalOCLX.g:5102:3: ( RULE_ID )
            {
             before(grammarAccess.getVarReferenceAccess().getRefVarDeclarationCrossReference_0()); 
            // InternalOCLX.g:5103:3: ( RULE_ID )
            // InternalOCLX.g:5104:4: RULE_ID
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
    // InternalOCLX.g:5115:1: rule__IntLiteralExp__ValueAssignment : ( RULE_INT ) ;
    public final void rule__IntLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5119:1: ( ( RULE_INT ) )
            // InternalOCLX.g:5120:2: ( RULE_INT )
            {
            // InternalOCLX.g:5120:2: ( RULE_INT )
            // InternalOCLX.g:5121:3: RULE_INT
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
    // InternalOCLX.g:5130:1: rule__StringLiteralExp__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5134:1: ( ( RULE_STRING ) )
            // InternalOCLX.g:5135:2: ( RULE_STRING )
            {
            // InternalOCLX.g:5135:2: ( RULE_STRING )
            // InternalOCLX.g:5136:3: RULE_STRING
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
    // InternalOCLX.g:5145:1: rule__BooleanLiteralExp__ValueAssignment_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralExp__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5149:1: ( ( ( 'true' ) ) )
            // InternalOCLX.g:5150:2: ( ( 'true' ) )
            {
            // InternalOCLX.g:5150:2: ( ( 'true' ) )
            // InternalOCLX.g:5151:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0()); 
            // InternalOCLX.g:5152:3: ( 'true' )
            // InternalOCLX.g:5153:4: 'true'
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0()); 
            match(input,60,FOLLOW_2); 
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
    // InternalOCLX.g:5164:1: rule__BooleanLiteralExp__ValueAssignment_1 : ( ( 'false' ) ) ;
    public final void rule__BooleanLiteralExp__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5168:1: ( ( ( 'false' ) ) )
            // InternalOCLX.g:5169:2: ( ( 'false' ) )
            {
            // InternalOCLX.g:5169:2: ( ( 'false' ) )
            // InternalOCLX.g:5170:3: ( 'false' )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0()); 
            // InternalOCLX.g:5171:3: ( 'false' )
            // InternalOCLX.g:5172:4: 'false'
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0()); 
            match(input,61,FOLLOW_2); 
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
    // InternalOCLX.g:5183:1: rule__FloatLiteralExp__ValueAssignment : ( ruleFloat ) ;
    public final void rule__FloatLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5187:1: ( ( ruleFloat ) )
            // InternalOCLX.g:5188:2: ( ruleFloat )
            {
            // InternalOCLX.g:5188:2: ( ruleFloat )
            // InternalOCLX.g:5189:3: ruleFloat
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
    // InternalOCLX.g:5198:1: rule__CollectionIterator__NameAssignment_0 : ( ruleIteratorName ) ;
    public final void rule__CollectionIterator__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5202:1: ( ( ruleIteratorName ) )
            // InternalOCLX.g:5203:2: ( ruleIteratorName )
            {
            // InternalOCLX.g:5203:2: ( ruleIteratorName )
            // InternalOCLX.g:5204:3: ruleIteratorName
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
    // InternalOCLX.g:5213:1: rule__CollectionIterator__ItervarAssignment_2 : ( ruleIteratorVarDeclaration ) ;
    public final void rule__CollectionIterator__ItervarAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5217:1: ( ( ruleIteratorVarDeclaration ) )
            // InternalOCLX.g:5218:2: ( ruleIteratorVarDeclaration )
            {
            // InternalOCLX.g:5218:2: ( ruleIteratorVarDeclaration )
            // InternalOCLX.g:5219:3: ruleIteratorVarDeclaration
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
    // InternalOCLX.g:5228:1: rule__CollectionIterator__BodyAssignment_4 : ( ruleExp ) ;
    public final void rule__CollectionIterator__BodyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5232:1: ( ( ruleExp ) )
            // InternalOCLX.g:5233:2: ( ruleExp )
            {
            // InternalOCLX.g:5233:2: ( ruleExp )
            // InternalOCLX.g:5234:3: ruleExp
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
    // InternalOCLX.g:5243:1: rule__IteratorName__NameAssignment : ( ( rule__IteratorName__NameAlternatives_0 ) ) ;
    public final void rule__IteratorName__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5247:1: ( ( ( rule__IteratorName__NameAlternatives_0 ) ) )
            // InternalOCLX.g:5248:2: ( ( rule__IteratorName__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:5248:2: ( ( rule__IteratorName__NameAlternatives_0 ) )
            // InternalOCLX.g:5249:3: ( rule__IteratorName__NameAlternatives_0 )
            {
             before(grammarAccess.getIteratorNameAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:5250:3: ( rule__IteratorName__NameAlternatives_0 )
            // InternalOCLX.g:5250:4: rule__IteratorName__NameAlternatives_0
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
    // InternalOCLX.g:5258:1: rule__IteratorVarDeclaration__NameAssignment_0 : ( ruleVarDeclaration ) ;
    public final void rule__IteratorVarDeclaration__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5262:1: ( ( ruleVarDeclaration ) )
            // InternalOCLX.g:5263:2: ( ruleVarDeclaration )
            {
            // InternalOCLX.g:5263:2: ( ruleVarDeclaration )
            // InternalOCLX.g:5264:3: ruleVarDeclaration
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
    // InternalOCLX.g:5273:1: rule__IteratorVarDeclaration__NameAssignment_1_0 : ( ruleVarDeclaration ) ;
    public final void rule__IteratorVarDeclaration__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5277:1: ( ( ruleVarDeclaration ) )
            // InternalOCLX.g:5278:2: ( ruleVarDeclaration )
            {
            // InternalOCLX.g:5278:2: ( ruleVarDeclaration )
            // InternalOCLX.g:5279:3: ruleVarDeclaration
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
    // InternalOCLX.g:5288:1: rule__IteratorVarDeclaration__TypeAssignment_1_2 : ( ruleTypeExp ) ;
    public final void rule__IteratorVarDeclaration__TypeAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5292:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:5293:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:5293:2: ( ruleTypeExp )
            // InternalOCLX.g:5294:3: ruleTypeExp
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
    // InternalOCLX.g:5303:1: rule__PropertyAccess__NameAssignment : ( ruleSimpleName ) ;
    public final void rule__PropertyAccess__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5307:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5308:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5308:2: ( ruleSimpleName )
            // InternalOCLX.g:5309:3: ruleSimpleName
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
    // InternalOCLX.g:5318:1: rule__MethodCall__NameAssignment_0_0 : ( ruleSimpleName ) ;
    public final void rule__MethodCall__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5322:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5323:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5323:2: ( ruleSimpleName )
            // InternalOCLX.g:5324:3: ruleSimpleName
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
    // InternalOCLX.g:5333:1: rule__MethodCall__NameAssignment_1_0 : ( ruleSimpleName ) ;
    public final void rule__MethodCall__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5337:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5338:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5338:2: ( ruleSimpleName )
            // InternalOCLX.g:5339:3: ruleSimpleName
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
    // InternalOCLX.g:5348:1: rule__MethodCall__ArgsAssignment_1_2 : ( ruleArgumentsExp ) ;
    public final void rule__MethodCall__ArgsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5352:1: ( ( ruleArgumentsExp ) )
            // InternalOCLX.g:5353:2: ( ruleArgumentsExp )
            {
            // InternalOCLX.g:5353:2: ( ruleArgumentsExp )
            // InternalOCLX.g:5354:3: ruleArgumentsExp
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
    // InternalOCLX.g:5363:1: rule__TypeCall__NameAssignment_0 : ( ( rule__TypeCall__NameAlternatives_0_0 ) ) ;
    public final void rule__TypeCall__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5367:1: ( ( ( rule__TypeCall__NameAlternatives_0_0 ) ) )
            // InternalOCLX.g:5368:2: ( ( rule__TypeCall__NameAlternatives_0_0 ) )
            {
            // InternalOCLX.g:5368:2: ( ( rule__TypeCall__NameAlternatives_0_0 ) )
            // InternalOCLX.g:5369:3: ( rule__TypeCall__NameAlternatives_0_0 )
            {
             before(grammarAccess.getTypeCallAccess().getNameAlternatives_0_0()); 
            // InternalOCLX.g:5370:3: ( rule__TypeCall__NameAlternatives_0_0 )
            // InternalOCLX.g:5370:4: rule__TypeCall__NameAlternatives_0_0
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
    // InternalOCLX.g:5378:1: rule__TypeCall__TypeAssignment_2 : ( ruleTypeExp ) ;
    public final void rule__TypeCall__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5382:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:5383:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:5383:2: ( ruleTypeExp )
            // InternalOCLX.g:5384:3: ruleTypeExp
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


    // $ANTLR start "rule__TypeExp__NameAssignment_1"
    // InternalOCLX.g:5393:1: rule__TypeExp__NameAssignment_1 : ( RULE_URI ) ;
    public final void rule__TypeExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5397:1: ( ( RULE_URI ) )
            // InternalOCLX.g:5398:2: ( RULE_URI )
            {
            // InternalOCLX.g:5398:2: ( RULE_URI )
            // InternalOCLX.g:5399:3: RULE_URI
            {
             before(grammarAccess.getTypeExpAccess().getNameURITerminalRuleCall_1_0()); 
            match(input,RULE_URI,FOLLOW_2); 
             after(grammarAccess.getTypeExpAccess().getNameURITerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TypeExp__NameAssignment_1"


    // $ANTLR start "rule__UnaryTemporalExp__NameAssignment_0"
    // InternalOCLX.g:5408:1: rule__UnaryTemporalExp__NameAssignment_0 : ( ruleUnaryTemporalOp ) ;
    public final void rule__UnaryTemporalExp__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5412:1: ( ( ruleUnaryTemporalOp ) )
            // InternalOCLX.g:5413:2: ( ruleUnaryTemporalOp )
            {
            // InternalOCLX.g:5413:2: ( ruleUnaryTemporalOp )
            // InternalOCLX.g:5414:3: ruleUnaryTemporalOp
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
    // InternalOCLX.g:5423:1: rule__UnaryTemporalExp__ExpAssignment_2 : ( ruleExp ) ;
    public final void rule__UnaryTemporalExp__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5427:1: ( ( ruleExp ) )
            // InternalOCLX.g:5428:2: ( ruleExp )
            {
            // InternalOCLX.g:5428:2: ( ruleExp )
            // InternalOCLX.g:5429:3: ruleExp
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
    // InternalOCLX.g:5438:1: rule__TemporalAsLongAs__NameAssignment_0 : ( ( 'asLongAs' ) ) ;
    public final void rule__TemporalAsLongAs__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5442:1: ( ( ( 'asLongAs' ) ) )
            // InternalOCLX.g:5443:2: ( ( 'asLongAs' ) )
            {
            // InternalOCLX.g:5443:2: ( ( 'asLongAs' ) )
            // InternalOCLX.g:5444:3: ( 'asLongAs' )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0()); 
            // InternalOCLX.g:5445:3: ( 'asLongAs' )
            // InternalOCLX.g:5446:4: 'asLongAs'
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0()); 
            match(input,55,FOLLOW_2); 
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
    // InternalOCLX.g:5457:1: rule__TemporalAsLongAs__BAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalAsLongAs__BAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5461:1: ( ( ruleExp ) )
            // InternalOCLX.g:5462:2: ( ruleExp )
            {
            // InternalOCLX.g:5462:2: ( ruleExp )
            // InternalOCLX.g:5463:3: ruleExp
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
    // InternalOCLX.g:5472:1: rule__TemporalAsLongAs__AAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalAsLongAs__AAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5476:1: ( ( ruleExp ) )
            // InternalOCLX.g:5477:2: ( ruleExp )
            {
            // InternalOCLX.g:5477:2: ( ruleExp )
            // InternalOCLX.g:5478:3: ruleExp
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
    // InternalOCLX.g:5487:1: rule__TemporalUntil__NameAssignment_0 : ( ( 'ensureThat' ) ) ;
    public final void rule__TemporalUntil__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5491:1: ( ( ( 'ensureThat' ) ) )
            // InternalOCLX.g:5492:2: ( ( 'ensureThat' ) )
            {
            // InternalOCLX.g:5492:2: ( ( 'ensureThat' ) )
            // InternalOCLX.g:5493:3: ( 'ensureThat' )
            {
             before(grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0()); 
            // InternalOCLX.g:5494:3: ( 'ensureThat' )
            // InternalOCLX.g:5495:4: 'ensureThat'
            {
             before(grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0()); 
            match(input,54,FOLLOW_2); 
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
    // InternalOCLX.g:5506:1: rule__TemporalUntil__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalUntil__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5510:1: ( ( ruleExp ) )
            // InternalOCLX.g:5511:2: ( ruleExp )
            {
            // InternalOCLX.g:5511:2: ( ruleExp )
            // InternalOCLX.g:5512:3: ruleExp
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
    // InternalOCLX.g:5521:1: rule__TemporalUntil__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalUntil__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5525:1: ( ( ruleExp ) )
            // InternalOCLX.g:5526:2: ( ruleExp )
            {
            // InternalOCLX.g:5526:2: ( ruleExp )
            // InternalOCLX.g:5527:3: ruleExp
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
    // InternalOCLX.g:5536:1: rule__TemporalEverytime__NameAssignment_0 : ( ( 'everyTime' ) ) ;
    public final void rule__TemporalEverytime__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5540:1: ( ( ( 'everyTime' ) ) )
            // InternalOCLX.g:5541:2: ( ( 'everyTime' ) )
            {
            // InternalOCLX.g:5541:2: ( ( 'everyTime' ) )
            // InternalOCLX.g:5542:3: ( 'everyTime' )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0()); 
            // InternalOCLX.g:5543:3: ( 'everyTime' )
            // InternalOCLX.g:5544:4: 'everyTime'
            {
             before(grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0()); 
            match(input,62,FOLLOW_2); 
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
    // InternalOCLX.g:5555:1: rule__TemporalEverytime__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalEverytime__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5559:1: ( ( ruleExp ) )
            // InternalOCLX.g:5560:2: ( ruleExp )
            {
            // InternalOCLX.g:5560:2: ( ruleExp )
            // InternalOCLX.g:5561:3: ruleExp
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
    // InternalOCLX.g:5570:1: rule__TemporalEverytime__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalEverytime__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5574:1: ( ( ruleExp ) )
            // InternalOCLX.g:5575:2: ( ruleExp )
            {
            // InternalOCLX.g:5575:2: ( ruleExp )
            // InternalOCLX.g:5576:3: ruleExp
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
    // InternalOCLX.g:5585:1: rule__TemporalAtLeastOnce__NameAssignment_0 : ( ( 'whenOnce' ) ) ;
    public final void rule__TemporalAtLeastOnce__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5589:1: ( ( ( 'whenOnce' ) ) )
            // InternalOCLX.g:5590:2: ( ( 'whenOnce' ) )
            {
            // InternalOCLX.g:5590:2: ( ( 'whenOnce' ) )
            // InternalOCLX.g:5591:3: ( 'whenOnce' )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0()); 
            // InternalOCLX.g:5592:3: ( 'whenOnce' )
            // InternalOCLX.g:5593:4: 'whenOnce'
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0()); 
            match(input,63,FOLLOW_2); 
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
    // InternalOCLX.g:5604:1: rule__TemporalAtLeastOnce__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalAtLeastOnce__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5608:1: ( ( ruleExp ) )
            // InternalOCLX.g:5609:2: ( ruleExp )
            {
            // InternalOCLX.g:5609:2: ( ruleExp )
            // InternalOCLX.g:5610:3: ruleExp
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
    // InternalOCLX.g:5619:1: rule__TemporalAtLeastOnce__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalAtLeastOnce__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5623:1: ( ( ruleExp ) )
            // InternalOCLX.g:5624:2: ( ruleExp )
            {
            // InternalOCLX.g:5624:2: ( ruleExp )
            // InternalOCLX.g:5625:3: ruleExp
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
    // InternalOCLX.g:5634:1: rule__LegacyUntil__NameAssignment_0 : ( ( 'until' ) ) ;
    public final void rule__LegacyUntil__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5638:1: ( ( ( 'until' ) ) )
            // InternalOCLX.g:5639:2: ( ( 'until' ) )
            {
            // InternalOCLX.g:5639:2: ( ( 'until' ) )
            // InternalOCLX.g:5640:3: ( 'until' )
            {
             before(grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0()); 
            // InternalOCLX.g:5641:3: ( 'until' )
            // InternalOCLX.g:5642:4: 'until'
            {
             before(grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0()); 
            match(input,64,FOLLOW_2); 
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
    // InternalOCLX.g:5653:1: rule__LegacyUntil__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyUntil__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5657:1: ( ( ruleExp ) )
            // InternalOCLX.g:5658:2: ( ruleExp )
            {
            // InternalOCLX.g:5658:2: ( ruleExp )
            // InternalOCLX.g:5659:3: ruleExp
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
    // InternalOCLX.g:5668:1: rule__LegacyUntil__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyUntil__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5672:1: ( ( ruleExp ) )
            // InternalOCLX.g:5673:2: ( ruleExp )
            {
            // InternalOCLX.g:5673:2: ( ruleExp )
            // InternalOCLX.g:5674:3: ruleExp
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
    // InternalOCLX.g:5683:1: rule__LegacyAsSoonAs__NameAssignment_0 : ( ( 'asSoonAs' ) ) ;
    public final void rule__LegacyAsSoonAs__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5687:1: ( ( ( 'asSoonAs' ) ) )
            // InternalOCLX.g:5688:2: ( ( 'asSoonAs' ) )
            {
            // InternalOCLX.g:5688:2: ( ( 'asSoonAs' ) )
            // InternalOCLX.g:5689:3: ( 'asSoonAs' )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0()); 
            // InternalOCLX.g:5690:3: ( 'asSoonAs' )
            // InternalOCLX.g:5691:4: 'asSoonAs'
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0()); 
            match(input,65,FOLLOW_2); 
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
    // InternalOCLX.g:5702:1: rule__LegacyAsSoonAs__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyAsSoonAs__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5706:1: ( ( ruleExp ) )
            // InternalOCLX.g:5707:2: ( ruleExp )
            {
            // InternalOCLX.g:5707:2: ( ruleExp )
            // InternalOCLX.g:5708:3: ruleExp
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
    // InternalOCLX.g:5717:1: rule__LegacyAsSoonAs__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyAsSoonAs__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5721:1: ( ( ruleExp ) )
            // InternalOCLX.g:5722:2: ( ruleExp )
            {
            // InternalOCLX.g:5722:2: ( ruleExp )
            // InternalOCLX.g:5723:3: ruleExp
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
    // InternalOCLX.g:5732:1: rule__LegacyEverytime__NameAssignment_0 : ( ( 'everytime' ) ) ;
    public final void rule__LegacyEverytime__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5736:1: ( ( ( 'everytime' ) ) )
            // InternalOCLX.g:5737:2: ( ( 'everytime' ) )
            {
            // InternalOCLX.g:5737:2: ( ( 'everytime' ) )
            // InternalOCLX.g:5738:3: ( 'everytime' )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0()); 
            // InternalOCLX.g:5739:3: ( 'everytime' )
            // InternalOCLX.g:5740:4: 'everytime'
            {
             before(grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0()); 
            match(input,66,FOLLOW_2); 
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
    // InternalOCLX.g:5751:1: rule__LegacyEverytime__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyEverytime__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5755:1: ( ( ruleExp ) )
            // InternalOCLX.g:5756:2: ( ruleExp )
            {
            // InternalOCLX.g:5756:2: ( ruleExp )
            // InternalOCLX.g:5757:3: ruleExp
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
    // InternalOCLX.g:5766:1: rule__LegacyEverytime__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyEverytime__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5770:1: ( ( ruleExp ) )
            // InternalOCLX.g:5771:2: ( ruleExp )
            {
            // InternalOCLX.g:5771:2: ( ruleExp )
            // InternalOCLX.g:5772:3: ruleExp
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
    // InternalOCLX.g:5781:1: rule__ArgumentsExp__OperatorsAssignment_0 : ( ruleExp ) ;
    public final void rule__ArgumentsExp__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5785:1: ( ( ruleExp ) )
            // InternalOCLX.g:5786:2: ( ruleExp )
            {
            // InternalOCLX.g:5786:2: ( ruleExp )
            // InternalOCLX.g:5787:3: ruleExp
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
    // InternalOCLX.g:5796:1: rule__ArgumentsExp__OperatorsAssignment_1_1 : ( ruleExp ) ;
    public final void rule__ArgumentsExp__OperatorsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5800:1: ( ( ruleExp ) )
            // InternalOCLX.g:5801:2: ( ruleExp )
            {
            // InternalOCLX.g:5801:2: ( ruleExp )
            // InternalOCLX.g:5802:3: ruleExp
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000C80000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0xF8C201C0240000B0L,0x0000000000000007L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000007FFE000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000007FFE002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000024000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000003FC0000010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0400000000000002L});

}