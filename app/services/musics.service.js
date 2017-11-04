angular.module("labsi").service("MusicsService", [function () {
    var _musics = [];

    this.addMusic = function (music) {
        _musics.push(music);
    };

    this.getMusics = function () {
        return angular.copy(_musics);
    }
}]);