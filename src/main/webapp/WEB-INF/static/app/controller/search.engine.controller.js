/**
 * Created by HItss on 23/12/2016.
 */

'use strict';
angular
    .module('global-hitss-app')
    .controller('SearchEngineController', function ($scope, SearchEngineService, $state, $rootScope) {
        var sec = $scope;
        sec.searchCountry = searchCountry;
        sec.search_group_customer_bussines_line_project_type = search_group_customer_bussines_line_project_type;
        sec.searchbussinessline_group = searchbussinessline_group;
        sec.searchbussinessline_client = searchbussinessline_client;
        sec.searchproyecttype_client = searchproyecttype_client;
        sec.searchproyecttype_group = searchproyecttype_group;
        sec.searchproyecttype_bussinessline = searchproyecttype_bussinessline;
        sec.selectproyecttype = selectproyecttype;
        sec.SendRequestSearchEngine = SendRequestSearchEngine;
        sec.request = {};
        sec.countries = [];
        sec.groups = [];
        sec.customers = [];
        sec.bussines_lines = [];
        sec.project_types = [];

        function SendRequestSearchEngine() {
            alert(JSON.stringify(sec.request));
            $rootScope.request = sec.request;
            $state.go('main.operation');
        }


        function searchCountry(d) {
            resetallcoumns()
            sec.send = false;
            sec.request.country = undefined;
            sec.request.list_of_Countries = d;
            SearchEngineService.searchEngine(sec.request)
                .then(
                function (d) {
                    sec.countries = d.data[0];
                },
                function (err) {
                    if (err.status != 401) swal('An error has ocurred', err.data.error, 'error');
                });
        }

        function search_group_customer_bussines_line_project_type() {
            resetallcoumns();
            sec.send = true;
            sec.request.year = parseInt(sec.request.year);
            SearchEngineService.searchEngine(sec.request)
                .then(
                function (d) {
                    sec.groups = d.data[0];
                    sec.customers = d.data[1];
                    sec.bussines_lines = d.data[2];
                    sec.project_types = d.data[3];
                    sec.first_column_a = true;
                    sec.first_column_b = true;
                    sec.first_column_c = true;
                    sec.first_column_d = true;
                    console.log(sec.request);
                },
                function (err) {
                    console.log(err);
                    if (err.status != 401) swal('An error has ocurred', err.data.error, 'error');
                });
        }

        function searchbussinessline_group() {
            sec.second_column_a = false;
            sec.third_column_a = false;
            sec.request.bussines_Line = undefined;
            SearchEngineService.searchEngine(sec.request)
                .then(
                function (d) {
                    sec.first_column_b = false;
                    sec.first_column_c = false;
                    sec.first_column_d = false;
                    sec.second_column_a = true;
                    sec.bussines_lines = d.data[0];
                    console.log(data);
                },
                function (err) {
                    console.log(err);
                    if (err.status != 401) swal('An error has ocurred', err.data.error, 'error');
                }
            );
        }

        function searchproyecttype_group() {
            sec.third_column_a = false;
            sec.request.project_Type = undefined;
            SearchEngineService.searchEngine(sec.request)
                .then(
                function (d) {
                    sec.project_types = d.data[0];
                    sec.third_column_a = true;
                    console.log(d);
                },
                function (err) {
                    if (err.status != 401) swal('An error has ocurred', err.data.error, 'error');
                }
            )
        }

        function searchbussinessline_client() {
            sec.second_column_b = false;
            sec.third_column_b = false;
            sec.request.bussines_Line = undefined;
            SearchEngineService.searchEngine(sec.request)
                .then(
                function (d) {
                    sec.first_column_a = false;
                    sec.first_column_c = false;
                    sec.first_column_d = false;
                    sec.second_column_b = true;
                    sec.bussines_lines = d.data[0];
                    console.log(data);
                },
                function (err) {
                    console.log(err);
                    if (err.status != 401) swal('An error has ocurred', err.data.error, 'error');
                }
            );
        }

        function searchproyecttype_bussinessline() {
            sec.second_column_c = false;
            sec.request.project_Type = undefined;
            SearchEngineService.searchEngine(sec.request)
                .then(
                function (d) {
                    sec.first_column_a = false;
                    sec.first_column_b = false;
                    sec.first_column_d = false;
                    sec.second_column_c = true;
                    sec.project_types = d.data[0];
                    console.log(d);
                },
                function (err) {
                    if (err.status != 401) swal('An error has ocurred', err.data.error, 'error');
                }
            )
        }

        function searchproyecttype_client() {
            sec.third_column_b = false;
            sec.request.project_Type = undefined;
            SearchEngineService.searchEngine(sec.request)
                .then(
                function (d) {
                    sec.project_types = d.data[0];
                    sec.third_column_b = true;
                    console.log(d);
                },
                function (err) {
                    if (err.status != 401) swal('An error has ocurred', err.data.error, 'error');
                }
            )
        }

        function selectproyecttype() {
            sec.first_column_a = false;
            sec.first_column_b = false;
            sec.first_column_c = false;
        }

        function resetallcoumns() {
            sec.first_column_a = false;
            sec.first_column_b = false;
            sec.first_column_c = false;
            sec.first_column_d = false;

            sec.second_column_a = false;
            sec.second_column_b = false;
            sec.second_column_c = false;

            sec.third_column_a = false;
            sec.third_column_b = false;


            sec.request.bussines_Line = undefined;
            sec.request.group = undefined;
            sec.request.client = undefined;
            sec.request.project_Type = undefined;
            sec.groups = [];
            sec.customers = [];
            sec.bussines_lines = [];
            sec.project_types = [];
        }
    });