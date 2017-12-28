angular.module('labsi').controller("ShowPlaylistCtrl", ["PlaylistsService", "$stateParams",
    function (playlistService, $stateParams) {
        const self = this;

        const playlistName = $stateParams.name;
        playlistService.getByName(playlistName).then((response) => {
            self.playlist = response.data;
            getAvailableMusics(self.playlist);
        }).catch(error => {
            console.log(error);
        });

        function getAvailableMusics(playlist) {
            playlistService.getAvailableMusics(playlist).then((response) => {
                self.availableMusics = response.data;
            }).catch(error => {
                console.log(error);
            });
        }

        self.addToPlaylist = function (playlist, music) {
            playlist.musics.push(music);
            playlistService.update(playlist).then(() => {
                console.log('adicionou a musica');
                removeFromAvailables(music);
            }).catch((error) => {
                playlist.musics.pop();
                console.log(error);
            });
        };

        const removeFromAvailables = (music) => {
            const removeIdx = self.availableMusics.indexOf(music);
            self.availableMusics.splice(removeIdx, 1);
        };

        self.removeFromPlaylist = function (playlist, musicToRemove) {
            const confirmResult = confirm("Deseja realmente remover a música da playlist?");

            if (confirmResult) {
                const idxToRemove = playlist.musics.findIndex(function (music) {
                    return music.name === musicToRemove.name;
                });

                playlist.musics.splice(idxToRemove, 1);

                playlistService.update(playlist).then(() => {
                    console.log('removeu a música');
                    self.availableMusics.push(musicToRemove);
                }).catch((error) => {
                    console.log(error);
                    self.playlist.musics.push(musicToRemove);
                });
            }
        }
    }]);