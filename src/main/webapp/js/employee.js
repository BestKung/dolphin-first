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
            $('#checp-password').removeClass('glyphicon glyphicon-remove').addClass('glyphicon glyphicon-ok').css('color', '#64dd17');
            return true;
        }
        else if ($scope.passwordMatches != $scope.employee.password) {
            $('#checp-password').removeClass('glyphicon glyphicon-ok').addClass('glyphicon glyphicon-remove').css('color', 'RED');
            return true;
        }
        
    };

    $scope.saveEmployee = function () {
        
            $http.post('/saveemployee', $scope.employee)
                    .success(function (data) {
                        growl("Save Success", "success", 'buttom');
                    })
                    .error(function (data) {
                        $scope.error = data;
                        $('body,html').animate({scrollTop: 0}, "600");
                        validateForm($scope.error);
                    });
        };
    
    $scope.clearError = function (elementValidator) {
        $(elementValidator).removeClass('has-error');
        $scope.error = {};
    };

    function validateForm(data) {
        var email = data.violations.email;
        var currentaddress = data.violations.currentAddress;
        var nameth = data.violations.nameTh;
        var mobile = data.violations.mobile;
        var password = data.violations.password;
        if (email) {
            $('.email').addClass('has-error');
            $('#email').val("").attr('placeholder', data.violations.email.message);
        }
        if (password) {
            $('.password').addClass('has-error');
            $('#password').attr('placeholder', data.violations.password.message);
        }
        if (nameth) {
            $('.nameth').addClass('has-error');
            $('#nameth').attr('placeholder', data.violations.nameTh.message);
        }
        if (mobile) {
            $('.mobile').addClass('has-error');
            $('#mobile').attr('placeholder', data.violations.mobile.message);
        }
        if (currentaddress) {
            $('.currentaddress').addClass('has-error');
            $('#currentaddress').attr('placeholder', data.violations.currentAddress.message);
        }
    };
    
    $('.datepicker.form-control').datepicker({
        changeYear: true,
        yearRange: "-100:+100",
        dateFormat: 'yy-mm-dd'
    });


});