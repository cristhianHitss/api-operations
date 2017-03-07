/**
 * Created by HItss on 05/01/2017.
 */
'use strict';

angular
    .module('global-hitss-app')
    .factory('SearchEngineService', function (AppUrlPath, access_api_data, headers_data, headers_data_json, $cookies, $q, $http) {

        var factory = {
            searchEngine: searchEngine
        };

        function searchEngine(obj) {
            console.log(obj);
            console.log("otp: "+  $cookies.get("access_token"));
            var req = {
                method: 'POST',
                url: AppUrlPath + '/api/search/' + $cookies.get("access_token"),
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