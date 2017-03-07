/**
 * Created by HItss on 20/12/2016.
 */

'use strict';
angular
    .module('global-hitss-app')
    .controller('LoginController', function ($scope, $state, $http, $httpParamSerializer, $cookies, access_api_data, LoginService, toaster, $crypto, UtilsService) {
        var lc = $scope;
        lc.user = {};
        lc.bodyClass = 'main-view';

        lc.login = function () {
            if (lc.user.username === undefined || lc.user.password === undefined) {
                toaster.pop({
                    type: 'info',
                    title: 'Es necesario llenar los campos',
                    showCloseButton: true
                });
                lc.clform();
            } else {
                LoginService.login(lc.user)
                    .then(function (data) {
                        $cookies.put("access_token", '?access_token=' + data.data.access_token);
                        LoginService.userdetails(lc.user.username)
                            .then(
                            function (data) {
                                $cookies.put("_payload_name", $crypto.encrypt(data.name + ' ' + data.lastname));
                                $cookies.put("_payload_username", $crypto.encrypt(data.username));
                                lc.clform();
                                $state.go('main.principal');
                            },
                            function (err) {
                                console.log(err);
                            }
                        )
                    },
                    function (err) {
                        toaster.pop({
                            type: 'error',
                            title: err.data.error_description,
                            showCloseButton: true
                        });
                        UtilsService.animateError(angular.element('#login_area'));
                        lc.clform();
                    }
                );
            }
        };

        lc.clform = function () {
            $scope.user.username = undefined;
            $scope.user.password = undefined;
        }


    });