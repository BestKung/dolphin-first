var app = angular.module('app',['ngRoute','employee','employeeInformationtt','department']);
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
    
    }).otherwise({
        redirectTo:'/'
    });
    
});

