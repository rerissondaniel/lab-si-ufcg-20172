angular.module("labsi").controller("ShowArtistCtrl",
    ["$stateParams", "ArtistsService", "MusicsService", function ($stateParams, artistsService, musicsService) {

        const self = this;

        const _artistName = $stateParams.name;

        artistsService.getByName(_artistName).then((response) => {
            self.artist = response.data;
        }).catch(error => {
            //TODO mostrar o erro.
        });

        self.updateArtist = function (artist) {
            artistsService.updateArtist(artist);
        }
    }]);