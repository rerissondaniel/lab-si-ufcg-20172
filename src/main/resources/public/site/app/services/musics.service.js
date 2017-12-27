angular.module("labsi").service("MusicsService", [function () {
    var _musics = [];
    var self = this;

    self.addMusic = function (music) {
        _musics.push(music);
    };

    self.getMusics = function () {
        return angular.copy(_musics);
    };

    self.getMusicsByArtist = function (artistName) {
        return _musics.filter(function (music) {
            return music.artist.name === artistName;
        });
    };

    self.getAlbunsByArtist = function (artistName) {
        var artistMusics = _musics.filter(function (music) {
            return music.artist.name === artistName;
        });

        var artistAlbuns = artistMusics.map(function (music) {
            return music.album;
        });

        return _removeDuplicates(artistAlbuns);
    };

    function _removeDuplicates(array) {
        var seen = {};
        return array.filter(function(album) {
            return seen.hasOwnProperty(album.name) ? false : (seen[album.name] = true);
        });
    }
}]);