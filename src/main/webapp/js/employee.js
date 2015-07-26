angular.module('employee', []);
angular.module('employee').controller('employeeController', function ($scope, $http) {
    $scope.authoritys = {};
    $scope.departments = {};
    $scope.employee = {};
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

$scope.saveEmployee = function (){
  $http.post('/saveemployee',$scope.employee)
          .success(function(data){
      console.log("success");
  })
          .error(function(data){
      
  });  
};

    $('.datepicker.form-control').datepicker({
        changeYear: true,
        yearRange: "-100:+100",
        dateFormat: 'yy-mm-dd'
    });
});