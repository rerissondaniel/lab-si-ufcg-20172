angular.module('labsi').controller("ShowPlaylistCtrl", ["PlaylistsService", "$stateParams",
    function (playlistService, $stateParams) {
        const self = this;

        const playlistName = $stateParams.name;
        playlistService.getByName(playlistName).then((response) => {
            self.playlist = response.data;
            getAvailableMusics(self.playlist);
        }).catch(() => {
            self.responseError = 'Erro na comunicação com o servidor';
        });

        function getAvailableMusics(playlist) {
            playlistService.getAvailableMusics(playlist).then((response) => {
                self.availableMusics = response.data;
            }).catch(() => {
                self.responseError = 'Erro na comunicação com o servidor';
            });
        }

        self.addToPlaylist = function (playlist, music) {
            playlist.musics.push(music);
            playlistService.update(playlist).then(() => {
                removeFromAvailables(music);
            }).catch(() => {
                playlist.musics.pop();
                self.responseError = 'Erro na comunicação com o servidor';
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
                    self.availableMusics.push(musicToRemove);
                }).catch(() => {
                    self.responseError = 'Erro na comunicação com o servidor';
                    self.playlist.musics.push(musicToRemove);
                });
            }
        }
    }]);