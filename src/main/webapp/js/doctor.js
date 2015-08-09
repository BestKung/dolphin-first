angular.module('doctor',[]);
angular.module('doctor').controller('doctorController', function ($scope , $http){
    
    $scope.doctor = {};
    
    $scope.saveDoctor = function (){
        $http.post('/savedoctor',$scope.doctor).success(function (data){
            
        }).error();
    };
});