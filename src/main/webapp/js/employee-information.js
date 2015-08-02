angular.module('employeeInformation', []);
angular.module('employeeInformation').controller('employeeInformationController', function ($scope, $http) {

    $scope.employees = {};
    $scope.search = {};
    var totalEmployee = 0;
  
    loadEmployees();
    
    function loadEmployees() {
        $http.get('/employees')
                .success(function (data) {
                    $scope.employees = data;
            console.log($scope.employees);
            }).error(function (data) {

        });
    }
    
    $scope.searchEmployee = function (){
        $http.post('/employeesearch',$scope.search)
                .success(function (data){
                    $scope.employees = data;
                    loadEmployees();
               })
                .error(function (data){
                    
                });
    };
    
  

});