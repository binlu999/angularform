
var fooGlobal = "fooglobaval";

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
	
		 $location.path('/submit');	
		 }

		
	  );
		  
	 
};  

