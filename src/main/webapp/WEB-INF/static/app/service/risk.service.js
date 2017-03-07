/**
 * Created by HItss on 08/01/2017.
 */

'use strict';
angular
    .module("global-hitss-app")
    .factory('RiskService', function (AppUrlPath, access_api_data, headers_data, headers_data_json, $cookies, $q, $http) {

        var factory = {
            getAll: getAll,
            getRiskDependencies: getRiskDependencies,
            save: save,
            getRiskById: getRiskById,
            update: update,
            getHistoricRiskById: getHistoricRiskById
        };

        function save(risk) {
            var req = {
                method: 'POST',
                url: AppUrlPath + '/api/risk/' + $cookies.get("access_token"),
                headers: headers_data_json,
                data: risk
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

        function update(risk) {
            var req = {
                method: 'PUT',
                url: AppUrlPath + '/api/risk/' + risk.id + $cookies.get("access_token"),
                headers: headers_data_json,
                data: risk
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

        function getAll() {
            var req = {
                method: 'GET',
                url: AppUrlPath + '/api/risk/' + $cookies.get("access_token"),
                headers: headers_data_json
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

        function getRiskDependencies() {
            var req = {
                method: 'GET',
                url: AppUrlPath + '/api/risk/dependencies/' + $cookies.get("access_token"),
                headers: headers_data_json
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

        function getRiskById(id) {
            var req = {
                method: 'GET',
                url: AppUrlPath + '/api/risk/' + id + $cookies.get("access_token"),
                headers: headers_data_json
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

        function getHistoricRiskById(id) {
            var req = {
                method: 'GET',
                url: AppUrlPath + '/api/risk/historic/' + id + $cookies.get("access_token"),
                headers: headers_data_json
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

        return factory;
    });
