
var app = angular.module('app', ['ngRoute', 'employee', 'employeeInformation', 'department', 'Customer', 'employeemoredetail']);
app = angular.module('app');

app.controller('homeController', function ($scope, $http) {

    $scope.namelogin = {};
    loadName();
    function loadName(){
        $http.get('/startpage').success(function (data){
            $scope.namelogin = data;
            console.log(data);
        }).error(function (data){});
    }
});

app.config(function ($routeProvider) {

    $routeProvider.when('/', {
        controller: 'homeController',
        templateUrl: 'pages/home.html'

    }).when('/employee', {
        controller: 'employeeController',
        templateUrl: 'pages/employee.html'

    }).when('/employee/information', {
        controller: 'employeeInformationController',
        templateUrl: 'pages/employee-information.html'

    }).when('/department', {
        controller: 'departmentController',
        templateUrl: 'pages/department.html'

    }).when('/customer', {
        controller: 'CustomerController',
        templateUrl: 'pages/customer.html'

    }).when('/tablecustomer', {
        controller: 'CustomerController',
        templateUrl: 'pages/tablecustomer.html'

    }).when('/employee/moredetail', {
        controller: 'employeeMoreDetailController',
        templateUrl: 'pages/employee-moredetail.html'
    }).otherwise({
        redirectTo: '/'
    });

});

app.factory('employeeService', function() {  
	return {
		emp : {}
	};
});
