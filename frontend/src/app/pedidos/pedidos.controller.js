class PedidosController {
  constructor(PedidoService, $state) {
    angular.extend(this, {
      PedidoService,
      $state
    });
  }

  $onInit() {
    this.buscarPedidos();
  }

  buscarPedidos() {
    this.PedidoService.todos()
      .then(pedidos => this.pedidos = pedidos);
  }

  abrirPedido(pedido) {
    this.$state.go('pedido', {codigo: pedido.codigo});
  }
}

angular.module('app').controller('PedidosController', PedidosController);
