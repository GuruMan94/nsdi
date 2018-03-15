// var app = angular.module("nsdi", ['ngRoute']);

// app.config(function ($routeProvider, $locationProvider) {
//     // configure our routes
//
//     $routeProvider.when('/#traki', {
//         // templateUrl: 'home.html',
//         controller: 'mainController'
//     });
//
//
//     // create the controller and inject Angular's $scope
//     app.controller('mainController', function ($scope) {
//         $scope.message = 'Home Controller.';
//         console.log('sdf');
//     });
//
// });

(function () {
    'use strict';

    var nsdi = angular.module('nsdi', ['ui.router']);
    nsdi.config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('/',{
                url:'/',
                templateUrl:'index.html'
            })

            .state('home', {
                url: '/home',
                templateUrl: 'home.html'
            })

            .state('about', {
                url: '/login',
                templateUrl: 'login.html'
                // we'll get to this in a bit
            });
    })

})();