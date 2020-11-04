import User from "../models/User.js"

const RegisterController = [
    "$scope",
    "$log",
    "$http",
    "$window",
    function ($scope, $log, $http, $window) {
        $log.log("controller is loaded");

        angular.copy(User, $scope.user);
        $scope.repeatEmail = "";
        $scope.repeatPassword = "";

        $scope.checkEmail = function(){
            $scope.registerForm.repeatemail.$setValidity("nomatch", ($scope.user.email == $scope.repeatEmail));
        }
        $scope.checkPassword = function(){
            $scope.registerForm.repeatepassword.$setValidity("nomatch", ($scope.user.password == $scope.repeatPassword));
        }
        $scope.goToLogin = function(){
            $window.location.href = "/login";
        }
        $scope.resetForm = function(){
            angular.copy(User, $scope.user);
            $scope.registerForm.$setPristine()
        }
        $scope.submitForm = function(){
            $http.post("/register/save", $scope.user)
                .success($log.log)
                .error($log.log);
        }


        return this;
    }
];

export default RegisterController;