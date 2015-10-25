'use strict';

/**
 * @ngdoc overview
 * @name yoAmyfarleyApp
 * @description
 * # yoAmyfarleyApp
 *
 * Main module of the application.
 */
var amyFarleyApp = angular
        .module('amyFarleyApp', [
            'ngAnimate',
            'ngCookies',
            'ngResource',
            'ngRoute',
            'ngSanitize',
            'ngTouch',
            'amyFarleyControllers'
        ]);

amyFarleyApp.config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];

        $routeProvider
                .when('/', {
                    templateUrl: 'views/main.html',
                    controller: 'MainCtrl',
                    controllerAs: 'main'
                })
                .when('/about', {
                    templateUrl: 'views/about.html',
                    controller: 'AboutCtrl',
                    controllerAs: 'about'
                })
                .when('/dayjob', {
                    templateUrl: 'views/dayjob.html',
                    controller: 'AboutCtrl',
                    controllerAs: 'about'
                })
                .when('/moonlighting', {
                    templateUrl: 'views/moonlighting.html',
                    controller: 'AboutCtrl',
                    controllerAs: 'about'
                })
                .when('/greatergood', {
                    templateUrl: 'views/greatergood.html',
                    controller: 'AboutCtrl',
                    controllerAs: 'about'
                })
                .when('/active', {
                    templateUrl: 'views/active.html',
                    controller: 'AboutCtrl',
                    controllerAs: 'about'
                })
                .when('/travel', {
                    templateUrl: 'views/travel.html',
                    controller: 'AboutCtrl',
                    controllerAs: 'about'
                })
                .when('/social', {
                    templateUrl: 'views/social.html',
                    controller: 'AboutCtrl',
                    controllerAs: 'about'
                })
                .otherwise({
                    redirectTo: '/'
                });
    }]);




