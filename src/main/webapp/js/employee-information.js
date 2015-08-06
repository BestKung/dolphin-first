var app = angular.module('employeeInformation', []);
angular.module('employeeInformation').controller('employeeInformationController', function (employeeService, $scope, $http) {
    
    $scope.employees = {};
    $scope.search = {};
    $scope.page = 0;
    $scope.totalRow = 10;
    $scope.totalPage;
    var totalEmployee = 0;

    loadEmployees();

    function loadEmployees() {
        $http.get('/employees', {params: {page: $scope.page, size: $scope.totalRow}})
                .success(function (data) {
                    $scope.employees = data;
                    checkPage();
                }).error(function (data) {

        });
    }

    $scope.loadEmployees = function () {
        $scope.page = 0;
        $http.get('/employees', {params: {page: $scope.page, size: $scope.totalRow}})
                .success(function (data) {
                    $scope.employees = data;
                    checkPage();
                }).error(function (data) {

        });
    };

    countEmployee();
    function countEmployee() {
        $http.get('/employees/count')
                .success(function (data) {
                    totalEmployee = data;
                })
                .error(function (data) {

                });
    }
    $scope.searchEmployee = function () {
        $http.post('/employeesearch', $scope.search)
                .success(function (data) {
                    $scope.employees = data;
                    loadEmployees();
                })
                .error(function (data) {

                });
    };

    function getTotalPage() {
        var totalPageTmp = parseInt(totalEmployee / $scope.totalRow);
        if ((totalEmployee % $scope.totalRow) != 0) {
            totalPageTmp++;
        }
        return totalPageTmp;
    }

    function checkPage() {
        if ($scope.page + 1 == getTotalPage()) {
            $('#next-page').addClass('disabled');
            $('#final-page').addClass('disabled');
        }
        if ($scope.page == 0) {
            $('#first-page').addClass('disabled');
            $('#pre-page').addClass('disabled');
        }
        if (($scope.page + 1 - getTotalPage() != 0) && ($scope.page != 0)) {
            $('#next-page').removeClass('disabled');
            $('#final-page').removeClass('disabled');
            $('#first-page').removeClass('disabled');
            $('#pre-page').removeClass('disabled');
        }
    }

    $scope.prePage = function () {
        if ($scope.page > 0) {
            $scope.page--;
            loadEmployees();
        }
    };
    $scope.nextPage = function () {
        if ($scope.page < getTotalPage() - 1) {
            $scope.page++;
            loadEmployees();
        }
    };

    $scope.finalPage = function () {
        if ($scope.page < getTotalPage() - 1) {
            $scope.page = (getTotalPage() - 1);
            loadEmployees();
            $('#first-page').removeClass('disabled');
            $('#pre-page').removeClass('disabled');
        }
    };

    $scope.firstPage = function () {
        if ($scope.page > 0) {
            $scope.page = 0;
            loadEmployees();
            $('#next-page').removeClass('disabled');
            $('#final-page').removeClass('disabled');
        }
    };

    $scope.getEmployeeDetail = function (employee) {
        employeeService.emp = employee;
   };
});
