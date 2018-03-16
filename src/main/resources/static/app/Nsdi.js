(function () {
    'use strict';

    var nsdi = angular.module('nsdi', ['ui.router']);
    nsdi.config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            // .state('/',{
            //     url:'/',
            //     templateUrl:'index.html'
            // })

            .state('/logout', {
                url: '/logout'
            });
    })

})();