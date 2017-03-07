/**
 * Created by HItss on 08/02/2017.
 */
'use strict';
angular
    .module("global-hitss-app")
    .factory('ReworkService', function (AppUrlPath, access_api_data, headers_data, headers_data_json, $cookies, $q, $http) {

        var factory = {
            getAll: getAll
        };

        function getAll() {
            var req = {
                method: 'GET',
                url: AppUrlPath + '/api/rework/' + $cookies.get("access_token"),
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
