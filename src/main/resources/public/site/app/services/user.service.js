angular.module('labsi').service('UserService', ['$http', 'config', function ($http, config) {
    const self = this;
    const baseServiceUrl = `${config.baseUrl}/user`;

    self.add = function (user) {
        return $http.post(baseServiceUrl, user);
    }
}]);