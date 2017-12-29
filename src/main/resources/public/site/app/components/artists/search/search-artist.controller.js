angular.module("labsi").controller("SearchArtistCtrl", ["UserArtistsService", function (userArtistService) {
    const self = this;

    userArtistService.getAll().then(response => {
        self.userArtists = response.data;
    }).catch(() => {
        self.responseError = 'Erro na comunicação com o servidor';
    });

    self.confirmUpdate = function (userArtist) {
        let confirmResult;
        if (userArtist.artist.favorite) {
            confirmResult = confirm("Deseja realmente adicionar o artista aos favoritos?");
        } else {
            confirmResult = confirm("Deseja realmente remover o artista dos favoritos?");
        }

        if (confirmResult) {
            _updateArtist(userArtist);
        } else {
            userArtist.artist.favorite = !userArtist.artist.favorite;
        }
    };

    function _updateArtist(userArtist) {
        userArtistService.update(userArtist);
    }
}]);