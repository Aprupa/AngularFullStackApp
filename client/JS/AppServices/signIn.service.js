
(function(){
    'use strict';
    angular.module('movieFlixApp')
        .service('signInService',signInService);

    signInService.$inject = ['$http','$q' , 'CONFIG'];
    function signInService($http , $q , CONFIG){
        var signinSelf = this;

        signinSelf.addUser = addUser;

        function addUser(user){
            console.log("Adding User to Database");
            return $http.post(CONFIG.API_HOST + '/user' , user)
                .then(successFuntion,errorFunction);
        }
        function successFuntion(response) {
            return response.data;
        }
        function errorFunction() {
            return $q.reject(error.status);
        }
    }
})();
