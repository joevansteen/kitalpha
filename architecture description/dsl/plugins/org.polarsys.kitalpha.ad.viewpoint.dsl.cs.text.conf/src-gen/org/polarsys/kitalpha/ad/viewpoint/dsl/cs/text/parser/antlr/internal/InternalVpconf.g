/*
* generated by Xtext
*/
grammar InternalVpconf;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.polarsys.kitalpha.ad.viewpoint.dsl.cs.text.services.VpconfGrammarAccess;

}

@parser::members {

 	private VpconfGrammarAccess grammarAccess;
 	
    public InternalVpconfParser(TokenStream input, VpconfGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Configuration";	
   	}
   	
   	@Override
   	protected VpconfGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleConfiguration
entryRuleConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConfigurationRule()); }
	 iv_ruleConfiguration=ruleConfiguration 
	 { $current=$iv_ruleConfiguration.current; } 
	 EOF 
;

// Rule Configuration
ruleConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getConfigurationAccess().getConfigurationAction_0(),
            $current);
    }
)	otherlv_1='Configuration' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getConfigurationAccess().getConfigurationKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConfigurationAccess().getNameFQNParserRuleCall_2_0()); 
	    }
		lv_name_2_0=ruleFQN		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConfigurationRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"FQN");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3='{' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getConfigurationAccess().getLeftCurlyBracketKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConfigurationAccess().getVpConfigurationElementsConfigurationElementParserRuleCall_4_0()); 
	    }
		lv_vpConfigurationElements_4_0=ruleConfigurationElement		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConfigurationRule());
	        }
       		add(
       			$current, 
       			"vpConfigurationElements",
        		lv_vpConfigurationElements_4_0, 
        		"ConfigurationElement");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getConfigurationAccess().getRightCurlyBracketKeyword_5());
    }
)
;





// Entry rule entryRuleConfigurationElement
entryRuleConfigurationElement returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConfigurationElementRule()); }
	 iv_ruleConfigurationElement=ruleConfigurationElement 
	 { $current=$iv_ruleConfigurationElement.current; } 
	 EOF 
;

// Rule ConfigurationElement
ruleConfigurationElement returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getConfigurationElementAccess().getTargetApplicationParserRuleCall_0()); 
    }
    this_TargetApplication_0=ruleTargetApplication
    { 
        $current = $this_TargetApplication_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getConfigurationElementAccess().getGenerationConfigurationParserRuleCall_1()); 
    }
    this_GenerationConfiguration_1=ruleGenerationConfiguration
    { 
        $current = $this_GenerationConfiguration_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getConfigurationElementAccess().getGenerationParserRuleCall_2()); 
    }
    this_Generation_2=ruleGeneration
    { 
        $current = $this_Generation_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleTargetApplication
entryRuleTargetApplication returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTargetApplicationRule()); }
	 iv_ruleTargetApplication=ruleTargetApplication 
	 { $current=$iv_ruleTargetApplication.current; } 
	 EOF 
;

// Rule TargetApplication
ruleTargetApplication returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getTargetApplicationAccess().getTargetApplicationAction_0(),
            $current);
    }
)	otherlv_1='target' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTargetApplicationAccess().getTargetKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTargetApplicationAccess().getTypeTargetApplicationTypeParserRuleCall_2_0()); 
	    }
		lv_type_2_0=ruleTargetApplicationType		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTargetApplicationRule());
	        }
       		set(
       			$current, 
       			"type",
        		lv_type_2_0, 
        		"TargetApplicationType");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleGenerationConfiguration
entryRuleGenerationConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGenerationConfigurationRule()); }
	 iv_ruleGenerationConfiguration=ruleGenerationConfiguration 
	 { $current=$iv_ruleGenerationConfiguration.current; } 
	 EOF 
;

