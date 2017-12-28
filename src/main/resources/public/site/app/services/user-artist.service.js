angular.module("labsi").service("UserArtistsService", ["$http", "config", function ($http, config) {
    const self = this;

    const baseServiceUrl = config.baseUrl + "/user/artist";

    self.getByName = (name) => {
        return $http.get(`${baseServiceUrl}/${name}`);
    };

    self.updateUserArtist = (userArtist) => {
        return $http.put(`${baseServiceUrl}`, userArtist);
    }

}]);