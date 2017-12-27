angular.module("labsi").controller("AddArtistsCtrl", ["ArtistsService", function (artistsService) {
    const self = this;

    self.addArtist = function (artist) {
        artistsService.add(artist).then(() => {
            _cleanArtistForm();
        }).catch((error) => {
            //TODO apresentar mensagem de erro
        });
    };

    function _cleanArtistForm() {
        self.artist = {};
        //noinspection JSUnresolvedVariable
        self.artistForm.$setPristine();
    }
}]);