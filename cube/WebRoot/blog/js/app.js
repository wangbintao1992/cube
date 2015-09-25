/*var headApp = angular.module('headApp',['ui.router']);
headApp.config(function($stateProvider, $urlRouterProvider){
	$stateProvider.state('main',{
		url:'/main',
		views:{
			'hehe':{
				template:'<div>hehe</div>'
			}
		}
	});
});*/
var j = jQuery.noConflict();  
j(document).ready(function(){

});

var blog = angular.module("blog", []);

blog.controller('articlesCtrl', function($scope,$http) {
	$http.get('/cube/getArticles.html?type=1').success(function(repo){
	$scope.data = repo});
});

blog.controller('topCtrl', function($scope,$http) {
	$http.get('/cube/getArticles.html?type=0').success(function(repo){
	$scope.data = repo});
});