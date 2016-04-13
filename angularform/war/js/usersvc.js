
/* JavaScript content from js/usersvc.js in folder js */
/**
 * 
 */

 
surveySvcMod.factory("userSvc", function() {
	var userObj = {};
	
	
	// user search defaults
	  userObj.search = {};
	  userObj.search.submitType = '';
	  
	  userObj.search.policyNum = '';
	  userObj.search.formName = '';
	
	// user results
	  userObj.searchResultsObj = {
			  	resultStatus:'',
			  	
			 // for fields used in data selectedRptObj below
			  	resultData:{}};
	  
	// user selected report
	  userObj.selectedSurveyObj = {};
	  userObj.selectedSurveyObj.surveyName = ''; 	 
      userObj.selectedSurveyObj.SurveyPolicyNum = '';
	   
	  
	return userObj;
});