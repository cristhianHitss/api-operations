'use strict';
angular
    .module('global-hitss-app')
    .config(function ($stateProvider, $urlRouterProvider, $httpProvider, $cryptoProvider) {
        $httpProvider.interceptors.push('AuthenticationServiceInterceptor');
        $cryptoProvider.setCryptographyKey('GLOBALHITSSAPPLICATIONPROYECTSADMINISTRATION');
        $stateProvider
            .state('login', {
                url: '/login',
                templateUrl: 'login.view',
                controller: 'LoginController',
                resolve: {
                    skipIfLoggedIn: isLogin
                }
            })
            .state('main', {
                url: '/main',
                templateUrl: 'main.view',
                controller: 'MainController',
                resolve: {
                    skipIfLoggedIn: loginRequired
                }
            })
            .state('main.principal', {
                url: '/principal',
                templateUrl: 'principal.view',
                controller: 'PrincipalController'
            })
            .state('main.users', {
                url: '/users',
                templateUrl: 'users.view',
                controller: 'UserController'
            })
            .state('main.search_engine', {
                url: '/search_engine',
                templateUrl: 'operation.search.view',
                controller: 'SearchEngineController'
            })
            .state('main.operation', {
                url: '/operation',
                templateUrl: 'operation.view',
                controller: 'OperationController'
            })
            .state('main.risk', {
                url: '/risk',
                templateUrl: 'risk.view',
                controller: 'RiskController'
            })
            .state('main.rework', {
                url: '/rework',
                templateUrl: 'rework.view',
                controller: 'ReworkController'
            });
        $urlRouterProvider.otherwise('/login');

        function isLogin($q, $cookies, $location) {
            var deferred = $q.defer();
            if ($cookies.get("access_token")) {
                $location.path('/main/principal');
            } else {
                deferred.resolve();
            }
            return deferred.promise;
        }

        function loginRequired($q, $location, $cookies) {
            var deferred = $q.defer();
            if ($cookies.get("access_token")) {
                deferred.resolve();
            } else {
                $location.path('/login');
            }
            return deferred.promise;
        }
    });


