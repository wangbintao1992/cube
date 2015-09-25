var headApp = angular.module('headApp',['ui.router']);
headApp.config(function($stateProvider, $urlRouterProvider){
	$stateProvider.state('main',{
		url:'/main',
		views:{
			'hehe':{
				template:'<div>hehe</div>'
			}
		}
	});
});