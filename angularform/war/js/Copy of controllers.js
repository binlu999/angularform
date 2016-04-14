
var fooGlobal = "fooglobaval";
/*
surveyControllerMod.controller('surveySearchCtrl', function ($scope,$rootScope,$http,$location,userSvc) {
		// alert("in cmod search ctrl");
    	$scope.viewName = "survey Search1 View";
    	 
    	$scope.search = userSvc.search;
     
      // submit types - FormSearch, submitName = "Life"
	  $scope.submitSearch = function(submitType,submitName) {
		  // alert("in submit search5");
		  var submitUrl = submitGetReportsListUrl;
		  		  
		  var formErrorF = false;
		  if ((submitType == 'FormSearch')) {
			  if($scope.searchForm.$invalid) {
				  // alert("Please fix errors before submitting.");
				  formErrorF = true;
				  $scope.searchMsg  = {error : {fix: true}};
				  return;
			  }				  
		  }
		  
		  if (!formErrorF) {
			  $scope.searchMsg  = {error : {fix: false}};
		  } 
		  
		  $("#spinner").html(spinImg);
		  
		  userSvc.search.submitType = submitType;
		  userSvc.search.formName = submitName;
		   // FormSearch			  
		  userSvc.search.policyNum = $scope.search.policyNum;		
		  
		  		  		  
		  // var paramUserId = userSvc.userInfo.userId;
		  // submitUrl += "?" + "paramUserId="+paramUserId;
		  submitUrl += "?paramSubmitType="+userSvc.search.submitType;
		  submitUrl += "&paramPolicyNum="+userSvc.search.policyNum;
		 
		  		   
		  // alert ("userSvc.search:"+userSvc.search);
		  // alert("search policyNum:"+userSvc.search.policyNum);		  
		  // var searchCmodUrl = "http://an36882.dnanico1.aniconet.com:10080/CmodProj/adapters/CmodAdapter/cmodSvc/searchCmod";
		 
		  /*  METHOD 1 */
		  
		 $http.get(submitUrl).success(function(data) {
			 
		/*	 // handle for session expired
			 if (isSessionExpired(data)){
				$("#spinner").html('&nbsp;');
				alert("Your session has expired. Please login again."); 				
				window.location = cmodRenderUrl;
				return;
			 } 
			 
			 // handle for error
			 if (isProcessingError(data)) {
				 $("#spinner").html('&nbsp;');
				 $location.path('/error');
				 
				 return;
			 }
			 */
			 userSvc.searchResultsObj = data;
			 console.log(data);   //is here OK?
			 $("#spinner").html('&nbsp;');
			 $location.path('/survey');	
		  });
			  
		 
	  };  
	  
	});


//the survey form
surveyControllerMod.controller('surveyFormCtrl', function ($scope,userSvc) {

    $scope.viewName = "Survey Form View";	
   // $scope.userInfo = userSvc.userInfo;
    $scope.searchResultsObj = userSvc.searchResultsObj;
    $scope.search = userSvc.search;

     
});

surveyControllerMod.controller('surveyViewCtrl', function ($scope,$rootScope,$http,$location,userSvc) {
	$http.get("/res/surveyform")
    .then(function(response) {
      $scope.data = response.data;
      console.log("Got data Inside[["+JSON.stringify($scope.data)+"]]");
    });
	
	console.log("Got data:"+JSON.stringify($scope.data));
	
	$scope.submitSurvey=submitSurveyfunc;
  
});

var submitSurveyfunc = function(submitType,submitName) {

	  var formErrorF = false;

	  
	 $http.get("/res/surveyform").success(function(data) {
	
		 }

		 $location.path('/submit');	
	  });
		  
	 
};  

