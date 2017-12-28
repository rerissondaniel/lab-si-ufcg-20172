angular.module('labsi').service('PlaylistsService', ['$http', 'config', function ($http, config) {
    const self = this;

    const baseServiceUrl = `${config.baseUrl}/playlist`;

    self.addPlaylist = function (playlist) {
        return $http.post(baseServiceUrl, playlist);
    };

    self.getPlaylists = function () {
        return $http.get(baseServiceUrl);
    };

    self.deletePlaylist = function (playlistToBeDeleted) {
        return $http.delete(`${baseServiceUrl}/${playlistToBeDeleted.id}`);
    };

    self.getAvailableMusics = function (playlist) {
        return $http.get(`${baseServiceUrl}/${playlist.name}/available-musics`);
    };

    self.update = function (playlist) {
        return $http.post(`${baseServiceUrl}`, playlist);
    };

    self.getByName = function (name) {
        return $http.get(`${baseServiceUrl}/${name}`);
    };
}]);