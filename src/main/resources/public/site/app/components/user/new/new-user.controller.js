angular.module('labsi').controller('NewUserCtrl', ["UserService", "$state", function (userService, $state) {
    const self = this;

    self.add = function (newUser) {
        userService.add(newUser).then(function () {
            $state.go('home.login');
        }).catch(function (error) {
            console.log(error);
            self.responseError = 'Erro interno no servidor, por favor tente novamente mais tarde';
        });
    }
}]);