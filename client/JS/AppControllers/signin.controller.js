(function(){
    'use strict';
    angular.module('movieFlixApp').controller('SignInController',SignInController);
    SignInController.$inject = ['signInService','$location']
    function SignInController() {
        var signInVM = this;
        signInVM.createUser = createUser;
        init();

        function init(){
            console.log("Inside Sign in Controller, sign in into Move DB");
        }
        function createUser(){
            console.dir(signInVM.user);
            signInVM.addUser(signInVM.user)
                .then(function(data){
                    $location.path('/movie');
                }, function(error){
                    console.log(error);
                })
        }
    }
})();
