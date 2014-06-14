'use strict';

/* Controllers */

var peepersControllers = angular.module('peepersControllers', []);

peepersControllers.controller('CardListCtrl', function($scope, $http) {
    $http({method: 'GET', url: 'rest/cards/all'}).success(function(data)
    {
        $scope.cards = data; // response data
    });
});

peepersControllers.controller('CardDetailCtrl', function($scope, $http) {
    $http({method: 'GET', url: 'rest/cards/'}).success(function(data)
    {
        $scope.card = data; // response data
    });
});

peepersControllers.controller('CardFormCtrl', function($scope, $http, $location) {
    $http({method: 'POST', url: 'rest/cards/add', data: $scope.card}).success(function(data)
    {
       $location.path('/cars')
    });
});
