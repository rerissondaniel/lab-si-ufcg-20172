angular.module("labsi").controller("ShowArtistCtrl",
    ["$stateParams", "UserArtistsService", function ($stateParams, userArtistsService) {

        const self = this;

        const _artistName = $stateParams.name;

        userArtistsService.getByName(_artistName).then((response) => {
            self.userArtist = response.data;
            self.musics = [];
            self.userArtist.artist.albuns.forEach(elem => {
                elem.musics.forEach(music => self.musics.push(music));
            });
        }).catch(error => {
            console.log('mostrar erro');
        });

        self.updateUserArtist = function (userArtist) {
            userArtistsService.updateUserArtist(userArtist).then((response) => {
                console.log('mostrar sucesso');
            }).catch((error) => {
                //TODO mostrar o erro.
            });
        }
    }]);