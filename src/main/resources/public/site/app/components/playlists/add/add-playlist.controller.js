angular.module('labsi').controller('AddPlaylistCtrl', ['PlaylistsService', function (playlistsService) {
    const self = this;

    playlistsService.getPlaylists().then((response) => {
        self.playlists = response.data;
    }).catch(() => {
        self.responseError = 'Erro na comunicação com o servidor';
    });

    self.addPlaylist = function (playlist) {
        playlist.musics = [];
        playlistsService.addPlaylist(playlist).then(response => {
            self.playlists.push(response.data);
            _cleanPlaylistForm();
        }).catch(() => {
            self.responseError = 'Erro na comunicação com o servidor';
        });
    };

    self.removePlaylist = function (playlist) {
        const confirmResult = confirm('Deseja realmente remover a playlist?');

        if (confirmResult) {
            playlistsService.deletePlaylist(playlist).then(() => {
                const removedPlaylistIdx = self.playlists.indexOf(playlist);
                self.playlists.splice(removedPlaylistIdx, 1);
            }).catch(() => {
                self.responseError = 'Erro na comunicação com o servidor';
            });
        }
    };

    self.isNameAvailable = function (playlistName) {
        if (self.playlists) {
            const playlistsWithName = self.playlists.find(function (playlist) {
                return playlist.name === playlistName;
            });

            return !playlistsWithName;
        }
    };

    function _cleanPlaylistForm() {
        self.playlist = {};
        //noinspection JSUnresolvedVariable
        self.playlistForm.$setPristine();
    }
}]);