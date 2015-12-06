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
			//controller: 'DetailCtrl'
		})
		.state('resources', {
			url: '/resources',
			templateUrl: 'partials/resources.html',
			//controller: 'CartCtrl'
		})
})

// For product listing page
.controller('toBeNamedCtrl',['$scope', function($scope){
	
}])