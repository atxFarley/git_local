var amyFarleyServices = angular.module('amyFarleyServices', ['ngResource']);

var baseUrl = 'http://localhost\\:8080';

amyFarleyServices.factory('GuestMessagesFactory', function ($resource) {
    //alert("inside ");
    // return $resource(baseUrl + '/rest/json/sign', {}, {
      //  query: { method: 'GET', isArray: false },
     //  create: { method: 'POST' }
   // })
    

 
});


//services.factory('UserFactory', function ($resource) {
//    return $resource(baseUrl + '/ngdemo/web/users/:id', {}, {
///      show: { method: 'GET' },
//    update: { method: 'PUT', params: {id: '@id'} },
//   delete: { method: 'DELETE', params: {id: '@id'} }
// })
//});



