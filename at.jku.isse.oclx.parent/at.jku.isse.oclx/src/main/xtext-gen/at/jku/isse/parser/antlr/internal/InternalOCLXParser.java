package at.jku.isse.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import at.jku.isse.services.OCLXGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOCLXParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_DESCRIPTION", "RULE_INT", "RULE_STRING", "RULE_URI", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'rule'", "'{'", "'description:'", "'is'", "'overrulable:'", "'context:'", "'expression:'", "'}'", "'.'", "'>'", "'<'", "'>='", "'<='", "'='", "'!='", "'and'", "'or'", "'xor'", "'implies'", "'*'", "'/'", "'+'", "'-'", "'->'", "'not'", "'('", "')'", "'self'", "'true'", "'false'", "'|'", "'forAll'", "'exists'", "'collect'", "'reject'", "'select'", "':'", "'()'", "'asType'", "'isTypeOf'", "'isKindOf'", "'next'", "'always'", "'eventually'", "'asLongAs'", "'ensureThat'", "'everyTime'", "'then'", "'whenOnce'", "'thenAtLeastOnce'", "'until'", "','", "'asSoonAs'", "'everytime'"
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
    public static final int RULE_DESCRIPTION=5;
    public static final int RULE_URI=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
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

        public InternalOCLXParser(TokenStream input, OCLXGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected OCLXGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalOCLX.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalOCLX.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalOCLX.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalOCLX.g:71:1: ruleModel returns [EObject current=null] : ( (lv_constraints_0_0= ruleConstraint ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_constraints_0_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:77:2: ( ( (lv_constraints_0_0= ruleConstraint ) )* )
            // InternalOCLX.g:78:2: ( (lv_constraints_0_0= ruleConstraint ) )*
            {
            // InternalOCLX.g:78:2: ( (lv_constraints_0_0= ruleConstraint ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalOCLX.g:79:3: (lv_constraints_0_0= ruleConstraint )
            	    {
            	    // InternalOCLX.g:79:3: (lv_constraints_0_0= ruleConstraint )
            	    // InternalOCLX.g:80:4: lv_constraints_0_0= ruleConstraint
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getConstraintsConstraintParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_constraints_0_0=ruleConstraint();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"constraints",
            	    					lv_constraints_0_0,
            	    					"at.jku.isse.OCLX.Constraint");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleConstraint"
    // InternalOCLX.g:100:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // InternalOCLX.g:100:51: (iv_ruleConstraint= ruleConstraint EOF )
            // InternalOCLX.g:101:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // InternalOCLX.g:107:1: ruleConstraint returns [EObject current=null] : (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'description:' ( (lv_description_4_0= RULE_DESCRIPTION ) ) )? (otherlv_5= 'is' otherlv_6= 'overrulable:' ( (lv_overrulable_7_0= ruleBooleanLiteralExp ) ) )? otherlv_8= 'context:' ( (lv_context_9_0= ruleContext ) ) otherlv_10= 'expression:' ( (lv_expression_11_0= ruleExp ) ) otherlv_12= '}' ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_description_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_overrulable_7_0 = null;

        EObject lv_context_9_0 = null;

        EObject lv_expression_11_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:113:2: ( (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'description:' ( (lv_description_4_0= RULE_DESCRIPTION ) ) )? (otherlv_5= 'is' otherlv_6= 'overrulable:' ( (lv_overrulable_7_0= ruleBooleanLiteralExp ) ) )? otherlv_8= 'context:' ( (lv_context_9_0= ruleContext ) ) otherlv_10= 'expression:' ( (lv_expression_11_0= ruleExp ) ) otherlv_12= '}' ) )
            // InternalOCLX.g:114:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'description:' ( (lv_description_4_0= RULE_DESCRIPTION ) ) )? (otherlv_5= 'is' otherlv_6= 'overrulable:' ( (lv_overrulable_7_0= ruleBooleanLiteralExp ) ) )? otherlv_8= 'context:' ( (lv_context_9_0= ruleContext ) ) otherlv_10= 'expression:' ( (lv_expression_11_0= ruleExp ) ) otherlv_12= '}' )
            {
            // InternalOCLX.g:114:2: (otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'description:' ( (lv_description_4_0= RULE_DESCRIPTION ) ) )? (otherlv_5= 'is' otherlv_6= 'overrulable:' ( (lv_overrulable_7_0= ruleBooleanLiteralExp ) ) )? otherlv_8= 'context:' ( (lv_context_9_0= ruleContext ) ) otherlv_10= 'expression:' ( (lv_expression_11_0= ruleExp ) ) otherlv_12= '}' )
            // InternalOCLX.g:115:3: otherlv_0= 'rule' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' (otherlv_3= 'description:' ( (lv_description_4_0= RULE_DESCRIPTION ) ) )? (otherlv_5= 'is' otherlv_6= 'overrulable:' ( (lv_overrulable_7_0= ruleBooleanLiteralExp ) ) )? otherlv_8= 'context:' ( (lv_context_9_0= ruleContext ) ) otherlv_10= 'expression:' ( (lv_expression_11_0= ruleExp ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getRuleKeyword_0());
            		
            // InternalOCLX.g:119:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalOCLX.g:120:4: (lv_name_1_0= RULE_ID )
            {
            // InternalOCLX.g:120:4: (lv_name_1_0= RULE_ID )
            // InternalOCLX.g:121:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getConstraintAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConstraintRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOCLX.g:141:3: (otherlv_3= 'description:' ( (lv_description_4_0= RULE_DESCRIPTION ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalOCLX.g:142:4: otherlv_3= 'description:' ( (lv_description_4_0= RULE_DESCRIPTION ) )
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_7); 

                    				newLeafNode(otherlv_3, grammarAccess.getConstraintAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalOCLX.g:146:4: ( (lv_description_4_0= RULE_DESCRIPTION ) )
                    // InternalOCLX.g:147:5: (lv_description_4_0= RULE_DESCRIPTION )
                    {
                    // InternalOCLX.g:147:5: (lv_description_4_0= RULE_DESCRIPTION )
                    // InternalOCLX.g:148:6: lv_description_4_0= RULE_DESCRIPTION
                    {
                    lv_description_4_0=(Token)match(input,RULE_DESCRIPTION,FOLLOW_8); 

                    						newLeafNode(lv_description_4_0, grammarAccess.getConstraintAccess().getDescriptionDESCRIPTIONTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getConstraintRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_4_0,
                    							"at.jku.isse.OCLX.DESCRIPTION");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalOCLX.g:165:3: (otherlv_5= 'is' otherlv_6= 'overrulable:' ( (lv_overrulable_7_0= ruleBooleanLiteralExp ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalOCLX.g:166:4: otherlv_5= 'is' otherlv_6= 'overrulable:' ( (lv_overrulable_7_0= ruleBooleanLiteralExp ) )
                    {
                    otherlv_5=(Token)match(input,16,FOLLOW_9); 

                    				newLeafNode(otherlv_5, grammarAccess.getConstraintAccess().getIsKeyword_4_0());
                    			
                    otherlv_6=(Token)match(input,17,FOLLOW_10); 

                    				newLeafNode(otherlv_6, grammarAccess.getConstraintAccess().getOverrulableKeyword_4_1());
                    			
                    // InternalOCLX.g:174:4: ( (lv_overrulable_7_0= ruleBooleanLiteralExp ) )
                    // InternalOCLX.g:175:5: (lv_overrulable_7_0= ruleBooleanLiteralExp )
                    {
                    // InternalOCLX.g:175:5: (lv_overrulable_7_0= ruleBooleanLiteralExp )
                    // InternalOCLX.g:176:6: lv_overrulable_7_0= ruleBooleanLiteralExp
                    {

                    						newCompositeNode(grammarAccess.getConstraintAccess().getOverrulableBooleanLiteralExpParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_overrulable_7_0=ruleBooleanLiteralExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConstraintRule());
                    						}
                    						set(
                    							current,
                    							"overrulable",
                    							lv_overrulable_7_0 != null,
                    							"at.jku.isse.OCLX.BooleanLiteralExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,18,FOLLOW_4); 

            			newLeafNode(otherlv_8, grammarAccess.getConstraintAccess().getContextKeyword_5());
            		
            // InternalOCLX.g:198:3: ( (lv_context_9_0= ruleContext ) )
            // InternalOCLX.g:199:4: (lv_context_9_0= ruleContext )
            {
            // InternalOCLX.g:199:4: (lv_context_9_0= ruleContext )
            // InternalOCLX.g:200:5: lv_context_9_0= ruleContext
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getContextContextParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_12);
            lv_context_9_0=ruleContext();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"context",
            						lv_context_9_0,
            						"at.jku.isse.OCLX.Context");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,19,FOLLOW_13); 

            			newLeafNode(otherlv_10, grammarAccess.getConstraintAccess().getExpressionKeyword_7());
            		
            // InternalOCLX.g:221:3: ( (lv_expression_11_0= ruleExp ) )
            // InternalOCLX.g:222:4: (lv_expression_11_0= ruleExp )
            {
            // InternalOCLX.g:222:4: (lv_expression_11_0= ruleExp )
            // InternalOCLX.g:223:5: lv_expression_11_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getConstraintAccess().getExpressionExpParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_14);
            lv_expression_11_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConstraintRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_11_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getConstraintAccess().getRightCurlyBracketKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalOCLX.g:248:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalOCLX.g:248:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalOCLX.g:249:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalOCLX.g:255:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalOCLX.g:261:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalOCLX.g:262:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalOCLX.g:262:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalOCLX.g:263:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalOCLX.g:270:3: (kw= '.' this_ID_2= RULE_ID )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==21) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalOCLX.g:271:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,21,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_15); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }


            	leaveRule();

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


    // $ANTLR start "entryRuleSimpleName"
    // InternalOCLX.g:288:1: entryRuleSimpleName returns [String current=null] : iv_ruleSimpleName= ruleSimpleName EOF ;
    public final String entryRuleSimpleName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSimpleName = null;


        try {
            // InternalOCLX.g:288:50: (iv_ruleSimpleName= ruleSimpleName EOF )
            // InternalOCLX.g:289:2: iv_ruleSimpleName= ruleSimpleName EOF
            {
             newCompositeNode(grammarAccess.getSimpleNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimpleName=ruleSimpleName();

            state._fsp--;

             current =iv_ruleSimpleName.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSimpleName"


    // $ANTLR start "ruleSimpleName"
    // InternalOCLX.g:295:1: ruleSimpleName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleSimpleName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:301:2: (this_ID_0= RULE_ID )
            // InternalOCLX.g:302:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_0);
            	

            		newLeafNode(this_ID_0, grammarAccess.getSimpleNameAccess().getIDTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSimpleName"


    // $ANTLR start "entryRuleFloat"
    // InternalOCLX.g:312:1: entryRuleFloat returns [String current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final String entryRuleFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFloat = null;


        try {
            // InternalOCLX.g:312:45: (iv_ruleFloat= ruleFloat EOF )
            // InternalOCLX.g:313:2: iv_ruleFloat= ruleFloat EOF
            {
             newCompositeNode(grammarAccess.getFloatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloat=ruleFloat();

            state._fsp--;

             current =iv_ruleFloat.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFloat"


    // $ANTLR start "ruleFloat"
    // InternalOCLX.g:319:1: ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalOCLX.g:325:2: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // InternalOCLX.g:326:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // InternalOCLX.g:326:2: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // InternalOCLX.g:327:3: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_16); 

            			current.merge(this_INT_0);
            		

            			newLeafNode(this_INT_0, grammarAccess.getFloatAccess().getINTTerminalRuleCall_0());
            		
            kw=(Token)match(input,21,FOLLOW_17); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getFloatAccess().getFullStopKeyword_1());
            		
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getFloatAccess().getINTTerminalRuleCall_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloat"


    // $ANTLR start "entryRuleContext"
    // InternalOCLX.g:350:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalOCLX.g:350:48: (iv_ruleContext= ruleContext EOF )
            // InternalOCLX.g:351:2: iv_ruleContext= ruleContext EOF
            {
             newCompositeNode(grammarAccess.getContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContext=ruleContext();

            state._fsp--;

             current =iv_ruleContext; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleContext"


    // $ANTLR start "ruleContext"
    // InternalOCLX.g:357:1: ruleContext returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:363:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // InternalOCLX.g:364:2: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // InternalOCLX.g:364:2: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalOCLX.g:365:3: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalOCLX.g:365:3: (lv_name_0_0= ruleQualifiedName )
            // InternalOCLX.g:366:4: lv_name_0_0= ruleQualifiedName
            {

            				newCompositeNode(grammarAccess.getContextAccess().getNameQualifiedNameParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getContextRule());
            				}
            				set(
            					current,
            					"name",
            					lv_name_0_0,
            					"at.jku.isse.OCLX.QualifiedName");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContext"


    // $ANTLR start "entryRuleExp"
    // InternalOCLX.g:386:1: entryRuleExp returns [EObject current=null] : iv_ruleExp= ruleExp EOF ;
    public final EObject entryRuleExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp = null;


        try {
            // InternalOCLX.g:386:44: (iv_ruleExp= ruleExp EOF )
            // InternalOCLX.g:387:2: iv_ruleExp= ruleExp EOF
            {
             newCompositeNode(grammarAccess.getExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExp=ruleExp();

            state._fsp--;

             current =iv_ruleExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleExp"


    // $ANTLR start "ruleExp"
    // InternalOCLX.g:393:1: ruleExp returns [EObject current=null] : (this_PrefixedExp_0= rulePrefixedExp ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )? ) ;
    public final EObject ruleExp() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedExp_0 = null;

        EObject lv_operators_2_0 = null;

        EObject lv_expressions_3_0 = null;

        EObject lv_operators_4_0 = null;

        EObject lv_expressions_5_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:399:2: ( (this_PrefixedExp_0= rulePrefixedExp ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )? ) )
            // InternalOCLX.g:400:2: (this_PrefixedExp_0= rulePrefixedExp ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )? )
            {
            // InternalOCLX.g:400:2: (this_PrefixedExp_0= rulePrefixedExp ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )? )
            // InternalOCLX.g:401:3: this_PrefixedExp_0= rulePrefixedExp ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )?
            {

            			newCompositeNode(grammarAccess.getExpAccess().getPrefixedExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_18);
            this_PrefixedExp_0=rulePrefixedExp();

            state._fsp--;


            			current = this_PrefixedExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalOCLX.g:409:3: ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=22 && LA6_0<=35)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalOCLX.g:410:4: () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )*
                    {
                    // InternalOCLX.g:410:4: ()
                    // InternalOCLX.g:411:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getExpAccess().getInfixExpExpressionsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalOCLX.g:417:4: ( (lv_operators_2_0= ruleBinaryOperator ) )
                    // InternalOCLX.g:418:5: (lv_operators_2_0= ruleBinaryOperator )
                    {
                    // InternalOCLX.g:418:5: (lv_operators_2_0= ruleBinaryOperator )
                    // InternalOCLX.g:419:6: lv_operators_2_0= ruleBinaryOperator
                    {

                    						newCompositeNode(grammarAccess.getExpAccess().getOperatorsBinaryOperatorParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_operators_2_0=ruleBinaryOperator();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExpRule());
                    						}
                    						add(
                    							current,
                    							"operators",
                    							lv_operators_2_0,
                    							"at.jku.isse.OCLX.BinaryOperator");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalOCLX.g:436:4: ( (lv_expressions_3_0= rulePrefixedExp ) )
                    // InternalOCLX.g:437:5: (lv_expressions_3_0= rulePrefixedExp )
                    {
                    // InternalOCLX.g:437:5: (lv_expressions_3_0= rulePrefixedExp )
                    // InternalOCLX.g:438:6: lv_expressions_3_0= rulePrefixedExp
                    {

                    						newCompositeNode(grammarAccess.getExpAccess().getExpressionsPrefixedExpParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_expressions_3_0=rulePrefixedExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getExpRule());
                    						}
                    						add(
                    							current,
                    							"expressions",
                    							lv_expressions_3_0,
                    							"at.jku.isse.OCLX.PrefixedExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalOCLX.g:455:4: ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=22 && LA5_0<=35)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalOCLX.g:456:5: ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) )
                    	    {
                    	    // InternalOCLX.g:456:5: ( (lv_operators_4_0= ruleBinaryOperator ) )
                    	    // InternalOCLX.g:457:6: (lv_operators_4_0= ruleBinaryOperator )
                    	    {
                    	    // InternalOCLX.g:457:6: (lv_operators_4_0= ruleBinaryOperator )
                    	    // InternalOCLX.g:458:7: lv_operators_4_0= ruleBinaryOperator
                    	    {

                    	    							newCompositeNode(grammarAccess.getExpAccess().getOperatorsBinaryOperatorParserRuleCall_1_3_0_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
                    	    lv_operators_4_0=ruleBinaryOperator();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getExpRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"operators",
                    	    								lv_operators_4_0,
                    	    								"at.jku.isse.OCLX.BinaryOperator");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    // InternalOCLX.g:475:5: ( (lv_expressions_5_0= rulePrefixedExp ) )
                    	    // InternalOCLX.g:476:6: (lv_expressions_5_0= rulePrefixedExp )
                    	    {
                    	    // InternalOCLX.g:476:6: (lv_expressions_5_0= rulePrefixedExp )
                    	    // InternalOCLX.g:477:7: lv_expressions_5_0= rulePrefixedExp
                    	    {

                    	    							newCompositeNode(grammarAccess.getExpAccess().getExpressionsPrefixedExpParserRuleCall_1_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
                    	    lv_expressions_5_0=rulePrefixedExp();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getExpRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"expressions",
                    	    								lv_expressions_5_0,
                    	    								"at.jku.isse.OCLX.PrefixedExp");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExp"


    // $ANTLR start "entryRulePrefixedExp"
    // InternalOCLX.g:500:1: entryRulePrefixedExp returns [EObject current=null] : iv_rulePrefixedExp= rulePrefixedExp EOF ;
    public final EObject entryRulePrefixedExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExp = null;


        try {
            // InternalOCLX.g:500:52: (iv_rulePrefixedExp= rulePrefixedExp EOF )
            // InternalOCLX.g:501:2: iv_rulePrefixedExp= rulePrefixedExp EOF
            {
             newCompositeNode(grammarAccess.getPrefixedExpRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrefixedExp=rulePrefixedExp();

            state._fsp--;

             current =iv_rulePrefixedExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePrefixedExp"


    // $ANTLR start "rulePrefixedExp"
    // InternalOCLX.g:507:1: rulePrefixedExp returns [EObject current=null] : ( ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) ) | this_PrimaryExp_3= rulePrimaryExp ) ;
    public final EObject rulePrefixedExp() throws RecognitionException {
        EObject current = null;

        EObject lv_operator_1_0 = null;

        EObject lv_expression_2_0 = null;

        EObject this_PrimaryExp_3 = null;



        	enterRule();

        try {
            // InternalOCLX.g:513:2: ( ( ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) ) | this_PrimaryExp_3= rulePrimaryExp ) )
            // InternalOCLX.g:514:2: ( ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) ) | this_PrimaryExp_3= rulePrimaryExp )
            {
            // InternalOCLX.g:514:2: ( ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) ) | this_PrimaryExp_3= rulePrimaryExp )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==35||LA7_0==37) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID||(LA7_0>=RULE_INT && LA7_0<=RULE_STRING)||LA7_0==38||(LA7_0>=40 && LA7_0<=42)||(LA7_0>=54 && LA7_0<=59)||LA7_0==61||LA7_0==63||(LA7_0>=65 && LA7_0<=66)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalOCLX.g:515:3: ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) )
                    {
                    // InternalOCLX.g:515:3: ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) )
                    // InternalOCLX.g:516:4: () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) )
                    {
                    // InternalOCLX.g:516:4: ()
                    // InternalOCLX.g:517:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrefixedExpAccess().getPrefixExpAction_0_0(),
                    						current);
                    				

                    }

                    // InternalOCLX.g:523:4: ( (lv_operator_1_0= ruleUnaryOperator ) )
                    // InternalOCLX.g:524:5: (lv_operator_1_0= ruleUnaryOperator )
                    {
                    // InternalOCLX.g:524:5: (lv_operator_1_0= ruleUnaryOperator )
                    // InternalOCLX.g:525:6: lv_operator_1_0= ruleUnaryOperator
                    {

                    						newCompositeNode(grammarAccess.getPrefixedExpAccess().getOperatorUnaryOperatorParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_operator_1_0=ruleUnaryOperator();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrefixedExpRule());
                    						}
                    						set(
                    							current,
                    							"operator",
                    							lv_operator_1_0,
                    							"at.jku.isse.OCLX.UnaryOperator");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalOCLX.g:542:4: ( (lv_expression_2_0= rulePrimaryExp ) )
                    // InternalOCLX.g:543:5: (lv_expression_2_0= rulePrimaryExp )
                    {
                    // InternalOCLX.g:543:5: (lv_expression_2_0= rulePrimaryExp )
                    // InternalOCLX.g:544:6: lv_expression_2_0= rulePrimaryExp
                    {

                    						newCompositeNode(grammarAccess.getPrefixedExpAccess().getExpressionPrimaryExpParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=rulePrimaryExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPrefixedExpRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_2_0,
                    							"at.jku.isse.OCLX.PrimaryExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:563:3: this_PrimaryExp_3= rulePrimaryExp
                    {

                    			newCompositeNode(grammarAccess.getPrefixedExpAccess().getPrimaryExpParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimaryExp_3=rulePrimaryExp();

                    state._fsp--;


                    			current = this_PrimaryExp_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixedExp"


    // $ANTLR start "entryRuleBinaryOperator"
    // InternalOCLX.g:575:1: entryRuleBinaryOperator returns [EObject current=null] : iv_ruleBinaryOperator= ruleBinaryOperator EOF ;
    public final EObject entryRuleBinaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperator = null;


        try {
            // InternalOCLX.g:575:55: (iv_ruleBinaryOperator= ruleBinaryOperator EOF )
            // InternalOCLX.g:576:2: iv_ruleBinaryOperator= ruleBinaryOperator EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinaryOperator=ruleBinaryOperator();

            state._fsp--;

             current =iv_ruleBinaryOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleBinaryOperator"


    // $ANTLR start "ruleBinaryOperator"
    // InternalOCLX.g:582:1: ruleBinaryOperator returns [EObject current=null] : this_InfixOperator_0= ruleInfixOperator ;
    public final EObject ruleBinaryOperator() throws RecognitionException {
        EObject current = null;

        EObject this_InfixOperator_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:588:2: (this_InfixOperator_0= ruleInfixOperator )
            // InternalOCLX.g:589:2: this_InfixOperator_0= ruleInfixOperator
            {

            		newCompositeNode(grammarAccess.getBinaryOperatorAccess().getInfixOperatorParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_InfixOperator_0=ruleInfixOperator();

            state._fsp--;


            		current = this_InfixOperator_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryOperator"


    // $ANTLR start "entryRuleInfixOperator"
    // InternalOCLX.g:600:1: entryRuleInfixOperator returns [EObject current=null] : iv_ruleInfixOperator= ruleInfixOperator EOF ;
    public final EObject entryRuleInfixOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOperator = null;


        try {
            // InternalOCLX.g:600:54: (iv_ruleInfixOperator= ruleInfixOperator EOF )
            // InternalOCLX.g:601:2: iv_ruleInfixOperator= ruleInfixOperator EOF
            {
             newCompositeNode(grammarAccess.getInfixOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInfixOperator=ruleInfixOperator();

            state._fsp--;

             current =iv_ruleInfixOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleInfixOperator"


    // $ANTLR start "ruleInfixOperator"
    // InternalOCLX.g:607:1: ruleInfixOperator returns [EObject current=null] : (this_BooleanOperator_0= ruleBooleanOperator | this_MathOperator_1= ruleMathOperator ) ;
    public final EObject ruleInfixOperator() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanOperator_0 = null;

        EObject this_MathOperator_1 = null;



        	enterRule();

        try {
            // InternalOCLX.g:613:2: ( (this_BooleanOperator_0= ruleBooleanOperator | this_MathOperator_1= ruleMathOperator ) )
            // InternalOCLX.g:614:2: (this_BooleanOperator_0= ruleBooleanOperator | this_MathOperator_1= ruleMathOperator )
            {
            // InternalOCLX.g:614:2: (this_BooleanOperator_0= ruleBooleanOperator | this_MathOperator_1= ruleMathOperator )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=22 && LA8_0<=31)) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=32 && LA8_0<=35)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalOCLX.g:615:3: this_BooleanOperator_0= ruleBooleanOperator
                    {

                    			newCompositeNode(grammarAccess.getInfixOperatorAccess().getBooleanOperatorParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanOperator_0=ruleBooleanOperator();

                    state._fsp--;


                    			current = this_BooleanOperator_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:624:3: this_MathOperator_1= ruleMathOperator
                    {

                    			newCompositeNode(grammarAccess.getInfixOperatorAccess().getMathOperatorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MathOperator_1=ruleMathOperator();

                    state._fsp--;


                    			current = this_MathOperator_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfixOperator"


    // $ANTLR start "entryRuleBooleanOperator"
    // InternalOCLX.g:636:1: entryRuleBooleanOperator returns [EObject current=null] : iv_ruleBooleanOperator= ruleBooleanOperator EOF ;
    public final EObject entryRuleBooleanOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanOperator = null;


        try {
            // InternalOCLX.g:636:56: (iv_ruleBooleanOperator= ruleBooleanOperator EOF )
            // InternalOCLX.g:637:2: iv_ruleBooleanOperator= ruleBooleanOperator EOF
            {
             newCompositeNode(grammarAccess.getBooleanOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanOperator=ruleBooleanOperator();

            state._fsp--;

             current =iv_ruleBooleanOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleBooleanOperator"


    // $ANTLR start "ruleBooleanOperator"
    // InternalOCLX.g:643:1: ruleBooleanOperator returns [EObject current=null] : ( ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '!=' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) ) ) ;
    public final EObject ruleBooleanOperator() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        Token lv_op_0_4=null;
        Token lv_op_0_5=null;
        Token lv_op_0_6=null;
        Token lv_op_0_7=null;
        Token lv_op_0_8=null;
        Token lv_op_0_9=null;
        Token lv_op_0_10=null;


        	enterRule();

        try {
            // InternalOCLX.g:649:2: ( ( ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '!=' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) ) ) )
            // InternalOCLX.g:650:2: ( ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '!=' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) ) )
            {
            // InternalOCLX.g:650:2: ( ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '!=' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) ) )
            // InternalOCLX.g:651:3: ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '!=' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) )
            {
            // InternalOCLX.g:651:3: ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '!=' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) )
            // InternalOCLX.g:652:4: (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '!=' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' )
            {
            // InternalOCLX.g:652:4: (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '!=' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' )
            int alt9=10;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt9=1;
                }
                break;
            case 23:
                {
                alt9=2;
                }
                break;
            case 24:
                {
                alt9=3;
                }
                break;
            case 25:
                {
                alt9=4;
                }
                break;
            case 26:
                {
                alt9=5;
                }
                break;
            case 27:
                {
                alt9=6;
                }
                break;
            case 28:
                {
                alt9=7;
                }
                break;
            case 29:
                {
                alt9=8;
                }
                break;
            case 30:
                {
                alt9=9;
                }
                break;
            case 31:
                {
                alt9=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalOCLX.g:653:5: lv_op_0_1= '>'
                    {
                    lv_op_0_1=(Token)match(input,22,FOLLOW_2); 

                    					newLeafNode(lv_op_0_1, grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:664:5: lv_op_0_2= '<'
                    {
                    lv_op_0_2=(Token)match(input,23,FOLLOW_2); 

                    					newLeafNode(lv_op_0_2, grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:675:5: lv_op_0_3= '>='
                    {
                    lv_op_0_3=(Token)match(input,24,FOLLOW_2); 

                    					newLeafNode(lv_op_0_3, grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalOCLX.g:686:5: lv_op_0_4= '<='
                    {
                    lv_op_0_4=(Token)match(input,25,FOLLOW_2); 

                    					newLeafNode(lv_op_0_4, grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalOCLX.g:697:5: lv_op_0_5= '='
                    {
                    lv_op_0_5=(Token)match(input,26,FOLLOW_2); 

                    					newLeafNode(lv_op_0_5, grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_5, null);
                    				

                    }
                    break;
                case 6 :
                    // InternalOCLX.g:708:5: lv_op_0_6= '!='
                    {
                    lv_op_0_6=(Token)match(input,27,FOLLOW_2); 

                    					newLeafNode(lv_op_0_6, grammarAccess.getBooleanOperatorAccess().getOpExclamationMarkEqualsSignKeyword_0_5());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_6, null);
                    				

                    }
                    break;
                case 7 :
                    // InternalOCLX.g:719:5: lv_op_0_7= 'and'
                    {
                    lv_op_0_7=(Token)match(input,28,FOLLOW_2); 

                    					newLeafNode(lv_op_0_7, grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_7, null);
                    				

                    }
                    break;
                case 8 :
                    // InternalOCLX.g:730:5: lv_op_0_8= 'or'
                    {
                    lv_op_0_8=(Token)match(input,29,FOLLOW_2); 

                    					newLeafNode(lv_op_0_8, grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_8, null);
                    				

                    }
                    break;
                case 9 :
                    // InternalOCLX.g:741:5: lv_op_0_9= 'xor'
                    {
                    lv_op_0_9=(Token)match(input,30,FOLLOW_2); 

                    					newLeafNode(lv_op_0_9, grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_9, null);
                    				

                    }
                    break;
                case 10 :
                    // InternalOCLX.g:752:5: lv_op_0_10= 'implies'
                    {
                    lv_op_0_10=(Token)match(input,31,FOLLOW_2); 

                    					newLeafNode(lv_op_0_10, grammarAccess.getBooleanOperatorAccess().getOpImpliesKeyword_0_9());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_10, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanOperator"


    // $ANTLR start "entryRuleMathOperator"
    // InternalOCLX.g:768:1: entryRuleMathOperator returns [EObject current=null] : iv_ruleMathOperator= ruleMathOperator EOF ;
    public final EObject entryRuleMathOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathOperator = null;


        try {
            // InternalOCLX.g:768:53: (iv_ruleMathOperator= ruleMathOperator EOF )
            // InternalOCLX.g:769:2: iv_ruleMathOperator= ruleMathOperator EOF
            {
             newCompositeNode(grammarAccess.getMathOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMathOperator=ruleMathOperator();

            state._fsp--;

             current =iv_ruleMathOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMathOperator"


    // $ANTLR start "ruleMathOperator"
    // InternalOCLX.g:775:1: ruleMathOperator returns [EObject current=null] : ( ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) ) ) ;
    public final EObject ruleMathOperator() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        Token lv_op_0_4=null;


        	enterRule();

        try {
            // InternalOCLX.g:781:2: ( ( ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) ) ) )
            // InternalOCLX.g:782:2: ( ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) ) )
            {
            // InternalOCLX.g:782:2: ( ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) ) )
            // InternalOCLX.g:783:3: ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) )
            {
            // InternalOCLX.g:783:3: ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) )
            // InternalOCLX.g:784:4: (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' )
            {
            // InternalOCLX.g:784:4: (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt10=1;
                }
                break;
            case 33:
                {
                alt10=2;
                }
                break;
            case 34:
                {
                alt10=3;
                }
                break;
            case 35:
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
                    // InternalOCLX.g:785:5: lv_op_0_1= '*'
                    {
                    lv_op_0_1=(Token)match(input,32,FOLLOW_2); 

                    					newLeafNode(lv_op_0_1, grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMathOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:796:5: lv_op_0_2= '/'
                    {
                    lv_op_0_2=(Token)match(input,33,FOLLOW_2); 

                    					newLeafNode(lv_op_0_2, grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMathOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:807:5: lv_op_0_3= '+'
                    {
                    lv_op_0_3=(Token)match(input,34,FOLLOW_2); 

                    					newLeafNode(lv_op_0_3, grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMathOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalOCLX.g:818:5: lv_op_0_4= '-'
                    {
                    lv_op_0_4=(Token)match(input,35,FOLLOW_2); 

                    					newLeafNode(lv_op_0_4, grammarAccess.getMathOperatorAccess().getOpHyphenMinusKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMathOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_4, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMathOperator"


    // $ANTLR start "entryRuleNavigationOperator"
    // InternalOCLX.g:834:1: entryRuleNavigationOperator returns [EObject current=null] : iv_ruleNavigationOperator= ruleNavigationOperator EOF ;
    public final EObject entryRuleNavigationOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperator = null;


        try {
            // InternalOCLX.g:834:59: (iv_ruleNavigationOperator= ruleNavigationOperator EOF )
            // InternalOCLX.g:835:2: iv_ruleNavigationOperator= ruleNavigationOperator EOF
            {
             newCompositeNode(grammarAccess.getNavigationOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavigationOperator=ruleNavigationOperator();

            state._fsp--;

             current =iv_ruleNavigationOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNavigationOperator"


    // $ANTLR start "ruleNavigationOperator"
    // InternalOCLX.g:841:1: ruleNavigationOperator returns [EObject current=null] : ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) ;
    public final EObject ruleNavigationOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;


        	enterRule();

        try {
            // InternalOCLX.g:847:2: ( ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) )
            // InternalOCLX.g:848:2: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            {
            // InternalOCLX.g:848:2: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            // InternalOCLX.g:849:3: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            {
            // InternalOCLX.g:849:3: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            // InternalOCLX.g:850:4: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            {
            // InternalOCLX.g:850:4: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            else if ( (LA11_0==36) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalOCLX.g:851:5: lv_name_0_1= '.'
                    {
                    lv_name_0_1=(Token)match(input,21,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNavigationOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:862:5: lv_name_0_2= '->'
                    {
                    lv_name_0_2=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getNavigationOperatorAccess().getNameHyphenMinusGreaterThanSignKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNavigationOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigationOperator"


    // $ANTLR start "entryRuleUnaryOperator"
    // InternalOCLX.g:878:1: entryRuleUnaryOperator returns [EObject current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final EObject entryRuleUnaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperator = null;


        try {
            // InternalOCLX.g:878:54: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalOCLX.g:879:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
             newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;

             current =iv_ruleUnaryOperator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // InternalOCLX.g:885:1: ruleUnaryOperator returns [EObject current=null] : ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) ;
    public final EObject ruleUnaryOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;


        	enterRule();

        try {
            // InternalOCLX.g:891:2: ( ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) )
            // InternalOCLX.g:892:2: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            {
            // InternalOCLX.g:892:2: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            // InternalOCLX.g:893:3: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            {
            // InternalOCLX.g:893:3: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            // InternalOCLX.g:894:4: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            {
            // InternalOCLX.g:894:4: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==35) ) {
                alt12=1;
            }
            else if ( (LA12_0==37) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalOCLX.g:895:5: lv_name_0_1= '-'
                    {
                    lv_name_0_1=(Token)match(input,35,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnaryOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:906:5: lv_name_0_2= 'not'
                    {
                    lv_name_0_2=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getUnaryOperatorAccess().getNameNotKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnaryOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRulePrimaryExp"
    // InternalOCLX.g:922:1: entryRulePrimaryExp returns [EObject current=null] : iv_rulePrimaryExp= rulePrimaryExp EOF ;
    public final EObject entryRulePrimaryExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExp = null;


        try {
            // InternalOCLX.g:922:51: (iv_rulePrimaryExp= rulePrimaryExp EOF )
            // InternalOCLX.g:923:2: iv_rulePrimaryExp= rulePrimaryExp EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExp=rulePrimaryExp();

            state._fsp--;

             current =iv_rulePrimaryExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePrimaryExp"


    // $ANTLR start "rulePrimaryExp"
    // InternalOCLX.g:929:1: rulePrimaryExp returns [EObject current=null] : (this_NestedExp_0= ruleNestedExp | (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* ) | this_PrimitiveLiteralExp_4= rulePrimitiveLiteralExp | this_TemporalExp_5= ruleTemporalExp ) ;
    public final EObject rulePrimaryExp() throws RecognitionException {
        EObject current = null;

        EObject this_NestedExp_0 = null;

        EObject this_VarOrSelfExp_1 = null;

        EObject lv_nav_2_0 = null;

        EObject lv_methods_3_0 = null;

        EObject this_PrimitiveLiteralExp_4 = null;

        EObject this_TemporalExp_5 = null;



        	enterRule();

        try {
            // InternalOCLX.g:935:2: ( (this_NestedExp_0= ruleNestedExp | (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* ) | this_PrimitiveLiteralExp_4= rulePrimitiveLiteralExp | this_TemporalExp_5= ruleTemporalExp ) )
            // InternalOCLX.g:936:2: (this_NestedExp_0= ruleNestedExp | (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* ) | this_PrimitiveLiteralExp_4= rulePrimitiveLiteralExp | this_TemporalExp_5= ruleTemporalExp )
            {
            // InternalOCLX.g:936:2: (this_NestedExp_0= ruleNestedExp | (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* ) | this_PrimitiveLiteralExp_4= rulePrimitiveLiteralExp | this_TemporalExp_5= ruleTemporalExp )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt14=1;
                }
                break;
            case RULE_ID:
            case 40:
                {
                alt14=2;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 41:
            case 42:
                {
                alt14=3;
                }
                break;
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 61:
            case 63:
            case 65:
            case 66:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalOCLX.g:937:3: this_NestedExp_0= ruleNestedExp
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpAccess().getNestedExpParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NestedExp_0=ruleNestedExp();

                    state._fsp--;


                    			current = this_NestedExp_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:946:3: (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* )
                    {
                    // InternalOCLX.g:946:3: (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* )
                    // InternalOCLX.g:947:4: this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )*
                    {

                    				newCompositeNode(grammarAccess.getPrimaryExpAccess().getVarOrSelfExpParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_19);
                    this_VarOrSelfExp_1=ruleVarOrSelfExp();

                    state._fsp--;


                    				current = this_VarOrSelfExp_1;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalOCLX.g:955:4: ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==21||LA13_0==36) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalOCLX.g:956:5: ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) )
                    	    {
                    	    // InternalOCLX.g:956:5: ( (lv_nav_2_0= ruleNavigationOperator ) )
                    	    // InternalOCLX.g:957:6: (lv_nav_2_0= ruleNavigationOperator )
                    	    {
                    	    // InternalOCLX.g:957:6: (lv_nav_2_0= ruleNavigationOperator )
                    	    // InternalOCLX.g:958:7: lv_nav_2_0= ruleNavigationOperator
                    	    {

                    	    							newCompositeNode(grammarAccess.getPrimaryExpAccess().getNavNavigationOperatorParserRuleCall_1_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_20);
                    	    lv_nav_2_0=ruleNavigationOperator();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPrimaryExpRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"nav",
                    	    								lv_nav_2_0,
                    	    								"at.jku.isse.OCLX.NavigationOperator");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }

                    	    // InternalOCLX.g:975:5: ( (lv_methods_3_0= ruleMethodExp ) )
                    	    // InternalOCLX.g:976:6: (lv_methods_3_0= ruleMethodExp )
                    	    {
                    	    // InternalOCLX.g:976:6: (lv_methods_3_0= ruleMethodExp )
                    	    // InternalOCLX.g:977:7: lv_methods_3_0= ruleMethodExp
                    	    {

                    	    							newCompositeNode(grammarAccess.getPrimaryExpAccess().getMethodsMethodExpParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_19);
                    	    lv_methods_3_0=ruleMethodExp();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPrimaryExpRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"methods",
                    	    								lv_methods_3_0,
                    	    								"at.jku.isse.OCLX.MethodExp");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:997:3: this_PrimitiveLiteralExp_4= rulePrimitiveLiteralExp
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpAccess().getPrimitiveLiteralExpParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimitiveLiteralExp_4=rulePrimitiveLiteralExp();

                    state._fsp--;


                    			current = this_PrimitiveLiteralExp_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1006:3: this_TemporalExp_5= ruleTemporalExp
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpAccess().getTemporalExpParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_TemporalExp_5=ruleTemporalExp();

                    state._fsp--;


                    			current = this_TemporalExp_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExp"


    // $ANTLR start "entryRuleNestedExp"
    // InternalOCLX.g:1018:1: entryRuleNestedExp returns [EObject current=null] : iv_ruleNestedExp= ruleNestedExp EOF ;
    public final EObject entryRuleNestedExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExp = null;


        try {
            // InternalOCLX.g:1018:50: (iv_ruleNestedExp= ruleNestedExp EOF )
            // InternalOCLX.g:1019:2: iv_ruleNestedExp= ruleNestedExp EOF
            {
             newCompositeNode(grammarAccess.getNestedExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNestedExp=ruleNestedExp();

            state._fsp--;

             current =iv_ruleNestedExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleNestedExp"


    // $ANTLR start "ruleNestedExp"
    // InternalOCLX.g:1025:1: ruleNestedExp returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleExp ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_source_1_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1031:2: ( (otherlv_0= '(' ( (lv_source_1_0= ruleExp ) ) otherlv_2= ')' ) )
            // InternalOCLX.g:1032:2: (otherlv_0= '(' ( (lv_source_1_0= ruleExp ) ) otherlv_2= ')' )
            {
            // InternalOCLX.g:1032:2: (otherlv_0= '(' ( (lv_source_1_0= ruleExp ) ) otherlv_2= ')' )
            // InternalOCLX.g:1033:3: otherlv_0= '(' ( (lv_source_1_0= ruleExp ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getNestedExpAccess().getLeftParenthesisKeyword_0());
            		
            // InternalOCLX.g:1037:3: ( (lv_source_1_0= ruleExp ) )
            // InternalOCLX.g:1038:4: (lv_source_1_0= ruleExp )
            {
            // InternalOCLX.g:1038:4: (lv_source_1_0= ruleExp )
            // InternalOCLX.g:1039:5: lv_source_1_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getNestedExpAccess().getSourceExpParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_21);
            lv_source_1_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNestedExpRule());
            					}
            					set(
            						current,
            						"source",
            						lv_source_1_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getNestedExpAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNestedExp"


    // $ANTLR start "entryRuleVarOrSelfExp"
    // InternalOCLX.g:1064:1: entryRuleVarOrSelfExp returns [EObject current=null] : iv_ruleVarOrSelfExp= ruleVarOrSelfExp EOF ;
    public final EObject entryRuleVarOrSelfExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarOrSelfExp = null;


        try {
            // InternalOCLX.g:1064:53: (iv_ruleVarOrSelfExp= ruleVarOrSelfExp EOF )
            // InternalOCLX.g:1065:2: iv_ruleVarOrSelfExp= ruleVarOrSelfExp EOF
            {
             newCompositeNode(grammarAccess.getVarOrSelfExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarOrSelfExp=ruleVarOrSelfExp();

            state._fsp--;

             current =iv_ruleVarOrSelfExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVarOrSelfExp"


    // $ANTLR start "ruleVarOrSelfExp"
    // InternalOCLX.g:1071:1: ruleVarOrSelfExp returns [EObject current=null] : (this_SelfExp_0= ruleSelfExp | this_VarReference_1= ruleVarReference ) ;
    public final EObject ruleVarOrSelfExp() throws RecognitionException {
        EObject current = null;

        EObject this_SelfExp_0 = null;

        EObject this_VarReference_1 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1077:2: ( (this_SelfExp_0= ruleSelfExp | this_VarReference_1= ruleVarReference ) )
            // InternalOCLX.g:1078:2: (this_SelfExp_0= ruleSelfExp | this_VarReference_1= ruleVarReference )
            {
            // InternalOCLX.g:1078:2: (this_SelfExp_0= ruleSelfExp | this_VarReference_1= ruleVarReference )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==40) ) {
                alt15=1;
            }
            else if ( (LA15_0==RULE_ID) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalOCLX.g:1079:3: this_SelfExp_0= ruleSelfExp
                    {

                    			newCompositeNode(grammarAccess.getVarOrSelfExpAccess().getSelfExpParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SelfExp_0=ruleSelfExp();

                    state._fsp--;


                    			current = this_SelfExp_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1088:3: this_VarReference_1= ruleVarReference
                    {

                    			newCompositeNode(grammarAccess.getVarOrSelfExpAccess().getVarReferenceParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_VarReference_1=ruleVarReference();

                    state._fsp--;


                    			current = this_VarReference_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarOrSelfExp"


    // $ANTLR start "entryRuleSelfExp"
    // InternalOCLX.g:1100:1: entryRuleSelfExp returns [EObject current=null] : iv_ruleSelfExp= ruleSelfExp EOF ;
    public final EObject entryRuleSelfExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExp = null;


        try {
            // InternalOCLX.g:1100:48: (iv_ruleSelfExp= ruleSelfExp EOF )
            // InternalOCLX.g:1101:2: iv_ruleSelfExp= ruleSelfExp EOF
            {
             newCompositeNode(grammarAccess.getSelfExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSelfExp=ruleSelfExp();

            state._fsp--;

             current =iv_ruleSelfExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSelfExp"


    // $ANTLR start "ruleSelfExp"
    // InternalOCLX.g:1107:1: ruleSelfExp returns [EObject current=null] : ( () ( (lv_name_1_0= 'self' ) ) ) ;
    public final EObject ruleSelfExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:1113:2: ( ( () ( (lv_name_1_0= 'self' ) ) ) )
            // InternalOCLX.g:1114:2: ( () ( (lv_name_1_0= 'self' ) ) )
            {
            // InternalOCLX.g:1114:2: ( () ( (lv_name_1_0= 'self' ) ) )
            // InternalOCLX.g:1115:3: () ( (lv_name_1_0= 'self' ) )
            {
            // InternalOCLX.g:1115:3: ()
            // InternalOCLX.g:1116:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSelfExpAccess().getSelfExpAction_0(),
            					current);
            			

            }

            // InternalOCLX.g:1122:3: ( (lv_name_1_0= 'self' ) )
            // InternalOCLX.g:1123:4: (lv_name_1_0= 'self' )
            {
            // InternalOCLX.g:1123:4: (lv_name_1_0= 'self' )
            // InternalOCLX.g:1124:5: lv_name_1_0= 'self'
            {
            lv_name_1_0=(Token)match(input,40,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSelfExpAccess().getNameSelfKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSelfExpRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_1_0, "self");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelfExp"


    // $ANTLR start "entryRuleVarDeclaration"
    // InternalOCLX.g:1140:1: entryRuleVarDeclaration returns [EObject current=null] : iv_ruleVarDeclaration= ruleVarDeclaration EOF ;
    public final EObject entryRuleVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDeclaration = null;


        try {
            // InternalOCLX.g:1140:55: (iv_ruleVarDeclaration= ruleVarDeclaration EOF )
            // InternalOCLX.g:1141:2: iv_ruleVarDeclaration= ruleVarDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarDeclaration=ruleVarDeclaration();

            state._fsp--;

             current =iv_ruleVarDeclaration; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVarDeclaration"


    // $ANTLR start "ruleVarDeclaration"
    // InternalOCLX.g:1147:1: ruleVarDeclaration returns [EObject current=null] : ( (lv_name_0_0= ruleSimpleName ) ) ;
    public final EObject ruleVarDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1153:2: ( ( (lv_name_0_0= ruleSimpleName ) ) )
            // InternalOCLX.g:1154:2: ( (lv_name_0_0= ruleSimpleName ) )
            {
            // InternalOCLX.g:1154:2: ( (lv_name_0_0= ruleSimpleName ) )
            // InternalOCLX.g:1155:3: (lv_name_0_0= ruleSimpleName )
            {
            // InternalOCLX.g:1155:3: (lv_name_0_0= ruleSimpleName )
            // InternalOCLX.g:1156:4: lv_name_0_0= ruleSimpleName
            {

            				newCompositeNode(grammarAccess.getVarDeclarationAccess().getNameSimpleNameParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleSimpleName();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getVarDeclarationRule());
            				}
            				set(
            					current,
            					"name",
            					lv_name_0_0,
            					"at.jku.isse.OCLX.SimpleName");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarDeclaration"


    // $ANTLR start "entryRuleVarReference"
    // InternalOCLX.g:1176:1: entryRuleVarReference returns [EObject current=null] : iv_ruleVarReference= ruleVarReference EOF ;
    public final EObject entryRuleVarReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarReference = null;


        try {
            // InternalOCLX.g:1176:53: (iv_ruleVarReference= ruleVarReference EOF )
            // InternalOCLX.g:1177:2: iv_ruleVarReference= ruleVarReference EOF
            {
             newCompositeNode(grammarAccess.getVarReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVarReference=ruleVarReference();

            state._fsp--;

             current =iv_ruleVarReference; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleVarReference"


    // $ANTLR start "ruleVarReference"
    // InternalOCLX.g:1183:1: ruleVarReference returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleVarReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:1189:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalOCLX.g:1190:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalOCLX.g:1190:2: ( (otherlv_0= RULE_ID ) )
            // InternalOCLX.g:1191:3: (otherlv_0= RULE_ID )
            {
            // InternalOCLX.g:1191:3: (otherlv_0= RULE_ID )
            // InternalOCLX.g:1192:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVarReferenceRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getVarReferenceAccess().getRefVarDeclarationCrossReference_0());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarReference"


    // $ANTLR start "entryRulePrimitiveLiteralExp"
    // InternalOCLX.g:1206:1: entryRulePrimitiveLiteralExp returns [EObject current=null] : iv_rulePrimitiveLiteralExp= rulePrimitiveLiteralExp EOF ;
    public final EObject entryRulePrimitiveLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExp = null;


        try {
            // InternalOCLX.g:1206:60: (iv_rulePrimitiveLiteralExp= rulePrimitiveLiteralExp EOF )
            // InternalOCLX.g:1207:2: iv_rulePrimitiveLiteralExp= rulePrimitiveLiteralExp EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveLiteralExp=rulePrimitiveLiteralExp();

            state._fsp--;

             current =iv_rulePrimitiveLiteralExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePrimitiveLiteralExp"


    // $ANTLR start "rulePrimitiveLiteralExp"
    // InternalOCLX.g:1213:1: rulePrimitiveLiteralExp returns [EObject current=null] : (this_IntLiteralExp_0= ruleIntLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_FloatLiteralExp_3= ruleFloatLiteralExp ) ;
    public final EObject rulePrimitiveLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject this_IntLiteralExp_0 = null;

        EObject this_StringLiteralExp_1 = null;

        EObject this_BooleanLiteralExp_2 = null;

        EObject this_FloatLiteralExp_3 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1219:2: ( (this_IntLiteralExp_0= ruleIntLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_FloatLiteralExp_3= ruleFloatLiteralExp ) )
            // InternalOCLX.g:1220:2: (this_IntLiteralExp_0= ruleIntLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_FloatLiteralExp_3= ruleFloatLiteralExp )
            {
            // InternalOCLX.g:1220:2: (this_IntLiteralExp_0= ruleIntLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_FloatLiteralExp_3= ruleFloatLiteralExp )
            int alt16=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==EOF||LA16_1==20||(LA16_1>=22 && LA16_1<=35)||LA16_1==39||(LA16_1>=57 && LA16_1<=58)||LA16_1==60||LA16_1==62||LA16_1==64) ) {
                    alt16=1;
                }
                else if ( (LA16_1==21) ) {
                    alt16=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                alt16=2;
                }
                break;
            case 41:
            case 42:
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
                    // InternalOCLX.g:1221:3: this_IntLiteralExp_0= ruleIntLiteralExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveLiteralExpAccess().getIntLiteralExpParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntLiteralExp_0=ruleIntLiteralExp();

                    state._fsp--;


                    			current = this_IntLiteralExp_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1230:3: this_StringLiteralExp_1= ruleStringLiteralExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveLiteralExpAccess().getStringLiteralExpParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringLiteralExp_1=ruleStringLiteralExp();

                    state._fsp--;


                    			current = this_StringLiteralExp_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1239:3: this_BooleanLiteralExp_2= ruleBooleanLiteralExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveLiteralExpAccess().getBooleanLiteralExpParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteralExp_2=ruleBooleanLiteralExp();

                    state._fsp--;


                    			current = this_BooleanLiteralExp_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1248:3: this_FloatLiteralExp_3= ruleFloatLiteralExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveLiteralExpAccess().getFloatLiteralExpParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_FloatLiteralExp_3=ruleFloatLiteralExp();

                    state._fsp--;


                    			current = this_FloatLiteralExp_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveLiteralExp"


    // $ANTLR start "entryRuleIntLiteralExp"
    // InternalOCLX.g:1260:1: entryRuleIntLiteralExp returns [EObject current=null] : iv_ruleIntLiteralExp= ruleIntLiteralExp EOF ;
    public final EObject entryRuleIntLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteralExp = null;


        try {
            // InternalOCLX.g:1260:54: (iv_ruleIntLiteralExp= ruleIntLiteralExp EOF )
            // InternalOCLX.g:1261:2: iv_ruleIntLiteralExp= ruleIntLiteralExp EOF
            {
             newCompositeNode(grammarAccess.getIntLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntLiteralExp=ruleIntLiteralExp();

            state._fsp--;

             current =iv_ruleIntLiteralExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIntLiteralExp"


    // $ANTLR start "ruleIntLiteralExp"
    // InternalOCLX.g:1267:1: ruleIntLiteralExp returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleIntLiteralExp() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:1273:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalOCLX.g:1274:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalOCLX.g:1274:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalOCLX.g:1275:3: (lv_value_0_0= RULE_INT )
            {
            // InternalOCLX.g:1275:3: (lv_value_0_0= RULE_INT )
            // InternalOCLX.g:1276:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getIntLiteralExpAccess().getValueINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIntLiteralExpRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntLiteralExp"


    // $ANTLR start "entryRuleStringLiteralExp"
    // InternalOCLX.g:1295:1: entryRuleStringLiteralExp returns [EObject current=null] : iv_ruleStringLiteralExp= ruleStringLiteralExp EOF ;
    public final EObject entryRuleStringLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExp = null;


        try {
            // InternalOCLX.g:1295:57: (iv_ruleStringLiteralExp= ruleStringLiteralExp EOF )
            // InternalOCLX.g:1296:2: iv_ruleStringLiteralExp= ruleStringLiteralExp EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteralExp=ruleStringLiteralExp();

            state._fsp--;

             current =iv_ruleStringLiteralExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleStringLiteralExp"


    // $ANTLR start "ruleStringLiteralExp"
    // InternalOCLX.g:1302:1: ruleStringLiteralExp returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralExp() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:1308:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalOCLX.g:1309:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalOCLX.g:1309:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalOCLX.g:1310:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalOCLX.g:1310:3: (lv_value_0_0= RULE_STRING )
            // InternalOCLX.g:1311:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralExpAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringLiteralExpRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteralExp"


    // $ANTLR start "entryRuleBooleanLiteralExp"
    // InternalOCLX.g:1330:1: entryRuleBooleanLiteralExp returns [EObject current=null] : iv_ruleBooleanLiteralExp= ruleBooleanLiteralExp EOF ;
    public final EObject entryRuleBooleanLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExp = null;


        try {
            // InternalOCLX.g:1330:58: (iv_ruleBooleanLiteralExp= ruleBooleanLiteralExp EOF )
            // InternalOCLX.g:1331:2: iv_ruleBooleanLiteralExp= ruleBooleanLiteralExp EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteralExp=ruleBooleanLiteralExp();

            state._fsp--;

             current =iv_ruleBooleanLiteralExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleBooleanLiteralExp"


    // $ANTLR start "ruleBooleanLiteralExp"
    // InternalOCLX.g:1337:1: ruleBooleanLiteralExp returns [EObject current=null] : ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExp() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:1343:2: ( ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) ) )
            // InternalOCLX.g:1344:2: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )
            {
            // InternalOCLX.g:1344:2: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==41) ) {
                alt17=1;
            }
            else if ( (LA17_0==42) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalOCLX.g:1345:3: ( (lv_value_0_0= 'true' ) )
                    {
                    // InternalOCLX.g:1345:3: ( (lv_value_0_0= 'true' ) )
                    // InternalOCLX.g:1346:4: (lv_value_0_0= 'true' )
                    {
                    // InternalOCLX.g:1346:4: (lv_value_0_0= 'true' )
                    // InternalOCLX.g:1347:5: lv_value_0_0= 'true'
                    {
                    lv_value_0_0=(Token)match(input,41,FOLLOW_2); 

                    					newLeafNode(lv_value_0_0, grammarAccess.getBooleanLiteralExpAccess().getValueTrueKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanLiteralExpRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_0_0, "true");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1360:3: ( (lv_value_1_0= 'false' ) )
                    {
                    // InternalOCLX.g:1360:3: ( (lv_value_1_0= 'false' ) )
                    // InternalOCLX.g:1361:4: (lv_value_1_0= 'false' )
                    {
                    // InternalOCLX.g:1361:4: (lv_value_1_0= 'false' )
                    // InternalOCLX.g:1362:5: lv_value_1_0= 'false'
                    {
                    lv_value_1_0=(Token)match(input,42,FOLLOW_2); 

                    					newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralExpAccess().getValueFalseKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanLiteralExpRule());
                    					}
                    					setWithLastConsumed(current, "value", lv_value_1_0, "false");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteralExp"


    // $ANTLR start "entryRuleFloatLiteralExp"
    // InternalOCLX.g:1378:1: entryRuleFloatLiteralExp returns [EObject current=null] : iv_ruleFloatLiteralExp= ruleFloatLiteralExp EOF ;
    public final EObject entryRuleFloatLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatLiteralExp = null;


        try {
            // InternalOCLX.g:1378:56: (iv_ruleFloatLiteralExp= ruleFloatLiteralExp EOF )
            // InternalOCLX.g:1379:2: iv_ruleFloatLiteralExp= ruleFloatLiteralExp EOF
            {
             newCompositeNode(grammarAccess.getFloatLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloatLiteralExp=ruleFloatLiteralExp();

            state._fsp--;

             current =iv_ruleFloatLiteralExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleFloatLiteralExp"


    // $ANTLR start "ruleFloatLiteralExp"
    // InternalOCLX.g:1385:1: ruleFloatLiteralExp returns [EObject current=null] : ( (lv_value_0_0= ruleFloat ) ) ;
    public final EObject ruleFloatLiteralExp() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1391:2: ( ( (lv_value_0_0= ruleFloat ) ) )
            // InternalOCLX.g:1392:2: ( (lv_value_0_0= ruleFloat ) )
            {
            // InternalOCLX.g:1392:2: ( (lv_value_0_0= ruleFloat ) )
            // InternalOCLX.g:1393:3: (lv_value_0_0= ruleFloat )
            {
            // InternalOCLX.g:1393:3: (lv_value_0_0= ruleFloat )
            // InternalOCLX.g:1394:4: lv_value_0_0= ruleFloat
            {

            				newCompositeNode(grammarAccess.getFloatLiteralExpAccess().getValueFloatParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleFloat();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getFloatLiteralExpRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"at.jku.isse.OCLX.Float");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloatLiteralExp"


    // $ANTLR start "entryRuleMethodExp"
    // InternalOCLX.g:1414:1: entryRuleMethodExp returns [EObject current=null] : iv_ruleMethodExp= ruleMethodExp EOF ;
    public final EObject entryRuleMethodExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodExp = null;


        try {
            // InternalOCLX.g:1414:50: (iv_ruleMethodExp= ruleMethodExp EOF )
            // InternalOCLX.g:1415:2: iv_ruleMethodExp= ruleMethodExp EOF
            {
             newCompositeNode(grammarAccess.getMethodExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMethodExp=ruleMethodExp();

            state._fsp--;

             current =iv_ruleMethodExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMethodExp"


    // $ANTLR start "ruleMethodExp"
    // InternalOCLX.g:1421:1: ruleMethodExp returns [EObject current=null] : (this_PropertyAccess_0= rulePropertyAccess | this_MethodCall_1= ruleMethodCall | this_CollectionIterator_2= ruleCollectionIterator | this_TypeCall_3= ruleTypeCall ) ;
    public final EObject ruleMethodExp() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyAccess_0 = null;

        EObject this_MethodCall_1 = null;

        EObject this_CollectionIterator_2 = null;

        EObject this_TypeCall_3 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1427:2: ( (this_PropertyAccess_0= rulePropertyAccess | this_MethodCall_1= ruleMethodCall | this_CollectionIterator_2= ruleCollectionIterator | this_TypeCall_3= ruleTypeCall ) )
            // InternalOCLX.g:1428:2: (this_PropertyAccess_0= rulePropertyAccess | this_MethodCall_1= ruleMethodCall | this_CollectionIterator_2= ruleCollectionIterator | this_TypeCall_3= ruleTypeCall )
            {
            // InternalOCLX.g:1428:2: (this_PropertyAccess_0= rulePropertyAccess | this_MethodCall_1= ruleMethodCall | this_CollectionIterator_2= ruleCollectionIterator | this_TypeCall_3= ruleTypeCall )
            int alt18=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==EOF||(LA18_1>=20 && LA18_1<=36)||LA18_1==39||(LA18_1>=57 && LA18_1<=58)||LA18_1==60||LA18_1==62||LA18_1==64) ) {
                    alt18=1;
                }
                else if ( (LA18_1==38||LA18_1==50) ) {
                    alt18=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
                }
                break;
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
                {
                alt18=3;
                }
                break;
            case 51:
            case 52:
            case 53:
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
                    // InternalOCLX.g:1429:3: this_PropertyAccess_0= rulePropertyAccess
                    {

                    			newCompositeNode(grammarAccess.getMethodExpAccess().getPropertyAccessParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PropertyAccess_0=rulePropertyAccess();

                    state._fsp--;


                    			current = this_PropertyAccess_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1438:3: this_MethodCall_1= ruleMethodCall
                    {

                    			newCompositeNode(grammarAccess.getMethodExpAccess().getMethodCallParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MethodCall_1=ruleMethodCall();

                    state._fsp--;


                    			current = this_MethodCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1447:3: this_CollectionIterator_2= ruleCollectionIterator
                    {

                    			newCompositeNode(grammarAccess.getMethodExpAccess().getCollectionIteratorParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_CollectionIterator_2=ruleCollectionIterator();

                    state._fsp--;


                    			current = this_CollectionIterator_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1456:3: this_TypeCall_3= ruleTypeCall
                    {

                    			newCompositeNode(grammarAccess.getMethodExpAccess().getTypeCallParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_TypeCall_3=ruleTypeCall();

                    state._fsp--;


                    			current = this_TypeCall_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodExp"


    // $ANTLR start "entryRuleCollectionIterator"
    // InternalOCLX.g:1468:1: entryRuleCollectionIterator returns [EObject current=null] : iv_ruleCollectionIterator= ruleCollectionIterator EOF ;
    public final EObject entryRuleCollectionIterator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionIterator = null;


        try {
            // InternalOCLX.g:1468:59: (iv_ruleCollectionIterator= ruleCollectionIterator EOF )
            // InternalOCLX.g:1469:2: iv_ruleCollectionIterator= ruleCollectionIterator EOF
            {
             newCompositeNode(grammarAccess.getCollectionIteratorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollectionIterator=ruleCollectionIterator();

            state._fsp--;

             current =iv_ruleCollectionIterator; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCollectionIterator"


    // $ANTLR start "ruleCollectionIterator"
    // InternalOCLX.g:1475:1: ruleCollectionIterator returns [EObject current=null] : ( ( (lv_name_0_0= ruleIteratorName ) ) otherlv_1= '(' ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) ) otherlv_3= '|' ( (lv_body_4_0= ruleExp ) ) otherlv_5= ')' ) ;
    public final EObject ruleCollectionIterator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_name_0_0 = null;

        EObject lv_itervar_2_0 = null;

        EObject lv_body_4_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1481:2: ( ( ( (lv_name_0_0= ruleIteratorName ) ) otherlv_1= '(' ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) ) otherlv_3= '|' ( (lv_body_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:1482:2: ( ( (lv_name_0_0= ruleIteratorName ) ) otherlv_1= '(' ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) ) otherlv_3= '|' ( (lv_body_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:1482:2: ( ( (lv_name_0_0= ruleIteratorName ) ) otherlv_1= '(' ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) ) otherlv_3= '|' ( (lv_body_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:1483:3: ( (lv_name_0_0= ruleIteratorName ) ) otherlv_1= '(' ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) ) otherlv_3= '|' ( (lv_body_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:1483:3: ( (lv_name_0_0= ruleIteratorName ) )
            // InternalOCLX.g:1484:4: (lv_name_0_0= ruleIteratorName )
            {
            // InternalOCLX.g:1484:4: (lv_name_0_0= ruleIteratorName )
            // InternalOCLX.g:1485:5: lv_name_0_0= ruleIteratorName
            {

            					newCompositeNode(grammarAccess.getCollectionIteratorAccess().getNameIteratorNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_22);
            lv_name_0_0=ruleIteratorName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCollectionIteratorRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"at.jku.isse.OCLX.IteratorName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getCollectionIteratorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:1506:3: ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) )
            // InternalOCLX.g:1507:4: (lv_itervar_2_0= ruleIteratorVarDeclaration )
            {
            // InternalOCLX.g:1507:4: (lv_itervar_2_0= ruleIteratorVarDeclaration )
            // InternalOCLX.g:1508:5: lv_itervar_2_0= ruleIteratorVarDeclaration
            {

            					newCompositeNode(grammarAccess.getCollectionIteratorAccess().getItervarIteratorVarDeclarationParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_23);
            lv_itervar_2_0=ruleIteratorVarDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCollectionIteratorRule());
            					}
            					set(
            						current,
            						"itervar",
            						lv_itervar_2_0,
            						"at.jku.isse.OCLX.IteratorVarDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,43,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getCollectionIteratorAccess().getVerticalLineKeyword_3());
            		
            // InternalOCLX.g:1529:3: ( (lv_body_4_0= ruleExp ) )
            // InternalOCLX.g:1530:4: (lv_body_4_0= ruleExp )
            {
            // InternalOCLX.g:1530:4: (lv_body_4_0= ruleExp )
            // InternalOCLX.g:1531:5: lv_body_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getCollectionIteratorAccess().getBodyExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_body_4_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCollectionIteratorRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_4_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getCollectionIteratorAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionIterator"


    // $ANTLR start "entryRuleIteratorName"
    // InternalOCLX.g:1556:1: entryRuleIteratorName returns [EObject current=null] : iv_ruleIteratorName= ruleIteratorName EOF ;
    public final EObject entryRuleIteratorName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIteratorName = null;


        try {
            // InternalOCLX.g:1556:53: (iv_ruleIteratorName= ruleIteratorName EOF )
            // InternalOCLX.g:1557:2: iv_ruleIteratorName= ruleIteratorName EOF
            {
             newCompositeNode(grammarAccess.getIteratorNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIteratorName=ruleIteratorName();

            state._fsp--;

             current =iv_ruleIteratorName; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIteratorName"


    // $ANTLR start "ruleIteratorName"
    // InternalOCLX.g:1563:1: ruleIteratorName returns [EObject current=null] : ( ( (lv_name_0_1= 'forAll' | lv_name_0_2= 'exists' | lv_name_0_3= 'collect' | lv_name_0_4= 'reject' | lv_name_0_5= 'select' ) ) ) ;
    public final EObject ruleIteratorName() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;


        	enterRule();

        try {
            // InternalOCLX.g:1569:2: ( ( ( (lv_name_0_1= 'forAll' | lv_name_0_2= 'exists' | lv_name_0_3= 'collect' | lv_name_0_4= 'reject' | lv_name_0_5= 'select' ) ) ) )
            // InternalOCLX.g:1570:2: ( ( (lv_name_0_1= 'forAll' | lv_name_0_2= 'exists' | lv_name_0_3= 'collect' | lv_name_0_4= 'reject' | lv_name_0_5= 'select' ) ) )
            {
            // InternalOCLX.g:1570:2: ( ( (lv_name_0_1= 'forAll' | lv_name_0_2= 'exists' | lv_name_0_3= 'collect' | lv_name_0_4= 'reject' | lv_name_0_5= 'select' ) ) )
            // InternalOCLX.g:1571:3: ( (lv_name_0_1= 'forAll' | lv_name_0_2= 'exists' | lv_name_0_3= 'collect' | lv_name_0_4= 'reject' | lv_name_0_5= 'select' ) )
            {
            // InternalOCLX.g:1571:3: ( (lv_name_0_1= 'forAll' | lv_name_0_2= 'exists' | lv_name_0_3= 'collect' | lv_name_0_4= 'reject' | lv_name_0_5= 'select' ) )
            // InternalOCLX.g:1572:4: (lv_name_0_1= 'forAll' | lv_name_0_2= 'exists' | lv_name_0_3= 'collect' | lv_name_0_4= 'reject' | lv_name_0_5= 'select' )
            {
            // InternalOCLX.g:1572:4: (lv_name_0_1= 'forAll' | lv_name_0_2= 'exists' | lv_name_0_3= 'collect' | lv_name_0_4= 'reject' | lv_name_0_5= 'select' )
            int alt19=5;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt19=1;
                }
                break;
            case 45:
                {
                alt19=2;
                }
                break;
            case 46:
                {
                alt19=3;
                }
                break;
            case 47:
                {
                alt19=4;
                }
                break;
            case 48:
                {
                alt19=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalOCLX.g:1573:5: lv_name_0_1= 'forAll'
                    {
                    lv_name_0_1=(Token)match(input,44,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getIteratorNameAccess().getNameForAllKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIteratorNameRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1584:5: lv_name_0_2= 'exists'
                    {
                    lv_name_0_2=(Token)match(input,45,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getIteratorNameAccess().getNameExistsKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIteratorNameRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1595:5: lv_name_0_3= 'collect'
                    {
                    lv_name_0_3=(Token)match(input,46,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getIteratorNameAccess().getNameCollectKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIteratorNameRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1606:5: lv_name_0_4= 'reject'
                    {
                    lv_name_0_4=(Token)match(input,47,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getIteratorNameAccess().getNameRejectKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIteratorNameRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1617:5: lv_name_0_5= 'select'
                    {
                    lv_name_0_5=(Token)match(input,48,FOLLOW_2); 

                    					newLeafNode(lv_name_0_5, grammarAccess.getIteratorNameAccess().getNameSelectKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIteratorNameRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_5, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIteratorName"


    // $ANTLR start "entryRuleIteratorVarDeclaration"
    // InternalOCLX.g:1633:1: entryRuleIteratorVarDeclaration returns [EObject current=null] : iv_ruleIteratorVarDeclaration= ruleIteratorVarDeclaration EOF ;
    public final EObject entryRuleIteratorVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIteratorVarDeclaration = null;


        try {
            // InternalOCLX.g:1633:63: (iv_ruleIteratorVarDeclaration= ruleIteratorVarDeclaration EOF )
            // InternalOCLX.g:1634:2: iv_ruleIteratorVarDeclaration= ruleIteratorVarDeclaration EOF
            {
             newCompositeNode(grammarAccess.getIteratorVarDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIteratorVarDeclaration=ruleIteratorVarDeclaration();

            state._fsp--;

             current =iv_ruleIteratorVarDeclaration; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleIteratorVarDeclaration"


    // $ANTLR start "ruleIteratorVarDeclaration"
    // InternalOCLX.g:1640:1: ruleIteratorVarDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= ruleVarDeclaration ) ) | ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ) ) ;
    public final EObject ruleIteratorVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_name_1_0 = null;

        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1646:2: ( ( ( (lv_name_0_0= ruleVarDeclaration ) ) | ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ) ) )
            // InternalOCLX.g:1647:2: ( ( (lv_name_0_0= ruleVarDeclaration ) ) | ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ) )
            {
            // InternalOCLX.g:1647:2: ( ( (lv_name_0_0= ruleVarDeclaration ) ) | ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==49) ) {
                    alt20=2;
                }
                else if ( (LA20_1==EOF||LA20_1==43) ) {
                    alt20=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalOCLX.g:1648:3: ( (lv_name_0_0= ruleVarDeclaration ) )
                    {
                    // InternalOCLX.g:1648:3: ( (lv_name_0_0= ruleVarDeclaration ) )
                    // InternalOCLX.g:1649:4: (lv_name_0_0= ruleVarDeclaration )
                    {
                    // InternalOCLX.g:1649:4: (lv_name_0_0= ruleVarDeclaration )
                    // InternalOCLX.g:1650:5: lv_name_0_0= ruleVarDeclaration
                    {

                    					newCompositeNode(grammarAccess.getIteratorVarDeclarationAccess().getNameVarDeclarationParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_name_0_0=ruleVarDeclaration();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIteratorVarDeclarationRule());
                    					}
                    					set(
                    						current,
                    						"name",
                    						lv_name_0_0,
                    						"at.jku.isse.OCLX.VarDeclaration");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1668:3: ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )
                    {
                    // InternalOCLX.g:1668:3: ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )
                    // InternalOCLX.g:1669:4: ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) )
                    {
                    // InternalOCLX.g:1669:4: ( (lv_name_1_0= ruleVarDeclaration ) )
                    // InternalOCLX.g:1670:5: (lv_name_1_0= ruleVarDeclaration )
                    {
                    // InternalOCLX.g:1670:5: (lv_name_1_0= ruleVarDeclaration )
                    // InternalOCLX.g:1671:6: lv_name_1_0= ruleVarDeclaration
                    {

                    						newCompositeNode(grammarAccess.getIteratorVarDeclarationAccess().getNameVarDeclarationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_name_1_0=ruleVarDeclaration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIteratorVarDeclarationRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"at.jku.isse.OCLX.VarDeclaration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,49,FOLLOW_25); 

                    				newLeafNode(otherlv_2, grammarAccess.getIteratorVarDeclarationAccess().getColonKeyword_1_1());
                    			
                    // InternalOCLX.g:1692:4: ( (lv_type_3_0= ruleTypeExp ) )
                    // InternalOCLX.g:1693:5: (lv_type_3_0= ruleTypeExp )
                    {
                    // InternalOCLX.g:1693:5: (lv_type_3_0= ruleTypeExp )
                    // InternalOCLX.g:1694:6: lv_type_3_0= ruleTypeExp
                    {

                    						newCompositeNode(grammarAccess.getIteratorVarDeclarationAccess().getTypeTypeExpParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_type_3_0=ruleTypeExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIteratorVarDeclarationRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_3_0,
                    							"at.jku.isse.OCLX.TypeExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIteratorVarDeclaration"


    // $ANTLR start "entryRulePropertyAccess"
    // InternalOCLX.g:1716:1: entryRulePropertyAccess returns [EObject current=null] : iv_rulePropertyAccess= rulePropertyAccess EOF ;
    public final EObject entryRulePropertyAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAccess = null;


        try {
            // InternalOCLX.g:1716:55: (iv_rulePropertyAccess= rulePropertyAccess EOF )
            // InternalOCLX.g:1717:2: iv_rulePropertyAccess= rulePropertyAccess EOF
            {
             newCompositeNode(grammarAccess.getPropertyAccessRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyAccess=rulePropertyAccess();

            state._fsp--;

             current =iv_rulePropertyAccess; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRulePropertyAccess"


    // $ANTLR start "rulePropertyAccess"
    // InternalOCLX.g:1723:1: rulePropertyAccess returns [EObject current=null] : ( (lv_name_0_0= ruleSimpleName ) ) ;
    public final EObject rulePropertyAccess() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1729:2: ( ( (lv_name_0_0= ruleSimpleName ) ) )
            // InternalOCLX.g:1730:2: ( (lv_name_0_0= ruleSimpleName ) )
            {
            // InternalOCLX.g:1730:2: ( (lv_name_0_0= ruleSimpleName ) )
            // InternalOCLX.g:1731:3: (lv_name_0_0= ruleSimpleName )
            {
            // InternalOCLX.g:1731:3: (lv_name_0_0= ruleSimpleName )
            // InternalOCLX.g:1732:4: lv_name_0_0= ruleSimpleName
            {

            				newCompositeNode(grammarAccess.getPropertyAccessAccess().getNameSimpleNameParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleSimpleName();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getPropertyAccessRule());
            				}
            				set(
            					current,
            					"name",
            					lv_name_0_0,
            					"at.jku.isse.OCLX.SimpleName");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyAccess"


    // $ANTLR start "entryRuleMethodCall"
    // InternalOCLX.g:1752:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalOCLX.g:1752:51: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalOCLX.g:1753:2: iv_ruleMethodCall= ruleMethodCall EOF
            {
             newCompositeNode(grammarAccess.getMethodCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMethodCall=ruleMethodCall();

            state._fsp--;

             current =iv_ruleMethodCall; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMethodCall"


    // $ANTLR start "ruleMethodCall"
    // InternalOCLX.g:1759:1: ruleMethodCall returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' ) | ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' ) ) ;
    public final EObject ruleMethodCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_args_4_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1765:2: ( ( ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' ) | ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' ) ) )
            // InternalOCLX.g:1766:2: ( ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' ) | ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' ) )
            {
            // InternalOCLX.g:1766:2: ( ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' ) | ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==38) ) {
                    alt21=2;
                }
                else if ( (LA21_1==50) ) {
                    alt21=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalOCLX.g:1767:3: ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' )
                    {
                    // InternalOCLX.g:1767:3: ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' )
                    // InternalOCLX.g:1768:4: ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()'
                    {
                    // InternalOCLX.g:1768:4: ( (lv_name_0_0= ruleSimpleName ) )
                    // InternalOCLX.g:1769:5: (lv_name_0_0= ruleSimpleName )
                    {
                    // InternalOCLX.g:1769:5: (lv_name_0_0= ruleSimpleName )
                    // InternalOCLX.g:1770:6: lv_name_0_0= ruleSimpleName
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getNameSimpleNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_26);
                    lv_name_0_0=ruleSimpleName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodCallRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"at.jku.isse.OCLX.SimpleName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,50,FOLLOW_2); 

                    				newLeafNode(otherlv_1, grammarAccess.getMethodCallAccess().getLeftParenthesisRightParenthesisKeyword_0_1());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1793:3: ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' )
                    {
                    // InternalOCLX.g:1793:3: ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' )
                    // InternalOCLX.g:1794:4: ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')'
                    {
                    // InternalOCLX.g:1794:4: ( (lv_name_2_0= ruleSimpleName ) )
                    // InternalOCLX.g:1795:5: (lv_name_2_0= ruleSimpleName )
                    {
                    // InternalOCLX.g:1795:5: (lv_name_2_0= ruleSimpleName )
                    // InternalOCLX.g:1796:6: lv_name_2_0= ruleSimpleName
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getNameSimpleNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_22);
                    lv_name_2_0=ruleSimpleName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodCallRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"at.jku.isse.OCLX.SimpleName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,38,FOLLOW_13); 

                    				newLeafNode(otherlv_3, grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalOCLX.g:1817:4: ( (lv_args_4_0= ruleArgumentsExp ) )
                    // InternalOCLX.g:1818:5: (lv_args_4_0= ruleArgumentsExp )
                    {
                    // InternalOCLX.g:1818:5: (lv_args_4_0= ruleArgumentsExp )
                    // InternalOCLX.g:1819:6: lv_args_4_0= ruleArgumentsExp
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getArgsArgumentsExpParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_21);
                    lv_args_4_0=ruleArgumentsExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodCallRule());
                    						}
                    						set(
                    							current,
                    							"args",
                    							lv_args_4_0,
                    							"at.jku.isse.OCLX.ArgumentsExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,39,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_1_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodCall"


    // $ANTLR start "entryRuleTypeCall"
    // InternalOCLX.g:1845:1: entryRuleTypeCall returns [EObject current=null] : iv_ruleTypeCall= ruleTypeCall EOF ;
    public final EObject entryRuleTypeCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeCall = null;


        try {
            // InternalOCLX.g:1845:49: (iv_ruleTypeCall= ruleTypeCall EOF )
            // InternalOCLX.g:1846:2: iv_ruleTypeCall= ruleTypeCall EOF
            {
             newCompositeNode(grammarAccess.getTypeCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeCall=ruleTypeCall();

            state._fsp--;

             current =iv_ruleTypeCall; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTypeCall"


    // $ANTLR start "ruleTypeCall"
    // InternalOCLX.g:1852:1: ruleTypeCall returns [EObject current=null] : ( ( ( (lv_name_0_1= 'asType' | lv_name_0_2= 'isTypeOf' | lv_name_0_3= 'isKindOf' ) ) ) otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')' ) ;
    public final EObject ruleTypeCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1858:2: ( ( ( ( (lv_name_0_1= 'asType' | lv_name_0_2= 'isTypeOf' | lv_name_0_3= 'isKindOf' ) ) ) otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')' ) )
            // InternalOCLX.g:1859:2: ( ( ( (lv_name_0_1= 'asType' | lv_name_0_2= 'isTypeOf' | lv_name_0_3= 'isKindOf' ) ) ) otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')' )
            {
            // InternalOCLX.g:1859:2: ( ( ( (lv_name_0_1= 'asType' | lv_name_0_2= 'isTypeOf' | lv_name_0_3= 'isKindOf' ) ) ) otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')' )
            // InternalOCLX.g:1860:3: ( ( (lv_name_0_1= 'asType' | lv_name_0_2= 'isTypeOf' | lv_name_0_3= 'isKindOf' ) ) ) otherlv_1= '(' ( (lv_type_2_0= ruleTypeExp ) ) otherlv_3= ')'
            {
            // InternalOCLX.g:1860:3: ( ( (lv_name_0_1= 'asType' | lv_name_0_2= 'isTypeOf' | lv_name_0_3= 'isKindOf' ) ) )
            // InternalOCLX.g:1861:4: ( (lv_name_0_1= 'asType' | lv_name_0_2= 'isTypeOf' | lv_name_0_3= 'isKindOf' ) )
            {
            // InternalOCLX.g:1861:4: ( (lv_name_0_1= 'asType' | lv_name_0_2= 'isTypeOf' | lv_name_0_3= 'isKindOf' ) )
            // InternalOCLX.g:1862:5: (lv_name_0_1= 'asType' | lv_name_0_2= 'isTypeOf' | lv_name_0_3= 'isKindOf' )
            {
            // InternalOCLX.g:1862:5: (lv_name_0_1= 'asType' | lv_name_0_2= 'isTypeOf' | lv_name_0_3= 'isKindOf' )
            int alt22=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt22=1;
                }
                break;
            case 52:
                {
                alt22=2;
                }
                break;
            case 53:
                {
                alt22=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // InternalOCLX.g:1863:6: lv_name_0_1= 'asType'
                    {
                    lv_name_0_1=(Token)match(input,51,FOLLOW_22); 

                    						newLeafNode(lv_name_0_1, grammarAccess.getTypeCallAccess().getNameAsTypeKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeCallRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1874:6: lv_name_0_2= 'isTypeOf'
                    {
                    lv_name_0_2=(Token)match(input,52,FOLLOW_22); 

                    						newLeafNode(lv_name_0_2, grammarAccess.getTypeCallAccess().getNameIsTypeOfKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeCallRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1885:6: lv_name_0_3= 'isKindOf'
                    {
                    lv_name_0_3=(Token)match(input,53,FOLLOW_22); 

                    						newLeafNode(lv_name_0_3, grammarAccess.getTypeCallAccess().getNameIsKindOfKeyword_0_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTypeCallRule());
                    						}
                    						setWithLastConsumed(current, "name", lv_name_0_3, null);
                    					

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_25); 

            			newLeafNode(otherlv_1, grammarAccess.getTypeCallAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:1902:3: ( (lv_type_2_0= ruleTypeExp ) )
            // InternalOCLX.g:1903:4: (lv_type_2_0= ruleTypeExp )
            {
            // InternalOCLX.g:1903:4: (lv_type_2_0= ruleTypeExp )
            // InternalOCLX.g:1904:5: lv_type_2_0= ruleTypeExp
            {

            					newCompositeNode(grammarAccess.getTypeCallAccess().getTypeTypeExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
            lv_type_2_0=ruleTypeExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTypeCallRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"at.jku.isse.OCLX.TypeExp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getTypeCallAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeCall"


    // $ANTLR start "entryRuleTypeExp"
    // InternalOCLX.g:1929:1: entryRuleTypeExp returns [EObject current=null] : iv_ruleTypeExp= ruleTypeExp EOF ;
    public final EObject entryRuleTypeExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExp = null;


        try {
            // InternalOCLX.g:1929:48: (iv_ruleTypeExp= ruleTypeExp EOF )
            // InternalOCLX.g:1930:2: iv_ruleTypeExp= ruleTypeExp EOF
            {
             newCompositeNode(grammarAccess.getTypeExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypeExp=ruleTypeExp();

            state._fsp--;

             current =iv_ruleTypeExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTypeExp"


    // $ANTLR start "ruleTypeExp"
    // InternalOCLX.g:1936:1: ruleTypeExp returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_URI ) ) ) ;
    public final EObject ruleTypeExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:1942:2: ( ( () ( (lv_name_1_0= RULE_URI ) ) ) )
            // InternalOCLX.g:1943:2: ( () ( (lv_name_1_0= RULE_URI ) ) )
            {
            // InternalOCLX.g:1943:2: ( () ( (lv_name_1_0= RULE_URI ) ) )
            // InternalOCLX.g:1944:3: () ( (lv_name_1_0= RULE_URI ) )
            {
            // InternalOCLX.g:1944:3: ()
            // InternalOCLX.g:1945:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTypeExpAccess().getTypeExpAction_0(),
            					current);
            			

            }

            // InternalOCLX.g:1951:3: ( (lv_name_1_0= RULE_URI ) )
            // InternalOCLX.g:1952:4: (lv_name_1_0= RULE_URI )
            {
            // InternalOCLX.g:1952:4: (lv_name_1_0= RULE_URI )
            // InternalOCLX.g:1953:5: lv_name_1_0= RULE_URI
            {
            lv_name_1_0=(Token)match(input,RULE_URI,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTypeExpAccess().getNameURITerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTypeExpRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"at.jku.isse.OCLX.URI");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeExp"


    // $ANTLR start "entryRuleTemporalExp"
    // InternalOCLX.g:1973:1: entryRuleTemporalExp returns [EObject current=null] : iv_ruleTemporalExp= ruleTemporalExp EOF ;
    public final EObject entryRuleTemporalExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalExp = null;


        try {
            // InternalOCLX.g:1973:52: (iv_ruleTemporalExp= ruleTemporalExp EOF )
            // InternalOCLX.g:1974:2: iv_ruleTemporalExp= ruleTemporalExp EOF
            {
             newCompositeNode(grammarAccess.getTemporalExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalExp=ruleTemporalExp();

            state._fsp--;

             current =iv_ruleTemporalExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTemporalExp"


    // $ANTLR start "ruleTemporalExp"
    // InternalOCLX.g:1980:1: ruleTemporalExp returns [EObject current=null] : (this_UnaryTemporalExp_0= ruleUnaryTemporalExp | this_TriggeredTemporalExp_1= ruleTriggeredTemporalExp ) ;
    public final EObject ruleTemporalExp() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryTemporalExp_0 = null;

        EObject this_TriggeredTemporalExp_1 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1986:2: ( (this_UnaryTemporalExp_0= ruleUnaryTemporalExp | this_TriggeredTemporalExp_1= ruleTriggeredTemporalExp ) )
            // InternalOCLX.g:1987:2: (this_UnaryTemporalExp_0= ruleUnaryTemporalExp | this_TriggeredTemporalExp_1= ruleTriggeredTemporalExp )
            {
            // InternalOCLX.g:1987:2: (this_UnaryTemporalExp_0= ruleUnaryTemporalExp | this_TriggeredTemporalExp_1= ruleTriggeredTemporalExp )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=54 && LA23_0<=56)) ) {
                alt23=1;
            }
            else if ( ((LA23_0>=57 && LA23_0<=59)||LA23_0==61||LA23_0==63||(LA23_0>=65 && LA23_0<=66)) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalOCLX.g:1988:3: this_UnaryTemporalExp_0= ruleUnaryTemporalExp
                    {

                    			newCompositeNode(grammarAccess.getTemporalExpAccess().getUnaryTemporalExpParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnaryTemporalExp_0=ruleUnaryTemporalExp();

                    state._fsp--;


                    			current = this_UnaryTemporalExp_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1997:3: this_TriggeredTemporalExp_1= ruleTriggeredTemporalExp
                    {

                    			newCompositeNode(grammarAccess.getTemporalExpAccess().getTriggeredTemporalExpParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TriggeredTemporalExp_1=ruleTriggeredTemporalExp();

                    state._fsp--;


                    			current = this_TriggeredTemporalExp_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalExp"


    // $ANTLR start "entryRuleUnaryTemporalExp"
    // InternalOCLX.g:2009:1: entryRuleUnaryTemporalExp returns [EObject current=null] : iv_ruleUnaryTemporalExp= ruleUnaryTemporalExp EOF ;
    public final EObject entryRuleUnaryTemporalExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryTemporalExp = null;


        try {
            // InternalOCLX.g:2009:57: (iv_ruleUnaryTemporalExp= ruleUnaryTemporalExp EOF )
            // InternalOCLX.g:2010:2: iv_ruleUnaryTemporalExp= ruleUnaryTemporalExp EOF
            {
             newCompositeNode(grammarAccess.getUnaryTemporalExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryTemporalExp=ruleUnaryTemporalExp();

            state._fsp--;

             current =iv_ruleUnaryTemporalExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnaryTemporalExp"


    // $ANTLR start "ruleUnaryTemporalExp"
    // InternalOCLX.g:2016:1: ruleUnaryTemporalExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnaryTemporalOp ) ) otherlv_1= '(' ( (lv_exp_2_0= ruleExp ) ) otherlv_3= ')' ) ;
    public final EObject ruleUnaryTemporalExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2022:2: ( ( ( (lv_name_0_0= ruleUnaryTemporalOp ) ) otherlv_1= '(' ( (lv_exp_2_0= ruleExp ) ) otherlv_3= ')' ) )
            // InternalOCLX.g:2023:2: ( ( (lv_name_0_0= ruleUnaryTemporalOp ) ) otherlv_1= '(' ( (lv_exp_2_0= ruleExp ) ) otherlv_3= ')' )
            {
            // InternalOCLX.g:2023:2: ( ( (lv_name_0_0= ruleUnaryTemporalOp ) ) otherlv_1= '(' ( (lv_exp_2_0= ruleExp ) ) otherlv_3= ')' )
            // InternalOCLX.g:2024:3: ( (lv_name_0_0= ruleUnaryTemporalOp ) ) otherlv_1= '(' ( (lv_exp_2_0= ruleExp ) ) otherlv_3= ')'
            {
            // InternalOCLX.g:2024:3: ( (lv_name_0_0= ruleUnaryTemporalOp ) )
            // InternalOCLX.g:2025:4: (lv_name_0_0= ruleUnaryTemporalOp )
            {
            // InternalOCLX.g:2025:4: (lv_name_0_0= ruleUnaryTemporalOp )
            // InternalOCLX.g:2026:5: lv_name_0_0= ruleUnaryTemporalOp
            {

            					newCompositeNode(grammarAccess.getUnaryTemporalExpAccess().getNameUnaryTemporalOpParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_22);
            lv_name_0_0=ruleUnaryTemporalOp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryTemporalExpRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"at.jku.isse.OCLX.UnaryTemporalOp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getUnaryTemporalExpAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2047:3: ( (lv_exp_2_0= ruleExp ) )
            // InternalOCLX.g:2048:4: (lv_exp_2_0= ruleExp )
            {
            // InternalOCLX.g:2048:4: (lv_exp_2_0= ruleExp )
            // InternalOCLX.g:2049:5: lv_exp_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getUnaryTemporalExpAccess().getExpExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
            lv_exp_2_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryTemporalExpRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getUnaryTemporalExpAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryTemporalExp"


    // $ANTLR start "entryRuleUnaryTemporalOp"
    // InternalOCLX.g:2074:1: entryRuleUnaryTemporalOp returns [String current=null] : iv_ruleUnaryTemporalOp= ruleUnaryTemporalOp EOF ;
    public final String entryRuleUnaryTemporalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryTemporalOp = null;


        try {
            // InternalOCLX.g:2074:55: (iv_ruleUnaryTemporalOp= ruleUnaryTemporalOp EOF )
            // InternalOCLX.g:2075:2: iv_ruleUnaryTemporalOp= ruleUnaryTemporalOp EOF
            {
             newCompositeNode(grammarAccess.getUnaryTemporalOpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryTemporalOp=ruleUnaryTemporalOp();

            state._fsp--;

             current =iv_ruleUnaryTemporalOp.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleUnaryTemporalOp"


    // $ANTLR start "ruleUnaryTemporalOp"
    // InternalOCLX.g:2081:1: ruleUnaryTemporalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'next' | kw= 'always' | kw= 'eventually' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryTemporalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOCLX.g:2087:2: ( (kw= 'next' | kw= 'always' | kw= 'eventually' ) )
            // InternalOCLX.g:2088:2: (kw= 'next' | kw= 'always' | kw= 'eventually' )
            {
            // InternalOCLX.g:2088:2: (kw= 'next' | kw= 'always' | kw= 'eventually' )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt24=1;
                }
                break;
            case 55:
                {
                alt24=2;
                }
                break;
            case 56:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalOCLX.g:2089:3: kw= 'next'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnaryTemporalOpAccess().getNextKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:2095:3: kw= 'always'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnaryTemporalOpAccess().getAlwaysKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:2101:3: kw= 'eventually'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnaryTemporalOpAccess().getEventuallyKeyword_2());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryTemporalOp"


    // $ANTLR start "entryRuleTriggeredTemporalExp"
    // InternalOCLX.g:2110:1: entryRuleTriggeredTemporalExp returns [EObject current=null] : iv_ruleTriggeredTemporalExp= ruleTriggeredTemporalExp EOF ;
    public final EObject entryRuleTriggeredTemporalExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTemporalExp = null;


        try {
            // InternalOCLX.g:2110:61: (iv_ruleTriggeredTemporalExp= ruleTriggeredTemporalExp EOF )
            // InternalOCLX.g:2111:2: iv_ruleTriggeredTemporalExp= ruleTriggeredTemporalExp EOF
            {
             newCompositeNode(grammarAccess.getTriggeredTemporalExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTriggeredTemporalExp=ruleTriggeredTemporalExp();

            state._fsp--;

             current =iv_ruleTriggeredTemporalExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTriggeredTemporalExp"


    // $ANTLR start "ruleTriggeredTemporalExp"
    // InternalOCLX.g:2117:1: ruleTriggeredTemporalExp returns [EObject current=null] : (this_TemporalAsLongAs_0= ruleTemporalAsLongAs | this_TemporalUntil_1= ruleTemporalUntil | this_TemporalEverytime_2= ruleTemporalEverytime | this_TemporalAtLeastOnce_3= ruleTemporalAtLeastOnce | this_LegacyUntil_4= ruleLegacyUntil | this_LegacyAsSoonAs_5= ruleLegacyAsSoonAs | this_LegacyEverytime_6= ruleLegacyEverytime ) ;
    public final EObject ruleTriggeredTemporalExp() throws RecognitionException {
        EObject current = null;

        EObject this_TemporalAsLongAs_0 = null;

        EObject this_TemporalUntil_1 = null;

        EObject this_TemporalEverytime_2 = null;

        EObject this_TemporalAtLeastOnce_3 = null;

        EObject this_LegacyUntil_4 = null;

        EObject this_LegacyAsSoonAs_5 = null;

        EObject this_LegacyEverytime_6 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2123:2: ( (this_TemporalAsLongAs_0= ruleTemporalAsLongAs | this_TemporalUntil_1= ruleTemporalUntil | this_TemporalEverytime_2= ruleTemporalEverytime | this_TemporalAtLeastOnce_3= ruleTemporalAtLeastOnce | this_LegacyUntil_4= ruleLegacyUntil | this_LegacyAsSoonAs_5= ruleLegacyAsSoonAs | this_LegacyEverytime_6= ruleLegacyEverytime ) )
            // InternalOCLX.g:2124:2: (this_TemporalAsLongAs_0= ruleTemporalAsLongAs | this_TemporalUntil_1= ruleTemporalUntil | this_TemporalEverytime_2= ruleTemporalEverytime | this_TemporalAtLeastOnce_3= ruleTemporalAtLeastOnce | this_LegacyUntil_4= ruleLegacyUntil | this_LegacyAsSoonAs_5= ruleLegacyAsSoonAs | this_LegacyEverytime_6= ruleLegacyEverytime )
            {
            // InternalOCLX.g:2124:2: (this_TemporalAsLongAs_0= ruleTemporalAsLongAs | this_TemporalUntil_1= ruleTemporalUntil | this_TemporalEverytime_2= ruleTemporalEverytime | this_TemporalAtLeastOnce_3= ruleTemporalAtLeastOnce | this_LegacyUntil_4= ruleLegacyUntil | this_LegacyAsSoonAs_5= ruleLegacyAsSoonAs | this_LegacyEverytime_6= ruleLegacyEverytime )
            int alt25=7;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt25=1;
                }
                break;
            case 58:
                {
                alt25=2;
                }
                break;
            case 59:
                {
                alt25=3;
                }
                break;
            case 61:
                {
                alt25=4;
                }
                break;
            case 63:
                {
                alt25=5;
                }
                break;
            case 65:
                {
                alt25=6;
                }
                break;
            case 66:
                {
                alt25=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalOCLX.g:2125:3: this_TemporalAsLongAs_0= ruleTemporalAsLongAs
                    {

                    			newCompositeNode(grammarAccess.getTriggeredTemporalExpAccess().getTemporalAsLongAsParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_TemporalAsLongAs_0=ruleTemporalAsLongAs();

                    state._fsp--;


                    			current = this_TemporalAsLongAs_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:2134:3: this_TemporalUntil_1= ruleTemporalUntil
                    {

                    			newCompositeNode(grammarAccess.getTriggeredTemporalExpAccess().getTemporalUntilParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TemporalUntil_1=ruleTemporalUntil();

                    state._fsp--;


                    			current = this_TemporalUntil_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:2143:3: this_TemporalEverytime_2= ruleTemporalEverytime
                    {

                    			newCompositeNode(grammarAccess.getTriggeredTemporalExpAccess().getTemporalEverytimeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_TemporalEverytime_2=ruleTemporalEverytime();

                    state._fsp--;


                    			current = this_TemporalEverytime_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalOCLX.g:2152:3: this_TemporalAtLeastOnce_3= ruleTemporalAtLeastOnce
                    {

                    			newCompositeNode(grammarAccess.getTriggeredTemporalExpAccess().getTemporalAtLeastOnceParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_TemporalAtLeastOnce_3=ruleTemporalAtLeastOnce();

                    state._fsp--;


                    			current = this_TemporalAtLeastOnce_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalOCLX.g:2161:3: this_LegacyUntil_4= ruleLegacyUntil
                    {

                    			newCompositeNode(grammarAccess.getTriggeredTemporalExpAccess().getLegacyUntilParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_LegacyUntil_4=ruleLegacyUntil();

                    state._fsp--;


                    			current = this_LegacyUntil_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalOCLX.g:2170:3: this_LegacyAsSoonAs_5= ruleLegacyAsSoonAs
                    {

                    			newCompositeNode(grammarAccess.getTriggeredTemporalExpAccess().getLegacyAsSoonAsParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_LegacyAsSoonAs_5=ruleLegacyAsSoonAs();

                    state._fsp--;


                    			current = this_LegacyAsSoonAs_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalOCLX.g:2179:3: this_LegacyEverytime_6= ruleLegacyEverytime
                    {

                    			newCompositeNode(grammarAccess.getTriggeredTemporalExpAccess().getLegacyEverytimeParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_LegacyEverytime_6=ruleLegacyEverytime();

                    state._fsp--;


                    			current = this_LegacyEverytime_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTriggeredTemporalExp"


    // $ANTLR start "entryRuleTemporalAsLongAs"
    // InternalOCLX.g:2191:1: entryRuleTemporalAsLongAs returns [EObject current=null] : iv_ruleTemporalAsLongAs= ruleTemporalAsLongAs EOF ;
    public final EObject entryRuleTemporalAsLongAs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalAsLongAs = null;


        try {
            // InternalOCLX.g:2191:57: (iv_ruleTemporalAsLongAs= ruleTemporalAsLongAs EOF )
            // InternalOCLX.g:2192:2: iv_ruleTemporalAsLongAs= ruleTemporalAsLongAs EOF
            {
             newCompositeNode(grammarAccess.getTemporalAsLongAsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalAsLongAs=ruleTemporalAsLongAs();

            state._fsp--;

             current =iv_ruleTemporalAsLongAs; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTemporalAsLongAs"


    // $ANTLR start "ruleTemporalAsLongAs"
    // InternalOCLX.g:2198:1: ruleTemporalAsLongAs returns [EObject current=null] : ( ( (lv_name_0_0= 'asLongAs' ) ) otherlv_1= '(' ( (lv_b_2_0= ruleExp ) ) otherlv_3= 'ensureThat' ( (lv_a_4_0= ruleExp ) ) otherlv_5= ')' ) ;
    public final EObject ruleTemporalAsLongAs() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_b_2_0 = null;

        EObject lv_a_4_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2204:2: ( ( ( (lv_name_0_0= 'asLongAs' ) ) otherlv_1= '(' ( (lv_b_2_0= ruleExp ) ) otherlv_3= 'ensureThat' ( (lv_a_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2205:2: ( ( (lv_name_0_0= 'asLongAs' ) ) otherlv_1= '(' ( (lv_b_2_0= ruleExp ) ) otherlv_3= 'ensureThat' ( (lv_a_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2205:2: ( ( (lv_name_0_0= 'asLongAs' ) ) otherlv_1= '(' ( (lv_b_2_0= ruleExp ) ) otherlv_3= 'ensureThat' ( (lv_a_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2206:3: ( (lv_name_0_0= 'asLongAs' ) ) otherlv_1= '(' ( (lv_b_2_0= ruleExp ) ) otherlv_3= 'ensureThat' ( (lv_a_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2206:3: ( (lv_name_0_0= 'asLongAs' ) )
            // InternalOCLX.g:2207:4: (lv_name_0_0= 'asLongAs' )
            {
            // InternalOCLX.g:2207:4: (lv_name_0_0= 'asLongAs' )
            // InternalOCLX.g:2208:5: lv_name_0_0= 'asLongAs'
            {
            lv_name_0_0=(Token)match(input,57,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemporalAsLongAsRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "asLongAs");
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTemporalAsLongAsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2224:3: ( (lv_b_2_0= ruleExp ) )
            // InternalOCLX.g:2225:4: (lv_b_2_0= ruleExp )
            {
            // InternalOCLX.g:2225:4: (lv_b_2_0= ruleExp )
            // InternalOCLX.g:2226:5: lv_b_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalAsLongAsAccess().getBExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_27);
            lv_b_2_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTemporalAsLongAsRule());
            					}
            					set(
            						current,
            						"b",
            						lv_b_2_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,58,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getTemporalAsLongAsAccess().getEnsureThatKeyword_3());
            		
            // InternalOCLX.g:2247:3: ( (lv_a_4_0= ruleExp ) )
            // InternalOCLX.g:2248:4: (lv_a_4_0= ruleExp )
            {
            // InternalOCLX.g:2248:4: (lv_a_4_0= ruleExp )
            // InternalOCLX.g:2249:5: lv_a_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalAsLongAsAccess().getAExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_a_4_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTemporalAsLongAsRule());
            					}
            					set(
            						current,
            						"a",
            						lv_a_4_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTemporalAsLongAsAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalAsLongAs"


    // $ANTLR start "entryRuleTemporalUntil"
    // InternalOCLX.g:2274:1: entryRuleTemporalUntil returns [EObject current=null] : iv_ruleTemporalUntil= ruleTemporalUntil EOF ;
    public final EObject entryRuleTemporalUntil() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalUntil = null;


        try {
            // InternalOCLX.g:2274:54: (iv_ruleTemporalUntil= ruleTemporalUntil EOF )
            // InternalOCLX.g:2275:2: iv_ruleTemporalUntil= ruleTemporalUntil EOF
            {
             newCompositeNode(grammarAccess.getTemporalUntilRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalUntil=ruleTemporalUntil();

            state._fsp--;

             current =iv_ruleTemporalUntil; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTemporalUntil"


    // $ANTLR start "ruleTemporalUntil"
    // InternalOCLX.g:2281:1: ruleTemporalUntil returns [EObject current=null] : ( ( (lv_name_0_0= 'ensureThat' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'asLongAs' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
    public final EObject ruleTemporalUntil() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_a_2_0 = null;

        EObject lv_b_4_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2287:2: ( ( ( (lv_name_0_0= 'ensureThat' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'asLongAs' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2288:2: ( ( (lv_name_0_0= 'ensureThat' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'asLongAs' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2288:2: ( ( (lv_name_0_0= 'ensureThat' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'asLongAs' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2289:3: ( (lv_name_0_0= 'ensureThat' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'asLongAs' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2289:3: ( (lv_name_0_0= 'ensureThat' ) )
            // InternalOCLX.g:2290:4: (lv_name_0_0= 'ensureThat' )
            {
            // InternalOCLX.g:2290:4: (lv_name_0_0= 'ensureThat' )
            // InternalOCLX.g:2291:5: lv_name_0_0= 'ensureThat'
            {
            lv_name_0_0=(Token)match(input,58,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemporalUntilRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "ensureThat");
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTemporalUntilAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2307:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2308:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2308:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2309:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalUntilAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_28);
            lv_a_2_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTemporalUntilRule());
            					}
            					set(
            						current,
            						"a",
            						lv_a_2_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,57,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getTemporalUntilAccess().getAsLongAsKeyword_3());
            		
            // InternalOCLX.g:2330:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2331:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2331:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2332:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalUntilAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_b_4_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTemporalUntilRule());
            					}
            					set(
            						current,
            						"b",
            						lv_b_4_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTemporalUntilAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalUntil"


    // $ANTLR start "entryRuleTemporalEverytime"
    // InternalOCLX.g:2357:1: entryRuleTemporalEverytime returns [EObject current=null] : iv_ruleTemporalEverytime= ruleTemporalEverytime EOF ;
    public final EObject entryRuleTemporalEverytime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalEverytime = null;


        try {
            // InternalOCLX.g:2357:58: (iv_ruleTemporalEverytime= ruleTemporalEverytime EOF )
            // InternalOCLX.g:2358:2: iv_ruleTemporalEverytime= ruleTemporalEverytime EOF
            {
             newCompositeNode(grammarAccess.getTemporalEverytimeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalEverytime=ruleTemporalEverytime();

            state._fsp--;

             current =iv_ruleTemporalEverytime; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTemporalEverytime"


    // $ANTLR start "ruleTemporalEverytime"
    // InternalOCLX.g:2364:1: ruleTemporalEverytime returns [EObject current=null] : ( ( (lv_name_0_0= 'everyTime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'then' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
    public final EObject ruleTemporalEverytime() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_a_2_0 = null;

        EObject lv_b_4_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2370:2: ( ( ( (lv_name_0_0= 'everyTime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'then' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2371:2: ( ( (lv_name_0_0= 'everyTime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'then' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2371:2: ( ( (lv_name_0_0= 'everyTime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'then' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2372:3: ( (lv_name_0_0= 'everyTime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'then' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2372:3: ( (lv_name_0_0= 'everyTime' ) )
            // InternalOCLX.g:2373:4: (lv_name_0_0= 'everyTime' )
            {
            // InternalOCLX.g:2373:4: (lv_name_0_0= 'everyTime' )
            // InternalOCLX.g:2374:5: lv_name_0_0= 'everyTime'
            {
            lv_name_0_0=(Token)match(input,59,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemporalEverytimeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "everyTime");
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTemporalEverytimeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2390:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2391:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2391:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2392:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalEverytimeAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_29);
            lv_a_2_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTemporalEverytimeRule());
            					}
            					set(
            						current,
            						"a",
            						lv_a_2_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,60,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getTemporalEverytimeAccess().getThenKeyword_3());
            		
            // InternalOCLX.g:2413:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2414:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2414:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2415:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalEverytimeAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_b_4_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTemporalEverytimeRule());
            					}
            					set(
            						current,
            						"b",
            						lv_b_4_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTemporalEverytimeAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalEverytime"


    // $ANTLR start "entryRuleTemporalAtLeastOnce"
    // InternalOCLX.g:2440:1: entryRuleTemporalAtLeastOnce returns [EObject current=null] : iv_ruleTemporalAtLeastOnce= ruleTemporalAtLeastOnce EOF ;
    public final EObject entryRuleTemporalAtLeastOnce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalAtLeastOnce = null;


        try {
            // InternalOCLX.g:2440:60: (iv_ruleTemporalAtLeastOnce= ruleTemporalAtLeastOnce EOF )
            // InternalOCLX.g:2441:2: iv_ruleTemporalAtLeastOnce= ruleTemporalAtLeastOnce EOF
            {
             newCompositeNode(grammarAccess.getTemporalAtLeastOnceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTemporalAtLeastOnce=ruleTemporalAtLeastOnce();

            state._fsp--;

             current =iv_ruleTemporalAtLeastOnce; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleTemporalAtLeastOnce"


    // $ANTLR start "ruleTemporalAtLeastOnce"
    // InternalOCLX.g:2447:1: ruleTemporalAtLeastOnce returns [EObject current=null] : ( ( (lv_name_0_0= 'whenOnce' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'thenAtLeastOnce' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
    public final EObject ruleTemporalAtLeastOnce() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_a_2_0 = null;

        EObject lv_b_4_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2453:2: ( ( ( (lv_name_0_0= 'whenOnce' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'thenAtLeastOnce' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2454:2: ( ( (lv_name_0_0= 'whenOnce' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'thenAtLeastOnce' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2454:2: ( ( (lv_name_0_0= 'whenOnce' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'thenAtLeastOnce' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2455:3: ( (lv_name_0_0= 'whenOnce' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'thenAtLeastOnce' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2455:3: ( (lv_name_0_0= 'whenOnce' ) )
            // InternalOCLX.g:2456:4: (lv_name_0_0= 'whenOnce' )
            {
            // InternalOCLX.g:2456:4: (lv_name_0_0= 'whenOnce' )
            // InternalOCLX.g:2457:5: lv_name_0_0= 'whenOnce'
            {
            lv_name_0_0=(Token)match(input,61,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemporalAtLeastOnceRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "whenOnce");
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTemporalAtLeastOnceAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2473:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2474:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2474:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2475:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalAtLeastOnceAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_30);
            lv_a_2_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTemporalAtLeastOnceRule());
            					}
            					set(
            						current,
            						"a",
            						lv_a_2_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,62,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getTemporalAtLeastOnceAccess().getThenAtLeastOnceKeyword_3());
            		
            // InternalOCLX.g:2496:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2497:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2497:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2498:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalAtLeastOnceAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_b_4_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTemporalAtLeastOnceRule());
            					}
            					set(
            						current,
            						"b",
            						lv_b_4_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getTemporalAtLeastOnceAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemporalAtLeastOnce"


    // $ANTLR start "entryRuleLegacyUntil"
    // InternalOCLX.g:2523:1: entryRuleLegacyUntil returns [EObject current=null] : iv_ruleLegacyUntil= ruleLegacyUntil EOF ;
    public final EObject entryRuleLegacyUntil() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLegacyUntil = null;


        try {
            // InternalOCLX.g:2523:52: (iv_ruleLegacyUntil= ruleLegacyUntil EOF )
            // InternalOCLX.g:2524:2: iv_ruleLegacyUntil= ruleLegacyUntil EOF
            {
             newCompositeNode(grammarAccess.getLegacyUntilRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLegacyUntil=ruleLegacyUntil();

            state._fsp--;

             current =iv_ruleLegacyUntil; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLegacyUntil"


    // $ANTLR start "ruleLegacyUntil"
    // InternalOCLX.g:2530:1: ruleLegacyUntil returns [EObject current=null] : ( ( (lv_name_0_0= 'until' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
    public final EObject ruleLegacyUntil() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_a_2_0 = null;

        EObject lv_b_4_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2536:2: ( ( ( (lv_name_0_0= 'until' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2537:2: ( ( (lv_name_0_0= 'until' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2537:2: ( ( (lv_name_0_0= 'until' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2538:3: ( (lv_name_0_0= 'until' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2538:3: ( (lv_name_0_0= 'until' ) )
            // InternalOCLX.g:2539:4: (lv_name_0_0= 'until' )
            {
            // InternalOCLX.g:2539:4: (lv_name_0_0= 'until' )
            // InternalOCLX.g:2540:5: lv_name_0_0= 'until'
            {
            lv_name_0_0=(Token)match(input,63,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLegacyUntilRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "until");
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getLegacyUntilAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2556:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2557:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2557:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2558:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyUntilAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_31);
            lv_a_2_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLegacyUntilRule());
            					}
            					set(
            						current,
            						"a",
            						lv_a_2_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getLegacyUntilAccess().getCommaKeyword_3());
            		
            // InternalOCLX.g:2579:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2580:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2580:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2581:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyUntilAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_b_4_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLegacyUntilRule());
            					}
            					set(
            						current,
            						"b",
            						lv_b_4_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getLegacyUntilAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLegacyUntil"


    // $ANTLR start "entryRuleLegacyAsSoonAs"
    // InternalOCLX.g:2606:1: entryRuleLegacyAsSoonAs returns [EObject current=null] : iv_ruleLegacyAsSoonAs= ruleLegacyAsSoonAs EOF ;
    public final EObject entryRuleLegacyAsSoonAs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLegacyAsSoonAs = null;


        try {
            // InternalOCLX.g:2606:55: (iv_ruleLegacyAsSoonAs= ruleLegacyAsSoonAs EOF )
            // InternalOCLX.g:2607:2: iv_ruleLegacyAsSoonAs= ruleLegacyAsSoonAs EOF
            {
             newCompositeNode(grammarAccess.getLegacyAsSoonAsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLegacyAsSoonAs=ruleLegacyAsSoonAs();

            state._fsp--;

             current =iv_ruleLegacyAsSoonAs; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLegacyAsSoonAs"


    // $ANTLR start "ruleLegacyAsSoonAs"
    // InternalOCLX.g:2613:1: ruleLegacyAsSoonAs returns [EObject current=null] : ( ( (lv_name_0_0= 'asSoonAs' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
    public final EObject ruleLegacyAsSoonAs() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_a_2_0 = null;

        EObject lv_b_4_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2619:2: ( ( ( (lv_name_0_0= 'asSoonAs' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2620:2: ( ( (lv_name_0_0= 'asSoonAs' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2620:2: ( ( (lv_name_0_0= 'asSoonAs' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2621:3: ( (lv_name_0_0= 'asSoonAs' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2621:3: ( (lv_name_0_0= 'asSoonAs' ) )
            // InternalOCLX.g:2622:4: (lv_name_0_0= 'asSoonAs' )
            {
            // InternalOCLX.g:2622:4: (lv_name_0_0= 'asSoonAs' )
            // InternalOCLX.g:2623:5: lv_name_0_0= 'asSoonAs'
            {
            lv_name_0_0=(Token)match(input,65,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLegacyAsSoonAsRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "asSoonAs");
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getLegacyAsSoonAsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2639:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2640:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2640:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2641:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyAsSoonAsAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_31);
            lv_a_2_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLegacyAsSoonAsRule());
            					}
            					set(
            						current,
            						"a",
            						lv_a_2_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getLegacyAsSoonAsAccess().getCommaKeyword_3());
            		
            // InternalOCLX.g:2662:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2663:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2663:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2664:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyAsSoonAsAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_b_4_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLegacyAsSoonAsRule());
            					}
            					set(
            						current,
            						"b",
            						lv_b_4_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getLegacyAsSoonAsAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLegacyAsSoonAs"


    // $ANTLR start "entryRuleLegacyEverytime"
    // InternalOCLX.g:2689:1: entryRuleLegacyEverytime returns [EObject current=null] : iv_ruleLegacyEverytime= ruleLegacyEverytime EOF ;
    public final EObject entryRuleLegacyEverytime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLegacyEverytime = null;


        try {
            // InternalOCLX.g:2689:56: (iv_ruleLegacyEverytime= ruleLegacyEverytime EOF )
            // InternalOCLX.g:2690:2: iv_ruleLegacyEverytime= ruleLegacyEverytime EOF
            {
             newCompositeNode(grammarAccess.getLegacyEverytimeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLegacyEverytime=ruleLegacyEverytime();

            state._fsp--;

             current =iv_ruleLegacyEverytime; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleLegacyEverytime"


    // $ANTLR start "ruleLegacyEverytime"
    // InternalOCLX.g:2696:1: ruleLegacyEverytime returns [EObject current=null] : ( ( (lv_name_0_0= 'everytime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
    public final EObject ruleLegacyEverytime() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_a_2_0 = null;

        EObject lv_b_4_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2702:2: ( ( ( (lv_name_0_0= 'everytime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2703:2: ( ( (lv_name_0_0= 'everytime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2703:2: ( ( (lv_name_0_0= 'everytime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2704:3: ( (lv_name_0_0= 'everytime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2704:3: ( (lv_name_0_0= 'everytime' ) )
            // InternalOCLX.g:2705:4: (lv_name_0_0= 'everytime' )
            {
            // InternalOCLX.g:2705:4: (lv_name_0_0= 'everytime' )
            // InternalOCLX.g:2706:5: lv_name_0_0= 'everytime'
            {
            lv_name_0_0=(Token)match(input,66,FOLLOW_22); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLegacyEverytimeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "everytime");
            				

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getLegacyEverytimeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2722:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2723:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2723:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2724:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyEverytimeAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_31);
            lv_a_2_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLegacyEverytimeRule());
            					}
            					set(
            						current,
            						"a",
            						lv_a_2_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getLegacyEverytimeAccess().getCommaKeyword_3());
            		
            // InternalOCLX.g:2745:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2746:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2746:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2747:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyEverytimeAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_21);
            lv_b_4_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLegacyEverytimeRule());
            					}
            					set(
            						current,
            						"b",
            						lv_b_4_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getLegacyEverytimeAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLegacyEverytime"


    // $ANTLR start "entryRuleArgumentsExp"
    // InternalOCLX.g:2772:1: entryRuleArgumentsExp returns [EObject current=null] : iv_ruleArgumentsExp= ruleArgumentsExp EOF ;
    public final EObject entryRuleArgumentsExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentsExp = null;


        try {
            // InternalOCLX.g:2772:53: (iv_ruleArgumentsExp= ruleArgumentsExp EOF )
            // InternalOCLX.g:2773:2: iv_ruleArgumentsExp= ruleArgumentsExp EOF
            {
             newCompositeNode(grammarAccess.getArgumentsExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArgumentsExp=ruleArgumentsExp();

            state._fsp--;

             current =iv_ruleArgumentsExp; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleArgumentsExp"


    // $ANTLR start "ruleArgumentsExp"
    // InternalOCLX.g:2779:1: ruleArgumentsExp returns [EObject current=null] : ( ( (lv_operators_0_0= ruleExp ) ) (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )* ) ;
    public final EObject ruleArgumentsExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operators_0_0 = null;

        EObject lv_operators_2_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2785:2: ( ( ( (lv_operators_0_0= ruleExp ) ) (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )* ) )
            // InternalOCLX.g:2786:2: ( ( (lv_operators_0_0= ruleExp ) ) (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )* )
            {
            // InternalOCLX.g:2786:2: ( ( (lv_operators_0_0= ruleExp ) ) (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )* )
            // InternalOCLX.g:2787:3: ( (lv_operators_0_0= ruleExp ) ) (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )*
            {
            // InternalOCLX.g:2787:3: ( (lv_operators_0_0= ruleExp ) )
            // InternalOCLX.g:2788:4: (lv_operators_0_0= ruleExp )
            {
            // InternalOCLX.g:2788:4: (lv_operators_0_0= ruleExp )
            // InternalOCLX.g:2789:5: lv_operators_0_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getArgumentsExpAccess().getOperatorsExpParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_32);
            lv_operators_0_0=ruleExp();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getArgumentsExpRule());
            					}
            					add(
            						current,
            						"operators",
            						lv_operators_0_0,
            						"at.jku.isse.OCLX.Exp");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalOCLX.g:2806:3: (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==64) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalOCLX.g:2807:4: otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) )
            	    {
            	    otherlv_1=(Token)match(input,64,FOLLOW_13); 

            	    				newLeafNode(otherlv_1, grammarAccess.getArgumentsExpAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOCLX.g:2811:4: ( (lv_operators_2_0= ruleExp ) )
            	    // InternalOCLX.g:2812:5: (lv_operators_2_0= ruleExp )
            	    {
            	    // InternalOCLX.g:2812:5: (lv_operators_2_0= ruleExp )
            	    // InternalOCLX.g:2813:6: lv_operators_2_0= ruleExp
            	    {

            	    						newCompositeNode(grammarAccess.getArgumentsExpAccess().getOperatorsExpParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_32);
            	    lv_operators_2_0=ruleExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getArgumentsExpRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operators",
            	    							lv_operators_2_0,
            	    							"at.jku.isse.OCLX.Exp");
            	    						afterParserOrEnumRuleCall();
            	    					

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


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgumentsExp"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000058000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000060000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0xAFC00768000000D0L,0x0000000000000006L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000FFFC00002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000001000200002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0039F00000000010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});

}