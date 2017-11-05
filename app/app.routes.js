angular.module("labsi").config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("nao-encontrado");

    $stateProvider

        .state("artist", {
            url: "/artist",
            abstract: true
        })

        .state("artist.add", {
            url: "/add",
            controller: "AddArtistsCtrl",
            controllerAs: "vm",
            templateUrl: "app/components/artists/add/add-artist.html"
        })

        .state("artist.search", {
            controller: "SearchArtistCtrl",
            controllerAs: "vm",
            url: "/search",
            templateUrl: "app/components/artists/search/search-artist.html"
        })

        .state("artist.show", {
            url: "/show?name",
            controller: "ShowArtistCtrl",
            controllerAs: "vm",
            templateUrl: "app/components/artists/show/show-artist.html"
        })

        .state("music", {
            url: "/music",
            abstract: true,
            controller: "MusicsCtrl",
            controllerAs: "vm"
        })

        .state("music.add", {
            url: "/add",
            templateUrl: "app/components/musics/add/add-music.html"
        });
});