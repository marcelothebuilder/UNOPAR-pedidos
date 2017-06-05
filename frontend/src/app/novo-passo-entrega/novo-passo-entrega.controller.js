class NovoPassoEntregaController {
  constructor(PedidoService, EstadoEntregaService) {
    angular.extend(this, {
      PedidoService,
      EstadoEntregaService
    });

    console.log(this);
  }

  buscarEstados() {
    this.EstadoEntregaService.todos()
      .then(estados => this.estadosEntrega = estados);
  }

  adicionar() {
    return this.PedidoService.adicionarPassoEntrega(this.codigoPedido, this.novoPasso)
      .then(() => this.onSuccess());
  }
}

angular.module('app')
  .controller('NovoPassoEntregaController', NovoPassoEntregaController);
