'use strict';

/* Controllers */

//var peepersControllers = angular.module('peepersControllers', []);


angular.module('peepersApp').controller('CardCtrl', function ($scope, $http, $location) {

        $scope.$watch('tree.currentNode', function (newValue, oldValue) {
            if (newValue === oldValue) {
                return;
            }
            $http({method: 'GET', url: 'rest/cards/all/folder/' + newValue.id}).success(function (data) {
                $scope.cardList = data;
            });
        });

        $http({method: 'GET', url: 'rest/folders/all'}).success(function (data) {
            $scope.folderList = data;
        });

        $scope.update = function (card, parentFolderForCard) {
            if ('active' in card) {
                delete card.active;
            }
            card.parentHolderId = parentFolderForCard.id;
            $http({method: 'POST', url: 'rest/cards/add', data: card}).success(function (data) {
                $location.path('/cars')
            });
        };

        $scope.addFolder = function (parentFolder, newFolder) {
            newFolder.parentHolderId = parentFolder.id;
            $http({method: 'POST', url: 'rest/folders/add', data: newFolder}).success(function (data) {
                $location.path('/cars')
            });
        };

        $scope.edit = function () {
            var cardList = $scope.cardList
            for (var indx in cardList) {
                if (cardList[indx].active) {
                    $scope.card = cardList[indx];
                }
            }
        };

        $scope.clear = function () {
            delete $scope.card;
        };

        $scope.initAddButton = function () {
            delete $scope.card;
        };

        $scope.removeCard = function () {
            var cardList = $scope.cardList
            for (var card in cardList) {
                if (cardList[card].active) {
                    $http({method: 'DELETE', url: 'rest/cards/remove/' + cardList[card].id}).success(function (data) {
                        $location.path('/cars')
                    });
                }
            }
        };

        $scope.flipAllCards = function () {
            $scope.flipAll ? $scope.flipAll = false : $scope.flipAll = true;
        };

    }
)
;

