angular.module("labsi").service("ArtistsService", function () {
    var _artists = [{name: "rerisson"}, {name: "maico"}, {name: "joao"}];

    this.add = function (artist) {
        _artists.push(artist);
    };

    this.getArtists = function () {
        return angular.copy(_artists);
    };

    this.updateArtist = function (artist) {
        var toUpdateIdx = _artists.findIndex(function(elem){
            return elem.name === artist.name;
        });
        _artists[toUpdateIdx] = artist;
    };

    this.getByName = function (name) {
        var artistsWithName = _artists.find(function (artist) {
            return artist.name === name;
        });

        if (artistsWithName) {
            return angular.copy(artistsWithName);
        }
    }
});