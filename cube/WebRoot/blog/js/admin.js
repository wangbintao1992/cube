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
//添加
admin.controller('addCtrl', function ($scope, Upload, $timeout,ngDialog,$http) {
	if($scope.select){
		$scope.title = $scope.select.title;
	}
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
                    $timeout(function () {
                        file.result = response.data;
                    });
                }, function (response) {
                    alert(response.status);
                }, function (evt) {

                });
            }else{
                $http.get('/cube/articles/save.html',{params:article}).success(function(repo){
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
admin.controller('gridCtrl', function ($scope, $http,ngDialog,obj) {

    $scope.adds = function(){
        var s = $scope.gridApi.selection.getSelectedGridRows();
        var e = s[0].entity;
        alert(e.name);
    }
    
    $scope.modify = function(){
    	var s = $scope.gridApi.selection.getSelectedGridRows();
    	if(s.length != 1){
    		ngDialog.open({template: "<p>请选择1个</p>",plain:true})
    		return;
    	}
    	$scope.select = {};
    	$scope.select.title = s[0].entity.name;
    	ngDialog.open({
            template: 'addForm.htm',
            controller: 'addCtrl',
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
    $scope.gridOptions = {
        enableGridMenu: true,
        columnDefs: [
            { name: 'title' },
            { name: 'summary'},
            { name: 'type'},
            { name: 'viewTimes'},
            { name: 'inputTimes' }
        ],
        onRegisterApi: function( gridApi ){
            $scope.gridApi = gridApi;
        },
        data:[ {
            "name": "Ethel Price",
            "gender": "female",
            "company": "Enersol"
        },
            {
                "name": "Evans Hickman",
                "gender": "male",
                "company": "Parleynet"
            },
            {
                "name": "Dawson Barber",
                "gender": "male",
                "company": "Dymi"
            }
        ]
    };
});
admin.factory('obj',function(){
	return {
		name:''
	}
});
