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

        $scope.lat = "0";
        $scope.lng = "0";
        $scope.accuracy = "0";
        $scope.error = "";
        $scope.model = {myMap: undefined};
        $scope.myMarkers = [];
        $scope.guestMessage;

        $scope.showResult = function () {
            return $scope.error == "";
        };

        //$scope.mapOptions = {
        //    center: new google.maps.LatLng($scope.lat, $scope.lng),
        //    zoom: 15,
        //   mapTypeId: google.maps.MapTypeId.ROADMAP
        // };

        $scope.showPosition = function (position) {
            $scope.lat = position.coords.latitude;
            $scope.lng = position.coords.longitude;
            $scope.accuracy = position.coords.accuracy;
            // $scope.$apply();

            // var latlng = new google.maps.LatLng($scope.lat, $scope.lng);
            //  $scope.model.myMap.setCenter(latlng);
            //  $scope.myMarkers.push(new google.maps.Marker({map: $scope.model.myMap, position: latlng}));
        };

        $scope.showError = function (error) {
            switch (error.code) {
                case error.PERMISSION_DENIED:
                    $scope.error = "User denied the request for Geolocation."
                    break;
                case error.POSITION_UNAVAILABLE:
                    $scope.error = "Location information is unavailable."
                    break;
                case error.TIMEOUT:
                    $scope.error = "The request to get user location timed out."
                    break;
                case error.UNKNOWN_ERROR:
                    $scope.error = "An unknown error occurred."
                    break;
            }
            $scope.$apply();
        };

        $scope.getLocation = function () {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition($scope.showPosition, $scope.showError);
            }
            else {
                $scope.error = "Geolocation is not supported by this browser.";
            }
        };

        $scope.getLocation();




        /* callback for ng-click 'addGuestMessage': */
        $scope.addGuestMessage = function () {
            //  alert("addGuestMessage()");
            $scope.formMessage.bookName = "default";
            $scope.formMessage.latitude = $scope.lat;
            $scope.formMessage.longitude = $scope.lng;
            //alert("guest Message being submitted: " + $scope.formMessage);
            $http({
                method: 'POST',
                //url: '/rest/guestbook/post',
                url: 'sign',
                headers: {'Content-Type': 'application/json'},
                data: $scope.formMessage

            }).success(function (data)
            {
                $scope.status = data;
                $scope.formMessage = null;
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





