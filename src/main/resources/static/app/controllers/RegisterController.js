import User from "../models/User.js"
import Countries from "../models/Countries.js";

const RegisterController = [
    "$scope",
    "$log",
    "$http",
    function ($scope, $log, $http) {
        $log.log("RegisterController is loaded");

        $scope.checkEmail = function(){
            $scope.registerForm.repeatemail.$setValidity("nomatch", ($scope.user.email === $scope.repeatEmail));
        }
        $scope.checkPassword = function(){
            $scope.registerForm.repeatpassword.$setValidity("nomatch", ($scope.user.password === $scope.repeatPassword));
        }
        $scope.onCountrySelected = function(country){
            $log.log("new item: "+country);
        }
        $scope.initForm = function(){
            $scope.user = angular.copy(User);
            $scope.countries = angular.copy(Countries);
            $scope.selectedCountry = null;
            $scope.searchCountryText = "";

            $scope.repeatEmail = "";
            $scope.repeatPassword = "";

            $scope.onError = false;
            $scope.onExists = false;
            $scope.onSuccess = false;
            $scope.formDisabled = false;
        }
        $scope.submitForm = function(){
            $scope.onError = false;
            $scope.onExists = false;
            $scope.onSuccess = false;
            $scope.formDisabled = true;
            $http.post("/public/api/register", $scope.user)
                .then(function(response){
                    $log.log(response);
                    if(response.data === "OK"){
                        $scope.onSuccess = true;
                    }
                })
                .catch(function(error){
                    $log.error(error);
                    $scope.formDisabled = false;
                    if(error.data.message === "EXISTS"){
                        $scope.onExists = true;
                    }else {
                        $scope.onError = true;
                    }
                });
        }
        $scope.searchCountry = function(){
            return $scope.searchCountryText ?
                $scope.countries.filter(createFilter($scope.searchCountryText))
                : $scope.countries;
        }
        $scope.$watch("selectedCountry", function(newVal, oldVal){
            if(newVal != null && "name" in newVal){
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

        $scope.initForm();
        return this;
    }
];

export default RegisterController;