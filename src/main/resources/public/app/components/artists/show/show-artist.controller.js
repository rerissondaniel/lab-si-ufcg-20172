angular.module("labsi").controller("ShowArtistCtrl",
    ["$stateParams", "ArtistsService", "MusicsService", function ($stateParams, artistsService, musicsService) {

        var self = this;

        var _artistName = $stateParams.name;

        self.artist = artistsService.getByName(_artistName);
        self.albuns = musicsService.getAlbunsByArtist(_artistName);
        self.musics = musicsService.getMusicsByArtist(_artistName);

        self.updateArtist = function (artist) {
            artistsService.updateArtist(artist);
        }
    }]);