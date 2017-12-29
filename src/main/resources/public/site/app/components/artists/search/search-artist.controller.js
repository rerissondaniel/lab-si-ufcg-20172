angular.module("labsi").controller("SearchArtistCtrl", ["ArtistsService", function (artistsService) {
    const self = this;

    artistsService.getArtists().then(response => {
        self.artists = response.data;
    }).catch(() => {
        self.responseError = 'Erro na comunicação com o servidor';
    });

    self.confirmUpdate = function (artist) {
        let confirmResult;
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
        artistsService.update(artist);
    }
}]);