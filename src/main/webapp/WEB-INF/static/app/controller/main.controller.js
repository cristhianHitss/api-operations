/**
 * Created by HItss on 20/12/2016.
 */

'use strict';
angular
    .module('global-hitss-app')
    .controller('MainController', function ($scope, $cookies, $state, $location) {
        var mc = $scope;

        mc.logout = function logout() {
            $cookies.remove("access_token");
            $state.go('login');
        }

        // Checar la ruta para dar la clase al elemento
        mc.getCurrentClass = function (route) {
            return ($location.path().substr(0, route.length) == route) ? "active" : ""
        };
    });