
(function(){
    'use strict';
    angular.module('movieFlixApp',['ngRoute','ngMessages'])
        .run(runModule)
        .config(moduleConfig);
    moduleConfig.$inject = ['$routeProvider','$httpProvider'];

    function moduleConfig($routeProvider,$httpProvider){

        $routeProvider
            .when('/movie',{
                templateUrl : 'Templates/movie-tmpl.html',
                controller : 'MovieController',
                controllerAs: 'movieVM'
            })
            .when('/movie/:id',{
                templateUrl : 'Templates/movie-detail.tmpl.html',
                controller : 'MovieDetailController',
                controllerAs : 'movieDetailVM'
            })
            .when('/movielist',{
                templateUrl : ' Templates/movielist.tmpl.html',
                controller : 'MovieController',
                controllerAs:'movieVM'
            })
            .when('/movielist/:id',{
                templateUrl : 'Templates/movie-detail.tmpl.html',
                controller : 'MovieDetailController',
                controllerAs : 'movieDetailVM'
            })
            .when('/sign-in',{
                templateUrl: ' Templates/sign-in.tmpl.html',
                controller : 'SignInController',
                controllerAs : 'signVM'
            })
            .when('/login',{
                templateUrl:'Templates/login-tmpl.html',
                controller : 'loginController',
                controllerAs : 'loginVM',
            })
            .when('/admin',{
                templateUrl : 'Templates/admin.tmpl.html',
                controller : 'AdminController',
                controllerAs : 'adminVM'
            })
            .when('/adminpage',{
                templateUrl : 'Templates/adminview.tmpl.html',
            })
            .when('/adminviewmovie',{
                templateUrl : 'Templates/adminviewmovie.tmpl.html',
                controller : 'adminViewMovieController',
                controllerAs : 'viewVM'
            })
            .when('/adminupdatemovie',{
                templateUrl : 'Templates/adminupdatemovie.tmpl.html',
                controller : 'adminViewMovieController',
                controllerAs : 'viewDetailVM'
            })
            .when('/admindeletemovie',{
                templateUrl : 'Templates/admindeletemovie.tmpl.html',
                controller : 'adminViewMovieController',
                controllerAs : 'viewDetailVM'
            })
            .otherwise({
                redirectTo:'/movie'
            })
    }

    function runModule(){
        console.log("Movie Flix Application Started");
    }
})();
