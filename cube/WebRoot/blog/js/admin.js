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
            article.lable = $scope.lable;
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
                    if (response.status > 0)
                        $scope.errorMsg = response.status + ': ' + response.data;
                }, function (evt) {

                });
            }else{
                $http.get('/cube/articles/save.html',{params:article}).success(function(repo){
                    $scope.menu = repo;
                });
            }
        }else{
            ngDialog.open({
                template: '<p>呵呵</p>',
                plain:true,
                className: 'ngdialog-theme-default'
            });
        }
    }

    $scope.uploadFiles = function(file, errFiles) {
        $scope.f = file;
    }
});
admin.controller('gridCtrl', function ($scope, $http,ngDialog) {

    $scope.adds = function(){
        var s = $scope.gridApi.selection.getSelectedGridRows();
        var e = s[0].entity;
        alert(e.name);
    }
    
    $scope.add = function(){
        ngDialog.open({
            template: 'addForm.htm',
            controller: 'addCtrl',
            closeByEscape: false,
        	closeByDocument: false,
            className: 'ngdialog-theme-default'
        });
    }
    $scope.gridOptions = {
        enableGridMenu: true,
        columnDefs: [
            { name: 'name' },
            { name: 'gender'},
            { name: 'company' }
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
