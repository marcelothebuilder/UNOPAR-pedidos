class NovoPedidoController {
  constructor(ClienteService, ProdutoService, PedidoService, $stateParams) {
    angular.extend(this, {
      ClienteService,
      ProdutoService,
      PedidoService
    });
    this.codigoCliente = $stateParams.cliente;
    this.novoItem = {};
    this.resetarPedido();
  }

  resetarPedido() {
    this.pedido = {
      itens: [],
      cliente: this.cliente
    };
  }

  $onInit() {
    this.buscarDadosCliente();
  }

  adicionarItem() {
    this.pedido.itens.push(this.novoItem);
    this.novoItem = {};
  }

  buscarDadosCliente() {
    this.ClienteService.porCodigo(this.codigoCliente)
      .then(cliente => {
        this.cliente = cliente;
        this.pedido.cliente = this.cliente;
      });
  }

  pesquisarProdutos(nome) {
    return this.ProdutoService.porNome(nome)
      .then(pagina => pagina.content);
  }

  criarPedido() {
    return this.PedidoService.criar(this.pedido)
      .then(() => {
        this.resetarPedido();
      });
  }
}

angular.module('app')
  .controller('NovoPedidoController', NovoPedidoController);
