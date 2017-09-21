(function(){
    'use strict';

    angular.module('movieFlixApp').controller('adminViewMovieDetailController',adminViewMovieDetailController);
    adminViewMovieDetailController.$inject = ['adminService','$routeParams','$location']

    function adminViewMovieDetailController() {
        var viewDetailVM = this;

        viewDetailVM.updateMovie = updateMovie;
        viewDetailVM.deleteMovie = deleteMovie;

        init();

        function init(){
            console.log("Show Parameters");
            console.log($routeParams);

            adminService.getMovieByID($routeParams.id)
                .then(function (data) {
                    console.dir(data);
                    viewDetailVM.movie = data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }

        function updateMovie(){
            console.log('Updating Movie in DB');
            adminService.updateMovie($routeParams.id,viewDetailVM.movie);
        }

        function deleteMovie(){
            console.log('Deleting Movie in DB');
            adminService.deleteMovie($routeParams.id,viewDetailVM.movie)
                .then(function (data) {
                    $location.path('/adminviewmovie');
                },function(error){
                    console.log(error);
                })
        }
    }


})();
