var amyFarleyServices = angular.module('amyFarleyServices', ['ngResource']);

var baseUrl = 'http://localhost\\:8080';

amyFarleyServices.factory('GuestMessagesFactory', function ($resource) {
            //return $resource('phones/:phoneId.json', {}, {
            // query: {method:'GET', params:{phoneId:'phones'}, isArray:true}
            // });
            // return $resource('/guestmessage/messages', {}, {
            return $resource(baseUrl + '/rest/json/sign/post', {}, {
               // query: {method: 'GET', isArray: true},
                create: {method: 'POST'}
            });
        });

// services.factory('UsersFactory', function ($resource) {
//  return $resource(baseUrl + '/ngdemo/web/users', {}, {
////      query: { method: 'GET', isArray: true },
//create: {method: 'POST'}
// })
//});

//services.factory('UserFactory', function ($resource) {
//    return $resource(baseUrl + '/ngdemo/web/users/:id', {}, {
///      show: { method: 'GET' },
//    update: { method: 'PUT', params: {id: '@id'} },
//   delete: { method: 'DELETE', params: {id: '@id'} }
// })
//});



