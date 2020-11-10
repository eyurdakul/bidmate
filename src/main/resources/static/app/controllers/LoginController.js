const LoginController = [
    "$scope",
    "$log",
    "$http",
    function ($scope, $log, $http) {
        $log.log("LoginController is loaded");
        return this;
    }
];

export default LoginController;