angular.module('labsi').controller('MusicsCtrl', ['AlbumsService', 'ArtistsService', function (albumService, artistsService) {
    const self = this;

    artistsService.getArtists().then(response => {
        self.artists = response.data;
    });

    self.addMusic = function (music, albumName) {
        albumService.addMusic(music, albumName).then(() => {
            _resetMusicForm();
        }).catch(() => {
            console.log('Música não adicionada, mostrar msg');
        });
    };

    function _resetMusicForm() {
        self.music = {};
        self.albumName = null;
        //noinspection JSUnresolvedVariable
        self.musicForm.$setPristine();
    }
}]);