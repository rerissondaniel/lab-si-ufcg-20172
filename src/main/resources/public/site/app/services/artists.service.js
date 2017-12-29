angular.module("labsi").service("ArtistsService", ["$http", "config", function ($http, config) {
    const self = this;

    const baseServiceUrl = `${config.baseUrl}/artist`;

    self.add = function (artist) {
        return $http.post(baseServiceUrl, artist);
    };

    self.update = function (artist) {
        return $http.put(baseServiceUrl, artist);
    };

    self.getArtists = function () {
        return $http.get(baseServiceUrl);
    };
}]);