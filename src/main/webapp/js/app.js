var peepersApp = angular.module('peepersApp', [
    'ngRoute',
    'peepersControllers'
]);

peepersApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/cards', {
                templateUrl: 'card-list.html',
                controller: 'CardListCtrl'
            }).
            when('/cards/:cardId', {
                templateUrl: 'card-detail.html',
                controller: 'CardDetailCtrl'
            }).
            when('/cards/add', {
                templateUrl: 'card-form.html',
                controller: 'CardFormCtrl'
            }).
            otherwise({
                redirectTo: '/cards'
            });
    }]);