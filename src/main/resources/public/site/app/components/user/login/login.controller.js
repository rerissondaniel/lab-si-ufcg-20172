angular.module('labsi').controller('LoginCtrl', ['$state', 'AuthService', function($state, authService) {
    const self = this;

    self.login = (credentials) => {
        authService.login(credentials).then((result) => {
            $state.go('home');
        }).catch((error) => {
            //TODO mostrar mensagem de erro
        });
    }
}]);