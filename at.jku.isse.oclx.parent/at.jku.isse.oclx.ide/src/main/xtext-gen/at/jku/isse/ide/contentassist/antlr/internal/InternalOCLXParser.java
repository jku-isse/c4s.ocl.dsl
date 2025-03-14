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
    // InternalOCLX.g:262:1: ruleBinaryOperator : ( ( rule__BinaryOperator__Alternatives ) ) ;
    public final void ruleBinaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:266:2: ( ( ( rule__BinaryOperator__Alternatives ) ) )
            // InternalOCLX.g:267:2: ( ( rule__BinaryOperator__Alternatives ) )
            {
            // InternalOCLX.g:267:2: ( ( rule__BinaryOperator__Alternatives ) )
            // InternalOCLX.g:268:3: ( rule__BinaryOperator__Alternatives )
            {
             before(grammarAccess.getBinaryOperatorAccess().getAlternatives()); 
            // InternalOCLX.g:269:3: ( rule__BinaryOperator__Alternatives )
            // InternalOCLX.g:269:4: rule__BinaryOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BinaryOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBinaryOperatorAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleNavigationExp"
    // InternalOCLX.g:428:1: entryRuleNavigationExp : ruleNavigationExp EOF ;
    public final void entryRuleNavigationExp() throws RecognitionException {
        try {
            // InternalOCLX.g:429:1: ( ruleNavigationExp EOF )
            // InternalOCLX.g:430:1: ruleNavigationExp EOF
            {
             before(grammarAccess.getNavigationExpRule()); 
            pushFollow(FOLLOW_1);
            ruleNavigationExp();

            state._fsp--;

             after(grammarAccess.getNavigationExpRule()); 
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
    // $ANTLR end "entryRuleNavigationExp"


    // $ANTLR start "ruleNavigationExp"
    // InternalOCLX.g:437:1: ruleNavigationExp : ( ( rule__NavigationExp__Group__0 ) ) ;
    public final void ruleNavigationExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:441:2: ( ( ( rule__NavigationExp__Group__0 ) ) )
            // InternalOCLX.g:442:2: ( ( rule__NavigationExp__Group__0 ) )
            {
            // InternalOCLX.g:442:2: ( ( rule__NavigationExp__Group__0 ) )
            // InternalOCLX.g:443:3: ( rule__NavigationExp__Group__0 )
            {
             before(grammarAccess.getNavigationExpAccess().getGroup()); 
            // InternalOCLX.g:444:3: ( rule__NavigationExp__Group__0 )
            // InternalOCLX.g:444:4: rule__NavigationExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NavigationExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNavigationExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNavigationExp"


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


    // $ANTLR start "entryRuleIntLiteralExp"
    // InternalOCLX.g:553:1: entryRuleIntLiteralExp : ruleIntLiteralExp EOF ;
    public final void entryRuleIntLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:554:1: ( ruleIntLiteralExp EOF )
            // InternalOCLX.g:555:1: ruleIntLiteralExp EOF
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
    // InternalOCLX.g:562:1: ruleIntLiteralExp : ( ( rule__IntLiteralExp__ValueAssignment ) ) ;
    public final void ruleIntLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:566:2: ( ( ( rule__IntLiteralExp__ValueAssignment ) ) )
            // InternalOCLX.g:567:2: ( ( rule__IntLiteralExp__ValueAssignment ) )
            {
            // InternalOCLX.g:567:2: ( ( rule__IntLiteralExp__ValueAssignment ) )
            // InternalOCLX.g:568:3: ( rule__IntLiteralExp__ValueAssignment )
            {
             before(grammarAccess.getIntLiteralExpAccess().getValueAssignment()); 
            // InternalOCLX.g:569:3: ( rule__IntLiteralExp__ValueAssignment )
            // InternalOCLX.g:569:4: rule__IntLiteralExp__ValueAssignment
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


    // $ANTLR start "entryRuleFloatLiteralExp"
    // InternalOCLX.g:628:1: entryRuleFloatLiteralExp : ruleFloatLiteralExp EOF ;
    public final void entryRuleFloatLiteralExp() throws RecognitionException {
        try {
            // InternalOCLX.g:629:1: ( ruleFloatLiteralExp EOF )
            // InternalOCLX.g:630:1: ruleFloatLiteralExp EOF
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
    // InternalOCLX.g:637:1: ruleFloatLiteralExp : ( ( rule__FloatLiteralExp__ValueAssignment ) ) ;
    public final void ruleFloatLiteralExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:641:2: ( ( ( rule__FloatLiteralExp__ValueAssignment ) ) )
            // InternalOCLX.g:642:2: ( ( rule__FloatLiteralExp__ValueAssignment ) )
            {
            // InternalOCLX.g:642:2: ( ( rule__FloatLiteralExp__ValueAssignment ) )
            // InternalOCLX.g:643:3: ( rule__FloatLiteralExp__ValueAssignment )
            {
             before(grammarAccess.getFloatLiteralExpAccess().getValueAssignment()); 
            // InternalOCLX.g:644:3: ( rule__FloatLiteralExp__ValueAssignment )
            // InternalOCLX.g:644:4: rule__FloatLiteralExp__ValueAssignment
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
    // InternalOCLX.g:837:1: ruleTypeExp : ( ( rule__TypeExp__Group__0 ) ) ;
    public final void ruleTypeExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:841:2: ( ( ( rule__TypeExp__Group__0 ) ) )
            // InternalOCLX.g:842:2: ( ( rule__TypeExp__Group__0 ) )
            {
            // InternalOCLX.g:842:2: ( ( rule__TypeExp__Group__0 ) )
            // InternalOCLX.g:843:3: ( rule__TypeExp__Group__0 )
            {
             before(grammarAccess.getTypeExpAccess().getGroup()); 
            // InternalOCLX.g:844:3: ( rule__TypeExp__Group__0 )
            // InternalOCLX.g:844:4: rule__TypeExp__Group__0
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
    // InternalOCLX.g:853:1: entryRuleTemporalExp : ruleTemporalExp EOF ;
    public final void entryRuleTemporalExp() throws RecognitionException {
        try {
            // InternalOCLX.g:854:1: ( ruleTemporalExp EOF )
            // InternalOCLX.g:855:1: ruleTemporalExp EOF
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
    // InternalOCLX.g:862:1: ruleTemporalExp : ( ( rule__TemporalExp__Alternatives ) ) ;
    public final void ruleTemporalExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:866:2: ( ( ( rule__TemporalExp__Alternatives ) ) )
            // InternalOCLX.g:867:2: ( ( rule__TemporalExp__Alternatives ) )
            {
            // InternalOCLX.g:867:2: ( ( rule__TemporalExp__Alternatives ) )
            // InternalOCLX.g:868:3: ( rule__TemporalExp__Alternatives )
            {
             before(grammarAccess.getTemporalExpAccess().getAlternatives()); 
            // InternalOCLX.g:869:3: ( rule__TemporalExp__Alternatives )
            // InternalOCLX.g:869:4: rule__TemporalExp__Alternatives
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
    // InternalOCLX.g:878:1: entryRuleUnaryTemporalExp : ruleUnaryTemporalExp EOF ;
    public final void entryRuleUnaryTemporalExp() throws RecognitionException {
        try {
            // InternalOCLX.g:879:1: ( ruleUnaryTemporalExp EOF )
            // InternalOCLX.g:880:1: ruleUnaryTemporalExp EOF
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
    // InternalOCLX.g:887:1: ruleUnaryTemporalExp : ( ( rule__UnaryTemporalExp__Group__0 ) ) ;
    public final void ruleUnaryTemporalExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:891:2: ( ( ( rule__UnaryTemporalExp__Group__0 ) ) )
            // InternalOCLX.g:892:2: ( ( rule__UnaryTemporalExp__Group__0 ) )
            {
            // InternalOCLX.g:892:2: ( ( rule__UnaryTemporalExp__Group__0 ) )
            // InternalOCLX.g:893:3: ( rule__UnaryTemporalExp__Group__0 )
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getGroup()); 
            // InternalOCLX.g:894:3: ( rule__UnaryTemporalExp__Group__0 )
            // InternalOCLX.g:894:4: rule__UnaryTemporalExp__Group__0
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
    // InternalOCLX.g:903:1: entryRuleUnaryTemporalOp : ruleUnaryTemporalOp EOF ;
    public final void entryRuleUnaryTemporalOp() throws RecognitionException {
        try {
            // InternalOCLX.g:904:1: ( ruleUnaryTemporalOp EOF )
            // InternalOCLX.g:905:1: ruleUnaryTemporalOp EOF
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
    // InternalOCLX.g:912:1: ruleUnaryTemporalOp : ( ( rule__UnaryTemporalOp__Alternatives ) ) ;
    public final void ruleUnaryTemporalOp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:916:2: ( ( ( rule__UnaryTemporalOp__Alternatives ) ) )
            // InternalOCLX.g:917:2: ( ( rule__UnaryTemporalOp__Alternatives ) )
            {
            // InternalOCLX.g:917:2: ( ( rule__UnaryTemporalOp__Alternatives ) )
            // InternalOCLX.g:918:3: ( rule__UnaryTemporalOp__Alternatives )
            {
             before(grammarAccess.getUnaryTemporalOpAccess().getAlternatives()); 
            // InternalOCLX.g:919:3: ( rule__UnaryTemporalOp__Alternatives )
            // InternalOCLX.g:919:4: rule__UnaryTemporalOp__Alternatives
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
    // InternalOCLX.g:928:1: entryRuleTriggeredTemporalExp : ruleTriggeredTemporalExp EOF ;
    public final void entryRuleTriggeredTemporalExp() throws RecognitionException {
        try {
            // InternalOCLX.g:929:1: ( ruleTriggeredTemporalExp EOF )
            // InternalOCLX.g:930:1: ruleTriggeredTemporalExp EOF
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
    // InternalOCLX.g:937:1: ruleTriggeredTemporalExp : ( ( rule__TriggeredTemporalExp__Alternatives ) ) ;
    public final void ruleTriggeredTemporalExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:941:2: ( ( ( rule__TriggeredTemporalExp__Alternatives ) ) )
            // InternalOCLX.g:942:2: ( ( rule__TriggeredTemporalExp__Alternatives ) )
            {
            // InternalOCLX.g:942:2: ( ( rule__TriggeredTemporalExp__Alternatives ) )
            // InternalOCLX.g:943:3: ( rule__TriggeredTemporalExp__Alternatives )
            {
             before(grammarAccess.getTriggeredTemporalExpAccess().getAlternatives()); 
            // InternalOCLX.g:944:3: ( rule__TriggeredTemporalExp__Alternatives )
            // InternalOCLX.g:944:4: rule__TriggeredTemporalExp__Alternatives
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
    // InternalOCLX.g:953:1: entryRuleTemporalAsLongAs : ruleTemporalAsLongAs EOF ;
    public final void entryRuleTemporalAsLongAs() throws RecognitionException {
        try {
            // InternalOCLX.g:954:1: ( ruleTemporalAsLongAs EOF )
            // InternalOCLX.g:955:1: ruleTemporalAsLongAs EOF
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
    // InternalOCLX.g:962:1: ruleTemporalAsLongAs : ( ( rule__TemporalAsLongAs__Group__0 ) ) ;
    public final void ruleTemporalAsLongAs() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:966:2: ( ( ( rule__TemporalAsLongAs__Group__0 ) ) )
            // InternalOCLX.g:967:2: ( ( rule__TemporalAsLongAs__Group__0 ) )
            {
            // InternalOCLX.g:967:2: ( ( rule__TemporalAsLongAs__Group__0 ) )
            // InternalOCLX.g:968:3: ( rule__TemporalAsLongAs__Group__0 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getGroup()); 
            // InternalOCLX.g:969:3: ( rule__TemporalAsLongAs__Group__0 )
            // InternalOCLX.g:969:4: rule__TemporalAsLongAs__Group__0
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
    // InternalOCLX.g:978:1: entryRuleTemporalUntil : ruleTemporalUntil EOF ;
    public final void entryRuleTemporalUntil() throws RecognitionException {
        try {
            // InternalOCLX.g:979:1: ( ruleTemporalUntil EOF )
            // InternalOCLX.g:980:1: ruleTemporalUntil EOF
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
    // InternalOCLX.g:987:1: ruleTemporalUntil : ( ( rule__TemporalUntil__Group__0 ) ) ;
    public final void ruleTemporalUntil() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:991:2: ( ( ( rule__TemporalUntil__Group__0 ) ) )
            // InternalOCLX.g:992:2: ( ( rule__TemporalUntil__Group__0 ) )
            {
            // InternalOCLX.g:992:2: ( ( rule__TemporalUntil__Group__0 ) )
            // InternalOCLX.g:993:3: ( rule__TemporalUntil__Group__0 )
            {
             before(grammarAccess.getTemporalUntilAccess().getGroup()); 
            // InternalOCLX.g:994:3: ( rule__TemporalUntil__Group__0 )
            // InternalOCLX.g:994:4: rule__TemporalUntil__Group__0
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
    // InternalOCLX.g:1003:1: entryRuleTemporalEverytime : ruleTemporalEverytime EOF ;
    public final void entryRuleTemporalEverytime() throws RecognitionException {
        try {
            // InternalOCLX.g:1004:1: ( ruleTemporalEverytime EOF )
            // InternalOCLX.g:1005:1: ruleTemporalEverytime EOF
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
    // InternalOCLX.g:1012:1: ruleTemporalEverytime : ( ( rule__TemporalEverytime__Group__0 ) ) ;
    public final void ruleTemporalEverytime() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1016:2: ( ( ( rule__TemporalEverytime__Group__0 ) ) )
            // InternalOCLX.g:1017:2: ( ( rule__TemporalEverytime__Group__0 ) )
            {
            // InternalOCLX.g:1017:2: ( ( rule__TemporalEverytime__Group__0 ) )
            // InternalOCLX.g:1018:3: ( rule__TemporalEverytime__Group__0 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getGroup()); 
            // InternalOCLX.g:1019:3: ( rule__TemporalEverytime__Group__0 )
            // InternalOCLX.g:1019:4: rule__TemporalEverytime__Group__0
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
    // InternalOCLX.g:1028:1: entryRuleTemporalAtLeastOnce : ruleTemporalAtLeastOnce EOF ;
    public final void entryRuleTemporalAtLeastOnce() throws RecognitionException {
        try {
            // InternalOCLX.g:1029:1: ( ruleTemporalAtLeastOnce EOF )
            // InternalOCLX.g:1030:1: ruleTemporalAtLeastOnce EOF
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
    // InternalOCLX.g:1037:1: ruleTemporalAtLeastOnce : ( ( rule__TemporalAtLeastOnce__Group__0 ) ) ;
    public final void ruleTemporalAtLeastOnce() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1041:2: ( ( ( rule__TemporalAtLeastOnce__Group__0 ) ) )
            // InternalOCLX.g:1042:2: ( ( rule__TemporalAtLeastOnce__Group__0 ) )
            {
            // InternalOCLX.g:1042:2: ( ( rule__TemporalAtLeastOnce__Group__0 ) )
            // InternalOCLX.g:1043:3: ( rule__TemporalAtLeastOnce__Group__0 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getGroup()); 
            // InternalOCLX.g:1044:3: ( rule__TemporalAtLeastOnce__Group__0 )
            // InternalOCLX.g:1044:4: rule__TemporalAtLeastOnce__Group__0
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
    // InternalOCLX.g:1053:1: entryRuleLegacyUntil : ruleLegacyUntil EOF ;
    public final void entryRuleLegacyUntil() throws RecognitionException {
        try {
            // InternalOCLX.g:1054:1: ( ruleLegacyUntil EOF )
            // InternalOCLX.g:1055:1: ruleLegacyUntil EOF
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
    // InternalOCLX.g:1062:1: ruleLegacyUntil : ( ( rule__LegacyUntil__Group__0 ) ) ;
    public final void ruleLegacyUntil() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1066:2: ( ( ( rule__LegacyUntil__Group__0 ) ) )
            // InternalOCLX.g:1067:2: ( ( rule__LegacyUntil__Group__0 ) )
            {
            // InternalOCLX.g:1067:2: ( ( rule__LegacyUntil__Group__0 ) )
            // InternalOCLX.g:1068:3: ( rule__LegacyUntil__Group__0 )
            {
             before(grammarAccess.getLegacyUntilAccess().getGroup()); 
            // InternalOCLX.g:1069:3: ( rule__LegacyUntil__Group__0 )
            // InternalOCLX.g:1069:4: rule__LegacyUntil__Group__0
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
    // InternalOCLX.g:1078:1: entryRuleLegacyAsSoonAs : ruleLegacyAsSoonAs EOF ;
    public final void entryRuleLegacyAsSoonAs() throws RecognitionException {
        try {
            // InternalOCLX.g:1079:1: ( ruleLegacyAsSoonAs EOF )
            // InternalOCLX.g:1080:1: ruleLegacyAsSoonAs EOF
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
    // InternalOCLX.g:1087:1: ruleLegacyAsSoonAs : ( ( rule__LegacyAsSoonAs__Group__0 ) ) ;
    public final void ruleLegacyAsSoonAs() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1091:2: ( ( ( rule__LegacyAsSoonAs__Group__0 ) ) )
            // InternalOCLX.g:1092:2: ( ( rule__LegacyAsSoonAs__Group__0 ) )
            {
            // InternalOCLX.g:1092:2: ( ( rule__LegacyAsSoonAs__Group__0 ) )
            // InternalOCLX.g:1093:3: ( rule__LegacyAsSoonAs__Group__0 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getGroup()); 
            // InternalOCLX.g:1094:3: ( rule__LegacyAsSoonAs__Group__0 )
            // InternalOCLX.g:1094:4: rule__LegacyAsSoonAs__Group__0
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
    // InternalOCLX.g:1103:1: entryRuleLegacyEverytime : ruleLegacyEverytime EOF ;
    public final void entryRuleLegacyEverytime() throws RecognitionException {
        try {
            // InternalOCLX.g:1104:1: ( ruleLegacyEverytime EOF )
            // InternalOCLX.g:1105:1: ruleLegacyEverytime EOF
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
    // InternalOCLX.g:1112:1: ruleLegacyEverytime : ( ( rule__LegacyEverytime__Group__0 ) ) ;
    public final void ruleLegacyEverytime() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1116:2: ( ( ( rule__LegacyEverytime__Group__0 ) ) )
            // InternalOCLX.g:1117:2: ( ( rule__LegacyEverytime__Group__0 ) )
            {
            // InternalOCLX.g:1117:2: ( ( rule__LegacyEverytime__Group__0 ) )
            // InternalOCLX.g:1118:3: ( rule__LegacyEverytime__Group__0 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getGroup()); 
            // InternalOCLX.g:1119:3: ( rule__LegacyEverytime__Group__0 )
            // InternalOCLX.g:1119:4: rule__LegacyEverytime__Group__0
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
    // InternalOCLX.g:1128:1: entryRuleArgumentsExp : ruleArgumentsExp EOF ;
    public final void entryRuleArgumentsExp() throws RecognitionException {
        try {
            // InternalOCLX.g:1129:1: ( ruleArgumentsExp EOF )
            // InternalOCLX.g:1130:1: ruleArgumentsExp EOF
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
    // InternalOCLX.g:1137:1: ruleArgumentsExp : ( ( rule__ArgumentsExp__Group__0 ) ) ;
    public final void ruleArgumentsExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1141:2: ( ( ( rule__ArgumentsExp__Group__0 ) ) )
            // InternalOCLX.g:1142:2: ( ( rule__ArgumentsExp__Group__0 ) )
            {
            // InternalOCLX.g:1142:2: ( ( rule__ArgumentsExp__Group__0 ) )
            // InternalOCLX.g:1143:3: ( rule__ArgumentsExp__Group__0 )
            {
             before(grammarAccess.getArgumentsExpAccess().getGroup()); 
            // InternalOCLX.g:1144:3: ( rule__ArgumentsExp__Group__0 )
            // InternalOCLX.g:1144:4: rule__ArgumentsExp__Group__0
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
    // InternalOCLX.g:1152:1: rule__PrefixedExp__Alternatives : ( ( ( rule__PrefixedExp__Group_0__0 ) ) | ( rulePrimaryExp ) );
    public final void rule__PrefixedExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1156:1: ( ( ( rule__PrefixedExp__Group_0__0 ) ) | ( rulePrimaryExp ) )
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
                    // InternalOCLX.g:1157:2: ( ( rule__PrefixedExp__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1157:2: ( ( rule__PrefixedExp__Group_0__0 ) )
                    // InternalOCLX.g:1158:3: ( rule__PrefixedExp__Group_0__0 )
                    {
                     before(grammarAccess.getPrefixedExpAccess().getGroup_0()); 
                    // InternalOCLX.g:1159:3: ( rule__PrefixedExp__Group_0__0 )
                    // InternalOCLX.g:1159:4: rule__PrefixedExp__Group_0__0
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
                    // InternalOCLX.g:1163:2: ( rulePrimaryExp )
                    {
                    // InternalOCLX.g:1163:2: ( rulePrimaryExp )
                    // InternalOCLX.g:1164:3: rulePrimaryExp
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


    // $ANTLR start "rule__BinaryOperator__Alternatives"
    // InternalOCLX.g:1173:1: rule__BinaryOperator__Alternatives : ( ( ruleBooleanOperator ) | ( ruleMathOperator ) );
    public final void rule__BinaryOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1177:1: ( ( ruleBooleanOperator ) | ( ruleMathOperator ) )
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
                    // InternalOCLX.g:1178:2: ( ruleBooleanOperator )
                    {
                    // InternalOCLX.g:1178:2: ( ruleBooleanOperator )
                    // InternalOCLX.g:1179:3: ruleBooleanOperator
                    {
                     before(grammarAccess.getBinaryOperatorAccess().getBooleanOperatorParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanOperator();

                    state._fsp--;

                     after(grammarAccess.getBinaryOperatorAccess().getBooleanOperatorParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1184:2: ( ruleMathOperator )
                    {
                    // InternalOCLX.g:1184:2: ( ruleMathOperator )
                    // InternalOCLX.g:1185:3: ruleMathOperator
                    {
                     before(grammarAccess.getBinaryOperatorAccess().getMathOperatorParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleMathOperator();

                    state._fsp--;

                     after(grammarAccess.getBinaryOperatorAccess().getMathOperatorParserRuleCall_1()); 

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
    // $ANTLR end "rule__BinaryOperator__Alternatives"


    // $ANTLR start "rule__BooleanOperator__OpAlternatives_0"
    // InternalOCLX.g:1194:1: rule__BooleanOperator__OpAlternatives_0 : ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '!=' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) );
    public final void rule__BooleanOperator__OpAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1198:1: ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) | ( '=' ) | ( '!=' ) | ( 'and' ) | ( 'or' ) | ( 'xor' ) | ( 'implies' ) )
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
                    // InternalOCLX.g:1199:2: ( '>' )
                    {
                    // InternalOCLX.g:1199:2: ( '>' )
                    // InternalOCLX.g:1200:3: '>'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1205:2: ( '<' )
                    {
                    // InternalOCLX.g:1205:2: ( '<' )
                    // InternalOCLX.g:1206:3: '<'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1211:2: ( '>=' )
                    {
                    // InternalOCLX.g:1211:2: ( '>=' )
                    // InternalOCLX.g:1212:3: '>='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1217:2: ( '<=' )
                    {
                    // InternalOCLX.g:1217:2: ( '<=' )
                    // InternalOCLX.g:1218:3: '<='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1223:2: ( '=' )
                    {
                    // InternalOCLX.g:1223:2: ( '=' )
                    // InternalOCLX.g:1224:3: '='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalOCLX.g:1229:2: ( '!=' )
                    {
                    // InternalOCLX.g:1229:2: ( '!=' )
                    // InternalOCLX.g:1230:3: '!='
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpExclamationMarkEqualsSignKeyword_0_5()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpExclamationMarkEqualsSignKeyword_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalOCLX.g:1235:2: ( 'and' )
                    {
                    // InternalOCLX.g:1235:2: ( 'and' )
                    // InternalOCLX.g:1236:3: 'and'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalOCLX.g:1241:2: ( 'or' )
                    {
                    // InternalOCLX.g:1241:2: ( 'or' )
                    // InternalOCLX.g:1242:3: 'or'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalOCLX.g:1247:2: ( 'xor' )
                    {
                    // InternalOCLX.g:1247:2: ( 'xor' )
                    // InternalOCLX.g:1248:3: 'xor'
                    {
                     before(grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalOCLX.g:1253:2: ( 'implies' )
                    {
                    // InternalOCLX.g:1253:2: ( 'implies' )
                    // InternalOCLX.g:1254:3: 'implies'
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
    // InternalOCLX.g:1263:1: rule__MathOperator__OpAlternatives_0 : ( ( '*' ) | ( '/' ) | ( '+' ) | ( '-' ) );
    public final void rule__MathOperator__OpAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1267:1: ( ( '*' ) | ( '/' ) | ( '+' ) | ( '-' ) )
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
                    // InternalOCLX.g:1268:2: ( '*' )
                    {
                    // InternalOCLX.g:1268:2: ( '*' )
                    // InternalOCLX.g:1269:3: '*'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1274:2: ( '/' )
                    {
                    // InternalOCLX.g:1274:2: ( '/' )
                    // InternalOCLX.g:1275:3: '/'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1280:2: ( '+' )
                    {
                    // InternalOCLX.g:1280:2: ( '+' )
                    // InternalOCLX.g:1281:3: '+'
                    {
                     before(grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1286:2: ( '-' )
                    {
                    // InternalOCLX.g:1286:2: ( '-' )
                    // InternalOCLX.g:1287:3: '-'
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
    // InternalOCLX.g:1296:1: rule__NavigationOperator__NameAlternatives_0 : ( ( '.' ) | ( '->' ) );
    public final void rule__NavigationOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1300:1: ( ( '.' ) | ( '->' ) )
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
                    // InternalOCLX.g:1301:2: ( '.' )
                    {
                    // InternalOCLX.g:1301:2: ( '.' )
                    // InternalOCLX.g:1302:3: '.'
                    {
                     before(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1307:2: ( '->' )
                    {
                    // InternalOCLX.g:1307:2: ( '->' )
                    // InternalOCLX.g:1308:3: '->'
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
    // InternalOCLX.g:1317:1: rule__UnaryOperator__NameAlternatives_0 : ( ( '-' ) | ( 'not' ) );
    public final void rule__UnaryOperator__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1321:1: ( ( '-' ) | ( 'not' ) )
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
                    // InternalOCLX.g:1322:2: ( '-' )
                    {
                    // InternalOCLX.g:1322:2: ( '-' )
                    // InternalOCLX.g:1323:3: '-'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1328:2: ( 'not' )
                    {
                    // InternalOCLX.g:1328:2: ( 'not' )
                    // InternalOCLX.g:1329:3: 'not'
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
    // InternalOCLX.g:1338:1: rule__PrimaryExp__Alternatives : ( ( ruleNestedExp ) | ( ruleNavigationExp ) | ( rulePrimitiveLiteralExp ) | ( ruleTemporalExp ) );
    public final void rule__PrimaryExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1342:1: ( ( ruleNestedExp ) | ( ruleNavigationExp ) | ( rulePrimitiveLiteralExp ) | ( ruleTemporalExp ) )
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
                    // InternalOCLX.g:1343:2: ( ruleNestedExp )
                    {
                    // InternalOCLX.g:1343:2: ( ruleNestedExp )
                    // InternalOCLX.g:1344:3: ruleNestedExp
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
                    // InternalOCLX.g:1349:2: ( ruleNavigationExp )
                    {
                    // InternalOCLX.g:1349:2: ( ruleNavigationExp )
                    // InternalOCLX.g:1350:3: ruleNavigationExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getNavigationExpParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleNavigationExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getNavigationExpParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1355:2: ( rulePrimitiveLiteralExp )
                    {
                    // InternalOCLX.g:1355:2: ( rulePrimitiveLiteralExp )
                    // InternalOCLX.g:1356:3: rulePrimitiveLiteralExp
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
                    // InternalOCLX.g:1361:2: ( ruleTemporalExp )
                    {
                    // InternalOCLX.g:1361:2: ( ruleTemporalExp )
                    // InternalOCLX.g:1362:3: ruleTemporalExp
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


    // $ANTLR start "rule__NavigationExp__Alternatives_0"
    // InternalOCLX.g:1371:1: rule__NavigationExp__Alternatives_0 : ( ( ruleSelfExp ) | ( ruleVarReference ) );
    public final void rule__NavigationExp__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1375:1: ( ( ruleSelfExp ) | ( ruleVarReference ) )
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
                    // InternalOCLX.g:1376:2: ( ruleSelfExp )
                    {
                    // InternalOCLX.g:1376:2: ( ruleSelfExp )
                    // InternalOCLX.g:1377:3: ruleSelfExp
                    {
                     before(grammarAccess.getNavigationExpAccess().getSelfExpParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSelfExp();

                    state._fsp--;

                     after(grammarAccess.getNavigationExpAccess().getSelfExpParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1382:2: ( ruleVarReference )
                    {
                    // InternalOCLX.g:1382:2: ( ruleVarReference )
                    // InternalOCLX.g:1383:3: ruleVarReference
                    {
                     before(grammarAccess.getNavigationExpAccess().getVarReferenceParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleVarReference();

                    state._fsp--;

                     after(grammarAccess.getNavigationExpAccess().getVarReferenceParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__NavigationExp__Alternatives_0"


    // $ANTLR start "rule__PrimitiveLiteralExp__Alternatives"
    // InternalOCLX.g:1392:1: rule__PrimitiveLiteralExp__Alternatives : ( ( ruleIntLiteralExp ) | ( ruleStringLiteralExp ) | ( ruleBooleanLiteralExp ) | ( ruleFloatLiteralExp ) );
    public final void rule__PrimitiveLiteralExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1396:1: ( ( ruleIntLiteralExp ) | ( ruleStringLiteralExp ) | ( ruleBooleanLiteralExp ) | ( ruleFloatLiteralExp ) )
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
                    // InternalOCLX.g:1397:2: ( ruleIntLiteralExp )
                    {
                    // InternalOCLX.g:1397:2: ( ruleIntLiteralExp )
                    // InternalOCLX.g:1398:3: ruleIntLiteralExp
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
                    // InternalOCLX.g:1403:2: ( ruleStringLiteralExp )
                    {
                    // InternalOCLX.g:1403:2: ( ruleStringLiteralExp )
                    // InternalOCLX.g:1404:3: ruleStringLiteralExp
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
                    // InternalOCLX.g:1409:2: ( ruleBooleanLiteralExp )
                    {
                    // InternalOCLX.g:1409:2: ( ruleBooleanLiteralExp )
                    // InternalOCLX.g:1410:3: ruleBooleanLiteralExp
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
                    // InternalOCLX.g:1415:2: ( ruleFloatLiteralExp )
                    {
                    // InternalOCLX.g:1415:2: ( ruleFloatLiteralExp )
                    // InternalOCLX.g:1416:3: ruleFloatLiteralExp
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
    // InternalOCLX.g:1425:1: rule__BooleanLiteralExp__Alternatives : ( ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) ) | ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) ) );
    public final void rule__BooleanLiteralExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1429:1: ( ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) ) | ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) ) )
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
                    // InternalOCLX.g:1430:2: ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) )
                    {
                    // InternalOCLX.g:1430:2: ( ( rule__BooleanLiteralExp__ValueAssignment_0 ) )
                    // InternalOCLX.g:1431:3: ( rule__BooleanLiteralExp__ValueAssignment_0 )
                    {
                     before(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_0()); 
                    // InternalOCLX.g:1432:3: ( rule__BooleanLiteralExp__ValueAssignment_0 )
                    // InternalOCLX.g:1432:4: rule__BooleanLiteralExp__ValueAssignment_0
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
                    // InternalOCLX.g:1436:2: ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) )
                    {
                    // InternalOCLX.g:1436:2: ( ( rule__BooleanLiteralExp__ValueAssignment_1 ) )
                    // InternalOCLX.g:1437:3: ( rule__BooleanLiteralExp__ValueAssignment_1 )
                    {
                     before(grammarAccess.getBooleanLiteralExpAccess().getValueAssignment_1()); 
                    // InternalOCLX.g:1438:3: ( rule__BooleanLiteralExp__ValueAssignment_1 )
                    // InternalOCLX.g:1438:4: rule__BooleanLiteralExp__ValueAssignment_1
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
    // InternalOCLX.g:1446:1: rule__MethodExp__Alternatives : ( ( rulePropertyAccess ) | ( ruleMethodCall ) | ( ruleCollectionIterator ) | ( ruleTypeCall ) );
    public final void rule__MethodExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1450:1: ( ( rulePropertyAccess ) | ( ruleMethodCall ) | ( ruleCollectionIterator ) | ( ruleTypeCall ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==49||LA12_1==53) ) {
                    alt12=2;
                }
                else if ( (LA12_1==EOF||(LA12_1>=13 && LA12_1<=28)||LA12_1==45||LA12_1==50||(LA12_1>=54 && LA12_1<=58)) ) {
                    alt12=1;
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
                    // InternalOCLX.g:1451:2: ( rulePropertyAccess )
                    {
                    // InternalOCLX.g:1451:2: ( rulePropertyAccess )
                    // InternalOCLX.g:1452:3: rulePropertyAccess
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
                    // InternalOCLX.g:1457:2: ( ruleMethodCall )
                    {
                    // InternalOCLX.g:1457:2: ( ruleMethodCall )
                    // InternalOCLX.g:1458:3: ruleMethodCall
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
                    // InternalOCLX.g:1463:2: ( ruleCollectionIterator )
                    {
                    // InternalOCLX.g:1463:2: ( ruleCollectionIterator )
                    // InternalOCLX.g:1464:3: ruleCollectionIterator
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
                    // InternalOCLX.g:1469:2: ( ruleTypeCall )
                    {
                    // InternalOCLX.g:1469:2: ( ruleTypeCall )
                    // InternalOCLX.g:1470:3: ruleTypeCall
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
    // InternalOCLX.g:1479:1: rule__IteratorName__NameAlternatives_0 : ( ( 'forAll' ) | ( 'exists' ) | ( 'collect' ) | ( 'reject' ) | ( 'select' ) );
    public final void rule__IteratorName__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1483:1: ( ( 'forAll' ) | ( 'exists' ) | ( 'collect' ) | ( 'reject' ) | ( 'select' ) )
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
                    // InternalOCLX.g:1484:2: ( 'forAll' )
                    {
                    // InternalOCLX.g:1484:2: ( 'forAll' )
                    // InternalOCLX.g:1485:3: 'forAll'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameForAllKeyword_0_0()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameForAllKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1490:2: ( 'exists' )
                    {
                    // InternalOCLX.g:1490:2: ( 'exists' )
                    // InternalOCLX.g:1491:3: 'exists'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameExistsKeyword_0_1()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameExistsKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1496:2: ( 'collect' )
                    {
                    // InternalOCLX.g:1496:2: ( 'collect' )
                    // InternalOCLX.g:1497:3: 'collect'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameCollectKeyword_0_2()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameCollectKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1502:2: ( 'reject' )
                    {
                    // InternalOCLX.g:1502:2: ( 'reject' )
                    // InternalOCLX.g:1503:3: 'reject'
                    {
                     before(grammarAccess.getIteratorNameAccess().getNameRejectKeyword_0_3()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getIteratorNameAccess().getNameRejectKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1508:2: ( 'select' )
                    {
                    // InternalOCLX.g:1508:2: ( 'select' )
                    // InternalOCLX.g:1509:3: 'select'
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
    // InternalOCLX.g:1518:1: rule__IteratorVarDeclaration__Alternatives : ( ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) ) | ( ( rule__IteratorVarDeclaration__Group_1__0 ) ) );
    public final void rule__IteratorVarDeclaration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1522:1: ( ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) ) | ( ( rule__IteratorVarDeclaration__Group_1__0 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==52) ) {
                    alt14=2;
                }
                else if ( (LA14_1==EOF||LA14_1==51) ) {
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
                    // InternalOCLX.g:1523:2: ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) )
                    {
                    // InternalOCLX.g:1523:2: ( ( rule__IteratorVarDeclaration__NameAssignment_0 ) )
                    // InternalOCLX.g:1524:3: ( rule__IteratorVarDeclaration__NameAssignment_0 )
                    {
                     before(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_0()); 
                    // InternalOCLX.g:1525:3: ( rule__IteratorVarDeclaration__NameAssignment_0 )
                    // InternalOCLX.g:1525:4: rule__IteratorVarDeclaration__NameAssignment_0
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
                    // InternalOCLX.g:1529:2: ( ( rule__IteratorVarDeclaration__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1529:2: ( ( rule__IteratorVarDeclaration__Group_1__0 ) )
                    // InternalOCLX.g:1530:3: ( rule__IteratorVarDeclaration__Group_1__0 )
                    {
                     before(grammarAccess.getIteratorVarDeclarationAccess().getGroup_1()); 
                    // InternalOCLX.g:1531:3: ( rule__IteratorVarDeclaration__Group_1__0 )
                    // InternalOCLX.g:1531:4: rule__IteratorVarDeclaration__Group_1__0
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
    // InternalOCLX.g:1539:1: rule__MethodCall__Alternatives : ( ( ( rule__MethodCall__Group_0__0 ) ) | ( ( rule__MethodCall__Group_1__0 ) ) );
    public final void rule__MethodCall__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1543:1: ( ( ( rule__MethodCall__Group_0__0 ) ) | ( ( rule__MethodCall__Group_1__0 ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==49) ) {
                    alt15=2;
                }
                else if ( (LA15_1==53) ) {
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
                    // InternalOCLX.g:1544:2: ( ( rule__MethodCall__Group_0__0 ) )
                    {
                    // InternalOCLX.g:1544:2: ( ( rule__MethodCall__Group_0__0 ) )
                    // InternalOCLX.g:1545:3: ( rule__MethodCall__Group_0__0 )
                    {
                     before(grammarAccess.getMethodCallAccess().getGroup_0()); 
                    // InternalOCLX.g:1546:3: ( rule__MethodCall__Group_0__0 )
                    // InternalOCLX.g:1546:4: rule__MethodCall__Group_0__0
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
                    // InternalOCLX.g:1550:2: ( ( rule__MethodCall__Group_1__0 ) )
                    {
                    // InternalOCLX.g:1550:2: ( ( rule__MethodCall__Group_1__0 ) )
                    // InternalOCLX.g:1551:3: ( rule__MethodCall__Group_1__0 )
                    {
                     before(grammarAccess.getMethodCallAccess().getGroup_1()); 
                    // InternalOCLX.g:1552:3: ( rule__MethodCall__Group_1__0 )
                    // InternalOCLX.g:1552:4: rule__MethodCall__Group_1__0
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
    // InternalOCLX.g:1560:1: rule__TypeCall__NameAlternatives_0_0 : ( ( 'asType' ) | ( 'isTypeOf' ) | ( 'isKindOf' ) );
    public final void rule__TypeCall__NameAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1564:1: ( ( 'asType' ) | ( 'isTypeOf' ) | ( 'isKindOf' ) )
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
                    // InternalOCLX.g:1565:2: ( 'asType' )
                    {
                    // InternalOCLX.g:1565:2: ( 'asType' )
                    // InternalOCLX.g:1566:3: 'asType'
                    {
                     before(grammarAccess.getTypeCallAccess().getNameAsTypeKeyword_0_0_0()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getTypeCallAccess().getNameAsTypeKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1571:2: ( 'isTypeOf' )
                    {
                    // InternalOCLX.g:1571:2: ( 'isTypeOf' )
                    // InternalOCLX.g:1572:3: 'isTypeOf'
                    {
                     before(grammarAccess.getTypeCallAccess().getNameIsTypeOfKeyword_0_0_1()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getTypeCallAccess().getNameIsTypeOfKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1577:2: ( 'isKindOf' )
                    {
                    // InternalOCLX.g:1577:2: ( 'isKindOf' )
                    // InternalOCLX.g:1578:3: 'isKindOf'
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
    // InternalOCLX.g:1587:1: rule__TemporalExp__Alternatives : ( ( ruleUnaryTemporalExp ) | ( ruleTriggeredTemporalExp ) );
    public final void rule__TemporalExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1591:1: ( ( ruleUnaryTemporalExp ) | ( ruleTriggeredTemporalExp ) )
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
                    // InternalOCLX.g:1592:2: ( ruleUnaryTemporalExp )
                    {
                    // InternalOCLX.g:1592:2: ( ruleUnaryTemporalExp )
                    // InternalOCLX.g:1593:3: ruleUnaryTemporalExp
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
                    // InternalOCLX.g:1598:2: ( ruleTriggeredTemporalExp )
                    {
                    // InternalOCLX.g:1598:2: ( ruleTriggeredTemporalExp )
                    // InternalOCLX.g:1599:3: ruleTriggeredTemporalExp
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
    // InternalOCLX.g:1608:1: rule__UnaryTemporalOp__Alternatives : ( ( 'next' ) | ( 'always' ) | ( 'eventually' ) );
    public final void rule__UnaryTemporalOp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1612:1: ( ( 'next' ) | ( 'always' ) | ( 'eventually' ) )
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
                    // InternalOCLX.g:1613:2: ( 'next' )
                    {
                    // InternalOCLX.g:1613:2: ( 'next' )
                    // InternalOCLX.g:1614:3: 'next'
                    {
                     before(grammarAccess.getUnaryTemporalOpAccess().getNextKeyword_0()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getUnaryTemporalOpAccess().getNextKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1619:2: ( 'always' )
                    {
                    // InternalOCLX.g:1619:2: ( 'always' )
                    // InternalOCLX.g:1620:3: 'always'
                    {
                     before(grammarAccess.getUnaryTemporalOpAccess().getAlwaysKeyword_1()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getUnaryTemporalOpAccess().getAlwaysKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1625:2: ( 'eventually' )
                    {
                    // InternalOCLX.g:1625:2: ( 'eventually' )
                    // InternalOCLX.g:1626:3: 'eventually'
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
    // InternalOCLX.g:1635:1: rule__TriggeredTemporalExp__Alternatives : ( ( ruleTemporalAsLongAs ) | ( ruleTemporalUntil ) | ( ruleTemporalEverytime ) | ( ruleTemporalAtLeastOnce ) | ( ruleLegacyUntil ) | ( ruleLegacyAsSoonAs ) | ( ruleLegacyEverytime ) );
    public final void rule__TriggeredTemporalExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1639:1: ( ( ruleTemporalAsLongAs ) | ( ruleTemporalUntil ) | ( ruleTemporalEverytime ) | ( ruleTemporalAtLeastOnce ) | ( ruleLegacyUntil ) | ( ruleLegacyAsSoonAs ) | ( ruleLegacyEverytime ) )
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
                    // InternalOCLX.g:1640:2: ( ruleTemporalAsLongAs )
                    {
                    // InternalOCLX.g:1640:2: ( ruleTemporalAsLongAs )
                    // InternalOCLX.g:1641:3: ruleTemporalAsLongAs
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
                    // InternalOCLX.g:1646:2: ( ruleTemporalUntil )
                    {
                    // InternalOCLX.g:1646:2: ( ruleTemporalUntil )
                    // InternalOCLX.g:1647:3: ruleTemporalUntil
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
                    // InternalOCLX.g:1652:2: ( ruleTemporalEverytime )
                    {
                    // InternalOCLX.g:1652:2: ( ruleTemporalEverytime )
                    // InternalOCLX.g:1653:3: ruleTemporalEverytime
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
                    // InternalOCLX.g:1658:2: ( ruleTemporalAtLeastOnce )
                    {
                    // InternalOCLX.g:1658:2: ( ruleTemporalAtLeastOnce )
                    // InternalOCLX.g:1659:3: ruleTemporalAtLeastOnce
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
                    // InternalOCLX.g:1664:2: ( ruleLegacyUntil )
                    {
                    // InternalOCLX.g:1664:2: ( ruleLegacyUntil )
                    // InternalOCLX.g:1665:3: ruleLegacyUntil
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
                    // InternalOCLX.g:1670:2: ( ruleLegacyAsSoonAs )
                    {
                    // InternalOCLX.g:1670:2: ( ruleLegacyAsSoonAs )
                    // InternalOCLX.g:1671:3: ruleLegacyAsSoonAs
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
                    // InternalOCLX.g:1676:2: ( ruleLegacyEverytime )
                    {
                    // InternalOCLX.g:1676:2: ( ruleLegacyEverytime )
                    // InternalOCLX.g:1677:3: ruleLegacyEverytime
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
    // InternalOCLX.g:1686:1: rule__Constraint__Group__0 : rule__Constraint__Group__0__Impl rule__Constraint__Group__1 ;
    public final void rule__Constraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1690:1: ( rule__Constraint__Group__0__Impl rule__Constraint__Group__1 )
            // InternalOCLX.g:1691:2: rule__Constraint__Group__0__Impl rule__Constraint__Group__1
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
    // InternalOCLX.g:1698:1: rule__Constraint__Group__0__Impl : ( 'rule' ) ;
    public final void rule__Constraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1702:1: ( ( 'rule' ) )
            // InternalOCLX.g:1703:1: ( 'rule' )
            {
            // InternalOCLX.g:1703:1: ( 'rule' )
            // InternalOCLX.g:1704:2: 'rule'
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
    // InternalOCLX.g:1713:1: rule__Constraint__Group__1 : rule__Constraint__Group__1__Impl rule__Constraint__Group__2 ;
    public final void rule__Constraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1717:1: ( rule__Constraint__Group__1__Impl rule__Constraint__Group__2 )
            // InternalOCLX.g:1718:2: rule__Constraint__Group__1__Impl rule__Constraint__Group__2
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
    // InternalOCLX.g:1725:1: rule__Constraint__Group__1__Impl : ( ( rule__Constraint__NameAssignment_1 ) ) ;
    public final void rule__Constraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1729:1: ( ( ( rule__Constraint__NameAssignment_1 ) ) )
            // InternalOCLX.g:1730:1: ( ( rule__Constraint__NameAssignment_1 ) )
            {
            // InternalOCLX.g:1730:1: ( ( rule__Constraint__NameAssignment_1 ) )
            // InternalOCLX.g:1731:2: ( rule__Constraint__NameAssignment_1 )
            {
             before(grammarAccess.getConstraintAccess().getNameAssignment_1()); 
            // InternalOCLX.g:1732:2: ( rule__Constraint__NameAssignment_1 )
            // InternalOCLX.g:1732:3: rule__Constraint__NameAssignment_1
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
    // InternalOCLX.g:1740:1: rule__Constraint__Group__2 : rule__Constraint__Group__2__Impl rule__Constraint__Group__3 ;
    public final void rule__Constraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1744:1: ( rule__Constraint__Group__2__Impl rule__Constraint__Group__3 )
            // InternalOCLX.g:1745:2: rule__Constraint__Group__2__Impl rule__Constraint__Group__3
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
    // InternalOCLX.g:1752:1: rule__Constraint__Group__2__Impl : ( '{' ) ;
    public final void rule__Constraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1756:1: ( ( '{' ) )
            // InternalOCLX.g:1757:1: ( '{' )
            {
            // InternalOCLX.g:1757:1: ( '{' )
            // InternalOCLX.g:1758:2: '{'
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
    // InternalOCLX.g:1767:1: rule__Constraint__Group__3 : rule__Constraint__Group__3__Impl rule__Constraint__Group__4 ;
    public final void rule__Constraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1771:1: ( rule__Constraint__Group__3__Impl rule__Constraint__Group__4 )
            // InternalOCLX.g:1772:2: rule__Constraint__Group__3__Impl rule__Constraint__Group__4
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
    // InternalOCLX.g:1779:1: rule__Constraint__Group__3__Impl : ( ( rule__Constraint__Group_3__0 )? ) ;
    public final void rule__Constraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1783:1: ( ( ( rule__Constraint__Group_3__0 )? ) )
            // InternalOCLX.g:1784:1: ( ( rule__Constraint__Group_3__0 )? )
            {
            // InternalOCLX.g:1784:1: ( ( rule__Constraint__Group_3__0 )? )
            // InternalOCLX.g:1785:2: ( rule__Constraint__Group_3__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_3()); 
            // InternalOCLX.g:1786:2: ( rule__Constraint__Group_3__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==46) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalOCLX.g:1786:3: rule__Constraint__Group_3__0
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
    // InternalOCLX.g:1794:1: rule__Constraint__Group__4 : rule__Constraint__Group__4__Impl rule__Constraint__Group__5 ;
    public final void rule__Constraint__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1798:1: ( rule__Constraint__Group__4__Impl rule__Constraint__Group__5 )
            // InternalOCLX.g:1799:2: rule__Constraint__Group__4__Impl rule__Constraint__Group__5
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
    // InternalOCLX.g:1806:1: rule__Constraint__Group__4__Impl : ( ( rule__Constraint__Group_4__0 )? ) ;
    public final void rule__Constraint__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1810:1: ( ( ( rule__Constraint__Group_4__0 )? ) )
            // InternalOCLX.g:1811:1: ( ( rule__Constraint__Group_4__0 )? )
            {
            // InternalOCLX.g:1811:1: ( ( rule__Constraint__Group_4__0 )? )
            // InternalOCLX.g:1812:2: ( rule__Constraint__Group_4__0 )?
            {
             before(grammarAccess.getConstraintAccess().getGroup_4()); 
            // InternalOCLX.g:1813:2: ( rule__Constraint__Group_4__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==47) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalOCLX.g:1813:3: rule__Constraint__Group_4__0
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
    // InternalOCLX.g:1821:1: rule__Constraint__Group__5 : rule__Constraint__Group__5__Impl rule__Constraint__Group__6 ;
    public final void rule__Constraint__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1825:1: ( rule__Constraint__Group__5__Impl rule__Constraint__Group__6 )
            // InternalOCLX.g:1826:2: rule__Constraint__Group__5__Impl rule__Constraint__Group__6
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
    // InternalOCLX.g:1833:1: rule__Constraint__Group__5__Impl : ( 'context:' ) ;
    public final void rule__Constraint__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1837:1: ( ( 'context:' ) )
            // InternalOCLX.g:1838:1: ( 'context:' )
            {
            // InternalOCLX.g:1838:1: ( 'context:' )
            // InternalOCLX.g:1839:2: 'context:'
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
    // InternalOCLX.g:1848:1: rule__Constraint__Group__6 : rule__Constraint__Group__6__Impl rule__Constraint__Group__7 ;
    public final void rule__Constraint__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1852:1: ( rule__Constraint__Group__6__Impl rule__Constraint__Group__7 )
            // InternalOCLX.g:1853:2: rule__Constraint__Group__6__Impl rule__Constraint__Group__7
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
    // InternalOCLX.g:1860:1: rule__Constraint__Group__6__Impl : ( ( rule__Constraint__ContextAssignment_6 ) ) ;
    public final void rule__Constraint__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1864:1: ( ( ( rule__Constraint__ContextAssignment_6 ) ) )
            // InternalOCLX.g:1865:1: ( ( rule__Constraint__ContextAssignment_6 ) )
            {
            // InternalOCLX.g:1865:1: ( ( rule__Constraint__ContextAssignment_6 ) )
            // InternalOCLX.g:1866:2: ( rule__Constraint__ContextAssignment_6 )
            {
             before(grammarAccess.getConstraintAccess().getContextAssignment_6()); 
            // InternalOCLX.g:1867:2: ( rule__Constraint__ContextAssignment_6 )
            // InternalOCLX.g:1867:3: rule__Constraint__ContextAssignment_6
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
    // InternalOCLX.g:1875:1: rule__Constraint__Group__7 : rule__Constraint__Group__7__Impl rule__Constraint__Group__8 ;
    public final void rule__Constraint__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1879:1: ( rule__Constraint__Group__7__Impl rule__Constraint__Group__8 )
            // InternalOCLX.g:1880:2: rule__Constraint__Group__7__Impl rule__Constraint__Group__8
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
    // InternalOCLX.g:1887:1: rule__Constraint__Group__7__Impl : ( 'expression:' ) ;
    public final void rule__Constraint__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1891:1: ( ( 'expression:' ) )
            // InternalOCLX.g:1892:1: ( 'expression:' )
            {
            // InternalOCLX.g:1892:1: ( 'expression:' )
            // InternalOCLX.g:1893:2: 'expression:'
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
    // InternalOCLX.g:1902:1: rule__Constraint__Group__8 : rule__Constraint__Group__8__Impl rule__Constraint__Group__9 ;
    public final void rule__Constraint__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1906:1: ( rule__Constraint__Group__8__Impl rule__Constraint__Group__9 )
            // InternalOCLX.g:1907:2: rule__Constraint__Group__8__Impl rule__Constraint__Group__9
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
    // InternalOCLX.g:1914:1: rule__Constraint__Group__8__Impl : ( ( rule__Constraint__ExpressionAssignment_8 ) ) ;
    public final void rule__Constraint__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1918:1: ( ( ( rule__Constraint__ExpressionAssignment_8 ) ) )
            // InternalOCLX.g:1919:1: ( ( rule__Constraint__ExpressionAssignment_8 ) )
            {
            // InternalOCLX.g:1919:1: ( ( rule__Constraint__ExpressionAssignment_8 ) )
            // InternalOCLX.g:1920:2: ( rule__Constraint__ExpressionAssignment_8 )
            {
             before(grammarAccess.getConstraintAccess().getExpressionAssignment_8()); 
            // InternalOCLX.g:1921:2: ( rule__Constraint__ExpressionAssignment_8 )
            // InternalOCLX.g:1921:3: rule__Constraint__ExpressionAssignment_8
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
    // InternalOCLX.g:1929:1: rule__Constraint__Group__9 : rule__Constraint__Group__9__Impl ;
    public final void rule__Constraint__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1933:1: ( rule__Constraint__Group__9__Impl )
            // InternalOCLX.g:1934:2: rule__Constraint__Group__9__Impl
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
    // InternalOCLX.g:1940:1: rule__Constraint__Group__9__Impl : ( '}' ) ;
    public final void rule__Constraint__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1944:1: ( ( '}' ) )
            // InternalOCLX.g:1945:1: ( '}' )
            {
            // InternalOCLX.g:1945:1: ( '}' )
            // InternalOCLX.g:1946:2: '}'
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
    // InternalOCLX.g:1956:1: rule__Constraint__Group_3__0 : rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1 ;
    public final void rule__Constraint__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1960:1: ( rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1 )
            // InternalOCLX.g:1961:2: rule__Constraint__Group_3__0__Impl rule__Constraint__Group_3__1
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
    // InternalOCLX.g:1968:1: rule__Constraint__Group_3__0__Impl : ( 'description:' ) ;
    public final void rule__Constraint__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1972:1: ( ( 'description:' ) )
            // InternalOCLX.g:1973:1: ( 'description:' )
            {
            // InternalOCLX.g:1973:1: ( 'description:' )
            // InternalOCLX.g:1974:2: 'description:'
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
    // InternalOCLX.g:1983:1: rule__Constraint__Group_3__1 : rule__Constraint__Group_3__1__Impl ;
    public final void rule__Constraint__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1987:1: ( rule__Constraint__Group_3__1__Impl )
            // InternalOCLX.g:1988:2: rule__Constraint__Group_3__1__Impl
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
    // InternalOCLX.g:1994:1: rule__Constraint__Group_3__1__Impl : ( ( rule__Constraint__DescriptionAssignment_3_1 ) ) ;
    public final void rule__Constraint__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:1998:1: ( ( ( rule__Constraint__DescriptionAssignment_3_1 ) ) )
            // InternalOCLX.g:1999:1: ( ( rule__Constraint__DescriptionAssignment_3_1 ) )
            {
            // InternalOCLX.g:1999:1: ( ( rule__Constraint__DescriptionAssignment_3_1 ) )
            // InternalOCLX.g:2000:2: ( rule__Constraint__DescriptionAssignment_3_1 )
            {
             before(grammarAccess.getConstraintAccess().getDescriptionAssignment_3_1()); 
            // InternalOCLX.g:2001:2: ( rule__Constraint__DescriptionAssignment_3_1 )
            // InternalOCLX.g:2001:3: rule__Constraint__DescriptionAssignment_3_1
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
    // InternalOCLX.g:2010:1: rule__Constraint__Group_4__0 : rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 ;
    public final void rule__Constraint__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2014:1: ( rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1 )
            // InternalOCLX.g:2015:2: rule__Constraint__Group_4__0__Impl rule__Constraint__Group_4__1
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
    // InternalOCLX.g:2022:1: rule__Constraint__Group_4__0__Impl : ( 'is' ) ;
    public final void rule__Constraint__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2026:1: ( ( 'is' ) )
            // InternalOCLX.g:2027:1: ( 'is' )
            {
            // InternalOCLX.g:2027:1: ( 'is' )
            // InternalOCLX.g:2028:2: 'is'
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
    // InternalOCLX.g:2037:1: rule__Constraint__Group_4__1 : rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2 ;
    public final void rule__Constraint__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2041:1: ( rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2 )
            // InternalOCLX.g:2042:2: rule__Constraint__Group_4__1__Impl rule__Constraint__Group_4__2
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
    // InternalOCLX.g:2049:1: rule__Constraint__Group_4__1__Impl : ( 'overrulable:' ) ;
    public final void rule__Constraint__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2053:1: ( ( 'overrulable:' ) )
            // InternalOCLX.g:2054:1: ( 'overrulable:' )
            {
            // InternalOCLX.g:2054:1: ( 'overrulable:' )
            // InternalOCLX.g:2055:2: 'overrulable:'
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
    // InternalOCLX.g:2064:1: rule__Constraint__Group_4__2 : rule__Constraint__Group_4__2__Impl ;
    public final void rule__Constraint__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2068:1: ( rule__Constraint__Group_4__2__Impl )
            // InternalOCLX.g:2069:2: rule__Constraint__Group_4__2__Impl
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
    // InternalOCLX.g:2075:1: rule__Constraint__Group_4__2__Impl : ( ( rule__Constraint__OverrulableAssignment_4_2 ) ) ;
    public final void rule__Constraint__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2079:1: ( ( ( rule__Constraint__OverrulableAssignment_4_2 ) ) )
            // InternalOCLX.g:2080:1: ( ( rule__Constraint__OverrulableAssignment_4_2 ) )
            {
            // InternalOCLX.g:2080:1: ( ( rule__Constraint__OverrulableAssignment_4_2 ) )
            // InternalOCLX.g:2081:2: ( rule__Constraint__OverrulableAssignment_4_2 )
            {
             before(grammarAccess.getConstraintAccess().getOverrulableAssignment_4_2()); 
            // InternalOCLX.g:2082:2: ( rule__Constraint__OverrulableAssignment_4_2 )
            // InternalOCLX.g:2082:3: rule__Constraint__OverrulableAssignment_4_2
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
    // InternalOCLX.g:2091:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2095:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalOCLX.g:2096:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalOCLX.g:2103:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2107:1: ( ( RULE_ID ) )
            // InternalOCLX.g:2108:1: ( RULE_ID )
            {
            // InternalOCLX.g:2108:1: ( RULE_ID )
            // InternalOCLX.g:2109:2: RULE_ID
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
    // InternalOCLX.g:2118:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2122:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalOCLX.g:2123:2: rule__QualifiedName__Group__1__Impl
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
    // InternalOCLX.g:2129:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2133:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalOCLX.g:2134:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalOCLX.g:2134:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalOCLX.g:2135:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalOCLX.g:2136:2: ( rule__QualifiedName__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==27) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalOCLX.g:2136:3: rule__QualifiedName__Group_1__0
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
    // InternalOCLX.g:2145:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2149:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalOCLX.g:2150:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalOCLX.g:2157:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2161:1: ( ( '.' ) )
            // InternalOCLX.g:2162:1: ( '.' )
            {
            // InternalOCLX.g:2162:1: ( '.' )
            // InternalOCLX.g:2163:2: '.'
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
    // InternalOCLX.g:2172:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2176:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalOCLX.g:2177:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalOCLX.g:2183:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2187:1: ( ( RULE_ID ) )
            // InternalOCLX.g:2188:1: ( RULE_ID )
            {
            // InternalOCLX.g:2188:1: ( RULE_ID )
            // InternalOCLX.g:2189:2: RULE_ID
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
    // InternalOCLX.g:2199:1: rule__Float__Group__0 : rule__Float__Group__0__Impl rule__Float__Group__1 ;
    public final void rule__Float__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2203:1: ( rule__Float__Group__0__Impl rule__Float__Group__1 )
            // InternalOCLX.g:2204:2: rule__Float__Group__0__Impl rule__Float__Group__1
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
    // InternalOCLX.g:2211:1: rule__Float__Group__0__Impl : ( RULE_INT ) ;
    public final void rule__Float__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2215:1: ( ( RULE_INT ) )
            // InternalOCLX.g:2216:1: ( RULE_INT )
            {
            // InternalOCLX.g:2216:1: ( RULE_INT )
            // InternalOCLX.g:2217:2: RULE_INT
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
    // InternalOCLX.g:2226:1: rule__Float__Group__1 : rule__Float__Group__1__Impl rule__Float__Group__2 ;
    public final void rule__Float__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2230:1: ( rule__Float__Group__1__Impl rule__Float__Group__2 )
            // InternalOCLX.g:2231:2: rule__Float__Group__1__Impl rule__Float__Group__2
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
    // InternalOCLX.g:2238:1: rule__Float__Group__1__Impl : ( '.' ) ;
    public final void rule__Float__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2242:1: ( ( '.' ) )
            // InternalOCLX.g:2243:1: ( '.' )
            {
            // InternalOCLX.g:2243:1: ( '.' )
            // InternalOCLX.g:2244:2: '.'
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
    // InternalOCLX.g:2253:1: rule__Float__Group__2 : rule__Float__Group__2__Impl ;
    public final void rule__Float__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2257:1: ( rule__Float__Group__2__Impl )
            // InternalOCLX.g:2258:2: rule__Float__Group__2__Impl
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
    // InternalOCLX.g:2264:1: rule__Float__Group__2__Impl : ( RULE_INT ) ;
    public final void rule__Float__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2268:1: ( ( RULE_INT ) )
            // InternalOCLX.g:2269:1: ( RULE_INT )
            {
            // InternalOCLX.g:2269:1: ( RULE_INT )
            // InternalOCLX.g:2270:2: RULE_INT
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
    // InternalOCLX.g:2280:1: rule__Exp__Group__0 : rule__Exp__Group__0__Impl rule__Exp__Group__1 ;
    public final void rule__Exp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2284:1: ( rule__Exp__Group__0__Impl rule__Exp__Group__1 )
            // InternalOCLX.g:2285:2: rule__Exp__Group__0__Impl rule__Exp__Group__1
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
    // InternalOCLX.g:2292:1: rule__Exp__Group__0__Impl : ( rulePrefixedExp ) ;
    public final void rule__Exp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2296:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:2297:1: ( rulePrefixedExp )
            {
            // InternalOCLX.g:2297:1: ( rulePrefixedExp )
            // InternalOCLX.g:2298:2: rulePrefixedExp
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
    // InternalOCLX.g:2307:1: rule__Exp__Group__1 : rule__Exp__Group__1__Impl ;
    public final void rule__Exp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2311:1: ( rule__Exp__Group__1__Impl )
            // InternalOCLX.g:2312:2: rule__Exp__Group__1__Impl
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
    // InternalOCLX.g:2318:1: rule__Exp__Group__1__Impl : ( ( rule__Exp__Group_1__0 )? ) ;
    public final void rule__Exp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2322:1: ( ( ( rule__Exp__Group_1__0 )? ) )
            // InternalOCLX.g:2323:1: ( ( rule__Exp__Group_1__0 )? )
            {
            // InternalOCLX.g:2323:1: ( ( rule__Exp__Group_1__0 )? )
            // InternalOCLX.g:2324:2: ( rule__Exp__Group_1__0 )?
            {
             before(grammarAccess.getExpAccess().getGroup_1()); 
            // InternalOCLX.g:2325:2: ( rule__Exp__Group_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=13 && LA23_0<=26)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalOCLX.g:2325:3: rule__Exp__Group_1__0
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
    // InternalOCLX.g:2334:1: rule__Exp__Group_1__0 : rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 ;
    public final void rule__Exp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2338:1: ( rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1 )
            // InternalOCLX.g:2339:2: rule__Exp__Group_1__0__Impl rule__Exp__Group_1__1
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
    // InternalOCLX.g:2346:1: rule__Exp__Group_1__0__Impl : ( () ) ;
    public final void rule__Exp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2350:1: ( ( () ) )
            // InternalOCLX.g:2351:1: ( () )
            {
            // InternalOCLX.g:2351:1: ( () )
            // InternalOCLX.g:2352:2: ()
            {
             before(grammarAccess.getExpAccess().getInfixExpExpressionsAction_1_0()); 
            // InternalOCLX.g:2353:2: ()
            // InternalOCLX.g:2353:3: 
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
    // InternalOCLX.g:2361:1: rule__Exp__Group_1__1 : rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2 ;
    public final void rule__Exp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2365:1: ( rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2 )
            // InternalOCLX.g:2366:2: rule__Exp__Group_1__1__Impl rule__Exp__Group_1__2
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
    // InternalOCLX.g:2373:1: rule__Exp__Group_1__1__Impl : ( ( rule__Exp__OperatorsAssignment_1_1 ) ) ;
    public final void rule__Exp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2377:1: ( ( ( rule__Exp__OperatorsAssignment_1_1 ) ) )
            // InternalOCLX.g:2378:1: ( ( rule__Exp__OperatorsAssignment_1_1 ) )
            {
            // InternalOCLX.g:2378:1: ( ( rule__Exp__OperatorsAssignment_1_1 ) )
            // InternalOCLX.g:2379:2: ( rule__Exp__OperatorsAssignment_1_1 )
            {
             before(grammarAccess.getExpAccess().getOperatorsAssignment_1_1()); 
            // InternalOCLX.g:2380:2: ( rule__Exp__OperatorsAssignment_1_1 )
            // InternalOCLX.g:2380:3: rule__Exp__OperatorsAssignment_1_1
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
    // InternalOCLX.g:2388:1: rule__Exp__Group_1__2 : rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3 ;
    public final void rule__Exp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2392:1: ( rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3 )
            // InternalOCLX.g:2393:2: rule__Exp__Group_1__2__Impl rule__Exp__Group_1__3
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
    // InternalOCLX.g:2400:1: rule__Exp__Group_1__2__Impl : ( ( rule__Exp__ExpressionsAssignment_1_2 ) ) ;
    public final void rule__Exp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2404:1: ( ( ( rule__Exp__ExpressionsAssignment_1_2 ) ) )
            // InternalOCLX.g:2405:1: ( ( rule__Exp__ExpressionsAssignment_1_2 ) )
            {
            // InternalOCLX.g:2405:1: ( ( rule__Exp__ExpressionsAssignment_1_2 ) )
            // InternalOCLX.g:2406:2: ( rule__Exp__ExpressionsAssignment_1_2 )
            {
             before(grammarAccess.getExpAccess().getExpressionsAssignment_1_2()); 
            // InternalOCLX.g:2407:2: ( rule__Exp__ExpressionsAssignment_1_2 )
            // InternalOCLX.g:2407:3: rule__Exp__ExpressionsAssignment_1_2
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
    // InternalOCLX.g:2415:1: rule__Exp__Group_1__3 : rule__Exp__Group_1__3__Impl ;
    public final void rule__Exp__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2419:1: ( rule__Exp__Group_1__3__Impl )
            // InternalOCLX.g:2420:2: rule__Exp__Group_1__3__Impl
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
    // InternalOCLX.g:2426:1: rule__Exp__Group_1__3__Impl : ( ( rule__Exp__Group_1_3__0 )* ) ;
    public final void rule__Exp__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2430:1: ( ( ( rule__Exp__Group_1_3__0 )* ) )
            // InternalOCLX.g:2431:1: ( ( rule__Exp__Group_1_3__0 )* )
            {
            // InternalOCLX.g:2431:1: ( ( rule__Exp__Group_1_3__0 )* )
            // InternalOCLX.g:2432:2: ( rule__Exp__Group_1_3__0 )*
            {
             before(grammarAccess.getExpAccess().getGroup_1_3()); 
            // InternalOCLX.g:2433:2: ( rule__Exp__Group_1_3__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=13 && LA24_0<=26)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalOCLX.g:2433:3: rule__Exp__Group_1_3__0
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
    // InternalOCLX.g:2442:1: rule__Exp__Group_1_3__0 : rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1 ;
    public final void rule__Exp__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2446:1: ( rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1 )
            // InternalOCLX.g:2447:2: rule__Exp__Group_1_3__0__Impl rule__Exp__Group_1_3__1
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
    // InternalOCLX.g:2454:1: rule__Exp__Group_1_3__0__Impl : ( ( rule__Exp__OperatorsAssignment_1_3_0 ) ) ;
    public final void rule__Exp__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2458:1: ( ( ( rule__Exp__OperatorsAssignment_1_3_0 ) ) )
            // InternalOCLX.g:2459:1: ( ( rule__Exp__OperatorsAssignment_1_3_0 ) )
            {
            // InternalOCLX.g:2459:1: ( ( rule__Exp__OperatorsAssignment_1_3_0 ) )
            // InternalOCLX.g:2460:2: ( rule__Exp__OperatorsAssignment_1_3_0 )
            {
             before(grammarAccess.getExpAccess().getOperatorsAssignment_1_3_0()); 
            // InternalOCLX.g:2461:2: ( rule__Exp__OperatorsAssignment_1_3_0 )
            // InternalOCLX.g:2461:3: rule__Exp__OperatorsAssignment_1_3_0
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
    // InternalOCLX.g:2469:1: rule__Exp__Group_1_3__1 : rule__Exp__Group_1_3__1__Impl ;
    public final void rule__Exp__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2473:1: ( rule__Exp__Group_1_3__1__Impl )
            // InternalOCLX.g:2474:2: rule__Exp__Group_1_3__1__Impl
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
    // InternalOCLX.g:2480:1: rule__Exp__Group_1_3__1__Impl : ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) ) ;
    public final void rule__Exp__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2484:1: ( ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) ) )
            // InternalOCLX.g:2485:1: ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) )
            {
            // InternalOCLX.g:2485:1: ( ( rule__Exp__ExpressionsAssignment_1_3_1 ) )
            // InternalOCLX.g:2486:2: ( rule__Exp__ExpressionsAssignment_1_3_1 )
            {
             before(grammarAccess.getExpAccess().getExpressionsAssignment_1_3_1()); 
            // InternalOCLX.g:2487:2: ( rule__Exp__ExpressionsAssignment_1_3_1 )
            // InternalOCLX.g:2487:3: rule__Exp__ExpressionsAssignment_1_3_1
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
    // InternalOCLX.g:2496:1: rule__PrefixedExp__Group_0__0 : rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1 ;
    public final void rule__PrefixedExp__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2500:1: ( rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1 )
            // InternalOCLX.g:2501:2: rule__PrefixedExp__Group_0__0__Impl rule__PrefixedExp__Group_0__1
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
    // InternalOCLX.g:2508:1: rule__PrefixedExp__Group_0__0__Impl : ( () ) ;
    public final void rule__PrefixedExp__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2512:1: ( ( () ) )
            // InternalOCLX.g:2513:1: ( () )
            {
            // InternalOCLX.g:2513:1: ( () )
            // InternalOCLX.g:2514:2: ()
            {
             before(grammarAccess.getPrefixedExpAccess().getPrefixExpAction_0_0()); 
            // InternalOCLX.g:2515:2: ()
            // InternalOCLX.g:2515:3: 
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
    // InternalOCLX.g:2523:1: rule__PrefixedExp__Group_0__1 : rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2 ;
    public final void rule__PrefixedExp__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2527:1: ( rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2 )
            // InternalOCLX.g:2528:2: rule__PrefixedExp__Group_0__1__Impl rule__PrefixedExp__Group_0__2
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
    // InternalOCLX.g:2535:1: rule__PrefixedExp__Group_0__1__Impl : ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) ) ;
    public final void rule__PrefixedExp__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2539:1: ( ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) ) )
            // InternalOCLX.g:2540:1: ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) )
            {
            // InternalOCLX.g:2540:1: ( ( rule__PrefixedExp__OperatorAssignment_0_1 ) )
            // InternalOCLX.g:2541:2: ( rule__PrefixedExp__OperatorAssignment_0_1 )
            {
             before(grammarAccess.getPrefixedExpAccess().getOperatorAssignment_0_1()); 
            // InternalOCLX.g:2542:2: ( rule__PrefixedExp__OperatorAssignment_0_1 )
            // InternalOCLX.g:2542:3: rule__PrefixedExp__OperatorAssignment_0_1
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
    // InternalOCLX.g:2550:1: rule__PrefixedExp__Group_0__2 : rule__PrefixedExp__Group_0__2__Impl ;
    public final void rule__PrefixedExp__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2554:1: ( rule__PrefixedExp__Group_0__2__Impl )
            // InternalOCLX.g:2555:2: rule__PrefixedExp__Group_0__2__Impl
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
    // InternalOCLX.g:2561:1: rule__PrefixedExp__Group_0__2__Impl : ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) ) ;
    public final void rule__PrefixedExp__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2565:1: ( ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) ) )
            // InternalOCLX.g:2566:1: ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) )
            {
            // InternalOCLX.g:2566:1: ( ( rule__PrefixedExp__ExpressionAssignment_0_2 ) )
            // InternalOCLX.g:2567:2: ( rule__PrefixedExp__ExpressionAssignment_0_2 )
            {
             before(grammarAccess.getPrefixedExpAccess().getExpressionAssignment_0_2()); 
            // InternalOCLX.g:2568:2: ( rule__PrefixedExp__ExpressionAssignment_0_2 )
            // InternalOCLX.g:2568:3: rule__PrefixedExp__ExpressionAssignment_0_2
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


    // $ANTLR start "rule__NestedExp__Group__0"
    // InternalOCLX.g:2577:1: rule__NestedExp__Group__0 : rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 ;
    public final void rule__NestedExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2581:1: ( rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 )
            // InternalOCLX.g:2582:2: rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1
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
    // InternalOCLX.g:2589:1: rule__NestedExp__Group__0__Impl : ( '(' ) ;
    public final void rule__NestedExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2593:1: ( ( '(' ) )
            // InternalOCLX.g:2594:1: ( '(' )
            {
            // InternalOCLX.g:2594:1: ( '(' )
            // InternalOCLX.g:2595:2: '('
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
    // InternalOCLX.g:2604:1: rule__NestedExp__Group__1 : rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 ;
    public final void rule__NestedExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2608:1: ( rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 )
            // InternalOCLX.g:2609:2: rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:2616:1: rule__NestedExp__Group__1__Impl : ( ( rule__NestedExp__SourceAssignment_1 ) ) ;
    public final void rule__NestedExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2620:1: ( ( ( rule__NestedExp__SourceAssignment_1 ) ) )
            // InternalOCLX.g:2621:1: ( ( rule__NestedExp__SourceAssignment_1 ) )
            {
            // InternalOCLX.g:2621:1: ( ( rule__NestedExp__SourceAssignment_1 ) )
            // InternalOCLX.g:2622:2: ( rule__NestedExp__SourceAssignment_1 )
            {
             before(grammarAccess.getNestedExpAccess().getSourceAssignment_1()); 
            // InternalOCLX.g:2623:2: ( rule__NestedExp__SourceAssignment_1 )
            // InternalOCLX.g:2623:3: rule__NestedExp__SourceAssignment_1
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
    // InternalOCLX.g:2631:1: rule__NestedExp__Group__2 : rule__NestedExp__Group__2__Impl ;
    public final void rule__NestedExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2635:1: ( rule__NestedExp__Group__2__Impl )
            // InternalOCLX.g:2636:2: rule__NestedExp__Group__2__Impl
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
    // InternalOCLX.g:2642:1: rule__NestedExp__Group__2__Impl : ( ')' ) ;
    public final void rule__NestedExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2646:1: ( ( ')' ) )
            // InternalOCLX.g:2647:1: ( ')' )
            {
            // InternalOCLX.g:2647:1: ( ')' )
            // InternalOCLX.g:2648:2: ')'
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


    // $ANTLR start "rule__NavigationExp__Group__0"
    // InternalOCLX.g:2658:1: rule__NavigationExp__Group__0 : rule__NavigationExp__Group__0__Impl rule__NavigationExp__Group__1 ;
    public final void rule__NavigationExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2662:1: ( rule__NavigationExp__Group__0__Impl rule__NavigationExp__Group__1 )
            // InternalOCLX.g:2663:2: rule__NavigationExp__Group__0__Impl rule__NavigationExp__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__NavigationExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NavigationExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationExp__Group__0"


    // $ANTLR start "rule__NavigationExp__Group__0__Impl"
    // InternalOCLX.g:2670:1: rule__NavigationExp__Group__0__Impl : ( ( rule__NavigationExp__Alternatives_0 ) ) ;
    public final void rule__NavigationExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2674:1: ( ( ( rule__NavigationExp__Alternatives_0 ) ) )
            // InternalOCLX.g:2675:1: ( ( rule__NavigationExp__Alternatives_0 ) )
            {
            // InternalOCLX.g:2675:1: ( ( rule__NavigationExp__Alternatives_0 ) )
            // InternalOCLX.g:2676:2: ( rule__NavigationExp__Alternatives_0 )
            {
             before(grammarAccess.getNavigationExpAccess().getAlternatives_0()); 
            // InternalOCLX.g:2677:2: ( rule__NavigationExp__Alternatives_0 )
            // InternalOCLX.g:2677:3: rule__NavigationExp__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__NavigationExp__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getNavigationExpAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationExp__Group__0__Impl"


    // $ANTLR start "rule__NavigationExp__Group__1"
    // InternalOCLX.g:2685:1: rule__NavigationExp__Group__1 : rule__NavigationExp__Group__1__Impl ;
    public final void rule__NavigationExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2689:1: ( rule__NavigationExp__Group__1__Impl )
            // InternalOCLX.g:2690:2: rule__NavigationExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NavigationExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationExp__Group__1"


    // $ANTLR start "rule__NavigationExp__Group__1__Impl"
    // InternalOCLX.g:2696:1: rule__NavigationExp__Group__1__Impl : ( ( rule__NavigationExp__Group_1__0 )* ) ;
    public final void rule__NavigationExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2700:1: ( ( ( rule__NavigationExp__Group_1__0 )* ) )
            // InternalOCLX.g:2701:1: ( ( rule__NavigationExp__Group_1__0 )* )
            {
            // InternalOCLX.g:2701:1: ( ( rule__NavigationExp__Group_1__0 )* )
            // InternalOCLX.g:2702:2: ( rule__NavigationExp__Group_1__0 )*
            {
             before(grammarAccess.getNavigationExpAccess().getGroup_1()); 
            // InternalOCLX.g:2703:2: ( rule__NavigationExp__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=27 && LA25_0<=28)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalOCLX.g:2703:3: rule__NavigationExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__NavigationExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getNavigationExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationExp__Group__1__Impl"


    // $ANTLR start "rule__NavigationExp__Group_1__0"
    // InternalOCLX.g:2712:1: rule__NavigationExp__Group_1__0 : rule__NavigationExp__Group_1__0__Impl rule__NavigationExp__Group_1__1 ;
    public final void rule__NavigationExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2716:1: ( rule__NavigationExp__Group_1__0__Impl rule__NavigationExp__Group_1__1 )
            // InternalOCLX.g:2717:2: rule__NavigationExp__Group_1__0__Impl rule__NavigationExp__Group_1__1
            {
            pushFollow(FOLLOW_22);
            rule__NavigationExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NavigationExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationExp__Group_1__0"


    // $ANTLR start "rule__NavigationExp__Group_1__0__Impl"
    // InternalOCLX.g:2724:1: rule__NavigationExp__Group_1__0__Impl : ( ( rule__NavigationExp__NavAssignment_1_0 ) ) ;
    public final void rule__NavigationExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2728:1: ( ( ( rule__NavigationExp__NavAssignment_1_0 ) ) )
            // InternalOCLX.g:2729:1: ( ( rule__NavigationExp__NavAssignment_1_0 ) )
            {
            // InternalOCLX.g:2729:1: ( ( rule__NavigationExp__NavAssignment_1_0 ) )
            // InternalOCLX.g:2730:2: ( rule__NavigationExp__NavAssignment_1_0 )
            {
             before(grammarAccess.getNavigationExpAccess().getNavAssignment_1_0()); 
            // InternalOCLX.g:2731:2: ( rule__NavigationExp__NavAssignment_1_0 )
            // InternalOCLX.g:2731:3: rule__NavigationExp__NavAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__NavigationExp__NavAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getNavigationExpAccess().getNavAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationExp__Group_1__0__Impl"


    // $ANTLR start "rule__NavigationExp__Group_1__1"
    // InternalOCLX.g:2739:1: rule__NavigationExp__Group_1__1 : rule__NavigationExp__Group_1__1__Impl ;
    public final void rule__NavigationExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2743:1: ( rule__NavigationExp__Group_1__1__Impl )
            // InternalOCLX.g:2744:2: rule__NavigationExp__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NavigationExp__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationExp__Group_1__1"


    // $ANTLR start "rule__NavigationExp__Group_1__1__Impl"
    // InternalOCLX.g:2750:1: rule__NavigationExp__Group_1__1__Impl : ( ( rule__NavigationExp__MethodsAssignment_1_1 ) ) ;
    public final void rule__NavigationExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2754:1: ( ( ( rule__NavigationExp__MethodsAssignment_1_1 ) ) )
            // InternalOCLX.g:2755:1: ( ( rule__NavigationExp__MethodsAssignment_1_1 ) )
            {
            // InternalOCLX.g:2755:1: ( ( rule__NavigationExp__MethodsAssignment_1_1 ) )
            // InternalOCLX.g:2756:2: ( rule__NavigationExp__MethodsAssignment_1_1 )
            {
             before(grammarAccess.getNavigationExpAccess().getMethodsAssignment_1_1()); 
            // InternalOCLX.g:2757:2: ( rule__NavigationExp__MethodsAssignment_1_1 )
            // InternalOCLX.g:2757:3: rule__NavigationExp__MethodsAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__NavigationExp__MethodsAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getNavigationExpAccess().getMethodsAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationExp__Group_1__1__Impl"


    // $ANTLR start "rule__SelfExp__Group__0"
    // InternalOCLX.g:2766:1: rule__SelfExp__Group__0 : rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1 ;
    public final void rule__SelfExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2770:1: ( rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1 )
            // InternalOCLX.g:2771:2: rule__SelfExp__Group__0__Impl rule__SelfExp__Group__1
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
    // InternalOCLX.g:2778:1: rule__SelfExp__Group__0__Impl : ( () ) ;
    public final void rule__SelfExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2782:1: ( ( () ) )
            // InternalOCLX.g:2783:1: ( () )
            {
            // InternalOCLX.g:2783:1: ( () )
            // InternalOCLX.g:2784:2: ()
            {
             before(grammarAccess.getSelfExpAccess().getSelfExpAction_0()); 
            // InternalOCLX.g:2785:2: ()
            // InternalOCLX.g:2785:3: 
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
    // InternalOCLX.g:2793:1: rule__SelfExp__Group__1 : rule__SelfExp__Group__1__Impl ;
    public final void rule__SelfExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2797:1: ( rule__SelfExp__Group__1__Impl )
            // InternalOCLX.g:2798:2: rule__SelfExp__Group__1__Impl
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
    // InternalOCLX.g:2804:1: rule__SelfExp__Group__1__Impl : ( ( rule__SelfExp__NameAssignment_1 ) ) ;
    public final void rule__SelfExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2808:1: ( ( ( rule__SelfExp__NameAssignment_1 ) ) )
            // InternalOCLX.g:2809:1: ( ( rule__SelfExp__NameAssignment_1 ) )
            {
            // InternalOCLX.g:2809:1: ( ( rule__SelfExp__NameAssignment_1 ) )
            // InternalOCLX.g:2810:2: ( rule__SelfExp__NameAssignment_1 )
            {
             before(grammarAccess.getSelfExpAccess().getNameAssignment_1()); 
            // InternalOCLX.g:2811:2: ( rule__SelfExp__NameAssignment_1 )
            // InternalOCLX.g:2811:3: rule__SelfExp__NameAssignment_1
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
    // InternalOCLX.g:2820:1: rule__CollectionIterator__Group__0 : rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 ;
    public final void rule__CollectionIterator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2824:1: ( rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1 )
            // InternalOCLX.g:2825:2: rule__CollectionIterator__Group__0__Impl rule__CollectionIterator__Group__1
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
    // InternalOCLX.g:2832:1: rule__CollectionIterator__Group__0__Impl : ( ( rule__CollectionIterator__NameAssignment_0 ) ) ;
    public final void rule__CollectionIterator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2836:1: ( ( ( rule__CollectionIterator__NameAssignment_0 ) ) )
            // InternalOCLX.g:2837:1: ( ( rule__CollectionIterator__NameAssignment_0 ) )
            {
            // InternalOCLX.g:2837:1: ( ( rule__CollectionIterator__NameAssignment_0 ) )
            // InternalOCLX.g:2838:2: ( rule__CollectionIterator__NameAssignment_0 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getNameAssignment_0()); 
            // InternalOCLX.g:2839:2: ( rule__CollectionIterator__NameAssignment_0 )
            // InternalOCLX.g:2839:3: rule__CollectionIterator__NameAssignment_0
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
    // InternalOCLX.g:2847:1: rule__CollectionIterator__Group__1 : rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 ;
    public final void rule__CollectionIterator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2851:1: ( rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2 )
            // InternalOCLX.g:2852:2: rule__CollectionIterator__Group__1__Impl rule__CollectionIterator__Group__2
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
    // InternalOCLX.g:2859:1: rule__CollectionIterator__Group__1__Impl : ( '(' ) ;
    public final void rule__CollectionIterator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2863:1: ( ( '(' ) )
            // InternalOCLX.g:2864:1: ( '(' )
            {
            // InternalOCLX.g:2864:1: ( '(' )
            // InternalOCLX.g:2865:2: '('
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
    // InternalOCLX.g:2874:1: rule__CollectionIterator__Group__2 : rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 ;
    public final void rule__CollectionIterator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2878:1: ( rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3 )
            // InternalOCLX.g:2879:2: rule__CollectionIterator__Group__2__Impl rule__CollectionIterator__Group__3
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
    // InternalOCLX.g:2886:1: rule__CollectionIterator__Group__2__Impl : ( ( rule__CollectionIterator__ItervarAssignment_2 ) ) ;
    public final void rule__CollectionIterator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2890:1: ( ( ( rule__CollectionIterator__ItervarAssignment_2 ) ) )
            // InternalOCLX.g:2891:1: ( ( rule__CollectionIterator__ItervarAssignment_2 ) )
            {
            // InternalOCLX.g:2891:1: ( ( rule__CollectionIterator__ItervarAssignment_2 ) )
            // InternalOCLX.g:2892:2: ( rule__CollectionIterator__ItervarAssignment_2 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getItervarAssignment_2()); 
            // InternalOCLX.g:2893:2: ( rule__CollectionIterator__ItervarAssignment_2 )
            // InternalOCLX.g:2893:3: rule__CollectionIterator__ItervarAssignment_2
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
    // InternalOCLX.g:2901:1: rule__CollectionIterator__Group__3 : rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4 ;
    public final void rule__CollectionIterator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2905:1: ( rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4 )
            // InternalOCLX.g:2906:2: rule__CollectionIterator__Group__3__Impl rule__CollectionIterator__Group__4
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
    // InternalOCLX.g:2913:1: rule__CollectionIterator__Group__3__Impl : ( '|' ) ;
    public final void rule__CollectionIterator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2917:1: ( ( '|' ) )
            // InternalOCLX.g:2918:1: ( '|' )
            {
            // InternalOCLX.g:2918:1: ( '|' )
            // InternalOCLX.g:2919:2: '|'
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
    // InternalOCLX.g:2928:1: rule__CollectionIterator__Group__4 : rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5 ;
    public final void rule__CollectionIterator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2932:1: ( rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5 )
            // InternalOCLX.g:2933:2: rule__CollectionIterator__Group__4__Impl rule__CollectionIterator__Group__5
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:2940:1: rule__CollectionIterator__Group__4__Impl : ( ( rule__CollectionIterator__BodyAssignment_4 ) ) ;
    public final void rule__CollectionIterator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2944:1: ( ( ( rule__CollectionIterator__BodyAssignment_4 ) ) )
            // InternalOCLX.g:2945:1: ( ( rule__CollectionIterator__BodyAssignment_4 ) )
            {
            // InternalOCLX.g:2945:1: ( ( rule__CollectionIterator__BodyAssignment_4 ) )
            // InternalOCLX.g:2946:2: ( rule__CollectionIterator__BodyAssignment_4 )
            {
             before(grammarAccess.getCollectionIteratorAccess().getBodyAssignment_4()); 
            // InternalOCLX.g:2947:2: ( rule__CollectionIterator__BodyAssignment_4 )
            // InternalOCLX.g:2947:3: rule__CollectionIterator__BodyAssignment_4
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
    // InternalOCLX.g:2955:1: rule__CollectionIterator__Group__5 : rule__CollectionIterator__Group__5__Impl ;
    public final void rule__CollectionIterator__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2959:1: ( rule__CollectionIterator__Group__5__Impl )
            // InternalOCLX.g:2960:2: rule__CollectionIterator__Group__5__Impl
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
    // InternalOCLX.g:2966:1: rule__CollectionIterator__Group__5__Impl : ( ')' ) ;
    public final void rule__CollectionIterator__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2970:1: ( ( ')' ) )
            // InternalOCLX.g:2971:1: ( ')' )
            {
            // InternalOCLX.g:2971:1: ( ')' )
            // InternalOCLX.g:2972:2: ')'
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
    // InternalOCLX.g:2982:1: rule__IteratorVarDeclaration__Group_1__0 : rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1 ;
    public final void rule__IteratorVarDeclaration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2986:1: ( rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1 )
            // InternalOCLX.g:2987:2: rule__IteratorVarDeclaration__Group_1__0__Impl rule__IteratorVarDeclaration__Group_1__1
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
    // InternalOCLX.g:2994:1: rule__IteratorVarDeclaration__Group_1__0__Impl : ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) ) ;
    public final void rule__IteratorVarDeclaration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:2998:1: ( ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) ) )
            // InternalOCLX.g:2999:1: ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) )
            {
            // InternalOCLX.g:2999:1: ( ( rule__IteratorVarDeclaration__NameAssignment_1_0 ) )
            // InternalOCLX.g:3000:2: ( rule__IteratorVarDeclaration__NameAssignment_1_0 )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getNameAssignment_1_0()); 
            // InternalOCLX.g:3001:2: ( rule__IteratorVarDeclaration__NameAssignment_1_0 )
            // InternalOCLX.g:3001:3: rule__IteratorVarDeclaration__NameAssignment_1_0
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
    // InternalOCLX.g:3009:1: rule__IteratorVarDeclaration__Group_1__1 : rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2 ;
    public final void rule__IteratorVarDeclaration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3013:1: ( rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2 )
            // InternalOCLX.g:3014:2: rule__IteratorVarDeclaration__Group_1__1__Impl rule__IteratorVarDeclaration__Group_1__2
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
    // InternalOCLX.g:3021:1: rule__IteratorVarDeclaration__Group_1__1__Impl : ( ':' ) ;
    public final void rule__IteratorVarDeclaration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3025:1: ( ( ':' ) )
            // InternalOCLX.g:3026:1: ( ':' )
            {
            // InternalOCLX.g:3026:1: ( ':' )
            // InternalOCLX.g:3027:2: ':'
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
    // InternalOCLX.g:3036:1: rule__IteratorVarDeclaration__Group_1__2 : rule__IteratorVarDeclaration__Group_1__2__Impl ;
    public final void rule__IteratorVarDeclaration__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3040:1: ( rule__IteratorVarDeclaration__Group_1__2__Impl )
            // InternalOCLX.g:3041:2: rule__IteratorVarDeclaration__Group_1__2__Impl
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
    // InternalOCLX.g:3047:1: rule__IteratorVarDeclaration__Group_1__2__Impl : ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) ) ;
    public final void rule__IteratorVarDeclaration__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3051:1: ( ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) ) )
            // InternalOCLX.g:3052:1: ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) )
            {
            // InternalOCLX.g:3052:1: ( ( rule__IteratorVarDeclaration__TypeAssignment_1_2 ) )
            // InternalOCLX.g:3053:2: ( rule__IteratorVarDeclaration__TypeAssignment_1_2 )
            {
             before(grammarAccess.getIteratorVarDeclarationAccess().getTypeAssignment_1_2()); 
            // InternalOCLX.g:3054:2: ( rule__IteratorVarDeclaration__TypeAssignment_1_2 )
            // InternalOCLX.g:3054:3: rule__IteratorVarDeclaration__TypeAssignment_1_2
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
    // InternalOCLX.g:3063:1: rule__MethodCall__Group_0__0 : rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1 ;
    public final void rule__MethodCall__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3067:1: ( rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1 )
            // InternalOCLX.g:3068:2: rule__MethodCall__Group_0__0__Impl rule__MethodCall__Group_0__1
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
    // InternalOCLX.g:3075:1: rule__MethodCall__Group_0__0__Impl : ( ( rule__MethodCall__NameAssignment_0_0 ) ) ;
    public final void rule__MethodCall__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3079:1: ( ( ( rule__MethodCall__NameAssignment_0_0 ) ) )
            // InternalOCLX.g:3080:1: ( ( rule__MethodCall__NameAssignment_0_0 ) )
            {
            // InternalOCLX.g:3080:1: ( ( rule__MethodCall__NameAssignment_0_0 ) )
            // InternalOCLX.g:3081:2: ( rule__MethodCall__NameAssignment_0_0 )
            {
             before(grammarAccess.getMethodCallAccess().getNameAssignment_0_0()); 
            // InternalOCLX.g:3082:2: ( rule__MethodCall__NameAssignment_0_0 )
            // InternalOCLX.g:3082:3: rule__MethodCall__NameAssignment_0_0
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
    // InternalOCLX.g:3090:1: rule__MethodCall__Group_0__1 : rule__MethodCall__Group_0__1__Impl ;
    public final void rule__MethodCall__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3094:1: ( rule__MethodCall__Group_0__1__Impl )
            // InternalOCLX.g:3095:2: rule__MethodCall__Group_0__1__Impl
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
    // InternalOCLX.g:3101:1: rule__MethodCall__Group_0__1__Impl : ( '()' ) ;
    public final void rule__MethodCall__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3105:1: ( ( '()' ) )
            // InternalOCLX.g:3106:1: ( '()' )
            {
            // InternalOCLX.g:3106:1: ( '()' )
            // InternalOCLX.g:3107:2: '()'
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
    // InternalOCLX.g:3117:1: rule__MethodCall__Group_1__0 : rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1 ;
    public final void rule__MethodCall__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3121:1: ( rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1 )
            // InternalOCLX.g:3122:2: rule__MethodCall__Group_1__0__Impl rule__MethodCall__Group_1__1
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
    // InternalOCLX.g:3129:1: rule__MethodCall__Group_1__0__Impl : ( ( rule__MethodCall__NameAssignment_1_0 ) ) ;
    public final void rule__MethodCall__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3133:1: ( ( ( rule__MethodCall__NameAssignment_1_0 ) ) )
            // InternalOCLX.g:3134:1: ( ( rule__MethodCall__NameAssignment_1_0 ) )
            {
            // InternalOCLX.g:3134:1: ( ( rule__MethodCall__NameAssignment_1_0 ) )
            // InternalOCLX.g:3135:2: ( rule__MethodCall__NameAssignment_1_0 )
            {
             before(grammarAccess.getMethodCallAccess().getNameAssignment_1_0()); 
            // InternalOCLX.g:3136:2: ( rule__MethodCall__NameAssignment_1_0 )
            // InternalOCLX.g:3136:3: rule__MethodCall__NameAssignment_1_0
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
    // InternalOCLX.g:3144:1: rule__MethodCall__Group_1__1 : rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2 ;
    public final void rule__MethodCall__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3148:1: ( rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2 )
            // InternalOCLX.g:3149:2: rule__MethodCall__Group_1__1__Impl rule__MethodCall__Group_1__2
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
    // InternalOCLX.g:3156:1: rule__MethodCall__Group_1__1__Impl : ( '(' ) ;
    public final void rule__MethodCall__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3160:1: ( ( '(' ) )
            // InternalOCLX.g:3161:1: ( '(' )
            {
            // InternalOCLX.g:3161:1: ( '(' )
            // InternalOCLX.g:3162:2: '('
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
    // InternalOCLX.g:3171:1: rule__MethodCall__Group_1__2 : rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3 ;
    public final void rule__MethodCall__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3175:1: ( rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3 )
            // InternalOCLX.g:3176:2: rule__MethodCall__Group_1__2__Impl rule__MethodCall__Group_1__3
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:3183:1: rule__MethodCall__Group_1__2__Impl : ( ( rule__MethodCall__ArgsAssignment_1_2 ) ) ;
    public final void rule__MethodCall__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3187:1: ( ( ( rule__MethodCall__ArgsAssignment_1_2 ) ) )
            // InternalOCLX.g:3188:1: ( ( rule__MethodCall__ArgsAssignment_1_2 ) )
            {
            // InternalOCLX.g:3188:1: ( ( rule__MethodCall__ArgsAssignment_1_2 ) )
            // InternalOCLX.g:3189:2: ( rule__MethodCall__ArgsAssignment_1_2 )
            {
             before(grammarAccess.getMethodCallAccess().getArgsAssignment_1_2()); 
            // InternalOCLX.g:3190:2: ( rule__MethodCall__ArgsAssignment_1_2 )
            // InternalOCLX.g:3190:3: rule__MethodCall__ArgsAssignment_1_2
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
    // InternalOCLX.g:3198:1: rule__MethodCall__Group_1__3 : rule__MethodCall__Group_1__3__Impl ;
    public final void rule__MethodCall__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3202:1: ( rule__MethodCall__Group_1__3__Impl )
            // InternalOCLX.g:3203:2: rule__MethodCall__Group_1__3__Impl
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
    // InternalOCLX.g:3209:1: rule__MethodCall__Group_1__3__Impl : ( ')' ) ;
    public final void rule__MethodCall__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3213:1: ( ( ')' ) )
            // InternalOCLX.g:3214:1: ( ')' )
            {
            // InternalOCLX.g:3214:1: ( ')' )
            // InternalOCLX.g:3215:2: ')'
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
    // InternalOCLX.g:3225:1: rule__TypeCall__Group__0 : rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1 ;
    public final void rule__TypeCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3229:1: ( rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1 )
            // InternalOCLX.g:3230:2: rule__TypeCall__Group__0__Impl rule__TypeCall__Group__1
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
    // InternalOCLX.g:3237:1: rule__TypeCall__Group__0__Impl : ( ( rule__TypeCall__NameAssignment_0 ) ) ;
    public final void rule__TypeCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3241:1: ( ( ( rule__TypeCall__NameAssignment_0 ) ) )
            // InternalOCLX.g:3242:1: ( ( rule__TypeCall__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3242:1: ( ( rule__TypeCall__NameAssignment_0 ) )
            // InternalOCLX.g:3243:2: ( rule__TypeCall__NameAssignment_0 )
            {
             before(grammarAccess.getTypeCallAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3244:2: ( rule__TypeCall__NameAssignment_0 )
            // InternalOCLX.g:3244:3: rule__TypeCall__NameAssignment_0
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
    // InternalOCLX.g:3252:1: rule__TypeCall__Group__1 : rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2 ;
    public final void rule__TypeCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3256:1: ( rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2 )
            // InternalOCLX.g:3257:2: rule__TypeCall__Group__1__Impl rule__TypeCall__Group__2
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
    // InternalOCLX.g:3264:1: rule__TypeCall__Group__1__Impl : ( '(' ) ;
    public final void rule__TypeCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3268:1: ( ( '(' ) )
            // InternalOCLX.g:3269:1: ( '(' )
            {
            // InternalOCLX.g:3269:1: ( '(' )
            // InternalOCLX.g:3270:2: '('
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
    // InternalOCLX.g:3279:1: rule__TypeCall__Group__2 : rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3 ;
    public final void rule__TypeCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3283:1: ( rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3 )
            // InternalOCLX.g:3284:2: rule__TypeCall__Group__2__Impl rule__TypeCall__Group__3
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:3291:1: rule__TypeCall__Group__2__Impl : ( ( rule__TypeCall__TypeAssignment_2 ) ) ;
    public final void rule__TypeCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3295:1: ( ( ( rule__TypeCall__TypeAssignment_2 ) ) )
            // InternalOCLX.g:3296:1: ( ( rule__TypeCall__TypeAssignment_2 ) )
            {
            // InternalOCLX.g:3296:1: ( ( rule__TypeCall__TypeAssignment_2 ) )
            // InternalOCLX.g:3297:2: ( rule__TypeCall__TypeAssignment_2 )
            {
             before(grammarAccess.getTypeCallAccess().getTypeAssignment_2()); 
            // InternalOCLX.g:3298:2: ( rule__TypeCall__TypeAssignment_2 )
            // InternalOCLX.g:3298:3: rule__TypeCall__TypeAssignment_2
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
    // InternalOCLX.g:3306:1: rule__TypeCall__Group__3 : rule__TypeCall__Group__3__Impl ;
    public final void rule__TypeCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3310:1: ( rule__TypeCall__Group__3__Impl )
            // InternalOCLX.g:3311:2: rule__TypeCall__Group__3__Impl
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
    // InternalOCLX.g:3317:1: rule__TypeCall__Group__3__Impl : ( ')' ) ;
    public final void rule__TypeCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3321:1: ( ( ')' ) )
            // InternalOCLX.g:3322:1: ( ')' )
            {
            // InternalOCLX.g:3322:1: ( ')' )
            // InternalOCLX.g:3323:2: ')'
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
    // InternalOCLX.g:3333:1: rule__TypeExp__Group__0 : rule__TypeExp__Group__0__Impl rule__TypeExp__Group__1 ;
    public final void rule__TypeExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3337:1: ( rule__TypeExp__Group__0__Impl rule__TypeExp__Group__1 )
            // InternalOCLX.g:3338:2: rule__TypeExp__Group__0__Impl rule__TypeExp__Group__1
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
    // InternalOCLX.g:3345:1: rule__TypeExp__Group__0__Impl : ( () ) ;
    public final void rule__TypeExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3349:1: ( ( () ) )
            // InternalOCLX.g:3350:1: ( () )
            {
            // InternalOCLX.g:3350:1: ( () )
            // InternalOCLX.g:3351:2: ()
            {
             before(grammarAccess.getTypeExpAccess().getTypeExpAction_0()); 
            // InternalOCLX.g:3352:2: ()
            // InternalOCLX.g:3352:3: 
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
    // InternalOCLX.g:3360:1: rule__TypeExp__Group__1 : rule__TypeExp__Group__1__Impl ;
    public final void rule__TypeExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3364:1: ( rule__TypeExp__Group__1__Impl )
            // InternalOCLX.g:3365:2: rule__TypeExp__Group__1__Impl
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
    // InternalOCLX.g:3371:1: rule__TypeExp__Group__1__Impl : ( ( rule__TypeExp__NameAssignment_1 ) ) ;
    public final void rule__TypeExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3375:1: ( ( ( rule__TypeExp__NameAssignment_1 ) ) )
            // InternalOCLX.g:3376:1: ( ( rule__TypeExp__NameAssignment_1 ) )
            {
            // InternalOCLX.g:3376:1: ( ( rule__TypeExp__NameAssignment_1 ) )
            // InternalOCLX.g:3377:2: ( rule__TypeExp__NameAssignment_1 )
            {
             before(grammarAccess.getTypeExpAccess().getNameAssignment_1()); 
            // InternalOCLX.g:3378:2: ( rule__TypeExp__NameAssignment_1 )
            // InternalOCLX.g:3378:3: rule__TypeExp__NameAssignment_1
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
    // InternalOCLX.g:3387:1: rule__UnaryTemporalExp__Group__0 : rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1 ;
    public final void rule__UnaryTemporalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3391:1: ( rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1 )
            // InternalOCLX.g:3392:2: rule__UnaryTemporalExp__Group__0__Impl rule__UnaryTemporalExp__Group__1
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
    // InternalOCLX.g:3399:1: rule__UnaryTemporalExp__Group__0__Impl : ( ( rule__UnaryTemporalExp__NameAssignment_0 ) ) ;
    public final void rule__UnaryTemporalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3403:1: ( ( ( rule__UnaryTemporalExp__NameAssignment_0 ) ) )
            // InternalOCLX.g:3404:1: ( ( rule__UnaryTemporalExp__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3404:1: ( ( rule__UnaryTemporalExp__NameAssignment_0 ) )
            // InternalOCLX.g:3405:2: ( rule__UnaryTemporalExp__NameAssignment_0 )
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3406:2: ( rule__UnaryTemporalExp__NameAssignment_0 )
            // InternalOCLX.g:3406:3: rule__UnaryTemporalExp__NameAssignment_0
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
    // InternalOCLX.g:3414:1: rule__UnaryTemporalExp__Group__1 : rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2 ;
    public final void rule__UnaryTemporalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3418:1: ( rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2 )
            // InternalOCLX.g:3419:2: rule__UnaryTemporalExp__Group__1__Impl rule__UnaryTemporalExp__Group__2
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
    // InternalOCLX.g:3426:1: rule__UnaryTemporalExp__Group__1__Impl : ( '(' ) ;
    public final void rule__UnaryTemporalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3430:1: ( ( '(' ) )
            // InternalOCLX.g:3431:1: ( '(' )
            {
            // InternalOCLX.g:3431:1: ( '(' )
            // InternalOCLX.g:3432:2: '('
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
    // InternalOCLX.g:3441:1: rule__UnaryTemporalExp__Group__2 : rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3 ;
    public final void rule__UnaryTemporalExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3445:1: ( rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3 )
            // InternalOCLX.g:3446:2: rule__UnaryTemporalExp__Group__2__Impl rule__UnaryTemporalExp__Group__3
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:3453:1: rule__UnaryTemporalExp__Group__2__Impl : ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) ) ;
    public final void rule__UnaryTemporalExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3457:1: ( ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) ) )
            // InternalOCLX.g:3458:1: ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) )
            {
            // InternalOCLX.g:3458:1: ( ( rule__UnaryTemporalExp__ExpAssignment_2 ) )
            // InternalOCLX.g:3459:2: ( rule__UnaryTemporalExp__ExpAssignment_2 )
            {
             before(grammarAccess.getUnaryTemporalExpAccess().getExpAssignment_2()); 
            // InternalOCLX.g:3460:2: ( rule__UnaryTemporalExp__ExpAssignment_2 )
            // InternalOCLX.g:3460:3: rule__UnaryTemporalExp__ExpAssignment_2
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
    // InternalOCLX.g:3468:1: rule__UnaryTemporalExp__Group__3 : rule__UnaryTemporalExp__Group__3__Impl ;
    public final void rule__UnaryTemporalExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3472:1: ( rule__UnaryTemporalExp__Group__3__Impl )
            // InternalOCLX.g:3473:2: rule__UnaryTemporalExp__Group__3__Impl
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
    // InternalOCLX.g:3479:1: rule__UnaryTemporalExp__Group__3__Impl : ( ')' ) ;
    public final void rule__UnaryTemporalExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3483:1: ( ( ')' ) )
            // InternalOCLX.g:3484:1: ( ')' )
            {
            // InternalOCLX.g:3484:1: ( ')' )
            // InternalOCLX.g:3485:2: ')'
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
    // InternalOCLX.g:3495:1: rule__TemporalAsLongAs__Group__0 : rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1 ;
    public final void rule__TemporalAsLongAs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3499:1: ( rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1 )
            // InternalOCLX.g:3500:2: rule__TemporalAsLongAs__Group__0__Impl rule__TemporalAsLongAs__Group__1
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
    // InternalOCLX.g:3507:1: rule__TemporalAsLongAs__Group__0__Impl : ( ( rule__TemporalAsLongAs__NameAssignment_0 ) ) ;
    public final void rule__TemporalAsLongAs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3511:1: ( ( ( rule__TemporalAsLongAs__NameAssignment_0 ) ) )
            // InternalOCLX.g:3512:1: ( ( rule__TemporalAsLongAs__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3512:1: ( ( rule__TemporalAsLongAs__NameAssignment_0 ) )
            // InternalOCLX.g:3513:2: ( rule__TemporalAsLongAs__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3514:2: ( rule__TemporalAsLongAs__NameAssignment_0 )
            // InternalOCLX.g:3514:3: rule__TemporalAsLongAs__NameAssignment_0
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
    // InternalOCLX.g:3522:1: rule__TemporalAsLongAs__Group__1 : rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2 ;
    public final void rule__TemporalAsLongAs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3526:1: ( rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2 )
            // InternalOCLX.g:3527:2: rule__TemporalAsLongAs__Group__1__Impl rule__TemporalAsLongAs__Group__2
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
    // InternalOCLX.g:3534:1: rule__TemporalAsLongAs__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalAsLongAs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3538:1: ( ( '(' ) )
            // InternalOCLX.g:3539:1: ( '(' )
            {
            // InternalOCLX.g:3539:1: ( '(' )
            // InternalOCLX.g:3540:2: '('
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
    // InternalOCLX.g:3549:1: rule__TemporalAsLongAs__Group__2 : rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3 ;
    public final void rule__TemporalAsLongAs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3553:1: ( rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3 )
            // InternalOCLX.g:3554:2: rule__TemporalAsLongAs__Group__2__Impl rule__TemporalAsLongAs__Group__3
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
    // InternalOCLX.g:3561:1: rule__TemporalAsLongAs__Group__2__Impl : ( ( rule__TemporalAsLongAs__BAssignment_2 ) ) ;
    public final void rule__TemporalAsLongAs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3565:1: ( ( ( rule__TemporalAsLongAs__BAssignment_2 ) ) )
            // InternalOCLX.g:3566:1: ( ( rule__TemporalAsLongAs__BAssignment_2 ) )
            {
            // InternalOCLX.g:3566:1: ( ( rule__TemporalAsLongAs__BAssignment_2 ) )
            // InternalOCLX.g:3567:2: ( rule__TemporalAsLongAs__BAssignment_2 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getBAssignment_2()); 
            // InternalOCLX.g:3568:2: ( rule__TemporalAsLongAs__BAssignment_2 )
            // InternalOCLX.g:3568:3: rule__TemporalAsLongAs__BAssignment_2
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
    // InternalOCLX.g:3576:1: rule__TemporalAsLongAs__Group__3 : rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4 ;
    public final void rule__TemporalAsLongAs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3580:1: ( rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4 )
            // InternalOCLX.g:3581:2: rule__TemporalAsLongAs__Group__3__Impl rule__TemporalAsLongAs__Group__4
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
    // InternalOCLX.g:3588:1: rule__TemporalAsLongAs__Group__3__Impl : ( 'ensureThat' ) ;
    public final void rule__TemporalAsLongAs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3592:1: ( ( 'ensureThat' ) )
            // InternalOCLX.g:3593:1: ( 'ensureThat' )
            {
            // InternalOCLX.g:3593:1: ( 'ensureThat' )
            // InternalOCLX.g:3594:2: 'ensureThat'
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
    // InternalOCLX.g:3603:1: rule__TemporalAsLongAs__Group__4 : rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5 ;
    public final void rule__TemporalAsLongAs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3607:1: ( rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5 )
            // InternalOCLX.g:3608:2: rule__TemporalAsLongAs__Group__4__Impl rule__TemporalAsLongAs__Group__5
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:3615:1: rule__TemporalAsLongAs__Group__4__Impl : ( ( rule__TemporalAsLongAs__AAssignment_4 ) ) ;
    public final void rule__TemporalAsLongAs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3619:1: ( ( ( rule__TemporalAsLongAs__AAssignment_4 ) ) )
            // InternalOCLX.g:3620:1: ( ( rule__TemporalAsLongAs__AAssignment_4 ) )
            {
            // InternalOCLX.g:3620:1: ( ( rule__TemporalAsLongAs__AAssignment_4 ) )
            // InternalOCLX.g:3621:2: ( rule__TemporalAsLongAs__AAssignment_4 )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getAAssignment_4()); 
            // InternalOCLX.g:3622:2: ( rule__TemporalAsLongAs__AAssignment_4 )
            // InternalOCLX.g:3622:3: rule__TemporalAsLongAs__AAssignment_4
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
    // InternalOCLX.g:3630:1: rule__TemporalAsLongAs__Group__5 : rule__TemporalAsLongAs__Group__5__Impl ;
    public final void rule__TemporalAsLongAs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3634:1: ( rule__TemporalAsLongAs__Group__5__Impl )
            // InternalOCLX.g:3635:2: rule__TemporalAsLongAs__Group__5__Impl
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
    // InternalOCLX.g:3641:1: rule__TemporalAsLongAs__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalAsLongAs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3645:1: ( ( ')' ) )
            // InternalOCLX.g:3646:1: ( ')' )
            {
            // InternalOCLX.g:3646:1: ( ')' )
            // InternalOCLX.g:3647:2: ')'
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
    // InternalOCLX.g:3657:1: rule__TemporalUntil__Group__0 : rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1 ;
    public final void rule__TemporalUntil__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3661:1: ( rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1 )
            // InternalOCLX.g:3662:2: rule__TemporalUntil__Group__0__Impl rule__TemporalUntil__Group__1
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
    // InternalOCLX.g:3669:1: rule__TemporalUntil__Group__0__Impl : ( ( rule__TemporalUntil__NameAssignment_0 ) ) ;
    public final void rule__TemporalUntil__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3673:1: ( ( ( rule__TemporalUntil__NameAssignment_0 ) ) )
            // InternalOCLX.g:3674:1: ( ( rule__TemporalUntil__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3674:1: ( ( rule__TemporalUntil__NameAssignment_0 ) )
            // InternalOCLX.g:3675:2: ( rule__TemporalUntil__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalUntilAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3676:2: ( rule__TemporalUntil__NameAssignment_0 )
            // InternalOCLX.g:3676:3: rule__TemporalUntil__NameAssignment_0
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
    // InternalOCLX.g:3684:1: rule__TemporalUntil__Group__1 : rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2 ;
    public final void rule__TemporalUntil__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3688:1: ( rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2 )
            // InternalOCLX.g:3689:2: rule__TemporalUntil__Group__1__Impl rule__TemporalUntil__Group__2
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
    // InternalOCLX.g:3696:1: rule__TemporalUntil__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalUntil__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3700:1: ( ( '(' ) )
            // InternalOCLX.g:3701:1: ( '(' )
            {
            // InternalOCLX.g:3701:1: ( '(' )
            // InternalOCLX.g:3702:2: '('
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
    // InternalOCLX.g:3711:1: rule__TemporalUntil__Group__2 : rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3 ;
    public final void rule__TemporalUntil__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3715:1: ( rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3 )
            // InternalOCLX.g:3716:2: rule__TemporalUntil__Group__2__Impl rule__TemporalUntil__Group__3
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
    // InternalOCLX.g:3723:1: rule__TemporalUntil__Group__2__Impl : ( ( rule__TemporalUntil__AAssignment_2 ) ) ;
    public final void rule__TemporalUntil__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3727:1: ( ( ( rule__TemporalUntil__AAssignment_2 ) ) )
            // InternalOCLX.g:3728:1: ( ( rule__TemporalUntil__AAssignment_2 ) )
            {
            // InternalOCLX.g:3728:1: ( ( rule__TemporalUntil__AAssignment_2 ) )
            // InternalOCLX.g:3729:2: ( rule__TemporalUntil__AAssignment_2 )
            {
             before(grammarAccess.getTemporalUntilAccess().getAAssignment_2()); 
            // InternalOCLX.g:3730:2: ( rule__TemporalUntil__AAssignment_2 )
            // InternalOCLX.g:3730:3: rule__TemporalUntil__AAssignment_2
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
    // InternalOCLX.g:3738:1: rule__TemporalUntil__Group__3 : rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4 ;
    public final void rule__TemporalUntil__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3742:1: ( rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4 )
            // InternalOCLX.g:3743:2: rule__TemporalUntil__Group__3__Impl rule__TemporalUntil__Group__4
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
    // InternalOCLX.g:3750:1: rule__TemporalUntil__Group__3__Impl : ( 'asLongAs' ) ;
    public final void rule__TemporalUntil__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3754:1: ( ( 'asLongAs' ) )
            // InternalOCLX.g:3755:1: ( 'asLongAs' )
            {
            // InternalOCLX.g:3755:1: ( 'asLongAs' )
            // InternalOCLX.g:3756:2: 'asLongAs'
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
    // InternalOCLX.g:3765:1: rule__TemporalUntil__Group__4 : rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5 ;
    public final void rule__TemporalUntil__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3769:1: ( rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5 )
            // InternalOCLX.g:3770:2: rule__TemporalUntil__Group__4__Impl rule__TemporalUntil__Group__5
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:3777:1: rule__TemporalUntil__Group__4__Impl : ( ( rule__TemporalUntil__BAssignment_4 ) ) ;
    public final void rule__TemporalUntil__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3781:1: ( ( ( rule__TemporalUntil__BAssignment_4 ) ) )
            // InternalOCLX.g:3782:1: ( ( rule__TemporalUntil__BAssignment_4 ) )
            {
            // InternalOCLX.g:3782:1: ( ( rule__TemporalUntil__BAssignment_4 ) )
            // InternalOCLX.g:3783:2: ( rule__TemporalUntil__BAssignment_4 )
            {
             before(grammarAccess.getTemporalUntilAccess().getBAssignment_4()); 
            // InternalOCLX.g:3784:2: ( rule__TemporalUntil__BAssignment_4 )
            // InternalOCLX.g:3784:3: rule__TemporalUntil__BAssignment_4
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
    // InternalOCLX.g:3792:1: rule__TemporalUntil__Group__5 : rule__TemporalUntil__Group__5__Impl ;
    public final void rule__TemporalUntil__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3796:1: ( rule__TemporalUntil__Group__5__Impl )
            // InternalOCLX.g:3797:2: rule__TemporalUntil__Group__5__Impl
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
    // InternalOCLX.g:3803:1: rule__TemporalUntil__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalUntil__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3807:1: ( ( ')' ) )
            // InternalOCLX.g:3808:1: ( ')' )
            {
            // InternalOCLX.g:3808:1: ( ')' )
            // InternalOCLX.g:3809:2: ')'
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
    // InternalOCLX.g:3819:1: rule__TemporalEverytime__Group__0 : rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1 ;
    public final void rule__TemporalEverytime__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3823:1: ( rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1 )
            // InternalOCLX.g:3824:2: rule__TemporalEverytime__Group__0__Impl rule__TemporalEverytime__Group__1
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
    // InternalOCLX.g:3831:1: rule__TemporalEverytime__Group__0__Impl : ( ( rule__TemporalEverytime__NameAssignment_0 ) ) ;
    public final void rule__TemporalEverytime__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3835:1: ( ( ( rule__TemporalEverytime__NameAssignment_0 ) ) )
            // InternalOCLX.g:3836:1: ( ( rule__TemporalEverytime__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3836:1: ( ( rule__TemporalEverytime__NameAssignment_0 ) )
            // InternalOCLX.g:3837:2: ( rule__TemporalEverytime__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getNameAssignment_0()); 
            // InternalOCLX.g:3838:2: ( rule__TemporalEverytime__NameAssignment_0 )
            // InternalOCLX.g:3838:3: rule__TemporalEverytime__NameAssignment_0
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
    // InternalOCLX.g:3846:1: rule__TemporalEverytime__Group__1 : rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2 ;
    public final void rule__TemporalEverytime__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3850:1: ( rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2 )
            // InternalOCLX.g:3851:2: rule__TemporalEverytime__Group__1__Impl rule__TemporalEverytime__Group__2
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
    // InternalOCLX.g:3858:1: rule__TemporalEverytime__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalEverytime__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3862:1: ( ( '(' ) )
            // InternalOCLX.g:3863:1: ( '(' )
            {
            // InternalOCLX.g:3863:1: ( '(' )
            // InternalOCLX.g:3864:2: '('
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
    // InternalOCLX.g:3873:1: rule__TemporalEverytime__Group__2 : rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3 ;
    public final void rule__TemporalEverytime__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3877:1: ( rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3 )
            // InternalOCLX.g:3878:2: rule__TemporalEverytime__Group__2__Impl rule__TemporalEverytime__Group__3
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
    // InternalOCLX.g:3885:1: rule__TemporalEverytime__Group__2__Impl : ( ( rule__TemporalEverytime__AAssignment_2 ) ) ;
    public final void rule__TemporalEverytime__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3889:1: ( ( ( rule__TemporalEverytime__AAssignment_2 ) ) )
            // InternalOCLX.g:3890:1: ( ( rule__TemporalEverytime__AAssignment_2 ) )
            {
            // InternalOCLX.g:3890:1: ( ( rule__TemporalEverytime__AAssignment_2 ) )
            // InternalOCLX.g:3891:2: ( rule__TemporalEverytime__AAssignment_2 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getAAssignment_2()); 
            // InternalOCLX.g:3892:2: ( rule__TemporalEverytime__AAssignment_2 )
            // InternalOCLX.g:3892:3: rule__TemporalEverytime__AAssignment_2
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
    // InternalOCLX.g:3900:1: rule__TemporalEverytime__Group__3 : rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4 ;
    public final void rule__TemporalEverytime__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3904:1: ( rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4 )
            // InternalOCLX.g:3905:2: rule__TemporalEverytime__Group__3__Impl rule__TemporalEverytime__Group__4
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
    // InternalOCLX.g:3912:1: rule__TemporalEverytime__Group__3__Impl : ( 'then' ) ;
    public final void rule__TemporalEverytime__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3916:1: ( ( 'then' ) )
            // InternalOCLX.g:3917:1: ( 'then' )
            {
            // InternalOCLX.g:3917:1: ( 'then' )
            // InternalOCLX.g:3918:2: 'then'
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
    // InternalOCLX.g:3927:1: rule__TemporalEverytime__Group__4 : rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5 ;
    public final void rule__TemporalEverytime__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3931:1: ( rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5 )
            // InternalOCLX.g:3932:2: rule__TemporalEverytime__Group__4__Impl rule__TemporalEverytime__Group__5
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:3939:1: rule__TemporalEverytime__Group__4__Impl : ( ( rule__TemporalEverytime__BAssignment_4 ) ) ;
    public final void rule__TemporalEverytime__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3943:1: ( ( ( rule__TemporalEverytime__BAssignment_4 ) ) )
            // InternalOCLX.g:3944:1: ( ( rule__TemporalEverytime__BAssignment_4 ) )
            {
            // InternalOCLX.g:3944:1: ( ( rule__TemporalEverytime__BAssignment_4 ) )
            // InternalOCLX.g:3945:2: ( rule__TemporalEverytime__BAssignment_4 )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getBAssignment_4()); 
            // InternalOCLX.g:3946:2: ( rule__TemporalEverytime__BAssignment_4 )
            // InternalOCLX.g:3946:3: rule__TemporalEverytime__BAssignment_4
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
    // InternalOCLX.g:3954:1: rule__TemporalEverytime__Group__5 : rule__TemporalEverytime__Group__5__Impl ;
    public final void rule__TemporalEverytime__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3958:1: ( rule__TemporalEverytime__Group__5__Impl )
            // InternalOCLX.g:3959:2: rule__TemporalEverytime__Group__5__Impl
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
    // InternalOCLX.g:3965:1: rule__TemporalEverytime__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalEverytime__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3969:1: ( ( ')' ) )
            // InternalOCLX.g:3970:1: ( ')' )
            {
            // InternalOCLX.g:3970:1: ( ')' )
            // InternalOCLX.g:3971:2: ')'
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
    // InternalOCLX.g:3981:1: rule__TemporalAtLeastOnce__Group__0 : rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1 ;
    public final void rule__TemporalAtLeastOnce__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3985:1: ( rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1 )
            // InternalOCLX.g:3986:2: rule__TemporalAtLeastOnce__Group__0__Impl rule__TemporalAtLeastOnce__Group__1
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
    // InternalOCLX.g:3993:1: rule__TemporalAtLeastOnce__Group__0__Impl : ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:3997:1: ( ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) ) )
            // InternalOCLX.g:3998:1: ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) )
            {
            // InternalOCLX.g:3998:1: ( ( rule__TemporalAtLeastOnce__NameAssignment_0 ) )
            // InternalOCLX.g:3999:2: ( rule__TemporalAtLeastOnce__NameAssignment_0 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4000:2: ( rule__TemporalAtLeastOnce__NameAssignment_0 )
            // InternalOCLX.g:4000:3: rule__TemporalAtLeastOnce__NameAssignment_0
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
    // InternalOCLX.g:4008:1: rule__TemporalAtLeastOnce__Group__1 : rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2 ;
    public final void rule__TemporalAtLeastOnce__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4012:1: ( rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2 )
            // InternalOCLX.g:4013:2: rule__TemporalAtLeastOnce__Group__1__Impl rule__TemporalAtLeastOnce__Group__2
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
    // InternalOCLX.g:4020:1: rule__TemporalAtLeastOnce__Group__1__Impl : ( '(' ) ;
    public final void rule__TemporalAtLeastOnce__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4024:1: ( ( '(' ) )
            // InternalOCLX.g:4025:1: ( '(' )
            {
            // InternalOCLX.g:4025:1: ( '(' )
            // InternalOCLX.g:4026:2: '('
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
    // InternalOCLX.g:4035:1: rule__TemporalAtLeastOnce__Group__2 : rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3 ;
    public final void rule__TemporalAtLeastOnce__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4039:1: ( rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3 )
            // InternalOCLX.g:4040:2: rule__TemporalAtLeastOnce__Group__2__Impl rule__TemporalAtLeastOnce__Group__3
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
    // InternalOCLX.g:4047:1: rule__TemporalAtLeastOnce__Group__2__Impl : ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4051:1: ( ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) ) )
            // InternalOCLX.g:4052:1: ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) )
            {
            // InternalOCLX.g:4052:1: ( ( rule__TemporalAtLeastOnce__AAssignment_2 ) )
            // InternalOCLX.g:4053:2: ( rule__TemporalAtLeastOnce__AAssignment_2 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getAAssignment_2()); 
            // InternalOCLX.g:4054:2: ( rule__TemporalAtLeastOnce__AAssignment_2 )
            // InternalOCLX.g:4054:3: rule__TemporalAtLeastOnce__AAssignment_2
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
    // InternalOCLX.g:4062:1: rule__TemporalAtLeastOnce__Group__3 : rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4 ;
    public final void rule__TemporalAtLeastOnce__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4066:1: ( rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4 )
            // InternalOCLX.g:4067:2: rule__TemporalAtLeastOnce__Group__3__Impl rule__TemporalAtLeastOnce__Group__4
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
    // InternalOCLX.g:4074:1: rule__TemporalAtLeastOnce__Group__3__Impl : ( 'thenAtLeastOnce' ) ;
    public final void rule__TemporalAtLeastOnce__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4078:1: ( ( 'thenAtLeastOnce' ) )
            // InternalOCLX.g:4079:1: ( 'thenAtLeastOnce' )
            {
            // InternalOCLX.g:4079:1: ( 'thenAtLeastOnce' )
            // InternalOCLX.g:4080:2: 'thenAtLeastOnce'
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
    // InternalOCLX.g:4089:1: rule__TemporalAtLeastOnce__Group__4 : rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5 ;
    public final void rule__TemporalAtLeastOnce__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4093:1: ( rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5 )
            // InternalOCLX.g:4094:2: rule__TemporalAtLeastOnce__Group__4__Impl rule__TemporalAtLeastOnce__Group__5
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:4101:1: rule__TemporalAtLeastOnce__Group__4__Impl : ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) ) ;
    public final void rule__TemporalAtLeastOnce__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4105:1: ( ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) ) )
            // InternalOCLX.g:4106:1: ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) )
            {
            // InternalOCLX.g:4106:1: ( ( rule__TemporalAtLeastOnce__BAssignment_4 ) )
            // InternalOCLX.g:4107:2: ( rule__TemporalAtLeastOnce__BAssignment_4 )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getBAssignment_4()); 
            // InternalOCLX.g:4108:2: ( rule__TemporalAtLeastOnce__BAssignment_4 )
            // InternalOCLX.g:4108:3: rule__TemporalAtLeastOnce__BAssignment_4
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
    // InternalOCLX.g:4116:1: rule__TemporalAtLeastOnce__Group__5 : rule__TemporalAtLeastOnce__Group__5__Impl ;
    public final void rule__TemporalAtLeastOnce__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4120:1: ( rule__TemporalAtLeastOnce__Group__5__Impl )
            // InternalOCLX.g:4121:2: rule__TemporalAtLeastOnce__Group__5__Impl
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
    // InternalOCLX.g:4127:1: rule__TemporalAtLeastOnce__Group__5__Impl : ( ')' ) ;
    public final void rule__TemporalAtLeastOnce__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4131:1: ( ( ')' ) )
            // InternalOCLX.g:4132:1: ( ')' )
            {
            // InternalOCLX.g:4132:1: ( ')' )
            // InternalOCLX.g:4133:2: ')'
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
    // InternalOCLX.g:4143:1: rule__LegacyUntil__Group__0 : rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1 ;
    public final void rule__LegacyUntil__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4147:1: ( rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1 )
            // InternalOCLX.g:4148:2: rule__LegacyUntil__Group__0__Impl rule__LegacyUntil__Group__1
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
    // InternalOCLX.g:4155:1: rule__LegacyUntil__Group__0__Impl : ( ( rule__LegacyUntil__NameAssignment_0 ) ) ;
    public final void rule__LegacyUntil__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4159:1: ( ( ( rule__LegacyUntil__NameAssignment_0 ) ) )
            // InternalOCLX.g:4160:1: ( ( rule__LegacyUntil__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4160:1: ( ( rule__LegacyUntil__NameAssignment_0 ) )
            // InternalOCLX.g:4161:2: ( rule__LegacyUntil__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyUntilAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4162:2: ( rule__LegacyUntil__NameAssignment_0 )
            // InternalOCLX.g:4162:3: rule__LegacyUntil__NameAssignment_0
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
    // InternalOCLX.g:4170:1: rule__LegacyUntil__Group__1 : rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2 ;
    public final void rule__LegacyUntil__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4174:1: ( rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2 )
            // InternalOCLX.g:4175:2: rule__LegacyUntil__Group__1__Impl rule__LegacyUntil__Group__2
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
    // InternalOCLX.g:4182:1: rule__LegacyUntil__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyUntil__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4186:1: ( ( '(' ) )
            // InternalOCLX.g:4187:1: ( '(' )
            {
            // InternalOCLX.g:4187:1: ( '(' )
            // InternalOCLX.g:4188:2: '('
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
    // InternalOCLX.g:4197:1: rule__LegacyUntil__Group__2 : rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3 ;
    public final void rule__LegacyUntil__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4201:1: ( rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3 )
            // InternalOCLX.g:4202:2: rule__LegacyUntil__Group__2__Impl rule__LegacyUntil__Group__3
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
    // InternalOCLX.g:4209:1: rule__LegacyUntil__Group__2__Impl : ( ( rule__LegacyUntil__AAssignment_2 ) ) ;
    public final void rule__LegacyUntil__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4213:1: ( ( ( rule__LegacyUntil__AAssignment_2 ) ) )
            // InternalOCLX.g:4214:1: ( ( rule__LegacyUntil__AAssignment_2 ) )
            {
            // InternalOCLX.g:4214:1: ( ( rule__LegacyUntil__AAssignment_2 ) )
            // InternalOCLX.g:4215:2: ( rule__LegacyUntil__AAssignment_2 )
            {
             before(grammarAccess.getLegacyUntilAccess().getAAssignment_2()); 
            // InternalOCLX.g:4216:2: ( rule__LegacyUntil__AAssignment_2 )
            // InternalOCLX.g:4216:3: rule__LegacyUntil__AAssignment_2
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
    // InternalOCLX.g:4224:1: rule__LegacyUntil__Group__3 : rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4 ;
    public final void rule__LegacyUntil__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4228:1: ( rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4 )
            // InternalOCLX.g:4229:2: rule__LegacyUntil__Group__3__Impl rule__LegacyUntil__Group__4
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
    // InternalOCLX.g:4236:1: rule__LegacyUntil__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyUntil__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4240:1: ( ( ',' ) )
            // InternalOCLX.g:4241:1: ( ',' )
            {
            // InternalOCLX.g:4241:1: ( ',' )
            // InternalOCLX.g:4242:2: ','
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
    // InternalOCLX.g:4251:1: rule__LegacyUntil__Group__4 : rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5 ;
    public final void rule__LegacyUntil__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4255:1: ( rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5 )
            // InternalOCLX.g:4256:2: rule__LegacyUntil__Group__4__Impl rule__LegacyUntil__Group__5
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:4263:1: rule__LegacyUntil__Group__4__Impl : ( ( rule__LegacyUntil__BAssignment_4 ) ) ;
    public final void rule__LegacyUntil__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4267:1: ( ( ( rule__LegacyUntil__BAssignment_4 ) ) )
            // InternalOCLX.g:4268:1: ( ( rule__LegacyUntil__BAssignment_4 ) )
            {
            // InternalOCLX.g:4268:1: ( ( rule__LegacyUntil__BAssignment_4 ) )
            // InternalOCLX.g:4269:2: ( rule__LegacyUntil__BAssignment_4 )
            {
             before(grammarAccess.getLegacyUntilAccess().getBAssignment_4()); 
            // InternalOCLX.g:4270:2: ( rule__LegacyUntil__BAssignment_4 )
            // InternalOCLX.g:4270:3: rule__LegacyUntil__BAssignment_4
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
    // InternalOCLX.g:4278:1: rule__LegacyUntil__Group__5 : rule__LegacyUntil__Group__5__Impl ;
    public final void rule__LegacyUntil__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4282:1: ( rule__LegacyUntil__Group__5__Impl )
            // InternalOCLX.g:4283:2: rule__LegacyUntil__Group__5__Impl
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
    // InternalOCLX.g:4289:1: rule__LegacyUntil__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyUntil__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4293:1: ( ( ')' ) )
            // InternalOCLX.g:4294:1: ( ')' )
            {
            // InternalOCLX.g:4294:1: ( ')' )
            // InternalOCLX.g:4295:2: ')'
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
    // InternalOCLX.g:4305:1: rule__LegacyAsSoonAs__Group__0 : rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1 ;
    public final void rule__LegacyAsSoonAs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4309:1: ( rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1 )
            // InternalOCLX.g:4310:2: rule__LegacyAsSoonAs__Group__0__Impl rule__LegacyAsSoonAs__Group__1
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
    // InternalOCLX.g:4317:1: rule__LegacyAsSoonAs__Group__0__Impl : ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4321:1: ( ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) ) )
            // InternalOCLX.g:4322:1: ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4322:1: ( ( rule__LegacyAsSoonAs__NameAssignment_0 ) )
            // InternalOCLX.g:4323:2: ( rule__LegacyAsSoonAs__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4324:2: ( rule__LegacyAsSoonAs__NameAssignment_0 )
            // InternalOCLX.g:4324:3: rule__LegacyAsSoonAs__NameAssignment_0
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
    // InternalOCLX.g:4332:1: rule__LegacyAsSoonAs__Group__1 : rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2 ;
    public final void rule__LegacyAsSoonAs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4336:1: ( rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2 )
            // InternalOCLX.g:4337:2: rule__LegacyAsSoonAs__Group__1__Impl rule__LegacyAsSoonAs__Group__2
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
    // InternalOCLX.g:4344:1: rule__LegacyAsSoonAs__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyAsSoonAs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4348:1: ( ( '(' ) )
            // InternalOCLX.g:4349:1: ( '(' )
            {
            // InternalOCLX.g:4349:1: ( '(' )
            // InternalOCLX.g:4350:2: '('
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
    // InternalOCLX.g:4359:1: rule__LegacyAsSoonAs__Group__2 : rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3 ;
    public final void rule__LegacyAsSoonAs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4363:1: ( rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3 )
            // InternalOCLX.g:4364:2: rule__LegacyAsSoonAs__Group__2__Impl rule__LegacyAsSoonAs__Group__3
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
    // InternalOCLX.g:4371:1: rule__LegacyAsSoonAs__Group__2__Impl : ( ( rule__LegacyAsSoonAs__AAssignment_2 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4375:1: ( ( ( rule__LegacyAsSoonAs__AAssignment_2 ) ) )
            // InternalOCLX.g:4376:1: ( ( rule__LegacyAsSoonAs__AAssignment_2 ) )
            {
            // InternalOCLX.g:4376:1: ( ( rule__LegacyAsSoonAs__AAssignment_2 ) )
            // InternalOCLX.g:4377:2: ( rule__LegacyAsSoonAs__AAssignment_2 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getAAssignment_2()); 
            // InternalOCLX.g:4378:2: ( rule__LegacyAsSoonAs__AAssignment_2 )
            // InternalOCLX.g:4378:3: rule__LegacyAsSoonAs__AAssignment_2
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
    // InternalOCLX.g:4386:1: rule__LegacyAsSoonAs__Group__3 : rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4 ;
    public final void rule__LegacyAsSoonAs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4390:1: ( rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4 )
            // InternalOCLX.g:4391:2: rule__LegacyAsSoonAs__Group__3__Impl rule__LegacyAsSoonAs__Group__4
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
    // InternalOCLX.g:4398:1: rule__LegacyAsSoonAs__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyAsSoonAs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4402:1: ( ( ',' ) )
            // InternalOCLX.g:4403:1: ( ',' )
            {
            // InternalOCLX.g:4403:1: ( ',' )
            // InternalOCLX.g:4404:2: ','
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
    // InternalOCLX.g:4413:1: rule__LegacyAsSoonAs__Group__4 : rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5 ;
    public final void rule__LegacyAsSoonAs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4417:1: ( rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5 )
            // InternalOCLX.g:4418:2: rule__LegacyAsSoonAs__Group__4__Impl rule__LegacyAsSoonAs__Group__5
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:4425:1: rule__LegacyAsSoonAs__Group__4__Impl : ( ( rule__LegacyAsSoonAs__BAssignment_4 ) ) ;
    public final void rule__LegacyAsSoonAs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4429:1: ( ( ( rule__LegacyAsSoonAs__BAssignment_4 ) ) )
            // InternalOCLX.g:4430:1: ( ( rule__LegacyAsSoonAs__BAssignment_4 ) )
            {
            // InternalOCLX.g:4430:1: ( ( rule__LegacyAsSoonAs__BAssignment_4 ) )
            // InternalOCLX.g:4431:2: ( rule__LegacyAsSoonAs__BAssignment_4 )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getBAssignment_4()); 
            // InternalOCLX.g:4432:2: ( rule__LegacyAsSoonAs__BAssignment_4 )
            // InternalOCLX.g:4432:3: rule__LegacyAsSoonAs__BAssignment_4
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
    // InternalOCLX.g:4440:1: rule__LegacyAsSoonAs__Group__5 : rule__LegacyAsSoonAs__Group__5__Impl ;
    public final void rule__LegacyAsSoonAs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4444:1: ( rule__LegacyAsSoonAs__Group__5__Impl )
            // InternalOCLX.g:4445:2: rule__LegacyAsSoonAs__Group__5__Impl
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
    // InternalOCLX.g:4451:1: rule__LegacyAsSoonAs__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyAsSoonAs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4455:1: ( ( ')' ) )
            // InternalOCLX.g:4456:1: ( ')' )
            {
            // InternalOCLX.g:4456:1: ( ')' )
            // InternalOCLX.g:4457:2: ')'
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
    // InternalOCLX.g:4467:1: rule__LegacyEverytime__Group__0 : rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1 ;
    public final void rule__LegacyEverytime__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4471:1: ( rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1 )
            // InternalOCLX.g:4472:2: rule__LegacyEverytime__Group__0__Impl rule__LegacyEverytime__Group__1
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
    // InternalOCLX.g:4479:1: rule__LegacyEverytime__Group__0__Impl : ( ( rule__LegacyEverytime__NameAssignment_0 ) ) ;
    public final void rule__LegacyEverytime__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4483:1: ( ( ( rule__LegacyEverytime__NameAssignment_0 ) ) )
            // InternalOCLX.g:4484:1: ( ( rule__LegacyEverytime__NameAssignment_0 ) )
            {
            // InternalOCLX.g:4484:1: ( ( rule__LegacyEverytime__NameAssignment_0 ) )
            // InternalOCLX.g:4485:2: ( rule__LegacyEverytime__NameAssignment_0 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getNameAssignment_0()); 
            // InternalOCLX.g:4486:2: ( rule__LegacyEverytime__NameAssignment_0 )
            // InternalOCLX.g:4486:3: rule__LegacyEverytime__NameAssignment_0
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
    // InternalOCLX.g:4494:1: rule__LegacyEverytime__Group__1 : rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2 ;
    public final void rule__LegacyEverytime__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4498:1: ( rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2 )
            // InternalOCLX.g:4499:2: rule__LegacyEverytime__Group__1__Impl rule__LegacyEverytime__Group__2
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
    // InternalOCLX.g:4506:1: rule__LegacyEverytime__Group__1__Impl : ( '(' ) ;
    public final void rule__LegacyEverytime__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4510:1: ( ( '(' ) )
            // InternalOCLX.g:4511:1: ( '(' )
            {
            // InternalOCLX.g:4511:1: ( '(' )
            // InternalOCLX.g:4512:2: '('
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
    // InternalOCLX.g:4521:1: rule__LegacyEverytime__Group__2 : rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3 ;
    public final void rule__LegacyEverytime__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4525:1: ( rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3 )
            // InternalOCLX.g:4526:2: rule__LegacyEverytime__Group__2__Impl rule__LegacyEverytime__Group__3
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
    // InternalOCLX.g:4533:1: rule__LegacyEverytime__Group__2__Impl : ( ( rule__LegacyEverytime__AAssignment_2 ) ) ;
    public final void rule__LegacyEverytime__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4537:1: ( ( ( rule__LegacyEverytime__AAssignment_2 ) ) )
            // InternalOCLX.g:4538:1: ( ( rule__LegacyEverytime__AAssignment_2 ) )
            {
            // InternalOCLX.g:4538:1: ( ( rule__LegacyEverytime__AAssignment_2 ) )
            // InternalOCLX.g:4539:2: ( rule__LegacyEverytime__AAssignment_2 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getAAssignment_2()); 
            // InternalOCLX.g:4540:2: ( rule__LegacyEverytime__AAssignment_2 )
            // InternalOCLX.g:4540:3: rule__LegacyEverytime__AAssignment_2
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
    // InternalOCLX.g:4548:1: rule__LegacyEverytime__Group__3 : rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4 ;
    public final void rule__LegacyEverytime__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4552:1: ( rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4 )
            // InternalOCLX.g:4553:2: rule__LegacyEverytime__Group__3__Impl rule__LegacyEverytime__Group__4
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
    // InternalOCLX.g:4560:1: rule__LegacyEverytime__Group__3__Impl : ( ',' ) ;
    public final void rule__LegacyEverytime__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4564:1: ( ( ',' ) )
            // InternalOCLX.g:4565:1: ( ',' )
            {
            // InternalOCLX.g:4565:1: ( ',' )
            // InternalOCLX.g:4566:2: ','
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
    // InternalOCLX.g:4575:1: rule__LegacyEverytime__Group__4 : rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5 ;
    public final void rule__LegacyEverytime__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4579:1: ( rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5 )
            // InternalOCLX.g:4580:2: rule__LegacyEverytime__Group__4__Impl rule__LegacyEverytime__Group__5
            {
            pushFollow(FOLLOW_19);
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
    // InternalOCLX.g:4587:1: rule__LegacyEverytime__Group__4__Impl : ( ( rule__LegacyEverytime__BAssignment_4 ) ) ;
    public final void rule__LegacyEverytime__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4591:1: ( ( ( rule__LegacyEverytime__BAssignment_4 ) ) )
            // InternalOCLX.g:4592:1: ( ( rule__LegacyEverytime__BAssignment_4 ) )
            {
            // InternalOCLX.g:4592:1: ( ( rule__LegacyEverytime__BAssignment_4 ) )
            // InternalOCLX.g:4593:2: ( rule__LegacyEverytime__BAssignment_4 )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getBAssignment_4()); 
            // InternalOCLX.g:4594:2: ( rule__LegacyEverytime__BAssignment_4 )
            // InternalOCLX.g:4594:3: rule__LegacyEverytime__BAssignment_4
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
    // InternalOCLX.g:4602:1: rule__LegacyEverytime__Group__5 : rule__LegacyEverytime__Group__5__Impl ;
    public final void rule__LegacyEverytime__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4606:1: ( rule__LegacyEverytime__Group__5__Impl )
            // InternalOCLX.g:4607:2: rule__LegacyEverytime__Group__5__Impl
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
    // InternalOCLX.g:4613:1: rule__LegacyEverytime__Group__5__Impl : ( ')' ) ;
    public final void rule__LegacyEverytime__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4617:1: ( ( ')' ) )
            // InternalOCLX.g:4618:1: ( ')' )
            {
            // InternalOCLX.g:4618:1: ( ')' )
            // InternalOCLX.g:4619:2: ')'
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
    // InternalOCLX.g:4629:1: rule__ArgumentsExp__Group__0 : rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1 ;
    public final void rule__ArgumentsExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4633:1: ( rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1 )
            // InternalOCLX.g:4634:2: rule__ArgumentsExp__Group__0__Impl rule__ArgumentsExp__Group__1
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
    // InternalOCLX.g:4641:1: rule__ArgumentsExp__Group__0__Impl : ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) ) ;
    public final void rule__ArgumentsExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4645:1: ( ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) ) )
            // InternalOCLX.g:4646:1: ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) )
            {
            // InternalOCLX.g:4646:1: ( ( rule__ArgumentsExp__OperatorsAssignment_0 ) )
            // InternalOCLX.g:4647:2: ( rule__ArgumentsExp__OperatorsAssignment_0 )
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_0()); 
            // InternalOCLX.g:4648:2: ( rule__ArgumentsExp__OperatorsAssignment_0 )
            // InternalOCLX.g:4648:3: rule__ArgumentsExp__OperatorsAssignment_0
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
    // InternalOCLX.g:4656:1: rule__ArgumentsExp__Group__1 : rule__ArgumentsExp__Group__1__Impl ;
    public final void rule__ArgumentsExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4660:1: ( rule__ArgumentsExp__Group__1__Impl )
            // InternalOCLX.g:4661:2: rule__ArgumentsExp__Group__1__Impl
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
    // InternalOCLX.g:4667:1: rule__ArgumentsExp__Group__1__Impl : ( ( rule__ArgumentsExp__Group_1__0 )* ) ;
    public final void rule__ArgumentsExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4671:1: ( ( ( rule__ArgumentsExp__Group_1__0 )* ) )
            // InternalOCLX.g:4672:1: ( ( rule__ArgumentsExp__Group_1__0 )* )
            {
            // InternalOCLX.g:4672:1: ( ( rule__ArgumentsExp__Group_1__0 )* )
            // InternalOCLX.g:4673:2: ( rule__ArgumentsExp__Group_1__0 )*
            {
             before(grammarAccess.getArgumentsExpAccess().getGroup_1()); 
            // InternalOCLX.g:4674:2: ( rule__ArgumentsExp__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==58) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalOCLX.g:4674:3: rule__ArgumentsExp__Group_1__0
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
    // InternalOCLX.g:4683:1: rule__ArgumentsExp__Group_1__0 : rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1 ;
    public final void rule__ArgumentsExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4687:1: ( rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1 )
            // InternalOCLX.g:4688:2: rule__ArgumentsExp__Group_1__0__Impl rule__ArgumentsExp__Group_1__1
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
    // InternalOCLX.g:4695:1: rule__ArgumentsExp__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ArgumentsExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4699:1: ( ( ',' ) )
            // InternalOCLX.g:4700:1: ( ',' )
            {
            // InternalOCLX.g:4700:1: ( ',' )
            // InternalOCLX.g:4701:2: ','
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
    // InternalOCLX.g:4710:1: rule__ArgumentsExp__Group_1__1 : rule__ArgumentsExp__Group_1__1__Impl ;
    public final void rule__ArgumentsExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4714:1: ( rule__ArgumentsExp__Group_1__1__Impl )
            // InternalOCLX.g:4715:2: rule__ArgumentsExp__Group_1__1__Impl
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
    // InternalOCLX.g:4721:1: rule__ArgumentsExp__Group_1__1__Impl : ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) ) ;
    public final void rule__ArgumentsExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4725:1: ( ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) ) )
            // InternalOCLX.g:4726:1: ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) )
            {
            // InternalOCLX.g:4726:1: ( ( rule__ArgumentsExp__OperatorsAssignment_1_1 ) )
            // InternalOCLX.g:4727:2: ( rule__ArgumentsExp__OperatorsAssignment_1_1 )
            {
             before(grammarAccess.getArgumentsExpAccess().getOperatorsAssignment_1_1()); 
            // InternalOCLX.g:4728:2: ( rule__ArgumentsExp__OperatorsAssignment_1_1 )
            // InternalOCLX.g:4728:3: rule__ArgumentsExp__OperatorsAssignment_1_1
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
    // InternalOCLX.g:4737:1: rule__Model__ConstraintsAssignment : ( ruleConstraint ) ;
    public final void rule__Model__ConstraintsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4741:1: ( ( ruleConstraint ) )
            // InternalOCLX.g:4742:2: ( ruleConstraint )
            {
            // InternalOCLX.g:4742:2: ( ruleConstraint )
            // InternalOCLX.g:4743:3: ruleConstraint
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
    // InternalOCLX.g:4752:1: rule__Constraint__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Constraint__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4756:1: ( ( RULE_ID ) )
            // InternalOCLX.g:4757:2: ( RULE_ID )
            {
            // InternalOCLX.g:4757:2: ( RULE_ID )
            // InternalOCLX.g:4758:3: RULE_ID
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
    // InternalOCLX.g:4767:1: rule__Constraint__DescriptionAssignment_3_1 : ( RULE_DESCRIPTION ) ;
    public final void rule__Constraint__DescriptionAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4771:1: ( ( RULE_DESCRIPTION ) )
            // InternalOCLX.g:4772:2: ( RULE_DESCRIPTION )
            {
            // InternalOCLX.g:4772:2: ( RULE_DESCRIPTION )
            // InternalOCLX.g:4773:3: RULE_DESCRIPTION
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
    // InternalOCLX.g:4782:1: rule__Constraint__OverrulableAssignment_4_2 : ( ruleBooleanLiteralExp ) ;
    public final void rule__Constraint__OverrulableAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4786:1: ( ( ruleBooleanLiteralExp ) )
            // InternalOCLX.g:4787:2: ( ruleBooleanLiteralExp )
            {
            // InternalOCLX.g:4787:2: ( ruleBooleanLiteralExp )
            // InternalOCLX.g:4788:3: ruleBooleanLiteralExp
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
    // InternalOCLX.g:4797:1: rule__Constraint__ContextAssignment_6 : ( ruleContext ) ;
    public final void rule__Constraint__ContextAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4801:1: ( ( ruleContext ) )
            // InternalOCLX.g:4802:2: ( ruleContext )
            {
            // InternalOCLX.g:4802:2: ( ruleContext )
            // InternalOCLX.g:4803:3: ruleContext
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
    // InternalOCLX.g:4812:1: rule__Constraint__ExpressionAssignment_8 : ( ruleExp ) ;
    public final void rule__Constraint__ExpressionAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4816:1: ( ( ruleExp ) )
            // InternalOCLX.g:4817:2: ( ruleExp )
            {
            // InternalOCLX.g:4817:2: ( ruleExp )
            // InternalOCLX.g:4818:3: ruleExp
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
    // InternalOCLX.g:4827:1: rule__Context__NameAssignment : ( ruleQualifiedName ) ;
    public final void rule__Context__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4831:1: ( ( ruleQualifiedName ) )
            // InternalOCLX.g:4832:2: ( ruleQualifiedName )
            {
            // InternalOCLX.g:4832:2: ( ruleQualifiedName )
            // InternalOCLX.g:4833:3: ruleQualifiedName
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
    // InternalOCLX.g:4842:1: rule__Exp__OperatorsAssignment_1_1 : ( ruleBinaryOperator ) ;
    public final void rule__Exp__OperatorsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4846:1: ( ( ruleBinaryOperator ) )
            // InternalOCLX.g:4847:2: ( ruleBinaryOperator )
            {
            // InternalOCLX.g:4847:2: ( ruleBinaryOperator )
            // InternalOCLX.g:4848:3: ruleBinaryOperator
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
    // InternalOCLX.g:4857:1: rule__Exp__ExpressionsAssignment_1_2 : ( rulePrefixedExp ) ;
    public final void rule__Exp__ExpressionsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4861:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:4862:2: ( rulePrefixedExp )
            {
            // InternalOCLX.g:4862:2: ( rulePrefixedExp )
            // InternalOCLX.g:4863:3: rulePrefixedExp
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
    // InternalOCLX.g:4872:1: rule__Exp__OperatorsAssignment_1_3_0 : ( ruleBinaryOperator ) ;
    public final void rule__Exp__OperatorsAssignment_1_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4876:1: ( ( ruleBinaryOperator ) )
            // InternalOCLX.g:4877:2: ( ruleBinaryOperator )
            {
            // InternalOCLX.g:4877:2: ( ruleBinaryOperator )
            // InternalOCLX.g:4878:3: ruleBinaryOperator
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
    // InternalOCLX.g:4887:1: rule__Exp__ExpressionsAssignment_1_3_1 : ( rulePrefixedExp ) ;
    public final void rule__Exp__ExpressionsAssignment_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4891:1: ( ( rulePrefixedExp ) )
            // InternalOCLX.g:4892:2: ( rulePrefixedExp )
            {
            // InternalOCLX.g:4892:2: ( rulePrefixedExp )
            // InternalOCLX.g:4893:3: rulePrefixedExp
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
    // InternalOCLX.g:4902:1: rule__PrefixedExp__OperatorAssignment_0_1 : ( ruleUnaryOperator ) ;
    public final void rule__PrefixedExp__OperatorAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4906:1: ( ( ruleUnaryOperator ) )
            // InternalOCLX.g:4907:2: ( ruleUnaryOperator )
            {
            // InternalOCLX.g:4907:2: ( ruleUnaryOperator )
            // InternalOCLX.g:4908:3: ruleUnaryOperator
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
    // InternalOCLX.g:4917:1: rule__PrefixedExp__ExpressionAssignment_0_2 : ( rulePrimaryExp ) ;
    public final void rule__PrefixedExp__ExpressionAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4921:1: ( ( rulePrimaryExp ) )
            // InternalOCLX.g:4922:2: ( rulePrimaryExp )
            {
            // InternalOCLX.g:4922:2: ( rulePrimaryExp )
            // InternalOCLX.g:4923:3: rulePrimaryExp
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
    // InternalOCLX.g:4932:1: rule__BooleanOperator__OpAssignment : ( ( rule__BooleanOperator__OpAlternatives_0 ) ) ;
    public final void rule__BooleanOperator__OpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4936:1: ( ( ( rule__BooleanOperator__OpAlternatives_0 ) ) )
            // InternalOCLX.g:4937:2: ( ( rule__BooleanOperator__OpAlternatives_0 ) )
            {
            // InternalOCLX.g:4937:2: ( ( rule__BooleanOperator__OpAlternatives_0 ) )
            // InternalOCLX.g:4938:3: ( rule__BooleanOperator__OpAlternatives_0 )
            {
             before(grammarAccess.getBooleanOperatorAccess().getOpAlternatives_0()); 
            // InternalOCLX.g:4939:3: ( rule__BooleanOperator__OpAlternatives_0 )
            // InternalOCLX.g:4939:4: rule__BooleanOperator__OpAlternatives_0
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
    // InternalOCLX.g:4947:1: rule__MathOperator__OpAssignment : ( ( rule__MathOperator__OpAlternatives_0 ) ) ;
    public final void rule__MathOperator__OpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4951:1: ( ( ( rule__MathOperator__OpAlternatives_0 ) ) )
            // InternalOCLX.g:4952:2: ( ( rule__MathOperator__OpAlternatives_0 ) )
            {
            // InternalOCLX.g:4952:2: ( ( rule__MathOperator__OpAlternatives_0 ) )
            // InternalOCLX.g:4953:3: ( rule__MathOperator__OpAlternatives_0 )
            {
             before(grammarAccess.getMathOperatorAccess().getOpAlternatives_0()); 
            // InternalOCLX.g:4954:3: ( rule__MathOperator__OpAlternatives_0 )
            // InternalOCLX.g:4954:4: rule__MathOperator__OpAlternatives_0
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
    // InternalOCLX.g:4962:1: rule__NavigationOperator__NameAssignment : ( ( rule__NavigationOperator__NameAlternatives_0 ) ) ;
    public final void rule__NavigationOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4966:1: ( ( ( rule__NavigationOperator__NameAlternatives_0 ) ) )
            // InternalOCLX.g:4967:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:4967:2: ( ( rule__NavigationOperator__NameAlternatives_0 ) )
            // InternalOCLX.g:4968:3: ( rule__NavigationOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getNavigationOperatorAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:4969:3: ( rule__NavigationOperator__NameAlternatives_0 )
            // InternalOCLX.g:4969:4: rule__NavigationOperator__NameAlternatives_0
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
    // InternalOCLX.g:4977:1: rule__UnaryOperator__NameAssignment : ( ( rule__UnaryOperator__NameAlternatives_0 ) ) ;
    public final void rule__UnaryOperator__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4981:1: ( ( ( rule__UnaryOperator__NameAlternatives_0 ) ) )
            // InternalOCLX.g:4982:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:4982:2: ( ( rule__UnaryOperator__NameAlternatives_0 ) )
            // InternalOCLX.g:4983:3: ( rule__UnaryOperator__NameAlternatives_0 )
            {
             before(grammarAccess.getUnaryOperatorAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:4984:3: ( rule__UnaryOperator__NameAlternatives_0 )
            // InternalOCLX.g:4984:4: rule__UnaryOperator__NameAlternatives_0
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


    // $ANTLR start "rule__NestedExp__SourceAssignment_1"
    // InternalOCLX.g:4992:1: rule__NestedExp__SourceAssignment_1 : ( ruleExp ) ;
    public final void rule__NestedExp__SourceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:4996:1: ( ( ruleExp ) )
            // InternalOCLX.g:4997:2: ( ruleExp )
            {
            // InternalOCLX.g:4997:2: ( ruleExp )
            // InternalOCLX.g:4998:3: ruleExp
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


    // $ANTLR start "rule__NavigationExp__NavAssignment_1_0"
    // InternalOCLX.g:5007:1: rule__NavigationExp__NavAssignment_1_0 : ( ruleNavigationOperator ) ;
    public final void rule__NavigationExp__NavAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5011:1: ( ( ruleNavigationOperator ) )
            // InternalOCLX.g:5012:2: ( ruleNavigationOperator )
            {
            // InternalOCLX.g:5012:2: ( ruleNavigationOperator )
            // InternalOCLX.g:5013:3: ruleNavigationOperator
            {
             before(grammarAccess.getNavigationExpAccess().getNavNavigationOperatorParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNavigationOperator();

            state._fsp--;

             after(grammarAccess.getNavigationExpAccess().getNavNavigationOperatorParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationExp__NavAssignment_1_0"


    // $ANTLR start "rule__NavigationExp__MethodsAssignment_1_1"
    // InternalOCLX.g:5022:1: rule__NavigationExp__MethodsAssignment_1_1 : ( ruleMethodExp ) ;
    public final void rule__NavigationExp__MethodsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5026:1: ( ( ruleMethodExp ) )
            // InternalOCLX.g:5027:2: ( ruleMethodExp )
            {
            // InternalOCLX.g:5027:2: ( ruleMethodExp )
            // InternalOCLX.g:5028:3: ruleMethodExp
            {
             before(grammarAccess.getNavigationExpAccess().getMethodsMethodExpParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMethodExp();

            state._fsp--;

             after(grammarAccess.getNavigationExpAccess().getMethodsMethodExpParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationExp__MethodsAssignment_1_1"


    // $ANTLR start "rule__SelfExp__NameAssignment_1"
    // InternalOCLX.g:5037:1: rule__SelfExp__NameAssignment_1 : ( ( 'self' ) ) ;
    public final void rule__SelfExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5041:1: ( ( ( 'self' ) ) )
            // InternalOCLX.g:5042:2: ( ( 'self' ) )
            {
            // InternalOCLX.g:5042:2: ( ( 'self' ) )
            // InternalOCLX.g:5043:3: ( 'self' )
            {
             before(grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0()); 
            // InternalOCLX.g:5044:3: ( 'self' )
            // InternalOCLX.g:5045:4: 'self'
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
    // InternalOCLX.g:5056:1: rule__VarDeclaration__NameAssignment : ( ruleSimpleName ) ;
    public final void rule__VarDeclaration__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5060:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5061:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5061:2: ( ruleSimpleName )
            // InternalOCLX.g:5062:3: ruleSimpleName
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
    // InternalOCLX.g:5071:1: rule__VarReference__RefAssignment : ( ( RULE_ID ) ) ;
    public final void rule__VarReference__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5075:1: ( ( ( RULE_ID ) ) )
            // InternalOCLX.g:5076:2: ( ( RULE_ID ) )
            {
            // InternalOCLX.g:5076:2: ( ( RULE_ID ) )
            // InternalOCLX.g:5077:3: ( RULE_ID )
            {
             before(grammarAccess.getVarReferenceAccess().getRefVarDeclarationCrossReference_0()); 
            // InternalOCLX.g:5078:3: ( RULE_ID )
            // InternalOCLX.g:5079:4: RULE_ID
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
    // InternalOCLX.g:5090:1: rule__IntLiteralExp__ValueAssignment : ( RULE_INT ) ;
    public final void rule__IntLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5094:1: ( ( RULE_INT ) )
            // InternalOCLX.g:5095:2: ( RULE_INT )
            {
            // InternalOCLX.g:5095:2: ( RULE_INT )
            // InternalOCLX.g:5096:3: RULE_INT
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
    // InternalOCLX.g:5105:1: rule__StringLiteralExp__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5109:1: ( ( RULE_STRING ) )
            // InternalOCLX.g:5110:2: ( RULE_STRING )
            {
            // InternalOCLX.g:5110:2: ( RULE_STRING )
            // InternalOCLX.g:5111:3: RULE_STRING
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
    // InternalOCLX.g:5120:1: rule__BooleanLiteralExp__ValueAssignment_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanLiteralExp__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5124:1: ( ( ( 'true' ) ) )
            // InternalOCLX.g:5125:2: ( ( 'true' ) )
            {
            // InternalOCLX.g:5125:2: ( ( 'true' ) )
            // InternalOCLX.g:5126:3: ( 'true' )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0()); 
            // InternalOCLX.g:5127:3: ( 'true' )
            // InternalOCLX.g:5128:4: 'true'
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
    // InternalOCLX.g:5139:1: rule__BooleanLiteralExp__ValueAssignment_1 : ( ( 'false' ) ) ;
    public final void rule__BooleanLiteralExp__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5143:1: ( ( ( 'false' ) ) )
            // InternalOCLX.g:5144:2: ( ( 'false' ) )
            {
            // InternalOCLX.g:5144:2: ( ( 'false' ) )
            // InternalOCLX.g:5145:3: ( 'false' )
            {
             before(grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0()); 
            // InternalOCLX.g:5146:3: ( 'false' )
            // InternalOCLX.g:5147:4: 'false'
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
    // InternalOCLX.g:5158:1: rule__FloatLiteralExp__ValueAssignment : ( ruleFloat ) ;
    public final void rule__FloatLiteralExp__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5162:1: ( ( ruleFloat ) )
            // InternalOCLX.g:5163:2: ( ruleFloat )
            {
            // InternalOCLX.g:5163:2: ( ruleFloat )
            // InternalOCLX.g:5164:3: ruleFloat
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
    // InternalOCLX.g:5173:1: rule__CollectionIterator__NameAssignment_0 : ( ruleIteratorName ) ;
    public final void rule__CollectionIterator__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5177:1: ( ( ruleIteratorName ) )
            // InternalOCLX.g:5178:2: ( ruleIteratorName )
            {
            // InternalOCLX.g:5178:2: ( ruleIteratorName )
            // InternalOCLX.g:5179:3: ruleIteratorName
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
    // InternalOCLX.g:5188:1: rule__CollectionIterator__ItervarAssignment_2 : ( ruleIteratorVarDeclaration ) ;
    public final void rule__CollectionIterator__ItervarAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5192:1: ( ( ruleIteratorVarDeclaration ) )
            // InternalOCLX.g:5193:2: ( ruleIteratorVarDeclaration )
            {
            // InternalOCLX.g:5193:2: ( ruleIteratorVarDeclaration )
            // InternalOCLX.g:5194:3: ruleIteratorVarDeclaration
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
    // InternalOCLX.g:5203:1: rule__CollectionIterator__BodyAssignment_4 : ( ruleExp ) ;
    public final void rule__CollectionIterator__BodyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5207:1: ( ( ruleExp ) )
            // InternalOCLX.g:5208:2: ( ruleExp )
            {
            // InternalOCLX.g:5208:2: ( ruleExp )
            // InternalOCLX.g:5209:3: ruleExp
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
    // InternalOCLX.g:5218:1: rule__IteratorName__NameAssignment : ( ( rule__IteratorName__NameAlternatives_0 ) ) ;
    public final void rule__IteratorName__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5222:1: ( ( ( rule__IteratorName__NameAlternatives_0 ) ) )
            // InternalOCLX.g:5223:2: ( ( rule__IteratorName__NameAlternatives_0 ) )
            {
            // InternalOCLX.g:5223:2: ( ( rule__IteratorName__NameAlternatives_0 ) )
            // InternalOCLX.g:5224:3: ( rule__IteratorName__NameAlternatives_0 )
            {
             before(grammarAccess.getIteratorNameAccess().getNameAlternatives_0()); 
            // InternalOCLX.g:5225:3: ( rule__IteratorName__NameAlternatives_0 )
            // InternalOCLX.g:5225:4: rule__IteratorName__NameAlternatives_0
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
    // InternalOCLX.g:5233:1: rule__IteratorVarDeclaration__NameAssignment_0 : ( ruleVarDeclaration ) ;
    public final void rule__IteratorVarDeclaration__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5237:1: ( ( ruleVarDeclaration ) )
            // InternalOCLX.g:5238:2: ( ruleVarDeclaration )
            {
            // InternalOCLX.g:5238:2: ( ruleVarDeclaration )
            // InternalOCLX.g:5239:3: ruleVarDeclaration
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
    // InternalOCLX.g:5248:1: rule__IteratorVarDeclaration__NameAssignment_1_0 : ( ruleVarDeclaration ) ;
    public final void rule__IteratorVarDeclaration__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5252:1: ( ( ruleVarDeclaration ) )
            // InternalOCLX.g:5253:2: ( ruleVarDeclaration )
            {
            // InternalOCLX.g:5253:2: ( ruleVarDeclaration )
            // InternalOCLX.g:5254:3: ruleVarDeclaration
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
    // InternalOCLX.g:5263:1: rule__IteratorVarDeclaration__TypeAssignment_1_2 : ( ruleTypeExp ) ;
    public final void rule__IteratorVarDeclaration__TypeAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5267:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:5268:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:5268:2: ( ruleTypeExp )
            // InternalOCLX.g:5269:3: ruleTypeExp
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
    // InternalOCLX.g:5278:1: rule__PropertyAccess__NameAssignment : ( ruleSimpleName ) ;
    public final void rule__PropertyAccess__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5282:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5283:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5283:2: ( ruleSimpleName )
            // InternalOCLX.g:5284:3: ruleSimpleName
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
    // InternalOCLX.g:5293:1: rule__MethodCall__NameAssignment_0_0 : ( ruleSimpleName ) ;
    public final void rule__MethodCall__NameAssignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5297:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5298:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5298:2: ( ruleSimpleName )
            // InternalOCLX.g:5299:3: ruleSimpleName
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
    // InternalOCLX.g:5308:1: rule__MethodCall__NameAssignment_1_0 : ( ruleSimpleName ) ;
    public final void rule__MethodCall__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5312:1: ( ( ruleSimpleName ) )
            // InternalOCLX.g:5313:2: ( ruleSimpleName )
            {
            // InternalOCLX.g:5313:2: ( ruleSimpleName )
            // InternalOCLX.g:5314:3: ruleSimpleName
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
    // InternalOCLX.g:5323:1: rule__MethodCall__ArgsAssignment_1_2 : ( ruleArgumentsExp ) ;
    public final void rule__MethodCall__ArgsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5327:1: ( ( ruleArgumentsExp ) )
            // InternalOCLX.g:5328:2: ( ruleArgumentsExp )
            {
            // InternalOCLX.g:5328:2: ( ruleArgumentsExp )
            // InternalOCLX.g:5329:3: ruleArgumentsExp
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
    // InternalOCLX.g:5338:1: rule__TypeCall__NameAssignment_0 : ( ( rule__TypeCall__NameAlternatives_0_0 ) ) ;
    public final void rule__TypeCall__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5342:1: ( ( ( rule__TypeCall__NameAlternatives_0_0 ) ) )
            // InternalOCLX.g:5343:2: ( ( rule__TypeCall__NameAlternatives_0_0 ) )
            {
            // InternalOCLX.g:5343:2: ( ( rule__TypeCall__NameAlternatives_0_0 ) )
            // InternalOCLX.g:5344:3: ( rule__TypeCall__NameAlternatives_0_0 )
            {
             before(grammarAccess.getTypeCallAccess().getNameAlternatives_0_0()); 
            // InternalOCLX.g:5345:3: ( rule__TypeCall__NameAlternatives_0_0 )
            // InternalOCLX.g:5345:4: rule__TypeCall__NameAlternatives_0_0
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
    // InternalOCLX.g:5353:1: rule__TypeCall__TypeAssignment_2 : ( ruleTypeExp ) ;
    public final void rule__TypeCall__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5357:1: ( ( ruleTypeExp ) )
            // InternalOCLX.g:5358:2: ( ruleTypeExp )
            {
            // InternalOCLX.g:5358:2: ( ruleTypeExp )
            // InternalOCLX.g:5359:3: ruleTypeExp
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
    // InternalOCLX.g:5368:1: rule__TypeExp__NameAssignment_1 : ( RULE_URI ) ;
    public final void rule__TypeExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5372:1: ( ( RULE_URI ) )
            // InternalOCLX.g:5373:2: ( RULE_URI )
            {
            // InternalOCLX.g:5373:2: ( RULE_URI )
            // InternalOCLX.g:5374:3: RULE_URI
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
    // InternalOCLX.g:5383:1: rule__UnaryTemporalExp__NameAssignment_0 : ( ruleUnaryTemporalOp ) ;
    public final void rule__UnaryTemporalExp__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5387:1: ( ( ruleUnaryTemporalOp ) )
            // InternalOCLX.g:5388:2: ( ruleUnaryTemporalOp )
            {
            // InternalOCLX.g:5388:2: ( ruleUnaryTemporalOp )
            // InternalOCLX.g:5389:3: ruleUnaryTemporalOp
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
    // InternalOCLX.g:5398:1: rule__UnaryTemporalExp__ExpAssignment_2 : ( ruleExp ) ;
    public final void rule__UnaryTemporalExp__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5402:1: ( ( ruleExp ) )
            // InternalOCLX.g:5403:2: ( ruleExp )
            {
            // InternalOCLX.g:5403:2: ( ruleExp )
            // InternalOCLX.g:5404:3: ruleExp
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
    // InternalOCLX.g:5413:1: rule__TemporalAsLongAs__NameAssignment_0 : ( ( 'asLongAs' ) ) ;
    public final void rule__TemporalAsLongAs__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5417:1: ( ( ( 'asLongAs' ) ) )
            // InternalOCLX.g:5418:2: ( ( 'asLongAs' ) )
            {
            // InternalOCLX.g:5418:2: ( ( 'asLongAs' ) )
            // InternalOCLX.g:5419:3: ( 'asLongAs' )
            {
             before(grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0()); 
            // InternalOCLX.g:5420:3: ( 'asLongAs' )
            // InternalOCLX.g:5421:4: 'asLongAs'
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
    // InternalOCLX.g:5432:1: rule__TemporalAsLongAs__BAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalAsLongAs__BAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5436:1: ( ( ruleExp ) )
            // InternalOCLX.g:5437:2: ( ruleExp )
            {
            // InternalOCLX.g:5437:2: ( ruleExp )
            // InternalOCLX.g:5438:3: ruleExp
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
    // InternalOCLX.g:5447:1: rule__TemporalAsLongAs__AAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalAsLongAs__AAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5451:1: ( ( ruleExp ) )
            // InternalOCLX.g:5452:2: ( ruleExp )
            {
            // InternalOCLX.g:5452:2: ( ruleExp )
            // InternalOCLX.g:5453:3: ruleExp
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
    // InternalOCLX.g:5462:1: rule__TemporalUntil__NameAssignment_0 : ( ( 'ensureThat' ) ) ;
    public final void rule__TemporalUntil__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5466:1: ( ( ( 'ensureThat' ) ) )
            // InternalOCLX.g:5467:2: ( ( 'ensureThat' ) )
            {
            // InternalOCLX.g:5467:2: ( ( 'ensureThat' ) )
            // InternalOCLX.g:5468:3: ( 'ensureThat' )
            {
             before(grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0()); 
            // InternalOCLX.g:5469:3: ( 'ensureThat' )
            // InternalOCLX.g:5470:4: 'ensureThat'
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
    // InternalOCLX.g:5481:1: rule__TemporalUntil__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalUntil__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5485:1: ( ( ruleExp ) )
            // InternalOCLX.g:5486:2: ( ruleExp )
            {
            // InternalOCLX.g:5486:2: ( ruleExp )
            // InternalOCLX.g:5487:3: ruleExp
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
    // InternalOCLX.g:5496:1: rule__TemporalUntil__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalUntil__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5500:1: ( ( ruleExp ) )
            // InternalOCLX.g:5501:2: ( ruleExp )
            {
            // InternalOCLX.g:5501:2: ( ruleExp )
            // InternalOCLX.g:5502:3: ruleExp
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
    // InternalOCLX.g:5511:1: rule__TemporalEverytime__NameAssignment_0 : ( ( 'everyTime' ) ) ;
    public final void rule__TemporalEverytime__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5515:1: ( ( ( 'everyTime' ) ) )
            // InternalOCLX.g:5516:2: ( ( 'everyTime' ) )
            {
            // InternalOCLX.g:5516:2: ( ( 'everyTime' ) )
            // InternalOCLX.g:5517:3: ( 'everyTime' )
            {
             before(grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0()); 
            // InternalOCLX.g:5518:3: ( 'everyTime' )
            // InternalOCLX.g:5519:4: 'everyTime'
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
    // InternalOCLX.g:5530:1: rule__TemporalEverytime__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalEverytime__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5534:1: ( ( ruleExp ) )
            // InternalOCLX.g:5535:2: ( ruleExp )
            {
            // InternalOCLX.g:5535:2: ( ruleExp )
            // InternalOCLX.g:5536:3: ruleExp
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
    // InternalOCLX.g:5545:1: rule__TemporalEverytime__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalEverytime__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5549:1: ( ( ruleExp ) )
            // InternalOCLX.g:5550:2: ( ruleExp )
            {
            // InternalOCLX.g:5550:2: ( ruleExp )
            // InternalOCLX.g:5551:3: ruleExp
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
    // InternalOCLX.g:5560:1: rule__TemporalAtLeastOnce__NameAssignment_0 : ( ( 'whenOnce' ) ) ;
    public final void rule__TemporalAtLeastOnce__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5564:1: ( ( ( 'whenOnce' ) ) )
            // InternalOCLX.g:5565:2: ( ( 'whenOnce' ) )
            {
            // InternalOCLX.g:5565:2: ( ( 'whenOnce' ) )
            // InternalOCLX.g:5566:3: ( 'whenOnce' )
            {
             before(grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0()); 
            // InternalOCLX.g:5567:3: ( 'whenOnce' )
            // InternalOCLX.g:5568:4: 'whenOnce'
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
    // InternalOCLX.g:5579:1: rule__TemporalAtLeastOnce__AAssignment_2 : ( ruleExp ) ;
    public final void rule__TemporalAtLeastOnce__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5583:1: ( ( ruleExp ) )
            // InternalOCLX.g:5584:2: ( ruleExp )
            {
            // InternalOCLX.g:5584:2: ( ruleExp )
            // InternalOCLX.g:5585:3: ruleExp
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
    // InternalOCLX.g:5594:1: rule__TemporalAtLeastOnce__BAssignment_4 : ( ruleExp ) ;
    public final void rule__TemporalAtLeastOnce__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5598:1: ( ( ruleExp ) )
            // InternalOCLX.g:5599:2: ( ruleExp )
            {
            // InternalOCLX.g:5599:2: ( ruleExp )
            // InternalOCLX.g:5600:3: ruleExp
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
    // InternalOCLX.g:5609:1: rule__LegacyUntil__NameAssignment_0 : ( ( 'until' ) ) ;
    public final void rule__LegacyUntil__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5613:1: ( ( ( 'until' ) ) )
            // InternalOCLX.g:5614:2: ( ( 'until' ) )
            {
            // InternalOCLX.g:5614:2: ( ( 'until' ) )
            // InternalOCLX.g:5615:3: ( 'until' )
            {
             before(grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0()); 
            // InternalOCLX.g:5616:3: ( 'until' )
            // InternalOCLX.g:5617:4: 'until'
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
    // InternalOCLX.g:5628:1: rule__LegacyUntil__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyUntil__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5632:1: ( ( ruleExp ) )
            // InternalOCLX.g:5633:2: ( ruleExp )
            {
            // InternalOCLX.g:5633:2: ( ruleExp )
            // InternalOCLX.g:5634:3: ruleExp
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
    // InternalOCLX.g:5643:1: rule__LegacyUntil__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyUntil__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5647:1: ( ( ruleExp ) )
            // InternalOCLX.g:5648:2: ( ruleExp )
            {
            // InternalOCLX.g:5648:2: ( ruleExp )
            // InternalOCLX.g:5649:3: ruleExp
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
    // InternalOCLX.g:5658:1: rule__LegacyAsSoonAs__NameAssignment_0 : ( ( 'asSoonAs' ) ) ;
    public final void rule__LegacyAsSoonAs__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5662:1: ( ( ( 'asSoonAs' ) ) )
            // InternalOCLX.g:5663:2: ( ( 'asSoonAs' ) )
            {
            // InternalOCLX.g:5663:2: ( ( 'asSoonAs' ) )
            // InternalOCLX.g:5664:3: ( 'asSoonAs' )
            {
             before(grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0()); 
            // InternalOCLX.g:5665:3: ( 'asSoonAs' )
            // InternalOCLX.g:5666:4: 'asSoonAs'
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
    // InternalOCLX.g:5677:1: rule__LegacyAsSoonAs__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyAsSoonAs__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5681:1: ( ( ruleExp ) )
            // InternalOCLX.g:5682:2: ( ruleExp )
            {
            // InternalOCLX.g:5682:2: ( ruleExp )
            // InternalOCLX.g:5683:3: ruleExp
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
    // InternalOCLX.g:5692:1: rule__LegacyAsSoonAs__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyAsSoonAs__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5696:1: ( ( ruleExp ) )
            // InternalOCLX.g:5697:2: ( ruleExp )
            {
            // InternalOCLX.g:5697:2: ( ruleExp )
            // InternalOCLX.g:5698:3: ruleExp
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
    // InternalOCLX.g:5707:1: rule__LegacyEverytime__NameAssignment_0 : ( ( 'everytime' ) ) ;
    public final void rule__LegacyEverytime__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5711:1: ( ( ( 'everytime' ) ) )
            // InternalOCLX.g:5712:2: ( ( 'everytime' ) )
            {
            // InternalOCLX.g:5712:2: ( ( 'everytime' ) )
            // InternalOCLX.g:5713:3: ( 'everytime' )
            {
             before(grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0()); 
            // InternalOCLX.g:5714:3: ( 'everytime' )
            // InternalOCLX.g:5715:4: 'everytime'
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
    // InternalOCLX.g:5726:1: rule__LegacyEverytime__AAssignment_2 : ( ruleExp ) ;
    public final void rule__LegacyEverytime__AAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5730:1: ( ( ruleExp ) )
            // InternalOCLX.g:5731:2: ( ruleExp )
            {
            // InternalOCLX.g:5731:2: ( ruleExp )
            // InternalOCLX.g:5732:3: ruleExp
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
    // InternalOCLX.g:5741:1: rule__LegacyEverytime__BAssignment_4 : ( ruleExp ) ;
    public final void rule__LegacyEverytime__BAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5745:1: ( ( ruleExp ) )
            // InternalOCLX.g:5746:2: ( ruleExp )
            {
            // InternalOCLX.g:5746:2: ( ruleExp )
            // InternalOCLX.g:5747:3: ruleExp
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
    // InternalOCLX.g:5756:1: rule__ArgumentsExp__OperatorsAssignment_0 : ( ruleExp ) ;
    public final void rule__ArgumentsExp__OperatorsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5760:1: ( ( ruleExp ) )
            // InternalOCLX.g:5761:2: ( ruleExp )
            {
            // InternalOCLX.g:5761:2: ( ruleExp )
            // InternalOCLX.g:5762:3: ruleExp
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
    // InternalOCLX.g:5771:1: rule__ArgumentsExp__OperatorsAssignment_1_1 : ( ruleExp ) ;
    public final void rule__ArgumentsExp__OperatorsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalOCLX.g:5775:1: ( ( ruleExp ) )
            // InternalOCLX.g:5776:2: ( ruleExp )
            {
            // InternalOCLX.g:5776:2: ( ruleExp )
            // InternalOCLX.g:5777:3: ruleExp
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
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000018000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000003FC0000010L});
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