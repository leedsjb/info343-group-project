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
			controller: 'CalendarCtrl'
		})
		.state('homework', {
			url: '/homework',
			templateUrl: 'partials/homework.html',
			controller: 'AssignmentCtrl'
		})
		.state('classNotes',{
			url: '/class-notes',
			templateUrl: 'partials/class-notes.html',
			controller: 'ClassNotesCtrl'
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
// For calendar page
.controller('CalendarCtrl', ['$scope', '$http', function($scope, $http) {
	$scope.titleFilter = '';
	$http.get('data/calendar-data.json').then(function(response) {
		$scope.weeks = response.data;
	});
}])
// For class notes page
.controller('ClassNotesCtrl', ['$scope', '$http', function($scope, $http) {
	$http.get('data/lecture-data.json').then(function(response){
		$scope.lectures = response.data;
	})
}])














































