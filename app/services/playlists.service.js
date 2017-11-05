angular.module("labsi").service("PlaylistsService", [function () {
    var _playlists = [];

    this.addPlaylist = function(playlist){
        _playlists.push(playlist);
    };

    this.getPlaylists = function(){
        return angular.copy(_playlists);
    }
}]);