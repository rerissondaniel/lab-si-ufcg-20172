angular.module("labsi").controller("SearchArtistCtrl", ["ArtistsService", function (artistsService) {
    var self = this;

    self.artists = artistsService.getArtists();

    self.confirmUpdate = function (artist) {
        var confirmResult;
        if (artist.favorite) {
            confirmResult = confirm("Deseja realmente adicionar o artista aos favoritos?");
        } else {
            confirmResult = confirm("Deseja realmente remover o artista dos favoritos?");
        }

        if (confirmResult) {
            _updateArtist(artist);
        } else {
            artist.favorite = !artist.favorite;
        }
    };

    function _updateArtist(artist) {
        artistsService.updateArtist(artist);
    }
}]);