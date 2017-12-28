angular.module('labsi').service('AlbumsService', ['$http', 'config', function ($http, config) {

    const self = this;
    const baseServiceUrl = `${config.baseUrl}/album`;

    self.addMusic = function (music, albumName) {
        return $http.put(`${baseServiceUrl}/${albumName}/add-music`, music);
    };
}]);