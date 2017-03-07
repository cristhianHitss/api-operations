/**
 * Created by HItss on 22/12/2016.
 */

'use strict';
angular
    .module('global-hitss-app')
    .factory('UserService', function ($http, $q, AppUrlPath, access_api_data, $httpParamSerializer, $cookies, headers_data, headers_data_json) {
        var factory = {
            fetchAllUsers: fetchAllUsers,
            save: save,
            remove: remove,
            update: update,
            getActivityById: getActivityById
        };
        return factory;

        function fetchAllUsers() {
            var req = {
                method: 'GET',
                url: AppUrlPath + '/api/user/' + $cookies.get("access_token"),
                headers: headers_data
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

        function save(user) {
            var req = {
                method: 'POST',
                url: AppUrlPath + '/api/user/' + $cookies.get("access_token"),
                headers: headers_data_json,
                data: user
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

        function update(user) {
            var req = {
                method: 'PUT',
                url: AppUrlPath + '/api/user/' + user.id + $cookies.get("access_token"),
                headers: headers_data_json,
                data: user
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

        function remove(id) {
            var req = {
                method: 'DELETE',
                url: AppUrlPath + '/api/user/' + id + $cookies.get("access_token"),
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

        function getActivityById(id) {
            var req = {
                method: 'GET',
                url: AppUrlPath + '/api/user/activity/' + id + $cookies.get("access_token"),
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
