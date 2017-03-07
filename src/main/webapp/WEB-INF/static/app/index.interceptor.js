/**
 * Created by HItss on 03/01/2017.
 */

'use strict';
angular
    .module('global-hitss-app')
    .service('AuthenticationServiceInterceptor', function ($q, SweetAlert, $httpParamSerializer, $injector, $cookies, $location, $crypto, access_api_data, AppUrlPath, headers_data) {
        var service = this;

        service.responseError = function (response) {
            if (response.status == 401) {
                SweetAlert.swal({
                        title: "",
                        text: " <div class=\"pages-header text-center\"> <div class=\"pages-box-icon\"><i class=\"zmdi zmdi-account-o\"></i></div> <h4>" + $crypto.decrypt($cookies.get("_payload_name")) + "</h4> </div>",
                        type: "input",
                        showCancelButton: false,
                        closeOnConfirm: false,
                        animation: "slide-from-top",
                        inputPlaceholder: "Ingresa tu contraseña",
                        showLoaderOnConfirm: true,
                        confirmButtonText: "Login",
                        html: true
                    },
                    function (inputValue) {
                        if (inputValue === false) return false;

                        if (inputValue === "") {
                            swal.showInputError("Necesitas ingresar tu password");
                            return false
                        }

                        var data_client = {
                            grant_type: "password",
                            username: $crypto.decrypt($cookies.get("_payload_username")),
                            password: inputValue,
                            client_id: access_api_data.client_id
                        };
                        var req = {
                            method: 'POST',
                            url: AppUrlPath + '/oauth/token',
                            headers: headers_data,
                            data: $httpParamSerializer(data_client)
                        }
                        var http = $injector.get('$http');
                        http(req).then(
                            function (data) {
                                SweetAlert.swal({
                                    title: "Login Correcto!",
                                    text: "Se han validado tus credenciales",
                                    timer: 1400,
                                    showConfirmButton: false
                                });
                                $cookies.put("access_token", '?access_token=' + data.data.access_token);
                                $location.path('/login');
                            }, function (err) {
                                SweetAlert.swal({
                                    title: "Credenciales Invalidas!",
                                    text: "Necesitas iniciar sesion",
                                    timer: 1200,
                                    showConfirmButton: false
                                });
                                $cookies.remove("access_token");
                                $location.path('/login');
                            });
                    });
            }
            return $q.reject(response);
        };
    });