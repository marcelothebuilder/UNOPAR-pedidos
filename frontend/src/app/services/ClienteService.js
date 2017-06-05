class ClienteService {
  constructor($http, $log) {
    angular.extend(this, {
      $http,
      $log
    });
  }

  porCodigo(codigo) {
    return this.$http.get(`/cliente/${codigo}`);
  }

  todos() {
    return this.$http.get('/cliente');
  }

  adicionar(cliente) {
    return this.$http.post('/cliente', cliente);
  }
}

angular.module('app')
  .service('ClienteService', ClienteService);
