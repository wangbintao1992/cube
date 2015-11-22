var j = jQuery.noConflict();  

var blog = angular.module("blog", ['ui.router','ui.bootstrap','ngFileUpload','ngDialog','ui.tinymce','ngDialog']);
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
//评论编辑
blog.controller('commentTinymce', function($scope,$http,ngDialog) {
	 $scope.tinymceOptions = {
		       height:'10em'
		    };
	 
	 $scope.dongtan = function(){
		 if(!$scope.content){
			 ngDialog.open({template: "不能发空动弹，说你呢~",plain:true})
			 return false;
		 }
	 }
});
//评论
blog.controller('commentCtrl', function($scope,$http) {
	 j('#comment').vTicker({
         speed: 500,        //滚动速度，单位毫秒。
         pause: 2000,       //暂停时间，就是滚动一条之后停留的时间，单位毫秒。
         showItems:5,     //显示内容的条数。
         animation: 'fade', //动画效果，默认是fade，淡出。
         mousePause: true,  //鼠标移动到内容上是否暂停滚动，默认为true。
         direction: 'up'        //滚动的方向，默认为up向上，down则为向下滚动。
     });
});

//图表
blog.controller('faCtrl', function($scope,$http,data) {
	$scope.flag = false;
    $scope.bar = data;
    $scope.$watch('bar', function(newVal, oldVal) {
	    if (newVal != oldVal) {
	        $scope.flag = newVal.flag;
	        $scope.$broadcast('to-child',newVal.result);  
	    }
	}, true);
});
//饼图
blog.controller('barCtrl', function($scope,$http) {
	$scope.$on('to-child', function(d,data) {  
        bar(formatBarData(data));
    });  
});
//直方图
blog.controller('chartCtrl', function($scope,$http) {
	$scope.$on('to-child', function(d,data) {  
    	columChart(formatColumDate(data));
    });
});
//input源
blog.controller('inputCtrl', function($scope,$http,data,ngDialog) {
	$scope.subBtn = false;
	$scope.input = "";
	$scope.bar = data;
	$scope.submit = function(){
		$scope.subBtn = true;
		if($scope.input != ""){
			$http.get('/cube/inputSource/inputText.html?text=' + encodeURI(encodeURI($scope.input))).success(function(repo){
				$scope.bar.flag = true;
				$scope.bar.result = repo;
				$scope.subBtn = false;
			});
		}else{
			ngDialog.open({
	            template: 'dialog',
	            className: 'ngdialog-theme-default'
	        });
			$scope.subBtn = false;
		}
	}
});
//url源
blog.controller('urlCtrl', function($scope,$http,data,ngDialog) {
	$scope.urlText = "";
	$scope.bar = data;
	$scope.subBtn = false;
	$scope.submit = function(){
		if($scope.urlText != ""){
			$scope.subBtn = true;
			$http.get('/cube/inputSource/webSite.html?url=http://' + $scope.urlText).success(function(repo){
				$scope.bar.flag = true;
				$scope.bar.result = repo;
				$scope.subBtn = false;
			});
		}else{
			ngDialog.open({
	            template: 'dialog',
	            className: 'ngdialog-theme-default'
	        });
			$scope.subBtn = false;
		}
	}
});
//上传
blog.controller('uploadCtrl',function ($scope, Upload, $timeout,ngDialog,data) {
	$scope.bar = data;
	$scope.subBtn = false;
    $scope.uploadFiles = function(file, errFiles) {
        $scope.f = file;
        $scope.errFile = errFiles && errFiles[0];
    }
    $scope.upload = function(){
    	$scope.subBtn = true;
            if ($scope.f) {
                $scope.f.upload = Upload.upload({
                    url: '/cube/inputSource/upload.html',
                    data: {'file':  $scope.f}
                }).success(function (data, status, headers, config) {
                	//成功提示
			        console.log('file ' + $scope.f.name + 'uploaded. Response: ' + data);
			    });
                $scope.f.upload.then(function (response) {
                	if(response.data == '2'){
                		ngDialog.open({
            	            template: '<p>上传文件非法</p>',
            	            plain:true,
            	            className: 'ngdialog-theme-default'
            	        });
                		return;
                	}
                	if(response.data == '1'){
                		ngDialog.open({
            	            template: '<p>处理失败</p>',
            	            plain:true,
            	            className: 'ngdialog-theme-default'
            	        });
                		return;
                	}
                	$scope.bar.flag = true;
    				$scope.bar.result = response.data;
    				$scope.subBtn = false;
                }, function (response) {
                    if (response.status > 0)
                        $scope.errorMsg = response.status + ': ' + response.data;
                }, function (evt) {
                	//进度条
                    $scope.f.progress = Math.min(100, parseInt(100.0 *
                            evt.loaded / evt.total));
                });
            }else{
            	
            }
        }
});

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
blog.factory('data',function(){
	return {flag: false,result:""};
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
/*************************************************jquery**********************************************************/
function columChart(data){
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
            categories: data.xAxis
        },
        series: [{
        	name:"letters",
            data: data.data
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
function bar(data){
    j('#bar').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
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
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
             name:'letter',
            data: data
        }]
    });
}
function formatColumDate(data){
	var result = {xAxis:[],data:[]};
	for(var key in data){
		result.xAxis.push(key);
		result.data.push(parseInt(data[key]));
	}
	return result;
}
function formatBarData(data){
	var result = [];
	for(var key in data){
		var tmp = [];
		tmp.push(key);
		tmp.push(parseInt(data[key]));
		result.push(tmp)
	}
	return result;
}
