var admin = angular.module("admin", ['ui.router','ui.bootstrap','ngFileUpload','ngDialog','ui.grid','ui.grid.selection','ui.tinymce']);

admin.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.when("", "/admin");
	$stateProvider.state('admin',{
		url:'/admin',
		templateUrl:'manage.htm'
	}).state('articleMange',{
		url:'/articleMange',
		templateUrl:'articleMange.htm'
	}).state('modify',{
		url:'/modify',
		templateUrl:'articleMange.htm'
	});
});
//菜单
admin.controller('menuCtrl', function ($scope, $http) {
    $http.get('/cube/menu/menus.html').success(function(repo){
        $scope.menu = repo;
    });
});
//更新
admin.controller('updateCtrl', function ($scope, Upload, $timeout,ngDialog,$http) {
	if($scope.select){
		$scope.title = $scope.select.title;
		$scope.summary = $scope.select.summary;
		$scope.type = $scope.select.type;
		$scope.content = $scope.select.content;
		$scope.label = $scope.select.label;
		$scope.id = $scope.select.id;
	}
	$scope.tinymceOptions = {
       height:'50em'
    };
    $scope.submitForm = function(isValid){
    	if(isValid){
            var article = {};
            article.title = ($scope.title);
            article.summary = ($scope.summary);
            article.type = ($scope.type);
            article.content = $scope.content;
            article.label = ($scope.label);
            article.id = $scope.id;
            if($scope.f){
                article.file = $scope.f;
                $scope.f.upload = Upload.upload({
                    url: '/cube/articles/updateWithFile.html',
                    data: article
                });
                $scope.f.upload.then(function (repo) {
                	var msg = '<p>更新失败</p>';
                	if(repo.data == "0"){
                		 msg = '<p>更新成功</p>';
                		 $scope.closeThisDialog("success");
                	}
                	ngDialog.open({template: msg,plain:true})
                }, function (response) {
                    alert(response.status);
                }, function (evt) {

                });
            }else{
            	$http({
	            	method:'post',
	            	url:'/cube/articles/update.html',
	            	data:param(article),
	            	headers : { 'Content-Type': 'application/x-www-form-urlencoded' }}).success(function(repo){
	            		var msg = '<p>更新失败</p>';
	                	if(repo == "0"){
	                		 msg = '<p>更新成功</p>';
	                		 $scope.closeThisDialog("success");
	                	}
	                	ngDialog.open({template: msg,plain:true})
	            	});
            }
        }else{
            ngDialog.open({
                template: '<p>表单非法</p>',
                plain:true,
                className: 'ngdialog-theme-default'
            });
        }
    }

    $scope.uploadFiles = function(file, errFiles) {
        $scope.f = file;
    }
});
//添加
admin.controller('addCtrl', function ($scope, Upload, $timeout,ngDialog,$http) {
	$scope.tinymceOptions = {
       height:'50em'
    };
    $scope.submitForm = function(isValid){
    	if(isValid){
            var article = {};
            article.title = $scope.title;
            article.summary = $scope.summary;
            article.type = $scope.type;
            article.content = $scope.content;
            article.label = $scope.label;
            if($scope.f){
                article.file = $scope.f;
                $scope.f.upload = Upload.upload({
                    url: '/cube/articles/saveWithFile.html',
                    data: article
                });
                $scope.f.upload.then(function (response) {
                	var msg = '<p>更新失败</p>';
                	if(repo.data == "0"){
                		 msg = '<p>更新成功</p>';
                		 $scope.closeThisDialog("success");
                	}
                	ngDialog.open({template: msg,plain:true})
                }, function (response) {
                    alert(response.status);
                }, function (evt) {

                });
            }else{
            	$http({
	            	method:'post',
	            	url:'/cube/articles/save.html',
	            	data:param(article),
	            	headers : { 'Content-Type': 'application/x-www-form-urlencoded' }}).success(function(repo){
	            		var msg = '<p>添加失败</p>';
	                	if(repo == "0"){
	                		 msg = '<p>添加成功</p>';
	                		 $scope.closeThisDialog("success");
	                	}
	                	ngDialog.open({template: msg,plain:true})
	            	});
            }
        }else{
            ngDialog.open({
                template: '<p>表单非法</p>',
                plain:true,
                className: 'ngdialog-theme-default'
            });
        }
    }

    $scope.uploadFiles = function(file, errFiles) {
        $scope.f = file;
    }
});
admin.controller('gridCtrl', function ($scope, $http,ngDialog,$log) {
	
	$scope.remove = function(){
		var s = $scope.gridApi.selection.getSelectedGridRows();
    	if(s.length != 1){
    		ngDialog.open({template: "<p>请选择1个</p>",plain:true})
    		return;
    	}
    	$http.get("/cube/articles/delete.html?id=" + s[0].entity.id).success(function(repo){
    		var msg = '<p>删除失败</p>';
        	if(repo == 0){
        		 msg = '<p>删除成功</p>';
        		 $scope.closeThisDialog("success");
        	}
        	ngDialog.open({template: msg,plain:true})
    	});
	}
    
    $scope.modify = function(){
    	var s = $scope.gridApi.selection.getSelectedGridRows();
    	if(s.length != 1){
    		ngDialog.open({template: "<p>请选择1个</p>",plain:true})
    		return;
    	}
    	$scope.select = {};
    	$scope.select.title = s[0].entity.title;
    	$scope.select.summary = s[0].entity.summary;
    	$scope.select.type = s[0].entity.type;
    	$scope.select.content = s[0].entity.content;
    	$scope.select.label = s[0].entity.label;
    	$scope.select.id = s[0].entity.id;
    	ngDialog.open({
            template: 'modifyForm.htm',
            controller: 'updateCtrl',
            closeByEscape: false,
        	closeByDocument: false,
        	scope:$scope,
            className: 'ngdialog-theme-default'
        });
    }
    
    $scope.add = function(){
        ngDialog.open({
            template: 'addForm.htm',
            controller: 'addCtrl',
            closeByEscape: false,
        	closeByDocument: false,
        	scope:$scope,
            className: 'ngdialog-theme-default'
        });
    }
    
    $scope.currentPage = 1;
  	var pageSize = 10;
  	$scope.setPage = function (pageNo) {
    	$scope.currentPage = pageNo;
	};
 	$http.get('/cube/articles/getArticles.html?type=3&pageNow=1&pageSize=' + pageSize).success(function(repo){
 		$scope.gridOptions.data = repo.data;
		$scope.totalItems = repo.totalCount;
	});
	$scope.pageChanged = function() {
    	$log.log('Page changed to: ' + $scope.currentPage);
    	$http.get('/cube/articles/getArticles.html?type=3&pageNow=' + $scope.currentPage + '&pageSize=' + pageSize).success(function(repo){
    		$scope.gridOptions.data = repo.data;
    		$scope.totalItems = repo.totalCount;
		});
  	};
    
    $scope.gridOptions = {
        enableGridMenu: true,
        columnDefs: [
            { name: 'id' },
            { name: 'title' },
            { name: 'summary'},
            { name: 'type'},
            { name: 'viewTimes'},
            { name: 'inputTimes' }
        ],
        onRegisterApi: function( gridApi ){
            $scope.gridApi = gridApi;
        }
    };
});
var param = function(obj) {
    var query = '', name, value, fullSubName, subName, subValue, innerObj, i;
      
    for(name in obj) {
      value = obj[name];
        
      if(value instanceof Array) {
        for(i=0; i<value.length; ++i) {
          subValue = value[i];
          fullSubName = name + '[' + i + ']';
          innerObj = {};
          innerObj[fullSubName] = subValue;
          query += param(innerObj) + '&';
        }
      }
      else if(value instanceof Object) {
        for(subName in value) {
          subValue = value[subName];
          fullSubName = name + '[' + subName + ']';
          innerObj = {};
          innerObj[fullSubName] = subValue;
          query += param(innerObj) + '&';
        }
      }
      else if(value !== undefined && value !== null)
        query += encodeURIComponent(name) + '=' + encodeURIComponent(value) + '&';
    }
      
    return query.length ? query.substr(0, query.length - 1) : query;
  };
