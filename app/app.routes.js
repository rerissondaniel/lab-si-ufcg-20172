angular.module("labsi").config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("nao-encontrado");

    $stateProvider

        .state("artists", {
            url: "/artists",
            templateUrl: "app/components/artists/artists.html",
            controller: "ArtistsCtrl",
            controllerAs: "vm"
        })

        .state("musics", {
            url: "/musics",
            templateUrl: "app/components/musics/musics.html",
            controller: "MusicsCtrl",
            controllerAs: "vm"
        });
});