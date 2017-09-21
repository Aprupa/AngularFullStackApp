(function(){
    'use strict';

    angular
        .module('movieFlixApp')
        .controller('MovieController' , MovieController);

    MovieController.$inject = ['movieService'];


    function MovieController(movieService) {
        var movieVM = this;
        movieVM.sorter = {
            by : 'Title',
            reverse: false
        };

        movieVM.toggleSort = toggleSort;
        init();

        function init(){
            console.log("Showing Movies using Movie Controller");
            movieService
                .getAllMovies()
                .then(function (data){
                    console.dir(data);
                    movieVM.movie = data;
                })
                .catch(function(error){
                    console.log(error);
                });
        }
        function toggleSort(prop){
            console.log(prop);
            movieVM.sorter.by = prop;
            movieVM.sorter.revers = !movieVM.sorter.reverse;
        }
    }
})();
