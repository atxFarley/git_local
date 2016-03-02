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
            'leaflet-directive',
            'amyFarleyControllers',
            'amyFarleyServices'
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
                .when('/main', {
                    templateUrl: 'views/main.html',
                    controller: 'MainCtrl',
                    controllerAs: 'main'
                })
                .when('/about', {
                    templateUrl: 'views/about.html',
                    controller: 'MainCtrl',
                    controllerAs: 'main'
                })
                .when('/dayjob', {
                    templateUrl: 'views/dayjob.html',
                    controller: 'MainCtrl',
                    controllerAs: 'main'
                })
                .when('/moonlighting', {
                    templateUrl: 'views/moonlighting.html',
                    controller: 'MainCtrl',
                    controllerAs: 'main'
                })
                .when('/greatergood', {
                    templateUrl: 'views/greatergood.html',
                    controller: 'MainCtrl',
                    controllerAs: 'main'
                })
                .when('/active', {
                    templateUrl: 'views/active.html',
                    controller: 'MainCtrl',
                    controllerAs: 'main'
                })
                .when('/travel', {
                    templateUrl: 'views/travel.html',
                    controller: 'MainCtrl',
                    controllerAs: 'main'
                })
                .when('/social', {
                    templateUrl: 'views/social.html',
                    controller: 'MainCtrl',
                    controllerAs: 'main'
                })
                .when('/guest', {
                    templateUrl: 'views/guestbook.html',
                    controller: 'MainCtrl',
                    controllerAs: 'main'
                })
                .when('/mapmenu', {
                    templateUrl: 'views/maps/mapmenu.html',
                    controller: 'MapCtrl',
                    controllerAs: 'mapCtrl'
                })
                .when('/atxmoontower', {
                    templateUrl: 'views/maps/moontowers.html',
                    controller: 'MoonTowerCtrl',
                    controllerAs: 'moonTowerCtrl'
                })
                .otherwise({
                    redirectTo: '/'
                });
    }]);




