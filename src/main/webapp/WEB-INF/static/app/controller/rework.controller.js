/**
 * Created by HItss on 08/02/2017.
 */
'use strict';

angular
    .module("global-hitss-app")
    .controller("ReworkController", function ($scope, $state, ReworkService, $rootScope, UtilsService) {
        var rwc = $scope;

        rwc.select = select;
        rwc.select_list_mode = select_list_mode;
        rwc.proyects = [];

        getAll();

        function getAll() {
            ReworkService.getAll()
                .then(
                function (obj) {
                    rwc.load = true;
                    rwc.proyects = obj.data;
                    console.log(rwc.proyects);
                }, function (err) {
                    if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                }
            );
        }

        function select_list_mode(elem) {
            if ('#' + elem + '' === '#list') {
                angular.element('#' + elem + '').css('background', 'rgba(76, 175, 80, 0.15)');
                angular.element('#square').css('background', '');
                rwc.square = false;
                rwc.list = true;
            } else {
                angular.element('#' + elem + '').css('background', 'rgba(76, 175, 80, 0.15)');
                angular.element('#list').css('background', '');
                rwc.square = true;
                rwc.list = false;
            }
        }

        function select(obj) {
            $rootScope.selected_risk_proyect = obj;
            UtilsService.showModal('rework.show.view.html', 'RiskShowController', 'app_lg');
        }
    });