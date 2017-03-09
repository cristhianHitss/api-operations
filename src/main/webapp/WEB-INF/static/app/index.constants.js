/* global malarkey:false, moment:false */
'use strict';

angular
    .module('global-hitss-app')
    // URI REST SERVICE
    //.constant('AppUrlPath', 'http://localhost:8080/api-operations')
    .constant('AppUrlPath', 'http://35.187.79.87:8080/api-operations')
    .constant('access_api_data', {client_id: "hitss_front_application", client_password: '0p3r4t10n'})
    .constant('headers_data', {
        'Authorization': 'Basic ' + btoa('hitss_front_application:0p3r4t10n'),
        'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
        'accept': 'application/json'
    })
    .constant('headers_data_json', {
        'Authorization': 'Basic ' + btoa('hitss_front_application:0p3r4t10n'),
        'Content-type': 'application/json',
        'accept': 'application/json'
    })
    .constant('defaultColors', [
        '#e0e0e0', // blue
        '#334F66', // red
        '#6e6e6e', // yellow
        '#2E7EB7', // blue
        '#D54E33', // light grey
        '#fbfbfb', // grey
        '#fbfbfb'  // dark grey
    ]);