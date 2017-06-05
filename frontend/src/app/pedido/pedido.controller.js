class PedidoController {
  constructor(PedidoService, $stateParams, $mdDialog) {
    angular.extend(this, {
      PedidoService,
      $stateParams,
      $mdDialog
    });
  }

  $onInit() {
    this.buscarPedido();
  }

  buscarPedido() {
    this.PedidoService.porCodigo(this.$stateParams.codigo)
      .then(pedido => this.pedido = pedido)
      .then(() => this.buscarPassos());
  }

  buscarPassos() {
    return this.PedidoService.buscarPassos(this.pedido.codigo)
      .then(passos => this.passos = passos);
  }

  adicionarEntrada() {
    const self = this;
    this.$mdDialog.show({
      controllerAs: '$ctrl',
      /** @ngInject */
      controller: function($mdDialog) {
        this.pedidoCodigo = self.pedido.codigo;
        this.success = () => $mdDialog.hide();
        this.cancel = () => $mdDialog.cancel();
      },
      template: '<app-novo-passo-entrega codigo-pedido="$ctrl.pedidoCodigo" on-success="$ctrl.success()" on-cancel="$ctrl.cancel()"></app-novo-passo-entrega>'
    }).then(() => this.buscarPassos());
  }
}

angular.module('app').controller('PedidoController', PedidoController);
