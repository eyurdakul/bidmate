import User from "../models/User.js"
import Countries from "../models/Countries.js";

const RegisterController = [
    "$scope",
    "$log",
    "$http",
    "$window",
    function ($scope, $log, $http, $window) {
        $log.log("RegisterController is loaded");

        $scope.user = angular.copy(User);
        $scope.countries = angular.copy(Countries);
        $scope.selectedCountry = null;
        $scope.searchCountryText = "";

        $scope.repeatEmail = "";
        $scope.repeatPassword = "";

        $scope.onError = true;
        $scope.onExists = true;
        $scope.onSuccess = true;

        $scope.checkEmail = function(){
            $scope.registerForm.repeatemail.$setValidity("nomatch", ($scope.user.email == $scope.repeatEmail));
        }
        $scope.checkPassword = function(){
            $scope.registerForm.repeatepassword.$setValidity("nomatch", ($scope.user.password == $scope.repeatPassword));
        }
        $scope.onCountrySelected = function(country){
            $log.log("new item: "+country);
        }
        $scope.resetForm = function(){
            $scope.user = angular.copy(User);
            $scope.repeatEmail = "";
            $scope.repeatPassword = "";
            $scope.registerForm.$setPristine()
        }
        $scope.submitForm = function(){
            $http.post("/public/api/register", $scope.user)
                .success($log.log)
                .error($log.log);
        }
        $scope.searchCountry = function(){
            return $scope.searchCountryText ?
                $scope.countries.filter(createFilter($scope.searchCountryText))
                : $scope.countries;
        }
        $scope.$watch("selectedCountry", function(newVal, oldVal){
            if("name" in newVal){
                $scope.user.country = newVal.name;
            }
        }, true);
        //private functions
        function createFilter(query) {
            let lowercaseQuery = query.toLowerCase();

            return function filterFn(country) {
                return (country.name.toLowerCase().indexOf(lowercaseQuery) === 0);
            };
        }

        return this;
    }
];

export default RegisterController;