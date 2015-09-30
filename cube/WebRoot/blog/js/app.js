var j = jQuery.noConflict();  
j(document).ready(function(){
	
});

var blog = angular.module("blog", ['ui.router']);
//路由
blog.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.when("", "/main");
	$stateProvider.state('main',{
		url:'/main',
		templateUrl:'main.jsp'
	})
	.state('article',{
		url:'/article/{id}',
		templateUrl:'article.jsp'
	})
	.state('about',{
		url:'/about',
		templateUrl:'about.jsp'
	})
	.state('search',{
		url:'/search',
		templateUrl:'search.jsp'
	});
});
//首页
blog.controller('articlesCtrl', function($scope,$http) {
	$http.get('/cube/getArticles.html?type=1').success(function(repo){
	$scope.data = repo});
});
//排行
blog.controller('topCtrl', function($scope,$http) {
	$http.get('/cube/getArticles.html?type=0').success(function(repo){
	$scope.data = repo});
});
//单个文章
blog.controller('getSingleArticle', function($scope,$http,$stateParams,$filter) {
	var id = $stateParams.id;
	$http.get('/cube/getSingleArticle.html?id=' + id).success(function(repo){
	$scope.data = repo});
});