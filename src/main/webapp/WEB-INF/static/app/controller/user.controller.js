/**
 * Created by HItss on 22/12/2016.
 */

'use strict';
angular
    .module('global-hitss-app')
    .controller('UserController', function ($scope, UserService, LoginService, $cookies, $state, $rootScope, UtilsService) {
        var uc = $scope;

        uc.users = [];
        uc.showUserDetail = showUserDetail;
        uc.create = create;
        uc.activityUser = activityUser;

        fetchAllUsers();

        $rootScope.$on("updateUsers", function () {
            fetchAllUsers();
        });

        function fetchAllUsers() {
            UserService.fetchAllUsers()
                .then(
                function (d) {
                    uc.users = d.data;
                },
                function (err) {
                    if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                }
            );
        };

        function showUserDetail(user) {
            $rootScope.userdetail = user;
            UtilsService.showModal('users.show.view.html', 'UserShowController', 'app_sm');
        }

        function create() {
            UtilsService.showModal('users.add.view.html', 'UserAddController', 'app_sm');
        }

        function activityUser(user) {
            $rootScope._id_user = user.id;
            $rootScope.userdetail = user;
            UtilsService.showModal('users.activity.view.html', 'UserActivityController', 'app_lg');
        }
    })
    .controller('UserAddController', function ($scope, $rootScope, UserService, SweetAlert, $state, $uibModalInstance) {

        var uac = $scope;

        uac.user = {};
        uac.save = save;
        uac.cancel = cancel;

        function save() {
            uac.user.usertype = parseInt(uac.user.usertype);
            UserService.save(uac.user)
                .then(
                function (d) {
                    $rootScope.$broadcast("updateUsers");
                    SweetAlert.swal("Guardado Correctamente", "Registro guardado correctamente", "success");
                    cancel();
                },
                function (err) {
                    if (err.status == 409) {
                        SweetAlert.swal("Registro no creado!", "El registro ya existe", "error");
                    } else if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                }
            );
        }

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        };

    })
    .controller('UserShowController', function ($scope, $rootScope, $state, UserService, SweetAlert, $uibModalInstance) {

        var usc = $scope;

        usc.remove = remove;
        usc.update = update;
        usc.cancel = cancel;

        init();

        function init() {
            if (!$rootScope.userdetail) {
                $state.go('main.users.null');
            } else {
                usc.user = angular.copy($rootScope.userdetail);
            }
        }

        function remove() {
            SweetAlert.swal({
                    title: "Estas seguro?",
                    text: "El registro se borrara, permanentemente!",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "Borrar",
                    closeOnConfirm: false,
                    showLoaderOnConfirm: true
                },
                function (confirm) {
                    if (confirm) {
                        UserService.remove(usc.user.id)
                            .then(
                            function () {
                                $rootScope.$broadcast("updateUsers");
                                swal("Borrado Correctamente!", 'El registro fue borrado correctamente', "success");
                                cancel();
                            },
                            function (err) {
                                if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                            }
                        );
                    }

                });
        }

        function update() {

            usc.user.usertype = parseInt(usc.user.usertype);

            UserService.update(usc.user)
                .then(
                function (d) {
                    $rootScope.$broadcast("updateUsers");
                    SweetAlert.swal("Actualizado Correctamente", "Registro actualizado correctamente", "success");
                    cancel();
                },
                function (err) {
                    if (err.status == 409) {
                        SweetAlert.swal("Registro no actualizado!", "El registro ya existe", "error");
                    } else if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                }
            );
        }

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        };
    })
    .controller('UserActivityController', function (UserService, $rootScope, $scope, $uibModalInstance) {

        var uacc = $scope;
        uacc.cancel = cancel;

        init();
        function init() {
            UserService.getActivityById($rootScope._id_user)
                .then(
                function (data) {
                    console.log($rootScope.userdetail);
                    console.log(data);
                    uacc.load = true;
                    uacc.userActivities = data;
                },
                function (err) {
                    if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                }
            );
        }

        function cancel() {
            $uibModalInstance.dismiss('cancel');
        };

    });