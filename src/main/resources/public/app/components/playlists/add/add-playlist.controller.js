angular.module("labsi").controller("AddPlaylistCtrl", ["PlaylistsService", function (playlistsService) {
    var self = this;

    self.playlists = playlistsService.getPlaylists();

    self.addPlaylist = function (playlist) {
        playlist.musics = [];
        playlistsService.addPlaylist(playlist);
        _cleanPlaylistForm();
        self.playlists = playlistsService.getPlaylists();
    }

    self.removePlaylist = function(playlist){
        var confirmResult = confirm("Deseja realmente remover a playlist?");
        
        if(confirmResult){
            playlistsService.deletePlaylist(playlist);
            self.playlists = playlistsService.getPlaylists();
        }
    }

    self.isNameAvailable = function(playlistName){
        var playlistsWithName = self.playlists.find(function(playlist){
            return playlist.name === playlistName;
        });

        return !playlistsWithName;
    }

    function _cleanPlaylistForm(){
        self.playlist = {};
        self.playlistForm.$setPristine();
    }
}]);