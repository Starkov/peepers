var peepersApp = angular.module('peepersApp', [
    'ngRoute',
    'peepersControllers'
]);

peepersApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/cards',
            {
                templateUrl: 'cards.html',
                controller: 'CardsCtrl'
            }).
            otherwise({redirectTo: '/cards'});
    }]);
