class CidadeService {
  constructor($http, $log) {
    angular.extend(this, {
      $http,
      $log
    });
  }

  todas() {
    return this.$http.get('/cidade')
      .then(response => response.data);
  }

  porEstado(estado) {
    return this.$http.get('/cidade', {
      params: {
        estado: estado.codigo
      }
    });
  }
}

angular.module('app')
  .service('CidadeService', CidadeService);
