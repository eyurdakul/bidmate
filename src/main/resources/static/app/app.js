"use strict"

import RegisterController from "./controllers/RegisterController.js";
import LoginController from "./controllers/LoginController.js";

let app = angular.module("appRoot", ["ngMaterial", "ngMessages"]);

//controllers
app.controller("RegisterController", RegisterController);
app.controller("LoginController", LoginController);

app.config(["$mdGestureProvider", "$mdThemingProvider", function($mdGestureProvider, $mdThemingProvider) {
    $mdGestureProvider.skipClickHijack();
    $mdThemingProvider.theme("default")
        .primaryPalette("blue")
        .accentPalette("orange");
}]);
