angular.module("labsi").service("MusicsService", [function () {
    var _musics = [];

    this.addMusic = function (music) {
        _musics.push(music);
    };

    this.getMusics = function () {
        return angular.copy(_musics);
    };

    this.getMusicsByArtist = function (artistName) {
        return _musics.filter(function (music) {
            return music.artist.name === artistName;
        });
    };

    this.getAlbunsByArtist = function (artistName) {
        var artistMusics = _musics.filter(function (music) {
            return music.artist.name === artistName;
        });

        var artistAlbuns = artistMusics.map(function (music) {
            return music.album;
        });

        return _removeDuplicates(artistAlbuns);
    };

    function _removeDuplicates(array) {
        return array.filter(function (value, index, self) {
            return self.indexOf(value) === index;
        });
    }
}]);