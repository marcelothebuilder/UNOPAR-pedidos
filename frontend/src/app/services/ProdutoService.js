class ProdutoService {
  constructor($http, $log) {
    angular.extend(this, {
      $http,
      $log
    });
  }

  todos() {
    return this.$http.get('/produto');
  }

  adicionar(produto) {
    return this.$http.post('/produto', produto);
  }

  porNome(nome, pagina = 0, tamanho = 10) {
    return this.$http.get('/produto', {
      params: {
        nome,
        page: pagina,
        size: tamanho
      }
    });
  }
}

angular.module('app')
  .service('ProdutoService', ProdutoService);
