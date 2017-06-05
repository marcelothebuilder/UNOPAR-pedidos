class PedidoService {
  constructor($http, $log) {
    angular.extend(this, {
      $http,
      $log
    });
  }

  porCodigo(codigo) {
    return this.$http.get(`/pedido/${codigo}`);
  }

  todos() {
    return this.$http.get('/pedido');
  }

  adicionar(pedido) {
    return this.$http.post('/pedido', pedido);
  }

  criar(pedido) {
    return this.adicionar(pedido);
  }

  adicionarPassoEntrega(codigoPedido, passo) {
    passo.pedidoCodigo = codigoPedido;
    return this.$http.post(`/pedido/${codigoPedido}/passo-entrega`, passo);
  }

  buscarPassos(codigoPedido) {
    return this.$http.get(`/pedido/${codigoPedido}/passo-entrega`);
  }
}

angular.module('app')
  .service('PedidoService', PedidoService);
