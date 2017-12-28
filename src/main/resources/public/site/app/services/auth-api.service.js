angular.module('labsi').service('AuthService', ["$http", 'AuthTokenService', "config", function($http, authTokenService, config) {
    const self = this;

    const authUrl = `${config.baseUrl}/login`;

    self.login = (credentials) => {
        return new Promise((resolve, reject) => {
            $http.post(authUrl, credentials).then((result) => {
                authTokenService.setToken(result.headers('Authorization'));
                resolve(result);
            }).catch((error) => {
                console.log(error);
                reject(error);
            });
        })
    };
}]);