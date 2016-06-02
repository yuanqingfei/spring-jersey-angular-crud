/* global toastr:false, moment:false */
(function() {
    'use strict';

    var baseUrl = window.location.origin;
    angular
        .module('app.core')
        .constant('toastr', toastr)
        .constant('moment', moment)
        .constant('API_BASE_URL', baseUrl+'/api');
})();
