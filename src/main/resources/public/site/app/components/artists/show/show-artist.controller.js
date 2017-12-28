angular.module("labsi").controller("ShowArtistCtrl",
    ["$stateParams", "UserArtistsService", "MusicsService", function ($stateParams, userArtistsService) {

        const self = this;

        const _artistName = $stateParams.name;

        userArtistsService.getByName(_artistName).then((response) => {
            self.userArtist = response.data;
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