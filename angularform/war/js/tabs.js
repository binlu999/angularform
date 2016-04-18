angular.module('surveyform.edit', ['ngAnimate', 'ui.bootstrap']);
angular.module('surveyform.edit').controller('survey.edit.ctl', function ($scope, $http) {

	$http.get("/res/surveyform?requesttype=forform").then(function(response) {
		$scope.data = response.data;
		console.log("Got form [[" + JSON.stringify($scope.data) + "]]");
	});
	
	$http.get("/res/surveyform?requesttype=forquestiontype").then(function(response) {
		$scope.questionTypes = response.data;
		console.log("Got questionTypes [[" + JSON.stringify($scope.questionTypes) + "]]");
	});
	
	
	$scope.formheaders=["formDescription","companyCode","marketArea","prodCode"]
	$scope.tabs = [
    { title:'Dynamic Title 1', content:'Dynamic content 1' },
    { title:'Dynamic Title 2', content:'Dynamic content 2', disabled: true }
  ];

  $scope.model = {
    name: 'Tabs'
  };
  
  $scope.submitSurvey = function() {
		$scope.code = null;
		$scope.response = null;

		$http({
			method : 'POST',
			url : '/res/surveyform?requesttype=saveform',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : $scope.data
		}).then(function(response) {
			$scope.status = response.status;
			
			console.log("here");
		}, function(response) {
			$scope.data = response.data || "Request failed";
			$scope.status = response.status;
		});
	};
	
});