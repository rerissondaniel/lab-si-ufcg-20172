angular.module("labsi").controller("AddPlaylistCtrl", ["PlaylistsService", function (playlistsService) {
    var self = this;

    self.playlists = playlistsService.getPlaylists();

    self.addPlaylist = function (playlist) {
        playlist.musics = [];
        playlistsService.addPlaylist(playlist);
        self.playlists = playlistsService.getPlaylists();
    }
}]);