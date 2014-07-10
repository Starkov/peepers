'use strict';

/* Controllers */

//var peepersControllers = angular.module('peepersControllers', []);


angular.module('peepersApp').controller('CardCtrl', function ($scope, $http, $location) {


    $http({method: 'GET', url: 'rest/folders/root-folders'}).success(function (data) {
        $scope.rootFolderList = data;
    });

    $http({method: 'GET', url: 'rest/folders/all'}).success(function (data) {
        $scope.folderList = data;
    });

    $scope.updateCard = function (card, parentFolderForCard) {
        if ('active' in card) {
            delete card.active;
        }
        card.parentHolderId = parentFolderForCard.id;
        $http({method: 'POST', url: 'rest/cards/add', data: card}).success(function (data) {
            $location.path('/cars')
        });
    };

    $scope.editCard = function () {
        var cardList = $scope.cardList
        for (var indx in cardList) {
            if (cardList[indx].active) {
                $scope.card = cardList[indx];
            }
        }
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
    $scope.clearCard = function () {
        delete $scope.card;
    };
    $scope.initAddCardButton = function () {
        delete $scope.card;
    };
    $scope.addFolder = function (parentFolder, newFolder) {
        if (parentFolder === undefined) {
            if ('selected' in newFolder) {
                delete newFolder.selected;
            }
            $http({method: 'POST', url: 'rest/folders/add', data: newFolder}).success(function (data) {
                $location.path('/cars')
            });
        } else {
            newFolder.parentHolderId = parentFolder.id;
            $http({method: 'POST', url: 'rest/folders/add', data: newFolder}).success(function (data) {
                $location.path('/cars')
            });
        }
    };
    $scope.editFolder = function () {
        $scope.$watch('tree.currentNode', function (newValue, oldValue) {
            $scope.newFolder = newValue;
        });
    };
    $scope.removeFolder = function () {
        $scope.$watch('tree.currentNode', function (newValue, oldValue) {
            if ('selected' in newValue) {
                delete newValue.selected;
            }
            $http({method: 'DELETE', url: 'rest/folders/remove/' + newValue.id}).success(function (data) {
                $location.path('/cars')
            });
        });
    };
    $scope.clearFolder = function () {
        delete $scope.newFolder
    };
    $scope.flipAllCards = function () {
        $scope.flipAll ? $scope.flipAll = false : $scope.flipAll = true;
    };
    $scope.showInSlider = function (card) {
        var cardList = $scope.cardList
        for (var indx in cardList) {
            if (cardList[indx].active) {
                cardList[indx].active = false;
            }
            if (cardList[indx].id === card.id) {
                cardList[indx].active = true;
            }
        }
    };
    $scope.$watch('tree.currentNode', function (newValue, oldValue) {
        if (newValue === oldValue) {
            return;
        }
        $http({method: 'GET', url: 'rest/cards/all/folder/' + newValue.id}).success(function (data) {
            $scope.cardList = data;
        });
    });
});

