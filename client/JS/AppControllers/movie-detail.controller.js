(function(){
    'use strict';

    angular
        .module('movieFlixApp')
        .controller('MovieDetailController',MovieDetailController);

    MovieDetailController.$inject = ['movieService','$routeParams'];

    function MovieDetailController(movieService,$routeParams) {
        var movieDetailVM = this;
        init();
        function init() {
            console.log("Show Parameters from Routing Params");
            console.log($routeParams);

            movieService.getMovieByID($routeParams.id)
                .then(function(data){
                    console.dir(data);
                    movieDetailVM.movie = data;
                })
                .catch(function(error){
                    console.log(error);
                })
        }
    }
})();
