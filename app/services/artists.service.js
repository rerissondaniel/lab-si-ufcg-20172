angular.module("labsi").service("ArtistsService", function () {
    var _artists = [];
    var self = this;

    self.add = function (artist) {
        _artists.push(artist);
    };

    self.getArtists = function () {
        return angular.copy(_artists);
    };

    self.updateArtist = function (artist) {
        var idxToUpdate = _artists.findIndex(function(elem){
            return elem.name === artist.name;
        });
        _artists[idxToUpdate] = artist;
    };

    self.getByName = function (name) {
        var artistsWithName = _artists.find(function (artist) {
            return artist.name === name;
        });

        if (artistsWithName) {
            return angular.copy(artistsWithName);
        }
    }
});