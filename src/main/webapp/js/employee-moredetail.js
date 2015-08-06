angular.module('employeemoredetail', []);
angular.module('employeemoredetail').controller('employeeMoreDetailController', function (employeeService, $scope, $http) {

    $scope.employee = {};
     $scope.employeeDetail = {};
    loadEmployeeDetail();
    function loadEmployeeDetail() {
        $http.post('/employeedetail', employeeService.emp).success(function (data) {
            $scope.employeeDetail = data;
        });
    }

    $scope.clickDelete = function (employee) {
        $scope.employee = employee;
    };

    $scope.deleteEmployee = function () {
       
        $('.modal-backdrop.in').css({'display': 'none'});
        $('body').css({'overflow-y': 'scroll'});
        $http.post('/deleteemployee', $scope.employee.id)
                .success(function (data) {
                    location.href = '#/employee/information';
                })
                .error(function (data) {

                });
    };

$scope.clickUpdate = function (employeeDetail){
    employeeService.emp = employeeDetail;
};

});