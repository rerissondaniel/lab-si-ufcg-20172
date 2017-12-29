angular.module('labsi').controller('NewUserCtrl', ["UserService", "$state", function (userService, $state) {
    const self = this;

    self.add = function (newUser) {
        userService.add(newUser).then(function () {
            $state.go('home.login');
        }).catch(() => {
            self.responseError = 'Erro no cadastro, insira outro endereço de email ou tente novamente mais tarde';
        });
    }
}]);