// Rule GenerationConfiguration
ruleGenerationConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getGenerationConfigurationAccess().getGenerationConfigurationAction_0(),
            $current);
    }
)	otherlv_1='project' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getGenerationConfigurationAccess().getProjectKeyword_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGenerationConfigurationAccess().getProjectNameFQNParserRuleCall_2_0()); 
	    }
		lv_projectName_2_0=ruleFQN		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGenerationConfigurationRule());
	        }
       		set(
       			$current, 
       			"projectName",
        		lv_projectName_2_0, 
        		"FQN");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_3='nsuri' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getGenerationConfigurationAccess().getNsuriKeyword_3_0());
    }
(
(
		lv_nsuri_4_0=RULE_STRING
		{
			newLeafNode(lv_nsuri_4_0, grammarAccess.getGenerationConfigurationAccess().getNsuriSTRINGTerminalRuleCall_3_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getGenerationConfigurationRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"nsuri",
        		lv_nsuri_4_0, 
        		"STRING");
	    }

)
))?)
;





// Entry rule entryRuleGeneration
entryRuleGeneration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGenerationRule()); }
	 iv_ruleGeneration=ruleGeneration 
	 { $current=$iv_ruleGeneration.current; } 
	 EOF 
;

// Rule Generation
ruleGeneration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getGenerationAccess().getGenerationAction_0(),
            $current);
    }
)	otherlv_1='generation' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getGenerationAccess().getGenerationKeyword_1());
    }
	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getGenerationAccess().getLeftCurlyBracketKeyword_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGenerationAccess().getOwnedDataGenerationConfGDataParserRuleCall_3_0()); 
	    }
		lv_ownedDataGenerationConf_3_0=ruleGData		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGenerationRule());
	        }
       		set(
       			$current, 
       			"ownedDataGenerationConf",
        		lv_ownedDataGenerationConf_3_0, 
        		"GData");
	        afterParserOrEnumRuleCall();
	    }

)
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getGenerationAccess().getOwnedExtensionGenConfExtensionGeneratrionConfigurationParserRuleCall_4_0()); 
	    }
		lv_ownedExtensionGenConf_4_0=ruleExtensionGeneratrionConfiguration		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGenerationRule());
	        }
       		add(
       			$current, 
       			"ownedExtensionGenConf",
        		lv_ownedExtensionGenConf_4_0, 
        		"ExtensionGeneratrionConfiguration");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_5='}' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getGenerationAccess().getRightCurlyBracketKeyword_5());
    }
)
;





// Entry rule entryRuleGData
entryRuleGData returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getGDataRule()); }
	 iv_ruleGData=ruleGData 
	 { $current=$iv_ruleGData.current; } 
	 EOF 
;

// Rule GData
ruleGData returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getGDataAccess().getGDataAction_0(),
            $current);
    }
)	otherlv_1='data' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getGDataAccess().getDataKeyword_1());
    }
	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getGDataAccess().getLeftParenthesisKeyword_2());
    }
((	otherlv_3='Model:' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getGDataAccess().getModelKeyword_3_0_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getModelEBooleanParserRuleCall_3_0_1_0()); 
	    }
		lv_model_4_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"model",
        		lv_model_4_0, 
        		"EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_5='Edit:' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getGDataAccess().getEditKeyword_3_1_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getEditEBooleanParserRuleCall_3_1_1_0()); 
	    }
		lv_edit_6_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"edit",
        		lv_edit_6_0, 
        		"EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_7='Editor:' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getGDataAccess().getEditorKeyword_3_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getEditorEBooleanParserRuleCall_3_2_1_0()); 
	    }
		lv_editor_8_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"editor",
        		lv_editor_8_0, 
        		"EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_9='Test:' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getGDataAccess().getTestKeyword_3_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getTestEBooleanParserRuleCall_3_3_1_0()); 
	    }
		lv_test_10_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"test",
        		lv_test_10_0, 
        		"EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_11='Javadoc:' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getGDataAccess().getJavadocKeyword_3_4_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getJavaDocEBooleanParserRuleCall_3_4_1_0()); 
	    }
		lv_javaDoc_12_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"javaDoc",
        		lv_javaDoc_12_0, 
        		"EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?(	otherlv_13='OverwriteEcore:' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getGDataAccess().getOverwriteEcoreKeyword_3_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getGDataAccess().getOverwriteEcoreEBooleanParserRuleCall_3_5_1_0()); 
	    }
		lv_overwriteEcore_14_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getGDataRule());
	        }
       		set(
       			$current, 
       			"overwriteEcore",
        		lv_overwriteEcore_14_0, 
        		"EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))?)	otherlv_15=')' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getGDataAccess().getRightParenthesisKeyword_4());
    }
)
;





