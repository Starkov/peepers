'use strict';

/* Controllers */

var peepersControllers = angular.module('peepersControllers', []);


peepersControllers.controller('CardCtrl', function ($scope, $http, $location) {


    $http({method: 'GET', url: 'rest/cards/all'}).success(function (data) {
        $scope.cards = data; // response data
    });
    $scope.update = function (card) {
        if ('active' in card) {
            delete card.active;
        }
        $http({method: 'POST', url: 'rest/cards/add', data: card}).success(function (data) {
            $location.path('/cars')
        });
    }
    $scope.edit = function (editCard) {
        $scope.card = editCard;
    }
    $scope.clear = function () {
        delete $scope.card;
    }

    $scope.removeCard = function (card) {
        $http({method: 'DELETE', url: 'rest/cards/remove/'+card.id}).success(function (data) {
            $location.path('/cars')
        });
    }
});

