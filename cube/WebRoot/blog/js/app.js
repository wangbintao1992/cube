var headApp = angular.module('headApp',['ui.router']);
headApp.config(function($stateProvider, $urlRouterProvider){
	$StateProvider.state('head',{
		url:'/head',
		templateUrl:'top.jsp'
	});
});