angular.module("labsi").config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise("nao-encontrado");

    $stateProvider.state("artists", {
        url: "/artists",
        templateUrl: "app/components/artists/artists.html",
        controller: "ArtistsCtrl",
        controllerAs: "artists"
    });
});