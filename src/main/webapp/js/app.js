var peepersApp = angular.module('peepersApp', [
    'ngRoute',
    'peepersControllers',
    'ui.bootstrap'
]);

peepersApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/cards',
            {
                templateUrl: 'cards.html'
            }).
            otherwise({redirectTo: '/cards'});
    }]);
