/**
 * Created by HItss on 06/01/2017.
 */

'use strict';
angular
    .module('global-hitss-app')
    .controller('OperationController', function ($scope, OperationService, $state) {
        var oc = $scope;

        init();

        function init() {
            if ($rootScope.request == null) {
                $state.go('main.search_engine');
            }
            oc.request = angular.copy($rootScope.request);
        }

    });