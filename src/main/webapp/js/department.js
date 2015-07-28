angular.module('department', []);
angular.module('department').controller('departmentController', function ($scope, $http) {

    $scope.departments = {};
    $scope.department = {};
    $scope.departmentDelete = {};
    $scope.departmentClick = {};

    loadDepartment();

    function loadDepartment() {
        $http.get('/depaerments')
                .success(function (data) {
                    $scope.departments = data;
                }).error(function (data) {

        });
    }

    $scope.clear = function () {
        $scope.department = {};
    };
    function validate(){
        if($scope.department !=  ""){
            growl('Please input Department Name.','danger');
            return false;
        }
        else{
            return true;
        }
    }
    $scope.actionUpdate = function (id, name) {
        $scope.department = {'id': id, 'name': name};
    };

    $scope.saveDepartment = function () {
       if(validate()){
            $http.post('/savedepartment', $scope.department)
                .success(function (data) {
                    loadDepartment();
                    growl('Save Success', 'success');
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
                    growl('Delete Success', 'danger');
                })
                .error(function (data) {

                });
    };




});



