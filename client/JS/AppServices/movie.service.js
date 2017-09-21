(function(){
    'use strict';

    angular.module('movieFlixApp')
        .service('movieService' , movieService);

    movieService.$inject = ['$http','$q','CONFIG'];
    function movieService($http,$q,CONFIG){
        var mvSelf = this;
        mvSelf.getAllMovies = getAllMovies;
        mvSelf.getMovieByID = getMovieByID;

        function getAllMovies(){
            return $http.get(CONFIG.API_HOST + '/movie')
                .then(successFunction,errorFunction);
        }

        function getMovieByID(id){
            return $http.get(CONFIG.API_HOST + '/movie/' + id)
                .then(successFunction,errorFunction);
        }

        function successFunction(response){
            return response.data;
        }
        function errorFunction(response) {
            return $q.reject(error.status);
        }
    }
})();
