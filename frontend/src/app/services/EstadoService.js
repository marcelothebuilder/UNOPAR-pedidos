class EstadoService {
  constructor($http, $log) {
    angular.extend(this, {
      $http,
      $log
    });
  }

  todos() {
    return this.$http.get('/estado');
  }
}

angular.module('app')
  .service('EstadoService', EstadoService);
