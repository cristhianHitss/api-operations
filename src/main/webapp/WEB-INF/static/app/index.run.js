'use strict';
angular
    .module('global-hitss-app')
    .run(function ($log, $rootScope, $http, $cookies, $crypto) {
        $http.defaults.headers.post["Content-Type"] = "application/json";
        // Funcion que cambiara el titulo de la App
        $rootScope.$on('$stateChangeSuccess', function (e, nextRoute) {
            if (nextRoute.title) {
                $rootScope.pageTitle = 'Operaciones | ' + nextRoute.title;
                $rootScope.moduleTitle = nextRoute.title;
            }
        });

        $rootScope.$on('$stateChangeStart', function (e, to) {
            var user = $cookies.get("_payload_name");
            if (user) {
                $rootScope._user = $crypto.decrypt($cookies.get("_payload_name"));
            }
        });

        // Una vez iniciada la App
        $log.debug('runBlock end');
    });
