angular.module("labsi").service("PlaylistsService", ["MusicsService", function (musicsService) {
    var self = this;
    var _playlists = [];

    self.addPlaylist = function(playlist){
        _playlists.push(playlist);
    };

    self.getPlaylists = function(){
        return angular.copy(_playlists);
    }

    self.deletePlaylist = function(playlistToBeDeleted){
        var idxToRemove = _playlists.findIndex(function(playlist){
            return playlistToBeDeleted.name === playlist.name;
        });

        _playlists.splice(idxToRemove, 1);
    }

    self.getAvailableMusics = function(playlist){
        return musicsService.getMusics().filter(function(music){
            return !_isInPlaylist(music, playlist);
        });
    }

    self.update = function(playlist){
        var idxToUpdate = _playlists.findIndex(function(elem){
            return elem.name === playlist.name;
        });
        _playlists[idxToUpdate] = playlist;
    }

    self.getByName = function(name){
        var playlistsWithName = _playlists.find(function (playlist) {
            return playlist.name === name;
        });

        if (playlistsWithName) {
            return angular.copy(playlistsWithName);
        }
    }

    function _isInPlaylist(music, playlist){
        return playlist.musics.find(function(musicInPlaylist){
            return musicInPlaylist.name === music.name;
        });
    }
}]);