angular.module("labsi").controller("MusicsCtrl", ["MusicsService", function (musicsService) {
    var self = this;

    self.musics = musicsService.getMusics();

    self.addMusic = function(music){
        musicsService.addMusic(music);
        _resetMusicForm();
        self.musics = musicsService.getMusics();
    };

    self.isMusicAvailable = function (name, album) {
        var musicstWithName = self.musics.find(function (music) {
            return name === music.name && album === music.album;
        });

        return !musicstWithName;
    };

    function _resetMusicForm(){
        self.music = {};
        //noinspection JSUnresolvedVariable
        self.musicForm.$setPristine();
    }
}]);