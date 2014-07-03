'use strict';

/* Controllers */

//var peepersControllers = angular.module('peepersControllers', []);


angular.module('peepersApp').controller('CardCtrl', function ($scope, $http, $location) {


        $http({method: 'GET', url: 'rest/cards/all'}).success(function (data) {
            $scope.cardList = data;
        });

        $http({method: 'GET', url: 'rest/cards/tree'}).success(function (data) {
            $scope.cardTree = data;
        });

        $scope.update = function (card) {
            if ('active' in card) {
                delete card.active;
            }
            $http({method: 'POST', url: 'rest/cards/add', data: card}).success(function (data) {
                $location.path('/cars')
            });
        };

        $scope.edit = function (editCard) {
            $scope.card = editCard;
        };

        $scope.clear = function () {
            delete $scope.card;
        };

        $scope.initAddButton = function () {
            delete $scope.card;
        };

        $scope.removeCard = function (card) {
            $http({method: 'DELETE', url: 'rest/cards/remove/' + card.id}).success(function (data) {
                $location.path('/cars')
            });
        };

        $scope.flipAllCards = function () {
            $scope.flipAll ? $scope.flipAll = false : $scope.flipAll = true;
        };

    }
)
;

