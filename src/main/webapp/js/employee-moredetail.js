angular.module('employeemoredetail', []);
angular.module('employeemoredetail').controller('employeeMoreDetailController', function (employeeService, $scope, $http) {

var dateToDay = new Date();
var yearToDay = dateToDay.getFullYear();

    $scope.employee = {};
     $scope.employeeDetail = {};
    
    loadEmployeeDetail();
     
    function loadEmployeeDetail() {
        $http.post('/employeedetail', employeeService.emp).success(function (data) {
            $scope.employeeDetail = data;
            $scope.employeeDetail.age = (yearToDay - new Date($scope.employeeDetail.birthDate).getFullYear());
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

$scope.clearService = function (){
    employeeService.emp = {};
};

});