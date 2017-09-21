(function(){
    'use strict';

    angular
        .module('movieFlixApp')
        .controller('adminViewMovieController',adminViewMovieController);
        adminViewMovieController.$inject = ['adminService'];
        function adminViewMovieController(adminService) {
            var viewVM = this;
            init();
            function init(){
                console.log("Logging from Admin View Movie Controller");
                adminService.viewMovie()
                    .then(function(data){
                        console.dir(data);
                        viewVM.movie = data;
                    })
                    .catch(function(error){
                        console.log(error);
                    })
            }
        }
})();
