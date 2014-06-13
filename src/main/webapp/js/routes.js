angular.module('peepersApp').config(
    // dependencies injection
    ['$routeProvider',

// routes definition
        function ($routeProvider) {

            $routeProvider

                //--- @begin: bookmarks
                .when(
                '/cards/new',
                {
                    controller: 'BookmarksListCtrl',
                    templateUrl: 'app/bookmarks/tpl.list.html'
                }
            )
                .when(
                '/bookmarks/search',
                {
                    controller: 'BookmarksSearchCtrl',
                    templateUrl: 'app/bookmarks/tpl.search.html'
                }
            )
                .when(
                '/bookmarks/new',
                {
                    controller: 'BookmarksNewCtrl',
                    templateUrl: 'app/bookmarks/tpl.form.html'
                }
            )
                .when(
                '/bookmarks/edit/:id',
                {
                    controller: 'BookmarksEditCtrl',
                    templateUrl: 'app/bookmarks/tpl.form.html'
                }
            )
                //--- @end: bookmarks

                .when(
                '/about',
                {
                    templateUrl: 'app/about/tpl.html'
                }
            )

                .otherwise({redirectTo: '/bookmarks'});

        }]);
