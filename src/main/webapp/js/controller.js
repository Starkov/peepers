'use strict';

/* Controllers */

var peepersApp = angular.module('peepersApp', []);

peepersApp.controller('CardCtrl', function($scope, $http) {
    $http({method: 'GET', url: 'rest/cards/all'}).success(function(data)
    {
        $scope.cards = data; // response data
    });
});