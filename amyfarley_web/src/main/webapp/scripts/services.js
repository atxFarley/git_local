var amyFarleyServices = angular.module('amyFarleyServices', ['ngResource']);

var baseUrl = 'http://localhost\\:8080';

amyFarleyServices.factory('GuestMessagesFactory', function ($resource) {
    console.log("inside amyFarleyServices");
    return $resource('/rest/guestbook/list', {}, {
        query: {method: 'GET', isArray: true}
        //  create: { method: 'POST' }
    });





});


//services.factory('UserFactory', function ($resource) {
//    return $resource(baseUrl + '/ngdemo/web/users/:id', {}, {
///      show: { method: 'GET' },
//    update: { method: 'PUT', params: {id: '@id'} },
//   delete: { method: 'DELETE', params: {id: '@id'} }
// })
//});



