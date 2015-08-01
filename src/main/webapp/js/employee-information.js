angular.module('employeeInformation', []);
angular.module('employeeInformation').controller('employeeInformationController', function ($scope, $http) {

    $scope.employees = {};
    var totalEmployee = 0;
     
    countEmployee();
    function countEmployee (){
        $http.get('/totalemployee').
                success(function (data){
            totalEmployee = data;
            console.log(totalEmployee);
        })
                .error(function (data){
            
        });
    }
    loadEmployees();
    
    function loadEmployees() {
        $http.get('/employees')
                .success(function (data) {
                    $scope.employees = data;
            console.log($scope.employees);
            }).error(function (data) {

        });
    }

});