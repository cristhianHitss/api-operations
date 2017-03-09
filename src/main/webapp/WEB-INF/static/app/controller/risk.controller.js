/**
 * Created by HItss on 08/01/2017.
 */
'use strict';

angular
    .module("global-hitss-app")
    .controller("RiskController", function ($scope, $state, RiskService, $rootScope, UtilsService) {

        var rc = $scope;

        rc.select = select;
        rc.select_list_mode = select_list_mode;
        rc.proyects = [];

        getAll();

        function getAll() {
            RiskService.getAll()
                .then(
                function (obj) {
                    rc.load = true;
                    rc.proyects = obj.data;
                }, function (err) {
                    if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                }
            );
        }

        function select_list_mode(elem) {
            if ('#' + elem + '' === '#list') {
                angular.element('#' + elem + '').css('background', 'rgba(76, 175, 80, 0.15)');
                angular.element('#square').css('background', '');
                rc.square = false;
                rc.list = true;
            } else {
                angular.element('#' + elem + '').css('background', 'rgba(76, 175, 80, 0.15)');
                angular.element('#list').css('background', '');
                rc.square = true;
                rc.list = false;
            }
        }

        function select(obj) {
            $rootScope.selected_risk_proyect = obj;
            UtilsService.showModal('risk.show.view.html', 'RiskShowController', 'app_lg');
        }

    })
    .controller('RiskAddController', function ($scope, $uibModalInstance, $rootScope, RiskService, $crypto, $cookies, SweetAlert) {

        var rac = $scope;
        rac.cancel = cancel;
        rac.save = save;
        rac.setPriority = setPriority;
        rac.print = print;

        init();

        function init() {
            if ($rootScope.editRisk) {
                rac.riskModel = $rootScope.editRisk;
                rac.riskModel.id_Probability = rac.riskModel.id_Probability + ''.toString();
                var d = new Date(rac.riskModel.commitment_Date);
                var fecha = d.getFullYear() + "-" + ("00" + (d.getMonth() + 1)).slice(-2) + "-" +
                    ("00" + d.getDate()).slice(-2);
                rac.riskModel._com_date = fecha;
                RiskService.getHistoricRiskById(rac.riskModel.id)
                    .then(
                    function (data) {
                        rac.historics = data.data;
                        console.log( data.data)
                    },
                    function (err) {
                        if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                    }
                )
                console.log(rac.riskModel.id);
                loadDependecies();
            } else {
                rac.riskModel = {};
                rac.riskModel.id_Proyect = angular.copy($rootScope.id_proyect_to_add);
                rac.riskModel.proyect_Name = angular.copy($rootScope.proyect_name_to_add);
                rac.riskModel.priority = 'gray';
                loadDependecies();
            }
        }

        function loadDependecies() {
            RiskService.getRiskDependencies()
                .then(
                function (data) {
                    rac.RiskDependencies = data.data;
                },
                function (err) {
                    if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                }
            );
        }

        function print(divName) {
            var printContents = document.getElementById("printThis").innerHTML;
            var originalContents = document.body.innerHTML;
            if (navigator.userAgent.toLowerCase().indexOf('chrome') > -1) {
                var popupWin = window.open('', '_blank', 'width=1300,height=600,scrollbars=no,menubar=no,toolbar=no,location=no,status=no,titlebar=no');
                popupWin.window.focus();
                popupWin.document.write('<!DOCTYPE html><html><head>' +
                '<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>	<script type="text/javascript" src="//cdn.rawgit.com/niklasvh/html2canvas/0.5.0-alpha2/dist/html2canvas.min.js"></script><script type="text/javascript" src="//cdn.rawgit.com/MrRio/jsPDF/master/dist/jspdf.min.js"></script>'+
                '(function(){var form = $(".area-imprimir"), cache_width = form.width(), a4  =[ 595.28,  841.89]; function createPDF(){ 	getCanvas().then(function(canvas){ var  img = canvas.toDataURL("image/png"), doc = new jsPDF({ unit:"px",format:"a4" }); doc.addImage(img, "JPEG", 20, 20);  doc.save("comprobante.pdf"); form.width(cache_width);	});} function getCanvas(){ form.width((a4[0]*1.33333) -80).css("max-width","none"); return html2canvas(form,{ imageTimeout:2000, removeContainer:true });} $("body").scrollTop(0); createPDF(); }());'+
                '</head><body onload="window.print()"><div class="reward-body">' + printContents + '</div></html>');
                popupWin.onbeforeunload = function (event) {
                    popupWin.close();
                    return '.\n';
                };
                popupWin.onabort = function (event) {
                    popupWin.document.close();
                    popupWin.close();
                }
            } else {
                var popupWin = window.open('', '_blank', 'width=1300,height=600');
                popupWin.document.open();
                popupWin.document.write('<html><head>'+
                '(function(){var form = $(".area-imprimir"), cache_width = form.width(), a4  =[ 595.28,  841.89]; function createPDF(){ 	getCanvas().then(function(canvas){ var  img = canvas.toDataURL("image/png"), doc = new jsPDF({ unit:"px",format:"a4" }); doc.addImage(img, "JPEG", 20, 20);  doc.save("comprobante.pdf"); form.width(cache_width);	});} function getCanvas(){ form.width((a4[0]*1.33333) -80).css("max-width","none"); return html2canvas(form,{ imageTimeout:2000, removeContainer:true });} $("body").scrollTop(0); createPDF(); }());'+
                '</head><body onload="window.print()">' + printContents + '</html>');
                popupWin.document.close();
            }
            popupWin.document.close();
            return true;
        }

        function save() {
            if ($rootScope.editRisk) {
                SweetAlert.swal({
                        title: "",
                        text: " <div class=\"pages-header text-center\"><h4>" + "Introduce tu comentario de la edicion" + "</h4> </div><textarea id='text' style='width: 100%;height: 59px;'></textarea>",
                        showCancelButton: true,
                        closeOnConfirm: false,
                        animation: "slide-from-top",
                        inputPlaceholder: "Introduce tu comentario de la edicion",
                        showLoaderOnConfirm: true,
                        confirmButtonText: "Aceptar",
                        cancelButtonText: "Cancel",
                        html: true
                    },
                    function (inputValue) {
                        var val = document.getElementById('text').value;
                        if (val === "") {
                            swal("Ha ocurrido un error", "Es necesario ingreasar el comentario de la edicion.\n Se ha registrado el intento", "error");
                            $rootScope.$broadcast("updateRisk");
                            return;
                        } else {
                            rac.riskModel.commitment_Date = rac.riskModel._com_date + ' 00:00:00';
                            rac.riskModel.commitment_Date = new Date(rac.riskModel.commitment_Date).getTime();
                            rac.riskModel.tmp_comment = val;
                            RiskService.update(rac.riskModel)
                                .then(
                                function (data) {
                                    $rootScope.$broadcast("updateRisk");
                                    swal("Guardado Correctamente", "Registro guardado correctamente", "success");
                                },
                                function (err) {
                                    if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                                });
                        }
                    });
            } else {
                rac.riskModel.commitment_Date = rac.riskModel._com_date + ' 00:00:00';
                rac.riskModel.commitment_Date = new Date(rac.riskModel.commitment_Date).getTime();
                RiskService.save(rac.riskModel)
                    .then(
                    function (data) {
                        $rootScope.$broadcast("updateRisk");
                        swal("Guardado Correctamente", "Registro guardado correctamente", "success");
                    },
                    function (err) {
                        if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                    });
            }
            cancel();
        }

        function setPriority() {
            if (rac.riskModel.id_Probability && rac.riskModel.id_Impact) {
                var result = parseInt(rac.riskModel.id_Impact) * parseFloat(rac.riskModel.id_Probability);
                console.log(parseInt(rac.riskModel.id_Impact) * parseFloat(rac.riskModel.id_Probability));
                if (0.10 <= result && result <= 0.70) {
                    rac.riskModel.priority = '#00FF00';
                    rac.riskModel.priority_order_identifier = 1;
                } else if (0.80 <= result && result <= 1.80) {
                    rac.riskModel.priority = '#FFFF00';
                    rac.riskModel.priority_order_identifier = 2;
                } else if (2.00 <= result && result <= 5) {
                    rac.riskModel.priority = '#FF0000';
                    rac.riskModel.priority_order_identifier = 3;
                }
            }
        }

        function cancel() {
            if ($rootScope.editRisk)$rootScope.editRisk = undefined;
            $uibModalInstance.dismiss('cancel');
        };
    })
    .controller('RiskShowController', function ($scope, $window, $uibModalInstance, $rootScope, UtilsService, defaultColors, RiskService) {

        var rsc = $scope;

        rsc.create = create;
        rsc.showAll = showAll;
        rsc.edit = edit;
        rsc.historic = historic;
        rsc.view = view;
        rsc.open = 1
        init();
        $rootScope.$on("updateRisk", function () {
            getById(rsc.risk_proyect.id);
        });

        function init() {
            if (!$rootScope.selected_risk_proyect) {
                $uibModalInstance.dismiss('cancel');
            }
            rsc.risk_proyect = angular.copy($rootScope.selected_risk_proyect);
            getById(rsc.risk_proyect.id);
        }

        function getById(id) {
            rsc.type_proyects_labels = [];
            rsc.type_proyects_data = [];
            rsc._total = 0;
            rsc.colors = defaultColors;
            RiskService.getRiskById(id)
                .then(
                function (data) {
                    rsc.risk_proyect = data.data;
                    angular.forEach(rsc.risk_proyect.risk_type, function (obj) {
                        rsc.type_proyects_labels.push(obj.type);
                        rsc.type_proyects_data.push(obj.total);
                        rsc._total = rsc._total + obj.total;
                    });
                },
                function (err) {
                    if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                }
            );
        }

        function create(obj) {
            $rootScope.id_proyect_to_add = rsc.risk_proyect.proyect_Id;
            $rootScope.proyect_name_to_add = rsc.risk_proyect.proyect_Name;
            $rootScope.customer_name = rsc.risk_proyect.customer;
            UtilsService.showModal('risk.add.view.html', 'RiskAddController', 'app_lg');
        }

        function showAll() {
            $rootScope.id_proyect_to_add = rsc.risk_proyect.proyect_Id;
            $rootScope.proyect_name_to_add = rsc.risk_proyect.proyect_Name;
            $rootScope.customer_name = rsc.risk_proyect.customer;
            UtilsService.showModal('risk.show.risks.view.html', 'RiskShowController', 'app_lg');
        }

        function edit(obj) {
            $rootScope.editRisk = obj;
            UtilsService.showModal('risk.add.view.html', 'RiskAddController', 'app_lg');
        }

        function view(obj){
            $rootScope.editRisk = obj;
            UtilsService.showModal('risk.print.view.html', 'RiskAddController', 'app_lg');
        }
        function historic(obj) {
            $rootScope.historic_Risk_id = obj.id;
            UtilsService.showModal('risk.historic.view.html', 'HistoricRiskController', 'app_lg');
        }

        rsc.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    })
    .controller('HistoricRiskController', function ($scope, RiskService, $rootScope, $uibModalInstance) {
        var hrc = $scope;

        init();

        function init() {
            RiskService.getHistoricRiskById($rootScope.historic_Risk_id)
                .then(
                function (data) {
                    hrc.historics = data.data;
                    console.log( data.data)
                },
                function (err) {
                    if (err.status != 401) swal("Ha ocurrido un error,intenta nuevamente", err.data.error, "error");
                }
            )
        }

        hrc.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };
    });

