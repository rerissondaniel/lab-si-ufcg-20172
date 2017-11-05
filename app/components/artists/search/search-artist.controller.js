angular.module("labsi").controller("SearchArtistCtrl", ["ArtistsService", function(artistsService){
    var self = this;

    self.artists = artistsService.getArtists();

    self.updateArtist = function(artist){
        artistsService.updateArtist(artist);
    }
}]);