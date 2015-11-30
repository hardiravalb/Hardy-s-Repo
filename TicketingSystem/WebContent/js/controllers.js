'use strict';

/* Controllers */

var app = angular.module('ngdemo.controllers', []);


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});


app.controller('DummyCtrl', ['$scope', 'DummyFactory', function ($scope, DummyFactory) {
    $scope.bla = 'bla from controller';
    DummyFactory.get({}, function (dummyFactory) {
        $scope.firstname = dummyFactory.firstName;
    })
}]);

app.controller('ticketListCtrl', ['$scope', 'TicketsFactory', 'TicketFactory', '$location',
    function ($scope, TicketsFactory, TicketFactory, $location) {

        // callback for ng-click 'editTicket':
        $scope.editTicket = function (custId) {
            $location.path('/ticket-detail/' + custId);
        };

        // callback for ng-click 'deleteTicket':
        $scope.deleteTicket = function (custId) {
            TicketFactory.delete({ id: custId });
            $scope.tickets = TicketsFactory.query();
        };

        // callback for ng-click 'createticket':
        $scope.createNewTicket = function () {
            $location.path('/ticket-creation');
        };

        $scope.tickets = TicketsFactory.query();
    }]);

app.controller('ticketDetailCtrl', ['$scope', '$routeParams', 'TicketFactory', '$location',
    function ($scope, $routeParams, TicketFactory, $location) {

        // callback for ng-click 'updateTicket':
        $scope.updateTicket = function () {
            TicketFactory.update($scope.ticket);
            $location.path('/ticket-list');
        };

        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('/ticket-list');
        };

        $scope.ticket = TicketFactory.show({id: $routeParams.id});
    }]);

app.controller('ticketCreationCtrl', ['$scope', 'TicketsFactory', '$location',
    function ($scope, TicketsFactory, $location) {

        // callback for ng-click 'createNewTicket':
        $scope.createNewTicket = function () {
            TicketsFactory.create($scope.ticket);
            $location.path('/ticket-list');
        }
    }]);
