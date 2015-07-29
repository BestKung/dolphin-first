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
        if ($scope.compairPassword()) {
            $http.post('/saveemployee', $scope.employee)
                    .success(function (data) {
                        growl("Save Success", "success");
                    })
                    .error(function (data) {
                        $scope.error = data;
                        $('body').animate({scrollTop: 0}, "600");
                        validateForm($scope.error);
                     });

        }
        else {
            growl("Plase Input Password", "danger",'top');
        }

    };

    $scope.clearError = function (elementValidator) {
        $(elementValidator).removeClass('has-error');
    };

    function validateForm(data) {
        var email = data.violations.email;
        var currentaddress = data.violations.currentAddress;
        var nameth = data.violations.nameTh;
        var mobile = data.violations.mobile;
        if (email) {
            $('.email').addClass('has-error');
            $('#email').val("").attr('placeholder', data.violations.email.message);
        }
        if (nameth) {
            $('.nameth').addClass('has-error');
            $('#nameth').val("").attr('placeholder', data.violations.nameTh.message);
        }
        if (mobile) {
            $('.mobile').addClass('has-error');
            $('#mobile').val("").attr('placeholder', data.violations.mobile.message);
        }
        if (currentaddress) {
            $('.currentaddress').addClass('has-error');
            $('#currentaddress').val("").attr('placeholder', data.violations.currentAddress.message);
        }
    }
    ;

    $('.datepicker.form-control').datepicker({
        changeYear: true,
        yearRange: "-100:+100",
        dateFormat: 'yy-mm-dd'
    });


});