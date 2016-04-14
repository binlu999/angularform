angular.module('surveyform.edit', ['ngAnimate', 'ui.bootstrap']);
angular.module('surveyform.edit').controller('survey.edit.ctl', function ($scope, $http) {

	$http.get("/res/surveyform?requesttype=forform").then(function(response) {
		$scope.data = response.data;
		console.log("Got data Inside new[[" + JSON.stringify($scope.data) + "]]");
	});
	
	$scope.formheaders=["companyCode","marketArea","prodCode"]
	$scope.tabs = [
    { title:'Dynamic Title 1', content:'Dynamic content 1' },
    { title:'Dynamic Title 2', content:'Dynamic content 2', disabled: true }
  ];

  $scope.model = {
    name: 'Tabs'
  };
});