/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var amyFarleyControllers = angular.module('amyFarleyControllers', []);

amyFarleyControllers.controller('MaintCtrl', function ($scope) {

    $scope.guestMessages = [];


});

amyFarleyControllers.controller('AddGuestMessageCtrl', ['$scope', 'GuestMessagesFactory', '$location',
    function ($scope, GuestMessagesFactory, $location) {

        /* callback for ng-click 'addGuestMessage': */
        $scope.addGuestMessage = function () {
            GuestMessagesFactory.create($scope.guestMessage);
            $location.path('/guest');
        };
    }]);



