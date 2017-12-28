angular.module('labsi').controller('AddPlaylistCtrl', ['PlaylistsService', function (playlistsService) {
    const self = this;

    playlistsService.getPlaylists().then((response) => {
        self.playlists = response.data;
    }).catch(error => {
        console.log(error);
    });

    self.addPlaylist = function (playlist) {
        playlist.musics = [];
        playlistsService.addPlaylist(playlist).then(response => {
            self.playlists.push(response.data);
            _cleanPlaylistForm();
        }).catch(error => {
            console.log(error);
        });
    };

    self.removePlaylist = function (playlist) {
        const confirmResult = confirm('Deseja realmente remover a playlist?');

        if (confirmResult) {
            playlistsService.deletePlaylist(playlist).then(() => {
                const removedPlaylistIdx = self.playlists.indexOf(playlist);
                self.playlists.splice(removedPlaylistIdx, 1);
            }).catch(error => {
                console.log(error);
            });
        }
    };

    self.isNameAvailable = function (playlistName) {
        if(self.playlists){
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