// Entry rule entryRuleExtensionGeneratrionConfiguration
entryRuleExtensionGeneratrionConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getExtensionGeneratrionConfigurationRule()); }
	 iv_ruleExtensionGeneratrionConfiguration=ruleExtensionGeneratrionConfiguration 
	 { $current=$iv_ruleExtensionGeneratrionConfiguration.current; } 
	 EOF 
;

// Rule ExtensionGeneratrionConfiguration
ruleExtensionGeneratrionConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

    { 
        newCompositeNode(grammarAccess.getExtensionGeneratrionConfigurationAccess().getDiagramGenerationConfigurationParserRuleCall()); 
    }
    this_DiagramGenerationConfiguration_0=ruleDiagramGenerationConfiguration
    { 
        $current = $this_DiagramGenerationConfiguration_0.current; 
        afterParserOrEnumRuleCall();
    }

;





// Entry rule entryRuleDiagramGenerationConfiguration
entryRuleDiagramGenerationConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getDiagramGenerationConfigurationRule()); }
	 iv_ruleDiagramGenerationConfiguration=ruleDiagramGenerationConfiguration 
	 { $current=$iv_ruleDiagramGenerationConfiguration.current; } 
	 EOF 
;

// Rule DiagramGenerationConfiguration
ruleDiagramGenerationConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getDiagramGenerationConfigurationAccess().getDiagramGenerationConfigurationAction_0(),
            $current);
    }
)	otherlv_1='diagram' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getDiagramGenerationConfigurationAccess().getDiagramKeyword_1());
    }
	otherlv_2='(' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getDiagramGenerationConfigurationAccess().getLeftParenthesisKeyword_2());
    }
(	otherlv_3='overwriteOdesign:' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getDiagramGenerationConfigurationAccess().getOverwriteOdesignKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getDiagramGenerationConfigurationAccess().getOverwriteVSMEBooleanParserRuleCall_3_1_0()); 
	    }
		lv_overwriteVSM_4_0=ruleEBoolean		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getDiagramGenerationConfigurationRule());
	        }
       		set(
       			$current, 
       			"overwriteVSM",
        		lv_overwriteVSM_4_0, 
        		"EBoolean");
	        afterParserOrEnumRuleCall();
	    }

)
))	otherlv_5=')' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getDiagramGenerationConfigurationAccess().getRightParenthesisKeyword_4());
    }
)
;





// Entry rule entryRuleTargetApplicationType
entryRuleTargetApplicationType returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getTargetApplicationTypeRule()); } 
	 iv_ruleTargetApplicationType=ruleTargetApplicationType 
	 { $current=$iv_ruleTargetApplicationType.current.getText(); }  
	 EOF 
;

// Rule TargetApplicationType
ruleTargetApplicationType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:

	kw='EMF' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getTargetApplicationTypeAccess().getEMFKeyword()); 
    }

    ;







// Entry rule entryRuleFQN
entryRuleFQN returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getFQNRule()); } 
	 iv_ruleFQN=ruleFQN 
	 { $current=$iv_ruleFQN.current.getText(); }  
	 EOF 
;

// Rule FQN
ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
    }
(( RULE_ID)=>    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1()); 
    }
))*)
    ;





// Entry rule entryRuleEBoolean
entryRuleEBoolean returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getEBooleanRule()); } 
	 iv_ruleEBoolean=ruleEBoolean 
	 { $current=$iv_ruleEBoolean.current.getText(); }  
	 EOF 
;

// Rule EBoolean
ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	kw='true' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
    }

    |
	kw='false' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 
    }
)
    ;







RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;

