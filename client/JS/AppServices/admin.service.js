
(function(){
    'use strict';

    angular
        .module('movieFlixApp')
        .service('adminService',adminService);

    adminService.$inject = ['$http','$q','CONFIG'];

    function adminService($http,$q,CONFIG){
        var adSelf = this;
        adSelf.addMovie = addMovie;
        adSelf.viewMovie = viewMovies;
        adSelf.getMovieByID = getMoviesByID;
        adSelf.updateMovies = updateMovie;
        adSelf.deleteMovies = deleteMovie;

        function viewMovies(){
            return $http.get(CONFIG.API_HOST + '/movie')
                .then(successFunction,errorFunction);
        }
        function getMoviesByID(id,movie){
            return $http.get(CONFIG.API_HOST + '/movie/' + id)
                .then(successFunction,errorFunction);
        }
        function updateMovie(id,movie){
            console.log("Updating Movie in DB");
            return $http.put(CONFIG.API_HOST + '/movie/admin/'+id,movie);
        }
        function deleteMovie(id){
            console.log("Deleting Movie in DB");
            return $http.delete(CONFIG.API_HOST + '/movie/admin' + id);
        }
        function addMovie(movie){
            return $http.post(CONFIG.API_HOST + '/movie/admin',movie)
                .then(successFunction,errorFunction);
        }
        function successFunction(response){
            return response.data;
        }
        function errorFunction(response){
            return $q.reject(error.status);
        }

    }
})();
