/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var amyFarleyControllers = angular.module('amyFarleyControllers', []);
var baseUrl = 'http://localhost\\:8080';

amyFarleyControllers.controller('MainCtrl', function ($scope, $http) {

    // $scope.getGuestMessages = function () {
    //    $http({
    //       method: 'GET',
    //       url: '/rest/guestbook/list'
    //url: 'sign'
    //   }).success(function (data, status, headers, config) {
    //      $scope.guestMessages = data;
    //     alert("$scope.guestMessages: " + $scope.guestMessages);
    //  }).error(function (data, status, headers, config) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
    // });


    // };

});

amyFarleyControllers.controller('GuestMessageCtrl', ['$scope', '$http', 'GuestMessagesFactory', '$location',
    function ($scope, $http, GuestMessagesFactory, $location) {


        /* callback for ng-click 'addGuestMessage': */
        $scope.addGuestMessage = function () {
            //  alert("addGuestMessage()");
            $http({
                method: 'POST',
                url: 'sign',
                headers: {'Content-Type': 'application/json'},
                data: $scope.guestMessage
            }).success(function (data)
            {
                $scope.status = data;
                $scope.guestMessage = null;
                $scope.guestMessages = GuestMessagesFactory.query();
            });
            $location.path('/guest');
        };

        $scope.getSampleMessage = function () {
            //alert("getSampleMessage()");
            $http({
                method: 'GET',
                url: '/rest/guestbook/sample'
                        //url: 'sign'
            }).success(function (data, status, headers, config) {
                $scope.sampleMessage = data;
            }).error(function (data, status, headers, config) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
            });

        };

        $scope.guestMessages = GuestMessagesFactory.query();


    }]);





