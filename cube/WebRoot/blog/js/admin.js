var admin = angular.module("admin", ['ui.router','ui.bootstrap','ngFileUpload','ngDialog','ui.grid','ui.grid.selection','ui.tinymce']);

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

admin.controller('addCtrl', function ($scope, $http,ngDialog,$sce) {
    var ctrl = this;
    this.updateHtml = function() {
        ctrl.tinymceHtml = $sce.trustAsHtml(ctrl.tinymce);
    };
})

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
