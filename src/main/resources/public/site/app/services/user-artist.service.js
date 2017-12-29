angular.module("labsi").service("UserArtistsService", ["$http", "config", function ($http, config) {
    const self = this;

    const baseServiceUrl = config.baseUrl + "/user/artist";

    self.getAll = () => $http.get(`${baseServiceUrl}`);

    self.getByName = (name) => $http.get(`${baseServiceUrl}/${name}`);

    self.update = (userArtist) => $http.put(`${baseServiceUrl}`, userArtist);

}]);