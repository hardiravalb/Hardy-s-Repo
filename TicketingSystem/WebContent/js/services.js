'use strict';

/* Services */

/*
 * http://docs.angularjs.org/api/ngResource.$resource
 * 
 * Default ngResources are defined as
 * 
 * 'get': {method:'GET'}, 'save': {method:'POST'}, 'query': {method:'GET',
 * isArray:true}, 'remove': {method:'DELETE'}, 'delete': {method:'DELETE'}
 * 
 */

var services = angular.module('ngdemo.services', ['ngResource']);

services.factory('DummyFactory', function ($resource) {
    return $resource('/ngdemo/web/dummy', {}, {
        query: { method: 'GET', params: {}, isArray: false }
    })
});

services.factory('TicketsFactory', function ($resource) {
    return $resource('/ngdemo/web/tickets', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

services.factory('TicketFactory', function ($resource) {
    return $resource('/ngdemo/web/tickets/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@custId'} },
        delete: { method: 'DELETE', params: {id: '@custId'} }
    })
});
