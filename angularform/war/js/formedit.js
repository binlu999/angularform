surveyControllerMod.controller('surveyEditCtrl', [ '$scope', '$http', function($scope, $http) {
	
	$http.get("/res/surveyform?requesttype=forform").then(function(response) {
		$scope.data = response.data;
		console.log("Got data Inside new[[" + JSON.stringify($scope.data) + "]]");
	});
	

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

			$scope.updateModel = function(method, url) {
				$scope.method = method;
				$scope.url = url;
			};
		} ]);
