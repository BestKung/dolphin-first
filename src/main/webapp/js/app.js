
var app = angular.module('app',['ngRoute','employee','employeeInformation','department','Customer']);
app = angular.module('app');

app.controller('homeController',function($scope , $http){
    
});

app.config(function ($routeProvider){
   
    $routeProvider.when('/',{
        controller:'homeController',
        templateUrl:'pages/home.html'
    
    }).when('/employee',{
        controller:'employeeController',
        templateUrl:'pages/employee.html'
    
    }).when('/employee/information',{
        controller:'employeeInformationController',
        templateUrl:'pages/employee-information.html'
   
    }).when('/department',{
        controller:'departmentController',
        templateUrl:'pages/department.html'
    
    }).when('/customer',{
        controller:'CustomerController',
        templateUrl:'pages/customer.html'
    
    }).when('/tablecustomer',{
        controller:'CustomerController',
        templateUrl:'pages/tablecustomer.html'
    
    }).otherwise({
        redirectTo:'/'
    });
    
});

