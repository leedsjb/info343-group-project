/*

*/


'use strict';

angular.module('143app', ['ui.router'])
.config(function($stateProvider, $urlRouterProvider) {

	// for unfound URLs redirect to home
	$urlRouterProvider.otherwise("/");

	$stateProvider
		.state('home', {
			url: '/', // root directory
			templateUrl: 'partials/home.html'
		})	
		.state('calendar', {
			url: '/calendar',
			templateUrl: 'partials/calendar.html',
			//controller: 'OrderCtrl'
		})
		.state('homework', {
			url: '/homework',
			templateUrl: 'partials/homework.html',
			controller: 'AssignmentCtrl'
		})
		.state('resources', {
			url: '/resources',
			templateUrl: 'partials/resources.html',
			//controller: 'CartCtrl'
		})
})

// For assignments page
.controller('AssignmentCtrl',['$scope', '$http',function($scope, $http){
	$http.get('data/assignment-data.json').then(function(response){
		$scope.assignments = response.data;
	});
}])