
(function() {
    'use strict';

    angular.module('movieFlixApp')
        .filter('capitalize', capitalize);

    function capitalize(){
        return function(input){

            return input.charAt(0).toUpperCase() + input.substr(1);
        }
    }
})();
