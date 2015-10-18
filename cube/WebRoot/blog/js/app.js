var j = jQuery.noConflict();  
j(document).ready(function(){

});

var blog = angular.module("blog", ['ui.router','ui.bootstrap','ngFileUpload']);
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
		url:'/classic',
		templateUrl:'classic.htm'
	})
	.state('wordCount',{
		url:'/wordCount',
		templateUrl:'wordCount.htm'
	});
});
//进度条
blog.controller('progressCtrl', function ($scope) {
	
});

blog.controller('barCtrl', function($scope,$http) {
	bar();
});
blog.controller('chartCtrl', function($scope,$http) {
	columChart();
});
//input源
blog.controller('inputCtrl', function($scope,$http) {
	$scope.submit = function(){
		alert($scope.input)
	}
});
//url源
blog.controller('urlCtrl', function($scope,$http) {
	$scope.submit = function(){
		$http.get('/cube/inputSource/webSite.html?url=http://' + $scope.urlText).success(function(repo){
		$scope.data = repo.data;
	});
	}
});
//上传
blog.controller('uploadCtrl', ['$scope', 'Upload', '$timeout', function ($scope, Upload, $timeout) {
    $scope.uploadFiles = function(file, errFiles) {
        $scope.f = file;
        $scope.errFile = errFiles && errFiles[0];
    }
    $scope.upload = function(){
            if ($scope.f) {
                $scope.f.upload = Upload.upload({
                    url: '/cube/inputSource/upload.html',
                    data: {'file':  $scope.f}
                }).success(function (data, status, headers, config) {
                	//成功提示
			        console.log('file ' + $scope.f.name + 'uploaded. Response: ' + data);
			    });;

                $scope.f.upload.then(function (response) {
                    $timeout(function () {
                    	//超时处理
                        $scope.f.result = response.data;
                    });
                }, function (response) {
                    if (response.status > 0)
                        $scope.errorMsg = response.status + ': ' + response.data;
                }, function (evt) {
                	//进度条
                    $scope.f.progress = Math.min(100, parseInt(100.0 *
                            evt.loaded / evt.total));
                });
            }else{
            	//空文件处理
            }
        }
}]);

//标签切换待定
/*blog.controller('TabsDemoCtrl', function ($scope, $window) {
	$scope.tabs = [
    { title:'Dynamic Title 1', content:'Dynamic content 1' },
    { title:'Dynamic Title 2', content:'Dynamic content 2', disabled: true }
  ];

  $scope.alertMe = function() {
    setTimeout(function() {
      $window.alert('You\'ve selected the alert tab!');
    });
  };
});*/


//经典
blog.controller('classicCtrl', function ($scope, $log,$http) {
  	$scope.currentPage = 1;
  	var pageSize = 5;
  	$scope.setPage = function (pageNo) {
    	$scope.currentPage = pageNo;
	};
 	$http.get('/cube/articles/getArticles.html?type=3&pageNow=1&pageSize=' + pageSize).success(function(repo){
		$scope.data = repo.data;
		$scope.totalItems = repo.totalCount;
	});
	$scope.pageChanged = function() {
    	$log.log('Page changed to: ' + $scope.currentPage);
    	$http.get('/cube/articles/getArticles.html?type=3&pageNow=' + $scope.currentPage + '&pageSize=' + pageSize).success(function(repo){
			$scope.data = repo.data;
			$scope.totalItems = repo.totalCount;
		});
  	};
});

//排行
blog.controller('articlesCtrl', function($scope,$http) {
	$scope.totalItems = 1;
    $scope.currentPage = 1;
    
    var pageSize = 4;
	$http.get('/cube/articles/getArticles.html?type=1&pageNow=' + $scope.currentPage + '&pageSize=' + pageSize).success(function(repo){
		$scope.data = repo.data;
		$scope.totalItems = repo.totalCount;
	});
	$scope.pageChanged = function() {
    	$http.get('/cube/articles/getArticles.html?type=1&pageNow=' + $scope.currentPage + '&pageSize=' + pageSize).success(function(repo){
			$scope.data = repo.data;
			$scope.totalItems = repo.totalCount;
		});
  	};
});
//首页 
blog.controller('topCtrl', function($scope,$http) {
	$scope.totalItems = 1;
    $scope.currentPage = 1;
    var pageSize = 3;
	$http.get('/cube/articles/getArticles.html?type=0&pageNow=' + $scope.currentPage + '&pageSize=' + pageSize).success(function(repo){
		$scope.data = repo.data;
		$scope.totalItems = repo.totalCount;
	});
	$scope.pageChanged = function() {
    	$http.get('/cube/articles/getArticles.html?type=0&pageNow=' + $scope.currentPage + '&pageSize=' + pageSize).success(function(repo){
			$scope.data = repo.data;
			$scope.totalItems = repo.totalCount;
		});
  	};
});
//单个文章
blog.controller('getSingleArticle', function($scope,$http,$stateParams) {
	var id = $stateParams.id;
	$http.get('/cube/articles/getSingleArticle.html?id=' + id).success(function(repo){
	$scope.data = repo});
});

/*************************************************factory**********************************************************/
blog.factory('',function(){

});
/*************************************************filter**********************************************************/
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

function columChart(){
	var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'columChart',
            type: 'column',
            margin: 75,
            options3d: {
                enabled: true,
                alpha: 15,
                beta: 15,
                depth: 50,
                viewDistance: 25
            }
        },
        title: {
            text: '按键磨损直方图'
        },
        plotOptions: {
            column: {
                depth: 25
            }
        },
        xAxis: {
            categories: [
                'A',
                'B',
                'C'
            ]
        },
        series: [{
            data: [10,20,50]
        }]
    });
    
    j('#R0').on('change', function(){
        chart.options.chart.options3d.alpha = this.value;
        showValues();
        chart.redraw(false);
    });
    j('#R1').on('change', function(){
        chart.options.chart.options3d.beta = this.value;
        showValues();
        chart.redraw(false);
    });

    function showValues() {
        j('#R0-value').html(chart.options.chart.options3d.alpha);
        j('#R1-value').html(chart.options.chart.options3d.beta);
    }
    showValues();
}
function bar(){
	j('#bar').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45,
                beta: 0
            }
        },
        title: {
            text: '按键磨损饼图'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                depth: 35,
                dataLabels: {
                    enabled: true,
                    format: '{point.name}'
                }
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: [
                ['Firefox',   45.0],
                ['IE',       26.8],
                {
                    name: 'Chrome',
                    y: 12.8,
                    sliced: true,
                    selected: true
                },
                ['Safari',    8.5],
                ['Opera',     6.2],
                ['Others',   0.7]
            ]
        }]
    });
}
