var j = jQuery.noConflict();  
j(document).ready(function(){
	
});

var blog = angular.module("blog", ['ui.router','ui.bootstrap']);
//路由
blog.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.when("", "/main");
	$stateProvider.state('main',{
		url:'/main',
		templateUrl:'main.htm'
	})
	.state('article',{
		url:'/article/{id}',
		templateUrl:'article.htm'
	})
	.state('about',{
		url:'/about',
		templateUrl:'about.htm'
	})
	.state('search',{
		url:'/search',
		templateUrl:'search.htm'
	})
	.state('classic',{
		url:'classic',
		templateUrl:'classic.htm'
	});
});
//经典
blog.controller('classicCtrl', function ($scope, $log,$http) {
  	$scope.currentPage = 1;
  	$scope.maxSize = 5;
  
 	$http.get('/cube/getArticles.html?type=3&pageNow=1&pageSize=' + $scope.maxSize).success(function(repo){
		$scope.data = repo.data;
		//
		$scope.maxSize = repo.totalCount >= 5 ? 5 : repo.totalCount / 5;
		$scope.totalItems = repo.totalCount;
	});
  
	$scope.setPage = function (pageNo) {
    	$scope.currentPage = pageNo;
	};

	$scope.pageChanged = function() {
    	$log.log('Page changed to: ' + $scope.currentPage);
    	$http.get('/cube/getArticles.html?type=3&pageNow=' + $scope.currentPage + '&pageSize=' + $scope.maxSize).success(function(repo){
			$scope.data = repo.data;
			//
			$scope.maxSize = repo.totalCount >= 2 ? 5 : repo.totalCount / 5;
			$scope.totalItems = repo.totalCount;
		});
  	};
});

//排行
blog.controller('articlesCtrl', function($scope,$http) {
	var pageNow = 1;
	var pageSize = 4;
	$scope.page = function(param) {
	      pageNow = pageNow + param <= 0 ? 1 : pageNow + param; 
	      $http.get('/cube/getArticles.html?type=1&pageNow=' + pageNow + '&pageSize=' + pageSize).success(function(repo){
	    	  $scope.data = repo}
	      );
	};
	$http.get('/cube/getArticles.html?type=1&pageNow=' + pageNow + '&pageSize=' + pageSize).success(function(repo){
	$scope.data = repo});
});
//首页 
blog.controller('topCtrl', function($scope,$http) {
	$http.get('/cube/getArticles.html?type=0&pageNow=1&pageSize=2').success(function(repo){
	$scope.data = repo});
});
//单个文章
blog.controller('getSingleArticle', function($scope,$http,$stateParams) {
	var id = $stateParams.id;
	$http.get('/cube/getSingleArticle.html?id=' + id).success(function(repo){
	$scope.data = repo});
});
//日期格式化
blog.filter('cnDate', function() {
    var isDate = function(date) {
        return ( (new Date(date) !== "Invalid Date" && !isNaN(new Date(date)) ));
    };
    var addPrefix = function(num) {
        if(num < 10) {
            num = '0' + num;
        }
        return num;
    };

    return function(input) {
        if(!isDate(input)) {
            return '时间都去哪了';
        } else {
            var date = new Date(input);
            return date.getFullYear() + '-' + addPrefix(date.getMonth() + 1) + '-' + addPrefix(date.getDate());
        }
    };
});