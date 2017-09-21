(function(){
    'use strict';

    angular.module('movieFlixApp').controller('loginController',loginController);
    loginController.$inject = ['$location'];

    function loginController($location){
        var loginVM = this;

        loginVM.formSubmit = formSubmit;
        init();
        function init(){
            console.log("logging from login Controller");
        }
        function formSubmit(){
            console.log('Form Submitted');
        }
    }
})();
