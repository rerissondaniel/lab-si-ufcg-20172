angular.module("labsi").controller("MusicsCtrl", ["MusicsService", "ArtistsService", function (musicsService, artistsService) {
    const self = this;

    artistsService.getArtists().then(response => {
        self.artists = response.data;
    });

    self.addMusic = function (music) {
        musicsService.addMusic(music);
        _resetMusicForm();
        self.musics = musicsService.getMusics();
    };

    function _resetMusicForm() {
        self.music = {};
        //noinspection JSUnresolvedVariable
        self.musicForm.$setPristine();
    }
}]);