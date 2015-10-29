var admin = angular.module("admin", ['ui.router','ui.bootstrap','ngFileUpload','ngDialog']);

admin.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.when("", "/admin");
	$stateProvider.state('admin',{
		url:'/admin',
		templateUrl:'manage.htm'
	});
});
admin.controller('menuCtrl', function ($scope, $log) {
	$scope.menu = [{title:'test',child:[{title:'ch1'},{title:'ch12'},{title:'ch32'}]},{title:'test2',child:[{title:'ch2'},{title:'ch22'},{title:'ch32'}]}];
	
});