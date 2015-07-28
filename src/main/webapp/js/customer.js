angular.module('Customer', []);
angular.module('Customer', ['checklist-model'])
        .controller('CustomerController', function ($scope, $http) {
            $scope.customer = {};
            $scope.customers = {};
            $scope.medicalhistorys = {};

            loadCustomer();
            function loadCustomer() {
                $http.get('/customer').success(function (data) {
                    $scope.customers = data;
                }).error(function (data, status, header, config) {

                });
            }
            $scope.saveCustomer = function () {
                $http.post('/customer', $scope.customer).success(function (data) {
                    alert('saveข้อมูลเรียบร้อย');
                }).error(function (data) {
                    $scope.error = data;
                    alert('คุณกรอกข้อมูลไม่เรียบร้อย');
                });
            };
            
            $scope.deleteCustomer = function (rowcustomer){
                $http.post('/customerdelete',rowcustomer).success(function (data){
                    loadCustomer();
                   alert('ลบข้อมูลเรียบร้อย'); 
                }).error(function (data, status, header, config){
                   alert('ลบไม่สำเร็จ'); 
                });
            };
            
            loadMedicalHistory();
            function loadMedicalHistory(){
                $http.get('/medicalhistory').success(function (data){
                   $scope.medicalhistorys = data; 
                }).error(function (data, status, header, config){
                    
                });
            }
        });


