(function(){
    'use strict';

    angular
        .module('movieFlixApp')
        .controller('AdminController', AdminController);

    AdminController.$inject = ['adminService','$location'];
    function AdminController(adminService, $location){
        var adminVM = this;
        adminVM.createMovie = createMovie;

        init();
        function init(){
            console.log("Logging from admin Controller");
        }
        function createMovie(){
            console.dir(adminVM.movie);
            adminService.addMovie(adminVM.movie)
                .then(function(data) {
                    console.log("Movie Successfully added");
                    $location.path('/adminviewmovie')
                },function(error){
                    console.log(error);
                })
        }
    }
})();
