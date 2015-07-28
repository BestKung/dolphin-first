angular.module('employee', []);
angular.module('employee').controller('employeeController', function ($scope, $http) {
    $scope.authoritys = {};
    $scope.departments = {};
    $scope.employee = {};
    $scope.passwordMatches = "";

    getAuthority();
    function getAuthority() {
        $http.get('/authority')
                .success(function (data) {
                    $scope.authoritys = data;
                })
                .error(function (data) {

                });
    }

    getDepartment();
    function getDepartment() {
        $http.get('/depaerments')
                .success(function (data) {
                    $scope.departments = data;
                })
                .error(function (data) {

                });
    }
    $scope.compairPassword = function () {
        if ($scope.passwordMatches == "" || $scope.employee.password == "") {
            return false;
        }
        if ($scope.passwordMatches == $scope.employee.password) {
            return true;
        }

    };

    $scope.saveEmployee = function () {
        //  if ($scope.compairPassword()) {
        $http.post('/saveemployee', $scope.employee)
                .success(function (data) {
                    growl("Save Success", "success");
                })
                .error(function (data) {
                    $scope.error = data;
                    console.log(data);
                    growl("Error", "danger");
                });
        //  }
    };

    $('.datepicker.form-control').datepicker({
        changeYear: true,
        yearRange: "-100:+100",
        dateFormat: 'yy-mm-dd'
    });
});