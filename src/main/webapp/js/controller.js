'use strict';

/* Controllers */

var peepersControllers = angular.module('peepersControllers', []);

peepersControllers.controller('CardsCtrl', function($scope, $http) {
    $http({method: 'GET', url: 'rest/cards/all'}).success(function(data)
    {
        $scope.cards = data; // response data
    });
});

peepersControllers.controller('CardFormCtrl', function($scope, $http, $location) {
    $scope.update = function(card){
        $http({method: 'POST', url: 'rest/cards/add', data: card}).success(function(data)
        {
            $location.path('/cars')
        });
    }

});
