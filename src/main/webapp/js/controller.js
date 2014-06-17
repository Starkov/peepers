'use strict';

/* Controllers */

var peepersControllers = angular.module('peepersControllers', []);


peepersControllers.controller('CardCtrl', function ($scope, $http, $location) {

    $http({method: 'GET', url: 'rest/cards/all'}).success(function (data) {
        $scope.cards = data; // response data
    });
    $scope.update = function (card) {
        if('active' in card){
            delete card.active;
        }
        $http({method: 'POST', url: 'rest/cards/add', data: card}).success(function (data) {
            $location.path('/cars')
        });
    }
    $scope.edit = function (editCard) {
        $scope.card = editCard;
    }
});

peepersControllers.controller('CardsSlidebarCtrl', function ($scope, $http) {
    $http({method: 'GET', url: 'rest/cards/all'}).success(function (data) {
        $scope.cardsSlide = data;
    });
});
peepersControllers.controller('CardEditCtrl', function ($scope, $http) {
    $http({method: 'GET', url: 'rest/cards/all'}).success(function (data) {
        $scope.cardsSlide = data;
    });
});
