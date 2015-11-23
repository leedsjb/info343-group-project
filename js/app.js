angular.module('143app',['ui.router'])
.config(function($stateProvider,$urlRouterProvider){

	// for unfound URLs redirect to home
	$urlRouterProvider.otherwise("/");

	// $stateProvider
	// .state('home',{
	// 	url: '/',
	// 	templateUrl: 'partials/home.html'
	// })
	// .state('orders',{
	// 	abstract: true, // this state holds child states, not displayed on its own
	// 	templateUrl: 'partials/orders.html',
	// })
	// .state('orders.products',{
	// 	url: '/orders',
	// 	templateUrl: 'partials/orders.products.html',
	// 	controller: 'ProductsCtrl'
	// })
	// .state('orders.cart',{
	// 	url: '/orders/cart',
	// 	templateUrl: 'partials/orders.cart.html',
	// 	controller: 'CartCtrl'
	// })
	// .state('orders.detail', {
	// 	url: '/orders/{id}',
	// 	templateUrl: 'partials/orders.bean-detail.html',
	// 	controller: 'DetailCtrl'
	// })
	
})

// For product listing page
.controller('toBeNamedCtrl',['$scope', function($scope){
	
}])