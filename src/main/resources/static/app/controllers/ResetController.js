import UserData from "../models/UserData.js"

const ResetController = [
    "$scope",
    "$log",
    "$http",
    "$window",
    function ($scope, $log, $http, $window) {
        $log.log("ResetController is loaded");

        $scope.stepOneSuccess = false;
        $scope.stepTwoSuccess = false;

        $scope.submitForm = function (){
            $scope.formDisabled = true;
            $http.post("/public/api/reset", $scope.userData)
                .then(function (response){
                    if($scope.stepOne){
                        $scope.stepOneSuccess = (response.data === "OK");
                    }else if ($scope.stepTwo){
                        $scope.stepTwoSuccess = (response.data === "OK");
                    }
                })
                .catch(function(error){
                    $scope.formDisabled = false;
                    $scope.error = error.data.message;
                    $log.error(error);
                });
        }

        $scope.initForm = function(){
            $scope.userData = angular.copy(UserData);

            const query = $window.location.search;
            const params = new URLSearchParams(query);
            $scope.userData.token = params.get("token");
            $scope.userData.email = params.get("email");

            $scope.repeatPassword = "";
            $scope.formDisabled = false;

            $scope.stepTwo = ($scope.userData.token != null);
            $scope.stepOne = !$scope.stepTwo;
            if($scope.resetForm){
                $scope.resetForm.$setPristine();
            }
        }

        $scope.checkPassword = function(){
            $scope.resetForm.repeatpassword.$setValidity("nomatch", ($scope.userData.password === $scope.repeatPassword));
        }

        $scope.initForm();
        return this;
    }
];

export default ResetController;