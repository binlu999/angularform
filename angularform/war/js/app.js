

var surveyNgApp = angular.module('surveyNgApp', [
                                                 'ngRoute',
                                                 'surveyControllerMod',
                                                 'ngMessages'
                                               ]);


var surveyControllerMod = angular.module('surveyControllerMod', ['surveySvcMod']);

var surveySvcMod = angular.module("surveySvcMod",[]);



// alert('test1b'); 

// alert("cmodBaseUrl app:"+cmodBaseUrl);

surveyNgApp.config(['$routeProvider',
                    function($routeProvider) {
                      $routeProvider.
                        when('/search', {
                          templateUrl: surveyBaseUrl+ '/surveyForm/searchView.html',
                          controller: 'surveySearchCtrl'
                        }).
                        when('/survey', {
                            templateUrl: surveyBaseUrl+ '/surveyForm/surveyView.html',
                            controller: 'surveyViewCtrl'
                          }).  
                              
                        when('/error', {
                             templateUrl: surveyBaseUrl+ '/surveyform/errorView.html',
                             controller: 'surveyErrorCtrl'
                                }).                               
                        otherwise({
                          redirectTo: '/survey'
                        });
                    }]);


// alert('test1ca');
