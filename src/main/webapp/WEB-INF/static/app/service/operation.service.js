/**
 * Created by HItss on 06/01/2017.
 */

'use strict';

angular
    .module('global-hitss-app')
    .factory('OperationService', function (AppUrlPath, access_api_data, headers_data, headers_data_json, $cookies, $q, $http) {

        var factory = {
            findOperationsByParams: findOperationsByParams
        };

        function findOperationsByParams(obj) {
            console.log(obj);
            var req = {
                method: 'POST',
                url: AppUrlPath + '/api/operation/' + $cookies.get("access_token"),
                headers: headers_data_json,
                data: obj
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