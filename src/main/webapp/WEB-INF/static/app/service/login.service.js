/**
 * Created by HItss on 21/12/2016.
 */

'use strict';
angular
    .module('global-hitss-app')
    .factory('LoginService', function ($http, $q, AppUrlPath, access_api_data, $httpParamSerializer, headers_data, headers_data_json, $cookies) {
        var factory = {
            login: login,
            userdetails: userdetails
        };
        return factory;

        function login(user) {
            var data_client = {
                grant_type: "password",
                username: user.username,
                password: user.password,
                client_id: access_api_data.client_id
            };
            var req = {
                method: 'POST',
                url: AppUrlPath + '/oauth/token',
                headers: headers_data,
                data: $httpParamSerializer(data_client)
            }
            var deferred = $q.defer();
            $http(req).then(
                function (data) {
                    deferred.resolve(data);
                }, function (err) {
                    deferred.reject(err);
                });
            return deferred.promise;
        }

        function userdetails(username) {
            var req = {
                method: 'GET',
                url: AppUrlPath + '/api/user/' + username + $cookies.get("access_token"),
                headers: headers_data_json
            }
            var deferred = $q.defer();
            $http(req)
                .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    deferred.reject(errResponse);
                }
            );
            return deferred.promise;
        }

    });
