class EstadoEntregaService {
  constructor($http, $log) {
    angular.extend(this, {
      $http,
      $log
    });
  }

  todos() {
    return this.$http.get('/estado-entrega');
  }
}

angular.module('app')
  .service('EstadoEntregaService', EstadoEntregaService);
