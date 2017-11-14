angular.module('labsi').controller("ShowPlaylistCtrl", ["PlaylistsService", "$stateParams", 
    function(playlistService, $stateParams){
        var self = this;
        
        var playlistName = $stateParams.name;
        self.playlist = playlistService.getByName(playlistName);

        self.availableMusics = playlistService.getAvailableMusics(self.playlist);

        self.addToPlaylist = function(playlist, music){
            playlist.musics.push(music);
            playlistService.update(playlist);
            self.availableMusics = playlistService.getAvailableMusics(self.playlist);
        }

        self.removeFromPlaylist = function(playlist, musicToRemove){
            var confirmResult = confirm("Deseja realmente remover a música da playlist?");
            
            if(confirmResult){
                var idxToRemove = playlist.musics.findIndex(function(music){
                    return music.name === musicToRemove.name;
                });

                playlist.musics.splice(idxToRemove, 1);
                playlistService.update(playlist);
                self.availableMusics = playlistService.getAvailableMusics(self.playlist);
            }
        }
}]);