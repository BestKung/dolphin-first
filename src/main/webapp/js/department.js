angular.module('department', []);
angular.module('department').controller('departmentController', function ($scope, $http) {

    $scope.departments = {};
    $scope.department = {};
    $scope.departmentDelete = {};
    $scope.departmentClick = {};

    loadDepartment();

    function loadDepartment() {
        $http.get('/depaerments', {params: {page: 0, size: 50, }})
                .success(function (data) {
                    $scope.departments = data;
                }).error(function (data) {

        });
    }

    $scope.clear = function () {
        $scope.department = {};
    };
    function validate() {
        if ($scope.department.name == undefined || $scope.department.name == "") {
            growl('Please input Department.', 'danger', 'buttom');
            return false;
        }
        else {
            return true;
        }
    }
    $scope.actionUpdate = function (dep) {
        $scope.department = dep;
        $('body,html').animate({scrollTop: 0}, "600");
    };

    $scope.saveDepartment = function () {
        if (validate()) {
            $http.post('/savedepartment', $scope.department)
                    .success(function (data) {
                        loadDepartment();
                        growl('Save Success', 'success', 'buttom');
                        $scope.department = {};
                    }).error(function (data) {

            });
        }

    };

    $scope.actionDelete = function (department) {
        $scope.departmentDelete = department;
    };

    $scope.deleteDepartment = function () {
        $http.post('/deletedepartment', $scope.departmentDelete)
                .success(function (data) {
                    loadDepartment();
                    growl('Delete Success', 'danger', 'buttom');
                })
                .error(function (data) {

                });
    };
});



