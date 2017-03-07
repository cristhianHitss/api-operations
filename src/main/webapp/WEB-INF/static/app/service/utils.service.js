/**
 * Created by HItss on 20/01/2017.
 */
'use strict';
angular
    .module('global-hitss-app')
    .factory('UtilsService', function ($uibModal) {

        var factory = {
            animateError: animateError,
            showModal: showModal
        };

        function animateError(elem) {
            var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';
            elem.css('box-shadow', ' ');
            elem.css("box-shadow", '0px 0px 6px 0px red');
            elem.addClass('animated tada').one(animationEnd, function () {
                elem.removeClass('animated tada');
                elem.css("box-shadow", '0px 0px 2px 0px rgba(50, 50, 50, 0.75)');
            });
        };

        function showModal(modalView, modalController, modalSize) {
            $uibModal.open({
                animation: true,
                ariaLabelledBy: 'modal-title',
                ariaDescribedBy: 'modal-body',
                templateUrl: modalView,
                controller: modalController,
                size: modalSize,
                backdrop: false,
                keyboard: false,
                windowClass: modalSize
            });
        };

        return factory;
    });
