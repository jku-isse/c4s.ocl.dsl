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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_DESCRIPTION", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'rule'", "'{'", "'description:'", "'is'", "'overrulable:'", "'context:'", "'expression:'", "'}'", "'.'", "'>'", "'<'", "'>='", "'<='", "'='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'*'", "'/'", "'+'", "'-'", "'->'", "'not'", "'('", "')'", "'self'", "'true'", "'false'", "'null'", "'|'", "'FORALL'", "'EXISTS'", "'COLLECT'", "'REJECT'", "'SELECT'", "':'", "'()'", "'SET'", "'LIST'", "'MAP'", "'COLLECTION'", "'next'", "'always'", "'eventually'", "'asLongAs'", "'ensureThat'", "'everyTime'", "'then'", "'whenOnce'", "'thenAtLeastOnce'", "'until'", "','", "'asSoonAs'", "'everytime'"
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
    public static final int T__25=25;
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

                if ( (LA1_0==12) ) {
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
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getConstraintAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalOCLX.g:141:3: (otherlv_3= 'description:' ( (lv_description_4_0= RULE_DESCRIPTION ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==14) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalOCLX.g:142:4: otherlv_3= 'description:' ( (lv_description_4_0= RULE_DESCRIPTION ) )
                    {
                    otherlv_3=(Token)match(input,14,FOLLOW_7); 

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

            if ( (LA3_0==15) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalOCLX.g:166:4: otherlv_5= 'is' otherlv_6= 'overrulable:' ( (lv_overrulable_7_0= ruleBooleanLiteralExp ) )
                    {
                    otherlv_5=(Token)match(input,15,FOLLOW_9); 

                    				newLeafNode(otherlv_5, grammarAccess.getConstraintAccess().getIsKeyword_4_0());
                    			
                    otherlv_6=(Token)match(input,16,FOLLOW_10); 

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

            otherlv_8=(Token)match(input,17,FOLLOW_4); 

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

            otherlv_10=(Token)match(input,18,FOLLOW_13); 

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

            otherlv_12=(Token)match(input,19,FOLLOW_2); 

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

                if ( (LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalOCLX.g:271:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,20,FOLLOW_4); 

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


    // $ANTLR start "entryRuleContext"
    // InternalOCLX.g:312:1: entryRuleContext returns [EObject current=null] : iv_ruleContext= ruleContext EOF ;
    public final EObject entryRuleContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContext = null;


        try {
            // InternalOCLX.g:312:48: (iv_ruleContext= ruleContext EOF )
            // InternalOCLX.g:313:2: iv_ruleContext= ruleContext EOF
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
    // InternalOCLX.g:319:1: ruleContext returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleContext() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:325:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // InternalOCLX.g:326:2: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // InternalOCLX.g:326:2: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalOCLX.g:327:3: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalOCLX.g:327:3: (lv_name_0_0= ruleQualifiedName )
            // InternalOCLX.g:328:4: lv_name_0_0= ruleQualifiedName
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
    // InternalOCLX.g:348:1: entryRuleExp returns [EObject current=null] : iv_ruleExp= ruleExp EOF ;
    public final EObject entryRuleExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExp = null;


        try {
            // InternalOCLX.g:348:44: (iv_ruleExp= ruleExp EOF )
            // InternalOCLX.g:349:2: iv_ruleExp= ruleExp EOF
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
    // InternalOCLX.g:355:1: ruleExp returns [EObject current=null] : (this_PrefixedExp_0= rulePrefixedExp ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )? ) ;
    public final EObject ruleExp() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedExp_0 = null;

        EObject lv_operators_2_0 = null;

        EObject lv_expressions_3_0 = null;

        EObject lv_operators_4_0 = null;

        EObject lv_expressions_5_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:361:2: ( (this_PrefixedExp_0= rulePrefixedExp ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )? ) )
            // InternalOCLX.g:362:2: (this_PrefixedExp_0= rulePrefixedExp ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )? )
            {
            // InternalOCLX.g:362:2: (this_PrefixedExp_0= rulePrefixedExp ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )? )
            // InternalOCLX.g:363:3: this_PrefixedExp_0= rulePrefixedExp ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )?
            {

            			newCompositeNode(grammarAccess.getExpAccess().getPrefixedExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_16);
            this_PrefixedExp_0=rulePrefixedExp();

            state._fsp--;


            			current = this_PrefixedExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalOCLX.g:371:3: ( () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=21 && LA6_0<=34)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalOCLX.g:372:4: () ( (lv_operators_2_0= ruleBinaryOperator ) ) ( (lv_expressions_3_0= rulePrefixedExp ) ) ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )*
                    {
                    // InternalOCLX.g:372:4: ()
                    // InternalOCLX.g:373:5: 
                    {

                    					current = forceCreateModelElementAndAdd(
                    						grammarAccess.getExpAccess().getInfixExpExpressionsAction_1_0(),
                    						current);
                    				

                    }

                    // InternalOCLX.g:379:4: ( (lv_operators_2_0= ruleBinaryOperator ) )
                    // InternalOCLX.g:380:5: (lv_operators_2_0= ruleBinaryOperator )
                    {
                    // InternalOCLX.g:380:5: (lv_operators_2_0= ruleBinaryOperator )
                    // InternalOCLX.g:381:6: lv_operators_2_0= ruleBinaryOperator
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

                    // InternalOCLX.g:398:4: ( (lv_expressions_3_0= rulePrefixedExp ) )
                    // InternalOCLX.g:399:5: (lv_expressions_3_0= rulePrefixedExp )
                    {
                    // InternalOCLX.g:399:5: (lv_expressions_3_0= rulePrefixedExp )
                    // InternalOCLX.g:400:6: lv_expressions_3_0= rulePrefixedExp
                    {

                    						newCompositeNode(grammarAccess.getExpAccess().getExpressionsPrefixedExpParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_16);
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

                    // InternalOCLX.g:417:4: ( ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=21 && LA5_0<=34)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalOCLX.g:418:5: ( (lv_operators_4_0= ruleBinaryOperator ) ) ( (lv_expressions_5_0= rulePrefixedExp ) )
                    	    {
                    	    // InternalOCLX.g:418:5: ( (lv_operators_4_0= ruleBinaryOperator ) )
                    	    // InternalOCLX.g:419:6: (lv_operators_4_0= ruleBinaryOperator )
                    	    {
                    	    // InternalOCLX.g:419:6: (lv_operators_4_0= ruleBinaryOperator )
                    	    // InternalOCLX.g:420:7: lv_operators_4_0= ruleBinaryOperator
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

                    	    // InternalOCLX.g:437:5: ( (lv_expressions_5_0= rulePrefixedExp ) )
                    	    // InternalOCLX.g:438:6: (lv_expressions_5_0= rulePrefixedExp )
                    	    {
                    	    // InternalOCLX.g:438:6: (lv_expressions_5_0= rulePrefixedExp )
                    	    // InternalOCLX.g:439:7: lv_expressions_5_0= rulePrefixedExp
                    	    {

                    	    							newCompositeNode(grammarAccess.getExpAccess().getExpressionsPrefixedExpParserRuleCall_1_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_16);
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
    // InternalOCLX.g:462:1: entryRulePrefixedExp returns [EObject current=null] : iv_rulePrefixedExp= rulePrefixedExp EOF ;
    public final EObject entryRulePrefixedExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExp = null;


        try {
            // InternalOCLX.g:462:52: (iv_rulePrefixedExp= rulePrefixedExp EOF )
            // InternalOCLX.g:463:2: iv_rulePrefixedExp= rulePrefixedExp EOF
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
    // InternalOCLX.g:469:1: rulePrefixedExp returns [EObject current=null] : ( ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) ) | this_PrimaryExp_3= rulePrimaryExp ) ;
    public final EObject rulePrefixedExp() throws RecognitionException {
        EObject current = null;

        EObject lv_operator_1_0 = null;

        EObject lv_expression_2_0 = null;

        EObject this_PrimaryExp_3 = null;



        	enterRule();

        try {
            // InternalOCLX.g:475:2: ( ( ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) ) | this_PrimaryExp_3= rulePrimaryExp ) )
            // InternalOCLX.g:476:2: ( ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) ) | this_PrimaryExp_3= rulePrimaryExp )
            {
            // InternalOCLX.g:476:2: ( ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) ) | this_PrimaryExp_3= rulePrimaryExp )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==34||LA7_0==36) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID||(LA7_0>=RULE_INT && LA7_0<=RULE_STRING)||LA7_0==37||(LA7_0>=39 && LA7_0<=42)||(LA7_0>=55 && LA7_0<=60)||LA7_0==62||LA7_0==64||(LA7_0>=66 && LA7_0<=67)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalOCLX.g:477:3: ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) )
                    {
                    // InternalOCLX.g:477:3: ( () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) ) )
                    // InternalOCLX.g:478:4: () ( (lv_operator_1_0= ruleUnaryOperator ) ) ( (lv_expression_2_0= rulePrimaryExp ) )
                    {
                    // InternalOCLX.g:478:4: ()
                    // InternalOCLX.g:479:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPrefixedExpAccess().getPrefixExpAction_0_0(),
                    						current);
                    				

                    }

                    // InternalOCLX.g:485:4: ( (lv_operator_1_0= ruleUnaryOperator ) )
                    // InternalOCLX.g:486:5: (lv_operator_1_0= ruleUnaryOperator )
                    {
                    // InternalOCLX.g:486:5: (lv_operator_1_0= ruleUnaryOperator )
                    // InternalOCLX.g:487:6: lv_operator_1_0= ruleUnaryOperator
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

                    // InternalOCLX.g:504:4: ( (lv_expression_2_0= rulePrimaryExp ) )
                    // InternalOCLX.g:505:5: (lv_expression_2_0= rulePrimaryExp )
                    {
                    // InternalOCLX.g:505:5: (lv_expression_2_0= rulePrimaryExp )
                    // InternalOCLX.g:506:6: lv_expression_2_0= rulePrimaryExp
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
                    // InternalOCLX.g:525:3: this_PrimaryExp_3= rulePrimaryExp
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
    // InternalOCLX.g:537:1: entryRuleBinaryOperator returns [EObject current=null] : iv_ruleBinaryOperator= ruleBinaryOperator EOF ;
    public final EObject entryRuleBinaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperator = null;


        try {
            // InternalOCLX.g:537:55: (iv_ruleBinaryOperator= ruleBinaryOperator EOF )
            // InternalOCLX.g:538:2: iv_ruleBinaryOperator= ruleBinaryOperator EOF
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
    // InternalOCLX.g:544:1: ruleBinaryOperator returns [EObject current=null] : this_InfixOperator_0= ruleInfixOperator ;
    public final EObject ruleBinaryOperator() throws RecognitionException {
        EObject current = null;

        EObject this_InfixOperator_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:550:2: (this_InfixOperator_0= ruleInfixOperator )
            // InternalOCLX.g:551:2: this_InfixOperator_0= ruleInfixOperator
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
    // InternalOCLX.g:562:1: entryRuleInfixOperator returns [EObject current=null] : iv_ruleInfixOperator= ruleInfixOperator EOF ;
    public final EObject entryRuleInfixOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOperator = null;


        try {
            // InternalOCLX.g:562:54: (iv_ruleInfixOperator= ruleInfixOperator EOF )
            // InternalOCLX.g:563:2: iv_ruleInfixOperator= ruleInfixOperator EOF
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
    // InternalOCLX.g:569:1: ruleInfixOperator returns [EObject current=null] : (this_BooleanOperator_0= ruleBooleanOperator | this_MathOperator_1= ruleMathOperator ) ;
    public final EObject ruleInfixOperator() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanOperator_0 = null;

        EObject this_MathOperator_1 = null;



        	enterRule();

        try {
            // InternalOCLX.g:575:2: ( (this_BooleanOperator_0= ruleBooleanOperator | this_MathOperator_1= ruleMathOperator ) )
            // InternalOCLX.g:576:2: (this_BooleanOperator_0= ruleBooleanOperator | this_MathOperator_1= ruleMathOperator )
            {
            // InternalOCLX.g:576:2: (this_BooleanOperator_0= ruleBooleanOperator | this_MathOperator_1= ruleMathOperator )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=21 && LA8_0<=30)) ) {
                alt8=1;
            }
            else if ( ((LA8_0>=31 && LA8_0<=34)) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalOCLX.g:577:3: this_BooleanOperator_0= ruleBooleanOperator
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
                    // InternalOCLX.g:586:3: this_MathOperator_1= ruleMathOperator
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
    // InternalOCLX.g:598:1: entryRuleBooleanOperator returns [EObject current=null] : iv_ruleBooleanOperator= ruleBooleanOperator EOF ;
    public final EObject entryRuleBooleanOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanOperator = null;


        try {
            // InternalOCLX.g:598:56: (iv_ruleBooleanOperator= ruleBooleanOperator EOF )
            // InternalOCLX.g:599:2: iv_ruleBooleanOperator= ruleBooleanOperator EOF
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
    // InternalOCLX.g:605:1: ruleBooleanOperator returns [EObject current=null] : ( ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '<>' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) ) ) ;
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
            // InternalOCLX.g:611:2: ( ( ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '<>' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) ) ) )
            // InternalOCLX.g:612:2: ( ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '<>' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) ) )
            {
            // InternalOCLX.g:612:2: ( ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '<>' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) ) )
            // InternalOCLX.g:613:3: ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '<>' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) )
            {
            // InternalOCLX.g:613:3: ( (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '<>' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' ) )
            // InternalOCLX.g:614:4: (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '<>' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' )
            {
            // InternalOCLX.g:614:4: (lv_op_0_1= '>' | lv_op_0_2= '<' | lv_op_0_3= '>=' | lv_op_0_4= '<=' | lv_op_0_5= '=' | lv_op_0_6= '<>' | lv_op_0_7= 'and' | lv_op_0_8= 'or' | lv_op_0_9= 'xor' | lv_op_0_10= 'implies' )
            int alt9=10;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt9=1;
                }
                break;
            case 22:
                {
                alt9=2;
                }
                break;
            case 23:
                {
                alt9=3;
                }
                break;
            case 24:
                {
                alt9=4;
                }
                break;
            case 25:
                {
                alt9=5;
                }
                break;
            case 26:
                {
                alt9=6;
                }
                break;
            case 27:
                {
                alt9=7;
                }
                break;
            case 28:
                {
                alt9=8;
                }
                break;
            case 29:
                {
                alt9=9;
                }
                break;
            case 30:
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
                    // InternalOCLX.g:615:5: lv_op_0_1= '>'
                    {
                    lv_op_0_1=(Token)match(input,21,FOLLOW_2); 

                    					newLeafNode(lv_op_0_1, grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:626:5: lv_op_0_2= '<'
                    {
                    lv_op_0_2=(Token)match(input,22,FOLLOW_2); 

                    					newLeafNode(lv_op_0_2, grammarAccess.getBooleanOperatorAccess().getOpLessThanSignKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:637:5: lv_op_0_3= '>='
                    {
                    lv_op_0_3=(Token)match(input,23,FOLLOW_2); 

                    					newLeafNode(lv_op_0_3, grammarAccess.getBooleanOperatorAccess().getOpGreaterThanSignEqualsSignKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalOCLX.g:648:5: lv_op_0_4= '<='
                    {
                    lv_op_0_4=(Token)match(input,24,FOLLOW_2); 

                    					newLeafNode(lv_op_0_4, grammarAccess.getBooleanOperatorAccess().getOpLessThanSignEqualsSignKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalOCLX.g:659:5: lv_op_0_5= '='
                    {
                    lv_op_0_5=(Token)match(input,25,FOLLOW_2); 

                    					newLeafNode(lv_op_0_5, grammarAccess.getBooleanOperatorAccess().getOpEqualsSignKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_5, null);
                    				

                    }
                    break;
                case 6 :
                    // InternalOCLX.g:670:5: lv_op_0_6= '<>'
                    {
                    lv_op_0_6=(Token)match(input,26,FOLLOW_2); 

                    					newLeafNode(lv_op_0_6, grammarAccess.getBooleanOperatorAccess().getOpLessThanSignGreaterThanSignKeyword_0_5());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_6, null);
                    				

                    }
                    break;
                case 7 :
                    // InternalOCLX.g:681:5: lv_op_0_7= 'and'
                    {
                    lv_op_0_7=(Token)match(input,27,FOLLOW_2); 

                    					newLeafNode(lv_op_0_7, grammarAccess.getBooleanOperatorAccess().getOpAndKeyword_0_6());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_7, null);
                    				

                    }
                    break;
                case 8 :
                    // InternalOCLX.g:692:5: lv_op_0_8= 'or'
                    {
                    lv_op_0_8=(Token)match(input,28,FOLLOW_2); 

                    					newLeafNode(lv_op_0_8, grammarAccess.getBooleanOperatorAccess().getOpOrKeyword_0_7());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_8, null);
                    				

                    }
                    break;
                case 9 :
                    // InternalOCLX.g:703:5: lv_op_0_9= 'xor'
                    {
                    lv_op_0_9=(Token)match(input,29,FOLLOW_2); 

                    					newLeafNode(lv_op_0_9, grammarAccess.getBooleanOperatorAccess().getOpXorKeyword_0_8());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_9, null);
                    				

                    }
                    break;
                case 10 :
                    // InternalOCLX.g:714:5: lv_op_0_10= 'implies'
                    {
                    lv_op_0_10=(Token)match(input,30,FOLLOW_2); 

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
    // InternalOCLX.g:730:1: entryRuleMathOperator returns [EObject current=null] : iv_ruleMathOperator= ruleMathOperator EOF ;
    public final EObject entryRuleMathOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMathOperator = null;


        try {
            // InternalOCLX.g:730:53: (iv_ruleMathOperator= ruleMathOperator EOF )
            // InternalOCLX.g:731:2: iv_ruleMathOperator= ruleMathOperator EOF
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
    // InternalOCLX.g:737:1: ruleMathOperator returns [EObject current=null] : ( ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) ) ) ;
    public final EObject ruleMathOperator() throws RecognitionException {
        EObject current = null;

        Token lv_op_0_1=null;
        Token lv_op_0_2=null;
        Token lv_op_0_3=null;
        Token lv_op_0_4=null;


        	enterRule();

        try {
            // InternalOCLX.g:743:2: ( ( ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) ) ) )
            // InternalOCLX.g:744:2: ( ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) ) )
            {
            // InternalOCLX.g:744:2: ( ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) ) )
            // InternalOCLX.g:745:3: ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) )
            {
            // InternalOCLX.g:745:3: ( (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' ) )
            // InternalOCLX.g:746:4: (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' )
            {
            // InternalOCLX.g:746:4: (lv_op_0_1= '*' | lv_op_0_2= '/' | lv_op_0_3= '+' | lv_op_0_4= '-' )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt10=1;
                }
                break;
            case 32:
                {
                alt10=2;
                }
                break;
            case 33:
                {
                alt10=3;
                }
                break;
            case 34:
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
                    // InternalOCLX.g:747:5: lv_op_0_1= '*'
                    {
                    lv_op_0_1=(Token)match(input,31,FOLLOW_2); 

                    					newLeafNode(lv_op_0_1, grammarAccess.getMathOperatorAccess().getOpAsteriskKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMathOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:758:5: lv_op_0_2= '/'
                    {
                    lv_op_0_2=(Token)match(input,32,FOLLOW_2); 

                    					newLeafNode(lv_op_0_2, grammarAccess.getMathOperatorAccess().getOpSolidusKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMathOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:769:5: lv_op_0_3= '+'
                    {
                    lv_op_0_3=(Token)match(input,33,FOLLOW_2); 

                    					newLeafNode(lv_op_0_3, grammarAccess.getMathOperatorAccess().getOpPlusSignKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMathOperatorRule());
                    					}
                    					setWithLastConsumed(current, "op", lv_op_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalOCLX.g:780:5: lv_op_0_4= '-'
                    {
                    lv_op_0_4=(Token)match(input,34,FOLLOW_2); 

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
    // InternalOCLX.g:796:1: entryRuleNavigationOperator returns [EObject current=null] : iv_ruleNavigationOperator= ruleNavigationOperator EOF ;
    public final EObject entryRuleNavigationOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperator = null;


        try {
            // InternalOCLX.g:796:59: (iv_ruleNavigationOperator= ruleNavigationOperator EOF )
            // InternalOCLX.g:797:2: iv_ruleNavigationOperator= ruleNavigationOperator EOF
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
    // InternalOCLX.g:803:1: ruleNavigationOperator returns [EObject current=null] : ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) ;
    public final EObject ruleNavigationOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;


        	enterRule();

        try {
            // InternalOCLX.g:809:2: ( ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) )
            // InternalOCLX.g:810:2: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            {
            // InternalOCLX.g:810:2: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            // InternalOCLX.g:811:3: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            {
            // InternalOCLX.g:811:3: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            // InternalOCLX.g:812:4: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            {
            // InternalOCLX.g:812:4: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            else if ( (LA11_0==35) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalOCLX.g:813:5: lv_name_0_1= '.'
                    {
                    lv_name_0_1=(Token)match(input,20,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getNavigationOperatorAccess().getNameFullStopKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getNavigationOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:824:5: lv_name_0_2= '->'
                    {
                    lv_name_0_2=(Token)match(input,35,FOLLOW_2); 

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
    // InternalOCLX.g:840:1: entryRuleUnaryOperator returns [EObject current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final EObject entryRuleUnaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOperator = null;


        try {
            // InternalOCLX.g:840:54: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalOCLX.g:841:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
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
    // InternalOCLX.g:847:1: ruleUnaryOperator returns [EObject current=null] : ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) ;
    public final EObject ruleUnaryOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;


        	enterRule();

        try {
            // InternalOCLX.g:853:2: ( ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) )
            // InternalOCLX.g:854:2: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            {
            // InternalOCLX.g:854:2: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            // InternalOCLX.g:855:3: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            {
            // InternalOCLX.g:855:3: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            // InternalOCLX.g:856:4: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            {
            // InternalOCLX.g:856:4: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==34) ) {
                alt12=1;
            }
            else if ( (LA12_0==36) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalOCLX.g:857:5: lv_name_0_1= '-'
                    {
                    lv_name_0_1=(Token)match(input,34,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getUnaryOperatorAccess().getNameHyphenMinusKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUnaryOperatorRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:868:5: lv_name_0_2= 'not'
                    {
                    lv_name_0_2=(Token)match(input,36,FOLLOW_2); 

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
    // InternalOCLX.g:884:1: entryRulePrimaryExp returns [EObject current=null] : iv_rulePrimaryExp= rulePrimaryExp EOF ;
    public final EObject entryRulePrimaryExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExp = null;


        try {
            // InternalOCLX.g:884:51: (iv_rulePrimaryExp= rulePrimaryExp EOF )
            // InternalOCLX.g:885:2: iv_rulePrimaryExp= rulePrimaryExp EOF
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
    // InternalOCLX.g:891:1: rulePrimaryExp returns [EObject current=null] : (this_NestedExp_0= ruleNestedExp | (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* ) | this_PrimitiveLiteralExp_4= rulePrimitiveLiteralExp | this_TemporalExp_5= ruleTemporalExp ) ;
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
            // InternalOCLX.g:897:2: ( (this_NestedExp_0= ruleNestedExp | (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* ) | this_PrimitiveLiteralExp_4= rulePrimitiveLiteralExp | this_TemporalExp_5= ruleTemporalExp ) )
            // InternalOCLX.g:898:2: (this_NestedExp_0= ruleNestedExp | (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* ) | this_PrimitiveLiteralExp_4= rulePrimitiveLiteralExp | this_TemporalExp_5= ruleTemporalExp )
            {
            // InternalOCLX.g:898:2: (this_NestedExp_0= ruleNestedExp | (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* ) | this_PrimitiveLiteralExp_4= rulePrimitiveLiteralExp | this_TemporalExp_5= ruleTemporalExp )
            int alt14=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt14=1;
                }
                break;
            case RULE_ID:
            case 39:
                {
                alt14=2;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 40:
            case 41:
            case 42:
                {
                alt14=3;
                }
                break;
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 62:
            case 64:
            case 66:
            case 67:
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
                    // InternalOCLX.g:899:3: this_NestedExp_0= ruleNestedExp
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
                    // InternalOCLX.g:908:3: (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* )
                    {
                    // InternalOCLX.g:908:3: (this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )* )
                    // InternalOCLX.g:909:4: this_VarOrSelfExp_1= ruleVarOrSelfExp ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )*
                    {

                    				newCompositeNode(grammarAccess.getPrimaryExpAccess().getVarOrSelfExpParserRuleCall_1_0());
                    			
                    pushFollow(FOLLOW_17);
                    this_VarOrSelfExp_1=ruleVarOrSelfExp();

                    state._fsp--;


                    				current = this_VarOrSelfExp_1;
                    				afterParserOrEnumRuleCall();
                    			
                    // InternalOCLX.g:917:4: ( ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==20||LA13_0==35) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalOCLX.g:918:5: ( (lv_nav_2_0= ruleNavigationOperator ) ) ( (lv_methods_3_0= ruleMethodExp ) )
                    	    {
                    	    // InternalOCLX.g:918:5: ( (lv_nav_2_0= ruleNavigationOperator ) )
                    	    // InternalOCLX.g:919:6: (lv_nav_2_0= ruleNavigationOperator )
                    	    {
                    	    // InternalOCLX.g:919:6: (lv_nav_2_0= ruleNavigationOperator )
                    	    // InternalOCLX.g:920:7: lv_nav_2_0= ruleNavigationOperator
                    	    {

                    	    							newCompositeNode(grammarAccess.getPrimaryExpAccess().getNavNavigationOperatorParserRuleCall_1_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_18);
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

                    	    // InternalOCLX.g:937:5: ( (lv_methods_3_0= ruleMethodExp ) )
                    	    // InternalOCLX.g:938:6: (lv_methods_3_0= ruleMethodExp )
                    	    {
                    	    // InternalOCLX.g:938:6: (lv_methods_3_0= ruleMethodExp )
                    	    // InternalOCLX.g:939:7: lv_methods_3_0= ruleMethodExp
                    	    {

                    	    							newCompositeNode(grammarAccess.getPrimaryExpAccess().getMethodsMethodExpParserRuleCall_1_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_17);
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
                    // InternalOCLX.g:959:3: this_PrimitiveLiteralExp_4= rulePrimitiveLiteralExp
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
                    // InternalOCLX.g:968:3: this_TemporalExp_5= ruleTemporalExp
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
    // InternalOCLX.g:980:1: entryRuleNestedExp returns [EObject current=null] : iv_ruleNestedExp= ruleNestedExp EOF ;
    public final EObject entryRuleNestedExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExp = null;


        try {
            // InternalOCLX.g:980:50: (iv_ruleNestedExp= ruleNestedExp EOF )
            // InternalOCLX.g:981:2: iv_ruleNestedExp= ruleNestedExp EOF
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
    // InternalOCLX.g:987:1: ruleNestedExp returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleExp ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_source_1_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:993:2: ( (otherlv_0= '(' ( (lv_source_1_0= ruleExp ) ) otherlv_2= ')' ) )
            // InternalOCLX.g:994:2: (otherlv_0= '(' ( (lv_source_1_0= ruleExp ) ) otherlv_2= ')' )
            {
            // InternalOCLX.g:994:2: (otherlv_0= '(' ( (lv_source_1_0= ruleExp ) ) otherlv_2= ')' )
            // InternalOCLX.g:995:3: otherlv_0= '(' ( (lv_source_1_0= ruleExp ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getNestedExpAccess().getLeftParenthesisKeyword_0());
            		
            // InternalOCLX.g:999:3: ( (lv_source_1_0= ruleExp ) )
            // InternalOCLX.g:1000:4: (lv_source_1_0= ruleExp )
            {
            // InternalOCLX.g:1000:4: (lv_source_1_0= ruleExp )
            // InternalOCLX.g:1001:5: lv_source_1_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getNestedExpAccess().getSourceExpParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_2=(Token)match(input,38,FOLLOW_2); 

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
    // InternalOCLX.g:1026:1: entryRuleVarOrSelfExp returns [EObject current=null] : iv_ruleVarOrSelfExp= ruleVarOrSelfExp EOF ;
    public final EObject entryRuleVarOrSelfExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarOrSelfExp = null;


        try {
            // InternalOCLX.g:1026:53: (iv_ruleVarOrSelfExp= ruleVarOrSelfExp EOF )
            // InternalOCLX.g:1027:2: iv_ruleVarOrSelfExp= ruleVarOrSelfExp EOF
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
    // InternalOCLX.g:1033:1: ruleVarOrSelfExp returns [EObject current=null] : (this_SelfExp_0= ruleSelfExp | this_VarReference_1= ruleVarReference ) ;
    public final EObject ruleVarOrSelfExp() throws RecognitionException {
        EObject current = null;

        EObject this_SelfExp_0 = null;

        EObject this_VarReference_1 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1039:2: ( (this_SelfExp_0= ruleSelfExp | this_VarReference_1= ruleVarReference ) )
            // InternalOCLX.g:1040:2: (this_SelfExp_0= ruleSelfExp | this_VarReference_1= ruleVarReference )
            {
            // InternalOCLX.g:1040:2: (this_SelfExp_0= ruleSelfExp | this_VarReference_1= ruleVarReference )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==39) ) {
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
                    // InternalOCLX.g:1041:3: this_SelfExp_0= ruleSelfExp
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
                    // InternalOCLX.g:1050:3: this_VarReference_1= ruleVarReference
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
    // InternalOCLX.g:1062:1: entryRuleSelfExp returns [EObject current=null] : iv_ruleSelfExp= ruleSelfExp EOF ;
    public final EObject entryRuleSelfExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExp = null;


        try {
            // InternalOCLX.g:1062:48: (iv_ruleSelfExp= ruleSelfExp EOF )
            // InternalOCLX.g:1063:2: iv_ruleSelfExp= ruleSelfExp EOF
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
    // InternalOCLX.g:1069:1: ruleSelfExp returns [EObject current=null] : ( () ( (lv_name_1_0= 'self' ) ) ) ;
    public final EObject ruleSelfExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:1075:2: ( ( () ( (lv_name_1_0= 'self' ) ) ) )
            // InternalOCLX.g:1076:2: ( () ( (lv_name_1_0= 'self' ) ) )
            {
            // InternalOCLX.g:1076:2: ( () ( (lv_name_1_0= 'self' ) ) )
            // InternalOCLX.g:1077:3: () ( (lv_name_1_0= 'self' ) )
            {
            // InternalOCLX.g:1077:3: ()
            // InternalOCLX.g:1078:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSelfExpAccess().getSelfExpAction_0(),
            					current);
            			

            }

            // InternalOCLX.g:1084:3: ( (lv_name_1_0= 'self' ) )
            // InternalOCLX.g:1085:4: (lv_name_1_0= 'self' )
            {
            // InternalOCLX.g:1085:4: (lv_name_1_0= 'self' )
            // InternalOCLX.g:1086:5: lv_name_1_0= 'self'
            {
            lv_name_1_0=(Token)match(input,39,FOLLOW_2); 

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
    // InternalOCLX.g:1102:1: entryRuleVarDeclaration returns [EObject current=null] : iv_ruleVarDeclaration= ruleVarDeclaration EOF ;
    public final EObject entryRuleVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarDeclaration = null;


        try {
            // InternalOCLX.g:1102:55: (iv_ruleVarDeclaration= ruleVarDeclaration EOF )
            // InternalOCLX.g:1103:2: iv_ruleVarDeclaration= ruleVarDeclaration EOF
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
    // InternalOCLX.g:1109:1: ruleVarDeclaration returns [EObject current=null] : ( (lv_name_0_0= ruleSimpleName ) ) ;
    public final EObject ruleVarDeclaration() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1115:2: ( ( (lv_name_0_0= ruleSimpleName ) ) )
            // InternalOCLX.g:1116:2: ( (lv_name_0_0= ruleSimpleName ) )
            {
            // InternalOCLX.g:1116:2: ( (lv_name_0_0= ruleSimpleName ) )
            // InternalOCLX.g:1117:3: (lv_name_0_0= ruleSimpleName )
            {
            // InternalOCLX.g:1117:3: (lv_name_0_0= ruleSimpleName )
            // InternalOCLX.g:1118:4: lv_name_0_0= ruleSimpleName
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
    // InternalOCLX.g:1138:1: entryRuleVarReference returns [EObject current=null] : iv_ruleVarReference= ruleVarReference EOF ;
    public final EObject entryRuleVarReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVarReference = null;


        try {
            // InternalOCLX.g:1138:53: (iv_ruleVarReference= ruleVarReference EOF )
            // InternalOCLX.g:1139:2: iv_ruleVarReference= ruleVarReference EOF
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
    // InternalOCLX.g:1145:1: ruleVarReference returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleVarReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:1151:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalOCLX.g:1152:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalOCLX.g:1152:2: ( (otherlv_0= RULE_ID ) )
            // InternalOCLX.g:1153:3: (otherlv_0= RULE_ID )
            {
            // InternalOCLX.g:1153:3: (otherlv_0= RULE_ID )
            // InternalOCLX.g:1154:4: otherlv_0= RULE_ID
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
    // InternalOCLX.g:1168:1: entryRulePrimitiveLiteralExp returns [EObject current=null] : iv_rulePrimitiveLiteralExp= rulePrimitiveLiteralExp EOF ;
    public final EObject entryRulePrimitiveLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExp = null;


        try {
            // InternalOCLX.g:1168:60: (iv_rulePrimitiveLiteralExp= rulePrimitiveLiteralExp EOF )
            // InternalOCLX.g:1169:2: iv_rulePrimitiveLiteralExp= rulePrimitiveLiteralExp EOF
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
    // InternalOCLX.g:1175:1: rulePrimitiveLiteralExp returns [EObject current=null] : (this_NumberLiteralExp_0= ruleNumberLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_NullLiteralExp_3= ruleNullLiteralExp ) ;
    public final EObject rulePrimitiveLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralExp_0 = null;

        EObject this_StringLiteralExp_1 = null;

        EObject this_BooleanLiteralExp_2 = null;

        EObject this_NullLiteralExp_3 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1181:2: ( (this_NumberLiteralExp_0= ruleNumberLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_NullLiteralExp_3= ruleNullLiteralExp ) )
            // InternalOCLX.g:1182:2: (this_NumberLiteralExp_0= ruleNumberLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_NullLiteralExp_3= ruleNullLiteralExp )
            {
            // InternalOCLX.g:1182:2: (this_NumberLiteralExp_0= ruleNumberLiteralExp | this_StringLiteralExp_1= ruleStringLiteralExp | this_BooleanLiteralExp_2= ruleBooleanLiteralExp | this_NullLiteralExp_3= ruleNullLiteralExp )
            int alt16=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt16=1;
                }
                break;
            case RULE_STRING:
                {
                alt16=2;
                }
                break;
            case 40:
            case 41:
                {
                alt16=3;
                }
                break;
            case 42:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalOCLX.g:1183:3: this_NumberLiteralExp_0= ruleNumberLiteralExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveLiteralExpAccess().getNumberLiteralExpParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumberLiteralExp_0=ruleNumberLiteralExp();

                    state._fsp--;


                    			current = this_NumberLiteralExp_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1192:3: this_StringLiteralExp_1= ruleStringLiteralExp
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
                    // InternalOCLX.g:1201:3: this_BooleanLiteralExp_2= ruleBooleanLiteralExp
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
                    // InternalOCLX.g:1210:3: this_NullLiteralExp_3= ruleNullLiteralExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveLiteralExpAccess().getNullLiteralExpParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_NullLiteralExp_3=ruleNullLiteralExp();

                    state._fsp--;


                    			current = this_NullLiteralExp_3;
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


    // $ANTLR start "entryRuleNumberLiteralExp"
    // InternalOCLX.g:1222:1: entryRuleNumberLiteralExp returns [EObject current=null] : iv_ruleNumberLiteralExp= ruleNumberLiteralExp EOF ;
    public final EObject entryRuleNumberLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExp = null;


        try {
            // InternalOCLX.g:1222:57: (iv_ruleNumberLiteralExp= ruleNumberLiteralExp EOF )
            // InternalOCLX.g:1223:2: iv_ruleNumberLiteralExp= ruleNumberLiteralExp EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberLiteralExp=ruleNumberLiteralExp();

            state._fsp--;

             current =iv_ruleNumberLiteralExp; 
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
    // $ANTLR end "entryRuleNumberLiteralExp"


    // $ANTLR start "ruleNumberLiteralExp"
    // InternalOCLX.g:1229:1: ruleNumberLiteralExp returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleNumberLiteralExp() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:1235:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalOCLX.g:1236:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalOCLX.g:1236:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalOCLX.g:1237:3: (lv_value_0_0= RULE_INT )
            {
            // InternalOCLX.g:1237:3: (lv_value_0_0= RULE_INT )
            // InternalOCLX.g:1238:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getNumberLiteralExpAccess().getValueINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNumberLiteralExpRule());
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
    // $ANTLR end "ruleNumberLiteralExp"


    // $ANTLR start "entryRuleStringLiteralExp"
    // InternalOCLX.g:1257:1: entryRuleStringLiteralExp returns [EObject current=null] : iv_ruleStringLiteralExp= ruleStringLiteralExp EOF ;
    public final EObject entryRuleStringLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExp = null;


        try {
            // InternalOCLX.g:1257:57: (iv_ruleStringLiteralExp= ruleStringLiteralExp EOF )
            // InternalOCLX.g:1258:2: iv_ruleStringLiteralExp= ruleStringLiteralExp EOF
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
    // InternalOCLX.g:1264:1: ruleStringLiteralExp returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteralExp() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:1270:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalOCLX.g:1271:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalOCLX.g:1271:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalOCLX.g:1272:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalOCLX.g:1272:3: (lv_value_0_0= RULE_STRING )
            // InternalOCLX.g:1273:4: lv_value_0_0= RULE_STRING
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
    // InternalOCLX.g:1292:1: entryRuleBooleanLiteralExp returns [EObject current=null] : iv_ruleBooleanLiteralExp= ruleBooleanLiteralExp EOF ;
    public final EObject entryRuleBooleanLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExp = null;


        try {
            // InternalOCLX.g:1292:58: (iv_ruleBooleanLiteralExp= ruleBooleanLiteralExp EOF )
            // InternalOCLX.g:1293:2: iv_ruleBooleanLiteralExp= ruleBooleanLiteralExp EOF
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
    // InternalOCLX.g:1299:1: ruleBooleanLiteralExp returns [EObject current=null] : ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExp() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalOCLX.g:1305:2: ( ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) ) )
            // InternalOCLX.g:1306:2: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )
            {
            // InternalOCLX.g:1306:2: ( ( (lv_value_0_0= 'true' ) ) | ( (lv_value_1_0= 'false' ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==40) ) {
                alt17=1;
            }
            else if ( (LA17_0==41) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalOCLX.g:1307:3: ( (lv_value_0_0= 'true' ) )
                    {
                    // InternalOCLX.g:1307:3: ( (lv_value_0_0= 'true' ) )
                    // InternalOCLX.g:1308:4: (lv_value_0_0= 'true' )
                    {
                    // InternalOCLX.g:1308:4: (lv_value_0_0= 'true' )
                    // InternalOCLX.g:1309:5: lv_value_0_0= 'true'
                    {
                    lv_value_0_0=(Token)match(input,40,FOLLOW_2); 

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
                    // InternalOCLX.g:1322:3: ( (lv_value_1_0= 'false' ) )
                    {
                    // InternalOCLX.g:1322:3: ( (lv_value_1_0= 'false' ) )
                    // InternalOCLX.g:1323:4: (lv_value_1_0= 'false' )
                    {
                    // InternalOCLX.g:1323:4: (lv_value_1_0= 'false' )
                    // InternalOCLX.g:1324:5: lv_value_1_0= 'false'
                    {
                    lv_value_1_0=(Token)match(input,41,FOLLOW_2); 

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


    // $ANTLR start "entryRuleNullLiteralExp"
    // InternalOCLX.g:1340:1: entryRuleNullLiteralExp returns [EObject current=null] : iv_ruleNullLiteralExp= ruleNullLiteralExp EOF ;
    public final EObject entryRuleNullLiteralExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExp = null;


        try {
            // InternalOCLX.g:1340:55: (iv_ruleNullLiteralExp= ruleNullLiteralExp EOF )
            // InternalOCLX.g:1341:2: iv_ruleNullLiteralExp= ruleNullLiteralExp EOF
            {
             newCompositeNode(grammarAccess.getNullLiteralExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNullLiteralExp=ruleNullLiteralExp();

            state._fsp--;

             current =iv_ruleNullLiteralExp; 
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
    // $ANTLR end "entryRuleNullLiteralExp"


    // $ANTLR start "ruleNullLiteralExp"
    // InternalOCLX.g:1347:1: ruleNullLiteralExp returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalOCLX.g:1353:2: ( ( () otherlv_1= 'null' ) )
            // InternalOCLX.g:1354:2: ( () otherlv_1= 'null' )
            {
            // InternalOCLX.g:1354:2: ( () otherlv_1= 'null' )
            // InternalOCLX.g:1355:3: () otherlv_1= 'null'
            {
            // InternalOCLX.g:1355:3: ()
            // InternalOCLX.g:1356:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNullLiteralExpAccess().getNullLiteralExpCSAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,42,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getNullLiteralExpAccess().getNullKeyword_1());
            		

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
    // $ANTLR end "ruleNullLiteralExp"


    // $ANTLR start "entryRuleMethodExp"
    // InternalOCLX.g:1370:1: entryRuleMethodExp returns [EObject current=null] : iv_ruleMethodExp= ruleMethodExp EOF ;
    public final EObject entryRuleMethodExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodExp = null;


        try {
            // InternalOCLX.g:1370:50: (iv_ruleMethodExp= ruleMethodExp EOF )
            // InternalOCLX.g:1371:2: iv_ruleMethodExp= ruleMethodExp EOF
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
    // InternalOCLX.g:1377:1: ruleMethodExp returns [EObject current=null] : (this_PropertyAccess_0= rulePropertyAccess | this_MethodCall_1= ruleMethodCall | this_CollectionIterator_2= ruleCollectionIterator ) ;
    public final EObject ruleMethodExp() throws RecognitionException {
        EObject current = null;

        EObject this_PropertyAccess_0 = null;

        EObject this_MethodCall_1 = null;

        EObject this_CollectionIterator_2 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1383:2: ( (this_PropertyAccess_0= rulePropertyAccess | this_MethodCall_1= ruleMethodCall | this_CollectionIterator_2= ruleCollectionIterator ) )
            // InternalOCLX.g:1384:2: (this_PropertyAccess_0= rulePropertyAccess | this_MethodCall_1= ruleMethodCall | this_CollectionIterator_2= ruleCollectionIterator )
            {
            // InternalOCLX.g:1384:2: (this_PropertyAccess_0= rulePropertyAccess | this_MethodCall_1= ruleMethodCall | this_CollectionIterator_2= ruleCollectionIterator )
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                int LA18_1 = input.LA(2);

                if ( (LA18_1==EOF||(LA18_1>=19 && LA18_1<=35)||LA18_1==38||(LA18_1>=58 && LA18_1<=59)||LA18_1==61||LA18_1==63||LA18_1==65) ) {
                    alt18=1;
                }
                else if ( (LA18_1==37||LA18_1==50) ) {
                    alt18=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA18_0>=44 && LA18_0<=48)) ) {
                alt18=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalOCLX.g:1385:3: this_PropertyAccess_0= rulePropertyAccess
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
                    // InternalOCLX.g:1394:3: this_MethodCall_1= ruleMethodCall
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
                    // InternalOCLX.g:1403:3: this_CollectionIterator_2= ruleCollectionIterator
                    {

                    			newCompositeNode(grammarAccess.getMethodExpAccess().getCollectionIteratorParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_CollectionIterator_2=ruleCollectionIterator();

                    state._fsp--;


                    			current = this_CollectionIterator_2;
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
    // InternalOCLX.g:1415:1: entryRuleCollectionIterator returns [EObject current=null] : iv_ruleCollectionIterator= ruleCollectionIterator EOF ;
    public final EObject entryRuleCollectionIterator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionIterator = null;


        try {
            // InternalOCLX.g:1415:59: (iv_ruleCollectionIterator= ruleCollectionIterator EOF )
            // InternalOCLX.g:1416:2: iv_ruleCollectionIterator= ruleCollectionIterator EOF
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
    // InternalOCLX.g:1422:1: ruleCollectionIterator returns [EObject current=null] : ( ( (lv_name_0_0= ruleIteratorName ) ) otherlv_1= '(' ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) ) otherlv_3= '|' ( (lv_body_4_0= ruleExp ) ) otherlv_5= ')' ) ;
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
            // InternalOCLX.g:1428:2: ( ( ( (lv_name_0_0= ruleIteratorName ) ) otherlv_1= '(' ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) ) otherlv_3= '|' ( (lv_body_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:1429:2: ( ( (lv_name_0_0= ruleIteratorName ) ) otherlv_1= '(' ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) ) otherlv_3= '|' ( (lv_body_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:1429:2: ( ( (lv_name_0_0= ruleIteratorName ) ) otherlv_1= '(' ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) ) otherlv_3= '|' ( (lv_body_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:1430:3: ( (lv_name_0_0= ruleIteratorName ) ) otherlv_1= '(' ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) ) otherlv_3= '|' ( (lv_body_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:1430:3: ( (lv_name_0_0= ruleIteratorName ) )
            // InternalOCLX.g:1431:4: (lv_name_0_0= ruleIteratorName )
            {
            // InternalOCLX.g:1431:4: (lv_name_0_0= ruleIteratorName )
            // InternalOCLX.g:1432:5: lv_name_0_0= ruleIteratorName
            {

            					newCompositeNode(grammarAccess.getCollectionIteratorAccess().getNameIteratorNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
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

            otherlv_1=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getCollectionIteratorAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:1453:3: ( (lv_itervar_2_0= ruleIteratorVarDeclaration ) )
            // InternalOCLX.g:1454:4: (lv_itervar_2_0= ruleIteratorVarDeclaration )
            {
            // InternalOCLX.g:1454:4: (lv_itervar_2_0= ruleIteratorVarDeclaration )
            // InternalOCLX.g:1455:5: lv_itervar_2_0= ruleIteratorVarDeclaration
            {

            					newCompositeNode(grammarAccess.getCollectionIteratorAccess().getItervarIteratorVarDeclarationParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
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
            		
            // InternalOCLX.g:1476:3: ( (lv_body_4_0= ruleExp ) )
            // InternalOCLX.g:1477:4: (lv_body_4_0= ruleExp )
            {
            // InternalOCLX.g:1477:4: (lv_body_4_0= ruleExp )
            // InternalOCLX.g:1478:5: lv_body_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getCollectionIteratorAccess().getBodyExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,38,FOLLOW_2); 

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
    // InternalOCLX.g:1503:1: entryRuleIteratorName returns [EObject current=null] : iv_ruleIteratorName= ruleIteratorName EOF ;
    public final EObject entryRuleIteratorName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIteratorName = null;


        try {
            // InternalOCLX.g:1503:53: (iv_ruleIteratorName= ruleIteratorName EOF )
            // InternalOCLX.g:1504:2: iv_ruleIteratorName= ruleIteratorName EOF
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
    // InternalOCLX.g:1510:1: ruleIteratorName returns [EObject current=null] : ( ( (lv_name_0_1= 'FORALL' | lv_name_0_2= 'EXISTS' | lv_name_0_3= 'COLLECT' | lv_name_0_4= 'REJECT' | lv_name_0_5= 'SELECT' ) ) ) ;
    public final EObject ruleIteratorName() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;


        	enterRule();

        try {
            // InternalOCLX.g:1516:2: ( ( ( (lv_name_0_1= 'FORALL' | lv_name_0_2= 'EXISTS' | lv_name_0_3= 'COLLECT' | lv_name_0_4= 'REJECT' | lv_name_0_5= 'SELECT' ) ) ) )
            // InternalOCLX.g:1517:2: ( ( (lv_name_0_1= 'FORALL' | lv_name_0_2= 'EXISTS' | lv_name_0_3= 'COLLECT' | lv_name_0_4= 'REJECT' | lv_name_0_5= 'SELECT' ) ) )
            {
            // InternalOCLX.g:1517:2: ( ( (lv_name_0_1= 'FORALL' | lv_name_0_2= 'EXISTS' | lv_name_0_3= 'COLLECT' | lv_name_0_4= 'REJECT' | lv_name_0_5= 'SELECT' ) ) )
            // InternalOCLX.g:1518:3: ( (lv_name_0_1= 'FORALL' | lv_name_0_2= 'EXISTS' | lv_name_0_3= 'COLLECT' | lv_name_0_4= 'REJECT' | lv_name_0_5= 'SELECT' ) )
            {
            // InternalOCLX.g:1518:3: ( (lv_name_0_1= 'FORALL' | lv_name_0_2= 'EXISTS' | lv_name_0_3= 'COLLECT' | lv_name_0_4= 'REJECT' | lv_name_0_5= 'SELECT' ) )
            // InternalOCLX.g:1519:4: (lv_name_0_1= 'FORALL' | lv_name_0_2= 'EXISTS' | lv_name_0_3= 'COLLECT' | lv_name_0_4= 'REJECT' | lv_name_0_5= 'SELECT' )
            {
            // InternalOCLX.g:1519:4: (lv_name_0_1= 'FORALL' | lv_name_0_2= 'EXISTS' | lv_name_0_3= 'COLLECT' | lv_name_0_4= 'REJECT' | lv_name_0_5= 'SELECT' )
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
                    // InternalOCLX.g:1520:5: lv_name_0_1= 'FORALL'
                    {
                    lv_name_0_1=(Token)match(input,44,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getIteratorNameAccess().getNameFORALLKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIteratorNameRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1531:5: lv_name_0_2= 'EXISTS'
                    {
                    lv_name_0_2=(Token)match(input,45,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getIteratorNameAccess().getNameEXISTSKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIteratorNameRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1542:5: lv_name_0_3= 'COLLECT'
                    {
                    lv_name_0_3=(Token)match(input,46,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getIteratorNameAccess().getNameCOLLECTKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIteratorNameRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1553:5: lv_name_0_4= 'REJECT'
                    {
                    lv_name_0_4=(Token)match(input,47,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getIteratorNameAccess().getNameREJECTKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getIteratorNameRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalOCLX.g:1564:5: lv_name_0_5= 'SELECT'
                    {
                    lv_name_0_5=(Token)match(input,48,FOLLOW_2); 

                    					newLeafNode(lv_name_0_5, grammarAccess.getIteratorNameAccess().getNameSELECTKeyword_0_4());
                    				

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
    // InternalOCLX.g:1580:1: entryRuleIteratorVarDeclaration returns [EObject current=null] : iv_ruleIteratorVarDeclaration= ruleIteratorVarDeclaration EOF ;
    public final EObject entryRuleIteratorVarDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIteratorVarDeclaration = null;


        try {
            // InternalOCLX.g:1580:63: (iv_ruleIteratorVarDeclaration= ruleIteratorVarDeclaration EOF )
            // InternalOCLX.g:1581:2: iv_ruleIteratorVarDeclaration= ruleIteratorVarDeclaration EOF
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
    // InternalOCLX.g:1587:1: ruleIteratorVarDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= ruleVarDeclaration ) ) | ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ) ) ;
    public final EObject ruleIteratorVarDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_name_1_0 = null;

        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1593:2: ( ( ( (lv_name_0_0= ruleVarDeclaration ) ) | ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ) ) )
            // InternalOCLX.g:1594:2: ( ( (lv_name_0_0= ruleVarDeclaration ) ) | ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ) )
            {
            // InternalOCLX.g:1594:2: ( ( (lv_name_0_0= ruleVarDeclaration ) ) | ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) ) )
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
                    // InternalOCLX.g:1595:3: ( (lv_name_0_0= ruleVarDeclaration ) )
                    {
                    // InternalOCLX.g:1595:3: ( (lv_name_0_0= ruleVarDeclaration ) )
                    // InternalOCLX.g:1596:4: (lv_name_0_0= ruleVarDeclaration )
                    {
                    // InternalOCLX.g:1596:4: (lv_name_0_0= ruleVarDeclaration )
                    // InternalOCLX.g:1597:5: lv_name_0_0= ruleVarDeclaration
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
                    // InternalOCLX.g:1615:3: ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )
                    {
                    // InternalOCLX.g:1615:3: ( ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) ) )
                    // InternalOCLX.g:1616:4: ( (lv_name_1_0= ruleVarDeclaration ) ) otherlv_2= ':' ( (lv_type_3_0= ruleTypeExp ) )
                    {
                    // InternalOCLX.g:1616:4: ( (lv_name_1_0= ruleVarDeclaration ) )
                    // InternalOCLX.g:1617:5: (lv_name_1_0= ruleVarDeclaration )
                    {
                    // InternalOCLX.g:1617:5: (lv_name_1_0= ruleVarDeclaration )
                    // InternalOCLX.g:1618:6: lv_name_1_0= ruleVarDeclaration
                    {

                    						newCompositeNode(grammarAccess.getIteratorVarDeclarationAccess().getNameVarDeclarationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_22);
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

                    otherlv_2=(Token)match(input,49,FOLLOW_23); 

                    				newLeafNode(otherlv_2, grammarAccess.getIteratorVarDeclarationAccess().getColonKeyword_1_1());
                    			
                    // InternalOCLX.g:1639:4: ( (lv_type_3_0= ruleTypeExp ) )
                    // InternalOCLX.g:1640:5: (lv_type_3_0= ruleTypeExp )
                    {
                    // InternalOCLX.g:1640:5: (lv_type_3_0= ruleTypeExp )
                    // InternalOCLX.g:1641:6: lv_type_3_0= ruleTypeExp
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
    // InternalOCLX.g:1663:1: entryRulePropertyAccess returns [EObject current=null] : iv_rulePropertyAccess= rulePropertyAccess EOF ;
    public final EObject entryRulePropertyAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAccess = null;


        try {
            // InternalOCLX.g:1663:55: (iv_rulePropertyAccess= rulePropertyAccess EOF )
            // InternalOCLX.g:1664:2: iv_rulePropertyAccess= rulePropertyAccess EOF
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
    // InternalOCLX.g:1670:1: rulePropertyAccess returns [EObject current=null] : ( (lv_name_0_0= ruleSimpleName ) ) ;
    public final EObject rulePropertyAccess() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1676:2: ( ( (lv_name_0_0= ruleSimpleName ) ) )
            // InternalOCLX.g:1677:2: ( (lv_name_0_0= ruleSimpleName ) )
            {
            // InternalOCLX.g:1677:2: ( (lv_name_0_0= ruleSimpleName ) )
            // InternalOCLX.g:1678:3: (lv_name_0_0= ruleSimpleName )
            {
            // InternalOCLX.g:1678:3: (lv_name_0_0= ruleSimpleName )
            // InternalOCLX.g:1679:4: lv_name_0_0= ruleSimpleName
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
    // InternalOCLX.g:1699:1: entryRuleMethodCall returns [EObject current=null] : iv_ruleMethodCall= ruleMethodCall EOF ;
    public final EObject entryRuleMethodCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodCall = null;


        try {
            // InternalOCLX.g:1699:51: (iv_ruleMethodCall= ruleMethodCall EOF )
            // InternalOCLX.g:1700:2: iv_ruleMethodCall= ruleMethodCall EOF
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
    // InternalOCLX.g:1706:1: ruleMethodCall returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' ) | ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' ) | ( ( (lv_name_6_0= ruleSimpleName ) ) otherlv_7= '(' ( (lv_type_8_0= ruleTypeExp ) ) otherlv_9= ')' ) ) ;
    public final EObject ruleMethodCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_args_4_0 = null;

        AntlrDatatypeRuleToken lv_name_6_0 = null;

        EObject lv_type_8_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1712:2: ( ( ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' ) | ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' ) | ( ( (lv_name_6_0= ruleSimpleName ) ) otherlv_7= '(' ( (lv_type_8_0= ruleTypeExp ) ) otherlv_9= ')' ) ) )
            // InternalOCLX.g:1713:2: ( ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' ) | ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' ) | ( ( (lv_name_6_0= ruleSimpleName ) ) otherlv_7= '(' ( (lv_type_8_0= ruleTypeExp ) ) otherlv_9= ')' ) )
            {
            // InternalOCLX.g:1713:2: ( ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' ) | ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' ) | ( ( (lv_name_6_0= ruleSimpleName ) ) otherlv_7= '(' ( (lv_type_8_0= ruleTypeExp ) ) otherlv_9= ')' ) )
            int alt21=3;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==37) ) {
                    int LA21_2 = input.LA(3);

                    if ( (LA21_2==22||(LA21_2>=51 && LA21_2<=54)) ) {
                        alt21=3;
                    }
                    else if ( (LA21_2==RULE_ID||(LA21_2>=RULE_INT && LA21_2<=RULE_STRING)||LA21_2==34||(LA21_2>=36 && LA21_2<=37)||(LA21_2>=39 && LA21_2<=42)||(LA21_2>=55 && LA21_2<=60)||LA21_2==62||LA21_2==64||(LA21_2>=66 && LA21_2<=67)) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 2, input);

                        throw nvae;
                    }
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
                    // InternalOCLX.g:1714:3: ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' )
                    {
                    // InternalOCLX.g:1714:3: ( ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()' )
                    // InternalOCLX.g:1715:4: ( (lv_name_0_0= ruleSimpleName ) ) otherlv_1= '()'
                    {
                    // InternalOCLX.g:1715:4: ( (lv_name_0_0= ruleSimpleName ) )
                    // InternalOCLX.g:1716:5: (lv_name_0_0= ruleSimpleName )
                    {
                    // InternalOCLX.g:1716:5: (lv_name_0_0= ruleSimpleName )
                    // InternalOCLX.g:1717:6: lv_name_0_0= ruleSimpleName
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getNameSimpleNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_24);
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
                    // InternalOCLX.g:1740:3: ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' )
                    {
                    // InternalOCLX.g:1740:3: ( ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')' )
                    // InternalOCLX.g:1741:4: ( (lv_name_2_0= ruleSimpleName ) ) otherlv_3= '(' ( (lv_args_4_0= ruleArgumentsExp ) ) otherlv_5= ')'
                    {
                    // InternalOCLX.g:1741:4: ( (lv_name_2_0= ruleSimpleName ) )
                    // InternalOCLX.g:1742:5: (lv_name_2_0= ruleSimpleName )
                    {
                    // InternalOCLX.g:1742:5: (lv_name_2_0= ruleSimpleName )
                    // InternalOCLX.g:1743:6: lv_name_2_0= ruleSimpleName
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getNameSimpleNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_20);
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

                    otherlv_3=(Token)match(input,37,FOLLOW_13); 

                    				newLeafNode(otherlv_3, grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_1_1());
                    			
                    // InternalOCLX.g:1764:4: ( (lv_args_4_0= ruleArgumentsExp ) )
                    // InternalOCLX.g:1765:5: (lv_args_4_0= ruleArgumentsExp )
                    {
                    // InternalOCLX.g:1765:5: (lv_args_4_0= ruleArgumentsExp )
                    // InternalOCLX.g:1766:6: lv_args_4_0= ruleArgumentsExp
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getArgsArgumentsExpParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_19);
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

                    otherlv_5=(Token)match(input,38,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_1_3());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1789:3: ( ( (lv_name_6_0= ruleSimpleName ) ) otherlv_7= '(' ( (lv_type_8_0= ruleTypeExp ) ) otherlv_9= ')' )
                    {
                    // InternalOCLX.g:1789:3: ( ( (lv_name_6_0= ruleSimpleName ) ) otherlv_7= '(' ( (lv_type_8_0= ruleTypeExp ) ) otherlv_9= ')' )
                    // InternalOCLX.g:1790:4: ( (lv_name_6_0= ruleSimpleName ) ) otherlv_7= '(' ( (lv_type_8_0= ruleTypeExp ) ) otherlv_9= ')'
                    {
                    // InternalOCLX.g:1790:4: ( (lv_name_6_0= ruleSimpleName ) )
                    // InternalOCLX.g:1791:5: (lv_name_6_0= ruleSimpleName )
                    {
                    // InternalOCLX.g:1791:5: (lv_name_6_0= ruleSimpleName )
                    // InternalOCLX.g:1792:6: lv_name_6_0= ruleSimpleName
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getNameSimpleNameParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_20);
                    lv_name_6_0=ruleSimpleName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodCallRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_6_0,
                    							"at.jku.isse.OCLX.SimpleName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_7=(Token)match(input,37,FOLLOW_23); 

                    				newLeafNode(otherlv_7, grammarAccess.getMethodCallAccess().getLeftParenthesisKeyword_2_1());
                    			
                    // InternalOCLX.g:1813:4: ( (lv_type_8_0= ruleTypeExp ) )
                    // InternalOCLX.g:1814:5: (lv_type_8_0= ruleTypeExp )
                    {
                    // InternalOCLX.g:1814:5: (lv_type_8_0= ruleTypeExp )
                    // InternalOCLX.g:1815:6: lv_type_8_0= ruleTypeExp
                    {

                    						newCompositeNode(grammarAccess.getMethodCallAccess().getTypeTypeExpParserRuleCall_2_2_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_type_8_0=ruleTypeExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getMethodCallRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_8_0,
                    							"at.jku.isse.OCLX.TypeExp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_9=(Token)match(input,38,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getMethodCallAccess().getRightParenthesisKeyword_2_3());
                    			

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


    // $ANTLR start "entryRuleTypeExp"
    // InternalOCLX.g:1841:1: entryRuleTypeExp returns [EObject current=null] : iv_ruleTypeExp= ruleTypeExp EOF ;
    public final EObject entryRuleTypeExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExp = null;


        try {
            // InternalOCLX.g:1841:48: (iv_ruleTypeExp= ruleTypeExp EOF )
            // InternalOCLX.g:1842:2: iv_ruleTypeExp= ruleTypeExp EOF
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
    // InternalOCLX.g:1848:1: ruleTypeExp returns [EObject current=null] : ( ( () otherlv_1= '<' ( (lv_name_2_0= rulePath ) ) otherlv_3= '>' ) | ( ( (lv_collectionType_4_0= ruleCollectionTypeIdentifier ) ) ( (lv_type_5_0= ruleTypeExp ) ) ) ) ;
    public final EObject ruleTypeExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_collectionType_4_0 = null;

        EObject lv_type_5_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:1854:2: ( ( ( () otherlv_1= '<' ( (lv_name_2_0= rulePath ) ) otherlv_3= '>' ) | ( ( (lv_collectionType_4_0= ruleCollectionTypeIdentifier ) ) ( (lv_type_5_0= ruleTypeExp ) ) ) ) )
            // InternalOCLX.g:1855:2: ( ( () otherlv_1= '<' ( (lv_name_2_0= rulePath ) ) otherlv_3= '>' ) | ( ( (lv_collectionType_4_0= ruleCollectionTypeIdentifier ) ) ( (lv_type_5_0= ruleTypeExp ) ) ) )
            {
            // InternalOCLX.g:1855:2: ( ( () otherlv_1= '<' ( (lv_name_2_0= rulePath ) ) otherlv_3= '>' ) | ( ( (lv_collectionType_4_0= ruleCollectionTypeIdentifier ) ) ( (lv_type_5_0= ruleTypeExp ) ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==22) ) {
                alt22=1;
            }
            else if ( ((LA22_0>=51 && LA22_0<=54)) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalOCLX.g:1856:3: ( () otherlv_1= '<' ( (lv_name_2_0= rulePath ) ) otherlv_3= '>' )
                    {
                    // InternalOCLX.g:1856:3: ( () otherlv_1= '<' ( (lv_name_2_0= rulePath ) ) otherlv_3= '>' )
                    // InternalOCLX.g:1857:4: () otherlv_1= '<' ( (lv_name_2_0= rulePath ) ) otherlv_3= '>'
                    {
                    // InternalOCLX.g:1857:4: ()
                    // InternalOCLX.g:1858:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getTypeExpAccess().getTypeExpAction_0_0(),
                    						current);
                    				

                    }

                    otherlv_1=(Token)match(input,22,FOLLOW_4); 

                    				newLeafNode(otherlv_1, grammarAccess.getTypeExpAccess().getLessThanSignKeyword_0_1());
                    			
                    // InternalOCLX.g:1868:4: ( (lv_name_2_0= rulePath ) )
                    // InternalOCLX.g:1869:5: (lv_name_2_0= rulePath )
                    {
                    // InternalOCLX.g:1869:5: (lv_name_2_0= rulePath )
                    // InternalOCLX.g:1870:6: lv_name_2_0= rulePath
                    {

                    						newCompositeNode(grammarAccess.getTypeExpAccess().getNamePathParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_name_2_0=rulePath();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTypeExpRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"at.jku.isse.OCLX.Path");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,21,FOLLOW_2); 

                    				newLeafNode(otherlv_3, grammarAccess.getTypeExpAccess().getGreaterThanSignKeyword_0_3());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1893:3: ( ( (lv_collectionType_4_0= ruleCollectionTypeIdentifier ) ) ( (lv_type_5_0= ruleTypeExp ) ) )
                    {
                    // InternalOCLX.g:1893:3: ( ( (lv_collectionType_4_0= ruleCollectionTypeIdentifier ) ) ( (lv_type_5_0= ruleTypeExp ) ) )
                    // InternalOCLX.g:1894:4: ( (lv_collectionType_4_0= ruleCollectionTypeIdentifier ) ) ( (lv_type_5_0= ruleTypeExp ) )
                    {
                    // InternalOCLX.g:1894:4: ( (lv_collectionType_4_0= ruleCollectionTypeIdentifier ) )
                    // InternalOCLX.g:1895:5: (lv_collectionType_4_0= ruleCollectionTypeIdentifier )
                    {
                    // InternalOCLX.g:1895:5: (lv_collectionType_4_0= ruleCollectionTypeIdentifier )
                    // InternalOCLX.g:1896:6: lv_collectionType_4_0= ruleCollectionTypeIdentifier
                    {

                    						newCompositeNode(grammarAccess.getTypeExpAccess().getCollectionTypeCollectionTypeIdentifierParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_23);
                    lv_collectionType_4_0=ruleCollectionTypeIdentifier();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTypeExpRule());
                    						}
                    						set(
                    							current,
                    							"collectionType",
                    							lv_collectionType_4_0,
                    							"at.jku.isse.OCLX.CollectionTypeIdentifier");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalOCLX.g:1913:4: ( (lv_type_5_0= ruleTypeExp ) )
                    // InternalOCLX.g:1914:5: (lv_type_5_0= ruleTypeExp )
                    {
                    // InternalOCLX.g:1914:5: (lv_type_5_0= ruleTypeExp )
                    // InternalOCLX.g:1915:6: lv_type_5_0= ruleTypeExp
                    {

                    						newCompositeNode(grammarAccess.getTypeExpAccess().getTypeTypeExpParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_type_5_0=ruleTypeExp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTypeExpRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_5_0,
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
    // $ANTLR end "ruleTypeExp"


    // $ANTLR start "entryRuleCollectionTypeIdentifier"
    // InternalOCLX.g:1937:1: entryRuleCollectionTypeIdentifier returns [EObject current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final EObject entryRuleCollectionTypeIdentifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeIdentifier = null;


        try {
            // InternalOCLX.g:1937:65: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // InternalOCLX.g:1938:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
             newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;

             current =iv_ruleCollectionTypeIdentifier; 
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
    // $ANTLR end "entryRuleCollectionTypeIdentifier"


    // $ANTLR start "ruleCollectionTypeIdentifier"
    // InternalOCLX.g:1944:1: ruleCollectionTypeIdentifier returns [EObject current=null] : ( ( (lv_name_0_1= 'SET' | lv_name_0_2= 'LIST' | lv_name_0_3= 'MAP' | lv_name_0_4= 'COLLECTION' ) ) ) ;
    public final EObject ruleCollectionTypeIdentifier() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;


        	enterRule();

        try {
            // InternalOCLX.g:1950:2: ( ( ( (lv_name_0_1= 'SET' | lv_name_0_2= 'LIST' | lv_name_0_3= 'MAP' | lv_name_0_4= 'COLLECTION' ) ) ) )
            // InternalOCLX.g:1951:2: ( ( (lv_name_0_1= 'SET' | lv_name_0_2= 'LIST' | lv_name_0_3= 'MAP' | lv_name_0_4= 'COLLECTION' ) ) )
            {
            // InternalOCLX.g:1951:2: ( ( (lv_name_0_1= 'SET' | lv_name_0_2= 'LIST' | lv_name_0_3= 'MAP' | lv_name_0_4= 'COLLECTION' ) ) )
            // InternalOCLX.g:1952:3: ( (lv_name_0_1= 'SET' | lv_name_0_2= 'LIST' | lv_name_0_3= 'MAP' | lv_name_0_4= 'COLLECTION' ) )
            {
            // InternalOCLX.g:1952:3: ( (lv_name_0_1= 'SET' | lv_name_0_2= 'LIST' | lv_name_0_3= 'MAP' | lv_name_0_4= 'COLLECTION' ) )
            // InternalOCLX.g:1953:4: (lv_name_0_1= 'SET' | lv_name_0_2= 'LIST' | lv_name_0_3= 'MAP' | lv_name_0_4= 'COLLECTION' )
            {
            // InternalOCLX.g:1953:4: (lv_name_0_1= 'SET' | lv_name_0_2= 'LIST' | lv_name_0_3= 'MAP' | lv_name_0_4= 'COLLECTION' )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt23=1;
                }
                break;
            case 52:
                {
                alt23=2;
                }
                break;
            case 53:
                {
                alt23=3;
                }
                break;
            case 54:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalOCLX.g:1954:5: lv_name_0_1= 'SET'
                    {
                    lv_name_0_1=(Token)match(input,51,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getCollectionTypeIdentifierAccess().getNameSETKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCollectionTypeIdentifierRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:1965:5: lv_name_0_2= 'LIST'
                    {
                    lv_name_0_2=(Token)match(input,52,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getCollectionTypeIdentifierAccess().getNameLISTKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCollectionTypeIdentifierRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:1976:5: lv_name_0_3= 'MAP'
                    {
                    lv_name_0_3=(Token)match(input,53,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getCollectionTypeIdentifierAccess().getNameMAPKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCollectionTypeIdentifierRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalOCLX.g:1987:5: lv_name_0_4= 'COLLECTION'
                    {
                    lv_name_0_4=(Token)match(input,54,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getCollectionTypeIdentifierAccess().getNameCOLLECTIONKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCollectionTypeIdentifierRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

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
    // $ANTLR end "ruleCollectionTypeIdentifier"


    // $ANTLR start "entryRuleTemporalExp"
    // InternalOCLX.g:2003:1: entryRuleTemporalExp returns [EObject current=null] : iv_ruleTemporalExp= ruleTemporalExp EOF ;
    public final EObject entryRuleTemporalExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalExp = null;


        try {
            // InternalOCLX.g:2003:52: (iv_ruleTemporalExp= ruleTemporalExp EOF )
            // InternalOCLX.g:2004:2: iv_ruleTemporalExp= ruleTemporalExp EOF
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
    // InternalOCLX.g:2010:1: ruleTemporalExp returns [EObject current=null] : (this_UnaryTemporalExp_0= ruleUnaryTemporalExp | this_TriggeredTemporalExp_1= ruleTriggeredTemporalExp ) ;
    public final EObject ruleTemporalExp() throws RecognitionException {
        EObject current = null;

        EObject this_UnaryTemporalExp_0 = null;

        EObject this_TriggeredTemporalExp_1 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2016:2: ( (this_UnaryTemporalExp_0= ruleUnaryTemporalExp | this_TriggeredTemporalExp_1= ruleTriggeredTemporalExp ) )
            // InternalOCLX.g:2017:2: (this_UnaryTemporalExp_0= ruleUnaryTemporalExp | this_TriggeredTemporalExp_1= ruleTriggeredTemporalExp )
            {
            // InternalOCLX.g:2017:2: (this_UnaryTemporalExp_0= ruleUnaryTemporalExp | this_TriggeredTemporalExp_1= ruleTriggeredTemporalExp )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=55 && LA24_0<=57)) ) {
                alt24=1;
            }
            else if ( ((LA24_0>=58 && LA24_0<=60)||LA24_0==62||LA24_0==64||(LA24_0>=66 && LA24_0<=67)) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalOCLX.g:2018:3: this_UnaryTemporalExp_0= ruleUnaryTemporalExp
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
                    // InternalOCLX.g:2027:3: this_TriggeredTemporalExp_1= ruleTriggeredTemporalExp
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
    // InternalOCLX.g:2039:1: entryRuleUnaryTemporalExp returns [EObject current=null] : iv_ruleUnaryTemporalExp= ruleUnaryTemporalExp EOF ;
    public final EObject entryRuleUnaryTemporalExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryTemporalExp = null;


        try {
            // InternalOCLX.g:2039:57: (iv_ruleUnaryTemporalExp= ruleUnaryTemporalExp EOF )
            // InternalOCLX.g:2040:2: iv_ruleUnaryTemporalExp= ruleUnaryTemporalExp EOF
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
    // InternalOCLX.g:2046:1: ruleUnaryTemporalExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnaryTemporalOp ) ) otherlv_1= '(' ( (lv_exp_2_0= ruleExp ) ) otherlv_3= ')' ) ;
    public final EObject ruleUnaryTemporalExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2052:2: ( ( ( (lv_name_0_0= ruleUnaryTemporalOp ) ) otherlv_1= '(' ( (lv_exp_2_0= ruleExp ) ) otherlv_3= ')' ) )
            // InternalOCLX.g:2053:2: ( ( (lv_name_0_0= ruleUnaryTemporalOp ) ) otherlv_1= '(' ( (lv_exp_2_0= ruleExp ) ) otherlv_3= ')' )
            {
            // InternalOCLX.g:2053:2: ( ( (lv_name_0_0= ruleUnaryTemporalOp ) ) otherlv_1= '(' ( (lv_exp_2_0= ruleExp ) ) otherlv_3= ')' )
            // InternalOCLX.g:2054:3: ( (lv_name_0_0= ruleUnaryTemporalOp ) ) otherlv_1= '(' ( (lv_exp_2_0= ruleExp ) ) otherlv_3= ')'
            {
            // InternalOCLX.g:2054:3: ( (lv_name_0_0= ruleUnaryTemporalOp ) )
            // InternalOCLX.g:2055:4: (lv_name_0_0= ruleUnaryTemporalOp )
            {
            // InternalOCLX.g:2055:4: (lv_name_0_0= ruleUnaryTemporalOp )
            // InternalOCLX.g:2056:5: lv_name_0_0= ruleUnaryTemporalOp
            {

            					newCompositeNode(grammarAccess.getUnaryTemporalExpAccess().getNameUnaryTemporalOpParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
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

            otherlv_1=(Token)match(input,37,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getUnaryTemporalExpAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2077:3: ( (lv_exp_2_0= ruleExp ) )
            // InternalOCLX.g:2078:4: (lv_exp_2_0= ruleExp )
            {
            // InternalOCLX.g:2078:4: (lv_exp_2_0= ruleExp )
            // InternalOCLX.g:2079:5: lv_exp_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getUnaryTemporalExpAccess().getExpExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_3=(Token)match(input,38,FOLLOW_2); 

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
    // InternalOCLX.g:2104:1: entryRuleUnaryTemporalOp returns [String current=null] : iv_ruleUnaryTemporalOp= ruleUnaryTemporalOp EOF ;
    public final String entryRuleUnaryTemporalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryTemporalOp = null;


        try {
            // InternalOCLX.g:2104:55: (iv_ruleUnaryTemporalOp= ruleUnaryTemporalOp EOF )
            // InternalOCLX.g:2105:2: iv_ruleUnaryTemporalOp= ruleUnaryTemporalOp EOF
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
    // InternalOCLX.g:2111:1: ruleUnaryTemporalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'next' | kw= 'always' | kw= 'eventually' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryTemporalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalOCLX.g:2117:2: ( (kw= 'next' | kw= 'always' | kw= 'eventually' ) )
            // InternalOCLX.g:2118:2: (kw= 'next' | kw= 'always' | kw= 'eventually' )
            {
            // InternalOCLX.g:2118:2: (kw= 'next' | kw= 'always' | kw= 'eventually' )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt25=1;
                }
                break;
            case 56:
                {
                alt25=2;
                }
                break;
            case 57:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalOCLX.g:2119:3: kw= 'next'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnaryTemporalOpAccess().getNextKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalOCLX.g:2125:3: kw= 'always'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnaryTemporalOpAccess().getAlwaysKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalOCLX.g:2131:3: kw= 'eventually'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

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
    // InternalOCLX.g:2140:1: entryRuleTriggeredTemporalExp returns [EObject current=null] : iv_ruleTriggeredTemporalExp= ruleTriggeredTemporalExp EOF ;
    public final EObject entryRuleTriggeredTemporalExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTriggeredTemporalExp = null;


        try {
            // InternalOCLX.g:2140:61: (iv_ruleTriggeredTemporalExp= ruleTriggeredTemporalExp EOF )
            // InternalOCLX.g:2141:2: iv_ruleTriggeredTemporalExp= ruleTriggeredTemporalExp EOF
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
    // InternalOCLX.g:2147:1: ruleTriggeredTemporalExp returns [EObject current=null] : (this_TemporalAsLongAs_0= ruleTemporalAsLongAs | this_TemporalUntil_1= ruleTemporalUntil | this_TemporalEverytime_2= ruleTemporalEverytime | this_TemporalAtLeastOnce_3= ruleTemporalAtLeastOnce | this_LegacyUntil_4= ruleLegacyUntil | this_LegacyAsSoonAs_5= ruleLegacyAsSoonAs | this_LegacyEverytime_6= ruleLegacyEverytime ) ;
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
            // InternalOCLX.g:2153:2: ( (this_TemporalAsLongAs_0= ruleTemporalAsLongAs | this_TemporalUntil_1= ruleTemporalUntil | this_TemporalEverytime_2= ruleTemporalEverytime | this_TemporalAtLeastOnce_3= ruleTemporalAtLeastOnce | this_LegacyUntil_4= ruleLegacyUntil | this_LegacyAsSoonAs_5= ruleLegacyAsSoonAs | this_LegacyEverytime_6= ruleLegacyEverytime ) )
            // InternalOCLX.g:2154:2: (this_TemporalAsLongAs_0= ruleTemporalAsLongAs | this_TemporalUntil_1= ruleTemporalUntil | this_TemporalEverytime_2= ruleTemporalEverytime | this_TemporalAtLeastOnce_3= ruleTemporalAtLeastOnce | this_LegacyUntil_4= ruleLegacyUntil | this_LegacyAsSoonAs_5= ruleLegacyAsSoonAs | this_LegacyEverytime_6= ruleLegacyEverytime )
            {
            // InternalOCLX.g:2154:2: (this_TemporalAsLongAs_0= ruleTemporalAsLongAs | this_TemporalUntil_1= ruleTemporalUntil | this_TemporalEverytime_2= ruleTemporalEverytime | this_TemporalAtLeastOnce_3= ruleTemporalAtLeastOnce | this_LegacyUntil_4= ruleLegacyUntil | this_LegacyAsSoonAs_5= ruleLegacyAsSoonAs | this_LegacyEverytime_6= ruleLegacyEverytime )
            int alt26=7;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt26=1;
                }
                break;
            case 59:
                {
                alt26=2;
                }
                break;
            case 60:
                {
                alt26=3;
                }
                break;
            case 62:
                {
                alt26=4;
                }
                break;
            case 64:
                {
                alt26=5;
                }
                break;
            case 66:
                {
                alt26=6;
                }
                break;
            case 67:
                {
                alt26=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalOCLX.g:2155:3: this_TemporalAsLongAs_0= ruleTemporalAsLongAs
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
                    // InternalOCLX.g:2164:3: this_TemporalUntil_1= ruleTemporalUntil
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
                    // InternalOCLX.g:2173:3: this_TemporalEverytime_2= ruleTemporalEverytime
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
                    // InternalOCLX.g:2182:3: this_TemporalAtLeastOnce_3= ruleTemporalAtLeastOnce
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
                    // InternalOCLX.g:2191:3: this_LegacyUntil_4= ruleLegacyUntil
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
                    // InternalOCLX.g:2200:3: this_LegacyAsSoonAs_5= ruleLegacyAsSoonAs
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
                    // InternalOCLX.g:2209:3: this_LegacyEverytime_6= ruleLegacyEverytime
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
    // InternalOCLX.g:2221:1: entryRuleTemporalAsLongAs returns [EObject current=null] : iv_ruleTemporalAsLongAs= ruleTemporalAsLongAs EOF ;
    public final EObject entryRuleTemporalAsLongAs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalAsLongAs = null;


        try {
            // InternalOCLX.g:2221:57: (iv_ruleTemporalAsLongAs= ruleTemporalAsLongAs EOF )
            // InternalOCLX.g:2222:2: iv_ruleTemporalAsLongAs= ruleTemporalAsLongAs EOF
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
    // InternalOCLX.g:2228:1: ruleTemporalAsLongAs returns [EObject current=null] : ( ( (lv_name_0_0= 'asLongAs' ) ) otherlv_1= '(' ( (lv_b_2_0= ruleExp ) ) otherlv_3= 'ensureThat' ( (lv_a_4_0= ruleExp ) ) otherlv_5= ')' ) ;
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
            // InternalOCLX.g:2234:2: ( ( ( (lv_name_0_0= 'asLongAs' ) ) otherlv_1= '(' ( (lv_b_2_0= ruleExp ) ) otherlv_3= 'ensureThat' ( (lv_a_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2235:2: ( ( (lv_name_0_0= 'asLongAs' ) ) otherlv_1= '(' ( (lv_b_2_0= ruleExp ) ) otherlv_3= 'ensureThat' ( (lv_a_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2235:2: ( ( (lv_name_0_0= 'asLongAs' ) ) otherlv_1= '(' ( (lv_b_2_0= ruleExp ) ) otherlv_3= 'ensureThat' ( (lv_a_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2236:3: ( (lv_name_0_0= 'asLongAs' ) ) otherlv_1= '(' ( (lv_b_2_0= ruleExp ) ) otherlv_3= 'ensureThat' ( (lv_a_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2236:3: ( (lv_name_0_0= 'asLongAs' ) )
            // InternalOCLX.g:2237:4: (lv_name_0_0= 'asLongAs' )
            {
            // InternalOCLX.g:2237:4: (lv_name_0_0= 'asLongAs' )
            // InternalOCLX.g:2238:5: lv_name_0_0= 'asLongAs'
            {
            lv_name_0_0=(Token)match(input,58,FOLLOW_20); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTemporalAsLongAsAccess().getNameAsLongAsKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemporalAsLongAsRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "asLongAs");
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTemporalAsLongAsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2254:3: ( (lv_b_2_0= ruleExp ) )
            // InternalOCLX.g:2255:4: (lv_b_2_0= ruleExp )
            {
            // InternalOCLX.g:2255:4: (lv_b_2_0= ruleExp )
            // InternalOCLX.g:2256:5: lv_b_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalAsLongAsAccess().getBExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
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

            otherlv_3=(Token)match(input,59,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getTemporalAsLongAsAccess().getEnsureThatKeyword_3());
            		
            // InternalOCLX.g:2277:3: ( (lv_a_4_0= ruleExp ) )
            // InternalOCLX.g:2278:4: (lv_a_4_0= ruleExp )
            {
            // InternalOCLX.g:2278:4: (lv_a_4_0= ruleExp )
            // InternalOCLX.g:2279:5: lv_a_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalAsLongAsAccess().getAExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,38,FOLLOW_2); 

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
    // InternalOCLX.g:2304:1: entryRuleTemporalUntil returns [EObject current=null] : iv_ruleTemporalUntil= ruleTemporalUntil EOF ;
    public final EObject entryRuleTemporalUntil() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalUntil = null;


        try {
            // InternalOCLX.g:2304:54: (iv_ruleTemporalUntil= ruleTemporalUntil EOF )
            // InternalOCLX.g:2305:2: iv_ruleTemporalUntil= ruleTemporalUntil EOF
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
    // InternalOCLX.g:2311:1: ruleTemporalUntil returns [EObject current=null] : ( ( (lv_name_0_0= 'ensureThat' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'asLongAs' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
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
            // InternalOCLX.g:2317:2: ( ( ( (lv_name_0_0= 'ensureThat' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'asLongAs' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2318:2: ( ( (lv_name_0_0= 'ensureThat' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'asLongAs' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2318:2: ( ( (lv_name_0_0= 'ensureThat' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'asLongAs' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2319:3: ( (lv_name_0_0= 'ensureThat' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'asLongAs' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2319:3: ( (lv_name_0_0= 'ensureThat' ) )
            // InternalOCLX.g:2320:4: (lv_name_0_0= 'ensureThat' )
            {
            // InternalOCLX.g:2320:4: (lv_name_0_0= 'ensureThat' )
            // InternalOCLX.g:2321:5: lv_name_0_0= 'ensureThat'
            {
            lv_name_0_0=(Token)match(input,59,FOLLOW_20); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTemporalUntilAccess().getNameEnsureThatKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemporalUntilRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "ensureThat");
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTemporalUntilAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2337:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2338:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2338:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2339:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalUntilAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_27);
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

            otherlv_3=(Token)match(input,58,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getTemporalUntilAccess().getAsLongAsKeyword_3());
            		
            // InternalOCLX.g:2360:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2361:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2361:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2362:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalUntilAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,38,FOLLOW_2); 

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
    // InternalOCLX.g:2387:1: entryRuleTemporalEverytime returns [EObject current=null] : iv_ruleTemporalEverytime= ruleTemporalEverytime EOF ;
    public final EObject entryRuleTemporalEverytime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalEverytime = null;


        try {
            // InternalOCLX.g:2387:58: (iv_ruleTemporalEverytime= ruleTemporalEverytime EOF )
            // InternalOCLX.g:2388:2: iv_ruleTemporalEverytime= ruleTemporalEverytime EOF
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
    // InternalOCLX.g:2394:1: ruleTemporalEverytime returns [EObject current=null] : ( ( (lv_name_0_0= 'everyTime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'then' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
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
            // InternalOCLX.g:2400:2: ( ( ( (lv_name_0_0= 'everyTime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'then' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2401:2: ( ( (lv_name_0_0= 'everyTime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'then' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2401:2: ( ( (lv_name_0_0= 'everyTime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'then' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2402:3: ( (lv_name_0_0= 'everyTime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'then' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2402:3: ( (lv_name_0_0= 'everyTime' ) )
            // InternalOCLX.g:2403:4: (lv_name_0_0= 'everyTime' )
            {
            // InternalOCLX.g:2403:4: (lv_name_0_0= 'everyTime' )
            // InternalOCLX.g:2404:5: lv_name_0_0= 'everyTime'
            {
            lv_name_0_0=(Token)match(input,60,FOLLOW_20); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTemporalEverytimeAccess().getNameEveryTimeKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemporalEverytimeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "everyTime");
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTemporalEverytimeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2420:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2421:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2421:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2422:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalEverytimeAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_28);
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

            otherlv_3=(Token)match(input,61,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getTemporalEverytimeAccess().getThenKeyword_3());
            		
            // InternalOCLX.g:2443:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2444:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2444:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2445:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalEverytimeAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,38,FOLLOW_2); 

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
    // InternalOCLX.g:2470:1: entryRuleTemporalAtLeastOnce returns [EObject current=null] : iv_ruleTemporalAtLeastOnce= ruleTemporalAtLeastOnce EOF ;
    public final EObject entryRuleTemporalAtLeastOnce() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemporalAtLeastOnce = null;


        try {
            // InternalOCLX.g:2470:60: (iv_ruleTemporalAtLeastOnce= ruleTemporalAtLeastOnce EOF )
            // InternalOCLX.g:2471:2: iv_ruleTemporalAtLeastOnce= ruleTemporalAtLeastOnce EOF
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
    // InternalOCLX.g:2477:1: ruleTemporalAtLeastOnce returns [EObject current=null] : ( ( (lv_name_0_0= 'whenOnce' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'thenAtLeastOnce' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
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
            // InternalOCLX.g:2483:2: ( ( ( (lv_name_0_0= 'whenOnce' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'thenAtLeastOnce' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2484:2: ( ( (lv_name_0_0= 'whenOnce' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'thenAtLeastOnce' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2484:2: ( ( (lv_name_0_0= 'whenOnce' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'thenAtLeastOnce' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2485:3: ( (lv_name_0_0= 'whenOnce' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= 'thenAtLeastOnce' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2485:3: ( (lv_name_0_0= 'whenOnce' ) )
            // InternalOCLX.g:2486:4: (lv_name_0_0= 'whenOnce' )
            {
            // InternalOCLX.g:2486:4: (lv_name_0_0= 'whenOnce' )
            // InternalOCLX.g:2487:5: lv_name_0_0= 'whenOnce'
            {
            lv_name_0_0=(Token)match(input,62,FOLLOW_20); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTemporalAtLeastOnceAccess().getNameWhenOnceKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTemporalAtLeastOnceRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "whenOnce");
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getTemporalAtLeastOnceAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2503:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2504:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2504:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2505:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalAtLeastOnceAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_29);
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

            otherlv_3=(Token)match(input,63,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getTemporalAtLeastOnceAccess().getThenAtLeastOnceKeyword_3());
            		
            // InternalOCLX.g:2526:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2527:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2527:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2528:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getTemporalAtLeastOnceAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,38,FOLLOW_2); 

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
    // InternalOCLX.g:2553:1: entryRuleLegacyUntil returns [EObject current=null] : iv_ruleLegacyUntil= ruleLegacyUntil EOF ;
    public final EObject entryRuleLegacyUntil() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLegacyUntil = null;


        try {
            // InternalOCLX.g:2553:52: (iv_ruleLegacyUntil= ruleLegacyUntil EOF )
            // InternalOCLX.g:2554:2: iv_ruleLegacyUntil= ruleLegacyUntil EOF
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
    // InternalOCLX.g:2560:1: ruleLegacyUntil returns [EObject current=null] : ( ( (lv_name_0_0= 'until' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
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
            // InternalOCLX.g:2566:2: ( ( ( (lv_name_0_0= 'until' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2567:2: ( ( (lv_name_0_0= 'until' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2567:2: ( ( (lv_name_0_0= 'until' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2568:3: ( (lv_name_0_0= 'until' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2568:3: ( (lv_name_0_0= 'until' ) )
            // InternalOCLX.g:2569:4: (lv_name_0_0= 'until' )
            {
            // InternalOCLX.g:2569:4: (lv_name_0_0= 'until' )
            // InternalOCLX.g:2570:5: lv_name_0_0= 'until'
            {
            lv_name_0_0=(Token)match(input,64,FOLLOW_20); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLegacyUntilAccess().getNameUntilKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLegacyUntilRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "until");
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getLegacyUntilAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2586:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2587:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2587:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2588:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyUntilAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_30);
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

            otherlv_3=(Token)match(input,65,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getLegacyUntilAccess().getCommaKeyword_3());
            		
            // InternalOCLX.g:2609:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2610:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2610:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2611:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyUntilAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,38,FOLLOW_2); 

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
    // InternalOCLX.g:2636:1: entryRuleLegacyAsSoonAs returns [EObject current=null] : iv_ruleLegacyAsSoonAs= ruleLegacyAsSoonAs EOF ;
    public final EObject entryRuleLegacyAsSoonAs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLegacyAsSoonAs = null;


        try {
            // InternalOCLX.g:2636:55: (iv_ruleLegacyAsSoonAs= ruleLegacyAsSoonAs EOF )
            // InternalOCLX.g:2637:2: iv_ruleLegacyAsSoonAs= ruleLegacyAsSoonAs EOF
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
    // InternalOCLX.g:2643:1: ruleLegacyAsSoonAs returns [EObject current=null] : ( ( (lv_name_0_0= 'asSoonAs' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
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
            // InternalOCLX.g:2649:2: ( ( ( (lv_name_0_0= 'asSoonAs' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2650:2: ( ( (lv_name_0_0= 'asSoonAs' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2650:2: ( ( (lv_name_0_0= 'asSoonAs' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2651:3: ( (lv_name_0_0= 'asSoonAs' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2651:3: ( (lv_name_0_0= 'asSoonAs' ) )
            // InternalOCLX.g:2652:4: (lv_name_0_0= 'asSoonAs' )
            {
            // InternalOCLX.g:2652:4: (lv_name_0_0= 'asSoonAs' )
            // InternalOCLX.g:2653:5: lv_name_0_0= 'asSoonAs'
            {
            lv_name_0_0=(Token)match(input,66,FOLLOW_20); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLegacyAsSoonAsAccess().getNameAsSoonAsKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLegacyAsSoonAsRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "asSoonAs");
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getLegacyAsSoonAsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2669:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2670:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2670:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2671:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyAsSoonAsAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_30);
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

            otherlv_3=(Token)match(input,65,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getLegacyAsSoonAsAccess().getCommaKeyword_3());
            		
            // InternalOCLX.g:2692:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2693:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2693:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2694:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyAsSoonAsAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,38,FOLLOW_2); 

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
    // InternalOCLX.g:2719:1: entryRuleLegacyEverytime returns [EObject current=null] : iv_ruleLegacyEverytime= ruleLegacyEverytime EOF ;
    public final EObject entryRuleLegacyEverytime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLegacyEverytime = null;


        try {
            // InternalOCLX.g:2719:56: (iv_ruleLegacyEverytime= ruleLegacyEverytime EOF )
            // InternalOCLX.g:2720:2: iv_ruleLegacyEverytime= ruleLegacyEverytime EOF
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
    // InternalOCLX.g:2726:1: ruleLegacyEverytime returns [EObject current=null] : ( ( (lv_name_0_0= 'everytime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) ;
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
            // InternalOCLX.g:2732:2: ( ( ( (lv_name_0_0= 'everytime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' ) )
            // InternalOCLX.g:2733:2: ( ( (lv_name_0_0= 'everytime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            {
            // InternalOCLX.g:2733:2: ( ( (lv_name_0_0= 'everytime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')' )
            // InternalOCLX.g:2734:3: ( (lv_name_0_0= 'everytime' ) ) otherlv_1= '(' ( (lv_a_2_0= ruleExp ) ) otherlv_3= ',' ( (lv_b_4_0= ruleExp ) ) otherlv_5= ')'
            {
            // InternalOCLX.g:2734:3: ( (lv_name_0_0= 'everytime' ) )
            // InternalOCLX.g:2735:4: (lv_name_0_0= 'everytime' )
            {
            // InternalOCLX.g:2735:4: (lv_name_0_0= 'everytime' )
            // InternalOCLX.g:2736:5: lv_name_0_0= 'everytime'
            {
            lv_name_0_0=(Token)match(input,67,FOLLOW_20); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLegacyEverytimeAccess().getNameEverytimeKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLegacyEverytimeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "everytime");
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_13); 

            			newLeafNode(otherlv_1, grammarAccess.getLegacyEverytimeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalOCLX.g:2752:3: ( (lv_a_2_0= ruleExp ) )
            // InternalOCLX.g:2753:4: (lv_a_2_0= ruleExp )
            {
            // InternalOCLX.g:2753:4: (lv_a_2_0= ruleExp )
            // InternalOCLX.g:2754:5: lv_a_2_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyEverytimeAccess().getAExpParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_30);
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

            otherlv_3=(Token)match(input,65,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getLegacyEverytimeAccess().getCommaKeyword_3());
            		
            // InternalOCLX.g:2775:3: ( (lv_b_4_0= ruleExp ) )
            // InternalOCLX.g:2776:4: (lv_b_4_0= ruleExp )
            {
            // InternalOCLX.g:2776:4: (lv_b_4_0= ruleExp )
            // InternalOCLX.g:2777:5: lv_b_4_0= ruleExp
            {

            					newCompositeNode(grammarAccess.getLegacyEverytimeAccess().getBExpParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
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

            otherlv_5=(Token)match(input,38,FOLLOW_2); 

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


    // $ANTLR start "entryRulePath"
    // InternalOCLX.g:2802:1: entryRulePath returns [String current=null] : iv_rulePath= rulePath EOF ;
    public final String entryRulePath() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePath = null;


        try {
            // InternalOCLX.g:2802:44: (iv_rulePath= rulePath EOF )
            // InternalOCLX.g:2803:2: iv_rulePath= rulePath EOF
            {
             newCompositeNode(grammarAccess.getPathRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;

             current =iv_rulePath.getText(); 
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
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalOCLX.g:2809:1: rulePath returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SimpleName_0= ruleSimpleName (kw= '/' this_SimpleName_2= ruleSimpleName )* ) ;
    public final AntlrDatatypeRuleToken rulePath() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_SimpleName_0 = null;

        AntlrDatatypeRuleToken this_SimpleName_2 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2815:2: ( (this_SimpleName_0= ruleSimpleName (kw= '/' this_SimpleName_2= ruleSimpleName )* ) )
            // InternalOCLX.g:2816:2: (this_SimpleName_0= ruleSimpleName (kw= '/' this_SimpleName_2= ruleSimpleName )* )
            {
            // InternalOCLX.g:2816:2: (this_SimpleName_0= ruleSimpleName (kw= '/' this_SimpleName_2= ruleSimpleName )* )
            // InternalOCLX.g:2817:3: this_SimpleName_0= ruleSimpleName (kw= '/' this_SimpleName_2= ruleSimpleName )*
            {

            			newCompositeNode(grammarAccess.getPathAccess().getSimpleNameParserRuleCall_0());
            		
            pushFollow(FOLLOW_31);
            this_SimpleName_0=ruleSimpleName();

            state._fsp--;


            			current.merge(this_SimpleName_0);
            		

            			afterParserOrEnumRuleCall();
            		
            // InternalOCLX.g:2827:3: (kw= '/' this_SimpleName_2= ruleSimpleName )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==32) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalOCLX.g:2828:4: kw= '/' this_SimpleName_2= ruleSimpleName
            	    {
            	    kw=(Token)match(input,32,FOLLOW_4); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getPathAccess().getSolidusKeyword_1_0());
            	    			

            	    				newCompositeNode(grammarAccess.getPathAccess().getSimpleNameParserRuleCall_1_1());
            	    			
            	    pushFollow(FOLLOW_31);
            	    this_SimpleName_2=ruleSimpleName();

            	    state._fsp--;


            	    				current.merge(this_SimpleName_2);
            	    			

            	    				afterParserOrEnumRuleCall();
            	    			

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleArgumentsExp"
    // InternalOCLX.g:2848:1: entryRuleArgumentsExp returns [EObject current=null] : iv_ruleArgumentsExp= ruleArgumentsExp EOF ;
    public final EObject entryRuleArgumentsExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgumentsExp = null;


        try {
            // InternalOCLX.g:2848:53: (iv_ruleArgumentsExp= ruleArgumentsExp EOF )
            // InternalOCLX.g:2849:2: iv_ruleArgumentsExp= ruleArgumentsExp EOF
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
    // InternalOCLX.g:2855:1: ruleArgumentsExp returns [EObject current=null] : ( ( (lv_operators_0_0= ruleExp ) ) (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )* ) ;
    public final EObject ruleArgumentsExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_operators_0_0 = null;

        EObject lv_operators_2_0 = null;



        	enterRule();

        try {
            // InternalOCLX.g:2861:2: ( ( ( (lv_operators_0_0= ruleExp ) ) (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )* ) )
            // InternalOCLX.g:2862:2: ( ( (lv_operators_0_0= ruleExp ) ) (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )* )
            {
            // InternalOCLX.g:2862:2: ( ( (lv_operators_0_0= ruleExp ) ) (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )* )
            // InternalOCLX.g:2863:3: ( (lv_operators_0_0= ruleExp ) ) (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )*
            {
            // InternalOCLX.g:2863:3: ( (lv_operators_0_0= ruleExp ) )
            // InternalOCLX.g:2864:4: (lv_operators_0_0= ruleExp )
            {
            // InternalOCLX.g:2864:4: (lv_operators_0_0= ruleExp )
            // InternalOCLX.g:2865:5: lv_operators_0_0= ruleExp
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

            // InternalOCLX.g:2882:3: (otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==65) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalOCLX.g:2883:4: otherlv_1= ',' ( (lv_operators_2_0= ruleExp ) )
            	    {
            	    otherlv_1=(Token)match(input,65,FOLLOW_13); 

            	    				newLeafNode(otherlv_1, grammarAccess.getArgumentsExpAccess().getCommaKeyword_1_0());
            	    			
            	    // InternalOCLX.g:2887:4: ( (lv_operators_2_0= ruleExp ) )
            	    // InternalOCLX.g:2888:5: (lv_operators_2_0= ruleExp )
            	    {
            	    // InternalOCLX.g:2888:5: (lv_operators_2_0= ruleExp )
            	    // InternalOCLX.g:2889:6: lv_operators_2_0= ruleExp
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
            	    break loop28;
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000000000002C000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x5F8007B4000000D0L,0x000000000000000DL});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000007FFE00002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000800100002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0001F00000000010L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0078000000400000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});

}