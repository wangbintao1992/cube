var admin = angular.module("admin", ['ui.router','ui.bootstrap','ngFileUpload','ngDialog']);

admin.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.when("", "/admin");
	$stateProvider.state('admin',{
		url:'/admin',
		templateUrl:'manage.htm'
	}).state('articleMange',{
		url:'/articleMange',
		templateUrl:'articleMange.htm'
	});;
});
admin.controller('menuCtrl', function ($scope, $log) {
	$scope.menu = [{title:'test',child:[{title:'ch1',url:'articleMange'},{title:'ch12',url:'articleMange'},{title:'ch32',url:'articleMange'}]},{title:'test2',child:[{title:'ch2',url:'articleMange'},{title:'ch22',url:'articleMange'},{title:'ch32',url:'articleMange'}]}];
	
});