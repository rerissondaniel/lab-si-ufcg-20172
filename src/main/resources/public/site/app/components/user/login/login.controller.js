angular.module('labsi').controller('LoginCtrl', ['$state', 'AuthApiService', function($state, authService) {
    const self = this;

    self.errorMessage = {mustShow: false};

    self.login = (credentials) => {
        authService.login(credentials).then(() => {
            $state.go('home');
        }).catch(() => {
            self.responseError = 'Erro de autenticação, verifique os dados ou tente novamente mais tarde';
        });
    }
}]);