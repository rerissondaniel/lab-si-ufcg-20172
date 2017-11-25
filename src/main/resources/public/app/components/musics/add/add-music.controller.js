angular.module("labsi").controller("MusicsCtrl", ["MusicsService", "ArtistsService", function (musicsService, artistsService) {
    var self = this;

    self.musics = musicsService.getMusics();
    self.artists = artistsService.getArtists();

    self.addMusic = function (music) {
        musicsService.addMusic(music);
        _resetMusicForm();
        self.musics = musicsService.getMusics();
    };

    self.isMusicAvailable = function (name, album) {
        var musicsWithName = self.musics.find(function (music) {
            return name === music.name && album === music.album.name;
        });

        return !musicsWithName;
    };

    function _resetMusicForm() {
        self.music = {};
        //noinspection JSUnresolvedVariable
        self.musicForm.$setPristine();
    }
}]);