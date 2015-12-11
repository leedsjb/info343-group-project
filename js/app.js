/*
Brian Luu, Benjamin Leeds, Brittney Hoy, Brooks Lobe
December  9 2015
Info 343 B: Joel Ross
.js file for Final Group Project
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
		})

})

// For assignments page
.controller('AssignmentCtrl',['$scope', '$http',function($scope, $http){
	$http.get('data/assignment-data.json').then(function(response){
		$scope.assignments = response.data;
	});
	$scope.hwLink = function(hw) {
		window.location = hw;
	}
}])
// For calendar page
.controller('CalendarCtrl', ['$scope', '$http', function($scope, $http) {
	$scope.titleFilter = '';
	$http.get('data/calendar-data.json').then(function(response) {
		$scope.weeks = response.data;
	});

	$scope.test = function(day){

		if($scope.titleFilter.length == 0){
			return true;
		} else if (!day.code) { // if current day has no Java files
			return false;
		}else {

			// for each object 
			for(var i = 0 ; i < day.code.length ; i++){
				if(day.code[i].title.toLowerCase().indexOf( $scope.titleFilter.toLowerCase() )  != -1){
					return true;
				}
			}
			return false;
		}
	};
}])
// For class notes page
.controller('ClassNotesCtrl', ['$scope', '$http', function($scope, $http) {
	$http.get('data/lecture-data.json').then(function(response){
		$scope.lectures = response.data;
	})
}])














































